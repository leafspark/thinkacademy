package io.flutter.embedding.engine.systemchannels;

import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class KeyEventChannel$$ExternalSyntheticLambda0 implements BasicMessageChannel.Reply {
    public final /* synthetic */ KeyEventChannel.EventResponseHandler f$0;

    public /* synthetic */ KeyEventChannel$$ExternalSyntheticLambda0(KeyEventChannel.EventResponseHandler eventResponseHandler) {
        this.f$0 = eventResponseHandler;
    }

    public final void reply(Object obj) {
        KeyEventChannel.lambda$createReplyHandler$0(this.f$0, obj);
    }
}
