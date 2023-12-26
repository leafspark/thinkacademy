package com.didi.hummer.core.util;

import android.util.Log;

public class HMLog {
    public static void v(String str, String str2) {
        if (DebugUtil.isDebuggable()) {
            Log.v(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (DebugUtil.isDebuggable()) {
            Log.d(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (DebugUtil.isDebuggable()) {
            Log.i(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (DebugUtil.isDebuggable()) {
            Log.w(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (DebugUtil.isDebuggable()) {
            Log.w(str, str2, th);
        }
    }

    public static void e(String str, String str2) {
        if (DebugUtil.isDebuggable()) {
            Log.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (DebugUtil.isDebuggable()) {
            Log.e(str, str2, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (DebugUtil.isDebuggable()) {
            Log.wtf(str, str2);
        }
    }

    public static void wtf(String str, String str2, Throwable th) {
        if (DebugUtil.isDebuggable()) {
            Log.wtf(str, str2, th);
        }
    }
}
