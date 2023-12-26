package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5DigestCalculatingInputStream extends SdkFilterInputStream {
    private MessageDigest digest = newMD5();
    private MessageDigest digestLastMarked;

    public MD5DigestCalculatingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    private MessageDigest newMD5() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("unexpected", e);
        }
    }

    private MessageDigest cloneFrom(MessageDigest messageDigest) {
        try {
            return (MessageDigest) messageDigest.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("unexpected", e);
        }
    }

    public byte[] getMd5Digest() {
        return this.digest.digest();
    }

    public void mark(int i) {
        if (markSupported()) {
            super.mark(i);
            this.digestLastMarked = cloneFrom(this.digest);
        }
    }

    public void reset() throws IOException {
        MessageDigest messageDigest;
        if (markSupported()) {
            super.reset();
            MessageDigest messageDigest2 = this.digestLastMarked;
            if (messageDigest2 == null) {
                messageDigest = newMD5();
            } else {
                messageDigest = cloneFrom(messageDigest2);
            }
            this.digest = messageDigest;
            return;
        }
        throw new IOException("mark/reset not supported");
    }

    public int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.digest.update((byte) read);
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.digest.update(bArr, i, read);
        }
        return read;
    }
}
