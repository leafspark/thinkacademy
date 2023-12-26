package com.igexin.push.f.a;

import com.igexin.b.a.d.a;

public abstract class b extends a {
    String c;
    byte[] d;
    public boolean e;

    public b(String str) {
        this.c = str;
    }

    public void a(Exception exc) {
    }

    public void a(byte[] bArr) {
        this.e = false;
        if (bArr != null && bArr.length >= 7 && bArr[5] == 111 && bArr[6] == 107) {
            this.e = true;
        }
    }

    public void b(byte[] bArr) {
        this.d = bArr;
    }

    public String c() {
        return this.c;
    }

    public byte[] d() {
        return this.d;
    }
}
