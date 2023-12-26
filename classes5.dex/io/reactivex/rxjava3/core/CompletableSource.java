package io.reactivex.rxjava3.core;

@FunctionalInterface
public interface CompletableSource {
    void subscribe(CompletableObserver completableObserver);
}
