package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class ExposureControl$$ExternalSyntheticLambda1 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ ExposureControl f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ ExposureControl$$ExternalSyntheticLambda1(ExposureControl exposureControl, int i) {
        this.f$0 = exposureControl;
        this.f$1 = i;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$setExposureCompensationIndex$2$ExposureControl(this.f$1, completer);
    }
}
