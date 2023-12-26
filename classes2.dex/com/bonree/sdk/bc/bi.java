package com.bonree.sdk.bc;

import java.io.IOException;

public final class bi extends ca {
    private static final long a = -5165065768816265385L;
    private bn b;
    private dg c;

    bi() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new bi();
    }

    private bi(bn bnVar, int i, long j, bn bnVar2, int[] iArr) {
        super(bnVar, 47, i, j);
        this.b = a(bnVar2);
        for (int a2 : iArr) {
            df.a(a2);
        }
        this.c = new dg(iArr);
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = new bn(tVar);
        this.c = new dg(tVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        this.b.a(vVar, (m) null, false);
        this.c.a(vVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.b = ddVar.a(bnVar);
        this.c = new dg(ddVar);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        if (!this.c.b()) {
            stringBuffer.append(' ');
            stringBuffer.append(this.c.toString());
        }
        return stringBuffer.toString();
    }

    private bn d() {
        return this.b;
    }

    private int[] e() {
        return this.c.a();
    }

    private boolean b(int i) {
        return this.c.a(i);
    }
}
