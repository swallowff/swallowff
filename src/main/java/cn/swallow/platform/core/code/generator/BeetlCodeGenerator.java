package cn.swallow.platform.core.code.generator;

import cn.swallow.platform.core.code.config.*;
import cn.swallow.platform.core.code.entity.ColumnClass;
import cn.swallow.platform.core.util.StreamUtil;
import cn.swallow.platform.core.util.StringUtil;
import org.beetl.core.Template;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author shenyu
 * @create 2019/3/16
 */
public class BeetlCodeGenerator {
    private GlobalConfig globalConfig;
    private PackageConfig packageConfig;
    private TemplateConfig templateConfig;
    private FilePathConfig filePathConfig;

    public BeetlCodeGenerator(GlobalConfig globalConfig, PackageConfig packageConfig, TemplateConfig templateConfig, FilePathConfig filePathConfig){
        this.globalConfig = globalConfig;
        this.packageConfig = packageConfig;
        this.templateConfig = templateConfig;
        this.filePathConfig = filePathConfig;
    }

    private ResultSet queryMetaData() throws SQLException {
        DatabaseMetaData metaData = globalConfig.getConnection().getMetaData();
        return metaData.getColumns(null,"%",globalConfig.getTableName(),"%");
    }

    private List<ColumnClass> wrapDataMeta(ResultSet resultSet) throws SQLException{
        List<ColumnClass> columnClassList = new ArrayList<ColumnClass>();
        while (resultSet.next()){
            ColumnClass columnClass = new ColumnClass();
            String columnName = resultSet.getString("COLUMN_NAME");
            //id字段略过
            if(columnName.equals("id")) continue;
            columnClass = new ColumnClass();
            //获取字段名称
            columnClass.setColumnName(resultSet.getString("COLUMN_NAME"));
            //获取字段类型
            columnClass.setColumnType(resultSet.getString("TYPE_NAME"));
            //转换字段名称，如 sys_name 变成 SysName
            columnClass.setFirstUppercase(StringUtil.replaceUnderLineAndUpperCase(columnName));
            //字段在数据库的注释
            columnClass.setColumnComment(resultSet.getString("REMARKS"));
            columnClassList.add(columnClass);
        }
        return columnClassList;
    }

    private Map<String,Object> wrapToTemplateData(List<ColumnClass> columnClasses,GenFileType fileType){
        Map<String,Object> dataMap = new HashMap<String,Object>();
        dataMap.put("items",columnClasses);
        dataMap.put("className",globalConfig.getClassName());
        dataMap.put("author",globalConfig.getAuthor());
        dataMap.put("date",new Date());
        dataMap.put("packageName",packageConfig.fetchFilePackageByType(fileType));
        return dataMap;
    }



    public void doGenerate() {
        try {
            //1 获取数据
            ResultSet resultSet = queryMetaData();
            List<ColumnClass> columnClasses = wrapDataMeta(resultSet);
            Map<String,Object> dataMap = null;
            //2 封装数据(生成不同文件时封装的数据不同)
            if (globalConfig.isGenEntity()){
                dataMap = wrapToTemplateData(columnClasses,GenFileType.Entity);
                genEntityFile(dataMap);
            }
            if (globalConfig.isGenDao()){
                dataMap = wrapToTemplateData(columnClasses,GenFileType.Dao);
                genDaoFile(dataMap);
            }
            if (globalConfig.isGenService()){
                dataMap = wrapToTemplateData(columnClasses,GenFileType.Service);
                genServiceFile(dataMap);
            }
            if (globalConfig.isGenController()){
                dataMap = wrapToTemplateData(columnClasses,GenFileType.Controller);
                genControllerFile(dataMap);
            }
            if (globalConfig.isGenDto()){
                dataMap = wrapToTemplateData(columnClasses,GenFileType.Dto);
                genDtoFile(dataMap);
            }
            if (globalConfig.isGenMapper()){
                dataMap = wrapToTemplateData(columnClasses,GenFileType.Mapper);
                genMapperFile(dataMap);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void outPutFile(Map<String,Object> dataMap,GenFileType fileType){
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            fos = new FileOutputStream(filePathConfig.fetchTargetFileByType(fileType));
            osw = new OutputStreamWriter(fos,Charset.forName("utf-8"));
            bw = new BufferedWriter(osw,10240);
            //3 获取模板
            Template template = templateConfig.getTemplate(fileType);
            //4 数据绑定模板
            template.binding(dataMap);
            //5 文件输出
            template.renderTo(bw);
        } catch (FileNotFoundException e1){

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            StreamUtil.close(fos,osw,bw);
        }
    }

    private void genEntityFile(Map<String,Object> dataMap) {
        outPutFile(dataMap,GenFileType.Entity);
    }

    public void genDaoFile(Map<String,Object> dataMap){
        outPutFile(dataMap,GenFileType.Dao);
    }

    public void genServiceFile(Map<String,Object> dataMap){
        outPutFile(dataMap,GenFileType.Service);
    }

    public void genControllerFile(Map<String,Object> dataMap){
        outPutFile(dataMap,GenFileType.Controller);
    }

    public void genDtoFile(Map<String,Object> dataMap){
        outPutFile(dataMap,GenFileType.Dto);
    }

    public void genMapperFile(Map<String,Object> dataMap){
        outPutFile(dataMap,GenFileType.Mapper);
    }


}
