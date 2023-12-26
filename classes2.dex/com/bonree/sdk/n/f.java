package com.bonree.sdk.n;

import android.text.TextUtils;
import com.bonree.sdk.agent.business.util.c;
import com.bonree.sdk.be.a;
import com.bonree.sdk.m.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class f extends c {
    private static com.bonree.sdk.be.f c = a.a();
    private int d;
    private int e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private int k;
    private int l;
    private String m;
    private String n;
    private int o;
    private int p;
    private int q;
    private long r;
    private final List<Long> s;
    private final List<Long> t;
    private String u;
    private boolean v;
    private String w;

    private f(f fVar) {
        this.d = 0;
        this.e = 0;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.k = 0;
        this.l = 0;
        this.m = "";
        this.n = "";
        this.o = -1;
        this.p = 200;
        this.q = 0;
        this.r = -1;
        this.u = "-1";
        this.v = false;
        this.w = "";
        this.d = fVar.d;
        this.e = fVar.e;
        this.f = fVar.f;
        this.g = fVar.g;
        this.h = fVar.h;
        this.i = fVar.i;
        this.j = fVar.j;
        this.k = fVar.k;
        this.l = fVar.l;
        this.m = fVar.m;
        this.n = fVar.n;
        this.o = fVar.o;
        this.p = fVar.p;
        this.q = fVar.q;
        this.r = fVar.r;
        this.s = fVar.s;
        this.t = fVar.t;
        this.u = fVar.u;
        this.v = fVar.v;
        this.w = fVar.w;
        this.a = fVar.a;
    }

    public f() {
        this.d = 0;
        this.e = 0;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.k = 0;
        this.l = 0;
        this.m = "";
        this.n = "";
        this.o = -1;
        this.p = 200;
        this.q = 0;
        this.r = -1;
        this.u = "-1";
        this.v = false;
        this.w = "";
        this.s = Collections.synchronizedList(new ArrayList());
        this.t = Collections.synchronizedList(new ArrayList());
    }

    public final int a() {
        return this.d;
    }

    private void t() {
        u();
    }

    public final void a(int i2) {
        this.o = i2;
    }

    public final void a(String str) {
        this.n = str;
    }

    public final void a(String str, int i2) {
        if (str != null) {
            com.bonree.sdk.be.f fVar = c;
            fVar.c(this.m + "      param:" + str, new Object[0]);
            this.m = str;
            if (this.d <= 0 && i2 > 0) {
                this.d = i2;
            }
        }
    }

    public final void b(String str) {
        if (str != null) {
            this.m = str;
        }
    }

    public final void a(long j2, int i2) {
        synchronized (this.s) {
            Long valueOf = Long.valueOf(Thread.currentThread().getId());
            if (!this.s.contains(valueOf)) {
                this.s.add(valueOf);
            }
        }
        v();
        this.h = j2;
        this.l = i2;
        u();
        this.v = false;
    }

    public final void a(long j2) {
        this.g = j2;
    }

    private void u() {
        if (!TextUtils.isEmpty(this.m) && g.a().b()) {
            g.a().notifyService((c) this);
        }
    }

    private void v() {
        this.l = 0;
        this.k = 0;
    }

    public final void b(long j2, int i2) {
        synchronized (this.s) {
            Long valueOf = Long.valueOf(Thread.currentThread().getId());
            if (!this.s.contains(valueOf)) {
                this.s.add(valueOf);
            }
        }
        v();
        this.f = j2;
        this.k = i2;
        u();
        this.v = true;
    }

    public final String b() {
        return this.m;
    }

    private void w() {
        this.m = null;
    }

    public final long c() {
        return this.i;
    }

    public final void b(long j2) {
        this.i = j2;
    }

    public final long d() {
        return this.j;
    }

    public final void c(long j2) {
        this.j = j2;
        if (j2 > 0) {
            long j3 = this.i;
            if (j3 > 0 && j2 > j3) {
                this.e = (int) (j2 - j3);
            }
        }
        u();
    }

    public final void a(Throwable th) {
        c(com.bonree.sdk.d.a.b());
        int a = c.a(th, (c) this);
        this.p = a;
        this.q = c.a(a, th);
        this.w = th.toString();
        u();
    }

    public final String e() {
        return this.w;
    }

    public final int f() {
        return this.p;
    }

    public final long g() {
        return this.f;
    }

    public final int h() {
        return this.l;
    }

    private void b(int i2) {
        this.l = i2;
    }

    public final int i() {
        return this.k;
    }

    public final long j() {
        return this.g;
    }

    public final long k() {
        return this.h;
    }

    public final long l() {
        return this.r;
    }

    public final void d(long j2) {
        this.s.add(Long.valueOf(j2));
        this.r = j2;
    }

    public final String m() {
        return this.u;
    }

    public final void c(String str) {
        this.u = str;
    }

    public final String n() {
        return this.n;
    }

    public final int o() {
        return this.o;
    }

    public final int p() {
        return this.q;
    }

    public final List<Long> q() {
        return this.s;
    }

    public final List<Long> r() {
        return this.t;
    }

    public final boolean s() {
        return this.v;
    }

    private void a(boolean z) {
        this.v = z;
    }

    public final String toString() {
        return "SocketData{sslElapseMs=" + this.d + ", connElapseMs=" + this.e + ", currentReceivedTimeMs=" + this.f + ", currentSendStartTimeUs=" + this.g + ", currentSendEndTimeUs=" + this.h + ", connStartTimeMs=" + this.i + ", connEndTimeMs=" + this.j + ", received=" + this.k + ", send=" + this.l + ", hostName='" + this.m + '\'' + ", ip='" + this.n + '\'' + ", port=" + this.o + ", errorId=" + this.p + ", subErrorId=" + this.q + ", threadId=" + this.r + ", threadIds=" + this.s + ", networkStartTimes=" + this.t + ", threadName='" + this.u + '\'' + ", flag=" + this.v + ", message='" + this.w + '\'' + '}';
    }

    public final void a(b bVar) {
        if (bVar != null) {
            bVar.i(this.m);
            synchronized (this.t) {
                if (this.t.size() > 30) {
                    this.t.remove(0);
                }
                this.t.add(Long.valueOf(bVar.b()));
            }
            v();
            u();
        }
    }
}
