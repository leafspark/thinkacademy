package com.xueersi.lib.graffiti.utils;

import android.os.Handler;
import android.os.Looper;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;

public class MainHandler {
    private Handler handler;

    public MainHandler(Looper looper) {
        this.handler = new Handler(looper);
    }

    public void post(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        Handler handler2 = this.handler;
        if (!(handler2 instanceof Handler)) {
            handler2.post(runnable);
        } else {
            AsynchronousInstrumentation.handlerPost(handler2, runnable);
        }
    }
}
