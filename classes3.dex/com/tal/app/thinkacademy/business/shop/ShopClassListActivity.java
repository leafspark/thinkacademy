package com.tal.app.thinkacademy.business.shop;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.adapter.ClassListAdapter;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassData;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassFilterData;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodListData;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassListRequestData;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassTeacherData;
import com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody;
import com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonHeader;
import com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassListBinding;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.business.shop.viewmodel.ShopClassListViewModel;
import com.tal.app.thinkacademy.business.shop.widget.dialog.ClassFilterDialog;
import com.tal.app.thinkacademy.business.shop.widget.list.ShopClassBottomView;
import com.tal.app.thinkacademy.business.shop.widget.view.SelectTabListGroup;
import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import com.tal.app.thinkacademy.common.CommonKtxKt;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 C2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001CB\u0005¢\u0006\u0002\u0010\u0004J6\u0010\u001f\u001a\u00020\u00132\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020\u0013H\u0002J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0013H\u0014J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0002J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u000fH\u0002J\u0012\u0010.\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\b\u00101\u001a\u00020*H\u0014J\u0014\u00102\u001a\u00020*2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\nH\u0002JL\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020\b2\b\b\u0002\u00106\u001a\u00020\b2\b\b\u0002\u00107\u001a\u00020\u00132\b\b\u0002\u00108\u001a\u00020\n2\b\b\u0002\u00109\u001a\u00020\n2\b\b\u0002\u0010:\u001a\u00020\n2\b\b\u0002\u0010;\u001a\u00020\u0013H\u0002J,\u0010<\u001a\u00020*2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0018\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0013H\u0002J\b\u0010?\u001a\u00020*H\u0016J\u0012\u0010@\u001a\u00020*2\b\u0010A\u001a\u0004\u0018\u00010BH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/ShopClassListActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/shop/viewmodel/ShopClassListViewModel;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ActivityShopClassListBinding;", "()V", "mClassAdapter", "Lcom/tal/app/thinkacademy/business/shop/adapter/ClassListAdapter;", "mCourseId", "", "mCourseName", "", "mDayOfWeek", "mEnterTime", "", "mFilterData", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassFilterData;", "mFilterDialog", "Lcom/tal/app/thinkacademy/business/shop/widget/dialog/ClassFilterDialog;", "mIsLoading", "", "mOnCreateTime", "mPageNum", "mSchoolCode", "getMSchoolCode", "()Ljava/lang/String;", "mSchoolCode$delegate", "Lkotlin/Lazy;", "mShopClassList", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassData;", "mTeacherId", "mTimeRange", "changeFilter", "day", "time", "teacher", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassTeacherData;", "checked", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "initData", "", "initView", "makeHeader", "filter", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "renderTrack", "errMsg", "requestData", "pageNum", "courseId", "onlyNotFull", "timeRange", "dayOfWeek", "teacherId", "needFullLoading", "setupFilterTab", "showFilterDialog", "pos", "startObserve", "updateList", "goodListData", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassGoodListData;", "Companion", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassListActivity.kt */
public final class ShopClassListActivity extends BaseVmActivity<ShopClassListViewModel, ActivityShopClassListBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int mPageCount = 10;
    private ClassListAdapter mClassAdapter;
    private int mCourseId = -1;
    private String mCourseName = "";
    private String mDayOfWeek = "";
    private long mEnterTime;
    private ShopClassFilterData mFilterData;
    private ClassFilterDialog mFilterDialog;
    /* access modifiers changed from: private */
    public boolean mIsLoading;
    private long mOnCreateTime;
    private int mPageNum = 1;
    private final Lazy mSchoolCode$delegate = LazyKt.lazy(ShopClassListActivity$mSchoolCode$2.INSTANCE);
    private ShopClassData mShopClassList;
    private String mTeacherId = "";
    private String mTimeRange = "";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopClassListActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/ShopClassListActivity$Companion;", "", "()V", "mPageCount", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopClassListActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final String getMSchoolCode() {
        return (String) this.mSchoolCode$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ShopClassListActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, -1, false);
        this.mOnCreateTime = System.currentTimeMillis();
        initView();
        initData();
    }

    private final void initView() {
        TitleBar titleBar = getBinding().titleView;
        if (titleBar != null) {
            titleBar.setTitle(getString(R.string.shop_class_list_title));
        }
        TitleBar titleBar2 = getBinding().titleView;
        if (titleBar2 != null) {
            titleBar2.setLineVisible(false);
        }
        TitleBar titleBar3 = getBinding().titleView;
        if (titleBar3 != null) {
            titleBar3.setOnTitleBarListener(new ShopClassListActivity$initView$1(this));
        }
        getBinding().appBar.addOnOffsetChangedListener(new ShopClassListActivity$$ExternalSyntheticLambda4(this));
        getBinding().refreshLayout.setEnableLoadMore(false);
        getBinding().refreshLayout.setOnRefreshListener(new ShopClassListActivity$$ExternalSyntheticLambda5(this));
        ClassListAdapter classListAdapter = new ClassListAdapter(getMSchoolCode());
        this.mClassAdapter = classListAdapter;
        classListAdapter.getLoadMoreModule().setLoadMoreView(new ShopClassBottomView());
        classListAdapter.getLoadMoreModule().setOnLoadMoreListener(new ShopClassListActivity$$ExternalSyntheticLambda3(this));
        classListAdapter.setOnItemClickListener(new ShopClassListActivity$$ExternalSyntheticLambda2(classListAdapter));
        getBinding().checkboxRegistered.setChecked(false);
        getBinding().checkboxRegistered.setOnClickListener(new ShopClassListActivity$$ExternalSyntheticLambda0(this));
        setupFilterTab$default(this, (String) null, (String) null, (ShopClassTeacherData) null, 7, (Object) null);
        getBinding().tabFilter.setTabClickListener(new ShopClassListActivity$initView$6(this));
        getBinding().recyclerView.setAdapter(this.mClassAdapter);
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m184initView$lambda0(ShopClassListActivity shopClassListActivity, AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(shopClassListActivity, "this$0");
        if (shopClassListActivity.getBinding().tvSubTitle.getHeight() <= Math.abs(i)) {
            shopClassListActivity.getBinding().titleView.setTitle(shopClassListActivity.mCourseName);
        } else {
            shopClassListActivity.getBinding().titleView.setTitle(shopClassListActivity.getString(R.string.shop_class_list_title));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m185initView$lambda1(ShopClassListActivity shopClassListActivity, RefreshLayout refreshLayout) {
        Intrinsics.checkNotNullParameter(shopClassListActivity, "this$0");
        Intrinsics.checkNotNullParameter(refreshLayout, "it");
        XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, new Object[]{"班级列表 刷新"});
        requestData$default(shopClassListActivity, 1, 0, false, (String) null, (String) null, (String) null, false, 62, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-5$lambda-2  reason: not valid java name */
    public static final void m186initView$lambda5$lambda2(ShopClassListActivity shopClassListActivity) {
        Intrinsics.checkNotNullParameter(shopClassListActivity, "this$0");
        XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, new Object[]{"班级列表加载更多"});
        int i = shopClassListActivity.mPageNum + 1;
        shopClassListActivity.mPageNum = i;
        requestData$default(shopClassListActivity, i, 0, false, (String) null, (String) null, (String) null, false, 62, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-5$lambda-4  reason: not valid java name */
    public static final void m187initView$lambda5$lambda4(ClassListAdapter classListAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String gradeName;
        String subject;
        String year;
        String platformType;
        Integer intOrNull;
        String levelDegreeName;
        ClassListAdapter classListAdapter2 = classListAdapter;
        Intrinsics.checkNotNullParameter(classListAdapter2, "$this_run");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "$noName_0");
        Intrinsics.checkNotNullParameter(view, "$noName_1");
        ShopClassGoodsData shopClassGoodsData = (ShopClassGoodsData) classListAdapter2.getItem(i);
        Bundle bundle = new Bundle();
        bundle.putString("skuId", String.valueOf(shopClassGoodsData.getId()));
        ShopClassGoodsSpecData spec = shopClassGoodsData.getSpec();
        bundle.putString(LearnMaterialsListActivityKt.CLASSID, String.valueOf(spec == null ? null : Integer.valueOf(spec.getClazzId())));
        XesRoute.getInstance().navigation("/shop/class_detail_activity", bundle);
        ShopTrack shopTrack = ShopTrack.INSTANCE;
        ShopClassGoodsSpecData spec2 = shopClassGoodsData.getSpec();
        int courseId = spec2 == null ? 0 : spec2.getCourseId();
        String title = shopClassGoodsData.getTitle();
        String str5 = title == null ? "" : title;
        ShopClassGoodsSpecData spec3 = shopClassGoodsData.getSpec();
        int clazzId = spec3 == null ? 0 : spec3.getClazzId();
        ShopClassGoodsSpecData spec4 = shopClassGoodsData.getSpec();
        if (spec4 == null || (levelDegreeName = spec4.getLevelDegreeName()) == null) {
            str = "";
        } else {
            str = levelDegreeName;
        }
        ShopClassGoodsSpecData spec5 = shopClassGoodsData.getSpec();
        int courseType = spec5 == null ? 0 : spec5.getCourseType();
        ShopClassGoodsSpecData spec6 = shopClassGoodsData.getSpec();
        int intValue = (spec6 == null || (platformType = spec6.getPlatformType()) == null || (intOrNull = StringsKt.toIntOrNull(platformType)) == null) ? 0 : intOrNull.intValue();
        ShopClassGoodsSpecData spec7 = shopClassGoodsData.getSpec();
        if (spec7 == null || (year = spec7.getYear()) == null) {
            str2 = "";
        } else {
            str2 = year;
        }
        ShopClassGoodsSpecData spec8 = shopClassGoodsData.getSpec();
        int term = spec8 == null ? 0 : spec8.getTerm();
        ShopClassGoodsSpecData spec9 = shopClassGoodsData.getSpec();
        if (spec9 == null || (subject = spec9.getSubject()) == null) {
            str3 = "";
        } else {
            str3 = subject;
        }
        ShopClassGoodsSpecData spec10 = shopClassGoodsData.getSpec();
        if (spec10 == null || (gradeName = spec10.getGradeName()) == null) {
            str4 = "";
        } else {
            str4 = gradeName;
        }
        ShopClassGoodsSpecData spec11 = shopClassGoodsData.getSpec();
        shopTrack.hw_shop_class_card_click(courseId, str5, clazzId, str, courseType, intValue, str2, term, str3, str4, spec11 == null ? 0 : spec11.getSubPlatformType(), "班级列表页");
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-6  reason: not valid java name */
    public static final void m188initView$lambda6(ShopClassListActivity shopClassListActivity, View view) {
        Intrinsics.checkNotNullParameter(shopClassListActivity, "this$0");
        if (shopClassListActivity.mIsLoading) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        shopClassListActivity.getBinding().checkboxRegistered.toggle();
        requestData$default(shopClassListActivity, 1, 0, false, (String) null, (String) null, (String) null, false, 126, (Object) null);
        ShopTrack.INSTANCE.shopClassListVacancy(shopClassListActivity.mCourseId, shopClassListActivity.mCourseName, "班级列表页-顶部", shopClassListActivity.getBinding().checkboxRegistered.isChecked() ? 1 : 0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void initData() {
        this.mCourseId = getIntent().getIntExtra("courseId", -1);
        String stringExtra = getIntent().getStringExtra("courseName");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mCourseName = stringExtra;
        this.mEnterTime = System.currentTimeMillis();
        ShopTrack.INSTANCE.shopClassListPv(this.mCourseId, this.mCourseName);
        if (this.mCourseId == -1) {
            LoadStatusView loadStatusView = getBinding().loadStatusView;
            Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
            String string = getString(R.string.oops);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.oops)");
            LoadStatusView.showEmptyView$default(loadStatusView, 0, string, false, (String) null, (Function0) null, 29, (Object) null);
            XesLog.et(ShopConstantsKt.TAG_SHOP_CLASS, new Object[]{"班级列表异常，courseId 错误"});
            return;
        }
        requestData$default(this, 1, 0, false, (String) null, (String) null, (String) null, false, 126, (Object) null);
    }

    public void startObserve() {
        getMViewModel().getMShopClassList().observe((LifecycleOwner) this, new ShopClassListActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-8  reason: not valid java name */
    public static final void m189startObserve$lambda8(ShopClassListActivity shopClassListActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(shopClassListActivity, "this$0");
        shopClassListActivity.mIsLoading = false;
        shopClassListActivity.getBinding().refreshLayout.finishRefresh();
        shopClassListActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            if (stateData.getData() != null) {
                ShopClassData shopClassData = (ShopClassData) stateData.getData();
                if ((shopClassData == null ? null : shopClassData.getFilter()) != null) {
                    XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, new Object[]{GsonUtil.getInstance().objToJson(stateData.getData())});
                    shopClassListActivity.getBinding().loadStatusView.restoreView();
                    shopClassListActivity.mShopClassList = (ShopClassData) stateData.getData();
                    Object data = stateData.getData();
                    Intrinsics.checkNotNull(data);
                    ShopClassData shopClassData2 = (ShopClassData) data;
                    ShopClassFilterData filter = shopClassData2.getFilter();
                    Intrinsics.checkNotNull(filter);
                    shopClassListActivity.makeHeader(filter);
                    shopClassListActivity.updateList(shopClassData2.getGoodsList());
                    renderTrack$default(shopClassListActivity, (String) null, 1, (Object) null);
                    return;
                }
            }
            LoadStatusView loadStatusView = shopClassListActivity.getBinding().loadStatusView;
            Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
            String string = shopClassListActivity.getString(R.string.data_is_empty);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.data_is_empty)");
            String string2 = shopClassListActivity.getString(R.string.retry);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.retry)");
            LoadStatusView.showErrorView$default(loadStatusView, 0, string, string2, (String) null, new ShopClassListActivity$startObserve$1$1(shopClassListActivity), 9, (Object) null);
            shopClassListActivity.getBinding().loadStatusView.setContentBg(R.color.color_F4F6FA);
            shopClassListActivity.renderTrack("数据为空");
            return;
        }
        LoadStatusView loadStatusView2 = shopClassListActivity.getBinding().loadStatusView;
        Intrinsics.checkNotNullExpressionValue(loadStatusView2, "binding.loadStatusView");
        String string3 = shopClassListActivity.getString(R.string.retry);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.retry)");
        Intrinsics.checkNotNullExpressionValue(stateData, "it");
        LoadStatusView.showErrorView$default(loadStatusView2, 0, (String) null, string3, CommonKtxKt.formatBadResult(stateData), new ShopClassListActivity$startObserve$1$3(shopClassListActivity), 3, (Object) null);
        shopClassListActivity.getBinding().loadStatusView.setContentBg(R.color.color_F4F6FA);
        XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, new Object[]{stateData.getCode() + "  " + stateData.getMsg()});
        shopClassListActivity.renderTrack(stateData.getCode() + "  " + stateData.getMsg());
    }

    /* access modifiers changed from: private */
    public final void showFilterDialog(int i, boolean z) {
        if (this.mFilterDialog == null) {
            ShopClassListActivity shopClassListActivity = this;
            XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, new Object[]{"showFilterDialog create"});
            ClassFilterDialog classFilterDialog = new ClassFilterDialog((Context) this);
            classFilterDialog.setFilterSure(new ShopClassListActivity$showFilterDialog$1$1(this));
            classFilterDialog.setFilterData(this.mFilterData);
            this.mFilterDialog = classFilterDialog;
        }
        int[] iArr = new int[2];
        getBinding().titleView.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getBinding().tabFilter.getLocationOnScreen(iArr2);
        XesLog.dt("ShopClassListActivity", new Object[]{"winarr1=" + iArr[0] + ",win2=" + iArr[1] + ",screenArray1=" + iArr2[0] + ",screen2=" + iArr2[1]});
        ClassFilterDialog classFilterDialog2 = this.mFilterDialog;
        if (classFilterDialog2 != null) {
            classFilterDialog2.setDataTopPosition(iArr2[1] - iArr[1]);
        }
        ClassFilterDialog classFilterDialog3 = this.mFilterDialog;
        if (classFilterDialog3 != null) {
            XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, new Object[]{"showFilterDialog show"});
            classFilterDialog3.showWithData(z, i);
            ShopTrack.INSTANCE.shopClassListSizerShow(this.mCourseId, this.mCourseName);
        }
    }

    private final void makeHeader(ShopClassFilterData shopClassFilterData) {
        getBinding().tvSubTitle.setText(this.mCourseName);
        this.mFilterData = shopClassFilterData;
    }

    private final void updateList(ShopClassGoodListData shopClassGoodListData) {
        int i;
        List<ShopClassGoodsData> list;
        BaseLoadMoreModule loadMoreModule;
        BaseLoadMoreModule loadMoreModule2;
        List data;
        BaseLoadMoreModule loadMoreModule3;
        BaseLoadMoreModule loadMoreModule4;
        boolean z = true;
        boolean z2 = this.mPageNum == 1;
        if (shopClassGoodListData == null) {
            i = 0;
        } else {
            i = shopClassGoodListData.getTotal();
        }
        BaseLoadMoreModule baseLoadMoreModule = null;
        if (shopClassGoodListData == null) {
            list = null;
        } else {
            list = shopClassGoodListData.getList();
        }
        if (z2) {
            Collection collection = list;
            if (collection == null || collection.isEmpty()) {
                ClassListAdapter classListAdapter = this.mClassAdapter;
                if (classListAdapter != null) {
                    classListAdapter.setList((Collection) null);
                }
                ClassListAdapter classListAdapter2 = this.mClassAdapter;
                if (classListAdapter2 != null) {
                    classListAdapter2.setEmptyView(R.layout.layout_shop_class_empty);
                    return;
                }
                return;
            }
            ClassListAdapter classListAdapter3 = this.mClassAdapter;
            if (classListAdapter3 != null) {
                classListAdapter3.setList(collection);
            }
            ClassListAdapter classListAdapter4 = this.mClassAdapter;
            if (classListAdapter4 != null) {
                classListAdapter4.removeEmptyView();
            }
            int size = collection.size();
            if (size == i) {
                ClassListAdapter classListAdapter5 = this.mClassAdapter;
                if (classListAdapter5 != null && (loadMoreModule4 = classListAdapter5.getLoadMoreModule()) != null) {
                    if (size >= 2) {
                        z = false;
                    }
                    loadMoreModule4.loadMoreEnd(z);
                    return;
                }
                return;
            }
            ClassListAdapter classListAdapter6 = this.mClassAdapter;
            if (classListAdapter6 != null) {
                baseLoadMoreModule = classListAdapter6.getLoadMoreModule();
            }
            if (baseLoadMoreModule != null) {
                baseLoadMoreModule.setAutoLoadMore(true);
                return;
            }
            return;
        }
        Collection collection2 = list;
        if (collection2 != null && !collection2.isEmpty()) {
            z = false;
        }
        if (z) {
            ClassListAdapter classListAdapter7 = this.mClassAdapter;
            if (classListAdapter7 != null && (loadMoreModule3 = classListAdapter7.getLoadMoreModule()) != null) {
                loadMoreModule3.loadMoreEnd(false);
                return;
            }
            return;
        }
        ClassListAdapter classListAdapter8 = this.mClassAdapter;
        if (classListAdapter8 != null) {
            classListAdapter8.addData(collection2);
        }
        ClassListAdapter classListAdapter9 = this.mClassAdapter;
        if (((classListAdapter9 == null || (data = classListAdapter9.getData()) == null) ? 0 : data.size()) == i) {
            ClassListAdapter classListAdapter10 = this.mClassAdapter;
            if (classListAdapter10 != null && (loadMoreModule2 = classListAdapter10.getLoadMoreModule()) != null) {
                loadMoreModule2.loadMoreEnd(false);
                return;
            }
            return;
        }
        ClassListAdapter classListAdapter11 = this.mClassAdapter;
        if (classListAdapter11 != null && (loadMoreModule = classListAdapter11.getLoadMoreModule()) != null) {
            loadMoreModule.loadMoreComplete();
        }
    }

    static /* synthetic */ void requestData$default(ShopClassListActivity shopClassListActivity, int i, int i2, boolean z, String str, String str2, String str3, boolean z2, int i3, Object obj) {
        ShopClassListActivity shopClassListActivity2 = shopClassListActivity;
        shopClassListActivity.requestData(i, (i3 & 2) != 0 ? shopClassListActivity2.mCourseId : i2, (i3 & 4) != 0 ? shopClassListActivity.getBinding().checkboxRegistered.isChecked() : z, (i3 & 8) != 0 ? shopClassListActivity2.mTimeRange : str, (i3 & 16) != 0 ? shopClassListActivity2.mDayOfWeek : str2, (i3 & 32) != 0 ? shopClassListActivity2.mTeacherId : str3, (i3 & 64) != 0 ? true : z2);
    }

    private final void requestData(int i, int i2, boolean z, String str, String str2, String str3, boolean z2) {
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            ClassListAdapter classListAdapter = this.mClassAdapter;
            BaseLoadMoreModule loadMoreModule = classListAdapter == null ? null : classListAdapter.getLoadMoreModule();
            if (loadMoreModule != null) {
                loadMoreModule.setAutoLoadMore(false);
            }
            if (z2) {
                if (this.mShopClassList != null) {
                    showLoading();
                } else {
                    getBinding().loadStatusView.showFullLoadingView(R.color.color_F4F6FA);
                }
            }
            this.mPageNum = i;
            getMViewModel().queryClazzByCourseId(new ShopRequestCommonBody(new ShopClassListRequestData(10, i, i2, z, str, str2, str3, (List) null, 128, (DefaultConstructorMarker) null), new ShopRequestCommonHeader(getMSchoolCode(), "app")));
        }
    }

    static /* synthetic */ boolean changeFilter$default(ShopClassListActivity shopClassListActivity, String str, String str2, ShopClassTeacherData shopClassTeacherData, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            shopClassTeacherData = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return shopClassListActivity.changeFilter(str, str2, shopClassTeacherData, z);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean changeFilter(java.lang.String r15, java.lang.String r16, com.tal.app.thinkacademy.business.shop.bean.ShopClassTeacherData r17, boolean r18) {
        /*
            r14 = this;
            r0 = r14
            r1 = r18
            java.lang.String r2 = r0.mDayOfWeek
            java.lang.String r3 = ""
            if (r15 != 0) goto L_0x000b
            r4 = r3
            goto L_0x000c
        L_0x000b:
            r4 = r15
        L_0x000c:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = r0.mTimeRange
            if (r16 != 0) goto L_0x001a
            r6 = r3
            goto L_0x001c
        L_0x001a:
            r6 = r16
        L_0x001c:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r6)
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = r0.mTeacherId
            if (r17 != 0) goto L_0x0028
        L_0x0026:
            r6 = r3
            goto L_0x002f
        L_0x0028:
            java.lang.String r6 = r17.getTeacherId()
            if (r6 != 0) goto L_0x002f
            goto L_0x0026
        L_0x002f:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r6)
            if (r2 != 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r2 = r4
            goto L_0x0039
        L_0x0038:
            r2 = r5
        L_0x0039:
            androidx.viewbinding.ViewBinding r6 = r14.getBinding()
            com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassListBinding r6 = (com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassListBinding) r6
            android.widget.CheckedTextView r6 = r6.checkboxRegistered
            boolean r6 = r6.isChecked()
            if (r6 == r1) goto L_0x0049
            r6 = r5
            goto L_0x004a
        L_0x0049:
            r6 = r4
        L_0x004a:
            java.lang.Object[] r7 = new java.lang.Object[r5]
            if (r2 != 0) goto L_0x0053
            if (r6 == 0) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            r8 = r4
            goto L_0x0054
        L_0x0053:
            r8 = r5
        L_0x0054:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            java.lang.String r9 = "筛选弹窗选择结果 是否刷新数据 "
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r8)
            r7[r4] = r8
            java.lang.String r8 = "商城班级"
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r8, r7)
            if (r15 != 0) goto L_0x0069
            r7 = r3
            goto L_0x006a
        L_0x0069:
            r7 = r15
        L_0x006a:
            r0.mDayOfWeek = r7
            if (r16 != 0) goto L_0x0070
            r7 = r3
            goto L_0x0072
        L_0x0070:
            r7 = r16
        L_0x0072:
            r0.mTimeRange = r7
            if (r17 != 0) goto L_0x0078
        L_0x0076:
            r7 = r3
            goto L_0x007f
        L_0x0078:
            java.lang.String r7 = r17.getTeacherId()
            if (r7 != 0) goto L_0x007f
            goto L_0x0076
        L_0x007f:
            r0.mTeacherId = r7
            androidx.viewbinding.ViewBinding r7 = r14.getBinding()
            com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassListBinding r7 = (com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassListBinding) r7
            android.widget.CheckedTextView r7 = r7.checkboxRegistered
            r7.setChecked(r1)
            r14.setupFilterTab(r15, r16, r17)
            if (r2 == 0) goto L_0x00aa
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r8 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            int r9 = r0.mCourseId
            java.lang.String r10 = r0.mCourseName
            java.lang.String r11 = r0.mDayOfWeek
            java.lang.String r12 = r0.mTimeRange
            if (r17 != 0) goto L_0x009f
        L_0x009d:
            r13 = r3
            goto L_0x00a7
        L_0x009f:
            java.lang.String r7 = r17.getSysName()
            if (r7 != 0) goto L_0x00a6
            goto L_0x009d
        L_0x00a6:
            r13 = r7
        L_0x00a7:
            r8.shopClassListSizerClick(r9, r10, r11, r12, r13)
        L_0x00aa:
            if (r6 == 0) goto L_0x00b7
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r3 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            int r7 = r0.mCourseId
            java.lang.String r8 = r0.mCourseName
            java.lang.String r9 = "班级列表页-筛选器"
            r3.shopClassListVacancy(r7, r8, r9, r1)
        L_0x00b7:
            if (r2 != 0) goto L_0x00bb
            if (r6 == 0) goto L_0x00bc
        L_0x00bb:
            r4 = r5
        L_0x00bc:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.ShopClassListActivity.changeFilter(java.lang.String, java.lang.String, com.tal.app.thinkacademy.business.shop.bean.ShopClassTeacherData, boolean):boolean");
    }

    static /* synthetic */ void setupFilterTab$default(ShopClassListActivity shopClassListActivity, String str, String str2, ShopClassTeacherData shopClassTeacherData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            shopClassTeacherData = null;
        }
        shopClassListActivity.setupFilterTab(str, str2, shopClassTeacherData);
    }

    private final void setupFilterTab(String str, String str2, ShopClassTeacherData shopClassTeacherData) {
        SelectTabListGroup selectTabListGroup = getBinding().tabFilter;
        Intrinsics.checkNotNullExpressionValue(selectTabListGroup, "binding.tabFilter");
        SelectTabListGroup.setDay$default(selectTabListGroup, str, false, 2, (Object) null);
        SelectTabListGroup selectTabListGroup2 = getBinding().tabFilter;
        Intrinsics.checkNotNullExpressionValue(selectTabListGroup2, "binding.tabFilter");
        SelectTabListGroup.setTime$default(selectTabListGroup2, str2, false, 2, (Object) null);
        SelectTabListGroup selectTabListGroup3 = getBinding().tabFilter;
        Intrinsics.checkNotNullExpressionValue(selectTabListGroup3, "binding.tabFilter");
        SelectTabListGroup.setTeacher$default(selectTabListGroup3, shopClassTeacherData == null ? null : shopClassTeacherData.getSysName(), false, 2, (Object) null);
    }

    static /* synthetic */ void renderTrack$default(ShopClassListActivity shopClassListActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        shopClassListActivity.renderTrack(str);
    }

    private final void renderTrack(String str) {
        if (this.mOnCreateTime != 0) {
            float currentTimeMillis = (((float) (System.currentTimeMillis() - this.mOnCreateTime)) * 1.0f) / ((float) 1000);
            this.mOnCreateTime = 0;
            ShopTrack shopTrack = ShopTrack.INSTANCE;
            CharSequence charSequence = str;
            boolean z = !(charSequence == null || charSequence.length() == 0);
            if (str == null) {
                str = "";
            }
            shopTrack.hw_shop_page_take_up_time(currentTimeMillis, z, str, ShopTrack.ShopPageType.SHOP_CLASS_LIST);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        double d;
        ShopClassListActivity.super.onDestroy();
        this.mFilterDialog = null;
        try {
            BigDecimal divide = BigDecimal.valueOf(System.currentTimeMillis() - this.mEnterTime).divide(BigDecimal.valueOf(1000), 3, 4);
            if (divide.doubleValue() <= 0.0d) {
                d = BigDecimal.ZERO.doubleValue();
            } else {
                d = divide.doubleValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
            XesLog.it(ShopConstantsKt.TAG_SHOP_CLASS, new Object[]{Intrinsics.stringPlus("退出班级列表，计算停留时长异常：", Unit.INSTANCE)});
            d = BigDecimal.ZERO.doubleValue();
        }
        ShopTrack.INSTANCE.shopClassListLeave(this.mCourseId, this.mCourseName, d);
    }

    /* access modifiers changed from: protected */
    public ActivityShopClassListBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityShopClassListBinding inflate = ActivityShopClassListBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }
}
