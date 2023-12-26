package com.coloros.ocs.base.task;

final class i implements Runnable {
    private h a;
    private Task b;

    i(h hVar, Task task) {
        this.a = hVar;
        this.b = task;
    }

    public final void run() {
        if (this.a.a() != null) {
            this.a.a().onFailure(this.b.getException());
        }
    }
}
