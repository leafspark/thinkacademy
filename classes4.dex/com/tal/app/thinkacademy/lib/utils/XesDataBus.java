package com.tal.app.thinkacademy.lib.utils;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0006\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\t\u001a\u00020\u0005H\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/XesDataBus;", "", "()V", "eventMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tal/app/thinkacademy/lib/utils/StickyLiveData;", "remove", "", "eventName", "with", "T", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: XesDataBus.kt */
public final class XesDataBus {
    public static final XesDataBus INSTANCE = new XesDataBus();
    private static final ConcurrentHashMap<String, StickyLiveData<?>> eventMap = new ConcurrentHashMap<>();

    private XesDataBus() {
    }

    @JvmStatic
    public static final <T> StickyLiveData<T> with(String str) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        ConcurrentHashMap<String, StickyLiveData<?>> concurrentHashMap = eventMap;
        StickyLiveData<T> stickyLiveData = concurrentHashMap.get(str);
        if (stickyLiveData != null) {
            return stickyLiveData;
        }
        StickyLiveData<T> stickyLiveData2 = new StickyLiveData<>();
        concurrentHashMap.put(str, stickyLiveData2);
        return stickyLiveData2;
    }

    @JvmStatic
    public static final void remove(String str) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        eventMap.remove(str);
    }
}
