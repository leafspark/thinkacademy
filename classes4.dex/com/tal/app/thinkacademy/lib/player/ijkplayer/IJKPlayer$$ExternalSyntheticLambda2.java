package com.tal.app.thinkacademy.lib.player.ijkplayer;

import tv.danmaku.ijk.media.psplayer.IMediaPlayer;
import tv.danmaku.ijk.media.psplayer.PSMediaPlayer;

public final /* synthetic */ class IJKPlayer$$ExternalSyntheticLambda2 implements PSMediaPlayer.VideoInfoListener {
    public final /* synthetic */ IJKPlayer f$0;

    public /* synthetic */ IJKPlayer$$ExternalSyntheticLambda2(IJKPlayer iJKPlayer) {
        this.f$0 = iJKPlayer;
    }

    public final void onVideoInfo(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        IJKPlayer.m96addListener$lambda7(this.f$0, iMediaPlayer, i, i2, i3, i4, i5, i6, i7);
    }
}
