package com.tal.app.thinkacademy.live.business.function;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.lib.util.DeviceUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.lib.util.StringUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.listenbody.AllOnStageListenerBody;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ChatBoxListenerBody;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.bean.CoinData;
import com.tal.app.thinkacademy.live.abilitypack.photobox.PhotoBoxViewModel;
import com.tal.app.thinkacademy.live.abilitypack.photobox.PhotoBoxViewModelKt;
import com.tal.app.thinkacademy.live.abilitypack.photobox.listenbody.PhotoBoxListenerBody;
import com.tal.app.thinkacademy.live.abilitypack.photowall.PhotoWallViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModelKt;
import com.tal.app.thinkacademy.live.abilitypack.rtc.listenbody.RtcPlayerListenerBody;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository;
import com.tal.app.thinkacademy.live.business.function.view.AbsFunctionPluginView;
import com.tal.app.thinkacademy.live.business.function.view.FunctionPluginView;
import com.tal.app.thinkacademy.live.business.function.view.FunctionPluginViewPhone;
import com.tal.app.thinkacademy.live.business.mediacontroller.EnableState;
import com.tal.app.thinkacademy.live.business.studentvideo.PermissCameraView;
import com.tal.app.thinkacademy.live.business.studentvideo.driver.StudentVideoPluginDriver;
import com.tal.app.thinkacademy.live.business.studentvideo.listen.PermissionListen;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.interfaces.IircControllerProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.RtcConfig;
import com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(classType = 1, desc = "小班功能区", ircType = {"mode", "user_audio_mute", "all_audio_mute", "allow_open_microphone", "user_video_mute", "forbidden_student_emoji", "forbid_mute_audio"}, launchType = "enter", moduleId = "-106")
@ViewLevels({@ViewLevel(level = 110, name = "function")})
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0018J\u000e\u0010G\u001a\u00020E2\u0006\u0010H\u001a\u00020\u0018J\n\u0010I\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010J\u001a\u00020EH\u0002J\u0012\u0010K\u001a\u0004\u0018\u00010\t2\u0006\u0010L\u001a\u00020MH\u0002J\b\u0010N\u001a\u00020\tH\u0002J\u0012\u0010O\u001a\u0004\u0018\u00010\t2\u0006\u0010P\u001a\u00020?H\u0002J\b\u0010Q\u001a\u0004\u0018\u00010\u0004J\b\u0010R\u001a\u0004\u0018\u00010SJ\b\u0010T\u001a\u00020EH\u0002J\b\u0010U\u001a\u00020EH\u0002J\b\u0010V\u001a\u00020EH\u0016J\u001c\u0010W\u001a\u00020E2\b\u0010X\u001a\u0004\u0018\u00010\t2\b\u0010Y\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010Z\u001a\u00020EH\u0002J\u000e\u0010[\u001a\u00020E2\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\\\u001a\u00020EH\u0002J\b\u0010]\u001a\u00020EH\u0002J\b\u0010^\u001a\u00020EH\u0016J\b\u0010_\u001a\u00020EH\u0002J\u0018\u0010`\u001a\u00020E2\u0006\u0010a\u001a\u00020\u00182\u0006\u0010b\u001a\u00020cH\u0002J\b\u0010d\u001a\u00020EH\u0016J\u0010\u0010e\u001a\u00020E2\b\b\u0002\u0010f\u001a\u00020\u0018J \u0010g\u001a\u00020E2\u0006\u0010h\u001a\u00020\t2\u0006\u0010i\u001a\u00020?2\b\b\u0002\u0010j\u001a\u00020kJ\u000e\u0010l\u001a\u00020E2\u0006\u0010m\u001a\u00020\u0018R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020'0&X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020'0&X\u000e¢\u0006\u0002\n\u0000R \u00104\u001a\b\u0012\u0004\u0012\u00020'0&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020'0&X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020'0&X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020'0&X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020'0&X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020'0&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/function/FunctionPluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "Lcom/tal/app/thinkacademy/live/business/studentvideo/listen/PermissionListen;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "TAG", "", "kotlin.jvm.PlatformType", "cameraOn", "cameraView", "Lcom/tal/app/thinkacademy/live/business/studentvideo/PermissCameraView;", "chatNameStr", "context", "Landroid/content/Context;", "data", "Lcom/tal/app/thinkacademy/live/abilitypack/coincenter/bean/CoinData;", "enterRoomMuteData", "Lcom/tal/app/thinkacademy/live/business/function/bean/EnterRoomMuteData;", "functionPluginView", "Lcom/tal/app/thinkacademy/live/business/function/view/AbsFunctionPluginView;", "isRequestEnterRoomMuteDataEnd", "", "isVideoLinking", "mAllOnStageViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/AllOnStageViewModel;", "mChatBoxViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/ChatBoxViewModel;", "mCourseInfoProxy", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/CourseInfoProxy;", "mEmojiPub", "mEmojiTipsView", "Lcom/tal/app/thinkacademy/live/business/function/EmojiTipsView;", "mEnterConfig", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/EnterConfigProxy;", "mObserverCamera", "Landroidx/lifecycle/Observer;", "Lcom/tal/app/thinkacademy/live/core/plugin/PluginEventData;", "mPhotoWallViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/photowall/PhotoWallViewModel;", "mPlanInfoProxy", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/PlanInfoProxy;", "mRtcViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel;", "mTeacherInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/TeacherInfo;", "mTeacherPrivateChat", "mTeacherPrivateOnStageObserver", "micOn", "observerChatBox", "observerFeedback", "getObserverFeedback", "()Landroidx/lifecycle/Observer;", "setObserverFeedback", "(Landroidx/lifecycle/Observer;)V", "observerGroupEnd", "observerGroupStart", "observerPermission", "observerTutorVideoCall", "observerVideoCall", "planId", "", "schoolId", "tutorIrcNickName", "userInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;", "controlLocalAudio", "", "micState", "controlLocalVideo", "cameraState", "getChatName", "getEnterRoomMuteData", "getFeedbackMessage", "parameter", "Lorg/json/JSONObject;", "getIRCRoomId", "getLevelUpMessage", "level", "getLiveRoomProvider", "getProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/IircControllerProvider;", "initMicStatus", "listenerVolumeOfSpeaker", "onDestroy", "onMessage", "ircTypeKey", "message", "openMicNowAndNoUi", "postUserInfo", "registerDataBus", "registerPermission", "removePermissView", "setRaiseHandData", "setSwitchEnable", "enable", "state", "Lcom/tal/app/thinkacademy/live/business/mediacontroller/EnableState;", "settingView", "showPermissionWindow", "isMicrophone", "showTips", "text", "top", "showTime", "", "switchChatBox", "show", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FunctionPluginDriver.kt */
public final class FunctionPluginDriver extends BaseLivePluginDriver implements PermissionListen {
    /* access modifiers changed from: private */
    public final String TAG = "FunctionPluginDriver";
    /* access modifiers changed from: private */
    public String cameraOn;
    private PermissCameraView cameraView;
    private String chatNameStr;
    private Context context;
    private CoinData data;
    /* access modifiers changed from: private */
    public EnterRoomMuteData enterRoomMuteData;
    /* access modifiers changed from: private */
    public AbsFunctionPluginView<?> functionPluginView;
    /* access modifiers changed from: private */
    public boolean isRequestEnterRoomMuteDataEnd;
    private boolean isVideoLinking;
    private AllOnStageViewModel mAllOnStageViewModel;
    private ChatBoxViewModel mChatBoxViewModel;
    private CourseInfoProxy mCourseInfoProxy;
    private volatile boolean mEmojiPub;
    private EmojiTipsView mEmojiTipsView;
    private EnterConfigProxy mEnterConfig;
    private Observer<PluginEventData> mObserverCamera;
    private PhotoWallViewModel mPhotoWallViewModel;
    private PlanInfoProxy mPlanInfoProxy;
    private RtcViewModel mRtcViewModel;
    private TeacherInfo mTeacherInfo;
    private boolean mTeacherPrivateChat;
    private Observer<PluginEventData> mTeacherPrivateOnStageObserver;
    /* access modifiers changed from: private */
    public String micOn;
    private Observer<PluginEventData> observerChatBox;
    private Observer<PluginEventData> observerFeedback;
    private Observer<PluginEventData> observerGroupEnd;
    private Observer<PluginEventData> observerGroupStart;
    private Observer<PluginEventData> observerPermission;
    private Observer<PluginEventData> observerTutorVideoCall;
    private Observer<PluginEventData> observerVideoCall;
    /* access modifiers changed from: private */
    public int planId;
    private String schoolId;
    private String tutorIrcNickName;
    private UserInfoProxy userInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        ListenerData<PhotoBoxListenerBody> mListenerData;
        ListenerData<ChatBoxListenerBody> mListenerBody;
        ListenerData<AllOnStageListenerBody> mListenerBody2;
        AbsFunctionPluginView<?> absFunctionPluginView;
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "mLiveRoomProvider");
        String str = "1";
        this.cameraOn = PermissionUtils.isGranted("android.permission.CAMERA") ? str : "2";
        this.micOn = !PermissionUtils.isGranted("android.permission.RECORD_AUDIO") ? "2" : str;
        this.observerGroupStart = new FunctionPluginDriver$$ExternalSyntheticLambda10(this);
        this.observerGroupEnd = new FunctionPluginDriver$$ExternalSyntheticLambda12(this);
        this.observerTutorVideoCall = new FunctionPluginDriver$$ExternalSyntheticLambda7(this);
        this.observerVideoCall = new FunctionPluginDriver$$ExternalSyntheticLambda13(this);
        this.observerPermission = new FunctionPluginDriver$$ExternalSyntheticLambda9(this);
        this.observerFeedback = new FunctionPluginDriver$$ExternalSyntheticLambda6(this, iLiveRoomProvider);
        this.mObserverCamera = new FunctionPluginDriver$$ExternalSyntheticLambda8(this);
        this.observerChatBox = new FunctionPluginDriver$$ExternalSyntheticLambda14(this);
        this.mTeacherPrivateOnStageObserver = new FunctionPluginDriver$$ExternalSyntheticLambda11(this);
        this.mRtcViewModel = RtcViewModelKt.getRtcViewModel(AbilityPackKt.getAbilityPack());
        this.mAllOnStageViewModel = AbilityPackKt.getAbilityPack().getViewModel(AllOnStageViewModel.class);
        this.mChatBoxViewModel = AbilityPackKt.getAbilityPack().getViewModel(ChatBoxViewModel.class);
        this.mPhotoWallViewModel = AbilityPackKt.getAbilityPack().getViewModel(PhotoWallViewModel.class);
        this.userInfo = iLiveRoomProvider.getDataStorage().getUserInfo();
        String id = iLiveRoomProvider.getDataStorage().getPlanInfo().getId();
        Intrinsics.checkNotNullExpressionValue(id, "mLiveRoomProvider.dataStorage.planInfo.id");
        this.planId = Integer.parseInt(id);
        this.mEnterConfig = iLiveRoomProvider.getDataStorage().getEnterConfig();
        this.mTeacherInfo = iLiveRoomProvider.getDataStorage().getTeacherInfo();
        this.mPlanInfoProxy = iLiveRoomProvider.getDataStorage().getPlanInfo();
        this.mCourseInfoProxy = iLiveRoomProvider.getDataStorage().getCourseInfo();
        this.schoolId = ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        this.tutorIrcNickName = iLiveRoomProvider.getDataStorage().getEnterConfig().getTutorIrcId();
        WeakReference<Context> weakRefContext = iLiveRoomProvider.getWeakRefContext();
        Context context2 = weakRefContext == null ? null : (Context) weakRefContext.get();
        this.context = context2;
        if (context2 != null) {
            if (PadUtils.isPad(Utils.getApp())) {
                absFunctionPluginView = new FunctionPluginView(context2, this);
            } else {
                absFunctionPluginView = new FunctionPluginViewPhone(context2, this);
            }
            this.functionPluginView = absFunctionPluginView;
            iLiveRoomProvider.addView((BaseLivePluginDriver) this, this.functionPluginView, this.mPluginConfData.getViewLevel("function"), LiveAreaContext.get().getFuncLp().newLp());
            LiveAreaContext.get().layoutObserver.observe((LifecycleOwner) this, new FunctionPluginDriver$$ExternalSyntheticLambda0(this));
        }
        registerPermission();
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        PluginEventBus.register(lifecycleOwner, DataBusKey.VIDEO_CALL_STATUS, this.observerVideoCall);
        PluginEventBus.register(lifecycleOwner, DataBusKey.VIDEO_CALL_F_STATUS, this.observerTutorVideoCall);
        PluginEventBus.register(lifecycleOwner, DataBusKey.FUNCTION_SHOW_PERMISSION_DIALOG, this.observerPermission);
        registerDataBus();
        PluginEventBus.register(lifecycleOwner, DataBusKey.GROUP_VIDEO_CALL_STUDENT_START, this.observerGroupStart);
        PluginEventBus.register(lifecycleOwner, DataBusKey.GROUP_VIDEO_CALL_STUDENT_END, this.observerGroupEnd);
        PluginEventBus.register(lifecycleOwner, DataBusKey.CLASS_FEEDBACK, this.observerFeedback);
        PluginEventBus.register(lifecycleOwner, DataBusKey.USER_MUTE_VIDEO_KEY, this.mObserverCamera);
        PluginEventBus.register(lifecycleOwner, DataBusKey.TEACHER_DRIVER_PRIVATE_CHAT, this.mTeacherPrivateOnStageObserver);
        XesDataBus.with(DataBusKey.WEB_DISMISS_VIEW).observe(lifecycleOwner, new FunctionPluginDriver$$ExternalSyntheticLambda15(this));
        getEnterRoomMuteData();
        setRaiseHandData();
        listenerVolumeOfSpeaker();
        AllOnStageViewModel allOnStageViewModel = this.mAllOnStageViewModel;
        if (!(allOnStageViewModel == null || (mListenerBody2 = allOnStageViewModel.getMListenerBody()) == null)) {
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            mListenerBody2.observeListener(lifecycleOwner, false, simpleName, new Function1<AllOnStageListenerBody, Unit>(this) {
                final /* synthetic */ FunctionPluginDriver this$0;

                {
                    this.this$0 = r1;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((AllOnStageListenerBody) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(AllOnStageListenerBody allOnStageListenerBody) {
                    Intrinsics.checkNotNullParameter(allOnStageListenerBody, "$this$observeListener");
                    final FunctionPluginDriver functionPluginDriver = this.this$0;
                    allOnStageListenerBody.onStageChanged(new Function1<Boolean, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Boolean) obj).booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z) {
                            if (z) {
                                if (!Intrinsics.areEqual(functionPluginDriver.micOn, "1") && PermissionUtils.isGranted("android.permission.RECORD_AUDIO")) {
                                    functionPluginDriver.controlLocalAudio(true);
                                }
                            } else if (!PadUtils.isPad(Utils.getApp()) && !Intrinsics.areEqual(functionPluginDriver.cameraOn, "1") && PermissionUtils.isGranted("android.permission.CAMERA")) {
                                functionPluginDriver.controlLocalVideo(true);
                            }
                        }
                    });
                }
            });
        }
        ChatBoxViewModel chatBoxViewModel = this.mChatBoxViewModel;
        if (!(chatBoxViewModel == null || (mListenerBody = chatBoxViewModel.getMListenerBody()) == null)) {
            String simpleName2 = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName2, "javaClass.simpleName");
            mListenerBody.observeListener(lifecycleOwner, false, simpleName2, new Function1<ChatBoxListenerBody, Unit>(this) {
                final /* synthetic */ FunctionPluginDriver this$0;

                {
                    this.this$0 = r1;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ChatBoxListenerBody) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(ChatBoxListenerBody chatBoxListenerBody) {
                    Intrinsics.checkNotNullParameter(chatBoxListenerBody, "$this$observeListener");
                    final FunctionPluginDriver functionPluginDriver = this.this$0;
                    chatBoxListenerBody.onChatBoxViewClosed(new Function0<Unit>() {
                        public final void invoke() {
                            AbsFunctionPluginView access$getFunctionPluginView$p = functionPluginDriver.functionPluginView;
                            if (access$getFunctionPluginView$p != null) {
                                access$getFunctionPluginView$p.resetChatBoxStatus(false);
                            }
                        }
                    });
                    final FunctionPluginDriver functionPluginDriver2 = this.this$0;
                    chatBoxListenerBody.onShowChatBoxRedRot(new Function0<Unit>() {
                        public final void invoke() {
                            AbsFunctionPluginView access$getFunctionPluginView$p = functionPluginDriver2.functionPluginView;
                            if (access$getFunctionPluginView$p != null) {
                                access$getFunctionPluginView$p.showChatBoxRedDotView(true);
                            }
                        }
                    });
                }
            });
        }
        PluginEventBus.register(lifecycleOwner, DataBusKey.CHAT_BOX_FUNCTION_KEY, this.observerChatBox);
        PhotoBoxViewModel photoBoxViewModel = PhotoBoxViewModelKt.getPhotoBoxViewModel(AbilityPackKt.getAbilityPack());
        if (photoBoxViewModel != null && (mListenerData = photoBoxViewModel.getMListenerData()) != null) {
            mListenerData.observeListener(lifecycleOwner, false, "functionDriver", new Function1<PhotoBoxListenerBody, Unit>(this) {
                final /* synthetic */ FunctionPluginDriver this$0;

                {
                    this.this$0 = r1;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((PhotoBoxListenerBody) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(PhotoBoxListenerBody photoBoxListenerBody) {
                    Intrinsics.checkNotNullParameter(photoBoxListenerBody, "$this$observeListener");
                    final FunctionPluginDriver functionPluginDriver = this.this$0;
                    photoBoxListenerBody.onBoxNewMessage(new Function0<Unit>() {
                        public final void invoke() {
                            AbsFunctionPluginView access$getFunctionPluginView$p = functionPluginDriver.functionPluginView;
                            if (access$getFunctionPluginView$p != null) {
                                AbsFunctionPluginView.showNewMessage$default(access$getFunctionPluginView$p, (Boolean) null, 1, (Object) null);
                            }
                        }
                    });
                    photoBoxListenerBody.onBoxDetailResult(AnonymousClass2.INSTANCE);
                    photoBoxListenerBody.onBoxListResult(AnonymousClass3.INSTANCE);
                    photoBoxListenerBody.onBoxListResult(AnonymousClass4.INSTANCE);
                    photoBoxListenerBody.onBoxClose(AnonymousClass5.INSTANCE);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observerGroupStart$lambda-0  reason: not valid java name */
    public static final void m241observerGroupStart$lambda0(FunctionPluginDriver functionPluginDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(functionPluginDriver, "this$0");
        UserInfoProxy userInfoProxy = functionPluginDriver.userInfo;
        if (Intrinsics.areEqual(userInfoProxy == null ? null : userInfoProxy.getId(), pluginEventData.getData())) {
            functionPluginDriver.isVideoLinking = true;
            AbsFunctionPluginView<?> absFunctionPluginView = functionPluginDriver.functionPluginView;
            if (absFunctionPluginView != null) {
                absFunctionPluginView.isEnableHand(false);
            }
            functionPluginDriver.openMicNowAndNoUi();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observerGroupEnd$lambda-1  reason: not valid java name */
    public static final void m240observerGroupEnd$lambda1(FunctionPluginDriver functionPluginDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(functionPluginDriver, "this$0");
        UserInfoProxy userInfoProxy = functionPluginDriver.userInfo;
        if (Intrinsics.areEqual(userInfoProxy == null ? null : userInfoProxy.getId(), pluginEventData.getData())) {
            functionPluginDriver.isVideoLinking = false;
            AbsFunctionPluginView<?> absFunctionPluginView = functionPluginDriver.functionPluginView;
            if (absFunctionPluginView != null) {
                absFunctionPluginView.isEnableHand(true);
            }
        }
    }

    private final void registerDataBus() {
        XesDataBus.with(DataBusKey.TAKE_PHOTO_STATE).observe((LifecycleOwner) this, new FunctionPluginDriver$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerDataBus$lambda-2  reason: not valid java name */
    public static final void m245registerDataBus$lambda2(FunctionPluginDriver functionPluginDriver, Object obj) {
        Intrinsics.checkNotNullParameter(functionPluginDriver, "this$0");
        if (obj == null) {
            return;
        }
        if (Intrinsics.areEqual("end", (String) obj)) {
            functionPluginDriver.setSwitchEnable(true, EnableState.CAMERA);
        } else {
            functionPluginDriver.setSwitchEnable(false, EnableState.CAMERA);
        }
    }

    private final void registerPermission() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        XesDataBus.with(DataBusKey.CAMERA_PERMISSION).observe(lifecycleOwner, new FunctionPluginDriver$$ExternalSyntheticLambda3(this));
        XesDataBus.with(DataBusKey.AUDIO_PERMISSION).observe(lifecycleOwner, new FunctionPluginDriver$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerPermission$lambda-3  reason: not valid java name */
    public static final void m246registerPermission$lambda3(FunctionPluginDriver functionPluginDriver, Object obj) {
        Intrinsics.checkNotNullParameter(functionPluginDriver, "this$0");
        if (obj != null) {
            functionPluginDriver.controlLocalVideo(((Boolean) obj).booleanValue());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerPermission$lambda-4  reason: not valid java name */
    public static final void m247registerPermission$lambda4(FunctionPluginDriver functionPluginDriver, Object obj) {
        Intrinsics.checkNotNullParameter(functionPluginDriver, "this$0");
        functionPluginDriver.initMicStatus();
    }

    /* access modifiers changed from: private */
    /* renamed from: observerTutorVideoCall$lambda-5  reason: not valid java name */
    public static final void m243observerTutorVideoCall$lambda5(FunctionPluginDriver functionPluginDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(functionPluginDriver, "this$0");
        if (Intrinsics.areEqual("videoCallTutorOn", pluginEventData.getData())) {
            functionPluginDriver.setSwitchEnable(false, EnableState.TUTOR_LINK);
        } else if (Intrinsics.areEqual("videoCallTutorOff", pluginEventData.getData())) {
            functionPluginDriver.setSwitchEnable(true, EnableState.TUTOR_LINK);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observerVideoCall$lambda-6  reason: not valid java name */
    public static final void m244observerVideoCall$lambda6(FunctionPluginDriver functionPluginDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(functionPluginDriver, "this$0");
        XesLog.it(functionPluginDriver.TAG, Intrinsics.stringPlus("收到教师端视频连麦=", pluginEventData.getData()));
        String data2 = pluginEventData.getData();
        if (Intrinsics.areEqual(data2, "videoCallStart") ? true : Intrinsics.areEqual(data2, "videoCallOn")) {
            functionPluginDriver.setSwitchEnable(false, EnableState.TEACHER_LINK);
        } else {
            functionPluginDriver.setSwitchEnable(true, EnableState.TEACHER_LINK);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observerPermission$lambda-7  reason: not valid java name */
    public static final void m242observerPermission$lambda7(FunctionPluginDriver functionPluginDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(functionPluginDriver, "this$0");
        if (Intrinsics.areEqual(pluginEventData.getData(), "camera")) {
            functionPluginDriver.showPermissionWindow(false);
        } else {
            functionPluginDriver.showPermissionWindow(true);
        }
    }

    public final Observer<PluginEventData> getObserverFeedback() {
        return this.observerFeedback;
    }

    public final void setObserverFeedback(Observer<PluginEventData> observer) {
        Intrinsics.checkNotNullParameter(observer, "<set-?>");
        this.observerFeedback = observer;
    }

    /* access modifiers changed from: private */
    /* renamed from: observerFeedback$lambda-8  reason: not valid java name */
    public static final void m239observerFeedback$lambda8(FunctionPluginDriver functionPluginDriver, ILiveRoomProvider iLiveRoomProvider, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(functionPluginDriver, "this$0");
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "$mLiveRoomProvider");
        Object object = pluginEventData.getObject();
        Objects.requireNonNull(object, "null cannot be cast to non-null type org.json.JSONObject");
        JSONObject jSONObject = (JSONObject) object;
        try {
            jSONObject.put("schoolCode", functionPluginDriver.schoolId);
            PlanInfoProxy planInfoProxy = functionPluginDriver.mPlanInfoProxy;
            Intrinsics.checkNotNull(planInfoProxy);
            jSONObject.put("planId", planInfoProxy.getId());
            jSONObject.put("roomId", iLiveRoomProvider.getDataStorage().getCourseInfo().getClassId());
            EnterConfigProxy enterConfigProxy = functionPluginDriver.mEnterConfig;
            Intrinsics.checkNotNull(enterConfigProxy);
            jSONObject.put("studentId", enterConfigProxy.getStuIrcId());
            UserInfoProxy userInfoProxy = functionPluginDriver.userInfo;
            jSONObject.put(LeanplumUtil.uid, userInfoProxy == null ? null : userInfoProxy.getId());
            TeacherInfo teacherInfo = functionPluginDriver.mTeacherInfo;
            Intrinsics.checkNotNull(teacherInfo);
            jSONObject.put("teacherId", teacherInfo.getId());
            TeacherInfo teacherInfo2 = functionPluginDriver.mTeacherInfo;
            Intrinsics.checkNotNull(teacherInfo2);
            jSONObject.put("teacherName", teacherInfo2.getNickName());
            EnterConfigProxy enterConfigProxy2 = functionPluginDriver.mEnterConfig;
            Intrinsics.checkNotNull(enterConfigProxy2);
            jSONObject.put("teacherRoomId", enterConfigProxy2.getRtcConfig().getTeacherRoomId());
            jSONObject.put("device", DeviceUtils.getModel());
            jSONObject.put("deviceVersion", DeviceUtils.getSDKVersionName());
            jSONObject.put("AppVersion", "2.19.1");
            if (!TextUtils.isEmpty(functionPluginDriver.tutorIrcNickName)) {
                XesLog.et(functionPluginDriver.TAG, "未获取到辅导老师的昵称");
                String feedbackMessage = functionPluginDriver.getFeedbackMessage(jSONObject);
                IircControllerProvider provider = functionPluginDriver.getProvider();
                if (provider != null) {
                    provider.sendPeerMessage(functionPluginDriver.tutorIrcNickName, feedbackMessage, 99);
                }
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(AwsS3Util.scene_feedback, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                XesLog.ut(functionPluginDriver.TAG, jsonObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mObserverCamera$lambda-9  reason: not valid java name */
    public static final void m236mObserverCamera$lambda9(FunctionPluginDriver functionPluginDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(functionPluginDriver, "this$0");
        if (pluginEventData != null) {
            try {
                if (!Intrinsics.areEqual("fromFunction", pluginEventData.getObject())) {
                    AbsFunctionPluginView<?> absFunctionPluginView = functionPluginDriver.functionPluginView;
                    if (absFunctionPluginView != null) {
                        absFunctionPluginView.setCameraStatus(pluginEventData.getData());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observerChatBox$lambda-10  reason: not valid java name */
    public static final void m238observerChatBox$lambda10(FunctionPluginDriver functionPluginDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(functionPluginDriver, "this$0");
        if (pluginEventData != null) {
            try {
                if (Intrinsics.areEqual(pluginEventData.getData(), "13")) {
                    AbsFunctionPluginView<?> absFunctionPluginView = functionPluginDriver.functionPluginView;
                    if (absFunctionPluginView != null) {
                        absFunctionPluginView.hideChatBoxView();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mTeacherPrivateOnStageObserver$lambda-11  reason: not valid java name */
    public static final void m237mTeacherPrivateOnStageObserver$lambda11(FunctionPluginDriver functionPluginDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(functionPluginDriver, "this$0");
        if (pluginEventData.getObject() instanceof Boolean) {
            Object object = pluginEventData.getObject();
            Objects.requireNonNull(object, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) object).booleanValue()) {
                boolean z = false;
                if (Intrinsics.areEqual("1", pluginEventData.getData())) {
                    XesLog.dt(functionPluginDriver.TAG, "收到老师私聊上台消息，打开私聊");
                    if (!functionPluginDriver.mTeacherPrivateChat) {
                        RtcViewModel rtcViewModel = functionPluginDriver.mRtcViewModel;
                        if (rtcViewModel != null && !rtcViewModel.getMLocalAudioEnable()) {
                            z = true;
                        }
                        if (z) {
                            functionPluginDriver.openMicNowAndNoUi();
                        }
                    }
                    functionPluginDriver.mTeacherPrivateChat = true;
                    return;
                }
                XesLog.dt(functionPluginDriver.TAG, "收到老师私聊上台消息,关闭私聊");
                functionPluginDriver.mTeacherPrivateChat = false;
            }
        }
    }

    private final String getFeedbackMessage(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("type", "150");
            jSONObject2.put("name", getChatName());
            jSONObject2.put("parameter", jSONObject);
            jSONObject2.put("msg", "I send a feedback");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2);
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-14$lambda-13  reason: not valid java name */
    public static final void m235lambda14$lambda13(FunctionPluginDriver functionPluginDriver, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(functionPluginDriver, "this$0");
        AbsFunctionPluginView<?> absFunctionPluginView = functionPluginDriver.functionPluginView;
        if (absFunctionPluginView != null) {
            ViewGroup.LayoutParams layoutParams = absFunctionPluginView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            liveAreaContext.getFuncLp().mergeLp(layoutParams2);
            absFunctionPluginView.setLayoutParams(layoutParams2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-15  reason: not valid java name */
    public static final void m234_init_$lambda15(FunctionPluginDriver functionPluginDriver, String str) {
        Intrinsics.checkNotNullParameter(functionPluginDriver, "this$0");
        AbsFunctionPluginView<?> absFunctionPluginView = functionPluginDriver.functionPluginView;
        if (absFunctionPluginView != null) {
            absFunctionPluginView.closeExamReportDialog();
        }
    }

    public static /* synthetic */ void showTips$default(FunctionPluginDriver functionPluginDriver, String str, int i, long j, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j = 3000;
        }
        functionPluginDriver.showTips(str, i, j);
    }

    public final void showTips(String str, int i, long j) {
        Intrinsics.checkNotNullParameter(str, "text");
        EmojiTipsView emojiTipsView = this.mEmojiTipsView;
        if (emojiTipsView != null) {
            emojiTipsView.destroy();
        }
        Context context2 = this.context;
        if (context2 != null) {
            String viewLevel = this.mPluginConfData.getViewLevel("function");
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
            Intrinsics.checkNotNullExpressionValue(iLiveRoomProvider, "mLiveRoomProvider");
            EmojiTipsView emojiTipsView2 = new EmojiTipsView(context2, iLiveRoomProvider);
            this.mEmojiTipsView = emojiTipsView2;
            emojiTipsView2.setTips(str, j);
            LiveAreaLayoutParams funcLp = LiveAreaContext.get().getFuncLp();
            layoutParams.setMarginEnd(funcLp.right + funcLp.width);
            layoutParams.topMargin = funcLp.top + i;
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.mEmojiTipsView, viewLevel, layoutParams);
        }
        LiveAreaContext.get().layoutObserver.observe((LifecycleOwner) this, new FunctionPluginDriver$$ExternalSyntheticLambda4(this, i));
    }

    /* access modifiers changed from: private */
    /* renamed from: showTips$lambda-19  reason: not valid java name */
    public static final void m249showTips$lambda19(FunctionPluginDriver functionPluginDriver, int i, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(functionPluginDriver, "this$0");
        EmojiTipsView emojiTipsView = functionPluginDriver.mEmojiTipsView;
        if (emojiTipsView != null && emojiTipsView.getParent() != null) {
            ViewGroup.LayoutParams layoutParams = emojiTipsView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginEnd(liveAreaContext.getFuncLp().right + liveAreaContext.getFuncLp().width);
            layoutParams2.topMargin = i + liveAreaContext.getFuncLp().top;
            emojiTipsView.setLayoutParams(layoutParams2);
        }
    }

    private final void listenerVolumeOfSpeaker() {
        ListenerData<RtcPlayerListenerBody> mRtcPlayerListener;
        RtcViewModel rtcViewModel = this.mRtcViewModel;
        if (rtcViewModel != null && (mRtcPlayerListener = rtcViewModel.getMRtcPlayerListener()) != null) {
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            mRtcPlayerListener.observeListener((LifecycleOwner) this, false, simpleName, new FunctionPluginDriver$listenerVolumeOfSpeaker$1(this));
        }
    }

    public final ILiveRoomProvider getLiveRoomProvider() {
        return this.mLiveRoomProvider;
    }

    public final IircControllerProvider getProvider() {
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        if (iLiveRoomProvider == null) {
            return null;
        }
        return iLiveRoomProvider.getIrcControllerProvider();
    }

    private final void getEnterRoomMuteData() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), new HandlerException(new FunctionPluginDriver$getEnterRoomMuteData$1(this)), (CoroutineStart) null, new FunctionPluginDriver$getEnterRoomMuteData$2(this, new FunctionRepository(), (Continuation<? super FunctionPluginDriver$getEnterRoomMuteData$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void initMicStatus() {
        XesLog.it(this.TAG, Intrinsics.stringPlus("请求麦克风默认状态接口是否结束=", Boolean.valueOf(this.isRequestEnterRoomMuteDataEnd)));
        if (this.isRequestEnterRoomMuteDataEnd) {
            boolean isGranted = PermissionUtils.isGranted("android.permission.RECORD_AUDIO");
            if (this.enterRoomMuteData != null) {
                String str = this.TAG;
                XesLog.it(str, "进入教室麦克风默认状态，服务端配置=" + GsonUtil.getInstance().objToJson(this.enterRoomMuteData) + ",是否有麦克风权限=" + isGranted);
                EnterRoomMuteData enterRoomMuteData2 = this.enterRoomMuteData;
                String str2 = null;
                if (Intrinsics.areEqual("1", enterRoomMuteData2 == null ? null : enterRoomMuteData2.getEnterRoomMute())) {
                    controlLocalAudio(false);
                    return;
                }
                EnterRoomMuteData enterRoomMuteData3 = this.enterRoomMuteData;
                if (enterRoomMuteData3 != null) {
                    str2 = enterRoomMuteData3.getEnterRoomMute();
                }
                if (!Intrinsics.areEqual(EnterRoomMuteData.STATUS_UN_MUTE, str2)) {
                    return;
                }
                if (isGranted) {
                    controlLocalAudio(true);
                } else {
                    controlLocalAudio(false);
                }
            } else {
                XesLog.it(this.TAG, Intrinsics.stringPlus("进入教室麦克风默认状态,是否有麦克风权限=", Boolean.valueOf(isGranted)));
                controlLocalAudio(isGranted);
            }
        }
    }

    public final void postUserInfo(CoinData coinData) {
        Intrinsics.checkNotNullParameter(coinData, "data");
        PluginEventBus.onEvent(DataBusKey.COURSE_USERCOINS_KEY, PluginEventData.obtainData(getClass(), "fromFunction", coinData.getPlanIdCoin()));
    }

    private final void setRaiseHandData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("schoolCode", this.schoolId);
            PlanInfoProxy planInfoProxy = this.mPlanInfoProxy;
            String str = null;
            jSONObject.put("planId", planInfoProxy == null ? null : planInfoProxy.getId());
            jSONObject.put("roomId", this.mLiveRoomProvider.getDataStorage().getCourseInfo().getClassId());
            EnterConfigProxy enterConfigProxy = this.mEnterConfig;
            jSONObject.put("studentId", enterConfigProxy == null ? null : enterConfigProxy.getStuIrcId());
            UserInfoProxy userInfoProxy = this.userInfo;
            jSONObject.put(LeanplumUtil.uid, userInfoProxy == null ? null : userInfoProxy.getId());
            TeacherInfo teacherInfo = this.mTeacherInfo;
            jSONObject.put("teacherId", teacherInfo == null ? null : teacherInfo.getId());
            TeacherInfo teacherInfo2 = this.mTeacherInfo;
            jSONObject.put("teacherName", teacherInfo2 == null ? null : teacherInfo2.getNickName());
            EnterConfigProxy enterConfigProxy2 = this.mEnterConfig;
            if (enterConfigProxy2 != null) {
                RtcConfig rtcConfig = enterConfigProxy2.getRtcConfig();
                if (rtcConfig != null) {
                    str = rtcConfig.getTeacherRoomId();
                }
            }
            jSONObject.put("teacherRoomId", str);
            jSONObject.put("device", DeviceUtils.getModel());
            jSONObject.put("deviceVersion", DeviceUtils.getSDKVersionName());
            jSONObject.put("AppVersion", "2.19.1");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AbsFunctionPluginView<?> absFunctionPluginView = this.functionPluginView;
        if (absFunctionPluginView != null) {
            absFunctionPluginView.setRaiseHandData(jSONObject, this.tutorIrcNickName, getChatName());
        }
    }

    private final String getIRCRoomId() {
        List ircRooms = this.mLiveRoomProvider.getDataStorage().getEnterConfig().getIrcRooms();
        if (ircRooms.size() <= 0) {
            return "";
        }
        Object obj = ircRooms.get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "ircRooms[0]");
        return (String) obj;
    }

    private final String getLevelUpMessage(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "142");
            jSONObject.put("name", getChatName());
            UserInfoProxy userInfoProxy = this.userInfo;
            String str = null;
            jSONObject.put("path", Intrinsics.stringPlus("", userInfoProxy == null ? null : userInfoProxy.getAvatar()));
            jSONObject.put("msg", "");
            UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
            if (userInfoEntity != null) {
                str = userInfoEntity.getUid();
            }
            jSONObject.put("userId", str);
            jSONObject.put("level", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
    }

    private final String getChatName() {
        if (TextUtils.isEmpty(this.chatNameStr)) {
            UserInfoProxy userInfoProxy = this.userInfo;
            String str = null;
            if (!StringUtils.isEmpty(userInfoProxy == null ? null : userInfoProxy.getNickName())) {
                UserInfoProxy userInfoProxy2 = this.userInfo;
                if (userInfoProxy2 != null) {
                    str = userInfoProxy2.getName();
                }
            } else {
                UserInfoProxy userInfoProxy3 = this.userInfo;
                if (!StringUtils.isEmpty(userInfoProxy3 == null ? null : userInfoProxy3.getName())) {
                    UserInfoProxy userInfoProxy4 = this.userInfo;
                    if (userInfoProxy4 != null) {
                        str = userInfoProxy4.getName();
                    }
                } else {
                    UserInfoProxy userInfoProxy5 = this.userInfo;
                    if (userInfoProxy5 != null) {
                        str = userInfoProxy5.getEnglishName();
                    }
                }
            }
            this.chatNameStr = str;
        }
        return this.chatNameStr;
    }

    public static /* synthetic */ void showPermissionWindow$default(FunctionPluginDriver functionPluginDriver, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        functionPluginDriver.showPermissionWindow(z);
    }

    public final void showPermissionWindow(boolean z) {
        PermissCameraView permissCameraView;
        Context context2 = this.context;
        if (context2 != null) {
            PermissCameraView permissCameraView2 = this.cameraView;
            if (permissCameraView2 != null) {
                this.mLiveRoomProvider.removeView((View) permissCameraView2);
            }
            if (this.cameraView == null) {
                FunctionPluginDriver functionPluginDriver = this;
                PermissCameraView permissCameraView3 = new PermissCameraView(context2);
                this.cameraView = permissCameraView3;
                permissCameraView3.setDriver(this);
                if (z && (permissCameraView = this.cameraView) != null) {
                    permissCameraView.showMicrophoneTip();
                }
            }
            String viewLevel = this.mPluginConfData.getViewLevel("function");
            FrameLayout.LayoutParams newLp = LiveAreaContext.get().getPptLp().newLp();
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.cameraView, viewLevel, newLp);
            LiveAreaContext.get().layoutObserver.observe((LifecycleOwner) this, new FunctionPluginDriver$$ExternalSyntheticLambda5(this, newLp));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showPermissionWindow$lambda-24$lambda-23  reason: not valid java name */
    public static final void m248showPermissionWindow$lambda24$lambda23(FunctionPluginDriver functionPluginDriver, FrameLayout.LayoutParams layoutParams, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(functionPluginDriver, "this$0");
        PermissCameraView permissCameraView = functionPluginDriver.cameraView;
        if (permissCameraView != null) {
            ViewGroup.LayoutParams layoutParams2 = permissCameraView.getLayoutParams();
            Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            liveAreaContext.getPptLp().mergeLp(layoutParams);
            permissCameraView.setLayoutParams((FrameLayout.LayoutParams) layoutParams2);
        }
    }

    public void removePermissView() {
        PermissCameraView permissCameraView = this.cameraView;
        if (permissCameraView != null) {
            this.mLiveRoomProvider.removeView((View) permissCameraView);
        }
        this.cameraView = null;
    }

    public void settingView() {
        PermissCameraView permissCameraView = this.cameraView;
        if (permissCameraView != null) {
            this.mLiveRoomProvider.removeView((View) permissCameraView);
            PluginEventBus.onEvent(DataBusKey.SETTING_PERMISSION, PluginEventData.obtainData(StudentVideoPluginDriver.class, ""));
            PermissionUtils.launchAppDetailsSettings();
        }
        this.cameraView = null;
    }

    private final void setSwitchEnable(boolean z, EnableState enableState) {
        AbsFunctionPluginView<?> absFunctionPluginView = this.functionPluginView;
        if (absFunctionPluginView != null) {
            absFunctionPluginView.setSwitchCameraEnable(z, enableState);
        }
    }

    public final void controlLocalVideo(boolean z) {
        XesLog.dt(this.TAG, Intrinsics.stringPlus("controlLocalVideo，cameraState = ", Boolean.valueOf(z)));
        this.cameraOn = z ? "1" : EnterRoomMuteData.STATUS_UN_MUTE;
        PluginEventBus.onEvent(DataBusKey.USER_MUTE_VIDEO_KEY, new PluginEventData(getClass(), DataBusKey.USER_MUTE_VIDEO_KEY, this.cameraOn, "fromFunction"));
    }

    public final void controlLocalAudio(boolean z) {
        XesLog.dt(this.TAG, Intrinsics.stringPlus("controlLocalAudio micState = ", Boolean.valueOf(z)));
        this.micOn = z ? "1" : EnterRoomMuteData.STATUS_UN_MUTE;
        PluginEventBus.onEvent(DataBusKey.USER_MUTE_MIC_KEY, new PluginEventData(getClass(), DataBusKey.USER_MUTE_MIC_KEY, this.micOn));
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0088 A[Catch:{ Exception -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a A[Catch:{ Exception -> 0x0097 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMessage(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = r7.TAG
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "ircTypeKey="
            r3.append(r4)
            r3.append(r8)
            java.lang.String r4 = ",message="
            r3.append(r4)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            r4 = 0
            r2[r4] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r0, r2)
            if (r9 != 0) goto L_0x0028
            goto L_0x0294
        L_0x0028:
            if (r8 == 0) goto L_0x0294
            int r0 = r8.hashCode()
            r2 = 0
            java.lang.String r3 = "data"
            java.lang.String r5 = "pub"
            switch(r0) {
                case -1410657834: goto L_0x0217;
                case -509715525: goto L_0x0184;
                case -282904495: goto L_0x0106;
                case 276210240: goto L_0x009b;
                case 447681404: goto L_0x005a;
                case 1933319497: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0294
        L_0x0038:
            java.lang.String r0 = "allow_open_microphone"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0042
            goto L_0x0294
        L_0x0042:
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>(r9)
            org.json.JSONObject r8 = r8.getJSONObject(r3)
            boolean r8 = r8.optBoolean(r5)
            com.tal.app.thinkacademy.live.business.function.view.AbsFunctionPluginView<?> r9 = r7.functionPluginView
            if (r9 != 0) goto L_0x0055
            goto L_0x0294
        L_0x0055:
            r9.setTeacherMicAllow(r8)
            goto L_0x0294
        L_0x005a:
            java.lang.String r0 = "forbidden_student_emoji"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0064
            goto L_0x0294
        L_0x0064:
            java.lang.Class<com.tal.app.thinkacademy.live.business.function.bean.EmojiControlsData> r8 = com.tal.app.thinkacademy.live.business.function.bean.EmojiControlsData.class
            java.lang.Object r8 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson((java.lang.String) r9, r8)     // Catch:{ Exception -> 0x0097 }
            com.tal.app.thinkacademy.live.business.function.bean.EmojiControlsData r8 = (com.tal.app.thinkacademy.live.business.function.bean.EmojiControlsData) r8     // Catch:{ Exception -> 0x0097 }
            if (r8 != 0) goto L_0x0070
        L_0x006e:
            r8 = r4
            goto L_0x0082
        L_0x0070:
            com.tal.app.thinkacademy.live.business.function.bean.ForbiddenStudentEmoji r8 = r8.getForbiddenStudentEmoji()     // Catch:{ Exception -> 0x0097 }
            if (r8 != 0) goto L_0x0077
            goto L_0x006e
        L_0x0077:
            java.lang.Boolean r8 = r8.getPub()     // Catch:{ Exception -> 0x0097 }
            if (r8 != 0) goto L_0x007e
            goto L_0x006e
        L_0x007e:
            boolean r8 = r8.booleanValue()     // Catch:{ Exception -> 0x0097 }
        L_0x0082:
            r7.mEmojiPub = r8     // Catch:{ Exception -> 0x0097 }
            com.tal.app.thinkacademy.live.business.function.view.AbsFunctionPluginView<?> r8 = r7.functionPluginView     // Catch:{ Exception -> 0x0097 }
            if (r8 != 0) goto L_0x008a
            goto L_0x0294
        L_0x008a:
            boolean r9 = r7.mEmojiPub     // Catch:{ Exception -> 0x0097 }
            if (r9 != 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r1 = r4
        L_0x0090:
            r8.emojiControls(r1)     // Catch:{ Exception -> 0x0097 }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0097 }
            goto L_0x0294
        L_0x0097:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            goto L_0x0294
        L_0x009b:
            java.lang.String r0 = "all_audio_mute"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x00a5
            goto L_0x0294
        L_0x00a5:
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>(r9)
            org.json.JSONObject r8 = r8.getJSONObject(r3)
            boolean r8 = r8.optBoolean(r5)
            java.lang.String r9 = r7.TAG
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r8)
            java.lang.String r5 = "收到全员静音消息，是否静音 = "
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r3)
            r0[r4] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r9, r0)
            if (r8 == 0) goto L_0x00d2
            boolean r9 = r7.isVideoLinking
            if (r9 == 0) goto L_0x00cc
            return
        L_0x00cc:
            r8 = r8 ^ r1
            r7.controlLocalAudio(r8)
            goto L_0x0294
        L_0x00d2:
            com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel r8 = r7.mRtcViewModel
            if (r8 != 0) goto L_0x00d8
        L_0x00d6:
            r8 = r4
            goto L_0x00df
        L_0x00d8:
            boolean r8 = r8.getMLocalAudioEnable()
            if (r8 != r1) goto L_0x00d6
            r8 = r1
        L_0x00df:
            if (r8 != 0) goto L_0x00f9
            com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel r8 = r7.mAllOnStageViewModel
            if (r8 != 0) goto L_0x00e7
            goto L_0x0294
        L_0x00e7:
            com.tal.app.thinkacademy.live.abilitypack.allonstage.Type r9 = com.tal.app.thinkacademy.live.abilitypack.allonstage.Type.RECORD
            boolean r9 = r8.dispatchPermissionOpenControl(r9)
            if (r9 != 0) goto L_0x00f0
            r2 = r8
        L_0x00f0:
            if (r2 != 0) goto L_0x00f4
            goto L_0x0294
        L_0x00f4:
            r7.openMicNowAndNoUi()
            goto L_0x0294
        L_0x00f9:
            java.lang.String r8 = r7.TAG
            java.lang.Object[] r9 = new java.lang.Object[r1]
            java.lang.String r0 = "2收到用户静音消息，麦克风已经打开，不需要提醒"
            r9[r4] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r8, r9)
            goto L_0x0294
        L_0x0106:
            java.lang.String r0 = "user_video_mute"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0110
            goto L_0x0294
        L_0x0110:
            java.lang.String r8 = r7.TAG     // Catch:{ Exception -> 0x016d }
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x016d }
            java.lang.String r6 = "USER_VIDEO_MUTE start"
            r0[r4] = r6     // Catch:{ Exception -> 0x016d }
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r8, r0)     // Catch:{ Exception -> 0x016d }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x016d }
            r8.<init>(r9)     // Catch:{ Exception -> 0x016d }
            org.json.JSONObject r8 = r8.optJSONObject(r3)     // Catch:{ Exception -> 0x016d }
            if (r8 != 0) goto L_0x0128
            goto L_0x0294
        L_0x0128:
            boolean r9 = r8.has(r5)     // Catch:{ Exception -> 0x016d }
            if (r9 == 0) goto L_0x0169
            boolean r8 = r8.optBoolean(r5)     // Catch:{ Exception -> 0x016d }
            java.lang.String r9 = r7.TAG     // Catch:{ Exception -> 0x016d }
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x016d }
            java.lang.String r3 = "USER_VIDEO_MUTE pub="
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r8)     // Catch:{ Exception -> 0x016d }
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r5)     // Catch:{ Exception -> 0x016d }
            r0[r4] = r3     // Catch:{ Exception -> 0x016d }
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r9, r0)     // Catch:{ Exception -> 0x016d }
            if (r8 == 0) goto L_0x0150
            if (r8 != 0) goto L_0x014b
            r8 = r1
            goto L_0x014c
        L_0x014b:
            r8 = r4
        L_0x014c:
            r7.controlLocalVideo(r8)     // Catch:{ Exception -> 0x016d }
            goto L_0x0169
        L_0x0150:
            com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel r8 = r7.mAllOnStageViewModel     // Catch:{ Exception -> 0x016d }
            if (r8 != 0) goto L_0x0155
            goto L_0x0169
        L_0x0155:
            com.tal.app.thinkacademy.live.abilitypack.allonstage.Type r9 = com.tal.app.thinkacademy.live.abilitypack.allonstage.Type.CAMERA     // Catch:{ Exception -> 0x016d }
            boolean r9 = r8.dispatchPermissionOpenControl(r9)     // Catch:{ Exception -> 0x016d }
            if (r9 != 0) goto L_0x015e
            r2 = r8
        L_0x015e:
            if (r2 != 0) goto L_0x0161
            goto L_0x0169
        L_0x0161:
            com.tal.app.thinkacademy.live.business.function.view.AbsFunctionPluginView<?> r8 = r7.functionPluginView     // Catch:{ Exception -> 0x016d }
            if (r8 != 0) goto L_0x0166
            goto L_0x0169
        L_0x0166:
            r8.showOpenCameraPopUpWindow()     // Catch:{ Exception -> 0x016d }
        L_0x0169:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x016d }
            goto L_0x0294
        L_0x016d:
            r8 = move-exception
            java.lang.String r9 = r7.TAG
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "USER_VIDEO_MUTE error="
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r8)
            r0[r4] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r9, r0)
            r8.printStackTrace()
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            goto L_0x0294
        L_0x0184:
            java.lang.String r0 = "forbid_mute_audio"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x018e
            goto L_0x0294
        L_0x018e:
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x0203 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x0203 }
            org.json.JSONObject r8 = r8.getJSONObject(r3)     // Catch:{ Exception -> 0x0203 }
            int r8 = r8.optInt(r5)     // Catch:{ Exception -> 0x0203 }
            if (r8 != r1) goto L_0x019f
            r8 = r1
            goto L_0x01a0
        L_0x019f:
            r8 = r4
        L_0x01a0:
            java.lang.String r9 = r7.TAG     // Catch:{ Exception -> 0x0203 }
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0203 }
            java.lang.String r2 = "收到消息：强制开启麦克风,同时禁止关闭麦克风,pub="
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r8)     // Catch:{ Exception -> 0x0203 }
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)     // Catch:{ Exception -> 0x0203 }
            r0[r4] = r2     // Catch:{ Exception -> 0x0203 }
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r9, r0)     // Catch:{ Exception -> 0x0203 }
            com.tal.app.thinkacademy.live.business.function.view.AbsFunctionPluginView<?> r9 = r7.functionPluginView     // Catch:{ Exception -> 0x0203 }
            if (r9 != 0) goto L_0x01b8
            goto L_0x01bb
        L_0x01b8:
            r9.setMIsTeacherForbidMuteMic(r8)     // Catch:{ Exception -> 0x0203 }
        L_0x01bb:
            if (r8 == 0) goto L_0x01e7
            java.lang.String r8 = "android.permission.RECORD_AUDIO"
            java.lang.String[] r8 = new java.lang.String[]{r8}     // Catch:{ Exception -> 0x0203 }
            boolean r8 = com.tal.app.thinkacademy.lib.util.PermissionUtils.isGranted((java.lang.String[]) r8)     // Catch:{ Exception -> 0x0203 }
            if (r8 != 0) goto L_0x01d5
            java.lang.String r8 = r7.TAG     // Catch:{ Exception -> 0x0203 }
            java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0203 }
            java.lang.String r0 = "收到消息：强制开启麦克风:没有权限，啥都不做"
            r9[r4] = r0     // Catch:{ Exception -> 0x0203 }
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r8, r9)     // Catch:{ Exception -> 0x0203 }
            goto L_0x01e3
        L_0x01d5:
            r7.controlLocalAudio(r1)     // Catch:{ Exception -> 0x0203 }
            java.lang.String r8 = r7.TAG     // Catch:{ Exception -> 0x0203 }
            java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0203 }
            java.lang.String r0 = "收到消息：强制开启麦克风，有权限，直接打开"
            r9[r4] = r0     // Catch:{ Exception -> 0x0203 }
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r8, r9)     // Catch:{ Exception -> 0x0203 }
        L_0x01e3:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0203 }
            goto L_0x0294
        L_0x01e7:
            java.lang.String r8 = r7.TAG     // Catch:{ Exception -> 0x0203 }
            java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0203 }
            java.lang.String r0 = "收到消息：强制开启麦克风，pub==false，不操作"
            r9[r4] = r0     // Catch:{ Exception -> 0x0203 }
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r8, r9)     // Catch:{ Exception -> 0x0203 }
            com.tal.app.thinkacademy.live.business.function.view.AbsFunctionPluginView<?> r8 = r7.functionPluginView     // Catch:{ Exception -> 0x0203 }
            if (r8 != 0) goto L_0x01f8
            goto L_0x0294
        L_0x01f8:
            boolean r9 = r8.isMicOff()     // Catch:{ Exception -> 0x0203 }
            r8.muteMic(r9)     // Catch:{ Exception -> 0x0203 }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0203 }
            goto L_0x0294
        L_0x0203:
            r8 = move-exception
            java.lang.String r9 = r7.TAG
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "收到消息:强制开启麦克风，同时禁止关闭麦克风，出错!!!,error="
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r8)
            r0[r4] = r8
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r9, r0)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            goto L_0x0294
        L_0x0217:
            java.lang.String r0 = "user_audio_mute"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0221
            goto L_0x0294
        L_0x0221:
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x0282 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x0282 }
            org.json.JSONObject r8 = r8.getJSONObject(r3)     // Catch:{ Exception -> 0x0282 }
            boolean r8 = r8.optBoolean(r5)     // Catch:{ Exception -> 0x0282 }
            java.lang.String r9 = r7.TAG     // Catch:{ Exception -> 0x0282 }
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0282 }
            java.lang.String r3 = "收到用户静音消息，是否静音 = "
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r8)     // Catch:{ Exception -> 0x0282 }
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r5)     // Catch:{ Exception -> 0x0282 }
            r0[r4] = r3     // Catch:{ Exception -> 0x0282 }
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r9, r0)     // Catch:{ Exception -> 0x0282 }
            if (r8 == 0) goto L_0x024e
            if (r8 != 0) goto L_0x0247
            r8 = r1
            goto L_0x0248
        L_0x0247:
            r8 = r4
        L_0x0248:
            r7.controlLocalAudio(r8)     // Catch:{ Exception -> 0x0282 }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0282 }
            goto L_0x0294
        L_0x024e:
            com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel r8 = r7.mRtcViewModel     // Catch:{ Exception -> 0x0282 }
            if (r8 != 0) goto L_0x0254
        L_0x0252:
            r8 = r4
            goto L_0x025b
        L_0x0254:
            boolean r8 = r8.getMLocalAudioEnable()     // Catch:{ Exception -> 0x0282 }
            if (r8 != r1) goto L_0x0252
            r8 = r1
        L_0x025b:
            if (r8 != 0) goto L_0x0274
            com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel r8 = r7.mAllOnStageViewModel     // Catch:{ Exception -> 0x0282 }
            if (r8 != 0) goto L_0x0262
            goto L_0x0294
        L_0x0262:
            com.tal.app.thinkacademy.live.abilitypack.allonstage.Type r9 = com.tal.app.thinkacademy.live.abilitypack.allonstage.Type.RECORD     // Catch:{ Exception -> 0x0282 }
            boolean r9 = r8.dispatchPermissionOpenControl(r9)     // Catch:{ Exception -> 0x0282 }
            if (r9 != 0) goto L_0x026b
            r2 = r8
        L_0x026b:
            if (r2 != 0) goto L_0x026e
            goto L_0x0294
        L_0x026e:
            r7.openMicNowAndNoUi()     // Catch:{ Exception -> 0x0282 }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0282 }
            goto L_0x0294
        L_0x0274:
            java.lang.String r8 = r7.TAG     // Catch:{ Exception -> 0x0282 }
            java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0282 }
            java.lang.String r0 = "1收到用户静音消息，麦克风已经打开，不需要提醒"
            r9[r4] = r0     // Catch:{ Exception -> 0x0282 }
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r8, r9)     // Catch:{ Exception -> 0x0282 }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0282 }
            goto L_0x0294
        L_0x0282:
            r8 = move-exception
            java.lang.String r9 = r7.TAG
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "收到用户静音消息出错 = "
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r8)
            r0[r4] = r8
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r9, r0)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
        L_0x0294:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver.onMessage(java.lang.String, java.lang.String):void");
    }

    public final void switchChatBox(boolean z) {
        if (z) {
            ChatBoxViewModel chatBoxViewModel = this.mChatBoxViewModel;
            if (chatBoxViewModel != null) {
                chatBoxViewModel.openChatBox();
                return;
            }
            return;
        }
        ChatBoxViewModel chatBoxViewModel2 = this.mChatBoxViewModel;
        if (chatBoxViewModel2 != null) {
            chatBoxViewModel2.closeChatBox();
        }
    }

    public void onDestroy() {
        ListenerData<ChatBoxListenerBody> mListenerBody;
        ListenerData<AllOnStageListenerBody> mListenerBody2;
        ListenerData<RtcPlayerListenerBody> mRtcPlayerListener;
        PluginEventBus.unregister(DataBusKey.VIDEO_CALL_STATUS, this.observerVideoCall);
        PluginEventBus.unregister(DataBusKey.VIDEO_CALL_F_STATUS, this.observerTutorVideoCall);
        PluginEventBus.unregister(DataBusKey.FUNCTION_SHOW_PERMISSION_DIALOG, this.observerPermission);
        PluginEventBus.unregister(DataBusKey.GROUP_VIDEO_CALL_STUDENT_START, this.observerGroupStart);
        PluginEventBus.unregister(DataBusKey.GROUP_VIDEO_CALL_STUDENT_END, this.observerGroupEnd);
        PluginEventBus.unregister(DataBusKey.CLASS_FEEDBACK, this.observerFeedback);
        PluginEventBus.unregister(DataBusKey.USER_MUTE_VIDEO_KEY, this.mObserverCamera);
        XesDataBus.with(DataBusKey.WEB_DISMISS_VIEW).removeObservers((LifecycleOwner) this);
        PluginEventBus.unregister(DataBusKey.TEACHER_DRIVER_PRIVATE_CHAT, this.mTeacherPrivateOnStageObserver);
        RtcViewModel rtcViewModel = this.mRtcViewModel;
        if (!(rtcViewModel == null || (mRtcPlayerListener = rtcViewModel.getMRtcPlayerListener()) == null)) {
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            mRtcPlayerListener.removeListener(simpleName);
        }
        AllOnStageViewModel allOnStageViewModel = this.mAllOnStageViewModel;
        if (!(allOnStageViewModel == null || (mListenerBody2 = allOnStageViewModel.getMListenerBody()) == null)) {
            String simpleName2 = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName2, "javaClass.simpleName");
            mListenerBody2.removeListener(simpleName2);
        }
        ChatBoxViewModel chatBoxViewModel = this.mChatBoxViewModel;
        if (!(chatBoxViewModel == null || (mListenerBody = chatBoxViewModel.getMListenerBody()) == null)) {
            String simpleName3 = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName3, "javaClass.simpleName");
            mListenerBody.removeListener(simpleName3);
        }
        PluginEventBus.unregister(DataBusKey.CHAT_BOX_FUNCTION_KEY, this.observerChatBox);
        AbsFunctionPluginView<?> absFunctionPluginView = this.functionPluginView;
        if (absFunctionPluginView != null) {
            absFunctionPluginView.onDestroy();
        }
        EmojiTipsView emojiTipsView = this.mEmojiTipsView;
        if (emojiTipsView != null) {
            emojiTipsView.destroy();
        }
    }

    private final void openMicNowAndNoUi() {
        XesLog.dt("功能区", "openMicNowAndNoUi 开始，直接打开麦克风");
        if (!PermissionUtils.isGranted("android.permission.RECORD_AUDIO")) {
            XesLog.dt("功能区", "openMicNowAndNoUi 直接打开麦克风，没有麦克风权限，开始展示权限弹窗");
            showPermissionWindow(true);
            return;
        }
        XesLog.dt("功能区", "openMicNowAndNoUi 直接打开麦克风");
        controlLocalAudio(true);
    }
}
