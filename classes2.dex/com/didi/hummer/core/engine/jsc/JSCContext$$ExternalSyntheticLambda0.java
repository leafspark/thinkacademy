package com.didi.hummer.core.engine.jsc;

import com.didi.hummer.core.engine.JSContext;

public final /* synthetic */ class JSCContext$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ JSCContext f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ JSContext.JSEvaluateCallback f$3;

    public /* synthetic */ JSCContext$$ExternalSyntheticLambda0(JSCContext jSCContext, String str, String str2, JSContext.JSEvaluateCallback jSEvaluateCallback) {
        this.f$0 = jSCContext;
        this.f$1 = str;
        this.f$2 = str2;
        this.f$3 = jSEvaluateCallback;
    }

    public final void run() {
        this.f$0.lambda$evaluateJavaScriptAsync$1$JSCContext(this.f$1, this.f$2, this.f$3);
    }
}
