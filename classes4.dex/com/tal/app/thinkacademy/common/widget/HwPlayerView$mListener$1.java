package com.tal.app.thinkacademy.common.widget;

import com.tal.app.thinkacademy.common.databinding.CommonHwPlayerLayoutBinding;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayListener;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer;
import com.tal.app.thinkacademy.lib.player.ijkplayer.MediaErrorInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J*\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u0010\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001cH\u0016¨\u0006\u001e"}, d2 = {"com/tal/app/thinkacademy/common/widget/HwPlayerView$mListener$1", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IJKPlayListener;", "onBufferComplete", "", "onBufferStart", "onCloseComplete", "onCloseStart", "onHWRenderFailed", "onOpenFailed", "errorinfo", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/MediaErrorInfo;", "onOpenStart", "onOpenSuccess", "onPaused", "onPlayError", "onPlaybackComplete", "onPlaying", "currentPosition", "", "duration", "onVideoSizeChanged", "width", "", "height", "serverList", "cur", "total", "addrList", "", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwPlayerView.kt */
public final class HwPlayerView$mListener$1 implements IJKPlayListener {
    final /* synthetic */ HwPlayerView this$0;

    public void onCloseComplete() {
    }

    public void onCloseStart() {
    }

    public void onVideoSizeChanged(int i, int i2) {
    }

    public void serverList(int i, int i2, List<String> list) {
    }

    HwPlayerView$mListener$1(HwPlayerView hwPlayerView) {
        this.this$0 = hwPlayerView;
    }

    public void onHWRenderFailed() {
        XesLog.dt("HwPlayerView", "onHWRenderFailed");
    }

    public void onOpenStart() {
        this.this$0.showPlayerLoading();
    }

    public void onOpenSuccess() {
        this.this$0.setErrorState(false);
        this.this$0.hidePlayerLoading();
    }

    public void onOpenFailed(MediaErrorInfo mediaErrorInfo) {
        Intrinsics.checkNotNullParameter(mediaErrorInfo, "errorinfo");
        XesLog.dt("HwPlayerView", Intrinsics.stringPlus("onOpenFailed errorinfo = ", mediaErrorInfo.getMErrorMsg()));
        this.this$0.setErrorState(true);
    }

    public void onPaused() {
        this.this$0.setPauseSate(true);
        XesLog.dt("HwPlayerView", "player onPaused");
    }

    public void onBufferStart() {
        this.this$0.setErrorState(false);
        this.this$0.showPlayerLoading();
    }

    public void onBufferComplete() {
        this.this$0.hidePlayerLoading();
    }

    public void onPlaybackComplete() {
        XesLog.dt("HwPlayerView", "onPlaybackComplete");
        HwPlayerView hwPlayerView = this.this$0;
        hwPlayerView.setBottomProgressBar(hwPlayerView.mDuration);
        IJKPlayer access$getMPlayer$p = this.this$0.mPlayer;
        if (access$getMPlayer$p != null) {
            access$getMPlayer$p.pausePlay();
        }
        CommonHwPlayerLayoutBinding access$getBinding$p = this.this$0.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getBinding$p.imageCover.setVisibility(0);
    }

    public void onPlaying(long j, long j2) {
        this.this$0.mCurrentPosition = j;
        this.this$0.mDuration = j2;
        this.this$0.setBottomProgressBar(j);
    }

    public void onPlayError() {
        XesLog.dt("HwPlayerView", "onPlayError");
        this.this$0.setErrorState(true);
    }
}
