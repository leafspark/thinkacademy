package com.bonree.sdk.bc;

import com.bonree.sdk.bc.dd;
import java.io.IOException;
import java.util.BitSet;

public final class bm extends ca {
    private static final long a = -8851454400765507520L;
    private bn b;
    private BitSet c;

    bm() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new bm();
    }

    private bm(bn bnVar, int i, long j, bn bnVar2, BitSet bitSet) {
        super(bnVar, 30, i, j);
        this.b = a(bnVar2);
        this.c = bitSet;
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = new bn(tVar);
        this.c = new BitSet();
        int b2 = tVar.b();
        for (int i = 0; i < b2; i++) {
            int g = tVar.g();
            for (int i2 = 0; i2 < 8; i2++) {
                if (((1 << (7 - i2)) & g) != 0) {
                    this.c.set((i << 3) + i2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        dd.a a2;
        this.b = ddVar.a(bnVar);
        this.c = new BitSet();
        while (true) {
            a2 = ddVar.a();
            if (a2.a()) {
                int a3 = df.a(a2.b, true);
                if (a3 <= 0 || a3 > 128) {
                } else {
                    this.c.set(a3);
                }
            } else {
                ddVar.b();
                return;
            }
        }
        throw ddVar.a("Invalid type: " + a2.b);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        int length = this.c.length();
        for (short s = 0; s < length; s = (short) (s + 1)) {
            if (this.c.get(s)) {
                stringBuffer.append(" ");
                stringBuffer.append(df.b(s));
            }
        }
        return stringBuffer.toString();
    }

    private bn d() {
        return this.b;
    }

    private BitSet e() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        this.b.a(vVar, (m) null, z);
        int length = this.c.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i |= this.c.get(i2) ? 1 << (7 - (i2 % 8)) : 0;
            if (i2 % 8 == 7 || i2 == length - 1) {
                vVar.b(i);
                i = 0;
            }
        }
    }
}
