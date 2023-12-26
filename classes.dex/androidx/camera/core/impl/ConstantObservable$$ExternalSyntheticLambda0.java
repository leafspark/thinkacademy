package androidx.camera.core.impl;

import androidx.camera.core.impl.Observable;

public final /* synthetic */ class ConstantObservable$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ConstantObservable f$0;
    public final /* synthetic */ Observable.Observer f$1;

    public /* synthetic */ ConstantObservable$$ExternalSyntheticLambda0(ConstantObservable constantObservable, Observable.Observer observer) {
        this.f$0 = constantObservable;
        this.f$1 = observer;
    }

    public final void run() {
        this.f$0.lambda$addObserver$0$ConstantObservable(this.f$1);
    }
}
