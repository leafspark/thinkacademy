package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.disposables.Disposable;

public interface Observer<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(Disposable disposable);
}
