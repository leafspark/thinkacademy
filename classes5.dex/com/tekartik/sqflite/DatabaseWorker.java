package com.tekartik.sqflite;

import android.os.Handler;
import android.os.HandlerThread;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;

class DatabaseWorker {
    private Handler handler;
    private HandlerThread handlerThread;
    private DatabaseTask lastTask;
    private final String name;
    protected Runnable onIdle;
    private final int priority;

    DatabaseWorker(String str, int i) {
        this.name = str;
        this.priority = i;
    }

    /* access modifiers changed from: package-private */
    public synchronized void start(Runnable runnable) {
        HandlerThread handlerThread2 = new HandlerThread(this.name, this.priority);
        this.handlerThread = handlerThread2;
        handlerThread2.start();
        this.handler = new Handler(this.handlerThread.getLooper());
        this.onIdle = runnable;
    }

    /* access modifiers changed from: package-private */
    public synchronized void quit() {
        HandlerThread handlerThread2 = this.handlerThread;
        if (handlerThread2 != null) {
            handlerThread2.quit();
            this.handlerThread = null;
            this.handler = null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isLastTaskInTransaction() {
        DatabaseTask databaseTask = this.lastTask;
        return databaseTask != null && databaseTask.isInTransaction();
    }

    /* access modifiers changed from: package-private */
    public Integer lastTaskDatabaseId() {
        DatabaseTask databaseTask = this.lastTask;
        if (databaseTask != null) {
            return databaseTask.getDatabaseId();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void postTask(DatabaseTask databaseTask) {
        Handler handler2 = this.handler;
        DatabaseWorker$$ExternalSyntheticLambda0 databaseWorker$$ExternalSyntheticLambda0 = new DatabaseWorker$$ExternalSyntheticLambda0(this, databaseTask);
        if (!(handler2 instanceof Handler)) {
            handler2.post(databaseWorker$$ExternalSyntheticLambda0);
        } else {
            AsynchronousInstrumentation.handlerPost(handler2, databaseWorker$$ExternalSyntheticLambda0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: work */
    public void lambda$postTask$0$DatabaseWorker(DatabaseTask databaseTask) {
        databaseTask.runnable.run();
        this.lastTask = databaseTask;
        this.onIdle.run();
    }
}
