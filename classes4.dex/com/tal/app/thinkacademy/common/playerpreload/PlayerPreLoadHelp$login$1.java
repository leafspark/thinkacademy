package com.tal.app.thinkacademy.common.playerpreload;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.ijk.media.psplayer.PSMediaPlayer;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/tal/app/thinkacademy/common/playerpreload/PlayerPreLoadHelp$login$1", "Ltv/danmaku/ijk/media/psplayer/PSMediaPlayer$PreloadListener;", "preloadFail", "", "url", "", "code", "", "preloadProgress", "progress", "preloadSuccess", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerPreLoadHelp.kt */
public final class PlayerPreLoadHelp$login$1 implements PSMediaPlayer.PreloadListener {
    PlayerPreLoadHelp$login$1() {
    }

    public void preloadSuccess(String str) {
        XesLog.i(PlayerPreLoadHelp.TAG, Intrinsics.stringPlus("preloadSuccess,url=", str));
    }

    public void preloadFail(String str, int i) {
        XesLog.i(PlayerPreLoadHelp.TAG, "preloadFail,url=" + str + ",code=" + i);
    }

    public void preloadProgress(String str, int i) {
        XesLog.i(PlayerPreLoadHelp.TAG, "preloadProgress,url=" + str + ",progress=" + i);
    }
}
