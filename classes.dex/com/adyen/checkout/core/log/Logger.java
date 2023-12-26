package com.adyen.checkout.core.log;

import android.util.Log;
import com.adyen.checkout.core.exception.NoConstructorException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Logger {
    private static final int MAX_LOGCAT_MSG_SIZE = 2048;
    public static final int NONE = 8;
    private static final int SENSITIVE = -1;
    private static boolean sIsLogcatLevelInitialized = false;
    private static int sLogcatLevel = 8;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    public static void updateDefaultLogcatLevel(boolean z) {
        if (!sIsLogcatLevelInitialized) {
            sLogcatLevel = z ? 3 : 8;
        }
    }

    public static void setLogcatLevel(int i) {
        sIsLogcatLevelInitialized = true;
        sLogcatLevel = i;
    }

    public static void v(String str, String str2) {
        logToLogcat(2, str, str2, (Throwable) null);
    }

    public static void v(String str, String str2, Throwable th) {
        logToLogcat(2, str, str2, th);
    }

    public static void d(String str, String str2) {
        logToLogcat(3, str, str2, (Throwable) null);
    }

    public static void d(String str, String str2, Throwable th) {
        logToLogcat(3, str, str2, th);
    }

    public static void i(String str, String str2) {
        logToLogcat(4, str, str2, (Throwable) null);
    }

    public static void i(String str, String str2, Throwable th) {
        logToLogcat(4, str, str2, th);
    }

    public static void w(String str, String str2) {
        logToLogcat(5, str, str2, (Throwable) null);
    }

    public static void w(String str, String str2, Throwable th) {
        logToLogcat(5, str, str2, th);
    }

    public static void e(String str, String str2) {
        logToLogcat(6, str, str2, (Throwable) null);
    }

    public static void e(String str, String str2, Throwable th) {
        logToLogcat(6, str, str2, th);
    }

    public static void sensitiveLog(String str, String str2) {
        if (sLogcatLevel == -1) {
            logToLogcat(-1, str, str2, (Throwable) null);
            return;
        }
        throw new SecurityException("Sensitive information should never be logged. Remove before committing.");
    }

    private static void logToLogcat(int i, String str, String str2, Throwable th) {
        String str3;
        if (sLogcatLevel <= i) {
            if (str2.length() > 2048) {
                int length = str2.length() / 2048;
                for (int i2 = 0; i2 <= length; i2++) {
                    if (i2 != length) {
                        str3 = str2.substring(i2 * 2048, (i2 + 1) * 2048);
                    } else {
                        str3 = str2.substring(i2 * 2048);
                    }
                    logToLogcat(i, str + "-" + i2, str3, th);
                }
            } else if (i != -1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i == 6) {
                                    if (th == null) {
                                        Log.e(str, str2);
                                    } else {
                                        Log.e(str, str2, th);
                                    }
                                }
                            } else if (th == null) {
                                Log.w(str, str2);
                            } else {
                                Log.w(str, str2, th);
                            }
                        } else if (th == null) {
                            Log.i(str, str2);
                        } else {
                            Log.i(str, str2, th);
                        }
                    } else if (th == null) {
                        Log.d(str, str2);
                    } else {
                        Log.d(str, str2, th);
                    }
                } else if (th == null) {
                    Log.v(str, str2);
                } else {
                    Log.v(str, str2, th);
                }
            } else if (th == null) {
                Log.wtf(str, str2);
            } else {
                Log.wtf(str, str2, th);
            }
        }
    }

    private Logger() {
        throw new NoConstructorException();
    }
}
