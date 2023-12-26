package com.bonree.sdk.bc;

import com.bonree.sdk.ac.f;
import java.io.IOException;

public final class q extends ca {
    private static final long a = -8214820200808997707L;
    private byte[] b;

    q() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new q();
    }

    private q(bn bnVar, int i, long j, byte[] bArr) {
        super(bnVar, 49, i, j);
        this.b = bArr;
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = tVar.j();
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.b = ddVar.l();
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.a(this.b);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return f.a(this.b);
    }

    private byte[] d() {
        return this.b;
    }
}
