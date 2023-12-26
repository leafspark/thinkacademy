package com.coloros.ocs.base.task;

final class k implements Runnable {
    private j a;
    private Task b;

    k(j jVar, Task task) {
        this.a = jVar;
        this.b = task;
    }

    public final void run() {
        if (this.a.a() != null) {
            this.a.a().onSuccess(this.b.getResult());
        }
    }
}
