package com.yanzhenjie.andserver.annotation;

public @interface FormPart {
    String name() default "";

    boolean required() default true;

    String value() default "";
}
