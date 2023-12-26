package com.tal.app.thinkacademy.lib.util;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class AdaptScreenUtils {
    private static final float SUBUNITS = 1.0f;
    private static float mInitDensity;
    private static int mInitDensityDpi;
    /* access modifiers changed from: private */
    public static float mInitScaleDensity;
    private static List<Field> sMetricsFields;

    private AdaptScreenUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Resources adaptRangeWidth(Resources resources, int i, int i2) {
        int i3 = (int) ((((float) resources.getDisplayMetrics().widthPixels) * SUBUNITS) / mInitDensity);
        if (i3 > i) {
            return adaptWidth(resources, i);
        }
        if (i3 < i2) {
            return adaptWidth(resources, i2);
        }
        return adaptWidth(resources, i3);
    }

    public static Resources adaptWidth(Resources resources, int i) {
        float f = (float) i;
        float f2 = (((float) resources.getDisplayMetrics().widthPixels) * SUBUNITS) / f;
        applyDisplayMetrics(resources, (((float) resources.getDisplayMetrics().widthPixels) * SUBUNITS) / f, f2, (int) (160.0f * f2), (mInitScaleDensity * f2) / mInitDensity);
        return resources;
    }

    public static Resources adaptHeight(Resources resources, int i) {
        return adaptHeight(resources, i, false);
    }

    public static Resources adaptHeight(Resources resources, int i, boolean z) {
        float navBarHeight = (((float) (resources.getDisplayMetrics().heightPixels + (z ? BarUtils.getNavBarHeight() : 0))) * SUBUNITS) / ((float) i);
        applyDisplayMetrics(resources, navBarHeight, navBarHeight, (int) (160.0f * navBarHeight), (mInitScaleDensity * navBarHeight) / mInitDensity);
        return resources;
    }

    public static Resources closeAdapt(Resources resources) {
        applyDisplayMetrics(resources, Resources.getSystem().getDisplayMetrics().density * 72.0f, mInitDensity, mInitDensityDpi, mInitScaleDensity);
        return resources;
    }

    public static int pt2Px(float f) {
        return (int) (((double) ((f * Utils.getApp().getResources().getDisplayMetrics().xdpi) / SUBUNITS)) + 0.5d);
    }

    public static int px2Pt(float f) {
        return (int) (((double) ((f * SUBUNITS) / Utils.getApp().getResources().getDisplayMetrics().xdpi)) + 0.5d);
    }

    private static void applyDisplayMetrics(Resources resources, float f, float f2, int i, float f3) {
        setDensity(resources.getDisplayMetrics(), f, f2, i, f3);
        setDensity(Utils.getApp().getResources().getDisplayMetrics(), f, f2, i, f3);
    }

    private static void setDensity(DisplayMetrics displayMetrics, float f, float f2, int i, float f3) {
        displayMetrics.density = f2;
        displayMetrics.densityDpi = i;
        displayMetrics.scaledDensity = f3;
    }

    static Runnable getPreLoadRunnable() {
        return new Runnable() {
            public void run() {
                AdaptScreenUtils.preLoad();
            }
        };
    }

    /* access modifiers changed from: private */
    public static void preLoad() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        mInitDensity = displayMetrics.density;
        mInitDensityDpi = displayMetrics.densityDpi;
        mInitScaleDensity = displayMetrics.scaledDensity;
        Utils.getApp().registerComponentCallbacks(new ComponentCallbacks() {
            public void onLowMemory() {
            }

            public void onConfigurationChanged(Configuration configuration) {
                if (configuration.fontScale > 0.0f) {
                    float unused = AdaptScreenUtils.mInitScaleDensity = Resources.getSystem().getDisplayMetrics().scaledDensity;
                }
            }
        });
        applyDisplayMetrics(Resources.getSystem(), displayMetrics.xdpi, mInitDensity, mInitDensityDpi, mInitScaleDensity);
    }

    private static void applyOtherDisplayMetrics(Resources resources, float f) {
        if (sMetricsFields == null) {
            sMetricsFields = new ArrayList();
            Class cls = resources.getClass();
            Field[] declaredFields = cls.getDeclaredFields();
            while (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                        field.setAccessible(true);
                        DisplayMetrics metricsFromField = getMetricsFromField(resources, field);
                        if (metricsFromField != null) {
                            sMetricsFields.add(field);
                            metricsFromField.xdpi = f;
                        }
                    }
                }
                cls = cls.getSuperclass();
                if (cls != null) {
                    declaredFields = cls.getDeclaredFields();
                } else {
                    return;
                }
            }
            return;
        }
        applyMetricsFields(resources, f);
    }

    private static void applyMetricsFields(Resources resources, float f) {
        for (Field field : sMetricsFields) {
            try {
                DisplayMetrics displayMetrics = (DisplayMetrics) field.get(resources);
                if (displayMetrics != null) {
                    displayMetrics.xdpi = f;
                }
            } catch (Exception e) {
                Log.e("AdaptScreenUtils", "applyMetricsFields: " + e);
            }
        }
    }

    private static DisplayMetrics getMetricsFromField(Resources resources, Field field) {
        try {
            return (DisplayMetrics) field.get(resources);
        } catch (Exception unused) {
            return null;
        }
    }
}
