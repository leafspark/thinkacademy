package com.bonree.sdk.bc;

import java.io.IOException;

public final class ax extends ca {
    private static final long a = -3962147172340353796L;
    private bn b;
    private bn c;

    ax() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new ax();
    }

    private ax(bn bnVar, int i, long j, bn bnVar2, bn bnVar3) {
        super(bnVar, 14, i, j);
        this.b = a(bnVar2);
        this.c = a(bnVar3);
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = new bn(tVar);
        this.c = new bn(tVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.b = ddVar.a(bnVar);
        this.c = ddVar.a(bnVar);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        return stringBuffer.toString();
    }

    private bn d() {
        return this.b;
    }

    private bn e() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        this.b.a(vVar, (m) null, z);
        this.c.a(vVar, (m) null, z);
    }
}
