package com.tal.app.thinkacademy.common.flutter;

import com.idlefish.flutterboost.FlutterBoost;
import io.flutter.embedding.engine.FlutterEngine;

public final /* synthetic */ class HwFlutterUtil$$ExternalSyntheticLambda2 implements FlutterBoost.Callback {
    public final /* synthetic */ long f$0;

    public /* synthetic */ HwFlutterUtil$$ExternalSyntheticLambda2(long j) {
        this.f$0 = j;
    }

    public final void onStart(FlutterEngine flutterEngine) {
        HwFlutterUtil.m49flutterBoostInit$lambda2(this.f$0, flutterEngine);
    }
}
