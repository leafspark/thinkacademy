package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class CameraX$$ExternalSyntheticLambda6 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ CameraX f$0;

    public /* synthetic */ CameraX$$ExternalSyntheticLambda6(CameraX cameraX) {
        this.f$0 = cameraX;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$shutdownInternal$11$CameraX(completer);
    }
}
