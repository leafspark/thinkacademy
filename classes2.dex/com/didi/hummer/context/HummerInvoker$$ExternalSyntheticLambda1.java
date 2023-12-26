package com.didi.hummer.context;

import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSContext;

public final /* synthetic */ class HummerInvoker$$ExternalSyntheticLambda1 implements JSContext.JSEvaluateCallback {
    public final /* synthetic */ HummerInvoker f$0;
    public final /* synthetic */ JSCallback f$1;

    public /* synthetic */ HummerInvoker$$ExternalSyntheticLambda1(HummerInvoker hummerInvoker, JSCallback jSCallback) {
        this.f$0 = hummerInvoker;
        this.f$1 = jSCallback;
    }

    public final void onJSEvaluated(Object obj) {
        this.f$0.lambda$null$0$HummerInvoker(this.f$1, obj);
    }
}
