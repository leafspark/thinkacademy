package com.tal.app.thinkacademy.common.imconfig;

import com.tal.thinkacademy.networkprobe.NetProbeConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tal/thinkacademy/networkprobe/NetProbeConfig$Builder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwNetProbe.kt */
final class HwNetProbe$createEngine$1 extends Lambda implements Function1<NetProbeConfig.Builder, Unit> {
    final /* synthetic */ HashMap<String, Long> $stepsMap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HwNetProbe$createEngine$1(HashMap<String, Long> hashMap) {
        super(1);
        this.$stepsMap = hashMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NetProbeConfig.Builder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(NetProbeConfig.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$create");
        long j = this.$stepsMap.get("timeoutMillis");
        if (j == null) {
            j = 6000L;
        }
        builder.setConnectTimeout(j.longValue());
        long j2 = this.$stepsMap.get("errorTimeMillis");
        if (j2 == null) {
            j2 = 30000L;
        }
        builder.setErrorTimeMillis(j2.longValue());
        builder.setDebug(false);
        builder.setRepeatCount(5);
    }
}
