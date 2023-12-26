package com.bonree.sdk.bc;

import com.bonree.sdk.ac.e;
import com.bonree.sdk.bd.c;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class bh extends ca {
    private static int a = 1;
    private static final long b = -7123504635968932855L;
    private static final c m = new c("0123456789ABCDEFGHIJKLMNOPQRSTUV=", false, false);
    private int c;
    private int d;
    private int e;
    private byte[] j;
    private byte[] k;
    private dg l;

    public static class b {
        private static int a = 1;

        private b() {
        }
    }

    public static class a {
        private static int a = 1;

        private a() {
        }
    }

    bh() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new bh();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private bh(bn bnVar, int i, long j2, int i2, int i3, int i4, byte[] bArr, byte[] bArr2, int[] iArr) {
        super(bnVar, 50, i, j2);
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int i5 = i2;
        this.c = a("hashAlg", i2);
        int i6 = i3;
        this.d = a("flags", i3);
        this.e = b("iterations", i4);
        if (bArr3 != null) {
            if (bArr3.length > 255) {
                throw new IllegalArgumentException("Invalid salt");
            } else if (bArr3.length > 0) {
                byte[] bArr5 = new byte[bArr3.length];
                this.j = bArr5;
                System.arraycopy(bArr3, 0, bArr5, 0, bArr3.length);
            }
        }
        if (bArr4.length <= 255) {
            byte[] bArr6 = new byte[bArr4.length];
            this.k = bArr6;
            System.arraycopy(bArr4, 0, bArr6, 0, bArr4.length);
            this.l = new dg(iArr);
            return;
        }
        throw new IllegalArgumentException("Invalid next hash");
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.c = tVar.g();
        this.d = tVar.g();
        this.e = tVar.h();
        int g = tVar.g();
        if (g > 0) {
            this.j = tVar.d(g);
        } else {
            this.j = null;
        }
        this.k = tVar.d(tVar.g());
        this.l = new dg(tVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.b(this.c);
        vVar.b(this.d);
        vVar.c(this.e);
        byte[] bArr = this.j;
        if (bArr != null) {
            vVar.b(bArr.length);
            vVar.a(this.j);
        } else {
            vVar.b(0);
        }
        vVar.b(this.k.length);
        vVar.a(this.k);
        this.l.a(vVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.c = ddVar.h();
        this.d = ddVar.h();
        this.e = ddVar.g();
        if (ddVar.c().equals("-")) {
            this.j = null;
        } else {
            ddVar.b();
            byte[] n = ddVar.n();
            this.j = n;
            if (n.length > 255) {
                throw ddVar.a("salt value too long");
            }
        }
        this.k = ddVar.a(m);
        this.l = new dg(ddVar);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.c);
        stringBuffer.append(' ');
        stringBuffer.append(this.d);
        stringBuffer.append(' ');
        stringBuffer.append(this.e);
        stringBuffer.append(' ');
        byte[] bArr = this.j;
        if (bArr == null) {
            stringBuffer.append('-');
        } else {
            stringBuffer.append(e.a(bArr));
        }
        stringBuffer.append(' ');
        stringBuffer.append(m.a(this.k));
        if (!this.l.b()) {
            stringBuffer.append(' ');
            stringBuffer.append(this.l.toString());
        }
        return stringBuffer.toString();
    }

    private int d() {
        return this.c;
    }

    private int e() {
        return this.d;
    }

    private int f() {
        return this.e;
    }

    private byte[] g() {
        return this.j;
    }

    private byte[] h() {
        return this.k;
    }

    private int[] i() {
        return this.l.a();
    }

    private boolean b(int i) {
        return this.l.a(i);
    }

    static byte[] a(bn bnVar, int i, int i2, byte[] bArr) throws NoSuchAlgorithmException {
        if (i == 1) {
            MessageDigest instance = MessageDigest.getInstance("sha-1");
            byte[] bArr2 = null;
            for (int i3 = 0; i3 <= i2; i3++) {
                instance.reset();
                if (i3 == 0) {
                    instance.update(bnVar.e());
                } else {
                    instance.update(bArr2);
                }
                if (bArr != null) {
                    instance.update(bArr);
                }
                bArr2 = instance.digest();
            }
            return bArr2;
        }
        throw new NoSuchAlgorithmException("Unknown NSEC3 algorithmidentifier: " + i);
    }

    private byte[] b(bn bnVar) throws NoSuchAlgorithmException {
        return a(bnVar, this.c, this.e, this.j);
    }
}
