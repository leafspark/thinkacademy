package com.bonree.sdk.q;

import com.bonree.sdk.be.f;
import com.bonree.sdk.r.a;
import java.io.IOException;

final class b implements com.bonree.sdk.r.b {
    private /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void b(a aVar) {
        if (!this.a.d.h()) {
            this.a.d.c(aVar.a());
        }
        this.a.a(aVar.b());
    }

    public final void a(a aVar) {
        if (!this.a.d.h()) {
            try {
                this.a.d.a(this.a.c.getResponseCode());
            } catch (IOException unused) {
                f a2 = a.f;
                a2.e("HttpURLConnectionExtension.getInputStream.streamComplete: " + aVar, new Object[0]);
            }
            long contentLength = (long) this.a.c.getContentLength();
            long a3 = aVar.a();
            if (a3 >= 0) {
                this.a.d.c(a3);
            }
            this.a.d.d(contentLength);
            this.a.d.h(com.bonree.sdk.d.a.b());
            if (this.a.d.G() > 0 && this.a.d.M() > 0 && this.a.d.M() > this.a.d.G()) {
                this.a.d.h((int) (this.a.d.M() - this.a.d.G()));
            }
            com.bonree.sdk.p.a.d(this.a.d, this.a.c);
        }
    }
}
