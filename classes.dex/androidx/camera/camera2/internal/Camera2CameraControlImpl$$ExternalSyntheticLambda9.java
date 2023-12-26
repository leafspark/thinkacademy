package androidx.camera.camera2.internal;

import java.util.List;

public final /* synthetic */ class Camera2CameraControlImpl$$ExternalSyntheticLambda9 implements Runnable {
    public final /* synthetic */ Camera2CameraControlImpl f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ Camera2CameraControlImpl$$ExternalSyntheticLambda9(Camera2CameraControlImpl camera2CameraControlImpl, List list) {
        this.f$0 = camera2CameraControlImpl;
        this.f$1 = list;
    }

    public final void run() {
        this.f$0.lambda$submitCaptureRequests$8$Camera2CameraControlImpl(this.f$1);
    }
}
