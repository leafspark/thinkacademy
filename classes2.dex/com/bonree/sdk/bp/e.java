package com.bonree.sdk.bp;

import com.bonree.sdk.bk.a;
import com.bonree.sdk.bp.v;
import java.io.DataInputStream;
import java.io.IOException;

public final class e extends u {
    public static e a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new e(a.a(dataInputStream, bArr));
    }

    private e(String str) {
        this(a.a(str));
    }

    public e(a aVar) {
        super(aVar);
    }

    public final v.b a() {
        return v.b.DNAME;
    }
}
