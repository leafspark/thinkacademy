package com.xueersi.lib.graffiti;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.xueersi.lib.graffiti.utils.CatchHandler;
import com.xueersi.lib.graffiti.utils.XesLog;
import java.util.concurrent.Executor;

public class WorkExecutor implements Executor {
    private static final String DEFAULT_TASK_GROUP_ID = "DEFAULT_TASK_ID";
    private volatile HandlerThread handlerThread;
    /* access modifiers changed from: private */
    public volatile boolean mQuit = false;
    private final String threadName;
    private volatile Handler workThreadHandler;

    public WorkExecutor(String str) {
        this.threadName = str;
    }

    public void execute(Runnable runnable) {
        if (this.mQuit) {
            XesLog.d("工作线程已经退出,拒绝执行任务" + this.threadName);
        } else if (checkThreadLive()) {
            Looper myLooper = Looper.myLooper();
            synchronized (this) {
                if (this.workThreadHandler != null) {
                    if (myLooper == this.workThreadHandler.getLooper()) {
                        runnable.run();
                    } else {
                        Handler handler = this.workThreadHandler;
                        if (!(handler instanceof Handler)) {
                            handler.post(runnable);
                        } else {
                            AsynchronousInstrumentation.handlerPost(handler, runnable);
                        }
                    }
                }
            }
        }
    }

    public void submitTask(Runnable runnable) {
        submitTask(DEFAULT_TASK_GROUP_ID, runnable);
    }

    public void removeSubmitTasks() {
        removeTaskByGroupId(DEFAULT_TASK_GROUP_ID);
    }

    public void submitTask(String str, Runnable runnable) {
        if (this.mQuit) {
            XesLog.d("工作线程已经退出,拒绝执行任务" + this.threadName);
        } else if (TextUtils.isEmpty(str)) {
            execute(runnable);
        } else if (checkThreadLive()) {
            String intern = str.intern();
            synchronized (this) {
                if (this.workThreadHandler != null) {
                    this.workThreadHandler.postAtTime(runnable, intern, SystemClock.uptimeMillis());
                }
            }
        }
    }

    public void removeAllTask() {
        if (!this.mQuit && checkThreadLive()) {
            synchronized (this) {
                if (this.workThreadHandler != null) {
                    this.workThreadHandler.removeCallbacksAndMessages((Object) null);
                }
            }
        }
    }

    public void removeTaskByGroupId(String str) {
        if (this.mQuit) {
            XesLog.d("工作线程已经退出,拒绝执行任务" + this.threadName);
        } else if (!TextUtils.isEmpty(str) && checkThreadLive()) {
            String intern = str.intern();
            synchronized (this) {
                if (this.workThreadHandler != null) {
                    this.workThreadHandler.removeCallbacksAndMessages(intern);
                }
            }
        }
    }

    private boolean checkThreadLive() {
        if (this.mQuit) {
            return false;
        }
        if (this.handlerThread != null && this.handlerThread.isAlive() && this.handlerThread.getLooper() != null && this.workThreadHandler != null) {
            return true;
        }
        synchronized (this) {
            if (this.mQuit) {
                return false;
            }
            if (this.handlerThread == null || !this.handlerThread.isAlive() || this.handlerThread.getLooper() == null) {
                this.handlerThread = new HandlerThread(this.threadName) {
                    public void run() {
                        XesLog.d("涂鸦线程开始:" + Thread.currentThread().getName());
                        super.run();
                        XesLog.d("涂鸦线程结束:" + Thread.currentThread().getName());
                        boolean unused = WorkExecutor.this.mQuit = true;
                    }
                };
                this.handlerThread.start();
                this.workThreadHandler = new CatchHandler(this.handlerThread.getLooper());
            }
            if (this.workThreadHandler == null) {
                this.workThreadHandler = new CatchHandler(this.handlerThread.getLooper());
            }
            this.mQuit = false;
            return true;
        }
    }

    public void destroy() {
        synchronized (this) {
            this.mQuit = true;
            if (!(this.workThreadHandler == null || this.workThreadHandler.getLooper() == null)) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.workThreadHandler.getLooper().quitSafely();
                } else {
                    this.workThreadHandler.getLooper().quit();
                }
            }
            this.handlerThread = null;
            this.workThreadHandler = null;
        }
    }
}
