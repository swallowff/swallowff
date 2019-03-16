package cn.swallow.platform.core.code.builder;

import cn.swallow.platform.core.code.config.*;
import cn.swallow.platform.core.code.entity.GenerateInfo;
import cn.swallow.platform.core.code.generator.GenerateUtil;
import cn.swallow.platform.core.util.JdbcUtil;
import cn.swallow.platform.core.util.StringUtil;

import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author shenyu
 * @create 2019/3/16
 */
public class ConfigBuilder {
    private GenerateInfo generateInfo;
    private GlobalConfig globalConfig;
    private PackageConfig packageConfig;
    private TemplateConfig templateConfig;
    private FilePathConfig filePathConfig;



    public ConfigBuilder(GenerateInfo generateInfo) {
        this.generateInfo = generateInfo;
    }

    public GlobalConfig buildGlobalConfig() throws SQLException {
        globalConfig = new GlobalConfig();
        globalConfig.setTableName(generateInfo.getTable());
        globalConfig.setAuthor(generateInfo.getAuthor());
        globalConfig.setClassName(generateInfo.getClassName() == null ? StringUtil.replaceUnderLineAndUpperCase(generateInfo.getTable()) : generateInfo.getClassName());
        globalConfig.setDate(new Date());
        globalConfig.setFileOverride(generateInfo.isFileOverride());
        globalConfig.setConnection(JdbcUtil.getConnection());
        globalConfig.setGenController(generateInfo.isGenController());
        globalConfig.setGenDao(generateInfo.isGenDao());
        globalConfig.setGenDto(generateInfo.isGenDto());
        globalConfig.setGenEntity(generateInfo.isGenEntity());
        globalConfig.setGenService(generateInfo.isGenService());
        globalConfig.setGenMapper(generateInfo.isGenMapper());
        return globalConfig;
    }

    public PackageConfig buildPackageConfig(){
        packageConfig = new PackageConfig();
        packageConfig.setModuleName(generateInfo.getModule());
        packageConfig.setFilePackage(handlePackageConfig(packageConfig));
        return packageConfig;
    }

    public TemplateConfig buildTemplateConfig(){
        templateConfig = new TemplateConfig();
        templateConfig.setTplNameMap(handleTemplateConfig(templateConfig));
        return templateConfig;
    }

    public FilePathConfig buildFilePathConfig(){
        filePathConfig = new FilePathConfig();
        filePathConfig.setFileMap(handleFilePathConfig(filePathConfig));
        return filePathConfig;
    }

    private Map<GenFileType,String> handlePackageConfig(PackageConfig packageConfig) {
        Map<GenFileType,String> filePackage = new HashMap<GenFileType, String>();
        filePackage.put(GenFileType.Entity,packageConfig.getDefaultPackage()+"."+packageConfig.getModuleName()+"."+packageConfig.getEntity());
        filePackage.put(GenFileType.Dao,packageConfig.getDefaultPackage()+"."+packageConfig.getModuleName()+"."+packageConfig.getDao());
        filePackage.put(GenFileType.Service,packageConfig.getDefaultPackage()+"."+packageConfig.getModuleName()+"."+packageConfig.getService());
        filePackage.put(GenFileType.Controller,packageConfig.getDefaultPackage()+"."+packageConfig.getModuleName()+"."+packageConfig.getController());
        filePackage.put(GenFileType.Dto,packageConfig.getDefaultPackage()+"."+packageConfig.getModuleName()+"."+packageConfig.getDto());
        filePackage.put(GenFileType.Mapper,"resources.mapper."+packageConfig.getModuleName()+"."+packageConfig.getMapper());
        return filePackage;
    }

    private Map<GenFileType,String> handleTemplateConfig(TemplateConfig templateConfig){
        Map<GenFileType,String> tplNameMap = new HashMap<GenFileType, String>();
        tplNameMap.put(GenFileType.Entity,templateConfig.getEntity());
        tplNameMap.put(GenFileType.Dao,templateConfig.getDao());
        tplNameMap.put(GenFileType.Service,templateConfig.getService());
        tplNameMap.put(GenFileType.Controller,templateConfig.getController());
        tplNameMap.put(GenFileType.Dto,templateConfig.getDto());
        tplNameMap.put(GenFileType.Mapper,templateConfig.getMapper());
        return tplNameMap;
    }

    private Map<GenFileType,File> handleFilePathConfig(FilePathConfig filePathConfig){
        Map<GenFileType,File> fileMap = new HashMap<GenFileType, File>();
        String projectPath = filePathConfig.getProjectPath();
        String src = "src";
        String main = "main";
        String java = "java";
        String temp = File.separator + src + File.separator + main + File.separator + java;
        if (null == packageConfig || null == globalConfig){
            throw new RuntimeException("code generator config initialized wrong");
        }
        Map<GenFileType,String> packageMap = packageConfig.getFilePackage();
        fileMap.put(GenFileType.Entity,new File(projectPath.concat(temp).concat(GenerateUtil.convertPackageToPath(packageMap.get(GenFileType.Entity))).concat(globalConfig.getClassName()).concat(filePathConfig.getJavaSuffix())));
        fileMap.put(GenFileType.Dao,new File(projectPath.concat(temp) + GenerateUtil.convertPackageToPath(packageMap.get(GenFileType.Dao)) + globalConfig.getClassName() + "Dao" + filePathConfig.getJavaSuffix()));
        fileMap.put(GenFileType.Service,new File(projectPath + temp + GenerateUtil.convertPackageToPath(packageMap.get(GenFileType.Service)) + globalConfig.getClassName() + "Service" + filePathConfig.getJavaSuffix()));
        fileMap.put(GenFileType.Controller,new File(projectPath + temp + GenerateUtil.convertPackageToPath(packageMap.get(GenFileType.Controller)) + globalConfig.getClassName() + "Controller" + filePathConfig.getJavaSuffix()));
        fileMap.put(GenFileType.Dto,new File(projectPath + temp + GenerateUtil.convertPackageToPath(packageMap.get(GenFileType.Dto)) + globalConfig.getClassName() + "Dto" + filePathConfig.getJavaSuffix()));
        fileMap.put(GenFileType.Mapper,new File(projectPath + src + main + GenerateUtil.convertPackageToPath(packageMap.get(GenFileType.Mapper)) + globalConfig.getClassName() + "Dto" + filePathConfig.getJavaSuffix()));
        return fileMap;
    }

}
