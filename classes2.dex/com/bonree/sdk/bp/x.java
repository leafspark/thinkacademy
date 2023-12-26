package com.bonree.sdk.bp;

import com.bonree.sdk.bk.a;
import com.bonree.sdk.bp.v;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class x extends h {
    private a a;
    private a b;
    private long c;
    private int d;
    private int e;
    private int f;
    private long g;

    public static x a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new x(a.a(dataInputStream, bArr), a.a(dataInputStream, bArr), ((long) dataInputStream.readInt()) & 4294967295L, dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readInt(), ((long) dataInputStream.readInt()) & 4294967295L);
    }

    private x(String str, String str2, long j, int i, int i2, int i3, long j2) {
        this(a.a(str), a.a(str2), j, i, i2, i3, j2);
    }

    public x(a aVar, a aVar2, long j, int i, int i2, int i3, long j2) {
        this.a = aVar;
        this.b = aVar2;
        this.c = j;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = j2;
    }

    public final v.b a() {
        return v.b.SOA;
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        this.a.a((OutputStream) dataOutputStream);
        this.b.a((OutputStream) dataOutputStream);
        dataOutputStream.writeInt((int) this.c);
        dataOutputStream.writeInt(this.d);
        dataOutputStream.writeInt(this.e);
        dataOutputStream.writeInt(this.f);
        dataOutputStream.writeInt((int) this.g);
    }

    public final String toString() {
        return this.a + ". " + this.b + ". " + this.c + ' ' + this.d + ' ' + this.e + ' ' + this.f + ' ' + this.g;
    }
}
