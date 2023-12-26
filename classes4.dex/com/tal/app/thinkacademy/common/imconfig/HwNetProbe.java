package com.tal.app.thinkacademy.common.imconfig;

import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.thinkacademy.networkprobe.NetProbe;
import com.tal.thinkacademy.networkprobe.PlatformKt;
import com.tal.thinkacademy.networkprobe.data.NetProbeData;
import com.tal.thinkacademy.networkprobe.data.NetProbeResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0010\u001a\u00020\u00072\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J)\u0010\u0019\u001a\u00020\u000b2!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006J\u0011\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012¢\u0006\u0002\u0010\u001cJ\u0011\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012¢\u0006\u0002\u0010\u001cJ3\u0010\u001e\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00122\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00070\rj\b\u0012\u0004\u0012\u00020\u0007`\u000eH\u0002¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0002J+\u0010&\u001a\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00122\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R+\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\rj\b\u0012\u0004\u0012\u00020\u0007`\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\rj\b\u0012\u0004\u0012\u00020\u0007`\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/HwNetProbe;", "", "()V", "isNeedProbe", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mNetProbeFinishCall", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "key", "", "mOneHost", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mOverseaHost", "arrayToStr", "arr", "", "([Ljava/lang/String;)Ljava/lang/String;", "checkNetInfo", "urlsInfo", "Lcom/tal/app/thinkacademy/common/imconfig/HostUrlsInfo;", "createEngine", "Lcom/tal/thinkacademy/networkprobe/NetProbe;", "netProbeFinishCall", "block", "oneHostArray", "()[Ljava/lang/String;", "overseaHostArray", "setupHost", "result", "Lcom/tal/thinkacademy/networkprobe/data/NetProbeResult;", "hosts", "([Lcom/tal/thinkacademy/networkprobe/data/NetProbeResult;Ljava/util/ArrayList;)V", "traceRequest", "it", "Lcom/tal/thinkacademy/networkprobe/data/NetProbeData;", "traceResult", "originHost", "([Lcom/tal/thinkacademy/networkprobe/data/NetProbeResult;[Ljava/lang/String;)V", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwNetProbe.kt */
public final class HwNetProbe {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.NET_PROBE;
    /* access modifiers changed from: private */
    public static final Lazy<HwNetProbe> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, HwNetProbe$Companion$instance$2.INSTANCE);
    private final AtomicBoolean isNeedProbe;
    /* access modifiers changed from: private */
    public Function1<? super String, Unit> mNetProbeFinishCall;
    /* access modifiers changed from: private */
    public volatile ArrayList<String> mOneHost;
    /* access modifiers changed from: private */
    public volatile ArrayList<String> mOverseaHost;

    public /* synthetic */ HwNetProbe(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private HwNetProbe() {
        this.isNeedProbe = new AtomicBoolean(true);
        this.mOneHost = new ArrayList<>();
        this.mOverseaHost = new ArrayList<>();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/HwNetProbe$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/common/Tag;", "instance", "Lcom/tal/app/thinkacademy/common/imconfig/HwNetProbe;", "getInstance", "()Lcom/tal/app/thinkacademy/common/imconfig/HwNetProbe;", "instance$delegate", "Lkotlin/Lazy;", "get", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HwNetProbe.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final HwNetProbe getInstance() {
            return (HwNetProbe) HwNetProbe.instance$delegate.getValue();
        }

        public final HwNetProbe get() {
            return getInstance();
        }
    }

    private final synchronized NetProbe createEngine() {
        NetProbe netProbe;
        try {
            String cloudKeyValue = HwCloudControlHelper.Companion.get().getCloudKeyValue("hw_net_probe");
            Object fromJson = GsonUtils.fromJson(cloudKeyValue, new HwNetProbe$createEngine$stepsMap$1().getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(cloudKeyValue,\n…String, Long>>() {}.type)");
            XesLog.i(TAG, Intrinsics.stringPlus("网络探测，使用云控配置 ", cloudKeyValue));
            netProbe = PlatformKt.create(NetProbe.Companion, new HwNetProbe$createEngine$1((HashMap) fromJson));
        } catch (Exception e) {
            XesLog.e(TAG, Intrinsics.stringPlus("网络探测，使用默认配置 ", e));
            netProbe = PlatformKt.create(NetProbe.Companion, HwNetProbe$createEngine$2.INSTANCE);
        }
        return netProbe;
    }

    public final String[] oneHostArray() {
        Object[] array = this.mOneHost.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    public final String[] overseaHostArray() {
        Object[] array = this.mOverseaHost.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    public final void netProbeFinishCall(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.mNetProbeFinishCall = function1;
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.Object[]] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007b, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void checkNetInfo(com.tal.app.thinkacademy.common.imconfig.HostUrlsInfo r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 != 0) goto L_0x0005
            monitor-exit(r6)
            return
        L_0x0005:
            java.util.concurrent.atomic.AtomicBoolean r0 = r6.isNeedProbe     // Catch:{ all -> 0x007c }
            boolean r0 = r0.get()     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x007a
            java.util.concurrent.atomic.AtomicBoolean r0 = r6.isNeedProbe     // Catch:{ all -> 0x007c }
            r1 = 0
            r0.set(r1)     // Catch:{ all -> 0x007c }
            com.tal.app.thinkacademy.common.Tag r0 = TAG     // Catch:{ all -> 0x007c }
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0     // Catch:{ all -> 0x007c }
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x007c }
            java.lang.String r4 = "开启网络探测"
            r3[r1] = r4     // Catch:{ all -> 0x007c }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r3)     // Catch:{ all -> 0x007c }
            r0 = 2
            kotlin.Pair[] r0 = new kotlin.Pair[r0]     // Catch:{ all -> 0x007c }
            kotlin.Pair r3 = new kotlin.Pair     // Catch:{ all -> 0x007c }
            java.lang.String r4 = "one"
            java.lang.String[] r5 = r7.getOneHost()     // Catch:{ all -> 0x007c }
            if (r5 != 0) goto L_0x0034
            java.lang.String[] r5 = new java.lang.String[r1]     // Catch:{ all -> 0x007c }
            java.lang.Object[] r5 = (java.lang.Object[]) r5     // Catch:{ all -> 0x007c }
            java.lang.String[] r5 = (java.lang.String[]) r5     // Catch:{ all -> 0x007c }
        L_0x0034:
            java.util.List r5 = kotlin.collections.ArraysKt.toList(r5)     // Catch:{ all -> 0x007c }
            r3.<init>(r4, r5)     // Catch:{ all -> 0x007c }
            r0[r1] = r3     // Catch:{ all -> 0x007c }
            kotlin.Pair r3 = new kotlin.Pair     // Catch:{ all -> 0x007c }
            java.lang.String r4 = "oversea"
            java.lang.String[] r5 = r7.getOverseaApiHost()     // Catch:{ all -> 0x007c }
            if (r5 != 0) goto L_0x004e
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ all -> 0x007c }
            java.lang.Object[] r1 = (java.lang.Object[]) r1     // Catch:{ all -> 0x007c }
            r5 = r1
            java.lang.String[] r5 = (java.lang.String[]) r5     // Catch:{ all -> 0x007c }
        L_0x004e:
            java.util.List r1 = kotlin.collections.ArraysKt.toList(r5)     // Catch:{ all -> 0x007c }
            r3.<init>(r4, r1)     // Catch:{ all -> 0x007c }
            r0[r2] = r3     // Catch:{ all -> 0x007c }
            java.util.LinkedHashMap r0 = kotlin.collections.MapsKt.linkedMapOf(r0)     // Catch:{ all -> 0x007c }
            com.tal.thinkacademy.networkprobe.NetProbe r1 = r6.createEngine()     // Catch:{ all -> 0x007c }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x007c }
            java.lang.String r2 = "/api/health"
            kotlin.Pair r3 = new kotlin.Pair     // Catch:{ all -> 0x007c }
            java.lang.String r4 = "payload"
            java.lang.String r5 = "4096"
            r3.<init>(r4, r5)     // Catch:{ all -> 0x007c }
            java.util.Map r3 = kotlin.collections.MapsKt.mapOf(r3)     // Catch:{ all -> 0x007c }
            com.tal.app.thinkacademy.common.imconfig.HwNetProbe$checkNetInfo$1 r4 = new com.tal.app.thinkacademy.common.imconfig.HwNetProbe$checkNetInfo$1     // Catch:{ all -> 0x007c }
            r4.<init>(r6, r7)     // Catch:{ all -> 0x007c }
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4     // Catch:{ all -> 0x007c }
            r1.startProbe(r0, r2, r3, r4)     // Catch:{ all -> 0x007c }
        L_0x007a:
            monitor-exit(r6)
            return
        L_0x007c:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.imconfig.HwNetProbe.checkNetInfo(com.tal.app.thinkacademy.common.imconfig.HostUrlsInfo):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|3|(3:5|6|(1:8))|9|10|(1:12)(1:13)|14|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0037 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d A[Catch:{ Exception -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f A[Catch:{ Exception -> 0x006b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void traceResult(com.tal.thinkacademy.networkprobe.data.NetProbeResult[] r12, java.lang.String[] r13) {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            r2 = r12[r1]     // Catch:{ Exception -> 0x006b }
            int r3 = r12.length     // Catch:{ Exception -> 0x006b }
            int r3 = r3 - r0
            r12 = r12[r3]     // Catch:{ Exception -> 0x006b }
            float r3 = r12.average()     // Catch:{ Exception -> 0x006b }
            java.util.ArrayList r12 = r12.getDurationArray()     // Catch:{ Exception -> 0x006b }
            int r12 = r12.size()     // Catch:{ Exception -> 0x006b }
            float r12 = (float) r12     // Catch:{ Exception -> 0x006b }
            float r3 = r3 * r12
            long r3 = (long) r3     // Catch:{ Exception -> 0x006b }
            float r12 = r2.average()     // Catch:{ Exception -> 0x006b }
            java.util.ArrayList r5 = r2.getDurationArray()     // Catch:{ Exception -> 0x006b }
            int r5 = r5.size()     // Catch:{ Exception -> 0x006b }
            float r5 = (float) r5     // Catch:{ Exception -> 0x006b }
            float r12 = r12 * r5
            long r5 = (long) r12     // Catch:{ Exception -> 0x006b }
            long r7 = r3 - r5
            java.lang.String r12 = r2.url()     // Catch:{ Exception -> 0x006b }
            java.lang.String r2 = ""
            if (r13 != 0) goto L_0x0031
            goto L_0x0037
        L_0x0031:
            r13 = r13[r1]     // Catch:{ Exception -> 0x0037 }
            if (r13 != 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r2 = r13
        L_0x0037:
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r2)     // Catch:{ Exception -> 0x006b }
            if (r13 != 0) goto L_0x003f
            r13 = r0
            goto L_0x0040
        L_0x003f:
            r13 = r1
        L_0x0040:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x006b }
            r9.<init>()     // Catch:{ Exception -> 0x006b }
            java.lang.String r10 = "hw_net_sniffer_diff_value"
            r9.put(r10, r7)     // Catch:{ Exception -> 0x006b }
            java.lang.String r7 = "hw_net_sniffer_min_value"
            r9.put(r7, r5)     // Catch:{ Exception -> 0x006b }
            java.lang.String r5 = "hw_net_sniffer_max_value"
            r9.put(r5, r3)     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = "hw_net_sniffer_real_url"
            r9.put(r3, r12)     // Catch:{ Exception -> 0x006b }
            java.lang.String r12 = "hw_net_sniffer_default_url"
            r9.put(r12, r2)     // Catch:{ Exception -> 0x006b }
            java.lang.String r12 = "hw_net_sniffer_is_change"
            r9.put(r12, r13)     // Catch:{ Exception -> 0x006b }
            com.tal.app.thinkacademy.common.sensors.HwTrackUtil r12 = com.tal.app.thinkacademy.common.sensors.HwTrackUtil.INSTANCE     // Catch:{ Exception -> 0x006b }
            java.lang.String r13 = "hw_net_work_sniffer_info"
            r12.track(r13, r9)     // Catch:{ Exception -> 0x006b }
            goto L_0x0081
        L_0x006b:
            r12 = move-exception
            com.tal.app.thinkacademy.common.Tag r13 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r13 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r13
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r12 = r12.getMessage()
            java.lang.String r2 = "网络探测结果埋点失败，"
            java.lang.String r12 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r12)
            r0[r1] = r12
            com.tal.app.thinkacademy.lib.logger.XesLog.e(r13, r0)
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.imconfig.HwNetProbe.traceResult(com.tal.thinkacademy.networkprobe.data.NetProbeResult[], java.lang.String[]):void");
    }

    /* access modifiers changed from: private */
    public final void traceRequest(NetProbeData netProbeData) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("hw_net_success", Intrinsics.areEqual(netProbeData.getSuccess(), true) ? "1" : EnterRoomMuteData.STATUS_UN_MUTE);
            jSONObject.put("error_msg", netProbeData.getErrorMsg());
            jSONObject.put("error_type", String.valueOf(netProbeData.getCode()));
            jSONObject.put("hw_net_sum_value", netProbeData.getDuration());
            jSONObject.put("hw_net_response_value", netProbeData.getResponseDuration());
            jSONObject.put("hw_net_service_value", netProbeData.getServiceDuration());
            jSONObject.put("hw_net_request_value", netProbeData.getRequestDuration());
            jSONObject.put("hw_net_tls_value", netProbeData.getTlsDuration());
            jSONObject.put("hw_net_tcp_value", netProbeData.getTcpDuration());
            jSONObject.put("hw_net_dns_value", netProbeData.getDnsDuration());
            jSONObject.put("hw_metrics_fetch_type", netProbeData.getMethod());
            jSONObject.put("hw_net_protocol", netProbeData.getProtocol());
            jSONObject.put("hw_net_request_url", netProbeData.getUrl());
            jSONObject.put("hw_dns_servers", arrayToStr(netProbeData.getDnsServer()));
            HwTrackUtil.INSTANCE.track("hw_net_work_request_metrics", jSONObject);
        } catch (Exception e) {
            XesLog.e(TAG, Intrinsics.stringPlus("网络探测请求埋点失败，", e.getMessage()));
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void setupHost(NetProbeResult[] netProbeResultArr, ArrayList<String> arrayList) {
        if (!(!(netProbeResultArr.length == 0))) {
            netProbeResultArr = null;
        }
        if (netProbeResultArr != null) {
            arrayList.clear();
            Collection arrayList2 = new ArrayList(netProbeResultArr.length);
            for (NetProbeResult url : netProbeResultArr) {
                arrayList2.add(Boolean.valueOf(arrayList.add(url.url())));
            }
            List list = (List) arrayList2;
        }
    }

    private final String arrayToStr(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        if (strArr != null) {
            for (String append : strArr) {
                sb.append(append);
                sb.append(",");
            }
        }
        if (sb.length() > 0) {
            z = true;
        }
        if (z) {
            Intrinsics.checkNotNullExpressionValue(sb.deleteCharAt(sb.length() - 1), "this.deleteCharAt(index)");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "result.toString()");
        return sb2;
    }
}
