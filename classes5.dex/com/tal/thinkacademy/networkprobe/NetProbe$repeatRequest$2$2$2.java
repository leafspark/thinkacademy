package com.tal.thinkacademy.networkprobe;

import com.tal.thinkacademy.networkprobe.NetProbe;
import com.tal.thinkacademy.networkprobe.data.NetProbeData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetProbe.kt */
final class NetProbe$repeatRequest$2$2$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Exception $e;
    final /* synthetic */ String $host;
    final /* synthetic */ NetProbe this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetProbe$repeatRequest$2$2$2(NetProbe netProbe, String str, Exception exc) {
        super(0);
        this.this$0 = netProbe;
        this.$host = str;
        this.$e = exc;
    }

    public final void invoke() {
        Function1<NetProbeData, Unit> mRequestBlock$networkprobe_release;
        NetProbe.CallHolder access$getMHolder$p = this.this$0.mHolder;
        if (access$getMHolder$p != null && (mRequestBlock$networkprobe_release = access$getMHolder$p.getMRequestBlock$networkprobe_release()) != null) {
            NetProbeData netProbeData = r2;
            NetProbeData netProbeData2 = new NetProbeData(this.$host, (String) null, (String) null, (String[]) null, (Long) null, (Long) null, (Long) null, (Long) null, (Long) null, (Long) null, (Long) null, (Boolean) null, -1, this.$e.getMessage(), 4094, (DefaultConstructorMarker) null);
            mRequestBlock$networkprobe_release.invoke(netProbeData);
        }
    }
}
