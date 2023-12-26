package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface CompletableOperator {
    CompletableObserver apply(CompletableObserver completableObserver) throws Throwable;
}
