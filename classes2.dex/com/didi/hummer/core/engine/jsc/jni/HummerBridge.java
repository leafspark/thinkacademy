package com.didi.hummer.core.engine.jsc.jni;

import com.didi.hummer.core.engine.jsc.JSCContext;
import com.didi.hummer.core.engine.jsc.JSCUtils;
import com.didi.hummer.core.util.DebugUtil;
import com.didi.hummer.core.util.ExceptionUtil;
import com.didi.hummer.core.util.HMLog;
import java.util.Arrays;

public class HummerBridge {
    private long jsContext;
    private InvokeCallback mCallback;

    public interface InvokeCallback {
        Object onInvoke(String str, long j, String str2, Object... objArr);
    }

    private native void initHummerBridge(long j);

    private native void releaseHummerBridge(long j);

    public HummerBridge(long j, InvokeCallback invokeCallback) {
        this.jsContext = j;
        this.mCallback = invokeCallback;
        initHummerBridge(j);
        HMLog.d("HummerNative", "HummerBridge.init");
    }

    public void onDestroy() {
        HMLog.d("HummerNative", "HummerBridge.onDestroy");
        releaseHummerBridge(this.jsContext);
        this.mCallback = null;
    }

    private long invoke(String str, long j, String str2, long... jArr) {
        String str3 = str2;
        if (DebugUtil.isDebuggable()) {
            HMLog.d("HummerNative", String.format("[Java invoked][objectID=%d][className=%s][method=%s][params=%s]", new Object[]{Long.valueOf(j), str, str3, Arrays.toString(jArr)}));
        }
        if (this.mCallback == null) {
            return -1;
        }
        Object[] objArr = null;
        try {
            Object[] jsValuesToObjects = JSCUtils.jsValuesToObjects(this.jsContext, jArr);
            try {
                return JSCUtils.objectToJsValue(this.jsContext, this.mCallback.onInvoke(str, j, str2, jsValuesToObjects));
            } catch (Exception e) {
                e = e;
                objArr = jsValuesToObjects;
                String jSErrorStack = ExceptionUtil.getJSErrorStack(JSCContext.wrapper(this.jsContext));
                ExceptionUtil.addStackTrace(e, new StackTraceElement("<<JS_Stack>>", "", "\n" + jSErrorStack, -1));
                ExceptionUtil.addStackTrace(e, new StackTraceElement(String.format("<<Bridge>> (%d) %s", new Object[]{Long.valueOf(j), str}), str3, Arrays.toString(objArr), -1));
                HummerException.nativeException(this.jsContext, e);
                return -1;
            }
        } catch (Exception e2) {
            e = e2;
            String jSErrorStack2 = ExceptionUtil.getJSErrorStack(JSCContext.wrapper(this.jsContext));
            ExceptionUtil.addStackTrace(e, new StackTraceElement("<<JS_Stack>>", "", "\n" + jSErrorStack2, -1));
            ExceptionUtil.addStackTrace(e, new StackTraceElement(String.format("<<Bridge>> (%d) %s", new Object[]{Long.valueOf(j), str}), str3, Arrays.toString(objArr), -1));
            HummerException.nativeException(this.jsContext, e);
            return -1;
        }
    }
}
