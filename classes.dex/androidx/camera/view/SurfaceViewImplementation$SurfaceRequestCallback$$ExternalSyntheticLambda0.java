package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.SurfaceViewImplementation;
import androidx.core.util.Consumer;

public final /* synthetic */ class SurfaceViewImplementation$SurfaceRequestCallback$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ SurfaceViewImplementation.SurfaceRequestCallback f$0;

    public /* synthetic */ SurfaceViewImplementation$SurfaceRequestCallback$$ExternalSyntheticLambda0(SurfaceViewImplementation.SurfaceRequestCallback surfaceRequestCallback) {
        this.f$0 = surfaceRequestCallback;
    }

    public final void accept(Object obj) {
        this.f$0.lambda$tryToComplete$0$SurfaceViewImplementation$SurfaceRequestCallback((SurfaceRequest.Result) obj);
    }
}
