package com.bonree.sdk.bp;

import com.bonree.sdk.bp.v;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class z extends h {
    /* access modifiers changed from: private */
    public static final Map<Byte, a> a = new HashMap();
    /* access modifiers changed from: private */
    public static final Map<Byte, c> b = new HashMap();
    /* access modifiers changed from: private */
    public static final Map<Byte, b> c = new HashMap();
    private byte d;
    private a e;
    private byte f;
    private c g;
    private byte h;
    private b i;
    private final byte[] j;

    static {
        a.values();
        c.values();
        b.values();
    }

    public enum a {
        caConstraint((byte) 0),
        serviceCertificateConstraint((byte) 1),
        trustAnchorAssertion((byte) 2),
        domainIssuedCertificate((byte) 3);
        
        public final byte byteValue;

        private a(byte b) {
            this.byteValue = b;
            z.a.put(Byte.valueOf(b), this);
        }
    }

    public enum c {
        fullCertificate((byte) 0),
        subjectPublicKeyInfo((byte) 1);
        
        public final byte byteValue;

        private c(byte b) {
            this.byteValue = b;
            z.b.put(Byte.valueOf(b), this);
        }
    }

    public enum b {
        noHash((byte) 0),
        sha256((byte) 1),
        sha512((byte) 2);
        
        public final byte byteValue;

        private b(byte b) {
            this.byteValue = b;
            z.c.put(Byte.valueOf(b), this);
        }
    }

    public static z a(DataInputStream dataInputStream, int i2) throws IOException {
        byte readByte = dataInputStream.readByte();
        byte readByte2 = dataInputStream.readByte();
        byte readByte3 = dataInputStream.readByte();
        int i3 = i2 - 3;
        byte[] bArr = new byte[i3];
        if (dataInputStream.read(bArr) == i3) {
            return new z(readByte, readByte2, readByte3, bArr);
        }
        throw new IOException();
    }

    private z(byte b2, byte b3, byte b4, byte[] bArr) {
        this.d = b2;
        this.e = a.get(Byte.valueOf(b2));
        this.f = b3;
        this.g = b.get(Byte.valueOf(b3));
        this.h = b4;
        this.i = c.get(Byte.valueOf(b4));
        this.j = bArr;
    }

    public final v.b a() {
        return v.b.TLSA;
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.d);
        dataOutputStream.writeByte(this.f);
        dataOutputStream.writeByte(this.h);
        dataOutputStream.write(this.j);
    }

    public final String toString() {
        return this.d + ' ' + this.f + ' ' + this.h + ' ' + new BigInteger(1, this.j).toString(16);
    }

    private byte[] g() {
        return (byte[]) this.j.clone();
    }

    private boolean a(byte[] bArr) {
        return Arrays.equals(this.j, bArr);
    }
}
