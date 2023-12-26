package com.amazonaws.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LengthCheckInputStream extends SdkFilterInputStream {
    public static final boolean EXCLUDE_SKIPPED_BYTES = false;
    public static final boolean INCLUDE_SKIPPED_BYTES = true;
    private long dataLength;
    private final long expectedLength;
    private final boolean includeSkipped;
    private long marked;

    public LengthCheckInputStream(InputStream inputStream, long j, boolean z) {
        super(inputStream);
        if (j >= 0) {
            this.expectedLength = j;
            this.includeSkipped = z;
            return;
        }
        throw new IllegalArgumentException();
    }

    public int read() throws IOException {
        int read = LengthCheckInputStream.super.read();
        if (read >= 0) {
            this.dataLength++;
        }
        checkLength(read == -1);
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = LengthCheckInputStream.super.read(bArr, i, i2);
        this.dataLength += read >= 0 ? (long) read : 0;
        checkLength(read == -1);
        return read;
    }

    public void mark(int i) {
        LengthCheckInputStream.super.mark(i);
        this.marked = this.dataLength;
    }

    public void reset() throws IOException {
        LengthCheckInputStream.super.reset();
        if (LengthCheckInputStream.super.markSupported()) {
            this.dataLength = this.marked;
        }
    }

    private void checkLength(boolean z) {
        if (z) {
            if (this.dataLength != this.expectedLength) {
                throw new AmazonClientException("Data read (" + this.dataLength + ") has a different length than the expected (" + this.expectedLength + ")");
            }
        } else if (this.dataLength > this.expectedLength) {
            throw new AmazonClientException("More data read (" + this.dataLength + ") than expected (" + this.expectedLength + ")");
        }
    }

    public long skip(long j) throws IOException {
        long skip = LengthCheckInputStream.super.skip(j);
        if (this.includeSkipped && skip > 0) {
            this.dataLength += skip;
            checkLength(false);
        }
        return skip;
    }
}
