package com.didi.hummer.core.engine.napi;

import com.didi.hummer.core.engine.JSContext;

public final /* synthetic */ class NAPIContext$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ NAPIContext f$0;
    public final /* synthetic */ byte[] f$1;
    public final /* synthetic */ JSContext.JSEvaluateCallback f$2;

    public /* synthetic */ NAPIContext$$ExternalSyntheticLambda1(NAPIContext nAPIContext, byte[] bArr, JSContext.JSEvaluateCallback jSEvaluateCallback) {
        this.f$0 = nAPIContext;
        this.f$1 = bArr;
        this.f$2 = jSEvaluateCallback;
    }

    public final void run() {
        this.f$0.lambda$evaluateJavaScriptAsync$0$NAPIContext(this.f$1, this.f$2);
    }
}
