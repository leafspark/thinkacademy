package com.igexin.push.util;

import android.content.Context;
import android.os.Build;
import com.igexin.b.a.c.b;
import com.igexin.push.config.l;
import java.util.Arrays;

public class m {
    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String a() {
        return Build.BRAND;
    }

    public static boolean b() {
        if ("*".equals(l.B)) {
            return true;
        }
        try {
            return Arrays.asList(l.B.toUpperCase().split(",")).contains(Build.BRAND.toUpperCase());
        } catch (Exception e) {
            b.a("PhoneInfoUtils|delAlarm " + l.B + " err " + e.toString(), new Object[0]);
            return false;
        }
    }
}
