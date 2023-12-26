package com.igexin.push.core.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;

class f implements c {
    private static String a = null;
    private static boolean b = false;
    private static boolean c = false;
    private static final CountDownLatch d = new CountDownLatch(1);
    private String e;
    private String f;
    private String g;
    private String h;
    private i i;

    public f(String str, String str2, String str3, String str4) {
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = str4;
    }

    /* access modifiers changed from: package-private */
    public long a(PackageInfo packageInfo) {
        try {
            Method declaredMethod = PackageInfo.class.getDeclaredMethod("getLongVersionCode", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Long) declaredMethod.invoke(packageInfo, new Object[0])).longValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public String a() {
        return null;
    }

    public boolean a(Context context) {
        if (c) {
            return b;
        }
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(this.e)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.e, 0);
                if (Build.VERSION.SDK_INT >= 28) {
                    return packageInfo != null && a(packageInfo) >= 1;
                }
                if (packageInfo != null && packageInfo.versionCode >= 1) {
                    z = true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        b = z;
        c = true;
        return b;
    }

    /* access modifiers changed from: protected */
    public int b() {
        return 1;
    }

    public String b(Context context) {
        i iVar;
        i iVar2;
        if (!TextUtils.isEmpty(a) || (iVar = this.i) == null || iVar.a() == null) {
            return a;
        }
        try {
            String a2 = this.i.a().a(d(context), e(context), a(), b());
            a = a2;
            if (!TextUtils.isEmpty(a2) && (iVar2 = this.i) != null) {
                context.unbindService(iVar2);
            }
        } catch (Throwable unused) {
        }
        return a;
    }

    public boolean c(Context context) {
        if (context == null || TextUtils.isEmpty(this.e)) {
            return false;
        }
        if (this.i == null) {
            this.i = new i(this.h, d);
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(this.f)) {
            intent.setPackage(this.e);
        } else {
            intent.setComponent(new ComponentName(this.e, this.f));
        }
        if (!TextUtils.isEmpty(this.g)) {
            intent.setAction(this.g);
        }
        return this.i.a(context, intent);
    }

    /* access modifiers changed from: protected */
    public String d(Context context) {
        return null;
    }

    /* access modifiers changed from: protected */
    public String e(Context context) {
        return null;
    }
}
