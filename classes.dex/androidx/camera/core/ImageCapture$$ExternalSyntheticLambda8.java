package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class ImageCapture$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$0;

    public /* synthetic */ ImageCapture$$ExternalSyntheticLambda8(CallbackToFutureAdapter.Completer completer) {
        this.f$0 = completer;
    }

    public final void run() {
        this.f$0.set(null);
    }
}
