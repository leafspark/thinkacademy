package androidx.camera.core;

import android.os.Build;
import android.util.Log;

public final class Logger {
    static final int DEFAULT_MIN_LOG_LEVEL = 3;
    private static final int MAX_TAG_LENGTH = 23;
    private static int sMinLogLevel = 3;

    private Logger() {
    }

    static void setMinLogLevel(int i) {
        sMinLogLevel = i;
    }

    static void resetMinLogLevel() {
        sMinLogLevel = 3;
    }

    public static boolean isDebugEnabled(String str) {
        return sMinLogLevel <= 3 || Log.isLoggable(truncateTag(str), 3);
    }

    public static boolean isInfoEnabled(String str) {
        return sMinLogLevel <= 4 || Log.isLoggable(truncateTag(str), 4);
    }

    public static boolean isWarnEnabled(String str) {
        return sMinLogLevel <= 5 || Log.isLoggable(truncateTag(str), 5);
    }

    public static boolean isErrorEnabled(String str) {
        return sMinLogLevel <= 6 || Log.isLoggable(truncateTag(str), 6);
    }

    public static void d(String str, String str2) {
        d(str, str2, (Throwable) null);
    }

    public static void d(String str, String str2, Throwable th) {
        if (isDebugEnabled(str)) {
            Log.d(truncateTag(str), str2, th);
        }
    }

    public static void i(String str, String str2) {
        i(str, str2, (Throwable) null);
    }

    public static void i(String str, String str2, Throwable th) {
        if (isInfoEnabled(str)) {
            Log.i(truncateTag(str), str2, th);
        }
    }

    public static void w(String str, String str2) {
        w(str, str2, (Throwable) null);
    }

    public static void w(String str, String str2, Throwable th) {
        if (isWarnEnabled(str)) {
            Log.w(truncateTag(str), str2, th);
        }
    }

    public static void e(String str, String str2) {
        e(str, str2, (Throwable) null);
    }

    public static void e(String str, String str2, Throwable th) {
        if (isErrorEnabled(str)) {
            Log.e(truncateTag(str), str2, th);
        }
    }

    private static String truncateTag(String str) {
        return (23 >= str.length() || Build.VERSION.SDK_INT >= 24) ? str : str.substring(0, 23);
    }
}
