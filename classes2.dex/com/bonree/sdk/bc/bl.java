package com.bonree.sdk.bc;

import java.io.IOException;

public final class bl extends ca {
    private static final long a = -5796493183235216538L;
    private byte[] b;

    bl() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new bl();
    }

    private bl(bn bnVar, int i, long j, byte[] bArr) {
        super(bnVar, 10, i, j);
        if (bArr.length <= 65535) {
            this.b = bArr;
            return;
        }
        throw new IllegalArgumentException("data must be <65536 bytes");
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = tVar.j();
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        throw ddVar.a("no defined text format for NULL records");
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return a(this.b);
    }

    private byte[] d() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.a(this.b);
    }
}
