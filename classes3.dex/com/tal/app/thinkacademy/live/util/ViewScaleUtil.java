package com.tal.app.thinkacademy.live.util;

import android.view.View;
import android.view.ViewGroup;

public class ViewScaleUtil {
    public static void scaleKeepWidth(View view, ViewGroup.MarginLayoutParams marginLayoutParams, float f, int i, int i2) {
        marginLayoutParams.width = (int) (((float) marginLayoutParams.width) / f);
        marginLayoutParams.leftMargin = (int) (((float) marginLayoutParams.leftMargin) * f);
        marginLayoutParams.topMargin = (int) (((float) marginLayoutParams.topMargin) * f);
        view.setScaleX(f);
        view.setScaleY(f);
        view.setPivotX((float) i);
        view.setPivotY((float) i2);
    }

    public static void scaleKeepSize(View view, float f, ViewGroup.MarginLayoutParams marginLayoutParams) {
        int i = (int) (((float) marginLayoutParams.height) / f);
        int i2 = (int) (((float) marginLayoutParams.width) / f);
        int marginStart = ((marginLayoutParams.width - i2) / 2) + marginLayoutParams.getMarginStart();
        view.setScaleX(f);
        view.setScaleY(f);
        marginLayoutParams.height = i;
        marginLayoutParams.width = i2;
        marginLayoutParams.setMarginStart(marginStart);
        marginLayoutParams.topMargin = ((marginLayoutParams.height - i) / 2) + marginLayoutParams.topMargin;
        view.setLayoutParams(marginLayoutParams);
    }

    public static void scale(View view, float f, int i, int i2) {
        view.setScaleX(f);
        view.setScaleY(f);
        view.setPivotX((float) i);
        view.setPivotY((float) i2);
    }

    public static void scale(View view, float f) {
        view.setScaleX(f);
        view.setScaleY(f);
    }
}
