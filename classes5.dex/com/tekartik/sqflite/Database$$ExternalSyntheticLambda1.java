package com.tekartik.sqflite;

public final /* synthetic */ class Database$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Database f$0;

    public /* synthetic */ Database$$ExternalSyntheticLambda1(Database database) {
        this.f$0 = database;
    }

    public final void run() {
        this.f$0.runQueuedOperations();
    }
}
