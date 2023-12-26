package io.flutter.plugin.platform;

import android.view.View;

public final /* synthetic */ class PlatformViewsController$$ExternalSyntheticLambda0 implements View.OnFocusChangeListener {
    public final /* synthetic */ PlatformViewsController f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ PlatformViewsController$$ExternalSyntheticLambda0(PlatformViewsController platformViewsController, int i) {
        this.f$0 = platformViewsController;
        this.f$1 = i;
    }

    public final void onFocusChange(View view, boolean z) {
        this.f$0.lambda$initializePlatformViewIfNeeded$0$PlatformViewsController(this.f$1, view, z);
    }
}
