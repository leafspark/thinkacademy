package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class CameraX$$ExternalSyntheticLambda11 implements Runnable {
    public final /* synthetic */ CameraX f$0;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$1;

    public /* synthetic */ CameraX$$ExternalSyntheticLambda11(CameraX cameraX, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = cameraX;
        this.f$1 = completer;
    }

    public final void run() {
        this.f$0.lambda$shutdownInternal$10$CameraX(this.f$1);
    }
}
