package com.wushuangtech.library;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFactoryWithNamePrefix implements ThreadFactory {
    private static final AtomicInteger mPoolNumber = new AtomicInteger(1);
    private final String mNamePrefix;
    private final ThreadGroup mThreadGroup;
    private final AtomicInteger mThreadNumber = new AtomicInteger(1);

    public ThreadFactoryWithNamePrefix(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.mThreadGroup = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.mNamePrefix = str + "-" + mPoolNumber.getAndIncrement() + "-thread-";
    }

    public Thread newThread(Runnable runnable) {
        ThreadGroup threadGroup = this.mThreadGroup;
        Thread thread = new Thread(threadGroup, runnable, this.mNamePrefix + this.mThreadNumber.getAndIncrement(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
