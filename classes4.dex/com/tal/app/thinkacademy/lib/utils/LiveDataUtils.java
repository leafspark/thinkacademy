package com.tal.app.thinkacademy.lib.utils;

import android.os.Handler;
import android.os.Looper;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;

public class LiveDataUtils {
    private static Handler sMainHandler;

    public static <T> void setValue(StickyLiveData<T> stickyLiveData, T t) {
        if (stickyLiveData != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                stickyLiveData.setValue(t);
            } else {
                postSetValue(stickyLiveData, t);
            }
        }
    }

    private static <T> void postSetValue(StickyLiveData<T> stickyLiveData, T t) {
        if (sMainHandler == null) {
            sMainHandler = new Handler(Looper.getMainLooper());
        }
        Handler handler = sMainHandler;
        SetValueRunnable<T> create = SetValueRunnable.create(stickyLiveData, t);
        if (!(handler instanceof Handler)) {
            handler.post(create);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, create);
        }
    }

    private static class SetValueRunnable<T> implements Runnable {
        private final T data;
        private final StickyLiveData<T> liveData;

        private SetValueRunnable(StickyLiveData<T> stickyLiveData, T t) {
            this.liveData = stickyLiveData;
            this.data = t;
        }

        public void run() {
            this.liveData.setValue(this.data);
        }

        public static <T> SetValueRunnable<T> create(StickyLiveData<T> stickyLiveData, T t) {
            return new SetValueRunnable<>(stickyLiveData, t);
        }
    }
}
