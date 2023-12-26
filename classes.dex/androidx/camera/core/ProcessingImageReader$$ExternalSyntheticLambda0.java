package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class ProcessingImageReader$$ExternalSyntheticLambda0 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ ProcessingImageReader f$0;

    public /* synthetic */ ProcessingImageReader$$ExternalSyntheticLambda0(ProcessingImageReader processingImageReader) {
        this.f$0 = processingImageReader;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$getCloseFuture$0$ProcessingImageReader(completer);
    }
}
