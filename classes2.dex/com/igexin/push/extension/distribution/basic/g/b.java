package com.igexin.push.extension.distribution.basic.g;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.push.core.d;
import com.igexin.push.extension.distribution.basic.c.e;

public class b {
    public static boolean a() {
        try {
            Class.forName("com.igexin.push.util.EncryptUtils");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Intent intent, Context context) {
        if (intent == null || context == null) {
            return false;
        }
        try {
            return context.getPackageManager().queryIntentActivities(intent, 0).size() > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(String str) {
        try {
            d.g.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b() {
        return b(e.f);
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            for (String str2 : str.split(",")) {
                if (str2.contains("|")) {
                    if (str2.contains("~")) {
                        String substring = str2.substring(0, str2.indexOf("|"));
                        String[] split = str2.substring(str2.indexOf("|") + 1).split("~");
                        if (split.length == 2) {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            if (Build.BRAND.equalsIgnoreCase(substring) && Build.VERSION.SDK_INT >= parseInt && Build.VERSION.SDK_INT <= parseInt2) {
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
