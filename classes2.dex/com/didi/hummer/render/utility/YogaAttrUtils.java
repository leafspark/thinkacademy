package com.didi.hummer.render.utility;

import android.graphics.Color;

public class YogaAttrUtils {
    public static boolean isNumeric(String str) {
        return str.matches("^-?\\d+(\\.\\d+)?$");
    }

    public static boolean isPxNumeric(String str) {
        return str.matches("^-?\\d+(\\.\\d+)?(px|PX)$");
    }

    public static boolean isHmNumeric(String str) {
        return str.matches("^-?\\d+(\\.\\d+)?(hm|HM)$");
    }

    public static boolean isColor(String str) {
        if (str.charAt(0) == '#') {
            return str.length() == 7 || str.length() == 9;
        }
        return false;
    }

    public static boolean isColor24(String str) {
        return str.charAt(0) == '#' && str.length() == 7;
    }

    public static boolean isColor32(String str) {
        return str.charAt(0) == '#' && str.length() == 9;
    }

    public static boolean isLinearGradientColor(String str) {
        return str.startsWith("linear-gradient");
    }

    public static int parseColor(String str) {
        int i;
        try {
            i = Color.parseColor(str);
        } catch (Exception unused) {
            i = 0;
        }
        return str.length() == 9 ? YogaColorUtils.rgba2argb(i) : i;
    }

    public static int[] parseLinearGradientColor(String str) {
        String[] split = str.replace("linear-gradient(", "").replace("deg", "").replace(")", "").trim().split("\\s+");
        int length = split.length;
        int[] iArr = new int[length];
        iArr[0] = Integer.parseInt(split[0]) % 360;
        for (int i = 1; i < length; i++) {
            iArr[i] = parseColor(split[i]);
        }
        return iArr;
    }
}
