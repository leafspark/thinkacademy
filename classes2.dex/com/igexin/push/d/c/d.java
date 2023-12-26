package com.igexin.push.d.c;

import com.igexin.b.a.b.e;

public class d extends c {
    String a;
    String b;
    String c;
    String d;

    public d() {
        this.i = 6;
        this.j = 20;
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
    }

    public d(String str, String str2, String str3, String str4) {
        this.i = 6;
        this.j = 20;
        this.a = str == null ? "" : str;
        this.b = str2 == null ? "" : str2;
        this.c = str3 == null ? "" : str3;
        this.d = str4 == null ? "" : str4;
    }

    public void a(byte[] bArr) {
        try {
            int a2 = e.a(bArr, 0);
            this.a = new String(bArr, 1, a2, "utf-8");
            int i = a2 + 1;
            int a3 = e.a(bArr, i);
            int i2 = i + 1;
            this.b = new String(bArr, i2, a3, "utf-8");
            int i3 = i2 + a3;
            int a4 = e.a(bArr, i3);
            int i4 = i3 + 1;
            this.c = new String(bArr, i4, a4, "utf-8");
            int i5 = i4 + a4;
            this.d = new String(bArr, i5 + 1, e.a(bArr, i5), "utf-8");
        } catch (Exception unused) {
        }
    }

    public byte[] c() {
        byte[] bytes = this.b.getBytes();
        byte[] bytes2 = this.a.getBytes();
        byte[] bytes3 = this.c.getBytes();
        byte[] bytes4 = this.d.getBytes();
        byte[] bArr = new byte[(bytes.length + bytes2.length + bytes3.length + bytes4.length + 4)];
        e.c(bytes.length, bArr, 0);
        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        int length = 1 + bytes.length;
        int i = length + 1;
        e.c(bytes2.length, bArr, length);
        System.arraycopy(bytes2, 0, bArr, i, bytes2.length);
        int length2 = i + bytes2.length;
        int i2 = length2 + 1;
        e.c(bytes3.length, bArr, length2);
        System.arraycopy(bytes3, 0, bArr, i2, bytes3.length);
        int length3 = i2 + bytes3.length;
        e.c(bytes4.length, bArr, length3);
        System.arraycopy(bytes4, 0, bArr, length3 + 1, bytes4.length);
        int length4 = bytes4.length;
        return bArr;
    }
}
