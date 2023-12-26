package com.tal.app.thinkacademy.lib.player.ijkplayer;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/tal/app/thinkacademy/lib/player/ijkplayer/PlayTimeEventReport$mRunnable$1", "Ljava/lang/Runnable;", "run", "", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayTimeEventReport.kt */
public final class PlayTimeEventReport$mRunnable$1 implements Runnable {
    final /* synthetic */ PlayTimeEventReport this$0;

    PlayTimeEventReport$mRunnable$1(PlayTimeEventReport playTimeEventReport) {
        this.this$0 = playTimeEventReport;
    }

    public void run() {
        this.this$0.reportLoadingTime();
        this.this$0.sendLoopEvent();
    }
}
