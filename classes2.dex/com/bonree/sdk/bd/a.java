package com.bonree.sdk.bd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class a {
    private static final byte e = 54;
    private static final byte f = 92;
    private MessageDigest a;
    private int b;
    private byte[] c;
    private byte[] d;

    private void c(byte[] bArr) {
        if (bArr.length > this.b) {
            bArr = this.a.digest(bArr);
            this.a.reset();
        }
        int i = this.b;
        this.c = new byte[i];
        this.d = new byte[i];
        int i2 = 0;
        while (i2 < bArr.length) {
            this.c[i2] = (byte) (54 ^ bArr[i2]);
            this.d[i2] = (byte) (92 ^ bArr[i2]);
            i2++;
        }
        while (i2 < this.b) {
            this.c[i2] = e;
            this.d[i2] = f;
            i2++;
        }
        this.a.update(this.c);
    }

    private a(MessageDigest messageDigest, int i, byte[] bArr) {
        messageDigest.reset();
        this.a = messageDigest;
        this.b = 64;
        c(bArr);
    }

    public a(String str, int i, byte[] bArr) {
        try {
            this.a = MessageDigest.getInstance(str);
            this.b = i;
            c(bArr);
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalArgumentException("unknown digest algorithm " + str);
        }
    }

    private a(MessageDigest messageDigest, byte[] bArr) {
        this(messageDigest, 64, bArr);
    }

    private a(String str, byte[] bArr) {
        this(str, 64, bArr);
    }

    public final void a(byte[] bArr, int i, int i2) {
        this.a.update(bArr, i, i2);
    }

    public final void a(byte[] bArr) {
        this.a.update(bArr);
    }

    public final byte[] a() {
        byte[] digest = this.a.digest();
        this.a.reset();
        this.a.update(this.d);
        return this.a.digest(digest);
    }

    public final boolean b(byte[] bArr) {
        return a(bArr, false);
    }

    public final boolean a(byte[] bArr, boolean z) {
        byte[] a2 = a();
        if (z && bArr.length < a2.length) {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(a2, 0, bArr2, 0, length);
            a2 = bArr2;
        }
        return Arrays.equals(bArr, a2);
    }

    public final void b() {
        this.a.reset();
        this.a.update(this.c);
    }

    public final int c() {
        return this.a.getDigestLength();
    }
}
