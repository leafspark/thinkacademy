package com.igexin.push.core;

import android.os.Environment;
import java.util.Random;

public class CoreConsts {
    public static final String a = a(6, "pre_burypoint.", new String[]{"co.", "mi.", "gex.", "ins.", "dka.", "cti.", "on.", "notifi.", "cation.", "burying.", "point."});
    public static final String b = a(5, "pre_doaction.", new String[]{"com.", "ige.", "xin.", "sdk.", "act.", "ion.", "do.", "act.", "tion."});
    public static final String c;
    public static final String d;
    public static final String e;
    public static int f = 0;
    public static int g = 2;
    public static int h = 11;
    public static int i = 5;
    public static int j = 7;
    public static int k = 9;
    public static int l = 10;
    public static int m = 0;
    public static int n = 1;
    public static int o = 2;
    public static String p = "com.igexin.sdk.PushService";
    public static String q = "com.igexin.sdk.coordinator.SdkMsgService";
    public static String r = "com.igexin.sdk.coordinator.GexinMsgService";

    static {
        String path = Environment.getExternalStorageDirectory().getPath();
        c = path;
        d = path + "/Sdk/ImgCache/";
        e = path + "/Sdk/WebCache/";
    }

    public static String a(int i2, String str, String[] strArr) {
        if (i2 <= 0 || strArr == null || strArr.length <= 0) {
            return str;
        }
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        for (int i3 = 0; i3 < i2; i3++) {
            stringBuffer.append(strArr[random.nextInt(strArr.length)]);
        }
        return stringBuffer.toString().substring(0, stringBuffer.toString().length() - 1);
    }

    @Deprecated
    public static String getBuryPointAction() {
        return a;
    }
}
