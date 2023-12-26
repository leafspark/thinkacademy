package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class LiveDataObservable$$ExternalSyntheticLambda0 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ LiveDataObservable f$0;

    public /* synthetic */ LiveDataObservable$$ExternalSyntheticLambda0(LiveDataObservable liveDataObservable) {
        this.f$0 = liveDataObservable;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$fetchData$1$LiveDataObservable(completer);
    }
}
