package com.sensorsdata.analytics.android.sdk.network;

import com.sensorsdata.analytics.android.sdk.ThreadNameConstants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class HttpTaskManager {
    private static final int POOL_SIZE = 2;
    private static volatile ExecutorService executor;

    private HttpTaskManager() {
    }

    private static ExecutorService getInstance() {
        if (executor == null) {
            synchronized (HttpTaskManager.class) {
                if (executor == null) {
                    executor = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactoryWithName(ThreadNameConstants.THREAD_DEEP_LINK_REQUEST));
                }
            }
        }
        return executor;
    }

    static void execute(Runnable runnable) {
        getInstance().execute(runnable);
    }

    static class ThreadFactoryWithName implements ThreadFactory {
        private final String name;

        ThreadFactoryWithName(String str) {
            this.name = str;
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.name);
        }
    }
}
