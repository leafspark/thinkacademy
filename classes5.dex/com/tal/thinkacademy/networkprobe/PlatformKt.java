package com.tal.thinkacademy.networkprobe;

import com.tal.thinkacademy.networkprobe.NetProbe;
import com.tal.thinkacademy.networkprobe.NetProbeConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"create", "Lcom/tal/thinkacademy/networkprobe/NetProbe;", "Lcom/tal/thinkacademy/networkprobe/NetProbe$Companion;", "config", "Lkotlin/Function1;", "Lcom/tal/thinkacademy/networkprobe/NetProbeConfig$Builder;", "", "Lkotlin/ExtensionFunctionType;", "networkprobe_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Platform.kt */
public final class PlatformKt {
    public static final NetProbe create(NetProbe.Companion companion, Function1<? super NetProbeConfig.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(function1, "config");
        return new NetProbe(function1);
    }
}
