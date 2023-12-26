package com.bonree.sdk.bp;

import com.bonree.sdk.bh.b;
import com.bonree.sdk.bp.i;
import com.bonree.sdk.bp.v;
import java.io.DataInputStream;
import java.io.IOException;

public final class d extends i {
    public static d a(DataInputStream dataInputStream, int i) throws IOException {
        i.a b = i.b(dataInputStream, i);
        return new d(b.a, b.b, b.c, b.d);
    }

    private d(int i, byte b, byte b2, byte[] bArr) {
        super(i, b, b2, bArr);
    }

    private d(int i, b.C0013b bVar, b.a aVar, byte[] bArr) {
        super(i, bVar, aVar, bArr);
    }

    public final v.b a() {
        return v.b.DLV;
    }
}
