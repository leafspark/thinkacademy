package com.tal.app.thinkacademy.lib.player.ijkplayer;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.Tag;
import com.tal.app.thinkacademy.lib.player.track.IjkTrackUtil;
import kotlin.Metadata;
import tv.danmaku.ijk.media.psplayer.PSMediaPlayer;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/lib/player/ijkplayer/IJKPlayer$Companion$login$1$1", "Ltv/danmaku/ijk/media/psplayer/PSMediaPlayer$LoginCallback;", "onError", "", "errCode", "", "errInfo", "", "onSuccess", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IJKPlayer.kt */
public final class IJKPlayer$Companion$login$1$1 implements PSMediaPlayer.LoginCallback {
    IJKPlayer$Companion$login$1$1() {
    }

    public void onError(int i, String str) {
        XesLog.e(Tag.VIDEO_MONITOR, "磐石播放器登录失败,错误码=" + i + ",错误描述=" + str);
        IjkTrackUtil ijkTrackUtil = IjkTrackUtil.INSTANCE;
        ijkTrackUtil.trackLoginFailEvent("磐石播放器登录失败,错误码=" + i + ",错误描述=" + str);
    }

    public void onSuccess() {
        XesLog.s(Tag.VIDEO_MONITOR, "磐石播放器登录成功");
        IjkTrackUtil.INSTANCE.trackLoginSuccessEvent();
    }
}
