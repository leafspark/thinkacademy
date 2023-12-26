package com.coloros.ocs.base.task;

public class TaskCompletionSource<TResult> {
    private TaskImpl<TResult> a = new TaskImpl<>();

    public void setResult(TResult tresult) {
        this.a.setResult(tresult);
    }

    public boolean trySetResult(TResult tresult) {
        return this.a.trySetResult(tresult);
    }

    public void setException(Exception exc) {
        this.a.setException(exc);
    }

    public boolean trySetException(Exception exc) {
        return this.a.trySetException(exc);
    }

    public Task<TResult> getTask() {
        return this.a;
    }
}
