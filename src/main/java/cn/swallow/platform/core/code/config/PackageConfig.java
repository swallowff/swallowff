package cn.swallow.platform.core.code.config;

import java.util.Map;

/**
 * @author shenyu
 * @create 2019/3/16
 */
public class PackageConfig {
    private String defaultPackage = "cn.swallow.platform.modular";  //默认包
    private String moduleName;                                      //模块名称
    private Map<GenFileType,String> filePackage;                    //保存不同文件对应的包名信息

    private String entity = "entity";
    private String dao = "dao";
    private String service = "service";
    private String controller = "controller";
    private String mapper = "";
    private String dto = "dto";

    public PackageConfig(){
    }

    public String getDefaultPackage() {
        return defaultPackage;
    }

    public void setDefaultPackage(String defaultPackage) {
        this.defaultPackage = defaultPackage;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getDao() {
        return dao;
    }

    public void setDao(String dao) {
        this.dao = dao;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getMapper() {
        return mapper;
    }

    public void setMapper(String mapper) {
        this.mapper = mapper;
    }

    public String getDto() {
        return dto;
    }

    public void setDto(String dto) {
        this.dto = dto;
    }

    public Map<GenFileType, String> getFilePackage() {
        return filePackage;
    }

    public void setFilePackage(Map<GenFileType, String> filePackage) {
        this.filePackage = filePackage;
    }

    public String fetchFilePackageByType(GenFileType fileType){
        return filePackage.get(fileType);
    }
}
