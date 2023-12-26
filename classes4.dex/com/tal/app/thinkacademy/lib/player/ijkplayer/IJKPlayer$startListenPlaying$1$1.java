package com.tal.app.thinkacademy.lib.player.ijkplayer;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: IJKPlayer.kt */
final class IJKPlayer$startListenPlaying$1$1 implements Runnable {
    final /* synthetic */ IJKPlayer this$0;

    IJKPlayer$startListenPlaying$1$1(IJKPlayer iJKPlayer) {
        this.this$0 = iJKPlayer;
    }

    public final void run() {
        IJKPlayListener mPlayListener = this.this$0.getMPlayListener();
        if (mPlayListener != null) {
            mPlayListener.onPlaying(this.this$0.getCurrentPosition().longValue(), this.this$0.getDuration().longValue());
        }
    }
}
