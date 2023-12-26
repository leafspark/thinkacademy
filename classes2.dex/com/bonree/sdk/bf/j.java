package com.bonree.sdk.bf;

import java.util.concurrent.ThreadFactory;

final class j implements ThreadFactory {
    j() {
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.setName("MiniDnsFuture Thread");
        return thread;
    }
}
