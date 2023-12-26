package com.didi.hummer.core.engine.napi;

import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.napi.jni.JSEngine;

public class NAPICallback extends NAPIValue implements JSCallback {
    public static NAPICallback wrapper(long j, long j2) {
        return new NAPICallback(j, j2);
    }

    private NAPICallback(long j, long j2) {
        super(j, j2);
        protect();
    }

    public Object call(Object... objArr) {
        if (!isValid()) {
            return null;
        }
        return JSEngine.callFunction(this.context, -1, this.value, objArr);
    }
}
