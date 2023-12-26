package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface CompletableConverter<R> {
    R apply(Completable completable);
}
