package com.kwai.koom.base;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0004"}, d2 = {"runIfDebug", "", "block", "Lkotlin/Function0;", "koom-monitor-base_SharedCppRelease"}, k = 2, mv = {1, 4, 1})
/* compiled from: MonitorLog.kt */
public final class MonitorLogKt {
    public static final int runIfDebug(Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        if (MonitorBuildConfig.getDEBUG()) {
            return ((Number) function0.invoke()).intValue();
        }
        return -1;
    }
}
