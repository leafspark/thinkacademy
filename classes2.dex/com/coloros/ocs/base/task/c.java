package com.coloros.ocs.base.task;

import java.util.concurrent.Executor;

final class c<TResult, TContinuationResult> implements b<TResult> {
    Continuation<TResult, TContinuationResult> a;
    TaskImpl<TContinuationResult> b;
    private Executor c;

    public c(Executor executor, Continuation<TResult, TContinuationResult> continuation, TaskImpl<TContinuationResult> taskImpl) {
        this.c = executor;
        this.a = continuation;
        this.b = taskImpl;
    }

    public final void a(Task<TResult> task) {
        this.c.execute(new l(this, task));
    }
}
