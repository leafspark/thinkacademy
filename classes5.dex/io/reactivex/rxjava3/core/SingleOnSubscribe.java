package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface SingleOnSubscribe<T> {
    void subscribe(SingleEmitter<T> singleEmitter) throws Throwable;
}
