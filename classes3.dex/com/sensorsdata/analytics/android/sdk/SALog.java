package com.sensorsdata.analytics.android.sdk;

import android.util.Log;

public class SALog {
    private static final int CHUNK_SIZE = 4000;
    private static boolean debug;
    private static boolean disableSDK;
    private static boolean enableLog;

    public static void d(String str, String str2) {
        if (debug && !disableSDK) {
            info(str, str2, (Throwable) null);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (debug && !disableSDK) {
            info(str, str2, th);
        }
    }

    public static void i(String str, String str2) {
        if (enableLog && !disableSDK) {
            info(str, str2, (Throwable) null);
        }
    }

    public static void i(String str, Throwable th) {
        if (enableLog && !disableSDK) {
            info(str, "", th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (enableLog && !disableSDK) {
            info(str, str2, th);
        }
    }

    public static void info(String str, String str2, Throwable th) {
        if (str2 != null) {
            try {
                byte[] bytes = str2.getBytes();
                int length = bytes.length;
                if (length <= 4000) {
                    Log.i(str, str2, th);
                    return;
                }
                int i = 0;
                while (i < length - 4000) {
                    int lastIndexOfLF = lastIndexOfLF(bytes, i);
                    int i2 = lastIndexOfLF - i;
                    Log.i(str, new String(bytes, i, i2), (Throwable) null);
                    if (i2 < 4000) {
                        lastIndexOfLF++;
                    }
                    i = lastIndexOfLF;
                }
                if (length > i) {
                    Log.i(str, new String(bytes, i, length - i), th);
                }
            } catch (Exception e) {
                printStackTrace(e);
            }
        } else {
            Log.i(str, (String) null, th);
        }
    }

    private static int lastIndexOfLF(byte[] bArr, int i) {
        int min = Math.min(i + 4000, bArr.length - 1);
        for (int i2 = min; i2 > min - 4000; i2--) {
            if (bArr[i2] == 10) {
                return i2;
            }
        }
        return min;
    }

    public static void printStackTrace(Exception exc) {
        if (enableLog && !disableSDK && exc != null) {
            Log.e("SA.Exception", "", exc);
        }
    }

    static void setDebug(boolean z) {
        debug = z;
    }

    public static void setEnableLog(boolean z) {
        enableLog = z;
    }

    public static void setDisableSDK(boolean z) {
        disableSDK = z;
    }

    public static boolean isLogEnabled() {
        return enableLog;
    }
}
