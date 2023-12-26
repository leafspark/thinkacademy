package com.tal.app.thinkacademy.business.study.study.ready;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.study.study.entity.OfflineData;
import com.tal.app.thinkacademy.business.study.study.entity.ReadyClassBackBean;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.ActivityBeforeClassPlaybackBinding;
import com.tal.app.thinkacademy.common.entity.AddressBean;
import com.tal.app.thinkacademy.common.entity.PlaybackUrlEntity;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.playerpreload.PlayerPreLoadHelp;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.download.model.FilePoint;
import com.tal.app.thinkacademy.lib.util.ColorUtils;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.util.ScreenUtils;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0010H\u0014J\u0010\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&H\u0016J\b\u0010(\u001a\u00020\u0016H\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020*H\u0016J\u0012\u0010,\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020*H\u0016J\u0012\u00102\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020*H\u0002J\b\u00106\u001a\u00020*H\u0002J\b\u00107\u001a\u00020*H\u0002J\b\u00108\u001a\u00020*H\u0002J\b\u00109\u001a\u00020*H\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006:"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/ready/BeforeClassBackActivity;", "Lcom/tal/app/thinkacademy/business/study/study/ready/BeforeClassBaseActivity;", "Lcom/tal/app/thinkacademy/business/study/study/ready/ReadyClassBackVM;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/ActivityBeforeClassPlaybackBinding;", "Landroid/view/View$OnClickListener;", "()V", "mGraffiti", "Lcom/tal/app/thinkacademy/business/study/study/entity/OfflineData;", "getMGraffiti", "()Lcom/tal/app/thinkacademy/business/study/study/entity/OfflineData;", "setMGraffiti", "(Lcom/tal/app/thinkacademy/business/study/study/entity/OfflineData;)V", "mMetadata", "getMMetadata", "setMMetadata", "mMetadataAvailable", "", "getMMetadataAvailable", "()Z", "setMMetadataAvailable", "(Z)V", "mStartTime", "", "mVodAddress", "Lcom/tal/app/thinkacademy/common/entity/PlaybackUrlEntity;", "getMVodAddress", "()Lcom/tal/app/thinkacademy/common/entity/PlaybackUrlEntity;", "setMVodAddress", "(Lcom/tal/app/thinkacademy/common/entity/PlaybackUrlEntity;)V", "mode", "", "getMode", "()Ljava/lang/String;", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "getDownloadFilePoint", "", "Lcom/tal/app/thinkacademy/lib/download/model/FilePoint;", "getDownloadFileSizeCount", "initViews", "", "loadData", "onClassDataLoadFailed", "point", "onClassDataLoadProgress", "progress", "", "onClassDataLoadSuccess", "onClick", "v", "Landroid/view/View;", "requestPlaybackData", "scalePad", "showDownloadFailView", "showDownloadView", "showNoVideoView", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BeforeClassBackActivity.kt */
public final class BeforeClassBackActivity extends BeforeClassBaseActivity<ReadyClassBackVM, ActivityBeforeClassPlaybackBinding> implements View.OnClickListener {
    private OfflineData mGraffiti;
    private OfflineData mMetadata;
    private boolean mMetadataAvailable;
    /* access modifiers changed from: private */
    public long mStartTime;
    private PlaybackUrlEntity mVodAddress;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BeforeClassBackActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public String getMode() {
        return "回放";
    }

    public final OfflineData getMGraffiti() {
        return this.mGraffiti;
    }

    public final void setMGraffiti(OfflineData offlineData) {
        this.mGraffiti = offlineData;
    }

    public final OfflineData getMMetadata() {
        return this.mMetadata;
    }

    public final void setMMetadata(OfflineData offlineData) {
        this.mMetadata = offlineData;
    }

    public final PlaybackUrlEntity getMVodAddress() {
        return this.mVodAddress;
    }

    public final void setMVodAddress(PlaybackUrlEntity playbackUrlEntity) {
        this.mVodAddress = playbackUrlEntity;
    }

    public final boolean getMMetadataAvailable() {
        return this.mMetadataAvailable;
    }

    public final void setMMetadataAvailable(boolean z) {
        this.mMetadataAvailable = z;
    }

    public void initViews() {
        setMTvDownload(getBinding().tvDownloadInfo);
        getBinding().progressDownload.setEnabled(false);
        getBinding().progressDownload.setClickable(false);
        getBinding().progressDownload.setFocusable(false);
        getBinding().btnBack.setOnClickListener(this);
        scalePad();
    }

    public void loadData() {
        showLoading();
        getMViewModel().getMReadyClassBean().observe((LifecycleOwner) this, new BeforeClassBackActivity$$ExternalSyntheticLambda2(this));
        getMViewModel().requestPlaybackInfo(getMPlanId());
        requestPlaybackData();
    }

    /* access modifiers changed from: private */
    /* renamed from: loadData$lambda-1  reason: not valid java name */
    public static final void m442loadData$lambda1(BeforeClassBackActivity beforeClassBackActivity, StateData stateData) {
        List list;
        AddressBean addressBean;
        Intrinsics.checkNotNullParameter(beforeClassBackActivity, "this$0");
        beforeClassBackActivity.hideLoading();
        int screenHeight = ScreenUtils.getScreenHeight() / 7;
        boolean z = true;
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            beforeClassBackActivity.getBinding().linearLayout.setPadding(0, screenHeight, 0, 0);
            beforeClassBackActivity.getBinding().layoutError.layoutError.setVisibility(8);
            ReadyClassBackBean readyClassBackBean = (ReadyClassBackBean) stateData.getData();
            if (readyClassBackBean != null) {
                beforeClassBackActivity.mStartTime = readyClassBackBean.getStartTime();
                beforeClassBackActivity.saveCourseware(beforeClassBackActivity.getMPlanId(), readyClassBackBean.getCourseware());
                beforeClassBackActivity.setMFollowCoursewareRatio(readyClassBackBean.getFollowCoursewareRatio());
                PlaybackUrlEntity vodAddress = readyClassBackBean.getVodAddress();
                String str = null;
                Collection collection = vodAddress == null ? null : vodAddress.list;
                if (collection != null && !collection.isEmpty()) {
                    z = false;
                }
                if (z) {
                    beforeClassBackActivity.showNoVideoView();
                    return;
                }
                beforeClassBackActivity.setMVodAddress(readyClassBackBean.getVodAddress());
                beforeClassBackActivity.setMGraffiti(readyClassBackBean.getGraffiti());
                beforeClassBackActivity.setMMetadata(readyClassBackBean.getMetadata());
                beforeClassBackActivity.setMMetadataAvailable(readyClassBackBean.getMetadataAvailable());
                PlayerPreLoadHelp instance = PlayerPreLoadHelp.Companion.getInstance();
                PlaybackUrlEntity vodAddress2 = readyClassBackBean.getVodAddress();
                if (!(vodAddress2 == null || (list = vodAddress2.list) == null || (addressBean = (AddressBean) list.get(0)) == null)) {
                    str = addressBean.address;
                }
                instance.startPlaybackPreload(str);
                beforeClassBackActivity.download(readyClassBackBean.getCourseware());
                beforeClassBackActivity.showDownloadView();
                return;
            }
            return;
        }
        beforeClassBackActivity.getBinding().layoutError.layoutError.setPadding(0, screenHeight, 0, 0);
        beforeClassBackActivity.getBinding().layoutError.layoutError.setVisibility(0);
        beforeClassBackActivity.getBinding().layoutError.btnRetry.setOnClickListener(beforeClassBackActivity);
    }

    private final void showDownloadView() {
        getBinding().ivNoVideo.setVisibility(8);
        getBinding().tvNoVideo.setVisibility(8);
        getBinding().btnOperation.setVisibility(8);
        getBinding().lottieLoading.setVisibility(0);
        getBinding().lottieLoading.playAnimation();
        getBinding().progressDownload.setVisibility(0);
        getBinding().tvDownloadInfo.setVisibility(0);
        getBinding().tvDownloadInfo.setTextColor(ColorUtils.getColor(R.color.color_172B4D));
    }

    private final void showDownloadFailView() {
        getBinding().ivNoVideo.setVisibility(8);
        getBinding().tvNoVideo.setVisibility(8);
        getBinding().btnOperation.setVisibility(0);
        getBinding().lottieLoading.setVisibility(0);
        getBinding().progressDownload.setVisibility(0);
        getBinding().tvDownloadInfo.setVisibility(0);
        getBinding().tvDownloadInfo.setText(getString(R.string.courseware_download_failed));
        getBinding().tvDownloadInfo.setTextColor(ColorUtils.getColor(R.color.color_FF503F));
        getBinding().btnOperation.setOnClickListener(new BeforeClassBackActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: showDownloadFailView$lambda-2  reason: not valid java name */
    public static final void m443showDownloadFailView$lambda2(BeforeClassBackActivity beforeClassBackActivity, View view) {
        Intrinsics.checkNotNullParameter(beforeClassBackActivity, "this$0");
        beforeClassBackActivity.download(beforeClassBackActivity.getMCourseware());
        beforeClassBackActivity.showDownloadView();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void showNoVideoView() {
        getBinding().lottieLoading.setVisibility(8);
        getBinding().progressDownload.setVisibility(8);
        getBinding().tvDownloadInfo.setVisibility(8);
        getBinding().ivNoVideo.setVisibility(0);
        getBinding().tvNoVideo.setVisibility(0);
        getBinding().btnOperation.setVisibility(0);
        getBinding().btnOperation.setText(getString(R.string.prepare_back));
        getBinding().btnOperation.setOnClickListener(new BeforeClassBackActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: showNoVideoView$lambda-3  reason: not valid java name */
    public static final void m444showNoVideoView$lambda3(BeforeClassBackActivity beforeClassBackActivity, View view) {
        Intrinsics.checkNotNullParameter(beforeClassBackActivity, "this$0");
        beforeClassBackActivity.finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onClassDataLoadSuccess() {
        BeforeClassBaseActivity.log$default(this, "资源下载完成，进入课堂", (Boolean) null, 2, (Object) null);
        getBinding().tvDownloadInfo.setText(getString(R.string.courseware_download_complete));
        getBinding().progressDownload.setProgress(100);
        PlaybackUrlEntity playbackUrlEntity = this.mVodAddress;
        if (playbackUrlEntity != null) {
            playbackUrlEntity.metadataAvailable = getMMetadataAvailable();
            Map linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("playbackUrl", playbackUrlEntity);
            getMViewModel().defer(1000, new BeforeClassBackActivity$onClassDataLoadSuccess$1$1(this, linkedHashMap));
        }
    }

    public void onClassDataLoadFailed(FilePoint filePoint) {
        showDownloadFailView();
    }

    /* access modifiers changed from: protected */
    public ActivityBeforeClassPlaybackBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityBeforeClassPlaybackBinding inflate = ActivityBeforeClassPlaybackBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.tal.app.thinkacademy.lib.download.model.FilePoint> getDownloadFilePoint() {
        /*
            r14 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            com.tal.app.thinkacademy.business.study.study.entity.OfflineData r1 = r14.mGraffiti
            r2 = 0
            r4 = 0
            r5 = 2
            r6 = 1
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
            r8 = 0
            if (r1 != 0) goto L_0x0018
            r1 = r8
            goto L_0x0169
        L_0x0018:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "graffiti_"
            r9.append(r10)
            java.lang.String r10 = r14.getMPlanId()
            r9.append(r10)
            java.lang.String r10 = ".zip"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r10 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            java.lang.String r11 = "-graffiti"
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r11)
            int r12 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_CAN_CLEAR
            java.lang.String r10 = r10.getString(r11, r8, r12)
            if (r10 != 0) goto L_0x0046
            r10 = r8
            goto L_0x0075
        L_0x0046:
            r11 = r14
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity r11 = (com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity) r11
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "本地涂鸦离线包md5是"
            r12.append(r13)
            r12.append(r10)
            java.lang.String r13 = "，服务端下发的md5是"
            r12.append(r13)
            java.lang.String r13 = r1.getMd5()
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity.log$default(r11, r12, r8, r5, r8)
            java.lang.String r11 = r1.getMd5()
            boolean r10 = kotlin.text.StringsKt.equals(r10, r11, r6)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
        L_0x0075:
            if (r10 != 0) goto L_0x0084
            r10 = r14
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBackActivity r10 = (com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBackActivity) r10
            r10 = r14
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity r10 = (com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity) r10
            java.lang.String r11 = "本地涂鸦md5不存在"
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity.log$default(r10, r11, r8, r5, r8)
            r10 = r4
            goto L_0x0088
        L_0x0084:
            boolean r10 = r10.booleanValue()
        L_0x0088:
            java.io.File r11 = new java.io.File
            java.lang.String r12 = r14.getMPlanId()
            java.lang.String r12 = com.tal.app.thinkacademy.lib.download.util.AppCacheUtil.getClassRoomOfflineGraffitiPath(r12)
            r11.<init>(r12)
            boolean r12 = r11.exists()
            if (r12 == 0) goto L_0x00a8
            java.lang.String[] r12 = r11.list()
            if (r12 != 0) goto L_0x00a3
            r12 = r4
            goto L_0x00a4
        L_0x00a3:
            int r12 = r12.length
        L_0x00a4:
            if (r12 <= 0) goto L_0x00a8
            r12 = r6
            goto L_0x00a9
        L_0x00a8:
            r12 = r4
        L_0x00a9:
            if (r12 == 0) goto L_0x00ac
            goto L_0x00ad
        L_0x00ac:
            r11 = r8
        L_0x00ad:
            if (r11 != 0) goto L_0x00b1
            r11 = r8
            goto L_0x00b2
        L_0x00b1:
            r11 = r7
        L_0x00b2:
            if (r10 == 0) goto L_0x00ba
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r7)
            if (r7 != 0) goto L_0x015b
        L_0x00ba:
            java.lang.String r7 = r1.getUrl()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x00cb
            boolean r7 = kotlin.text.StringsKt.isBlank(r7)
            if (r7 == 0) goto L_0x00c9
            goto L_0x00cb
        L_0x00c9:
            r7 = r4
            goto L_0x00cc
        L_0x00cb:
            r7 = r6
        L_0x00cc:
            if (r7 != 0) goto L_0x015b
            java.lang.String r7 = r1.getMd5()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x00df
            boolean r7 = kotlin.text.StringsKt.isBlank(r7)
            if (r7 == 0) goto L_0x00dd
            goto L_0x00df
        L_0x00dd:
            r7 = r4
            goto L_0x00e0
        L_0x00df:
            r7 = r6
        L_0x00e0:
            if (r7 != 0) goto L_0x015b
            java.lang.String r7 = r14.getMPlanId()
            java.lang.String r7 = com.tal.app.thinkacademy.lib.download.util.AppCacheUtil.getClassRoomOfflineGraffitiPath(r7)
            com.tal.app.thinkacademy.lib.util.FileUtils.deleteDir(r7)
            com.tal.app.thinkacademy.common.entity.GraffitiFilePoint r7 = new com.tal.app.thinkacademy.common.entity.GraffitiFilePoint
            r7.<init>()
            java.lang.String r10 = r1.getSize()
            long r10 = com.tal.app.thinkacademy.lib.util.ParseUtils.tryParseLong(r10, r2)
            r7.setFileSize(r10)
            java.lang.String r10 = r1.getUrl()
            java.util.List r10 = kotlin.collections.CollectionsKt.listOf(r10)
            r7.setUrl(r10)
            com.tal.app.thinkacademy.lib.download.operation.ResourceBusinessType r10 = com.tal.app.thinkacademy.lib.download.operation.ResourceBusinessType.TYPE_GRAFFITI
            java.lang.String r10 = r10.name()
            r7.setResBusinessType(r10)
            android.app.Application r10 = com.tal.app.thinkacademy.lib.language.AppUtil.getApplication()
            java.io.File r10 = r10.getFilesDir()
            java.lang.String r10 = r10.getAbsolutePath()
            java.lang.String r11 = "/course_zip/"
            java.lang.String r10 = kotlin.jvm.internal.Intrinsics.stringPlus(r10, r11)
            r7.setFilePath(r10)
            r7.setFileName(r9)
            java.lang.String r9 = r7.getFileName()
            r7.setRealFileName(r9)
            java.lang.String r9 = r14.getMPlanId()
            java.lang.String r9 = com.tal.app.thinkacademy.lib.download.util.AppCacheUtil.getClassRoomOfflineGraffitiPath(r9)
            r7.setUnZipPath(r9)
            java.lang.String r9 = r1.getMd5()
            r7.setMd5(r9)
            r7.setIgnoreSRAVerify(r6)
            r7.setDiff(r4)
            r7.setHighPriorityRes(r6)
            r0.add(r7)
            r7 = r14
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity r7 = (com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity) r7
            java.lang.String r9 = "需要下载涂鸦离线包，graffiti = "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r1)
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity.log$default(r7, r1, r8, r5, r8)
            goto L_0x0167
        L_0x015b:
            r7 = r14
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity r7 = (com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity) r7
            java.lang.String r9 = "本地存在涂鸦离线数据，或接口下发的涂鸦离线包链接或md5为空，不下载 graffiti = "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r1)
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity.log$default(r7, r1, r8, r5, r8)
        L_0x0167:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x0169:
            if (r1 != 0) goto L_0x0173
            r1 = r14
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity r1 = (com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity) r1
            java.lang.String r7 = "接口下发的离线包涂鸦数据为空"
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity.log$default(r1, r7, r8, r5, r8)
        L_0x0173:
            com.tal.app.thinkacademy.business.study.study.entity.OfflineData r1 = r14.mMetadata
            if (r1 != 0) goto L_0x017a
            r1 = r8
            goto L_0x0247
        L_0x017a:
            java.io.File r7 = new java.io.File
            java.lang.String r9 = r14.getMPlanId()
            java.lang.String r9 = com.tal.app.thinkacademy.lib.download.util.AppCacheUtil.getClassRoomOfflineMateInfoPath(r9)
            java.lang.String r10 = "mateinfo.txt"
            r7.<init>(r9, r10)
            boolean r9 = r7.exists()
            if (r9 == 0) goto L_0x0190
            goto L_0x0191
        L_0x0190:
            r7 = r8
        L_0x0191:
            if (r7 != 0) goto L_0x0195
            r7 = r8
            goto L_0x01be
        L_0x0195:
            r9 = r14
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity r9 = (com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity) r9
            java.lang.String r11 = r1.getMd5()
            java.lang.String r12 = "接口下发打点文件md5值："
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r12, r11)
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity.log$default(r9, r11, r8, r5, r8)
            java.lang.String r7 = com.tal.app.thinkacademy.lib.util.EncryptUtils.encodeFile(r7)
            java.lang.String r11 = r1.getMd5()
            boolean r11 = kotlin.text.StringsKt.equals(r7, r11, r6)
            java.lang.String r12 = "本地打点文件存在，md5值："
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r12, r7)
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity.log$default(r9, r7, r8, r5, r8)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r11)
        L_0x01be:
            if (r7 != 0) goto L_0x01cd
            r7 = r14
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBackActivity r7 = (com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBackActivity) r7
            r7 = r14
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity r7 = (com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity) r7
            java.lang.String r9 = "本地打点文件不存在"
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity.log$default(r7, r9, r8, r5, r8)
            r7 = r4
            goto L_0x01d1
        L_0x01cd:
            boolean r7 = r7.booleanValue()
        L_0x01d1:
            if (r7 != 0) goto L_0x0239
            java.lang.String r7 = r1.getUrl()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x01e4
            boolean r7 = kotlin.text.StringsKt.isBlank(r7)
            if (r7 == 0) goto L_0x01e2
            goto L_0x01e4
        L_0x01e2:
            r7 = r4
            goto L_0x01e5
        L_0x01e4:
            r7 = r6
        L_0x01e5:
            if (r7 != 0) goto L_0x0239
            com.tal.app.thinkacademy.common.entity.DataFilePoint r7 = new com.tal.app.thinkacademy.common.entity.DataFilePoint
            r7.<init>()
            java.lang.String r9 = r1.getSize()
            long r2 = com.tal.app.thinkacademy.lib.util.ParseUtils.tryParseLong(r9, r2)
            r7.setFileSize(r2)
            java.lang.String r2 = r1.getUrl()
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r2)
            r7.setUrl(r2)
            com.tal.app.thinkacademy.lib.download.operation.ResourceBusinessType r2 = com.tal.app.thinkacademy.lib.download.operation.ResourceBusinessType.TYPE_MATEINFO
            java.lang.String r2 = r2.name()
            r7.setResBusinessType(r2)
            java.lang.String r2 = r14.getMPlanId()
            java.lang.String r2 = com.tal.app.thinkacademy.lib.download.util.AppCacheUtil.getClassRoomOfflineMateInfoPath(r2)
            r7.setFilePath(r2)
            r7.setFileName(r10)
            r7.setIgnoreSRAVerify(r6)
            r7.setDiff(r4)
            r7.setHighPriorityRes(r6)
            java.lang.String r1 = r1.getMd5()
            r7.setMd5(r1)
            r0.add(r7)
            r1 = r14
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity r1 = (com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity) r1
            java.lang.String r2 = "需要下载mateinfo文件，mataInfo = "
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r7)
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity.log$default(r1, r2, r8, r5, r8)
            goto L_0x0245
        L_0x0239:
            r2 = r14
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity r2 = (com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity) r2
            java.lang.String r3 = "本地存在mateInfo文件,或接口下发的mateInfoUrl为空，不下载，mateInfo = "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r1)
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity.log$default(r2, r1, r8, r5, r8)
        L_0x0245:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x0247:
            if (r1 != 0) goto L_0x0251
            r1 = r14
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity r1 = (com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity) r1
            java.lang.String r2 = "接口下发的离线包数据为空"
            com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBaseActivity.log$default(r1, r2, r8, r5, r8)
        L_0x0251:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.ready.BeforeClassBackActivity.getDownloadFilePoint():java.util.List");
    }

    public long getDownloadFileSizeCount() {
        OfflineData offlineData = this.mGraffiti;
        String str = null;
        long tryParseLong = ParseUtils.tryParseLong(offlineData == null ? null : offlineData.getSize(), 0) + 0;
        OfflineData offlineData2 = this.mMetadata;
        if (offlineData2 != null) {
            str = offlineData2.getSize();
        }
        return tryParseLong + ParseUtils.tryParseLong(str, 0);
    }

    public void onClassDataLoadProgress(int i) {
        getBinding().progressDownload.setProgress(i);
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, BeforeClassBackActivity.class);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i = R.id.btn_back;
        if (valueOf != null && valueOf.intValue() == i) {
            finish();
        } else {
            int i2 = R.id.btn_retry;
            if (valueOf != null && valueOf.intValue() == i2) {
                getMViewModel().requestPlaybackInfo(getMPlanId());
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    private final void requestPlaybackData() {
        getMViewModel().requestPlaybackEnter(getMPlanId(), getMCourseId(), getMBizId());
        getMViewModel().requestInitModule(getMPlanId());
    }

    private final void scalePad() {
        if (PadUtils.isPad((Context) this)) {
            FrameLayout root = getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            scale(root, 1.5f, ScreenUtils.getScreenWidth() / 2, 0);
        }
    }
}
