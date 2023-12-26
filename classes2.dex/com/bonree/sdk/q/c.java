package com.bonree.sdk.q;

import com.bonree.sdk.be.f;
import com.bonree.sdk.r.a;
import com.bonree.sdk.r.b;
import java.io.IOException;

final class c implements b {
    private /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void b(a aVar) {
        if (!this.a.d.h()) {
            this.a.d.b(aVar.a());
        }
        this.a.a(aVar.b());
    }

    public final void a(a aVar) {
        if (!this.a.d.h()) {
            try {
                this.a.d.a(this.a.c.getResponseCode());
            } catch (IOException unused) {
                f a2 = a.f;
                a2.e("HttpURLConnectionExtension.getOutputStream.streamComplete: " + aVar, new Object[0]);
            }
            String requestProperty = this.a.c.getRequestProperty("Content-length");
            long a3 = aVar.a();
            if (requestProperty != null) {
                try {
                    a3 = Long.parseLong(requestProperty);
                } catch (NumberFormatException unused2) {
                }
            }
            this.a.d.b(a3);
        }
    }
}
