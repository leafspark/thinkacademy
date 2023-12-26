package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable;

public final /* synthetic */ class LiveDataObservable$LiveDataObserverAdapter$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ LiveDataObservable.LiveDataObserverAdapter f$0;
    public final /* synthetic */ LiveDataObservable.Result f$1;

    public /* synthetic */ LiveDataObservable$LiveDataObserverAdapter$$ExternalSyntheticLambda0(LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter, LiveDataObservable.Result result) {
        this.f$0 = liveDataObserverAdapter;
        this.f$1 = result;
    }

    public final void run() {
        this.f$0.lambda$onChanged$0$LiveDataObservable$LiveDataObserverAdapter(this.f$1);
    }
}
