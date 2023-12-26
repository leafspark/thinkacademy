package com.coloros.ocs.base.task;

import java.util.concurrent.Executor;

final class j<TResult> implements b<TResult> {
    private Executor a;
    private final Object b = new Object();
    private volatile OnSuccessListener<? super TResult> c;

    public j(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.a = executor;
        this.c = onSuccessListener;
    }

    public final OnSuccessListener<? super TResult> a() {
        OnSuccessListener<? super TResult> onSuccessListener;
        synchronized (this.b) {
            onSuccessListener = this.c;
        }
        return onSuccessListener;
    }

    public final void a(Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.a.execute(new k(this, task));
                }
            }
        }
    }
}
