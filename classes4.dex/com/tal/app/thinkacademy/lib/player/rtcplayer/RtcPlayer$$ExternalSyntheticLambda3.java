package com.tal.app.thinkacademy.lib.player.rtcplayer;

public final /* synthetic */ class RtcPlayer$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ RtcPlayerEngineEventListener f$0;
    public final /* synthetic */ RtcPlayer f$1;

    public /* synthetic */ RtcPlayer$$ExternalSyntheticLambda3(RtcPlayerEngineEventListener rtcPlayerEngineEventListener, RtcPlayer rtcPlayer) {
        this.f$0 = rtcPlayerEngineEventListener;
        this.f$1 = rtcPlayer;
    }

    public final void run() {
        RtcPlayer.m98addEtcEngineEventListener$lambda15(this.f$0, this.f$1);
    }
}
