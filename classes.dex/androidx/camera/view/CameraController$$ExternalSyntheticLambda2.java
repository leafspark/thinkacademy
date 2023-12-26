package androidx.camera.view;

import androidx.camera.core.CameraSelector;

public final /* synthetic */ class CameraController$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ CameraController f$0;
    public final /* synthetic */ CameraSelector f$1;

    public /* synthetic */ CameraController$$ExternalSyntheticLambda2(CameraController cameraController, CameraSelector cameraSelector) {
        this.f$0 = cameraController;
        this.f$1 = cameraSelector;
    }

    public final void run() {
        this.f$0.lambda$setCameraSelector$2$CameraController(this.f$1);
    }
}
