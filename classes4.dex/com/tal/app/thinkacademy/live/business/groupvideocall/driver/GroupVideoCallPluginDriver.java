package com.tal.app.thinkacademy.live.business.groupvideocall.driver;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.eaydu.omni.RTCEngine;
import com.google.gson.internal.LinkedTreeMap;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.lib.player.rtcplayer.IRTCEngineProvider;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineProviderUtils;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayerEngineEventListener;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModelKt;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.groupvideocall.GroupVideoCallBean;
import com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean;
import com.tal.app.thinkacademy.live.business.groupvideocall.bean.GroupStudentInfo;
import com.tal.app.thinkacademy.live.business.groupvideocall.view.GroupVideoCallSmallView;
import com.tal.app.thinkacademy.live.business.groupvideocall.view.GroupVideoCallView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.interfaces.IircControllerProvider;
import com.tal.app.thinkacademy.live.core.irc.entity.MsgBean;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.RtcConfig;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import org.json.JSONObject;

@PluginAnnotation(desc = "多人上台", ircType = {"mult_video_mic", "send_emoji", "animation_emoji"}, launchType = "delay", moduleId = "111")
@ViewLevels({@ViewLevel(level = 40, name = "GroupVideoCall")})
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b%\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001aH\u0002J$\u0010H\u001a\u00020F2\u001a\u0010I\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001bH\u0002J\u0012\u0010J\u001a\u0004\u0018\u00010\u001e2\u0006\u0010K\u001a\u000208H\u0002J\b\u0010L\u001a\u00020FH\u0002J\u0012\u0010M\u001a\u0004\u0018\u0001092\u0006\u0010K\u001a\u000208H\u0002J\b\u0010N\u001a\u00020FH\u0002J\u0016\u0010O\u001a\u00020F2\u0006\u0010P\u001a\u00020\n2\u0006\u0010Q\u001a\u00020 J\b\u0010R\u001a\u00020FH\u0002J\b\u0010S\u001a\u00020FH\u0016J\u001c\u0010T\u001a\u00020F2\b\u0010U\u001a\u0004\u0018\u00010\u00102\b\u0010V\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010W\u001a\u00020F2\u0006\u0010K\u001a\u000208H\u0002J\u0010\u0010X\u001a\u00020F2\u0006\u0010K\u001a\u000208H\u0002J\u0018\u0010Y\u001a\u00020F2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010Z\u001a\u00020\nH\u0002J\u0012\u0010[\u001a\u00020F2\b\b\u0002\u0010\\\u001a\u00020\nH\u0002J\u0018\u0010]\u001a\u00020F2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\u0010H\u0002J\u0010\u0010_\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001aH\u0002J\u0010\u0010`\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001aH\u0002J\b\u0010a\u001a\u00020FH\u0002J\b\u0010b\u001a\u00020FH\u0002J\u0010\u0010c\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001aH\u0002J.\u0010d\u001a\u00020F2\u001a\u0010I\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b2\b\b\u0002\u0010e\u001a\u00020\nH\u0002J\u0016\u0010f\u001a\u00020F2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010g\u001a\u00020\fJ\u0016\u0010h\u001a\u00020F2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010i\u001a\u00020\fJ\u000e\u0010j\u001a\u00020F2\u0006\u0010E\u001a\u00020\fR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R*\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001a0'j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001a`(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R*\u00106\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001a0'j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001a`(X\u000e¢\u0006\u0002\n\u0000R.\u00107\u001a\"\u0012\u0004\u0012\u000208\u0012\u0006\u0012\u0004\u0018\u0001090'j\u0010\u0012\u0004\u0012\u000208\u0012\u0006\u0012\u0004\u0018\u000109`(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020?0>X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020?0>X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020?0>X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020?0>X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020?0>X\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/groupvideocall/driver/GroupVideoCallPluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "isInteractStart", "", "isMuteAudio", "", "isMuteVideo", "isOnDestroy", "keyTag", "", "mClassType", "mContext", "Landroid/content/Context;", "mCourseInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/CourseInfoProxy;", "mCourseRate", "Lcom/tal/app/thinkacademy/live/core/layout/LiveAreaCompat$CourseRate;", "mData", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/live/business/groupvideocall/VideoCallBean;", "Lkotlin/collections/ArrayList;", "mGraffitiUseCourseRate", "mGroupStudentList", "Lcom/tal/app/thinkacademy/live/business/groupvideocall/bean/GroupStudentInfo;", "mGroupVideoCallBean", "Lcom/tal/app/thinkacademy/live/business/groupvideocall/GroupVideoCallBean;", "mGroupVideoCallView", "Lcom/tal/app/thinkacademy/live/business/groupvideocall/view/GroupVideoCallView;", "mIpadTeacherId", "mIrcControllerProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/IircControllerProvider;", "mLocalStudent", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "mPcTeacherId", "mProvider", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/IRTCEngineProvider;", "mRTCEngineCallback", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/IRTCEngineProvider$RTCEngineCallback;", "mRtcConfig", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/RtcConfig;", "mRtcEngine", "Lcom/eaydu/omni/RTCEngine;", "mRtcPlayerEngineEventListener", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayerEngineEventListener;", "mRtcViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel;", "mServerStudent", "mSurfaceViewMap", "", "Landroid/view/TextureView;", "mUserId", "mUserInfoProxy", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;", "observerAudioMuteStatus", "Landroidx/lifecycle/Observer;", "Lcom/tal/app/thinkacademy/live/core/plugin/PluginEventData;", "observerEmoji", "observerHandup", "observerOtherUserLevel", "observerUserLevel", "observerVideoMuteStatus", "addCoin", "", "student", "authPen", "data", "findStudent", "uid", "getGroupStudentList", "getStudentSurfaceView", "initEngine", "interactiveBegan", "abnormalReturn", "bean", "interactiveClosed", "onDestroy", "onMessage", "ircTypeKey", "message", "playingAudioStart", "playingAudioStop", "remotefirstVideoRecvWithUid", "isShow", "requestMicro", "isStart", "showFace", "emojiString", "singleStage", "singleStep", "singleStepAll", "stageOperation", "studentSliding", "updateAllLocation", "isJudgeLocation", "updateLevel", "level", "updateMic", "volume", "updateUserCoins", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GroupVideoCallPluginDriver.kt */
public final class GroupVideoCallPluginDriver extends BaseLivePluginDriver {
    /* access modifiers changed from: private */
    public final Tag TAG;
    private boolean isInteractStart;
    /* access modifiers changed from: private */
    public int isMuteAudio;
    private int isMuteVideo;
    private boolean isOnDestroy;
    private final String keyTag = "GroupVideoCallPluginDriver";
    private String mClassType;
    private Context mContext;
    /* access modifiers changed from: private */
    public CourseInfoProxy mCourseInfo;
    private LiveAreaCompat.CourseRate mCourseRate;
    private ArrayList<VideoCallBean> mData;
    private boolean mGraffitiUseCourseRate;
    /* access modifiers changed from: private */
    public ArrayList<GroupStudentInfo> mGroupStudentList;
    private GroupVideoCallBean mGroupVideoCallBean;
    private GroupVideoCallView mGroupVideoCallView;
    /* access modifiers changed from: private */
    public String mIpadTeacherId;
    private IircControllerProvider mIrcControllerProvider;
    /* access modifiers changed from: private */
    public LinkedHashMap<String, VideoCallBean> mLocalStudent;
    /* access modifiers changed from: private */
    public String mPcTeacherId;
    private IRTCEngineProvider mProvider;
    private IRTCEngineProvider.RTCEngineCallback mRTCEngineCallback;
    private RtcConfig mRtcConfig;
    /* access modifiers changed from: private */
    public RTCEngine mRtcEngine;
    private RtcPlayerEngineEventListener mRtcPlayerEngineEventListener;
    private RtcViewModel mRtcViewModel;
    private LinkedHashMap<String, VideoCallBean> mServerStudent;
    private LinkedHashMap<Long, TextureView> mSurfaceViewMap;
    /* access modifiers changed from: private */
    public String mUserId;
    private UserInfoProxy mUserInfoProxy;
    private Observer<PluginEventData> observerAudioMuteStatus;
    private Observer<PluginEventData> observerEmoji;
    private Observer<PluginEventData> observerHandup;
    private Observer<PluginEventData> observerOtherUserLevel;
    private Observer<PluginEventData> observerUserLevel;
    private Observer<PluginEventData> observerVideoMuteStatus;

    public GroupVideoCallPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        String teacherAudioUid;
        String teacherUid;
        Tag tag = Tag.GroupVideoCallPluginDriver;
        this.TAG = tag;
        String str = EnterRoomMuteData.STATUS_UN_MUTE;
        this.mClassType = str;
        this.mUserId = str;
        this.mIpadTeacherId = str;
        this.mPcTeacherId = str;
        this.mLocalStudent = new LinkedHashMap<>();
        this.mServerStudent = new LinkedHashMap<>();
        this.mSurfaceViewMap = new LinkedHashMap<>();
        this.isMuteVideo = 1;
        int i = 2;
        this.isMuteAudio = 2;
        this.mCourseRate = LiveAreaCompat.CourseRate.RATE_4_3;
        this.observerHandup = new GroupVideoCallPluginDriver$$ExternalSyntheticLambda5(this);
        this.observerVideoMuteStatus = new GroupVideoCallPluginDriver$$ExternalSyntheticLambda1(this);
        this.observerAudioMuteStatus = new GroupVideoCallPluginDriver$$ExternalSyntheticLambda6(this);
        this.observerUserLevel = new GroupVideoCallPluginDriver$$ExternalSyntheticLambda2(this);
        this.observerOtherUserLevel = new GroupVideoCallPluginDriver$$ExternalSyntheticLambda3(this);
        this.observerEmoji = new GroupVideoCallPluginDriver$$ExternalSyntheticLambda4(this);
        if (iLiveRoomProvider != null) {
            WeakReference<Context> weakRefContext = iLiveRoomProvider.getWeakRefContext();
            LiveAreaCompat.CourseRate courseRate = null;
            this.mContext = weakRefContext == null ? null : (Context) weakRefContext.get();
            this.mUserInfoProxy = iLiveRoomProvider.getDataStorage().getUserInfo();
            this.mCourseInfo = iLiveRoomProvider.getDataStorage().getCourseInfo();
            String classType = iLiveRoomProvider.getClassType();
            Intrinsics.checkNotNullExpressionValue(classType, "mLiveRoomProvider.classType");
            this.mClassType = classType;
            this.mUserId = iLiveRoomProvider.getDataStorage().getUserInfo().getId().toString();
            RtcConfig rtcConfig = iLiveRoomProvider.getDataStorage().getEnterConfig().getRtcConfig();
            this.mRtcConfig = rtcConfig;
            this.mPcTeacherId = (rtcConfig == null || (teacherUid = rtcConfig.getTeacherUid()) == null) ? str : teacherUid;
            RtcConfig rtcConfig2 = this.mRtcConfig;
            if (!(rtcConfig2 == null || (teacherAudioUid = rtcConfig2.getTeacherAudioUid()) == null)) {
                str = teacherAudioUid;
            }
            this.mIpadTeacherId = str;
            RoomData roomData = iLiveRoomProvider.getDataStorage().getRoomData();
            courseRate = roomData != null ? roomData.getCourseRate() : courseRate;
            this.mCourseRate = courseRate == null ? LiveAreaCompat.CourseRate.RATE_4_3 : courseRate;
            RoomData roomData2 = iLiveRoomProvider.getDataStorage().getRoomData();
            this.mGraffitiUseCourseRate = roomData2 == null ? false : roomData2.getGraffitiUseCourseRate();
        }
        this.mRtcViewModel = RtcViewModelKt.getRtcViewModel(AbilityPackKt.getAbilityPack());
        initEngine();
        RtcViewModel rtcViewModel = this.mRtcViewModel;
        this.isMuteVideo = rtcViewModel != null && rtcViewModel.getMLocalVideoEnable() ? 1 : 2;
        RtcViewModel rtcViewModel2 = this.mRtcViewModel;
        this.isMuteAudio = rtcViewModel2 != null && rtcViewModel2.getMLocalAudioEnable() ? 1 : i;
        requestMicro(true);
        XesLog.i(tag, "init --> isMuteVideo=" + this.isMuteVideo + " -- isMuteAudio=" + this.isMuteAudio);
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        PluginEventBus.register(lifecycleOwner, DataBusKey.USER_MUTE_VIDEO_KEY, this.observerVideoMuteStatus);
        PluginEventBus.registerStickyForever(lifecycleOwner, DataBusKey.USER_MUTE_MIC_KEY, this.observerAudioMuteStatus);
        getGroupStudentList();
    }

    /* access modifiers changed from: private */
    /* renamed from: observerHandup$lambda-0  reason: not valid java name */
    public static final void m261observerHandup$lambda0(GroupVideoCallPluginDriver groupVideoCallPluginDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(groupVideoCallPluginDriver, "this$0");
        PluginEventBus.onEvent(DataBusKey.GROUP_VIDEO_CALL_STUDENT_HAND_UP, new PluginEventData(GroupVideoCallPluginDriver.class, DataBusKey.GROUP_VIDEO_CALL_STUDENT_HAND_UP, "2"));
        requestMicro$default(groupVideoCallPluginDriver, false, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: observerVideoMuteStatus$lambda-1  reason: not valid java name */
    public static final void m264observerVideoMuteStatus$lambda1(GroupVideoCallPluginDriver groupVideoCallPluginDriver, PluginEventData pluginEventData) {
        RTCEngine rTCEngine;
        Intrinsics.checkNotNullParameter(groupVideoCallPluginDriver, "this$0");
        groupVideoCallPluginDriver.isMuteVideo = Intrinsics.areEqual("1", pluginEventData.getData()) ? 1 : 2;
        XesLog.i(groupVideoCallPluginDriver.TAG, "observerVideoMuteStatus --> isMuteVideo=" + groupVideoCallPluginDriver.isMuteVideo + " -- isMuteAudio=" + groupVideoCallPluginDriver.isMuteAudio);
        if (groupVideoCallPluginDriver.isInteractStart) {
            groupVideoCallPluginDriver.requestMicro(true);
            CharSequence charSequence = groupVideoCallPluginDriver.mUserId;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                return;
            }
            if (groupVideoCallPluginDriver.isMuteVideo == 1) {
                LinkedHashMap<String, VideoCallBean> linkedHashMap = groupVideoCallPluginDriver.mLocalStudent;
                if ((linkedHashMap == null ? null : Boolean.valueOf(linkedHashMap.containsKey(groupVideoCallPluginDriver.mUserId))).booleanValue() && (rTCEngine = groupVideoCallPluginDriver.mRtcEngine) != null) {
                    rTCEngine.setupLocalVideo(groupVideoCallPluginDriver.getStudentSurfaceView(Long.parseLong(groupVideoCallPluginDriver.mUserId)));
                }
                groupVideoCallPluginDriver.remotefirstVideoRecvWithUid(groupVideoCallPluginDriver.mUserId, true);
                return;
            }
            groupVideoCallPluginDriver.remotefirstVideoRecvWithUid(groupVideoCallPluginDriver.mUserId, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observerAudioMuteStatus$lambda-2  reason: not valid java name */
    public static final void m259observerAudioMuteStatus$lambda2(GroupVideoCallPluginDriver groupVideoCallPluginDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(groupVideoCallPluginDriver, "this$0");
        String data = pluginEventData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "pluginEventData.data");
        groupVideoCallPluginDriver.isMuteAudio = Integer.parseInt(data);
        XesLog.i(groupVideoCallPluginDriver.TAG, "observerAudioMuteStatus --> isMuteVideo=" + groupVideoCallPluginDriver.isMuteVideo + " -- isMuteAudio=" + groupVideoCallPluginDriver.isMuteAudio);
        groupVideoCallPluginDriver.requestMicro(true);
        if (!groupVideoCallPluginDriver.isInteractStart) {
            return;
        }
        if (groupVideoCallPluginDriver.isMuteAudio != 1) {
            groupVideoCallPluginDriver.updateMic(groupVideoCallPluginDriver.mUserId, -1);
        } else {
            groupVideoCallPluginDriver.updateMic(groupVideoCallPluginDriver.mUserId, 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observerUserLevel$lambda-3  reason: not valid java name */
    public static final void m263observerUserLevel$lambda3(GroupVideoCallPluginDriver groupVideoCallPluginDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(groupVideoCallPluginDriver, "this$0");
        String str = groupVideoCallPluginDriver.mUserId;
        String data = pluginEventData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "pluginEventData.data");
        groupVideoCallPluginDriver.updateLevel(str, Integer.parseInt(data));
    }

    /* access modifiers changed from: private */
    /* renamed from: observerOtherUserLevel$lambda-4  reason: not valid java name */
    public static final void m262observerOtherUserLevel$lambda4(GroupVideoCallPluginDriver groupVideoCallPluginDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(groupVideoCallPluginDriver, "this$0");
        JSONObject jSONObject = new JSONObject(pluginEventData.getData());
        String optString = jSONObject.optString("userId");
        Intrinsics.checkNotNullExpressionValue(optString, "jSONObject.optString(\"userId\")");
        String optString2 = jSONObject.optString("level");
        Intrinsics.checkNotNullExpressionValue(optString2, "jSONObject.optString(\"level\")");
        groupVideoCallPluginDriver.updateLevel(optString, Integer.parseInt(optString2));
    }

    /* access modifiers changed from: private */
    /* renamed from: observerEmoji$lambda-5  reason: not valid java name */
    public static final void m260observerEmoji$lambda5(GroupVideoCallPluginDriver groupVideoCallPluginDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(groupVideoCallPluginDriver, "this$0");
        String str = groupVideoCallPluginDriver.mUserId;
        String data = pluginEventData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "pluginEventData.data");
        groupVideoCallPluginDriver.showFace(str, data);
    }

    private final void initEngine() {
        this.mProvider = RTCEngineProviderUtils.getInstance().get("Live");
        this.mRTCEngineCallback = new GroupVideoCallPluginDriver$initEngine$1(this);
        this.mRtcPlayerEngineEventListener = new GroupVideoCallPluginDriver$initEngine$2(this);
        IRTCEngineProvider iRTCEngineProvider = this.mProvider;
        if (iRTCEngineProvider != null) {
            iRTCEngineProvider.provide(GroupVideoCallPluginDriverKt.GroupVideoCallPluginKey, this.mRTCEngineCallback);
        }
    }

    public void onMessage(String str, String str2) {
        if (!this.isOnDestroy) {
            CharSequence charSequence = str2;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                XesLog.i(this.TAG, Intrinsics.stringPlus("ircTypeKey --> ", str2));
                if (str != null) {
                    int hashCode = str.hashCode();
                    if (hashCode != -1925166133) {
                        if (hashCode != -627260364) {
                            if (hashCode != 814542031 || !str.equals(DataBusKey.SEND_EMOJI)) {
                                return;
                            }
                        } else if (str.equals("mult_video_mic")) {
                            try {
                                Intrinsics.checkNotNull(str2);
                                JSONObject optJSONObject = new JSONObject(str2).optJSONObject(str);
                                if (optJSONObject != null) {
                                    GroupVideoCallBean groupVideoCallBean = (GroupVideoCallBean) GsonUtils.fromJson(!(optJSONObject instanceof JSONObject) ? optJSONObject.toString() : JSONObjectInstrumentation.toString(optJSONObject), GroupVideoCallBean.class);
                                    this.mGroupVideoCallBean = groupVideoCallBean;
                                    if (groupVideoCallBean != null) {
                                        if (Intrinsics.areEqual(groupVideoCallBean.getPub(), true)) {
                                            stageOperation();
                                            return;
                                        } else {
                                            interactiveClosed();
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } catch (Exception e) {
                                XesLog.e(this.TAG, Intrinsics.stringPlus("mult_video_mic e --> ", e.getMessage()));
                                interactiveClosed();
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (!str.equals("animation_emoji")) {
                        return;
                    }
                    try {
                        MsgBean msgBean = (MsgBean) GsonUtils.fromJson(str2, MsgBean.class);
                        if (msgBean != null) {
                            Object data = msgBean.getData();
                            if (data != null) {
                                JSONObject jSONObject = new JSONObject((LinkedTreeMap) data);
                                String jSONObject2 = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
                                String userId = msgBean.getFrom().getUserId();
                                Intrinsics.checkNotNullExpressionValue(userId, "from.userId");
                                String json = GsonUtils.toJson((EmojiBean) GsonUtils.fromJson(jSONObject2, EmojiBean.class));
                                Intrinsics.checkNotNullExpressionValue(json, "toJson(bean)");
                                showFace(userId, json);
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.google.gson.internal.LinkedTreeMap<*, *>");
                        }
                    } catch (Exception e2) {
                        XesLog.e(this.TAG, Intrinsics.stringPlus("send_emoji e --> ", e2.getMessage()));
                    }
                }
            }
        }
    }

    private final void stageOperation() {
        GroupVideoCallView groupVideoCallView;
        this.isInteractStart = true;
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        PluginEventBus.register(lifecycleOwner, DataBusKey.CLASS_HANDUP, this.observerHandup);
        PluginEventBus.register(lifecycleOwner, DataBusKey.LEVEL_KEY, this.observerUserLevel);
        PluginEventBus.register(lifecycleOwner, DataBusKey.SHOW_OTHER_LEVEL_KEY, this.observerOtherUserLevel);
        PluginEventBus.register(lifecycleOwner, DataBusKey.SEND_EMOJI, this.observerEmoji);
        IRTCEngineProvider iRTCEngineProvider = this.mProvider;
        if (iRTCEngineProvider != null) {
            iRTCEngineProvider.addEtcEngineEventListener(this.keyTag, this.mRtcPlayerEngineEventListener);
        }
        PluginEventBus.onEvent(DataBusKey.GROUP_VIDEO_CALL_STATE, new PluginEventData(GroupVideoCallPluginDriver.class, DataBusKey.GROUP_VIDEO_CALL_STATE, "1"));
        GroupVideoCallBean groupVideoCallBean = this.mGroupVideoCallBean;
        if (groupVideoCallBean != null) {
            Context context = this.mContext;
            if (context == null) {
                Void voidR = null;
            } else if (this.mGroupVideoCallView == null) {
                if (LiveAreaCompat.isSmallPad() || LiveAreaCompat.isSmallPhone()) {
                    groupVideoCallView = new GroupVideoCallSmallView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                } else {
                    groupVideoCallView = new GroupVideoCallView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                }
                this.mGroupVideoCallView = groupVideoCallView;
                groupVideoCallView.layoutGroup(this.mCourseRate, this.mGraffitiUseCourseRate);
                this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.mGroupVideoCallView, this.mPluginConfData.getViewLevel("GroupVideoCall"), LiveAreaContext.get().getPptLp().newLp());
                LiveAreaContext.get().layoutObserver.observe(lifecycleOwner, new GroupVideoCallPluginDriver$$ExternalSyntheticLambda0(this));
                interactiveBegan(true, groupVideoCallBean);
                return;
            } else {
                interactiveBegan(false, groupVideoCallBean);
                return;
            }
        }
        interactiveClosed();
    }

    /* access modifiers changed from: private */
    /* renamed from: stageOperation$lambda-14$lambda-13$lambda-12  reason: not valid java name */
    public static final void m265stageOperation$lambda14$lambda13$lambda12(GroupVideoCallPluginDriver groupVideoCallPluginDriver, LiveAreaContext liveAreaContext) {
        ArrayList<VideoCallBean> arrayList;
        Intrinsics.checkNotNullParameter(groupVideoCallPluginDriver, "this$0");
        GroupVideoCallView groupVideoCallView = groupVideoCallPluginDriver.mGroupVideoCallView;
        if (groupVideoCallView != null) {
            ViewGroup.LayoutParams layoutParams = groupVideoCallView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            groupVideoCallView.setLayoutParams(liveAreaContext.getPptLp().mergeLp((FrameLayout.LayoutParams) layoutParams));
            groupVideoCallView.layoutGroup(groupVideoCallPluginDriver.mCourseRate, groupVideoCallPluginDriver.mGraffitiUseCourseRate);
            ArrayList<VideoCallBean> arrayList2 = groupVideoCallPluginDriver.mData;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            for (String str : groupVideoCallPluginDriver.mLocalStudent.keySet()) {
                VideoCallBean videoCallBean = groupVideoCallPluginDriver.mLocalStudent.get(str);
                if (!(videoCallBean == null || (arrayList = groupVideoCallPluginDriver.mData) == null)) {
                    arrayList.add(videoCallBean);
                }
            }
            groupVideoCallPluginDriver.updateAllLocation(groupVideoCallPluginDriver.mData, false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0203, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A[SYNTHETIC, Splitter:B:20:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void interactiveBegan(boolean r6, com.tal.app.thinkacademy.live.business.groupvideocall.GroupVideoCallBean r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "bean"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)     // Catch:{ all -> 0x0204 }
            com.tal.app.thinkacademy.live.Tag r0 = r5.TAG     // Catch:{ all -> 0x0204 }
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0     // Catch:{ all -> 0x0204 }
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = "interactiveBegan --> "
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r4)     // Catch:{ all -> 0x0204 }
            r4 = 0
            r2[r4] = r3     // Catch:{ all -> 0x0204 }
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r2)     // Catch:{ all -> 0x0204 }
            java.util.ArrayList r0 = r7.getData()     // Catch:{ all -> 0x0204 }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x0204 }
            if (r0 == 0) goto L_0x002e
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0204 }
            if (r0 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r0 = r4
            goto L_0x002f
        L_0x002e:
            r0 = r1
        L_0x002f:
            if (r0 == 0) goto L_0x0056
            r5.singleStepAll()     // Catch:{ all -> 0x0204 }
            java.lang.Integer r0 = r7.getStatus()     // Catch:{ all -> 0x0204 }
            if (r0 != 0) goto L_0x003b
            goto L_0x0056
        L_0x003b:
            int r0 = r0.intValue()     // Catch:{ all -> 0x0204 }
            if (r0 != r1) goto L_0x0056
            r5.requestMicro(r1)     // Catch:{ all -> 0x0204 }
            java.lang.String r6 = "group_video_call_student_hand_up"
            com.tal.app.thinkacademy.live.core.plugin.PluginEventData r7 = new com.tal.app.thinkacademy.live.core.plugin.PluginEventData     // Catch:{ all -> 0x0204 }
            java.lang.Class<com.tal.app.thinkacademy.live.business.groupvideocall.driver.GroupVideoCallPluginDriver> r0 = com.tal.app.thinkacademy.live.business.groupvideocall.driver.GroupVideoCallPluginDriver.class
            java.lang.String r1 = "group_video_call_student_hand_up"
            java.lang.String r2 = "1"
            r7.<init>(r0, r1, r2)     // Catch:{ all -> 0x0204 }
            com.tal.app.thinkacademy.live.core.plugin.PluginEventBus.onEvent(r6, r7)     // Catch:{ all -> 0x0204 }
            monitor-exit(r5)
            return
        L_0x0056:
            if (r6 == 0) goto L_0x009f
            java.util.LinkedHashMap<java.lang.String, com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean> r6 = r5.mLocalStudent     // Catch:{ all -> 0x0204 }
            r6.clear()     // Catch:{ all -> 0x0204 }
            r5.requestMicro(r1)     // Catch:{ all -> 0x0204 }
            java.util.ArrayList r6 = r7.getData()     // Catch:{ all -> 0x0204 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ all -> 0x0204 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0204 }
        L_0x006b:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0204 }
            if (r7 == 0) goto L_0x0202
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0204 }
            com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean r7 = (com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean) r7     // Catch:{ all -> 0x0204 }
            java.util.LinkedHashMap<java.lang.String, com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean> r0 = r5.mLocalStudent     // Catch:{ all -> 0x0204 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0204 }
            java.lang.String r1 = r7.getUserId()     // Catch:{ all -> 0x0204 }
            java.lang.String r2 = "newStudent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)     // Catch:{ all -> 0x0204 }
            r0.put(r1, r7)     // Catch:{ all -> 0x0204 }
            java.util.LinkedHashMap<java.lang.String, com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean> r0 = r5.mLocalStudent     // Catch:{ all -> 0x0204 }
            java.lang.String r7 = r7.getUserId()     // Catch:{ all -> 0x0204 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0204 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ all -> 0x0204 }
            java.lang.String r0 = "mLocalStudent[newStudent.userId]!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ all -> 0x0204 }
            com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean r7 = (com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean) r7     // Catch:{ all -> 0x0204 }
            r5.singleStage(r7)     // Catch:{ all -> 0x0204 }
            goto L_0x006b
        L_0x009f:
            java.lang.Integer r6 = r7.getStatus()     // Catch:{ all -> 0x0204 }
            r0 = 2
            if (r6 != 0) goto L_0x00a7
            goto L_0x00f8
        L_0x00a7:
            int r1 = r6.intValue()     // Catch:{ all -> 0x0204 }
            if (r1 != r0) goto L_0x00f8
            java.util.ArrayList r6 = r7.getData()     // Catch:{ all -> 0x0204 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ all -> 0x0204 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0204 }
        L_0x00b8:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0204 }
            if (r7 == 0) goto L_0x0202
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0204 }
            com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean r7 = (com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean) r7     // Catch:{ all -> 0x0204 }
            java.util.LinkedHashMap<java.lang.String, com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean> r0 = r5.mLocalStudent     // Catch:{ all -> 0x0204 }
            java.lang.String r1 = r7.getUserId()     // Catch:{ all -> 0x0204 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0204 }
            if (r0 != 0) goto L_0x00b8
            java.util.LinkedHashMap<java.lang.String, com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean> r0 = r5.mLocalStudent     // Catch:{ all -> 0x0204 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0204 }
            java.lang.String r1 = r7.getUserId()     // Catch:{ all -> 0x0204 }
            java.lang.String r2 = "newStudent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)     // Catch:{ all -> 0x0204 }
            r0.put(r1, r7)     // Catch:{ all -> 0x0204 }
            java.util.LinkedHashMap<java.lang.String, com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean> r0 = r5.mLocalStudent     // Catch:{ all -> 0x0204 }
            java.lang.String r7 = r7.getUserId()     // Catch:{ all -> 0x0204 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0204 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ all -> 0x0204 }
            java.lang.String r0 = "mLocalStudent[newStudent.userId]!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ all -> 0x0204 }
            com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean r7 = (com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean) r7     // Catch:{ all -> 0x0204 }
            r5.singleStage(r7)     // Catch:{ all -> 0x0204 }
            goto L_0x00b8
        L_0x00f8:
            r1 = 3
            if (r6 != 0) goto L_0x00fc
            goto L_0x016f
        L_0x00fc:
            int r2 = r6.intValue()     // Catch:{ all -> 0x0204 }
            if (r2 != r1) goto L_0x016f
            java.util.LinkedHashMap<java.lang.String, com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean> r6 = r5.mServerStudent     // Catch:{ all -> 0x0204 }
            r6.clear()     // Catch:{ all -> 0x0204 }
            java.util.ArrayList r6 = r7.getData()     // Catch:{ all -> 0x0204 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ all -> 0x0204 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0204 }
        L_0x0112:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0204 }
            if (r7 == 0) goto L_0x012f
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0204 }
            com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean r7 = (com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean) r7     // Catch:{ all -> 0x0204 }
            java.util.LinkedHashMap<java.lang.String, com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean> r0 = r5.mServerStudent     // Catch:{ all -> 0x0204 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0204 }
            java.lang.String r1 = r7.getUserId()     // Catch:{ all -> 0x0204 }
            java.lang.String r2 = "student"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)     // Catch:{ all -> 0x0204 }
            r0.put(r1, r7)     // Catch:{ all -> 0x0204 }
            goto L_0x0112
        L_0x012f:
            java.util.LinkedHashMap<java.lang.String, com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean> r6 = r5.mLocalStudent     // Catch:{ all -> 0x0204 }
            java.util.Set r6 = r6.entrySet()     // Catch:{ all -> 0x0204 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0204 }
        L_0x0139:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0204 }
            if (r7 == 0) goto L_0x0202
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0204 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ all -> 0x0204 }
            java.lang.Object r7 = r7.getKey()     // Catch:{ all -> 0x0204 }
            java.lang.String r0 = "iterator.next().key"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ all -> 0x0204 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0204 }
            java.util.LinkedHashMap<java.lang.String, com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean> r0 = r5.mServerStudent     // Catch:{ all -> 0x0204 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x0204 }
            if (r0 != 0) goto L_0x0139
            java.util.LinkedHashMap<java.lang.String, com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean> r0 = r5.mLocalStudent     // Catch:{ all -> 0x0204 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0204 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ all -> 0x0204 }
            java.lang.String r0 = "mLocalStudent[userId]!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch:{ all -> 0x0204 }
            com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean r7 = (com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean) r7     // Catch:{ all -> 0x0204 }
            r5.singleStep(r7)     // Catch:{ all -> 0x0204 }
            r6.remove()     // Catch:{ all -> 0x0204 }
            goto L_0x0139
        L_0x016f:
            r1 = 4
            if (r6 != 0) goto L_0x0173
            goto L_0x01d7
        L_0x0173:
            int r2 = r6.intValue()     // Catch:{ all -> 0x0204 }
            if (r2 != r1) goto L_0x01d7
            java.util.ArrayList r6 = r7.getData()     // Catch:{ all -> 0x0204 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ all -> 0x0204 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0204 }
        L_0x0184:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0204 }
            if (r7 == 0) goto L_0x0202
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0204 }
            com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean r7 = (com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean) r7     // Catch:{ all -> 0x0204 }
            java.util.LinkedHashMap<java.lang.String, com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean> r0 = r5.mLocalStudent     // Catch:{ all -> 0x0204 }
            java.lang.String r1 = r7.getUserId()     // Catch:{ all -> 0x0204 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0204 }
            com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean r0 = (com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean) r0     // Catch:{ all -> 0x0204 }
            if (r0 != 0) goto L_0x019f
            goto L_0x0184
        L_0x019f:
            java.util.LinkedHashMap<java.lang.String, com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean> r0 = r5.mLocalStudent     // Catch:{ all -> 0x0204 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0204 }
            java.lang.String r1 = r7.getUserId()     // Catch:{ all -> 0x0204 }
            java.lang.String r2 = "student"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)     // Catch:{ all -> 0x0204 }
            r0.put(r1, r7)     // Catch:{ all -> 0x0204 }
            java.lang.Integer r0 = r7.getAddCoin()     // Catch:{ all -> 0x0204 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x0204 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x0204 }
            if (r0 <= 0) goto L_0x01bf
            r5.addCoin(r7)     // Catch:{ all -> 0x0204 }
        L_0x01bf:
            java.lang.String r0 = r7.getUserId()     // Catch:{ all -> 0x0204 }
            java.lang.String r1 = r5.mUserId     // Catch:{ all -> 0x0204 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)     // Catch:{ all -> 0x0204 }
            if (r0 == 0) goto L_0x0184
            java.lang.Integer r7 = r7.getAddCoin()     // Catch:{ all -> 0x0204 }
            int r7 = r7.intValue()     // Catch:{ all -> 0x0204 }
            r5.updateUserCoins(r7)     // Catch:{ all -> 0x0204 }
            goto L_0x0184
        L_0x01d7:
            r1 = 5
            if (r6 != 0) goto L_0x01db
            goto L_0x01f1
        L_0x01db:
            int r2 = r6.intValue()     // Catch:{ all -> 0x0204 }
            if (r2 != r1) goto L_0x01f1
            java.util.ArrayList r6 = r7.getData()     // Catch:{ all -> 0x0204 }
            r1 = 0
            updateAllLocation$default(r5, r6, r4, r0, r1)     // Catch:{ all -> 0x0204 }
            java.util.ArrayList r6 = r7.getData()     // Catch:{ all -> 0x0204 }
            r5.authPen(r6)     // Catch:{ all -> 0x0204 }
            goto L_0x0202
        L_0x01f1:
            r0 = 6
            if (r6 != 0) goto L_0x01f5
            goto L_0x0202
        L_0x01f5:
            int r6 = r6.intValue()     // Catch:{ all -> 0x0204 }
            if (r6 != r0) goto L_0x0202
            java.util.ArrayList r6 = r7.getData()     // Catch:{ all -> 0x0204 }
            r5.authPen(r6)     // Catch:{ all -> 0x0204 }
        L_0x0202:
            monitor-exit(r5)
            return
        L_0x0204:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.groupvideocall.driver.GroupVideoCallPluginDriver.interactiveBegan(boolean, com.tal.app.thinkacademy.live.business.groupvideocall.GroupVideoCallBean):void");
    }

    private final void authPen(ArrayList<VideoCallBean> arrayList) {
        if (arrayList != null) {
            for (VideoCallBean videoCallBean : arrayList) {
                GroupVideoCallView groupVideoCallView = this.mGroupVideoCallView;
                if (groupVideoCallView != null) {
                    groupVideoCallView.authPen(videoCallBean);
                }
                if (Intrinsics.areEqual(videoCallBean.getUserId(), this.mUserId)) {
                    PluginEventBus.onEvent(DataBusKey.GTRAFFITI_AUTH_KEY, new PluginEventData(GroupVideoCallPluginDriver.class, DataBusKey.GTRAFFITI_AUTH_KEY, String.valueOf(videoCallBean.isAuthorize())));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void interactiveClosed() {
        XesLog.i(this.TAG, "interactiveClosed");
        this.isInteractStart = false;
        singleStepAll();
        this.mGroupVideoCallBean = null;
        IRTCEngineProvider iRTCEngineProvider = this.mProvider;
        if (iRTCEngineProvider != null) {
            iRTCEngineProvider.removeRtcEngineEventListener(this.keyTag);
        }
        PluginEventBus.onEvent(DataBusKey.GROUP_VIDEO_CALL_STATE, new PluginEventData(GroupVideoCallPluginDriver.class, DataBusKey.GROUP_VIDEO_CALL_STATE, EnterRoomMuteData.STATUS_UN_MUTE));
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        if (iLiveRoomProvider != null) {
            iLiveRoomProvider.removeView((View) this.mGroupVideoCallView);
        }
        this.mGroupVideoCallView = null;
        PluginEventBus.unregister(DataBusKey.CLASS_HANDUP, this.observerHandup);
        PluginEventBus.unregister(DataBusKey.LEVEL_KEY, this.observerUserLevel);
        PluginEventBus.unregister(DataBusKey.SHOW_OTHER_LEVEL_KEY, this.observerOtherUserLevel);
        PluginEventBus.unregister(DataBusKey.SEND_EMOJI, this.observerEmoji);
    }

    private final void singleStage(VideoCallBean videoCallBean) {
        String micIsOpen;
        String cameraIsOpen;
        String interactId;
        Class<GroupVideoCallPluginDriver> cls = GroupVideoCallPluginDriver.class;
        PluginEventBus.onEventMain(DataBusKey.GROUP_VIDEO_CALL_STUDENT_START, new PluginEventData(cls, DataBusKey.GROUP_VIDEO_CALL_STUDENT_START, videoCallBean.getUserId()));
        GroupVideoCallView groupVideoCallView = this.mGroupVideoCallView;
        if (groupVideoCallView != null) {
            groupVideoCallView.singleStage(videoCallBean, getStudentSurfaceView(Long.parseLong(videoCallBean.getUserId())));
        }
        int i = 0;
        XesLog.i(this.TAG, "singleStage --> userId=" + videoCallBean.getUserId() + " -- micIsOpen=" + videoCallBean.getMicIsOpen() + " -- cameraIsOpen=" + videoCallBean.getCameraIsOpen() + " --");
        if (Intrinsics.areEqual(videoCallBean.getUserId(), this.mUserId)) {
            PluginEventBus.onEvent(DataBusKey.GROUP_VIDEO_CALL_STUDENT_HAND_UP, new PluginEventData(cls, DataBusKey.GROUP_VIDEO_CALL_STUDENT_HAND_UP, "2"));
            remotefirstVideoRecvWithUid(videoCallBean.getUserId(), this.isMuteVideo == 1);
            String str = this.mUserId;
            if (this.isMuteAudio != 1) {
                i = -1;
            }
            updateMic(str, i);
            HWEventTracking hWEventTracking = HWEventTracking.Companion.get();
            GroupVideoCallBean groupVideoCallBean = this.mGroupVideoCallBean;
            String str2 = "";
            if (!(groupVideoCallBean == null || (interactId = groupVideoCallBean.getInteractId()) == null)) {
                str2 = interactId;
            }
            hWEventTracking.ostaIaOnStage(str2, "start");
        } else {
            Integer cameraIsInit = videoCallBean.getCameraIsInit();
            if (cameraIsInit != null && cameraIsInit.intValue() == 0) {
                GroupStudentInfo findStudent = findStudent(Long.parseLong(videoCallBean.getUserId()));
                videoCallBean.setCameraIsOpen((findStudent == null || (cameraIsOpen = findStudent.getCameraIsOpen()) == null) ? 2 : Integer.valueOf(Integer.parseInt(cameraIsOpen)));
            }
            String userId = videoCallBean.getUserId();
            Integer cameraIsOpen2 = videoCallBean.getCameraIsOpen();
            remotefirstVideoRecvWithUid(userId, cameraIsOpen2 != null && cameraIsOpen2.intValue() == 1);
            Integer micIsInit = videoCallBean.getMicIsInit();
            if (micIsInit != null && micIsInit.intValue() == 0) {
                GroupStudentInfo findStudent2 = findStudent(Long.parseLong(videoCallBean.getUserId()));
                videoCallBean.setMicIsOpen((findStudent2 == null || (micIsOpen = findStudent2.getMicIsOpen()) == null) ? 2 : Integer.valueOf(Integer.parseInt(micIsOpen)));
            }
            String userId2 = videoCallBean.getUserId();
            Integer micIsOpen2 = videoCallBean.getMicIsOpen();
            if (micIsOpen2 == null || micIsOpen2.intValue() != 1) {
                i = -1;
            }
            updateMic(userId2, i);
            playingAudioStart(Long.parseLong(videoCallBean.getUserId()));
        }
        GroupVideoCallView groupVideoCallView2 = this.mGroupVideoCallView;
        if (groupVideoCallView2 != null) {
            groupVideoCallView2.authPen(videoCallBean);
        }
    }

    private final void singleStep(VideoCallBean videoCallBean) {
        String interactId;
        if (!Intrinsics.areEqual(videoCallBean.getUserId(), this.mUserId)) {
            playingAudioStop(Long.parseLong(videoCallBean.getUserId()));
        } else {
            HWEventTracking hWEventTracking = HWEventTracking.Companion.get();
            GroupVideoCallBean groupVideoCallBean = this.mGroupVideoCallBean;
            String str = "";
            if (!(groupVideoCallBean == null || (interactId = groupVideoCallBean.getInteractId()) == null)) {
                str = interactId;
            }
            hWEventTracking.ostaIaOnStage(str, "end");
        }
        XesLog.i(this.TAG, "singleStep --> userId=" + videoCallBean.getUserId() + " -- micIsOpen=" + videoCallBean.getMicIsOpen() + " -- cameraIsOpen=" + videoCallBean.getCameraIsOpen() + " --");
        GroupVideoCallView groupVideoCallView = this.mGroupVideoCallView;
        if (groupVideoCallView != null) {
            groupVideoCallView.singleStep(videoCallBean);
        }
        PluginEventBus.onEventMain(DataBusKey.GROUP_VIDEO_CALL_STUDENT_END, new PluginEventData(GroupVideoCallPluginDriver.class, DataBusKey.GROUP_VIDEO_CALL_STUDENT_END, videoCallBean.getUserId()));
    }

    private final void singleStepAll() {
        XesLog.i(this.TAG, "singleStepAll");
        for (String str : this.mLocalStudent.keySet()) {
            VideoCallBean videoCallBean = this.mLocalStudent.get(str);
            Intrinsics.checkNotNull(videoCallBean);
            Intrinsics.checkNotNullExpressionValue(videoCallBean, "mLocalStudent[key]!!");
            singleStep(videoCallBean);
        }
        this.mLocalStudent.clear();
        this.mServerStudent.clear();
    }

    static /* synthetic */ void updateAllLocation$default(GroupVideoCallPluginDriver groupVideoCallPluginDriver, ArrayList arrayList, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        groupVideoCallPluginDriver.updateAllLocation(arrayList, z);
    }

    private final void updateAllLocation(ArrayList<VideoCallBean> arrayList, boolean z) {
        Collection collection = arrayList;
        if (!(collection == null || collection.isEmpty())) {
            Intrinsics.checkNotNull(arrayList);
            Iterator<VideoCallBean> it = arrayList.iterator();
            while (it.hasNext()) {
                VideoCallBean next = it.next();
                VideoCallBean videoCallBean = this.mLocalStudent.get(next.getUserId());
                if (videoCallBean != null) {
                    String userId = next.getUserId();
                    Intrinsics.checkNotNullExpressionValue(next, "student");
                    this.mLocalStudent.put(userId, next);
                    if (!z) {
                        VideoCallBean videoCallBean2 = this.mLocalStudent.get(next.getUserId());
                        Intrinsics.checkNotNull(videoCallBean2);
                        Intrinsics.checkNotNullExpressionValue(videoCallBean2, "mLocalStudent[student.userId]!!");
                        studentSliding(videoCallBean2);
                    } else if (!Intrinsics.areEqual(videoCallBean.getOriginXRatio(), next.getOriginXRatio()) || !Intrinsics.areEqual(videoCallBean.getOriginYRatio(), next.getOriginYRatio()) || !Intrinsics.areEqual(videoCallBean.getWRatio(), next.getWRatio()) || !Intrinsics.areEqual(videoCallBean.getHRatio(), next.getHRatio())) {
                        VideoCallBean videoCallBean3 = this.mLocalStudent.get(next.getUserId());
                        Intrinsics.checkNotNull(videoCallBean3);
                        Intrinsics.checkNotNullExpressionValue(videoCallBean3, "mLocalStudent[student.userId]!!");
                        studentSliding(videoCallBean3);
                    }
                }
            }
        }
    }

    private final void addCoin(VideoCallBean videoCallBean) {
        GroupVideoCallView groupVideoCallView = this.mGroupVideoCallView;
        if (groupVideoCallView != null) {
            groupVideoCallView.addCoin(videoCallBean);
        }
    }

    private final void studentSliding(VideoCallBean videoCallBean) {
        GroupVideoCallView groupVideoCallView = this.mGroupVideoCallView;
        if (groupVideoCallView != null) {
            groupVideoCallView.studentSliding(videoCallBean);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r0 = (r0 = r0.getDataStorage()).getUserInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateUserCoins(int r12) {
        /*
            r11 = this;
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r0 = r11.mLiveRoomProvider
            r1 = 0
            if (r0 != 0) goto L_0x0007
        L_0x0005:
            r0 = r1
            goto L_0x001e
        L_0x0007:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r0 = r0.getDataStorage()
            if (r0 != 0) goto L_0x000e
            goto L_0x0005
        L_0x000e:
            com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy r0 = r0.getUserInfo()
            if (r0 != 0) goto L_0x0015
            goto L_0x0005
        L_0x0015:
            int r0 = r0.getGoldNum()
            int r0 = r0 + r12
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L_0x001e:
            if (r0 != 0) goto L_0x0021
            return
        L_0x0021:
            int r0 = r0.intValue()
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r2 = r11.mLiveRoomProvider
            if (r2 != 0) goto L_0x002a
            goto L_0x0035
        L_0x002a:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r2 = r2.getDataStorage()
            if (r2 != 0) goto L_0x0031
            goto L_0x0035
        L_0x0031:
            com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy r1 = r2.getUserInfo()
        L_0x0035:
            if (r1 != 0) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            r1.setGoldNum(r0)
        L_0x003b:
            com.tal.app.thinkacademy.live.core.plugin.PluginEventData r1 = new com.tal.app.thinkacademy.live.core.plugin.PluginEventData
            java.lang.Class<com.tal.app.thinkacademy.live.business.interactivegames.driver.GamePluginDriver> r2 = com.tal.app.thinkacademy.live.business.interactivegames.driver.GamePluginDriver.class
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData r10 = new com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData
            r6 = 0
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r4 = "多人上台"
            r3 = r10
            r5 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            java.lang.String r12 = "usercoins_key"
            r1.<init>(r2, r12, r0, r10)
            com.tal.app.thinkacademy.live.core.plugin.PluginEventBus.onEvent(r12, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.groupvideocall.driver.GroupVideoCallPluginDriver.updateUserCoins(int):void");
    }

    private final void showFace(String str, String str2) {
        GroupVideoCallView groupVideoCallView = this.mGroupVideoCallView;
        if (groupVideoCallView != null) {
            groupVideoCallView.showFace(str, str2);
        }
    }

    private final TextureView getStudentSurfaceView(long j) {
        if (this.mRtcEngine == null) {
            return null;
        }
        TextureView textureView = this.mSurfaceViewMap.get(Long.valueOf(j));
        if (textureView == null) {
            RTCEngine rTCEngine = this.mRtcEngine;
            Intrinsics.checkNotNull(rTCEngine);
            textureView = rTCEngine.createTextureView();
            this.mSurfaceViewMap.put(Long.valueOf(j), textureView);
        }
        if (j == Long.parseLong(this.mUserId)) {
            RTCEngine rTCEngine2 = this.mRtcEngine;
            if (rTCEngine2 != null) {
                rTCEngine2.setupLocalVideo(textureView);
            }
        } else {
            RTCEngine rTCEngine3 = this.mRtcEngine;
            if (rTCEngine3 != null) {
                rTCEngine3.setupRemoteVideo(j, textureView);
            }
        }
        return textureView;
    }

    public final void updateLevel(String str, int i) {
        Intrinsics.checkNotNullParameter(str, LeanplumUtil.uid);
        GroupVideoCallView groupVideoCallView = this.mGroupVideoCallView;
        if (groupVideoCallView != null) {
            groupVideoCallView.updateLevel(str, i);
        }
    }

    public final void updateMic(String str, int i) {
        Intrinsics.checkNotNullParameter(str, LeanplumUtil.uid);
        GroupVideoCallView groupVideoCallView = this.mGroupVideoCallView;
        if (groupVideoCallView != null) {
            groupVideoCallView.updateMic(str, i);
        }
    }

    /* access modifiers changed from: private */
    public final void remotefirstVideoRecvWithUid(String str, boolean z) {
        GroupVideoCallView groupVideoCallView = this.mGroupVideoCallView;
        if (groupVideoCallView != null) {
            groupVideoCallView.remotefirstVideoRecvWithUid(str, z);
        }
    }

    static /* synthetic */ void requestMicro$default(GroupVideoCallPluginDriver groupVideoCallPluginDriver, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        groupVideoCallPluginDriver.requestMicro(z);
    }

    private final void requestMicro(boolean z) {
        GroupVideoCallBean groupVideoCallBean = this.mGroupVideoCallBean;
        if (groupVideoCallBean != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (z) {
                    jSONObject.put("type", 127);
                } else {
                    jSONObject.put("type", 125);
                }
                jSONObject.put("stuId", this.mUserId);
                int i = 2;
                jSONObject.put("cameraAvailable", (!PermissionUtils.isGranted("android.permission.CAMERA") || this.isMuteVideo != 1) ? 2 : 1);
                jSONObject.put("mikeAvailable", (!PermissionUtils.isGranted("android.permission.RECORD_AUDIO") || this.isMuteAudio != 1) ? 2 : 1);
                if (PermissionUtils.isGranted("android.permission.CAMERA") && this.isMuteVideo == 1) {
                    i = 1;
                }
                jSONObject.put("cameraIsOpen", i);
                if (this.mIrcControllerProvider == null) {
                    this.mIrcControllerProvider = this.mLiveRoomProvider.getIrcControllerProvider();
                }
                IircControllerProvider iircControllerProvider = this.mIrcControllerProvider;
                if (iircControllerProvider != null) {
                    iircControllerProvider.sendPeerMessage(groupVideoCallBean.getFrom(), !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), 0);
                }
                XesLog.i(this.TAG, "requestMicro --> isStart=" + z + " -- message=" + jSONObject);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public final void playingAudioStart(long j) {
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngine.muteRemoteAudio(j, false);
        }
    }

    private final void playingAudioStop(long j) {
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngine.muteRemoteAudio(j, true);
        }
    }

    private final void getGroupStudentList() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), new HandlerException(new GroupVideoCallPluginDriver$getGroupStudentList$1(this)), (CoroutineStart) null, new GroupVideoCallPluginDriver$getGroupStudentList$2(this, (Continuation<? super GroupVideoCallPluginDriver$getGroupStudentList$2>) null), 2, (Object) null);
    }

    private final GroupStudentInfo findStudent(long j) {
        Collection collection = this.mGroupStudentList;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList<GroupStudentInfo> arrayList = this.mGroupStudentList;
        Intrinsics.checkNotNull(arrayList);
        Iterator<GroupStudentInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            String userId = it.next().getUserId();
            if (userId != null) {
                Long.parseLong(userId);
            }
        }
        return null;
    }

    public void onDestroy() {
        try {
            for (Map.Entry entry : this.mSurfaceViewMap.entrySet()) {
                TextureView textureView = (TextureView) entry.getValue();
                long longValue = ((Number) entry.getKey()).longValue();
                if (textureView != null) {
                    if (textureView.getParent() != null) {
                        ViewParent parent = textureView.getParent();
                        if (parent != null) {
                            ((ViewGroup) parent).removeView(textureView);
                            XesLog.i(this.TAG, Intrinsics.stringPlus("开始移除，uid=", Long.valueOf(longValue)));
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                        }
                    } else {
                        XesLog.i(this.TAG, Intrinsics.stringPlus("没有父视图，不需要移除，uid=", Long.valueOf(longValue)));
                    }
                    if (textureView.getParent() != null) {
                        XesLog.i(this.TAG, Intrinsics.stringPlus("检查：未移除掉！uid=", Long.valueOf(longValue)));
                    } else {
                        XesLog.i(this.TAG, Intrinsics.stringPlus("检查：已经移除！uid=", Long.valueOf(longValue)));
                    }
                } else {
                    XesLog.i(this.TAG, Intrinsics.stringPlus("surfaceView为空，不需要移除！uid=", Long.valueOf(longValue)));
                }
            }
        } catch (Exception e) {
            XesLog.i(this.TAG, Intrinsics.stringPlus("遍历移除surfaceView引用失败=", e));
        }
        this.isOnDestroy = true;
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        if (iLiveRoomProvider != null) {
            iLiveRoomProvider.removeView((View) this.mGroupVideoCallView);
        }
        this.mGroupVideoCallView = null;
        this.mGroupVideoCallBean = null;
        this.mSurfaceViewMap.clear();
        this.mRtcPlayerEngineEventListener = null;
        this.mProvider = null;
        this.mRtcEngine = null;
        this.mContext = null;
        PluginEventBus.unregister(DataBusKey.USER_MUTE_VIDEO_KEY, this.observerVideoMuteStatus);
        PluginEventBus.unregister(DataBusKey.USER_MUTE_MIC_KEY, this.observerAudioMuteStatus);
        ILiveRoomProvider iLiveRoomProvider2 = this.mLiveRoomProvider;
        if (iLiveRoomProvider2 != null) {
            iLiveRoomProvider2.destroyPlugin((BaseLivePluginDriver) this);
        }
    }
}
