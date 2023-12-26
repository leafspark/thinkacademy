package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;

public final /* synthetic */ class TextureViewImplementation$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ TextureViewImplementation f$0;
    public final /* synthetic */ SurfaceRequest f$1;

    public /* synthetic */ TextureViewImplementation$$ExternalSyntheticLambda4(TextureViewImplementation textureViewImplementation, SurfaceRequest surfaceRequest) {
        this.f$0 = textureViewImplementation;
        this.f$1 = surfaceRequest;
    }

    public final void run() {
        this.f$0.lambda$onSurfaceRequested$0$TextureViewImplementation(this.f$1);
    }
}
