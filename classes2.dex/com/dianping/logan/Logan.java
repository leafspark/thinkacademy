package com.dianping.logan;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Logan {
    static boolean sDebug = false;
    private static LoganControlCenter sLoganControlCenter;
    private static OnLoganProtocolStatus sLoganProtocolStatus;

    public static void init(LoganConfig loganConfig) {
        sLoganControlCenter = LoganControlCenter.instance(loganConfig);
    }

    public static void w(String str, int i, String str2, String str3, String str4, int i2) {
        LoganControlCenter loganControlCenter = sLoganControlCenter;
        if (loganControlCenter != null) {
            loganControlCenter.write(str, i, str2, str3, str4, i2);
            return;
        }
        throw new RuntimeException("Please initialize Logan first");
    }

    public static void w(String str, int i) {
        LoganControlCenter loganControlCenter = sLoganControlCenter;
        if (loganControlCenter != null) {
            loganControlCenter.write(str, i);
            return;
        }
        throw new RuntimeException("Please initialize Logan first");
    }

    public static void f() {
        LoganControlCenter loganControlCenter = sLoganControlCenter;
        if (loganControlCenter != null) {
            loganControlCenter.flush();
            return;
        }
        throw new RuntimeException("Please initialize Logan first");
    }

    public static void o(String str) {
        LoganControlCenter loganControlCenter = sLoganControlCenter;
        if (loganControlCenter != null) {
            loganControlCenter.open(str);
            return;
        }
        throw new RuntimeException("Please initialize Logan first");
    }

    public static void o() {
        LoganControlCenter loganControlCenter = sLoganControlCenter;
        if (loganControlCenter != null) {
            loganControlCenter.open((String) null);
            return;
        }
        throw new RuntimeException("Please initialize Logan first");
    }

    public static void s(String[] strArr, SendLogRunnable sendLogRunnable) {
        LoganControlCenter loganControlCenter = sLoganControlCenter;
        if (loganControlCenter != null) {
            loganControlCenter.send(strArr, sendLogRunnable);
            return;
        }
        throw new RuntimeException("Please initialize Logan first");
    }

    public static Map<String, Long> getAllFilesInfo() {
        File[] listFiles;
        LoganControlCenter loganControlCenter = sLoganControlCenter;
        if (loganControlCenter != null) {
            File dir = loganControlCenter.getDir();
            if (!dir.exists() || (listFiles = dir.listFiles()) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (File file : listFiles) {
                try {
                    hashMap.put(file.getName(), Long.valueOf(file.length()));
                } catch (NumberFormatException unused) {
                }
            }
            return hashMap;
        }
        throw new RuntimeException("Please initialize Logan first");
    }

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    static void onListenerLogWriteStatus(String str, int i) {
        OnLoganProtocolStatus onLoganProtocolStatus = sLoganProtocolStatus;
        if (onLoganProtocolStatus != null) {
            onLoganProtocolStatus.loganProtocolStatus(str, i);
        }
    }

    public static void setOnLoganProtocolStatus(OnLoganProtocolStatus onLoganProtocolStatus) {
        sLoganProtocolStatus = onLoganProtocolStatus;
    }
}
