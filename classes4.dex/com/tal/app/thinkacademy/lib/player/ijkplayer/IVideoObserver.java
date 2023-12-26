package com.tal.app.thinkacademy.lib.player.ijkplayer;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IVideoObserver;", "", "onAudio", "", "samples", "", "onVideoFrame", "frame", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IVideoObserver.kt */
public interface IVideoObserver {
    void onAudio(byte[] bArr);

    void onVideoFrame(byte[] bArr);
}
