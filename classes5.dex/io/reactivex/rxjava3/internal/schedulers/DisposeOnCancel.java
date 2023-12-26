package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class DisposeOnCancel implements Future<Object> {
    final Disposable upstream;

    public Object get() {
        return null;
    }

    public Object get(long j, TimeUnit timeUnit) {
        return null;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }

    DisposeOnCancel(Disposable disposable) {
        this.upstream = disposable;
    }

    public boolean cancel(boolean z) {
        this.upstream.dispose();
        return false;
    }
}
