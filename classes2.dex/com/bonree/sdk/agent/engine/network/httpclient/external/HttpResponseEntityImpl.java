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

public final class HttpResponseEntityImpl implements b, HttpEntity {
    private static final f a = a.a();
    private final long b;
    private com.bonree.sdk.s.a c;
    private final HttpEntity impl;
    private final com.bonree.sdk.n.b transactionState;

    public HttpResponseEntityImpl(HttpResponse httpResponse, com.bonree.sdk.n.b bVar, long j) {
        this.impl = httpResponse.getEntity();
        this.transactionState = bVar;
        this.b = j;
    }

    public final void consumeContent() throws IOException {
        try {
            this.impl.consumeContent();
        } catch (Exception e) {
            com.bonree.sdk.o.a.b(this.transactionState, e);
            throw e;
        }
    }

    public final InputStream getContent() throws IOException, IllegalStateException {
        com.bonree.sdk.s.a aVar = this.c;
        if (aVar != null) {
            return aVar;
        }
        try {
            com.bonree.sdk.s.a aVar2 = new com.bonree.sdk.s.a(this.impl.getContent());
            this.c = aVar2;
            aVar2.a(this.transactionState);
            this.c.a((b) this);
            return this.c;
        } catch (IOException e) {
            com.bonree.sdk.o.a.b(this.transactionState, e);
            throw e;
        } catch (IllegalStateException e2) {
            com.bonree.sdk.o.a.b(this.transactionState, e2);
            throw e2;
        } catch (Throwable unused) {
            return this.impl.getContent();
        }
    }

    public final Header getContentEncoding() {
        return this.impl.getContentEncoding();
    }

    public final long getContentLength() {
        return this.impl.getContentLength();
    }

    public final Header getContentType() {
        return this.impl.getContentType();
    }

    public final boolean isChunked() {
        return this.impl.isChunked();
    }

    public final boolean isRepeatable() {
        return this.impl.isRepeatable();
    }

    public final boolean isStreaming() {
        return this.impl.isStreaming();
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        if (this.transactionState.p()) {
            this.impl.writeTo(outputStream);
            return;
        }
        com.bonree.sdk.s.b bVar = new com.bonree.sdk.s.b(outputStream);
        try {
            this.impl.writeTo(bVar);
            if (!this.transactionState.p()) {
                long j = this.b;
                if (j >= 0) {
                    this.transactionState.c(j);
                } else {
                    this.transactionState.c(bVar.a());
                    this.transactionState.h(com.bonree.sdk.d.a.b());
                    if (this.transactionState.M() > 0 && this.transactionState.G() > 0 && this.transactionState.M() - this.transactionState.G() > 0) {
                        com.bonree.sdk.n.b bVar2 = this.transactionState;
                        bVar2.h((int) (bVar2.M() - this.transactionState.G()));
                    }
                }
                com.bonree.sdk.o.a.a(this.transactionState);
            }
        } catch (Exception e) {
            com.bonree.sdk.o.a.b(this.transactionState, e);
            throw e;
        }
    }

    public final void a(com.bonree.sdk.r.a aVar) {
        ((d) aVar.getSource()).b(this);
        f fVar = a;
        fVar.c("HttpResponseEntityImpl streamComplete", new Object[0]);
        if (!this.transactionState.p()) {
            fVar.c("HttpResponseEntityImpl transaction not complete", new Object[0]);
            long j = this.b;
            if (j >= 0) {
                this.transactionState.c(j);
            } else {
                this.transactionState.c(aVar.a());
            }
            this.transactionState.h(com.bonree.sdk.d.a.b());
            if (this.transactionState.M() > 0 && this.transactionState.G() > 0 && this.transactionState.M() - this.transactionState.G() > 0) {
                com.bonree.sdk.n.b bVar = this.transactionState;
                bVar.h((int) (bVar.M() - this.transactionState.G()));
            }
            com.bonree.sdk.o.a.a(this.transactionState);
        }
    }

    public final void b(com.bonree.sdk.r.a aVar) {
        ((d) aVar.getSource()).b(this);
        com.bonree.sdk.o.a.b(this.transactionState, aVar.b());
    }
}
