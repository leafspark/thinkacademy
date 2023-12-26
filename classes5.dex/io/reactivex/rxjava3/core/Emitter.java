package io.reactivex.rxjava3.core;

public interface Emitter<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);
}
