package com.bonree.sdk.bs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ac {
    public static void a(Runnable runnable) {
        a.a.execute(runnable);
    }

    private static void b(Runnable runnable) {
        b.a.execute(runnable);
    }

    static class a {
        /* access modifiers changed from: private */
        public static ExecutorService a = Executors.newCachedThreadPool();

        private a() {
        }
    }

    static class b {
        /* access modifiers changed from: private */
        public static ExecutorService a = Executors.newFixedThreadPool(1);

        private b() {
        }
    }
}
