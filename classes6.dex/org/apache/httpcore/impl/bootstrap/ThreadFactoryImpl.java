package org.apache.httpcore.impl.bootstrap;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

class ThreadFactoryImpl implements ThreadFactory {
    private final AtomicLong count;
    private final ThreadGroup group;
    private final String namePrefix;

    ThreadFactoryImpl(String str, ThreadGroup threadGroup) {
        this.namePrefix = str;
        this.group = threadGroup;
        this.count = new AtomicLong();
    }

    ThreadFactoryImpl(String str) {
        this(str, (ThreadGroup) null);
    }

    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.group;
        return new Thread(threadGroup, runnable, this.namePrefix + "-" + this.count.incrementAndGet());
    }
}
