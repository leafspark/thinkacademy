package com.igexin.push.f.b;

import com.igexin.b.a.b.c;
import com.igexin.b.a.c.b;
import com.igexin.push.config.l;
import com.igexin.push.util.a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class d extends g {
    private long a = l.u;
    private AtomicBoolean b = new AtomicBoolean(false);

    public d() {
        super(604800000);
        this.n = true;
    }

    private void a(long j) {
        a(j, TimeUnit.MILLISECONDS);
    }

    public static d i() {
        return e.a;
    }

    public int b_() {
        return 20160629;
    }

    /* access modifiers changed from: protected */
    public void d_() {
        a(this.a, TimeUnit.MILLISECONDS);
        boolean a2 = a.a(System.currentTimeMillis());
        if (!com.igexin.push.core.d.n && com.igexin.push.core.d.i && com.igexin.push.core.d.k && !a2 && a.b()) {
            b.a("PollingTimerTask|run = true", new Object[0]);
            com.igexin.push.d.b.a().g();
            com.igexin.push.core.d.F = 100;
            f.i().j();
        }
    }

    public void j() {
        if (!this.b.get()) {
            c.b().a(this, false, true);
            this.b.set(true);
        }
        a(this.a);
    }

    public void k() {
        a(604800000, TimeUnit.MILLISECONDS);
    }
}
