package com.coloros.ocs.base.a;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;

public final class b {
    private static boolean a = false;
    private static boolean b;
    private static boolean c;

    static {
        boolean isLoggable = Log.isLoggable("OcsBase", 3);
        b = isLoggable;
        c = isLoggable;
    }

    public static void a(Context context) {
        if (context != null) {
            boolean z = false;
            boolean z2 = Settings.System.getInt(context.getContentResolver(), "log_switch_type", 0) != 0;
            a = z2;
            if (z2 || b) {
                z = true;
            }
            c = z;
            Log.i("OcsBase", "AFLog, sIsLogOn = " + a + ", sIsDebugTagOn = " + b);
        }
    }

    public static void a(String str, String str2) {
        if (c) {
            Log.v("OcsBase.".concat(String.valueOf(str)), str2);
        }
    }

    public static void b(String str, String str2) {
        if (c) {
            Log.d("OcsBase.".concat(String.valueOf(str)), str2);
        }
    }

    public static void a(String str) {
        if (c) {
            Log.d("OcsBase", str);
        }
    }

    public static void c(String str, String str2) {
        Log.i("OcsBase.".concat(String.valueOf(str)), str2);
    }

    public static void d(String str, String str2) {
        Log.e("OcsBase.".concat(String.valueOf(str)), str2);
    }
}
