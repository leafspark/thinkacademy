package com.bonree.sdk.n;

import com.bonree.sdk.d.a;
import com.bonree.sdk.l.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class j {
    private String a;
    private String b;
    private int c;
    private long d;
    private long e;
    private long f;
    private int g;
    private long h = -1;
    private long i = -1;
    private long j = -1;
    private long k = -1;
    private int l = 0;
    private int m = 0;
    private int n;
    private int o;
    private String p;
    private int q;
    private String r;
    private List<b> s;
    private List<a.b> t;
    private boolean u = false;
    private List<Long> v;
    private List<Long> w;
    private long x;

    public j(f fVar) {
        this.b = fVar.n();
        this.a = fVar.b();
        this.c = fVar.o();
        this.d = fVar.c();
        this.e = fVar.d();
        this.f = (long) fVar.a();
        this.n = fVar.f();
        this.o = fVar.p();
        this.p = fVar.e();
        this.q = fVar.a;
        this.r = fVar.m();
        this.v = fVar.q();
    }

    public j(j jVar) {
        this.b = jVar.b;
        this.a = jVar.a;
        this.c = jVar.c;
        this.n = jVar.n;
        this.o = jVar.o;
        this.p = jVar.p;
        this.q = jVar.q;
        this.r = jVar.r;
    }

    public final void a(long j2, long j3, long j4, long j5, int i2, int i3, int i4, long j6, long j7) {
        long j8 = j2;
        long j9 = j3;
        long j10 = j4;
        long j11 = j5;
        if (j8 > 0) {
            this.h = j8;
        }
        if (j9 > 0) {
            this.i = j9;
        }
        if (j10 > 0) {
            this.j = j10;
        }
        if (j11 > 0) {
            this.k = j11;
        }
        this.l = i2;
        this.m = i3;
        this.f = (long) i4;
        this.d = j6;
        this.e = j7;
    }

    public final void a(f fVar) {
        if (fVar.h() > 0) {
            this.l += fVar.h();
            i iVar = new i(fVar.h(), fVar.j(), fVar.k());
            if (this.s == null) {
                this.s = Collections.synchronizedList(new ArrayList());
            }
            this.s.add(iVar);
        }
        if (fVar.i() > 0) {
            this.m += fVar.i();
            g gVar = new g(fVar.i(), fVar.g(), fVar.s());
            if (this.t == null) {
                this.t = Collections.synchronizedList(new ArrayList());
            }
            this.t.add(gVar);
        }
        List<Long> q2 = fVar.q();
        if (q2 != null && !q2.isEmpty()) {
            this.v = q2;
        }
        List<Long> r2 = fVar.r();
        if (r2 != null && !r2.isEmpty()) {
            this.w = r2;
        }
        this.x = a.b();
        this.a = fVar.b();
        this.n = fVar.f();
        this.o = fVar.p();
        this.f = (long) fVar.a();
        this.q = fVar.a;
        this.p = fVar.e();
    }

    public final void a(i iVar) {
        if (this.s == null) {
            this.s = Collections.synchronizedList(new ArrayList());
        }
        this.s.add(iVar);
    }

    public final void a(g gVar) {
        if (this.t == null) {
            this.t = Collections.synchronizedList(new ArrayList());
        }
        this.t.add(gVar);
    }

    public final List<b> a() {
        return this.s;
    }

    public final List<a.b> b() {
        return this.t;
    }

    public final int c() {
        return this.q;
    }

    public final void a(int i2) {
        this.q = i2;
    }

    public final String d() {
        return this.p;
    }

    public final long e() {
        return this.f;
    }

    public final void a(long j2) {
        this.f = j2;
    }

    public final String f() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final long g() {
        return this.d;
    }

    public final void b(long j2) {
        this.d = j2;
    }

    public final long h() {
        return this.e;
    }

    public final void c(long j2) {
        this.e = j2;
    }

    public final long i() {
        return this.h;
    }

    public final void d(long j2) {
        this.h = j2;
    }

    public final long j() {
        return this.i;
    }

    public final void e(long j2) {
        this.i = j2;
    }

    public final long k() {
        return this.j;
    }

    public final void f(long j2) {
        this.j = j2;
    }

    public final long l() {
        return this.k;
    }

    public final void g(long j2) {
        this.k = j2;
    }

    public final int m() {
        return this.l;
    }

    public final void b(int i2) {
        this.l = i2;
    }

    public final int n() {
        return this.m;
    }

    public final void c(int i2) {
        this.m = i2;
    }

    public final int o() {
        return this.n;
    }

    public final void d(int i2) {
        this.n = i2;
    }

    public final int p() {
        return this.o;
    }

    public final void e(int i2) {
        this.o = i2;
    }

    public final String q() {
        return this.r;
    }

    public final void b(String str) {
        this.r = str;
    }

    public final boolean r() {
        return this.u;
    }

    public final void a(boolean z) {
        this.u = z;
    }

    public final int s() {
        return this.c;
    }

    public final void f(int i2) {
        this.c = i2;
    }

    public final int t() {
        return this.g;
    }

    public final void g(int i2) {
        this.g = i2;
    }

    public final String u() {
        return this.b;
    }

    public final void c(String str) {
        this.b = str;
    }

    public final List<Long> v() {
        return this.v;
    }

    public final long w() {
        return this.x;
    }

    public final List<Long> x() {
        return this.w;
    }

    public final String toString() {
        return "SocketSerializeData{hostName='" + this.a + '\'' + ", ip='" + this.b + '\'' + ", port=" + this.c + ", connStartTimeMs=" + this.d + ", connEndTimeMs=" + this.e + ", sslElapseMs=" + this.f + ", responseElapseMs=" + this.g + ", firstSendStartTimeMs=" + this.h + ", lastSendEndTimeMs=" + this.i + ", firstReceivedEndTimeMs=" + this.j + ", lastReceivedEndTimeMs=" + this.k + ", sendBytes=" + this.l + ", receivedBytes=" + this.m + ", errorId=" + this.n + ", subErrorId=" + this.o + ", threadName='" + this.r + '\'' + ", socketSendPacketDataList=" + this.s + ", socketReceivePacketDataList=" + this.t + ", flag=" + this.u + ", threadIds=" + this.v + ", networkStartTimes=" + this.w + ", lastSetTimeMs=" + this.x + '}';
    }
}
