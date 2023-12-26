package com.tal.thinkacademy.networkprobe.cache;

import java.util.HashMap;
import kotlin.Metadata;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\fR*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/tal/thinkacademy/networkprobe/cache/TraceEventCache;", "", "()V", "mCallMap", "Ljava/util/HashMap;", "", "Lcom/tal/thinkacademy/networkprobe/cache/NetworkTraceCache;", "Lkotlin/collections/HashMap;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "clear", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isEmpty", "", "save", "trace", "(Ljava/lang/String;Lcom/tal/thinkacademy/networkprobe/cache/NetworkTraceCache;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "size", "", "networkprobe_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TraceEventCache.kt */
public final class TraceEventCache {
    public static final TraceEventCache INSTANCE = new TraceEventCache();
    private static final HashMap<String, NetworkTraceCache> mCallMap = new HashMap<>();
    private static final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);

    private TraceEventCache() {
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object save(java.lang.String r6, com.tal.thinkacademy.networkprobe.cache.NetworkTraceCache r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.tal.thinkacademy.networkprobe.cache.TraceEventCache$save$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.tal.thinkacademy.networkprobe.cache.TraceEventCache$save$1 r0 = (com.tal.thinkacademy.networkprobe.cache.TraceEventCache$save$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.tal.thinkacademy.networkprobe.cache.TraceEventCache$save$1 r0 = new com.tal.thinkacademy.networkprobe.cache.TraceEventCache$save$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 != r4) goto L_0x0039
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r7 = r0.L$1
            com.tal.thinkacademy.networkprobe.cache.NetworkTraceCache r7 = (com.tal.thinkacademy.networkprobe.cache.NetworkTraceCache) r7
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r6
            r6 = r0
            goto L_0x0055
        L_0x0039:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Mutex r8 = mutex
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.label = r4
            java.lang.Object r0 = r8.lock(r3, r0)
            if (r0 != r1) goto L_0x0055
            return r1
        L_0x0055:
            java.util.HashMap<java.lang.String, com.tal.thinkacademy.networkprobe.cache.NetworkTraceCache> r0 = mCallMap     // Catch:{ all -> 0x0064 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0064 }
            r0.put(r6, r7)     // Catch:{ all -> 0x0064 }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0064 }
            r8.unlock(r3)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0064:
            r6 = move-exception
            r8.unlock(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.thinkacademy.networkprobe.cache.TraceEventCache.save(java.lang.String, com.tal.thinkacademy.networkprobe.cache.NetworkTraceCache, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(java.lang.String r6, kotlin.coroutines.Continuation<? super com.tal.thinkacademy.networkprobe.cache.NetworkTraceCache> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.tal.thinkacademy.networkprobe.cache.TraceEventCache$get$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.tal.thinkacademy.networkprobe.cache.TraceEventCache$get$1 r0 = (com.tal.thinkacademy.networkprobe.cache.TraceEventCache$get$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.tal.thinkacademy.networkprobe.cache.TraceEventCache$get$1 r0 = new com.tal.thinkacademy.networkprobe.cache.TraceEventCache$get$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r4) goto L_0x0035
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r6
            r6 = r0
            goto L_0x004f
        L_0x0035:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.sync.Mutex r7 = mutex
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r0 = r7.lock(r3, r0)
            if (r0 != r1) goto L_0x004f
            return r1
        L_0x004f:
            java.util.HashMap<java.lang.String, com.tal.thinkacademy.networkprobe.cache.NetworkTraceCache> r0 = mCallMap     // Catch:{ all -> 0x0059 }
            java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x0059 }
            r7.unlock(r3)
            return r6
        L_0x0059:
            r6 = move-exception
            r7.unlock(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.thinkacademy.networkprobe.cache.TraceEventCache.get(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object isEmpty(kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.tal.thinkacademy.networkprobe.cache.TraceEventCache$isEmpty$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.tal.thinkacademy.networkprobe.cache.TraceEventCache$isEmpty$1 r0 = (com.tal.thinkacademy.networkprobe.cache.TraceEventCache$isEmpty$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.tal.thinkacademy.networkprobe.cache.TraceEventCache$isEmpty$1 r0 = new com.tal.thinkacademy.networkprobe.cache.TraceEventCache$isEmpty$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0048
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = mutex
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r0 = r6.lock(r3, r0)
            if (r0 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r0 = r6
        L_0x0048:
            java.util.HashMap<java.lang.String, com.tal.thinkacademy.networkprobe.cache.NetworkTraceCache> r6 = mCallMap     // Catch:{ all -> 0x0056 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0056 }
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)     // Catch:{ all -> 0x0056 }
            r0.unlock(r3)
            return r6
        L_0x0056:
            r6 = move-exception
            r0.unlock(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.thinkacademy.networkprobe.cache.TraceEventCache.isEmpty(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object size(kotlin.coroutines.Continuation<? super java.lang.Integer> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.tal.thinkacademy.networkprobe.cache.TraceEventCache$size$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.tal.thinkacademy.networkprobe.cache.TraceEventCache$size$1 r0 = (com.tal.thinkacademy.networkprobe.cache.TraceEventCache$size$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.tal.thinkacademy.networkprobe.cache.TraceEventCache$size$1 r0 = new com.tal.thinkacademy.networkprobe.cache.TraceEventCache$size$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0048
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = mutex
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r0 = r6.lock(r3, r0)
            if (r0 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r0 = r6
        L_0x0048:
            java.util.HashMap<java.lang.String, com.tal.thinkacademy.networkprobe.cache.NetworkTraceCache> r6 = mCallMap     // Catch:{ all -> 0x0056 }
            int r6 = r6.size()     // Catch:{ all -> 0x0056 }
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)     // Catch:{ all -> 0x0056 }
            r0.unlock(r3)
            return r6
        L_0x0056:
            r6 = move-exception
            r0.unlock(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.thinkacademy.networkprobe.cache.TraceEventCache.size(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object clear(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.tal.thinkacademy.networkprobe.cache.TraceEventCache$clear$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.tal.thinkacademy.networkprobe.cache.TraceEventCache$clear$1 r0 = (com.tal.thinkacademy.networkprobe.cache.TraceEventCache$clear$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.tal.thinkacademy.networkprobe.cache.TraceEventCache$clear$1 r0 = new com.tal.thinkacademy.networkprobe.cache.TraceEventCache$clear$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0048
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = mutex
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r0 = r6.lock(r3, r0)
            if (r0 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r0 = r6
        L_0x0048:
            java.util.HashMap<java.lang.String, com.tal.thinkacademy.networkprobe.cache.NetworkTraceCache> r6 = mCallMap     // Catch:{ all -> 0x0055 }
            r6.clear()     // Catch:{ all -> 0x0055 }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0055 }
            r0.unlock(r3)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0055:
            r6 = move-exception
            r0.unlock(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.thinkacademy.networkprobe.cache.TraceEventCache.clear(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
