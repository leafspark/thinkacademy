package org.extra.tools;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import org.extra.relinker.c;

public abstract class a {
    public static final String a = "a";
    private static Context b;

    public static Context a() {
        return b;
    }

    public static void b(String str) {
        try {
            b = ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke((Object) null, (Object[]) null)).getApplicationContext();
        } catch (Exception unused) {
        }
        b(b, str);
    }

    private static boolean c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                c.a(context, str);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            String str2 = a;
            Log.i(str2, "loadLibrary " + str + " fail! Error: " + th.getMessage());
            return false;
        }
    }

    private static void b(Context context, String str) {
        if (!a(str) && !a(context, str)) {
            c(context, str);
        }
    }

    private static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            System.load((context.getApplicationInfo().dataDir + "/lib") + File.separator + "lib" + str + ".so");
            return true;
        } catch (Throwable th) {
            Log.i(a, "load  fail! Error: " + th.getMessage());
            return false;
        }
    }
}
