package cn.swallow.platform.practice.base.annotation;

/**
 * @author shenyu
 * @create 2019/3/30
 */

public class ArticleService {

    public Article get(String id){
        return new Article(id,"Article"+id);
    }


}
