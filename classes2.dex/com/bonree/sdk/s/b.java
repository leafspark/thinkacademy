package com.bonree.sdk.s;

import com.bonree.sdk.r.a;
import com.bonree.sdk.r.c;
import com.bonree.sdk.r.d;
import java.io.IOException;
import java.io.OutputStream;

public final class b extends OutputStream implements d {
    private final OutputStream a;
    private long b = 0;
    private final c c = new c();

    public b(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            this.a = outputStream;
            return;
        }
        throw new IOException("CountingOutputStream: output stream cannot be null");
    }

    public final void a(com.bonree.sdk.r.b bVar) {
        this.c.a(bVar);
    }

    public final void b(com.bonree.sdk.r.b bVar) {
        this.c.b(bVar);
    }

    public final long a() {
        return this.b;
    }

    public final void write(int i) throws IOException {
        try {
            this.a.write(i);
            this.b++;
        } catch (IOException e) {
            a((Exception) e);
            throw e;
        }
    }

    public final void write(byte[] bArr) throws IOException {
        try {
            this.a.write(bArr);
            this.b += (long) bArr.length;
        } catch (IOException e) {
            a((Exception) e);
            throw e;
        }
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.a.write(bArr, i, i2);
            this.b += (long) i2;
        } catch (IOException e) {
            a((Exception) e);
            throw e;
        }
    }

    public final void close() throws IOException {
        try {
            this.a.close();
            if (!this.c.a()) {
                this.c.a(new a(this, this.b));
            }
        } catch (IOException e) {
            a((Exception) e);
            throw e;
        }
    }

    public final void flush() throws IOException {
        this.a.flush();
    }

    private void b() {
        if (!this.c.a()) {
            this.c.a(new a(this, this.b));
        }
    }

    private void a(Exception exc) {
        if (!this.c.a()) {
            this.c.b(new a(this, this.b, exc));
        }
    }
}
