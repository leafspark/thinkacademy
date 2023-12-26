package com.bonree.sdk.bn;

import com.bonree.sdk.bn.a;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class c {
    protected final byte[] a;
    private int b;
    private int c;
    private String d;
    private String e;

    public abstract a.b a();

    /* access modifiers changed from: protected */
    public abstract CharSequence b();

    /* access modifiers changed from: protected */
    public abstract CharSequence d();

    protected c(int i, byte[] bArr) {
        this.b = i;
        this.c = bArr.length;
        this.a = bArr;
    }

    protected c(byte[] bArr) {
        this.b = a().asInt;
        this.c = bArr.length;
        this.a = bArr;
    }

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.b);
        dataOutputStream.writeShort(this.c);
        dataOutputStream.write(this.a);
    }

    public final String toString() {
        if (this.d == null) {
            this.d = b().toString();
        }
        return this.d;
    }

    public final String c() {
        if (this.e == null) {
            this.e = d().toString();
        }
        return this.e;
    }

    public static c a(int i, byte[] bArr) {
        if (d.a[a.b.a(i).ordinal()] != 1) {
            return new f(i, bArr);
        }
        return new e(bArr);
    }
}
