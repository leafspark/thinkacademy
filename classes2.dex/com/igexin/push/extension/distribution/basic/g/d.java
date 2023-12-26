package com.igexin.push.extension.distribution.basic.g;

import android.app.Notification;
import android.content.Context;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.List;

public class d {
    private static volatile Boolean a;

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

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static synchronized boolean a(int i, Notification notification) {
        synchronized (d.class) {
            try {
                if (b()) {
                    Object obj = notification.getClass().getDeclaredField("extraNotification").get(notification);
                    obj.getClass().getDeclaredMethod("setMessageCount", new Class[]{Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i)});
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static synchronized boolean a(int i, boolean z) {
        synchronized (d.class) {
            try {
                if (com.igexin.push.core.d.g == null) {
                    return false;
                }
                String a2 = a();
                if ("huawei".equalsIgnoreCase(a2) || "honor".equalsIgnoreCase(a2)) {
                    int intValue = ((Integer) g.b(com.igexin.push.core.d.g, "hwBadgeNum", 0)).intValue();
                    if (!z) {
                        i += intValue;
                    }
                    g.a(com.igexin.push.core.d.g, "hwBadgeNum", Integer.valueOf(i));
                    Bundle bundle = new Bundle();
                    bundle.putString("package", com.igexin.push.core.d.g.getPackageName());
                    bundle.putString("class", b(com.igexin.push.core.d.g));
                    bundle.putInt("badgenumber", i);
                    Uri parse = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                    Uri parse2 = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
                    if (TextUtils.isEmpty(com.igexin.push.core.d.g.getContentResolver().getType(parse))) {
                        parse = parse2;
                    }
                    com.igexin.push.core.d.g.getContentResolver().call(parse, "change_badge", (String) null, bundle);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static String b(Context context) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()), 0);
            return queryIntentActivities.size() > 0 ? queryIntentActivities.get(0).activityInfo.name : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean b() {
        boolean z;
        try {
            if (a != null) {
                return a.booleanValue();
            }
            String a2 = a("ro.miui.ui.version.name");
            String a3 = a("ro.miui.ui.version.code");
            if (!"Xiaomi".equalsIgnoreCase(Build.BRAND) && TextUtils.isEmpty(a2)) {
                if (TextUtils.isEmpty(a3)) {
                    z = false;
                    a = Boolean.valueOf(z);
                    return a.booleanValue();
                }
            }
            z = true;
            a = Boolean.valueOf(z);
            return a.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }
}
