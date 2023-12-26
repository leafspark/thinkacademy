package com.tal.app.thinkacademy.live.business.voice;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import com.eaydu.omni.RTCChannel;
import com.eaydu.omni.RTCEngine;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.common.entity.ParentAuditCloudData;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.player.rtcplayer.IRTCEngineProvider;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineProvider;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineProviderUtils;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayer;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayerUtil;
import com.tal.app.thinkacademy.lib.player.rtcplayer.SimpleRtcPlayerEngineEventListener;
import com.tal.app.thinkacademy.lib.player.rtcplayer.entity.RtcUserState;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.listenbody.RtcPlayerListenerBody;
import com.tal.app.thinkacademy.live.business.function.FunctionPluginDriverKt;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import java.util.HashSet;
import java.util.List;

@PluginAnnotation(desc = "声音管理", ircType = {"video_bet_student"}, launchType = "enter", moduleId = "349")
public class VoicePluginDriver extends BaseLivePluginDriver {
    /* access modifiers changed from: private */
    public static final XesLogTag TAG = Tag.VOICE_MANAGER;
    public final String MutePluginKey = "mute_plugin_key";
    private Context mContext;
    private HashSet<Long> mFilterStudentList;
    private boolean mIsLookOther = true;
    private boolean mIsOnTeacherPrivateOnStage = false;
    private boolean mIsParentAuditor = false;
    /* access modifiers changed from: private */
    public boolean mIsSmallClass = false;
    public Observer<PluginEventData> mObserverCancelIgnoreStudent = new VoicePluginDriver$$ExternalSyntheticLambda3(this);
    public Observer<PluginEventData> mObserverIgnoreStudent = new VoicePluginDriver$$ExternalSyntheticLambda2(this);
    private RtcPlayer mPlayer;
    /* access modifiers changed from: private */
    public volatile boolean mPub;
    private IRTCEngineProvider.RTCEngineCallback mRTCEngineCallback = new IRTCEngineProvider.RTCEngineCallback() {
        public void onGetRTCEngineFail(int i, int i2) {
        }

        public void onGetRTCEngine(RTCEngine rTCEngine, RTCChannel rTCChannel) {
            RTCEngine unused = VoicePluginDriver.this.mRtcEngine = rTCEngine;
        }
    };
    /* access modifiers changed from: private */
    public RTCEngine mRtcEngine;
    private IRTCEngineProvider mRtcEngineProvider;
    private RtcViewModel mRtcViewModel;
    /* access modifiers changed from: private */
    public List<Long> mStudentList;
    private Observer<PluginEventData> mTeacherPrivateOnStageObserver = new VoicePluginDriver$$ExternalSyntheticLambda4(this);
    private long mUid = 0;
    public Observer<PluginEventData> observerGroupEnd = new VoicePluginDriver$$ExternalSyntheticLambda1(this);
    public Observer<PluginEventData> observerGroupStart = new VoicePluginDriver$$ExternalSyntheticLambda0(this);

    public VoicePluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        EnterConfigProxy enterConfig = iLiveRoomProvider.getDataStorage().getEnterConfig();
        this.mIsSmallClass = "2".equals(iLiveRoomProvider.getClassType());
        this.mStudentList = enterConfig.getClassStudentList();
        this.mFilterStudentList = new HashSet<>();
        initParentAudit();
        PluginEventBus.register(this, DataBusKey.GROUP_VIDEO_CALL_STUDENT_START, this.observerGroupStart);
        PluginEventBus.register(this, DataBusKey.GROUP_VIDEO_CALL_STUDENT_END, this.observerGroupEnd);
        PluginEventBus.register(this, DataBusKey.VOICE_DRIVER_START_IGNORE_ONE_STUDENT, this.mObserverIgnoreStudent);
        PluginEventBus.register(this, DataBusKey.VOICE_DRIVER_CANCEL_IGNORE_ONE_STUDENT, this.mObserverCancelIgnoreStudent);
        PluginEventBus.register(this, DataBusKey.TEACHER_DRIVER_PRIVATE_CHAT, this.mTeacherPrivateOnStageObserver);
        initRtcViewModel();
        initRtcEngine();
    }

    private void initRtcViewModel() {
        RtcViewModel viewModel = AbilityPack.get().getViewModel(RtcViewModel.class);
        this.mRtcViewModel = viewModel;
        if (viewModel != null) {
            viewModel.getMRtcPlayerListener().observerSticky(this, false, new Observer<RtcPlayerListenerBody>() {
                public void onChanged(RtcPlayerListenerBody rtcPlayerListenerBody) {
                    if (rtcPlayerListenerBody instanceof RtcPlayerListenerBody.StudentListUpdate) {
                        XesLog.i(VoicePluginDriver.TAG, "班级数据有更新了");
                        VoicePluginDriver.this.updateStudentList(((RtcPlayerListenerBody.StudentListUpdate) rtcPlayerListenerBody).getList());
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void updateStudentList(List<StudentVideoBean.ListBean> list) {
        RtcUserState remoteState;
        if (list != null && this.mStudentList != null) {
            for (int i = 0; i < list.size(); i++) {
                long userId = list.get(i).getUserId();
                if (!this.mStudentList.contains(Long.valueOf(userId))) {
                    this.mStudentList.add(Long.valueOf(userId));
                    RtcViewModel rtcViewModel = this.mRtcViewModel;
                    if (!(rtcViewModel == null || (remoteState = rtcViewModel.getRemoteState(userId)) == null || !remoteState.getMIsOnline())) {
                        if (this.mPub) {
                            XesLog.i(TAG, "更新数据，开互听");
                            vocal(userId);
                        } else {
                            XesLog.i(TAG, "更新数据，未开互听");
                        }
                    }
                }
            }
        }
    }

    private void initParentAudit() {
        List<Long> list;
        if (this.mLiveRoomProvider.getDataStorage() != null) {
            if (this.mLiveRoomProvider.getDataStorage().getCourseInfo() != null) {
                this.mIsParentAuditor = this.mLiveRoomProvider.getDataStorage().getCourseInfo().getIsParentAuditLocal();
                XesLogTag xesLogTag = TAG;
                XesLog.i(xesLogTag, "是否为家长旁听 = " + this.mIsParentAuditor);
            }
            this.mIsLookOther = getLookOthers();
            XesLogTag xesLogTag2 = TAG;
            XesLog.i(xesLogTag2, "是否开启互看 = " + this.mIsLookOther);
            try {
                long parseLong = Long.parseLong(this.mLiveRoomProvider.getDataStorage().getUserInfo().getId());
                this.mUid = parseLong;
                if (parseLong > 0 && (list = this.mStudentList) != null && this.mIsParentAuditor && list.contains(Long.valueOf(parseLong))) {
                    XesLog.i(xesLogTag2, "家长旁听，包含自己孩子，去除自己孩子id = " + this.mUid);
                    this.mStudentList.remove(Long.valueOf(this.mUid));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.mStudentList != null && this.mIsParentAuditor) {
                if (!PadUtils.isPad(Utils.getApp())) {
                    XesLog.i(TAG, "家长旁听，手机,不能听到其他学生的声音");
                    this.mStudentList.clear();
                } else if (!this.mIsLookOther) {
                    XesLog.i(TAG, "家长旁听，pad,未开启互看,不能听到其他学生的声音");
                    this.mStudentList.clear();
                }
            }
        }
    }

    private boolean getLookOthers() {
        if (!this.mIsParentAuditor) {
            return true;
        }
        ParentAuditCloudData parentAuditParam = HwCloudControlHelper.get().getParentAuditParam();
        if (parentAuditParam == null || parentAuditParam.getLookOther() == null || !parentAuditParam.getLookOther().equals("1")) {
            return false;
        }
        return true;
    }

    public void onMessage(String str, String str2) {
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "ircTypeKey = " + str + " message = " + str2);
        try {
            if (str.equals(FunctionPluginDriverKt.VIDEO_BET_STUDENT)) {
                XesLog.s(xesLogTag, "收到声音管理的消息:ircTypeKey=" + str + ",message=" + str2);
                VoiceStatus video_bet_student = ((VoiceSwitch) GsonUtils.fromJson(str2, VoiceSwitch.class)).getVideo_bet_student();
                if (this.mIsOnTeacherPrivateOnStage) {
                    XesLog.i(xesLogTag, "收到声音管理的消息:正在处于，老师私聊上台中，忽略，不响应");
                    return;
                }
                this.mPub = video_bet_student.isPub();
                controlHearEachOther();
            }
        } catch (Exception e) {
            XesLogTag xesLogTag2 = TAG;
            XesLog.e(xesLogTag2, "onMessage error=" + e.toString());
        }
    }

    private void controlHearEachOther() {
        if (this.mPub) {
            vocalAll();
        } else {
            muteAll();
        }
        PluginEventBus.onEvent(DataBusKey.VOICE_DRIVER_IS_HEAR_EACH_OTHER, new PluginEventData(VoicePluginDriver.class, DataBusKey.VOICE_DRIVER_IS_HEAR_EACH_OTHER, this.mPub ? "open" : "close"));
    }

    public void onDestroy() {
        stopRTC();
        PluginEventBus.unregister(DataBusKey.GROUP_VIDEO_CALL_STUDENT_START, this.observerGroupStart);
        PluginEventBus.unregister(DataBusKey.GROUP_VIDEO_CALL_STUDENT_END, this.observerGroupEnd);
        PluginEventBus.unregister(DataBusKey.VOICE_DRIVER_START_IGNORE_ONE_STUDENT, this.mObserverIgnoreStudent);
        PluginEventBus.unregister(DataBusKey.VOICE_DRIVER_CANCEL_IGNORE_ONE_STUDENT, this.mObserverCancelIgnoreStudent);
        PluginEventBus.unregister(DataBusKey.TEACHER_DRIVER_PRIVATE_CHAT, this.mTeacherPrivateOnStageObserver);
    }

    private void initRtcEngine() {
        this.mContext = (Context) this.mLiveRoomProvider.getWeakRefContext().get();
        RtcPlayer rtcPlayer = RtcPlayerUtil.getInstance().get("Live");
        this.mPlayer = rtcPlayer;
        if (rtcPlayer == null) {
            this.mPlayer = new RtcPlayer(this.mContext);
            RtcPlayerUtil.getInstance().put("Live", this.mPlayer);
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "VoicePluginDriver进入直播间创建mPlayer：", "mPlayer is" + this.mPlayer);
        }
        RTCEngineProvider rTCEngineProvider = RTCEngineProviderUtils.getInstance().get("Live");
        this.mRtcEngineProvider = rTCEngineProvider;
        if (rTCEngineProvider != null) {
            rTCEngineProvider.provide("mute_plugin_key", this.mRTCEngineCallback);
        }
        this.mRtcEngineProvider.addEtcEngineEventListener("voice_driver", new SimpleRtcPlayerEngineEventListener() {
            public void didOfflineOfUid(long j, String str) {
                super.didOfflineOfUid(j, str);
                if (VoicePluginDriver.this.mIsSmallClass && VoicePluginDriver.this.mStudentList != null && VoicePluginDriver.this.mStudentList.contains(Long.valueOf(j))) {
                    XesLogTag access$000 = VoicePluginDriver.TAG;
                    XesLog.i(access$000, "didOfflineOfUid uid=" + j);
                    VoicePluginDriver.this.mute(j);
                }
            }

            public void remoteUserJoinWitnUid(long j, String str) {
                super.remoteUserJoinWitnUid(j, str);
                if (VoicePluginDriver.this.mPub && VoicePluginDriver.this.mIsSmallClass && VoicePluginDriver.this.mStudentList != null && VoicePluginDriver.this.mStudentList.contains(Long.valueOf(j))) {
                    XesLogTag access$000 = VoicePluginDriver.TAG;
                    XesLog.i(access$000, "remoteUserJoinWitnUid uid=" + j);
                    VoicePluginDriver.this.vocal(j);
                }
            }
        });
    }

    private boolean isListHas(List<Long> list, Long l) {
        if (!(list == null || l == null)) {
            for (int i = 0; i < list.size(); i++) {
                if (l.longValue() == list.get(i).longValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void stopRTC() {
        IRTCEngineProvider iRTCEngineProvider = this.mRtcEngineProvider;
        if (iRTCEngineProvider != null) {
            iRTCEngineProvider.release();
        }
    }

    public void muteAll() {
        muteAll(this.mStudentList);
    }

    public void vocalAll() {
        vocalAll(this.mStudentList);
    }

    private void muteAll(List<Long> list) {
        if (list != null && !list.isEmpty()) {
            for (Long longValue : list) {
                mute(longValue.longValue());
            }
        }
    }

    public void mute(long j) {
        muteRemoteAudio(j, true);
    }

    private void vocalAll(List<Long> list) {
        if (list != null && !list.isEmpty()) {
            for (Long longValue : list) {
                vocal(longValue.longValue());
            }
        }
    }

    public void vocal(long j) {
        if (this.mIsSmallClass) {
            RtcPlayer rtcPlayer = this.mPlayer;
            if (rtcPlayer != null && rtcPlayer.getRemoteStateOnLine(j)) {
                XesLogTag xesLogTag = TAG;
                XesLog.i(xesLogTag, "vocal uid=" + j);
                muteRemoteAudio(j, false);
                return;
            }
            return;
        }
        muteRemoteAudio(j, false);
    }

    private void muteRemoteAudio(long j, boolean z) {
        if (this.mRtcEngine != null && !this.mFilterStudentList.contains(Long.valueOf(j))) {
            this.mRtcEngine.muteRemoteAudio(j, z);
        }
    }

    public /* synthetic */ void lambda$new$0$VoicePluginDriver(PluginEventData pluginEventData) {
        String data = pluginEventData.getData();
        try {
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "上台，屏蔽，学员uid=" + data);
            this.mFilterStudentList.add(Long.valueOf(Long.parseLong(data)));
        } catch (Exception unused) {
            XesLogTag xesLogTag2 = TAG;
            XesLog.e(xesLogTag2, "上台，屏蔽，学员出错，uid=" + data);
        }
    }

    public /* synthetic */ void lambda$new$1$VoicePluginDriver(PluginEventData pluginEventData) {
        String data = pluginEventData.getData();
        try {
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "上台，取消屏蔽，学员uid=" + data);
            long parseLong = Long.parseLong(data);
            this.mFilterStudentList.remove(Long.valueOf(parseLong));
            if (this.mPub) {
                vocal(parseLong);
            }
        } catch (Exception unused) {
            XesLogTag xesLogTag2 = TAG;
            XesLog.e(xesLogTag2, "上台，取消屏蔽，学员出错，uid=" + data);
        }
    }

    public /* synthetic */ void lambda$new$2$VoicePluginDriver(PluginEventData pluginEventData) {
        String data = pluginEventData.getData();
        try {
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "忽略学员uid=" + data);
            this.mFilterStudentList.add(Long.valueOf(Long.parseLong(data)));
        } catch (Exception e) {
            XesLogTag xesLogTag2 = TAG;
            XesLog.e(xesLogTag2, "忽略学员出错：" + e.toString());
        }
    }

    public /* synthetic */ void lambda$new$3$VoicePluginDriver(PluginEventData pluginEventData) {
        String data = pluginEventData.getData();
        try {
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "取消忽略学员uid=" + data);
            long parseLong = Long.parseLong(data);
            this.mFilterStudentList.remove(Long.valueOf(parseLong));
            if (this.mPub) {
                vocal(parseLong);
            }
        } catch (Exception e) {
            XesLogTag xesLogTag2 = TAG;
            XesLog.e(xesLogTag2, "取消忽略学员出错：" + e.toString());
        }
    }

    public /* synthetic */ void lambda$new$4$VoicePluginDriver(PluginEventData pluginEventData) {
        if (pluginEventData.getObject() != null && (pluginEventData.getObject() instanceof Boolean)) {
            if (!((Boolean) pluginEventData.getObject()).booleanValue()) {
                XesLog.i(TAG, "收到老师私聊上台消息，不是是本人，忽略 ");
            } else if ("1".equals(pluginEventData.getData())) {
                this.mIsOnTeacherPrivateOnStage = true;
                this.mPub = false;
                controlHearEachOther();
                XesLog.i(TAG, "收到老师私聊上台消息，关闭互听");
            } else {
                this.mIsOnTeacherPrivateOnStage = false;
                XesLog.i(TAG, "收到老师私聊上台消息，互听逻辑，不处理");
            }
        }
    }
}
