package com.didi.hummer.core.engine.jsc;

import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.base.ICallback;
import com.didi.hummer.core.engine.jsc.base.CallbackImpl;

public class JSCCallback extends JSCValue implements JSCallback {
    private ICallback callback;

    public static JSCCallback wrapper(long j, long j2) {
        return new JSCCallback(j, j2);
    }

    private JSCCallback(long j, long j2) {
        super(j, j2);
        this.callback = new CallbackImpl(j, j2, -1);
        protect();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JSCallback)) {
            return false;
        }
        JSCallback jSCallback = (JSCallback) obj;
        if (jSCallback.getJSContext().getIdentify() == getJSContext().getIdentify() && jSCallback.getIdentify() == getIdentify()) {
            return true;
        }
        return false;
    }

    public Object call(Object... objArr) {
        if (!isValid()) {
            return null;
        }
        return this.callback.call(objArr);
    }
}
