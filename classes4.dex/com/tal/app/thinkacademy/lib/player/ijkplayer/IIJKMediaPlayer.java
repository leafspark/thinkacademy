package com.tal.app.thinkacademy.lib.player.ijkplayer;

import com.tal.app.thinkacademy.lib.player.base.IMediaPlayer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH&J\b\u0010\u0011\u001a\u00020\u0007H&¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IIJKMediaPlayer;", "Lcom/tal/app/thinkacademy/lib/player/base/IMediaPlayer;", "getCurrentPosition", "", "()Ljava/lang/Long;", "getDuration", "seekTo", "", "position", "isManual", "", "setSpeed", "speed", "", "setVolume", "left", "right", "stopPlay", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IIJKMediaPlayer.kt */
public interface IIJKMediaPlayer extends IMediaPlayer {
    Long getCurrentPosition();

    Long getDuration();

    void seekTo(long j, boolean z);

    void setSpeed(float f);

    void setVolume(float f, float f2);

    void stopPlay();
}
