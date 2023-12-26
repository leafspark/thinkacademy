package com.coloros.ocs.base.task;

import java.util.concurrent.Executor;

final class d<TResult> implements b<TResult> {
    private Executor a;
    private final Object b = new Object();
    private volatile OnCanceledListener c;

    public d(Executor executor, OnCanceledListener onCanceledListener) {
        this.a = executor;
        this.c = onCanceledListener;
    }

    public final OnCanceledListener a() {
        OnCanceledListener onCanceledListener;
        synchronized (this.b) {
            onCanceledListener = this.c;
        }
        return onCanceledListener;
    }

    public final void a(Task task) {
        if (task.isCanceled()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.a.execute(new e(this));
                }
            }
        }
    }
}
