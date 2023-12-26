package com.tal.app.thinkacademy.common.util;

import android.graphics.drawable.GradientDrawable;

public class ShapeUtil {
    public static GradientDrawable createRectangleDrawable(int i, int i2, int i3, float f) {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(i);
            gradientDrawable.setStroke(i3, i2);
            gradientDrawable.setCornerRadius(f);
            return gradientDrawable;
        } catch (Exception unused) {
            return new GradientDrawable();
        }
    }

    public static GradientDrawable createRectangleDrawable(int i, int i2, int i3, float[] fArr) {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(i);
            gradientDrawable.setStroke(i3, i2);
            if (fArr != null && fArr.length == 4) {
                gradientDrawable.setCornerRadii(new float[]{fArr[0], fArr[0], fArr[1], fArr[1], fArr[2], fArr[2], fArr[3], fArr[3]});
            }
            return gradientDrawable;
        } catch (Exception unused) {
            return new GradientDrawable();
        }
    }

    public static GradientDrawable createRounderDrawable(int i, float[] fArr) {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(i);
            if (fArr != null && fArr.length == 4) {
                gradientDrawable.setCornerRadii(new float[]{fArr[0], fArr[0], fArr[1], fArr[1], fArr[2], fArr[2], fArr[3], fArr[3]});
            }
            return gradientDrawable;
        } catch (Exception unused) {
            return new GradientDrawable();
        }
    }

    public static GradientDrawable createRounderDrawable(int i, float f) {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(i);
            gradientDrawable.setCornerRadius(f);
            return gradientDrawable;
        } catch (Exception unused) {
            return new GradientDrawable();
        }
    }
}
