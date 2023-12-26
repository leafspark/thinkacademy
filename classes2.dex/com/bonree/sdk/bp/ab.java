package com.bonree.sdk.bp;

import com.bonree.sdk.bp.v;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class ab extends h {
    private final v.b a;
    private final byte[] b;

    private ab(DataInputStream dataInputStream, int i, v.b bVar) throws IOException {
        this.a = bVar;
        byte[] bArr = new byte[i];
        this.b = bArr;
        dataInputStream.readFully(bArr);
    }

    public final v.b a() {
        return this.a;
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.b);
    }

    public static ab a(DataInputStream dataInputStream, int i, v.b bVar) throws IOException {
        return new ab(dataInputStream, i, bVar);
    }
}
