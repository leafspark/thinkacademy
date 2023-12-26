package com.didi.hummer.core.engine.napi.jni;

import com.didi.hummer.core.engine.napi.jni.JSException;

public final /* synthetic */ class JSException$$ExternalSyntheticLambda0 implements JSException.JSExceptionCallback {
    public static final /* synthetic */ JSException$$ExternalSyntheticLambda0 INSTANCE = new JSException$$ExternalSyntheticLambda0();

    private /* synthetic */ JSException$$ExternalSyntheticLambda0() {
    }

    public final void onException(long j, String str) {
        JSException.dispatchExceptionCallback(j, new com.didi.hummer.core.exception.JSException(str));
    }
}
