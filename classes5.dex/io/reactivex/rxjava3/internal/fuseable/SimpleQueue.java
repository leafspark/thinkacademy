package io.reactivex.rxjava3.internal.fuseable;

public interface SimpleQueue<T> {
    void clear();

    boolean isEmpty();

    boolean offer(T t);

    boolean offer(T t, T t2);

    T poll() throws Throwable;
}
