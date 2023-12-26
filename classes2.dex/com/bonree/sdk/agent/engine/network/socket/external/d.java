package com.bonree.sdk.agent.engine.network.socket.external;

import com.bonree.sdk.d.a;
import com.bonree.sdk.n.f;
import java.io.IOException;
import java.io.OutputStream;

public final class d extends OutputStream {
    private OutputStream a;
    private f b;

    public d(f fVar, OutputStream outputStream) {
        if (outputStream == null || fVar == null) {
            throw new NullPointerException("outputStream delegate or monitorStreamReadWrite was null");
        }
        this.a = outputStream;
        this.b = fVar;
    }

    public final void write(int i) throws IOException {
        this.b.a(a.b());
        this.a.write(i);
        this.b.a(a.b(), 1);
    }

    public final void write(byte[] bArr) throws IOException {
        this.b.a(a.b());
        this.a.write(bArr);
        this.b.a(a.b(), bArr.length);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.b.a(a.b());
        this.a.write(bArr, i, i2);
        this.b.a(a.b(), i2);
    }

    public final void flush() throws IOException {
        this.a.flush();
    }

    public final void close() throws IOException {
        this.a.close();
    }
}
