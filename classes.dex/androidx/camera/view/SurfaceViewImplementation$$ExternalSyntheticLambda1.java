package androidx.camera.view;

public final /* synthetic */ class SurfaceViewImplementation$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ SurfaceViewImplementation f$0;

    public /* synthetic */ SurfaceViewImplementation$$ExternalSyntheticLambda1(SurfaceViewImplementation surfaceViewImplementation) {
        this.f$0 = surfaceViewImplementation;
    }

    public final void run() {
        this.f$0.notifySurfaceNotInUse();
    }
}
