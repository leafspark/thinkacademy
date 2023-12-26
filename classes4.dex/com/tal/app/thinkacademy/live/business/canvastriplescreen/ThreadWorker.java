package com.tal.app.thinkacademy.live.business.canvastriplescreen;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;

public class ThreadWorker {
    /* access modifiers changed from: private */
    public int GET_SEI_TIME_FLAG = 100;
    private Handler.Callback callback = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != ThreadWorker.this.GET_SEI_TIME_FLAG) {
                return true;
            }
            if (ThreadWorker.this.updateListener != null) {
                ThreadWorker.this.updateListener.onUpdate();
            }
            if (ThreadWorker.this.mWorkThreadHandler.hasMessages(ThreadWorker.this.GET_SEI_TIME_FLAG)) {
                return true;
            }
            ThreadWorker.this.mWorkThreadHandler.sendEmptyMessageDelayed(ThreadWorker.this.GET_SEI_TIME_FLAG, (long) ThreadWorker.this.timeGapMillis);
            return true;
        }
    };
    private HandlerThread handlerThread;
    /* access modifiers changed from: private */
    public Handler mWorkThreadHandler;
    private String threadName;
    /* access modifiers changed from: private */
    public int timeGapMillis;
    /* access modifiers changed from: private */
    public UpdateListener updateListener;

    public interface UpdateListener {
        void onUpdate();
    }

    public ThreadWorker(String str, int i) {
        this.threadName = str;
        this.timeGapMillis = i;
    }

    public void setUpdateListener(UpdateListener updateListener2) {
        this.updateListener = updateListener2;
    }

    public void startPoll() {
        checkThreadLive();
        Handler handler = this.mWorkThreadHandler;
        if (handler != null && !handler.hasMessages(this.GET_SEI_TIME_FLAG)) {
            this.mWorkThreadHandler.sendEmptyMessageDelayed(this.GET_SEI_TIME_FLAG, (long) this.timeGapMillis);
        }
    }

    private void checkThreadLive() {
        HandlerThread handlerThread2 = this.handlerThread;
        if (handlerThread2 == null || !handlerThread2.isAlive()) {
            HandlerThread handlerThread3 = new HandlerThread(this.threadName);
            this.handlerThread = handlerThread3;
            handlerThread3.start();
            this.mWorkThreadHandler = new CatchHandler(this.handlerThread.getLooper(), this.callback);
        }
        if (this.mWorkThreadHandler == null) {
            this.mWorkThreadHandler = new CatchHandler(this.handlerThread.getLooper(), this.callback);
        }
    }

    static class CatchHandler extends Handler {
        CatchHandler() {
        }

        CatchHandler(Handler.Callback callback) {
            super(callback);
        }

        CatchHandler(Looper looper) {
            super(looper);
        }

        CatchHandler(Looper looper, Handler.Callback callback) {
            super(looper, callback);
        }

        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pausePoll() {
        Handler handler = this.mWorkThreadHandler;
        if (handler != null) {
            handler.removeMessages(this.GET_SEI_TIME_FLAG);
        }
    }

    public void run(Runnable runnable) {
        checkThreadLive();
        Handler handler = this.mWorkThreadHandler;
        if (handler == null) {
            return;
        }
        if (!(handler instanceof Handler)) {
            handler.post(runnable);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, runnable);
        }
    }

    public void destroy() {
        Handler handler = this.mWorkThreadHandler;
        if (handler != null) {
            handler.getLooper().quitSafely();
        }
        this.handlerThread = null;
        this.mWorkThreadHandler = null;
    }
}
