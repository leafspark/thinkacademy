package com.igexin.push.d.c;

import com.bumptech.glide.load.Key;
import com.igexin.b.a.b.e;
import com.igexin.push.util.EncryptUtils;

public class g extends c {
    public String a;
    public byte[] b;
    public byte c;
    public String d;

    public g() {
        this.i = 96;
        this.j = 4;
        this.k = (byte) (this.k | 16);
    }

    private String a(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, Key.STRING_CHARSET_NAME);
        } catch (Exception unused) {
            return "";
        }
    }

    public void a(byte[] bArr) {
        try {
            this.c = bArr[0];
            byte b2 = bArr[1] & 255;
            this.a = a(bArr, 2, b2);
            int i = 2 + b2;
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            byte[] bArr2 = new byte[i3];
            this.b = bArr2;
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            int i4 = i2 + i3;
            this.d = a(bArr, i4 + 1, bArr[i4] & 255);
        } catch (Exception unused) {
        }
    }

    public byte[] c() {
        byte[] bytes = this.a.getBytes();
        byte[] iv = EncryptUtils.getIV(e.b((int) (System.currentTimeMillis() / 1000)));
        byte[] socketAESKey = EncryptUtils.getSocketAESKey();
        byte[] bArr = new byte[(bytes.length + 2 + 2 + socketAESKey.length + 1 + iv.length)];
        int c2 = e.c(0, bArr, 0);
        int c3 = c2 + e.c((byte) bytes.length, bArr, c2);
        int a2 = c3 + e.a(bytes, 0, bArr, c3, bytes.length);
        int b2 = a2 + e.b((short) socketAESKey.length, bArr, a2);
        int a3 = b2 + e.a(socketAESKey, 0, bArr, b2, socketAESKey.length);
        e.a(iv, 0, bArr, a3 + e.c((byte) iv.length, bArr, a3), iv.length);
        return bArr;
    }
}
