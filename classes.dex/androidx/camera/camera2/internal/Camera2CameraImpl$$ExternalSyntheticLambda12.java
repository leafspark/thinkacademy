package androidx.camera.camera2.internal;

import androidx.camera.core.impl.DeferrableSurface;

public final /* synthetic */ class Camera2CameraImpl$$ExternalSyntheticLambda12 implements Runnable {
    public final /* synthetic */ Camera2CameraImpl f$0;
    public final /* synthetic */ CaptureSession f$1;
    public final /* synthetic */ DeferrableSurface f$2;
    public final /* synthetic */ Runnable f$3;

    public /* synthetic */ Camera2CameraImpl$$ExternalSyntheticLambda12(Camera2CameraImpl camera2CameraImpl, CaptureSession captureSession, DeferrableSurface deferrableSurface, Runnable runnable) {
        this.f$0 = camera2CameraImpl;
        this.f$1 = captureSession;
        this.f$2 = deferrableSurface;
        this.f$3 = runnable;
    }

    public final void run() {
        this.f$0.lambda$configAndClose$1$Camera2CameraImpl(this.f$1, this.f$2, this.f$3);
    }
}
