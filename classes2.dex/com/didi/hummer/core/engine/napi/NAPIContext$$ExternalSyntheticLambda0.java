package com.didi.hummer.core.engine.napi;

import com.didi.hummer.core.engine.JSContext;

public final /* synthetic */ class NAPIContext$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ NAPIContext f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ JSContext.JSEvaluateCallback f$3;

    public /* synthetic */ NAPIContext$$ExternalSyntheticLambda0(NAPIContext nAPIContext, String str, String str2, JSContext.JSEvaluateCallback jSEvaluateCallback) {
        this.f$0 = nAPIContext;
        this.f$1 = str;
        this.f$2 = str2;
        this.f$3 = jSEvaluateCallback;
    }

    public final void run() {
        this.f$0.lambda$evaluateJavaScriptAsync$1$NAPIContext(this.f$1, this.f$2, this.f$3);
    }
}
