package io.flutter.embedding.engine.systemchannels;

import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class PlatformViewsChannel$1$$ExternalSyntheticLambda0 implements PlatformViewsChannel.PlatformViewBufferResized {
    public final /* synthetic */ MethodChannel.Result f$0;

    public /* synthetic */ PlatformViewsChannel$1$$ExternalSyntheticLambda0(MethodChannel.Result result) {
        this.f$0 = result;
    }

    public final void run(PlatformViewsChannel.PlatformViewBufferSize platformViewBufferSize) {
        PlatformViewsChannel.AnonymousClass1.lambda$resize$0(this.f$0, platformViewBufferSize);
    }
}
