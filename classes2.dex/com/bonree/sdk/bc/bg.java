package com.bonree.sdk.bc;

import com.bonree.sdk.ac.e;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public final class bg extends ca {
    private static final long a = -8689038598776316533L;
    private int b;
    private int c;
    private int d;
    private byte[] e;

    bg() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new bg();
    }

    private bg(bn bnVar, int i, long j, int i2, int i3, int i4, byte[] bArr) {
        super(bnVar, 51, i, j);
        this.b = a("hashAlg", i2);
        this.c = a("flags", i3);
        this.d = b("iterations", i4);
        if (bArr == null) {
            return;
        }
        if (bArr.length > 255) {
            throw new IllegalArgumentException("Invalid salt length");
        } else if (bArr.length > 0) {
            byte[] bArr2 = new byte[bArr.length];
            this.e = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = tVar.g();
        this.c = tVar.g();
        this.d = tVar.h();
        int g = tVar.g();
        if (g > 0) {
            this.e = tVar.d(g);
        } else {
            this.e = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.b(this.b);
        vVar.b(this.c);
        vVar.c(this.d);
        byte[] bArr = this.e;
        if (bArr != null) {
            vVar.b(bArr.length);
            vVar.a(this.e);
            return;
        }
        vVar.b(0);
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.b = ddVar.h();
        this.c = ddVar.h();
        this.d = ddVar.g();
        if (ddVar.c().equals("-")) {
            this.e = null;
            return;
        }
        ddVar.b();
        byte[] n = ddVar.n();
        this.e = n;
        if (n.length > 255) {
            throw ddVar.a("salt value too long");
        }
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        stringBuffer.append(' ');
        stringBuffer.append(this.c);
        stringBuffer.append(' ');
        stringBuffer.append(this.d);
        stringBuffer.append(' ');
        byte[] bArr = this.e;
        if (bArr == null) {
            stringBuffer.append('-');
        } else {
            stringBuffer.append(e.a(bArr));
        }
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

    private byte[] g() {
        return this.e;
    }

    private byte[] b(bn bnVar) throws NoSuchAlgorithmException {
        return bh.a(bnVar, this.b, this.d, this.e);
    }
}
