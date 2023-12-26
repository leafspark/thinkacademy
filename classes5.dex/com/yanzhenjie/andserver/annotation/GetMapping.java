package com.yanzhenjie.andserver.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface GetMapping {
    String[] consumes() default {};

    String[] headers() default {};

    String[] params() default {};

    String[] path() default {};

    String[] produces() default {};

    String[] value() default {};
}
