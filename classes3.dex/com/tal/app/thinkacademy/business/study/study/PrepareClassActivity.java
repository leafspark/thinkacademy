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
import com.google.gson.JsonObject;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.study.study.dialog.CheckInDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.CheckInFaildDialog;
import com.tal.app.thinkacademy.business.study.study.dialog.CheckInSuccessDialog;
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
import com.tal.app.thinkacademy.common.utils.StudyCenterUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.download.operation.DownloadEngine;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.BarUtils;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.util.TimeUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010K\u001a\u00020LH\u0002J\b\u0010M\u001a\u00020LH\u0002J\u0018\u0010N\u001a\u00020\u00032\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u0013H\u0014J\b\u0010R\u001a\u00020LH\u0002J\b\u0010S\u001a\u00020LH\u0002J\b\u0010T\u001a\u00020LH\u0002J\b\u0010U\u001a\u00020LH\u0002J\u0012\u0010V\u001a\u00020L2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\u0012\u0010Y\u001a\u00020L2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0014J\b\u0010\\\u001a\u00020LH\u0014J\b\u0010]\u001a\u00020LH\u0002J\b\u0010^\u001a\u00020LH\u0002J\u0006\u0010_\u001a\u00020LJ\u0006\u0010`\u001a\u00020LJ\b\u0010a\u001a\u00020LH\u0002J\b\u0010b\u001a\u00020LH\u0016J\u0010\u0010c\u001a\u00020L2\u0006\u0010d\u001a\u00020\u0007H\u0002J\u0006\u0010e\u001a\u00020LR\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010%\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010/R\u0010\u00100\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010:\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010/R\u0010\u0010;\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010>\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010?\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010@\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010C\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/PrepareClassActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/study/study/vm/PrepareClassVM;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/ActivityPrepareLayoutBinding;", "Landroid/view/View$OnClickListener;", "()V", "TAG", "", "allRoundTrip", "", "avgRoundTrip", "", "avgSuccRate", "downloadStart", "excellentAvgRoundTrip", "", "Ljava/lang/Integer;", "excellentAvgSuccessRate", "isAuditor", "", "isBindCourseware", "isLive", "isParentAudit", "isStopRequest", "isTemp", "mBizId", "mCheckInDialog", "Lcom/tal/app/thinkacademy/business/study/study/dialog/CheckInDialog;", "mCheckInFaildDialog", "Lcom/tal/app/thinkacademy/business/study/study/dialog/CheckInFaildDialog;", "mCheckInSuccessDialog", "Lcom/tal/app/thinkacademy/business/study/study/dialog/CheckInSuccessDialog;", "mCourseId", "mDelay", "mDestroy", "mDownloadState", "mDuration", "mEditSuccess", "mEndDownloadTime", "mHandler", "Landroid/os/Handler;", "mHasDownFinished", "mInternetSafetyTipsDialog", "Lcom/tal/app/thinkacademy/business/study/study/dialog/InternetSafetyTipsDialog;", "mLessonType", "mNetState", "mNowTime", "Ljava/lang/Long;", "mPlanId", "mPreProcess", "mProcess", "mQuitOutDialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "mRequestCounts", "mRequestEnd", "mRequestStart", "mRequestSuccessCount", "mStartDownloadTime", "mStartTime", "mZipSize", "mZipStartDownloadSize", "mZipUrl", "normalAvgRoundTrip", "normalAvgSuccessRate", "packageId", "previousSource", "realName", "subPlatformType", "tickedRefreshRunnable", "Ljava/lang/Runnable;", "tvCancel", "Landroid/widget/TextView;", "tvExit", "tvMsgContent", "tvMsgTip", "calculateNetResult", "", "calculateStartClassTime", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "initData", "initNetstatusLottie", "initStatusData", "initViews", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setValues", "showDialog", "showDownFailedView", "showDownFinishView", "showNetRefreshVIew", "startObserve", "trackJoinClass", "type", "updateDownloadView", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrepareClassActivity.kt */
public final class PrepareClassActivity extends BaseVmActivity<PrepareClassVM, ActivityPrepareLayoutBinding> implements View.OnClickListener {
    private final String TAG = "PrepareClassActivity";
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
    /* access modifiers changed from: private */
    public boolean isAuditor;
    /* access modifiers changed from: private */
    public boolean isBindCourseware = true;
    /* access modifiers changed from: private */
    public boolean isLive = true;
    /* access modifiers changed from: private */
    public boolean isParentAudit;
    /* access modifiers changed from: private */
    public boolean isStopRequest;
    private String isTemp = "";
    private String mBizId = "";
    /* access modifiers changed from: private */
    public CheckInDialog mCheckInDialog;
    /* access modifiers changed from: private */
    public CheckInFaildDialog mCheckInFaildDialog;
    /* access modifiers changed from: private */
    public CheckInSuccessDialog mCheckInSuccessDialog;
    /* access modifiers changed from: private */
    public String mCourseId = "";
    /* access modifiers changed from: private */
    public long mDelay;
    /* access modifiers changed from: private */
    public boolean mDestroy;
    private String mDownloadState = "下载中";
    /* access modifiers changed from: private */
    public Integer mDuration = 10;
    private String mEditSuccess = "0";
    /* access modifiers changed from: private */
    public long mEndDownloadTime;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public boolean mHasDownFinished;
    /* access modifiers changed from: private */
    public InternetSafetyTipsDialog mInternetSafetyTipsDialog;
    private String mLessonType = "";
    private String mNetState;
    /* access modifiers changed from: private */
    public Long mNowTime = 0L;
    /* access modifiers changed from: private */
    public String mPlanId = "";
    /* access modifiers changed from: private */
    public int mPreProcess;
    /* access modifiers changed from: private */
    public int mProcess;
    private BaseDialog mQuitOutDialog;
    /* access modifiers changed from: private */
    public int mRequestCounts = 1;
    /* access modifiers changed from: private */
    public long mRequestEnd;
    /* access modifiers changed from: private */
    public long mRequestStart;
    /* access modifiers changed from: private */
    public float mRequestSuccessCount;
    private long mStartDownloadTime;
    /* access modifiers changed from: private */
    public Long mStartTime = 0L;
    /* access modifiers changed from: private */
    public String mZipSize;
    /* access modifiers changed from: private */
    public long mZipStartDownloadSize;
    /* access modifiers changed from: private */
    public String mZipUrl;
    /* access modifiers changed from: private */
    public Integer normalAvgRoundTrip = 0;
    /* access modifiers changed from: private */
    public Integer normalAvgSuccessRate = 0;
    private String packageId = "";
    private String previousSource = "";
    /* access modifiers changed from: private */
    public String realName = "";
    /* access modifiers changed from: private */
    public Integer subPlatformType = 0;
    private Runnable tickedRefreshRunnable = new PrepareClassActivity$tickedRefreshRunnable$1(this);
    private TextView tvCancel;
    private TextView tvExit;
    private TextView tvMsgContent;
    private TextView tvMsgTip;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PrepareClassActivity.kt */
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
    public ActivityPrepareLayoutBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityPrepareLayoutBinding inflate = ActivityPrepareLayoutBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        PrepareClassActivity.super.onCreate(bundle);
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
        this.isLive = intent == null ? true : intent.getBooleanExtra("isLive", true);
        Intent intent2 = getIntent();
        this.isAuditor = intent2 != null && intent2.getBooleanExtra("isAuditor", false);
        Intent intent3 = getIntent();
        this.isParentAudit = intent3 == null ? false : intent3.getBooleanExtra("isParentAudit", false);
        XesLog.it(this.TAG, new Object[]{Intrinsics.stringPlus("是否是旁听生:", Boolean.valueOf(this.isAuditor))});
        this.mStartDownloadTime = System.currentTimeMillis();
    }

    private final void initViews() {
        getBinding().prepareClassCourseDownLayout.setVisibility(8);
        getBinding().tvJoinClass.setEnabled(false);
    }

    private final void initNetstatusLottie() {
        getBinding().prepareClassLottie.setAnimation("data.json");
        getBinding().prepareClassLottie.setRepeatCount(-1);
        getBinding().prepareClassLottie.playAnimation();
    }

    private final void setValues() {
        if (!Intrinsics.areEqual((Object) LiveUrls.SCHOOL_CODE_US, (Object) ShareDataManager.getInstance().getString("school_code", "-1", ShareDataManager.SHAREDATA_NOT_CLEAR))) {
            getBinding().internetSafetyTips.setVisibility(8);
        } else if (!isFinishing()) {
            getBinding().internetSafetyTips.setVisibility(0);
            RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
            View view = getBinding().internetSafetyTips;
            Intrinsics.checkNotNullExpressionValue(view, "binding.internetSafetyTips");
            rxUnDoubleUtil.setOnUnDoubleClickListener(view, 500, new PrepareClassActivity$setValues$1(this));
        }
        ShareDataManager.getInstance().put(Intrinsics.stringPlus("planId-", this.mPlanId), Intrinsics.stringPlus("planId-", this.mPlanId), ShareDataManager.SHAREDATA_CAN_CLEAR);
        View.OnClickListener onClickListener = this;
        getBinding().prepareClassBackIcon.setOnClickListener(onClickListener);
        getBinding().btCourseDownload.setOnClickListener(onClickListener);
        getBinding().btNetRefresh.setOnClickListener(onClickListener);
        getBinding().tvJoinClass.setOnClickListener(onClickListener);
        if (!this.isLive) {
            getBinding().tvJoinClassDifTime.setText(getString(R.string.playback_prepare_class_prompt));
        }
        getMViewModel().requestPrepareData(Integer.valueOf(ParseUtils.tryParseInt(this.mPlanId, 0)));
        XesLog.it("GetCourseWareContentLog", new Object[]{"课件下载页>>>开始请求课件详情页接口"});
        ImCousesWare.INSTANCE.getCouseWareInfo(ParseUtils.tryParseInt(this.mPlanId, 0), true);
        ImCousesWare.INSTANCE.addCourseWareEventListener(new PrepareClassActivity$setValues$2(this));
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

    public final void showDownFinishView() {
        this.mHasDownFinished = true;
        DownloadEngine.getInstance().resumeOnlineAll();
        ImCoursesWareUtils.INSTANCE.clearCourseWareEventListener();
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
        getBinding().tvJoinClass.getDelegate().setBackgroundColor(getColor(R.color.color_ffaa0a));
        getBinding().tvJoinClass.setTextColor(ContextCompat.getColor(context, R.color.color_ffffff));
        getBinding().tvJoinClass.setClickable(true);
        XesLog.dt("PrepareClassActivity", new Object[]{Intrinsics.stringPlus("showDownFinishView()==", Long.valueOf(this.allRoundTrip))});
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
        showDownFinishView();
    }

    /* access modifiers changed from: private */
    public final void initStatusData() {
        Handler handler;
        getMViewModel().requestNetStatus();
        this.mRequestStart = System.currentTimeMillis();
        if (this.mDuration != null && (handler = this.mHandler) != null) {
            PrepareClassActivity$$ExternalSyntheticLambda2 prepareClassActivity$$ExternalSyntheticLambda2 = new PrepareClassActivity$$ExternalSyntheticLambda2(this);
            Integer num = this.mDuration;
            Intrinsics.checkNotNull(num);
            handler.postDelayed(prepareClassActivity$$ExternalSyntheticLambda2, ((long) num.intValue()) * ((long) 1000));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initStatusData$lambda-0  reason: not valid java name */
    public static final void m375initStatusData$lambda0(PrepareClassActivity prepareClassActivity) {
        Intrinsics.checkNotNullParameter(prepareClassActivity, "this$0");
        prepareClassActivity.isStopRequest = true;
        prepareClassActivity.calculateNetResult();
    }

    private final void calculateNetResult() {
        XesLog.it("PrepareClassActivity", new Object[]{"mRequestSuccessCount==" + this.mRequestSuccessCount + "----mRequestCounts==" + this.mRequestCounts});
        XesLog.it("PrepareClassActivity", new Object[]{Intrinsics.stringPlus("allRoundTrip==", Long.valueOf(this.allRoundTrip))});
        getBinding().prepareClassLottie.cancelAnimation();
        getBinding().prepareClassLottie.setVisibility(8);
        getBinding().btNetRefresh.setVisibility(0);
        float f = this.mRequestSuccessCount;
        String str = "网速很差";
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
                    str = "网速良好";
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
                    str = "网速一般";
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
        new NetworkQualityBean((int) 0.0f, (int) 0.0f, 1, str);
        this.mNetState = str;
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("avgRoundTrip", Integer.valueOf((int) this.avgRoundTrip));
            jsonObject.addProperty("avgSuccRate", Integer.valueOf((int) this.avgSuccRate));
            jsonObject.addProperty("reqTimes", Integer.valueOf(this.mRequestCounts));
            jsonObject.addProperty(DbParams.KEY_CHANNEL_RESULT, str);
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
        PrepareClassActivity.super.startObserve();
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getMViewModel().getNetStatus().observe(lifecycleOwner, new PrepareClassActivity$startObserve$$inlined$observe$1(this));
        getMViewModel().getPrepareDataStatus().observe(lifecycleOwner, new PrepareClassActivity$startObserve$$inlined$observe$2(this));
        getMViewModel().getPrepareCheckInStatus().observe(lifecycleOwner, new PrepareClassActivity$startObserve$$inlined$observe$3(this));
        getMViewModel().getPrepareCheckInData().observe(lifecycleOwner, new PrepareClassActivity$startObserve$$inlined$observe$4(this));
    }

    /* access modifiers changed from: private */
    public final void calculateStartClassTime() {
        Handler handler;
        Long l = this.mStartTime;
        if (l != null && this.mNowTime != null) {
            Intrinsics.checkNotNull(l);
            long longValue = l.longValue();
            Long l2 = this.mNowTime;
            Intrinsics.checkNotNull(l2);
            if (longValue < l2.longValue()) {
                Long l3 = this.mNowTime;
                Intrinsics.checkNotNull(l3);
                long j = (long) 1000;
                Long l4 = this.mStartTime;
                Intrinsics.checkNotNull(l4);
                this.mDelay = TimeUtils.getTimeSpan(l3.longValue() * j, l4.longValue() * j, 60000);
                if (this.isLive) {
                    getBinding().tvJoinClassDifTime.setText(getString(R.string.prepare_class_start_status_ago, new Object[]{Long.valueOf(this.mDelay)}));
                }
            } else {
                Long l5 = this.mStartTime;
                Intrinsics.checkNotNull(l5);
                long j2 = (long) 1000;
                Long l6 = this.mNowTime;
                Intrinsics.checkNotNull(l6);
                this.mDelay = TimeUtils.getTimeSpan(l5.longValue() * j2, l6.longValue() * j2, 60000);
                if (this.isLive) {
                    getBinding().tvJoinClassDifTime.setText(getString(R.string.prepare_class_start_status, new Object[]{Long.valueOf(this.mDelay)}));
                }
            }
            Runnable runnable = this.tickedRefreshRunnable;
            if (runnable != null && (handler = this.mHandler) != null) {
                handler.postDelayed(runnable, 60000);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        PrepareClassActivity.super.onDestroy();
        this.mDestroy = true;
        DownloadEngine.getInstance().resumeOnlineAll();
        Handler handler = this.mHandler;
        if (handler != null) {
            this.tickedRefreshRunnable = null;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            this.mHandler = null;
        }
        this.mCheckInDialog = null;
        this.mCheckInSuccessDialog = null;
        this.mCheckInFaildDialog = null;
        this.mInternetSafetyTipsDialog = null;
    }

    public void onClick(View view) {
        View view2 = view;
        MethodInfo.onClickEventEnter(view2, PrepareClassActivity.class);
        Integer valueOf = view2 == null ? null : Integer.valueOf(view.getId());
        int i = R.id.prepare_class_back_icon;
        if (valueOf != null && valueOf.intValue() == i) {
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
                        XesLog.dt("PrepareClassActivity", new Object[]{Intrinsics.stringPlus("showDownFinishView()==", Long.valueOf(this.allRoundTrip))});
                        if (this.mHasDownFinished) {
                            trackJoinClass("正常进课");
                            if (this.isLive) {
                                StudyCenterUtil.Companion.enterLiveVideo(this.mPlanId, this.mCourseId, this.mBizId, this.mEditSuccess, this.subPlatformType, this.isTemp, this.isBindCourseware, this.isParentAudit, this.isAuditor, this.mLessonType, this.previousSource, this.packageId);
                            } else {
                                StudyCenterUtil.Companion.enterPlayBack(this.mPlanId, this.mCourseId, this.mBizId, this.subPlatformType, this.isBindCourseware, this.mLessonType, this.previousSource, this.packageId);
                            }
                            finish();
                        } else {
                            showDialog();
                        }
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

    /* JADX WARNING: type inference failed for: r0v17, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void showDialog() {
        /*
            r3 = this;
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r0 = r3.mQuitOutDialog
            if (r0 != 0) goto L_0x00a5
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r0 = new com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog
            r1 = r3
            android.content.Context r1 = (android.content.Context) r1
            r0.<init>(r1)
            r3.mQuitOutDialog = r0
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.layout.prepare_class_dialog_join_class
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r0 = r0.contentView(r1)
            if (r0 != 0) goto L_0x0017
            goto L_0x0024
        L_0x0017:
            r1 = 17
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r0 = r0.gravity(r1)
            if (r0 != 0) goto L_0x0020
            goto L_0x0024
        L_0x0020:
            r1 = 1
            r0.canceledOnTouchOutside(r1)
        L_0x0024:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r0 = r3.mQuitOutDialog
            r1 = 0
            if (r0 != 0) goto L_0x002b
            r0 = r1
            goto L_0x0033
        L_0x002b:
            int r2 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_dialog_title
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0033:
            r3.tvMsgTip = r0
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r0 = r3.mQuitOutDialog
            if (r0 != 0) goto L_0x003b
            r0 = r1
            goto L_0x0043
        L_0x003b:
            int r2 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_cancel
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0043:
            r3.tvCancel = r0
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r0 = r3.mQuitOutDialog
            if (r0 != 0) goto L_0x004b
            r0 = r1
            goto L_0x0053
        L_0x004b:
            int r2 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_confirm
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0053:
            r3.tvExit = r0
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r0 = r3.mQuitOutDialog
            if (r0 != 0) goto L_0x005a
            goto L_0x0063
        L_0x005a:
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_dialog_content
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x0063:
            r3.tvMsgContent = r1
            if (r1 != 0) goto L_0x0068
            goto L_0x006d
        L_0x0068:
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.string.prepare_class_dialog_content
            r1.setText(r0)
        L_0x006d:
            android.widget.TextView r0 = r3.tvMsgTip
            if (r0 != 0) goto L_0x0072
            goto L_0x0077
        L_0x0072:
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.string.prepare_class_dialog_title
            r0.setText(r1)
        L_0x0077:
            android.widget.TextView r0 = r3.tvExit
            if (r0 != 0) goto L_0x007c
            goto L_0x0081
        L_0x007c:
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.string.prepare_class_dialog_continue
            r0.setText(r1)
        L_0x0081:
            android.widget.TextView r0 = r3.tvCancel
            if (r0 != 0) goto L_0x0086
            goto L_0x008b
        L_0x0086:
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.string.prepare_join_text
            r0.setText(r1)
        L_0x008b:
            android.widget.TextView r0 = r3.tvExit
            if (r0 != 0) goto L_0x0090
            goto L_0x0098
        L_0x0090:
            com.tal.app.thinkacademy.business.study.study.PrepareClassActivity$$ExternalSyntheticLambda1 r1 = new com.tal.app.thinkacademy.business.study.study.PrepareClassActivity$$ExternalSyntheticLambda1
            r1.<init>(r3)
            r0.setOnClickListener(r1)
        L_0x0098:
            android.widget.TextView r0 = r3.tvCancel
            if (r0 != 0) goto L_0x009d
            goto L_0x00a5
        L_0x009d:
            com.tal.app.thinkacademy.business.study.study.PrepareClassActivity$$ExternalSyntheticLambda0 r1 = new com.tal.app.thinkacademy.business.study.study.PrepareClassActivity$$ExternalSyntheticLambda0
            r1.<init>(r3)
            r0.setOnClickListener(r1)
        L_0x00a5:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r0 = r3.mQuitOutDialog
            if (r0 != 0) goto L_0x00aa
            goto L_0x00ad
        L_0x00aa:
            r0.show()
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.PrepareClassActivity.showDialog():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: showDialog$lambda-8  reason: not valid java name */
    public static final void m376showDialog$lambda8(PrepareClassActivity prepareClassActivity, View view) {
        Intrinsics.checkNotNullParameter(prepareClassActivity, "this$0");
        BaseDialog baseDialog = prepareClassActivity.mQuitOutDialog;
        if (baseDialog != null) {
            baseDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showDialog$lambda-9  reason: not valid java name */
    public static final void m377showDialog$lambda9(PrepareClassActivity prepareClassActivity, View view) {
        PrepareClassActivity prepareClassActivity2 = prepareClassActivity;
        Intrinsics.checkNotNullParameter(prepareClassActivity2, "this$0");
        BaseDialog baseDialog = prepareClassActivity2.mQuitOutDialog;
        if (baseDialog != null) {
            baseDialog.dismiss();
        }
        prepareClassActivity2.trackJoinClass("强行进课");
        if (prepareClassActivity2.isLive) {
            StudyCenterUtil.Companion.enterLiveVideo(prepareClassActivity2.mPlanId, prepareClassActivity2.mCourseId, prepareClassActivity2.mBizId, prepareClassActivity2.mEditSuccess, prepareClassActivity2.subPlatformType, prepareClassActivity2.isTemp, prepareClassActivity2.isBindCourseware, prepareClassActivity2.isParentAudit, prepareClassActivity2.isAuditor, prepareClassActivity2.mLessonType, prepareClassActivity2.previousSource, prepareClassActivity2.packageId);
        } else {
            StudyCenterUtil.Companion.enterPlayBack(prepareClassActivity2.mPlanId, prepareClassActivity2.mCourseId, prepareClassActivity2.mBizId, prepareClassActivity2.subPlatformType, prepareClassActivity2.isBindCourseware, prepareClassActivity2.mLessonType, prepareClassActivity2.previousSource, prepareClassActivity2.packageId);
        }
        prepareClassActivity.finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void trackJoinClass(String str) {
        if (ImCoursesWareUtils.isCourseFinished$default(ImCoursesWareUtils.INSTANCE, this.mPlanId, true, (Boolean) null, 4, (Object) null)) {
            this.mDownloadState = "下载完成";
            if (this.mEndDownloadTime == 0) {
                this.mZipStartDownloadSize = -1;
            }
        } else if (this.mEndDownloadTime != 0) {
            this.mDownloadState = "下载失败";
        } else {
            this.mDownloadState = "下载中";
            System.currentTimeMillis();
        }
    }
}
