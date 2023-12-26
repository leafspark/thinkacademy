package com.tal.thinkacademy.networkprobe;

import com.tal.thinkacademy.networkprobe.NetProbe;
import com.tal.thinkacademy.networkprobe.data.NetProbeResult;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetProbe.kt */
final class NetProbe$startProbe$1$1$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $key;
    final /* synthetic */ ArrayList<NetProbeResult> $resultList;
    final /* synthetic */ NetProbe this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetProbe$startProbe$1$1$5(NetProbe netProbe, String str, ArrayList<NetProbeResult> arrayList) {
        super(0);
        this.this$0 = netProbe;
        this.$key = str;
        this.$resultList = arrayList;
    }

    public final void invoke() {
        Function2<String, NetProbeResult[], Unit> mResultBlock$networkprobe_release;
        NetProbe.CallHolder access$getMHolder$p = this.this$0.mHolder;
        if (access$getMHolder$p != null && (mResultBlock$networkprobe_release = access$getMHolder$p.getMResultBlock$networkprobe_release()) != null) {
            String str = this.$key;
            Object[] array = this.$resultList.toArray(new NetProbeResult[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            mResultBlock$networkprobe_release.invoke(str, array);
        }
    }
}
