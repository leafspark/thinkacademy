package com.tal.app.thinkacademy.business.study.study.vodplayer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.tal.app.thinkacademy.business.study.study.Tag;
import com.tal.app.thinkacademy.business.studycenter.databinding.HwCommonPlayerActivityBinding;
import com.tal.app.thinkacademy.common.base.BaseBindActivity;
import com.tal.app.thinkacademy.common.business.AppVersionBll;
import com.tal.app.thinkacademy.common.entity.HwCommonPlayerParams;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.commui.widget.pad.NotPadAutoScreen;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.track.VideoPlayerSceneType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\rH\u0014J\b\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u00020!H\u0002J\b\u0010(\u001a\u00020!H\u0016J\u0012\u0010)\u001a\u00020!2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\b\u0010,\u001a\u00020!H\u0014J\b\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020!H\u0014J\b\u0010/\u001a\u00020!H\u0014J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\rH\u0002J\b\u00102\u001a\u00020!H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vodplayer/HwCommonPlayerActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseBindActivity;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/HwCommonPlayerActivityBinding;", "()V", "mCommonPlayerParams", "Lcom/tal/app/thinkacademy/common/entity/HwCommonPlayerParams;", "getMCommonPlayerParams", "()Lcom/tal/app/thinkacademy/common/entity/HwCommonPlayerParams;", "setMCommonPlayerParams", "(Lcom/tal/app/thinkacademy/common/entity/HwCommonPlayerParams;)V", "mHandler", "Landroid/os/Handler;", "mIsNeedResumePlay", "", "mOneMinuteRunnable", "Ljava/lang/Runnable;", "mPlayerSceneType", "Lcom/tal/app/thinkacademy/lib/player/track/VideoPlayerSceneType;", "getMPlayerSceneType", "()Lcom/tal/app/thinkacademy/lib/player/track/VideoPlayerSceneType;", "setMPlayerSceneType", "(Lcom/tal/app/thinkacademy/lib/player/track/VideoPlayerSceneType;)V", "mStartPosition", "", "mSwitchLineIndex", "", "mSwitchLines", "", "", "mUid", "mUrl", "mVideoName", "convertResourceData", "", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "initData", "loopSendReport", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onExitPlayer", "onPause", "onResume", "saveStartPosition", "isPlayComplete", "setStartPosition", "Companion", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@NotPadAutoScreen
/* compiled from: HwCommonPlayerActivity.kt */
public final class HwCommonPlayerActivity extends BaseBindActivity<HwCommonPlayerActivityBinding> {
    public static final String COMMON_PLAYER_PARAMS = "common_player_params";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.COMMON_PLAYER_PLAY;
    private HwCommonPlayerParams mCommonPlayerParams;
    private final Handler mHandler;
    private boolean mIsNeedResumePlay;
    private final Runnable mOneMinuteRunnable;
    private VideoPlayerSceneType mPlayerSceneType = VideoPlayerSceneType.UNKNOWN;
    private long mStartPosition;
    private int mSwitchLineIndex;
    private List<String> mSwitchLines;
    private String mUid;
    private String mUrl;
    private String mVideoName;

    public HwCommonPlayerActivity() {
        String uid;
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        String str = "";
        if (!(userInfoEntity == null || (uid = userInfoEntity.getUid()) == null)) {
            str = uid;
        }
        this.mUid = str;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mOneMinuteRunnable = new HwCommonPlayerActivity$mOneMinuteRunnable$1();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vodplayer/HwCommonPlayerActivity$Companion;", "", "()V", "COMMON_PLAYER_PARAMS", "", "TAG", "Lcom/tal/app/thinkacademy/business/study/study/Tag;", "startActivity", "", "context", "Landroid/content/Context;", "params", "Lcom/tal/app/thinkacademy/common/entity/HwCommonPlayerParams;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HwCommonPlayerActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startActivity(Context context, HwCommonPlayerParams hwCommonPlayerParams) {
            Unit unit;
            Intrinsics.checkNotNullParameter(hwCommonPlayerParams, "params");
            if (context == null) {
                unit = null;
            } else {
                Intent intent = new Intent(context, VideoPlayerClassActivity.class);
                intent.putExtra(HwCommonPlayerActivity.COMMON_PLAYER_PARAMS, (Serializable) hwCommonPlayerParams);
                context.startActivity(intent);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                Companion companion = this;
                XesLog.i(HwCommonPlayerActivity.TAG, new Object[]{"startActivity error:context is null"});
            }
        }
    }

    public final HwCommonPlayerParams getMCommonPlayerParams() {
        return this.mCommonPlayerParams;
    }

    public final void setMCommonPlayerParams(HwCommonPlayerParams hwCommonPlayerParams) {
        this.mCommonPlayerParams = hwCommonPlayerParams;
    }

    public final VideoPlayerSceneType getMPlayerSceneType() {
        return this.mPlayerSceneType;
    }

    public final void setMPlayerSceneType(VideoPlayerSceneType videoPlayerSceneType) {
        Intrinsics.checkNotNullParameter(videoPlayerSceneType, "<set-?>");
        this.mPlayerSceneType = videoPlayerSceneType;
    }

    private final void loopSendReport() {
        this.mHandler.removeCallbacks(this.mOneMinuteRunnable);
        this.mHandler.postDelayed(this.mOneMinuteRunnable, 60000);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        HwCommonPlayerActivity.super.onCreate(bundle);
        initData();
        getBinding().playerView.setVideoPlayerSceneType(this.mPlayerSceneType);
        convertResourceData();
        getBinding().playerView.setVodPlayerListen(new HwCommonPlayerActivity$onCreate$1(this));
        getBinding().playerView.setMIsOpenHLSCache(false);
        XesLog.i(TAG, new Object[]{Intrinsics.stringPlus("是否打开缓存=", Boolean.valueOf(getBinding().playerView.getMIsOpenHLSCache()))});
        getBinding().playerView.setData(this.mVideoName, this.mUrl, this.mSwitchLineIndex, this.mSwitchLines);
        HwVodVideoPlayerView hwVodVideoPlayerView = getBinding().playerView;
        String str = this.mUrl;
        if (str == null) {
            str = "";
        }
        hwVodVideoPlayerView.playUrl(str);
        loopSendReport();
        AppVersionBll.Companion.getInstance().cancelUpdate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        if (r2 != null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
        if (r2 == null) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setStartPosition() {
        /*
            r8 = this;
            r0 = 0
            r8.mStartPosition = r0
            java.lang.String r2 = r8.mUrl
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0015
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r2 = r4
            goto L_0x0016
        L_0x0015:
            r2 = r3
        L_0x0016:
            if (r2 != 0) goto L_0x0076
            java.lang.String r2 = r8.mUrl
            r5 = 2
            if (r2 != 0) goto L_0x001f
        L_0x001d:
            r2 = r4
            goto L_0x0029
        L_0x001f:
            r6 = 0
            java.lang.String r7 = "http"
            boolean r2 = kotlin.text.StringsKt.startsWith$default(r2, r7, r4, r5, r6)
            if (r2 != r3) goto L_0x001d
            r2 = r3
        L_0x0029:
            java.lang.String r6 = ""
            if (r2 == 0) goto L_0x003e
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x0039 }
            java.lang.String r7 = r8.mUrl     // Catch:{ Exception -> 0x0039 }
            r2.<init>(r7)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r2 = r2.getFile()     // Catch:{ Exception -> 0x0039 }
            goto L_0x0043
        L_0x0039:
            java.lang.String r2 = r8.mUrl
            if (r2 != 0) goto L_0x0043
            goto L_0x0044
        L_0x003e:
            java.lang.String r2 = r8.mUrl
            if (r2 != 0) goto L_0x0043
            goto L_0x0044
        L_0x0043:
            r6 = r2
        L_0x0044:
            kotlin.jvm.internal.StringCompanionObject r2 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r2 = new java.lang.Object[r5]
            java.lang.String r7 = r8.mUid
            r2[r4] = r7
            r2[r3] = r6
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r5)
            java.lang.String r3 = "%s-%s"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            java.lang.String r3 = "format(format, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r3 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r4 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_CAN_CLEAR
            long r0 = r3.getLong(r2, r0, r4)
            r8.mStartPosition = r0
            androidx.viewbinding.ViewBinding r0 = r8.getBinding()
            com.tal.app.thinkacademy.business.studycenter.databinding.HwCommonPlayerActivityBinding r0 = (com.tal.app.thinkacademy.business.studycenter.databinding.HwCommonPlayerActivityBinding) r0
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView r0 = r0.playerView
            long r1 = r8.mStartPosition
            r0.setMCurrentPosition(r1)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.vodplayer.HwCommonPlayerActivity.setStartPosition():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0048, code lost:
        if (r8 != null) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004d, code lost:
        if (r8 == null) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void saveStartPosition(boolean r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x0005
            r0 = 0
            goto L_0x0011
        L_0x0005:
            androidx.viewbinding.ViewBinding r8 = r7.getBinding()
            com.tal.app.thinkacademy.business.studycenter.databinding.HwCommonPlayerActivityBinding r8 = (com.tal.app.thinkacademy.business.studycenter.databinding.HwCommonPlayerActivityBinding) r8
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView r8 = r8.playerView
            long r0 = r8.getMCurrentPosition()
        L_0x0011:
            java.lang.String r8 = r7.mUrl
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r2 = 1
            r3 = 0
            if (r8 == 0) goto L_0x0022
            int r8 = r8.length()
            if (r8 != 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r8 = r3
            goto L_0x0023
        L_0x0022:
            r8 = r2
        L_0x0023:
            if (r8 != 0) goto L_0x0073
            java.lang.String r8 = r7.mUrl
            r4 = 2
            if (r8 != 0) goto L_0x002c
        L_0x002a:
            r8 = r3
            goto L_0x0036
        L_0x002c:
            r5 = 0
            java.lang.String r6 = "http"
            boolean r8 = kotlin.text.StringsKt.startsWith$default(r8, r6, r3, r4, r5)
            if (r8 != r2) goto L_0x002a
            r8 = r2
        L_0x0036:
            java.lang.String r5 = ""
            if (r8 == 0) goto L_0x004b
            java.net.URL r8 = new java.net.URL     // Catch:{ Exception -> 0x0046 }
            java.lang.String r6 = r7.mUrl     // Catch:{ Exception -> 0x0046 }
            r8.<init>(r6)     // Catch:{ Exception -> 0x0046 }
            java.lang.String r8 = r8.getFile()     // Catch:{ Exception -> 0x0046 }
            goto L_0x0050
        L_0x0046:
            java.lang.String r8 = r7.mUrl
            if (r8 != 0) goto L_0x0050
            goto L_0x0051
        L_0x004b:
            java.lang.String r8 = r7.mUrl
            if (r8 != 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r5 = r8
        L_0x0051:
            kotlin.jvm.internal.StringCompanionObject r8 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r8 = new java.lang.Object[r4]
            java.lang.String r6 = r7.mUid
            r8[r3] = r6
            r8[r2] = r5
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r4)
            java.lang.String r2 = "%s-%s"
            java.lang.String r8 = java.lang.String.format(r2, r8)
            java.lang.String r2 = "format(format, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r3 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_CAN_CLEAR
            r2.put(r8, r0, r3)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.vodplayer.HwCommonPlayerActivity.saveStartPosition(boolean):void");
    }

    private final void convertResourceData() {
        HwCommonPlayerParams hwCommonPlayerParams = this.mCommonPlayerParams;
        if (hwCommonPlayerParams != null) {
            this.mUrl = "";
            this.mVideoName = hwCommonPlayerParams.getVideoName();
            this.mSwitchLines = new ArrayList();
            try {
                List urls = hwCommonPlayerParams.getUrls();
                if (urls != null) {
                    int i = 0;
                    for (Object next : urls) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        String str = (String) next;
                        if (i == 0) {
                            this.mUrl = str;
                        }
                        List<String> list = this.mSwitchLines;
                        if (list != null) {
                            list.add(str);
                        }
                        i = i2;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e) {
                XesLog.i(TAG, new Object[]{Intrinsics.stringPlus("convertResourceData error = ", e)});
                Unit unit2 = Unit.INSTANCE;
            }
        }
        setStartPosition();
        XesLog.i(TAG, new Object[]{"convertResourceData,即将播放的url=" + this.mUrl + ",position=" + this.mStartPosition});
    }

    private final void initData() {
        HwCommonPlayerParams hwCommonPlayerParams;
        VideoPlayerSceneType videoPlayerSceneType = null;
        try {
            Serializable serializableExtra = getIntent().getSerializableExtra(COMMON_PLAYER_PARAMS);
            if (serializableExtra != null) {
                hwCommonPlayerParams = (HwCommonPlayerParams) serializableExtra;
                this.mCommonPlayerParams = hwCommonPlayerParams;
                if (hwCommonPlayerParams != null) {
                    videoPlayerSceneType = hwCommonPlayerParams.getSceneType();
                }
                if (videoPlayerSceneType == null) {
                    videoPlayerSceneType = VideoPlayerSceneType.UNKNOWN;
                }
                this.mPlayerSceneType = videoPlayerSceneType;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tal.app.thinkacademy.common.entity.HwCommonPlayerParams");
        } catch (Exception unused) {
            hwCommonPlayerParams = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        HwCommonPlayerActivity.super.onResume();
        if (this.mIsNeedResumePlay) {
            getBinding().playerView.resumePlay();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        HwCommonPlayerActivity.super.onPause();
        this.mIsNeedResumePlay = !getBinding().playerView.getMIsOnPause();
        getBinding().playerView.pausePlay();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        HwCommonPlayerActivity.super.onDestroy();
        this.mHandler.removeCallbacksAndMessages((Object) null);
        getBinding().playerView.destroyPlayer();
    }

    public void onBackPressed() {
        HwCommonPlayerActivity.super.onBackPressed();
        onExitPlayer();
    }

    /* access modifiers changed from: private */
    public final void onExitPlayer() {
        saveStartPosition(getBinding().playerView.getIsPlayComplete());
        AppVersionBll instance = AppVersionBll.Companion.getInstance();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        instance.restartUpdate(applicationContext);
    }

    /* access modifiers changed from: protected */
    public HwCommonPlayerActivityBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        HwCommonPlayerActivityBinding inflate = HwCommonPlayerActivityBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater,group,attach)");
        return inflate;
    }
}
