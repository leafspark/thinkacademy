package com.bonree.sdk.bp;

import com.bonree.sdk.bh.b;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public abstract class i extends h {
    private static /* synthetic */ boolean i = true;
    private int a;
    private b.C0013b b;
    private byte c;
    private b.a d;
    private byte e;
    private byte[] f;
    private transient BigInteger g;
    private transient String h;

    protected static a b(DataInputStream dataInputStream, int i2) throws IOException {
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        byte readByte = dataInputStream.readByte();
        byte readByte2 = dataInputStream.readByte();
        int i3 = i2 - 4;
        byte[] bArr = new byte[i3];
        if (dataInputStream.read(bArr) == i3) {
            return new a(readUnsignedShort, readByte, readByte2, bArr, (byte) 0);
        }
        throw new IOException();
    }

    public static final class a {
        protected final int a;
        protected final byte b;
        protected final byte c;
        protected final byte[] d;

        /* synthetic */ a(int i, byte b2, byte b3, byte[] bArr, byte b4) {
            this(i, b2, b3, bArr);
        }

        private a(int i, byte b2, byte b3, byte[] bArr) {
            this.a = i;
            this.b = b2;
            this.c = b3;
            this.d = bArr;
        }
    }

    private i(int i2, b.C0013b bVar, byte b2, b.a aVar, byte b3, byte[] bArr) {
        this.a = i2;
        if (!i) {
            if (b2 != (bVar != null ? bVar.number : b2)) {
                throw new AssertionError();
            }
        }
        this.c = b2;
        this.b = bVar == null ? b.C0013b.a(b2) : bVar;
        if (!i) {
            if (b3 != (aVar != null ? aVar.value : b3)) {
                throw new AssertionError();
            }
        }
        this.e = b3;
        this.d = aVar == null ? b.a.a(b3) : aVar;
        if (i || bArr != null) {
            this.f = bArr;
            return;
        }
        throw new AssertionError();
    }

    protected i(int i2, byte b2, byte b3, byte[] bArr) {
        this(i2, (b.C0013b) null, b2, (b.a) null, b3, bArr);
    }

    protected i(int i2, b.C0013b bVar, b.a aVar, byte[] bArr) {
        this(i2, bVar, bVar.number, aVar, aVar.value, bArr);
    }

    protected i(int i2, b.C0013b bVar, byte b2, byte[] bArr) {
        this(i2, bVar, bVar.number, (b.a) null, b2, bArr);
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.a);
        dataOutputStream.writeByte(this.c);
        dataOutputStream.writeByte(this.e);
        dataOutputStream.write(this.f);
    }

    public String toString() {
        return this.a + ' ' + this.b + ' ' + this.d + ' ' + new BigInteger(1, this.f).toString(16).toUpperCase();
    }

    private BigInteger d() {
        if (this.g == null) {
            this.g = new BigInteger(1, this.f);
        }
        return this.g;
    }

    private String e() {
        if (this.h == null) {
            if (this.g == null) {
                this.g = new BigInteger(1, this.f);
            }
            this.h = this.g.toString(16).toUpperCase();
        }
        return this.h;
    }

    private boolean a(byte[] bArr) {
        return Arrays.equals(this.f, bArr);
    }
}
