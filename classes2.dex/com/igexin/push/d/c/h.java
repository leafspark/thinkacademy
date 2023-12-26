package com.igexin.push.d.c;

public class h extends c {
    public byte a;
    public byte b;

    public h() {
        this.i = 97;
    }

    public void a(byte[] bArr) {
        this.a = bArr[0];
        this.b = bArr[1];
    }

    public byte[] c() {
        return new byte[]{this.a, this.b};
    }
}
