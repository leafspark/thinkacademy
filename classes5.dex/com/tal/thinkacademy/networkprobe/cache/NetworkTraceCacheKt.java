package com.tal.thinkacademy.networkprobe.cache;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a0\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0000¨\u0006\u0007"}, d2 = {"getEventCostTime", "", "eventsTimeMap", "", "", "startName", "endName", "networkprobe_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetworkTraceCache.kt */
public final class NetworkTraceCacheKt {
    public static final long getEventCostTime(Map<String, Long> map, String str, String str2) {
        Intrinsics.checkNotNullParameter(map, "eventsTimeMap");
        if (!map.containsKey(str) || !map.containsKey(str2)) {
            return 0;
        }
        Long l = map.get(str2);
        Long l2 = map.get(str);
        Intrinsics.checkNotNull(l);
        long longValue = l.longValue();
        Intrinsics.checkNotNull(l2);
        return longValue - l2.longValue();
    }
}
