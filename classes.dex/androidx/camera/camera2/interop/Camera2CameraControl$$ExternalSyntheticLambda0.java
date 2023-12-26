package androidx.camera.camera2.interop;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;

public final /* synthetic */ class Camera2CameraControl$$ExternalSyntheticLambda0 implements Camera2CameraControlImpl.CaptureResultListener {
    public final /* synthetic */ Camera2CameraControl f$0;

    public /* synthetic */ Camera2CameraControl$$ExternalSyntheticLambda0(Camera2CameraControl camera2CameraControl) {
        this.f$0 = camera2CameraControl;
    }

    public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
        return this.f$0.lambda$new$0$Camera2CameraControl(totalCaptureResult);
    }
}
