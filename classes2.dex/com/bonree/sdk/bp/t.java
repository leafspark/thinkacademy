package com.bonree.sdk.bp;

import com.bonree.sdk.bh.b;
import com.bonree.sdk.bk.a;
import com.bonree.sdk.bp.v;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class t extends h {
    private static /* synthetic */ boolean l = true;
    public final v.b a;
    private b.C0013b b;
    private byte c;
    private byte d;
    private long e;
    private Date f;
    private Date g;
    private int h;
    private a i;
    private final byte[] j;
    private transient String k;

    public static t a(DataInputStream dataInputStream, byte[] bArr, int i2) throws IOException {
        v.b a2 = v.b.a(dataInputStream.readUnsignedShort());
        byte readByte = dataInputStream.readByte();
        byte readByte2 = dataInputStream.readByte();
        long readInt = ((long) dataInputStream.readInt()) & 4294967295L;
        Date date = new Date((((long) dataInputStream.readInt()) & 4294967295L) * 1000);
        Date date2 = new Date((4294967295L & ((long) dataInputStream.readInt())) * 1000);
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        a a3 = a.a(dataInputStream, bArr);
        int b2 = (i2 - a3.b()) - 18;
        byte[] bArr2 = new byte[b2];
        if (dataInputStream.read(bArr2) == b2) {
            return new t(a2, (b.C0013b) null, readByte, readByte2, readInt, date, date2, readUnsignedShort, a3, bArr2);
        }
        throw new IOException();
    }

    private t(v.b bVar, b.C0013b bVar2, byte b2, byte b3, long j2, Date date, Date date2, int i2, a aVar, byte[] bArr) {
        this.a = bVar;
        boolean z = l;
        this.c = b2;
        this.b = b.C0013b.a(b2);
        this.d = b3;
        this.e = j2;
        this.f = date;
        this.g = date2;
        this.h = i2;
        this.i = aVar;
        this.j = bArr;
    }

    private t(v.b bVar, int i2, byte b2, long j2, Date date, Date date2, int i3, a aVar, byte[] bArr) {
        this(bVar, (b.C0013b) null, (byte) i2, b2, j2, date, date2, i3, aVar, bArr);
    }

    private t(v.b bVar, int i2, byte b2, long j2, Date date, Date date2, int i3, String str, byte[] bArr) {
        this(bVar, (b.C0013b) null, (byte) i2, b2, j2, date, date2, i3, a.a(str), bArr);
    }

    private t(v.b bVar, b.C0013b bVar2, byte b2, long j2, Date date, Date date2, int i2, a aVar, byte[] bArr) {
        this(bVar, (int) bVar2.number, b2, j2, date, date2, i2, aVar, bArr);
    }

    private t(v.b bVar, b.C0013b bVar2, byte b2, long j2, Date date, Date date2, int i2, String str, byte[] bArr) {
        this(bVar, (int) bVar2.number, b2, j2, date, date2, i2, a.a(str), bArr);
    }

    private byte[] d() {
        return (byte[]) this.j.clone();
    }

    private DataInputStream e() {
        return new DataInputStream(new ByteArrayInputStream(this.j));
    }

    private int f() {
        return this.j.length;
    }

    private String g() {
        if (this.k == null) {
            this.k = com.bonree.sdk.ai.b.a(this.j);
        }
        return this.k;
    }

    public final v.b a() {
        return v.b.RRSIG;
    }

    private void c(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.a.a());
        dataOutputStream.writeByte(this.c);
        dataOutputStream.writeByte(this.d);
        dataOutputStream.writeInt((int) this.e);
        dataOutputStream.writeInt((int) (this.f.getTime() / 1000));
        dataOutputStream.writeInt((int) (this.g.getTime() / 1000));
        dataOutputStream.writeShort(this.h);
        this.i.a((OutputStream) dataOutputStream);
    }

    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return this.a + ' ' + this.b + ' ' + this.d + ' ' + this.e + ' ' + simpleDateFormat.format(this.f) + ' ' + simpleDateFormat.format(this.g) + ' ' + this.h + ' ' + this.i + ". " + g();
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.a.a());
        dataOutputStream.writeByte(this.c);
        dataOutputStream.writeByte(this.d);
        dataOutputStream.writeInt((int) this.e);
        dataOutputStream.writeInt((int) (this.f.getTime() / 1000));
        dataOutputStream.writeInt((int) (this.g.getTime() / 1000));
        dataOutputStream.writeShort(this.h);
        this.i.a((OutputStream) dataOutputStream);
        dataOutputStream.write(this.j);
    }
}
