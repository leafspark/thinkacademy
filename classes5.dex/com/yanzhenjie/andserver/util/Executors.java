package com.yanzhenjie.andserver.util;

import android.os.Handler;
import android.os.Looper;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Executors {
    private static Executors instance;
    private static Handler mHandler;
    private final ExecutorService mService = java.util.concurrent.Executors.newCachedThreadPool();

    public static Executors getInstance() {
        if (instance == null) {
            synchronized (Executors.class) {
                if (instance == null) {
                    instance = new Executors();
                }
            }
        }
        return instance;
    }

    private Executors() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    public void execute(Runnable runnable) {
        this.mService.execute(runnable);
    }

    public Future<?> submit(Runnable runnable) {
        return this.mService.submit(runnable);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.mService.submit(runnable, t);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.mService.submit(callable);
    }

    public void post(Runnable runnable) {
        Handler handler = mHandler;
        if (!(handler instanceof Handler)) {
            handler.post(runnable);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, runnable);
        }
    }

    public void postDelayed(Runnable runnable, long j) {
        mHandler.postDelayed(runnable, j);
    }
}
