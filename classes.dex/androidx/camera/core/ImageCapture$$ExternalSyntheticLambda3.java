package androidx.camera.core;

import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureStage;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;

public final /* synthetic */ class ImageCapture$$ExternalSyntheticLambda3 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ ImageCapture f$0;
    public final /* synthetic */ CaptureConfig.Builder f$1;
    public final /* synthetic */ List f$2;
    public final /* synthetic */ CaptureStage f$3;

    public /* synthetic */ ImageCapture$$ExternalSyntheticLambda3(ImageCapture imageCapture, CaptureConfig.Builder builder, List list, CaptureStage captureStage) {
        this.f$0 = imageCapture;
        this.f$1 = builder;
        this.f$2 = list;
        this.f$3 = captureStage;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$issueTakePicture$19$ImageCapture(this.f$1, this.f$2, this.f$3, completer);
    }
}
