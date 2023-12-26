package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;

public final /* synthetic */ class SurfaceViewImplementation$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ SurfaceViewImplementation f$0;
    public final /* synthetic */ SurfaceRequest f$1;

    public /* synthetic */ SurfaceViewImplementation$$ExternalSyntheticLambda2(SurfaceViewImplementation surfaceViewImplementation, SurfaceRequest surfaceRequest) {
        this.f$0 = surfaceViewImplementation;
        this.f$1 = surfaceRequest;
    }

    public final void run() {
        this.f$0.lambda$onSurfaceRequested$0$SurfaceViewImplementation(this.f$1);
    }
}
