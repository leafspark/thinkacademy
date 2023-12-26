package com.didi.hummer.core.engine.napi.jni;

import com.didi.hummer.core.engine.base.ICallback;
import com.didi.hummer.core.engine.base.IRecycler;
import com.didi.hummer.core.util.HMGsonUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JSEngine {
    private static final Map<Long, Map<Integer, ICallback>> callbackMaps = new ConcurrentHashMap();
    private static final Map<Long, IRecycler> recyclerMap = new ConcurrentHashMap();

    public static native Object callFunction(long j, long j2, long j3, Object... objArr);

    public static native byte[] compileJavaScript(long j, String str, String str2);

    public static native long createJSContext();

    public static native boolean delProperty(long j, long j2, String str);

    public static native void destroyJSContext(long j);

    public static native Object evaluateBytecode(long j, byte[] bArr);

    public static native Object evaluateJavaScript(long j, String str, String str2);

    public static native Object getProperty(long j, long j2, String str);

    public static native boolean isJSContextValid(long j);

    public static native boolean isJSValueEqual(long j, long j2, long j3);

    public static native boolean isJSValueValid(long j, long j2);

    public static native void protect(long j, long j2);

    public static native void registerFunction(long j, long j2, String str, int i);

    public static native void setProperty(long j, long j2, String str, Object obj);

    public static native void unprotect(long j, long j2);

    public static String toJsonString(Object obj) {
        return HMGsonUtil.toJson(obj);
    }

    private static Object callJavaCallback(long j, int i, Object... objArr) {
        ICallback iCallback;
        Map map = callbackMaps.get(Long.valueOf(j));
        if (map == null || (iCallback = (ICallback) map.get(Integer.valueOf(i))) == null) {
            return null;
        }
        return iCallback.call(objArr);
    }

    private static void callJavaRecycler(long j, long j2) {
        IRecycler iRecycler = recyclerMap.get(Long.valueOf(j));
        if (iRecycler != null) {
            iRecycler.onRecycle(j2);
        }
    }

    public static void registerJSCallback(long j, long j2, String str, ICallback iCallback) {
        int hashCode = iCallback.hashCode();
        registerFunction(j, j2, str, hashCode);
        Map<Long, Map<Integer, ICallback>> map = callbackMaps;
        Map map2 = map.get(Long.valueOf(j));
        if (map2 == null) {
            map2 = new HashMap();
            map.put(Long.valueOf(j), map2);
        }
        map2.put(Integer.valueOf(hashCode), iCallback);
    }

    public static void unregisterJSCallback(long j) {
        Map remove = callbackMaps.remove(Long.valueOf(j));
        if (remove != null) {
            remove.clear();
        }
    }

    public static void unregisterJSCallback(long j, ICallback iCallback) {
        Map map = callbackMaps.get(Long.valueOf(j));
        if (map != null) {
            map.remove(Integer.valueOf(iCallback.hashCode()));
        }
    }

    public static void registerJSRecycler(long j, IRecycler iRecycler) {
        recyclerMap.put(Long.valueOf(j), iRecycler);
    }

    public static void unregisterJSRecycler(long j) {
        recyclerMap.remove(Long.valueOf(j));
    }
}
