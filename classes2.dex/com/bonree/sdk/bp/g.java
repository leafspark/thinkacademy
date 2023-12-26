package com.bonree.sdk.bp;

import com.bonree.sdk.bh.b;
import com.bonree.sdk.bp.i;
import com.bonree.sdk.bp.v;
import java.io.DataInputStream;
import java.io.IOException;

public final class g extends i {
    public static g a(DataInputStream dataInputStream, int i) throws IOException {
        i.a b = i.b(dataInputStream, i);
        return new g(b.a, b.b, b.c, b.d);
    }

    private g(int i, byte b, byte b2, byte[] bArr) {
        super(i, b, b2, bArr);
    }

    private g(int i, b.C0013b bVar, byte b, byte[] bArr) {
        super(i, bVar, b, bArr);
    }

    private g(int i, b.C0013b bVar, b.a aVar, byte[] bArr) {
        super(i, bVar, aVar, bArr);
    }

    public final v.b a() {
        return v.b.DS;
    }
}
