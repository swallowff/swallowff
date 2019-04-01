package cn.swallow.platform.practice.base.annotation;

import java.lang.annotation.*;

/**
 * @author shenyu
 * @create 2019/3/30
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    String value();
    String name() default "yu.shen";
}
