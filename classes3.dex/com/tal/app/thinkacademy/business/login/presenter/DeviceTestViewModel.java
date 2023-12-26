package com.tal.app.thinkacademy.business.login.presenter;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.business.login.config.DeviceTestRepository;
import com.tal.app.thinkacademy.business.login.entity.DeviceConfig;
import com.tal.app.thinkacademy.business.login.entity.DeviceIrcServer;
import com.tal.app.thinkacademy.business.login.entity.NetTestBean;
import com.tal.app.thinkacademy.business.login.entity.NetTestState;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.download.util.HttpHelper;
import com.tal.app.thinkacademy.lib.irc.DeviceIrcConfServer;
import com.tal.app.thinkacademy.lib.irc.IrcEngine;
import com.tal.app.thinkacademy.lib.irc.IrcInitInfo;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.lib.player.widget.RtcTest;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.lib.utils.StickyLiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import okhttp3.Call;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 =2\u00020\u0001:\u0001=B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,J\u0010\u0010-\u001a\u00020*2\b\u0010.\u001a\u0004\u0018\u00010,J\u0018\u0010/\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u00010,2\u0006\u00101\u001a\u00020\u000bJ\u0006\u00102\u001a\u00020*J\b\u00103\u001a\u00020*H\u0016J\u0018\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0005H\u0002J\u0018\u00108\u001a\u00020*2\u0006\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u000bH\u0002J\u0016\u00109\u001a\u00020*2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0005J\u001a\u0010:\u001a\u0004\u0018\u00010;2\b\u00100\u001a\u0004\u0018\u00010,2\u0006\u00101\u001a\u00020\u000bJ\u0006\u0010<\u001a\u00020*R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/presenter/DeviceTestViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "mDeviceConfig", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/business/login/entity/DeviceConfig;", "getMDeviceConfig", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "mDownloadCall", "Lokhttp3/Call;", "mDownloadCount", "", "mDownloadTesting", "", "mDownloadTimeOut", "mDownloadTimer", "Ljava/lang/Runnable;", "mEnableRtcTest", "mHandler", "Landroid/os/Handler;", "mIrcEngine", "Lcom/tal/app/thinkacademy/lib/irc/IrcEngine;", "mIrcRecvCount", "", "mIrcSendRunnable", "mIrcTesting", "mIrcTimer", "mIsIrcInit", "mNetTestState", "Lcom/tal/app/thinkacademy/lib/utils/StickyLiveData;", "Lcom/tal/app/thinkacademy/business/login/entity/NetTestBean;", "getMNetTestState", "()Lcom/tal/app/thinkacademy/lib/utils/StickyLiveData;", "mRepository", "Lcom/tal/app/thinkacademy/business/login/config/DeviceTestRepository;", "mRtcMaxQuality", "mRtcNetCheckCount", "mRtcTest", "Lcom/tal/app/thinkacademy/lib/player/widget/RtcTest;", "mRtcTimeOut", "mRtcTimer", "checkDownload", "", "downloadUrl", "", "checkServerHealth", "checkUrl", "enableLastMileProbeTest", "token", "uid", "getDeviceConfig", "onDestroy", "setupIrc", "context", "Landroid/content/Context;", "deviceConfig", "setupRtc", "startItcCheck", "startRtcPreview", "Landroid/view/SurfaceView;", "stopRtcPreview", "Companion", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceTestViewModel.kt */
public final class DeviceTestViewModel extends BaseViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "DeviceTest_VM";
    private final StateLiveData<DeviceConfig> mDeviceConfig = new StateLiveData<>();
    private Call mDownloadCall;
    /* access modifiers changed from: private */
    public long mDownloadCount;
    /* access modifiers changed from: private */
    public boolean mDownloadTesting;
    private final long mDownloadTimeOut = 10000;
    /* access modifiers changed from: private */
    public Runnable mDownloadTimer = new DeviceTestViewModel$$ExternalSyntheticLambda3(this);
    /* access modifiers changed from: private */
    public boolean mEnableRtcTest;
    /* access modifiers changed from: private */
    public final Handler mHandler;
    /* access modifiers changed from: private */
    public IrcEngine mIrcEngine;
    /* access modifiers changed from: private */
    public int mIrcRecvCount;
    /* access modifiers changed from: private */
    public final Runnable mIrcSendRunnable = new DeviceTestViewModel$$ExternalSyntheticLambda0(this);
    /* access modifiers changed from: private */
    public boolean mIrcTesting;
    /* access modifiers changed from: private */
    public final Runnable mIrcTimer = new DeviceTestViewModel$$ExternalSyntheticLambda2(this);
    /* access modifiers changed from: private */
    public boolean mIsIrcInit;
    private final StickyLiveData<NetTestBean> mNetTestState = new StickyLiveData<>();
    /* access modifiers changed from: private */
    public final DeviceTestRepository mRepository = new DeviceTestRepository();
    /* access modifiers changed from: private */
    public int mRtcMaxQuality;
    /* access modifiers changed from: private */
    public int mRtcNetCheckCount;
    /* access modifiers changed from: private */
    public RtcTest mRtcTest;
    private final long mRtcTimeOut = 15000;
    /* access modifiers changed from: private */
    public final Runnable mRtcTimer = new DeviceTestViewModel$$ExternalSyntheticLambda1(this);

    public DeviceTestViewModel() {
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        this.mHandler = new Handler(myLooper);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/presenter/DeviceTestViewModel$Companion;", "", "()V", "TAG", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DeviceTestViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final StickyLiveData<NetTestBean> getMNetTestState() {
        return this.mNetTestState;
    }

    public final StateLiveData<DeviceConfig> getMDeviceConfig() {
        return this.mDeviceConfig;
    }

    /* access modifiers changed from: private */
    /* renamed from: mDownloadTimer$lambda-0  reason: not valid java name */
    public static final void m48mDownloadTimer$lambda0(DeviceTestViewModel deviceTestViewModel) {
        Intrinsics.checkNotNullParameter(deviceTestViewModel, "this$0");
        XesLog.it(TAG, new Object[]{Intrinsics.stringPlus("课件下载网络测试，下载超时 downloadCount=", Long.valueOf(deviceTestViewModel.mDownloadCount))});
        if (!deviceTestViewModel.mDownloadTesting) {
            XesLog.it(TAG, new Object[]{"课件下载网络测试，下载超时-----拦截"});
            return;
        }
        deviceTestViewModel.mDownloadTesting = false;
        Call call = deviceTestViewModel.mDownloadCall;
        if (call != null) {
            call.cancel();
        }
        deviceTestViewModel.mNetTestState.postStickyData(NetTestState.INSTANCE.createDownloadBean((int) ((((float) deviceTestViewModel.mDownloadCount) / 1024.0f) / (((float) deviceTestViewModel.mDownloadTimeOut) / 1000.0f))));
    }

    /* access modifiers changed from: private */
    /* renamed from: mIrcTimer$lambda-1  reason: not valid java name */
    public static final void m50mIrcTimer$lambda1(DeviceTestViewModel deviceTestViewModel) {
        Intrinsics.checkNotNullParameter(deviceTestViewModel, "this$0");
        XesLog.it(TAG, new Object[]{Intrinsics.stringPlus("startItcCheck 10s 计时结束 ", Integer.valueOf(deviceTestViewModel.mIrcRecvCount))});
        deviceTestViewModel.mHandler.removeCallbacks(deviceTestViewModel.mIrcSendRunnable);
        deviceTestViewModel.mIrcTesting = false;
        deviceTestViewModel.mIsIrcInit = false;
        IrcEngine ircEngine = deviceTestViewModel.mIrcEngine;
        if (ircEngine != null) {
            ircEngine.release();
        }
        deviceTestViewModel.mNetTestState.postStickyData(NetTestState.INSTANCE.createIrcBean(deviceTestViewModel.mIrcRecvCount));
    }

    /* access modifiers changed from: private */
    /* renamed from: mRtcTimer$lambda-2  reason: not valid java name */
    public static final void m51mRtcTimer$lambda2(DeviceTestViewModel deviceTestViewModel) {
        Intrinsics.checkNotNullParameter(deviceTestViewModel, "this$0");
        if (deviceTestViewModel.mEnableRtcTest) {
            XesLog.it(TAG, new Object[]{"rtc网络测试 15s 超时结束"});
            deviceTestViewModel.mEnableRtcTest = false;
            RtcTest rtcTest = deviceTestViewModel.mRtcTest;
            if (rtcTest != null) {
                rtcTest.disableLastMileProbeTest();
            }
            deviceTestViewModel.mNetTestState.postStickyData(NetTestState.INSTANCE.createRtcBean(-1));
            deviceTestViewModel.mRtcMaxQuality = 0;
            deviceTestViewModel.mRtcNetCheckCount = 0;
            return;
        }
        XesLog.it(TAG, new Object[]{"rtc网络测试 15s 超时结束，测试状态关闭"});
    }

    /* access modifiers changed from: private */
    /* renamed from: mIrcSendRunnable$lambda-3  reason: not valid java name */
    public static final void m49mIrcSendRunnable$lambda3(DeviceTestViewModel deviceTestViewModel) {
        Intrinsics.checkNotNullParameter(deviceTestViewModel, "this$0");
        int i = 20;
        while (i > 0) {
            i--;
            IrcEngine ircEngine = deviceTestViewModel.mIrcEngine;
            if (ircEngine != null) {
                IrcEngine.sendRoomKV$default(ircEngine, "ircTestKey", Intrinsics.stringPlus("device_test_", Integer.valueOf(i)), (long[]) null, 4, (Object) null);
            }
        }
    }

    private final void setupRtc(String str, long j) {
        if (this.mRtcTest == null) {
            DeviceTestViewModel deviceTestViewModel = this;
            Application app = Utils.getApp();
            Intrinsics.checkNotNullExpressionValue(app, "getApp()");
            this.mRtcTest = new RtcTest(app, j);
        }
        RtcTest rtcTest = this.mRtcTest;
        if (rtcTest != null) {
            rtcTest.setupRtc(str, new DeviceTestViewModel$setupRtc$2(this));
        }
    }

    private final int setupIrc(Context context, DeviceConfig deviceConfig) {
        int i;
        if (this.mIsIrcInit) {
            return 0;
        }
        if (this.mIrcEngine == null) {
            DeviceTestViewModel deviceTestViewModel = this;
            this.mIrcEngine = new IrcEngine();
        }
        DeviceIrcConfServer deviceIrcConfServer = null;
        IrcInitInfo ircInitInfo = new IrcInitInfo((List) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (DeviceIrcConfServer) null, (DeviceIrcConfServer) null, 2047, (DefaultConstructorMarker) null);
        String[] ircRooms = deviceConfig.getIrcRooms();
        ircInitInfo.setRoomIds(ircRooms == null ? null : ArraysKt.toMutableList((T[]) ircRooms));
        ircInitInfo.setUid(String.valueOf(deviceConfig.getStudentId()));
        ircInitInfo.setCallAllUser(false);
        ircInitInfo.setNickname(deviceConfig.getIrcNickName());
        ircInitInfo.setLiveId(deviceConfig.getTestPlanId());
        ircInitInfo.setBusinessId("3");
        ircInitInfo.setClassId("3");
        DeviceIrcServer ircServer = deviceConfig.getIrcServer();
        ircInitInfo.setLocationV3(ircServer == null ? null : ircServer.getLocationV3());
        DeviceIrcServer ircServer2 = deviceConfig.getIrcServer();
        ircInitInfo.setConfServiceV3(ircServer2 == null ? null : ircServer2.getConfServiceV3());
        DeviceIrcServer ircServer3 = deviceConfig.getIrcServer();
        if (ircServer3 != null) {
            deviceIrcConfServer = ircServer3.getLogService();
        }
        ircInitInfo.setLogService(deviceIrcConfServer);
        IrcEngine ircEngine = this.mIrcEngine;
        if (ircEngine == null) {
            i = 1;
        } else {
            String ircAppId = deviceConfig.getIrcAppId();
            String str = "";
            if (ircAppId == null) {
                ircAppId = str;
            }
            String ircAppKey = deviceConfig.getIrcAppKey();
            if (ircAppKey != null) {
                str = ircAppKey;
            }
            i = ircEngine.create(context, ircAppId, str, ircInitInfo);
        }
        IrcEngine ircEngine2 = this.mIrcEngine;
        if (ircEngine2 != null) {
            ircEngine2.setIrcDispatch(new DeviceTestViewModel$setupIrc$2(this));
        }
        IrcEngine ircEngine3 = this.mIrcEngine;
        if (ircEngine3 != null) {
            ircEngine3.setIrcKVSendResult(new DeviceTestViewModel$setupIrc$3(this));
        }
        if (i == 0 || i == 17) {
            this.mIsIrcInit = true;
        }
        return i;
    }

    public final void enableLastMileProbeTest(String str, long j) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            XesLog.it(TAG, new Object[]{"enableLastMileProbeTest token为空"});
            this.mNetTestState.postStickyData(NetTestState.INSTANCE.createRtcBean(-1));
            return;
        }
        XesLog.it(TAG, new Object[]{"enableLastMileProbeTest 开始rtc网络测试"});
        setupRtc(str, j);
        this.mEnableRtcTest = true;
        RtcTest rtcTest = this.mRtcTest;
        if (rtcTest != null) {
            rtcTest.enableLastMileProbeTest();
        }
        this.mHandler.postDelayed(this.mRtcTimer, this.mRtcTimeOut);
    }

    public final SurfaceView startRtcPreview(String str, long j) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        setupRtc(str, j);
        RtcTest rtcTest = this.mRtcTest;
        if (rtcTest == null) {
            return null;
        }
        return rtcTest.startPreview();
    }

    public final void stopRtcPreview() {
        RtcTest rtcTest = this.mRtcTest;
        if (rtcTest != null) {
            rtcTest.stopPreview();
        }
    }

    public final void startItcCheck(Context context, DeviceConfig deviceConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deviceConfig, "deviceConfig");
        XesLog.it(TAG, new Object[]{"startItcCheck 开始irc测试"});
        this.mIrcTesting = true;
        this.mIrcRecvCount = 0;
        if (this.mIsIrcInit) {
            Handler handler = this.mHandler;
            Runnable runnable = this.mIrcSendRunnable;
            if (!(handler instanceof Handler)) {
                handler.post(runnable);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, runnable);
            }
        } else {
            setupIrc(context, deviceConfig);
            if (!this.mIsIrcInit) {
                XesLog.it(TAG, new Object[]{"startItcCheck irc 初始化失败"});
                this.mIrcTesting = false;
                this.mIsIrcInit = false;
                IrcEngine ircEngine = this.mIrcEngine;
                if (ircEngine != null) {
                    ircEngine.release();
                }
                this.mNetTestState.postStickyData(NetTestState.INSTANCE.createIrcBean(-1));
                return;
            }
        }
        XesLog.it(TAG, new Object[]{"startItcCheck 计时开始"});
        this.mHandler.postDelayed(this.mIrcTimer, this.mDownloadTimeOut);
    }

    public final void checkServerHealth(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            this.mNetTestState.postStickyData(NetTestState.INSTANCE.createServerBean(-1));
        } else {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new DeviceTestViewModel$checkServerHealth$1(this)), (CoroutineStart) null, new DeviceTestViewModel$checkServerHealth$2(this, str, (Continuation<? super DeviceTestViewModel$checkServerHealth$2>) null), 2, (Object) null);
        }
    }

    public final void checkDownload(String str) {
        this.mDownloadTesting = true;
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            XesLog.it(TAG, new Object[]{"checkDownload 下载链接为空"});
            if (!this.mDownloadTesting) {
                XesLog.it(TAG, new Object[]{"课件下载网络测试，链接为空-----拦截"});
                return;
            }
            this.mDownloadTesting = false;
            this.mNetTestState.postStickyData(NetTestState.INSTANCE.createDownloadBean(-1));
            return;
        }
        this.mHandler.postDelayed(this.mDownloadTimer, this.mDownloadTimeOut);
        this.mDownloadCall = HttpHelper.getInstance().downloadFileByUrl(str, new DeviceTestViewModel$checkDownload$1(this, System.currentTimeMillis()));
    }

    public final void getDeviceConfig() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new DeviceTestViewModel$getDeviceConfig$1(this)), (CoroutineStart) null, new DeviceTestViewModel$getDeviceConfig$2(this, (Continuation<? super DeviceTestViewModel$getDeviceConfig$2>) null), 2, (Object) null);
    }

    public void onDestroy() {
        DeviceTestViewModel.super.onDestroy();
        RtcTest rtcTest = this.mRtcTest;
        if (rtcTest != null) {
            rtcTest.disableLastMileProbeTest();
        }
        RtcTest rtcTest2 = this.mRtcTest;
        if (rtcTest2 != null) {
            rtcTest2.stopPreview();
        }
        RtcTest rtcTest3 = this.mRtcTest;
        if (rtcTest3 != null) {
            rtcTest3.destroyRtc();
        }
        this.mIsIrcInit = false;
        IrcEngine ircEngine = this.mIrcEngine;
        if (ircEngine != null) {
            ircEngine.release();
        }
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }
}
