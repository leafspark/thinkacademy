package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;

public final /* synthetic */ class PreviewView$1$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ PreviewView.AnonymousClass1 f$0;
    public final /* synthetic */ SurfaceRequest f$1;

    public /* synthetic */ PreviewView$1$$ExternalSyntheticLambda2(PreviewView.AnonymousClass1 r1, SurfaceRequest surfaceRequest) {
        this.f$0 = r1;
        this.f$1 = surfaceRequest;
    }

    public final void run() {
        this.f$0.lambda$onSurfaceRequested$0$PreviewView$1(this.f$1);
    }
}
