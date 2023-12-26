package com.didi.hummer.core.engine.napi;

import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.engine.base.ICallback;
import com.didi.hummer.core.engine.napi.jni.JSEngine;
import java.lang.reflect.Type;

public class NAPIValue implements JSValue {
    public long context;
    private volatile boolean isUnprotected = true;
    public long value;

    @Deprecated
    public boolean booleanValue() {
        return false;
    }

    @Deprecated
    public double doubleValue() {
        return 0.0d;
    }

    @Deprecated
    public float floatValue() {
        return 0.0f;
    }

    @Deprecated
    public int intValue() {
        return 0;
    }

    @Deprecated
    public boolean isBoolean() {
        return false;
    }

    @Deprecated
    public boolean isFunction() {
        return false;
    }

    @Deprecated
    public boolean isNull() {
        return false;
    }

    @Deprecated
    public boolean isNumber() {
        return false;
    }

    @Deprecated
    public boolean isString() {
        return false;
    }

    @Deprecated
    public <T> T jsonValueOf(Type type) {
        return null;
    }

    @Deprecated
    public long longValue() {
        return 0;
    }

    @Deprecated
    public String stringValue() {
        return null;
    }

    public static NAPIValue wrapper(long j, long j2) {
        return new NAPIValue(j, j2);
    }

    protected NAPIValue(long j, long j2) {
        this.context = j;
        this.value = j2;
    }

    public JSContext getJSContext() {
        return NAPIContext.wrapper(this.context);
    }

    public boolean isValid() {
        return JSEngine.isJSValueValid(this.context, this.value);
    }

    public int getInt(String str) {
        Object property = JSEngine.getProperty(this.context, this.value, str);
        if (!(property instanceof Number)) {
            return 0;
        }
        return ((Number) property).intValue();
    }

    public long getLong(String str) {
        Object property = JSEngine.getProperty(this.context, this.value, str);
        if (!(property instanceof Number)) {
            return 0;
        }
        return ((Number) property).longValue();
    }

    public double getDouble(String str) {
        Object property = JSEngine.getProperty(this.context, this.value, str);
        if (!(property instanceof Number)) {
            return 0.0d;
        }
        return ((Number) property).doubleValue();
    }

    public boolean getBoolean(String str) {
        Object property = JSEngine.getProperty(this.context, this.value, str);
        if (!(property instanceof Boolean)) {
            return false;
        }
        return ((Boolean) property).booleanValue();
    }

    public String getString(String str) {
        Object property = JSEngine.getProperty(this.context, this.value, str);
        if (!(property instanceof String)) {
            return null;
        }
        return (String) property;
    }

    public JSValue getJSValue(String str) {
        Object property = JSEngine.getProperty(this.context, this.value, str);
        if (property instanceof JSCallback) {
            return (JSCallback) property;
        }
        if (property instanceof JSValue) {
            return (JSValue) property;
        }
        return null;
    }

    public void set(String str, Number number) {
        JSEngine.setProperty(this.context, this.value, str, number);
    }

    public void set(String str, boolean z) {
        JSEngine.setProperty(this.context, this.value, str, Boolean.valueOf(z));
    }

    public void set(String str, String str2) {
        JSEngine.setProperty(this.context, this.value, str, str2);
    }

    public void set(String str, Object obj) {
        if (obj instanceof ICallback) {
            JSEngine.registerJSCallback(this.context, this.value, str, (ICallback) obj);
            return;
        }
        JSEngine.setProperty(this.context, this.value, str, obj);
    }

    public void set(String str, JSValue jSValue) {
        JSEngine.setProperty(this.context, this.value, str, jSValue);
    }

    public void set(String str, JSCallback jSCallback) {
        JSEngine.setProperty(this.context, this.value, str, jSCallback);
    }

    public Object callFunction(String str, Object... objArr) {
        Object property = JSEngine.getProperty(this.context, this.value, str);
        if (!(property instanceof JSCallback)) {
            return null;
        }
        return JSEngine.callFunction(this.context, this.value, ((JSCallback) property).getIdentify(), objArr);
    }

    public void protect() {
        if (this.isUnprotected) {
            this.isUnprotected = false;
            JSEngine.protect(this.context, this.value);
        }
    }

    public void unprotect() {
        if (!this.isUnprotected) {
            this.isUnprotected = true;
            JSEngine.unprotect(this.context, this.value);
        }
    }

    public long getIdentify() {
        return this.value;
    }

    public void release() {
        unprotect();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JSValue)) {
            return false;
        }
        JSValue jSValue = (JSValue) obj;
        return JSEngine.isJSValueEqual(jSValue.getJSContext().getIdentify(), jSValue.getIdentify(), getIdentify());
    }

    public String toString() {
        return "NAPIValue{context=" + this.context + ", value=" + this.value + ", isUnprotected=" + this.isUnprotected + '}';
    }
}
