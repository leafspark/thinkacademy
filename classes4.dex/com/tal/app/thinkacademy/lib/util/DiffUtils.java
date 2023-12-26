package com.tal.app.thinkacademy.lib.util;

public class DiffUtils {
    public static native void bsPatch(String str, String str2, String str3);

    static {
        System.loadLibrary("xes-diff");
    }
}
