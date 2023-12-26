package com.didi.hummer.core.engine.jsc.base;

import com.didi.hummer.core.engine.base.ICallback;
import com.didi.hummer.core.engine.jsc.JSCUtils;
import com.didi.hummer.core.engine.jsc.jni.TypeConvertor;

public class CallbackImpl implements ICallback {
    public long jsContext;
    public long jsThisObj;
    public long jsValue;

    public CallbackImpl(long j, long j2, long j3) {
        this.jsContext = j;
        this.jsValue = j2;
        this.jsThisObj = j3;
    }

    public Object call(Object... objArr) {
        return JSCUtils.jsValueToObject(this.jsContext, TypeConvertor.JSFunctionCall(this.jsContext, this.jsThisObj, this.jsValue, JSCUtils.objectsToJsValues(this.jsContext, objArr)));
    }
}
