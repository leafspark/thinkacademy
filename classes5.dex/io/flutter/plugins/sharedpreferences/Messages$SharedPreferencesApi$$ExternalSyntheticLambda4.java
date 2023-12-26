package io.flutter.plugins.sharedpreferences;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.sharedpreferences.Messages;

public final /* synthetic */ class Messages$SharedPreferencesApi$$ExternalSyntheticLambda4 implements BasicMessageChannel.MessageHandler {
    public final /* synthetic */ Messages.SharedPreferencesApi f$0;

    public /* synthetic */ Messages$SharedPreferencesApi$$ExternalSyntheticLambda4(Messages.SharedPreferencesApi sharedPreferencesApi) {
        this.f$0 = sharedPreferencesApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.SharedPreferencesApi.CC.lambda$setup$4(this.f$0, obj, reply);
    }
}
