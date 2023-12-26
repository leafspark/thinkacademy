package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.KeyboardMap;

public final /* synthetic */ class KeyEmbedderResponder$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ KeyEmbedderResponder f$0;
    public final /* synthetic */ KeyboardMap.KeyPair f$1;
    public final /* synthetic */ KeyEvent f$2;

    public /* synthetic */ KeyEmbedderResponder$$ExternalSyntheticLambda2(KeyEmbedderResponder keyEmbedderResponder, KeyboardMap.KeyPair keyPair, KeyEvent keyEvent) {
        this.f$0 = keyEmbedderResponder;
        this.f$1 = keyPair;
        this.f$2 = keyEvent;
    }

    public final void run() {
        this.f$0.lambda$synchronizePressingKey$1$KeyEmbedderResponder(this.f$1, this.f$2);
    }
}
