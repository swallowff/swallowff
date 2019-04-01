package cn.swallow.platform.practice.base.annotation;

/**
 * @author shenyu
 * @create 2019/3/30
 */
public class ArticleCtrl {

    public Object save(Article article){
        AnnotationProcess.validateObject(article);
        return null;
    }


}
