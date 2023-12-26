package com.tal.app.thinkacademy.lib.language;

import android.app.Application;
import android.content.Context;

public class AppUtil {
    private static Application sApplication;

    private AppUtil() {
    }

    public static void init(Context context) {
        if (context == null) {
            init(getApplicationByReflect());
        } else {
            init((Application) context.getApplicationContext());
        }
    }

    public static void init(Application application) {
        if (sApplication != null) {
            return;
        }
        if (application == null) {
            sApplication = getApplicationByReflect();
        } else {
            sApplication = application;
        }
    }

    public static Application getApplication() {
        Application application = sApplication;
        if (application != null) {
            return application;
        }
        Application applicationByReflect = getApplicationByReflect();
        init(applicationByReflect);
        return applicationByReflect;
    }

    private static Application getApplicationByReflect() {
        try {
            Application application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke((Object) null, new Object[0]);
            if (application != null) {
                return application;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Application application2 = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke((Object) null, new Object[0]);
            if (application2 != null) {
                return application2;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
