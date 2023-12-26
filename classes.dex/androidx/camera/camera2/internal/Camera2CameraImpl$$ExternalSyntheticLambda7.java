package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class Camera2CameraImpl$$ExternalSyntheticLambda7 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ Camera2CameraImpl f$0;

    public /* synthetic */ Camera2CameraImpl$$ExternalSyntheticLambda7(Camera2CameraImpl camera2CameraImpl) {
        this.f$0 = camera2CameraImpl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$release$3$Camera2CameraImpl(completer);
    }
}
