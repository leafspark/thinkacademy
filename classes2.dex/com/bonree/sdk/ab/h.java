package com.bonree.sdk.ab;

import com.bonree.sdk.d.a;
import java.util.Map;

public final class h {
    private String a;
    private long b;
    private final boolean c;
    private boolean d;
    private int e;
    private Map<String, String> f;
    private String g;
    private String h;

    public h(String str) {
        this(str, false);
    }

    public h(String str, int i) {
        this(str, false);
        this.e = i;
    }

    public h(String str, boolean z) {
        this.e = -1;
        this.a = str;
        this.d = z;
        this.b = a.l();
        this.c = a.k().J();
    }

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final long b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final int e() {
        return this.e;
    }

    public final void a(int i) {
        this.e = i;
    }

    public final Map<String, String> f() {
        return this.f;
    }

    public final void a(Map<String, String> map) {
        this.f = map;
    }

    public final String g() {
        return this.g;
    }

    public final void b(String str) {
        this.g = str;
    }

    public final String h() {
        return this.h;
    }

    public final void c(String str) {
        this.h = str;
    }
}
