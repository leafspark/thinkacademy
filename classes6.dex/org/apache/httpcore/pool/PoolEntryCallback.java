package org.apache.httpcore.pool;

public interface PoolEntryCallback<T, C> {
    void process(PoolEntry<T, C> poolEntry);
}
