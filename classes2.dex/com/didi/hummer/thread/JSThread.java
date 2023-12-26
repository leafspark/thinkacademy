package com.didi.hummer.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

public class JSThread extends HandlerThread {
    private Handler mHandler;

    public JSThread(String str) {
        super(str);
        start();
        this.mHandler = new Handler(getLooper());
    }

    public JSThread(String str, int i) {
        super(str, i);
        start();
        this.mHandler = new Handler(getLooper());
    }

    public JSThread(String str, Handler.Callback callback) {
        super(str);
        start();
        this.mHandler = new Handler(getLooper(), postCallback(callback));
    }

    public JSThread(String str, int i, Handler.Callback callback) {
        super(str, i);
        start();
        this.mHandler = new Handler(getLooper(), postCallback(callback));
    }

    public static Runnable postRunnable(Runnable runnable) {
        return (runnable == null || (runnable instanceof SafeRunnable)) ? runnable : new SafeRunnable(runnable);
    }

    public static Handler.Callback postCallback(Handler.Callback callback) {
        return (callback == null || (callback instanceof SafeCallback)) ? callback : new SafeCallback(callback);
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public boolean isThreadAlive() {
        return (this.mHandler == null || getLooper() == null || !isAlive()) ? false : true;
    }

    public boolean quit() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        return super.quit();
    }

    static class SafeRunnable implements Runnable {
        final Runnable mTask;

        SafeRunnable(Runnable runnable) {
            this.mTask = runnable;
        }

        public void run() {
            try {
                Runnable runnable = this.mTask;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    static class SafeCallback implements Handler.Callback {
        final Handler.Callback mCallback;

        SafeCallback(Handler.Callback callback) {
            this.mCallback = callback;
        }

        public boolean handleMessage(Message message) {
            try {
                Handler.Callback callback = this.mCallback;
                if (callback != null) {
                    return callback.handleMessage(message);
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
    }
}
