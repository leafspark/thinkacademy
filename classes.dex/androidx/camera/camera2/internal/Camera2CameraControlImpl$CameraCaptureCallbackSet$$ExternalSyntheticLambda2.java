package androidx.camera.camera2.internal;

import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;

public final /* synthetic */ class Camera2CameraControlImpl$CameraCaptureCallbackSet$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ CameraCaptureCallback f$0;
    public final /* synthetic */ CameraCaptureResult f$1;

    public /* synthetic */ Camera2CameraControlImpl$CameraCaptureCallbackSet$$ExternalSyntheticLambda2(CameraCaptureCallback cameraCaptureCallback, CameraCaptureResult cameraCaptureResult) {
        this.f$0 = cameraCaptureCallback;
        this.f$1 = cameraCaptureResult;
    }

    public final void run() {
        this.f$0.onCaptureCompleted(this.f$1);
    }
}
