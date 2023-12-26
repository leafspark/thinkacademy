package com.bonree.sdk.agent.engine.network.httpclient.external;

import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;
import com.bonree.sdk.r.b;
import com.bonree.sdk.r.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.HttpEntityWrapper;

public final class HttpResponseEntityWrapperImpl extends HttpEntityWrapper implements b {
    private static final f a = a.a();
    private final long b;
    private com.bonree.sdk.s.a c;
    private final HttpEntity d;
    private HttpResponse e;
    private final com.bonree.sdk.n.b f;

    public HttpResponseEntityWrapperImpl(HttpResponse httpResponse, com.bonree.sdk.n.b bVar, long j) {
        super(httpResponse.getEntity());
        this.e = httpResponse;
        this.d = httpResponse.getEntity();
        this.f = bVar;
        this.b = j;
    }

    public final void consumeContent() throws IOException {
        try {
            this.d.consumeContent();
        } catch (Exception e2) {
            com.bonree.sdk.o.a.b(this.f, e2);
            throw e2;
        }
    }

    public final InputStream getContent() throws IOException, IllegalStateException {
        com.bonree.sdk.s.a aVar = this.c;
        if (aVar != null) {
            return aVar;
        }
        try {
            com.bonree.sdk.s.a aVar2 = new com.bonree.sdk.s.a(this.d.getContent());
            this.c = aVar2;
            aVar2.a(this.f);
            this.c.a((b) this);
            return this.c;
        } catch (IOException e2) {
            com.bonree.sdk.o.a.b(this.f, e2);
            throw e2;
        } catch (IllegalStateException e3) {
            com.bonree.sdk.o.a.b(this.f, e3);
            throw e3;
        } catch (Throwable unused) {
            return this.d.getContent();
        }
    }

    public final Header getContentEncoding() {
        return this.d.getContentEncoding();
    }

    public final long getContentLength() {
        return this.d.getContentLength();
    }

    public final Header getContentType() {
        return this.d.getContentType();
    }

    public final boolean isChunked() {
        return this.d.isChunked();
    }

    public final boolean isRepeatable() {
        return this.d.isRepeatable();
    }

    public final boolean isStreaming() {
        return this.d.isStreaming();
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        if (this.f.p()) {
            this.d.writeTo(outputStream);
            return;
        }
        com.bonree.sdk.s.b bVar = new com.bonree.sdk.s.b(outputStream);
        try {
            this.d.writeTo(bVar);
            if (!this.f.p()) {
                long j = this.b;
                if (j >= 0) {
                    this.f.c(j);
                } else {
                    this.f.c(bVar.a());
                    this.f.h(com.bonree.sdk.d.a.b());
                    if (this.f.M() > 0 && this.f.G() > 0 && this.f.M() - this.f.G() > 0) {
                        com.bonree.sdk.n.b bVar2 = this.f;
                        bVar2.h((int) (bVar2.M() - this.f.G()));
                    }
                }
                com.bonree.sdk.o.a.a(this.f);
            }
        } catch (Exception e2) {
            com.bonree.sdk.o.a.b(this.f, e2);
            throw e2;
        }
    }

    public final void a(com.bonree.sdk.r.a aVar) {
        ((d) aVar.getSource()).b(this);
        f fVar = a;
        fVar.c("HttpResponseEntityWrapperImpl streamComplete", new Object[0]);
        if (!this.f.p()) {
            fVar.c("HttpResponseEntityWrapperImpl transaction not complete", new Object[0]);
            long j = this.b;
            if (j >= 0) {
                this.f.c(j);
            } else {
                this.f.c(aVar.a());
            }
            this.f.h(com.bonree.sdk.d.a.b());
            if (this.f.M() > 0 && this.f.G() > 0 && this.f.M() - this.f.G() > 0) {
                com.bonree.sdk.n.b bVar = this.f;
                bVar.h((int) (bVar.M() - this.f.G()));
            }
            com.bonree.sdk.o.a.a(this.f);
        }
    }

    public final void b(com.bonree.sdk.r.a aVar) {
        ((d) aVar.getSource()).b(this);
        com.bonree.sdk.o.a.b(this.f, aVar.b());
    }
}
