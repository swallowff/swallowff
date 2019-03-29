package cn.swallow.platform.practice.lang.annotations;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author shenyu
 * @create 2019/3/29
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectBean {
    @AliasFor("name")
    String[] value() default {};

    @AliasFor("value")
    String[] name() default {};

    Autowire autowire() default Autowire.NO;

    String initMethod() default "";

    String destroyMethod() default "(inferred)";
}
