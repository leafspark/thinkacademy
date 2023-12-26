package com.tal.app.thinkacademy.lib.player.ijkplayer;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.utils.NetWorkUtils;
import com.tal.app.thinkacademy.lib.player.ijkplayer.config.MediaPlayer;
import com.tal.app.thinkacademy.lib.player.track.IjkTrackUtil;
import com.tal.app.thinkacademy.lib.player.track.VideoPlayerSceneType;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011*\u0001\u001b\u0018\u0000 62\u00020\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020&H\u0002J\u0006\u0010'\u001a\u00020&J\u000e\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\bJ*\u0010*\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010$2\b\u0010,\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\fJ\b\u0010/\u001a\u00020&H\u0002J\b\u00100\u001a\u00020&H\u0002J\u000e\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\fJ\b\u00103\u001a\u00020&H\u0002J\u000e\u00104\u001a\u00020&2\u0006\u0010)\u001a\u00020\bJ\b\u00105\u001a\u00020&H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u000e\u0010\u0017\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/ijkplayer/PlayTimeEventReport;", "", "()V", "isBuffering", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isCreate", "isPreparing", "mCurrentState", "", "mHandler", "Landroid/os/Handler;", "mIsEnableHlsCache", "", "mIsError", "mIsFirstPlay", "mIsOtherLine", "getMIsOtherLine", "()Z", "setMIsOtherLine", "(Z)V", "mIsPlayStartHitCache", "getMIsPlayStartHitCache", "setMIsPlayStartHitCache", "mIsSeekFromUser", "mIsStartLook", "mLoadingCount", "mRunnable", "com/tal/app/thinkacademy/lib/player/ijkplayer/PlayTimeEventReport$mRunnable$1", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/PlayTimeEventReport$mRunnable$1;", "mStartLoadingTime", "", "mStartLookTime", "mTotalLoadingTime", "mVideoPlayerScene", "Lcom/tal/app/thinkacademy/lib/player/track/VideoPlayerSceneType;", "mVideoUrl", "", "computeLoadingTime", "", "destroy", "onPlayState", "state", "playFile", "url", "scene", "isEnableHlsCache", "isOtherLine", "reportLoadingTime", "reportNow", "seek", "isFromUser", "sendLoopEvent", "setPlayerState", "stopReport", "Companion", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayTimeEventReport.kt */
public final class PlayTimeEventReport {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "卡顿时长上报";
    private final AtomicBoolean isBuffering = new AtomicBoolean(false);
    private final AtomicBoolean isCreate = new AtomicBoolean(false);
    private final AtomicBoolean isPreparing = new AtomicBoolean(false);
    private int mCurrentState = MediaPlayer.Companion.getSTATE_PLAYING();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsEnableHlsCache;
    private boolean mIsError;
    private boolean mIsFirstPlay = true;
    private boolean mIsOtherLine;
    private boolean mIsPlayStartHitCache;
    private boolean mIsSeekFromUser;
    private boolean mIsStartLook;
    private int mLoadingCount;
    private PlayTimeEventReport$mRunnable$1 mRunnable = new PlayTimeEventReport$mRunnable$1(this);
    private long mStartLoadingTime;
    private long mStartLookTime;
    private long mTotalLoadingTime;
    private VideoPlayerSceneType mVideoPlayerScene;
    private String mVideoUrl;

    public final boolean getMIsPlayStartHitCache() {
        return this.mIsPlayStartHitCache;
    }

    public final void setMIsPlayStartHitCache(boolean z) {
        this.mIsPlayStartHitCache = z;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/ijkplayer/PlayTimeEventReport$Companion;", "", "()V", "TAG", "", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PlayTimeEventReport.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean getMIsOtherLine() {
        return this.mIsOtherLine;
    }

    public final void setMIsOtherLine(boolean z) {
        this.mIsOtherLine = z;
    }

    /* access modifiers changed from: private */
    public final void reportLoadingTime() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.mStartLookTime;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("上报神策，观看时长=");
        sb.append(elapsedRealtime);
        sb.append(" ms,卡顿时长=");
        sb.append(this.mTotalLoadingTime);
        sb.append(" ms,卡顿次数=");
        sb.append(this.mLoadingCount);
        sb.append(",url=");
        sb.append(this.mVideoUrl);
        sb.append(",scene=");
        VideoPlayerSceneType videoPlayerSceneType = this.mVideoPlayerScene;
        sb.append(videoPlayerSceneType == null ? null : videoPlayerSceneType.getValue());
        sb.append(",enableCache=");
        sb.append(this.mIsEnableHlsCache);
        objArr[0] = sb.toString();
        XesLog.et(TAG, objArr);
        IjkTrackUtil.INSTANCE.trackPlayerLookCostTime(this.mTotalLoadingTime, elapsedRealtime, this.mLoadingCount, this.mVideoUrl, this.mVideoPlayerScene, this.mIsEnableHlsCache, this.mIsPlayStartHitCache, this.mIsOtherLine);
        this.mTotalLoadingTime = 0;
        this.mLoadingCount = 0;
        this.mStartLookTime = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: private */
    public final void sendLoopEvent() {
        XesLog.it(TAG, "执行 sendLoopEvent 函数");
        this.mHandler.removeCallbacks(this.mRunnable);
        this.mHandler.postDelayed(this.mRunnable, NetWorkUtils.MINUTE);
    }

    private final void stopReport() {
        XesLog.it(TAG, "执行 stopReport 函数");
        this.mHandler.removeCallbacks(this.mRunnable);
    }

    private final void reportNow() {
        XesLog.it(TAG, "执行 reportNow 函数");
        reportLoadingTime();
    }

    private final void computeLoadingTime() {
        if (this.isBuffering.get()) {
            this.mTotalLoadingTime += SystemClock.elapsedRealtime() - this.mStartLoadingTime;
            this.mLoadingCount++;
            this.isBuffering.set(false);
        }
    }

    public final void playFile(String str, VideoPlayerSceneType videoPlayerSceneType, boolean z, boolean z2) {
        this.mVideoUrl = str;
        this.mVideoPlayerScene = videoPlayerSceneType;
        this.mIsEnableHlsCache = z;
        this.mIsOtherLine = z2;
    }

    public final void seek(boolean z) {
        this.mIsSeekFromUser = z;
    }

    public final void onPlayState(int i) {
        switch (i) {
            case -1:
            case 7:
                stopReport();
                if (this.mIsFirstPlay) {
                    XesLog.it(TAG, "播放失败，还处于第一次播放，不计卡顿耗时,不上报");
                } else if (this.mIsStartLook) {
                    stopReport();
                    if (this.isBuffering.get()) {
                        XesLog.it(TAG, "播放失败，失败前，卡顿中，观看中，计算卡顿时长。立即上报");
                        computeLoadingTime();
                    } else {
                        XesLog.it(TAG, "播放失败，失败前，不处于卡顿中，观看中，不计卡顿时长。立即上报");
                    }
                    reportNow();
                } else {
                    XesLog.it(TAG, "播放失败，失败前，卡顿中，不在观看中，计算卡顿时长。立即上报");
                }
                this.isBuffering.set(false);
                this.mIsSeekFromUser = false;
                this.mIsFirstPlay = true;
                this.mIsStartLook = false;
                return;
            case 1:
                this.isPreparing.set(true);
                this.isCreate.set(true);
                return;
            case 2:
                if (this.mIsFirstPlay) {
                    XesLog.it(TAG, "第一次播放成功，开始上报计时");
                    this.mStartLookTime = SystemClock.elapsedRealtime();
                    this.mIsStartLook = true;
                    sendLoopEvent();
                } else if (this.isBuffering.get()) {
                    XesLog.it(TAG, "卡顿结束，开始计算卡顿时长");
                    computeLoadingTime();
                }
                this.mIsFirstPlay = false;
                this.mIsSeekFromUser = false;
                this.isBuffering.set(false);
                return;
            case 3:
                if (this.mIsFirstPlay) {
                    XesLog.it(TAG, "回调：暂停,处于第一次播放，不处理,1");
                } else if (this.mIsStartLook) {
                    stopReport();
                    if (this.isBuffering.get()) {
                        XesLog.it(TAG, "回调：暂停,不处于第一次播放，处于观看中，loading中，上报,2");
                        computeLoadingTime();
                    } else {
                        XesLog.it(TAG, "回调：暂停,不处于第一次播放，处于观看中，no loding，上报,3");
                    }
                    reportNow();
                } else {
                    XesLog.it(TAG, "回调：暂停,不处于第一次播放，不在观看中，不处理，4");
                }
                this.mIsStartLook = false;
                this.mIsFirstPlay = true;
                this.mIsSeekFromUser = false;
                this.isBuffering.set(false);
                return;
            case 4:
                if (this.mIsFirstPlay) {
                    XesLog.it(TAG, "开始loading...第一次，不计卡顿，");
                    return;
                } else if (!this.isCreate.get()) {
                    return;
                } else {
                    if (this.mIsSeekFromUser) {
                        XesLog.it(TAG, "开始loading...不是第一次，用户拖动造成，不计卡顿");
                        return;
                    }
                    XesLog.it(TAG, "开始loading...不是第一次，自动卡顿，计卡顿");
                    this.isBuffering.set(true);
                    this.mStartLoadingTime = SystemClock.elapsedRealtime();
                    return;
                }
            case 5:
                if (this.mIsFirstPlay) {
                    XesLog.it(TAG, "播放完成,还处于第一次播放中，不上报");
                } else if (this.mIsStartLook) {
                    XesLog.it(TAG, "播放完成，不是第一次，观看中，立即上报");
                    stopReport();
                    reportNow();
                } else {
                    XesLog.it(TAG, "播放完成，不是第一次，不再观看中，立即上报");
                }
                this.isBuffering.set(false);
                this.mIsSeekFromUser = false;
                this.mIsFirstPlay = true;
                this.mIsStartLook = false;
                return;
            case 6:
                this.isPreparing.set(true);
                return;
            default:
                return;
        }
    }

    public final void setPlayerState(int i) {
        this.mCurrentState = i;
        if (i == MediaPlayer.Companion.getSTATE_STOPPED()) {
            if (this.mIsFirstPlay) {
                XesLog.it(TAG, "结束播放，还处于第一次播放，不计卡顿耗时,不上报");
            } else if (this.mIsStartLook) {
                stopReport();
                if (this.isBuffering.get()) {
                    XesLog.it(TAG, "结束播放，失败前，卡顿中，观看中，计算卡顿时长。立即上报");
                    computeLoadingTime();
                } else {
                    XesLog.it(TAG, "结束播放，失败前，不处于卡顿中，观看中，不计卡顿时长。立即上报");
                }
                reportNow();
            } else {
                XesLog.it(TAG, "结束播放，失败前，卡顿中，不在观看中，计算卡顿时长。立即上报");
            }
            this.isBuffering.set(false);
            this.mIsSeekFromUser = false;
            this.mIsFirstPlay = true;
            this.mIsStartLook = false;
        }
    }

    public final void destroy() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }
}
