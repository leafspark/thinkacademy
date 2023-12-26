package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

@Deprecated
public class CipherLiteInputStream extends SdkFilterInputStream {
    private static final int BYTE_MASK = 255;
    private static final int DEFAULT_IN_BUFFER_SIZE = 512;
    private static final int MAX_RETRY = 1000;
    private final byte[] bufin;
    private byte[] bufout;
    private CipherLite cipherLite;
    private int currPos;
    private boolean eof;
    private final boolean lastMultiPart;
    private int maxPos;
    private final boolean multipart;

    public CipherLiteInputStream(InputStream inputStream, CipherLite cipherLite2) {
        this(inputStream, cipherLite2, 512, false, false);
    }

    public CipherLiteInputStream(InputStream inputStream, CipherLite cipherLite2, int i) {
        this(inputStream, cipherLite2, i, false, false);
    }

    public CipherLiteInputStream(InputStream inputStream, CipherLite cipherLite2, int i, boolean z, boolean z2) {
        super(inputStream);
        this.eof = false;
        this.currPos = 0;
        this.maxPos = 0;
        if (!z2 || z) {
            this.multipart = z;
            this.lastMultiPart = z2;
            this.cipherLite = cipherLite2;
            if (i <= 0 || i % 512 != 0) {
                throw new IllegalArgumentException("buffsize (" + i + ") must be a positive multiple of " + 512);
            }
            this.bufin = new byte[i];
            return;
        }
        throw new IllegalArgumentException("lastMultiPart can only be true if multipart is true");
    }

    protected CipherLiteInputStream(InputStream inputStream) {
        this(inputStream, CipherLite.NULL, 512, false, false);
    }

    public int read() throws IOException {
        if (this.currPos >= this.maxPos) {
            if (this.eof) {
                return -1;
            }
            int i = 0;
            while (i <= 1000) {
                int nextChunk = nextChunk();
                i++;
                if (nextChunk != 0) {
                    if (nextChunk == -1) {
                        return -1;
                    }
                }
            }
            throw new IOException("exceeded maximum number of attempts to read next chunk of data");
        }
        byte[] bArr = this.bufout;
        int i2 = this.currPos;
        this.currPos = i2 + 1;
        return bArr[i2] & 255;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.currPos >= this.maxPos) {
            if (this.eof) {
                return -1;
            }
            int i3 = 0;
            while (i3 <= 1000) {
                int nextChunk = nextChunk();
                i3++;
                if (nextChunk != 0) {
                    if (nextChunk == -1) {
                        return -1;
                    }
                }
            }
            throw new IOException("exceeded maximum number of attempts to read next chunk of data");
        }
        if (i2 <= 0) {
            return 0;
        }
        int i4 = this.maxPos;
        int i5 = this.currPos;
        int i6 = i4 - i5;
        if (i2 >= i6) {
            i2 = i6;
        }
        System.arraycopy(this.bufout, i5, bArr, i, i2);
        this.currPos += i2;
        return i2;
    }

    public long skip(long j) throws IOException {
        abortIfNeeded();
        int i = this.maxPos;
        int i2 = this.currPos;
        long j2 = (long) (i - i2);
        if (j > j2) {
            j = j2;
        }
        if (j < 0) {
            return 0;
        }
        this.currPos = (int) (((long) i2) + j);
        return j;
    }

    public int available() {
        abortIfNeeded();
        return this.maxPos - this.currPos;
    }

    public void close() throws IOException {
        this.in.close();
        if (!this.multipart && !S3CryptoScheme.isAesGcm(this.cipherLite.getCipherAlgorithm())) {
            try {
                this.cipherLite.doFinal();
            } catch (BadPaddingException | IllegalBlockSizeException unused) {
            }
        }
        this.currPos = 0;
        this.maxPos = 0;
        abortIfNeeded();
    }

    public boolean markSupported() {
        abortIfNeeded();
        return this.in.markSupported() && this.cipherLite.markSupported();
    }

    public void mark(int i) {
        abortIfNeeded();
        this.in.mark(i);
        this.cipherLite.mark();
    }

    public void reset() throws IOException {
        abortIfNeeded();
        this.in.reset();
        this.cipherLite.reset();
        resetInternal();
    }

    /* access modifiers changed from: package-private */
    public final void resetInternal() {
        if (markSupported()) {
            this.currPos = 0;
            this.maxPos = 0;
            this.eof = false;
        }
    }

    private int nextChunk() throws IOException {
        abortIfNeeded();
        if (this.eof) {
            return -1;
        }
        this.bufout = null;
        int read = this.in.read(this.bufin);
        int i = 0;
        if (read == -1) {
            this.eof = true;
            if (!this.multipart || this.lastMultiPart) {
                try {
                    byte[] doFinal = this.cipherLite.doFinal();
                    this.bufout = doFinal;
                    if (doFinal == null) {
                        return -1;
                    }
                    this.currPos = 0;
                    int length = doFinal.length;
                    this.maxPos = length;
                    return length;
                } catch (IllegalBlockSizeException unused) {
                } catch (BadPaddingException e) {
                    if (S3CryptoScheme.isAesGcm(this.cipherLite.getCipherAlgorithm())) {
                        throw new SecurityException(e);
                    }
                }
            }
            return -1;
        }
        byte[] update = this.cipherLite.update(this.bufin, 0, read);
        this.bufout = update;
        this.currPos = 0;
        if (update != null) {
            i = update.length;
        }
        this.maxPos = i;
        return i;
    }

    /* access modifiers changed from: package-private */
    public void renewCipherLite() {
        this.cipherLite = this.cipherLite.recreate();
    }
}
