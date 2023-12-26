package com.amazonaws.services.s3.internal.crypto;

import java.io.IOException;
import java.io.InputStream;

@Deprecated
public final class RenewableCipherLiteInputStream extends CipherLiteInputStream {
    private boolean hasBeenAccessed;

    public RenewableCipherLiteInputStream(InputStream inputStream, CipherLite cipherLite) {
        super(inputStream, cipherLite);
    }

    public RenewableCipherLiteInputStream(InputStream inputStream, CipherLite cipherLite, int i) {
        super(inputStream, cipherLite, i);
    }

    public RenewableCipherLiteInputStream(InputStream inputStream, CipherLite cipherLite, int i, boolean z, boolean z2) {
        super(inputStream, cipherLite, i, z, z2);
    }

    protected RenewableCipherLiteInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public boolean markSupported() {
        abortIfNeeded();
        return this.in.markSupported();
    }

    public void mark(int i) {
        abortIfNeeded();
        if (!this.hasBeenAccessed) {
            this.in.mark(i);
            return;
        }
        throw new UnsupportedOperationException("Marking is only supported before your first call to read or skip.");
    }

    public void reset() throws IOException {
        abortIfNeeded();
        this.in.reset();
        renewCipherLite();
        resetInternal();
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
