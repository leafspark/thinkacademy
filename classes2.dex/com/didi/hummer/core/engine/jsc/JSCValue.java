package com.didi.hummer.core.engine.jsc;

import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.engine.base.IObjectOperator;
import com.didi.hummer.core.engine.base.IValueOperator;
import com.didi.hummer.core.engine.jsc.base.ObjectOperator;
import com.didi.hummer.core.engine.jsc.base.ValueOperator;
import com.didi.hummer.core.engine.jsc.jni.TypeConvertor;
import com.didi.hummer.core.util.HMGsonUtil;
import java.lang.reflect.Type;

public class JSCValue implements JSValue {
    public long context;
    private volatile boolean isUnprotected = true;
    private IObjectOperator objectOperator;
    public long value;
    private IValueOperator valueOperator;

    public static JSCValue create(long j, Number number) {
        return wrapper(j, TypeConvertor.makeNumber(j, number.doubleValue()));
    }

    public static JSCValue create(long j, boolean z) {
        return wrapper(j, TypeConvertor.makeBoolean(j, z));
    }

    public static JSCValue create(long j, String str) {
        return wrapper(j, TypeConvertor.makeString(j, str));
    }

    public static JSCValue create(long j, Object obj) {
        if (obj instanceof Number) {
            return create(j, (Number) obj);
        }
        if (obj instanceof Boolean) {
            return create(j, (Object) (Boolean) obj);
        }
        if (obj instanceof String) {
            return create(j, (String) obj);
        }
        return wrapper(j, TypeConvertor.makeFromJsonString(j, HMGsonUtil.toJson(obj)));
    }

    public static JSCValue createEmptyObject(long j) {
        return wrapper(j, TypeConvertor.makeFromJsonString(j, "{}"));
    }

    public static JSCValue createEmptyArray(long j) {
        return wrapper(j, TypeConvertor.makeFromJsonString(j, "[]"));
    }

    public static JSCValue wrapper(long j, long j2) {
        return new JSCValue(j, j2);
    }

    protected JSCValue(long j, long j2) {
        this.context = j;
        this.value = j2;
        this.valueOperator = new ValueOperator(j, j2);
        this.objectOperator = new ObjectOperator(j, j2);
    }

    public JSContext getJSContext() {
        return JSCContext.wrapper(this.context);
    }

    public boolean isValid() {
        return TypeConvertor.isJSValueValid(this.context, this.value);
    }

    public long getIdentify() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JSCValue)) {
            return false;
        }
        JSCValue jSCValue = (JSCValue) obj;
        if (jSCValue.context == this.context && jSCValue.value == this.value) {
            return true;
        }
        return false;
    }

    public int intValue() {
        return this.valueOperator.intValue();
    }

    public long longValue() {
        return this.valueOperator.longValue();
    }

    public float floatValue() {
        return this.valueOperator.floatValue();
    }

    public double doubleValue() {
        return this.valueOperator.doubleValue();
    }

    public boolean booleanValue() {
        return this.valueOperator.booleanValue();
    }

    public String stringValue() {
        return this.valueOperator.stringValue();
    }

    public <T> T jsonValueOf(Type type) {
        return this.valueOperator.jsonValueOf(type);
    }

    public boolean isNumber() {
        return this.valueOperator.isNumber();
    }

    public boolean isBoolean() {
        return this.valueOperator.isBoolean();
    }

    public boolean isString() {
        return this.valueOperator.isString();
    }

    public boolean isFunction() {
        return this.valueOperator.isFunction();
    }

    public boolean isNull() {
        return this.valueOperator.isNull();
    }

    public void protect() {
        if (this.isUnprotected) {
            this.isUnprotected = false;
            this.valueOperator.protect();
        }
    }

    public void unprotect() {
        if (!this.isUnprotected) {
            this.isUnprotected = true;
            this.valueOperator.unprotect();
        }
    }

    public int getInt(String str) {
        return this.objectOperator.getInt(str);
    }

    public long getLong(String str) {
        return this.objectOperator.getLong(str);
    }

    public double getDouble(String str) {
        return this.objectOperator.getDouble(str);
    }

    public boolean getBoolean(String str) {
        return this.objectOperator.getBoolean(str);
    }

    public String getString(String str) {
        return this.objectOperator.getString(str);
    }

    public JSValue getJSValue(String str) {
        return this.objectOperator.getJSValue(str);
    }

    public void set(String str, Number number) {
        this.objectOperator.set(str, number);
    }

    public void set(String str, boolean z) {
        this.objectOperator.set(str, z);
    }

    public void set(String str, String str2) {
        this.objectOperator.set(str, str2);
    }

    public void set(String str, Object obj) {
        this.objectOperator.set(str, obj);
    }

    public void set(String str, JSValue jSValue) {
        this.objectOperator.set(str, jSValue);
    }

    public void set(String str, JSCallback jSCallback) {
        this.objectOperator.set(str, jSCallback);
    }

    public Object callFunction(String str, Object... objArr) {
        return this.objectOperator.callFunction(str, objArr);
    }

    public void release() {
        unprotect();
    }
}
