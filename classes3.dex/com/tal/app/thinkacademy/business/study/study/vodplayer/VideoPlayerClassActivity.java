package com.tal.app.thinkacademy.business.study.study.vodplayer;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.tal.app.thinkacademy.business.study.study.StudyTrack;
import com.tal.app.thinkacademy.business.study.study.Tag;
import com.tal.app.thinkacademy.business.study.study.entity.RecordLesson;
import com.tal.app.thinkacademy.business.study.study.entity.RecordResource;
import com.tal.app.thinkacademy.business.study.study.entity.RecordUrl;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedSchedule;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.VideoPlayerClassActivityBinding;
import com.tal.app.thinkacademy.common.base.BaseBindActivity;
import com.tal.app.thinkacademy.common.business.AppVersionBll;
import com.tal.app.thinkacademy.common.entity.VodPlayerReportBody;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.commui.widget.pad.NotPadAutoScreen;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\tH\u0014J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u001fH\u0002J\b\u0010&\u001a\u00020\u001fH\u0016J\u0012\u0010'\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\b\u0010*\u001a\u00020\u001fH\u0014J\b\u0010+\u001a\u00020\u001fH\u0002J\b\u0010,\u001a\u00020\u001fH\u0014J\b\u0010-\u001a\u00020\u001fH\u0014J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\tH\u0002J\u0010\u00100\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\tH\u0002J\b\u00101\u001a\u00020\u001fH\u0002J\b\u00102\u001a\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VideoPlayerClassActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseBindActivity;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/VideoPlayerClassActivityBinding;", "()V", "mCourseId", "", "mHandler", "Landroid/os/Handler;", "mIsNeedResumePlay", "", "mOneMinuteRunnable", "Ljava/lang/Runnable;", "mPlanId", "mResourceId", "", "mResourceIndex", "mScheduleListSize", "mSessionId", "", "mStartPosition", "mSwitchLineIndex", "mSwitchLines", "", "mTeacherId", "mTeacherName", "mUid", "mUrl", "mVideoName", "mVodPlayerData", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCalendarListEntity;", "convertResourceData", "", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "initData", "loopSendReport", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onExitPlayer", "onPause", "onResume", "reportServerVideoData", "isPlayComplete", "saveStartPosition", "setStartPosition", "startPreload", "Companion", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@NotPadAutoScreen
/* compiled from: VideoPlayerClassActivity.kt */
public final class VideoPlayerClassActivity extends BaseBindActivity<VideoPlayerClassActivityBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.VOD_PLAYER_PLAY;
    /* access modifiers changed from: private */
    public int mCourseId;
    private final Handler mHandler;
    private boolean mIsNeedResumePlay;
    private final Runnable mOneMinuteRunnable;
    /* access modifiers changed from: private */
    public int mPlanId;
    private String mResourceId;
    /* access modifiers changed from: private */
    public int mResourceIndex;
    /* access modifiers changed from: private */
    public int mScheduleListSize;
    private long mSessionId;
    private long mStartPosition;
    /* access modifiers changed from: private */
    public int mSwitchLineIndex;
    /* access modifiers changed from: private */
    public List<String> mSwitchLines;
    /* access modifiers changed from: private */
    public int mTeacherId;
    /* access modifiers changed from: private */
    public String mTeacherName;
    private String mUid;
    /* access modifiers changed from: private */
    public String mUrl;
    /* access modifiers changed from: private */
    public String mVideoName;
    private RecordedCalendarListEntity mVodPlayerData;

    private final void startPreload() {
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VideoPlayerClassActivity$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/business/study/study/Tag;", "startActivity", "", "context", "Landroid/content/Context;", "resourceIndex", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoPlayerClassActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startActivity(Context context, int i) {
            Unit unit;
            if (context == null) {
                unit = null;
            } else {
                Intent intent = new Intent(context, VideoPlayerClassActivity.class);
                intent.putExtra("resourceIndex", i);
                context.startActivity(intent);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                Companion companion = this;
                XesLog.i(VideoPlayerClassActivity.TAG, new Object[]{"startActivity error:context is null"});
            }
        }
    }

    public VideoPlayerClassActivity() {
        String uid;
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        String str = "";
        if (!(userInfoEntity == null || (uid = userInfoEntity.getUid()) == null)) {
            str = uid;
        }
        this.mUid = str;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mOneMinuteRunnable = new VideoPlayerClassActivity$mOneMinuteRunnable$1(this);
    }

    /* access modifiers changed from: private */
    public final void loopSendReport() {
        this.mHandler.removeCallbacks(this.mOneMinuteRunnable);
        this.mHandler.postDelayed(this.mOneMinuteRunnable, 60000);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r8) {
        /*
            r7 = this;
            com.tal.app.thinkacademy.business.study.study.vodplayer.VideoPlayerClassActivity.super.onCreate(r8)
            r7.initData()
            r8 = 0
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity r0 = r7.mVodPlayerData     // Catch:{ Exception -> 0x0021 }
            if (r0 != 0) goto L_0x000d
        L_0x000b:
            r0 = r8
            goto L_0x001f
        L_0x000d:
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarCourse r0 = r0.getCourse()     // Catch:{ Exception -> 0x0021 }
            if (r0 != 0) goto L_0x0014
            goto L_0x000b
        L_0x0014:
            java.lang.String r0 = r0.getId()     // Catch:{ Exception -> 0x0021 }
            if (r0 != 0) goto L_0x001b
            goto L_0x000b
        L_0x001b:
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0021 }
        L_0x001f:
            r7.mCourseId = r0     // Catch:{ Exception -> 0x0021 }
        L_0x0021:
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity r0 = r7.mVodPlayerData
            r1 = 0
            if (r0 != 0) goto L_0x0028
            goto L_0x0033
        L_0x0028:
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarCourse r0 = r0.getCourse()
            if (r0 != 0) goto L_0x002f
            goto L_0x0033
        L_0x002f:
            long r1 = r0.getSessionId()
        L_0x0033:
            r7.mSessionId = r1
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity r0 = r7.mVodPlayerData
            r1 = 1
            if (r0 != 0) goto L_0x003b
            goto L_0x006f
        L_0x003b:
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarCourse r0 = r0.getCourse()
            if (r0 != 0) goto L_0x0042
            goto L_0x006f
        L_0x0042:
            java.util.List r0 = r0.getTeachers()
            if (r0 != 0) goto L_0x0049
            goto L_0x006f
        L_0x0049:
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r1
            if (r2 == 0) goto L_0x006f
            java.lang.Object r2 = r0.get(r8)
            com.tal.app.thinkacademy.business.study.study.entity.Teacher r2 = (com.tal.app.thinkacademy.business.study.study.entity.Teacher) r2
            java.lang.String r2 = r2.getId()
            int r2 = com.tal.app.thinkacademy.lib.util.ParseUtils.tryParseInt(r2, r8)
            r7.mTeacherId = r2
            java.lang.Object r0 = r0.get(r8)
            com.tal.app.thinkacademy.business.study.study.entity.Teacher r0 = (com.tal.app.thinkacademy.business.study.study.entity.Teacher) r0
            java.lang.String r0 = r0.getName()
            r7.mTeacherName = r0
        L_0x006f:
            androidx.viewbinding.ViewBinding r0 = r7.getBinding()
            com.tal.app.thinkacademy.business.studycenter.databinding.VideoPlayerClassActivityBinding r0 = (com.tal.app.thinkacademy.business.studycenter.databinding.VideoPlayerClassActivityBinding) r0
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView r0 = r0.playerView
            com.tal.app.thinkacademy.lib.player.track.VideoPlayerSceneType r2 = com.tal.app.thinkacademy.lib.player.track.VideoPlayerSceneType.RECORDING_CLASS
            r0.setVideoPlayerSceneType(r2)
            r7.convertResourceData()
            androidx.viewbinding.ViewBinding r0 = r7.getBinding()
            com.tal.app.thinkacademy.business.studycenter.databinding.VideoPlayerClassActivityBinding r0 = (com.tal.app.thinkacademy.business.studycenter.databinding.VideoPlayerClassActivityBinding) r0
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView r0 = r0.playerView
            com.tal.app.thinkacademy.business.study.study.vodplayer.VideoPlayerClassActivity$onCreate$2 r2 = new com.tal.app.thinkacademy.business.study.study.vodplayer.VideoPlayerClassActivity$onCreate$2
            r2.<init>(r7)
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView$VodPlayerListen r2 = (com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView.VodPlayerListen) r2
            r0.setVodPlayerListen(r2)
            androidx.viewbinding.ViewBinding r0 = r7.getBinding()
            com.tal.app.thinkacademy.business.studycenter.databinding.VideoPlayerClassActivityBinding r0 = (com.tal.app.thinkacademy.business.studycenter.databinding.VideoPlayerClassActivityBinding) r0
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView r0 = r0.playerView
            com.tal.app.thinkacademy.common.playerpreload.PlayerPreLoadHelp$Companion r2 = com.tal.app.thinkacademy.common.playerpreload.PlayerPreLoadHelp.Companion
            com.tal.app.thinkacademy.common.playerpreload.PlayerPreLoadHelp r2 = r2.getInstance()
            boolean r2 = r2.isEnableHlsCache()
            r0.setMIsOpenHLSCache(r2)
            com.tal.app.thinkacademy.business.study.study.Tag r0 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            androidx.viewbinding.ViewBinding r2 = r7.getBinding()
            com.tal.app.thinkacademy.business.studycenter.databinding.VideoPlayerClassActivityBinding r2 = (com.tal.app.thinkacademy.business.studycenter.databinding.VideoPlayerClassActivityBinding) r2
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView r2 = r2.playerView
            boolean r2 = r2.getMIsOpenHLSCache()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r3 = "是否打开缓存="
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r2)
            r1[r8] = r2
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r1)
            androidx.viewbinding.ViewBinding r8 = r7.getBinding()
            com.tal.app.thinkacademy.business.studycenter.databinding.VideoPlayerClassActivityBinding r8 = (com.tal.app.thinkacademy.business.studycenter.databinding.VideoPlayerClassActivityBinding) r8
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView r8 = r8.playerView
            java.lang.String r0 = r7.mVideoName
            java.lang.String r1 = r7.mUrl
            int r2 = r7.mSwitchLineIndex
            java.util.List<java.lang.String> r3 = r7.mSwitchLines
            r8.setData(r0, r1, r2, r3)
            androidx.viewbinding.ViewBinding r8 = r7.getBinding()
            com.tal.app.thinkacademy.business.studycenter.databinding.VideoPlayerClassActivityBinding r8 = (com.tal.app.thinkacademy.business.studycenter.databinding.VideoPlayerClassActivityBinding) r8
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView r8 = r8.playerView
            java.lang.String r0 = r7.mUrl
            if (r0 != 0) goto L_0x00e8
            java.lang.String r0 = ""
        L_0x00e8:
            r8.playUrl(r0)
            r7.loopSendReport()
            com.tal.app.thinkacademy.business.study.study.StudyTrack r1 = com.tal.app.thinkacademy.business.study.study.StudyTrack.INSTANCE
            r2 = 1
            int r3 = r7.mCourseId
            int r4 = r7.mPlanId
            int r5 = r7.mTeacherId
            java.lang.String r6 = r7.mTeacherName
            r1.hw_recorded_course(r2, r3, r4, r5, r6)
            com.tal.app.thinkacademy.common.business.AppVersionBll$Companion r8 = com.tal.app.thinkacademy.common.business.AppVersionBll.Companion
            com.tal.app.thinkacademy.common.business.AppVersionBll r8 = r8.getInstance()
            r8.cancelUpdate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.vodplayer.VideoPlayerClassActivity.onCreate(android.os.Bundle):void");
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
            com.tal.app.thinkacademy.business.studycenter.databinding.VideoPlayerClassActivityBinding r0 = (com.tal.app.thinkacademy.business.studycenter.databinding.VideoPlayerClassActivityBinding) r0
            com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView r0 = r0.playerView
            long r1 = r8.mStartPosition
            r0.setMCurrentPosition(r1)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.vodplayer.VideoPlayerClassActivity.setStartPosition():void");
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
            com.tal.app.thinkacademy.business.studycenter.databinding.VideoPlayerClassActivityBinding r8 = (com.tal.app.thinkacademy.business.studycenter.databinding.VideoPlayerClassActivityBinding) r8
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.vodplayer.VideoPlayerClassActivity.saveStartPosition(boolean):void");
    }

    /* access modifiers changed from: private */
    public final void convertResourceData() {
        if (this.mScheduleListSize > this.mResourceIndex) {
            this.mUrl = "";
            this.mVideoName = "";
            this.mSwitchLines = new ArrayList();
            try {
                RecordedCalendarListEntity recordedCalendarListEntity = this.mVodPlayerData;
                if (recordedCalendarListEntity != null) {
                    List<RecordedSchedule> scheduleList = recordedCalendarListEntity.getScheduleList();
                    if (scheduleList != null) {
                        RecordedSchedule recordedSchedule = scheduleList.get(this.mResourceIndex);
                        if (recordedSchedule != null) {
                            RecordLesson recordLesson = recordedSchedule.getRecordLesson();
                            if (recordLesson != null) {
                                this.mPlanId = recordLesson.getLessonId();
                                this.mVideoName = recordLesson.getLessonName();
                                List<RecordResource> resourceList = recordLesson.getResourceList();
                                String str = null;
                                if (resourceList != null) {
                                    RecordResource recordResource = resourceList.get(0);
                                    if (recordResource != null) {
                                        Integer id = recordResource.getId();
                                        if (id != null) {
                                            str = id.toString();
                                        }
                                    }
                                }
                                this.mResourceId = str;
                                List<RecordResource> resourceList2 = recordLesson.getResourceList();
                                if (resourceList2 != null) {
                                    RecordResource recordResource2 = resourceList2.get(0);
                                    if (recordResource2 != null) {
                                        List<RecordUrl> urls = recordResource2.getUrls();
                                        if (urls != null) {
                                            int i = 0;
                                            for (Object next : urls) {
                                                int i2 = i + 1;
                                                if (i < 0) {
                                                    CollectionsKt.throwIndexOverflow();
                                                }
                                                RecordUrl recordUrl = (RecordUrl) next;
                                                if (i == 0) {
                                                    this.mUrl = recordUrl.getUrl();
                                                }
                                                List<String> list = this.mSwitchLines;
                                                if (list != null) {
                                                    String url = recordUrl.getUrl();
                                                    if (url == null) {
                                                        url = "";
                                                    }
                                                    list.add(url);
                                                }
                                                i = i2;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                XesLog.i(TAG, new Object[]{Intrinsics.stringPlus("convertResourceData error = ", e)});
            }
        }
        setStartPosition();
        XesLog.i(TAG, new Object[]{"convertResourceData,即将播放的url=" + this.mUrl + ",position=" + this.mStartPosition});
        startPreload();
    }

    private final void initData() {
        int i;
        List<RecordedSchedule> scheduleList;
        Intent intent = getIntent();
        this.mResourceIndex = intent == null ? 0 : intent.getIntExtra("resourceIndex", 0);
        RecordedCalendarListEntity vodPlayerData = VodPlayerDataHolder.Companion.getInstance().getVodPlayerData();
        this.mVodPlayerData = vodPlayerData;
        if (vodPlayerData == null || (scheduleList = vodPlayerData.getScheduleList()) == null) {
            i = 0;
        } else {
            i = scheduleList.size();
        }
        this.mScheduleListSize = i;
        if (!(i > this.mResourceIndex)) {
            ToastUtils.showLong(getString(R.string.data_is_empty), new Object[0]);
            XesLog.i(TAG, new Object[]{"数据无效，直接退出"});
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        VideoPlayerClassActivity.super.onResume();
        if (this.mIsNeedResumePlay) {
            getBinding().playerView.resumePlay();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        VideoPlayerClassActivity.super.onPause();
        this.mIsNeedResumePlay = !getBinding().playerView.getMIsOnPause();
        getBinding().playerView.pausePlay();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        VideoPlayerClassActivity.super.onDestroy();
        this.mHandler.removeCallbacksAndMessages((Object) null);
        getBinding().playerView.destroyPlayer();
    }

    public void onBackPressed() {
        VideoPlayerClassActivity.super.onBackPressed();
        onExitPlayer();
    }

    /* access modifiers changed from: private */
    public final void onExitPlayer() {
        boolean isPlayComplete = getBinding().playerView.getIsPlayComplete();
        saveStartPosition(isPlayComplete);
        reportServerVideoData(isPlayComplete);
        StudyTrack.INSTANCE.hw_recorded_course_duration(isPlayComplete, getBinding().playerView.getMIsOnPause(), getBinding().playerView.getMDuration(), getBinding().playerView.getMCurrentPosition(), this.mTeacherId, this.mTeacherName, this.mCourseId, this.mPlanId);
        StudyTrack.INSTANCE.hw_recorded_course(false, this.mCourseId, this.mPlanId, this.mTeacherId, this.mTeacherName);
        AppVersionBll instance = AppVersionBll.Companion.getInstance();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        instance.restartUpdate(applicationContext);
    }

    /* access modifiers changed from: private */
    public final void reportServerVideoData(boolean z) {
        long mDuration = getBinding().playerView.getMDuration();
        long mCurrentPosition = getBinding().playerView.getMCurrentPosition();
        if (z) {
            mCurrentPosition = mDuration;
        }
        if (mDuration > 0) {
            long j = (long) 1000;
            int i = (int) (mDuration / j);
            VodPlayerReportBody vodPlayerReportBody = new VodPlayerReportBody(this.mPlanId, this.mCourseId, this.mTeacherId, this.mTeacherName, (int) (mCurrentPosition / j), i, (int) (((((float) mCurrentPosition) * 1.0f) * ((float) 100)) / ((float) mDuration)), this.mResourceId, this.mSessionId);
            XesLog.i(TAG, new Object[]{"reportVideoData,planId=" + vodPlayerReportBody.getPlanId() + ",courseId=" + vodPlayerReportBody.getCourseId() + ",contentTeacherId = " + vodPlayerReportBody.getContentTeacherId() + ",contentTeahcer=" + vodPlayerReportBody.getContentTeahcer() + ",watchDuration=" + vodPlayerReportBody.getWatchDuration() + ",duration=" + vodPlayerReportBody.getDuration() + ",rightnowPlayProgress = " + vodPlayerReportBody.getRightnowPlayProgress() + ",resourceId = " + vodPlayerReportBody.getResourceId() + ",sessionId=" + vodPlayerReportBody.getSessionId()});
            VodPlayerDataHolder.Companion.getInstance().reportVideoData(vodPlayerReportBody);
        }
    }

    /* access modifiers changed from: protected */
    public VideoPlayerClassActivityBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        VideoPlayerClassActivityBinding inflate = VideoPlayerClassActivityBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }
}
