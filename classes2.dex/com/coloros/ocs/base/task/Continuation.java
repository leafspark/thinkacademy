package com.coloros.ocs.base.task;

public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(Task<TResult> task);
}
