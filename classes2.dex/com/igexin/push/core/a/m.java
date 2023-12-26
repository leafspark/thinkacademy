package com.igexin.push.core.a;

import android.text.TextUtils;
import com.igexin.assist.sdk.a;
import com.igexin.b.a.c.a.f;
import com.igexin.b.a.d.e;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.b.i;
import com.igexin.push.core.d;
import com.igexin.push.core.r;
import com.igexin.push.d.b;
import com.igexin.push.d.c.k;
import com.igexin.push.util.c;

public class m extends a {
    private void b() {
        f a = f.a();
        a.a("Login successed with cid = " + d.u);
        b.a().f();
        com.igexin.b.a.c.b.a("loginRsp|" + d.u + "|success", new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("isCidBroadcasted|");
        sb.append(d.o);
        com.igexin.b.a.c.b.a(sb.toString(), new Object[0]);
        if (!d.o) {
            r.a().c();
            d.o = true;
        }
        d.n = true;
        r.a().b();
        e.a().c();
        if (TextUtils.isEmpty(d.A)) {
            e.a().d();
        }
        c.f();
        a();
        d();
        i.a().b();
        e();
        f();
    }

    private void c() {
        com.igexin.b.a.c.b.a("loginRsp|" + d.u + "|failed", new Object[0]);
        f a = f.a();
        a.a("Login " + d.u + " failed");
        com.igexin.b.a.c.b.a("LoginResultAction login failed, clear session or cid", new Object[0]);
        i.a().c();
        com.igexin.push.core.m.a().c();
    }

    private void d() {
        try {
            if ((System.currentTimeMillis() - d.L) - 86400000 > 0) {
                com.igexin.b.a.c.b.a("LoginResultAction, over 24h, start get sdk cfg", new Object[0]);
                com.igexin.b.a.b.c.b().a(new com.igexin.push.f.a.c(new com.igexin.push.core.c.b(SDKUrlConfig.getConfigServiceUrl())), false, true);
            }
        } catch (Exception unused) {
        }
    }

    private void e() {
        if (!d.u.equals(d.v)) {
            d.v = d.u;
        }
    }

    private void f() {
        if (a.h(d.g)) {
            com.igexin.b.a.b.c.b().a(new n(this), false, true);
        }
    }

    public void a() {
        boolean z = (System.currentTimeMillis() - d.I) - 86400000 > 0;
        boolean z2 = !com.igexin.b.b.a.a(d.C, d.B);
        boolean equals = true ^ d.u.equals(d.v);
        com.igexin.b.a.c.b.a("LoginResultAction|isOverOneDay = " + z + ", isDeviceTokenDiff = " + z2 + ", isCidDiff = " + equals, new Object[0]);
        if (z || z2 || equals) {
            e.a().e();
        }
    }

    public boolean a(e eVar) {
        return false;
    }

    public boolean a(Object obj) {
        if (!(obj instanceof k)) {
            return true;
        }
        d.F = 0;
        if (d.n) {
            return true;
        }
        com.igexin.push.c.i.a().d().h();
        if (((k) obj).a) {
            b();
            return true;
        }
        c();
        return true;
    }
}
