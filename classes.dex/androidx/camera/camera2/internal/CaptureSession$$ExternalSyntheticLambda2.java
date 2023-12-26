package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class CaptureSession$$ExternalSyntheticLambda2 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ CaptureSession f$0;

    public /* synthetic */ CaptureSession$$ExternalSyntheticLambda2(CaptureSession captureSession) {
        this.f$0 = captureSession;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$release$1$CaptureSession(completer);
    }
}
