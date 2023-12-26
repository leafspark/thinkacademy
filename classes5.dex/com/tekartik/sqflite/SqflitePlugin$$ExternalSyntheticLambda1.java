package com.tekartik.sqflite;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class SqflitePlugin$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ MethodCall f$0;
    public final /* synthetic */ Database f$1;
    public final /* synthetic */ MethodChannel.Result f$2;

    public /* synthetic */ SqflitePlugin$$ExternalSyntheticLambda1(MethodCall methodCall, Database database, MethodChannel.Result result) {
        this.f$0 = methodCall;
        this.f$1 = database;
        this.f$2 = result;
    }

    public final void run() {
        SqflitePlugin.lambda$onSetLocaleCall$5(this.f$0, this.f$1, this.f$2);
    }
}
