package com.amazonaws.util;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
public class CountingInputStream extends SdkFilterInputStream {
    private long byteCount = 0;

    public CountingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public long getByteCount() {
        return this.byteCount;
    }

    public int read() throws IOException {
        int read = CountingInputStream.super.read();
        this.byteCount += read >= 0 ? 1 : 0;
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = CountingInputStream.super.read(bArr, i, i2);
        this.byteCount += read >= 0 ? (long) read : 0;
        return read;
    }
}
