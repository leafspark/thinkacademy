package com.tal.app.thinkacademy.live.abilitypack.rtc;

import com.eaydu.omni.RTCChannel;
import com.eaydu.omni.RTCEngine;
import com.tal.app.thinkacademy.lib.player.rtcplayer.IRTCEngineProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"com/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel$mRTCEngineCallback$1", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/IRTCEngineProvider$RTCEngineCallback;", "onGetRTCEngine", "", "rtcEngine", "Lcom/eaydu/omni/RTCEngine;", "rtcChannel", "Lcom/eaydu/omni/RTCChannel;", "onGetRTCEngineFail", "code", "", "subCode", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcViewModel.kt */
public final class RtcViewModel$mRTCEngineCallback$1 implements IRTCEngineProvider.RTCEngineCallback {
    final /* synthetic */ RtcViewModel this$0;

    public void onGetRTCEngineFail(int i, int i2) {
    }

    RtcViewModel$mRTCEngineCallback$1(RtcViewModel rtcViewModel) {
        this.this$0 = rtcViewModel;
    }

    public void onGetRTCEngine(RTCEngine rTCEngine, RTCChannel rTCChannel) {
        this.this$0.mRtcEngine = rTCEngine;
    }
}
