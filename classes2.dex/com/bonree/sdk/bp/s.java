package com.bonree.sdk.bp;

import com.bonree.sdk.bk.a;
import com.bonree.sdk.bp.v;
import java.io.DataInputStream;
import java.io.IOException;

public final class s extends u {
    public static s a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new s(a.a(dataInputStream, bArr));
    }

    private s(String str) {
        this(a.a(str));
    }

    s(a aVar) {
        super(aVar);
    }

    public final v.b a() {
        return v.b.PTR;
    }
}
