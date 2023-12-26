package com.tal.app.thinkacademy.business.shop.gradeaggregate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.ShopUtils;
import com.tal.app.thinkacademy.business.shop.adapter.GradeAggregateAdapter;
import com.tal.app.thinkacademy.business.shop.bean.GradeAggregateClassListData;
import com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData;
import com.tal.app.thinkacademy.business.shop.classdetail.StudentInfo;
import com.tal.app.thinkacademy.business.shop.databinding.ActivityGradeAggregateBinding;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.business.shop.viewmodel.GradeAggregateVm;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.XesBaseActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.constants.UrlUtils;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.utils.TextHighLightUtil;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\nH\u0014J\u0006\u0010'\u001a\u00020\u0002J\b\u0010(\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020!H\u0002J\u0012\u0010*\u001a\u00020!2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010+\u001a\u00020!H\u0002J\b\u0010,\u001a\u00020!H\u0002J\b\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020!H\u0002J\b\u0010/\u001a\u00020!H\u0002J\u0012\u00100\u001a\u00020!2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\b\u00103\u001a\u00020!H\u0014J\b\u00104\u001a\u00020!H\u0014J\b\u00105\u001a\u00020!H\u0014J\b\u00106\u001a\u00020!H\u0014J\b\u00107\u001a\u00020!H\u0014J\b\u00108\u001a\u00020!H\u0002J\b\u00109\u001a\u00020!H\u0002J\u0014\u0010:\u001a\u00020!2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010<\u001a\u00020!H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/gradeaggregate/GradeAggregateActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/shop/viewmodel/GradeAggregateVm;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ActivityGradeAggregateBinding;", "()V", "classIndex", "", "examId", "", "havaClassItem", "", "isNeedSubmitInfor", "mFootView", "Landroid/view/View;", "mGradeAggregateAdapter", "Lcom/tal/app/thinkacademy/business/shop/adapter/GradeAggregateAdapter;", "mGradeAggregateP", "Lcom/tal/app/thinkacademy/business/shop/gradeaggregate/GradeAggregateP;", "mIsShowFrom", "mIsShowLesson", "mLinearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mMainData", "Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateDetailInfo;", "mPageId", "mSchoolCode", "mShowPrice", "mStudentInfo", "Lcom/tal/app/thinkacademy/business/shop/classdetail/StudentInfo;", "mVideoModel", "Lcom/tal/app/thinkacademy/business/shop/gradeaggregate/VideoModel;", "mVideoView", "addFootView", "", "addVideoHead", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "getGradeViewModel", "getMainData", "goToShare", "gotoAdmissionTest", "gotoLogin", "initAdapter", "initData", "initListener", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "removeVideoHead", "setBottomPrice", "showMainDataEmpty", "msg", "startObserve", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateActivity.kt */
public final class GradeAggregateActivity extends BaseVmActivity<GradeAggregateVm, ActivityGradeAggregateBinding> {
    /* access modifiers changed from: private */
    public int classIndex = -1;
    /* access modifiers changed from: private */
    public String examId = "";
    /* access modifiers changed from: private */
    public boolean havaClassItem;
    /* access modifiers changed from: private */
    public boolean isNeedSubmitInfor;
    private View mFootView;
    /* access modifiers changed from: private */
    public GradeAggregateAdapter mGradeAggregateAdapter;
    private GradeAggregateP mGradeAggregateP;
    private boolean mIsShowFrom;
    private boolean mIsShowLesson;
    /* access modifiers changed from: private */
    public LinearLayoutManager mLinearLayoutManager;
    private GradeAggregateDetailInfo mMainData;
    /* access modifiers changed from: private */
    public int mPageId = -1;
    private String mSchoolCode;
    private int mShowPrice;
    private StudentInfo mStudentInfo;
    private VideoModel mVideoModel;
    /* access modifiers changed from: private */
    public View mVideoView;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GradeAggregateActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GradeAggregateActivity() {
        String string = ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(…SHAREDATA_NOT_CLEAR\n    )");
        this.mSchoolCode = string;
    }

    /* access modifiers changed from: protected */
    public ActivityGradeAggregateBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityGradeAggregateBinding inflate = ActivityGradeAggregateBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        GradeAggregateActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, -1, false);
        StudentInfo studentInfo = new StudentInfo(getMViewModel(), (XesBaseActivity) this, new GradeAggregateActivity$onCreate$1(this));
        this.mStudentInfo = studentInfo;
        studentInfo.viewmModelObserve();
        GradeAggregateP gradeAggregateP = new GradeAggregateP(getMViewModel(), this);
        this.mGradeAggregateP = gradeAggregateP;
        gradeAggregateP.viewmModelObserve();
        this.mVideoModel = new VideoModel(this);
        initData();
        initView();
        initListener();
        getMainData();
    }

    private final void initData() {
        Intent intent = getIntent();
        int i = -1;
        if (intent != null) {
            i = intent.getIntExtra("pageId", -1);
        }
        this.mPageId = i;
        Intent intent2 = getIntent();
        int i2 = 0;
        this.mIsShowFrom = intent2 == null ? false : intent2.getBooleanExtra("isShowFrom", false);
        Intent intent3 = getIntent();
        this.mIsShowLesson = intent3 == null ? false : intent3.getBooleanExtra("isShowLesson", false);
        Intent intent4 = getIntent();
        if (intent4 != null) {
            i2 = intent4.getIntExtra("showPrice", 0);
        }
        this.mShowPrice = i2;
    }

    private final void initView() {
        initAdapter();
        setBottomPrice();
    }

    private final void initListener() {
        getBinding().titleView.setOnTitleBarListener(new GradeAggregateActivity$initListener$1(this));
        ShopTrack.INSTANCE.hw_shop_aggregate_share_show(String.valueOf(this.mPageId));
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        TextView textView = getBinding().tvGoto;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvGoto");
        rxUnDoubleUtil.setOnUnDoubleClickListener(textView, 300, new GradeAggregateActivity$initListener$2(this));
    }

    private final void initAdapter() {
        this.mLinearLayoutManager = new LinearLayoutManager((Context) this, 1, false);
        getBinding().recycleView.setLayoutManager(this.mLinearLayoutManager);
        this.mGradeAggregateAdapter = new GradeAggregateAdapter();
        getBinding().recycleView.setAdapter(this.mGradeAggregateAdapter);
        GradeAggregateAdapter gradeAggregateAdapter = this.mGradeAggregateAdapter;
        if (gradeAggregateAdapter != null) {
            gradeAggregateAdapter.setOnItemClickListener(new GradeAggregateActivity$$ExternalSyntheticLambda3(this));
        }
        getBinding().recycleView.addOnScrollListener(new GradeAggregateActivity$initAdapter$2(this));
    }

    /* JADX WARNING: type inference failed for: r5v4, types: [java.lang.Integer] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: initAdapter$lambda-1  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m331initAdapter$lambda1(com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity r2, com.chad.library.adapter.base.BaseQuickAdapter r3, android.view.View r4, int r5) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "adapter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.List r3 = r3.getData()
            java.lang.Object r3 = r3.get(r5)
            boolean r4 = r3 instanceof com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTeacherNode
            r5 = 0
            if (r4 == 0) goto L_0x0055
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r4 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            int r2 = r2.mPageId
            java.lang.String r2 = java.lang.String.valueOf(r2)
            com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTeacherNode r3 = (com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTeacherNode) r3
            java.lang.Integer r0 = r3.getId()
            if (r0 != 0) goto L_0x002d
            goto L_0x0031
        L_0x002d:
            java.lang.String r5 = r0.toString()
        L_0x0031:
            r4.hw_shop_aggregate_teacher_click(r2, r5)
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.Integer r3 = r3.getId()
            if (r3 != 0) goto L_0x0041
            r3 = 0
            goto L_0x0045
        L_0x0041:
            int r3 = r3.intValue()
        L_0x0045:
            java.lang.String r4 = "teacherId"
            r2.putInt(r4, r3)
            com.tal.app.thinkacademy.lib.route.XesRoute r3 = com.tal.app.thinkacademy.lib.route.XesRoute.getInstance()
            java.lang.String r4 = "/shop/teacher_details_activity"
            r3.navigation(r4, r2)
            goto L_0x00e4
        L_0x0055:
            boolean r4 = r3 instanceof com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateDiagnosisNode
            if (r4 == 0) goto L_0x008e
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r4 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r4 = r4.getInstance()
            boolean r4 = r4.isGuest()
            if (r4 != 0) goto L_0x008a
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r4 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            int r5 = r2.mPageId
            java.lang.String r5 = java.lang.String.valueOf(r5)
            com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateDiagnosisNode r3 = (com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateDiagnosisNode) r3
            java.lang.String r0 = r3.getExamId()
            r4.hw_shop_aggregate_test_click(r5, r0)
            r2.showLoading()
            java.lang.String r3 = r3.getExamId()
            r2.examId = r3
            com.tal.app.thinkacademy.business.shop.classdetail.StudentInfo r2 = r2.mStudentInfo
            if (r2 != 0) goto L_0x0084
            goto L_0x00e4
        L_0x0084:
            com.tal.app.thinkacademy.business.shop.classdetail.AccountListTypeEnum r3 = com.tal.app.thinkacademy.business.shop.classdetail.AccountListTypeEnum.Admission
            r2.getAccountList(r3)
            goto L_0x00e4
        L_0x008a:
            r2.gotoLogin()
            goto L_0x00e4
        L_0x008e:
            boolean r4 = r3 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData
            if (r4 == 0) goto L_0x00e4
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r4 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            int r2 = r2.mPageId
            java.lang.String r2 = java.lang.String.valueOf(r2)
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData r3 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData) r3
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData r0 = r3.getSpec()
            if (r0 != 0) goto L_0x00a4
            r0 = r5
            goto L_0x00ac
        L_0x00a4:
            int r0 = r0.getClazzId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x00ac:
            r4.hw_shop_aggregate_class_click(r2, r0)
            com.tal.app.thinkacademy.lib.route.XesRoute r2 = com.tal.app.thinkacademy.lib.route.XesRoute.getInstance()
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            int r0 = r3.getId()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "skuId"
            r4.putString(r1, r0)
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData r3 = r3.getSpec()
            if (r3 != 0) goto L_0x00cc
            goto L_0x00d4
        L_0x00cc:
            int r3 = r3.getClazzId()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
        L_0x00d4:
            java.lang.String r3 = java.lang.String.valueOf(r5)
            java.lang.String r5 = "classId"
            r4.putString(r5, r3)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            java.lang.String r3 = "/shop/class_detail_activity"
            r2.navigation(r3, r4)
        L_0x00e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity.m331initAdapter$lambda1(com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity, com.chad.library.adapter.base.BaseQuickAdapter, android.view.View, int):void");
    }

    public void startObserve() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        getMViewModel().getMMainDetail().observe(lifecycleOwner, new GradeAggregateActivity$$ExternalSyntheticLambda1(this));
        getMViewModel().getClassList().observe(lifecycleOwner, new GradeAggregateActivity$$ExternalSyntheticLambda2(this));
        getMViewModel().getPostLeaveInfoResult().observe(lifecycleOwner, new GradeAggregateActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003c, code lost:
        r3 = r3.getMLocalContent();
     */
    /* renamed from: startObserve$lambda-2  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m332startObserve$lambda2(com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity r5, com.tal.app.thinkacademy.common.entity.StateData r6) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()
            com.tal.app.thinkacademy.business.shop.databinding.ActivityGradeAggregateBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ActivityGradeAggregateBinding) r0
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r0 = r0.loadStatusView
            r0.restoreView()
            com.tal.app.thinkacademy.common.entity.StateData$DataStatus r0 = r6.getStatus()
            int[] r1 = com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 != r1) goto L_0x00e6
            java.lang.Object r0 = r6.getData()
            r2 = 0
            if (r0 == 0) goto L_0x00e2
            java.lang.Object r0 = r6.getData()
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo r0 = (com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo) r0
            r5.mMainData = r0
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()
            com.tal.app.thinkacademy.business.shop.databinding.ActivityGradeAggregateBinding r0 = (com.tal.app.thinkacademy.business.shop.databinding.ActivityGradeAggregateBinding) r0
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r0 = r0.titleView
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo r3 = r5.mMainData
            if (r3 != 0) goto L_0x003c
        L_0x003a:
            r3 = r2
            goto L_0x0047
        L_0x003c:
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHead r3 = r3.getMLocalContent()
            if (r3 != 0) goto L_0x0043
            goto L_0x003a
        L_0x0043:
            java.lang.String r3 = r3.getPageTitle()
        L_0x0047:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setTitle(r3)
            r5.addVideoHead()
            r5.addFootView()
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo r0 = r5.mMainData
            r3 = 0
            if (r0 != 0) goto L_0x0059
        L_0x0057:
            r0 = r3
            goto L_0x0064
        L_0x0059:
            java.lang.Boolean r0 = r0.getHavaClassItem()
            if (r0 != 0) goto L_0x0060
            goto L_0x0057
        L_0x0060:
            boolean r0 = r0.booleanValue()
        L_0x0064:
            r5.havaClassItem = r0
            java.lang.Object r0 = r6.getData()
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo r0 = (com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo) r0
            if (r0 != 0) goto L_0x0070
            r0 = r2
            goto L_0x0074
        L_0x0070:
            java.util.List r0 = r0.getMLocalNodeList()
        L_0x0074:
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x0081
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x007f
            goto L_0x0081
        L_0x007f:
            r0 = r3
            goto L_0x0082
        L_0x0081:
            r0 = r1
        L_0x0082:
            if (r0 != 0) goto L_0x009c
            com.tal.app.thinkacademy.business.shop.adapter.GradeAggregateAdapter r0 = r5.mGradeAggregateAdapter
            if (r0 != 0) goto L_0x0089
            goto L_0x009c
        L_0x0089:
            java.lang.Object r4 = r6.getData()
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo r4 = (com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo) r4
            if (r4 != 0) goto L_0x0093
            r4 = r2
            goto L_0x0097
        L_0x0093:
            java.util.List r4 = r4.getMLocalNodeList()
        L_0x0097:
            java.util.Collection r4 = (java.util.Collection) r4
            r0.setList(r4)
        L_0x009c:
            java.lang.Object r0 = r6.getData()
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo r0 = (com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo) r0
            if (r0 != 0) goto L_0x00a6
            r0 = r2
            goto L_0x00aa
        L_0x00a6:
            java.util.List r0 = r0.getMLocalClassList()
        L_0x00aa:
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x00b6
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00b5
            goto L_0x00b6
        L_0x00b5:
            r1 = r3
        L_0x00b6:
            if (r1 != 0) goto L_0x00f2
            java.lang.Object r6 = r6.getData()
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo r6 = (com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo) r6
            if (r6 != 0) goto L_0x00c1
            goto L_0x00c5
        L_0x00c1:
            java.util.List r2 = r6.getMLocalClassList()
        L_0x00c5:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.util.Iterator r6 = r2.iterator()
        L_0x00cc:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x00f2
            java.lang.Object r0 = r6.next()
            com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode r0 = (com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode) r0
            com.tal.app.thinkacademy.common.base.BaseViewModel r1 = r5.getMViewModel()
            com.tal.app.thinkacademy.business.shop.viewmodel.GradeAggregateVm r1 = (com.tal.app.thinkacademy.business.shop.viewmodel.GradeAggregateVm) r1
            r1.getClassList(r0)
            goto L_0x00cc
        L_0x00e2:
            showMainDataEmpty$default(r5, r2, r1, r2)
            goto L_0x00f2
        L_0x00e6:
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            java.lang.String r6 = com.tal.app.thinkacademy.common.CommonKtxKt.formatBadResult(r6)
            r5.showMainDataEmpty(r6)
        L_0x00f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity.m332startObserve$lambda2(com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity, com.tal.app.thinkacademy.common.entity.StateData):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-4  reason: not valid java name */
    public static final void m333startObserve$lambda4(GradeAggregateActivity gradeAggregateActivity, StateData stateData) {
        GradeAggregateClassListData gradeAggregateClassListData;
        GradeAggregateAdapter gradeAggregateAdapter;
        Intrinsics.checkNotNullParameter(gradeAggregateActivity, "this$0");
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] != 1) {
            ToastUtils.showShort(stateData.getMsg(), new Object[0]);
        } else if (stateData.getData() != null && (gradeAggregateClassListData = (GradeAggregateClassListData) stateData.getData()) != null && (gradeAggregateAdapter = gradeAggregateActivity.mGradeAggregateAdapter) != null) {
            List<ShopClassGoodsData> goodsList = gradeAggregateClassListData.getGoodsList();
            Intrinsics.checkNotNull(goodsList);
            gradeAggregateAdapter.nodeAddData(gradeAggregateClassListData.getNode(), 0, goodsList);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-5  reason: not valid java name */
    public static final void m334startObserve$lambda5(GradeAggregateActivity gradeAggregateActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(gradeAggregateActivity, "this$0");
        gradeAggregateActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            ToastUtils.showShort(gradeAggregateActivity.getString(R.string.submission_successful), new Object[0]);
        } else {
            ToastUtils.showShort(gradeAggregateActivity.getString(R.string.submission_failed), new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public final void getMainData() {
        LoadStatusView loadStatusView = getBinding().loadStatusView;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
        LoadStatusView.showFullLoadingView$default(loadStatusView, 0, 1, (Object) null);
        getMViewModel().getMainDetail(String.valueOf(this.mPageId));
    }

    static /* synthetic */ void showMainDataEmpty$default(GradeAggregateActivity gradeAggregateActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        gradeAggregateActivity.showMainDataEmpty(str);
    }

    private final void showMainDataEmpty(String str) {
        LoadStatusView loadStatusView = getBinding().loadStatusView;
        int i = R.drawable.fail_internet_connection;
        String string = getString(R.string.data_is_empty);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.data_is_empty)");
        String string2 = getString(R.string.fail_btn_hint);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.fail_btn_hint)");
        loadStatusView.showErrorView(i, string, string2, str, new GradeAggregateActivity$showMainDataEmpty$1(this));
        getBinding().loadStatusView.setContentBg(R.color.color_f4f6fa);
    }

    /* access modifiers changed from: private */
    public final void goToShare() {
        StringBuffer stringBuffer = new StringBuffer(UrlUtils.INSTANCE.getTouchHost());
        stringBuffer.append(Intrinsics.stringPlus("/courses/aggregational-detail/", Integer.valueOf(this.mPageId)));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", stringBuffer.toString());
        startActivity(Intent.createChooser(intent, getTitle()));
    }

    private final void addFootView() {
        View view;
        GradeAggregateP gradeAggregateP;
        BaseQuickAdapter baseQuickAdapter;
        if (this.isNeedSubmitInfor) {
            LayoutInflater layoutInflater = getLayoutInflater();
            int i = R.layout.activity_grade_aggregate_foot_submit;
            ViewGroup viewGroup = getBinding().recycleView;
            view = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(view, "{\n            layoutInfl…e\n            )\n        }");
        } else {
            LayoutInflater layoutInflater2 = getLayoutInflater();
            int i2 = R.layout.lib_common_ui_list_foot;
            ViewGroup viewGroup2 = getBinding().recycleView;
            view = !(layoutInflater2 instanceof LayoutInflater) ? layoutInflater2.inflate(i2, viewGroup2, false) : XMLParseInstrumentation.inflate(layoutInflater2, i2, viewGroup2, false);
            Intrinsics.checkNotNullExpressionValue(view, "{\n            layoutInfl…e\n            )\n        }");
        }
        this.mFootView = view;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFootView");
            view = null;
        }
        if (view.getParent() == null && (baseQuickAdapter = this.mGradeAggregateAdapter) != null) {
            BaseQuickAdapter.addFooterView$default(baseQuickAdapter, view, 0, 0, 6, (Object) null);
        }
        if (this.isNeedSubmitInfor && (gradeAggregateP = this.mGradeAggregateP) != null) {
            gradeAggregateP.footViewShow(view, this.mPageId);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        if ((r0 == null || r0.length() == 0) == false) goto L_0x0037;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void addVideoHead() {
        /*
            r11 = this;
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo r0 = r11.mMainData
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0007
            goto L_0x000d
        L_0x0007:
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHead r0 = r0.getMLocalContent()
            if (r0 != 0) goto L_0x000f
        L_0x000d:
            r0 = r2
            goto L_0x0038
        L_0x000f:
            java.lang.String r3 = r0.getImg()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x0020
            int r3 = r3.length()
            if (r3 != 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            r3 = r2
            goto L_0x0021
        L_0x0020:
            r3 = r1
        L_0x0021:
            if (r3 == 0) goto L_0x0037
            java.lang.String r0 = r0.getVideo()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0034
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r0 = r2
            goto L_0x0035
        L_0x0034:
            r0 = r1
        L_0x0035:
            if (r0 != 0) goto L_0x000d
        L_0x0037:
            r0 = r1
        L_0x0038:
            if (r0 == 0) goto L_0x00b5
            com.tal.app.thinkacademy.business.shop.gradeaggregate.VideoModel r0 = r11.mVideoModel
            r3 = 0
            if (r0 != 0) goto L_0x0041
            r0 = r3
            goto L_0x0054
        L_0x0041:
            androidx.viewbinding.ViewBinding r4 = r11.getBinding()
            com.tal.app.thinkacademy.business.shop.databinding.ActivityGradeAggregateBinding r4 = (com.tal.app.thinkacademy.business.shop.databinding.ActivityGradeAggregateBinding) r4
            androidx.recyclerview.widget.RecyclerView r4 = r4.recycleView
            java.lang.String r5 = "binding.recycleView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            android.view.View r0 = r0.getHeadView(r11, r4)
        L_0x0054:
            r11.mVideoView = r0
            com.tal.app.thinkacademy.business.shop.gradeaggregate.VideoModel r0 = r11.mVideoModel
            if (r0 != 0) goto L_0x005b
            goto L_0x0060
        L_0x005b:
            int r4 = r11.mPageId
            r0.setMPageId(r4)
        L_0x0060:
            com.tal.app.thinkacademy.business.shop.gradeaggregate.VideoModel r0 = r11.mVideoModel
            if (r0 != 0) goto L_0x0065
            goto L_0x0072
        L_0x0065:
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo r4 = r11.mMainData
            if (r4 != 0) goto L_0x006b
            r4 = r3
            goto L_0x006f
        L_0x006b:
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHead r4 = r4.getMLocalContent()
        L_0x006f:
            r0.setData(r4)
        L_0x0072:
            android.view.View r6 = r11.mVideoView
            if (r6 != 0) goto L_0x0077
            goto L_0x008c
        L_0x0077:
            android.view.ViewParent r0 = r6.getParent()
            if (r0 != 0) goto L_0x008c
            com.tal.app.thinkacademy.business.shop.adapter.GradeAggregateAdapter r0 = r11.mGradeAggregateAdapter
            if (r0 != 0) goto L_0x0082
            goto L_0x008c
        L_0x0082:
            r5 = r0
            com.chad.library.adapter.base.BaseQuickAdapter r5 = (com.chad.library.adapter.base.BaseQuickAdapter) r5
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            com.chad.library.adapter.base.BaseQuickAdapter.addHeaderView$default(r5, r6, r7, r8, r9, r10)
        L_0x008c:
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateDetailInfo r0 = r11.mMainData
            if (r0 != 0) goto L_0x0091
            goto L_0x009c
        L_0x0091:
            com.tal.app.thinkacademy.business.shop.bean.GradeAggregateHead r0 = r0.getMLocalContent()
            if (r0 != 0) goto L_0x0098
            goto L_0x009c
        L_0x0098:
            java.lang.String r3 = r0.getVideo()
        L_0x009c:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x00a8
            int r0 = r3.length()
            if (r0 != 0) goto L_0x00a7
            goto L_0x00a8
        L_0x00a7:
            r1 = r2
        L_0x00a8:
            if (r1 != 0) goto L_0x00b5
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r0 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            int r1 = r11.mPageId
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.hw_shop_aggregate_video_show(r1)
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.gradeaggregate.GradeAggregateActivity.addVideoHead():void");
    }

    private final void removeVideoHead() {
        GradeAggregateAdapter gradeAggregateAdapter;
        View view = this.mVideoView;
        if (view != null && view.getParent() != null && (gradeAggregateAdapter = this.mGradeAggregateAdapter) != null) {
            gradeAggregateAdapter.removeHeaderView(view);
        }
    }

    /* access modifiers changed from: private */
    public final void gotoAdmissionTest(String str) {
        if (!UserInfoBll.Companion.getInstance().isGuest()) {
            String touchHost = UrlUtils.INSTANCE.getTouchHost();
            Bundle bundle = new Bundle();
            StringBuffer stringBuffer = new StringBuffer(touchHost);
            stringBuffer.append("/quiz/evaluation/instruction/" + str + "?fromClientType=native");
            bundle.putString("jump_key", stringBuffer.toString());
            bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
            XesRoute.getInstance().navigation("/login/coins_activity", bundle);
            return;
        }
        gotoLogin();
    }

    private final void gotoLogin() {
        XesRoute instance = XesRoute.getInstance();
        Bundle bundle = new Bundle();
        bundle.putString("login_page_path", "年级聚合页");
        Unit unit = Unit.INSTANCE;
        instance.navigation("/login/login_activity", bundle);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        GradeAggregateActivity.super.onResume();
        VideoModel videoModel = this.mVideoModel;
        if (videoModel != null) {
            videoModel.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        GradeAggregateActivity.super.onPause();
        VideoModel videoModel = this.mVideoModel;
        if (videoModel != null) {
            videoModel.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        GradeAggregateActivity.super.onDestroy();
        StudentInfo studentInfo = this.mStudentInfo;
        if (studentInfo != null) {
            studentInfo.onDestroy();
        }
        GradeAggregateP gradeAggregateP = this.mGradeAggregateP;
        if (gradeAggregateP != null) {
            gradeAggregateP.onDestroy();
        }
        this.mGradeAggregateP = null;
        VideoModel videoModel = this.mVideoModel;
        if (videoModel != null) {
            videoModel.onDestroy();
        }
    }

    private final void setBottomPrice() {
        String str;
        String str2;
        String format;
        String makePrice = ShopUtils.INSTANCE.makePrice(SchoolConstants.INSTANCE.getSchoolCurrency(this.mSchoolCode), this.mShowPrice);
        if (!this.mIsShowLesson) {
            if (this.mShowPrice <= 0 && !this.mIsShowFrom) {
                makePrice = getString(R.string.free);
                Intrinsics.checkNotNullExpressionValue(makePrice, "getString(R.string.free)");
            } else if (this.mIsShowFrom) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = getString(R.string.from_price_msg_format);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.from_price_msg_format)");
                format = String.format(string, Arrays.copyOf(new Object[]{makePrice}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            str2 = makePrice;
            str = str2;
            TextHighLightUtil.INSTANCE.setTextHighLightColorSize(getBinding().tvPrice, str2, str, getColor(R.color.color_ffaa0a), SizeUtils.dp2px(20.0f));
        } else if (this.mIsShowFrom) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string2 = getString(R.string.from_price_msg_format);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.from_price_msg_format)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{makePrice}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            format = Intrinsics.stringPlus(format2, getString(R.string.lesson));
        } else {
            format = Intrinsics.stringPlus(makePrice, getString(R.string.lesson));
        }
        str = makePrice;
        str2 = format;
        TextHighLightUtil.INSTANCE.setTextHighLightColorSize(getBinding().tvPrice, str2, str, getColor(R.color.color_ffaa0a), SizeUtils.dp2px(20.0f));
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        GradeAggregateActivity.super.onStart();
        ShopTrack.INSTANCE.hw_shop_aggregate_pv(String.valueOf(this.mPageId));
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        GradeAggregateActivity.super.onStop();
        ShopTrack.INSTANCE.hw_shop_aggregate_leave(String.valueOf(this.mPageId));
    }

    public final GradeAggregateVm getGradeViewModel() {
        return getMViewModel();
    }
}
