package com.bonree.sdk.bc;

import java.io.IOException;

abstract class dh extends ca {
    private static final long c = -8315884183112502995L;
    protected int a;
    protected bn b;

    protected dh() {
    }

    private dh(bn bnVar, int i, int i2, long j) {
        super(bnVar, i, i2, j);
    }

    protected dh(bn bnVar, int i, int i2, long j, int i3, String str, bn bnVar2, String str2) {
        super(bnVar, i, i2, j);
        this.a = b(str, i3);
        this.b = a(bnVar2);
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.a = tVar.h();
        this.b = new bn(tVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.a = ddVar.g();
        this.b = ddVar.a(bnVar);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.a);
        stringBuffer.append(" ");
        stringBuffer.append(this.b);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public final int d() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public final bn e() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public void a(v vVar, m mVar, boolean z) {
        vVar.c(this.a);
        this.b.a(vVar, (m) null, z);
    }
}
