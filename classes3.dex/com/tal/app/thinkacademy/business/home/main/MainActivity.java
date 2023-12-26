package com.tal.app.thinkacademy.business.home.main;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.gyf.immersionbar.ImmersionBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.home.R;
import com.tal.app.thinkacademy.business.home.databinding.ActivityMainBinding;
import com.tal.app.thinkacademy.business.home.databinding.DialogLoginAgainBinding;
import com.tal.app.thinkacademy.business.home.main.MainActivityLogic;
import com.tal.app.thinkacademy.business.home.main.vm.MainViewModel;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.AppVersionBll;
import com.tal.app.thinkacademy.common.business.browser.agent.WebAgent;
import com.tal.app.thinkacademy.common.business.browser.cache.HwWebViewCacheManager;
import com.tal.app.thinkacademy.common.business.browser.helper.FragmentListener;
import com.tal.app.thinkacademy.common.business.browser.helper.XesWebViewCookieUtils;
import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.flutter.EventToFlutter;
import com.tal.app.thinkacademy.common.flutter.HwFlutterUtil;
import com.tal.app.thinkacademy.common.logan.LoganHelper;
import com.tal.app.thinkacademy.common.playerpreload.PlayerPreLoadHelp;
import com.tal.app.thinkacademy.common.track.CommonTrack;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.route.FlutterToModuleService;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.AppUtils;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.business.redpackagerain.listener.GameResRequestListener;
import com.tal.app.thinkacademy.live.business.redpackagerain.util.GameResUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0014J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020)H\u0014J\u0012\u0010.\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\b\u00101\u001a\u00020)H\u0014J\b\u00102\u001a\u00020)H\u0014J\u0010\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\u0018H\u0016J\b\u00105\u001a\u00020)H\u0002J\b\u00106\u001a\u00020)H\u0002J\b\u00107\u001a\u00020)H\u0016J\b\u00108\u001a\u00020)H\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/MainActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/home/main/vm/MainViewModel;", "Lcom/tal/app/thinkacademy/business/home/databinding/ActivityMainBinding;", "Lcom/tal/app/thinkacademy/business/home/main/MainActivityLogic$ActivityProvider;", "Lcom/tal/app/thinkacademy/common/business/browser/helper/FragmentListener;", "()V", "isToken", "", "()Z", "setToken", "(Z)V", "listenTimeZoneChange", "Landroidx/lifecycle/Observer;", "", "mActivityLogic", "Lcom/tal/app/thinkacademy/business/home/main/MainActivityLogic;", "mClientLoggingIn", "mFirstClickTime", "", "mLoginDialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/home/databinding/DialogLoginAgainBinding;", "mWebAgent", "Lcom/tal/app/thinkacademy/common/business/browser/agent/WebAgent;", "observerRequestHomeworkOutTime", "observerSyncHomework", "observerSyncHomeworkSuccess", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "getActivity", "Landroid/app/Activity;", "getActivityLifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "getActivityResources", "Landroid/content/res/Resources;", "getActivitySupportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "process", "webAgent", "pushClientLogin", "registerFlutterEvent", "startObserve", "uploadLog", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MainActivity.kt */
public final class MainActivity extends BaseVmActivity<MainViewModel, ActivityMainBinding> implements MainActivityLogic.ActivityProvider, FragmentListener {
    private boolean isToken;
    private final Observer<Object> listenTimeZoneChange = new MainActivity$$ExternalSyntheticLambda3(this);
    /* access modifiers changed from: private */
    public MainActivityLogic mActivityLogic;
    /* access modifiers changed from: private */
    public boolean mClientLoggingIn;
    private long mFirstClickTime;
    private BaseBindDialog<DialogLoginAgainBinding> mLoginDialog;
    private WebAgent mWebAgent;
    private final Observer<Object> observerRequestHomeworkOutTime = MainActivity$$ExternalSyntheticLambda6.INSTANCE;
    private final Observer<Object> observerSyncHomework = MainActivity$$ExternalSyntheticLambda7.INSTANCE;
    private final Observer<Object> observerSyncHomeworkSuccess = MainActivity$$ExternalSyntheticLambda8.INSTANCE;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MainActivity.kt */
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

    public void finish() {
        MainActivity.super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        MainActivity.super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        MainActivity.super.onStart();
        ActivityInfo.endStartTrace(getClass().getName());
    }

    public void onStop() {
        MainActivity.super.onStop();
        ActivityInfo.stopActivity();
    }

    public final boolean isToken() {
        return this.isToken;
    }

    public final void setToken(boolean z) {
        this.isToken = z;
    }

    /* access modifiers changed from: protected */
    public ActivityMainBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityMainBinding inflate = ActivityMainBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        MainActivity.super.onCreate(bundle);
        ImmersionBar.with((Activity) this).keyboardEnable(false).statusBarDarkFont(true).navigationBarColor(R.color.white).navigationBarDarkIcon(true).init();
        this.mActivityLogic = new MainActivityLogic(this, bundle);
        uploadLog();
        XesWebViewCookieUtils.clearCookies();
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        XesDataBus.with("home_tab_red_point").observe(lifecycleOwner, new MainActivity$$ExternalSyntheticLambda2(this));
        XesDataBus.with("main_tab_switch").observe(lifecycleOwner, new MainActivity$onCreate$$inlined$observe$1(this));
        ThreadUtils.runOnUiThreadDelayed(MainActivity$$ExternalSyntheticLambda9.INSTANCE, 100);
        PlayerPreLoadHelp.Companion.getInstance().getInitData();
        MainActivityLogic mainActivityLogic = this.mActivityLogic;
        if (mainActivityLogic != null) {
            mainActivityLogic.registerTimeZoneReceiver();
        }
        CommonTrack.INSTANCE.hw_armabi_so_collect();
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m29onCreate$lambda1(MainActivity mainActivity, Pair pair) {
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        MainActivityLogic mainActivityLogic = mainActivity.mActivityLogic;
        if (mainActivityLogic != null) {
            mainActivityLogic.setXesTabHintPoint((String) pair.getFirst(), ((Boolean) pair.getSecond()).booleanValue());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3  reason: not valid java name */
    public static final void m30onCreate$lambda3() {
        HwWebViewCacheManager.Companion.getInstance().preLoadWeb();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        r8 = r8.getExtras();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNewIntent(android.content.Intent r8) {
        /*
            r7 = this;
            com.tal.app.thinkacademy.business.home.main.MainActivity.super.onNewIntent(r8)
            r7.setIntent(r8)
            android.content.Intent r8 = r7.getIntent()
            java.lang.String r0 = "TAB_STUDY"
            if (r8 != 0) goto L_0x000f
            goto L_0x0019
        L_0x000f:
            java.lang.String r1 = "tabName"
            java.lang.String r8 = r8.getStringExtra(r1)
            if (r8 != 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r0 = r8
        L_0x0019:
            android.content.Intent r8 = r7.getIntent()
            java.lang.String r1 = "live"
            if (r8 != 0) goto L_0x0022
            goto L_0x002c
        L_0x0022:
            java.lang.String r2 = "courseType"
            java.lang.String r8 = r8.getStringExtra(r2)
            if (r8 != 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r1 = r8
        L_0x002c:
            com.tal.app.thinkacademy.business.home.main.MainActivityLogic r8 = r7.mActivityLogic
            if (r8 != 0) goto L_0x0031
            goto L_0x0034
        L_0x0031:
            r8.selectTab(r0, r1)
        L_0x0034:
            android.content.Intent r8 = r7.getIntent()
            r0 = 0
            if (r8 != 0) goto L_0x003d
        L_0x003b:
            r8 = r0
            goto L_0x004a
        L_0x003d:
            android.os.Bundle r8 = r8.getExtras()
            if (r8 != 0) goto L_0x0044
            goto L_0x003b
        L_0x0044:
            java.lang.String r1 = "isToken"
            java.lang.Object r8 = r8.get(r1)
        L_0x004a:
            android.content.Intent r1 = r7.getIntent()
            if (r1 != 0) goto L_0x0052
        L_0x0050:
            r1 = r0
            goto L_0x005f
        L_0x0052:
            android.os.Bundle r1 = r1.getExtras()
            if (r1 != 0) goto L_0x0059
            goto L_0x0050
        L_0x0059:
            java.lang.String r2 = "message"
            java.lang.Object r1 = r1.get(r2)
        L_0x005f:
            if (r8 != 0) goto L_0x0062
            goto L_0x0070
        L_0x0062:
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Boolean"
            java.util.Objects.requireNonNull(r8, r2)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r7.setToken(r8)
        L_0x0070:
            boolean r8 = r7.isToken
            if (r8 == 0) goto L_0x00df
            com.tal.app.thinkacademy.business.login.business.LoginOut r8 = com.tal.app.thinkacademy.business.login.business.LoginOut.INSTANCE
            r2 = r7
            android.content.Context r2 = (android.content.Context) r2
            r3 = 1
            r8.loginOut(r2, r3)
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.home.databinding.DialogLoginAgainBinding> r8 = r7.mLoginDialog
            r2 = 0
            if (r8 != 0) goto L_0x00b5
            com.tal.app.thinkacademy.business.home.main.MainActivity$onNewIntent$2 r8 = new com.tal.app.thinkacademy.business.home.main.MainActivity$onNewIntent$2
            r8.<init>(r7)
            r3 = 80
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r3 = r8.gravity(r3)
            android.widget.LinearLayout$LayoutParams r4 = new android.widget.LinearLayout$LayoutParams
            r5 = -1
            r6 = -2
            r4.<init>(r5, r6)
            android.view.ViewGroup$LayoutParams r4 = (android.view.ViewGroup.LayoutParams) r4
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog r3 = r3.layoutParams(r4)
            r3.canceledOnTouchOutside(r2)
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog r8 = (com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog) r8
            r7.mLoginDialog = r8
            androidx.viewbinding.ViewBinding r8 = r8.binding
            com.tal.app.thinkacademy.business.home.databinding.DialogLoginAgainBinding r8 = (com.tal.app.thinkacademy.business.home.databinding.DialogLoginAgainBinding) r8
            if (r8 != 0) goto L_0x00a8
            goto L_0x00b5
        L_0x00a8:
            android.widget.TextView r8 = r8.tvLogin
            if (r8 != 0) goto L_0x00ad
            goto L_0x00b5
        L_0x00ad:
            com.tal.app.thinkacademy.business.home.main.MainActivity$$ExternalSyntheticLambda0 r3 = new com.tal.app.thinkacademy.business.home.main.MainActivity$$ExternalSyntheticLambda0
            r3.<init>(r7)
            r8.setOnClickListener(r3)
        L_0x00b5:
            if (r1 != 0) goto L_0x00b8
            goto L_0x00d5
        L_0x00b8:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.home.databinding.DialogLoginAgainBinding> r8 = r7.mLoginDialog
            if (r8 != 0) goto L_0x00bd
            goto L_0x00c6
        L_0x00bd:
            androidx.viewbinding.ViewBinding r8 = r8.binding
            com.tal.app.thinkacademy.business.home.databinding.DialogLoginAgainBinding r8 = (com.tal.app.thinkacademy.business.home.databinding.DialogLoginAgainBinding) r8
            if (r8 != 0) goto L_0x00c4
            goto L_0x00c6
        L_0x00c4:
            android.widget.TextView r0 = r8.tvDialogContent
        L_0x00c6:
            if (r0 != 0) goto L_0x00c9
            goto L_0x00d5
        L_0x00c9:
            java.lang.String r8 = "null cannot be cast to non-null type kotlin.String"
            java.util.Objects.requireNonNull(r1, r8)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x00d5:
            com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog<com.tal.app.thinkacademy.business.home.databinding.DialogLoginAgainBinding> r8 = r7.mLoginDialog
            if (r8 != 0) goto L_0x00da
            goto L_0x00dd
        L_0x00da:
            r8.show()
        L_0x00dd:
            r7.isToken = r2
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.MainActivity.onNewIntent(android.content.Intent):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onNewIntent$lambda-6  reason: not valid java name */
    public static final void m31onNewIntent$lambda6(MainActivity mainActivity, View view) {
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        XesRoute.getInstance().navigation("/login/login_activity");
        BaseBindDialog<DialogLoginAgainBinding> baseBindDialog = mainActivity.mLoginDialog;
        if (baseBindDialog != null) {
            baseBindDialog.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        MainActivity.super.onResume();
        MainActivityLogic mainActivityLogic = this.mActivityLogic;
        if (mainActivityLogic != null) {
            mainActivityLogic.setOnResume(true);
        }
        HwCloudControlHelper.Companion.get().syncCloud();
        if (!UserInfoBll.Companion.getInstance().isGuest()) {
            GameResUtil.Companion.get().requestGamePackage((GameResRequestListener) null);
        }
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        MainActivity.super.onPause();
        MainActivityLogic mainActivityLogic = this.mActivityLogic;
        if (mainActivityLogic != null) {
            mainActivityLogic.setOnResume(false);
        }
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    public void onBackPressed() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mFirstClickTime < 2000) {
            XesDataBus.with("on_app_exit").setStickyData("");
            AppUtils.exitApp();
            return;
        }
        this.mFirstClickTime = currentTimeMillis;
        showToast(getString(R.string.toast_exit_app));
    }

    public void startObserve() {
        MainActivity.super.startObserve();
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        XesDataBus.with("push_client_login").observerSticky(lifecycleOwner, true, new MainActivity$$ExternalSyntheticLambda1(this));
        XesDataBus.with("user_center_login_bus").observe(lifecycleOwner, new MainActivity$startObserve$$inlined$observe$1(this));
        XesDataBus.with("user_switch_login_success").observe(lifecycleOwner, new MainActivity$startObserve$$inlined$observe$2(this));
        if (!PadAutoUtil.isCloseScreenLandscape()) {
            registerFlutterEvent();
        }
        getMViewModel().getClientLogin().observe(lifecycleOwner, new MainActivity$startObserve$$inlined$observe$3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-8  reason: not valid java name */
    public static final void m34startObserve$lambda8(MainActivity mainActivity, String str) {
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        mainActivity.pushClientLogin();
    }

    /* access modifiers changed from: private */
    /* renamed from: observerSyncHomeworkSuccess$lambda-12  reason: not valid java name */
    public static final void m28observerSyncHomeworkSuccess$lambda12(Object obj) {
        XesLog.dt("", new Object[]{"收到js提交作业,开始发送flutter"});
        HwFlutterUtil.sendEventToFlutter$default(HwFlutterUtil.INSTANCE, EventToFlutter.course_detail_refresh, (HashMap) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: observerRequestHomeworkOutTime$lambda-13  reason: not valid java name */
    public static final void m26observerRequestHomeworkOutTime$lambda13(Object obj) {
        ToastUtils.setGravity(17, 0, 0);
        ToastUtils.showShort("Network error (or your account is signed in on another device)", new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: observerSyncHomework$lambda-14  reason: not valid java name */
    public static final void m27observerSyncHomework$lambda14(Object obj) {
        FlutterToModuleService flutterToModuleService = (FlutterToModuleService) XesRoute.getInstance().get("/study/routeService");
        if (flutterToModuleService != null) {
            flutterToModuleService.onEvent("openPushNotification", (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: listenTimeZoneChange$lambda-15  reason: not valid java name */
    public static final void m25listenTimeZoneChange$lambda15(MainActivity mainActivity, Object obj) {
        Intrinsics.checkNotNullParameter(mainActivity, "this$0");
        MainActivityLogic mainActivityLogic = mainActivity.mActivityLogic;
        if (mainActivityLogic != null) {
            mainActivityLogic.timeZoneForFlutterCheck();
        }
    }

    private final void registerFlutterEvent() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        XesDataBus.with("user_center_login_bus").observe(lifecycleOwner, new MainActivity$registerFlutterEvent$$inlined$observe$1());
        XesDataBus.with("user_center_logout_bus").observe(lifecycleOwner, new MainActivity$registerFlutterEvent$$inlined$observe$2());
        XesDataBus.with("seleted_time_zone").observe(lifecycleOwner, new MainActivity$registerFlutterEvent$$inlined$observe$3());
        XesDataBus.with("study_tab_switch").observerSticky(lifecycleOwner, true, MainActivity$$ExternalSyntheticLambda5.INSTANCE);
        XesDataBus.with("study_tab_live_update").observerSticky(lifecycleOwner, true, MainActivity$$ExternalSyntheticLambda4.INSTANCE);
        XesDataBus.with("system_time_zone_changed").observeForever(this.listenTimeZoneChange);
        XesDataBus.with("syc_homework").observeForever(this.observerSyncHomework);
        XesDataBus.with("sync_homework_success").observeForever(this.observerSyncHomeworkSuccess);
        XesDataBus.with("request_homework_out_time").observeForever(this.observerRequestHomeworkOutTime);
    }

    /* access modifiers changed from: private */
    /* renamed from: registerFlutterEvent$lambda-19  reason: not valid java name */
    public static final void m32registerFlutterEvent$lambda19(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) "live")) {
            HwFlutterUtil.sendEventToFlutter$default(HwFlutterUtil.INSTANCE, EventToFlutter.REFRESH_STUDY_CENTER, (HashMap) null, 2, (Object) null);
            HwFlutterUtil.sendEventToFlutter$default(HwFlutterUtil.INSTANCE, EventToFlutter.SWITCH_TAB_TO_LIVE, (HashMap) null, 2, (Object) null);
        } else if (Intrinsics.areEqual((Object) str, (Object) "recorded")) {
            HwFlutterUtil.sendEventToFlutter$default(HwFlutterUtil.INSTANCE, EventToFlutter.REFRESH_STUDY_CENTER, (HashMap) null, 2, (Object) null);
            HwFlutterUtil.sendEventToFlutter$default(HwFlutterUtil.INSTANCE, EventToFlutter.SWITCH_TAB_TO_RECORD, (HashMap) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerFlutterEvent$lambda-20  reason: not valid java name */
    public static final void m33registerFlutterEvent$lambda20(Boolean bool) {
        HwFlutterUtil.sendEventToFlutter$default(HwFlutterUtil.INSTANCE, EventToFlutter.REFRESH_STUDY_CENTER, (HashMap) null, 2, (Object) null);
    }

    private final void uploadLog() {
        LoganHelper.newFileWithUpload$default((Context) this, (String) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void pushClientLogin() {
        String uid;
        if (UserInfoBll.Companion.getInstance().isGuest()) {
            XesLog.e(Tag.PUSH, new Object[]{"未登录，不执行clientLogin请求"});
            return;
        }
        String str = "";
        String string = ShareDataManager.getInstance().getString("push_client_id", str, ShareDataManager.SHAREDATA_NOT_CLEAR);
        CharSequence charSequence = string;
        if (charSequence == null || charSequence.length() == 0) {
            XesLog.e(Tag.PUSH, new Object[]{"cid 为空，不执行clientLogin请求"});
        } else if (this.mClientLoggingIn) {
            XesLog.i(Tag.PUSH, new Object[]{Intrinsics.stringPlus("clientLogin请求执行中 cid:", string)});
        } else {
            XesLogTag xesLogTag = Tag.PUSH;
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("执行clientLogin请求 cid:");
            sb.append(string);
            sb.append(" uid:");
            UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
            if (!(userInfoEntity == null || (uid = userInfoEntity.getUid()) == null)) {
                str = uid;
            }
            sb.append(str);
            objArr[0] = sb.toString();
            XesLog.i(xesLogTag, objArr);
            this.mClientLoggingIn = true;
            Intrinsics.checkNotNullExpressionValue(string, "cid");
            getMViewModel().clientLogin(string, 1);
        }
    }

    public Resources getActivityResources() {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return resources;
    }

    public FragmentManager getActivitySupportFragmentManager() {
        return getSupportFragmentManager();
    }

    public LifecycleCoroutineScope getActivityLifecycleScope() {
        return LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this);
    }

    public Activity getActivity() {
        return (Activity) this;
    }

    public void process(WebAgent webAgent) {
        Intrinsics.checkNotNullParameter(webAgent, "webAgent");
        this.mWebAgent = webAgent;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        MainActivity.super.onDestroy();
        MainActivityLogic mainActivityLogic = this.mActivityLogic;
        if (mainActivityLogic != null) {
            mainActivityLogic.unRegisterTimeZoneReceiver();
        }
        XesDataBus.with("system_time_zone_changed").removeObserver(this.listenTimeZoneChange);
        XesDataBus.with("syc_homework").removeObserver(this.observerSyncHomework);
        XesDataBus.with("sync_homework_success").removeObserver(this.observerSyncHomeworkSuccess);
        XesDataBus.with("request_homework_out_time").removeObserver(this.observerRequestHomeworkOutTime);
        AppVersionBll.Companion.getInstance().cancelUpdate();
        MainActivityLogic mainActivityLogic2 = this.mActivityLogic;
        if (mainActivityLogic2 != null) {
            mainActivityLogic2.onDestroy();
        }
        WebAgent webAgent = this.mWebAgent;
        if (webAgent != null) {
            webAgent.onDestroy();
        }
        this.mWebAgent = null;
    }
}
