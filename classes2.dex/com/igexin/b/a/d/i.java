package com.igexin.b.a.d;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class i implements ThreadFactory {
    final AtomicInteger a = new AtomicInteger(0);
    final /* synthetic */ g b;

    public i(g gVar) {
        this.b = gVar;
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "TS-pool-" + this.a.incrementAndGet());
    }
}
