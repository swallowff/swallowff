package cn.swallow.platform.practice.base.annotation;

import cn.swallow.platform.core.util.context.SpringContextHolder;

import java.util.Map;

/**
 * @author shenyu
 * @create 2019/3/30
 */

public class AnnotationProcess {

    /**
     * 使用ApplicationContext获取自定义注解的Bean
     */
    public static void test(){
        Map<String,Object> targetBeans = SpringContextHolder.getApplicationContext().getBeansWithAnnotation(Author.class);
        return;
    }

    /**
     * 通过传入的对象获取注解并进行处理
     * @param object
     */
    public static void validateObject(Object object){

    }


}
