package com.tekartik.sqflite.operation;

public class QueuedOperation {
    final Operation operation;
    final Runnable runnable;

    public QueuedOperation(Operation operation2, Runnable runnable2) {
        this.operation = operation2;
        this.runnable = runnable2;
    }

    public void run() {
        this.runnable.run();
    }
}
