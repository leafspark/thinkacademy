package com.coloros.ocs.base.task;

import java.util.concurrent.Executor;

final class m<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, b<TResult> {
    SuccessContinuation<TResult, TContinuationResult> a;
    private Executor b;
    private TaskImpl<TContinuationResult> c;

    public m(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation, TaskImpl<TContinuationResult> taskImpl) {
        this.b = executor;
        this.a = successContinuation;
        this.c = taskImpl;
    }

    public final void a(Task<TResult> task) {
        this.b.execute(new n(this, task));
    }

    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.c.setResult(tcontinuationresult);
    }

    public final void onFailure(Exception exc) {
        this.c.setException(exc);
    }

    public final void onCanceled() {
        this.c.tryCancel();
    }
}
