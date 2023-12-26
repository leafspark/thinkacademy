package com.didi.hummer.core.util;

public class DebugUtil {
    private static boolean isDebug = false;

    public static boolean isDebuggable() {
        return isDebug;
    }

    public static void setDebuggable(boolean z) {
        isDebug = z;
    }
}
