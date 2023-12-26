package com.tal.app.thinkacademy.common.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.common.databinding.CommonHwPlayerLayoutBinding;
import com.tal.app.thinkacademy.common.utils.CommonUtilsKt;
import com.tal.app.thinkacademy.lib.imageloader.ImageRequestListener;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.progress.OnProgressListener;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayListener;
import com.tal.app.thinkacademy.lib.player.ijkplayer.IJKPlayer;
import com.tal.app.thinkacademy.lib.player.track.VideoPlayerSceneType;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u0000 :2\u00020\u0001:\u0002:;B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020'H\u0002J\u0006\u0010*\u001a\u00020'J\u000e\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\nJ\u0006\u0010-\u001a\u00020'J\b\u0010.\u001a\u00020'H\u0002J\u0010\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020\fH\u0002J\u0016\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nJ\u0010\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020\u0017H\u0002J\u0010\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\u0017H\u0002J\u000e\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020%J\b\u00109\u001a\u00020'H\u0002R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/tal/app/thinkacademy/common/widget/HwPlayerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/tal/app/thinkacademy/common/databinding/CommonHwPlayerLayoutBinding;", "mCoverUrl", "", "mCurrentPosition", "", "mDuration", "mHolder", "Landroid/view/SurfaceHolder;", "mHwPayerViewListen", "Lcom/tal/app/thinkacademy/common/widget/HwPlayerView$HwPayerViewListen;", "getMHwPayerViewListen", "()Lcom/tal/app/thinkacademy/common/widget/HwPlayerView$HwPayerViewListen;", "setMHwPayerViewListen", "(Lcom/tal/app/thinkacademy/common/widget/HwPlayerView$HwPayerViewListen;)V", "mIsError", "", "mIsOnPause", "getMIsOnPause", "()Z", "setMIsOnPause", "(Z)V", "mListener", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IJKPlayListener;", "mPlayer", "Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IJKPlayer;", "mSurface", "Landroid/view/Surface;", "mVideoPath", "mVideoPlayerSceneType", "Lcom/tal/app/thinkacademy/lib/player/track/VideoPlayerSceneType;", "destroyPlayer", "", "hidePlayerLoading", "initPlayer", "pausePlay", "playUrl", "url", "resumePlay", "retryPlay", "setBottomProgressBar", "time", "setData", "coverUrl", "setErrorState", "isError", "setPauseSate", "isPause", "setVideoPlayerSceneType", "videoPlayerSceneType", "showPlayerLoading", "Companion", "HwPayerViewListen", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwPlayerView.kt */
public final class HwPlayerView extends FrameLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "HwPlayerView";
    /* access modifiers changed from: private */
    public CommonHwPlayerLayoutBinding binding;
    private String mCoverUrl;
    /* access modifiers changed from: private */
    public long mCurrentPosition;
    /* access modifiers changed from: private */
    public long mDuration;
    private SurfaceHolder mHolder;
    private HwPayerViewListen mHwPayerViewListen;
    private boolean mIsError;
    private boolean mIsOnPause;
    private final IJKPlayListener mListener;
    /* access modifiers changed from: private */
    public IJKPlayer mPlayer;
    /* access modifiers changed from: private */
    public Surface mSurface;
    private String mVideoPath;
    private VideoPlayerSceneType mVideoPlayerSceneType;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/common/widget/HwPlayerView$HwPayerViewListen;", "", "playBtnClick", "", "isPlay", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HwPlayerView.kt */
    public interface HwPayerViewListen {
        void playBtnClick(boolean z);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HwPlayerView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HwPlayerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/common/widget/HwPlayerView$Companion;", "", "()V", "TAG", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HwPlayerView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HwPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsOnPause = true;
        this.mVideoPath = "";
        this.mCoverUrl = "";
        this.mListener = new HwPlayerView$mListener$1(this);
        LayoutInflater from = LayoutInflater.from(context);
        int i = R.layout.common_hw_player_layout;
        ViewGroup viewGroup = this;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(from, i, viewGroup, false);
        addView(inflate);
        CommonHwPlayerLayoutBinding bind = CommonHwPlayerLayoutBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(view)");
        this.binding = bind;
        if (bind == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bind = null;
        }
        bind.payerSurfaceView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener(this) {
            final /* synthetic */ HwPlayerView this$0;

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                Intrinsics.checkNotNullParameter(surfaceTexture, "surface");
            }

            {
                this.this$0 = r1;
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                IJKPlayer access$getMPlayer$p;
                Intrinsics.checkNotNullParameter(surfaceTexture, "surface");
                XesLog.dt(HwPlayerView.TAG, "onSurfaceTextureAvailable");
                this.this$0.mSurface = new Surface(surfaceTexture);
                Surface access$getMSurface$p = this.this$0.mSurface;
                if (access$getMSurface$p != null && (access$getMPlayer$p = this.this$0.mPlayer) != null) {
                    access$getMPlayer$p.setSurface(access$getMSurface$p);
                }
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                Intrinsics.checkNotNullParameter(surfaceTexture, "surface");
                XesLog.dt(HwPlayerView.TAG, "onSurfaceTextureSizeChanged width=" + i + ",height=" + i2);
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                Intrinsics.checkNotNullParameter(surfaceTexture, "surface");
                XesLog.dt(HwPlayerView.TAG, "onSurfaceTextureDestroyed");
                IJKPlayer access$getMPlayer$p = this.this$0.mPlayer;
                if (access$getMPlayer$p != null) {
                    access$getMPlayer$p.releaseSurface();
                }
                return false;
            }
        });
        setOnClickListener(new HwPlayerView$$ExternalSyntheticLambda0(this));
    }

    public final boolean getMIsOnPause() {
        return this.mIsOnPause;
    }

    public final void setMIsOnPause(boolean z) {
        this.mIsOnPause = z;
    }

    public final HwPayerViewListen getMHwPayerViewListen() {
        return this.mHwPayerViewListen;
    }

    public final void setMHwPayerViewListen(HwPayerViewListen hwPayerViewListen) {
        this.mHwPayerViewListen = hwPayerViewListen;
    }

    public final void setVideoPlayerSceneType(VideoPlayerSceneType videoPlayerSceneType) {
        Intrinsics.checkNotNullParameter(videoPlayerSceneType, "videoPlayerSceneType");
        this.mVideoPlayerSceneType = videoPlayerSceneType;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m60_init_$lambda0(HwPlayerView hwPlayerView, View view) {
        Intrinsics.checkNotNullParameter(hwPlayerView, "this$0");
        if (CommonUtilsKt.isFastClick()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (hwPlayerView.mVideoPath.length() == 0) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        HwPayerViewListen hwPayerViewListen = hwPlayerView.mHwPayerViewListen;
        if (hwPayerViewListen != null) {
            hwPayerViewListen.playBtnClick(true ^ hwPlayerView.mIsOnPause);
        }
        if (!hwPlayerView.mIsOnPause) {
            hwPlayerView.pausePlay();
        } else {
            CommonHwPlayerLayoutBinding commonHwPlayerLayoutBinding = hwPlayerView.binding;
            if (commonHwPlayerLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                commonHwPlayerLayoutBinding = null;
            }
            commonHwPlayerLayoutBinding.imageCover.setVisibility(8);
            if (hwPlayerView.mPlayer == null) {
                hwPlayerView.playUrl(hwPlayerView.mVideoPath);
            } else if (hwPlayerView.mIsError) {
                hwPlayerView.retryPlay();
            } else {
                hwPlayerView.resumePlay();
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
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
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.widget.HwPlayerView.initPlayer():void");
    }

    /* access modifiers changed from: private */
    public final void showPlayerLoading() {
        CommonHwPlayerLayoutBinding commonHwPlayerLayoutBinding = this.binding;
        if (commonHwPlayerLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            commonHwPlayerLayoutBinding = null;
        }
        commonHwPlayerLayoutBinding.playerLoading.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void hidePlayerLoading() {
        CommonHwPlayerLayoutBinding commonHwPlayerLayoutBinding = this.binding;
        if (commonHwPlayerLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            commonHwPlayerLayoutBinding = null;
        }
        commonHwPlayerLayoutBinding.playerLoading.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void setErrorState(boolean z) {
        this.mIsError = z;
        if (z) {
            ToastUtils.showLong(R.string.common_player_error_msg);
            pausePlay();
        }
    }

    /* access modifiers changed from: private */
    public final void setPauseSate(boolean z) {
        if (this.mIsOnPause != z) {
            this.mIsOnPause = z;
            CommonHwPlayerLayoutBinding commonHwPlayerLayoutBinding = null;
            if (z) {
                CommonHwPlayerLayoutBinding commonHwPlayerLayoutBinding2 = this.binding;
                if (commonHwPlayerLayoutBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    commonHwPlayerLayoutBinding2 = null;
                }
                commonHwPlayerLayoutBinding2.playBtn.setVisibility(0);
                CommonHwPlayerLayoutBinding commonHwPlayerLayoutBinding3 = this.binding;
                if (commonHwPlayerLayoutBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    commonHwPlayerLayoutBinding = commonHwPlayerLayoutBinding3;
                }
                commonHwPlayerLayoutBinding.playBtn.setImageResource(R.drawable.common_player_play_icon);
                return;
            }
            CommonHwPlayerLayoutBinding commonHwPlayerLayoutBinding4 = this.binding;
            if (commonHwPlayerLayoutBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                commonHwPlayerLayoutBinding = commonHwPlayerLayoutBinding4;
            }
            commonHwPlayerLayoutBinding.playBtn.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void setBottomProgressBar(long j) {
        long j2 = this.mDuration;
        int i = j2 > 0 ? (int) ((((float) j) * 100.0f) / ((float) j2)) : 0;
        CommonHwPlayerLayoutBinding commonHwPlayerLayoutBinding = this.binding;
        if (commonHwPlayerLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            commonHwPlayerLayoutBinding = null;
        }
        commonHwPlayerLayoutBinding.bottomProgressbar.setProgress(i);
    }

    public final void setData(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str3, "coverUrl");
        Intrinsics.checkNotNullParameter(str4, "url");
        this.mCoverUrl = str3;
        this.mVideoPath = str4;
        boolean z = true;
        CommonHwPlayerLayoutBinding commonHwPlayerLayoutBinding = null;
        if (str4.length() == 0) {
            CommonHwPlayerLayoutBinding commonHwPlayerLayoutBinding2 = this.binding;
            if (commonHwPlayerLayoutBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                commonHwPlayerLayoutBinding2 = null;
            }
            commonHwPlayerLayoutBinding2.playBtn.setVisibility(8);
        } else {
            CommonHwPlayerLayoutBinding commonHwPlayerLayoutBinding3 = this.binding;
            if (commonHwPlayerLayoutBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                commonHwPlayerLayoutBinding3 = null;
            }
            commonHwPlayerLayoutBinding3.playBtn.setVisibility(0);
        }
        if (str3.length() != 0) {
            z = false;
        }
        if (z) {
            this.mCoverUrl = this.mVideoPath;
            XesImageLoader xesImageLoader = XesImageLoader.INSTANCE;
            CommonHwPlayerLayoutBinding commonHwPlayerLayoutBinding4 = this.binding;
            if (commonHwPlayerLayoutBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                commonHwPlayerLayoutBinding = commonHwPlayerLayoutBinding4;
            }
            ImageView imageView = commonHwPlayerLayoutBinding.imageCover;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageCover");
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            XesImageLoader.loadImageNormal$default(xesImageLoader, imageView, context, this.mCoverUrl, R.drawable.bg_default_image, (OnProgressListener) null, (ImageRequestListener) null, 24, (Object) null);
            return;
        }
        XesImageLoader xesImageLoader2 = XesImageLoader.INSTANCE;
        CommonHwPlayerLayoutBinding commonHwPlayerLayoutBinding5 = this.binding;
        if (commonHwPlayerLayoutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            commonHwPlayerLayoutBinding = commonHwPlayerLayoutBinding5;
        }
        ImageView imageView2 = commonHwPlayerLayoutBinding.imageCover;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.imageCover");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        XesImageLoader.loadImage$default(xesImageLoader2, imageView2, context2, this.mCoverUrl, R.drawable.bg_default_image, (OnProgressListener) null, (ImageRequestListener) null, 24, (Object) null);
    }

    public final void playUrl(String str) {
        IJKPlayer iJKPlayer;
        IJKPlayer iJKPlayer2;
        Intrinsics.checkNotNullParameter(str, "url");
        showPlayerLoading();
        setPauseSate(false);
        initPlayer();
        this.mVideoPath = str;
        IJKPlayer iJKPlayer3 = this.mPlayer;
        if (iJKPlayer3 != null) {
            iJKPlayer3.initPlayer(this.mListener);
        }
        IJKPlayer iJKPlayer4 = this.mPlayer;
        if (iJKPlayer4 != null) {
            iJKPlayer4.seekToAccurate();
        }
        IJKPlayer iJKPlayer5 = this.mPlayer;
        if (iJKPlayer5 != null) {
            iJKPlayer5.playFile(this.mVideoPath, (float) this.mCurrentPosition, 0, this.mVideoPlayerSceneType);
        }
        SurfaceHolder surfaceHolder = this.mHolder;
        if (!(surfaceHolder == null || (iJKPlayer2 = this.mPlayer) == null)) {
            iJKPlayer2.setSurfaceHolder(surfaceHolder);
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
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            if (iJKPlayer != null) {
                iJKPlayer.startPlay();
            }
            setPauseSate(false);
        }
    }

    private final void retryPlay() {
        IJKPlayer iJKPlayer = this.mPlayer;
        if (iJKPlayer != null) {
            if (iJKPlayer != null) {
                iJKPlayer.stopPlay();
            }
            playUrl(this.mVideoPath);
        }
    }

    public final void destroyPlayer() {
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
}
