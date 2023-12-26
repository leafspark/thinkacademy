package com.igexin.push.f.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.igexin.b.a.c.b;
import com.igexin.push.core.a.e;
import com.igexin.push.core.b.i;
import com.igexin.push.core.d;
import com.igexin.push.core.m;
import com.igexin.push.util.a;
import java.util.concurrent.TimeUnit;

public class f extends g {
    private static f a;
    private long b = System.currentTimeMillis();
    private long c = SystemClock.elapsedRealtime();

    private f() {
        super(1200000);
        this.n = true;
    }

    public static synchronized f i() {
        f fVar;
        synchronized (f.class) {
            if (a == null) {
                a = new f();
            }
            fVar = a;
        }
        return fVar;
    }

    public void a(long j) {
        this.c = j;
    }

    public void b(long j) {
        b.a("RTTask|refreshDelayTime, delay = " + j, new Object[0]);
        a(j, TimeUnit.MILLISECONDS);
    }

    public final int b_() {
        return -2147483641;
    }

    public void c() {
        super.c();
    }

    public void d() {
    }

    /* access modifiers changed from: protected */
    public void d_() {
        long j;
        e.a().k();
        boolean a2 = a.a(System.currentTimeMillis());
        boolean b2 = a.b();
        d.i = a.h();
        b.a("RTTask|networkAvailable = " + d.i + ",sdkOnline = " + d.n + ", " + "pushOn =" + d.k + ", isSilentTime= " + a2 + ", blockEndTime= " + b2, new Object[0]);
        if (!d.i || !d.k || d.n || a2 || !b2) {
            b.a("RTTask reconnect timer task stop, connect interval= 20min #######", new Object[0]);
            j = 1200000;
        } else if (a.i() || !TextUtils.isEmpty(d.u)) {
            b.a("RTTask reconnect timer task isOnline = false, try login...", new Object[0]);
            if (System.currentTimeMillis() - this.b < 2500) {
                d.q++;
            }
            if (d.q > 30 && ((double) Math.abs(SystemClock.elapsedRealtime() - this.c)) < 72000.0d) {
                i.a().d();
            }
            this.b = System.currentTimeMillis();
            m.a().b();
            j = 1800000;
        } else {
            d.G = 900000;
            a(900000, TimeUnit.MILLISECONDS);
            b.a("RTTask|date is error, set connect interval = 15min", new Object[0]);
            return;
        }
        d.G = j;
        a(j, TimeUnit.MILLISECONDS);
    }

    public void j() {
        b(d.F);
    }
}
