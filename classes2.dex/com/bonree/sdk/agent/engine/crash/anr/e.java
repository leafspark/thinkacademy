package com.bonree.sdk.agent.engine.crash.anr;

final class e implements Runnable {
    private /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        this.a.e.getAndSet(this.a.e.incrementAndGet() % Integer.MAX_VALUE);
    }
}
