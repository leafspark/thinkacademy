package com.tal.app.thinkacademy.live.util;

import android.os.Handler;
import android.os.Looper;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;

public class LiveMainHandler {
    private static Handler mHandler = new Handler(Looper.getMainLooper());

    public static Handler getMainHandler() {
        return new Handler(Looper.getMainLooper());
    }

    public static boolean post(Runnable runnable) {
        Handler handler = mHandler;
        return !(handler instanceof Handler) ? handler.post(runnable) : AsynchronousInstrumentation.handlerPost(handler, runnable);
    }

    public static boolean postDelayed(Runnable runnable, long j) {
        return mHandler.postDelayed(runnable, j);
    }

    public static void removeCallbacks(Runnable runnable) {
        if (runnable != null) {
            mHandler.removeCallbacks(runnable);
        }
    }
}
