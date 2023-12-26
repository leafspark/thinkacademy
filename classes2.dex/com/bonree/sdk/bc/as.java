package com.bonree.sdk.bc;

import com.bonree.sdk.af.a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class as {
    private static final bn[] C = new bn[0];
    private static int D = 0;
    private static int E = 1;
    private static int F = 2;
    private static int G = 3;
    private static int H = 4;
    private static cd a;
    private static bn[] b;
    private static Map c;
    private static int d;
    private boolean A;
    private boolean B;
    private cd e;
    private bn[] f;
    private j g;
    private boolean h;
    private int i;
    private bn j;
    private int k;
    private int l;
    private boolean m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private List r;
    private ca[] s;
    private int t;
    private String u;
    private boolean v;
    private boolean w;
    private String x;
    private boolean y;
    private boolean z;

    static {
        c();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        throw new java.lang.RuntimeException("Failed to initialize resolver");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0029 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void c() {
        /*
            java.lang.Class<com.bonree.sdk.bc.as> r0 = com.bonree.sdk.bc.as.class
            monitor-enter(r0)
            com.bonree.sdk.bc.ab r1 = new com.bonree.sdk.bc.ab     // Catch:{ UnknownHostException -> 0x0029 }
            r1.<init>()     // Catch:{ UnknownHostException -> 0x0029 }
            a = r1     // Catch:{ UnknownHostException -> 0x0029 }
            com.bonree.sdk.bc.ce r1 = com.bonree.sdk.bc.ce.e()     // Catch:{ all -> 0x0027 }
            com.bonree.sdk.bc.bn[] r1 = r1.c()     // Catch:{ all -> 0x0027 }
            b = r1     // Catch:{ all -> 0x0027 }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0027 }
            r1.<init>()     // Catch:{ all -> 0x0027 }
            c = r1     // Catch:{ all -> 0x0027 }
            com.bonree.sdk.bc.ce r1 = com.bonree.sdk.bc.ce.e()     // Catch:{ all -> 0x0027 }
            int r1 = r1.d()     // Catch:{ all -> 0x0027 }
            d = r1     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)
            return
        L_0x0027:
            r1 = move-exception
            goto L_0x0031
        L_0x0029:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0027 }
            java.lang.String r2 = "Failed to initialize resolver"
            r1.<init>(r2)     // Catch:{ all -> 0x0027 }
            throw r1     // Catch:{ all -> 0x0027 }
        L_0x0031:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.as.c():void");
    }

    private static synchronized cd d() {
        cd cdVar;
        synchronized (as.class) {
            cdVar = a;
        }
        return cdVar;
    }

    private static synchronized void a(cd cdVar) {
        synchronized (as.class) {
            a = cdVar;
        }
    }

    private static synchronized j a(int i2) {
        j jVar;
        synchronized (as.class) {
            p.a(i2);
            jVar = (j) c.get(bc.c(i2));
            if (jVar == null) {
                jVar = new j(i2);
                c.put(bc.c(i2), jVar);
            }
        }
        return jVar;
    }

    private static synchronized void a(j jVar, int i2) {
        synchronized (as.class) {
            p.a(i2);
            c.put(bc.c(i2), jVar);
        }
    }

    private static synchronized bn[] e() {
        bn[] bnVarArr;
        synchronized (as.class) {
            bnVarArr = b;
        }
        return bnVarArr;
    }

    private static synchronized void a(bn[] bnVarArr) {
        synchronized (as.class) {
            b = bnVarArr;
        }
    }

    private static synchronized void a(String[] strArr) throws dc {
        synchronized (as.class) {
            if (strArr == null) {
                b = null;
                return;
            }
            bn[] bnVarArr = new bn[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                bnVarArr[i2] = bn.a(strArr[i2], bn.a);
            }
            b = bnVarArr;
        }
    }

    private static synchronized void a(a.C0004a aVar) {
        synchronized (as.class) {
        }
    }

    private final void f() {
        this.n = 0;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = null;
        this.s = null;
        this.t = -1;
        this.u = null;
        this.v = false;
        this.w = false;
        this.x = null;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
        if (this.h) {
            this.g.a();
        }
    }

    private as(bn bnVar, int i2, int i3) {
        df.a(i2);
        p.a(i3);
        if (df.d(i2) || i2 == 255) {
            this.j = bnVar;
            this.k = i2;
            this.l = i3;
            synchronized (as.class) {
                this.e = d();
                this.f = e();
                this.g = a(i3);
            }
            this.i = 3;
            this.m = br.a("verbose");
            this.t = -1;
            return;
        }
        throw new IllegalArgumentException("Cannot query for meta-types other than ANY");
    }

    public as(bn bnVar, int i2) {
        this(bnVar, 12, 1);
    }

    private as(bn bnVar) {
        this(bnVar, 1, 1);
    }

    private as(String str, int i2, int i3) throws dc {
        this(bn.a(str), i2, i3);
    }

    public as(String str, int i2) throws dc {
        this(bn.a(str), i2, 1);
    }

    private as(String str) throws dc {
        this(bn.a(str), 1, 1);
    }

    private void b(cd cdVar) {
        this.e = cdVar;
    }

    private void b(bn[] bnVarArr) {
        this.f = bnVarArr;
    }

    private void b(String[] strArr) throws dc {
        if (strArr == null) {
            this.f = null;
            return;
        }
        bn[] bnVarArr = new bn[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bnVarArr[i2] = bn.a(strArr[i2], bn.a);
        }
        this.f = bnVarArr;
    }

    private void a(j jVar) {
        if (jVar == null) {
            this.g = new j(this.l);
            this.h = true;
            return;
        }
        this.g = jVar;
        this.h = false;
    }

    private static void b(int i2) {
        if (i2 >= 0) {
            d = i2;
            return;
        }
        throw new IllegalArgumentException("Illegal ndots value: " + i2);
    }

    private void c(int i2) {
        this.i = i2;
    }

    private void a(bn bnVar, bn bnVar2) {
        this.o = true;
        this.w = false;
        this.y = false;
        this.z = false;
        this.v = false;
        this.B = false;
        int i2 = this.n + 1;
        this.n = i2;
        if (i2 >= 6 || bnVar.equals(bnVar2)) {
            this.t = 1;
            this.u = "CNAME loop";
            this.p = true;
            return;
        }
        if (this.r == null) {
            this.r = new ArrayList();
        }
        this.r.add(bnVar2);
        a(bnVar);
    }

    private void a(bn bnVar, cq cqVar) {
        if (cqVar.f()) {
            bx[] g2 = cqVar.g();
            ArrayList arrayList = new ArrayList();
            for (bx c2 : g2) {
                Iterator c3 = c2.c();
                while (c3.hasNext()) {
                    arrayList.add(c3.next());
                }
            }
            this.t = 0;
            this.s = (ca[]) arrayList.toArray(new ca[arrayList.size()]);
            this.p = true;
        } else if (cqVar.a()) {
            this.v = true;
            this.q = true;
            if (this.n > 0) {
                this.t = 3;
                this.p = true;
            }
        } else if (cqVar.b()) {
            this.t = 4;
            this.s = null;
            this.p = true;
        } else if (cqVar.d()) {
            a(cqVar.h().d_(), bnVar);
        } else if (cqVar.e()) {
            try {
                a(bnVar.a(cqVar.i()), bnVar);
            } catch (bo unused) {
                this.t = 1;
                this.u = "Invalid DNAME target";
                this.p = true;
            }
        } else if (cqVar.c()) {
            this.B = true;
        }
    }

    private void a(bn bnVar) {
        cq a2 = this.g.a(bnVar, this.k, this.i);
        if (this.m) {
            PrintStream printStream = System.err;
            printStream.println("lookup " + bnVar + " " + df.b(this.k));
            System.err.println(a2);
        }
        a(bnVar, a2);
        if (!this.p && !this.q) {
            try {
                bb a3 = this.e.a(bb.a(ca.a(bnVar, this.k, this.l)));
                int c2 = a3.a().c();
                if (c2 == 0 || c2 == 3) {
                    cq a4 = this.g.a(a3);
                    if (a4 == null) {
                        a4 = this.g.a(bnVar, this.k, this.i);
                    }
                    if (this.m) {
                        PrintStream printStream2 = System.err;
                        printStream2.println("queried " + bnVar + " " + df.b(this.k));
                        System.err.println(a4);
                    }
                    a(bnVar, a4);
                    return;
                }
                this.w = true;
                this.x = bz.a(c2);
            } catch (IOException e2) {
                if (e2 instanceof InterruptedIOException) {
                    this.z = true;
                } else {
                    this.y = true;
                }
            }
        }
    }

    private void b(bn bnVar, bn bnVar2) {
        this.q = false;
        if (bnVar2 != null) {
            try {
                bnVar = bn.a(bnVar, bnVar2);
            } catch (bo unused) {
                this.A = true;
                return;
            }
        }
        a(bnVar);
    }

    public final ca[] a() {
        int i2 = 0;
        if (this.p) {
            this.n = 0;
            this.o = false;
            this.p = false;
            this.q = false;
            this.r = null;
            this.s = null;
            this.t = -1;
            this.u = null;
            this.v = false;
            this.w = false;
            this.x = null;
            this.y = false;
            this.z = false;
            this.A = false;
            this.B = false;
            if (this.h) {
                this.g.a();
            }
        }
        if (!this.j.b()) {
            if (this.f != null) {
                if (this.j.d() > d) {
                    b(this.j, bn.a);
                }
                if (!this.p) {
                    while (true) {
                        bn[] bnVarArr = this.f;
                        if (i2 >= bnVarArr.length) {
                            break;
                        }
                        b(this.j, bnVarArr[i2]);
                        if (!this.p) {
                            if (this.o) {
                                break;
                            }
                            i2++;
                        } else {
                            return this.s;
                        }
                    }
                } else {
                    return this.s;
                }
            } else {
                b(this.j, bn.a);
            }
        } else {
            b(this.j, (bn) null);
        }
        if (!this.p) {
            if (this.w) {
                this.t = 2;
                this.u = this.x;
                this.p = true;
            } else if (this.z) {
                this.t = 2;
                this.u = "timed out";
                this.p = true;
            } else if (this.y) {
                this.t = 2;
                this.u = "network error";
                this.p = true;
            } else if (this.v) {
                this.t = 3;
                this.p = true;
            } else if (this.B) {
                this.t = 1;
                this.u = "referral";
                this.p = true;
            } else if (this.A) {
                this.t = 1;
                this.u = "name too long";
                this.p = true;
            }
        }
        return this.s;
    }

    private void g() {
        if (!this.p || this.t == -1) {
            StringBuffer stringBuffer = new StringBuffer("Lookup of " + this.j + " ");
            if (this.l != 1) {
                stringBuffer.append(p.b(this.l) + " ");
            }
            stringBuffer.append(df.b(this.k) + " isn't done");
            throw new IllegalStateException(stringBuffer.toString());
        }
    }

    private ca[] h() {
        g();
        return this.s;
    }

    private bn[] i() {
        g();
        List list = this.r;
        if (list == null) {
            return C;
        }
        return (bn[]) list.toArray(new bn[list.size()]);
    }

    public final int b() {
        g();
        return this.t;
    }

    private String j() {
        g();
        String str = this.u;
        if (str != null) {
            return str;
        }
        int i2 = this.t;
        if (i2 == 0) {
            return "successful";
        }
        if (i2 == 1) {
            return "unrecoverable error";
        }
        if (i2 == 2) {
            return "try again";
        }
        if (i2 == 3) {
            return "host not found";
        }
        if (i2 == 4) {
            return "type not found";
        }
        throw new IllegalStateException("unknown result");
    }
}
