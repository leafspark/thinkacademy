package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class DeferrableSurface$$ExternalSyntheticLambda0 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ DeferrableSurface f$0;

    public /* synthetic */ DeferrableSurface$$ExternalSyntheticLambda0(DeferrableSurface deferrableSurface) {
        this.f$0 = deferrableSurface;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$new$0$DeferrableSurface(completer);
    }
}
