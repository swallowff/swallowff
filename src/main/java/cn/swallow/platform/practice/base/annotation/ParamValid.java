package cn.swallow.platform.practice.base.annotation;

import java.lang.annotation.*;

/**
 * @author shenyu
 * @create 2019/3/30
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Documented
public @interface ParamValid {
    boolean key() default false;
}