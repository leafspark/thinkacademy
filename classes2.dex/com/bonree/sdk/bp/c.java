package com.bonree.sdk.bp;

import com.bonree.sdk.bk.a;
import com.bonree.sdk.bp.v;
import java.io.DataInputStream;
import java.io.IOException;

public final class c extends u {
    public static c a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new c(a.a(dataInputStream, bArr));
    }

    private c(String str) {
        this(a.a(str));
    }

    public c(a aVar) {
        super(aVar);
    }

    public final v.b a() {
        return v.b.CNAME;
    }
}
