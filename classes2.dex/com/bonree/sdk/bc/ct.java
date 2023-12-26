package com.bonree.sdk.bc;

import java.io.IOException;

abstract class ct extends ca {
    private static final long b = -18595042501413L;
    protected bn a;

    protected ct() {
    }

    private ct(bn bnVar, int i, int i2, long j) {
        super(bnVar, i, i2, j);
    }

    protected ct(bn bnVar, int i, int i2, long j, bn bnVar2, String str) {
        super(bnVar, i, i2, j);
        this.a = a(bnVar2);
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.a = new bn(tVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.a = ddVar.a(bnVar);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return this.a.toString();
    }

    /* access modifiers changed from: protected */
    public final bn e() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public void a(v vVar, m mVar, boolean z) {
        this.a.a(vVar, (m) null, z);
    }
}
