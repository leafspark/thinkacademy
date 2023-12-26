package com.igexin.b.a.b.a.a;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

public class p {
    private BufferedOutputStream a;

    public p(OutputStream outputStream) {
        this.a = new BufferedOutputStream(outputStream);
    }

    public void a(byte[] bArr) {
        this.a.write(bArr, 0, bArr.length);
        this.a.flush();
    }
}
