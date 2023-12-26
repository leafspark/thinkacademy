package com.bonree.sdk.bc;

import com.bonree.sdk.ac.f;
import com.bonree.sdk.bc.w;
import java.io.IOException;
import java.util.Date;

abstract class ci extends ca {
    private static final long a = -3738444391533812369L;
    private int b;
    private int c;
    private int d;
    private long e;
    private Date j;
    private Date k;
    private int l;
    private bn m;
    private byte[] n;

    protected ci() {
    }

    public ci(bn bnVar, int i, int i2, long j2, int i3, int i4, long j3, Date date, Date date2, int i5, bn bnVar2, byte[] bArr) {
        super(bnVar, i, i2, j2);
        df.a(i3);
        e.a(j3);
        this.b = i3;
        this.c = a("alg", i4);
        this.d = bnVar.d() - 1;
        if (bnVar.a()) {
            this.d--;
        }
        this.e = j3;
        this.j = date;
        this.k = date2;
        this.l = b("footprint", i5);
        this.m = a(bnVar2);
        this.n = bArr;
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = tVar.h();
        this.c = tVar.g();
        this.d = tVar.g();
        this.e = tVar.i();
        this.j = new Date(tVar.i() * 1000);
        this.k = new Date(tVar.i() * 1000);
        this.l = tVar.h();
        this.m = new bn(tVar);
        this.n = tVar.j();
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        String c2 = ddVar.c();
        int a2 = df.a(c2);
        this.b = a2;
        if (a2 >= 0) {
            String c3 = ddVar.c();
            int a3 = w.a.a(c3);
            this.c = a3;
            if (a3 >= 0) {
                this.d = ddVar.h();
                this.e = ddVar.i();
                this.j = ad.a(ddVar.c());
                this.k = ad.a(ddVar.c());
                this.l = ddVar.g();
                this.m = ddVar.a(bnVar);
                this.n = ddVar.l();
                return;
            }
            throw ddVar.a("Invalid algorithm: " + c3);
        }
        throw ddVar.a("Invalid type: " + c2);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(df.b(this.b));
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        stringBuffer.append(" ");
        stringBuffer.append(this.d);
        stringBuffer.append(" ");
        stringBuffer.append(this.e);
        stringBuffer.append(" ");
        if (br.a("multiline")) {
            stringBuffer.append("(\n\t");
        }
        stringBuffer.append(ad.a(this.j));
        stringBuffer.append(" ");
        stringBuffer.append(ad.a(this.k));
        stringBuffer.append(" ");
        stringBuffer.append(this.l);
        stringBuffer.append(" ");
        stringBuffer.append(this.m);
        if (br.a("multiline")) {
            stringBuffer.append("\n");
            stringBuffer.append(f.a(this.n, 64, "\t", true));
        } else {
            stringBuffer.append(" ");
            stringBuffer.append(f.a(this.n));
        }
        return stringBuffer.toString();
    }

    public int l() {
        return this.b;
    }

    public int k() {
        return this.c;
    }

    public int j() {
        return this.d;
    }

    public long i() {
        return this.e;
    }

    public Date h() {
        return this.j;
    }

    public Date g() {
        return this.k;
    }

    public int f() {
        return this.l;
    }

    public bn e() {
        return this.m;
    }

    public byte[] d() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public final void b(byte[] bArr) {
        this.n = bArr;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.c(this.b);
        vVar.b(this.c);
        vVar.b(this.d);
        vVar.a(this.e);
        vVar.a(this.j.getTime() / 1000);
        vVar.a(this.k.getTime() / 1000);
        vVar.c(this.l);
        this.m.a(vVar, (m) null, z);
        vVar.a(this.n);
    }
}
