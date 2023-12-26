package com.bonree.sdk.bc;

import java.io.IOException;

public final class cm extends ca {
    private static final long a = -3886460132387522052L;
    private int b;
    private int c;
    private int d;
    private bn e;

    cm() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new cm();
    }

    private cm(bn bnVar, int i, long j, int i2, int i3, int i4, bn bnVar2) {
        super(bnVar, 33, i, j);
        this.b = b("priority", i2);
        this.c = b("weight", i3);
        this.d = b("port", i4);
        this.e = a(bnVar2);
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = tVar.h();
        this.c = tVar.h();
        this.d = tVar.h();
        this.e = new bn(tVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.b = ddVar.g();
        this.c = ddVar.g();
        this.d = ddVar.g();
        this.e = ddVar.a(bnVar);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b + " ");
        stringBuffer.append(this.c + " ");
        stringBuffer.append(this.d + " ");
        stringBuffer.append(this.e);
        return stringBuffer.toString();
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

    private bn g() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.c(this.b);
        vVar.c(this.c);
        vVar.c(this.d);
        this.e.a(vVar, (m) null, z);
    }

    public final bn c() {
        return this.e;
    }
}
