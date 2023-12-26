package com.bonree.sdk.d;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.aa;
import java.util.ArrayList;
import java.util.List;

public final class h {
    private String a;
    private String b;
    private final String c;
    private final Context d;
    private final a e;
    private List<String> f = new ArrayList();
    private final f g = a.a();
    private boolean h;

    public h(Context context, a aVar) {
        this.d = context;
        this.e = aVar;
        this.c = context.getPackageName();
        if (!TextUtils.isEmpty(aVar.D())) {
            this.a = aVar.D();
        } else {
            i();
        }
        c();
        d();
        if (!TextUtils.isEmpty(this.a)) {
            this.h = !this.a.equals(this.b);
        }
    }

    public final boolean a() {
        return this.h;
    }

    private void h() {
        if (!TextUtils.isEmpty(this.e.D())) {
            this.a = this.e.D();
        } else {
            i();
        }
        c();
        d();
        if (!TextUtils.isEmpty(this.a)) {
            this.h = !this.a.equals(this.b);
        }
    }

    private void i() {
        try {
            PackageInfo packageInfo = this.d.getPackageManager().getPackageInfo(this.c, 0);
            if (packageInfo == null || packageInfo.versionName == null || packageInfo.versionName.length() <= 0) {
                a.a.e("Your app doesn't appear to have a version defined. Ensure you have defined 'versionName' in your manifest.", new Object[0]);
            }
            this.a = packageInfo.versionName;
            int i = packageInfo.versionCode;
            if (i != 0) {
                this.a += "(" + i + ")";
            }
        } catch (Throwable th) {
            this.g.a("Could not determine package version: ", th);
            this.a = "default_bonree_versionName";
        }
    }

    public final String b() {
        if (!TextUtils.isEmpty(this.e.D()) && !this.e.D().equals(this.a)) {
            this.a = this.e.D();
        }
        return this.a;
    }

    public final void c() {
        try {
            this.b = aa.d(this.d, "PreAppVersion", "preVersion");
        } catch (Throwable unused) {
        }
    }

    public final void d() {
        try {
            aa.a(this.d, "PreAppVersion", "preVersion", this.a);
        } catch (Throwable unused) {
        }
    }

    public final String e() {
        return this.c;
    }

    public final boolean a(String str) {
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

    public final synchronized List<String> f() {
        List<String> list = this.f;
        if (list != null && list.size() <= 0) {
            try {
                for (ActivityInfo activityInfo : this.d.getPackageManager().getPackageInfo(this.c, 1).activities) {
                    this.f.add(activityInfo.name);
                }
            } catch (Throwable unused) {
                this.f = null;
            }
        }
        return this.f;
    }

    public final void g() {
        try {
            for (ActivityInfo activityInfo : this.d.getPackageManager().getPackageInfo(this.c, 1).activities) {
                this.f.add(activityInfo.name);
            }
        } catch (Throwable unused) {
            this.f = null;
        }
    }
}
