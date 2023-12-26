package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractRepeatableCipherInputStream<T> extends SdkFilterInputStream {
    private final T cipherFactory;
    private boolean hasBeenAccessed;
    private final InputStream unencryptedDataStream;

    /* access modifiers changed from: protected */
    public abstract FilterInputStream createCipherInputStream(InputStream inputStream, T t);

    protected AbstractRepeatableCipherInputStream(InputStream inputStream, FilterInputStream filterInputStream, T t) {
        super(filterInputStream);
        this.unencryptedDataStream = inputStream;
        this.cipherFactory = t;
    }

    public boolean markSupported() {
        abortIfNeeded();
        return this.unencryptedDataStream.markSupported();
    }

    public void mark(int i) {
        abortIfNeeded();
        if (!this.hasBeenAccessed) {
            this.unencryptedDataStream.mark(i);
            return;
        }
        throw new UnsupportedOperationException("Marking is only supported before your first call to read or skip.");
    }

    public void reset() throws IOException {
        abortIfNeeded();
        this.unencryptedDataStream.reset();
        this.in = createCipherInputStream(this.unencryptedDataStream, this.cipherFactory);
        this.hasBeenAccessed = false;
    }

    public int read() throws IOException {
        this.hasBeenAccessed = true;
        return super.read();
    }

    public int read(byte[] bArr) throws IOException {
        this.hasBeenAccessed = true;
        return super.read(bArr);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        this.hasBeenAccessed = true;
        return super.read(bArr, i, i2);
    }

    public long skip(long j) throws IOException {
        this.hasBeenAccessed = true;
        return super.skip(j);
    }
}
