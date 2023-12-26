package com.tal.app.thinkacademy.live.abilitypack.rtc;

import com.eaydu.omni.RTCEngine;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.live.abilitypack.rtc.listenbody.RtcPlayerListenerBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel$mRtcEngineEventObserver$1", "Lcom/eaydu/omni/RTCEngine$RtcEngineEventObserver;", "onNetworkQuality", "", "uid", "", "txQuality", "", "rxQuality", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcViewModel.kt */
public final class RtcViewModel$mRtcEngineEventObserver$1 extends RTCEngine.RtcEngineEventObserver {
    final /* synthetic */ RtcViewModel this$0;

    RtcViewModel$mRtcEngineEventObserver$1(RtcViewModel rtcViewModel) {
        this.this$0 = rtcViewModel;
    }

    public void onNetworkQuality(long j, int i, int i2) {
        RtcViewModel$mRtcEngineEventObserver$1.super.onNetworkQuality(j, i, i2);
        ThreadUtils.runOnUiThread(new RtcViewModel$mRtcEngineEventObserver$1$$ExternalSyntheticLambda0(j, this.this$0, i2, i));
    }

    /* access modifiers changed from: private */
    /* renamed from: onNetworkQuality$lambda-0  reason: not valid java name */
    public static final void m154onNetworkQuality$lambda0(long j, RtcViewModel rtcViewModel, int i, int i2) {
        Intrinsics.checkNotNullParameter(rtcViewModel, "this$0");
        if (j == 0) {
            rtcViewModel.setMNetworkQualityPicId(rtcViewModel.syncNetworkParse(i));
            rtcViewModel.getMRtcPlayerListener().setStickyData(new RtcPlayerListenerBody.NetworkQuality(j, i2, i));
        }
    }
}
