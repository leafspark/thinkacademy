package com.idlefish.flutterboost;

import android.content.Intent;
import io.flutter.plugin.common.PluginRegistry;

public final /* synthetic */ class FlutterBoostPlugin$$ExternalSyntheticLambda4 implements PluginRegistry.ActivityResultListener {
    public final /* synthetic */ FlutterBoostPlugin f$0;

    public /* synthetic */ FlutterBoostPlugin$$ExternalSyntheticLambda4(FlutterBoostPlugin flutterBoostPlugin) {
        this.f$0 = flutterBoostPlugin;
    }

    public final boolean onActivityResult(int i, int i2, Intent intent) {
        return this.f$0.lambda$onAttachedToActivity$13$FlutterBoostPlugin(i, i2, intent);
    }
}
