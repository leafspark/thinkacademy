package com.igexin.push.a.a;

import com.igexin.push.core.a.e;
import com.igexin.push.core.w;
import com.igexin.push.f.b.c;

public class b implements c {
    public static final String a = "com.igexin.push.a.a.b";
    private long b = 0;

    public void a() {
        com.igexin.b.a.c.b.a("start cron-keep task", new Object[0]);
        e.a().i();
        w.a().c();
        w.a().d();
        w.a().g();
        e.a().g();
        e.a().j();
    }

    public void a(long j) {
        this.b = j;
    }

    public boolean b() {
        return System.currentTimeMillis() - this.b > 3600000;
    }
}
