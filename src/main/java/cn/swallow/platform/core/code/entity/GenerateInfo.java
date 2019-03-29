package cn.swallow.platform.core.code.entity;

/**
 * @author shenyu
 * @create 2019/3/16
 */
public class GenerateInfo {
    private String table;       //表名称
    private String className;   //生成的类名
    private String module = "system";       //模块名
    private String author = "yu.shen";      //作者

    private boolean fileOverride = false;
    private boolean genEntity = false;
    private boolean genDao = false;
    private boolean genService = false;
    private boolean genController = false;
    private boolean genDto = false;
    private boolean genListPage = false;
    private boolean genDetailPage = false;
    private boolean genInsertPage = false;
    private boolean genUpdatePage = false;
    private boolean genMapper = false;


    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isFileOverride() {
        return fileOverride;
    }

    public void setFileOverride(boolean fileOverride) {
        this.fileOverride = fileOverride;
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

    public boolean isGenListPage() {
        return genListPage;
    }

    public void setGenListPage(boolean genListPage) {
        this.genListPage = genListPage;
    }

    public boolean isGenDetailPage() {
        return genDetailPage;
    }

    public void setGenDetailPage(boolean genDetailPage) {
        this.genDetailPage = genDetailPage;
    }

    public boolean isGenInsertPage() {
        return genInsertPage;
    }

    public void setGenInsertPage(boolean genInsertPage) {
        this.genInsertPage = genInsertPage;
    }

    public boolean isGenUpdatePage() {
        return genUpdatePage;
    }

    public void setGenUpdatePage(boolean genUpdatePage) {
        this.genUpdatePage = genUpdatePage;
    }

    public boolean isGenMapper() {
        return genMapper;
    }

    public void setGenMapper(boolean genMapper) {
        this.genMapper = genMapper;
    }
}
