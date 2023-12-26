package com.amazonaws.mobile.client.internal;

import com.amazonaws.mobile.client.Callback;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;

public abstract class ReturningRunnable<R> {
    /* access modifiers changed from: private */
    public final String operationDescription;

    public abstract R run() throws Exception;

    public ReturningRunnable() {
        this.operationDescription = null;
    }

    public ReturningRunnable(String str) {
        this.operationDescription = str;
    }

    public R await() throws Exception {
        return run();
    }

    public void async(final Callback<R> callback) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    callback.onResult(ReturningRunnable.this.run());
                } catch (Exception e) {
                    if (ReturningRunnable.this.operationDescription == null) {
                        callback.onError(e);
                    } else {
                        callback.onError(new Exception(ReturningRunnable.this.operationDescription, e));
                    }
                }
            }
        });
        if (!(thread instanceof Thread)) {
            thread.start();
        } else {
            AsynchronousInstrumentation.threadStart(thread);
        }
    }
}
