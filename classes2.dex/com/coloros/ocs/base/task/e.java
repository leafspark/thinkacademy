package com.coloros.ocs.base.task;

final class e implements Runnable {
    private d a;

    public e(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        if (this.a.a() != null) {
            this.a.a().onCanceled();
        }
    }
}
