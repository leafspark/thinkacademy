package androidx.camera.camera2.internal;

import androidx.camera.core.ZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class ZoomControl$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ ZoomControl f$0;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$1;
    public final /* synthetic */ ZoomState f$2;

    public /* synthetic */ ZoomControl$$ExternalSyntheticLambda3(ZoomControl zoomControl, CallbackToFutureAdapter.Completer completer, ZoomState zoomState) {
        this.f$0 = zoomControl;
        this.f$1 = completer;
        this.f$2 = zoomState;
    }

    public final void run() {
        this.f$0.lambda$setZoomRatio$0$ZoomControl(this.f$1, this.f$2);
    }
}
