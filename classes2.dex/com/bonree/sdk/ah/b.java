package com.bonree.sdk.ah;

public final class b {
    public Thread a;
    public Throwable b;

    public b() {
    }

    private b(Thread thread, Throwable th) {
        this.a = thread;
        this.b = th;
    }

    public final String toString() {
        return "JavaCrashCallBackData{" + "mCrashThread=" + this.a + ", mThrowable=" + this.b + '}';
    }
}
