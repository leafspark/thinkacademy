package com.tal.app.thinkacademy.lib.player.ijkplayer;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H&J*\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u0010\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001cH&¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IJKPlayListener;", "", "onBufferComplete", "", "onBufferStart", "onCloseComplete", "onCloseStart", "onHWRenderFailed", "onOpenFailed", "errorinfo", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/MediaErrorInfo;", "onOpenStart", "onOpenSuccess", "onPaused", "onPlayError", "onPlaybackComplete", "onPlaying", "currentPosition", "", "duration", "onVideoSizeChanged", "width", "", "height", "serverList", "cur", "total", "addrList", "", "", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IJKPlayListener.kt */
public interface IJKPlayListener {
    void onBufferComplete();

    void onBufferStart();

    void onCloseComplete();

    void onCloseStart();

    void onHWRenderFailed();

    void onOpenFailed(MediaErrorInfo mediaErrorInfo);

    void onOpenStart();

    void onOpenSuccess();

    void onPaused();

    void onPlayError();

    void onPlaybackComplete();

    void onPlaying(long j, long j2);

    void onVideoSizeChanged(int i, int i2);

    void serverList(int i, int i2, List<String> list);
}
