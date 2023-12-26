package com.kwai.koom.javaoom.monitor.tracker.model;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "line", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SystemInfo.kt */
final class SystemInfo$refresh$2 extends Lambda implements Function1<String, Unit> {
    public static final SystemInfo$refresh$2 INSTANCE = new SystemInfo$refresh$2();

    SystemInfo$refresh$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "line");
        if (StringsKt.startsWith$default(str, "MemTotal", false, 2, (Object) null)) {
            SystemInfo.INSTANCE.getMemInfo().setTotalInKb(SystemInfo.INSTANCE.matchValue(SystemInfo.MEM_TOTAL_REGEX, str));
        } else if (StringsKt.startsWith$default(str, "MemFree", false, 2, (Object) null)) {
            SystemInfo.INSTANCE.getMemInfo().setFreeInKb(SystemInfo.INSTANCE.matchValue(SystemInfo.MEM_FREE_REGEX, str));
        } else if (StringsKt.startsWith$default(str, "MemAvailable", false, 2, (Object) null)) {
            SystemInfo.INSTANCE.getMemInfo().setAvailableInKb(SystemInfo.INSTANCE.matchValue(SystemInfo.MEM_AVA_REGEX, str));
        } else if (StringsKt.startsWith$default(str, "CmaTotal", false, 2, (Object) null)) {
            SystemInfo.INSTANCE.getMemInfo().setCmaTotal(SystemInfo.INSTANCE.matchValue(SystemInfo.MEM_CMA_REGEX, str));
        } else if (StringsKt.startsWith$default(str, "ION_heap", false, 2, (Object) null)) {
            SystemInfo.INSTANCE.getMemInfo().setIONHeap(SystemInfo.INSTANCE.matchValue(SystemInfo.MEM_ION_REGEX, str));
        }
    }
}
