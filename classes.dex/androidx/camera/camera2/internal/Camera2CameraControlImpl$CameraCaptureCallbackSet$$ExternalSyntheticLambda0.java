package androidx.camera.camera2.internal;

import androidx.camera.core.impl.CameraCaptureCallback;

public final /* synthetic */ class Camera2CameraControlImpl$CameraCaptureCallbackSet$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ CameraCaptureCallback f$0;

    public /* synthetic */ Camera2CameraControlImpl$CameraCaptureCallbackSet$$ExternalSyntheticLambda0(CameraCaptureCallback cameraCaptureCallback) {
        this.f$0 = cameraCaptureCallback;
    }

    public final void run() {
        this.f$0.onCaptureCancelled();
    }
}
