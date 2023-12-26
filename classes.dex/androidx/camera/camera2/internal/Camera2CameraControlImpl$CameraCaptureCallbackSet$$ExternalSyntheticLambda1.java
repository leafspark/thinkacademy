package androidx.camera.camera2.internal;

import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;

public final /* synthetic */ class Camera2CameraControlImpl$CameraCaptureCallbackSet$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ CameraCaptureCallback f$0;
    public final /* synthetic */ CameraCaptureFailure f$1;

    public /* synthetic */ Camera2CameraControlImpl$CameraCaptureCallbackSet$$ExternalSyntheticLambda1(CameraCaptureCallback cameraCaptureCallback, CameraCaptureFailure cameraCaptureFailure) {
        this.f$0 = cameraCaptureCallback;
        this.f$1 = cameraCaptureFailure;
    }

    public final void run() {
        this.f$0.onCaptureFailed(this.f$1);
    }
}
