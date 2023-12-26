package com.tal.app.thinkacademy.lib.player.rtcplayer;

import com.tal.app.thinkacademy.lib.player.rtcplayer.IRTCEngineProvider;

public class RTCEngineProvider implements IRTCEngineProvider {
    private RtcPlayer mRtcPlayer;

    public int getLinkType() {
        return 1;
    }

    public void release() {
    }

    public RTCEngineProvider(RtcPlayer rtcPlayer) {
        this.mRtcPlayer = rtcPlayer;
    }

    public void provide(String str, IRTCEngineProvider.RTCEngineCallback rTCEngineCallback) {
        RtcPlayer rtcPlayer = this.mRtcPlayer;
        if (rtcPlayer != null) {
            rTCEngineCallback.onGetRTCEngine(rtcPlayer.getRTCEngine(), this.mRtcPlayer.getRTCEngineChannel());
        }
    }

    public void addEtcEngineEventListener(String str, RtcPlayerEngineEventListener rtcPlayerEngineEventListener) {
        RtcPlayer rtcPlayer = this.mRtcPlayer;
        if (rtcPlayer != null) {
            rtcPlayer.addEtcEngineEventListener(str, rtcPlayerEngineEventListener);
        }
    }

    public void removeRtcEngineEventListener(String str) {
        RtcPlayer rtcPlayer = this.mRtcPlayer;
        if (rtcPlayer != null) {
            rtcPlayer.removeRtcEngineEventListener(str);
        }
    }

    public int getOnceLastMileQuality() {
        RtcPlayer rtcPlayer = this.mRtcPlayer;
        if (rtcPlayer != null) {
            return rtcPlayer.getOnceLastMileQuality();
        }
        return 1;
    }
}
