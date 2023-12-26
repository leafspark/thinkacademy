package androidx.camera.camera2.internal;

public final /* synthetic */ class Camera2CameraControlImpl$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ Camera2CameraControlImpl f$0;

    public /* synthetic */ Camera2CameraControlImpl$$ExternalSyntheticLambda5(Camera2CameraControlImpl camera2CameraControlImpl) {
        this.f$0 = camera2CameraControlImpl;
    }

    public final void run() {
        this.f$0.updateSessionConfigSynchronous();
    }
}
