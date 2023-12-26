package com.tal.app.thinkacademy.lib.commui.baseview.popupwindow;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface VerticalGravity {
    public static final int ABOVE = 1;
    public static final int ALIGN_BOTTOM = 4;
    public static final int ALIGN_TOP = 3;
    public static final int BELOW = 2;
    public static final int CENTER = 0;
}
