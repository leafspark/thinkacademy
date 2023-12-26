package com.tekartik.sqflite;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class SqflitePlugin$$ExternalSyntheticLambda7 implements Runnable {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ MethodChannel.Result f$2;
    public final /* synthetic */ Boolean f$3;
    public final /* synthetic */ Database f$4;
    public final /* synthetic */ MethodCall f$5;
    public final /* synthetic */ boolean f$6;
    public final /* synthetic */ int f$7;

    public /* synthetic */ SqflitePlugin$$ExternalSyntheticLambda7(boolean z, String str, MethodChannel.Result result, Boolean bool, Database database, MethodCall methodCall, boolean z2, int i) {
        this.f$0 = z;
        this.f$1 = str;
        this.f$2 = result;
        this.f$3 = bool;
        this.f$4 = database;
        this.f$5 = methodCall;
        this.f$6 = z2;
        this.f$7 = i;
    }

    public final void run() {
        SqflitePlugin.lambda$onOpenDatabaseCall$7(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
    }
}
