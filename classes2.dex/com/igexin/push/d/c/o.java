package com.igexin.push.d.c;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.igexin.b.a.b.e;

public class o extends c {
    public long a;
    public String b = "";
    public String c = "";
    public String d = "";

    public o() {
        this.i = 9;
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
        int i = 8;
        if (bArr.length > 8) {
            byte b2 = bArr[8] & 255;
            if (b2 > 0) {
                this.b = a(bArr, 9, b2);
                i = b2 + 9;
            } else {
                i = 9;
            }
        }
        if (bArr.length > i) {
            int i2 = i + 1;
            byte b3 = bArr[i] & 255;
            if (b3 > 0) {
                this.c = a(bArr, i2, b3);
                i = b3 + i2;
            } else {
                i = i2;
            }
        }
        if (bArr.length > i) {
            int i3 = i + 1;
            byte b4 = bArr[i] & 255;
            if (b4 > 0) {
                this.d = a(bArr, i3, b4);
            }
        }
    }

    public byte[] c() {
        if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d)) {
            byte[] bytes = this.b.getBytes();
            byte[] bArr = new byte[(bytes.length + 8 + 1)];
            e.a(this.a, bArr, 0);
            e.c(bytes.length, bArr, 8);
            System.arraycopy(bytes, 0, bArr, 9, bytes.length);
            return bArr;
        }
        byte[] bytes2 = this.b.getBytes();
        byte[] bytes3 = this.c.getBytes();
        byte[] bytes4 = this.d.getBytes();
        byte[] bArr2 = new byte[(bytes2.length + 8 + bytes3.length + bytes4.length + 3)];
        e.a(this.a, bArr2, 0);
        e.c(bytes2.length, bArr2, 8);
        System.arraycopy(bytes2, 0, bArr2, 9, bytes2.length);
        int length = 9 + bytes2.length;
        int i = length + 1;
        e.c(bytes3.length, bArr2, length);
        System.arraycopy(bytes3, 0, bArr2, i, bytes3.length);
        int length2 = i + bytes3.length;
        e.c(bytes4.length, bArr2, length2);
        System.arraycopy(bytes4, 0, bArr2, length2 + 1, bytes4.length);
        return bArr2;
    }
}
