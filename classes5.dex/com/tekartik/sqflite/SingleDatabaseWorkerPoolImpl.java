package com.tekartik.sqflite;

import android.os.Handler;
import android.os.HandlerThread;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tekartik.sqflite.DatabaseWorkerPool;

/* compiled from: DatabaseWorkerPool */
class SingleDatabaseWorkerPoolImpl implements DatabaseWorkerPool {
    private Handler handler;
    private HandlerThread handlerThread;
    final String name;
    final int priority;

    public /* synthetic */ void post(Database database, Runnable runnable) {
        DatabaseWorkerPool.CC.$default$post(this, database, runnable);
    }

    SingleDatabaseWorkerPoolImpl(String str, int i) {
        this.name = str;
        this.priority = i;
    }

    public void start() {
        HandlerThread handlerThread2 = new HandlerThread(this.name, this.priority);
        this.handlerThread = handlerThread2;
        handlerThread2.start();
        this.handler = new Handler(this.handlerThread.getLooper());
    }

    public void quit() {
        HandlerThread handlerThread2 = this.handlerThread;
        if (handlerThread2 != null) {
            handlerThread2.quit();
            this.handlerThread = null;
            this.handler = null;
        }
    }

    public void post(DatabaseTask databaseTask) {
        Handler handler2 = this.handler;
        Runnable runnable = databaseTask.runnable;
        if (!(handler2 instanceof Handler)) {
            handler2.post(runnable);
        } else {
            AsynchronousInstrumentation.handlerPost(handler2, runnable);
        }
    }
}
