package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface ObservableConverter<T, R> {
    R apply(Observable<T> observable);
}
