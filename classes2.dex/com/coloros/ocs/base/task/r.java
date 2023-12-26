package com.coloros.ocs.base.task;

import java.util.concurrent.Executor;

public final class r implements Executor {
    r() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
