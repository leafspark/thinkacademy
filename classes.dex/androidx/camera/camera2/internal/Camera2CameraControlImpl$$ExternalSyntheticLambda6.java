package androidx.camera.camera2.internal;

import androidx.camera.core.impl.CameraCaptureCallback;

public final /* synthetic */ class Camera2CameraControlImpl$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ Camera2CameraControlImpl f$0;
    public final /* synthetic */ CameraCaptureCallback f$1;

    public /* synthetic */ Camera2CameraControlImpl$$ExternalSyntheticLambda6(Camera2CameraControlImpl camera2CameraControlImpl, CameraCaptureCallback cameraCaptureCallback) {
        this.f$0 = camera2CameraControlImpl;
        this.f$1 = cameraCaptureCallback;
    }

    public final void run() {
        this.f$0.lambda$removeSessionCameraCaptureCallback$10$Camera2CameraControlImpl(this.f$1);
    }
}
