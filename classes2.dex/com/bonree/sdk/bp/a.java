package com.bonree.sdk.bp;

import com.bonree.sdk.bp.v;
import com.bonree.sdk.br.g;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Inet4Address;

public class a extends k<Inet4Address> {
    private static /* synthetic */ boolean b = true;

    public final v.b a() {
        return v.b.A;
    }

    public a(Inet4Address inet4Address) {
        super(inet4Address);
        if (!b && this.a.length != 4) {
            throw new AssertionError();
        }
    }

    private a(int i, int i2, int i3, int i4) {
        super(new byte[]{(byte) i, (byte) i2, (byte) i3, (byte) i4});
        if (i < 0 || i > 255 || i2 < 0 || i2 > 255 || i3 < 0 || i3 > 255 || i4 < 0 || i4 > 255) {
            throw new IllegalArgumentException();
        }
    }

    private a(byte[] bArr) {
        super(bArr);
    }

    private a(CharSequence charSequence) {
        this(g.a(charSequence));
    }

    public static a a(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[4];
        dataInputStream.readFully(bArr);
        return new a(bArr);
    }

    public String toString() {
        return Integer.toString(this.a[0] & 255) + "." + Integer.toString(this.a[1] & 255) + "." + Integer.toString(this.a[2] & 255) + "." + Integer.toString(this.a[3] & 255);
    }
}
