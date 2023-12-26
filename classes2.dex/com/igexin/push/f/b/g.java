package com.igexin.push.f.b;

import com.igexin.b.a.d.e;
import java.util.concurrent.TimeUnit;

public abstract class g extends e {
    long d;

    public g(long j) {
        this(0, j);
    }

    public g(long j, long j2) {
        super(5);
        j2 = j > 0 ? j2 + (j - System.currentTimeMillis()) : j2;
        this.d = j2;
        a(j2, TimeUnit.MILLISECONDS);
    }

    public final void b() {
        super.b();
        d_();
    }

    /* access modifiers changed from: protected */
    public abstract void d_();

    /* access modifiers changed from: protected */
    public void e() {
    }
}
