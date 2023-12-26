package com.bonree.sdk.agent.engine.network.okhttp3.external;

import com.bonree.sdk.d.a;
import com.bonree.sdk.m.g;
import com.bonree.sdk.n.b;
import com.bonree.sdk.n.c;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class BrResponseBody extends ResponseBody {
    /* access modifiers changed from: private */
    public final ResponseBody a;
    private BufferedSource b;
    /* access modifiers changed from: private */
    public b c;

    BrResponseBody(ResponseBody responseBody, b bVar) {
        this.a = responseBody;
        this.c = bVar;
    }

    public MediaType contentType() {
        return this.a.contentType();
    }

    public long contentLength() {
        return this.a.contentLength();
    }

    public BufferedSource source() {
        if (this.b == null) {
            this.b = Okio.buffer(load(this.a.source()));
        }
        return this.b;
    }

    private Source load(BufferedSource bufferedSource) {
        return new MyForwardingSource(bufferedSource);
    }

    class MyForwardingSource extends ForwardingSource {
        private long a = 0;

        public MyForwardingSource(Source source) {
            super(source);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
            if (com.bonree.sdk.agent.engine.network.okhttp3.external.BrResponseBody.b(r4.b) != null) goto L_0x003a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(okio.Buffer r5, long r6) throws java.io.IOException {
            /*
                r4 = this;
                long r5 = com.bonree.sdk.agent.engine.network.okhttp3.external.BrResponseBody.super.read(r5, r6)
                long r0 = r4.a
                r2 = -1
                int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
                if (r7 == 0) goto L_0x000e
                r2 = r5
                goto L_0x0010
            L_0x000e:
                r2 = 0
            L_0x0010:
                long r0 = r0 + r2
                r4.a = r0
                com.bonree.sdk.agent.engine.network.okhttp3.external.BrResponseBody r0 = com.bonree.sdk.agent.engine.network.okhttp3.external.BrResponseBody.this
                com.bonree.sdk.n.b r0 = r0.c
                if (r0 == 0) goto L_0x0024
                com.bonree.sdk.agent.engine.network.okhttp3.external.BrResponseBody r0 = com.bonree.sdk.agent.engine.network.okhttp3.external.BrResponseBody.this
                com.bonree.sdk.n.b r0 = r0.c
                r0.o()
            L_0x0024:
                if (r7 == 0) goto L_0x003a
                long r0 = r4.a     // Catch:{ all -> 0x003e }
                com.bonree.sdk.agent.engine.network.okhttp3.external.BrResponseBody r7 = com.bonree.sdk.agent.engine.network.okhttp3.external.BrResponseBody.this     // Catch:{ all -> 0x003e }
                long r2 = r7.contentLength()     // Catch:{ all -> 0x003e }
                int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r7 != 0) goto L_0x003d
                com.bonree.sdk.agent.engine.network.okhttp3.external.BrResponseBody r7 = com.bonree.sdk.agent.engine.network.okhttp3.external.BrResponseBody.this     // Catch:{ all -> 0x003e }
                okhttp3.ResponseBody r7 = r7.a     // Catch:{ all -> 0x003e }
                if (r7 == 0) goto L_0x003d
            L_0x003a:
                r4.end()     // Catch:{ all -> 0x003e }
            L_0x003d:
                return r5
            L_0x003e:
                r5 = move-exception
                r4.end()
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.engine.network.okhttp3.external.BrResponseBody.MyForwardingSource.read(okio.Buffer, long):long");
        }

        private void end() {
            if (!BrResponseBody.this.c.p()) {
                BrResponseBody.this.c.c(this.a);
                BrResponseBody.this.c.h(a.b());
                BrResponseBody.this.c.r();
                if (BrResponseBody.this.c.M() > 0 && BrResponseBody.this.c.G() > 0 && BrResponseBody.this.c.M() - BrResponseBody.this.c.G() > 0) {
                    BrResponseBody.this.c.h((int) (BrResponseBody.this.c.M() - BrResponseBody.this.c.G()));
                }
                g.a().notifyService((c) BrResponseBody.this.c);
                com.bonree.sdk.be.g.a("okhttp3 BrResponseBody: %s", BrResponseBody.this.c);
            }
        }
    }

    private void a() {
        this.a.close();
    }
}
