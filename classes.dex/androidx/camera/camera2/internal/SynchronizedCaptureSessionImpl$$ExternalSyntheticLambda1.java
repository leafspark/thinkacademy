package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda1 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ SynchronizedCaptureSessionImpl f$0;

    public /* synthetic */ SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda1(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
        this.f$0 = synchronizedCaptureSessionImpl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$new$0$SynchronizedCaptureSessionImpl(completer);
    }
}
