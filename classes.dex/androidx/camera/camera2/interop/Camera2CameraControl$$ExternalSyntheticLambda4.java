package androidx.camera.camera2.interop;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class Camera2CameraControl$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ Camera2CameraControl f$0;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$1;

    public /* synthetic */ Camera2CameraControl$$ExternalSyntheticLambda4(Camera2CameraControl camera2CameraControl, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = camera2CameraControl;
        this.f$1 = completer;
    }

    public final void run() {
        this.f$0.lambda$addCaptureRequestOptions$3$Camera2CameraControl(this.f$1);
    }
}
