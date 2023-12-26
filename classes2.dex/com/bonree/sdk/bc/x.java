package com.bonree.sdk.bc;

import com.bonree.sdk.ac.e;
import java.io.IOException;

public final class x extends ca {
    private static int a = 1;
    private static int b = 2;
    private static int c = 3;
    private static int d = 4;
    private static final long e = -9001819329700081493L;
    private int j;
    private int k;
    private int l;
    private byte[] m;

    public static class a {
        private static int a = 1;
        private static int b = 2;
        private static int c = 3;
        private static int d = 4;
        private String e;
        private int f;
        private int g;
        private int h;

        private a() {
        }

        public a(String str) throws Exception {
            this.e = str;
            String[] split = str.split("/")[1].split("\\.");
            this.f = Integer.valueOf(split[0]).intValue();
            this.g = Integer.valueOf(split[1]).intValue();
            this.h = Integer.valueOf(split[2]).intValue();
        }

        private void d() throws Exception {
            String[] split = this.e.split("/")[1].split("\\.");
            this.f = Integer.valueOf(split[0]).intValue();
            this.g = Integer.valueOf(split[1]).intValue();
            this.h = Integer.valueOf(split[2]).intValue();
        }

        public int a() {
            return this.f;
        }

        public int b() {
            return this.g;
        }

        public int c() {
            return this.h;
        }
    }

    x() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new x();
    }

    private x(bn bnVar, int i, long j2, int i2, int i3, int i4, byte[] bArr) {
        super(bnVar, 43, i, j2);
        this.j = b("footprint", i2);
        this.k = a("alg", i3);
        this.l = a("digestid", i4);
        this.m = bArr;
    }

    private x(bn bnVar, int i, long j2, int i2, u uVar) {
        this(bnVar, i, j2, uVar.d(), uVar.f(), i2, w.a(uVar, i2));
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.j = tVar.h();
        this.k = tVar.g();
        this.l = tVar.g();
        this.m = tVar.j();
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.j = ddVar.g();
        this.k = ddVar.h();
        this.l = ddVar.h();
        this.m = ddVar.m();
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.j);
        stringBuffer.append(" ");
        stringBuffer.append(this.k);
        stringBuffer.append(" ");
        stringBuffer.append(this.l);
        if (this.m != null) {
            stringBuffer.append(" ");
            stringBuffer.append(e.a(this.m));
        }
        return stringBuffer.toString();
    }

    private int d() {
        return this.k;
    }

    private int e() {
        return this.l;
    }

    private byte[] f() {
        return this.m;
    }

    private int g() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.c(this.j);
        vVar.b(this.k);
        vVar.b(this.l);
        byte[] bArr = this.m;
        if (bArr != null) {
            vVar.a(bArr);
        }
    }
}
