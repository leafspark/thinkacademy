package com.didi.hummer.module;

import com.didi.hummer.core.engine.JSCallback;

public final /* synthetic */ class Timer$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Timer f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ JSCallback f$2;

    public /* synthetic */ Timer$$ExternalSyntheticLambda0(Timer timer, long j, JSCallback jSCallback) {
        this.f$0 = timer;
        this.f$1 = j;
        this.f$2 = jSCallback;
    }

    public final void run() {
        this.f$0.lambda$setInterval$0$Timer(this.f$1, this.f$2);
    }
}
