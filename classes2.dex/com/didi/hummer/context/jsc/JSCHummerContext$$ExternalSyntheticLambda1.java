package com.didi.hummer.context.jsc;

import com.didi.hummer.core.exception.ExceptionCallback;

public final /* synthetic */ class JSCHummerContext$$ExternalSyntheticLambda1 implements ExceptionCallback {
    public final /* synthetic */ JSCHummerContext f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ JSCHummerContext$$ExternalSyntheticLambda1(JSCHummerContext jSCHummerContext, String str) {
        this.f$0 = jSCHummerContext;
        this.f$1 = str;
    }

    public final void onException(Exception exc) {
        this.f$0.lambda$new$1$JSCHummerContext(this.f$1, exc);
    }
}
