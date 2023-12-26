package com.igexin.push.extension.distribution.basic.f;

import com.igexin.b.a.d.a;

public abstract class d extends a {
    String a;
    byte[] b;
    protected boolean c;
    protected boolean d;
    protected boolean e;
    public boolean f;

    public d(String str) {
        this.a = str;
    }

    public void a(Exception exc) {
    }

    public void a(byte[] bArr) {
        this.f = false;
        if (bArr != null && bArr.length >= 7 && bArr[5] == 111 && bArr[6] == 107) {
            this.f = true;
        }
    }

    public String b() {
        return this.a;
    }

    public void b(byte[] bArr) {
        this.b = bArr;
    }

    public byte[] c() {
        return this.b;
    }

    public boolean d() {
        return this.c;
    }

    public boolean e() {
        return this.d;
    }
}
