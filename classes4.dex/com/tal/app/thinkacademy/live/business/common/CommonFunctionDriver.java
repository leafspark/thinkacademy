package com.tal.app.thinkacademy.live.business.common;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModelKt;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001c\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/common/CommonFunctionDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "mCommonFunctionViewModel", "Lcom/tal/app/thinkacademy/live/business/common/CommonFunctionViewModel;", "getMCommonFunctionViewModel", "()Lcom/tal/app/thinkacademy/live/business/common/CommonFunctionViewModel;", "mCommonFunctionViewModel$delegate", "Lkotlin/Lazy;", "mRtcViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel;", "observerGroupEnd", "Landroidx/lifecycle/Observer;", "Lcom/tal/app/thinkacademy/live/core/plugin/PluginEventData;", "observerGroupStart", "observerVideoCall", "observerVideoFCall", "userInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;", "getRtcViewModel", "onDestroy", "", "onMessage", "ircTypeKey", "", "message", "setVideoBitrate", "isHigh", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PluginAnnotation(desc = "公共功能组件", ircType = {"classmode"}, launchType = "enter", moduleId = "-200")
/* compiled from: CommonFunctionDriver.kt */
public final class CommonFunctionDriver extends BaseLivePluginDriver {
    private final Tag TAG = Tag.COMMON_FUNCTION_DRIVER;
    private final Lazy mCommonFunctionViewModel$delegate = LazyKt.lazy(CommonFunctionDriver$mCommonFunctionViewModel$2.INSTANCE);
    private RtcViewModel mRtcViewModel;
    private Observer<PluginEventData> observerGroupEnd = new CommonFunctionDriver$$ExternalSyntheticLambda2(this);
    private Observer<PluginEventData> observerGroupStart = new CommonFunctionDriver$$ExternalSyntheticLambda3(this);
    private Observer<PluginEventData> observerVideoCall = new CommonFunctionDriver$$ExternalSyntheticLambda1(this);
    private Observer<PluginEventData> observerVideoFCall = new CommonFunctionDriver$$ExternalSyntheticLambda0(this);
    private UserInfoProxy userInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonFunctionDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "mLiveRoomProvider");
        try {
            this.userInfo = iLiveRoomProvider.getDataStorage().getUserInfo();
        } catch (Exception e) {
            XesLog.e(this.TAG, Intrinsics.stringPlus("初始化失败，错误信息=", e));
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        PluginEventBus.register(lifecycleOwner, DataBusKey.GROUP_VIDEO_CALL_STUDENT_START, this.observerGroupStart);
        PluginEventBus.register(lifecycleOwner, DataBusKey.GROUP_VIDEO_CALL_STUDENT_END, this.observerGroupEnd);
        PluginEventBus.register(lifecycleOwner, DataBusKey.VIDEO_CALL_STATUS, this.observerVideoCall);
        PluginEventBus.register(lifecycleOwner, DataBusKey.VIDEO_CALL_F_STATUS, this.observerVideoFCall);
        XesLog.s(this.TAG, "初始化成功");
    }

    private final CommonFunctionViewModel getMCommonFunctionViewModel() {
        return (CommonFunctionViewModel) this.mCommonFunctionViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: observerGroupStart$lambda-0  reason: not valid java name */
    public static final void m196observerGroupStart$lambda0(CommonFunctionDriver commonFunctionDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(commonFunctionDriver, "this$0");
        UserInfoProxy userInfoProxy = commonFunctionDriver.userInfo;
        if (Intrinsics.areEqual(userInfoProxy == null ? null : userInfoProxy.getId(), pluginEventData.getData())) {
            XesLog.i(commonFunctionDriver.TAG, "收到自己上台了,开始设置高码率");
            commonFunctionDriver.setVideoBitrate(true);
            return;
        }
        XesLog.i(commonFunctionDriver.TAG, Intrinsics.stringPlus("收到其他人上台：", pluginEventData.getData()));
    }

    /* access modifiers changed from: private */
    /* renamed from: observerGroupEnd$lambda-1  reason: not valid java name */
    public static final void m195observerGroupEnd$lambda1(CommonFunctionDriver commonFunctionDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(commonFunctionDriver, "this$0");
        UserInfoProxy userInfoProxy = commonFunctionDriver.userInfo;
        if (Intrinsics.areEqual(userInfoProxy == null ? null : userInfoProxy.getId(), pluginEventData.getData())) {
            XesLog.i(commonFunctionDriver.TAG, "收到自己下台了，开始设置普通码率");
            commonFunctionDriver.setVideoBitrate(false);
            return;
        }
        XesLog.i(commonFunctionDriver.TAG, Intrinsics.stringPlus("收到其他人下台：", pluginEventData.getData()));
    }

    /* access modifiers changed from: private */
    /* renamed from: observerVideoCall$lambda-2  reason: not valid java name */
    public static final void m197observerVideoCall$lambda2(CommonFunctionDriver commonFunctionDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(commonFunctionDriver, "this$0");
        if (Intrinsics.areEqual("videoCallStart", pluginEventData.getData())) {
            XesLog.i(commonFunctionDriver.TAG, "视频连麦，开启连麦，等待链接");
        } else if (Intrinsics.areEqual("videoCallOn", pluginEventData.getData())) {
            XesLog.i(commonFunctionDriver.TAG, "视频连麦，上麦");
            commonFunctionDriver.setVideoBitrate(true);
        } else if (Intrinsics.areEqual("videoCallOff", pluginEventData.getData())) {
            XesLog.i(commonFunctionDriver.TAG, "视频连麦，下麦");
            commonFunctionDriver.setVideoBitrate(false);
        } else {
            XesLog.i(commonFunctionDriver.TAG, "视频连麦，下麦2");
            commonFunctionDriver.setVideoBitrate(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observerVideoFCall$lambda-3  reason: not valid java name */
    public static final void m198observerVideoFCall$lambda3(CommonFunctionDriver commonFunctionDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(commonFunctionDriver, "this$0");
        if (Intrinsics.areEqual("videoCallTutorOn", pluginEventData.getData())) {
            XesLog.i(commonFunctionDriver.TAG, "辅导视频连麦，上麦");
            commonFunctionDriver.setVideoBitrate(true);
            return;
        }
        XesLog.i(commonFunctionDriver.TAG, "辅导视频连麦，下麦");
        commonFunctionDriver.setVideoBitrate(false);
    }

    public void onMessage(String str, String str2) {
        CommonFunctionViewModel mCommonFunctionViewModel;
        if (Intrinsics.areEqual(str, "classmode") && (mCommonFunctionViewModel = getMCommonFunctionViewModel()) != null) {
            mCommonFunctionViewModel.onReceiveMessage(str2);
        }
    }

    public void onDestroy() {
        PluginEventBus.unregister(DataBusKey.GROUP_VIDEO_CALL_STUDENT_START, this.observerGroupStart);
        PluginEventBus.unregister(DataBusKey.GROUP_VIDEO_CALL_STUDENT_END, this.observerGroupEnd);
        PluginEventBus.unregister(DataBusKey.VIDEO_CALL_STATUS, this.observerVideoCall);
        PluginEventBus.unregister(DataBusKey.VIDEO_CALL_F_STATUS, this.observerVideoFCall);
    }

    private final RtcViewModel getRtcViewModel() {
        if (this.mRtcViewModel == null) {
            this.mRtcViewModel = RtcViewModelKt.getRtcViewModel(AbilityPackKt.getAbilityPack());
        }
        return this.mRtcViewModel;
    }

    private final void setVideoBitrate(boolean z) {
        XesLog.i(this.TAG, Intrinsics.stringPlus("设置码率，isHigh=", Boolean.valueOf(z)));
        RtcViewModel rtcViewModel = getRtcViewModel();
        if (rtcViewModel != null) {
            rtcViewModel.setVideoBitRate(z);
        }
    }
}
