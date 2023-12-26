package com.bonree.sdk.q;

import com.bonree.sdk.be.g;
import com.bonree.sdk.r.a;
import com.bonree.sdk.r.b;
import java.io.IOException;
import java.net.HttpURLConnection;

final class f implements b {
    private /* synthetic */ d a;

    f(d dVar) {
        this.a = dVar;
    }

    public final void a(a aVar) {
        if (!this.a.e.h()) {
            try {
                this.a.e.a(this.a.d.getResponseCode());
            } catch (IOException unused) {
                com.bonree.sdk.be.f a2 = d.c;
                a2.e("HttpsURLConnectionExtension.getOutputStream.streamComplete: " + aVar, new Object[0]);
            }
            String requestProperty = this.a.d.getRequestProperty("Content-length");
            long a3 = aVar.a();
            if (requestProperty != null) {
                try {
                    a3 = Long.parseLong(requestProperty);
                } catch (NumberFormatException e) {
                    g.a("httpsUrlConnection exception:" + e, new Object[0]);
                }
            }
            this.a.e.b(a3);
        }
    }

    public final void b(a aVar) {
        if (!this.a.e.h()) {
            this.a.e.b(aVar.a());
        }
        com.bonree.sdk.p.a.a(aVar.b(), (HttpURLConnection) this.a.d, this.a.e);
    }
}
