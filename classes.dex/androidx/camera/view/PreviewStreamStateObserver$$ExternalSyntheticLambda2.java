package androidx.camera.view;

import androidx.camera.core.CameraInfo;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;

public final /* synthetic */ class PreviewStreamStateObserver$$ExternalSyntheticLambda2 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ PreviewStreamStateObserver f$0;
    public final /* synthetic */ CameraInfo f$1;
    public final /* synthetic */ List f$2;

    public /* synthetic */ PreviewStreamStateObserver$$ExternalSyntheticLambda2(PreviewStreamStateObserver previewStreamStateObserver, CameraInfo cameraInfo, List list) {
        this.f$0 = previewStreamStateObserver;
        this.f$1 = cameraInfo;
        this.f$2 = list;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$waitForCaptureResult$2$PreviewStreamStateObserver(this.f$1, this.f$2, completer);
    }
}
