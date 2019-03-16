package cn.swallow.platform.core.code.config;

import java.io.File;
import java.sql.Connection;
import java.util.Date;

/**
 * @author shenyu
 * @create 2019/3/16
 */
public class GlobalConfig {
    private String projectDir = new File("").getAbsolutePath();
    private boolean fileOverride = false;
    private String author;
    private Connection connection;
    private String tableName;
    private String className;
    private Date date;


    private boolean genMapper;
    private boolean genEntity;
    private boolean genDao;
    private boolean genService;
    private boolean genController;
    private boolean genDto;


    public GlobalConfig(){

    }

    public String getProjectDir() {
        return projectDir;
    }

    public void setProjectDir(String projectDir) {
        this.projectDir = projectDir;
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
}
