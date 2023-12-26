package androidx.camera.core;

import androidx.camera.core.SurfaceRequest;

public final /* synthetic */ class SurfaceRequest$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ SurfaceRequest.TransformationInfoListener f$0;
    public final /* synthetic */ SurfaceRequest.TransformationInfo f$1;

    public /* synthetic */ SurfaceRequest$$ExternalSyntheticLambda3(SurfaceRequest.TransformationInfoListener transformationInfoListener, SurfaceRequest.TransformationInfo transformationInfo) {
        this.f$0 = transformationInfoListener;
        this.f$1 = transformationInfo;
    }

    public final void run() {
        this.f$0.onTransformationInfoUpdate(this.f$1);
    }
}
