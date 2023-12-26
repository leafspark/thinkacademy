package org.apache.httpcore.pool;

import java.util.concurrent.Future;
import org.apache.httpcore.concurrent.FutureCallback;

public interface ConnPool<T, E> {
    Future<E> lease(T t, Object obj, FutureCallback<E> futureCallback);

    void release(E e, boolean z);
}
