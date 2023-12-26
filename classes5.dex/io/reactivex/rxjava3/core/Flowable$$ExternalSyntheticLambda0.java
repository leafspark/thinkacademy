package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.disposables.Disposable;

public final /* synthetic */ class Flowable$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Disposable f$0;

    public /* synthetic */ Flowable$$ExternalSyntheticLambda0(Disposable disposable) {
        this.f$0 = disposable;
    }

    public final void run() {
        this.f$0.dispose();
    }
}
