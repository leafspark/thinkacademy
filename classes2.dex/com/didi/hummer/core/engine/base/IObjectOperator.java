package com.didi.hummer.core.engine.base;

import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSValue;

public interface IObjectOperator {
    Object callFunction(String str, Object... objArr);

    boolean getBoolean(String str);

    double getDouble(String str);

    int getInt(String str);

    JSValue getJSValue(String str);

    long getLong(String str);

    String getString(String str);

    void set(String str, JSCallback jSCallback);

    void set(String str, JSValue jSValue);

    void set(String str, Number number);

    void set(String str, Object obj);

    void set(String str, String str2);

    void set(String str, boolean z);
}
