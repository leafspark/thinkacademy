package com.coloros.ocs.base.task;

import android.os.Handler;
import android.os.Looper;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.util.concurrent.Executor;

public class TaskExecutors {
    public static final Executor CURRENT_THREAD = new r();
    public static final Executor MAIN_THREAD = new MainExecutor();

    private TaskExecutors() {
    }

    static class MainExecutor implements Executor {
        private Handler a = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            Handler handler = this.a;
            if (!(handler instanceof Handler)) {
                handler.post(runnable);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, runnable);
            }
        }
    }
}
