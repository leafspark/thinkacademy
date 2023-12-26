package com.tal.app.thinkacademy.lib.commui.listener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface TagTextStyle {
    public static final int bold = 1;
    public static final int bold_italic = 3;
    public static final int italic = 2;
    public static final int normal = 0;

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TagTextStyles {
    }
}
