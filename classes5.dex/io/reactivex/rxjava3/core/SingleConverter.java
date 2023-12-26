package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface SingleConverter<T, R> {
    R apply(Single<T> single);
}
