package cn.swallow.platform.core.code;

import cn.swallow.platform.Application;
import cn.swallow.platform.core.beetl.util.BeetlUtil;
import cn.swallow.platform.core.code.config.*;
import cn.swallow.platform.core.code.generator.GenerateUtil;
import cn.swallow.platform.core.util.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.beetl.core.Template;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.Map;

/**
 * @author shenyu
 * @create 2019/3/17
 */
public class GeneratorConfigManager {
    private GlobalConfig globalConfig;
    private PackageConfig packageConfig;
    private TemplateConfig templateConfig;
    private FilePathConfig filePathConfig;


    private boolean fileOverride = false;
    private String author;
    private Connection connection;
    private String tableName;
    private String className;
    private String moudle;
    private Date date;

    private static String basePackage = Application.class.getPackage().getName();
    private String defaltClassPackage = basePackage + ".system";
    private Map<GenFileType,String> classPackageMap;

    private boolean genMapper;
    private boolean genEntity;
    private boolean genDao;
    private boolean genService;
    private boolean genController;
    private boolean genDto;

    private Map<GenFileType,String> targetFilePathMap;
    private static String projectPath = new File("").getAbsolutePath();
    private static String rootPath = File.separator + "src" + File.separator + "main" + File.separator + "java";
    private String defaultTargetFilePath;

    private static String templateFilePath = "/WEB-INF/view/admin/templates/gencode/";

    public GeneratorConfigManager(GlobalConfig globalConfig, PackageConfig packageConfig, TemplateConfig templateConfig, FilePathConfig filePathConfig) {
        this.globalConfig = globalConfig;
        this.packageConfig = packageConfig;
        this.templateConfig = templateConfig;
        this.filePathConfig = filePathConfig;
    }

    public boolean isFileOverride() {
        return fileOverride;
    }

    public void setFileOverride(boolean fileOverride) {
        this.fileOverride = fileOverride;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getMoudle() {
        return moudle;
    }

    public void setMoudle(String moudle) {
        this.moudle = moudle;
    }

    public String getDefaltClassPackage() {
        return defaltClassPackage;
    }

    public void setDefaltClassPackage(String defaltClassPackage) {
        this.defaltClassPackage = defaltClassPackage;
    }

    public Map<GenFileType, String> getClassPackageMap() {
        return classPackageMap;
    }

    public void setClassPackageMap(Map<GenFileType, String> classPackageMap) {
        this.classPackageMap = classPackageMap;
    }

    public boolean isGenMapper() {
        return genMapper;
    }

    public void setGenMapper(boolean genMapper) {
        this.genMapper = genMapper;
    }

    public boolean isGenEntity() {
        return genEntity;
    }

    public void setGenEntity(boolean genEntity) {
        this.genEntity = genEntity;
    }

    public boolean isGenDao() {
        return genDao;
    }

    public void setGenDao(boolean genDao) {
        this.genDao = genDao;
    }

    public boolean isGenService() {
        return genService;
    }

    public void setGenService(boolean genService) {
        this.genService = genService;
    }

    public boolean isGenController() {
        return genController;
    }

    public void setGenController(boolean genController) {
        this.genController = genController;
    }

    public boolean isGenDto() {
        return genDto;
    }

    public void setGenDto(boolean genDto) {
        this.genDto = genDto;
    }

    public Map<GenFileType, String> getTargetFilePathMap() {
        return targetFilePathMap;
    }

    public void setTargetFilePathMap(Map<GenFileType, String> targetFilePathMap) {
        this.targetFilePathMap = targetFilePathMap;
    }

    public String getDefaultTargetFilePath(){
        if (StringUtils.isBlank(defaultTargetFilePath)){
            defaultTargetFilePath = projectPath + File.separator + rootPath + File.separator + GenerateUtil.convertPackageToPath(basePackage);
        }
        return  defaultTargetFilePath;

    }

    public String fetchFilePackageByType(GenFileType fileType) {
        if (null != classPackageMap && classPackageMap.size() != 0){
            String classPackage = classPackageMap.get(fileType);
            return StringUtils.isEmpty(classPackage) ? defaltClassPackage : classPackage;
        }else {
            return defaltClassPackage;
        }

    }

    public File fetchTargetFileByType(GenFileType fileType){
        if (null != targetFilePathMap && targetFilePathMap.size() != 0){
            return new File(targetFilePathMap.get(fileType));
        }else {
            return new File(getDefaultTargetFilePath());
        }
    }

    public Template getTemplate(GenFileType fileType) throws IOException {
        return BeetlUtil.getTemplate(fileType.name(),templateFilePath,"utf-8");
    }


}
