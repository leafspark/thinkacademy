package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class Camera2CameraImpl$$ExternalSyntheticLambda0 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ Camera2CameraImpl f$0;

    public /* synthetic */ Camera2CameraImpl$$ExternalSyntheticLambda0(Camera2CameraImpl camera2CameraImpl) {
        this.f$0 = camera2CameraImpl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$getOrCreateUserReleaseFuture$4$Camera2CameraImpl(completer);
    }
}
