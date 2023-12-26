package com.bonree.sdk.bc;

import java.util.ArrayList;
import java.util.List;

public final class cq {
    private static int a = 0;
    private static int b = 1;
    private static int c = 2;
    private static int d = 3;
    private static int e = 4;
    private static int f = 5;
    private static int g = 6;
    private static final cq h = new cq(0);
    private static final cq i = new cq(1);
    private static final cq j = new cq(2);
    private int k;
    private Object l;

    private cq() {
    }

    cq(int i2, bx bxVar) {
        if (i2 < 0 || i2 > 6) {
            throw new IllegalArgumentException("invalid type");
        }
        this.k = i2;
        this.l = bxVar;
    }

    cq(int i2) {
        if (i2 < 0 || i2 > 6) {
            throw new IllegalArgumentException("invalid type");
        }
        this.k = i2;
        this.l = null;
    }

    static cq a(int i2) {
        switch (i2) {
            case 0:
                return h;
            case 1:
                return i;
            case 2:
                return j;
            case 3:
            case 4:
            case 5:
            case 6:
                cq cqVar = new cq();
                cqVar.k = i2;
                cqVar.l = null;
                return cqVar;
            default:
                throw new IllegalArgumentException("invalid type");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(bx bxVar) {
        if (this.l == null) {
            this.l = new ArrayList();
        }
        ((List) this.l).add(bxVar);
    }

    private boolean j() {
        return this.k == 0;
    }

    public final boolean a() {
        return this.k == 1;
    }

    public final boolean b() {
        return this.k == 2;
    }

    public final boolean c() {
        return this.k == 3;
    }

    public final boolean d() {
        return this.k == 4;
    }

    public final boolean e() {
        return this.k == 5;
    }

    public final boolean f() {
        return this.k == 6;
    }

    public final bx[] g() {
        if (this.k != 6) {
            return null;
        }
        List list = (List) this.l;
        return (bx[]) list.toArray(new bx[list.size()]);
    }

    public final i h() {
        return (i) ((bx) this.l).i();
    }

    public final s i() {
        return (s) ((bx) this.l).i();
    }

    private bx k() {
        return (bx) this.l;
    }

    public final String toString() {
        switch (this.k) {
            case 0:
                return "unknown";
            case 1:
                return "NXDOMAIN";
            case 2:
                return "NXRRSET";
            case 3:
                return "delegation: " + this.l;
            case 4:
                return "CNAME: " + this.l;
            case 5:
                return "DNAME: " + this.l;
            case 6:
                return "successful";
            default:
                throw new IllegalStateException();
        }
    }
}
