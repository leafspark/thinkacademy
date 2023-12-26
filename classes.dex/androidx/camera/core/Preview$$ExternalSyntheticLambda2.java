package androidx.camera.core;

import androidx.camera.core.Preview;

public final /* synthetic */ class Preview$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ Preview.SurfaceProvider f$0;
    public final /* synthetic */ SurfaceRequest f$1;

    public /* synthetic */ Preview$$ExternalSyntheticLambda2(Preview.SurfaceProvider surfaceProvider, SurfaceRequest surfaceRequest) {
        this.f$0 = surfaceProvider;
        this.f$1 = surfaceRequest;
    }

    public final void run() {
        this.f$0.onSurfaceRequested(this.f$1);
    }
}
