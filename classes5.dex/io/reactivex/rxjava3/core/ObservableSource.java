package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface ObservableSource<T> {
    void subscribe(Observer<? super T> observer);
}
