package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;

public final /* synthetic */ class Camera2CameraControlImpl$CameraControlSessionCallback$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Camera2CameraControlImpl.CameraControlSessionCallback f$0;
    public final /* synthetic */ TotalCaptureResult f$1;

    public /* synthetic */ Camera2CameraControlImpl$CameraControlSessionCallback$$ExternalSyntheticLambda0(Camera2CameraControlImpl.CameraControlSessionCallback cameraControlSessionCallback, TotalCaptureResult totalCaptureResult) {
        this.f$0 = cameraControlSessionCallback;
        this.f$1 = totalCaptureResult;
    }

    public final void run() {
        this.f$0.lambda$onCaptureCompleted$0$Camera2CameraControlImpl$CameraControlSessionCallback(this.f$1);
    }
}
