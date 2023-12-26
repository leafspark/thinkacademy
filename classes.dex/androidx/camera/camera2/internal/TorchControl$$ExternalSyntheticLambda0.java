package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class TorchControl$$ExternalSyntheticLambda0 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ TorchControl f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ TorchControl$$ExternalSyntheticLambda0(TorchControl torchControl, boolean z) {
        this.f$0 = torchControl;
        this.f$1 = z;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$enableTorch$1$TorchControl(this.f$1, completer);
    }
}
