package com.bonree.sdk.bc;

import com.bonree.sdk.ac.f;
import com.bonree.sdk.bc.w;
import com.facebook.soloader.MinElf;
import java.io.IOException;
import java.security.PublicKey;

abstract class ao extends ca {
    private static final long j = 3469321722693285454L;
    protected int a;
    protected int b;
    protected int c;
    protected byte[] d;
    protected PublicKey e = null;
    private int k = -1;

    protected ao() {
    }

    public ao(bn bnVar, int i, int i2, long j2, int i3, int i4, int i5, byte[] bArr) {
        super(bnVar, i, i2, j2);
        this.a = b("flags", i3);
        this.b = a("proto", i4);
        this.c = a("alg", i5);
        this.d = bArr;
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.a = tVar.h();
        this.b = tVar.g();
        this.c = tVar.g();
        if (tVar.b() > 0) {
            this.d = tVar.j();
        }
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.a);
        stringBuffer.append(" ");
        stringBuffer.append(this.b);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        if (this.d != null) {
            if (br.a("multiline")) {
                stringBuffer.append(" (\n");
                stringBuffer.append(f.a(this.d, 64, "\t", true));
                stringBuffer.append(" ; key_tag = ");
                stringBuffer.append(d());
            } else {
                stringBuffer.append(" ");
                stringBuffer.append(f.a(this.d));
            }
        }
        return stringBuffer.toString();
    }

    public int h() {
        return this.a;
    }

    public int g() {
        return this.b;
    }

    public int f() {
        return this.c;
    }

    public byte[] e() {
        return this.d;
    }

    public int d() {
        int i;
        byte b2;
        int i2 = this.k;
        if (i2 >= 0) {
            return i2;
        }
        v vVar = new v();
        int i3 = 0;
        a(vVar, (m) null, false);
        byte[] d2 = vVar.d();
        if (this.c == 1) {
            b2 = d2[d2.length - 2] & 255;
            i = (d2[d2.length - 3] & 255) << 8;
        } else {
            i = 0;
            while (i3 < d2.length - 1) {
                i += ((d2[i3] & 255) << 8) + (d2[i3 + 1] & 255);
                i3 += 2;
            }
            if (i3 < d2.length) {
                i += (d2[i3] & 255) << 8;
            }
            b2 = (i >> 16) & 65535;
        }
        int i4 = (i + b2) & MinElf.PN_XNUM;
        this.k = i4;
        return i4;
    }

    public PublicKey f_() throws w.b {
        PublicKey publicKey = this.e;
        if (publicKey != null) {
            return publicKey;
        }
        PublicKey a2 = w.a(this);
        this.e = a2;
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.c(this.a);
        vVar.b(this.b);
        vVar.b(this.c);
        byte[] bArr = this.d;
        if (bArr != null) {
            vVar.a(bArr);
        }
    }
}
