package com.tal.app.thinkacademy.business.study.study.vodplayer;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView;
import com.tal.app.thinkacademy.business.studycenter.databinding.VodVideoPlayerViewBinding;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayListener;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IjkPlayerInfo;
import com.tal.app.thinkacademy.lib.player.ijkplayer.MediaErrorInfo;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.ijk.media.psplayer.PSMediaPlayer;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0017J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J*\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u0010\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001cH\u0016¨\u0006\u001e"}, d2 = {"com/tal/app/thinkacademy/business/study/study/vodplayer/HwVodVideoPlayerView$mListener$1", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IJKPlayListener;", "onBufferComplete", "", "onBufferStart", "onCloseComplete", "onCloseStart", "onHWRenderFailed", "onOpenFailed", "errorinfo", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/MediaErrorInfo;", "onOpenStart", "onOpenSuccess", "onPaused", "onPlayError", "onPlaybackComplete", "onPlaying", "currentPosition", "", "duration", "onVideoSizeChanged", "width", "", "height", "serverList", "cur", "total", "addrList", "", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwVodVideoPlayerView.kt */
public final class HwVodVideoPlayerView$mListener$1 implements IJKPlayListener {
    final /* synthetic */ HwVodVideoPlayerView this$0;

    public void onCloseComplete() {
    }

    public void onCloseStart() {
    }

    public void serverList(int i, int i2, List<String> list) {
    }

    HwVodVideoPlayerView$mListener$1(HwVodVideoPlayerView hwVodVideoPlayerView) {
        this.this$0 = hwVodVideoPlayerView;
    }

    public void onHWRenderFailed() {
        XesLog.i(HwVodVideoPlayerView.TAG, new Object[]{"onHWRenderFailed"});
    }

    public void onVideoSizeChanged(int i, int i2) {
        XesLog.i(HwVodVideoPlayerView.TAG, new Object[]{"onVideoSizeChanged width=" + i + ",height=" + i2});
        VodVideoPlayerViewBinding access$getBinding$p = this.this$0.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        ConstraintLayout.LayoutParams layoutParams = access$getBinding$p.payerSurfaceView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = layoutParams;
        if (i > 0 && i2 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(':');
            sb.append(i2);
            layoutParams2.dimensionRatio = sb.toString();
        }
    }

    public void onOpenStart() {
        this.this$0.showPlayerLoading();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r1 = r1.getCurrentPosition();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onOpenSuccess() {
        /*
            r6 = this;
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView r0 = r6.this$0
            com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer r1 = r0.mPlayer
            r2 = 0
            if (r1 != 0) goto L_0x000c
        L_0x000a:
            r4 = r2
            goto L_0x0017
        L_0x000c:
            java.lang.Long r1 = r1.getCurrentPosition()
            if (r1 != 0) goto L_0x0013
            goto L_0x000a
        L_0x0013:
            long r4 = r1.longValue()
        L_0x0017:
            r0.setMCurrentPosition(r4)
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView r0 = r6.this$0
            com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer r1 = r0.mPlayer
            if (r1 != 0) goto L_0x0023
            goto L_0x002e
        L_0x0023:
            java.lang.Long r1 = r1.getDuration()
            if (r1 != 0) goto L_0x002a
            goto L_0x002e
        L_0x002a:
            long r2 = r1.longValue()
        L_0x002e:
            r0.setMDuration(r2)
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView r0 = r6.this$0
            com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer r0 = r0.mPlayer
            if (r0 != 0) goto L_0x003a
            goto L_0x0043
        L_0x003a:
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView r1 = r6.this$0
            float r1 = r1.mCurrentSpeed
            r0.setSpeed(r1)
        L_0x0043:
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView r0 = r6.this$0
            r1 = 0
            r0.setErrorState(r1)
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView r0 = r6.this$0
            r0.hidePlayerLoading()
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView r0 = r6.this$0
            boolean r0 = r0.getMIsOnPause()
            if (r0 == 0) goto L_0x0062
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView r0 = r6.this$0
            com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer r0 = r0.mPlayer
            if (r0 != 0) goto L_0x005f
            goto L_0x0062
        L_0x005f:
            r0.pausePlay()
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView$mListener$1.onOpenSuccess():void");
    }

    public void onOpenFailed(MediaErrorInfo mediaErrorInfo) {
        String str;
        Intrinsics.checkNotNullParameter(mediaErrorInfo, "errorinfo");
        boolean z = false;
        XesLog.i(HwVodVideoPlayerView.TAG, new Object[]{"onOpenFailed errorcode start"});
        XesLog.i(HwVodVideoPlayerView.TAG, new Object[]{"onOpenFailed errorcode = " + mediaErrorInfo.getMErrorCode() + ",msg = " + mediaErrorInfo.getMErrorMsg()});
        CharSequence mErrorMsg = mediaErrorInfo.getMErrorMsg();
        if (mErrorMsg == null || mErrorMsg.length() == 0) {
            z = true;
        }
        if (z) {
            str = "";
        } else {
            str = Intrinsics.stringPlus(",msg=", mediaErrorInfo.getMErrorMsg());
        }
        VodVideoPlayerViewBinding access$getBinding$p = this.this$0.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getBinding$p.errDesc.setText("(Error code:" + mediaErrorInfo.getMErrorCode() + str + ')');
        this.this$0.setErrorState(true);
    }

    public void onPaused() {
        this.this$0.setPauseSate(true);
        XesLog.i(HwVodVideoPlayerView.TAG, new Object[]{"player onPaused"});
    }

    public void onBufferStart() {
        this.this$0.setErrorState(false);
        this.this$0.showPlayerLoading();
    }

    public void onBufferComplete() {
        this.this$0.hidePlayerLoading();
    }

    public void onPlaybackComplete() {
        this.this$0.setPlayComplete(true);
        HwVodVideoPlayerView.VodPlayerListen access$getMVodPlayerListen$p = this.this$0.mVodPlayerListen;
        if (access$getMVodPlayerListen$p != null) {
            access$getMVodPlayerListen$p.playComplete();
        }
        XesLog.i(HwVodVideoPlayerView.TAG, new Object[]{"onPlaybackComplete"});
        HwVodVideoPlayerView hwVodVideoPlayerView = this.this$0;
        hwVodVideoPlayerView.setSeekbarProgressTime(hwVodVideoPlayerView.getMDuration());
        IJKPlayer access$getMPlayer$p = this.this$0.mPlayer;
        if (access$getMPlayer$p != null) {
            access$getMPlayer$p.pausePlay();
        }
    }

    public void onPlaying(long j, long j2) {
        IjkPlayerInfo ijkPlayerInfo;
        this.this$0.setTotalTime(j2);
        this.this$0.setMCurrentPosition(j);
        this.this$0.setMDuration(j2);
        this.this$0.showPlayNextVideoBtn();
        if (!this.this$0.mIsDragging) {
            this.this$0.setSeekbarProgressTime(j);
        }
        IJKPlayer access$getMPlayer$p = this.this$0.mPlayer;
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = null;
        if (!(access$getMPlayer$p == null || (ijkPlayerInfo = access$getMPlayer$p.getIjkPlayerInfo()) == null)) {
            HwVodVideoPlayerView hwVodVideoPlayerView = this.this$0;
            VodVideoPlayerViewBinding access$getBinding$p = hwVodVideoPlayerView.binding;
            if (access$getBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                access$getBinding$p = null;
            }
            access$getBinding$p.tcpSpeedTextview.setText(hwVodVideoPlayerView.formatSpeed(ijkPlayerInfo.getMTcpSpeed(), 1000));
            if (!hwVodVideoPlayerView.getMIsOpenHLSCache()) {
                VodVideoPlayerViewBinding access$getBinding$p2 = hwVodVideoPlayerView.binding;
                if (access$getBinding$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    access$getBinding$p2 = null;
                }
                access$getBinding$p2.playerProgress.setSecondaryProgress((int) ijkPlayerInfo.getMBufferingPercent());
            }
        }
        this.this$0.checkIsNeedReport();
        if (this.this$0.getMIsOpenHLSCache()) {
            try {
                PSMediaPlayer.CacheInfo cacheInfo = IJKPlayer.Companion.getCacheInfo(this.this$0.mVideoPath, this.this$0.getMCurrentPosition());
                if (cacheInfo != null) {
                    HwVodVideoPlayerView hwVodVideoPlayerView2 = this.this$0;
                    XesLog.i(HwVodVideoPlayerView.TAG, new Object[]{"cacheInfo:mCurrentPosition=" + hwVodVideoPlayerView2.getMCurrentPosition() + "，pos=" + cacheInfo.pos + "，isCache=" + cacheInfo.isCache + ",cacheDuration=" + cacheInfo.cacheDuration + ",isFinish=" + cacheInfo.isFinish});
                    int i = 100;
                    int mCurrentPosition = hwVodVideoPlayerView2.getMDuration() > 0 ? (int) (((cacheInfo.cacheDuration + hwVodVideoPlayerView2.getMCurrentPosition()) * ((long) 100)) / hwVodVideoPlayerView2.getMDuration()) : 0;
                    if (mCurrentPosition <= 100) {
                        i = mCurrentPosition;
                    }
                    VodVideoPlayerViewBinding access$getBinding$p3 = hwVodVideoPlayerView2.binding;
                    if (access$getBinding$p3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        vodVideoPlayerViewBinding = access$getBinding$p3;
                    }
                    vodVideoPlayerViewBinding.playerProgress.setSecondaryProgress(i);
                }
            } catch (Exception e) {
                XesLog.i(HwVodVideoPlayerView.TAG, new Object[]{Intrinsics.stringPlus("获取缓存信息失败：", e)});
            }
        }
    }

    public void onPlayError() {
        XesLog.i(HwVodVideoPlayerView.TAG, new Object[]{"onPlayError"});
        VodVideoPlayerViewBinding access$getBinding$p = this.this$0.binding;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getBinding$p.errDesc.setText("(init error)");
        this.this$0.setErrorState(true);
    }
}
