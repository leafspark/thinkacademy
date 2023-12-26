package com.igexin.b.a.b.a.a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class o {
    BufferedInputStream a;

    public o(InputStream inputStream) {
        this.a = new BufferedInputStream(inputStream);
    }

    public int a(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            i2 = this.a.read(bArr, i, length - i);
            if (i2 > 0) {
                i += i2;
            } else {
                throw new IOException("read = -1, end of stream !");
            }
        }
        return i2;
    }
}
