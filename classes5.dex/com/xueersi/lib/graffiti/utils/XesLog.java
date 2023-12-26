package com.xueersi.lib.graffiti.utils;

import android.text.TextUtils;
import android.util.Log;
import com.xueersi.lib.graffiti.LogProvider;

public class XesLog {
    protected static final String TAG = "xes_graffiti";
    private static boolean disable = false;
    private static LogProvider logProvider;

    public static void setLogProvider(LogProvider logProvider2) {
        logProvider = logProvider2;
    }

    public static void info(String str) {
        LogProvider logProvider2 = logProvider;
        if (logProvider2 != null && str != null) {
            logProvider2.i(str);
        }
    }

    public static void setDebugMode(boolean z) {
        disable = !z;
    }

    private static String buildMessage(String str) {
        StackTraceElement stackTraceElement = new Throwable().fillInStackTrace().getStackTrace()[2];
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(" : ");
        stringBuffer.append(stackTraceElement.getClassName());
        stringBuffer.append(".");
        stringBuffer.append(stackTraceElement.getMethodName());
        stringBuffer.append("()");
        return stringBuffer.toString();
    }

    public static boolean isEnabled() {
        return !disable;
    }

    public static void v(String str) {
        if (isEnabled()) {
            Log.v(TAG, buildMessage(str));
        }
    }

    public static void v(String str, Throwable th) {
        if (isEnabled()) {
            Log.v(TAG, buildMessage(str), th);
        }
    }

    public static void d(String str) {
        if (isEnabled()) {
            Log.d(TAG, buildMessage(str));
        }
    }

    public static void d(String str, String str2) {
        if (isEnabled()) {
            Log.d(str, str2);
        }
    }

    public static void d(String str, Throwable th) {
        if (isEnabled()) {
            Log.d(TAG, buildMessage(str), th);
        }
    }

    public static void i(String str) {
        if (isEnabled()) {
            Log.i(TAG, buildMessage(str));
        }
    }

    public static void i(String str, Throwable th) {
        if (isEnabled()) {
            Log.i(TAG, buildMessage(str), th);
        }
    }

    public static void e(String str) {
        if (isEnabled()) {
            Log.e(TAG, buildMessage(str));
        }
    }

    public static void e(String str, Throwable th) {
        if (isEnabled()) {
            Log.e(TAG, buildMessage(str), th);
        }
    }

    public static void w(String str) {
        if (isEnabled()) {
            Log.w(TAG, buildMessage(str));
        }
    }

    public static void w(String str, Throwable th) {
        if (isEnabled()) {
            Log.w(TAG, buildMessage(str), th);
        }
    }

    public static void logCallStack(String str) {
        if (isEnabled()) {
            if (TextUtils.isEmpty(str)) {
                str = TAG;
            }
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null) {
                for (int i = 0; i < stackTrace.length; i++) {
                    String className = stackTrace[i].getClassName();
                    if (TextUtils.isEmpty(className) || !className.startsWith("com.xueersi")) {
                        Log.i(str, "class : " + className + "-----line Number : " + stackTrace[i].getLineNumber() + "-----method name : " + stackTrace[i].getMethodName());
                    }
                }
            }
        }
    }
}
