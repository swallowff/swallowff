package cn.swallow.platform.core.code.generator;

import cn.swallow.platform.core.code.CodeGenConfig;
import cn.swallow.platform.core.code.entity.ColumnClass;
import cn.swallow.platform.core.util.JdbcUtil;
import org.apache.commons.lang3.StringUtils;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class BeetlCodeGenerator {
    private static BeetlCodeGenerator generator;
    private Connection connection = null;
    private String tableName;
    private String className;
    private String outPutPackage;

    private BeetlCodeGenerator(){}

    public static BeetlCodeGenerator me(){
        if (null != generator){
            generator = new BeetlCodeGenerator();
        }return generator;
    }

    public void init(String tableName,String className,String outPutPath) throws SQLException {
        connection = JdbcUtil.getConnection();
        this.tableName = tableName;
        this.className = replaceUnderLineAndUpperCase(className);
        this.outPutPackage = outPutPath;
    }

    public void assertConnection(){
        if (null == connection){
            throw new RuntimeException("BeetlCodeGenerator did not initialize");
        }
    }

    public ResultSet queryDataMeta(String tableName) throws SQLException{
        DatabaseMetaData metaData = connection.getMetaData();
        return metaData.getColumns(null,"%",tableName,"%");
    }

    public List<ColumnClass> wrapDataMeta(ResultSet resultSet) throws SQLException{
        List<ColumnClass> columns = new ArrayList<>();
        while (resultSet.next()){
            ColumnClass columnClass = new ColumnClass();
            //id字段略过
            if(resultSet.getString("COLUMN_NAME").equals("id")) continue;
            columnClass = new ColumnClass();
            //获取字段名称
            columnClass.setColumnName(resultSet.getString("COLUMN_NAME"));
            //获取字段类型
            columnClass.setColumnType(resultSet.getString("TYPE_NAME"));
            //转换字段名称，如 sys_name 变成 SysName
            columnClass.setChangeColumnName(replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME")));
            //字段在数据库的注释
            columnClass.setColumnComment(resultSet.getString("REMARKS"));
            columns.add(columnClass);
        }
        return columns;
    }

    public Map<String,Object> configTemplateData(List<ColumnClass> fieldList, String author, CodeGenConfig.CodeGenType type){
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("columns",fieldList);
        dataMap.put("className",className);
        dataMap.put("author",author);
        dataMap.put("date",new Date());
        dataMap.put("packageName",GeneratorUtil.getTargetPath(outPutPackage, type));
        return dataMap;
    }

    public void generate(){
        try {
            init("test_table","Article","cn.swallow.modular.manage.blog");
            ResultSet resultSet = queryDataMeta(tableName);
            List<ColumnClass> columnClassList = wrapDataMeta(resultSet);

            Map<String,Object> dataMap = configTemplateData(columnClassList,"shenyu", CodeGenConfig.CodeGenType.Entity);
            Template template = getTemplate("Entity.btl");
            template.binding(dataMap);
            File targetFile = new File(outPutPackage+File.separator+className+".java");
            FileOutputStream fos = new FileOutputStream(targetFile);
            OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName("utf-8"));
            template.renderTo(new BufferedWriter(osw,10240));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            destroy();
        }

    }

    public Template getTemplate(String templateName) throws IOException {
        FileResourceLoader fileResourceLoader = new FileResourceLoader("/WEB-INF/view/admin/templates/gencode/","utf-8");
        Configuration configuration = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(fileResourceLoader,configuration);
        Template t = gt.getTemplate(templateName);
        return t;
    }

    public static String replaceUnderLineAndUpperCase(String str){
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while(count!=0){
            int num = sb.indexOf("_",count);
            count = num + 1;
            if(num != -1){
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count , count + 1,ia + "");
            }
        }
        String result = sb.toString().replaceAll("_","");
        return StringUtils.capitalize(result);
    }

    public void destroy(){

    }
}
