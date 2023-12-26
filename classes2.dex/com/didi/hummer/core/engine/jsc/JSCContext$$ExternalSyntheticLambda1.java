package com.didi.hummer.core.engine.jsc;

import com.didi.hummer.core.engine.JSContext;

public final /* synthetic */ class JSCContext$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ JSCContext f$0;
    public final /* synthetic */ byte[] f$1;
    public final /* synthetic */ JSContext.JSEvaluateCallback f$2;

    public /* synthetic */ JSCContext$$ExternalSyntheticLambda1(JSCContext jSCContext, byte[] bArr, JSContext.JSEvaluateCallback jSEvaluateCallback) {
        this.f$0 = jSCContext;
        this.f$1 = bArr;
        this.f$2 = jSEvaluateCallback;
    }

    public final void run() {
        this.f$0.lambda$evaluateJavaScriptAsync$0$JSCContext(this.f$1, this.f$2);
    }
}
