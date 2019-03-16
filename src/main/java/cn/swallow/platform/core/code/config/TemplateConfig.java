package cn.swallow.platform.core.code.config;

import cn.swallow.platform.core.beetl.util.BeetlUtil;
import org.beetl.core.Template;

import java.io.IOException;
import java.util.Map;

/**
 * @author shenyu
 * @create 2019/3/16
 */
public class TemplateConfig {
    private Map<GenFileType,String> tplNameMap;

    private String entity = "Entity.java.btl";
    private String dao = "Dao.java.btl";
    private String service = "service.java.btl";
    private String dto = "Dto.java.btl";
    private String controller = "Controller.java.btl";
    private String mapper = "Mapper.java.btl";

    public TemplateConfig(){
    }

    public Template getTemplate(GenFileType fileType) throws IOException {
        return BeetlUtil.getTemplate(tplNameMap.get(fileType),"/WEB-INF/view/admin/templates/gencode/","utf-8");
    }

    public Map<GenFileType, String> getTplNameMap() {
        return tplNameMap;
    }

    public void setTplNameMap(Map<GenFileType, String> tplNameMap) {
        this.tplNameMap = tplNameMap;
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

    public String getDto() {
        return dto;
    }

    public void setDto(String dto) {
        this.dto = dto;
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
}
