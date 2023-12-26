package com.didi.hummer.core.engine.jsc.base;

import com.didi.hummer.core.engine.base.IValueOperator;
import com.didi.hummer.core.engine.jsc.jni.TypeConvertor;
import com.didi.hummer.core.util.HMGsonUtil;
import java.lang.reflect.Type;

public class ValueOperator implements IValueOperator {
    public long jsContext;
    public long jsValue;

    public ValueOperator(long j, long j2) {
        this.jsContext = j;
        this.jsValue = j2;
    }

    public int intValue() {
        return (int) TypeConvertor.JSValue2Double(this.jsContext, this.jsValue);
    }

    public long longValue() {
        return (long) TypeConvertor.JSValue2Double(this.jsContext, this.jsValue);
    }

    public float floatValue() {
        return (float) TypeConvertor.JSValue2Double(this.jsContext, this.jsValue);
    }

    public double doubleValue() {
        return TypeConvertor.JSValue2Double(this.jsContext, this.jsValue);
    }

    public boolean booleanValue() {
        return TypeConvertor.JSValue2Boolean(this.jsContext, this.jsValue);
    }

    public String stringValue() {
        return TypeConvertor.JSValue2String(this.jsContext, this.jsValue);
    }

    public <T> T jsonValueOf(Type type) {
        return HMGsonUtil.fromJson(stringValue(), type);
    }

    public boolean isNumber() {
        return TypeConvertor.isJSNumber(this.jsContext, this.jsValue);
    }

    public boolean isBoolean() {
        return TypeConvertor.isJSBoolean(this.jsContext, this.jsValue);
    }

    public boolean isString() {
        return TypeConvertor.isJSString(this.jsContext, this.jsValue);
    }

    public boolean isFunction() {
        return TypeConvertor.isJSFunction(this.jsContext, this.jsValue);
    }

    public boolean isNull() {
        return TypeConvertor.isJSNull(this.jsContext, this.jsValue) || TypeConvertor.isJSUndefined(this.jsContext, this.jsValue);
    }

    public void protect() {
        TypeConvertor.JSValueProtect(this.jsContext, this.jsValue);
    }

    public void unprotect() {
        TypeConvertor.JSValueUnProtect(this.jsContext, this.jsValue);
    }
}
