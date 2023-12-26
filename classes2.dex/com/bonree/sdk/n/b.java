package com.bonree.sdk.n;

import android.text.TextUtils;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b extends c {
    private static f c = com.bonree.sdk.be.a.a();
    private long A = 0;
    private int B = 0;
    private int C = 0;
    private a D = a.READY;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private long J = Thread.currentThread().getId();
    private String K = Thread.currentThread().getName();
    private String L;
    private String M = "";
    private String N = "";
    private List<String> O;
    private Map<String, String> P;
    private Map<String, String> Q;
    private boolean R;
    private long S = 0;
    private int T = 0;
    private boolean U = false;
    private String V;
    private String d;
    private String e;
    private String f;
    private String g;
    private int h;
    private long i = com.bonree.sdk.d.a.b();
    private long j = com.bonree.sdk.d.a.l();
    private long k = 0;
    private long l = 0;
    private long m = 0;
    private long n = 0;
    private long o = 0;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private int s = 0;
    private int t = 0;
    private int u = 0;
    private int v = 0;
    private int w = 0;
    private long x = 0;
    private long y = 0;
    private long z = 0;

    enum a {
        READY,
        SENT,
        COMPLETE,
        CLOSURE
    }

    public b() {
        f fVar = c;
        fVar.c("FrameData(): startTimeMs:" + this.i + "  eventStartMs:" + this.j + ad.a(), new Object[0]);
    }

    public final void a(String str) {
        if (this.O == null) {
            this.O = new ArrayList();
        }
        this.O.add(str);
    }

    public final List<String> a() {
        List<String> list = this.O;
        return list == null ? new ArrayList() : list;
    }

    public final long b() {
        return this.i;
    }

    public final long c() {
        return this.o;
    }

    private a Y() {
        return this.D;
    }

    public final String d() {
        return this.I;
    }

    public final void b(String str) {
        if (!h() || TextUtils.isEmpty(this.I)) {
            this.I = str;
        }
    }

    public final long e() {
        return this.l;
    }

    public final void a(long j2) {
        this.l = j2;
    }

    public final void c(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("x-via-maa-tls")) {
                    String[] split = str.split("://");
                    if (split.length > 0 && split[1].startsWith("x-via-maa-tls")) {
                        split[1] = split[1].replaceFirst("x-via-maa-tls", "");
                        StringBuilder sb = new StringBuilder();
                        for (int i2 = 0; i2 < split.length; i2++) {
                            if (i2 < split.length - 1) {
                                sb.append(split[i2]);
                                sb.append("://");
                            } else {
                                sb.append(split[i2]);
                            }
                        }
                        str = sb.toString();
                    }
                }
                if (TextUtils.isEmpty(this.e)) {
                    this.e = str;
                }
                this.d = str;
            }
        } catch (Throwable th) {
            c.e("seturl():" + th.toString(), new Object[0]);
        }
    }

    private String Z() {
        if (TextUtils.isEmpty(this.e)) {
            return "";
        }
        return this.e;
    }

    public final String f() {
        if (TextUtils.isEmpty(this.d)) {
            return "";
        }
        return this.d;
    }

    public final boolean g() {
        return this.D.ordinal() < a.SENT.ordinal();
    }

    public final boolean h() {
        return this.D.ordinal() >= a.COMPLETE.ordinal();
    }

    public final void a(int i2) {
        if (h() || this.B > 0) {
            f fVar = c;
            fVar.d("setStatusCode(...) called on TransactionState in " + this.D.toString() + " state  statusCode:" + i2, new Object[0]);
            return;
        }
        this.C = i2;
        this.B = i2;
    }

    public final int i() {
        return this.B;
    }

    public final void b(int i2) {
        if (h() || this.B > 0) {
            f fVar = c;
            fVar.d("setErrorCode(...) called on TransactionState in " + this.D.toString() + " state", new Object[0]);
            return;
        }
        this.C = 200;
        this.B = 200;
    }

    public final void a(int i2, int i3) {
        if (h() || this.B > 0) {
            f fVar = c;
            fVar.d("setErrorCode(...) called on TransactionState in " + this.D.toString() + " state", new Object[0]);
            return;
        }
        this.C = i2;
        this.B = i3;
    }

    public final String j() {
        return this.N;
    }

    public final void d(String str) {
        if (!h() && TextUtils.isEmpty(this.N)) {
            this.N = str;
        }
    }

    public final int k() {
        return this.C;
    }

    private long aa() {
        return this.x;
    }

    public final void b(long j2) {
        if (!h()) {
            this.x = j2;
            this.D = a.SENT;
        }
    }

    public final void c(long j2) {
        if (!p()) {
            this.y = j2;
        }
    }

    public final long l() {
        return this.z;
    }

    public final void d(long j2) {
        if (!h()) {
            this.z = j2;
        }
    }

    public final long m() {
        return this.y;
    }

    public final void n() {
        if (!h()) {
            this.D = a.COMPLETE;
            this.o = com.bonree.sdk.d.a.b();
        }
    }

    public final void o() {
        this.o = com.bonree.sdk.d.a.b();
    }

    public final boolean p() {
        return this.D.ordinal() >= a.CLOSURE.ordinal();
    }

    public final void q() {
        if (!p()) {
            this.D = a.CLOSURE;
        }
    }

    public final void r() {
        if (!p()) {
            this.D = a.CLOSURE;
            this.o = com.bonree.sdk.d.a.b();
        }
    }

    public final String s() {
        return this.M;
    }

    public final void e(String str) {
        this.M = str;
    }

    public final String t() {
        return this.E;
    }

    public final void f(String str) {
        this.E = str;
    }

    public final String u() {
        return this.G;
    }

    public final void g(String str) {
        this.G = str;
    }

    public final void e(long j2) {
        this.k = j2;
    }

    public final String v() {
        return this.H;
    }

    public final void h(String str) {
        this.H = str;
    }

    public final Map<String, String> w() {
        return this.Q;
    }

    public final void a(Map<String, String> map) {
        this.Q = map;
    }

    private boolean ab() {
        Map<String, String> map = this.Q;
        return map != null && map.size() > 0;
    }

    public final String x() {
        return this.f;
    }

    private void n(String str) {
        this.f = str;
    }

    public final int y() {
        return this.h;
    }

    private void k(int i2) {
        this.h = i2;
    }

    public final int z() {
        return this.p;
    }

    public final void c(int i2) {
        this.p = i2;
    }

    public final int A() {
        return this.q;
    }

    public final void d(int i2) {
        this.q = i2;
    }

    public final void e(int i2) {
        this.r = i2;
    }

    public final int B() {
        return this.r;
    }

    public final int C() {
        return this.s;
    }

    private void l(int i2) {
        this.s = i2;
    }

    public final int D() {
        return this.t;
    }

    public final void f(int i2) {
        this.t = i2;
    }

    public final int E() {
        return this.u;
    }

    public final void g(int i2) {
        this.u = i2;
    }

    public final int F() {
        return this.v;
    }

    public final void h(int i2) {
        this.v = i2;
    }

    public final long G() {
        return this.m;
    }

    public final void f(long j2) {
        this.m = j2;
    }

    public final long H() {
        return this.k;
    }

    public final long I() {
        return this.J;
    }

    public final void g(long j2) {
        this.J = j2;
    }

    public final int J() {
        return this.w;
    }

    private void m(int i2) {
        this.w = i2;
    }

    public final long K() {
        return this.A;
    }

    private void l(long j2) {
        this.A = j2;
    }

    public final String L() {
        return this.L;
    }

    public final void i(String str) {
        this.L = str;
    }

    public final long M() {
        return this.n;
    }

    public final void h(long j2) {
        this.n = j2;
    }

    public final Map<String, String> N() {
        return this.P;
    }

    public final void b(Map<String, String> map) {
        this.P = map;
    }

    public final Map<String, String> O() {
        return this.Q;
    }

    private void c(Map<String, String> map) {
        this.Q = map;
    }

    public final boolean P() {
        return this.R;
    }

    public final void a(boolean z2) {
        this.R = z2;
    }

    public final String Q() {
        return this.g;
    }

    public final void j(String str) {
        this.g = str;
    }

    public final long R() {
        return this.j;
    }

    public final void i(long j2) {
        this.j = j2;
    }

    public final String S() {
        return this.F;
    }

    public final void k(String str) {
        this.F = str;
    }

    public final long T() {
        return this.S;
    }

    public final void j(long j2) {
        this.S = j2;
    }

    public final void k(long j2) {
        this.i = j2;
    }

    public final int U() {
        return this.T;
    }

    public final void i(int i2) {
        this.T = 1;
    }

    public final boolean V() {
        return this.U;
    }

    public final void b(boolean z2) {
        this.U = true;
    }

    private String ac() {
        return this.V;
    }

    public final void l(String str) {
        this.V = str;
    }

    public final String toString() {
        return "FrameData{url='" + this.d + '\'' + ", loadUrl='" + this.e + '\'' + ", targetIp='" + this.f + '\'' + ", method='" + this.g + '\'' + ", targetPort=" + this.h + ", startTimeMs=" + this.i + ", eventStartMs=" + this.j + ", requestTimeMs=" + this.k + ", connectEndTimeMs=" + this.l + ", responseTimeMs=" + this.m + ", responseBodyTimeMs=" + this.n + ", endTimeMs=" + this.o + ", dnsElapseMs=" + this.p + ", connElapseMs=" + this.q + ", urlConnectionConnElapseMs=" + this.r + ", sslElapseMs=" + this.s + ", requestElapseMs=" + this.t + ", responseElapseMs=" + this.u + ", downloadElapseMs=" + this.v + ", socketDownloadElapseMs=" + this.w + ", sendBytes=" + this.x + ", receivedBytes=" + this.y + ", bodyLength=" + this.z + ", socketDownloadBytes=" + this.A + ", statusCode=" + this.B + ", errorCode=" + this.C + ", state=" + this.D + ", contentType='" + this.E + '\'' + ", requestBody='" + this.F + '\'' + ", protocolType='" + this.G + '\'' + ", requestHeader='" + this.H + '\'' + ", responseHeader='" + this.I + '\'' + ", threadId=" + this.J + ", threadName='" + this.K + '\'' + ", hostName='" + this.L + '\'' + ", RequestId='" + this.M + '\'' + ", message='" + this.N + '\'' + ", ipList=" + this.O + ", responseHeadersMap=" + this.P + ", requestHeadersMap=" + this.Q + ", isCache=" + this.R + ", uuid='" + this.b + '\'' + ", requestSize=" + this.S + ", source=" + this.T + ", needFilter=" + this.U + ", traceParent='" + this.V + '\'' + ", mErrorOccurrentProcess=" + this.a + '}';
    }
}
