package com.tal.app.thinkacademy.lib.commui.baseview.popupwindow;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface HorizontalGravity {
    public static final int ALIGN_LEFT = 3;
    public static final int ALIGN_RIGHT = 4;
    public static final int CENTER = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
}
