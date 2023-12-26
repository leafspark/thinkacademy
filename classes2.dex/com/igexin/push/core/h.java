package com.igexin.push.core;

import com.huawei.multimedia.audiokit.config.ResultCode;
import com.igexin.push.config.l;

public class h {
    private static h d;
    public long a = 240000;
    private k b = k.DETECT;
    private long c = 0;

    private h() {
    }

    public static h a() {
        if (d == null) {
            d = new h();
        }
        return d;
    }

    private void b(j jVar) {
        k kVar;
        int i = i.b[jVar.ordinal()];
        if (i == 1) {
            a(Math.min(this.a + 60000, 420000));
        } else if (i == 2 || i == 3) {
            long j = this.c + 1;
            this.c = j;
            if (j >= 2) {
                a(Math.max(this.a - 60000, 240000));
                kVar = k.STABLE;
                a(kVar);
            }
            return;
        } else if (i == 4) {
            a(240000);
        } else {
            return;
        }
        kVar = k.DETECT;
        a(kVar);
    }

    private void c(j jVar) {
        k kVar;
        int i = i.b[jVar.ordinal()];
        if (i == 1) {
            kVar = k.STABLE;
        } else if (i == 2 || i == 3) {
            a(Math.max(this.a - 60000, 240000));
            long j = this.c + 1;
            this.c = j;
            if (j >= 2) {
                a(240000);
                kVar = k.PENDING;
            } else {
                return;
            }
        } else if (i == 4) {
            a(240000);
            kVar = k.DETECT;
        } else {
            return;
        }
        a(kVar);
    }

    private void d(j jVar) {
        k kVar;
        int i = i.b[jVar.ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                kVar = k.PENDING;
                a(kVar);
            } else if (i != 4) {
                return;
            }
        }
        a(240000);
        kVar = k.DETECT;
        a(kVar);
    }

    public void a(long j) {
        this.a = j;
    }

    public void a(j jVar) {
        int i = i.a[this.b.ordinal()];
        if (i == 1) {
            b(jVar);
        } else if (i == 2) {
            c(jVar);
        } else if (i == 3) {
            d(jVar);
        }
    }

    public void a(k kVar) {
        this.b = kVar;
        this.c = 0;
    }

    public long b() {
        long j = this.a;
        if (l.d > 0) {
            j = (long) (l.d * ResultCode.KARAOKE_SUCCESS);
        }
        if (d.i && d.n && c.a().i().a()) {
            return j;
        }
        return 3600000;
    }
}
