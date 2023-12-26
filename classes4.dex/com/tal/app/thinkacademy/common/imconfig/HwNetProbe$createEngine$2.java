package com.tal.app.thinkacademy.common.imconfig;

import com.tal.thinkacademy.networkprobe.NetProbeConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tal/thinkacademy/networkprobe/NetProbeConfig$Builder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwNetProbe.kt */
final class HwNetProbe$createEngine$2 extends Lambda implements Function1<NetProbeConfig.Builder, Unit> {
    public static final HwNetProbe$createEngine$2 INSTANCE = new HwNetProbe$createEngine$2();

    HwNetProbe$createEngine$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NetProbeConfig.Builder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(NetProbeConfig.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$create");
        builder.setConnectTimeout(6000);
        builder.setErrorTimeMillis(30000);
        builder.setDebug(false);
        builder.setRepeatCount(5);
    }
}
