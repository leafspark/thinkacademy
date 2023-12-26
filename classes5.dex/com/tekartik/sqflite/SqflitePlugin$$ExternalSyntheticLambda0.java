package com.tekartik.sqflite;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class SqflitePlugin$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Database f$0;
    public final /* synthetic */ MethodCall f$1;
    public final /* synthetic */ MethodChannel.Result f$2;

    public /* synthetic */ SqflitePlugin$$ExternalSyntheticLambda0(Database database, MethodCall methodCall, MethodChannel.Result result) {
        this.f$0 = database;
        this.f$1 = methodCall;
        this.f$2 = result;
    }

    public final void run() {
        this.f$0.batch(this.f$1, this.f$2);
    }
}
