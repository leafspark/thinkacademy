package com.tal.app.thinkacademy.lib.player.ijkplayer;

import android.os.Handler;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import java.util.TimerTask;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Timer.kt */
public final class IJKPlayer$startListenPlaying$$inlined$timerTask$1 extends TimerTask {
    final /* synthetic */ IJKPlayer this$0;

    public IJKPlayer$startListenPlaying$$inlined$timerTask$1(IJKPlayer iJKPlayer) {
        this.this$0 = iJKPlayer;
    }

    public void run() {
        TimerTask timerTask = this;
        Handler mainHandler = ThreadUtils.getMainHandler();
        Runnable iJKPlayer$startListenPlaying$1$1 = new IJKPlayer$startListenPlaying$1$1(this.this$0);
        if (!(mainHandler instanceof Handler)) {
            mainHandler.post(iJKPlayer$startListenPlaying$1$1);
        } else {
            AsynchronousInstrumentation.handlerPost(mainHandler, iJKPlayer$startListenPlaying$1$1);
        }
    }
}
