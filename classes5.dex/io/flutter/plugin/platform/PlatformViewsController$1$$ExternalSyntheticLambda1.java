package io.flutter.plugin.platform;

import android.view.View;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.platform.PlatformViewsController;

public final /* synthetic */ class PlatformViewsController$1$$ExternalSyntheticLambda1 implements View.OnFocusChangeListener {
    public final /* synthetic */ PlatformViewsController.AnonymousClass1 f$0;
    public final /* synthetic */ PlatformViewsChannel.PlatformViewCreationRequest f$1;

    public /* synthetic */ PlatformViewsController$1$$ExternalSyntheticLambda1(PlatformViewsController.AnonymousClass1 r1, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        this.f$0 = r1;
        this.f$1 = platformViewCreationRequest;
    }

    public final void onFocusChange(View view, boolean z) {
        this.f$0.lambda$configureForVirtualDisplay$1$PlatformViewsController$1(this.f$1, view, z);
    }
}
