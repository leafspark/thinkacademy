package com.wushuangtech.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;

public abstract class BaseThread extends Thread {
    private static final int ACTION_WORKER_THREAD_QUIT = 4112;
    protected String TAG = getName();
    private boolean mReady;
    protected WorkerThreadHandler mWorkerHandler;

    /* access modifiers changed from: protected */
    public abstract void receiveEvent(BaseThread baseThread, Message message);

    public void startAndWaitReady() {
        start();
        waitForReady();
    }

    public void run() {
        OmniLog.i(this.TAG, "Work thread start to run");
        Looper.prepare();
        this.mWorkerHandler = new WorkerThreadHandler(this);
        this.mReady = true;
        Looper.loop();
    }

    private static final class WorkerThreadHandler extends Handler {
        private WeakReference<BaseThread> mWorkerThread;

        WorkerThreadHandler(BaseThread baseThread) {
            this.mWorkerThread = new WeakReference<>(baseThread);
        }

        public void release() {
            WeakReference<BaseThread> weakReference = this.mWorkerThread;
            if (weakReference != null) {
                weakReference.clear();
                this.mWorkerThread = null;
            }
        }

        public void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            WeakReference<BaseThread> weakReference = this.mWorkerThread;
            if (weakReference == null) {
                AsynchronousInstrumentation.handlerMessageEnd();
                return;
            }
            BaseThread baseThread = (BaseThread) weakReference.get();
            if (baseThread == null) {
                AsynchronousInstrumentation.handlerMessageEnd();
            } else if (message.what == BaseThread.ACTION_WORKER_THREAD_QUIT) {
                baseThread.exit();
                AsynchronousInstrumentation.handlerMessageEnd();
            } else {
                baseThread.receiveEvent(baseThread, message);
                AsynchronousInstrumentation.handlerMessageEnd();
            }
        }
    }

    public void sendMessage(int i, Object[] objArr) {
        Message message = new Message();
        message.what = i;
        message.obj = objArr;
        message.arg1 = i;
        message.setTarget(this.mWorkerHandler);
        message.sendToTarget();
    }

    private void waitForReady() {
        while (!this.mReady) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String str = this.TAG;
            OmniLog.i(str, "wait for " + getName());
        }
    }

    public final void exit() {
        if (Thread.currentThread() != this) {
            OmniLog.w(this.TAG, "exit() - exit app thread asynchronously");
            WorkerThreadHandler workerThreadHandler = this.mWorkerHandler;
            if (workerThreadHandler != null) {
                workerThreadHandler.sendEmptyMessage(ACTION_WORKER_THREAD_QUIT);
                return;
            }
            return;
        }
        OmniLog.i(this.TAG, "exit() > start");
        this.mReady = false;
        WorkerThreadHandler workerThreadHandler2 = this.mWorkerHandler;
        if (workerThreadHandler2 != null) {
            workerThreadHandler2.removeCallbacksAndMessages((Object) null);
            workerThreadHandler2.release();
        }
        this.mWorkerHandler = null;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            myLooper.quit();
        }
        OmniLog.i(this.TAG, "exit() > end");
    }
}
