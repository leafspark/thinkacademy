package com.didi.hummer.core.engine.jsc.jni;

import com.didi.hummer.core.engine.jsc.jni.HummerException;
import com.didi.hummer.core.exception.JSException;

public final /* synthetic */ class HummerException$$ExternalSyntheticLambda0 implements HummerException.JSExceptionCallback {
    public static final /* synthetic */ HummerException$$ExternalSyntheticLambda0 INSTANCE = new HummerException$$ExternalSyntheticLambda0();

    private /* synthetic */ HummerException$$ExternalSyntheticLambda0() {
    }

    public final void onException(long j, String str) {
        HummerException.dispatchExceptionCallback(j, new JSException(str));
    }
}
