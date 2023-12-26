package com.didi.hummer.core.engine;

import com.didi.hummer.core.engine.base.IRecycler;

public interface JSContext extends JSValue {

    public interface JSEvaluateCallback {
        void onJSEvaluated(Object obj);
    }

    Object evaluateBytecode(byte[] bArr);

    Object evaluateJavaScript(String str);

    Object evaluateJavaScript(String str, String str2);

    void evaluateJavaScriptAsync(String str, String str2, JSEvaluateCallback jSEvaluateCallback);

    @Deprecated
    Object evaluateJavaScriptOnly(String str, String str2);

    void setRecycler(IRecycler iRecycler);
}
