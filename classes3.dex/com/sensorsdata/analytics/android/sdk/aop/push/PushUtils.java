package com.sensorsdata.analytics.android.sdk.aop.push;

public class PushUtils {
    public static String getJPushSDKName(byte b) {
        if (b == 1) {
            return "Xiaomi";
        }
        if (b == 2) {
            return "HUAWEI";
        }
        if (b == 3) {
            return "Meizu";
        }
        if (b == 4) {
            return "OPPO";
        }
        if (b != 5) {
            return null;
        }
        return "vivo";
    }
}
