package com.didi.hummer.module.notifycenter;

import android.content.Context;
import androidx.collection.LongSparseArray;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSContext;
import com.didi.hummer.core.engine.base.ICallback;
import java.util.List;
import java.util.Map;

public class NotifyCenter {
    private static LongSparseArray<Map<String, List<ICallback>>> globalNotifyMap = new LongSparseArray<>();

    private static long getContextId(ICallback iCallback) {
        JSContext jSContext;
        if (iCallback == null) {
            return -1;
        }
        if (iCallback instanceof NotifyCallback) {
            return ((NotifyCallback) iCallback).getContextId();
        }
        if (!(iCallback instanceof JSCallback) || (jSContext = ((JSCallback) iCallback).getJSContext()) == null) {
            return -1;
        }
        return jSContext.getIdentify();
    }

    @JsMethod("triggerEvent")
    public static synchronized void triggerEvent(String str, Object obj) {
        List<ICallback> list;
        synchronized (NotifyCenter.class) {
            for (int i = 0; i < globalNotifyMap.size(); i++) {
                Map map = (Map) globalNotifyMap.valueAt(i);
                if (!(map == null || (list = (List) map.get(str)) == null)) {
                    for (ICallback call : list) {
                        call.call(obj);
                    }
                }
            }
        }
    }

    @JsMethod("addEventListener")
    public static synchronized void addEventListener(String str, JSCallback jSCallback) {
        synchronized (NotifyCenter.class) {
            addEventListener(str, (ICallback) jSCallback);
        }
    }

    public static synchronized void addEventListener(String str, NotifyCallback notifyCallback) {
        synchronized (NotifyCenter.class) {
            addEventListener(str, (ICallback) notifyCallback);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void addEventListener(java.lang.String r5, com.didi.hummer.core.engine.base.ICallback r6) {
        /*
            java.lang.Class<com.didi.hummer.module.notifycenter.NotifyCenter> r0 = com.didi.hummer.module.notifycenter.NotifyCenter.class
            monitor-enter(r0)
            if (r6 != 0) goto L_0x0007
            monitor-exit(r0)
            return
        L_0x0007:
            long r1 = getContextId(r6)     // Catch:{ all -> 0x0042 }
            r3 = 0
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0013
            monitor-exit(r0)
            return
        L_0x0013:
            androidx.collection.LongSparseArray<java.util.Map<java.lang.String, java.util.List<com.didi.hummer.core.engine.base.ICallback>>> r3 = globalNotifyMap     // Catch:{ all -> 0x0042 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x0042 }
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ all -> 0x0042 }
            if (r3 != 0) goto L_0x0027
            java.util.concurrent.ConcurrentHashMap r3 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x0042 }
            r3.<init>()     // Catch:{ all -> 0x0042 }
            androidx.collection.LongSparseArray<java.util.Map<java.lang.String, java.util.List<com.didi.hummer.core.engine.base.ICallback>>> r4 = globalNotifyMap     // Catch:{ all -> 0x0042 }
            r4.put(r1, r3)     // Catch:{ all -> 0x0042 }
        L_0x0027:
            java.lang.Object r1 = r3.get(r5)     // Catch:{ all -> 0x0042 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0042 }
            if (r1 != 0) goto L_0x0037
            java.util.concurrent.CopyOnWriteArrayList r1 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ all -> 0x0042 }
            r1.<init>()     // Catch:{ all -> 0x0042 }
            r3.put(r5, r1)     // Catch:{ all -> 0x0042 }
        L_0x0037:
            boolean r5 = r1.contains(r6)     // Catch:{ all -> 0x0042 }
            if (r5 != 0) goto L_0x0040
            r1.add(r6)     // Catch:{ all -> 0x0042 }
        L_0x0040:
            monitor-exit(r0)
            return
        L_0x0042:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.module.notifycenter.NotifyCenter.addEventListener(java.lang.String, com.didi.hummer.core.engine.base.ICallback):void");
    }

    @JsMethod("removeEventListener")
    public static synchronized void removeEventListener(HummerContext hummerContext, String str, JSCallback jSCallback) {
        synchronized (NotifyCenter.class) {
            long contextId = getContextId(jSCallback);
            if (contextId < 0 && hummerContext != null) {
                contextId = hummerContext.getJsContext().getIdentify();
            }
            removeEventListener(contextId, str, (ICallback) jSCallback);
        }
    }

    public static synchronized void removeEventListener(Context context, String str) {
        synchronized (NotifyCenter.class) {
            removeEventListener(context, str, (ICallback) null);
        }
    }

    public static synchronized void removeEventListener(String str, ICallback iCallback) {
        synchronized (NotifyCenter.class) {
            removeEventListener((Context) null, str, iCallback);
        }
    }

    public static synchronized void removeEventListener(Context context, String str, ICallback iCallback) {
        synchronized (NotifyCenter.class) {
            long contextId = getContextId(iCallback);
            if (contextId < 0 && context != null) {
                contextId = (long) context.hashCode();
            }
            removeEventListener(contextId, str, iCallback);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void removeEventListener(long r3, java.lang.String r5, com.didi.hummer.core.engine.base.ICallback r6) {
        /*
            java.lang.Class<com.didi.hummer.module.notifycenter.NotifyCenter> r0 = com.didi.hummer.module.notifycenter.NotifyCenter.class
            monitor-enter(r0)
            r1 = 0
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x000b
            monitor-exit(r0)
            return
        L_0x000b:
            androidx.collection.LongSparseArray<java.util.Map<java.lang.String, java.util.List<com.didi.hummer.core.engine.base.ICallback>>> r1 = globalNotifyMap     // Catch:{ all -> 0x006c }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x006c }
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x006a
            java.lang.Object r3 = r3.get(r5)     // Catch:{ all -> 0x006c }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x006a
            boolean r4 = r3.isEmpty()     // Catch:{ all -> 0x006c }
            if (r4 != 0) goto L_0x006a
            if (r6 != 0) goto L_0x0043
            java.util.Iterator r4 = r3.iterator()     // Catch:{ all -> 0x006c }
        L_0x0029:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x006c }
            if (r5 == 0) goto L_0x003f
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x006c }
            com.didi.hummer.core.engine.base.ICallback r5 = (com.didi.hummer.core.engine.base.ICallback) r5     // Catch:{ all -> 0x006c }
            boolean r6 = r5 instanceof com.didi.hummer.core.engine.JSCallback     // Catch:{ all -> 0x006c }
            if (r6 == 0) goto L_0x0029
            com.didi.hummer.core.engine.JSCallback r5 = (com.didi.hummer.core.engine.JSCallback) r5     // Catch:{ all -> 0x006c }
            r5.release()     // Catch:{ all -> 0x006c }
            goto L_0x0029
        L_0x003f:
            r3.clear()     // Catch:{ all -> 0x006c }
            goto L_0x006a
        L_0x0043:
            r4 = 0
            java.util.Iterator r5 = r3.iterator()     // Catch:{ all -> 0x006c }
        L_0x0048:
            boolean r1 = r5.hasNext()     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x005d
            java.lang.Object r1 = r5.next()     // Catch:{ all -> 0x006c }
            com.didi.hummer.core.engine.base.ICallback r1 = (com.didi.hummer.core.engine.base.ICallback) r1     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x0048
            boolean r2 = r1.equals(r6)     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x0048
            r4 = r1
        L_0x005d:
            boolean r5 = r4 instanceof com.didi.hummer.core.engine.JSCallback     // Catch:{ all -> 0x006c }
            if (r5 == 0) goto L_0x006a
            r5 = r4
            com.didi.hummer.core.engine.JSCallback r5 = (com.didi.hummer.core.engine.JSCallback) r5     // Catch:{ all -> 0x006c }
            r5.release()     // Catch:{ all -> 0x006c }
            r3.remove(r4)     // Catch:{ all -> 0x006c }
        L_0x006a:
            monitor-exit(r0)
            return
        L_0x006c:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.module.notifycenter.NotifyCenter.removeEventListener(long, java.lang.String, com.didi.hummer.core.engine.base.ICallback):void");
    }

    public static synchronized void release(JSContext jSContext) {
        synchronized (NotifyCenter.class) {
            release(jSContext.getIdentify());
        }
    }

    public static synchronized void release(Context context) {
        synchronized (NotifyCenter.class) {
            release((long) context.hashCode());
        }
    }

    private static synchronized void release(long j) {
        synchronized (NotifyCenter.class) {
            Map map = (Map) globalNotifyMap.get(j);
            if (map != null) {
                for (String str : map.keySet()) {
                    List<ICallback> list = (List) map.get(str);
                    if (list != null && !list.isEmpty()) {
                        for (ICallback iCallback : list) {
                            if (iCallback instanceof JSCallback) {
                                ((JSCallback) iCallback).release();
                            }
                        }
                        list.clear();
                    }
                }
                map.clear();
            }
            globalNotifyMap.remove(j);
        }
    }

    public static synchronized void releaseAll() {
        synchronized (NotifyCenter.class) {
            for (int i = 0; i < globalNotifyMap.size(); i++) {
                Map map = (Map) globalNotifyMap.valueAt(i);
                if (map != null) {
                    for (String str : map.keySet()) {
                        List<ICallback> list = (List) map.get(str);
                        if (list != null && !list.isEmpty()) {
                            for (ICallback iCallback : list) {
                                if (iCallback instanceof JSCallback) {
                                    ((JSCallback) iCallback).release();
                                }
                            }
                            list.clear();
                        }
                    }
                    map.clear();
                }
            }
            globalNotifyMap.clear();
        }
    }
}
