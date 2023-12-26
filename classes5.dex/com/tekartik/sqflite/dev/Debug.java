package com.tekartik.sqflite.dev;

import android.util.Log;

public class Debug {
    public static boolean EXTRA_LOGV = false;
    public static boolean LOGV = false;
    public static boolean _EXTRA_LOGV = false;

    @Deprecated
    public static void devLog(String str, String str2) {
        Log.d("ContentValues", str2);
    }
}
