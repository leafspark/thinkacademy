package com.xueersi.lib.graffiti.utils;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import java.lang.reflect.InvocationTargetException;

public final class AppUtils {
    private static Application sApplication;

    public static void init(Context context) {
        if (context == null) {
            sApplication = getApplicationByReflect();
        } else {
            sApplication = (Application) context.getApplicationContext();
        }
    }

    public static Application getApp() {
        Application application = sApplication;
        if (application != null) {
            return application;
        }
        return getApplicationByReflect();
    }

    private static Application getApplicationByReflect() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]), new Object[0]);
            if (invoke != null) {
                return (Application) invoke;
            }
            throw new NullPointerException("u should init first");
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            throw new NullPointerException("u should init first");
        }
    }

    public static DisplayMetrics getDisplayMetrics() {
        return getApp().getResources().getDisplayMetrics();
    }
}
