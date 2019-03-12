package cn.swallow.platform.core.code.generator;

import cn.hutool.core.io.FileUtil;
import cn.swallow.platform.SwallowffApplication;
import cn.swallow.platform.core.code.entity.ColumnClass;
import cn.swallow.platform.core.util.CommonUtil;
import cn.swallow.platform.core.util.JdbcUtil;
import cn.swallow.platform.core.util.SpringContextHolder;
import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.alibaba.druid.sql.dialect.db2.ast.DB2Object.Constants.CURRENT_DATE;
import static javafx.css.StyleOrigin.AUTHOR;

/**
 * @author shenyu
 * @create 2019/3/12
 */
@Component
public class CodeGenerator {
    private String tableName;
    private String className;
    private static final String JAVA_SUFFIX = ".java";
    private String projectPath = new File("").getAbsolutePath();
    private String tplBasePath = this.getClass().getResource("/WEB-INF/view/templates/gencode/").getPath();
    private String basePackage = SwallowffApplication.class.getPackage().getName();

    private enum TplFile{
        MAPPER("Mapper.ftl"),DAO("Dao.ftl"),Service("Service.ftl"),Controller("Controller.ftl"),Entity("Entity.ftl"),Dto("Dto.ftl");

        private String name;

        TplFile(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    private CodeGenerator() {
    }

    public CodeGenerator(String tableName){
        this.tableName = tableName;
        className = replaceUnderLineAndUpperCase(tableName);
    }

    private Connection getConnection() throws SQLException{
        return JdbcUtil.getConnection();
    }

//    private boolean executeTestSql() throws SQLException{
//        Connection connection = getConnection();
//        try {
//            connection.prepareStatement("");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void generate(String targetPackage) throws Exception{
        Connection connection = getConnection();
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet resultSet = databaseMetaData.getColumns(null,"%",tableName,"%");

        //生成Mapper文件
        generateMapperFile(resultSet);
        //生成Dao文件
        generateRepositoryFile(resultSet);
        //生成service文件
        generateServiceFile(resultSet);
        //生成controller文件
        generateControllerFile(resultSet);
        //生成entity文件
        generateEntityFile(resultSet,targetPackage);
        //生成dto文件
        generateDtoFile(resultSet);

        //TODO 生成前端文件


    }

    private void generateMapperFile(ResultSet resultSet){
    }

    private void generateRepositoryFile(ResultSet resultSet){
    }

    private void generateServiceFile(ResultSet resultSet){
    }

    private void generateControllerFile(ResultSet resultSet){
    }

    private void generateDtoFile(ResultSet resultSet){
    }

    private void generateEntityFile(ResultSet resultSet,String targetPackage) throws Exception{
        final String targetPath = projectPath + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + CommonUtil.packageToPath(basePackage + "." + targetPackage) + File.separator + className + JAVA_SUFFIX;
        File targetFile = new File(targetPath);
        List<ColumnClass> columnClassList = new ArrayList<>();
        ColumnClass columnClass = null;
        while(resultSet.next()){
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
            columnClassList.add(columnClass);
        }
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("entity_column",columnClassList);
        generateFileByTemplate(TplFile.Entity,targetFile,targetPackage,dataMap);
    }

    private void generateFileByTemplate(TplFile tplFile,File file,String targetPackage,Map<String,Object> dataMap) throws Exception{
        Template template = FreeMarkerTemplateUtil.getTemplate(tplFile.getName());
        if (!file.exists()){
            System.out.println("文件不存在");
        }

        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("table_name_small",tableName);
        dataMap.put("class_name",className);
        dataMap.put("author",AUTHOR);
        dataMap.put("date",CURRENT_DATE);
        dataMap.put("package_name",basePackage+targetPackage);
        dataMap.put("table_annotation","表的备注");
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
        template.process(dataMap,out);
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


    public static CodeGenerator me(){
        return SpringContextHolder.getBean(CodeGenerator.class);
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
