package com.bonree.sdk.bc;

import java.io.IOException;

public final class ah extends ca {
    private static final long a = -4732870630947452112L;
    private byte[] b;
    private byte[] c;

    ah() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new ah();
    }

    private ah(bn bnVar, int i, long j, String str, String str2) {
        super(bnVar, 13, i, j);
        try {
            this.b = a(str);
            this.c = a(str2);
        } catch (dc e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = tVar.k();
        this.c = tVar.k();
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        try {
            this.b = a(ddVar.c());
            this.c = a(ddVar.c());
        } catch (dc e) {
            throw ddVar.a(e.getMessage());
        }
    }

    private String d() {
        return a(this.b, false);
    }

    private String e() {
        return a(this.c, false);
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.b(this.b);
        vVar.b(this.c);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a(this.b, true));
        stringBuffer.append(" ");
        stringBuffer.append(a(this.c, true));
        return stringBuffer.toString();
    }
}
