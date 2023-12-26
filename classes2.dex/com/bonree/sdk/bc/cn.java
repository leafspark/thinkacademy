package com.bonree.sdk.bc;

import com.bonree.sdk.ac.e;
import java.io.IOException;

public final class cn extends ca {
    private static final long a = -8104701402654687025L;
    private int b;
    private int c;
    private byte[] d;

    public static class a {
        private static int a = 1;
        private static int b = 2;

        private a() {
        }
    }

    public static class b {
        private static int a = 1;

        private b() {
        }
    }

    cn() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new cn();
    }

    private cn(bn bnVar, int i, long j, int i2, int i3, byte[] bArr) {
        super(bnVar, 44, i, j);
        this.b = a("alg", i2);
        this.c = a("digestType", i3);
        this.d = bArr;
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = tVar.g();
        this.c = tVar.g();
        this.d = tVar.j();
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.b = ddVar.h();
        this.c = ddVar.h();
        this.d = ddVar.b(true);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        stringBuffer.append(" ");
        stringBuffer.append(e.a(this.d));
        return stringBuffer.toString();
    }

    private int d() {
        return this.b;
    }

    private int e() {
        return this.c;
    }

    private byte[] f() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.b(this.b);
        vVar.b(this.c);
        vVar.a(this.d);
    }
}
