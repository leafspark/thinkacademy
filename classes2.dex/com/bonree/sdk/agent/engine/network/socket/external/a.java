package com.bonree.sdk.agent.engine.network.socket.external;

import com.bonree.sdk.n.f;
import java.io.IOException;
import java.io.InputStream;

public final class a extends InputStream {
    private InputStream a;
    private f b;

    public a(f fVar, InputStream inputStream) {
        if (inputStream == null || fVar == null) {
            throw new NullPointerException("inputStream delegate or monitorStreamReadWrite was null");
        }
        this.a = inputStream;
        this.b = fVar;
    }

    public final int read() throws IOException {
        int read = this.a.read();
        this.b.b(com.bonree.sdk.d.a.b(), read);
        return read;
    }

    public final int read(byte[] bArr) throws IOException {
        int read = this.a.read(bArr);
        this.b.b(com.bonree.sdk.d.a.b(), read);
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.a.read(bArr, i, i2);
        this.b.b(com.bonree.sdk.d.a.b(), read);
        return read;
    }

    public final int available() throws IOException {
        return this.a.available();
    }

    public final void close() throws IOException {
        this.a.close();
    }

    public final long skip(long j) throws IOException {
        return this.a.skip(j);
    }

    public final synchronized void mark(int i) {
        this.a.mark(i);
    }

    public final synchronized void reset() throws IOException {
        this.a.reset();
    }

    public final boolean markSupported() {
        return this.a.markSupported();
    }
}
