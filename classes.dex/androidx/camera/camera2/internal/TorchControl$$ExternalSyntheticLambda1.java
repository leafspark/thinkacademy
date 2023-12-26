package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class TorchControl$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ TorchControl f$0;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ TorchControl$$ExternalSyntheticLambda1(TorchControl torchControl, CallbackToFutureAdapter.Completer completer, boolean z) {
        this.f$0 = torchControl;
        this.f$1 = completer;
        this.f$2 = z;
    }

    public final void run() {
        this.f$0.lambda$enableTorch$0$TorchControl(this.f$1, this.f$2);
    }
}
