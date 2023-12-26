package com.luck.picture.lib.tools;

import android.os.Build;

public class SdkVersionUtils {
    public static final int R = 30;
    public static final int TIRAMISU = 33;

    public static boolean checkedAndroid_Q() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean checkedAndroid_R() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean isMinM() {
        return Build.VERSION.SDK_INT < 23;
    }

    public static boolean isO() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isMaxN() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean isN() {
        return Build.VERSION.SDK_INT == 24;
    }

    public static boolean isP() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean isQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean isR() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean isTIRAMISU() {
        return Build.VERSION.SDK_INT >= 33;
    }
}
