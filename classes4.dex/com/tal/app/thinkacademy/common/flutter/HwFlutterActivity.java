package com.tal.app.thinkacademy.common.flutter;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoUtil;
import io.flutter.embedding.android.RenderMode;
import io.flutter.embedding.engine.FlutterEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u0004H\u0014J\b\u0010\u000f\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/common/flutter/HwFlutterActivity;", "Lcom/idlefish/flutterboost/containers/FlutterBoostActivity;", "()V", "configureFlutterEngine", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "getRenderMode", "Lio/flutter/embedding/android/RenderMode;", "getResources", "Landroid/content/res/Resources;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwFlutterActivity.kt */
public final class HwFlutterActivity extends FlutterBoostActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        PadAutoUtil.setupAutoScreenOrientation((Activity) this);
        HwFlutterActivity.super.onCreate(bundle);
    }

    public Resources getResources() {
        Resources resources = HwFlutterActivity.super.getResources();
        Class<?> cls = getClass();
        Intrinsics.checkNotNullExpressionValue(resources, "oldResult");
        return PadAutoUtil.adaptScreenResources(cls, resources);
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        HwFlutterActivity.super.configureFlutterEngine(flutterEngine);
    }

    public void onResume() {
        HwFlutterActivity.super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        HwFlutterActivity.super.onPause();
    }

    public RenderMode getRenderMode() {
        return RenderMode.surface;
    }
}
