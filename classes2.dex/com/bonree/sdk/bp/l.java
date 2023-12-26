package com.bonree.sdk.bp;

import com.bonree.sdk.bk.a;
import com.bonree.sdk.bp.v;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class l extends h {
    private int a;
    private a b;
    @Deprecated
    private a c;

    public static l a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new l(dataInputStream.readUnsignedShort(), a.a(dataInputStream, bArr));
    }

    private l(int i, String str) {
        this(i, a.a(str));
    }

    public l(int i, a aVar) {
        this.a = i;
        this.b = aVar;
        this.c = aVar;
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.a);
        this.b.a((OutputStream) dataOutputStream);
    }

    public final String toString() {
        return this.a + " " + this.b + '.';
    }

    public final v.b a() {
        return v.b.MX;
    }
}
