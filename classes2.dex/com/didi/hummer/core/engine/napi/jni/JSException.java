package com.didi.hummer.core.engine.napi.jni;

import android.util.LongSparseArray;
import com.didi.hummer.core.engine.JSContext;
import com.didi.hummer.core.exception.ExceptionCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JSException {
    private static LongSparseArray<List<ExceptionCallback>> contextCallbacks = new LongSparseArray<>();

    public interface JSExceptionCallback {
        void onException(long j, String str);
    }

    private static native void init(JSExceptionCallback jSExceptionCallback);

    public static void init() {
        init(JSException$$ExternalSyntheticLambda0.INSTANCE);
    }

    public static void nativeException(JSContext jSContext, Exception exc) {
        nativeException(jSContext.getIdentify(), exc);
    }

    public static void nativeException(long j, Exception exc) {
        dispatchExceptionCallback(j, exc);
    }

    public static void addJSContextExceptionCallback(JSContext jSContext, ExceptionCallback exceptionCallback) {
        List list = contextCallbacks.get(jSContext.getIdentify());
        if (list == null) {
            list = new ArrayList();
            contextCallbacks.put(jSContext.getIdentify(), list);
        }
        list.add(exceptionCallback);
    }

    public static void removeJSContextExceptionCallback(JSContext jSContext, ExceptionCallback exceptionCallback) {
        List list = contextCallbacks.get(jSContext.getIdentify());
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((ExceptionCallback) it.next()) == exceptionCallback) {
                    it.remove();
                }
            }
        }
    }

    public static void removeJSContextExceptionCallback(JSContext jSContext) {
        contextCallbacks.remove(jSContext.getIdentify());
    }

    /* access modifiers changed from: private */
    public static void dispatchExceptionCallback(long j, Exception exc) {
        List<ExceptionCallback> list = contextCallbacks.get(j);
        if (list != null) {
            for (ExceptionCallback exceptionCallback : list) {
                if (exceptionCallback != null) {
                    exceptionCallback.onException(exc);
                }
            }
        }
    }
}
