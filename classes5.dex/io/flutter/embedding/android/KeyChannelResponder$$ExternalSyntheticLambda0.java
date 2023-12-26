package io.flutter.embedding.android;

import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;

public final /* synthetic */ class KeyChannelResponder$$ExternalSyntheticLambda0 implements KeyEventChannel.EventResponseHandler {
    public final /* synthetic */ KeyboardManager.Responder.OnKeyEventHandledCallback f$0;

    public /* synthetic */ KeyChannelResponder$$ExternalSyntheticLambda0(KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        this.f$0 = onKeyEventHandledCallback;
    }

    public final void onFrameworkResponse(boolean z) {
        this.f$0.onKeyEventHandled(z);
    }
}
