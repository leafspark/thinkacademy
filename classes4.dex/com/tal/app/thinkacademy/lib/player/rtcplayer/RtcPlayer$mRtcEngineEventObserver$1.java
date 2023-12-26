package com.tal.app.thinkacademy.lib.player.rtcplayer;

import com.eaydu.omni.RTCEngine;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayer$mRtcEngineEventObserver$1", "Lcom/eaydu/omni/RTCEngine$RtcEngineEventObserver;", "onNetworkQuality", "", "uid", "", "txQuality", "", "rxQuality", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcPlayer.kt */
public final class RtcPlayer$mRtcEngineEventObserver$1 extends RTCEngine.RtcEngineEventObserver {
    final /* synthetic */ RtcPlayer this$0;

    RtcPlayer$mRtcEngineEventObserver$1(RtcPlayer rtcPlayer) {
        this.this$0 = rtcPlayer;
    }

    public void onNetworkQuality(long j, int i, int i2) {
        RtcPlayer$mRtcEngineEventObserver$1.super.onNetworkQuality(j, i, i2);
        this.this$0.disPatchNetworkQuality(j, i, i2);
    }
}
