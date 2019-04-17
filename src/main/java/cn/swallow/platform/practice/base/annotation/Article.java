package cn.swallow.platform.practice.base.annotation;

/**
 * 使用SpringIoc
 * @author shenyu
 * @create 2019/3/30
 */

public class Article {
    @ParamValid(key = true)
    private String id;
    private String name;

    public Article() {
    }

    public Article(String id, String name) {
        this.id = id;
        this.name = name;
    }


}
