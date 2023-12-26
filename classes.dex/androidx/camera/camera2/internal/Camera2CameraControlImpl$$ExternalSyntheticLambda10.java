package androidx.camera.camera2.internal;

import androidx.camera.core.impl.CameraCaptureCallback;
import java.util.concurrent.Executor;

public final /* synthetic */ class Camera2CameraControlImpl$$ExternalSyntheticLambda10 implements Runnable {
    public final /* synthetic */ Camera2CameraControlImpl f$0;
    public final /* synthetic */ Executor f$1;
    public final /* synthetic */ CameraCaptureCallback f$2;

    public /* synthetic */ Camera2CameraControlImpl$$ExternalSyntheticLambda10(Camera2CameraControlImpl camera2CameraControlImpl, Executor executor, CameraCaptureCallback cameraCaptureCallback) {
        this.f$0 = camera2CameraControlImpl;
        this.f$1 = executor;
        this.f$2 = cameraCaptureCallback;
    }

    public final void run() {
        this.f$0.lambda$addSessionCameraCaptureCallback$9$Camera2CameraControlImpl(this.f$1, this.f$2);
    }
}
