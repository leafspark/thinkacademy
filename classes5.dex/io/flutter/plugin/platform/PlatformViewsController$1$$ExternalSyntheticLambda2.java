package io.flutter.plugin.platform;

import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.platform.PlatformViewsController;

public final /* synthetic */ class PlatformViewsController$1$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ PlatformViewsController.AnonymousClass1 f$0;
    public final /* synthetic */ VirtualDisplayController f$1;
    public final /* synthetic */ float f$2;
    public final /* synthetic */ PlatformViewsChannel.PlatformViewBufferResized f$3;

    public /* synthetic */ PlatformViewsController$1$$ExternalSyntheticLambda2(PlatformViewsController.AnonymousClass1 r1, VirtualDisplayController virtualDisplayController, float f, PlatformViewsChannel.PlatformViewBufferResized platformViewBufferResized) {
        this.f$0 = r1;
        this.f$1 = virtualDisplayController;
        this.f$2 = f;
        this.f$3 = platformViewBufferResized;
    }

    public final void run() {
        this.f$0.lambda$resize$0$PlatformViewsController$1(this.f$1, this.f$2, this.f$3);
    }
}
