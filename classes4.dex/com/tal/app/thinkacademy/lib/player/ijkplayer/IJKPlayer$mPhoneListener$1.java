package com.tal.app.thinkacademy.lib.player.ijkplayer;

import android.telephony.PhoneStateListener;
import com.tal.app.thinkacademy.lib.player.ijkplayer.config.MediaPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"com/tal/app/thinkacademy/lib/player/ijkplayer/IJKPlayer$mPhoneListener$1", "Landroid/telephony/PhoneStateListener;", "start", "", "getStart", "()Z", "setStart", "(Z)V", "onCallStateChanged", "", "state", "", "incomingNumber", "", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IJKPlayer.kt */
public final class IJKPlayer$mPhoneListener$1 extends PhoneStateListener {
    private boolean start;
    final /* synthetic */ IJKPlayer this$0;

    IJKPlayer$mPhoneListener$1(IJKPlayer iJKPlayer) {
        this.this$0 = iJKPlayer;
    }

    public final boolean getStart() {
        return this.start;
    }

    public final void setStart(boolean z) {
        this.start = z;
    }

    public void onCallStateChanged(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "incomingNumber");
        if (i == 0) {
            if (this.start) {
                this.this$0.getVideoPhoneState().set(false);
            }
            this.start = false;
        } else if (i == 1 || i == 2) {
            if (!this.this$0.getVideoPhoneState().get() && !this.start) {
                this.this$0.getVideoPhoneState().set(true);
            } else if (this.this$0.isPlaying()) {
                this.this$0.pausePlay();
                this.this$0.setState(MediaPlayer.Companion.getSTATE_RINGING());
            }
            this.start = true;
        }
    }
}
