package com.tal.app.thinkacademy.business.study.study;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.flyco.roundview.RoundTextView;
import com.google.gson.JsonObject;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.study.study.dialog.InternetSafetyTipsDialog;
import com.tal.app.thinkacademy.business.study.study.entity.NetworkQualityBean;
import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import com.tal.app.thinkacademy.business.study.study.vm.PrepareClassVM;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPrepareLayoutBinding;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.courseware.ImCoursesWareUtils;
import com.tal.app.thinkacademy.common.courseware.ImCousesWare;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.common.utils.StudyCenterUtil;
import com.tal.app.thinkacademy.lib.download.operation.DownloadEngine;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.BarUtils;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020-H\u0002J\u0018\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0013H\u0014J\b\u00103\u001a\u00020-H\u0002J\b\u00104\u001a\u00020-H\u0002J\b\u00105\u001a\u00020-H\u0002J\b\u00106\u001a\u00020-H\u0002J\b\u00107\u001a\u00020-H\u0016J\u0012\u00108\u001a\u00020-2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0012\u0010;\u001a\u00020-2\b\u0010<\u001a\u0004\u0018\u00010=H\u0014J\b\u0010>\u001a\u00020-H\u0014J\b\u0010?\u001a\u00020-H\u0002J\b\u0010@\u001a\u00020-H\u0002J\u0006\u0010A\u001a\u00020-J\b\u0010B\u001a\u00020-H\u0002J\b\u0010C\u001a\u00020-H\u0002J\u0018\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0002J\b\u0010G\u001a\u00020-H\u0016J\u0006\u0010H\u001a\u00020-R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010'\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010(\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006I"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/PrepareClassPlaybackActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/study/study/vm/PrepareClassVM;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/ActivityPrepareLayoutBinding;", "Landroid/view/View$OnClickListener;", "()V", "TAG", "", "allRoundTrip", "", "avgRoundTrip", "", "avgSuccRate", "downloadStart", "excellentAvgRoundTrip", "", "Ljava/lang/Integer;", "excellentAvgSuccessRate", "isAuditor", "", "isBindCourseware", "isParentAudit", "isStopRequest", "isTemp", "mBizId", "mCourseId", "mDuration", "mEditSuccess", "mHandler", "Landroid/os/Handler;", "mInternetSafetyTipsDialog", "Lcom/tal/app/thinkacademy/business/study/study/dialog/InternetSafetyTipsDialog;", "mLessonType", "mPlanId", "mRequestCounts", "mRequestEnd", "mRequestStart", "mRequestSuccessCount", "normalAvgRoundTrip", "normalAvgSuccessRate", "packageId", "previousSource", "realName", "subPlatformType", "calculateNetResult", "", "coursewareReady", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "initData", "initNetstatusLottie", "initStatusData", "initViews", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setJoinBtnEnable", "setValues", "showDownFailedView", "showDownFinishView", "showNetRefreshVIew", "showProgressView", "soFarBytes", "totalBytes", "startObserve", "updateDownloadView", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrepareClassPlaybackActivity.kt */
public final class PrepareClassPlaybackActivity extends BaseVmActivity<PrepareClassVM, ActivityPrepareLayoutBinding> implements View.OnClickListener {
    /* access modifiers changed from: private */
    public final String TAG = "回放-课前";
    /* access modifiers changed from: private */
    public long allRoundTrip;
    private float avgRoundTrip;
    private float avgSuccRate;
    /* access modifiers changed from: private */
    public long downloadStart;
    /* access modifiers changed from: private */
    public Integer excellentAvgRoundTrip = 0;
    /* access modifiers changed from: private */
    public Integer excellentAvgSuccessRate = 0;
    private boolean isAuditor;
    /* access modifiers changed from: private */
    public boolean isBindCourseware = true;
    private boolean isParentAudit;
    /* access modifiers changed from: private */
    public boolean isStopRequest;
    private String isTemp = "";
    private String mBizId = "";
    private String mCourseId = "";
    /* access modifiers changed from: private */
    public Integer mDuration = 10;
    private String mEditSuccess = "0";
    private Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public InternetSafetyTipsDialog mInternetSafetyTipsDialog;
    private String mLessonType = "";
    /* access modifiers changed from: private */
    public String mPlanId = "";
    /* access modifiers changed from: private */
    public int mRequestCounts = 1;
    /* access modifiers changed from: private */
    public long mRequestEnd;
    /* access modifiers changed from: private */
    public long mRequestStart;
    /* access modifiers changed from: private */
    public float mRequestSuccessCount;
    /* access modifiers changed from: private */
    public Integer normalAvgRoundTrip = 0;
    /* access modifiers changed from: private */
    public Integer normalAvgSuccessRate = 0;
    private String packageId = "";
    private String previousSource = "";
    /* access modifiers changed from: private */
    public String realName = "";
    private Integer subPlatformType = 0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PrepareClassPlaybackActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            iArr[StateData.DataStatus.ERROR.ordinal()] = 2;
            iArr[StateData.DataStatus.FAILURE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        PrepareClassPlaybackActivity.super.onCreate(bundle);
        Activity activity = (Activity) this;
        XesStatusBar.INSTANCE.setStatusBar(activity, false, 0, true);
        BarUtils.setStatusBarVisibility(activity, false);
        DownloadEngine.getInstance().pauseOnlineAll();
        initData();
        initViews();
        initNetstatusLottie();
        setValues();
    }

    private final void initData() {
        this.mPlanId = getIntent().getStringExtra(LearnMaterialsListActivityKt.PLANID);
        this.mLessonType = getIntent().getStringExtra("lessonType");
        this.previousSource = getIntent().getStringExtra("previousSource");
        this.packageId = getIntent().getStringExtra("packageId");
        this.mCourseId = getIntent().getStringExtra("courseId");
        this.mBizId = getIntent().getStringExtra("bizId");
        this.mEditSuccess = getIntent().getStringExtra("editSuccess");
        this.subPlatformType = Integer.valueOf(getIntent().getIntExtra("subPlatformType", 0));
        this.isTemp = getIntent().getStringExtra("isTemp");
        Intent intent = getIntent();
        this.isAuditor = intent != null && intent.getBooleanExtra("isAuditor", false);
        Intent intent2 = getIntent();
        this.isParentAudit = intent2 == null ? false : intent2.getBooleanExtra("isParentAudit", false);
        String str = this.TAG;
        XesLog.it(str, new Object[]{"进入回放课前下载页，是否是旁听生 = " + this.isAuditor + "，planId = " + this.mPlanId + "，courseId = " + this.mCourseId});
    }

    private final void initViews() {
        getBinding().prepareClassCourseDownLayout.setVisibility(8);
        getBinding().tvJoinClass.setText(getString(R.string.enter));
        getBinding().tvJoinClass.setEnabled(false);
        getBinding().tvJoinClass.getDelegate().setBackgroundColor(getColor(R.color.color_14ff503f));
        getBinding().tvJoinClass.setTextColor(ContextCompat.getColor((Context) this, R.color.color_ffaa0a));
    }

    private final void initNetstatusLottie() {
        getBinding().prepareClassLottie.setAnimation("data.json");
        getBinding().prepareClassLottie.setRepeatCount(-1);
        getBinding().prepareClassLottie.playAnimation();
    }

    private final void setValues() {
        if (!Intrinsics.areEqual((Object) LiveUrls.SCHOOL_CODE_US, (Object) ShareDataManager.getInstance().getString("school_code", "-1", ShareDataManager.SHAREDATA_NOT_CLEAR))) {
            RoundTextView roundTextView = getBinding().internetSafetyTips;
            if (roundTextView != null) {
                roundTextView.setVisibility(8);
            }
        } else if (!isFinishing()) {
            RoundTextView roundTextView2 = getBinding().internetSafetyTips;
            if (roundTextView2 != null) {
                roundTextView2.setVisibility(0);
            }
            View view = getBinding().internetSafetyTips;
            if (view != null) {
                RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(view, 500, new PrepareClassPlaybackActivity$setValues$1(this));
            }
        }
        View.OnClickListener onClickListener = this;
        getBinding().prepareClassBackIcon.setOnClickListener(onClickListener);
        getBinding().btCourseDownload.setOnClickListener(onClickListener);
        getBinding().btNetRefresh.setOnClickListener(onClickListener);
        getBinding().tvJoinClass.setOnClickListener(onClickListener);
        TextView textView = getBinding().tvJoinClassDifTime;
        if (textView != null) {
            textView.setText(getString(R.string.playback_prepare_class_prompt));
        }
        getMViewModel().requestPrepareData(Integer.valueOf(ParseUtils.tryParseInt(this.mPlanId, 0)));
        if (ImCoursesWareUtils.isCourseFinished$default(ImCoursesWareUtils.INSTANCE, this.mPlanId, true, (Boolean) null, 4, (Object) null)) {
            XesLog.it(this.TAG, new Object[]{"课件下载页>>>课件存在"});
            coursewareReady();
            return;
        }
        XesLog.it(this.TAG, new Object[]{"课件下载页>>>开始请求课件详情页接口"});
        ImCousesWare.INSTANCE.getCouseWareInfo(ParseUtils.tryParseInt(this.mPlanId, 0), true);
        ImCousesWare.INSTANCE.addCourseWareEventListener(new PrepareClassPlaybackActivity$setValues$2(this));
    }

    /* access modifiers changed from: private */
    public final void showProgressView(long j, long j2) {
        getBinding().btCourseDownload.setVisibility(8);
        getBinding().tvDownStatusFailed.setVisibility(8);
        getBinding().prepareDownloadTitle.setVisibility(0);
        getBinding().prepareDownloadExplanation.setVisibility(0);
        getBinding().prepareClassProgress.setVisibility(0);
        getBinding().prepareClassProgressContent.setVisibility(0);
        int i = (int) (((((float) j) * 1.0f) * ((float) 100)) / ((float) j2));
        if (i > getBinding().prepareClassProgress.getProgress()) {
            getBinding().prepareClassProgress.setProgress(i);
            double d = (double) 1048576;
            DecimalFormat decimalFormat = new DecimalFormat("0.0");
            String format = decimalFormat.format(((double) j) / d);
            Intrinsics.checkNotNullExpressionValue(format, "df.format(downNum)");
            String format2 = decimalFormat.format(((double) j2) / d);
            Intrinsics.checkNotNullExpressionValue(format2, "df.format(totalNum)");
            getBinding().prepareClassProgressContent.setText(getString(R.string.prepare_download_process, new Object[]{format, format2}));
            String str = this.TAG;
            XesLog.dt(str, new Object[]{"onProgress==" + j + "----" + j2});
        }
    }

    public final void showDownFailedView() {
        getBinding().prepareDownloadTitle.setVisibility(8);
        getBinding().prepareDownloadExplanation.setVisibility(8);
        getBinding().prepareClassProgress.setVisibility(8);
        getBinding().prepareClassProgressContent.setVisibility(8);
        getBinding().tvDownStatusFailed.setVisibility(0);
        Context context = (Context) this;
        getBinding().tvDownStatusFailed.setTextColor(ContextCompat.getColor(context, R.color.color_ff503f));
        getBinding().tvDownStatusFailed.setText(getString(R.string.prepare_download_failed));
        getBinding().btCourseDownload.setVisibility(0);
        getBinding().btCourseDownload.setClickable(true);
        getBinding().btCourseDownload.setTextColor(ContextCompat.getColor(context, R.color.color_ff503f));
        getBinding().btCourseDownload.setText(getString(R.string.prepare_class_redownload));
        getBinding().prepareDownloadIcon.setImageResource(R.drawable.prepare_class_down_failed);
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.prepare_class_download_icon);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        getBinding().btCourseDownload.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void coursewareReady() {
        /*
            r8 = this;
            java.lang.String r0 = r8.TAG
            r1 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
            java.lang.Object[] r3 = new java.lang.Object[r1]
            java.lang.String r4 = "课件准备就绪"
            r5 = 0
            r3[r5] = r4
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r0, r3)
            com.tal.app.thinkacademy.lib.download.operation.DownloadEngine r0 = com.tal.app.thinkacademy.lib.download.operation.DownloadEngine.getInstance()
            r0.resumeOnlineAll()
            java.io.File r0 = new java.io.File
            java.lang.String r3 = r8.mPlanId
            java.lang.String r3 = com.tal.app.thinkacademy.lib.download.util.AppCacheUtil.getClassRoomOfflineGraffitiPath(r3)
            r0.<init>(r3)
            boolean r3 = r0.exists()
            if (r3 == 0) goto L_0x0036
            java.lang.String[] r3 = r0.list()
            if (r3 != 0) goto L_0x0031
            r3 = r5
            goto L_0x0032
        L_0x0031:
            int r3 = r3.length
        L_0x0032:
            if (r3 <= 0) goto L_0x0036
            r3 = r1
            goto L_0x0037
        L_0x0036:
            r3 = r5
        L_0x0037:
            r4 = 0
            if (r3 == 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r0 = r4
        L_0x003c:
            if (r0 != 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r4 = r2
        L_0x0040:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.app.Application r6 = com.tal.app.thinkacademy.lib.language.AppUtil.getApplication()
            java.io.File r6 = r6.getFilesDir()
            java.lang.String r6 = r6.getAbsolutePath()
            r3.append(r6)
            java.lang.String r6 = "/course_zip/graffiti_"
            r3.append(r6)
            java.lang.String r6 = r8.mPlanId
            r3.append(r6)
            java.lang.String r6 = ".zip"
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r0.<init>(r3)
            boolean r0 = r0.exists()
            java.io.File r3 = new java.io.File
            java.lang.String r6 = r8.mPlanId
            java.lang.String r6 = com.tal.app.thinkacademy.lib.download.util.AppCacheUtil.getClassRoomOfflineMateInfoPath(r6)
            java.lang.String r7 = "mateinfo.txt"
            r3.<init>(r6, r7)
            boolean r3 = r3.exists()
            if (r0 != 0) goto L_0x009a
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x009a
            if (r3 == 0) goto L_0x009a
            java.lang.String r0 = r8.TAG
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "本地离线数据存在，无需下载"
            r1[r5] = r2
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r0, r1)
            r8.showDownFinishView()
            goto L_0x00d7
        L_0x009a:
            java.lang.String r2 = r8.TAG
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "本地离线数据不完整，需要下载 涂鸦是否存在："
            r6.append(r7)
            r6.append(r4)
            java.lang.String r4 = ",mateInfo是否存在："
            r6.append(r4)
            r6.append(r3)
            java.lang.String r3 = ",涂鸦zip包是否存在："
            r6.append(r3)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r1[r5] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r2, r1)
            com.tal.app.thinkacademy.common.base.BaseViewModel r0 = r8.getMViewModel()
            com.tal.app.thinkacademy.business.study.study.vm.PrepareClassVM r0 = (com.tal.app.thinkacademy.business.study.study.vm.PrepareClassVM) r0
            java.lang.String r1 = r8.mPlanId
            int r1 = com.tal.app.thinkacademy.lib.util.ParseUtils.tryParseInt(r1, r5)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.getOfflineData(r1)
        L_0x00d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.PrepareClassPlaybackActivity.coursewareReady():void");
    }

    /* access modifiers changed from: private */
    public final void showDownFinishView() {
        getBinding().prepareClassCourseDownLayout.setVisibility(0);
        getBinding().prepareDownloadTitle.setVisibility(8);
        getBinding().prepareDownloadExplanation.setVisibility(8);
        getBinding().prepareClassProgress.setVisibility(8);
        getBinding().prepareClassProgressContent.setVisibility(8);
        getBinding().tvDownStatusFailed.setVisibility(0);
        Context context = (Context) this;
        getBinding().tvDownStatusFailed.setTextColor(ContextCompat.getColor(context, R.color.color_172B4D));
        getBinding().tvDownStatusFailed.setText(getString(R.string.prepare_download_completed));
        getBinding().btCourseDownload.setVisibility(0);
        getBinding().btCourseDownload.setClickable(false);
        getBinding().btCourseDownload.getDelegate().setBackgroundColor(getColor(R.color.color_fff0fcf8));
        getBinding().btCourseDownload.setTextColor(ContextCompat.getColor(context, R.color.color_02ca8a));
        getBinding().btCourseDownload.setText(getString(R.string.prepare_download_completed_content));
        getBinding().prepareDownloadIcon.setImageResource(R.drawable.prepare_class_down_success);
        getBinding().btCourseDownload.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        setJoinBtnEnable();
        XesLog.dt(this.TAG, new Object[]{Intrinsics.stringPlus("showDownFinishView()==", Long.valueOf(this.allRoundTrip))});
    }

    public final void updateDownloadView() {
        if (!ImCoursesWareUtils.isCourseFinished$default(ImCoursesWareUtils.INSTANCE, this.mPlanId, true, (Boolean) null, 4, (Object) null)) {
            getBinding().tvDownStatusFailed.setVisibility(8);
            getBinding().btCourseDownload.setVisibility(8);
            getBinding().prepareDownloadTitle.setVisibility(0);
            getBinding().prepareDownloadExplanation.setVisibility(0);
            getBinding().prepareClassProgress.setVisibility(0);
            getBinding().prepareClassProgressContent.setVisibility(0);
            getBinding().prepareClassProgressContent.setText(getString(R.string.prepare_download_process, new Object[]{"0.0", "0.0"}));
            getBinding().prepareDownloadIcon.setImageResource(R.drawable.prepare_courseware_icon);
            return;
        }
        coursewareReady();
    }

    /* access modifiers changed from: private */
    public final void initStatusData() {
        Handler handler;
        getMViewModel().requestNetStatus();
        this.mRequestStart = System.currentTimeMillis();
        if (this.mDuration != null && (handler = this.mHandler) != null) {
            PrepareClassPlaybackActivity$$ExternalSyntheticLambda0 prepareClassPlaybackActivity$$ExternalSyntheticLambda0 = new PrepareClassPlaybackActivity$$ExternalSyntheticLambda0(this);
            Integer num = this.mDuration;
            Intrinsics.checkNotNull(num);
            handler.postDelayed(prepareClassPlaybackActivity$$ExternalSyntheticLambda0, ((long) num.intValue()) * ((long) 1000));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initStatusData$lambda-2  reason: not valid java name */
    public static final void m378initStatusData$lambda2(PrepareClassPlaybackActivity prepareClassPlaybackActivity) {
        Intrinsics.checkNotNullParameter(prepareClassPlaybackActivity, "this$0");
        prepareClassPlaybackActivity.isStopRequest = true;
        prepareClassPlaybackActivity.calculateNetResult();
    }

    private final void calculateNetResult() {
        String str = this.TAG;
        XesLog.it(str, new Object[]{"mRequestSuccessCount==" + this.mRequestSuccessCount + "，mRequestCounts==" + this.mRequestCounts + "，allRoundTrip==" + this.allRoundTrip});
        getBinding().prepareClassLottie.cancelAnimation();
        getBinding().prepareClassLottie.setVisibility(8);
        getBinding().btNetRefresh.setVisibility(0);
        float f = this.mRequestSuccessCount;
        String str2 = "网速很差";
        if (f > 0.0f) {
            float f2 = ((float) this.allRoundTrip) / f;
            this.avgRoundTrip = f2;
            this.avgSuccRate = (f / ((float) this.mRequestCounts)) * ((float) 100);
            Integer num = this.excellentAvgRoundTrip;
            Intrinsics.checkNotNull(num);
            if (f2 <= ((float) num.intValue())) {
                float f3 = this.avgSuccRate;
                Integer num2 = this.excellentAvgSuccessRate;
                Intrinsics.checkNotNull(num2);
                if (f3 >= ((float) num2.intValue())) {
                    getBinding().tvNetStatusContent.setVisibility(0);
                    getBinding().prepareNetTitle.setVisibility(8);
                    getBinding().prepareNetExplanation.setVisibility(8);
                    Context context = (Context) this;
                    getBinding().tvNetStatusContent.setTextColor(ContextCompat.getColor(context, R.color.color_172B4D));
                    getBinding().tvNetStatusContent.setText(getString(R.string.prepare_class_net_status_content_good));
                    getBinding().btNetRefresh.getDelegate().setBackgroundColor(getColor(R.color.color_fff0fcf8));
                    getBinding().btNetRefresh.setTextColor(ContextCompat.getColor(context, R.color.color_02ca8a));
                    getBinding().btNetRefresh.setText(getString(R.string.prepare_class_net_good));
                    getBinding().prepareWifiIcon.setImageResource(R.drawable.prepare_class_net_status_good);
                    getBinding().btNetRefresh.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    getBinding().btNetRefresh.setClickable(false);
                    str2 = "网速良好";
                }
            }
            float f4 = this.avgRoundTrip;
            Integer num3 = this.normalAvgRoundTrip;
            Intrinsics.checkNotNull(num3);
            if (f4 <= ((float) num3.intValue())) {
                float f5 = this.avgSuccRate;
                Integer num4 = this.normalAvgSuccessRate;
                Intrinsics.checkNotNull(num4);
                if (f5 >= ((float) num4.intValue())) {
                    getBinding().tvNetStatusContent.setVisibility(0);
                    getBinding().prepareNetTitle.setVisibility(8);
                    getBinding().prepareNetExplanation.setVisibility(8);
                    Context context2 = (Context) this;
                    getBinding().tvNetStatusContent.setTextColor(ContextCompat.getColor(context2, R.color.color_ffaa0a));
                    getBinding().tvNetStatusContent.setText(getString(R.string.prepare_class_net_status_content_normal));
                    getBinding().btNetRefresh.getDelegate().setBackgroundColor(getColor(R.color.color_fff9ec));
                    getBinding().btNetRefresh.setTextColor(ContextCompat.getColor(context2, R.color.color_ffaa0a));
                    getBinding().btNetRefresh.setText(getString(R.string.prepare_class_net_normal));
                    getBinding().prepareWifiIcon.setImageResource(R.drawable.prepare_class_net_status_nomal);
                    getBinding().btNetRefresh.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    getBinding().btNetRefresh.setClickable(false);
                    str2 = "网速一般";
                }
            }
            showNetRefreshVIew();
        } else {
            showNetRefreshVIew();
        }
        this.avgRoundTrip = 0.0f;
        this.allRoundTrip = 0;
        this.mRequestSuccessCount = 0.0f;
        this.avgSuccRate = 0.0f;
        this.mRequestCounts = 1;
        new NetworkQualityBean((int) 0.0f, (int) 0.0f, 1, str2);
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("avgRoundTrip", Integer.valueOf((int) this.avgRoundTrip));
            jsonObject.addProperty("avgSuccRate", Integer.valueOf((int) this.avgSuccRate));
            jsonObject.addProperty("reqTimes", Integer.valueOf(this.mRequestCounts));
            jsonObject.addProperty(DbParams.KEY_CHANNEL_RESULT, str2);
            XesLog.ut("userApiNetworkQuality", jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private final void showNetRefreshVIew() {
        getBinding().tvNetStatusContent.setVisibility(8);
        getBinding().prepareNetTitle.setVisibility(0);
        getBinding().prepareNetExplanation.setVisibility(0);
        getBinding().btNetRefresh.getDelegate().setBackgroundColor(getColor(R.color.color_14ff503f));
        Context context = (Context) this;
        getBinding().btNetRefresh.setTextColor(ContextCompat.getColor(context, R.color.color_ff503f));
        getBinding().btNetRefresh.setText(getString(R.string.prepare_class_net_retest));
        getBinding().prepareWifiIcon.setImageResource(R.drawable.prepare_class_net_status_weak);
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.prepare_class_refresh_icon);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        getBinding().btNetRefresh.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        getBinding().btNetRefresh.setClickable(true);
    }

    public void startObserve() {
        PrepareClassPlaybackActivity.super.startObserve();
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getMViewModel().getNetStatus().observe(lifecycleOwner, new PrepareClassPlaybackActivity$startObserve$$inlined$observe$1(this));
        getMViewModel().getPrepareDataStatus().observe(lifecycleOwner, new PrepareClassPlaybackActivity$startObserve$$inlined$observe$2(this));
        getMViewModel().getOfflineZip().observe(lifecycleOwner, new PrepareClassPlaybackActivity$startObserve$$inlined$observe$3(this));
    }

    /* access modifiers changed from: private */
    public final void setJoinBtnEnable() {
        XesLog.it(this.TAG, new Object[]{"enter按钮可点"});
        getBinding().tvJoinClass.setEnabled(true);
        getBinding().tvJoinClass.getDelegate().setBackgroundColor(getColor(R.color.color_ffaa0a));
        getBinding().tvJoinClass.setTextColor(ContextCompat.getColor((Context) this, R.color.color_ffffff));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        PrepareClassPlaybackActivity.super.onDestroy();
        DownloadEngine.getInstance().resumeOnlineAll();
        this.mInternetSafetyTipsDialog = null;
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, PrepareClassPlaybackActivity.class);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i = R.id.prepare_class_back_icon;
        if (valueOf != null && valueOf.intValue() == i) {
            ImCousesWare.INSTANCE.addCourseWareEventListener((ImCousesWare.CourseWareCallBack) null);
            ImCoursesWareUtils.INSTANCE.clearCourseWareEventListener();
            finish();
        } else {
            int i2 = R.id.bt_course_download;
            if (valueOf == null || valueOf.intValue() != i2) {
                int i3 = R.id.bt_net_refresh;
                if (valueOf != null && valueOf.intValue() == i3) {
                    getBinding().btNetRefresh.setVisibility(8);
                    getBinding().prepareClassLottie.setVisibility(0);
                    getBinding().prepareClassLottie.playAnimation();
                    initStatusData();
                    this.isStopRequest = false;
                    getBinding().tvNetStatusContent.setVisibility(0);
                    getBinding().prepareNetTitle.setVisibility(8);
                    getBinding().prepareNetExplanation.setVisibility(8);
                    getBinding().tvNetStatusContent.setTextColor(ContextCompat.getColor((Context) this, R.color.color_172B4D));
                    getBinding().prepareWifiIcon.setImageResource(R.drawable.icon_prepare_class_wifi);
                    getBinding().tvNetStatusContent.setText(getString(R.string.prepare_wifi_title));
                } else {
                    int i4 = R.id.tv_join_class;
                    if (valueOf != null && valueOf.intValue() == i4) {
                        XesLog.dt(this.TAG, new Object[]{Intrinsics.stringPlus("点击enter,进入房间==", Long.valueOf(this.allRoundTrip))});
                        ImCousesWare.INSTANCE.addCourseWareEventListener((ImCousesWare.CourseWareCallBack) null);
                        ImCoursesWareUtils.INSTANCE.clearCourseWareEventListener();
                        HashMap hashMap = new HashMap();
                        Map map = hashMap;
                        map.put("lesson_id", this.mPlanId);
                        map.put("live_button_path", "learning_detail_page");
                        LeanplumUtil.commonTrack("click_enter_live_button", hashMap);
                        StudyCenterUtil.Companion.enterPlayBack(this.mPlanId, this.mCourseId, this.mBizId, this.subPlatformType, this.isBindCourseware, this.mLessonType, this.previousSource, this.packageId);
                        finish();
                    }
                }
            } else if (this.mPlanId != null) {
                ImCoursesWareUtils imCoursesWareUtils = ImCoursesWareUtils.INSTANCE;
                String str = this.mPlanId;
                Intrinsics.checkNotNull(str);
                ImCoursesWareUtils.isUpdateCourse$default(imCoursesWareUtils, str, true, (Boolean) null, 4, (Object) null);
                updateDownloadView();
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void onBackPressed() {
        ImCousesWare.INSTANCE.addCourseWareEventListener((ImCousesWare.CourseWareCallBack) null);
        ImCoursesWareUtils.INSTANCE.clearCourseWareEventListener();
        PrepareClassPlaybackActivity.super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public ActivityPrepareLayoutBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityPrepareLayoutBinding inflate = ActivityPrepareLayoutBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }
}
