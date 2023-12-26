package com.kwai.koom.javaoom.monitor.tracker.model;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "line", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SystemInfo.kt */
final class SystemInfo$refresh$1 extends Lambda implements Function1<String, Unit> {
    public static final SystemInfo$refresh$1 INSTANCE = new SystemInfo$refresh$1();

    SystemInfo$refresh$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "line");
        if (SystemInfo.INSTANCE.getProcStatus().getVssInKb() != 0 && SystemInfo.INSTANCE.getProcStatus().getRssInKb() != 0 && SystemInfo.INSTANCE.getProcStatus().getThread() != 0) {
            return;
        }
        if (StringsKt.startsWith$default(str, "VmSize", false, 2, (Object) null)) {
            SystemInfo.INSTANCE.getProcStatus().setVssInKb(SystemInfo.INSTANCE.matchValue(SystemInfo.VSS_REGEX, str));
        } else if (StringsKt.startsWith$default(str, "VmRSS", false, 2, (Object) null)) {
            SystemInfo.INSTANCE.getProcStatus().setRssInKb(SystemInfo.INSTANCE.matchValue(SystemInfo.RSS_REGEX, str));
        } else if (StringsKt.startsWith$default(str, "Threads", false, 2, (Object) null)) {
            SystemInfo.INSTANCE.getProcStatus().setThread(SystemInfo.INSTANCE.matchValue(SystemInfo.THREADS_REGEX, str));
        }
    }
}
