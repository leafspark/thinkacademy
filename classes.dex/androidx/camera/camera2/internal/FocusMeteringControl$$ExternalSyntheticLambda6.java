package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class FocusMeteringControl$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ FocusMeteringControl f$0;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$1;

    public /* synthetic */ FocusMeteringControl$$ExternalSyntheticLambda6(FocusMeteringControl focusMeteringControl, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = focusMeteringControl;
        this.f$1 = completer;
    }

    public final void run() {
        this.f$0.lambda$cancelFocusAndMetering$5$FocusMeteringControl(this.f$1);
    }
}
