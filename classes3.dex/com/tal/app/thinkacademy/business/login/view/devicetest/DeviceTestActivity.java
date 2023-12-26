package com.tal.app.thinkacademy.business.login.view.devicetest;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.databinding.ActivityDeviceTestBinding;
import com.tal.app.thinkacademy.business.login.entity.DeviceConfig;
import com.tal.app.thinkacademy.business.login.entity.DeviceTestResult;
import com.tal.app.thinkacademy.business.login.entity.NetTestBean;
import com.tal.app.thinkacademy.business.login.presenter.DeviceTestViewModel;
import com.tal.app.thinkacademy.business.login.view.customview.DeviceTestStepTitle;
import com.tal.app.thinkacademy.business.login.view.devicetest.driver.CameraTestDriver;
import com.tal.app.thinkacademy.business.login.view.devicetest.driver.DeviceTestDriverOwner;
import com.tal.app.thinkacademy.business.login.view.devicetest.driver.MicTestDriver;
import com.tal.app.thinkacademy.business.login.view.devicetest.driver.NetTestDriver;
import com.tal.app.thinkacademy.business.login.view.devicetest.driver.TestResultDriver;
import com.tal.app.thinkacademy.business.login.view.devicetest.driver.VoiceTestDriver;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.common.utils.AudioRecordHelper;
import com.tal.app.thinkacademy.common.utils.PCMShortListener;
import com.tal.app.thinkacademy.common.utils.VolumeChangeHelper;
import com.tal.app.thinkacademy.common.widget.DeviceTesting;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.BarUtils;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0007\u0018\u0000 @2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001@B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00130\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\rH\u0014J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\tH\u0016J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J(\u0010%\u001a\u00020\u00132\u001e\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00130&H\u0016J\u0012\u0010(\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020\u0013H\u0014J\b\u0010,\u001a\u00020\u0013H\u0014J\b\u0010-\u001a\u00020\u0013H\u0014J\b\u0010.\u001a\u00020\u0013H\u0014J\u0018\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020'H\u0016J$\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u0002042\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u0016H\u0016J\b\u00105\u001a\u00020\u0013H\u0016J\u001e\u00106\u001a\u00020\u00132\u0014\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000107\u0012\u0004\u0012\u00020\u00130\u0016H\u0016J\b\u00108\u001a\u00020\u0013H\u0002J\b\u00109\u001a\u00020\u0013H\u0016J\u001c\u0010:\u001a\u00020\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u00130\u0016H\u0016J\b\u0010<\u001a\u00020\u0013H\u0016J\u0010\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020'H\u0016J\b\u0010?\u001a\u00020\u0013H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/devicetest/DeviceTestActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/DeviceTestViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivityDeviceTestBinding;", "Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/DeviceTestDriverOwner;", "()V", "mDeviceTestConfig", "Lcom/tal/app/thinkacademy/business/login/entity/DeviceConfig;", "mDeviceTestResult", "Lcom/tal/app/thinkacademy/business/login/entity/DeviceTestResult;", "mDriverHelper", "Lcom/tal/app/thinkacademy/business/login/view/devicetest/DriverHelper;", "mOnBack", "", "mPCMShortListener", "Lcom/tal/app/thinkacademy/common/utils/PCMShortListener;", "mVolumeChangeHelper", "Lcom/tal/app/thinkacademy/common/utils/VolumeChangeHelper;", "adaptContent", "", "addNetCallback", "block", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/business/login/entity/NetTestBean;", "checkDownloadNet", "checkIrcNet", "checkRtcNet", "checkServerNet", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "getContext", "Landroid/content/Context;", "getDeviceTestResult", "initData", "initView", "obtainSystemMediaVoiceSize", "Lkotlin/Function3;", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onStart", "onStop", "playVoice", "id", "repeatCount", "requestPermission", "permission", "", "saveStateAndToSystemSettings", "startCameraPreview", "Landroid/view/SurfaceView;", "startNetTest", "startObserve", "startRecord", "", "stopCameraPreview", "stopPlayVoice", "soundId", "stopRecord", "Companion", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceTestActivity.kt */
public final class DeviceTestActivity extends BaseVmActivity<DeviceTestViewModel, ActivityDeviceTestBinding> implements DeviceTestDriverOwner {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "DeviceTest_Activity";
    private DeviceConfig mDeviceTestConfig;
    /* access modifiers changed from: private */
    public DeviceTestResult mDeviceTestResult = new DeviceTestResult(false, false, false, false, 15, (DefaultConstructorMarker) null);
    private DriverHelper mDriverHelper;
    /* access modifiers changed from: private */
    public boolean mOnBack;
    private PCMShortListener mPCMShortListener;
    private VolumeChangeHelper mVolumeChangeHelper;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DeviceTestActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/devicetest/DeviceTestActivity$Companion;", "", "()V", "TAG", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DeviceTestActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        DeviceTestActivity.super.onCreate(bundle);
        initView();
        initData();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        DeviceTestActivity.super.onStart();
        this.mOnBack = false;
    }

    public void startObserve() {
        DeviceTestActivity.super.startObserve();
        getMViewModel().getMDeviceConfig().observe((LifecycleOwner) this, new DeviceTestActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-0  reason: not valid java name */
    public static final void m142startObserve$lambda0(DeviceTestActivity deviceTestActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(deviceTestActivity, "this$0");
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            deviceTestActivity.getBinding().loadStatusView.restoreView();
            deviceTestActivity.mDeviceTestConfig = (DeviceConfig) stateData.getData();
            deviceTestActivity.startNetTest();
            return;
        }
        deviceTestActivity.showToast(deviceTestActivity.getString(R.string.fail_hint));
        LoadStatusView loadStatusView = deviceTestActivity.getBinding().loadStatusView;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
        LoadStatusView.showErrorView$default(loadStatusView, 0, (String) null, (String) null, (String) null, new DeviceTestActivity$startObserve$1$1(deviceTestActivity), 15, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        DeviceTestActivity.super.onResume();
        int testingStep = DeviceTesting.INSTANCE.getTestingStep();
        DriverHelper driverHelper = this.mDriverHelper;
        if (driverHelper != null && driverHelper.currentStep() == testingStep) {
            if (testingStep != 1) {
                if (testingStep == 2 && isGranted("android.permission.CAMERA")) {
                    DeviceTesting.INSTANCE.saveTestingStep(0);
                    DriverHelper driverHelper2 = this.mDriverHelper;
                    if (driverHelper2 != null) {
                        driverHelper2.reloadCurrent();
                    }
                }
            } else if (isGranted("android.permission.RECORD_AUDIO")) {
                DeviceTesting.INSTANCE.saveTestingStep(0);
                DriverHelper driverHelper3 = this.mDriverHelper;
                if (driverHelper3 != null) {
                    driverHelper3.reloadCurrent();
                }
            }
        }
    }

    private final void startNetTest() {
        if (this.mDeviceTestConfig != null) {
            int testingStep = DeviceTesting.INSTANCE.getTestingStep();
            DeviceTesting.INSTANCE.saveTestingStep(0);
            DriverHelper driverHelper = this.mDriverHelper;
            if (driverHelper != null) {
                driverHelper.load(testingStep, this.mDeviceTestResult);
            }
        }
    }

    private final void initData() {
        LoadStatusView loadStatusView = getBinding().loadStatusView;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
        LoadStatusView.showFullLoadingView$default(loadStatusView, 0, 1, (Object) null);
        getMViewModel().getDeviceConfig();
        this.mDeviceTestResult.merge(DeviceTesting.INSTANCE.getTestingResult());
    }

    private final void initView() {
        findViewById(R.id.titleBar).setOnTitleBarListener(new DeviceTestActivity$initView$1(this));
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.container_test);
        DeviceTestStepTitle deviceTestStepTitle = (DeviceTestStepTitle) findViewById(R.id.layout_device_step);
        adaptContent();
        Intrinsics.checkNotNullExpressionValue(frameLayout, "testContainer");
        DriverHelper driverHelper = new DriverHelper(frameLayout);
        this.mDriverHelper = driverHelper;
        DeviceTestDriverOwner deviceTestDriverOwner = this;
        driverHelper.addDriver(new NetTestDriver(deviceTestDriverOwner));
        driverHelper.addDriver(new MicTestDriver(deviceTestDriverOwner));
        driverHelper.addDriver(new CameraTestDriver(deviceTestDriverOwner));
        driverHelper.addDriver(new VoiceTestDriver(deviceTestDriverOwner));
        driverHelper.addDriver(new TestResultDriver(deviceTestDriverOwner));
        driverHelper.driverResultCall(new DeviceTestActivity$initView$2$1(this, deviceTestStepTitle));
        driverHelper.driverFinishCall(new DeviceTestActivity$initView$2$2(deviceTestStepTitle));
        driverHelper.driverLoadInterceptor(new DeviceTestActivity$initView$2$3(this));
        driverHelper.allFinishCall(new DeviceTestActivity$initView$2$4(this));
    }

    private final void adaptContent() {
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        ViewParent parent = findViewById.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.View");
        Rect rect = new Rect();
        ((View) parent).getWindowVisibleDisplayFrame(rect);
        int i = rect.right - rect.left;
        float f = ((float) i) * 1.0f;
        float dimensionPixelSize = (float) (((rect.bottom - rect.top) - getResources().getDimensionPixelSize(R.dimen.size_48dp)) - BarUtils.getStatusBarHeight());
        float dimensionPixelSize2 = f / dimensionPixelSize > 0.609375f ? (1.0f * dimensionPixelSize) / ((float) (getResources().getDimensionPixelSize(R.dimen.size_540dp) + getResources().getDimensionPixelSize(R.dimen.size_100dp))) : f / ((float) getResources().getDimensionPixelSize(R.dimen.size_390dp));
        LinearLayout linearLayout = getBinding().adaptContent;
        linearLayout.setScaleX(dimensionPixelSize2);
        linearLayout.setScaleY(dimensionPixelSize2);
        linearLayout.setPivotY(0.0f);
        linearLayout.setPivotX(((float) getResources().getDimensionPixelSize(R.dimen.size_390dp)) / 2.0f);
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.height = (int) (dimensionPixelSize / dimensionPixelSize2);
        linearLayout.setLayoutParams(layoutParams);
    }

    public Context getContext() {
        return (Context) this;
    }

    public void checkRtcNet() {
        DeviceConfig deviceConfig = this.mDeviceTestConfig;
        if (deviceConfig != null) {
            getMViewModel().enableLastMileProbeTest(deviceConfig.getRtcToken(), deviceConfig.getStudentId());
        }
    }

    public void checkIrcNet() {
        DeviceConfig deviceConfig = this.mDeviceTestConfig;
        if (deviceConfig != null) {
            getMViewModel().startItcCheck((Context) this, deviceConfig);
        }
    }

    public void checkServerNet() {
        DeviceConfig deviceConfig = this.mDeviceTestConfig;
        if (deviceConfig != null) {
            getMViewModel().checkServerHealth(deviceConfig.getHealthCheckUrl());
        }
    }

    public void checkDownloadNet() {
        DeviceConfig deviceConfig = this.mDeviceTestConfig;
        if (deviceConfig != null) {
            getMViewModel().checkDownload(deviceConfig.getCoursewareZipUrl());
        }
    }

    public void addNetCallback(Function1<? super NetTestBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        getMViewModel().getMNetTestState().observerSticky((LifecycleOwner) this, false, new DeviceTestActivity$$ExternalSyntheticLambda1(function1));
    }

    /* access modifiers changed from: private */
    /* renamed from: addNetCallback$lambda-9  reason: not valid java name */
    public static final void m141addNetCallback$lambda9(Function1 function1, NetTestBean netTestBean) {
        Intrinsics.checkNotNullParameter(function1, "$block");
        Intrinsics.checkNotNullExpressionValue(netTestBean, "it");
        function1.invoke(netTestBean);
    }

    public void requestPermission(String str, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "permission");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (isFinishing() || isDestroyed() || this.mOnBack) {
            XesLog.it(TAG, new Object[]{Intrinsics.stringPlus("requestPermission activity 在未展示，拦截权限请求：", str)});
            return;
        }
        request(new String[]{str}, new DeviceTestActivity$requestPermission$1(function1));
    }

    public void obtainSystemMediaVoiceSize(Function3<? super Integer, ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "block");
        DeviceTestActivity deviceTestActivity = this;
        VolumeChangeHelper volumeChangeHelper = deviceTestActivity.mVolumeChangeHelper;
        if (volumeChangeHelper == null) {
            volumeChangeHelper = new VolumeChangeHelper((Context) deviceTestActivity);
            deviceTestActivity.mVolumeChangeHelper = volumeChangeHelper;
        }
        function3.invoke(Integer.valueOf(volumeChangeHelper.getCurrentVolume()), Integer.valueOf(volumeChangeHelper.getMaxVolume()), Integer.valueOf(volumeChangeHelper.getMinVolume()));
        volumeChangeHelper.registerVolumeChangeListener(new DeviceTestActivity$obtainSystemMediaVoiceSize$2$1(function3, volumeChangeHelper));
    }

    public DeviceTestResult getDeviceTestResult() {
        return this.mDeviceTestResult;
    }

    public void startRecord(Function1<? super Double, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        DeviceTestActivity deviceTestActivity = this;
        PCMShortListener pCMShortListener = deviceTestActivity.mPCMShortListener;
        if (pCMShortListener == null) {
            pCMShortListener = (PCMShortListener) new DeviceTestActivity$startRecord$1$1$listener$1(deviceTestActivity, function1);
            deviceTestActivity.mPCMShortListener = pCMShortListener;
        }
        AudioRecordHelper.Companion.get().addPCMShortListener(pCMShortListener);
    }

    public void stopRecord() {
        PCMShortListener pCMShortListener = this.mPCMShortListener;
        if (pCMShortListener != null) {
            AudioRecordHelper.Companion.get().removePCMShortListener(pCMShortListener);
        }
    }

    public void startCameraPreview(Function1<? super SurfaceView, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        DeviceConfig deviceConfig = this.mDeviceTestConfig;
        if (deviceConfig != null) {
            function1.invoke(getMViewModel().startRtcPreview(deviceConfig.getRtcToken(), deviceConfig.getStudentId()));
        }
    }

    public void stopCameraPreview() {
        getMViewModel().stopRtcPreview();
    }

    public void saveStateAndToSystemSettings() {
        DriverHelper driverHelper = this.mDriverHelper;
        if (driverHelper != null) {
            DeviceTesting.INSTANCE.saveTestingStep(driverHelper.currentStep());
            DeviceTesting.INSTANCE.saveTestingResult(this.mDeviceTestResult.toJson());
        }
        PermissionUtils.launchAppDetailsSettings();
    }

    public int playVoice(int i, int i2) {
        return SoundPoolUtils.play((Context) this, i, i2);
    }

    public void stopPlayVoice(int i) {
        SoundPoolUtils.stop(i);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        DeviceTestActivity.super.onStop();
        this.mOnBack = true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        DeviceTestActivity.super.onDestroy();
        stopRecord();
        DriverHelper driverHelper = this.mDriverHelper;
        if (driverHelper != null) {
            driverHelper.release();
        }
        VolumeChangeHelper volumeChangeHelper = this.mVolumeChangeHelper;
        if (volumeChangeHelper != null) {
            volumeChangeHelper.unregisterReceiver();
        }
        this.mVolumeChangeHelper = null;
    }

    /* access modifiers changed from: protected */
    public ActivityDeviceTestBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityDeviceTestBinding inflate = ActivityDeviceTestBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }
}
