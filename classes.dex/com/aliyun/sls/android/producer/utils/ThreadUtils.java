package com.aliyun.sls.android.producer.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtils {
    private static ExecutorService SINGLE_THREAD_EXECUTOR = Executors.newSingleThreadExecutor();

    private ThreadUtils() {
    }

    public static void exec(Runnable runnable) {
        SINGLE_THREAD_EXECUTOR.execute(runnable);
    }
}
