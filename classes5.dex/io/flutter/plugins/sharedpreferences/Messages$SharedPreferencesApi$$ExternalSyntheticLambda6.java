package io.flutter.plugins.sharedpreferences;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.sharedpreferences.Messages;

public final /* synthetic */ class Messages$SharedPreferencesApi$$ExternalSyntheticLambda6 implements BasicMessageChannel.MessageHandler {
    public final /* synthetic */ Messages.SharedPreferencesApi f$0;

    public /* synthetic */ Messages$SharedPreferencesApi$$ExternalSyntheticLambda6(Messages.SharedPreferencesApi sharedPreferencesApi) {
        this.f$0 = sharedPreferencesApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.SharedPreferencesApi.CC.lambda$setup$6(this.f$0, obj, reply);
    }
}
