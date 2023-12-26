package com.coloros.ocs.base.task;

import java.util.concurrent.Executor;

final class h<TResult> implements b<TResult> {
    private Executor a;
    private final Object b = new Object();
    private volatile OnFailureListener c;

    public h(Executor executor, OnFailureListener onFailureListener) {
        this.a = executor;
        this.c = onFailureListener;
    }

    public final OnFailureListener a() {
        OnFailureListener onFailureListener;
        synchronized (this.b) {
            onFailureListener = this.c;
        }
        return onFailureListener;
    }

    public final void a(Task<TResult> task) {
        if (!task.isSuccessful() && !task.isCanceled()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.a.execute(new i(this, task));
                }
            }
        }
    }
}
