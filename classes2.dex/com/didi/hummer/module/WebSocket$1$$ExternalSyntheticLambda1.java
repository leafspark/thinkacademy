package com.didi.hummer.module;

import com.didi.hummer.module.WebSocket;

public final /* synthetic */ class WebSocket$1$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ WebSocket.AnonymousClass1 f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ WebSocket$1$$ExternalSyntheticLambda1(WebSocket.AnonymousClass1 r1, int i, String str) {
        this.f$0 = r1;
        this.f$1 = i;
        this.f$2 = str;
    }

    public final void run() {
        this.f$0.lambda$onClosed$1$WebSocket$1(this.f$1, this.f$2);
    }
}
