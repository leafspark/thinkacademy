package com.igexin.b.a.d;

import com.igexin.b.a.d.a.c;
import com.igexin.b.a.d.a.d;
import com.igexin.b.a.d.a.f;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public abstract class e extends a {
    protected static f D;
    public Exception A;
    public Object B;
    public f C;
    protected final ReentrantLock E;
    protected final Condition F;
    Thread G;
    protected volatile boolean H;
    int I;
    protected c J;
    private byte a;
    protected volatile boolean j;
    protected volatile boolean k;
    protected volatile boolean m;
    protected volatile boolean n;
    protected volatile boolean o;
    protected volatile boolean p;
    protected volatile boolean q;
    protected volatile boolean r;
    protected volatile boolean s;
    protected volatile long t;
    volatile int u;
    public long v;
    public int w;
    public int x;
    public int y;
    public int z;

    public e(int i) {
        this(i, (c) null);
    }

    public e(int i, c cVar) {
        this.y = i;
        this.J = cVar;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.E = reentrantLock;
        this.F = reentrantLock.newCondition();
    }

    public final int a(long j2, TimeUnit timeUnit) {
        if (j2 > 0) {
            int a2 = D.k.a(this, j2, timeUnit);
            if (a2 == -2) {
                return -2;
            }
            if (a2 != -1) {
                return a2 != 1 ? 0 : 1;
            }
            this.t = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(j2, timeUnit);
            return -1;
        }
    }

    public long a(TimeUnit timeUnit) {
        return timeUnit.convert(o(), TimeUnit.MILLISECONDS);
    }

    public final void a(int i) {
        byte b = (byte) (this.a & 15);
        this.a = b;
        this.a = (byte) (((i & 15) << 4) | b);
    }

    public final void a(int i, f fVar) {
        if (i >= 0) {
            this.x = i;
            this.C = fVar;
            return;
        }
        throw new IllegalArgumentException("second must > 0");
    }

    public final void a(c cVar) {
        this.J = cVar;
    }

    public void b() {
        this.G = Thread.currentThread();
        this.o = true;
    }

    public void c() {
        if (this.j || this.k) {
            f();
        }
    }

    public final void c(long j2) {
        this.v = j2;
    }

    public void d() {
        this.r = true;
    }

    /* access modifiers changed from: protected */
    public abstract void e();

    /* access modifiers changed from: protected */
    public void e_() {
        if (!this.n && !this.p && !this.q) {
            this.j = true;
        } else if ((!this.p || this.j) && (!this.n || this.m || this.j)) {
            return;
        }
        this.o = false;
    }

    public void f() {
        this.B = null;
        this.A = null;
        this.G = null;
    }

    /* access modifiers changed from: protected */
    public void g() {
    }

    /* access modifiers changed from: package-private */
    public final void n() {
        int i = this.I + 1;
        this.I = i;
        this.I = i & 1090519038;
    }

    /* access modifiers changed from: package-private */
    public long o() {
        return this.t - System.currentTimeMillis();
    }

    public final void p() {
        this.j = true;
    }

    public final boolean q() {
        return this.m;
    }

    public final boolean r() {
        return this.k;
    }

    public final Thread s() {
        return this.G;
    }

    /* access modifiers changed from: protected */
    public void t() {
        c cVar = this.J;
        if (cVar != null) {
            cVar.a(d.a);
        }
    }
}
