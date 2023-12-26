package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface MaybeSource<T> {
    void subscribe(MaybeObserver<? super T> maybeObserver);
}
