package com.didi.hummer.utils;

import android.os.Handler;
import android.os.Looper;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;

public class UIThreadUtil {
    private static Handler sMainHandler;

    public static boolean isOnMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void runOnUiThread(Runnable runnable) {
        synchronized (UIThreadUtil.class) {
            if (sMainHandler == null) {
                sMainHandler = new Handler(Looper.getMainLooper());
            }
        }
        Handler handler = sMainHandler;
        if (!(handler instanceof Handler)) {
            handler.post(runnable);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, runnable);
        }
    }
}
