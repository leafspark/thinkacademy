package com.bonree.sdk.bc;

import java.io.IOException;

public final class bd extends ca {
    private static final long a = 5191232392044947002L;
    private int b;
    private int c;
    private byte[] d;
    private byte[] e;
    private byte[] j;
    private bn k;

    bd() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new bd();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private bd(bn bnVar, int i, long j2, int i2, int i3, String str, String str2, String str3, bn bnVar2) {
        super(bnVar, 35, i, j2);
        int i4 = i2;
        this.b = b("order", i2);
        int i5 = i3;
        this.c = b("preference", i3);
        try {
            this.d = a(str);
            this.e = a(str2);
            this.j = a(str3);
            this.k = a(bnVar2);
        } catch (dc e2) {
            throw new IllegalArgumentException(e2.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = tVar.h();
        this.c = tVar.h();
        this.d = tVar.k();
        this.e = tVar.k();
        this.j = tVar.k();
        this.k = new bn(tVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.b = ddVar.g();
        this.c = ddVar.g();
        try {
            this.d = a(ddVar.c());
            this.e = a(ddVar.c());
            this.j = a(ddVar.c());
            this.k = ddVar.a(bnVar);
        } catch (dc e2) {
            throw ddVar.a(e2.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        stringBuffer.append(" ");
        stringBuffer.append(a(this.d, true));
        stringBuffer.append(" ");
        stringBuffer.append(a(this.e, true));
        stringBuffer.append(" ");
        stringBuffer.append(a(this.j, true));
        stringBuffer.append(" ");
        stringBuffer.append(this.k);
        return stringBuffer.toString();
    }

    private int d() {
        return this.b;
    }

    private int e() {
        return this.c;
    }

    private String f() {
        return a(this.d, false);
    }

    private String g() {
        return a(this.e, false);
    }

    private String h() {
        return a(this.j, false);
    }

    private bn i() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.c(this.b);
        vVar.c(this.c);
        vVar.b(this.d);
        vVar.b(this.e);
        vVar.b(this.j);
        this.k.a(vVar, (m) null, z);
    }

    public final bn c() {
        return this.k;
    }
}
