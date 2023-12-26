package org.apache.commons.fileupload.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class LimitedInputStream extends FilterInputStream implements Closeable {
    private boolean closed;
    private long count;
    private final long sizeMax;

    /* access modifiers changed from: protected */
    public abstract void raiseError(long j, long j2) throws IOException;

    public LimitedInputStream(InputStream inputStream, long j) {
        super(inputStream);
        this.sizeMax = j;
    }

    private void checkLimit() throws IOException {
        long j = this.count;
        long j2 = this.sizeMax;
        if (j > j2) {
            raiseError(j2, j);
        }
    }

    public int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.count++;
            checkLimit();
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read > 0) {
            this.count += (long) read;
            checkLimit();
        }
        return read;
    }

    public boolean isClosed() throws IOException {
        return this.closed;
    }

    public void close() throws IOException {
        this.closed = true;
        super.close();
    }
}
