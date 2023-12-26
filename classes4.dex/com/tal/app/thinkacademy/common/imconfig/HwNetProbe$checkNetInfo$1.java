package com.tal.app.thinkacademy.common.imconfig;

import com.tal.app.thinkacademy.common.flutter.HwFlutterUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.thinkacademy.networkprobe.NetProbe;
import com.tal.thinkacademy.networkprobe.data.NetProbeData;
import com.tal.thinkacademy.networkprobe.data.NetProbeResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tal/thinkacademy/networkprobe/NetProbe$CallHolder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwNetProbe.kt */
final class HwNetProbe$checkNetInfo$1 extends Lambda implements Function1<NetProbe.CallHolder, Unit> {
    final /* synthetic */ HostUrlsInfo $urlsInfo;
    final /* synthetic */ HwNetProbe this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HwNetProbe$checkNetInfo$1(HwNetProbe hwNetProbe, HostUrlsInfo hostUrlsInfo) {
        super(1);
        this.this$0 = hwNetProbe;
        this.$urlsInfo = hostUrlsInfo;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NetProbe.CallHolder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(NetProbe.CallHolder callHolder) {
        Intrinsics.checkNotNullParameter(callHolder, "$this$startProbe");
        final HwNetProbe hwNetProbe = this.this$0;
        callHolder.onRequestCall(new Function1<NetProbeData, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((NetProbeData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(NetProbeData netProbeData) {
                Intrinsics.checkNotNullParameter(netProbeData, "it");
                XesLog.a(HwNetProbe.TAG, Intrinsics.stringPlus("接口探测结果：", netProbeData));
                hwNetProbe.traceRequest(netProbeData);
            }
        });
        final HostUrlsInfo hostUrlsInfo = this.$urlsInfo;
        final HwNetProbe hwNetProbe2 = this.this$0;
        callHolder.onResult(new Function2<String, NetProbeResult[], Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, (NetProbeResult[]) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String str, NetProbeResult[] netProbeResultArr) {
                Intrinsics.checkNotNullParameter(str, "key");
                Intrinsics.checkNotNullParameter(netProbeResultArr, "result");
                if (netProbeResultArr.length == 0) {
                    XesLog.a(HwNetProbe.TAG, Intrinsics.stringPlus("探测结果为空：", str));
                    return;
                }
                for (NetProbeResult netProbeResult : netProbeResultArr) {
                    XesLog.a(HwNetProbe.TAG, "探测结果：" + netProbeResult.url() + ", 平均请求时间：" + netProbeResult.average());
                }
                String[] strArr = null;
                if (Intrinsics.areEqual(str, "one")) {
                    strArr = hostUrlsInfo.getOneHost();
                    HwNetProbe hwNetProbe = hwNetProbe2;
                    hwNetProbe.setupHost(netProbeResultArr, hwNetProbe.mOneHost);
                } else if (Intrinsics.areEqual(str, "oversea")) {
                    strArr = hostUrlsInfo.getOverseaApiHost();
                    HwNetProbe hwNetProbe2 = hwNetProbe2;
                    hwNetProbe2.setupHost(netProbeResultArr, hwNetProbe2.mOverseaHost);
                }
                Function1 access$getMNetProbeFinishCall$p = hwNetProbe2.mNetProbeFinishCall;
                if (access$getMNetProbeFinishCall$p != null) {
                    access$getMNetProbeFinishCall$p.invoke(str);
                }
                hwNetProbe2.traceResult(netProbeResultArr, strArr);
                HwFlutterUtil.INSTANCE.sendEventToFlutterNetProbe();
            }
        });
    }
}
