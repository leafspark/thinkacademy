package com.tal.app.thinkacademy.live.business.function.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.EasyPopup;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.bean.CoinData;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver;
import com.tal.app.thinkacademy.live.business.function.ITeacherControl;
import com.tal.app.thinkacademy.live.business.function.ITeacherNotAllow;
import com.tal.app.thinkacademy.live.business.function.TeacherNotAllowView;
import com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity;
import com.tal.app.thinkacademy.live.business.mediacontroller.EnableState;
import com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseVBLivePluginView;
import java.lang.ref.SoftReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0013\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\f\u0001\u0001\u0001\u0001\u0001\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020 H\u0016J\b\u0010X\u001a\u00020VH\u0016J\u0010\u0010Y\u001a\u00020V2\u0006\u0010Z\u001a\u00020 H\u0016J\b\u0010[\u001a\u00020\nH\u0016J\b\u0010\\\u001a\u00020VH\u0016J\b\u0010]\u001a\u00020VH\u0016J\b\u0010^\u001a\u00020VH\u0016J\b\u0010_\u001a\u00020VH\u0016J\b\u0010`\u001a\u00020VH\u0016J\u0010\u0010a\u001a\u00020V2\u0006\u0010W\u001a\u00020 H\u0016J\u0010\u0010b\u001a\u00020V2\u0006\u0010W\u001a\u00020 H\u0016J\b\u0010c\u001a\u00020VH\u0016J\u0016\u0010d\u001a\u00020V2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020\nJ\u0010\u0010h\u001a\u00020V2\u0006\u0010i\u001a\u00020 H\u0016J\u0012\u0010j\u001a\u00020V2\b\u0010U\u001a\u0004\u0018\u00010KH\u0016J\b\u0010k\u001a\u00020VH\u0016J\b\u0010l\u001a\u00020VH\u0016J\"\u0010m\u001a\u00020V2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010P\u001a\u0004\u0018\u00010KJ\u0012\u0010n\u001a\u00020V2\b\u0010o\u001a\u0004\u0018\u00010KH\u0016J\u0016\u0010p\u001a\u00020V2\u0006\u0010W\u001a\u00020 2\u0006\u00105\u001a\u000206J\u0010\u0010q\u001a\u00020V2\u0006\u0010r\u001a\u00020sH\u0016J\u0010\u0010t\u001a\u00020V2\u0006\u0010u\u001a\u00020\nH\u0016J\b\u0010v\u001a\u00020VH\u0016J\u0010\u0010w\u001a\u00020V2\u0006\u0010x\u001a\u00020 H\u0016J\u0010\u0010y\u001a\u00020V2\u0006\u0010z\u001a\u00020KH\u0016J\u001a\u0010{\u001a\u00020V2\b\u0010|\u001a\u0004\u0018\u00010}2\u0006\u0010~\u001a\u00020 H\u0016J+\u0010\u001a\u00020V2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020}0\u00012\u0006\u0010~\u001a\u00020 2\t\b\u0001\u0010\u0001\u001a\u00020\nH\u0016J\t\u0010\u0001\u001a\u00020VH\u0016J\u001c\u0010\u0001\u001a\u00020V2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020VH\u0016J\u0012\u0010\u0001\u001a\u00020V2\u0007\u0010\u0001\u001a\u00020 H\u0016J\t\u0010\u0001\u001a\u00020VH\u0016J\t\u0010\u0001\u001a\u00020VH\u0016J\u0012\u0010\u0001\u001a\u00020V2\u0007\u0010\u0001\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\u001a\u0010&\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\u001a\u0010(\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u001a\u0010*\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010!\"\u0004\b+\u0010#R\u001a\u0010,\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010!\"\u0004\b.\u0010#R\u001c\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000206X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\u001a\u0010D\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010!\"\u0004\bF\u0010#R\u001c\u0010G\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010>\"\u0004\bI\u0010@R\u001c\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010P\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010M\"\u0004\bR\u0010OR\u0016\u0010S\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010TX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "context", "Landroid/content/Context;", "driver", "Lcom/tal/app/thinkacademy/live/business/function/FunctionPluginDriver;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/business/function/FunctionPluginDriver;)V", "WHAT_MIC_UPDATE", "", "audioControlCameraHandler", "Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView$AudioControlCameraHandler;", "getAudioControlCameraHandler", "()Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView$AudioControlCameraHandler;", "setAudioControlCameraHandler", "(Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView$AudioControlCameraHandler;)V", "audioControlHandler", "Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView$AudioControlHandler;", "getAudioControlHandler", "()Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView$AudioControlHandler;", "setAudioControlHandler", "(Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView$AudioControlHandler;)V", "getDriver", "()Lcom/tal/app/thinkacademy/live/business/function/FunctionPluginDriver;", "handJson", "Lorg/json/JSONObject;", "getHandJson", "()Lorg/json/JSONObject;", "setHandJson", "(Lorg/json/JSONObject;)V", "isCameraOn", "", "()Z", "setCameraOn", "(Z)V", "isHandCountDown", "setHandCountDown", "isHandSelect", "setHandSelect", "isMicOff", "setMicOff", "isSwitchEnable", "setSwitchEnable", "mIsTeacherForbidMuteMic", "getMIsTeacherForbidMuteMic", "setMIsTeacherForbidMuteMic", "mTeacherNotAllMicView", "Lcom/tal/app/thinkacademy/live/business/function/TeacherNotAllowView;", "getMTeacherNotAllMicView", "()Lcom/tal/app/thinkacademy/live/business/function/TeacherNotAllowView;", "setMTeacherNotAllMicView", "(Lcom/tal/app/thinkacademy/live/business/function/TeacherNotAllowView;)V", "state", "Lcom/tal/app/thinkacademy/live/business/mediacontroller/EnableState;", "getState", "()Lcom/tal/app/thinkacademy/live/business/mediacontroller/EnableState;", "setState", "(Lcom/tal/app/thinkacademy/live/business/mediacontroller/EnableState;)V", "teacherControlCameraPopup", "Lcom/tal/app/thinkacademy/lib/commui/baseview/popupwindow/EasyPopup;", "getTeacherControlCameraPopup", "()Lcom/tal/app/thinkacademy/lib/commui/baseview/popupwindow/EasyPopup;", "setTeacherControlCameraPopup", "(Lcom/tal/app/thinkacademy/lib/commui/baseview/popupwindow/EasyPopup;)V", "teacherControlPopup", "getTeacherControlPopup", "setTeacherControlPopup", "teacherMicAllow", "getTeacherMicAllow", "setTeacherMicAllow", "teacherNotAllowPopup", "getTeacherNotAllowPopup", "setTeacherNotAllowPopup", "tutorIrcNickName", "", "getTutorIrcNickName", "()Ljava/lang/String;", "setTutorIrcNickName", "(Ljava/lang/String;)V", "userName", "getUserName", "setUserName", "volumeHandler", "Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView$VolumeHandler;", "cameraOn", "", "enable", "closeExamReportDialog", "emojiControls", "pub", "getRaiseHandLeft", "hideChatBoxView", "initFunctionView", "initListener", "initPermissionState", "initViews", "isEnableHand", "muteMic", "onDestroy", "reportAudioVolumeOfSpeaker", "uid", "", "volume", "resetChatBoxStatus", "isSelected", "setCameraStatus", "setExamReportShow", "setHomeworkShow", "setRaiseHandData", "setScreenShotFilePath", "path", "setSwitchCameraEnable", "setUserInfo", "data", "Lcom/tal/app/thinkacademy/live/abilitypack/coincenter/bean/CoinData;", "setUserLevel", "level", "setupNoHomework", "showChatBoxRedDotView", "isShow", "showExamReportDialog", "url", "showGradingPopup", "item", "Lcom/tal/app/thinkacademy/live/business/homework/entity/HomeworkEntity;", "canCorrect", "showHomeworkList", "list", "", "layoutId", "showMedalsDialog", "showNewMessage", "show", "(Ljava/lang/Boolean;)V", "showNoExamReport", "showNotAllowMicPopUpWindow", "isActionOpen", "showOpenCameraPopUpWindow", "showOpenMicPopUpWindow", "updateMic", "mic", "AudioControlCameraHandler", "AudioControlHandler", "TeacherControlCamera", "TeacherControlMic", "TeacherNotAllowMic", "VolumeHandler", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbsFunctionPluginView.kt */
public abstract class AbsFunctionPluginView<VB extends ViewBinding> extends BaseVBLivePluginView<VB> {
    /* access modifiers changed from: private */
    public final int WHAT_MIC_UPDATE = 100;
    private AudioControlCameraHandler<VB> audioControlCameraHandler;
    private AudioControlHandler<VB> audioControlHandler;
    private final FunctionPluginDriver driver;
    private JSONObject handJson;
    private boolean isCameraOn = true;
    private boolean isHandCountDown;
    private boolean isHandSelect;
    private boolean isMicOff;
    private boolean isSwitchEnable = true;
    private boolean mIsTeacherForbidMuteMic;
    private TeacherNotAllowView mTeacherNotAllMicView;
    private EnableState state = EnableState.ANIMATION;
    private EasyPopup teacherControlCameraPopup;
    private EasyPopup teacherControlPopup;
    private boolean teacherMicAllow = true;
    private EasyPopup teacherNotAllowPopup;
    private String tutorIrcNickName;
    private String userName;
    private VolumeHandler<VB> volumeHandler;

    public void closeExamReportDialog() {
    }

    public void emojiControls(boolean z) {
    }

    public int getRaiseHandLeft() {
        return 0;
    }

    public void hideChatBoxView() {
    }

    public void initFunctionView() {
    }

    public void initListener() {
    }

    public void isEnableHand(boolean z) {
    }

    public void muteMic(boolean z) {
    }

    public void onDestroy() {
    }

    public void resetChatBoxStatus(boolean z) {
    }

    public void setCameraStatus(String str) {
    }

    public void setExamReportShow() {
    }

    public void setHomeworkShow() {
    }

    public void setScreenShotFilePath(String str) {
    }

    public void setUserInfo(CoinData coinData) {
        Intrinsics.checkNotNullParameter(coinData, "data");
    }

    public void setUserLevel(int i) {
    }

    public void setupNoHomework() {
    }

    public void showChatBoxRedDotView(boolean z) {
    }

    public void showExamReportDialog(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
    }

    public void showGradingPopup(HomeworkEntity homeworkEntity, boolean z) {
    }

    public void showHomeworkList(List<? extends HomeworkEntity> list, boolean z, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
    }

    public void showMedalsDialog() {
    }

    public void showNewMessage(Boolean bool) {
    }

    public void showNoExamReport() {
    }

    public void showNotAllowMicPopUpWindow(boolean z) {
    }

    public void showOpenCameraPopUpWindow() {
    }

    public void showOpenMicPopUpWindow() {
    }

    public void updateMic(int i) {
    }

    public final FunctionPluginDriver getDriver() {
        return this.driver;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbsFunctionPluginView(Context context, FunctionPluginDriver functionPluginDriver) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(functionPluginDriver, "driver");
        this.driver = functionPluginDriver;
    }

    /* access modifiers changed from: protected */
    public final JSONObject getHandJson() {
        return this.handJson;
    }

    /* access modifiers changed from: protected */
    public final void setHandJson(JSONObject jSONObject) {
        this.handJson = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final String getTutorIrcNickName() {
        return this.tutorIrcNickName;
    }

    /* access modifiers changed from: protected */
    public final void setTutorIrcNickName(String str) {
        this.tutorIrcNickName = str;
    }

    /* access modifiers changed from: protected */
    public final String getUserName() {
        return this.userName;
    }

    /* access modifiers changed from: protected */
    public final void setUserName(String str) {
        this.userName = str;
    }

    public final boolean isMicOff() {
        return this.isMicOff;
    }

    public final void setMicOff(boolean z) {
        this.isMicOff = z;
    }

    /* access modifiers changed from: protected */
    public final boolean isCameraOn() {
        return this.isCameraOn;
    }

    /* access modifiers changed from: protected */
    public final void setCameraOn(boolean z) {
        this.isCameraOn = z;
    }

    /* access modifiers changed from: protected */
    public final boolean isHandSelect() {
        return this.isHandSelect;
    }

    /* access modifiers changed from: protected */
    public final void setHandSelect(boolean z) {
        this.isHandSelect = z;
    }

    /* access modifiers changed from: protected */
    public final boolean isHandCountDown() {
        return this.isHandCountDown;
    }

    /* access modifiers changed from: protected */
    public final void setHandCountDown(boolean z) {
        this.isHandCountDown = z;
    }

    public final boolean getTeacherMicAllow() {
        return this.teacherMicAllow;
    }

    public final void setTeacherMicAllow(boolean z) {
        this.teacherMicAllow = z;
    }

    public final boolean getMIsTeacherForbidMuteMic() {
        return this.mIsTeacherForbidMuteMic;
    }

    public final void setMIsTeacherForbidMuteMic(boolean z) {
        this.mIsTeacherForbidMuteMic = z;
    }

    /* access modifiers changed from: protected */
    public final EasyPopup getTeacherControlPopup() {
        return this.teacherControlPopup;
    }

    /* access modifiers changed from: protected */
    public final void setTeacherControlPopup(EasyPopup easyPopup) {
        this.teacherControlPopup = easyPopup;
    }

    /* access modifiers changed from: protected */
    public final AudioControlHandler<VB> getAudioControlHandler() {
        return this.audioControlHandler;
    }

    /* access modifiers changed from: protected */
    public final void setAudioControlHandler(AudioControlHandler<VB> audioControlHandler2) {
        this.audioControlHandler = audioControlHandler2;
    }

    /* access modifiers changed from: protected */
    public final EasyPopup getTeacherNotAllowPopup() {
        return this.teacherNotAllowPopup;
    }

    /* access modifiers changed from: protected */
    public final void setTeacherNotAllowPopup(EasyPopup easyPopup) {
        this.teacherNotAllowPopup = easyPopup;
    }

    /* access modifiers changed from: protected */
    public final TeacherNotAllowView getMTeacherNotAllMicView() {
        return this.mTeacherNotAllMicView;
    }

    /* access modifiers changed from: protected */
    public final void setMTeacherNotAllMicView(TeacherNotAllowView teacherNotAllowView) {
        this.mTeacherNotAllMicView = teacherNotAllowView;
    }

    /* access modifiers changed from: protected */
    public final EasyPopup getTeacherControlCameraPopup() {
        return this.teacherControlCameraPopup;
    }

    /* access modifiers changed from: protected */
    public final void setTeacherControlCameraPopup(EasyPopup easyPopup) {
        this.teacherControlCameraPopup = easyPopup;
    }

    /* access modifiers changed from: protected */
    public final AudioControlCameraHandler<VB> getAudioControlCameraHandler() {
        return this.audioControlCameraHandler;
    }

    /* access modifiers changed from: protected */
    public final void setAudioControlCameraHandler(AudioControlCameraHandler<VB> audioControlCameraHandler2) {
        this.audioControlCameraHandler = audioControlCameraHandler2;
    }

    /* access modifiers changed from: protected */
    public final boolean isSwitchEnable() {
        return this.isSwitchEnable;
    }

    /* access modifiers changed from: protected */
    public final void setSwitchEnable(boolean z) {
        this.isSwitchEnable = z;
    }

    /* access modifiers changed from: protected */
    public final EnableState getState() {
        return this.state;
    }

    /* access modifiers changed from: protected */
    public final void setState(EnableState enableState) {
        Intrinsics.checkNotNullParameter(enableState, "<set-?>");
        this.state = enableState;
    }

    public void initViews() {
        AbsFunctionPluginView.super.initViews();
        initPermissionState();
        initFunctionView();
        initListener();
    }

    public void initPermissionState() {
        this.isCameraOn = PermissionUtils.isGranted("android.permission.CAMERA");
    }

    public void cameraOn(boolean z) {
        this.isCameraOn = z;
    }

    public final void reportAudioVolumeOfSpeaker(long j, int i) {
        VolumeHandler<VB> volumeHandler2;
        if (this.volumeHandler == null) {
            AbsFunctionPluginView absFunctionPluginView = this;
            AbsFunctionPluginView absFunctionPluginView2 = (AbsFunctionPluginView) new SoftReference(this).get();
            if (absFunctionPluginView2 == null) {
                volumeHandler2 = null;
            } else {
                Looper mainLooper = Looper.getMainLooper();
                Intrinsics.checkNotNullExpressionValue(mainLooper, "getMainLooper()");
                volumeHandler2 = new VolumeHandler<>(mainLooper, absFunctionPluginView2);
            }
            this.volumeHandler = volumeHandler2;
        }
        Message obtain = Message.obtain();
        SmallClassPluginDriver.MicDataBean micDataBean = new SmallClassPluginDriver.MicDataBean();
        micDataBean.uid = j;
        micDataBean.mic = i;
        obtain.what = this.WHAT_MIC_UPDATE;
        obtain.obj = micDataBean;
        VolumeHandler<VB> volumeHandler3 = this.volumeHandler;
        if (volumeHandler3 != null) {
            volumeHandler3.sendMessage(obtain);
        }
    }

    public final void setRaiseHandData(JSONObject jSONObject, String str, String str2) {
        Intrinsics.checkNotNullParameter(jSONObject, "handJson");
        this.handJson = jSONObject;
        this.tutorIrcNickName = str;
        this.userName = str2;
    }

    public static /* synthetic */ void showNewMessage$default(AbsFunctionPluginView absFunctionPluginView, Boolean bool, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                bool = true;
            }
            absFunctionPluginView.showNewMessage(bool);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showNewMessage");
    }

    public final void setSwitchCameraEnable(boolean z, EnableState enableState) {
        Intrinsics.checkNotNullParameter(enableState, "state");
        this.isSwitchEnable = z;
        this.state = enableState;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView$TeacherControlCamera;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/tal/app/thinkacademy/live/business/function/ITeacherControl;", "pluginView", "Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;", "(Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;)V", "getPluginView", "()Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;", "setPluginView", "(Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;)V", "agree", "", "deny", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AbsFunctionPluginView.kt */
    public final class TeacherControlCamera<VB extends ViewBinding> implements ITeacherControl {
        private AbsFunctionPluginView<VB> pluginView;
        final /* synthetic */ AbsFunctionPluginView<VB> this$0;

        public TeacherControlCamera(AbsFunctionPluginView absFunctionPluginView, AbsFunctionPluginView<VB> absFunctionPluginView2) {
            Intrinsics.checkNotNullParameter(absFunctionPluginView, "this$0");
            this.this$0 = absFunctionPluginView;
            this.pluginView = absFunctionPluginView2;
        }

        public final AbsFunctionPluginView<VB> getPluginView() {
            return this.pluginView;
        }

        public final void setPluginView(AbsFunctionPluginView<VB> absFunctionPluginView) {
            this.pluginView = absFunctionPluginView;
        }

        public void deny() {
            EasyPopup teacherControlCameraPopup;
            AudioControlCameraHandler<VB> audioControlCameraHandler;
            AbsFunctionPluginView<VB> absFunctionPluginView = this.pluginView;
            if (!(absFunctionPluginView == null || (audioControlCameraHandler = absFunctionPluginView.getAudioControlCameraHandler()) == null)) {
                audioControlCameraHandler.removeCallbacksAndMessages((Object) null);
            }
            AbsFunctionPluginView<VB> absFunctionPluginView2 = this.pluginView;
            if (absFunctionPluginView2 != null && (teacherControlCameraPopup = absFunctionPluginView2.getTeacherControlCameraPopup()) != null) {
                teacherControlCameraPopup.dismiss();
            }
        }

        public void agree() {
            FunctionPluginDriver driver;
            Context context;
            EasyPopup teacherControlCameraPopup;
            AudioControlCameraHandler<VB> audioControlCameraHandler;
            AbsFunctionPluginView<VB> absFunctionPluginView = this.pluginView;
            String str = null;
            if (!(absFunctionPluginView == null || (audioControlCameraHandler = absFunctionPluginView.getAudioControlCameraHandler()) == null)) {
                audioControlCameraHandler.removeCallbacksAndMessages((Object) null);
            }
            AbsFunctionPluginView<VB> absFunctionPluginView2 = this.pluginView;
            if (!(absFunctionPluginView2 == null || (teacherControlCameraPopup = absFunctionPluginView2.getTeacherControlCameraPopup()) == null)) {
                teacherControlCameraPopup.dismiss();
            }
            AbsFunctionPluginView<VB> absFunctionPluginView3 = this.pluginView;
            if (absFunctionPluginView3 != null && !absFunctionPluginView3.isSwitchEnable()) {
                AbsFunctionPluginView<VB> absFunctionPluginView4 = this.pluginView;
                if ((absFunctionPluginView4 == null ? null : absFunctionPluginView4.getState()) == EnableState.CAMERA) {
                    AbsFunctionPluginView<VB> absFunctionPluginView5 = this.pluginView;
                    if (!(absFunctionPluginView5 == null || (context = absFunctionPluginView5.mContext) == null)) {
                        str = context.getString(R.string.photographing);
                    }
                    ToastUtils.showShort(str, new Object[0]);
                    return;
                }
            }
            if (!PermissionUtils.isGranted("android.permission.CAMERA")) {
                AbsFunctionPluginView<VB> absFunctionPluginView6 = this.pluginView;
                if (absFunctionPluginView6 != null && (driver = absFunctionPluginView6.getDriver()) != null) {
                    FunctionPluginDriver.showPermissionWindow$default(driver, false, 1, (Object) null);
                    return;
                }
                return;
            }
            this.this$0.getDriver().controlLocalVideo(true);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView$TeacherControlMic;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/tal/app/thinkacademy/live/business/function/ITeacherControl;", "pluginView", "Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;", "(Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;)V", "getPluginView", "()Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;", "setPluginView", "(Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;)V", "agree", "", "deny", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AbsFunctionPluginView.kt */
    public final class TeacherControlMic<VB extends ViewBinding> implements ITeacherControl {
        private AbsFunctionPluginView<VB> pluginView;
        final /* synthetic */ AbsFunctionPluginView<VB> this$0;

        public TeacherControlMic(AbsFunctionPluginView absFunctionPluginView, AbsFunctionPluginView<VB> absFunctionPluginView2) {
            Intrinsics.checkNotNullParameter(absFunctionPluginView, "this$0");
            this.this$0 = absFunctionPluginView;
            this.pluginView = absFunctionPluginView2;
        }

        public final AbsFunctionPluginView<VB> getPluginView() {
            return this.pluginView;
        }

        public final void setPluginView(AbsFunctionPluginView<VB> absFunctionPluginView) {
            this.pluginView = absFunctionPluginView;
        }

        public void deny() {
            EasyPopup teacherControlPopup;
            AudioControlHandler<VB> audioControlHandler;
            AbsFunctionPluginView<VB> absFunctionPluginView = this.pluginView;
            if (!(absFunctionPluginView == null || (audioControlHandler = absFunctionPluginView.getAudioControlHandler()) == null)) {
                audioControlHandler.removeCallbacksAndMessages((Object) null);
            }
            AbsFunctionPluginView<VB> absFunctionPluginView2 = this.pluginView;
            if (absFunctionPluginView2 != null && (teacherControlPopup = absFunctionPluginView2.getTeacherControlPopup()) != null) {
                teacherControlPopup.dismiss();
            }
        }

        public void agree() {
            FunctionPluginDriver driver;
            EasyPopup teacherControlPopup;
            AudioControlHandler<VB> audioControlHandler;
            XesLog.dt("功能区", "agree");
            AbsFunctionPluginView<VB> absFunctionPluginView = this.pluginView;
            if (!(absFunctionPluginView == null || (audioControlHandler = absFunctionPluginView.getAudioControlHandler()) == null)) {
                audioControlHandler.removeCallbacksAndMessages((Object) null);
            }
            AbsFunctionPluginView<VB> absFunctionPluginView2 = this.pluginView;
            if (!(absFunctionPluginView2 == null || (teacherControlPopup = absFunctionPluginView2.getTeacherControlPopup()) == null)) {
                teacherControlPopup.dismiss();
            }
            if (!PermissionUtils.isGranted("android.permission.RECORD_AUDIO")) {
                XesLog.dt("功能区", "没有麦克风权限");
                AbsFunctionPluginView<VB> absFunctionPluginView3 = this.pluginView;
                if (absFunctionPluginView3 != null && (driver = absFunctionPluginView3.getDriver()) != null) {
                    driver.showPermissionWindow(true);
                    return;
                }
                return;
            }
            XesLog.dt("功能区", "打开麦克风");
            this.this$0.getDriver().controlLocalAudio(true);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView$TeacherNotAllowMic;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/tal/app/thinkacademy/live/business/function/ITeacherNotAllow;", "pluginView", "Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;", "(Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;)V", "getPluginView", "()Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;", "setPluginView", "(Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;)V", "gotIt", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AbsFunctionPluginView.kt */
    public final class TeacherNotAllowMic<VB extends ViewBinding> implements ITeacherNotAllow {
        private AbsFunctionPluginView<VB> pluginView;
        final /* synthetic */ AbsFunctionPluginView<VB> this$0;

        public TeacherNotAllowMic(AbsFunctionPluginView absFunctionPluginView, AbsFunctionPluginView<VB> absFunctionPluginView2) {
            Intrinsics.checkNotNullParameter(absFunctionPluginView, "this$0");
            this.this$0 = absFunctionPluginView;
            this.pluginView = absFunctionPluginView2;
        }

        public final AbsFunctionPluginView<VB> getPluginView() {
            return this.pluginView;
        }

        public final void setPluginView(AbsFunctionPluginView<VB> absFunctionPluginView) {
            this.pluginView = absFunctionPluginView;
        }

        public void gotIt() {
            EasyPopup teacherNotAllowPopup;
            AudioControlHandler<VB> audioControlHandler;
            AbsFunctionPluginView<VB> absFunctionPluginView = this.pluginView;
            if (!(absFunctionPluginView == null || (audioControlHandler = absFunctionPluginView.getAudioControlHandler()) == null)) {
                audioControlHandler.removeCallbacksAndMessages((Object) null);
            }
            AbsFunctionPluginView<VB> absFunctionPluginView2 = this.pluginView;
            if (absFunctionPluginView2 != null && (teacherNotAllowPopup = absFunctionPluginView2.getTeacherNotAllowPopup()) != null) {
                teacherNotAllowPopup.dismiss();
            }
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView$VolumeHandler;", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "pluginView", "Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;", "(Landroid/os/Looper;Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;)V", "getPluginView", "()Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;", "setPluginView", "(Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AbsFunctionPluginView.kt */
    public static final class VolumeHandler<VB extends ViewBinding> extends Handler {
        private AbsFunctionPluginView<VB> pluginView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VolumeHandler(Looper looper, AbsFunctionPluginView<VB> absFunctionPluginView) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.pluginView = absFunctionPluginView;
        }

        public final AbsFunctionPluginView<VB> getPluginView() {
            return this.pluginView;
        }

        public final void setPluginView(AbsFunctionPluginView<VB> absFunctionPluginView) {
            this.pluginView = absFunctionPluginView;
        }

        public void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            Intrinsics.checkNotNullParameter(message, "msg");
            super.handleMessage(message);
            int i = message.what;
            AbsFunctionPluginView<VB> absFunctionPluginView = this.pluginView;
            boolean z = false;
            if (absFunctionPluginView != null && i == absFunctionPluginView.WHAT_MIC_UPDATE) {
                z = true;
            }
            if (z) {
                Object obj = message.obj;
                if (obj != null) {
                    SmallClassPluginDriver.MicDataBean micDataBean = (SmallClassPluginDriver.MicDataBean) obj;
                    AbsFunctionPluginView<VB> absFunctionPluginView2 = this.pluginView;
                    if (absFunctionPluginView2 != null) {
                        absFunctionPluginView2.updateMic(micDataBean.mic);
                    }
                } else {
                    NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver.MicDataBean");
                    AsynchronousInstrumentation.handlerMessageEnd();
                    throw nullPointerException;
                }
            }
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView$AudioControlHandler;", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "pluginView", "Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;", "(Landroid/os/Looper;Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AbsFunctionPluginView.kt */
    public static final class AudioControlHandler<VB extends ViewBinding> extends Handler {
        private AbsFunctionPluginView<VB> pluginView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AudioControlHandler(Looper looper, AbsFunctionPluginView<VB> absFunctionPluginView) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.pluginView = absFunctionPluginView;
        }

        public void handleMessage(Message message) {
            AbsFunctionPluginView<VB> absFunctionPluginView;
            EasyPopup teacherNotAllowPopup;
            EasyPopup teacherControlPopup;
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            Intrinsics.checkNotNullParameter(message, "msg");
            super.handleMessage(message);
            if (message.what == 1) {
                AbsFunctionPluginView<VB> absFunctionPluginView2 = this.pluginView;
                if (!(absFunctionPluginView2 == null || (teacherControlPopup = absFunctionPluginView2.getTeacherControlPopup()) == null)) {
                    teacherControlPopup.dismiss();
                }
            } else if (!(message.what != 2 || (absFunctionPluginView = this.pluginView) == null || (teacherNotAllowPopup = absFunctionPluginView.getTeacherNotAllowPopup()) == null)) {
                teacherNotAllowPopup.dismiss();
            }
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView$AudioControlCameraHandler;", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "pluginView", "Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;", "(Landroid/os/Looper;Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AbsFunctionPluginView.kt */
    public static final class AudioControlCameraHandler<VB extends ViewBinding> extends Handler {
        private AbsFunctionPluginView<VB> pluginView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AudioControlCameraHandler(Looper looper, AbsFunctionPluginView<VB> absFunctionPluginView) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.pluginView = absFunctionPluginView;
        }

        public void handleMessage(Message message) {
            EasyPopup teacherControlCameraPopup;
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            Intrinsics.checkNotNullParameter(message, "msg");
            super.handleMessage(message);
            if (message.what == 1) {
                AbsFunctionPluginView<VB> absFunctionPluginView = this.pluginView;
                if (!(absFunctionPluginView == null || (teacherControlCameraPopup = absFunctionPluginView.getTeacherControlCameraPopup()) == null)) {
                    teacherControlCameraPopup.dismiss();
                }
            } else {
                int i = message.what;
            }
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    }
}
