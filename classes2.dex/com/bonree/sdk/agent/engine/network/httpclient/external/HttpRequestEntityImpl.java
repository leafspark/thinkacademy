package com.bonree.sdk.agent.engine.network.httpclient.external;

import com.bonree.sdk.m.g;
import com.bonree.sdk.m.j;
import com.bonree.sdk.n.c;
import com.bonree.sdk.r.b;
import com.bonree.sdk.r.d;
import com.bonree.sdk.s.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public final class HttpRequestEntityImpl implements b, HttpEntity {
    private final HttpEntity a;
    private final com.bonree.sdk.n.b b;

    public HttpRequestEntityImpl(HttpEntity httpEntity, com.bonree.sdk.n.b bVar) {
        this.a = httpEntity;
        this.b = bVar;
    }

    public final void consumeContent() throws IOException {
        try {
            this.a.consumeContent();
        } catch (IOException e) {
            a(e, (Long) null);
            throw e;
        }
    }

    public final InputStream getContent() throws IOException, IllegalStateException {
        try {
            if (this.b.g()) {
                return this.a.getContent();
            }
            a aVar = new a(this.a.getContent());
            aVar.a((b) this);
            return aVar;
        } catch (IOException e) {
            a(e, (Long) null);
            throw e;
        } catch (IllegalStateException e2) {
            a(e2, (Long) null);
            throw e2;
        } catch (Throwable unused) {
            return this.a.getContent();
        }
    }

    public final Header getContentEncoding() {
        return this.a.getContentEncoding();
    }

    public final long getContentLength() {
        return this.a.getContentLength();
    }

    public final Header getContentType() {
        return this.a.getContentType();
    }

    public final boolean isChunked() {
        return this.a.isChunked();
    }

    public final boolean isRepeatable() {
        return this.a.isRepeatable();
    }

    public final boolean isStreaming() {
        return this.a.isStreaming();
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        try {
            if (!this.b.g()) {
                com.bonree.sdk.s.b bVar = new com.bonree.sdk.s.b(outputStream);
                this.a.writeTo(bVar);
                this.b.b(bVar.a());
                return;
            }
            this.a.writeTo(outputStream);
        } catch (IOException e) {
            a(e, (Long) null);
            throw e;
        }
    }

    public final void a(com.bonree.sdk.r.a aVar) {
        ((d) aVar.getSource()).b(this);
        this.b.b(aVar.a());
    }

    public final void b(com.bonree.sdk.r.a aVar) {
        ((d) aVar.getSource()).b(this);
        a(aVar.b(), Long.valueOf(aVar.a()));
    }

    private void a(Exception exc) {
        a(exc, (Long) null);
    }

    private void a(Exception exc, Long l) {
        j.a(this.b, exc);
        if (!this.b.h()) {
            if (l != null) {
                this.b.b(l.longValue());
            }
            this.b.n();
            g.a().notifyService((c) this.b);
            com.bonree.sdk.be.g.a("HttpRequestEntityImpl :" + this.b, new Object[0]);
        }
    }
}
