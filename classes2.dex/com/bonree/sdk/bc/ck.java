package com.bonree.sdk.bc;

import java.io.IOException;

public final class ck extends ca {
    private static final long a = 1049740098229303931L;
    private bn b;
    private bn c;
    private long d;
    private long e;
    private long j;
    private long k;
    private long l;

    ck() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new ck();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ck(bn bnVar, int i, long j2, bn bnVar2, bn bnVar3, long j3, long j4, long j5, long j6, long j7) {
        super(bnVar, 6, i, 0);
        this.b = a(bnVar2);
        this.c = a(bnVar3);
        long j8 = j3;
        this.d = a("serial", j3);
        this.e = a("refresh", 0);
        this.j = a("retry", 0);
        this.k = a("expire", 0);
        this.l = a("minimum", 0);
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = new bn(tVar);
        this.c = new bn(tVar);
        this.d = tVar.i();
        this.e = tVar.i();
        this.j = tVar.i();
        this.k = tVar.i();
        this.l = tVar.i();
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.b = ddVar.a(bnVar);
        this.c = ddVar.a(bnVar);
        long e2 = ddVar.e();
        if (e2 < 0 || e2 > 4294967295L) {
            throw ddVar.a("expected an 32 bit unsigned integer");
        }
        this.d = e2;
        this.e = ddVar.j();
        this.j = ddVar.j();
        this.k = ddVar.j();
        this.l = ddVar.j();
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        if (br.a("multiline")) {
            stringBuffer.append(" (\n\t\t\t\t\t");
            stringBuffer.append(this.d);
            stringBuffer.append("\t; serial\n\t\t\t\t\t");
            stringBuffer.append(this.e);
            stringBuffer.append("\t; refresh\n\t\t\t\t\t");
            stringBuffer.append(this.j);
            stringBuffer.append("\t; retry\n\t\t\t\t\t");
            stringBuffer.append(this.k);
            stringBuffer.append("\t; expire\n\t\t\t\t\t");
            stringBuffer.append(this.l);
            stringBuffer.append(" )\t; minimum");
        } else {
            stringBuffer.append(" ");
            stringBuffer.append(this.d);
            stringBuffer.append(" ");
            stringBuffer.append(this.e);
            stringBuffer.append(" ");
            stringBuffer.append(this.j);
            stringBuffer.append(" ");
            stringBuffer.append(this.k);
            stringBuffer.append(" ");
            stringBuffer.append(this.l);
        }
        return stringBuffer.toString();
    }

    private bn f() {
        return this.b;
    }

    private bn g() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    private long h() {
        return this.e;
    }

    private long i() {
        return this.j;
    }

    private long j() {
        return this.k;
    }

    public final long e() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        this.b.a(vVar, mVar, z);
        this.c.a(vVar, mVar, z);
        vVar.a(this.d);
        vVar.a(this.e);
        vVar.a(this.j);
        vVar.a(this.k);
        vVar.a(this.l);
    }
}
