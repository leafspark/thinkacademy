package com.tal.app.thinkacademy.lib.player.ijkplayer;

import tv.danmaku.ijk.media.psplayer.IMediaPlayer;
import tv.danmaku.ijk.media.psplayer.PSMediaPlayer;

public final /* synthetic */ class IJKPlayer$$ExternalSyntheticLambda0 implements PSMediaPlayer.PlayerStateListener {
    public final /* synthetic */ IJKPlayer f$0;

    public /* synthetic */ IJKPlayer$$ExternalSyntheticLambda0(IJKPlayer iJKPlayer) {
        this.f$0 = iJKPlayer;
    }

    public final void onPlayerState(IMediaPlayer iMediaPlayer, int i) {
        IJKPlayer.m95addListener$lambda6(this.f$0, iMediaPlayer, i);
    }
}
