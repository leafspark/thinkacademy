package androidx.camera.camera2.internal;

import androidx.camera.core.impl.SessionConfig;

public final /* synthetic */ class Camera2CameraImpl$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ SessionConfig.ErrorListener f$0;
    public final /* synthetic */ SessionConfig f$1;

    public /* synthetic */ Camera2CameraImpl$$ExternalSyntheticLambda6(SessionConfig.ErrorListener errorListener, SessionConfig sessionConfig) {
        this.f$0 = errorListener;
        this.f$1 = sessionConfig;
    }

    public final void run() {
        this.f$0.onError(this.f$1, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
    }
}
