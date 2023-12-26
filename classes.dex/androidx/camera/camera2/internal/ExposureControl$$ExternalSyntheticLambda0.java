package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class ExposureControl$$ExternalSyntheticLambda0 implements Camera2CameraControlImpl.CaptureResultListener {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$1;

    public /* synthetic */ ExposureControl$$ExternalSyntheticLambda0(int i, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = i;
        this.f$1 = completer;
    }

    public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
        return ExposureControl.lambda$setExposureCompensationIndex$0(this.f$0, this.f$1, totalCaptureResult);
    }
}
