package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class ImageCapture$CaptureCallbackChecker$$ExternalSyntheticLambda0 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ ImageCapture.CaptureCallbackChecker f$0;
    public final /* synthetic */ ImageCapture.CaptureCallbackChecker.CaptureResultChecker f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ long f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ ImageCapture$CaptureCallbackChecker$$ExternalSyntheticLambda0(ImageCapture.CaptureCallbackChecker captureCallbackChecker, ImageCapture.CaptureCallbackChecker.CaptureResultChecker captureResultChecker, long j, long j2, Object obj) {
        this.f$0 = captureCallbackChecker;
        this.f$1 = captureResultChecker;
        this.f$2 = j;
        this.f$3 = j2;
        this.f$4 = obj;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$checkCaptureResult$0$ImageCapture$CaptureCallbackChecker(this.f$1, this.f$2, this.f$3, this.f$4, completer);
    }
}
