package com.igexin.push.d.c;

import com.bumptech.glide.load.Key;
import com.igexin.b.a.b.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class i extends c {
    public long a;
    public byte b;
    public int c;
    public String d;
    public List<j> e;

    public i() {
        this.i = 4;
        this.j = 20;
    }

    private String a(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, Key.STRING_CHARSET_NAME);
        } catch (Exception unused) {
            return "";
        }
    }

    public void a(byte[] bArr) {
        this.a = e.e(bArr, 0);
        this.b = bArr[8];
        this.c = e.d(bArr, 9) & -1;
        int i = 13;
        if (bArr.length > 13) {
            int i2 = 14;
            byte b2 = bArr[13] & 255;
            if (b2 > 0) {
                this.e = new ArrayList();
                int i3 = b2 + 14;
                while (i2 < i3) {
                    j jVar = new j();
                    this.e.add(jVar);
                    int i4 = i2 + 1;
                    int a2 = e.a(bArr, i2) & 255;
                    int i5 = i4 + 1;
                    int a3 = e.a(bArr, i4) & 255;
                    jVar.a = (byte) a2;
                    if ((a2 == 1 || a2 == 4) && a3 > 0) {
                        try {
                            jVar.b = new String(bArr, i5, a3, Key.STRING_CHARSET_NAME);
                        } catch (Exception unused) {
                        }
                    }
                    i2 = i5 + a3;
                }
            }
            i = i2;
        }
        if (bArr.length > i) {
            this.d = a(bArr, i + 1, bArr[i] & 255);
        }
    }

    public byte[] c() {
        int i;
        int i2;
        List<j> list = this.e;
        byte[] bArr = null;
        if (list != null && list.size() > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (j c2 : this.e) {
                try {
                    byteArrayOutputStream.write(c2.c());
                    bArr = byteArrayOutputStream.toByteArray();
                } catch (IOException unused) {
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused2) {
            }
        }
        if (bArr != null) {
            i2 = bArr.length;
            i = i2 + 1;
        } else {
            i2 = 0;
            i = 1;
        }
        byte[] bArr2 = new byte[(i + 12 + this.d.getBytes().length + 1)];
        int a2 = e.a(this.a, bArr2, 0);
        int a3 = a2 + e.a(((this.b & 255) << 24) | this.c, bArr2, a2);
        int c3 = a3 + e.c(i2, bArr2, a3);
        if (i2 > 0) {
            c3 += e.a(bArr, 0, bArr2, c3, i2);
        }
        byte[] bytes = this.d.getBytes();
        e.c(bytes.length, bArr2, c3);
        System.arraycopy(bytes, 0, bArr2, c3 + 1, bytes.length);
        int length = bytes.length;
        return bArr2;
    }
}
