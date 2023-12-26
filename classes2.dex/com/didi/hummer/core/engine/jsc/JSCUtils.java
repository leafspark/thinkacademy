package com.didi.hummer.core.engine.jsc;

import com.didi.hummer.core.engine.jsc.jni.TypeConvertor;
import com.didi.hummer.core.util.HMGsonUtil;

public class JSCUtils {
    public static final long POINTER_NULL = -1;

    public static Object jsValueToObject(long j, long j2) {
        return jsValueToObject(JSCValue.wrapper(j, j2));
    }

    public static Object jsValueToObject(JSCValue jSCValue) {
        if (jSCValue == null || jSCValue.isNull()) {
            return null;
        }
        if (jSCValue.isNumber()) {
            return Double.valueOf(jSCValue.doubleValue());
        }
        if (jSCValue.isBoolean()) {
            return Boolean.valueOf(jSCValue.booleanValue());
        }
        if (jSCValue.isString()) {
            return jSCValue.stringValue();
        }
        return jSCValue.isFunction() ? JSCCallback.wrapper(jSCValue.context, jSCValue.value) : jSCValue;
    }

    public static Object[] jsValuesToObjects(long j, long... jArr) {
        if (jArr == null || jArr.length <= 0) {
            return new Object[0];
        }
        Object[] objArr = new Object[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            objArr[i] = jsValueToObject(j, jArr[i]);
        }
        return objArr;
    }

    public static long objectToJsValue(long j, Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Number) {
            return TypeConvertor.makeNumber(j, ((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return TypeConvertor.makeBoolean(j, ((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return TypeConvertor.makeString(j, (String) obj);
        }
        if (obj instanceof JSCValue) {
            return ((JSCValue) obj).value;
        }
        return TypeConvertor.makeFromJsonString(j, HMGsonUtil.toJson(obj));
    }

    public static long[] objectsToJsValues(long j, Object... objArr) {
        if (objArr == null) {
            return null;
        }
        long[] jArr = new long[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            jArr[i] = objectToJsValue(j, objArr[i]);
        }
        return jArr;
    }
}
