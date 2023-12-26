package com.bonree.sdk.agent.engine.external;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassRewriter {
    boolean activity() default true;

    boolean click() default true;

    boolean isHap() default false;

    String version() default "Null";

    boolean webview() default true;
}
