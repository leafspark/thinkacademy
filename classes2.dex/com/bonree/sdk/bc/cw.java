package com.bonree.sdk.bc;

import com.bonree.sdk.ac.e;
import com.facebook.soloader.MinElf;
import java.io.IOException;

public final class cw extends ca {
    private static final long a = 356494267028580169L;
    private int b;
    private int c;
    private int d;
    private byte[] e;

    public static class a {
        private static int a = 0;
        private static int b = 1;
        private static int c = 2;
        private static int d = 3;

        private a() {
        }
    }

    public static class c {
        private static int a = 0;
        private static int b = 1;

        private c() {
        }
    }

    public static class b {
        private static int a = 0;
        private static int b = 1;
        private static int c = 2;

        private b() {
        }
    }

    cw() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new cw();
    }

    private cw(bn bnVar, int i, long j, int i2, int i3, int i4, byte[] bArr) {
        super(bnVar, 52, i, j);
        this.b = a("certificateUsage", i2);
        this.c = a("selector", i3);
        this.d = a("matchingType", i4);
        this.e = a("certificateAssociationData", bArr, (int) MinElf.PN_XNUM);
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = tVar.g();
        this.c = tVar.g();
        this.d = tVar.g();
        this.e = tVar.j();
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.b = ddVar.h();
        this.c = ddVar.h();
        this.d = ddVar.h();
        this.e = ddVar.m();
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        stringBuffer.append(" ");
        stringBuffer.append(this.d);
        stringBuffer.append(" ");
        stringBuffer.append(e.a(this.e));
        return stringBuffer.toString();
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.b(this.b);
        vVar.b(this.c);
        vVar.b(this.d);
        vVar.a(this.e);
    }

    private int d() {
        return this.b;
    }

    private int e() {
        return this.c;
    }

    private int f() {
        return this.d;
    }

    private byte[] g() {
        return this.e;
    }
}
