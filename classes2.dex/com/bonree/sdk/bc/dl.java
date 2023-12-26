package com.bonree.sdk.bc;

import com.bonree.sdk.agent.engine.webview.entity.WebViewRouteChangeEvent;
import java.io.IOException;

public final class dl extends ca {
    private static final long a = 7955422413971804232L;
    private int b;
    private int c;
    private byte[] d;

    dl() {
        this.d = new byte[0];
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new dl();
    }

    private dl(bn bnVar, int i, long j, int i2, int i3, String str) {
        super(bnVar, WebViewRouteChangeEvent.ROUTE_CHANGE_String_LIMIT, i, j);
        this.b = b("priority", i2);
        this.c = b("weight", i3);
        try {
            this.d = a(str);
        } catch (dc e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = tVar.h();
        this.c = tVar.h();
        this.d = tVar.k();
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.b = ddVar.g();
        this.c = ddVar.g();
        try {
            this.d = a(ddVar.c());
        } catch (dc e) {
            throw ddVar.a(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b + " ");
        stringBuffer.append(this.c + " ");
        stringBuffer.append(a(this.d, true));
        return stringBuffer.toString();
    }

    private int d() {
        return this.b;
    }

    private int e() {
        return this.c;
    }

    private String f() {
        return a(this.d, false);
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.c(this.b);
        vVar.c(this.c);
        vVar.b(this.d);
    }
}
