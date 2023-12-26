package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable;

public final /* synthetic */ class LiveDataObservable$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ LiveDataObservable f$0;
    public final /* synthetic */ LiveDataObservable.LiveDataObserverAdapter f$1;
    public final /* synthetic */ LiveDataObservable.LiveDataObserverAdapter f$2;

    public /* synthetic */ LiveDataObservable$$ExternalSyntheticLambda2(LiveDataObservable liveDataObservable, LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter, LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter2) {
        this.f$0 = liveDataObservable;
        this.f$1 = liveDataObserverAdapter;
        this.f$2 = liveDataObserverAdapter2;
    }

    public final void run() {
        this.f$0.lambda$addObserver$2$LiveDataObservable(this.f$1, this.f$2);
    }
}
