package com.tal.app.thinkacademy.lib.player.ijkplayer;

import tv.danmaku.ijk.media.psplayer.IMediaPlayer;
import tv.danmaku.ijk.media.psplayer.PSMediaPlayer;

public final /* synthetic */ class IJKPlayer$$ExternalSyntheticLambda1 implements PSMediaPlayer.SeverListListener {
    public final /* synthetic */ IJKPlayer f$0;

    public /* synthetic */ IJKPlayer$$ExternalSyntheticLambda1(IJKPlayer iJKPlayer) {
        this.f$0 = iJKPlayer;
    }

    public final void onServerList(IMediaPlayer iMediaPlayer, String str) {
        IJKPlayer.m94addListener$lambda5(this.f$0, iMediaPlayer, str);
    }
}
