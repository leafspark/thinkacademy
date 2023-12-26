package io.flutter.plugins.pathprovider;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.pathprovider.Messages;

public final /* synthetic */ class Messages$PathProviderApi$$ExternalSyntheticLambda2 implements BasicMessageChannel.MessageHandler {
    public final /* synthetic */ Messages.PathProviderApi f$0;

    public /* synthetic */ Messages$PathProviderApi$$ExternalSyntheticLambda2(Messages.PathProviderApi pathProviderApi) {
        this.f$0 = pathProviderApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.PathProviderApi.CC.lambda$setup$2(this.f$0, obj, reply);
    }
}
