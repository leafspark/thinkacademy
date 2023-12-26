package com.bonree.sdk.a;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.aa;
import java.util.ArrayList;
import java.util.List;

public class a {
    private static boolean a = false;
    private static String b = "com.bonree.sdk";
    @Deprecated
    private static String c = "com.bonree.sdk";
    private static String d = "release";
    private static String e = "Bonree";
    private static int f = 1;
    private static String g = "1.0";
    private static String h = "7.10.0";
    private static String i = "20230428 22:02";
    private String j;
    private String k;
    private final String l;
    private final Context m;
    private final com.bonree.sdk.d.a n;
    private List<String> o;
    private final f p;
    private boolean q;

    public a() {
    }

    public a(Context context, com.bonree.sdk.d.a aVar) {
        this.m = context;
        this.n = aVar;
        this.l = context.getPackageName();
        this.o = new ArrayList();
        this.p = com.bonree.sdk.be.a.a();
        if (!TextUtils.isEmpty(aVar.D())) {
            this.j = aVar.D();
        } else {
            i();
        }
        c();
        d();
        if (!TextUtils.isEmpty(this.j)) {
            this.q = !this.j.equals(this.k);
        }
    }

    public boolean a() {
        return this.q;
    }

    private void h() {
        if (!TextUtils.isEmpty(this.n.D())) {
            this.j = this.n.D();
        } else {
            i();
        }
        c();
        d();
        if (!TextUtils.isEmpty(this.j)) {
            this.q = !this.j.equals(this.k);
        }
    }

    private void i() {
        try {
            PackageInfo packageInfo = this.m.getPackageManager().getPackageInfo(this.l, 0);
            if (packageInfo == null || packageInfo.versionName == null || packageInfo.versionName.length() <= 0) {
                com.bonree.sdk.d.a.a.e("Your app doesn't appear to have a version defined. Ensure you have defined 'versionName' in your manifest.", new Object[0]);
            }
            this.j = packageInfo.versionName;
            int i2 = packageInfo.versionCode;
            if (i2 != 0) {
                this.j += "(" + i2 + ")";
            }
        } catch (Throwable th) {
            this.p.a("Could not determine package version: ", th);
            this.j = "default_bonree_versionName";
        }
    }

    public String b() {
        if (!TextUtils.isEmpty(this.n.D()) && !this.n.D().equals(this.j)) {
            this.j = this.n.D();
        }
        return this.j;
    }

    public void c() {
        try {
            this.k = aa.d(this.m, "PreAppVersion", "preVersion");
        } catch (Throwable unused) {
        }
    }

    public void d() {
        try {
            aa.a(this.m, "PreAppVersion", "preVersion", this.j);
        } catch (Throwable unused) {
        }
    }

    public String e() {
        return this.l;
    }

    public boolean a(String str) {
        List<String> f2 = f();
        if (f2 != null && f2.size() > 0) {
            if (!f2.contains(str)) {
                for (String next : f2) {
                    if (!TextUtils.isEmpty(next) && next.startsWith("com.qihoo360.replugin")) {
                        break;
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public synchronized List<String> f() {
        List<String> list = this.o;
        if (list != null && list.size() <= 0) {
            g();
        }
        return this.o;
    }

    public void g() {
        try {
            for (ActivityInfo activityInfo : this.m.getPackageManager().getPackageInfo(this.l, 1).activities) {
                this.o.add(activityInfo.name);
            }
        } catch (Throwable unused) {
            this.o = null;
        }
    }
}
