package io.reactivex.rxjava3.internal.fuseable;

public abstract class AbstractEmptyQueueFuseable<T> implements QueueSubscription<T>, QueueDisposable<T> {
    public void cancel() {
    }

    public final void clear() {
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return false;
    }

    public final boolean isEmpty() {
        return true;
    }

    public final T poll() throws Throwable {
        return null;
    }

    public final void request(long j) {
    }

    public final int requestFusion(int i) {
        return i & 2;
    }

    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
