package androidx.camera.core;

import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class CameraX$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ CameraX f$0;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$1;

    public /* synthetic */ CameraX$$ExternalSyntheticLambda1(CameraX cameraX, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = cameraX;
        this.f$1 = completer;
    }

    public final void run() {
        Futures.propagate(this.f$0.shutdownInternal(), this.f$1);
    }
}
