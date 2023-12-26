package com.bonree.sdk.bc;

import com.bonree.sdk.ac.e;
import java.io.IOException;

public final class r extends ca {
    private static int a = 1;
    private static int b = 1;
    private static final long c = 1960742375677534148L;
    private int d;
    private int e;
    private int j;
    private byte[] k;

    r() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new r();
    }

    private r(bn bnVar, int i, long j2, int i2, int i3, int i4, byte[] bArr) {
        super(bnVar, 32769, i, j2);
        this.d = b("footprint", i2);
        this.e = a("alg", i3);
        this.j = a("digestid", i4);
        this.k = bArr;
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.d = tVar.h();
        this.e = tVar.g();
        this.j = tVar.g();
        this.k = tVar.j();
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.d = ddVar.g();
        this.e = ddVar.h();
        this.j = ddVar.h();
        this.k = ddVar.m();
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.d);
        stringBuffer.append(" ");
        stringBuffer.append(this.e);
        stringBuffer.append(" ");
        stringBuffer.append(this.j);
        if (this.k != null) {
            stringBuffer.append(" ");
            stringBuffer.append(e.a(this.k));
        }
        return stringBuffer.toString();
    }

    private int d() {
        return this.e;
    }

    private int e() {
        return this.j;
    }

    private byte[] f() {
        return this.k;
    }

    private int g() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.c(this.d);
        vVar.b(this.e);
        vVar.b(this.j);
        byte[] bArr = this.k;
        if (bArr != null) {
            vVar.a(bArr);
        }
    }
}
