package com.tal.app.thinkacademy.live.business.teachercameup.driver;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.player.rtcplayer.IRTCEngineProvider;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineProviderUtils;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayerEngineEventListener;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.groupvideocall.driver.GroupVideoCallPluginDriver;
import com.tal.app.thinkacademy.live.business.liveplay.bean.TeacherOnStageMsg;
import com.tal.app.thinkacademy.live.business.teachercameup.bean.TeacherCameUpBean;
import com.tal.app.thinkacademy.live.business.teachercameup.view.BaseTeacherView;
import com.tal.app.thinkacademy.live.business.teachercameup.view.TeacherCameUpSmallView;
import com.tal.app.thinkacademy.live.business.teachercameup.view.TeacherCameUpView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020/H\u0016J\u001c\u00101\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u00010\r2\b\u00103\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u00104\u001a\u00020/2\b\u00105\u001a\u0004\u0018\u00010%H\u0002J\u001c\u00106\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u00010\r2\b\u00107\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u00108\u001a\u00020/2\u0006\u00109\u001a\u00020\nH\u0002J\u0010\u0010:\u001a\u00020/2\u0006\u00109\u001a\u00020\nH\u0002J\b\u0010;\u001a\u00020/H\u0002J\b\u0010<\u001a\u00020/H\u0002J\u0006\u0010=\u001a\u00020/R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/teachercameup/driver/TeacherCameUpPluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "isInteractStart", "", "isOnDestroy", "keyTag", "", "mAudioId", "", "mAudioVolume", "", "mContext", "Landroid/content/Context;", "mCourseRate", "Lcom/tal/app/thinkacademy/live/core/layout/LiveAreaCompat$CourseRate;", "mGraffitiUseCourseRate", "mIsMySelfPrivateChat", "mIsOnline", "mIsOpenCamera", "mIsOpenMic", "mIsPrivateChat", "mProvider", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/IRTCEngineProvider;", "mRtcPlayerEngineEventListener", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayerEngineEventListener;", "mRtcViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel;", "mSurfaceView", "Landroid/view/SurfaceView;", "mTeacherCameUpBean", "Lcom/tal/app/thinkacademy/live/business/teachercameup/bean/TeacherCameUpBean;", "mTeacherCameUpView", "Lcom/tal/app/thinkacademy/live/business/teachercameup/view/BaseTeacherView;", "mTeacherInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/TeacherInfo;", "mUserId", "observerTeacherInfo", "Landroidx/lifecycle/Observer;", "Lcom/tal/app/thinkacademy/live/core/plugin/PluginEventData;", "initEngine", "", "onDestroy", "onMessage", "ircTypeKey", "message", "onThePlatform", "bean", "processPrivateMessage", "messageStr", "sendPrivateEvent", "isOnState", "sendTeacherCameUpEvent", "stageOperation", "underThePlatform", "updateMic", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PluginAnnotation(desc = "老师上讲台", ircType = {"teacher_video_mic", "graffiti_board_video"}, launchType = "delay", moduleId = "310")
@ViewLevels({@ViewLevel(level = 40, name = "TeacherCameUp")})
/* compiled from: TeacherCameUpPluginDriver.kt */
public final class TeacherCameUpPluginDriver extends BaseLivePluginDriver {
    private final Tag TAG = Tag.TeacherCameUpPluginDriver;
    private boolean isInteractStart;
    private boolean isOnDestroy;
    private final String keyTag = "TeacherCameUpPluginDriver";
    /* access modifiers changed from: private */
    public long mAudioId = -1;
    /* access modifiers changed from: private */
    public int mAudioVolume;
    private Context mContext;
    private LiveAreaCompat.CourseRate mCourseRate = LiveAreaCompat.CourseRate.RATE_4_3;
    private boolean mGraffitiUseCourseRate;
    private boolean mIsMySelfPrivateChat = true;
    private boolean mIsOnline;
    private boolean mIsOpenCamera;
    /* access modifiers changed from: private */
    public boolean mIsOpenMic;
    private boolean mIsPrivateChat;
    private IRTCEngineProvider mProvider;
    private RtcPlayerEngineEventListener mRtcPlayerEngineEventListener;
    private RtcViewModel mRtcViewModel;
    private SurfaceView mSurfaceView;
    private TeacherCameUpBean mTeacherCameUpBean;
    private BaseTeacherView<?> mTeacherCameUpView;
    private TeacherInfo mTeacherInfo;
    private String mUserId;
    private Observer<PluginEventData> observerTeacherInfo = new TeacherCameUpPluginDriver$$ExternalSyntheticLambda0(this);

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0022, code lost:
        r0 = r3.getDataStorage();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TeacherCameUpPluginDriver(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r3, android.os.Bundle r4) {
        /*
            r2 = this;
            r2.<init>(r3, r4)
            com.tal.app.thinkacademy.live.Tag r4 = com.tal.app.thinkacademy.live.Tag.TeacherCameUpPluginDriver
            r2.TAG = r4
            java.lang.String r4 = "TeacherCameUpPluginDriver"
            r2.keyTag = r4
            r4 = 1
            r2.mIsMySelfPrivateChat = r4
            r0 = -1
            r2.mAudioId = r0
            com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat$CourseRate r4 = com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat.CourseRate.RATE_4_3
            r2.mCourseRate = r4
            com.tal.app.thinkacademy.live.business.teachercameup.driver.TeacherCameUpPluginDriver$$ExternalSyntheticLambda0 r4 = new com.tal.app.thinkacademy.live.business.teachercameup.driver.TeacherCameUpPluginDriver$$ExternalSyntheticLambda0
            r4.<init>(r2)
            r2.observerTeacherInfo = r4
            r4 = 0
            if (r3 != 0) goto L_0x0022
        L_0x0020:
            r0 = r4
            goto L_0x002d
        L_0x0022:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r0 = r3.getDataStorage()
            if (r0 != 0) goto L_0x0029
            goto L_0x0020
        L_0x0029:
            com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo r0 = r0.getTeacherInfo()
        L_0x002d:
            r2.mTeacherInfo = r0
            if (r3 != 0) goto L_0x0033
        L_0x0031:
            r0 = r4
            goto L_0x0045
        L_0x0033:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r0 = r3.getDataStorage()
            if (r0 != 0) goto L_0x003a
            goto L_0x0031
        L_0x003a:
            com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy r0 = r0.getUserInfo()
            if (r0 != 0) goto L_0x0041
            goto L_0x0031
        L_0x0041:
            java.lang.String r0 = r0.getId()
        L_0x0045:
            r2.mUserId = r0
            com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack r0 = com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt.getAbilityPack()
            com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel r0 = com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModelKt.getRtcViewModel(r0)
            r2.mRtcViewModel = r0
            if (r3 != 0) goto L_0x0054
            goto L_0x0094
        L_0x0054:
            java.lang.ref.WeakReference r0 = r3.getWeakRefContext()
            if (r0 != 0) goto L_0x005c
            r0 = r4
            goto L_0x0062
        L_0x005c:
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
        L_0x0062:
            r2.mContext = r0
            r2.initEngine()
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r0 = r3.getDataStorage()
            if (r0 != 0) goto L_0x006e
            goto L_0x0079
        L_0x006e:
            com.tal.app.thinkacademy.live.core.live.datastorage.RoomData r0 = r0.getRoomData()
            if (r0 != 0) goto L_0x0075
            goto L_0x0079
        L_0x0075:
            com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat$CourseRate r4 = r0.getCourseRate()
        L_0x0079:
            if (r4 != 0) goto L_0x007d
            com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat$CourseRate r4 = com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat.CourseRate.RATE_4_3
        L_0x007d:
            r2.mCourseRate = r4
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r3 = r3.getDataStorage()
            r4 = 0
            if (r3 != 0) goto L_0x0087
            goto L_0x0092
        L_0x0087:
            com.tal.app.thinkacademy.live.core.live.datastorage.RoomData r3 = r3.getRoomData()
            if (r3 != 0) goto L_0x008e
            goto L_0x0092
        L_0x008e:
            boolean r4 = r3.getGraffitiUseCourseRate()
        L_0x0092:
            r2.mGraffitiUseCourseRate = r4
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.teachercameup.driver.TeacherCameUpPluginDriver.<init>(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: observerTeacherInfo$lambda-1  reason: not valid java name */
    public static final void m445observerTeacherInfo$lambda1(TeacherCameUpPluginDriver teacherCameUpPluginDriver, PluginEventData pluginEventData) {
        Intrinsics.checkNotNullParameter(teacherCameUpPluginDriver, "this$0");
        TeacherOnStageMsg teacherOnStageMsg = (TeacherOnStageMsg) pluginEventData.getObject();
        if (teacherOnStageMsg != null) {
            teacherCameUpPluginDriver.mIsOnline = teacherOnStageMsg.isOnLine();
            teacherCameUpPluginDriver.mIsOpenMic = teacherOnStageMsg.isOpenMic();
            teacherCameUpPluginDriver.mIsOpenCamera = teacherOnStageMsg.isOpenCamera();
            teacherCameUpPluginDriver.mAudioId = teacherOnStageMsg.getTeacherAudioUid();
            teacherCameUpPluginDriver.mSurfaceView = teacherOnStageMsg.getSurfaceView();
            if (teacherCameUpPluginDriver.mIsPrivateChat && !teacherCameUpPluginDriver.mIsMySelfPrivateChat) {
                return;
            }
            if (!teacherCameUpPluginDriver.mIsOnline || !teacherCameUpPluginDriver.isInteractStart) {
                teacherCameUpPluginDriver.underThePlatform();
            } else {
                teacherCameUpPluginDriver.onThePlatform(teacherCameUpPluginDriver.mTeacherCameUpBean);
            }
        }
    }

    private final void initEngine() {
        this.mProvider = RTCEngineProviderUtils.getInstance().get("Live");
        this.mRtcPlayerEngineEventListener = new TeacherCameUpPluginDriver$initEngine$1(this);
    }

    public void onMessage(String str, String str2) {
        XesLog.i(this.TAG, "onMessage ircTypeKey=" + str + ",message=" + str2);
        if (this.isOnDestroy) {
            return;
        }
        if (Intrinsics.areEqual(str, "teacher_video_mic")) {
            CharSequence charSequence = str2;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                XesLog.i(this.TAG, Intrinsics.stringPlus("ircTypeKey --> ", str2));
                try {
                    Intrinsics.checkNotNull(str2);
                    JSONObject optJSONObject = new JSONObject(str2).optJSONObject(str);
                    if (optJSONObject != null) {
                        TeacherCameUpBean teacherCameUpBean = (TeacherCameUpBean) GsonUtils.fromJson(!(optJSONObject instanceof JSONObject) ? optJSONObject.toString() : JSONObjectInstrumentation.toString(optJSONObject), TeacherCameUpBean.class);
                        this.mTeacherCameUpBean = teacherCameUpBean;
                        if (teacherCameUpBean != null) {
                            if (Intrinsics.areEqual(teacherCameUpBean.getPub(), true)) {
                                this.mIsPrivateChat = false;
                                this.mIsMySelfPrivateChat = true;
                                stageOperation();
                            } else if (this.mIsPrivateChat) {
                                XesLog.i(this.TAG, "老师私聊上台中，无效的普通老师下台。");
                                return;
                            } else {
                                underThePlatform();
                            }
                            this.mIsPrivateChat = false;
                            this.mIsMySelfPrivateChat = true;
                        }
                    }
                } catch (Exception e) {
                    this.mIsPrivateChat = false;
                    this.mIsMySelfPrivateChat = true;
                    underThePlatform();
                    XesLog.e(this.TAG, Intrinsics.stringPlus("出错，老师下台", e));
                }
            }
        } else if (Intrinsics.areEqual(str, "graffiti_board_video")) {
            processPrivateMessage(str, str2);
        }
    }

    private final void processPrivateMessage(String str, String str2) {
        XesLog.i(this.TAG, "收到老师上台，私聊消息 ircTypeKey=" + str + ",message=" + str2);
        if (str2 != null) {
            try {
                JSONObject optJSONObject = new JSONObject(str2).optJSONObject(str);
                if (optJSONObject != null) {
                    TeacherCameUpBean teacherCameUpBean = (TeacherCameUpBean) GsonUtils.fromJson(!(optJSONObject instanceof JSONObject) ? optJSONObject.toString() : JSONObjectInstrumentation.toString(optJSONObject), TeacherCameUpBean.class);
                    this.mTeacherCameUpBean = teacherCameUpBean;
                    if (teacherCameUpBean != null) {
                        this.mIsMySelfPrivateChat = Intrinsics.areEqual(String.valueOf(teacherCameUpBean.getUserId()), this.mUserId);
                        if (Intrinsics.areEqual(teacherCameUpBean.getPub(), true)) {
                            this.mIsPrivateChat = true;
                            if (this.mIsMySelfPrivateChat) {
                                XesLog.i(this.TAG, "是本人，开始启动，私聊老师上台");
                                stageOperation();
                            } else {
                                XesLog.i(this.TAG, "不是本人，不启动，私聊老师上台，开始发送事件");
                                sendPrivateEvent(true);
                            }
                        } else {
                            this.mIsPrivateChat = false;
                            if (this.mIsMySelfPrivateChat) {
                                XesLog.i(this.TAG, "是本人，开始启动，私聊老师下台");
                                underThePlatform();
                            } else {
                                XesLog.i(this.TAG, "不是本人，不启动，私聊老师下台，开始发送事件");
                                sendPrivateEvent(false);
                            }
                        }
                        PluginEventBus.onEvent(DataBusKey.TEACHER_DRIVER_PRIVATE_CHAT, new PluginEventData(TeacherCameUpPluginDriver.class, DataBusKey.TEACHER_DRIVER_PRIVATE_CHAT, Intrinsics.areEqual(teacherCameUpBean.getPub(), true) ? "1" : EnterRoomMuteData.STATUS_UN_MUTE, Boolean.valueOf(this.mIsMySelfPrivateChat)));
                        Unit unit = Unit.INSTANCE;
                    }
                }
            } catch (Exception e) {
                XesLog.e(this.TAG, Intrinsics.stringPlus("出错，私聊老师下台,error=", e));
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    private final void sendPrivateEvent(boolean z) {
        Unit unit;
        Class<TeacherCameUpPluginDriver> cls = TeacherCameUpPluginDriver.class;
        TeacherCameUpBean teacherCameUpBean = this.mTeacherCameUpBean;
        Unit unit2 = null;
        if (teacherCameUpBean != null) {
            if (z) {
                PluginEventBus.onEvent(DataBusKey.VOICE_DRIVER_START_IGNORE_ONE_STUDENT, new PluginEventData(cls, DataBusKey.VOICE_DRIVER_START_IGNORE_ONE_STUDENT, String.valueOf(teacherCameUpBean.getUserId())));
                RtcViewModel rtcViewModel = this.mRtcViewModel;
                if (rtcViewModel != null) {
                    rtcViewModel.stopRemoteAudio(teacherCameUpBean.getUserId());
                    unit = Unit.INSTANCE;
                }
            } else {
                PluginEventBus.onEvent(DataBusKey.VOICE_DRIVER_CANCEL_IGNORE_ONE_STUDENT, new PluginEventData(cls, DataBusKey.VOICE_DRIVER_CANCEL_IGNORE_ONE_STUDENT, String.valueOf(teacherCameUpBean.getUserId())));
                unit = Unit.INSTANCE;
            }
            unit2 = unit;
        }
        if (unit2 == null) {
            TeacherCameUpPluginDriver teacherCameUpPluginDriver = this;
            XesLog.e(this.TAG, "老师上台私聊，数据结构为空，无法触发");
        }
    }

    private final void sendTeacherCameUpEvent(boolean z) {
        if (z) {
            PluginEventBus.onEvent(DataBusKey.TEACHER_CAME_UP_STATE, new PluginEventData(GroupVideoCallPluginDriver.class, DataBusKey.TEACHER_CAME_UP_STATE, EnterRoomMuteData.STATUS_UN_MUTE, Boolean.valueOf(this.mIsMySelfPrivateChat)));
        } else {
            PluginEventBus.onEvent(DataBusKey.TEACHER_CAME_UP_STATE, new PluginEventData(GroupVideoCallPluginDriver.class, DataBusKey.TEACHER_CAME_UP_STATE, "1", Boolean.valueOf(this.mIsMySelfPrivateChat)));
        }
    }

    private final void stageOperation() {
        Unit unit;
        BaseTeacherView<?> baseTeacherView;
        this.isInteractStart = true;
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        PluginEventBus.register(lifecycleOwner, DataBusKey.TEACHER_CAME_UP_GET_INFO, this.observerTeacherInfo);
        sendTeacherCameUpEvent(true);
        IRTCEngineProvider iRTCEngineProvider = this.mProvider;
        if (iRTCEngineProvider != null) {
            iRTCEngineProvider.addEtcEngineEventListener(this.keyTag, this.mRtcPlayerEngineEventListener);
        }
        TeacherCameUpBean teacherCameUpBean = this.mTeacherCameUpBean;
        if (teacherCameUpBean == null) {
            unit = null;
        } else {
            Context context = this.mContext;
            if (context == null) {
                TeacherCameUpPluginDriver teacherCameUpPluginDriver = this;
                XesLog.e(this.TAG, "context is null");
                unit = Unit.INSTANCE;
            } else {
                if (this.mTeacherCameUpView == null) {
                    if (LiveAreaCompat.isSmallPad() || LiveAreaCompat.isSmallPhone()) {
                        baseTeacherView = new TeacherCameUpSmallView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                    } else {
                        baseTeacherView = new TeacherCameUpView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                    }
                    this.mTeacherCameUpView = baseTeacherView;
                    baseTeacherView.setMTeacherInfo(this.mTeacherInfo);
                    BaseTeacherView<?> baseTeacherView2 = this.mTeacherCameUpView;
                    if (baseTeacherView2 != null) {
                        baseTeacherView2.layoutView(this.mCourseRate, this.mGraffitiUseCourseRate);
                    }
                    this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.mTeacherCameUpView, this.mPluginConfData.getViewLevel("TeacherCameUp"), LiveAreaContext.get().getPptLp().newLp());
                    LiveAreaContext.get().layoutObserver.observe(lifecycleOwner, new TeacherCameUpPluginDriver$$ExternalSyntheticLambda1(this, teacherCameUpBean));
                }
                if (!this.mIsPrivateChat || !this.mIsMySelfPrivateChat) {
                    BaseTeacherView<?> baseTeacherView3 = this.mTeacherCameUpView;
                    if (baseTeacherView3 != null) {
                        baseTeacherView3.setPrivateCallLabelVisible(false);
                    }
                } else {
                    BaseTeacherView<?> baseTeacherView4 = this.mTeacherCameUpView;
                    if (baseTeacherView4 != null) {
                        baseTeacherView4.setPrivateCallLabelVisible(true);
                    }
                }
                if (this.mIsOnline && this.isInteractStart) {
                    onThePlatform(teacherCameUpBean);
                    return;
                }
                return;
            }
        }
        if (unit == null) {
            TeacherCameUpPluginDriver teacherCameUpPluginDriver2 = this;
            XesLog.e(this.TAG, "mTeacherCameUpBean is null");
        }
        underThePlatform();
    }

    /* access modifiers changed from: private */
    /* renamed from: stageOperation$lambda-14$lambda-12$lambda-11  reason: not valid java name */
    public static final void m446stageOperation$lambda14$lambda12$lambda11(TeacherCameUpPluginDriver teacherCameUpPluginDriver, TeacherCameUpBean teacherCameUpBean, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(teacherCameUpPluginDriver, "this$0");
        Intrinsics.checkNotNullParameter(teacherCameUpBean, "$bean");
        BaseTeacherView<?> baseTeacherView = teacherCameUpPluginDriver.mTeacherCameUpView;
        if (baseTeacherView != null && teacherCameUpPluginDriver.mIsOnline && teacherCameUpPluginDriver.isInteractStart) {
            ViewGroup.LayoutParams layoutParams = baseTeacherView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            baseTeacherView.setLayoutParams(liveAreaContext.getPptLp().mergeLp((FrameLayout.LayoutParams) layoutParams));
            baseTeacherView.layoutView(teacherCameUpPluginDriver.mCourseRate, teacherCameUpPluginDriver.mGraffitiUseCourseRate);
            teacherCameUpPluginDriver.onThePlatform(teacherCameUpBean);
        }
    }

    private final void onThePlatform(TeacherCameUpBean teacherCameUpBean) {
        XesLogTag xesLogTag = this.TAG;
        Object[] objArr = new Object[1];
        objArr[0] = Intrinsics.stringPlus("onThePlatform --> status=", teacherCameUpBean == null ? null : teacherCameUpBean.getStatus());
        XesLog.i(xesLogTag, objArr);
        if (teacherCameUpBean != null) {
            BaseTeacherView<?> baseTeacherView = this.mTeacherCameUpView;
            if (baseTeacherView != null) {
                baseTeacherView.updateMic(this.mIsOpenMic, this.mAudioVolume);
            }
            BaseTeacherView<?> baseTeacherView2 = this.mTeacherCameUpView;
            if (baseTeacherView2 != null) {
                baseTeacherView2.onThePlatform(teacherCameUpBean);
            }
            BaseTeacherView<?> baseTeacherView3 = this.mTeacherCameUpView;
            if (baseTeacherView3 != null) {
                baseTeacherView3.videoOperation(teacherCameUpBean, this.mIsOpenCamera, this.mSurfaceView);
            }
        }
    }

    private final void underThePlatform() {
        XesLog.i(this.TAG, "underThePlatform");
        this.isInteractStart = false;
        BaseTeacherView<?> baseTeacherView = this.mTeacherCameUpView;
        if (baseTeacherView != null) {
            baseTeacherView.underThePlatform();
        }
        PluginEventBus.unregister(DataBusKey.TEACHER_CAME_UP_GET_INFO, this.observerTeacherInfo);
        IRTCEngineProvider iRTCEngineProvider = this.mProvider;
        if (iRTCEngineProvider != null) {
            iRTCEngineProvider.removeRtcEngineEventListener(this.keyTag);
        }
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        if (iLiveRoomProvider != null) {
            iLiveRoomProvider.removeView((View) this.mTeacherCameUpView);
        }
        this.mTeacherCameUpView = null;
        sendTeacherCameUpEvent(false);
        this.mTeacherCameUpBean = null;
    }

    public final void updateMic() {
        BaseTeacherView<?> baseTeacherView = this.mTeacherCameUpView;
        if (baseTeacherView != null) {
            baseTeacherView.updateMic(this.mIsOpenMic, this.mAudioVolume);
        }
    }

    public void onDestroy() {
        this.isOnDestroy = true;
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        if (iLiveRoomProvider != null) {
            iLiveRoomProvider.removeView((View) this.mTeacherCameUpView);
        }
        IRTCEngineProvider iRTCEngineProvider = this.mProvider;
        if (iRTCEngineProvider != null) {
            iRTCEngineProvider.removeRtcEngineEventListener(this.keyTag);
        }
        this.mProvider = null;
        this.mRtcPlayerEngineEventListener = null;
        this.mTeacherCameUpView = null;
        this.mTeacherCameUpBean = null;
        this.mContext = null;
        ILiveRoomProvider iLiveRoomProvider2 = this.mLiveRoomProvider;
        if (iLiveRoomProvider2 != null) {
            iLiveRoomProvider2.destroyPlugin((BaseLivePluginDriver) this);
        }
    }
}
