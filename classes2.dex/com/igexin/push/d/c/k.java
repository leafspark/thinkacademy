package com.igexin.push.d.c;

import com.igexin.b.a.b.e;
import com.igexin.b.a.c.b;

public class k extends c {
    public boolean a;
    public boolean b;
    public String c;
    public String d;
    public long e;

    public k() {
        this.i = 5;
    }

    public void a(byte[] bArr) {
        byte b2 = bArr[0];
        int i = 1;
        this.a = (b2 & 64) != 0;
        boolean z = (b2 & 128) != 0;
        this.b = z;
        if (z) {
            this.c = a(b2);
            int c2 = e.c(bArr, 1);
            i = 1 + c2 + 2;
            try {
                this.d = new String(bArr, 3, c2, this.c);
            } catch (Exception unused) {
            }
        }
        if (bArr.length > i) {
            this.e = e.e(bArr, i);
            b.a("LoginResult|session = " + this.e, new Object[0]);
        }
    }

    public byte[] c() {
        int i;
        int i2;
        byte b2 = this.a ? (byte) 64 : 0;
        byte[] bArr = null;
        if (this.b) {
            byte b3 = (byte) (b2 | 128);
            i2 = 3;
            try {
                bArr = this.d.getBytes(this.c);
                i = bArr.length;
                i2 = 3 + i;
            } catch (Exception unused) {
                i = 0;
            }
            b2 = (byte) (b3 | a(this.c));
        } else {
            i2 = 1;
            i = 0;
        }
        byte[] bArr2 = new byte[(i2 + 8)];
        int c2 = e.c(b2, bArr2, 0);
        if (this.b) {
            c2 = e.b(i, bArr2, c2);
            if (bArr != null) {
                c2 += e.a(bArr, 0, bArr2, c2, i);
            }
        }
        e.a(this.e, bArr2, c2);
        return bArr2;
    }
}
