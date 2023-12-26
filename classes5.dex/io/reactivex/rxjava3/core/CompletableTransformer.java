package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface CompletableTransformer {
    CompletableSource apply(Completable completable);
}
