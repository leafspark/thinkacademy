package com.tal.app.thinkacademy.lib.player.rtcplayer;

public final /* synthetic */ class RtcPlayer$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ RtcPlayer f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ RtcPlayer$$ExternalSyntheticLambda2(RtcPlayer rtcPlayer, long j, int i, int i2) {
        this.f$0 = rtcPlayer;
        this.f$1 = j;
        this.f$2 = i;
        this.f$3 = i2;
    }

    public final void run() {
        RtcPlayer.m99disPatchNetworkQuality$lambda16(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
