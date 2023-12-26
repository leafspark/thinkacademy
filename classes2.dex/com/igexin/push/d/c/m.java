package com.igexin.push.d.c;

import com.bumptech.glide.load.Key;
import com.igexin.b.a.b.e;

public class m extends c {
    private static final String m = "com.igexin.push.d.c.m";
    public int a;
    public int b;
    public long c;
    public String d;
    public Object e;
    public Object f;
    public String g;
    public String h = Key.STRING_CHARSET_NAME;

    public m() {
        this.i = 26;
    }

    public void a(byte[] bArr) {
        int i;
        int i2;
        this.a = e.c(bArr, 0);
        this.b = bArr[2] & 192;
        this.h = a(bArr[2]);
        this.c = e.e(bArr, 3);
        byte b2 = bArr[11] & 255;
        try {
            this.d = new String(bArr, 12, b2, this.h);
        } catch (Exception unused) {
            this.d = "";
        }
        int i3 = 12 + b2;
        int i4 = 0;
        while (true) {
            i = i4 | (bArr[i3] & Byte.MAX_VALUE);
            if ((bArr[i3] & 128) == 0) {
                break;
            }
            i4 = i << 7;
            i3++;
        }
        int i5 = i3 + 1;
        if (i > 0) {
            if (this.b == 192) {
                byte[] bArr2 = new byte[i];
                this.e = bArr2;
                System.arraycopy(bArr, i5, bArr2, 0, i);
            } else {
                try {
                    this.e = new String(bArr, i5, i, this.h);
                } catch (Exception unused2) {
                }
            }
        }
        int i6 = i5 + i;
        int i7 = 0;
        while (true) {
            i2 = i7 | (bArr[i6] & Byte.MAX_VALUE);
            if ((bArr[i6] & 128) == 0) {
                break;
            }
            i7 = i2 << 7;
            i6++;
        }
        int i8 = i6 + 1;
        if (i2 > 0) {
            byte[] bArr3 = new byte[i2];
            this.f = bArr3;
            System.arraycopy(bArr, i8, bArr3, 0, i2);
        }
        int i9 = i8 + i2;
        if (bArr.length > i9) {
            try {
                this.g = new String(bArr, i9 + 1, bArr[i9] & 255, this.h);
            } catch (Exception unused3) {
            }
        }
    }

    public final boolean b() {
        return this.b == 128;
    }

    public byte[] c() {
        byte[] bArr = null;
        try {
            byte[] bytes = this.d.getBytes(this.h);
            byte[] bytes2 = this.g.getBytes(this.h);
            byte[] bytes3 = !"".equals(this.e) ? this.b == 192 ? (byte[]) this.e : ((String) this.e).getBytes(this.h) : null;
            Object obj = this.f;
            byte[] bArr2 = obj != null ? (byte[]) obj : null;
            int length = bytes3 == null ? 0 : bytes3.length;
            int length2 = bArr2 == null ? 0 : bArr2.length;
            byte[] a2 = e.a(length);
            byte[] a3 = e.a(length2);
            bArr = new byte[(bytes.length + 13 + a2.length + length + a3.length + length2 + bytes2.length)];
            int b2 = e.b(this.a, bArr, 0);
            int c2 = b2 + e.c(this.b | a(this.h), bArr, b2);
            int a4 = c2 + e.a(this.c, bArr, c2);
            int c3 = a4 + e.c(bytes.length, bArr, a4);
            int a5 = c3 + e.a(bytes, 0, bArr, c3, bytes.length);
            int a6 = a5 + e.a(a2, 0, bArr, a5, a2.length);
            if (length > 0) {
                a6 += e.a(bytes3, 0, bArr, a6, length);
            }
            int a7 = a6 + e.a(a3, 0, bArr, a6, a3.length);
            if (length2 > 0) {
                a7 += e.a(bArr2, 0, bArr, a7, length2);
            }
            e.a(bytes2, 0, bArr, a7 + e.c(bytes2.length, bArr, a7), bytes2.length);
        } catch (Exception unused) {
        }
        return bArr;
    }

    public final void d() {
        this.b = 128;
    }
}
