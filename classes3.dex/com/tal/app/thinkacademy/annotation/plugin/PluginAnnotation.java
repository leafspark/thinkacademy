package com.tal.app.thinkacademy.annotation.plugin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PluginAnnotation {
    int classType() default 10086;

    String desc() default "";

    int deviceType() default 10086;

    boolean invalid() default false;

    String[] ircType() default {};

    String launchType() default "delay";

    int liveType() default 0;

    String[] metaDataKey() default {};

    String moduleId();

    String[] noActiveKey() default {};
}
