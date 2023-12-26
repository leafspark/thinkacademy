package com.igexin.push.c;

import com.igexin.b.a.b.c;
import com.igexin.b.a.c.b;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.util.a;
import java.util.List;

public class i {
    private static final String a = ("DT_" + i.class.getName());
    private static i b;
    private static h c;

    private i() {
        c = a.c() ? h.WIFI : h.MOBILE;
    }

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (b == null) {
                b = new i();
            }
            iVar = b;
        }
        return iVar;
    }

    public void b() {
        if (!SDKUrlConfig.hasMultipleXfr()) {
            b.a(a + "|xfr len = 1, detect = false", new Object[0]);
            return;
        }
        c.b().a(m.c_(), false, true);
    }

    public void c() {
        if (SDKUrlConfig.hasMultipleXfr()) {
            try {
                f().d();
            } catch (Throwable th) {
                b.a(a + "|" + th.toString(), new Object[0]);
            }
        }
    }

    public a d() {
        return f().d;
    }

    public void e() {
        if (!SDKUrlConfig.hasMultipleXfr()) {
            k.a();
            m.c_().h();
            try {
                n.a().d.a((List<e>) null);
                s.a().d.a((List<e>) null);
                s.a().g();
                n.a().g();
                s.a().i();
            } catch (Throwable th) {
                b.a(a + "|" + th.toString(), new Object[0]);
            }
        } else {
            try {
                s.a().i();
                s.a().f();
                n.a().f();
                o f = f();
                if (f != null) {
                    f.h();
                }
            } catch (Throwable th2) {
                b.a(a + "|" + th2.toString(), new Object[0]);
            }
        }
    }

    public synchronized o f() {
        o a2;
        a2 = a.c() ? s.a() : n.a();
        h b2 = a2.b();
        if (b2 != c) {
            if (b2 == h.WIFI) {
                n.a().e();
            } else if (b2 == h.MOBILE) {
                s.a().e();
            }
        }
        c = b2;
        return a2;
    }
}
