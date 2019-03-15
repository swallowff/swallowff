package cn.swallow.platform.core.common.annotation;

import java.lang.annotation.*;

@Deprecated
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BusinessLog {
    String value()default "";
}
