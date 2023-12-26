package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class InputSubstream extends SdkFilterInputStream {
    private final boolean closeSourceStream;
    private long currentPosition = 0;
    private long markedPosition = 0;
    private final long requestedLength;
    private final long requestedOffset;

    public InputSubstream(InputStream inputStream, long j, long j2, boolean z) {
        super(inputStream);
        this.requestedLength = j2;
        this.requestedOffset = j;
        this.closeSourceStream = z;
    }

    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        if (read == -1) {
            return read;
        }
        return bArr[0];
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j;
        long j2;
        while (true) {
            j = this.currentPosition;
            j2 = this.requestedOffset;
            if (j >= j2) {
                break;
            }
            this.currentPosition += super.skip(j2 - j);
        }
        long j3 = (this.requestedLength + j2) - j;
        if (j3 <= 0) {
            return -1;
        }
        int read = super.read(bArr, i, (int) Math.min((long) i2, j3));
        this.currentPosition += (long) read;
        return read;
    }

    public synchronized void mark(int i) {
        this.markedPosition = this.currentPosition;
        super.mark(i);
    }

    public synchronized void reset() throws IOException {
        this.currentPosition = this.markedPosition;
        super.reset();
    }

    public void close() throws IOException {
        if (this.closeSourceStream) {
            super.close();
        }
    }

    public int available() throws IOException {
        long j;
        long j2 = this.currentPosition;
        long j3 = this.requestedOffset;
        if (j2 < j3) {
            j = this.requestedLength;
        } else {
            j = (this.requestedLength + j3) - j2;
        }
        return (int) Math.min(j, (long) super.available());
    }
}
