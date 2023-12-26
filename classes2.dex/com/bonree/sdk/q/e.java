package com.bonree.sdk.q;

import com.bonree.sdk.be.f;
import com.bonree.sdk.be.g;
import com.bonree.sdk.r.a;
import com.bonree.sdk.r.b;
import java.io.IOException;
import java.net.HttpURLConnection;

final class e implements b {
    private /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void a(a aVar) {
        if (!this.a.e.h()) {
            try {
                this.a.e.a(this.a.d.getResponseCode());
            } catch (IOException unused) {
                f a2 = d.c;
                a2.e("HttpsURLConnectionExtension.getInputStream.streamComplete: " + aVar, new Object[0]);
            }
            long contentLength = (long) this.a.d.getContentLength();
            long a3 = aVar.a();
            if (a3 >= 0) {
                this.a.e.c(a3);
            }
            this.a.e.d(contentLength);
            this.a.e.h(com.bonree.sdk.d.a.b());
            if (this.a.e.G() > 0 && this.a.e.M() > 0 && this.a.e.M() > this.a.e.G()) {
                this.a.e.h((int) (this.a.e.M() - this.a.e.G()));
            }
            com.bonree.sdk.p.a.a(this.a.e, this.a.d);
            g.a("httpurlconn streamcomplete thread id:" + Thread.currentThread().getId() + "  time:" + com.bonree.sdk.d.a.b(), new Object[0]);
        }
    }

    public final void b(a aVar) {
        if (!this.a.e.h()) {
            this.a.e.c(aVar.a());
        }
        com.bonree.sdk.p.a.a(aVar.b(), (HttpURLConnection) this.a.d, this.a.e);
    }
}
