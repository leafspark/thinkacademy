package com.bonree.sdk.bs;

import java.lang.Thread;

final class g implements Thread.UncaughtExceptionHandler {
    /* synthetic */ g(byte b) {
        this();
    }

    private g() {
    }

    static class a {
        /* access modifiers changed from: private */
        public static final g a = new g((byte) 0);

        private a() {
        }
    }

    public static g a() {
        return a.a;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        com.bonree.sdk.be.a.a().a("BRUncaughtException: ", th);
    }
}
