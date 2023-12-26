package com.bonree.sdk.be;

public final class c implements f {
    private f f = new h();

    public final void a(String str) {
    }

    public final void a(f fVar) {
        synchronized (this) {
            this.f = fVar;
        }
    }

    public final void a(String str, Object... objArr) {
        synchronized (this) {
            this.f.a(str, objArr);
        }
    }

    public final void b(String str, Object... objArr) {
        synchronized (this) {
            this.f.b(str, objArr);
        }
    }

    public final void c(String str, Object... objArr) {
        synchronized (this) {
            this.f.c(str, objArr);
        }
    }

    public final void d(String str, Object... objArr) {
        synchronized (this) {
            this.f.d(str, objArr);
        }
    }

    public final void e(String str, Object... objArr) {
        synchronized (this) {
            this.f.e(str, objArr);
        }
    }

    public final void a(String str, Throwable th) {
        synchronized (this) {
            this.f.a(str, th);
        }
    }

    public final int a() {
        int a;
        synchronized (this) {
            a = this.f.a();
        }
        return a;
    }

    public final void a(int i) {
        synchronized (this) {
            this.f.a(i);
        }
    }
}
