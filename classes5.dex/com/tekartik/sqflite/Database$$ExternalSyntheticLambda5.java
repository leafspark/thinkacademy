package com.tekartik.sqflite;

import com.tekartik.sqflite.operation.Operation;

public final /* synthetic */ class Database$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ Database f$0;
    public final /* synthetic */ Operation f$1;

    public /* synthetic */ Database$$ExternalSyntheticLambda5(Database database, Operation operation) {
        this.f$0 = database;
        this.f$1 = operation;
    }

    public final void run() {
        this.f$0.lambda$queryCursorNext$2$Database(this.f$1);
    }
}