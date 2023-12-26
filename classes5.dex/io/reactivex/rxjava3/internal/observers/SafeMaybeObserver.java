package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class SafeMaybeObserver<T> implements MaybeObserver<T> {
    final MaybeObserver<? super T> downstream;
    boolean onSubscribeFailed;

    public SafeMaybeObserver(MaybeObserver<? super T> maybeObserver) {
        this.downstream = maybeObserver;
    }

    public void onSubscribe(Disposable disposable) {
        try {
            this.downstream.onSubscribe(disposable);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            this.onSubscribeFailed = true;
            disposable.dispose();
            RxJavaPlugins.onError(th);
        }
    }

    public void onSuccess(T t) {
        if (!this.onSubscribeFailed) {
            try {
                this.downstream.onSuccess(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    public void onError(Throwable th) {
        if (this.onSubscribeFailed) {
            RxJavaPlugins.onError(th);
            return;
        }
        try {
            this.downstream.onError(th);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(th, th2));
        }
    }

    public void onComplete() {
        if (!this.onSubscribeFailed) {
            try {
                this.downstream.onComplete();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }
}
