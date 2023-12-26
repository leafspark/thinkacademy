package com.adyen.checkout.core.api;

import android.os.Handler;
import android.os.Looper;
import com.adyen.checkout.core.exception.NoConstructorException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ThreadManager {
    public static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
    public static final Handler MAIN_HANDLER = getMainHandler();

    private static Handler getMainHandler() {
        try {
            return new Handler(Looper.getMainLooper());
        } catch (RuntimeException unused) {
            return new Handler();
        }
    }

    private ThreadManager() {
        throw new NoConstructorException();
    }
}
