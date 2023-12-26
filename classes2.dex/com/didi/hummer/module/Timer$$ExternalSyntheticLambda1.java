package com.didi.hummer.module;

import com.didi.hummer.core.engine.JSCallback;

public final /* synthetic */ class Timer$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Timer f$0;
    public final /* synthetic */ JSCallback f$1;

    public /* synthetic */ Timer$$ExternalSyntheticLambda1(Timer timer, JSCallback jSCallback) {
        this.f$0 = timer;
        this.f$1 = jSCallback;
    }

    public final void run() {
        this.f$0.lambda$setTimeout$1$Timer(this.f$1);
    }
}
