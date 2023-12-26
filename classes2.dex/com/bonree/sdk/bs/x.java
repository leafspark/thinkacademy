package com.bonree.sdk.bs;

import android.text.TextUtils;
import java.io.Serializable;

public final class x {
    public static String a(Serializable serializable) {
        String substring;
        if (serializable == null) {
            return "";
        }
        try {
            String[] split = serializable.toString().split("/");
            if (split != null && split.length == 2) {
                if (!TextUtils.isEmpty(split[0])) {
                    return split[0];
                }
                if (split[1] != null) {
                    String str = split[1];
                    String str2 = ":" + b(serializable);
                    if (str.endsWith(str2) && (substring = str.substring(0, str.lastIndexOf(str2))) != null) {
                        return substring.contains("]") ? substring.split("]")[0].replace("[", "") : substring;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String a(Serializable serializable, int i) {
        if (serializable == null) {
            return "";
        }
        try {
            String obj = serializable.toString();
            String str = ":" + i;
            if (obj.endsWith(str)) {
                obj = obj.substring(0, obj.lastIndexOf(str));
            }
            String[] split = obj.split("/");
            if (!(split == null || split.length != 2 || split[1] == null)) {
                if (split[1].contains("]")) {
                    return split[1].split("]")[0].replace("[", "");
                }
                return split[1];
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private static int a(String str, String str2) {
        if (str.length() <= 0) {
            return 0;
        }
        String upperCase = str.toUpperCase();
        char charAt = str2.toUpperCase().charAt(0);
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (charAt == upperCase.charAt(i2)) {
                i++;
            }
        }
        return i;
    }

    public static int b(Serializable serializable) {
        if (serializable == null) {
            return 80;
        }
        try {
            String[] split = serializable.toString().split(":");
            if (split != null && split.length > 1 && !TextUtils.isEmpty(split[split.length - 1])) {
                return Integer.parseInt(split[split.length - 1]);
            }
        } catch (Throwable unused) {
        }
        return 80;
    }
}
