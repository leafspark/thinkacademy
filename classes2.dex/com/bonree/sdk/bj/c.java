package com.bonree.sdk.bj;

import com.bonree.sdk.bj.a;
import com.bonree.sdk.bk.a;
import com.bonree.sdk.bp.v;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class c {
    private static /* synthetic */ boolean f = true;
    public final a a;
    public final v.b b;
    public final v.a c;
    private final boolean d;
    private byte[] e;

    private c(CharSequence charSequence, v.b bVar, v.a aVar, boolean z) {
        this(a.a(charSequence), bVar, aVar, z);
    }

    private c(a aVar, v.b bVar, v.a aVar2, boolean z) {
        boolean z2 = f;
        if (!z2 && aVar == null) {
            throw new AssertionError();
        } else if (!z2 && bVar == null) {
            throw new AssertionError();
        } else if (z2 || aVar2 != null) {
            this.a = aVar;
            this.b = bVar;
            this.c = aVar2;
            this.d = z;
        } else {
            throw new AssertionError();
        }
    }

    public c(a aVar, v.b bVar, v.a aVar2) {
        this(aVar, bVar, aVar2, false);
    }

    public c(a aVar, v.b bVar) {
        this(aVar, bVar, v.a.IN);
    }

    public c(CharSequence charSequence, v.b bVar, v.a aVar) {
        this(a.a(charSequence), bVar, aVar);
    }

    public c(CharSequence charSequence, v.b bVar) {
        this(a.a(charSequence), bVar);
    }

    public c(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        this.a = a.a(dataInputStream, bArr);
        this.b = v.b.a(dataInputStream.readUnsignedShort());
        this.c = v.a.a(dataInputStream.readUnsignedShort());
        this.d = false;
    }

    public final byte[] a() {
        if (this.e == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                this.a.a((OutputStream) dataOutputStream);
                dataOutputStream.writeShort(this.b.a());
                dataOutputStream.writeShort(this.c.a() | (this.d ? 32768 : 0));
                dataOutputStream.flush();
                this.e = byteArrayOutputStream.toByteArray();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        return this.e;
    }

    public int hashCode() {
        return Arrays.hashCode(a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return Arrays.equals(a(), ((c) obj).a());
    }

    public String toString() {
        return this.a.a() + ".\t" + this.c + 9 + this.b;
    }

    public final a.C0014a b() {
        a.C0014a f2 = a.f();
        f2.b(this);
        return f2;
    }

    private a c() {
        return b().b();
    }
}
