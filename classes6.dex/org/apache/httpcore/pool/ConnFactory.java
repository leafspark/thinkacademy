package org.apache.httpcore.pool;

import java.io.IOException;

public interface ConnFactory<T, C> {
    C create(T t) throws IOException;
}
