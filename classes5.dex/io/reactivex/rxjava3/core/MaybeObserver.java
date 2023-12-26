package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.disposables.Disposable;

public interface MaybeObserver<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(Disposable disposable);

    void onSuccess(T t);
}
