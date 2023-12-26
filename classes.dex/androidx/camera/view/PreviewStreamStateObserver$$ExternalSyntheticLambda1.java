package androidx.camera.view;

import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class PreviewStreamStateObserver$$ExternalSyntheticLambda1 implements AsyncFunction {
    public final /* synthetic */ PreviewStreamStateObserver f$0;

    public /* synthetic */ PreviewStreamStateObserver$$ExternalSyntheticLambda1(PreviewStreamStateObserver previewStreamStateObserver) {
        this.f$0 = previewStreamStateObserver;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f$0.lambda$startPreviewStreamStateFlow$0$PreviewStreamStateObserver((Void) obj);
    }
}
