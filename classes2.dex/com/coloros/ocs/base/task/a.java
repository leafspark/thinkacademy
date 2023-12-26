package com.coloros.ocs.base.task;

import java.util.concurrent.Callable;

final class a implements Runnable {
    private Callable a;
    private TaskImpl b;

    a(TaskImpl taskImpl, Callable callable) {
        this.b = taskImpl;
        this.a = callable;
    }

    public final void run() {
        try {
            this.b.setResult(this.a.call());
        } catch (Exception e) {
            this.b.setException(e);
        }
    }
}
