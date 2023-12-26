package com.amazonaws.mobile.auth.core.internal.util;

import android.os.Handler;
import android.os.Looper;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;

public class ThreadUtils {
    private ThreadUtils() {
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Handler handler = new Handler(Looper.getMainLooper());
            if (!(handler instanceof Handler)) {
                handler.post(runnable);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, runnable);
            }
        } else {
            runnable.run();
        }
    }
}
