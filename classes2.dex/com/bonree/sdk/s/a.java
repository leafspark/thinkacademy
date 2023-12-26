package com.bonree.sdk.s;

import com.bonree.sdk.n.b;
import com.bonree.sdk.r.c;
import com.bonree.sdk.r.d;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public final class a extends InputStream implements d {
    private final InputStream a;
    private final c b;
    private long c = 0;
    private b d;

    public final void a(b bVar) {
        this.d = bVar;
    }

    public a(InputStream inputStream) {
        Objects.requireNonNull(inputStream, "countingInputStream delegate or monitorStreamReadWrite was null");
        this.a = inputStream;
        this.b = new c();
    }

    public final void a(com.bonree.sdk.r.b bVar) {
        this.b.a(bVar);
    }

    public final void b(com.bonree.sdk.r.b bVar) {
        this.b.b(bVar);
    }

    private void a() {
        b bVar = this.d;
        if (bVar != null) {
            if (bVar.G() == 0) {
                this.d.f(com.bonree.sdk.d.a.b());
            }
            this.d.o();
        }
    }

    public final int read() throws IOException {
        try {
            int read = this.a.read();
            a();
            if (read >= 0) {
                this.c++;
            } else {
                b();
            }
            return read;
        } catch (IOException e) {
            a((Exception) e);
            throw e;
        }
    }

    public final int read(byte[] bArr) throws IOException {
        try {
            int read = this.a.read(bArr);
            a();
            if (read >= 0) {
                this.c += (long) read;
                return read;
            }
            b();
            return read;
        } catch (IOException e) {
            a((Exception) e);
            throw e;
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int read = this.a.read(bArr, i, i2);
            a();
            if (read >= 0) {
                this.c += (long) read;
                return read;
            }
            b();
            return read;
        } catch (IOException e) {
            a((Exception) e);
            throw e;
        }
    }

    public final long skip(long j) throws IOException {
        try {
            long skip = this.a.skip(j);
            this.c += skip;
            return skip;
        } catch (IOException e) {
            a((Exception) e);
            throw e;
        }
    }

    public final void close() throws IOException {
        try {
            this.a.close();
            b();
        } catch (IOException e) {
            a((Exception) e);
            throw e;
        }
    }

    private void b() {
        if (!this.b.a()) {
            this.b.a(new com.bonree.sdk.r.a(this, this.c));
        }
    }

    private void a(Exception exc) {
        if (!this.b.a()) {
            this.b.b(new com.bonree.sdk.r.a(this, this.c, exc));
        }
    }

    public final int available() throws IOException {
        return this.a.available();
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
