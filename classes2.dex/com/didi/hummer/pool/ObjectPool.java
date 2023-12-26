package com.didi.hummer.pool;

public interface ObjectPool {
    <T> T get(long j);

    void put(long j, Object obj);

    <T> T remove(long j);
}
