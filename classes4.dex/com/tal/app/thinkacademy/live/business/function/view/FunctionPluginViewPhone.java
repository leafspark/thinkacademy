package com.tal.app.thinkacademy.live.business.function.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.EasyPopup;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesDisplayUtil;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.bean.CoinData;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessFunctionPluginLayoutPhoneBinding;
import com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver;
import com.tal.app.thinkacademy.live.business.function.TeacherControlView;
import com.tal.app.thinkacademy.live.business.function.TeacherNotAllowView;
import com.tal.app.thinkacademy.live.business.function.view.AbsFunctionPluginView;
import com.tal.app.thinkacademy.live.business.livemessage.LiveMsgPrivateRemindView;
import com.tal.app.thinkacademy.live.business.raisehand.RaiseHandUtil;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0012\u0010\u001a\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\tH\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0013H\u0016¨\u0006%"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/view/FunctionPluginViewPhone;", "Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessFunctionPluginLayoutPhoneBinding;", "context", "Landroid/content/Context;", "driver", "Lcom/tal/app/thinkacademy/live/business/function/FunctionPluginDriver;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/business/function/FunctionPluginDriver;)V", "cameraOn", "", "enable", "", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "getRaiseHandLeft", "", "handCountDown", "initFunctionView", "initListener", "isEnableHand", "muteMic", "mute", "setCameraStatus", "", "setUserInfo", "data", "Lcom/tal/app/thinkacademy/live/abilitypack/coincenter/bean/CoinData;", "showNotAllowMicPopUpWindow", "isActionOpen", "showOpenCameraPopUpWindow", "showOpenMicPopUpWindow", "updateMic", "mic", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FunctionPluginViewPhone.kt */
public final class FunctionPluginViewPhone extends AbsFunctionPluginView<LiveBusinessFunctionPluginLayoutPhoneBinding> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionPluginViewPhone(Context context, FunctionPluginDriver functionPluginDriver) {
        super(context, functionPluginDriver);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(functionPluginDriver, "driver");
    }

    /* access modifiers changed from: protected */
    public LiveBusinessFunctionPluginLayoutPhoneBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveBusinessFunctionPluginLayoutPhoneBinding inflate = LiveBusinessFunctionPluginLayoutPhoneBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }

    public void initFunctionView() {
        super.initFunctionView();
        this.mBinding.liveBusinessFunctionCpbHand.setProgressColor(Color.parseColor("#1EFC92"));
        this.mBinding.liveBusinessFunctionCpbHand.setBackColor(Color.parseColor("#1affffff"));
        this.mBinding.liveBusinessFunctionCpbHand.setBgColor(0);
        this.mBinding.liveBusinessFunctionCpbHand.setProgressWidth(SizeUtils.dp2px(3.0f));
        this.mBinding.liveBusinessFunctionCpbHand.setBackWidth(SizeUtils.dp2px(3.0f));
    }

    public void initListener() {
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        ImageView imageView = this.mBinding.liveBusinessFunctionIvMute;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.liveBusinessFunctionIvMute");
        rxUnDoubleUtil.setOnUnDoubleClickListener(imageView, 500, new FunctionPluginViewPhone$initListener$1(this));
        this.mBinding.liveBusinessFunctionIvHand.setOnClickListener(new FunctionPluginViewPhone$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-0  reason: not valid java name */
    public static final void m257initListener$lambda0(FunctionPluginViewPhone functionPluginViewPhone, View view) {
        Intrinsics.checkNotNullParameter(functionPluginViewPhone, "this$0");
        functionPluginViewPhone.setHandSelect(!functionPluginViewPhone.isHandSelect());
        functionPluginViewPhone.handCountDown();
        RaiseHandUtil.sendRaiseHandMsg(functionPluginViewPhone.getDriver().getProvider(), functionPluginViewPhone.getTutorIrcNickName(), functionPluginViewPhone.getUserName(), functionPluginViewPhone.getHandJson());
        HWEventTracking.Companion.get().ostaRaiseHand();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void handCountDown() {
        setHandCountDown(true);
        this.mBinding.liveBusinessFunctionIvHand.setVisibility(8);
        this.mBinding.liveBusinessFunctionCpbHand.setVisibility(0);
        this.mBinding.liveBusinessFunctionTvHandProgress.setVisibility(0);
        this.mBinding.liveBusinessFunctionCpbHand.setProgressCallback(new FunctionPluginViewPhone$handCountDown$1(this));
        this.mBinding.liveBusinessFunctionCpbHand.startProgress(100, LiveMsgPrivateRemindView.REMIND_SHOW_TIME);
    }

    public void isEnableHand(boolean z) {
        if (isHandCountDown()) {
            this.mBinding.liveBusinessFunctionCpbHand.reset();
        }
        if (z) {
            this.mBinding.liveBusinessFunctionIvHand.setVisibility(0);
            this.mBinding.liveBusinessFunctionCpbHand.setVisibility(8);
            this.mBinding.liveBusinessFunctionTvHandProgress.setVisibility(8);
            this.mBinding.liveBusinessFunctionIvHandDis.setVisibility(8);
            return;
        }
        this.mBinding.liveBusinessFunctionIvHand.setVisibility(8);
        this.mBinding.liveBusinessFunctionCpbHand.setVisibility(8);
        this.mBinding.liveBusinessFunctionTvHandProgress.setVisibility(8);
        this.mBinding.liveBusinessFunctionIvHandDis.setVisibility(0);
    }

    public void showNotAllowMicPopUpWindow(boolean z) {
        AbsFunctionPluginView.AudioControlHandler audioControlHandler;
        boolean z2 = false;
        if (getTeacherNotAllowPopup() == null) {
            FunctionPluginViewPhone functionPluginViewPhone = this;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            AbsFunctionPluginView absFunctionPluginView = this;
            setMTeacherNotAllMicView(new TeacherNotAllowView(context, new AbsFunctionPluginView.TeacherNotAllowMic(absFunctionPluginView, absFunctionPluginView)));
            EasyPopup easyPopup = new EasyPopup(this.mContext);
            easyPopup.setContentView((View) getMTeacherNotAllMicView()).setWidth(XesDisplayUtil.dp2px(253.0f)).setHeight(XesDisplayUtil.dp2px(94.0f)).setFocusAndOutsideEnable(false).createPopup();
            setTeacherNotAllowPopup(easyPopup);
        }
        if (z) {
            TeacherNotAllowView mTeacherNotAllMicView = getMTeacherNotAllMicView();
            if (mTeacherNotAllMicView != null) {
                mTeacherNotAllMicView.setIconRes(R.drawable.icon_microphone_turnoff);
            }
            TeacherNotAllowView mTeacherNotAllMicView2 = getMTeacherNotAllMicView();
            if (mTeacherNotAllMicView2 != null) {
                mTeacherNotAllMicView2.setMsg(R.string.teacher_does_not_allow);
            }
        } else {
            TeacherNotAllowView mTeacherNotAllMicView3 = getMTeacherNotAllMicView();
            if (mTeacherNotAllMicView3 != null) {
                mTeacherNotAllMicView3.setIconRes(R.drawable.icon_microphone_turn_on);
            }
            TeacherNotAllowView mTeacherNotAllMicView4 = getMTeacherNotAllMicView();
            if (mTeacherNotAllMicView4 != null) {
                mTeacherNotAllMicView4.setMsg(R.string.teacher_not_allow_mute_mic);
            }
        }
        EasyPopup teacherNotAllowPopup = getTeacherNotAllowPopup();
        if (teacherNotAllowPopup != null && !teacherNotAllowPopup.isShowing()) {
            z2 = true;
        }
        if (z2) {
            EasyPopup teacherNotAllowPopup2 = getTeacherNotAllowPopup();
            if (teacherNotAllowPopup2 != null) {
                teacherNotAllowPopup2.showAsDropDown(this.mBinding.getRoot(), -SizeUtils.dp2px(273.0f), -SizeUtils.dp2px(114.0f), 8388611);
            }
            if (getAudioControlHandler() == null) {
                FunctionPluginViewPhone functionPluginViewPhone2 = this;
                FunctionPluginViewPhone functionPluginViewPhone3 = (FunctionPluginViewPhone) new SoftReference(this).get();
                if (functionPluginViewPhone3 == null) {
                    audioControlHandler = null;
                } else {
                    Looper mainLooper = Looper.getMainLooper();
                    Intrinsics.checkNotNullExpressionValue(mainLooper, "getMainLooper()");
                    audioControlHandler = new AbsFunctionPluginView.AudioControlHandler(mainLooper, functionPluginViewPhone3);
                }
                setAudioControlHandler(audioControlHandler);
            }
            AbsFunctionPluginView.AudioControlHandler audioControlHandler2 = getAudioControlHandler();
            if (audioControlHandler2 != null) {
                audioControlHandler2.sendEmptyMessageDelayed(2, 5000);
            }
        }
    }

    public void showOpenMicPopUpWindow() {
        AbsFunctionPluginView.AudioControlHandler audioControlHandler;
        if (isMicOff()) {
            boolean z = false;
            if (getTeacherControlPopup() == null) {
                FunctionPluginViewPhone functionPluginViewPhone = this;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                String string = getContext().getString(R.string.teacher_control_microphone);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…acher_control_microphone)");
                AbsFunctionPluginView absFunctionPluginView = this;
                TeacherControlView teacherControlView = new TeacherControlView(context, string, R.drawable.icon_microphone, R.color.color_A2AAB8, R.color.white, new AbsFunctionPluginView.TeacherControlMic(absFunctionPluginView, absFunctionPluginView));
                EasyPopup easyPopup = new EasyPopup(this.mContext);
                easyPopup.setContentView((View) teacherControlView).setWidth(XesDisplayUtil.dp2px(253.0f)).setHeight(XesDisplayUtil.dp2px(94.0f)).setFocusAndOutsideEnable(false).createPopup();
                setTeacherControlPopup(easyPopup);
            }
            EasyPopup teacherControlPopup = getTeacherControlPopup();
            if (teacherControlPopup != null && !teacherControlPopup.isShowing()) {
                z = true;
            }
            if (z) {
                EasyPopup teacherControlPopup2 = getTeacherControlPopup();
                if (teacherControlPopup2 != null) {
                    teacherControlPopup2.showAsDropDown(this.mBinding.getRoot(), -SizeUtils.dp2px(273.0f), -SizeUtils.dp2px(114.0f), 8388611);
                }
                if (getAudioControlHandler() == null) {
                    FunctionPluginViewPhone functionPluginViewPhone2 = this;
                    FunctionPluginViewPhone functionPluginViewPhone3 = (FunctionPluginViewPhone) new SoftReference(this).get();
                    if (functionPluginViewPhone3 == null) {
                        audioControlHandler = null;
                    } else {
                        Looper mainLooper = Looper.getMainLooper();
                        Intrinsics.checkNotNullExpressionValue(mainLooper, "getMainLooper()");
                        audioControlHandler = new AbsFunctionPluginView.AudioControlHandler(mainLooper, functionPluginViewPhone3);
                    }
                    setAudioControlHandler(audioControlHandler);
                }
                AbsFunctionPluginView.AudioControlHandler audioControlHandler2 = getAudioControlHandler();
                if (audioControlHandler2 != null) {
                    audioControlHandler2.sendEmptyMessageDelayed(1, LiveMsgPrivateRemindView.REMIND_SHOW_TIME);
                }
            }
        }
    }

    public void showOpenCameraPopUpWindow() {
        AbsFunctionPluginView.AudioControlCameraHandler audioControlCameraHandler;
        if (!isCameraOn()) {
            boolean z = false;
            if (getTeacherControlCameraPopup() == null) {
                FunctionPluginViewPhone functionPluginViewPhone = this;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                String string = getContext().getString(R.string.teacher_control_camera);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.teacher_control_camera)");
                AbsFunctionPluginView absFunctionPluginView = this;
                TeacherControlView teacherControlView = new TeacherControlView(context, string, R.drawable.icon_camera, R.color.color_A2AAB8, R.color.white, new AbsFunctionPluginView.TeacherControlCamera(absFunctionPluginView, absFunctionPluginView));
                EasyPopup easyPopup = new EasyPopup(this.mContext);
                easyPopup.setContentView((View) teacherControlView).setWidth(XesDisplayUtil.dp2px(253.0f)).setHeight(XesDisplayUtil.dp2px(94.0f)).setFocusAndOutsideEnable(false).createPopup();
                setTeacherControlCameraPopup(easyPopup);
            }
            EasyPopup teacherControlCameraPopup = getTeacherControlCameraPopup();
            if (teacherControlCameraPopup != null && !teacherControlCameraPopup.isShowing()) {
                z = true;
            }
            if (z) {
                EasyPopup teacherControlCameraPopup2 = getTeacherControlCameraPopup();
                if (teacherControlCameraPopup2 != null) {
                    teacherControlCameraPopup2.showAsDropDown(this.mBinding.getRoot(), -SizeUtils.dp2px(273.0f), -SizeUtils.dp2px(114.0f), 8388611);
                }
                if (getAudioControlCameraHandler() == null) {
                    FunctionPluginViewPhone functionPluginViewPhone2 = this;
                    FunctionPluginViewPhone functionPluginViewPhone3 = (FunctionPluginViewPhone) new SoftReference(this).get();
                    if (functionPluginViewPhone3 == null) {
                        audioControlCameraHandler = null;
                    } else {
                        Looper mainLooper = Looper.getMainLooper();
                        Intrinsics.checkNotNullExpressionValue(mainLooper, "getMainLooper()");
                        audioControlCameraHandler = new AbsFunctionPluginView.AudioControlCameraHandler(mainLooper, functionPluginViewPhone3);
                    }
                    setAudioControlCameraHandler(audioControlCameraHandler);
                }
                AbsFunctionPluginView.AudioControlCameraHandler audioControlCameraHandler2 = getAudioControlCameraHandler();
                if (audioControlCameraHandler2 != null) {
                    audioControlCameraHandler2.sendEmptyMessageDelayed(1, LiveMsgPrivateRemindView.REMIND_SHOW_TIME);
                }
            }
        }
    }

    public void cameraOn(boolean z) {
        setCameraOn(z);
    }

    public void setCameraStatus(String str) {
        if (Intrinsics.areEqual("1", str)) {
            setCameraOn(true);
        } else if (Intrinsics.areEqual("2", str)) {
            setCameraOn(false);
        }
    }

    public void updateMic(int i) {
        if (!this.mBinding.liveBusinessFunctionIvMute.isSelected()) {
            this.mBinding.liveBusinessFunctionIvMute.getDrawable().setLevel((i * 10000) / 255);
        }
    }

    public void muteMic(boolean z) {
        setMicOff(z);
        this.mBinding.liveBusinessFunctionIvMute.setSelected(z);
    }

    public void setUserInfo(CoinData coinData) {
        Intrinsics.checkNotNullParameter(coinData, "data");
        super.setUserInfo(coinData);
        getDriver().postUserInfo(coinData);
    }

    public int getRaiseHandLeft() {
        return this.mBinding.liveBusinessFunctionIvHand.getLeft();
    }
}
