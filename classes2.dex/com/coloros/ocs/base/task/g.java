package com.coloros.ocs.base.task;

final class g implements Runnable {
    private f a;
    private Task b;

    g(f fVar, Task task) {
        this.a = fVar;
        this.b = task;
    }

    public final void run() {
        synchronized (this.a.a) {
            if (this.a.a() != null) {
                this.a.a().onComplete(this.b);
            }
        }
    }
}
