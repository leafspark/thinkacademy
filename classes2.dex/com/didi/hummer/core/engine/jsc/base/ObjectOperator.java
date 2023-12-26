package com.didi.hummer.core.engine.jsc.base;

import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.engine.base.IObjectOperator;
import com.didi.hummer.core.engine.jsc.JSCCallback;
import com.didi.hummer.core.engine.jsc.JSCValue;
import com.didi.hummer.core.engine.jsc.jni.TypeConvertor;

public class ObjectOperator implements IObjectOperator {
    public long jsContext;
    public long jsValue;

    public ObjectOperator(long j, long j2) {
        this.jsContext = j;
        this.jsValue = j2;
    }

    public void setProperty(String str, long j) {
        TypeConvertor.JSValueSetProperty(this.jsContext, this.jsValue, str, j);
    }

    public long getProperty(String str) {
        return TypeConvertor.JSValueGetProperty(this.jsContext, this.jsValue, str);
    }

    public boolean delProperty(String str) {
        return TypeConvertor.JSValueDelProperty(this.jsContext, this.jsValue, str);
    }

    public int getInt(String str) {
        return (int) TypeConvertor.JSValue2Double(this.jsContext, getProperty(str));
    }

    public long getLong(String str) {
        return (long) TypeConvertor.JSValue2Double(this.jsContext, getProperty(str));
    }

    public double getDouble(String str) {
        return TypeConvertor.JSValue2Double(this.jsContext, getProperty(str));
    }

    public boolean getBoolean(String str) {
        return TypeConvertor.JSValue2Boolean(this.jsContext, getProperty(str));
    }

    public String getString(String str) {
        return TypeConvertor.JSValue2String(this.jsContext, getProperty(str));
    }

    public JSValue getJSValue(String str) {
        return JSCValue.wrapper(this.jsContext, getProperty(str));
    }

    public void set(String str, Number number) {
        set(str, (JSValue) JSCValue.create(this.jsContext, number));
    }

    public void set(String str, boolean z) {
        set(str, (JSValue) JSCValue.create(this.jsContext, z));
    }

    public void set(String str, String str2) {
        set(str, (JSValue) JSCValue.create(this.jsContext, str2));
    }

    public void set(String str, Object obj) {
        set(str, (JSValue) JSCValue.create(this.jsContext, obj));
    }

    public void set(String str, JSValue jSValue) {
        setProperty(str, ((JSCValue) jSValue).value);
    }

    public void set(String str, JSCallback jSCallback) {
        setProperty(str, ((JSCCallback) jSCallback).value);
    }

    public Object callFunction(String str, Object... objArr) {
        return new CallbackImpl(this.jsContext, getProperty(str), this.jsValue).call(objArr);
    }
}
