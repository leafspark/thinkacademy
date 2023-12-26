package com.bonree.sdk.bc;

import com.bonree.sdk.bc.dd;
import java.io.IOException;

public final class ak extends ca {
    private static final long a = -8730801385178968798L;
    private byte[] b;
    private byte[] c;

    ak() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new ak();
    }

    private ak(bn bnVar, int i, long j, String str, String str2) {
        super(bnVar, 20, i, j);
        try {
            this.b = a(str);
            if (str2 != null) {
                this.c = a(str2);
            }
        } catch (dc e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = tVar.k();
        if (tVar.b() > 0) {
            this.c = tVar.k();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        try {
            this.b = a(ddVar.c());
            dd.a a2 = ddVar.a();
            if (a2.a()) {
                this.c = a(a2.b);
            } else {
                ddVar.b();
            }
        } catch (dc e) {
            throw ddVar.a(e.getMessage());
        }
    }

    private String d() {
        return a(this.b, false);
    }

    private String e() {
        byte[] bArr = this.c;
        if (bArr == null) {
            return null;
        }
        return a(bArr, false);
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.b(this.b);
        byte[] bArr = this.c;
        if (bArr != null) {
            vVar.b(bArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a(this.b, true));
        if (this.c != null) {
            stringBuffer.append(" ");
            stringBuffer.append(a(this.c, true));
        }
        return stringBuffer.toString();
    }
}
