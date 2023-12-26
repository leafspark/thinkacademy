package com.bonree.sdk.bp;

import com.bonree.sdk.ah.c;
import com.bonree.sdk.bi.b;
import com.bonree.sdk.bp.v;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class o extends h {
    private static byte a = 1;
    /* access modifiers changed from: private */
    public static final Map<Byte, a> b = new HashMap();
    private static /* synthetic */ boolean m = true;
    private a c;
    private byte d;
    private byte e;
    private int f;
    private final byte[] g;
    private final byte[] h;
    private final byte[] i;
    private List<v.b> j;
    private String k;
    private b l;

    public enum a {
        RESERVED(0, "Reserved"),
        SHA1(1, "SHA-1");
        
        public final String description;
        public final byte value;

        private a(int i, String str) {
            if (i < 0 || i > 255) {
                throw new IllegalArgumentException();
            }
            byte b = (byte) i;
            this.value = b;
            this.description = str;
            o.b.put(Byte.valueOf(b), this);
        }

        public static a a(byte b) {
            return (a) o.b.get(Byte.valueOf(b));
        }
    }

    public static o a(DataInputStream dataInputStream, int i2) throws IOException {
        byte readByte = dataInputStream.readByte();
        byte readByte2 = dataInputStream.readByte();
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        byte[] bArr = new byte[readUnsignedByte];
        if (dataInputStream.read(bArr) == readUnsignedByte) {
            int readUnsignedByte2 = dataInputStream.readUnsignedByte();
            byte[] bArr2 = new byte[readUnsignedByte2];
            if (dataInputStream.read(bArr2) == readUnsignedByte2) {
                int i3 = i2 - ((readUnsignedByte + 6) + readUnsignedByte2);
                byte[] bArr3 = new byte[i3];
                if (dataInputStream.read(bArr3) == i3) {
                    return new o(readByte, readByte2, readUnsignedShort, bArr, bArr2, n.a(bArr3));
                }
                throw new IOException();
            }
            throw new IOException();
        }
        throw new IOException();
    }

    private o(a aVar, byte b2, byte b3, int i2, byte[] bArr, byte[] bArr2, List<v.b> list) {
        boolean z = m;
        this.d = b2;
        this.c = a.a(b2);
        this.e = b3;
        this.f = i2;
        this.g = bArr;
        this.h = bArr2;
        this.j = list;
        this.i = n.a(list);
    }

    private o(byte b2, byte b3, int i2, byte[] bArr, byte[] bArr2, List<v.b> list) {
        this((a) null, b2, b3, i2, bArr, bArr2, list);
    }

    private o(byte b2, byte b3, int i2, byte[] bArr, byte[] bArr2, v.b... bVarArr) {
        this((a) null, b2, b3, i2, bArr, bArr2, Arrays.asList(bVarArr));
    }

    public final v.b a() {
        return v.b.NSEC3;
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.d);
        dataOutputStream.writeByte(this.e);
        dataOutputStream.writeShort(this.f);
        dataOutputStream.writeByte(this.g.length);
        dataOutputStream.write(this.g);
        dataOutputStream.writeByte(this.h.length);
        dataOutputStream.write(this.h);
        dataOutputStream.write(this.i);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        sb.append(' ');
        sb.append(this.e);
        sb.append(' ');
        sb.append(this.f);
        sb.append(' ');
        if (this.g.length == 0) {
            str = "-";
        } else {
            str = new BigInteger(1, this.g).toString(16).toUpperCase();
        }
        sb.append(str);
        sb.append(' ');
        sb.append(c.a(this.h));
        for (v.b append : this.j) {
            sb.append(' ');
            sb.append(append);
        }
        return sb.toString();
    }

    private byte[] e() {
        return (byte[]) this.g.clone();
    }

    private int f() {
        return this.g.length;
    }

    private byte[] g() {
        return (byte[]) this.h.clone();
    }

    private String h() {
        if (this.k == null) {
            this.k = c.a(this.h);
        }
        return this.k;
    }

    private b i() {
        if (this.l == null) {
            if (this.k == null) {
                this.k = c.a(this.h);
            }
            this.l = b.a(this.k);
        }
        return this.l;
    }

    private void a(byte[] bArr, int i2) {
        byte[] bArr2 = this.g;
        System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
    }
}
