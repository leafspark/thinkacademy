package com.didi.hummer.core.engine.jsc.jni;

public final class JavaScriptRuntime {
    private static native byte[] compileJavaScriptNative(long j, String str, String str2);

    private static native long createJSContextNative();

    private static native void destroyJSContextNative(long j);

    private static native long evaluateBytecodeNative(long j, byte[] bArr);

    private static native long evaluateJavaScriptNative(long j, String str, String str2);

    public static long createJSContext() {
        return createJSContextNative();
    }

    public static void destroyJSContext(long j) {
        destroyJSContextNative(j);
    }

    public static long evaluateJavaScript(long j, String str) {
        return evaluateJavaScriptNative(j, str, "");
    }

    public static long evaluateJavaScript(long j, String str, String str2) {
        return evaluateJavaScriptNative(j, str, str2);
    }

    public static byte[] compileJavaScript(long j, String str, String str2) {
        return compileJavaScriptNative(j, str, str2);
    }

    public static long evaluateBytecode(long j, byte[] bArr) {
        return evaluateBytecodeNative(j, bArr);
    }
}
