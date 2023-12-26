package com.tal.app.thinkacademy.business.study.study.vodplayer;

import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwVodVideoPlayerView.kt */
final class HwVodVideoPlayerView$showSwitchLineDialog$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ HwVodVideoPlayerView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HwVodVideoPlayerView$showSwitchLineDialog$1(HwVodVideoPlayerView hwVodVideoPlayerView) {
        super(1);
        this.this$0 = hwVodVideoPlayerView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        List access$getMSwitchLines$p = this.this$0.mSwitchLines;
        if (access$getMSwitchLines$p != null) {
            HwVodVideoPlayerView hwVodVideoPlayerView = this.this$0;
            if (i < access$getMSwitchLines$p.size()) {
                hwVodVideoPlayerView.mSwitchLineIndex = i;
                hwVodVideoPlayerView.mVideoPath = (String) access$getMSwitchLines$p.get(hwVodVideoPlayerView.mSwitchLineIndex);
                if (hwVodVideoPlayerView.mSwitchLineIndex == 0) {
                    IJKPlayer access$getMPlayer$p = hwVodVideoPlayerView.mPlayer;
                    if (access$getMPlayer$p != null) {
                        access$getMPlayer$p.setIsOtherLine(false);
                    }
                } else {
                    IJKPlayer access$getMPlayer$p2 = hwVodVideoPlayerView.mPlayer;
                    if (access$getMPlayer$p2 != null) {
                        access$getMPlayer$p2.setIsOtherLine(true);
                    }
                }
                hwVodVideoPlayerView.retryPlay();
                ToastUtils.showLong(hwVodVideoPlayerView.getContext().getString(R.string.vod_player_switch_line_success), new Object[0]);
            }
        }
    }
}
