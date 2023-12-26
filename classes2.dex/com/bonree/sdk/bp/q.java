package com.bonree.sdk.bp;

import com.bonree.sdk.ai.b;
import com.bonree.sdk.bp.v;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class q extends h {
    private final byte[] a;
    private transient String b;

    public static q a(DataInputStream dataInputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        dataInputStream.readFully(bArr);
        return new q(bArr);
    }

    q(byte[] bArr) {
        this.a = bArr;
    }

    public final v.b a() {
        return v.b.OPENPGPKEY;
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.a);
    }

    private String d() {
        if (this.b == null) {
            this.b = b.a(this.a);
        }
        return this.b;
    }

    private byte[] e() {
        return (byte[]) this.a.clone();
    }

    public final String toString() {
        if (this.b == null) {
            this.b = b.a(this.a);
        }
        return this.b;
    }
}
