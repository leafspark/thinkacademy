package com.bonree.sdk.bp;

import com.bonree.sdk.bp.o;
import com.bonree.sdk.bp.v;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class p extends h {
    private static /* synthetic */ boolean f = true;
    private o.a a;
    private byte b;
    private byte c;
    private int d;
    private final byte[] e;

    public static p a(DataInputStream dataInputStream) throws IOException {
        byte readByte = dataInputStream.readByte();
        byte readByte2 = dataInputStream.readByte();
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        byte[] bArr = new byte[readUnsignedByte];
        if (dataInputStream.read(bArr) == readUnsignedByte || readUnsignedByte == 0) {
            return new p(readByte, readByte2, readUnsignedShort, bArr);
        }
        throw new IOException();
    }

    private p(o.a aVar, byte b2, byte b3, int i, byte[] bArr) {
        boolean z = f;
        this.b = b2;
        this.a = o.a.a(b2);
        this.c = b3;
        this.d = i;
        this.e = bArr;
    }

    private p(byte b2, byte b3, int i, byte[] bArr) {
        this((o.a) null, b2, b3, i, bArr);
    }

    public final v.b a() {
        return v.b.NSEC3PARAM;
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.b);
        dataOutputStream.writeByte(this.c);
        dataOutputStream.writeShort(this.d);
        dataOutputStream.writeByte(this.e.length);
        dataOutputStream.write(this.e);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(' ');
        sb.append(this.c);
        sb.append(' ');
        sb.append(this.d);
        sb.append(' ');
        if (this.e.length == 0) {
            str = "-";
        } else {
            str = new BigInteger(1, this.e).toString(16).toUpperCase();
        }
        sb.append(str);
        return sb.toString();
    }

    private int d() {
        return this.e.length;
    }
}
