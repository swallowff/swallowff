package cn.swallow.platform.core.code.generator;

public enum  GenFileType {
    Mapper(""),
    Dao("dao"),
    Service("service"),
    Controller("controller"),
    Entity("entity"),
    Dto("dto"),
    ListHtml(""),
    AddHtml(""),
    DetailHtml("");

    GenFileType(String packageName) {
        this.packageName = packageName;
    }

    private String packageName;
}
