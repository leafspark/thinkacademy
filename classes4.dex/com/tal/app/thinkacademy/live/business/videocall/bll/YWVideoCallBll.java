package com.tal.app.thinkacademy.live.business.videocall.bll;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.arch.core.util.Function;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.eaydu.omni.RTCChannel;
import com.eaydu.omni.RTCEngine;
import com.eaydu.omni.listener.RTCConnectionStateType;
import com.google.gson.JsonObject;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.player.rtcplayer.IRTCEngineProvider;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineProviderUtils;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayerEngineEventListener;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModelKt;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.videocall.bll.VideoCallHelper;
import com.tal.app.thinkacademy.live.business.videocall.config.VideoCallConfig;
import com.tal.app.thinkacademy.live.business.videocall.driver.VideoCallDriver;
import com.tal.app.thinkacademy.live.business.videocall.entity.StudentEntity;
import com.tal.app.thinkacademy.live.business.videocall.pager.VideoCallPager;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import com.tal.app.thinkacademy.live.util.LiveMainHandler;
import com.tbruyelle.rxpermissions3.RxPermissions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YWVideoCallBll implements IVideoCallAction {
    /* access modifiers changed from: private */
    public XesLogTag TAG = Tag.VIDEO_CALL;
    private boolean checkPermission = false;
    private boolean hasPermission = false;
    private int isMuteVideo = 1;
    private boolean isPushingStream;
    /* access modifiers changed from: private */
    public boolean isTarget = false;
    private boolean isVideoCallOn;
    /* access modifiers changed from: private */
    public String mCameraAvailable;
    /* access modifiers changed from: private */
    public String mClassName;
    private Context mContext;
    /* access modifiers changed from: private */
    public EnterConfigProxy mEnterConfigProxy;
    /* access modifiers changed from: private */
    public String mFrom = "t";
    private Handler mHandler;
    /* access modifiers changed from: private */
    public boolean mHasJoinRTC;
    /* access modifiers changed from: private */
    public String mInteractId;
    private ILiveRoomProvider mLiveRoomProvider;
    /* access modifiers changed from: private */
    public String mOnMicClassName;
    /* access modifiers changed from: private */
    public String mOnMicName;
    /* access modifiers changed from: private */
    public long mOnMicUid;
    /* access modifiers changed from: private */
    public VideoCallPager mPager;
    private IRTCEngineProvider.RTCEngineCallback mRTCEngineCallback = new IRTCEngineProvider.RTCEngineCallback() {
        public void onGetRTCEngineFail(int i, int i2) {
        }

        public void onGetRTCEngine(RTCEngine rTCEngine, RTCChannel rTCChannel) {
            RTCEngine unused = YWVideoCallBll.this.mRtcEngine = rTCEngine;
            RTCChannel unused2 = YWVideoCallBll.this.mRtcEngineChannel = rTCChannel;
            YWVideoCallBll yWVideoCallBll = YWVideoCallBll.this;
            yWVideoCallBll.startRTC(yWVideoCallBll.mRtcEngineProvider);
        }
    };
    /* access modifiers changed from: private */
    public int mRaiseHandState;
    /* access modifiers changed from: private */
    public long mReceiveFirstVideoUid;
    private RoomData mRoomData;
    /* access modifiers changed from: private */
    public RTCEngine mRtcEngine;
    /* access modifiers changed from: private */
    public RTCChannel mRtcEngineChannel;
    /* access modifiers changed from: private */
    public IRTCEngineProvider mRtcEngineProvider;
    private RtcViewModel mRtcViewModel;
    private long mSelfUid;
    /* access modifiers changed from: private */
    public int mSpeakingState;
    private Map<Long, SurfaceView> mSurfaceViewMap = new HashMap();
    private VideoCallHelper mVideoCallHelper;
    private boolean pushingStreamOnPause;
    private View.OnClickListener raiseHandClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            MethodInfo.onClickEventEnter(view, YWVideoCallBll.class);
            if (view.getId() == R.id.live_business_video_call_bt) {
                if (YWVideoCallBll.this.mRaiseHandState == 0) {
                    YWVideoCallBll yWVideoCallBll = YWVideoCallBll.this;
                    yWVideoCallBll.track_click_video_show(LeanplumUtil.click_join_videomic, yWVideoCallBll.mInteractId);
                    YWVideoCallBll.this.checkPermissions(false, false);
                    DriverTrack.INSTANCE.classRoomInteractVideoChatControl(YWVideoCallBll.this.mInteractId, "举手");
                    HWEventTracking.get().ostaRaiseHand();
                } else {
                    YWVideoCallBll.this.videoCallDriver.giveupMicro(YWVideoCallBll.this.mFrom, YWVideoCallBll.this.mInteractId);
                    YWVideoCallBll yWVideoCallBll2 = YWVideoCallBll.this;
                    yWVideoCallBll2.track_click_video_show(LeanplumUtil.click_cancel_videomic, yWVideoCallBll2.mInteractId);
                    int unused = YWVideoCallBll.this.mRaiseHandState = 0;
                    YWVideoCallBll.this.updateUI();
                    DriverTrack.INSTANCE.classRoomInteractVideoChatControl(YWVideoCallBll.this.mInteractId, "取消举手");
                }
            } else if (YWVideoCallBll.this.mSpeakingState == 1) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
                return;
            } else if (YWVideoCallBll.this.mRaiseHandState == 0) {
                YWVideoCallBll yWVideoCallBll3 = YWVideoCallBll.this;
                yWVideoCallBll3.track_click_video_show(LeanplumUtil.click_join_videomic, yWVideoCallBll3.mInteractId);
                YWVideoCallBll.this.checkPermissions(true, false);
                YWVideoCallBll.this.mPager.setActionCancel();
            } else {
                YWVideoCallBll yWVideoCallBll4 = YWVideoCallBll.this;
                yWVideoCallBll4.track_click_video_show(LeanplumUtil.click_cancel_videomic, yWVideoCallBll4.mInteractId);
                YWVideoCallBll.this.videoCallDriver.giveupMicro(YWVideoCallBll.this.mFrom, YWVideoCallBll.this.mInteractId);
                int unused2 = YWVideoCallBll.this.mRaiseHandState = 0;
                YWVideoCallBll.this.mPager.setActionRaiseHand();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            MethodInfo.onClickEventEnd();
        }
    };
    private boolean selfOffMic;
    private int unPermissionCount = 0;
    /* access modifiers changed from: private */
    public VideoCallDriver videoCallDriver;
    private boolean waitingForJoinRTC;

    public void onVisitorLogin() {
    }

    public YWVideoCallBll(ILiveRoomProvider iLiveRoomProvider, VideoCallHelper videoCallHelper, VideoCallDriver videoCallDriver2) {
        this.mLiveRoomProvider = iLiveRoomProvider;
        this.mEnterConfigProxy = iLiveRoomProvider.getDataStorage().getEnterConfig();
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        this.mRoomData = iLiveRoomProvider.getDataStorage().getRoomData();
        this.videoCallDriver = videoCallDriver2;
        this.mVideoCallHelper = videoCallHelper;
        this.mSelfUid = videoCallHelper.safeParseLong(iLiveRoomProvider.getDataStorage().getUserInfo().getId());
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mRtcViewModel = RtcViewModelKt.getRtcViewModel(AbilityPack.get());
    }

    public void onResume() {
        if (this.pushingStreamOnPause) {
            realStartPushStream();
        }
        this.pushingStreamOnPause = false;
    }

    public void onPause() {
        if (this.isPushingStream) {
            this.pushingStreamOnPause = true;
        }
    }

    public void onModeChange(String str, String str2, boolean z) {
        XesLogTag xesLogTag = this.TAG;
        XesLog.i(xesLogTag, "onModeChange: oldMode=" + str + ", mode=" + str2 + ", isPresent=" + z);
        if (this.mRaiseHandState == 1) {
            this.mRaiseHandState = 2;
            this.videoCallDriver.giveupMicro(this.mFrom, this.mInteractId);
        }
        Handler handler = this.mHandler;
        YWVideoCallBll$$ExternalSyntheticLambda1 yWVideoCallBll$$ExternalSyntheticLambda1 = new YWVideoCallBll$$ExternalSyntheticLambda1(this);
        if (!(handler instanceof Handler)) {
            handler.post(yWVideoCallBll$$ExternalSyntheticLambda1);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, yWVideoCallBll$$ExternalSyntheticLambda1);
        }
    }

    public /* synthetic */ void lambda$onModeChange$0$YWVideoCallBll() {
        videoCallOff(VideoCallConfig.TEMP_VALUE_NOTICE);
    }

    public void track_click_video_show(String str, String str2) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", str2);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(str, trackMap);
    }

    public void videoCallOn(String str, String str2, String str3, boolean z, List<StudentEntity> list) {
        if (!this.isVideoCallOn) {
            PluginEventBus.onEvent(DataBusKey.VIDEO_CALL_STATUS, new PluginEventData(YWVideoCallBll.class, DataBusKey.VIDEO_CALL_STATUS, "videoCallStart"));
            this.mInteractId = str;
            this.mFrom = str2;
            this.mRtcEngineProvider = RTCEngineProviderUtils.getInstance().get("Live");
            XesLogTag xesLogTag = this.TAG;
            XesLog.i(xesLogTag, "开启视频连麦，上麦时获取mRtcEngineProvider：", "mRtcEngineProvider is" + this.mRtcEngineProvider);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("开启视频连麦，上麦时获取mRtcEngineProvider：", "mRtcEngineProvider is" + this.mRtcEngineProvider);
            XesLog.ut(VideoCallConfig.TAG, jsonObject);
            IRTCEngineProvider iRTCEngineProvider = this.mRtcEngineProvider;
            if (iRTCEngineProvider != null) {
                iRTCEngineProvider.provide(this.mInteractId, this.mRTCEngineCallback);
            }
            this.mHasJoinRTC = true;
            XesLogTag xesLogTag2 = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("开启视频连麦，是否是主讲模式 ：");
            sb.append(!this.videoCallDriver.isInTraningMode());
            XesLog.i(xesLogTag2, sb.toString());
            if (this.mPager == null) {
                VideoCallPager videoCallPager = new VideoCallPager(this.mContext, false);
                this.mPager = videoCallPager;
                videoCallPager.setRaiseHandClickListener(this.raiseHandClickListener);
                this.mPager.setOnBackPressListener(new Function<Void, Void>() {
                    public Void apply(Void voidR) {
                        if (YWVideoCallBll.this.mRtcEngine == null) {
                            return null;
                        }
                        YWVideoCallBll.this.realStopPushStream();
                        return null;
                    }
                });
                this.mPager.setInteractionId(this.mInteractId);
            }
            if (z) {
                showVideoCall();
                this.isVideoCallOn = true;
                HWEventTracking.get().ostaIaVideoLink(str, "master_teacher", "start");
            } else if (VideoCallConfig.TEMP_VALUE_NOTICE.equals(str3)) {
                showVideoCall();
                this.isVideoCallOn = true;
                HWEventTracking.get().ostaIaVideoLink(str, "master_teacher", "start");
            }
            this.mSpeakingState = 0;
            this.mRaiseHandState = 0;
            if (VideoCallConfig.TEMP_VALUE_NOTICE.equals(str3)) {
                this.isTarget = false;
                updateUI();
                track_click_video_show(LeanplumUtil.show_videomic, this.mInteractId);
            }
            if ("target".equals(str3)) {
                this.isTarget = true;
                checkPermissions(false, true);
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("收到定向连麦：", "checkPermissions");
                XesLog.ut(VideoCallConfig.TAG, jsonObject2);
            }
        }
    }

    private void showVideoCall() {
        LiveAreaLayoutParams pptLp = LiveAreaContext.get().getPptLp();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.height = this.mPager.getVideoViewHeight();
        layoutParams.width = this.mPager.getVideoViewWidth();
        layoutParams.topMargin = (pptLp.top + pptLp.height) - layoutParams.height;
        layoutParams.setMarginStart((pptLp.left + pptLp.width) - layoutParams.width);
        this.mLiveRoomProvider.addView(this.videoCallDriver, this.mPager, "VideoCallView", layoutParams);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.tal.app.thinkacademy.live.business.videocall.pager.VideoCallPager, android.view.View] */
    private void closeVideoCall() {
        this.mLiveRoomProvider.removeView(this.mPager);
        this.mPager = null;
    }

    public void videoCallOffRandom(String str) {
        if (this.isVideoCallOn) {
            HWEventTracking.get().ostaIaVideoLink(this.mInteractId, "master_teacher", "end");
            XesLog.i(this.TAG, "关闭视频连麦");
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("收到连麦关闭", "关闭视频连麦");
            XesLog.ut(VideoCallConfig.TAG, jsonObject);
            stopRTC();
            if (this.mPager != null) {
                closeVideoCall();
            }
            this.isVideoCallOn = false;
            this.isTarget = false;
            this.mSurfaceViewMap.clear();
        }
    }

    public void videoCallOff(String str) {
        if (this.isVideoCallOn || this.isTarget) {
            PluginEventBus.onEvent(DataBusKey.VIDEO_CALL_STATUS, new PluginEventData(YWVideoCallBll.class, DataBusKey.VIDEO_CALL_STATUS, "videoCallEnd"));
            HWEventTracking.get().ostaIaVideoLink(this.mInteractId, "master_teacher", "end");
            XesLog.i(this.TAG, "关闭视频连麦");
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("收到连麦关闭", "关闭视频连麦");
            XesLog.ut(VideoCallConfig.TAG, jsonObject);
            stopRTC();
            if (this.mPager != null) {
                closeVideoCall();
            }
            this.isVideoCallOn = false;
            this.isTarget = false;
            this.mSurfaceViewMap.clear();
        }
    }

    public void videoCallHandNum(int i) {
        VideoCallPager videoCallPager = this.mPager;
        if (videoCallPager != null) {
            videoCallPager.updateHandNum(i);
        }
    }

    public void videoCallChoose(int i, List<StudentEntity> list, boolean z, int i2, boolean z2) {
        VideoCallPager videoCallPager;
        VideoCallPager videoCallPager2;
        EnterConfigProxy enterConfigProxy;
        RTCChannel rTCChannel;
        EnterConfigProxy enterConfigProxy2;
        String str;
        Class<YWVideoCallBll> cls = YWVideoCallBll.class;
        if (this.mPager != null && this.isVideoCallOn) {
            this.isMuteVideo = i2;
            XesLogTag xesLogTag = this.TAG;
            XesLog.i(xesLogTag, "选中上麦notice：orderType=" + i + ", " + list);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("收到连麦关闭", "选中上麦notice：orderType=" + i + ", " + list);
            XesLog.ut(VideoCallConfig.TAG, jsonObject);
            StudentEntity studentEntity = null;
            if (list.size() > 0 && (studentEntity = list.get(0)) != null) {
                this.mOnMicName = studentEntity.getName();
                this.mOnMicClassName = studentEntity.getClassName();
                if (studentEntity.cameraAvailable.equals("1")) {
                    str = studentEntity.cameraIsOpen;
                } else {
                    str = "2";
                }
                this.mCameraAvailable = str;
                this.mOnMicUid = this.mVideoCallHelper.safeParseLong(studentEntity.getId());
            }
            if (studentEntity != null && z) {
                if (z2) {
                    DriverTrack.INSTANCE.classRoomInteractVideoChat(this.mInteractId, "2", (!studentEntity.cameraAvailable.equals("1") || !studentEntity.cameraIsOpen.equals("1")) ? 0 : 1, PermissionUtils.isGranted("android.permission.RECORD_AUDIO") ? 1 : 0);
                } else {
                    DriverTrack.INSTANCE.classRoomInteractVideoChat(this.mInteractId, "1", (!studentEntity.cameraAvailable.equals("1") || !studentEntity.cameraIsOpen.equals("1")) ? 0 : 1, PermissionUtils.isGranted("android.permission.RECORD_AUDIO") ? 1 : 0);
                }
            }
            this.selfOffMic = false;
            if (!z) {
                if (this.mSpeakingState == 1) {
                    if (!(this.mRtcEngine == null || (enterConfigProxy = this.mEnterConfigProxy) == null || enterConfigProxy.getRtcConfig() == null || (rTCChannel = this.mRtcEngineChannel) == null)) {
                        rTCChannel.muteLocalVideo(true);
                        this.mRtcEngineChannel.muteLocalAudio(true);
                        this.mRtcEngineChannel.setRole(RTCEngine.RTCRole.RTCRoleAudience);
                        this.mRtcEngine.muteLocalVideo(false);
                        RtcViewModel rtcViewModel = this.mRtcViewModel;
                        if (rtcViewModel != null) {
                            rtcViewModel.setMLocalVideoEnable(true);
                        }
                        this.mRtcEngine.muteLocalAudio(false);
                        this.mRtcEngine.setRole(RTCEngine.RTCRole.RTCRoleBroadcaster);
                        this.mRtcEngine.setDefaultMuteAllRemoteAudioStreams(true);
                        PluginEventBus.onEvent(DataBusKey.VIDEO_CALL_STATUS, new PluginEventData(cls, DataBusKey.VIDEO_CALL_STATUS, "videoCallOff"));
                        JsonObject jsonObject2 = new JsonObject();
                        jsonObject2.addProperty("自己下麦别人上麦切换", "加入engine否成功");
                        XesLog.ut(VideoCallConfig.TAG, jsonObject2);
                    }
                    this.selfOffMic = true;
                    stopPushStream();
                    this.mRaiseHandState = 0;
                }
                this.mSpeakingState = 2;
            } else if (this.mSpeakingState != 1) {
                this.mSpeakingState = 1;
                this.mOnMicName = this.mContext.getString(R.string.me);
                if (!(this.mRtcEngine == null || (enterConfigProxy2 = this.mEnterConfigProxy) == null || enterConfigProxy2.getRtcConfig() == null || this.mRtcEngineChannel == null)) {
                    PluginEventBus.onEvent(DataBusKey.VIDEO_CALL_STATUS, new PluginEventData(cls, DataBusKey.VIDEO_CALL_STATUS, "videoCallOn"));
                    this.mRtcEngine.muteLocalAudio(true);
                    this.mRtcEngine.muteLocalVideo(true);
                    RtcViewModel rtcViewModel2 = this.mRtcViewModel;
                    if (rtcViewModel2 != null) {
                        rtcViewModel2.setMLocalVideoEnable(false);
                    }
                    this.mRtcEngineChannel.setRole(RTCEngine.RTCRole.RTCRoleBroadcaster);
                    this.mRtcEngineChannel.muteLocalAudio(false);
                    if (i2 == 1) {
                        this.mRtcEngineChannel.muteLocalVideo(false);
                    } else {
                        this.mRtcEngineChannel.muteLocalVideo(true);
                    }
                    realStartPushStream();
                    JsonObject jsonObject3 = new JsonObject();
                    jsonObject3.addProperty("选中自己", "加入mRtcEngine是否成功");
                    XesLog.ut(VideoCallConfig.TAG, jsonObject3);
                }
                if (PermissionUtils.isGranted("android.permission.CAMERA") && i2 == 1) {
                    startPushStream();
                }
            } else {
                return;
            }
            if (list.size() == 0) {
                this.mSpeakingState = 0;
                VideoCallPager videoCallPager3 = this.mPager;
                if (videoCallPager3 != null) {
                    videoCallPager3.setSpeaker("", "", "", this.isTarget);
                    this.mPager.showVideoMask(true, 1);
                    this.mReceiveFirstVideoUid = -1;
                }
                this.mOnMicName = "";
                this.mCameraAvailable = "";
                this.mOnMicUid = -1;
            } else {
                VideoCallPager videoCallPager4 = this.mPager;
                if (videoCallPager4 != null) {
                    videoCallPager4.setSpeaker(this.mOnMicName, this.mOnMicClassName, this.mCameraAvailable, this.isTarget);
                }
                if (this.mHasJoinRTC) {
                    renderVideo();
                } else {
                    this.waitingForJoinRTC = true;
                }
            }
            updateUI();
            if (this.selfOffMic && (videoCallPager2 = this.mPager) != null) {
                videoCallPager2.removeRenderView(this.mSurfaceViewMap.get(Long.valueOf(this.mSelfUid)));
            }
            if (list.size() == 0 && (videoCallPager = this.mPager) != null) {
                videoCallPager.removeRenderView();
            }
        }
    }

    public void teacherQuit() {
        this.mRaiseHandState = 0;
        PluginEventBus.onEvent(DataBusKey.VIDEO_CALL_STATUS, new PluginEventData(YWVideoCallBll.class, DataBusKey.VIDEO_CALL_STATUS, "videoCallOff"));
        videoCallOff(VideoCallConfig.TEMP_VALUE_TOPIC);
        this.mSpeakingState = 0;
    }

    public void destroy() {
        PluginEventBus.onEvent(DataBusKey.VIDEO_CALL_STATUS, new PluginEventData(YWVideoCallBll.class, DataBusKey.VIDEO_CALL_STATUS, "videoCallEnd"));
        this.isTarget = false;
        stopRTC();
        if (this.mPager != null) {
            closeVideoCall();
        }
        this.mSurfaceViewMap.clear();
    }

    private void renderVideo() {
        if (this.mRtcEngineChannel != null) {
            if (this.mSpeakingState != 1) {
                JsonObject jsonObject = new JsonObject();
                if ("1".equals(this.mCameraAvailable)) {
                    SurfaceView surfaceView = this.mSurfaceViewMap.get(Long.valueOf(this.mOnMicUid));
                    if (surfaceView == null && (surfaceView = this.mRtcEngine.createRendererView()) != null) {
                        surfaceView.setZOrderOnTop(true);
                        this.mSurfaceViewMap.put(Long.valueOf(this.mOnMicUid), surfaceView);
                    }
                    if (surfaceView != null) {
                        this.mRtcEngineChannel.setupRemoteVideo(surfaceView, this.mOnMicUid);
                        VideoCallPager videoCallPager = this.mPager;
                        if (videoCallPager != null) {
                            videoCallPager.removeRenderView();
                            this.mPager.addRenderView(surfaceView);
                            surfaceView.setZOrderMediaOverlay(true);
                        }
                    }
                    jsonObject.addProperty("别人上麦", "mCameraAvailable==1");
                    if (this.isTarget) {
                        trackInteractiveLog("TargetLinkMic", "videoDisplay", 1, "");
                    } else {
                        trackInteractiveLog("NormalLinkMic", "videoDisplay", 1, "");
                    }
                } else if (this.mPager != null) {
                    jsonObject.addProperty("别人上麦", "mCameraAvailable不等于1，上麦人没有摄像头权限不推流");
                    this.mPager.removeRenderView();
                }
                jsonObject.addProperty("别人上麦", "renderVideo");
                XesLog.ut(VideoCallConfig.TAG, jsonObject);
            }
            this.mHandler.postDelayed(new YWVideoCallBll$$ExternalSyntheticLambda2(this), 500);
        }
    }

    public /* synthetic */ void lambda$renderVideo$1$YWVideoCallBll() {
        VideoCallPager videoCallPager;
        int i = 1;
        if (this.mSpeakingState != 1 || (videoCallPager = this.mPager) == null) {
            VideoCallPager videoCallPager2 = this.mPager;
            if (videoCallPager2 != null) {
                if (this.mOnMicUid != this.mReceiveFirstVideoUid) {
                    i = 2;
                }
                videoCallPager2.showVideoMask(false, i);
                return;
            }
            return;
        }
        videoCallPager.showVideoMask(false, 1);
    }

    private void startPushStream() {
        if (this.mRtcEngine != null) {
            XesLog.i(this.TAG, "上麦(自己)");
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("上麦(自己)startPushStream:", "renderVideo");
            XesLog.ut(VideoCallConfig.TAG, jsonObject);
            SurfaceView createRendererView = this.mRtcEngine.createRendererView();
            if (createRendererView != null) {
                createRendererView.setZOrderOnTop(true);
                this.mRtcEngine.setupLocalVideo(createRendererView);
                this.mRtcEngine.startPreview();
                this.mSurfaceViewMap.put(Long.valueOf(this.mSelfUid), createRendererView);
                this.mPager.addRenderView(createRendererView);
                createRendererView.setZOrderMediaOverlay(true);
            }
            if (this.isTarget) {
                trackInteractiveLog("TargetLinkMic", "videoDisplay", 1, "");
            } else {
                trackInteractiveLog("NormalLinkMic", "videoDisplay", 1, "");
            }
        }
    }

    private void realStartPushStream() {
        this.isPushingStream = true;
        if (this.isMuteVideo == 1) {
            this.mRtcEngine.enableLocalVideo(true);
        } else {
            this.mRtcEngine.enableLocalVideo(false);
        }
        this.mRtcEngine.enableLocalAudio(true);
    }

    private void stopPushStream() {
        if (this.mRtcEngine != null) {
            XesLog.i(this.TAG, "下麦(自己)");
            this.mRtcEngine.stopPreview();
        }
    }

    /* access modifiers changed from: private */
    public void realStopPushStream() {
        this.isPushingStream = false;
        this.mRtcEngine.enableLocalAudio(false);
        this.mRtcEngine.enableLocalVideo(false);
    }

    /* access modifiers changed from: private */
    public void startRTC(IRTCEngineProvider iRTCEngineProvider) {
        if (this.mRtcEngine != null) {
            iRTCEngineProvider.addEtcEngineEventListener(VideoCallConfig.TAG, new RtcPlayerEngineEventListener() {
                public void didAudioMuted(long j, boolean z, String str) {
                }

                public void onOnceLastMileQuality(int i, String str) {
                }

                public void remoteUserJoinWitnUid(long j, String str) {
                }

                public void reportAudioVolumeOfSpeaker(long j, int i) {
                }

                public void dispatchConnectionState(RTCConnectionStateType rTCConnectionStateType, String str, String str2) {
                    if (!"Channel".equals(str2)) {
                        return;
                    }
                    if (RTCConnectionStateType.RTCConnectionStateTypeConnected == rTCConnectionStateType) {
                        XesLog.i(YWVideoCallBll.this.TAG, "rtc  连接成功");
                        if (YWVideoCallBll.this.mPager != null) {
                            YWVideoCallBll.this.mPager.showVideoMask(false, 1);
                            return;
                        }
                        return;
                    }
                    XesLog.i(YWVideoCallBll.this.TAG, "rtc  断开连接");
                    if (YWVideoCallBll.this.mPager != null) {
                        YWVideoCallBll.this.mPager.showVideoMask(true, 3);
                    }
                }

                public void localUserJoindWithUid(long j, String str) {
                    XesLogTag access$500 = YWVideoCallBll.this.TAG;
                    XesLog.i(access$500, "视频连麦老师选择自己切换房间本地用户joinedRTC, localUserJoindWithUid: " + j);
                    if ("Channel".equals(str)) {
                        boolean unused = YWVideoCallBll.this.mHasJoinRTC = true;
                    }
                }

                public void remotefirstVideoRecvWithUid(long j, String str) {
                    XesLogTag access$500 = YWVideoCallBll.this.TAG;
                    XesLog.i(access$500, "主讲上麦", "==================" + str + "remotefirstVideoRecvWithUid回调过来的uid:" + j);
                    if ("Channel".equals(str)) {
                        long unused = YWVideoCallBll.this.mReceiveFirstVideoUid = j;
                        if (j == YWVideoCallBll.this.mOnMicUid && YWVideoCallBll.this.mPager != null) {
                            String unused2 = YWVideoCallBll.this.mCameraAvailable = "1";
                            YWVideoCallBll.this.mPager.setSpeaker(YWVideoCallBll.this.mOnMicName, YWVideoCallBll.this.mOnMicClassName, YWVideoCallBll.this.mCameraAvailable, YWVideoCallBll.this.isTarget);
                            YWVideoCallBll.this.mPager.showVideoMask(false, 1);
                        }
                    }
                }

                public void remotefirstAudioRecvWithUid(long j, String str) {
                    if ("Channel".equals(str) && YWVideoCallBll.this.mPager != null && YWVideoCallBll.this.mOnMicUid == j) {
                        if (YWVideoCallBll.this.isTarget) {
                            YWVideoCallBll.this.trackInteractiveLog("TargetLinkMic", "AudioDisplay", 1, "");
                        } else {
                            YWVideoCallBll.this.trackInteractiveLog("NormalLinkMic", "AudioDisplay", 1, "");
                        }
                    }
                }

                public void didOfflineOfUid(long j, String str) {
                    if ("Channel".equals(str)) {
                        if (YWVideoCallBll.this.mPager != null && YWVideoCallBll.this.mOnMicUid == j) {
                            YWVideoCallBll.this.mPager.showVideoMask(true, 3);
                        }
                        if (j == ParseUtils.tryParseLong(YWVideoCallBll.this.mEnterConfigProxy.getRtcConfig().getTeacherAudioUid(), -1) || j == ParseUtils.tryParseLong(YWVideoCallBll.this.mEnterConfigProxy.getRtcConfig().getTutorUid(), -1)) {
                            YWVideoCallBll.this.teacherQuit();
                        }
                    }
                }

                public void didVideoMuted(long j, boolean z, String str) {
                    if ("Channel".equals(str) && YWVideoCallBll.this.mPager != null && YWVideoCallBll.this.mOnMicUid == j) {
                        if (z) {
                            YWVideoCallBll.this.mPager.setSpeaker(YWVideoCallBll.this.mOnMicName, YWVideoCallBll.this.mOnMicClassName, "2", YWVideoCallBll.this.isTarget);
                        } else {
                            YWVideoCallBll.this.mPager.setSpeaker(YWVideoCallBll.this.mOnMicName, YWVideoCallBll.this.mOnMicClassName, "1", YWVideoCallBll.this.isTarget);
                        }
                        YWVideoCallBll.this.mPager.showVideoMask(false, 1);
                    }
                }

                public void onRemoteVideoStateChanged(long j, int i, String str) {
                    XesLogTag access$500 = YWVideoCallBll.this.TAG;
                    XesLog.i(access$500, "主讲上麦", "==================" + str + "onRemoteVideoStateChanged回调过来的state:" + i + "uid:" + j);
                }
            });
            this.mRtcEngine.setVideoEncoderConfiguration(320, 240, RTCEngine.RTCEngineVideoBitrate.VIDEO_BITRATE_100, RTCEngine.RTC_ORIENTATION_MODE.RTC_ORIENTATION_MODE_ADAPTIVE);
        }
    }

    private void stopRTC() {
        EnterConfigProxy enterConfigProxy;
        RTCChannel rTCChannel;
        IRTCEngineProvider iRTCEngineProvider = this.mRtcEngineProvider;
        if (iRTCEngineProvider != null) {
            iRTCEngineProvider.removeRtcEngineEventListener(VideoCallConfig.TAG);
        }
        IRTCEngineProvider iRTCEngineProvider2 = this.mRtcEngineProvider;
        if (iRTCEngineProvider2 != null) {
            iRTCEngineProvider2.release();
            if (!(this.mSpeakingState != 1 || this.mRtcEngine == null || (enterConfigProxy = this.mEnterConfigProxy) == null || enterConfigProxy.getRtcConfig() == null || (rTCChannel = this.mRtcEngineChannel) == null)) {
                rTCChannel.muteLocalVideo(true);
                this.mRtcEngineChannel.muteLocalAudio(true);
                this.mRtcEngineChannel.setRole(RTCEngine.RTCRole.RTCRoleAudience);
                if (this.isMuteVideo == 1) {
                    this.mRtcEngine.muteLocalVideo(false);
                    RtcViewModel rtcViewModel = this.mRtcViewModel;
                    if (rtcViewModel != null) {
                        rtcViewModel.setMLocalVideoEnable(true);
                    }
                } else {
                    this.mRtcEngine.muteLocalVideo(true);
                    RtcViewModel rtcViewModel2 = this.mRtcViewModel;
                    if (rtcViewModel2 != null) {
                        rtcViewModel2.setMLocalVideoEnable(false);
                    }
                }
                this.mRtcEngine.muteLocalAudio(false);
                this.mRtcEngine.setRole(RTCEngine.RTCRole.RTCRoleBroadcaster);
                this.mRtcEngine.setDefaultMuteAllRemoteAudioStreams(true);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("自己上完麦老师结束上麦互动", "加入mRtcEngine是否成功");
                XesLog.ut(VideoCallConfig.TAG, jsonObject);
            }
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("别人上完麦老师结束上麦互动", "结束上麦互动");
            XesLog.ut(VideoCallConfig.TAG, jsonObject2);
        }
    }

    /* access modifiers changed from: private */
    public void updateUI() {
        if (this.mPager != null) {
            LiveMainHandler.post(new YWVideoCallBll$$ExternalSyntheticLambda3(this));
        }
    }

    public /* synthetic */ void lambda$updateUI$2$YWVideoCallBll() {
        VideoCallPager videoCallPager = this.mPager;
        if (videoCallPager != null) {
            videoCallPager.updateUI(this.mSpeakingState, this.mRaiseHandState, this.isVideoCallOn, this.isTarget);
        }
    }

    /* access modifiers changed from: private */
    public void updateUIisSpeaking() {
        if (this.mPager != null) {
            LiveMainHandler.post(new YWVideoCallBll$$ExternalSyntheticLambda4(this));
        }
    }

    public /* synthetic */ void lambda$updateUIisSpeaking$3$YWVideoCallBll() {
        VideoCallPager videoCallPager = this.mPager;
        if (videoCallPager != null) {
            videoCallPager.updateUIisSpeaking(this.mSpeakingState, this.mRaiseHandState, this.isVideoCallOn);
        }
    }

    /* access modifiers changed from: private */
    public void checkPermissions(boolean z, boolean z2) {
        this.checkPermission = true;
        applyPermission(z, z2);
    }

    private void linkMickRequest(final boolean z) {
        int i;
        int i2;
        if ((this.isVideoCallOn || this.isTarget) && this.mInteractId != null) {
            IRTCEngineProvider iRTCEngineProvider = this.mRtcEngineProvider;
            if (iRTCEngineProvider != null) {
                i2 = iRTCEngineProvider.getOnceLastMileQuality();
                i = this.mRtcEngineProvider.getLinkType();
            } else {
                i2 = 1;
                i = 1;
            }
            this.mVideoCallHelper.linkMicRequest(this.mInteractId, this.mFrom, i2, i, PermissionUtils.isGranted("android.permission.CAMERA") ? 1 : 2, PermissionUtils.isGranted("android.permission.RECORD_AUDIO") ? 1 : 2, new VideoCallHelper.Callback<String>() {
                public void onSuccess(String str) {
                    String unused = YWVideoCallBll.this.mClassName = str;
                    int unused2 = YWVideoCallBll.this.mRaiseHandState = 1;
                    XesLog.i(YWVideoCallBll.this.TAG, "举手接口成功", str);
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("举手接口成功", str);
                    XesLog.ut(VideoCallConfig.TAG, jsonObject);
                    if (!YWVideoCallBll.this.isTarget) {
                        if (z) {
                            YWVideoCallBll.this.updateUIisSpeaking();
                        } else {
                            YWVideoCallBll.this.updateUI();
                        }
                        YWVideoCallBll.this.trackInteractiveLog("NormalLinkMic", "requestMicro", 1, "");
                    }
                }

                public void onFail(int i) {
                    if (!YWVideoCallBll.this.isTarget) {
                        YWVideoCallBll yWVideoCallBll = YWVideoCallBll.this;
                        yWVideoCallBll.trackInteractiveLog("NormalLinkMic", "requestMicro", 0, i + "");
                    }
                }
            });
        }
    }

    private void applyPermission(boolean z, boolean z2) {
        new RxPermissions(this.mContext).request(new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}).subscribe(new YWVideoCallBll$$ExternalSyntheticLambda0(this, z2, z));
    }

    public /* synthetic */ void lambda$applyPermission$4$YWVideoCallBll(boolean z, boolean z2, Boolean bool) throws Throwable {
        this.hasPermission = true;
        if (this.mRtcEngine != null && !z) {
            linkMickRequest(z2);
        }
    }

    /* access modifiers changed from: private */
    public void trackInteractiveLog(String str, String str2, int i, String str3) {
        InteractReportKt.XesLogReport(str2, str, this.mInteractId, Integer.valueOf(i), str3);
    }
}
