package tv.danmaku.ijk.media.psplayer.pragma;

import android.util.Log;
import java.util.Locale;

public class DebugLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static int level = 5;
    private static OnLogCallback mOnLogCallback;

    public interface OnLogCallback {
        void onLog(int i, String str, String str2);

        void onLog(int i, String str, String str2, Throwable th);
    }

    public static void v(String str, String str2) {
    }

    public static void v(String str, String str2, Throwable th) {
    }

    public static void vfmt(String str, String str2, Object... objArr) {
    }

    public static void setLevel(int i) {
        level = i;
    }

    public static int getLevel() {
        return level;
    }

    public static void e(String str, String str2) {
        if (level <= 6) {
            Log.e(str, str2);
            logCallback(6, str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (level <= 6) {
            Log.e(str, str2, th);
            logCallback(6, str, str2, th);
        }
    }

    public static void efmt(String str, String str2, Object... objArr) {
        if (level <= 6) {
            String format = String.format(Locale.US, str2, objArr);
            Log.e(str, format);
            logCallback(6, str, format);
        }
    }

    public static void i(String str, String str2) {
        if (level <= 4) {
            Log.i(str, str2);
            logCallback(4, str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (level <= 4) {
            Log.i(str, str2, th);
            logCallback(4, str, str2, th);
        }
    }

    public static void ifmt(String str, String str2, Object... objArr) {
        if (level <= 4) {
            String format = String.format(Locale.US, str2, objArr);
            Log.i(str, format);
            logCallback(4, str, format);
        }
    }

    public static void w(String str, String str2) {
        if (level <= 5) {
            Log.w(str, str2);
            logCallback(5, str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (level <= 5) {
            Log.w(str, str2, th);
            logCallback(5, str, str2, th);
        }
    }

    public static void wfmt(String str, String str2, Object... objArr) {
        if (level <= 5) {
            String format = String.format(Locale.US, str2, objArr);
            Log.w(str, format);
            logCallback(5, str, format);
        }
    }

    public static void d(String str, String str2) {
        if (level <= 3) {
            Log.d(str, str2);
            logCallback(3, str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (level <= 3) {
            Log.d(str, str2, th);
            logCallback(3, str, str2, th);
        }
    }

    public static void dfmt(String str, String str2, Object... objArr) {
        if (level <= 3) {
            String format = String.format(Locale.US, str2, objArr);
            Log.d(str, format);
            logCallback(3, str, format);
        }
    }

    public static void printStackTrace(Throwable th) {
        if (level <= 5) {
            th.printStackTrace();
        }
    }

    public static void printCause(Throwable th) {
        if (level <= 5) {
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            printStackTrace(th);
        }
    }

    private static StackTraceElement getStackTrace() {
        return Thread.currentThread().getStackTrace()[2];
    }

    private static final void logCallback(int i, String str, String str2) {
        OnLogCallback onLogCallback = mOnLogCallback;
        if (onLogCallback != null) {
            onLogCallback.onLog(i, str, str2);
        }
    }

    private static void logCallback(int i, String str, String str2, Throwable th) {
        OnLogCallback onLogCallback = mOnLogCallback;
        if (onLogCallback != null) {
            onLogCallback.onLog(i, str, str2, th);
        }
    }

    public static void setLogCallback(OnLogCallback onLogCallback) {
        mOnLogCallback = onLogCallback;
    }
}
