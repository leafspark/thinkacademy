package com.idlefish.flutterboost;

import com.idlefish.flutterboost.Messages;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class Messages$NativeRouterApi$$ExternalSyntheticLambda0 implements BasicMessageChannel.MessageHandler {
    public final /* synthetic */ Messages.NativeRouterApi f$0;

    public /* synthetic */ Messages$NativeRouterApi$$ExternalSyntheticLambda0(Messages.NativeRouterApi nativeRouterApi) {
        this.f$0 = nativeRouterApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.NativeRouterApi.CC.lambda$setup$0(this.f$0, obj, reply);
    }
}
