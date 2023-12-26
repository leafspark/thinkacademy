package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class LiveDataObservable$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ LiveDataObservable f$0;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$1;

    public /* synthetic */ LiveDataObservable$$ExternalSyntheticLambda3(LiveDataObservable liveDataObservable, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = liveDataObservable;
        this.f$1 = completer;
    }

    public final void run() {
        this.f$0.lambda$fetchData$0$LiveDataObservable(this.f$1);
    }
}
