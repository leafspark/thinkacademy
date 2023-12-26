package com.didi.hummer.module;

import com.didi.hummer.module.WebSocket;

public final /* synthetic */ class WebSocket$1$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ WebSocket.AnonymousClass1 f$0;
    public final /* synthetic */ Throwable f$1;

    public /* synthetic */ WebSocket$1$$ExternalSyntheticLambda3(WebSocket.AnonymousClass1 r1, Throwable th) {
        this.f$0 = r1;
        this.f$1 = th;
    }

    public final void run() {
        this.f$0.lambda$onFailure$2$WebSocket$1(this.f$1);
    }
}
