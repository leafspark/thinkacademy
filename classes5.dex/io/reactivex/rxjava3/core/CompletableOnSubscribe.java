package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface CompletableOnSubscribe {
    void subscribe(CompletableEmitter completableEmitter) throws Throwable;
}
