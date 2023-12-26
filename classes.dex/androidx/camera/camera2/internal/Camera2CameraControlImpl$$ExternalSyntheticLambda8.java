package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class Camera2CameraControlImpl$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ Camera2CameraControlImpl f$0;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$1;

    public /* synthetic */ Camera2CameraControlImpl$$ExternalSyntheticLambda8(Camera2CameraControlImpl camera2CameraControlImpl, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = camera2CameraControlImpl;
        this.f$1 = completer;
    }

    public final void run() {
        this.f$0.lambda$triggerAf$3$Camera2CameraControlImpl(this.f$1);
    }
}
