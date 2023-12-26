package com.tal.app.thinkacademy.business.home.main;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.home.R;
import com.tal.app.thinkacademy.business.home.databinding.ActivityLaunchBinding;
import com.tal.app.thinkacademy.business.home.main.push.PushCenter;
import com.tal.app.thinkacademy.business.home.main.vm.LaunchViewModel;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.location.CustomLocationManager;
import com.tal.app.thinkacademy.common.location.util.LocationAddressKt;
import com.tal.app.thinkacademy.common.util.ChooseSchoolUtil;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoCenterScreen;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.utils.LaunchUtil;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import com.tbruyelle.rxpermissions3.Permission;
import com.tbruyelle.rxpermissions3.RxPermissions;
import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@PadAutoCenterScreen
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001*B\u0005¢\u0006\u0002\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0014J\b\u0010\u0014\u001a\u00020\rH\u0002J\u0012\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\rH\u0002J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\rH\u0014J\b\u0010 \u001a\u00020\rH\u0014J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u000bH\u0002J\b\u0010#\u001a\u00020\rH\u0002J\u0014\u0010$\u001a\u00020\r2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010&\u001a\u00020\rH\u0002J\b\u0010'\u001a\u00020\rH\u0002J\b\u0010(\u001a\u00020\rH\u0016J\b\u0010)\u001a\u00020\rH\u0002R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/LaunchActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/home/main/vm/LaunchViewModel;", "Lcom/tal/app/thinkacademy/business/home/databinding/ActivityLaunchBinding;", "Landroid/view/View$OnClickListener;", "()V", "mHandler", "Landroid/os/Handler;", "mIsSelectSchool", "", "msgCount", "", "analysisLocation", "", "location", "Landroid/location/Location;", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "getSchoolList", "goNormalNext", "path", "", "hideGetSchoolListError", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "setChosenSchool", "schoolCode", "setDefaultLanguage", "showGetSchoolListError", "msg", "showStartSelectSchool", "startLocation", "startObserve", "transferLanguageData", "Companion", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LaunchActivity.kt */
public final class LaunchActivity extends BaseVmActivity<LaunchViewModel, ActivityLaunchBinding> implements View.OnClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "LaunchActivity分校信息";
    /* access modifiers changed from: private */
    public Handler mHandler = new LaunchActivity$mHandler$1(this, Looper.getMainLooper());
    private boolean mIsSelectSchool;
    private final int msgCount = 1;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LaunchActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void setDefaultLanguage() {
    }

    private final void transferLanguageData() {
    }

    public void finish() {
        LaunchActivity.super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        LaunchActivity.super.onPause();
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        LaunchActivity.super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        LaunchActivity.super.onStart();
        ActivityInfo.endStartTrace(getClass().getName());
    }

    public void onStop() {
        LaunchActivity.super.onStop();
        ActivityInfo.stopActivity();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/LaunchActivity$Companion;", "", "()V", "TAG", "", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LaunchActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public ActivityLaunchBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityLaunchBinding inflate = ActivityLaunchBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        LaunchActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, -1, false);
        transferLanguageData();
        List schoolList = SchoolConstants.INSTANCE.getSchoolList();
        this.mIsSelectSchool = (schoolList == null ? 0 : schoolList.size()) > 0;
        getMViewModel().getSchoolListInfo().observe((LifecycleOwner) this, new LaunchActivity$$ExternalSyntheticLambda0(this));
        if (!this.mIsSelectSchool) {
            XesLog.dt(TAG, new Object[]{"本地没有分校信息数据，开始请求"});
            getSchoolList();
            PushCenter.Companion.get().consume();
        } else {
            XesLog.dt(TAG, new Object[]{"本地有分校信息数据，直接展示，让用去选择分校"});
            showStartSelectSchool();
            ImConfig.INSTANCE.getSchoolList();
        }
        getBinding().tvStart.setOnClickListener(this);
        ImConfig.getHostUrlsConfig$default(ImConfig.INSTANCE, (String) null, 1, (Object) null);
        ImConfig.INSTANCE.getConfigInfo();
        LeanplumUtil.longTrack$default("app_homepage_pv", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16382, (Object) null);
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        r0 = r0.getList();
     */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m19onCreate$lambda0(com.tal.app.thinkacademy.business.home.main.LaunchActivity r6, com.tal.app.thinkacademy.common.entity.StateData r7) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.tal.app.thinkacademy.common.entity.StateData$DataStatus r0 = r7.getStatus()
            int[] r1 = com.tal.app.thinkacademy.business.home.main.LaunchActivity.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            java.lang.String r1 = "LaunchActivity分校信息"
            r2 = 1
            r3 = 0
            if (r0 != r2) goto L_0x007e
            java.lang.Object r0 = r7.getData()
            com.tal.app.thinkacademy.common.imconfig.SchoolListInfo r0 = (com.tal.app.thinkacademy.common.imconfig.SchoolListInfo) r0
            if (r0 != 0) goto L_0x0021
        L_0x001f:
            r0 = r3
            goto L_0x002c
        L_0x0021:
            java.util.List r0 = r0.getList()
            if (r0 != 0) goto L_0x0028
            goto L_0x001f
        L_0x0028:
            int r0 = r0.size()
        L_0x002c:
            com.tal.app.thinkacademy.common.constants.SchoolConstants r4 = com.tal.app.thinkacademy.common.constants.SchoolConstants.INSTANCE
            java.lang.Object r5 = r7.getData()
            com.tal.app.thinkacademy.common.imconfig.SchoolListInfo r5 = (com.tal.app.thinkacademy.common.imconfig.SchoolListInfo) r5
            boolean r4 = r4.checkSchoolInfoError(r5)
            if (r4 == 0) goto L_0x0044
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r4 = "检测到分校信息出错,报错给用户，让用户手动点击获取！！！"
            r0[r3] = r4
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r1, r0)
            r0 = r3
        L_0x0044:
            if (r0 <= 0) goto L_0x0070
            com.tal.app.thinkacademy.common.constants.SchoolConstants r0 = com.tal.app.thinkacademy.common.constants.SchoolConstants.INSTANCE
            java.lang.Object r4 = r7.getData()
            com.tal.app.thinkacademy.common.imconfig.SchoolListInfo r4 = (com.tal.app.thinkacademy.common.imconfig.SchoolListInfo) r4
            r0.schoolInfoInitNew(r4)
            r6.hideGetSchoolListError()
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = "获取分校列表数据成功,用户开始让用户选择分校"
            r0[r3] = r2
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r1, r0)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r0 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            java.lang.Object r7 = r7.getData()
            int r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r2 = "launch_school_list_key"
            r0.saveCacheGsonEntity(r7, r2, r1)
            r6.showStartSelectSchool()
            goto L_0x0093
        L_0x0070:
            java.lang.Object[] r7 = new java.lang.Object[r2]
            java.lang.String r0 = "获取分校列表数据分校列表为空,直接展示失败，让用户重试"
            r7[r3] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r1, r7)
            r7 = 0
            showGetSchoolListError$default(r6, r7, r2, r7)
            goto L_0x0093
        L_0x007e:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = "获取分校列表数据失败,直接展示失败，让用户重试"
            r0[r3] = r2
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r1, r0)
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            java.lang.String r7 = com.tal.app.thinkacademy.common.CommonKtxKt.formatBadResult(r7)
            r6.showGetSchoolListError(r7)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.LaunchActivity.m19onCreate$lambda0(com.tal.app.thinkacademy.business.home.main.LaunchActivity, com.tal.app.thinkacademy.common.entity.StateData):void");
    }

    static /* synthetic */ void showGetSchoolListError$default(LaunchActivity launchActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        launchActivity.showGetSchoolListError(str);
    }

    private final void showGetSchoolListError(String str) {
        LoadStatusView loadStatusView = getBinding().launchStatusView;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.launchStatusView");
        int i = R.drawable.launch_logo;
        String string = getString(R.string.retry);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.retry)");
        LoadStatusView.showErrorView$default(loadStatusView, i, (String) null, string, str, new LaunchActivity$showGetSchoolListError$1(this), 2, (Object) null);
        getBinding().launchStatusView.setContentBg(R.color.color_F4F6FA);
    }

    private final void hideGetSchoolListError() {
        getBinding().launchStatusView.restoreView();
    }

    private final void showStartSelectSchool() {
        CharSequence string = ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        if (string == null || string.length() == 0) {
            PushCenter.Companion.get().consume();
            getBinding().tvStart.setVisibility(0);
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new LaunchActivity$$ExternalSyntheticLambda2(this), 1000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showStartSelectSchool$lambda-1  reason: not valid java name */
    public static final void m20showStartSelectSchool$lambda1(LaunchActivity launchActivity) {
        Intrinsics.checkNotNullParameter(launchActivity, "this$0");
        goNormalNext$default(launchActivity, (String) null, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void getSchoolList() {
        if (!this.mIsSelectSchool) {
            getBinding().launchStatusView.showFullLoadingView(R.color.color_F4F6FA);
        }
        getMViewModel().getSchoolList();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        LaunchActivity.super.onResume();
        if (LaunchUtil.sAppStartTime > 0) {
            LaunchUtil.sAppStartTime = 0;
            LaunchTrack.INSTANCE.appLaunch(SystemClock.elapsedRealtime() - LaunchUtil.sAppStartTime);
        }
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    public void startObserve() {
        getMViewModel().getSchoolCode().observe((LifecycleOwner) this, new LaunchActivity$startObserve$$inlined$observe$1(this));
    }

    private final void startLocation() {
        Observable requestEachCombined;
        showLoading();
        String[] strArr = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
        RxPermissions mRxPermissions = getMRxPermissions();
        if (mRxPermissions != null && (requestEachCombined = mRxPermissions.requestEachCombined((String[]) Arrays.copyOf(strArr, 2))) != null) {
            requestEachCombined.subscribe(new LaunchActivity$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startLocation$lambda-3  reason: not valid java name */
    public static final void m21startLocation$lambda3(LaunchActivity launchActivity, Permission permission) {
        LaunchActivity launchActivity2 = launchActivity;
        Intrinsics.checkNotNullParameter(launchActivity2, "this$0");
        LeanplumUtil.longTrack$default("ip_access_popup_show", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16382, (Object) null);
        if (permission.granted) {
            XesLog.dt(TAG, new Object[]{"start location"});
            Handler handler = launchActivity2.mHandler;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(launchActivity2.msgCount, 10000);
            }
            LeanplumUtil.longTrack$default("click_allow_ip_access", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16382, (Object) null);
            CustomLocationManager.Companion.getInstance((Context) launchActivity2).start(new LaunchActivity$startLocation$1$1(launchActivity2), true);
            return;
        }
        launchActivity.hideLoading();
        XesLog.dt(TAG, new Object[]{"choose school directly"});
        launchActivity2.goNormalNext("do_not_allow_ip_access");
    }

    static /* synthetic */ void goNormalNext$default(LaunchActivity launchActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        launchActivity.goNormalNext(str);
    }

    /* access modifiers changed from: private */
    public final void goNormalNext(String str) {
        CharSequence string = ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        if (string == null || string.length() == 0) {
            Bundle bundle = new Bundle();
            bundle.putString("school_selection_path", str);
            XesRoute.getInstance().navigation("/login/select_school_activity", bundle);
            finish();
            return;
        }
        XesLog.dt(TAG, new Object[]{"已经选择分校，直接进入首页"});
        ImConfig.getHostUrlsConfig$default(ImConfig.INSTANCE, (String) null, 1, (Object) null);
        XesRoute.getInstance().navigation("/home/main_activity");
        finish();
    }

    /* access modifiers changed from: private */
    public final void setChosenSchool(int i) {
        ShareDataManager.getInstance().put("location_country", true, ShareDataManager.SHAREDATA_NOT_CLEAR);
        ShareDataManager.getInstance().put("school_code", String.valueOf(i), ShareDataManager.SHAREDATA_NOT_CLEAR);
        ShareDataManager.getInstance().saveCacheGsonEntity(ChooseSchoolUtil.INSTANCE.getChosenSchoolBean(i), "current_school_info", ShareDataManager.SHAREDATA_NOT_CLEAR);
        ImConfig.getHostUrlsConfig$default(ImConfig.INSTANCE, (String) null, 1, (Object) null);
        goNormalNext$default(this, (String) null, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void analysisLocation(Location location) {
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale, "ENGLISH");
        List address = LocationAddressKt.getAddress((Context) this, location, locale);
        Collection collection = address;
        if (collection == null || collection.isEmpty()) {
            goNormalNext$default(this, (String) null, 1, (Object) null);
            return;
        }
        Address address2 = (Address) address.get(0);
        XesLog.dt(TAG, new Object[]{Intrinsics.stringPlus("countryName = ", address2.getCountryName())});
        XesLog.dt(TAG, new Object[]{Intrinsics.stringPlus("countryCode = ", address2.getCountryCode())});
        showLoading();
        XesLog.dt(TAG, new Object[]{"开始请求自动定位的：schoolCode"});
        getMViewModel().getSchoolCode(address2.getCountryCode());
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, this);
        XesLog.dt(TAG, new Object[]{"点击start按钮，开始启动自动定位"});
        LeanplumUtil.longTrack$default("click_enter_app", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16382, (Object) null);
        startLocation();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        CustomLocationManager.Companion.getInstance((Context) this).onDestroy();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mHandler = null;
        LaunchActivity.super.onDestroy();
    }
}
