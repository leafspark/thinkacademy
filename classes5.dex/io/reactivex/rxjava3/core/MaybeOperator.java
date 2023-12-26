package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface MaybeOperator<Downstream, Upstream> {
    MaybeObserver<? super Upstream> apply(MaybeObserver<? super Downstream> maybeObserver) throws Throwable;
}
