package io.flutter.embedding.android;

import io.flutter.embedding.android.KeyboardManager;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;

public final /* synthetic */ class KeyEmbedderResponder$$ExternalSyntheticLambda0 implements BinaryMessenger.BinaryReply {
    public final /* synthetic */ KeyboardManager.Responder.OnKeyEventHandledCallback f$0;

    public /* synthetic */ KeyEmbedderResponder$$ExternalSyntheticLambda0(KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        this.f$0 = onKeyEventHandledCallback;
    }

    public final void reply(ByteBuffer byteBuffer) {
        KeyEmbedderResponder.lambda$sendKeyEvent$2(this.f$0, byteBuffer);
    }
}
