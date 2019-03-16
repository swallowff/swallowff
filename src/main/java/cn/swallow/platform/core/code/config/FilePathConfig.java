package cn.swallow.platform.core.code.config;

import java.io.File;
import java.util.Map;

/**
 * @author shenyu
 * @create 2019/3/16
 */
public class FilePathConfig {
    private String projectPath = new File("").getAbsolutePath();
    private Map<GenFileType,File> fileMap;
    private String javaSuffix = ".java";
    private String htmlSuffix = ".html";
    private String xmlSuffix = ".xml";

    public FilePathConfig(){
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public Map<GenFileType, File> getFileMap() {
        return fileMap;
    }

    public void setFileMap(Map<GenFileType, File> fileMap) {
        this.fileMap = fileMap;
    }

    public String getJavaSuffix() {
        return javaSuffix;
    }

    public void setJavaSuffix(String javaSuffix) {
        this.javaSuffix = javaSuffix;
    }

    public String getHtmlSuffix() {
        return htmlSuffix;
    }

    public void setHtmlSuffix(String htmlSuffix) {
        this.htmlSuffix = htmlSuffix;
    }

    public String getXmlSuffix() {
        return xmlSuffix;
    }

    public void setXmlSuffix(String xmlSuffix) {
        this.xmlSuffix = xmlSuffix;
    }

    public File fetchTargetFileByType(GenFileType fileType){
        return fileMap.get(fileType);
    }
}
