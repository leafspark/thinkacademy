package com.tal.app.thinkacademy.lib.player.base;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/base/IMediaPlayer;", "", "destroyPlayer", "", "isInit", "", "isPause", "isPlaying", "pausePlay", "setVolume", "volume", "", "startPlay", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IMediaPlayer.kt */
public interface IMediaPlayer {
    void destroyPlayer();

    boolean isInit();

    boolean isPause();

    boolean isPlaying();

    void pausePlay();

    void setVolume(float f);

    void startPlay();
}
