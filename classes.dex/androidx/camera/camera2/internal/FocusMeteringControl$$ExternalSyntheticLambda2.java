package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class FocusMeteringControl$$ExternalSyntheticLambda2 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ FocusMeteringControl f$0;

    public /* synthetic */ FocusMeteringControl$$ExternalSyntheticLambda2(FocusMeteringControl focusMeteringControl) {
        this.f$0 = focusMeteringControl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$cancelFocusAndMetering$6$FocusMeteringControl(completer);
    }
}
