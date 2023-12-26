package com.bonree.sdk.bp;

import com.bonree.sdk.bp.v;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public abstract class h {
    private byte[] a;
    private transient Integer b;

    public abstract v.b a();

    /* access modifiers changed from: protected */
    public abstract void a(DataOutputStream dataOutputStream) throws IOException;

    private void d() {
        if (this.a == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                a(new DataOutputStream(byteArrayOutputStream));
                this.a = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    public final int b() {
        d();
        return this.a.length;
    }

    private void a(OutputStream outputStream) throws IOException {
        b(new DataOutputStream(outputStream));
    }

    public final void b(DataOutputStream dataOutputStream) throws IOException {
        d();
        dataOutputStream.write(this.a);
    }

    public final byte[] c() {
        d();
        return (byte[]) this.a.clone();
    }

    public final int hashCode() {
        if (this.b == null) {
            d();
            this.b = Integer.valueOf(Arrays.hashCode(this.a));
        }
        return this.b.intValue();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        h hVar = (h) obj;
        hVar.d();
        d();
        return Arrays.equals(this.a, hVar.a);
    }
}
