package com.didi.hummer.tools;

import com.didi.hummer.HummerSDK;
import com.didi.hummer.core.util.HMLog;

public class JSLogger {
    private static final String TAG = "HummerJS";

    public interface Logger {
        public static final int DEBUG = 2;
        public static final int ERROR = 5;
        public static final int INFO = 3;
        public static final int VERBOSE = 1;
        public static final int WARN = 4;

        void log(int i, String str);
    }

    public static void log(String str, String str2) {
        HMLog.v(TAG, str2);
        printLog(str, 1, str2);
    }

    public static void debug(String str, String str2) {
        HMLog.d(TAG, str2);
        printLog(str, 2, str2);
    }

    public static void info(String str, String str2) {
        HMLog.i(TAG, str2);
        printLog(str, 3, str2);
    }

    public static void warn(String str, String str2) {
        HMLog.w(TAG, str2);
        printLog(str, 4, str2);
    }

    public static void error(String str, String str2) {
        HMLog.e(TAG, str2);
        printLog(str, 5, str2);
    }

    private static void printLog(String str, int i, String str2) {
        Logger jSLogger = HummerSDK.getJSLogger(str);
        if (jSLogger != null) {
            jSLogger.log(i, str2);
        }
    }
}
