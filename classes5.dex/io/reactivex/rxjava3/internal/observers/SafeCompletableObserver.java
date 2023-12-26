package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class SafeCompletableObserver implements CompletableObserver {
    final CompletableObserver downstream;
    boolean onSubscribeFailed;

    public SafeCompletableObserver(CompletableObserver completableObserver) {
        this.downstream = completableObserver;
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
