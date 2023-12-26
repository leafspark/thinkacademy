package com.tal.user.global.trade.util;

public class JNISecurity {
    private static native byte[] aesEncode(String str, String str2);

    public static native String getKey();

    public static native String keyVersion();

    private static native String sign(String str, String str2);

    static {
        System.loadLibrary("taltradeglobalsecurity");
    }

    public static String signJava(String str, String str2) {
        String sign = sign(str, str2);
        return "" + sign;
    }

    public static byte[] aesEncodeJava(String str, String str2) {
        return aesEncode(str, str2);
    }
}
