package com.bonree.sdk.bc;

import java.io.IOException;

public final class bt extends ca {
    private static final long a = 1811540008806660667L;
    private int b;
    private bn c;
    private bn d;

    bt() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new bt();
    }

    private bt(bn bnVar, int i, long j, int i2, bn bnVar2, bn bnVar3) {
        super(bnVar, 26, i, j);
        this.b = b("preference", i2);
        this.c = a(bnVar2);
        this.d = a(bnVar3);
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = tVar.h();
        this.c = new bn(tVar);
        this.d = new bn(tVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.b = ddVar.g();
        this.c = ddVar.a(bnVar);
        this.d = ddVar.a(bnVar);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        stringBuffer.append(" ");
        stringBuffer.append(this.d);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.c(this.b);
        this.c.a(vVar, (m) null, z);
        this.d.a(vVar, (m) null, z);
    }

    private int d() {
        return this.b;
    }

    private bn e() {
        return this.c;
    }

    private bn f() {
        return this.d;
    }
}
