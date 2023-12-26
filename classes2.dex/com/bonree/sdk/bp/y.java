package com.bonree.sdk.bp;

import com.bonree.sdk.bk.a;
import com.bonree.sdk.bp.v;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class y extends h implements Comparable<y> {
    public final int a;
    public final int b;
    public final a c;
    private int d;
    @Deprecated
    private a e;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        y yVar = (y) obj;
        int i = yVar.a - this.a;
        return i == 0 ? this.b - yVar.b : i;
    }

    public static y a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new y(dataInputStream.readUnsignedShort(), dataInputStream.readUnsignedShort(), dataInputStream.readUnsignedShort(), a.a(dataInputStream, bArr));
    }

    private y(int i, int i2, int i3, String str) {
        this(i, i2, i3, a.a(str));
    }

    private y(int i, int i2, int i3, a aVar) {
        this.a = i;
        this.b = i2;
        this.d = i3;
        this.c = aVar;
        this.e = aVar;
    }

    private boolean d() {
        return !this.c.c();
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.a);
        dataOutputStream.writeShort(this.b);
        dataOutputStream.writeShort(this.d);
        this.c.a((OutputStream) dataOutputStream);
    }

    public final String toString() {
        return this.a + " " + this.b + " " + this.d + " " + this.c + ".";
    }

    public final v.b a() {
        return v.b.SRV;
    }

    private int a(y yVar) {
        int i = yVar.a - this.a;
        return i == 0 ? this.b - yVar.b : i;
    }
}
