package io.reactivex.rxjava3.internal.fuseable;

public interface SimplePlainQueue<T> extends SimpleQueue<T> {
    T poll();
}
