package com.tal.app.thinkacademy.lib.commui.widget.bar;

import android.graphics.drawable.Drawable;

public interface ITitleBarStyle {
    Drawable getBackIcon();

    Drawable getBackground();

    int getChildPadding();

    int getDrawablePadding();

    Drawable getLeftBackground();

    int getLeftColor();

    float getLeftSize();

    Drawable getLineDrawable();

    int getLineSize();

    Drawable getRightBackground();

    int getRightColor();

    float getRightSize();

    int getTitleBarHeight();

    int getTitleColor();

    int getTitleGravity();

    float getTitleSize();

    boolean isLineVisible();
}
