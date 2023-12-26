package com.tal.app.thinkacademy.lib.network.trace;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005H\u0007J$\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007H\u0007R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/lib/network/trace/NetTimeManager;", "", "()V", "mTraceMap", "Ljava/util/HashMap;", "", "Lcom/tal/app/thinkacademy/lib/network/trace/NetworkTraceBean;", "Lkotlin/collections/HashMap;", "getTraceBean", "id", "getTraceMap", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetTimeManager.kt */
public final class NetTimeManager {
    public static final NetTimeManager INSTANCE = new NetTimeManager();
    private static final HashMap<String, NetworkTraceBean> mTraceMap = new HashMap<>();

    private NetTimeManager() {
    }

    @JvmStatic
    public static final NetworkTraceBean getTraceBean(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        HashMap<String, NetworkTraceBean> hashMap = mTraceMap;
        if (hashMap.containsKey(str)) {
            return hashMap.get(str);
        }
        NetworkTraceBean networkTraceBean = new NetworkTraceBean();
        networkTraceBean.setId(str);
        networkTraceBean.setTime(System.currentTimeMillis());
        hashMap.put(str, networkTraceBean);
        return networkTraceBean;
    }

    @JvmStatic
    public static final HashMap<String, NetworkTraceBean> getTraceMap() {
        return mTraceMap;
    }
}
