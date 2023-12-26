package com.tal.app.thinkacademy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.TestData;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.view.BrowserActivity;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.databinding.ActivityMain2Binding;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.imageloader.ImageRequestListener;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.progress.OnProgressListener;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.lib.utils.XesFragmentManager;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus2;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tbruyelle.rxpermissions3.RxPermissions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u000fH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/DemoActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/DemoViewModel;", "Lcom/tal/app/thinkacademy/databinding/ActivityMain2Binding;", "()V", "url1", "", "getUrl1", "()Ljava/lang/String;", "setUrl1", "(Ljava/lang/String;)V", "url2", "getUrl2", "setUrl2", "applyPermission", "", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "startObserve", "app_googleRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DemoActivity.kt */
public final class DemoActivity extends BaseVmActivity<DemoViewModel, ActivityMain2Binding> {
    private String url1 = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=579539400,2248223712&fm=26&gp=0.jpg";
    private String url2 = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=579539400,2248223712&fm=26&gp=0.jpg";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DemoActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            iArr[StateData.DataStatus.ERROR.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: applyPermission$lambda-9  reason: not valid java name */
    public static final void m5applyPermission$lambda9(boolean z) {
    }

    public void finish() {
        DemoActivity.super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        DemoActivity.super.onPause();
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        DemoActivity.super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        DemoActivity.super.onResume();
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        DemoActivity.super.onStart();
        ActivityInfo.endStartTrace(getClass().getName());
    }

    public void onStop() {
        DemoActivity.super.onStop();
        ActivityInfo.stopActivity();
    }

    public final String getUrl1() {
        return this.url1;
    }

    public final void setUrl1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url1 = str;
    }

    public final String getUrl2() {
        return this.url2;
    }

    public final void setUrl2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url2 = str;
    }

    /* access modifiers changed from: protected */
    public ActivityMain2Binding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityMain2Binding inflate = ActivityMain2Binding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        DemoActivity.super.onCreate(bundle);
        XesDataBus.with("testdata").setStickyData("aaaaaaaaa");
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        XesDataBus.with("testdata").observerSticky(lifecycleOwner, true, DemoActivity$$ExternalSyntheticLambda8.INSTANCE);
        XesDataBus.with("testdata").setStickyData("bbb");
        getBinding().buttonWebview.setOnClickListener(new DemoActivity$$ExternalSyntheticLambda1(this));
        getBinding().titleBar.setOnTitleBarListener(new DemoActivity$onCreate$3());
        XesImageLoader xesImageLoader = XesImageLoader.INSTANCE;
        ImageView imageView = getBinding().ivTest;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivTest");
        Context context = (Context) this;
        XesImageLoader.loadImage$default(xesImageLoader, imageView, context, this.url1, 0, (OnProgressListener) null, (ImageRequestListener) null, 28, (Object) null);
        XesImageLoader xesImageLoader2 = XesImageLoader.INSTANCE;
        ImageView imageView2 = getBinding().ivTest2;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivTest2");
        Context context2 = context;
        XesImageLoader.loadImage$default(xesImageLoader2, imageView2, context2, this.url2, 0, (OnProgressListener) null, (ImageRequestListener) null, 28, (Object) null);
        XesImageLoader xesImageLoader3 = XesImageLoader.INSTANCE;
        ImageView imageView3 = getBinding().ivTest3;
        String str = this.url2;
        ImageRequestListener demoActivity$onCreate$4 = new DemoActivity$onCreate$4(this);
        OnProgressListener demoActivity$onCreate$5 = new DemoActivity$onCreate$5();
        Intrinsics.checkNotNullExpressionValue(imageView3, "ivTest3");
        XesImageLoader.loadImage$default(xesImageLoader3, imageView3, context2, str, 0, demoActivity$onCreate$5, demoActivity$onCreate$4, 4, (Object) null);
        applyPermission();
        ImageLoaderJ.load(context, this.url1, getBinding().ivTest);
        XesLog.dt("TAG", new Object[]{getIntent().getStringExtra("bbb")});
        XesLog.dt("TAG", new Object[]{Integer.valueOf(getIntent().getIntExtra("aaa", 0))});
        PluginEventBus.onEvent("aaa", PluginEventData.obtainData(getClass(), "bbb"));
        getBinding().testBtn.setOnClickListener(DemoActivity$$ExternalSyntheticLambda4.INSTANCE);
        getBinding().testBtnBack.setOnClickListener(DemoActivity$$ExternalSyntheticLambda3.INSTANCE);
        getBinding().loginBtn.setOnClickListener(new DemoActivity$$ExternalSyntheticLambda0(this));
        getBinding().buttonFragment.setOnClickListener(new DemoActivity$$ExternalSyntheticLambda2(this));
        getBinding().buttonChangeLanguage.setOnClickListener(DemoActivity$$ExternalSyntheticLambda5.INSTANCE);
        ShareDataManager.getInstance().put("test", "string", ShareDataManager.SHAREDATA_TOURIST);
        ShareDataManager.getInstance().put("test", "string", ShareDataManager.SHAREDATA_TOURIST, true);
        ShareDataManager.getInstance().getString("test", "", ShareDataManager.SHAREDATA_TOURIST);
        ShareDataManager.getInstance().getString("test", "", ShareDataManager.SHAREDATA_TOURIST, true);
        PluginEventBus2.register(lifecycleOwner, "aaa", DemoActivity$$ExternalSyntheticLambda7.INSTANCE);
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m6onCreate$lambda0(String str) {
        XesLog.et("testdata", new Object[]{str});
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m7onCreate$lambda1(DemoActivity demoActivity, View view) {
        Intrinsics.checkNotNullParameter(demoActivity, "this$0");
        demoActivity.startActivity(new Intent((Context) demoActivity, BrowserActivity.class));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m8onCreate$lambda2(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("liveParams", "{\n             \"planId\":\"130\",\n             \"courseId\":\"82286\",\n             \"liveType\":3\n             \"bizId\":1\n             }");
        XesRoute.getInstance().navigation("/live/live_player", bundle);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3  reason: not valid java name */
    public static final void m9onCreate$lambda3(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("liveParams", "{\n             \"planId\":\"130\",\n             \"courseId\":\"82286\",\n             \"liveType\":3\n             \"bizId\":1\n             }");
        XesRoute.getInstance().navigation("/live/player_back", bundle);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-4  reason: not valid java name */
    public static final void m10onCreate$lambda4(DemoActivity demoActivity, View view) {
        Intrinsics.checkNotNullParameter(demoActivity, "this$0");
        PluginEventBus2.onEvent("aaa", PluginEventData.obtainData(demoActivity.getClass(), "bbb"));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-5  reason: not valid java name */
    public static final void m11onCreate$lambda5(DemoActivity demoActivity, View view) {
        Intrinsics.checkNotNullParameter(demoActivity, "this$0");
        XesFragmentManager.INSTANCE.addFragment((AppCompatActivity) demoActivity, new DemoFragment(), 16908290);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-6  reason: not valid java name */
    public static final void m12onCreate$lambda6(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-7  reason: not valid java name */
    public static final void m13onCreate$lambda7(PluginEventData pluginEventData) {
        XesLog.dt("lizheng", new Object[]{"sssssss"});
    }

    public void startObserve() {
        getMViewModel().getLiveData().observe((LifecycleOwner) this, DemoActivity$$ExternalSyntheticLambda6.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-8  reason: not valid java name */
    public static final void m14startObserve$lambda8(StateData stateData) {
        TestData.Data data;
        TestData.Data.Monitor monitor;
        int i = WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()];
        if (i == 1) {
            XesLog.et("TAG", new Object[]{stateData.getData()});
            TestData testData = (TestData) stateData.getData();
            if (testData != null && (data = testData.getData()) != null && (monitor = data.getMonitor()) != null) {
                monitor.getConfigdata();
            }
        } else if (i == 2) {
            XesLog.et("TAG", new Object[]{stateData.getData()});
        }
    }

    private final void applyPermission() {
        new RxPermissions((FragmentActivity) this).request(new String[]{"android.permission.CAMERA", "android.permission.READ_PHONE_STATE"}).subscribe(DemoActivity$$ExternalSyntheticLambda9.INSTANCE);
    }
}
