package com.coloros.ocs.base.task;

import java.util.concurrent.Executor;

final class f<TResult> implements b<TResult> {
    final Object a = new Object();
    private Executor b;
    private volatile OnCompleteListener<TResult> c;

    public f(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.b = executor;
        this.c = onCompleteListener;
    }

    public final OnCompleteListener<TResult> a() {
        OnCompleteListener<TResult> onCompleteListener;
        synchronized (this.a) {
            onCompleteListener = this.c;
        }
        return onCompleteListener;
    }

    public final void a(Task<TResult> task) {
        synchronized (this.a) {
            if (this.c != null) {
                this.b.execute(new g(this, task));
            }
        }
    }
}
