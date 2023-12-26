package com.bonree.sdk.ah;

public final class a {
    private static byte a = 1;
    private static byte b = 2;
    private static byte c = 3;
    private byte d;
    private String e;
    private String f;
    private com.bonree.sdk.ag.a g;
    private String h;

    public final String a() {
        return this.e;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final String b() {
        return this.f;
    }

    public final void b(String str) {
        this.f = str;
    }

    public final com.bonree.sdk.ag.a c() {
        return this.g;
    }

    public final void a(com.bonree.sdk.ag.a aVar) {
        this.g = aVar;
    }

    public final String d() {
        return this.h;
    }

    public final void c(String str) {
        this.h = str;
    }

    public final byte e() {
        return this.d;
    }

    public final void a(byte b2) {
        this.d = b2;
    }

    public final String toString() {
        return "AnrData{collectType=" + this.d + ", anrType='" + this.e + '\'' + ", anrFilePath='" + this.f + '\'' + ", anrError=" + this.g + ", anrMessage='" + this.h + '\'' + '}';
    }
}
