package androidx.camera.camera2.interop;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class Camera2CameraControl$$ExternalSyntheticLambda2 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ Camera2CameraControl f$0;

    public /* synthetic */ Camera2CameraControl$$ExternalSyntheticLambda2(Camera2CameraControl camera2CameraControl) {
        this.f$0 = camera2CameraControl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$clearCaptureRequestOptions$6$Camera2CameraControl(completer);
    }
}
