package com.tal.app.thinkacademy.business.study.study.vodplayer;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.study.study.Tag;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.VodVideoPlayerViewBinding;
import com.tal.app.thinkacademy.common.utils.CommonUtilsKt;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayListener;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer;
import com.tal.app.thinkacademy.lib.player.track.VideoPlayerSceneType;
import com.tal.app.thinkacademy.lib.util.ImageUtils;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.lib.util.TimeUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.lib.utils.PermissionHelper;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b.\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0004\u0001\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010D\u001a\u00020EH\u0002J\u0006\u0010F\u001a\u00020EJ\u0010\u0010G\u001a\u00020E2\u0006\u0010H\u001a\u00020\u000bH\u0002J\u0010\u0010I\u001a\u00020E2\u0006\u0010H\u001a\u00020\u000bH\u0002J\u001a\u0010J\u001a\u0004\u0018\u00010\u000f2\u0006\u0010K\u001a\u00020\u00112\u0006\u0010L\u001a\u00020\u0011H\u0002J\u0010\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PH\u0002J\u0006\u0010Q\u001a\u00020\rJ\b\u0010R\u001a\u00020PH\u0002J\n\u0010S\u001a\u0004\u0018\u00010PH\u0002J\b\u0010T\u001a\u00020EH\u0002J\b\u0010U\u001a\u00020EH\u0002J\b\u0010V\u001a\u00020EH\u0002J\b\u0010W\u001a\u00020EH\u0002J\u0012\u0010X\u001a\u00020E2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\u0006\u0010[\u001a\u00020EJ\u000e\u0010\\\u001a\u00020E2\u0006\u0010]\u001a\u00020\u000fJ\u0010\u0010^\u001a\u00020E2\u0006\u0010_\u001a\u00020\u0011H\u0002J\b\u0010`\u001a\u00020EH\u0002J\b\u0010a\u001a\u00020EH\u0002J\b\u0010b\u001a\u00020EH\u0002J\u0006\u0010c\u001a\u00020EJ\u0006\u0010d\u001a\u00020EJ(\u0010e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010f\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020\u000f2\u0006\u0010h\u001a\u00020\u000fH\u0002J\u0010\u0010i\u001a\u00020E2\u0006\u0010j\u001a\u00020\u000bH\u0002J6\u0010k\u001a\u00020E2\b\u0010l\u001a\u0004\u0018\u00010\u000f2\b\u0010]\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010m\u001a\u00020\u000b2\u0010\b\u0002\u0010n\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u000107J\u0010\u0010o\u001a\u00020E2\u0006\u0010p\u001a\u00020\rH\u0002J\u0010\u0010q\u001a\u00020E2\u0006\u0010r\u001a\u00020\rH\u0002J\u0010\u0010s\u001a\u00020E2\u0006\u0010t\u001a\u00020\rH\u0002J\u0010\u0010u\u001a\u00020E2\u0006\u0010v\u001a\u00020\u0011H\u0002J\u0010\u0010w\u001a\u00020E2\u0006\u0010v\u001a\u00020\u0011H\u0002J\u000e\u0010x\u001a\u00020E2\u0006\u0010y\u001a\u00020;J\u0010\u0010z\u001a\u00020E2\b\u0010{\u001a\u0004\u0018\u00010CJ\u0010\u0010|\u001a\u00020E2\u0006\u0010}\u001a\u00020\rH\u0002J\b\u0010~\u001a\u00020EH\u0002J\b\u0010\u001a\u00020EH\u0002J\t\u0010\u0001\u001a\u00020EH\u0002J\t\u0010\u0001\u001a\u00020EH\u0002J\t\u0010\u0001\u001a\u00020EH\u0002J\t\u0010\u0001\u001a\u00020EH\u0003J\u0007\u0010\u0001\u001a\u00020EJ\t\u0010\u0001\u001a\u00020EH\u0002R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u000e\u0010\u001c\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u000e\u0010+\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u00106\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vodplayer/HwVodVideoPlayerView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/VodVideoPlayerViewBinding;", "mBackSeekCount", "", "mBackSeekIsStart", "", "mCoverUrl", "", "mCurrentPosition", "", "getMCurrentPosition", "()J", "setMCurrentPosition", "(J)V", "mCurrentSpeed", "", "mDragProgress", "mDuration", "getMDuration", "setMDuration", "mFrontSeekCount", "mFrontSeekIsStart", "mHandler", "Landroid/os/Handler;", "mIsControlBarShowing", "mIsDragging", "mIsError", "mIsOnPause", "getMIsOnPause", "()Z", "setMIsOnPause", "(Z)V", "mIsOpenHLSCache", "getMIsOpenHLSCache", "setMIsOpenHLSCache", "mIsPlayComplete", "mLastReportMinute", "mListener", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IJKPlayListener;", "mPlayer", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IJKPlayer;", "mSurface", "Landroid/view/Surface;", "mSwitchLineDialog", "Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VideoSwitchLineDialog;", "mSwitchLineIndex", "mSwitchLines", "", "mVideoName", "mVideoPath", "mVideoPlayerSceneType", "Lcom/tal/app/thinkacademy/lib/player/track/VideoPlayerSceneType;", "mVideoScreenShotDialog", "Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VideoScreenShotDialog;", "mVideoSettingDialog", "Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VideoSettingDialog;", "mVideoSpeedSelectDialog", "Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VideoSpeedSelectDialog;", "mVodPlayerListen", "Lcom/tal/app/thinkacademy/business/study/study/vodplayer/HwVodVideoPlayerView$VodPlayerListen;", "checkIsNeedReport", "", "destroyPlayer", "execBackSeekAnimator", "count", "execFrontSeekAnimator", "formatSpeed", "bytes", "elapsed_milli", "fromFile", "Landroid/net/Uri;", "file", "Ljava/io/File;", "getIsPlayComplete", "getSaveCameraDir", "getSystemCameraDir", "hideControlBar", "hideError", "hidePlayerLoading", "initPlayer", "onClick", "v", "Landroid/view/View;", "pausePlay", "playUrl", "url", "playerSeek", "position", "requestSavePermission", "resetBackSeekButton", "resetFrontSeekButton", "resumePlay", "retryPlay", "saveToGallery", "path", "title", "description", "setCurrentTime", "progress", "setData", "name", "switchLineIndex", "switchLines", "setErrorState", "isError", "setPauseSate", "isPause", "setPlayComplete", "isComplete", "setSeekbarProgressTime", "time", "setTotalTime", "setVideoPlayerSceneType", "videoPlayerSceneType", "setVodPlayerListen", "listen", "showControlBar", "isAlwaysShow", "showError", "showPlayNextVideoBtn", "showPlayerLoading", "showSettingDialog", "showSwitchLineDialog", "showSwitchSpeed", "stopPlay", "takePhoto", "Companion", "VodPlayerListen", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwVodVideoPlayerView.kt */
public final class HwVodVideoPlayerView extends FrameLayout implements View.OnClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long HIDE_DELAY_TIME = 5000;
    private static final int ONE_MINUTE_TIME = 60000;
    private static final long REPORT_DELAY_TIME = 60000;
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.VOD_PLAYER_PLAY;
    private static final int WHAT_BACK_SEEK_RESET = 102;
    private static final int WHAT_CONTROL_BAR_HIDE = 100;
    private static final int WHAT_FRONT_SEEK_RESET = 101;
    private static final int WHAT_REPORT_VIDEO_DATA = 103;
    /* access modifiers changed from: private */
    public VodVideoPlayerViewBinding binding;
    /* access modifiers changed from: private */
    public int mBackSeekCount;
    /* access modifiers changed from: private */
    public boolean mBackSeekIsStart;
    private String mCoverUrl;
    private long mCurrentPosition;
    /* access modifiers changed from: private */
    public float mCurrentSpeed;
    /* access modifiers changed from: private */
    public long mDragProgress;
    private long mDuration;
    /* access modifiers changed from: private */
    public int mFrontSeekCount;
    /* access modifiers changed from: private */
    public boolean mFrontSeekIsStart;
    private final Handler mHandler;
    private boolean mIsControlBarShowing;
    /* access modifiers changed from: private */
    public boolean mIsDragging;
    private boolean mIsError;
    private boolean mIsOnPause;
    private boolean mIsOpenHLSCache;
    private boolean mIsPlayComplete;
    private int mLastReportMinute;
    private final IJKPlayListener mListener;
    /* access modifiers changed from: private */
    public IJKPlayer mPlayer;
    /* access modifiers changed from: private */
    public Surface mSurface;
    private VideoSwitchLineDialog mSwitchLineDialog;
    /* access modifiers changed from: private */
    public int mSwitchLineIndex;
    /* access modifiers changed from: private */
    public List<String> mSwitchLines;
    private String mVideoName;
    /* access modifiers changed from: private */
    public String mVideoPath;
    private VideoPlayerSceneType mVideoPlayerSceneType;
    private VideoScreenShotDialog mVideoScreenShotDialog;
    private VideoSettingDialog mVideoSettingDialog;
    private VideoSpeedSelectDialog mVideoSpeedSelectDialog;
    /* access modifiers changed from: private */
    public VodPlayerListen mVodPlayerListen;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vodplayer/HwVodVideoPlayerView$VodPlayerListen;", "", "isShowNextVideoButton", "", "onExit", "", "onNextVideoButtonClick", "onSwitchSpeed", "speed", "", "onTakePhoto", "playComplete", "reportData", "minute", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HwVodVideoPlayerView.kt */
    public interface VodPlayerListen {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: HwVodVideoPlayerView.kt */
        public static final class DefaultImpls {
            public static boolean isShowNextVideoButton(VodPlayerListen vodPlayerListen) {
                Intrinsics.checkNotNullParameter(vodPlayerListen, "this");
                return false;
            }

            public static void onExit(VodPlayerListen vodPlayerListen) {
                Intrinsics.checkNotNullParameter(vodPlayerListen, "this");
            }

            public static void onNextVideoButtonClick(VodPlayerListen vodPlayerListen) {
                Intrinsics.checkNotNullParameter(vodPlayerListen, "this");
            }

            public static void onSwitchSpeed(VodPlayerListen vodPlayerListen, String str) {
                Intrinsics.checkNotNullParameter(vodPlayerListen, "this");
                Intrinsics.checkNotNullParameter(str, "speed");
            }

            public static void onTakePhoto(VodPlayerListen vodPlayerListen) {
                Intrinsics.checkNotNullParameter(vodPlayerListen, "this");
            }

            public static void reportData(VodPlayerListen vodPlayerListen, int i) {
                Intrinsics.checkNotNullParameter(vodPlayerListen, "this");
            }
        }

        boolean isShowNextVideoButton();

        void onExit();

        void onNextVideoButtonClick();

        void onSwitchSpeed(String str);

        void onTakePhoto();

        void playComplete();

        void reportData(int i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HwVodVideoPlayerView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HwVodVideoPlayerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vodplayer/HwVodVideoPlayerView$Companion;", "", "()V", "HIDE_DELAY_TIME", "", "ONE_MINUTE_TIME", "", "REPORT_DELAY_TIME", "TAG", "Lcom/tal/app/thinkacademy/business/study/study/Tag;", "WHAT_BACK_SEEK_RESET", "WHAT_CONTROL_BAR_HIDE", "WHAT_FRONT_SEEK_RESET", "WHAT_REPORT_VIDEO_DATA", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HwVodVideoPlayerView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HwVodVideoPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsOnPause = true;
        this.mVideoPath = "";
        this.mCoverUrl = "";
        this.mCurrentSpeed = 1.0f;
        this.mIsControlBarShowing = true;
        this.mHandler = new HwVodVideoPlayerView$mHandler$1(this, Looper.getMainLooper());
        this.mListener = new HwVodVideoPlayerView$mListener$1(this);
        VodVideoPlayerViewBinding inflate = VodVideoPlayerViewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context),this,true)");
        this.binding = inflate;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = context.getString(R.string.speed_switch_btn_str);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.speed_switch_btn_str)");
        String format = String.format(string, Arrays.copyOf(new Object[]{1}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = this.binding;
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding2 = null;
        if (vodVideoPlayerViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding = null;
        }
        vodVideoPlayerViewBinding.switchSpeedBtn.setText(format);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding3 = this.binding;
        if (vodVideoPlayerViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding3 = null;
        }
        vodVideoPlayerViewBinding3.payerSurfaceView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener(this) {
            final /* synthetic */ HwVodVideoPlayerView this$0;

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                Intrinsics.checkNotNullParameter(surfaceTexture, "surface");
            }

            {
                this.this$0 = r1;
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                IJKPlayer access$getMPlayer$p;
                Intrinsics.checkNotNullParameter(surfaceTexture, "surface");
                XesLog.i(HwVodVideoPlayerView.TAG, new Object[]{"onSurfaceTextureAvailable"});
                this.this$0.mSurface = new Surface(surfaceTexture);
                Surface access$getMSurface$p = this.this$0.mSurface;
                if (access$getMSurface$p != null && (access$getMPlayer$p = this.this$0.mPlayer) != null) {
                    access$getMPlayer$p.setSurface(access$getMSurface$p);
                }
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                Intrinsics.checkNotNullParameter(surfaceTexture, "surface");
                XesLog.i(HwVodVideoPlayerView.TAG, new Object[]{"onSurfaceTextureSizeChanged width=" + i + ",height=" + i2});
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                Intrinsics.checkNotNullParameter(surfaceTexture, "surface");
                XesLog.i(HwVodVideoPlayerView.TAG, new Object[]{"onSurfaceTextureDestroyed"});
                IJKPlayer access$getMPlayer$p = this.this$0.mPlayer;
                if (access$getMPlayer$p != null) {
                    access$getMPlayer$p.releaseSurface();
                }
                return false;
            }
        });
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding4 = this.binding;
        if (vodVideoPlayerViewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding4 = null;
        }
        vodVideoPlayerViewBinding4.playerProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) {
            final /* synthetic */ HwVodVideoPlayerView this$0;

            {
                this.this$0 = r1;
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                if (z) {
                    this.this$0.mIsDragging = true;
                    this.this$0.mDragProgress = (long) i;
                    this.this$0.setCurrentTime(i);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                this.this$0.mIsDragging = true;
                XesLog.i(HwVodVideoPlayerView.TAG, new Object[]{"开始拖动"});
                this.this$0.showControlBar(true);
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                XesLog.i(HwVodVideoPlayerView.TAG, new Object[]{Intrinsics.stringPlus("拖动结束 progress=", Long.valueOf(this.this$0.mDragProgress))});
                this.this$0.mIsDragging = false;
                this.this$0.showControlBar(false);
                HwVodVideoPlayerView hwVodVideoPlayerView = this.this$0;
                long j = 0;
                if (hwVodVideoPlayerView.getMDuration() > 0) {
                    j = (this.this$0.getMDuration() * this.this$0.mDragProgress) / ((long) 100);
                }
                hwVodVideoPlayerView.setMCurrentPosition(j);
                HwVodVideoPlayerView hwVodVideoPlayerView2 = this.this$0;
                hwVodVideoPlayerView2.playerSeek(hwVodVideoPlayerView2.getMCurrentPosition());
                SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
            }
        });
        setOnClickListener(new HwVodVideoPlayerView$$ExternalSyntheticLambda0(this));
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding5 = this.binding;
        if (vodVideoPlayerViewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding5 = null;
        }
        View.OnClickListener onClickListener = this;
        vodVideoPlayerViewBinding5.playerPlayBtn.setOnClickListener(onClickListener);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding6 = this.binding;
        if (vodVideoPlayerViewBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding6 = null;
        }
        vodVideoPlayerViewBinding6.playerBackBtn.setOnClickListener(onClickListener);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding7 = this.binding;
        if (vodVideoPlayerViewBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding7 = null;
        }
        vodVideoPlayerViewBinding7.takePhoto.setOnClickListener(onClickListener);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding8 = this.binding;
        if (vodVideoPlayerViewBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding8 = null;
        }
        vodVideoPlayerViewBinding8.frontSeekBtn.setOnClickListener(onClickListener);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding9 = this.binding;
        if (vodVideoPlayerViewBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding9 = null;
        }
        vodVideoPlayerViewBinding9.backSeekBtn.setOnClickListener(onClickListener);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding10 = this.binding;
        if (vodVideoPlayerViewBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding10 = null;
        }
        vodVideoPlayerViewBinding10.switchSpeedBtn.setOnClickListener(onClickListener);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding11 = this.binding;
        if (vodVideoPlayerViewBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding11 = null;
        }
        vodVideoPlayerViewBinding11.reloadButton.setOnClickListener(onClickListener);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding12 = this.binding;
        if (vodVideoPlayerViewBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding12 = null;
        }
        vodVideoPlayerViewBinding12.playerFunctionMore.setOnClickListener(onClickListener);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding13 = this.binding;
        if (vodVideoPlayerViewBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vodVideoPlayerViewBinding2 = vodVideoPlayerViewBinding13;
        }
        vodVideoPlayerViewBinding2.playNextVideoBtn.setOnClickListener(onClickListener);
    }

    public final long getMDuration() {
        return this.mDuration;
    }

    public final void setMDuration(long j) {
        this.mDuration = j;
    }

    public final long getMCurrentPosition() {
        return this.mCurrentPosition;
    }

    public final void setMCurrentPosition(long j) {
        this.mCurrentPosition = j;
    }

    public final boolean getMIsOnPause() {
        return this.mIsOnPause;
    }

    public final void setMIsOnPause(boolean z) {
        this.mIsOnPause = z;
    }

    public final boolean getMIsOpenHLSCache() {
        return this.mIsOpenHLSCache;
    }

    public final void setMIsOpenHLSCache(boolean z) {
        this.mIsOpenHLSCache = z;
    }

    public final void setVideoPlayerSceneType(VideoPlayerSceneType videoPlayerSceneType) {
        Intrinsics.checkNotNullParameter(videoPlayerSceneType, "videoPlayerSceneType");
        this.mVideoPlayerSceneType = videoPlayerSceneType;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m493_init_$lambda0(HwVodVideoPlayerView hwVodVideoPlayerView, View view) {
        Intrinsics.checkNotNullParameter(hwVodVideoPlayerView, "this$0");
        if (hwVodVideoPlayerView.mIsControlBarShowing) {
            hwVodVideoPlayerView.hideControlBar();
        } else {
            hwVodVideoPlayerView.showControlBar(false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setVodPlayerListen(VodPlayerListen vodPlayerListen) {
        this.mVodPlayerListen = vodPlayerListen;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        r0 = r0.getUid();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initPlayer() {
        /*
            r9 = this;
            com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer r0 = r9.mPlayer
            if (r0 != 0) goto L_0x0045
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r0 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r0 = r0.getInstance()
            com.tal.app.thinkacademy.common.user.UserInfo r0 = r0.getUserInfoEntity()
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0014
        L_0x0012:
            r7 = r1
            goto L_0x001c
        L_0x0014:
            java.lang.String r0 = r0.getUid()
            if (r0 != 0) goto L_0x001b
            goto L_0x0012
        L_0x001b:
            r7 = r0
        L_0x001c:
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r0 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r2 = "school_code"
            java.lang.String r3 = "415"
            java.lang.String r8 = r0.getString(r2, r3, r1)
            com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer r0 = new com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer
            android.content.Context r3 = r9.getContext()
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            java.lang.String r1 = "schoolCode"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            java.lang.String r4 = "hw20001"
            java.lang.String r5 = ""
            r2 = r0
            r6 = r7
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r9.mPlayer = r0
        L_0x0045:
            boolean r0 = r9.mIsOpenHLSCache
            if (r0 == 0) goto L_0x0051
            com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer r0 = r9.mPlayer
            if (r0 != 0) goto L_0x004e
            goto L_0x0051
        L_0x004e:
            r0.enableHLSCache()
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView.initPlayer():void");
    }

    /* access modifiers changed from: private */
    public final void showPlayerLoading() {
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = this.binding;
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding2 = null;
        if (vodVideoPlayerViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding = null;
        }
        vodVideoPlayerViewBinding.playerLoading.setVisibility(0);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding3 = this.binding;
        if (vodVideoPlayerViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding3 = null;
        }
        vodVideoPlayerViewBinding3.loadingLottieView.playAnimation();
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding4 = this.binding;
        if (vodVideoPlayerViewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vodVideoPlayerViewBinding2 = vodVideoPlayerViewBinding4;
        }
        vodVideoPlayerViewBinding2.playerPlayBtn.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public final void hidePlayerLoading() {
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = this.binding;
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding2 = null;
        if (vodVideoPlayerViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding = null;
        }
        vodVideoPlayerViewBinding.playerLoading.setVisibility(8);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding3 = this.binding;
        if (vodVideoPlayerViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding3 = null;
        }
        vodVideoPlayerViewBinding3.loadingLottieView.cancelAnimation();
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding4 = this.binding;
        if (vodVideoPlayerViewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vodVideoPlayerViewBinding2 = vodVideoPlayerViewBinding4;
        }
        vodVideoPlayerViewBinding2.playerPlayBtn.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void showControlBar(boolean z) {
        this.mHandler.removeMessages(100);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = this.binding;
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding2 = null;
        if (vodVideoPlayerViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding = null;
        }
        vodVideoPlayerViewBinding.playerTopLayout.setVisibility(0);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding3 = this.binding;
        if (vodVideoPlayerViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding3 = null;
        }
        vodVideoPlayerViewBinding3.playerBottomLayout.setVisibility(0);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding4 = this.binding;
        if (vodVideoPlayerViewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding4 = null;
        }
        vodVideoPlayerViewBinding4.centerControlBtnLayout.setVisibility(0);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding5 = this.binding;
        if (vodVideoPlayerViewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vodVideoPlayerViewBinding2 = vodVideoPlayerViewBinding5;
        }
        vodVideoPlayerViewBinding2.displayInfoBg.setVisibility(0);
        this.mIsControlBarShowing = true;
        if (!z) {
            this.mHandler.sendEmptyMessageDelayed(100, HIDE_DELAY_TIME);
        }
    }

    /* access modifiers changed from: private */
    public final void hideControlBar() {
        this.mHandler.removeMessages(100);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = this.binding;
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding2 = null;
        if (vodVideoPlayerViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding = null;
        }
        vodVideoPlayerViewBinding.playerTopLayout.setVisibility(8);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding3 = this.binding;
        if (vodVideoPlayerViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding3 = null;
        }
        vodVideoPlayerViewBinding3.playerBottomLayout.setVisibility(8);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding4 = this.binding;
        if (vodVideoPlayerViewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding4 = null;
        }
        vodVideoPlayerViewBinding4.centerControlBtnLayout.setVisibility(8);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding5 = this.binding;
        if (vodVideoPlayerViewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vodVideoPlayerViewBinding2 = vodVideoPlayerViewBinding5;
        }
        vodVideoPlayerViewBinding2.displayInfoBg.setVisibility(8);
        this.mIsControlBarShowing = false;
    }

    /* access modifiers changed from: private */
    public final void setErrorState(boolean z) {
        this.mIsError = z;
        if (z) {
            hideControlBar();
            hidePlayerLoading();
            pausePlay();
            showError();
        }
    }

    private final void showError() {
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = this.binding;
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding2 = null;
        if (vodVideoPlayerViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding = null;
        }
        vodVideoPlayerViewBinding.errorLayout.setVisibility(0);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding3 = this.binding;
        if (vodVideoPlayerViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vodVideoPlayerViewBinding2 = vodVideoPlayerViewBinding3;
        }
        vodVideoPlayerViewBinding2.playerTopLayout.setVisibility(0);
    }

    private final void hideError() {
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = this.binding;
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding2 = null;
        if (vodVideoPlayerViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding = null;
        }
        vodVideoPlayerViewBinding.playerTopLayout.setVisibility(8);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding3 = this.binding;
        if (vodVideoPlayerViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vodVideoPlayerViewBinding2 = vodVideoPlayerViewBinding3;
        }
        vodVideoPlayerViewBinding2.errorLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void setPauseSate(boolean z) {
        if (this.mIsOnPause != z) {
            this.mIsOnPause = z;
            VodVideoPlayerViewBinding vodVideoPlayerViewBinding = null;
            if (z) {
                VodVideoPlayerViewBinding vodVideoPlayerViewBinding2 = this.binding;
                if (vodVideoPlayerViewBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    vodVideoPlayerViewBinding = vodVideoPlayerViewBinding2;
                }
                vodVideoPlayerViewBinding.playerPlayBtn.setImageResource(R.drawable.vod_player_play_icon);
                return;
            }
            VodVideoPlayerViewBinding vodVideoPlayerViewBinding3 = this.binding;
            if (vodVideoPlayerViewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                vodVideoPlayerViewBinding = vodVideoPlayerViewBinding3;
            }
            vodVideoPlayerViewBinding.playerPlayBtn.setImageResource(R.drawable.vod_player_pause_icon);
        }
    }

    /* access modifiers changed from: private */
    public final void setTotalTime(long j) {
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = this.binding;
        if (vodVideoPlayerViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding = null;
        }
        vodVideoPlayerViewBinding.playerTimeTotal.setText(TimeUtils.stringForTime(j));
    }

    /* access modifiers changed from: private */
    public final void setCurrentTime(int i) {
        long j = (((long) i) * this.mDuration) / ((long) 100);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = this.binding;
        if (vodVideoPlayerViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding = null;
        }
        vodVideoPlayerViewBinding.playerTimeCurrent.setText(TimeUtils.stringForTime(j));
    }

    /* access modifiers changed from: private */
    public final void setSeekbarProgressTime(long j) {
        long j2 = this.mDuration;
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = null;
        int i = 0;
        if (j2 > 0) {
            i = (int) ((((float) j) * 100.0f) / ((float) j2));
            VodVideoPlayerViewBinding vodVideoPlayerViewBinding2 = this.binding;
            if (vodVideoPlayerViewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vodVideoPlayerViewBinding2 = null;
            }
            vodVideoPlayerViewBinding2.playerProgress.setProgress(i);
        } else {
            VodVideoPlayerViewBinding vodVideoPlayerViewBinding3 = this.binding;
            if (vodVideoPlayerViewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vodVideoPlayerViewBinding3 = null;
            }
            vodVideoPlayerViewBinding3.playerProgress.setProgress(0);
        }
        if (!this.mIsOpenHLSCache) {
            VodVideoPlayerViewBinding vodVideoPlayerViewBinding4 = this.binding;
            if (vodVideoPlayerViewBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vodVideoPlayerViewBinding4 = null;
            }
            vodVideoPlayerViewBinding4.playerProgress.setSecondaryProgress(i);
        }
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding5 = this.binding;
        if (vodVideoPlayerViewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vodVideoPlayerViewBinding = vodVideoPlayerViewBinding5;
        }
        vodVideoPlayerViewBinding.playerTimeCurrent.setText(TimeUtils.stringForTime(j));
    }

    /* access modifiers changed from: private */
    public final void playerSeek(long j) {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            iJKPlayer.seekTo(j, true);
        }
        setSeekbarProgressTime(j);
    }

    public static /* synthetic */ void setData$default(HwVodVideoPlayerView hwVodVideoPlayerView, String str, String str2, int i, List list, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        if ((i2 & 8) != 0) {
            list = null;
        }
        hwVodVideoPlayerView.setData(str, str2, i, list);
    }

    public final void setData(String str, String str2, int i, List<String> list) {
        this.mVideoName = str;
        if (str2 == null) {
            str2 = "";
        }
        this.mVideoPath = str2;
        this.mSwitchLineIndex = i;
        this.mSwitchLines = list;
    }

    public final void playUrl(String str) {
        IJKPlayer iJKPlayer;
        Intrinsics.checkNotNullParameter(str, "url");
        setPlayComplete(false);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = this.binding;
        if (vodVideoPlayerViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding = null;
        }
        vodVideoPlayerViewBinding.playerVideoName.setText(this.mVideoName);
        showPlayerLoading();
        setPauseSate(false);
        showControlBar(false);
        initPlayer();
        this.mVideoPath = str;
        IJKPlayer iJKPlayer2 = this.mPlayer;
        if (iJKPlayer2 != null) {
            iJKPlayer2.initPlayer(this.mListener);
        }
        IJKPlayer iJKPlayer3 = this.mPlayer;
        if (iJKPlayer3 != null) {
            iJKPlayer3.playFile(this.mVideoPath, (float) this.mCurrentPosition, 0, this.mVideoPlayerSceneType);
        }
        Surface surface = this.mSurface;
        if (surface != null && (iJKPlayer = this.mPlayer) != null) {
            iJKPlayer.setSurface(surface);
        }
    }

    public final void pausePlay() {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            if (iJKPlayer != null) {
                iJKPlayer.pausePlay();
            }
            setPauseSate(true);
        }
    }

    public final void resumePlay() {
        setPlayComplete(false);
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            if (iJKPlayer != null) {
                iJKPlayer.startPlay();
            }
            setPauseSate(false);
        }
    }

    public final void stopPlay() {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null && iJKPlayer != null) {
            iJKPlayer.stopPlay();
        }
    }

    public final void retryPlay() {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            if (iJKPlayer != null) {
                iJKPlayer.stopPlay();
            }
            playUrl(this.mVideoPath);
        }
    }

    public final void destroyPlayer() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            iJKPlayer.stopPlay();
        }
        IJKPlayer iJKPlayer2 = this.mPlayer;
        if (iJKPlayer2 != null) {
            iJKPlayer2.destroyPlayer();
        }
        this.mPlayer = null;
    }

    /* access modifiers changed from: private */
    public final void takePhoto() {
        VideoScreenShotDialog videoScreenShotDialog;
        VodPlayerListen vodPlayerListen = this.mVodPlayerListen;
        if (vodPlayerListen != null) {
            vodPlayerListen.onTakePhoto();
        }
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = this.binding;
        Unit unit = null;
        if (vodVideoPlayerViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding = null;
        }
        Bitmap bitmap = vodVideoPlayerViewBinding.payerSurfaceView.getBitmap();
        if (bitmap != null) {
            if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                if (this.mVideoScreenShotDialog == null) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    this.mVideoScreenShotDialog = new VideoScreenShotDialog(context);
                }
                VideoScreenShotDialog videoScreenShotDialog2 = this.mVideoScreenShotDialog;
                if ((videoScreenShotDialog2 != null && videoScreenShotDialog2.isShowing()) && (videoScreenShotDialog = this.mVideoScreenShotDialog) != null) {
                    videoScreenShotDialog.dismiss();
                }
                VideoScreenShotDialog videoScreenShotDialog3 = this.mVideoScreenShotDialog;
                if (videoScreenShotDialog3 != null) {
                    videoScreenShotDialog3.setShotBitmap(bitmap);
                }
                VideoScreenShotDialog videoScreenShotDialog4 = this.mVideoScreenShotDialog;
                if (videoScreenShotDialog4 != null) {
                    videoScreenShotDialog4.show();
                }
                String string = getContext().getString(R.string.player_save_screenshot_success);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…_save_screenshot_success)");
                ThreadUtils.getCachedPool(5).execute(new HwVodVideoPlayerView$$ExternalSyntheticLambda1(getSaveCameraDir(), "xueersiVideo" + System.currentTimeMillis() + ".jpg", bitmap, this, string));
                unit = Unit.INSTANCE;
            } else {
                return;
            }
        }
        if (unit == null) {
            HwVodVideoPlayerView hwVodVideoPlayerView = this;
            XesLog.i(TAG, new Object[]{"获取视频图像失败,bitmap为空"});
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: takePhoto$lambda-3$lambda-2  reason: not valid java name */
    public static final void m494takePhoto$lambda3$lambda2(File file, String str, Bitmap bitmap, HwVodVideoPlayerView hwVodVideoPlayerView, String str2) {
        Intrinsics.checkNotNullParameter(file, "$saveDir");
        Intrinsics.checkNotNullParameter(str, "$filename");
        Intrinsics.checkNotNullParameter(bitmap, "$it");
        Intrinsics.checkNotNullParameter(hwVodVideoPlayerView, "this$0");
        Intrinsics.checkNotNullParameter(str2, "$saveSuccess");
        File file2 = new File(file, str);
        boolean save = ImageUtils.save(bitmap, file2, Bitmap.CompressFormat.JPEG);
        Application app = Utils.getApp();
        Intrinsics.checkNotNullExpressionValue(app, "getApp()");
        String absolutePath = file2.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        hwVodVideoPlayerView.saveToGallery(app, absolutePath, str, str);
        if (save) {
            XesLog.i(TAG, new Object[]{"截屏成功"});
            ToastUtils.showLong(str2, new Object[0]);
            return;
        }
        XesLog.i(TAG, new Object[]{"保存图片失败"});
    }

    private final File getSaveCameraDir() {
        String str;
        File externalCacheDir = Utils.getApp().getExternalCacheDir();
        if (externalCacheDir == null) {
            str = Utils.getApp().getFilesDir().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(str, "{\n                Utils.…bsolutePath\n            }");
        } else {
            if (externalCacheDir.exists()) {
                str = externalCacheDir.getAbsolutePath();
            } else {
                str = Utils.getApp().getFilesDir().getAbsolutePath();
            }
            Intrinsics.checkNotNullExpressionValue(str, "{\n                if(ext…          }\n            }");
        }
        File file = new File(str, "xueersi/screenshots");
        if (!file.exists()) {
            file.mkdirs();
        }
        XesLog.i(TAG, new Object[]{Intrinsics.stringPlus("保存截图的目录为：", file.getAbsolutePath())});
        return file;
    }

    private final File getSystemCameraDir() {
        try {
            if (!TextUtils.equals("mounted", Environment.getExternalStorageState())) {
                return null;
            }
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            File file = new File(externalStoragePublicDirectory.getAbsolutePath() + File.separator + "Camera" + File.separator);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.exists()) {
                return file;
            }
            XesLog.i(TAG, new Object[]{"获取系统相机目录失败,目录不存在"});
            return null;
        } catch (Exception e) {
            XesLog.i(TAG, new Object[]{Intrinsics.stringPlus("获取系统相机目录失败=", e)});
            return null;
        }
    }

    private final void requestSavePermission() {
        if (PermissionUtils.isGranted(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"})) {
            XesLog.i(TAG, new Object[]{"已经获取了Sdcard存储权限，开始截图"});
            takePhoto();
            return;
        }
        XesLog.i(TAG, new Object[]{"未获取Sdcard存储权限，开始申请权限"});
        PermissionHelper permissionHelper = PermissionHelper.INSTANCE;
        FragmentActivity context = getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        permissionHelper.request(context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, new HwVodVideoPlayerView$requestSavePermission$1(this));
    }

    /* access modifiers changed from: private */
    public final String formatSpeed(long j, long j2) {
        if (j2 <= 0 || j <= 0) {
            return "0 B/s";
        }
        float f = (((float) j) * 1000.0f) / ((float) j2);
        if (f >= 1000000.0f) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            float f2 = (float) 1000;
            String format = String.format(Locale.US, "%.2f MB/s", Arrays.copyOf(new Object[]{Float.valueOf((f / f2) / f2)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
            return format;
        } else if (f >= 1000.0f) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(Locale.US, "%.1f KB/s", Arrays.copyOf(new Object[]{Float.valueOf(f / ((float) 1000))}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(locale, format, *args)");
            return format2;
        } else {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format(Locale.US, "%d B/s", Arrays.copyOf(new Object[]{Long.valueOf((long) f)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(locale, format, *args)");
            return format3;
        }
    }

    private final boolean saveToGallery(Context context, String str, String str2, String str3) {
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), str, str2, str3);
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(fromFile(new File(str)));
            context.sendBroadcast(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private final Uri fromFile(File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            Uri uriForFile = FileProvider.getUriForFile(getContext(), Intrinsics.stringPlus(getContext().getApplicationContext().getPackageName(), ".fileprovider"), file);
            Intrinsics.checkNotNullExpressionValue(uriForFile, "{\n            FileProvid…rovider\", file)\n        }");
            return uriForFile;
        }
        Uri fromFile = Uri.fromFile(file);
        Intrinsics.checkNotNullExpressionValue(fromFile, "{\n            Uri.fromFile(file)\n        }");
        return fromFile;
    }

    private final void execBackSeekAnimator(int i) {
        int i2 = -getResources().getDimensionPixelOffset(R.dimen.size_76dp);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = this.binding;
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding2 = null;
        if (vodVideoPlayerViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(vodVideoPlayerViewBinding.backSeekTextView, "translationX", new float[]{0.0f, (float) i2});
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding3 = this.binding;
        if (vodVideoPlayerViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vodVideoPlayerViewBinding2 = vodVideoPlayerViewBinding3;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(vodVideoPlayerViewBinding2.backSeekTextView, "alpha", new float[]{1.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.addListener(new HwVodVideoPlayerView$execBackSeekAnimator$1(this, i));
        animatorSet.setDuration(300);
        animatorSet.start();
        this.mHandler.removeMessages(102);
        this.mHandler.sendEmptyMessageDelayed(102, 1000);
    }

    /* access modifiers changed from: private */
    public final void resetBackSeekButton() {
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = this.binding;
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding2 = null;
        if (vodVideoPlayerViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(vodVideoPlayerViewBinding.backSeekTextView, "translationX", new float[]{0.0f});
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding3 = this.binding;
        if (vodVideoPlayerViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vodVideoPlayerViewBinding2 = vodVideoPlayerViewBinding3;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(vodVideoPlayerViewBinding2.backSeekTextView, "alpha", new float[]{1.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        this.mBackSeekIsStart = false;
        animatorSet.addListener(new HwVodVideoPlayerView$resetBackSeekButton$1(this));
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(100);
        animatorSet.start();
    }

    private final void execFrontSeekAnimator(int i) {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.size_76dp);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = this.binding;
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding2 = null;
        if (vodVideoPlayerViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(vodVideoPlayerViewBinding.frontSeekTextView, "translationX", new float[]{0.0f, (float) dimensionPixelOffset});
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding3 = this.binding;
        if (vodVideoPlayerViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vodVideoPlayerViewBinding2 = vodVideoPlayerViewBinding3;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(vodVideoPlayerViewBinding2.frontSeekTextView, "alpha", new float[]{1.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.addListener(new HwVodVideoPlayerView$execFrontSeekAnimator$1(this, i));
        animatorSet.setDuration(300);
        animatorSet.start();
        this.mHandler.removeMessages(101);
        this.mHandler.sendEmptyMessageDelayed(101, 1000);
    }

    /* access modifiers changed from: private */
    public final void resetFrontSeekButton() {
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = this.binding;
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding2 = null;
        if (vodVideoPlayerViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(vodVideoPlayerViewBinding.frontSeekTextView, "translationX", new float[]{0.0f});
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding3 = this.binding;
        if (vodVideoPlayerViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            vodVideoPlayerViewBinding2 = vodVideoPlayerViewBinding3;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(vodVideoPlayerViewBinding2.frontSeekTextView, "alpha", new float[]{1.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        this.mFrontSeekIsStart = false;
        animatorSet.addListener(new HwVodVideoPlayerView$resetFrontSeekButton$1(this));
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(100);
        animatorSet.start();
    }

    private final void showSwitchSpeed() {
        VideoSpeedSelectDialog videoSpeedSelectDialog;
        hideControlBar();
        if (this.mVideoSpeedSelectDialog == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.mVideoSpeedSelectDialog = new VideoSpeedSelectDialog(context, new HwVodVideoPlayerView$showSwitchSpeed$1(this));
        }
        VideoSpeedSelectDialog videoSpeedSelectDialog2 = this.mVideoSpeedSelectDialog;
        boolean z = false;
        if (videoSpeedSelectDialog2 != null && videoSpeedSelectDialog2.isShowing()) {
            z = true;
        }
        if (z && (videoSpeedSelectDialog = this.mVideoSpeedSelectDialog) != null) {
            videoSpeedSelectDialog.dismiss();
        }
        VideoSpeedSelectDialog videoSpeedSelectDialog3 = this.mVideoSpeedSelectDialog;
        if (videoSpeedSelectDialog3 != null) {
            videoSpeedSelectDialog3.show();
        }
    }

    private final void showSettingDialog() {
        VideoSettingDialog videoSettingDialog;
        hideControlBar();
        if (this.mVideoSettingDialog == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.mVideoSettingDialog = new VideoSettingDialog(context, new HwVodVideoPlayerView$showSettingDialog$1(this));
        }
        VideoSettingDialog videoSettingDialog2 = this.mVideoSettingDialog;
        boolean z = false;
        if (videoSettingDialog2 != null && videoSettingDialog2.isShowing()) {
            z = true;
        }
        if (z && (videoSettingDialog = this.mVideoSettingDialog) != null) {
            videoSettingDialog.dismiss();
        }
        VideoSettingDialog videoSettingDialog3 = this.mVideoSettingDialog;
        if (videoSettingDialog3 != null) {
            videoSettingDialog3.show();
        }
    }

    /* access modifiers changed from: private */
    public final void showSwitchLineDialog() {
        VideoSwitchLineDialog videoSwitchLineDialog;
        if (this.mSwitchLineDialog == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.mSwitchLineDialog = new VideoSwitchLineDialog(context, new HwVodVideoPlayerView$showSwitchLineDialog$1(this));
        }
        VideoSwitchLineDialog videoSwitchLineDialog2 = this.mSwitchLineDialog;
        boolean z = false;
        if (videoSwitchLineDialog2 != null && videoSwitchLineDialog2.isShowing()) {
            z = true;
        }
        if (z && (videoSwitchLineDialog = this.mSwitchLineDialog) != null) {
            videoSwitchLineDialog.dismiss();
        }
        List<String> list = this.mSwitchLines;
        if (list != null) {
            VideoSwitchLineDialog videoSwitchLineDialog3 = this.mSwitchLineDialog;
            if (videoSwitchLineDialog3 != null) {
                videoSwitchLineDialog3.setData(this.mSwitchLineIndex, list);
            }
            VideoSwitchLineDialog videoSwitchLineDialog4 = this.mSwitchLineDialog;
            if (videoSwitchLineDialog4 != null) {
                videoSwitchLineDialog4.show();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        if ((r3 - r7) < REPORT_DELAY_TIME) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showPlayNextVideoBtn() {
        /*
            r9 = this;
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView$VodPlayerListen r0 = r9.mVodPlayerListen
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
        L_0x0006:
            r0 = r2
            goto L_0x000f
        L_0x0008:
            boolean r0 = r0.isShowNextVideoButton()
            if (r0 != r1) goto L_0x0006
            r0 = r1
        L_0x000f:
            if (r0 == 0) goto L_0x0028
            long r3 = r9.mDuration
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0028
            long r7 = r9.mCurrentPosition
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0028
            long r3 = r3 - r7
            r5 = 60000(0xea60, double:2.9644E-319)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r1 = r2
        L_0x0029:
            r0 = 0
            java.lang.String r3 = "binding"
            if (r1 == 0) goto L_0x003d
            com.tal.app.thinkacademy.business.studycenter.databinding.VodVideoPlayerViewBinding r1 = r9.binding
            if (r1 != 0) goto L_0x0036
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x0037
        L_0x0036:
            r0 = r1
        L_0x0037:
            com.flyco.roundview.RoundTextView r0 = r0.playNextVideoBtn
            r0.setVisibility(r2)
            goto L_0x004d
        L_0x003d:
            com.tal.app.thinkacademy.business.studycenter.databinding.VodVideoPlayerViewBinding r1 = r9.binding
            if (r1 != 0) goto L_0x0045
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x0046
        L_0x0045:
            r0 = r1
        L_0x0046:
            com.flyco.roundview.RoundTextView r0 = r0.playNextVideoBtn
            r1 = 8
            r0.setVisibility(r1)
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView.showPlayNextVideoBtn():void");
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, HwVodVideoPlayerView.class);
        if (CommonUtilsKt.isFastClick()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            MethodInfo.onClickEventEnd();
            return;
        }
        boolean z = false;
        showControlBar(false);
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding = this.binding;
        VodVideoPlayerViewBinding vodVideoPlayerViewBinding2 = null;
        if (vodVideoPlayerViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            vodVideoPlayerViewBinding = null;
        }
        long j = 0;
        if (Intrinsics.areEqual((Object) view, (Object) vodVideoPlayerViewBinding.backSeekBtn)) {
            IJKPlayer iJKPlayer = this.mPlayer;
            if (!(iJKPlayer != null && iJKPlayer.isInit())) {
                XesLog.i(TAG, new Object[]{"播放器还没准备好"});
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
                return;
            }
            long j2 = this.mDuration;
            if (j2 <= 0) {
                XesLog.i(TAG, new Object[]{Intrinsics.stringPlus("视频时长=", Long.valueOf(j2))});
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
                return;
            }
            long j3 = this.mCurrentPosition - ((long) 10000);
            if (j3 >= 0) {
                j = j3;
            }
            playerSeek(j);
            this.mBackSeekIsStart = true;
            int i = this.mBackSeekCount + 10;
            this.mBackSeekCount = i;
            execBackSeekAnimator(i);
            XesLog.i(TAG, new Object[]{"点击播放器快退"});
        } else {
            VodVideoPlayerViewBinding vodVideoPlayerViewBinding3 = this.binding;
            if (vodVideoPlayerViewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                vodVideoPlayerViewBinding3 = null;
            }
            if (Intrinsics.areEqual((Object) view, (Object) vodVideoPlayerViewBinding3.switchSpeedBtn)) {
                showSwitchSpeed();
                XesLog.i(TAG, new Object[]{"点击播放器切换倍速"});
            } else {
                VodVideoPlayerViewBinding vodVideoPlayerViewBinding4 = this.binding;
                if (vodVideoPlayerViewBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    vodVideoPlayerViewBinding4 = null;
                }
                if (Intrinsics.areEqual((Object) view, (Object) vodVideoPlayerViewBinding4.reloadButton)) {
                    hideError();
                    retryPlay();
                    XesLog.i(TAG, new Object[]{"点击播放器失败重试按钮"});
                } else {
                    VodVideoPlayerViewBinding vodVideoPlayerViewBinding5 = this.binding;
                    if (vodVideoPlayerViewBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        vodVideoPlayerViewBinding5 = null;
                    }
                    if (Intrinsics.areEqual((Object) view, (Object) vodVideoPlayerViewBinding5.playerFunctionMore)) {
                        showSettingDialog();
                        XesLog.i(TAG, new Object[]{"点击更多"});
                    } else {
                        VodVideoPlayerViewBinding vodVideoPlayerViewBinding6 = this.binding;
                        if (vodVideoPlayerViewBinding6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            vodVideoPlayerViewBinding6 = null;
                        }
                        if (Intrinsics.areEqual((Object) view, (Object) vodVideoPlayerViewBinding6.playNextVideoBtn)) {
                            VodPlayerListen vodPlayerListen = this.mVodPlayerListen;
                            if (vodPlayerListen != null) {
                                vodPlayerListen.onNextVideoButtonClick();
                            }
                            XesLog.i(TAG, new Object[]{"点击播放下一个"});
                        } else {
                            VodVideoPlayerViewBinding vodVideoPlayerViewBinding7 = this.binding;
                            if (vodVideoPlayerViewBinding7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                vodVideoPlayerViewBinding7 = null;
                            }
                            if (Intrinsics.areEqual((Object) view, (Object) vodVideoPlayerViewBinding7.frontSeekBtn)) {
                                IJKPlayer iJKPlayer2 = this.mPlayer;
                                if (!(iJKPlayer2 != null && iJKPlayer2.isInit())) {
                                    XesLog.i(TAG, new Object[]{"播放器还没准备好"});
                                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                                    MethodInfo.onClickEventEnd();
                                    return;
                                }
                                long j4 = this.mDuration;
                                if (j4 <= 0) {
                                    XesLog.i(TAG, new Object[]{Intrinsics.stringPlus("视频时长=", Long.valueOf(j4))});
                                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                                    MethodInfo.onClickEventEnd();
                                    return;
                                }
                                long j5 = this.mCurrentPosition + ((long) 10000);
                                if (j5 > j4) {
                                    j5 = j4 - 1;
                                }
                                playerSeek(j5);
                                this.mFrontSeekIsStart = true;
                                int i2 = this.mFrontSeekCount + 10;
                                this.mFrontSeekCount = i2;
                                execFrontSeekAnimator(i2);
                                XesLog.i(TAG, new Object[]{"点击播放器快进"});
                            } else {
                                VodVideoPlayerViewBinding vodVideoPlayerViewBinding8 = this.binding;
                                if (vodVideoPlayerViewBinding8 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                                    vodVideoPlayerViewBinding8 = null;
                                }
                                if (Intrinsics.areEqual((Object) view, (Object) vodVideoPlayerViewBinding8.takePhoto)) {
                                    XesLog.i(TAG, new Object[]{"点击播放器截屏"});
                                    requestSavePermission();
                                } else {
                                    VodVideoPlayerViewBinding vodVideoPlayerViewBinding9 = this.binding;
                                    if (vodVideoPlayerViewBinding9 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                                        vodVideoPlayerViewBinding9 = null;
                                    }
                                    if (Intrinsics.areEqual((Object) view, (Object) vodVideoPlayerViewBinding9.playerBackBtn)) {
                                        VodPlayerListen vodPlayerListen2 = this.mVodPlayerListen;
                                        if (vodPlayerListen2 != null) {
                                            vodPlayerListen2.onExit();
                                        }
                                        if (getContext() instanceof Activity) {
                                            Context context = getContext();
                                            if (context != null) {
                                                ((Activity) context).finish();
                                            } else {
                                                NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
                                                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                                                MethodInfo.onClickEventEnd();
                                                throw nullPointerException;
                                            }
                                        }
                                    } else {
                                        VodVideoPlayerViewBinding vodVideoPlayerViewBinding10 = this.binding;
                                        if (vodVideoPlayerViewBinding10 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                                            vodVideoPlayerViewBinding10 = null;
                                        }
                                        if (Intrinsics.areEqual((Object) view, (Object) vodVideoPlayerViewBinding10.playerPlayBtn)) {
                                            if (this.mVideoPath.length() == 0) {
                                                z = true;
                                            }
                                            if (z) {
                                                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                                                MethodInfo.onClickEventEnd();
                                                return;
                                            }
                                            VodVideoPlayerViewBinding vodVideoPlayerViewBinding11 = this.binding;
                                            if (vodVideoPlayerViewBinding11 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                            } else {
                                                vodVideoPlayerViewBinding2 = vodVideoPlayerViewBinding11;
                                            }
                                            if (vodVideoPlayerViewBinding2.errorLayout.getVisibility() == 0) {
                                                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                                                MethodInfo.onClickEventEnd();
                                                return;
                                            } else if (!this.mIsOnPause) {
                                                pausePlay();
                                            } else if (this.mPlayer == null) {
                                                playUrl(this.mVideoPath);
                                            } else if (this.mIsError) {
                                                retryPlay();
                                            } else {
                                                resumePlay();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    /* access modifiers changed from: private */
    public final void setPlayComplete(boolean z) {
        this.mIsPlayComplete = z;
        XesLog.i(TAG, new Object[]{Intrinsics.stringPlus("setPlayComplete = ", Boolean.valueOf(z))});
    }

    public final boolean getIsPlayComplete() {
        return this.mIsPlayComplete;
    }

    /* access modifiers changed from: private */
    public final void checkIsNeedReport() {
        int i = (int) ((this.mCurrentPosition / ((long) ONE_MINUTE_TIME)) + 1);
        if (i != this.mLastReportMinute) {
            VodPlayerListen vodPlayerListen = this.mVodPlayerListen;
            if (vodPlayerListen != null) {
                vodPlayerListen.reportData(i);
            }
            this.mLastReportMinute = i;
        }
    }
}
