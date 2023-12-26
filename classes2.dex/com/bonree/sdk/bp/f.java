package com.bonree.sdk.bp;

import com.bonree.sdk.bh.b;
import com.bonree.sdk.bp.v;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class f extends h {
    private static short a = 1;
    private static short b = 128;
    private static short c = 256;
    private static byte d = 3;
    private static /* synthetic */ boolean m = true;
    private short e;
    private byte f;
    private b.C0013b g;
    private byte h;
    private final byte[] i;
    private transient Integer j;
    private transient String k;
    private transient BigInteger l;

    public static f a(DataInputStream dataInputStream, int i2) throws IOException {
        short readShort = dataInputStream.readShort();
        byte readByte = dataInputStream.readByte();
        byte readByte2 = dataInputStream.readByte();
        byte[] bArr = new byte[(i2 - 4)];
        dataInputStream.readFully(bArr);
        return new f(readShort, readByte, readByte2, bArr);
    }

    private f(short s, byte b2, b.C0013b bVar, byte b3, byte[] bArr) {
        this.e = s;
        this.f = b2;
        if (!m) {
            if (b3 != (bVar != null ? bVar.number : b3)) {
                throw new AssertionError();
            }
        }
        this.h = b3;
        this.g = bVar == null ? b.C0013b.a(b3) : bVar;
        this.i = bArr;
    }

    private f(short s, byte b2, byte b3, byte[] bArr) {
        this(s, b2, b.C0013b.a(b3), bArr);
    }

    private f(short s, byte b2, b.C0013b bVar, byte[] bArr) {
        this(s, b2, bVar, bVar.number, bArr);
    }

    public final v.b a() {
        return v.b.DNSKEY;
    }

    private int d() {
        if (this.j == null) {
            byte[] c2 = c();
            long j2 = 0;
            for (int i2 = 0; i2 < c2.length; i2++) {
                j2 += (i2 & 1) > 0 ? ((long) c2[i2]) & 255 : (((long) c2[i2]) & 255) << 8;
            }
            this.j = Integer.valueOf((int) ((j2 + ((j2 >> 16) & 65535)) & 65535));
        }
        return this.j.intValue();
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.e);
        dataOutputStream.writeByte(this.f);
        dataOutputStream.writeByte(this.g.number);
        dataOutputStream.write(this.i);
    }

    public String toString() {
        return this.e + ' ' + this.f + ' ' + this.g + ' ' + com.bonree.sdk.ai.b.a(this.i);
    }

    private int e() {
        return this.i.length;
    }

    private byte[] f() {
        return (byte[]) this.i.clone();
    }

    private DataInputStream g() {
        return new DataInputStream(new ByteArrayInputStream(this.i));
    }

    private String h() {
        if (this.k == null) {
            this.k = com.bonree.sdk.ai.b.a(this.i);
        }
        return this.k;
    }

    private BigInteger i() {
        if (this.l == null) {
            this.l = new BigInteger(this.i);
        }
        return this.l;
    }

    private boolean a(byte[] bArr) {
        return Arrays.equals(this.i, bArr);
    }

    private boolean j() {
        return (this.e & 1) == 1;
    }
}
