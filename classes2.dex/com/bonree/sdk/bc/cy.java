package com.bonree.sdk.bc;

import com.bonree.sdk.ac.f;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.Date;

public final class cy extends ca {
    private static final long a = -88820909016649306L;
    private bn b;
    private Date c;
    private int d;
    private byte[] e;
    private int j;
    private int k;
    private byte[] l;

    cy() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new cy();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public cy(bn bnVar, int i, long j2, bn bnVar2, Date date, int i2, byte[] bArr, int i3, int i4, byte[] bArr2) {
        super(bnVar, 250, 255, 0);
        this.b = a(bnVar2);
        this.c = date;
        int i5 = i2;
        this.d = b("fudge", i2);
        this.e = bArr;
        this.j = b("originalID", i3);
        this.k = b(Constants.IPC_BUNDLE_KEY_SEND_ERROR, i4);
        this.l = bArr2;
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = new bn(tVar);
        this.c = new Date(((((long) tVar.h()) << 32) + tVar.i()) * 1000);
        this.d = tVar.h();
        this.e = tVar.d(tVar.h());
        this.j = tVar.h();
        this.k = tVar.h();
        int h = tVar.h();
        if (h > 0) {
            this.l = tVar.d(h);
        } else {
            this.l = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        throw ddVar.a("no text format defined for TSIG");
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        stringBuffer.append(" ");
        if (br.a("multiline")) {
            stringBuffer.append("(\n\t");
        }
        stringBuffer.append(this.c.getTime() / 1000);
        stringBuffer.append(" ");
        stringBuffer.append(this.d);
        stringBuffer.append(" ");
        stringBuffer.append(this.e.length);
        if (br.a("multiline")) {
            stringBuffer.append("\n");
            stringBuffer.append(f.a(this.e, 64, "\t", false));
        } else {
            stringBuffer.append(" ");
            stringBuffer.append(f.a(this.e));
        }
        stringBuffer.append(" ");
        stringBuffer.append(bz.b(this.k));
        stringBuffer.append(" ");
        byte[] bArr = this.l;
        if (bArr == null) {
            stringBuffer.append(0);
        } else {
            stringBuffer.append(bArr.length);
            if (br.a("multiline")) {
                stringBuffer.append("\n\n\n\t");
            } else {
                stringBuffer.append(" ");
            }
            if (this.k == 18) {
                byte[] bArr2 = this.l;
                if (bArr2.length != 6) {
                    stringBuffer.append("<invalid BADTIME other data>");
                } else {
                    stringBuffer.append("<server time: ");
                    stringBuffer.append(new Date(((((long) (bArr2[0] & 255)) << 40) + (((long) (bArr2[1] & 255)) << 32) + ((long) ((bArr2[2] & 255) << 24)) + ((long) ((bArr2[3] & 255) << 16)) + ((long) ((bArr2[4] & 255) << 8)) + ((long) (bArr2[5] & 255))) * 1000));
                    stringBuffer.append(">");
                }
            } else {
                stringBuffer.append("<");
                stringBuffer.append(f.a(this.l));
                stringBuffer.append(">");
            }
        }
        if (br.a("multiline")) {
            stringBuffer.append(" )");
        }
        return stringBuffer.toString();
    }

    public final bn d() {
        return this.b;
    }

    public final Date e() {
        return this.c;
    }

    public final int f() {
        return this.d;
    }

    public final byte[] g() {
        return this.e;
    }

    private int j() {
        return this.j;
    }

    public final int h() {
        return this.k;
    }

    public final byte[] i() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        this.b.a(vVar, (m) null, z);
        long time = this.c.getTime() / 1000;
        vVar.c((int) (time >> 32));
        vVar.a(time & 4294967295L);
        vVar.c(this.d);
        vVar.c(this.e.length);
        vVar.a(this.e);
        vVar.c(this.j);
        vVar.c(this.k);
        byte[] bArr = this.l;
        if (bArr != null) {
            vVar.c(bArr.length);
            vVar.a(this.l);
            return;
        }
        vVar.c(0);
    }
}
