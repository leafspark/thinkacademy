package androidx.camera.camera2.internal;

import androidx.camera.core.UseCase;

public final /* synthetic */ class Camera2CameraImpl$$ExternalSyntheticLambda13 implements Runnable {
    public final /* synthetic */ Camera2CameraImpl f$0;
    public final /* synthetic */ UseCase f$1;

    public /* synthetic */ Camera2CameraImpl$$ExternalSyntheticLambda13(Camera2CameraImpl camera2CameraImpl, UseCase useCase) {
        this.f$0 = camera2CameraImpl;
        this.f$1 = useCase;
    }

    public final void run() {
        this.f$0.lambda$onUseCaseActive$5$Camera2CameraImpl(this.f$1);
    }
}
