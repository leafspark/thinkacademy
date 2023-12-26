package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface SingleSource<T> {
    void subscribe(SingleObserver<? super T> singleObserver);
}
