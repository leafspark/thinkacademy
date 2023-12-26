package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraStateRegistry;

public final /* synthetic */ class CameraStateRegistry$CameraRegistration$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ CameraStateRegistry.OnOpenAvailableListener f$0;

    public /* synthetic */ CameraStateRegistry$CameraRegistration$$ExternalSyntheticLambda0(CameraStateRegistry.OnOpenAvailableListener onOpenAvailableListener) {
        this.f$0 = onOpenAvailableListener;
    }

    public final void run() {
        this.f$0.onOpenAvailable();
    }
}
