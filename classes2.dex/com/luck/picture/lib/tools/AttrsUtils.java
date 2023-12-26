package com.luck.picture.lib.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;

public class AttrsUtils {
    public static float getTypeValueSize(Context context, int i) {
        float f = 0.0f;
        try {
            int[] iArr = {i};
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, iArr);
            f = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
            obtainStyledAttributes.recycle();
            return f;
        } catch (Exception e) {
            e.printStackTrace();
            return f;
        }
    }

    public static int getTypeValueSizeForInt(Context context, int i) {
        int i2 = 0;
        try {
            int[] iArr = {i};
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, iArr);
            i2 = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            obtainStyledAttributes.recycle();
            return i2;
        } catch (Exception e) {
            e.printStackTrace();
            return i2;
        }
    }

    public static int getTypeValueColor(Context context, int i) {
        int i2 = 0;
        try {
            int[] iArr = {i};
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, iArr);
            i2 = obtainStyledAttributes.getColor(0, 0);
            obtainStyledAttributes.recycle();
            return i2;
        } catch (Exception e) {
            e.printStackTrace();
            return i2;
        }
    }

    public static ColorStateList getTypeValueColorStateList(Context context, int i) {
        ColorStateList colorStateList = null;
        try {
            int[] iArr = {i};
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, iArr);
            colorStateList = obtainStyledAttributes.getColorStateList(0);
            obtainStyledAttributes.recycle();
            return colorStateList;
        } catch (Exception e) {
            e.printStackTrace();
            return colorStateList;
        }
    }

    public static boolean getTypeValueBoolean(Context context, int i) {
        boolean z = false;
        try {
            int[] iArr = {i};
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, iArr);
            z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    public static Drawable getTypeValueDrawable(Context context, int i, int i2) {
        Drawable drawable = null;
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i});
            drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return drawable == null ? ContextCompat.getDrawable(context, i2) : drawable;
    }

    public static ColorStateList getColorStateList(int[] iArr) {
        try {
            if (iArr.length != 2) {
                return ColorStateList.valueOf(iArr[0]);
            }
            return new ColorStateList(new int[][]{new int[]{-16842913}, new int[]{16842913}}, iArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
