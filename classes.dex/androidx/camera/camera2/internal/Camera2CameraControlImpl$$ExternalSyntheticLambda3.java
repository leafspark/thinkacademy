package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class Camera2CameraControlImpl$$ExternalSyntheticLambda3 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ Camera2CameraControlImpl f$0;

    public /* synthetic */ Camera2CameraControlImpl$$ExternalSyntheticLambda3(Camera2CameraControlImpl camera2CameraControlImpl) {
        this.f$0 = camera2CameraControlImpl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$triggerAf$4$Camera2CameraControlImpl(completer);
    }
}
