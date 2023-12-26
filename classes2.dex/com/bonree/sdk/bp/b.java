package com.bonree.sdk.bp;

import com.bonree.sdk.bp.v;
import com.bonree.sdk.br.g;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Inet6Address;

public class b extends k<Inet6Address> {
    private static /* synthetic */ boolean b = true;

    public final v.b a() {
        return v.b.AAAA;
    }

    public b(Inet6Address inet6Address) {
        super(inet6Address);
        if (!b && this.a.length != 16) {
            throw new AssertionError();
        }
    }

    private b(byte[] bArr) {
        super(bArr);
    }

    private b(CharSequence charSequence) {
        this(g.b(charSequence));
    }

    public static b a(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[16];
        dataInputStream.readFully(bArr);
        return new b(bArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.a.length; i += 2) {
            if (i != 0) {
                sb.append(':');
            }
            sb.append(Integer.toHexString(((this.a[i] & 255) << 8) + (this.a[i + 1] & 255)));
        }
        return sb.toString();
    }
}
