package com.bonree.sdk.m;

import com.bonree.sdk.be.g;
import com.bonree.sdk.d.a;
import com.bonree.sdk.l.b;
import com.bonree.sdk.n.f;
import com.squareup.okhttp.Request;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class n {
    private String a;
    private String b;
    private int c;
    private long d;
    private long e;
    private long f;
    private int g;
    private long h;
    private long i;
    private long j;
    private long k;
    private int l;
    private int m;
    private int n;
    private int o;
    private String p;
    private int q;
    private String r;
    private List<b> s;
    private List<a.b> t;
    private boolean u;
    private List<Long> v;
    private List<Long> w;
    private long x;

    public n() {
    }

    private static void b(Request request, String str, String str2) throws Exception {
        Field declaredField = request.getClass().getDeclaredField("headers");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(request);
        if (obj != null) {
            Field declaredField2 = obj.getClass().getDeclaredField("namesAndValues");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 instanceof String[]) {
                ArrayList arrayList = new ArrayList(Arrays.asList((String[]) obj2));
                int indexOf = arrayList.indexOf(str);
                if (indexOf < 0) {
                    arrayList.add(str);
                    arrayList.add(str2);
                } else {
                    arrayList.set(indexOf + 1, str2);
                }
                declaredField2.set(obj, (String[]) arrayList.toArray(new String[0]));
            }
        }
    }

    public static void a(Request request, String str, String str2) {
        try {
            Field declaredField = request.getClass().getDeclaredField("headers");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(request);
            if (obj != null) {
                Field declaredField2 = obj.getClass().getDeclaredField("namesAndValues");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                if (obj2 instanceof String[]) {
                    ArrayList arrayList = new ArrayList(Arrays.asList((String[]) obj2));
                    int indexOf = arrayList.indexOf(str);
                    if (indexOf < 0) {
                        arrayList.add(str);
                        arrayList.add(str2);
                    } else {
                        arrayList.set(indexOf + 1, str2);
                    }
                    declaredField2.set(obj, (String[]) arrayList.toArray(new String[0]));
                }
            }
        } catch (Throwable th) {
            g.b("OkHttp3 Exception addHeader error:" + th);
        }
    }

    public n(f fVar) {
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = 0;
        this.m = 0;
        this.u = false;
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

    public n(n nVar) {
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = 0;
        this.m = 0;
        this.u = false;
        this.b = nVar.u();
        this.a = nVar.f();
        this.c = nVar.s();
        this.n = nVar.o();
        this.o = nVar.p();
        this.p = nVar.d();
        this.q = nVar.c();
        this.r = nVar.q();
    }

    public void a(long j2, long j3, long j4, long j5, int i2, int i3, int i4, long j6, long j7) {
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

    public void a(f fVar) {
        if (fVar.h() > 0) {
            this.l += fVar.h();
            a(new b(fVar.h(), fVar.j(), fVar.k()));
        }
        if (fVar.i() > 0) {
            this.m += fVar.i();
            a(new a.b(fVar.i(), fVar.g(), fVar.s()));
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

    public void a(b bVar) {
        if (this.s == null) {
            this.s = Collections.synchronizedList(new ArrayList());
        }
        this.s.add(bVar);
    }

    public void a(a.b bVar) {
        if (this.t == null) {
            this.t = Collections.synchronizedList(new ArrayList());
        }
        this.t.add(bVar);
    }

    public List<b> a() {
        return this.s;
    }

    public List<a.b> b() {
        return this.t;
    }

    public int c() {
        return this.q;
    }

    public void a(int i2) {
        this.q = i2;
    }

    public String d() {
        return this.p;
    }

    public long e() {
        return this.f;
    }

    public void a(long j2) {
        this.f = j2;
    }

    public String f() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public long g() {
        return this.d;
    }

    public void b(long j2) {
        this.d = j2;
    }

    public long h() {
        return this.e;
    }

    public void c(long j2) {
        this.e = j2;
    }

    public long i() {
        return this.h;
    }

    public void d(long j2) {
        this.h = j2;
    }

    public long j() {
        return this.i;
    }

    public void e(long j2) {
        this.i = j2;
    }

    public long k() {
        return this.j;
    }

    public void f(long j2) {
        this.j = j2;
    }

    public long l() {
        return this.k;
    }

    public void g(long j2) {
        this.k = j2;
    }

    public int m() {
        return this.l;
    }

    public void b(int i2) {
        this.l = i2;
    }

    public int n() {
        return this.m;
    }

    public void c(int i2) {
        this.m = i2;
    }

    public int o() {
        return this.n;
    }

    public void d(int i2) {
        this.n = i2;
    }

    public int p() {
        return this.o;
    }

    public void e(int i2) {
        this.o = i2;
    }

    public String q() {
        return this.r;
    }

    public void b(String str) {
        this.r = str;
    }

    public boolean r() {
        return this.u;
    }

    public void a(boolean z) {
        this.u = z;
    }

    public int s() {
        return this.c;
    }

    public void f(int i2) {
        this.c = i2;
    }

    public int t() {
        return this.g;
    }

    public void g(int i2) {
        this.g = i2;
    }

    public String u() {
        return this.b;
    }

    public void c(String str) {
        this.b = str;
    }

    public List<Long> v() {
        return this.v;
    }

    public long w() {
        return this.x;
    }

    public List<Long> x() {
        return this.w;
    }

    public String toString() {
        return "SocketSerializeData{hostName='" + this.a + '\'' + ", ip='" + this.b + '\'' + ", port=" + this.c + ", connStartTimeMs=" + this.d + ", connEndTimeMs=" + this.e + ", sslElapseMs=" + this.f + ", responseElapseMs=" + this.g + ", firstSendStartTimeMs=" + this.h + ", lastSendEndTimeMs=" + this.i + ", firstReceivedEndTimeMs=" + this.j + ", lastReceivedEndTimeMs=" + this.k + ", sendBytes=" + this.l + ", receivedBytes=" + this.m + ", errorId=" + this.n + ", subErrorId=" + this.o + ", threadName='" + this.r + '\'' + ", socketSendPacketDataList=" + this.s + ", socketReceivePacketDataList=" + this.t + ", flag=" + this.u + ", threadIds=" + this.v + ", networkStartTimes=" + this.w + ", lastSetTimeMs=" + this.x + '}';
    }
}
