package com.igexin.push.d.c;

public class e {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public byte g;
    public byte h;
    public byte i;
    public byte j;
    public byte k;
    public byte l;
    public byte m;
    public byte[] n;
    public int o;
    public int p;
    public int q;

    public int a() {
        byte b2 = this.d | this.g;
        this.d = b2;
        byte b3 = b2 | this.h;
        this.d = b3;
        byte b4 = b3 | this.i;
        this.d = b4;
        return b4;
    }

    public void a(byte b2) {
        this.d = b2 & 255;
        this.g = (byte) (b2 & 192);
        this.h = (byte) (b2 & 48);
        this.i = (byte) (b2 & 15);
    }

    public int b() {
        byte b2 = this.f | this.j;
        this.f = b2;
        byte b3 = b2 | this.k;
        this.f = b3;
        byte b4 = b3 | this.l;
        this.f = b4;
        byte b5 = b4 | this.m;
        this.f = b5;
        return b5;
    }
}
