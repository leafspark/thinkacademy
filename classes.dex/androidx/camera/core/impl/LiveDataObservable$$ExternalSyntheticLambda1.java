package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable;

public final /* synthetic */ class LiveDataObservable$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ LiveDataObservable f$0;
    public final /* synthetic */ LiveDataObservable.LiveDataObserverAdapter f$1;

    public /* synthetic */ LiveDataObservable$$ExternalSyntheticLambda1(LiveDataObservable liveDataObservable, LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter) {
        this.f$0 = liveDataObservable;
        this.f$1 = liveDataObserverAdapter;
    }

    public final void run() {
        this.f$0.lambda$removeObserver$3$LiveDataObservable(this.f$1);
    }
}
