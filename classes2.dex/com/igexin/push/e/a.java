package com.igexin.push.e;

import com.igexin.b.a.b.a.a.f;
import com.igexin.b.a.b.a.a.m;
import com.igexin.b.a.b.a.a.q;
import com.igexin.b.a.c.b;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.config.l;
import com.igexin.push.core.a.e;
import com.igexin.push.core.d;
import com.igexin.push.core.j;
import com.igexin.push.core.r;
import com.igexin.push.d.c.c;
import com.igexin.push.d.c.g;
import com.igexin.push.d.c.i;
import com.igexin.push.d.h;
import com.igexin.push.util.EncryptUtils;

public class a {
    private static String a = "com.igexin.push.e.a";
    private boolean b;

    private void b(boolean z) {
        b.a(a + "|call setActive, param active = " + z + "; this.active = " + this.b, new Object[0]);
        boolean z2 = this.b;
        if (z2 != z) {
            this.b = z;
            if (z) {
                b.a(a + "|active = true, start connect~~~~", new Object[0]);
                e();
                return;
            }
            b.a(a + "|active = false, disconnect...", new Object[0]);
            a(true);
        } else if (z2 && !d.n && d.F > 1500) {
            b.a(a + "|start active again, online = false, reset delay", new Object[0]);
            d.F = 0;
            d();
        }
    }

    public int a(String str, c cVar) {
        return a(str, cVar, false);
    }

    public int a(String str, c cVar, boolean z) {
        if (str == null || cVar == null) {
            return -1;
        }
        if (d.n || (cVar instanceof g) || (cVar instanceof i) || (cVar instanceof com.igexin.push.d.c.d)) {
            if (this.b) {
                if (z) {
                    int i = 10;
                    if (l.e > 0) {
                        i = l.e;
                    }
                    if (com.igexin.b.a.b.c.b().a(SDKUrlConfig.getCmAddress(), 3, com.igexin.push.core.c.a().h(), cVar, true, i, new h()) == null) {
                        return -2;
                    }
                } else if (com.igexin.b.a.b.c.b().a(SDKUrlConfig.getCmAddress(), 3, com.igexin.push.core.c.a().h(), cVar, true) == null) {
                    return -2;
                }
            }
            return 0;
        }
        b.a("networkLayer|sendData|not online|" + cVar.getClass().getName(), new Object[0]);
        return -3;
    }

    public void a(q qVar) {
        com.igexin.b.a.b.c b2;
        Object aVar;
        if (qVar == q.TCP_IO_EXCEPTION) {
            b2 = com.igexin.b.a.b.c.b();
            aVar = new com.igexin.push.d.b.b();
        } else if (qVar == q.TCP_DISCONNECT_SUCCESS) {
            b2 = com.igexin.b.a.b.c.b();
            aVar = new com.igexin.push.d.b.a();
        } else {
            return;
        }
        b2.a(aVar);
        com.igexin.b.a.b.c.b().c();
    }

    public void a(c cVar) {
        if (cVar != null) {
            e.a().a(cVar);
        }
    }

    public void a(boolean z) {
        b.a(a + "|call -> disconnect, reset delay = " + z, new Object[0]);
        if (z) {
            d.F = 0;
        }
        f.a().c();
    }

    public boolean a() {
        return this.b;
    }

    public void b() {
        boolean z = d.k;
        boolean a2 = com.igexin.push.util.a.a(System.currentTimeMillis());
        boolean b2 = com.igexin.push.util.a.b();
        b.a(a + "|start: isPushOn = " + z + " silentTime = " + a2 + " isBlockEndTime = " + b2, new Object[0]);
        if (z && !a2 && b2) {
            b(true);
        }
    }

    public void c() {
        b.a(a + "|stop by user", new Object[0]);
        b(false);
        if (d.n) {
            d.n = false;
            r.a().b();
        }
    }

    public void d() {
        d.F = com.igexin.push.d.b.a().c().a();
        com.igexin.push.f.b.f.i().j();
    }

    public void e() {
        b.a(a + "|call -> tryConnect and reset delay = 0", new Object[0]);
        a(true);
    }

    public void f() {
        com.igexin.push.c.i.a().d().c();
        com.igexin.push.c.a d = com.igexin.push.c.i.a().d();
        com.igexin.push.core.h.a().a(j.NETWORK_ERROR);
        d.i();
        if (h()) {
            b.a(a + "|sdkOn = false or pushOn = false, disconect|user", new Object[0]);
        } else {
            b.a(a + "|disconnect by network", new Object[0]);
        }
        com.igexin.b.a.b.c.b().a(m.class);
        a(false);
    }

    public void g() {
        com.igexin.push.d.a.b.b = -1;
        if (d.j) {
            b.a(a + "|isAppidWrong = true", new Object[0]);
            com.igexin.b.a.c.a.f.a().a("isAppidWrong = true");
        } else if (!EncryptUtils.isLoadSuccess()) {
            b.a(a + "|so error ++++++++", new Object[0]);
        } else if (d.at) {
            d();
        } else {
            b.a(a + "|initSuccess = false", new Object[0]);
        }
    }

    public boolean h() {
        return !d.k;
    }

    public void i() {
        com.igexin.push.core.h.a().a(j.NETWORK_SWITCH);
        boolean h = com.igexin.push.util.a.h();
        b.a(a + "|network changed, available = " + h + ", last = " + d.i, new Object[0]);
        com.igexin.push.d.b.a().b();
        if (!h) {
            b.a(a + "|network changed, available = false, do nothing", new Object[0]);
        } else if (!d.i) {
            b.a(a + "|network changed, try connect reset delay", new Object[0]);
            e();
        }
        if (h) {
            com.igexin.push.c.i.a().c();
        }
        d.i = h;
    }
}
