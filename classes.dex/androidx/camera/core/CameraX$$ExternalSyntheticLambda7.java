package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class CameraX$$ExternalSyntheticLambda7 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ CameraX f$0;

    public /* synthetic */ CameraX$$ExternalSyntheticLambda7(CameraX cameraX) {
        this.f$0 = cameraX;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return CameraX.lambda$shutdownLocked$5(this.f$0, completer);
    }
}
