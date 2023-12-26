package com.didi.hummer.core.engine.jsc.jni;

public class TypeConvertor {
    public static native long JSFunctionCall(long j, long j2, long j3, long... jArr);

    public static native boolean JSValue2Boolean(long j, long j2);

    public static native double JSValue2Double(long j, long j2);

    public static native String JSValue2String(long j, long j2);

    public static native boolean JSValueDelProperty(long j, long j2, String str);

    public static native long JSValueGetProperty(long j, long j2, String str);

    public static native void JSValueProtect(long j, long j2);

    public static native void JSValueSetProperty(long j, long j2, String str, long j3);

    public static native void JSValueUnProtect(long j, long j2);

    public static native boolean isJSBoolean(long j, long j2);

    public static native boolean isJSContextValid(long j);

    public static native boolean isJSFunction(long j, long j2);

    public static native boolean isJSNull(long j, long j2);

    public static native boolean isJSNumber(long j, long j2);

    public static native boolean isJSString(long j, long j2);

    public static native boolean isJSUndefined(long j, long j2);

    public static native boolean isJSValueValid(long j, long j2);

    public static native long makeBoolean(long j, boolean z);

    public static native long makeFromJsonString(long j, String str);

    public static native long makeNumber(long j, double d);

    public static native long makeString(long j, String str);
}
