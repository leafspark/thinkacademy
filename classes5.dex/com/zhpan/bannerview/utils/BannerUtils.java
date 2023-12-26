package com.zhpan.bannerview.utils;

import android.content.res.Resources;
import android.util.Log;
import com.zhpan.bannerview.manager.IndicatorOptions;

public class BannerUtils {
    private static boolean debugMode = false;

    public static float getCoordinateY(float f) {
        return f / 2.0f;
    }

    public static void setDebugMode(boolean z) {
        debugMode = z;
    }

    public static boolean isDebugMode() {
        return debugMode;
    }

    public static int dp2px(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static void log(String str, String str2) {
        if (isDebugMode()) {
            Log.e(str, str2);
        }
    }

    public static void log(String str) {
        if (isDebugMode()) {
            Log.e("BannerView", str);
        }
    }

    public static int getRealPosition(boolean z, int i, int i2) {
        if (z) {
            i--;
        }
        return (i + i2) % i2;
    }

    public static float getCoordinateX(IndicatorOptions indicatorOptions, float f, int i) {
        return (f / 2.0f) + ((indicatorOptions.getNormalSliderWidth() + indicatorOptions.getSliderGap()) * ((float) i));
    }
}
