package com.bonree.sdk.bf;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

final class k implements RejectedExecutionHandler {
    k() {
    }

    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        runnable.run();
    }
}
