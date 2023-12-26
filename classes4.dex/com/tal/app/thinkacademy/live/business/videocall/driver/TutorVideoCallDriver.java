package com.tal.app.thinkacademy.live.business.videocall.driver;

import android.content.Context;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.eaydu.omni.RTCChannel;
import com.eaydu.omni.RTCEngine;
import com.eaydu.omni.listener.RTCConnectionStateType;
import com.google.gson.JsonObject;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.irc.IrcKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.player.rtcplayer.IRTCEngineProvider;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineProviderUtils;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayerEngineEventListener;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.videocall.pager.TutorVideoCallPager;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.http.bean.RtcConfig;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(classType = 0, desc = "辅导连麦", ircType = {"video_mic_f", "local_joinRoom", "mode"}, moduleId = "333", noActiveKey = {"mode"})
@ViewLevels({@ViewLevel(level = 120, name = "TutorVideoCallView")})
public class TutorVideoCallDriver extends BaseLivePluginDriver {
    public final XesLogTag TAG = Tag.TUTOR_VIDEO_CALL;
    public final String TutorVideoCallPluginKey = "video_mic_f";
    private final String UT_TAG = "TutorVideoCall";
    /* access modifiers changed from: private */
    public boolean isTutorVideoCallOn = false;
    private Context mContext;
    private String mCurrentMode = "";
    private View.OnClickListener mExitClick = new TutorVideoCallDriver$$ExternalSyntheticLambda0(this);
    private long mInteractionId = -1;
    private boolean mIsExquisite = false;
    private ILiveRoomProvider mLiveRoomProvider;
    /* access modifiers changed from: private */
    public TutorVideoCallPager mPager;
    private IRTCEngineProvider.RTCEngineCallback mRTCEngineCallback = new IRTCEngineProvider.RTCEngineCallback() {
        public void onGetRTCEngineFail(int i, int i2) {
        }

        public void onGetRTCEngine(RTCEngine rTCEngine, RTCChannel rTCChannel) {
            RTCEngine unused = TutorVideoCallDriver.this.mRtcEngine = rTCEngine;
            RTCChannel unused2 = TutorVideoCallDriver.this.mRtcEngineChannel = rTCChannel;
            TutorVideoCallDriver tutorVideoCallDriver = TutorVideoCallDriver.this;
            tutorVideoCallDriver.startTutorRTC(tutorVideoCallDriver.mRtcEngineProvider);
        }
    };
    private RtcConfig mRtcConfig;
    /* access modifiers changed from: private */
    public RTCEngine mRtcEngine;
    /* access modifiers changed from: private */
    public RTCChannel mRtcEngineChannel;
    /* access modifiers changed from: private */
    public IRTCEngineProvider mRtcEngineProvider;
    /* access modifiers changed from: private */
    public long mSelfUid;
    private Map<Long, SurfaceView> mSurfaceViewMap = new HashMap();
    /* access modifiers changed from: private */
    public long mTutorUid;

    public TutorVideoCallDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mLiveRoomProvider = iLiveRoomProvider;
        this.mSelfUid = ParseUtils.tryParseLong(iLiveRoomProvider.getDataStorage().getUserInfo().getId(), 0);
        this.mTutorUid = (long) iLiveRoomProvider.getDataStorage().getCourseInfo().getTutorId();
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        this.mRtcConfig = iLiveRoomProvider.getDataStorage().getEnterConfig().getRtcConfig();
        this.mIsExquisite = "2".equals(iLiveRoomProvider.getClassType());
    }

    public void onDestroy() {
        try {
            for (Map.Entry next : this.mSurfaceViewMap.entrySet()) {
                SurfaceView surfaceView = (SurfaceView) next.getValue();
                Long l = (Long) next.getKey();
                if (surfaceView != null) {
                    if (surfaceView.getParent() != null) {
                        ((ViewGroup) surfaceView.getParent()).removeView(surfaceView);
                        XesLogTag xesLogTag = this.TAG;
                        XesLog.i(xesLogTag, "开始移除，uid=" + l);
                    } else {
                        XesLogTag xesLogTag2 = this.TAG;
                        XesLog.i(xesLogTag2, "没有父视图，不需要移除，uid=" + l);
                    }
                    if (surfaceView.getParent() != null) {
                        XesLogTag xesLogTag3 = this.TAG;
                        XesLog.i(xesLogTag3, "检查：未移除掉！uid=" + l);
                    } else {
                        XesLogTag xesLogTag4 = this.TAG;
                        XesLog.i(xesLogTag4, "检查：已经移除！uid=" + l);
                    }
                } else {
                    XesLogTag xesLogTag5 = this.TAG;
                    XesLog.i(xesLogTag5, "surfaceView为空，不需要移除！uid=" + l);
                }
            }
        } catch (Exception e) {
            XesLogTag xesLogTag6 = this.TAG;
            XesLog.i(xesLogTag6, "遍历移除surfaceView引用失败=" + e);
        }
        stopRTC();
        TutorVideoCallPager tutorVideoCallPager = this.mPager;
        if (tutorVideoCallPager != null) {
            tutorVideoCallPager.onDestroy();
            closeVideoCall();
        }
        this.isTutorVideoCallOn = false;
        this.mSurfaceViewMap.clear();
        this.mInteractionId = -1;
    }

    public void onMessage(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -644962439) {
                if (hashCode != 3357091) {
                    if (hashCode == 1379740586) {
                        if (str.equals("video_mic_f")) {
                            c = 0;
                        }
                    }
                } else if (str.equals("mode")) {
                    c = 2;
                }
            } else if (str.equals(IrcKey.LOCAL_JOIN_ROOM)) {
                c = 1;
            }
            if (c == 0) {
                XesLog.i(this.TAG, str2);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("收到辅导老师video_mic信令", str2);
                XesLog.ut("TutorVideoCall", jsonObject);
                handleTutorNotice(jSONObject.optJSONObject(str));
            } else if (c == 1) {
                XesLog.i(this.TAG, str2);
            } else if (c == 2) {
                XesLog.i(this.TAG, str2);
                this.mCurrentMode = jSONObject.optString("mode", "");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void handleTutorNotice(JSONObject jSONObject) {
        Class<TutorVideoCallDriver> cls = TutorVideoCallDriver.class;
        jSONObject.optString("from");
        long optLong = jSONObject.optLong("interactId");
        jSONObject.optBoolean("pub");
        int optInt = jSONObject.optInt("status");
        if (this.mSelfUid == jSONObject.optLong("studentId")) {
            if (optInt != 1) {
                if (optInt != 2) {
                    if (optInt == 3) {
                        videoCallOff();
                        trackInteractiveLog("TutorLinkMic", "end", 1, "");
                    }
                } else if (this.mPager != null && this.isTutorVideoCallOn) {
                    initVideoView();
                    initRtcEngine();
                    initClickListen();
                    showTutorVideo();
                    PluginEventBus.onEvent(DataBusKey.VIDEO_CALL_F_STATUS, new PluginEventData(cls, DataBusKey.VIDEO_CALL_F_STATUS, "videoCallTutorOn"));
                    XesDataBus.with(DataBusKey.CLASS_TUTOR_VIDEO_CALL).postStickyData(true);
                }
            } else if (this.mInteractionId != optLong && !this.isTutorVideoCallOn) {
                trackInteractiveLog("TutorLinkMic", "start", 1, "");
                PluginEventBus.onEvent(DataBusKey.VIDEO_CALL_F_STATUS, new PluginEventData(cls, DataBusKey.VIDEO_CALL_F_STATUS, "videoCallTutorStart"));
                this.mInteractionId = optLong;
                this.isTutorVideoCallOn = true;
                if (this.mPager == null) {
                    this.mPager = new TutorVideoCallPager(this.mContext, this.mLiveRoomProvider.getDataStorage().getCounselorInfo().getAvatar());
                }
            }
        }
    }

    private void initRtcEngine() {
        HWEventTracking.get().ostaIaVideoLink("", "guiding_teacher", "start");
        this.mRtcEngineProvider = RTCEngineProviderUtils.getInstance().get("Live");
        XesLog.dt("TutorVideoCall", "辅导老师开启视频连麦，上麦时获取mRtcEngineProvider：", "mRtcEngineProvider is" + this.mRtcEngineProvider);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("开启视频连麦，上麦时获取mRtcEngineProvider：", "mRtcEngineProvider is" + this.mRtcEngineProvider);
        XesLog.ut("TutorVideoCall", jsonObject);
        IRTCEngineProvider iRTCEngineProvider = this.mRtcEngineProvider;
        if (iRTCEngineProvider != null) {
            iRTCEngineProvider.provide("video_mic_f", this.mRTCEngineCallback);
        }
    }

    private void initVideoView() {
        FrameLayout.LayoutParams newLp = LiveAreaContext.get().getHeadLp().newLp();
        newLp.height += LiveAreaContext.get().getMsgLp().height;
        this.mLiveRoomProvider.addView(this, this.mPager, "TutorVideoCallView", newLp);
        LiveAreaContext.get().layoutObserver.observe(this, new TutorVideoCallDriver$$ExternalSyntheticLambda1(this));
    }

    public /* synthetic */ void lambda$initVideoView$0$TutorVideoCallDriver(LiveAreaContext liveAreaContext) {
        FrameLayout.LayoutParams layoutParams;
        TutorVideoCallPager tutorVideoCallPager = this.mPager;
        if (tutorVideoCallPager != null && (layoutParams = (FrameLayout.LayoutParams) tutorVideoCallPager.getLayoutParams()) != null) {
            liveAreaContext.getHeadLp().mergeLp(layoutParams);
            layoutParams.height += liveAreaContext.getMsgLp().height;
            this.mPager.setLayoutParams(layoutParams);
        }
    }

    public /* synthetic */ void lambda$new$1$TutorVideoCallDriver(View view) {
        videoCallOff();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void initClickListen() {
        TutorVideoCallPager tutorVideoCallPager = this.mPager;
        if (tutorVideoCallPager != null) {
            tutorVideoCallPager.setExitClickListener(this.mExitClick);
        }
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.view.View, com.tal.app.thinkacademy.live.business.videocall.pager.TutorVideoCallPager] */
    private void closeVideoCall() {
        RtcConfig rtcConfig;
        RtcConfig rtcConfig2;
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngine.setDefaultMuteAllRemoteAudioStreams(true);
            this.mRtcEngine.muteRemoteAudio(this.mTutorUid, true);
            this.mRtcEngine.muteRemoteVideo(this.mTutorUid, true);
        }
        if (!this.mIsExquisite) {
            RTCChannel rTCChannel = this.mRtcEngineChannel;
            if (!(rTCChannel == null || (rtcConfig2 = this.mRtcConfig) == null)) {
                rTCChannel.muteRemoteAudio(ParseUtils.tryParseLong(rtcConfig2.getTeacherAudioUid(), -1), false);
            }
        } else {
            RTCEngine rTCEngine2 = this.mRtcEngine;
            if (!(rTCEngine2 == null || (rtcConfig = this.mRtcConfig) == null)) {
                rTCEngine2.muteRemoteAudio(ParseUtils.tryParseLong(rtcConfig.getTeacherAudioUid(), -1), false);
            }
        }
        this.mLiveRoomProvider.removeView(this.mPager);
        this.mPager = null;
        PluginEventBus.onEvent(DataBusKey.VIDEO_CALL_F_STATUS, new PluginEventData(TutorVideoCallDriver.class, DataBusKey.VIDEO_CALL_F_STATUS, "videoCallTutorOff"));
        XesDataBus.with(DataBusKey.CLASS_TUTOR_VIDEO_CALL).postStickyData(false);
    }

    private void showTutorVideo() {
        RtcConfig rtcConfig;
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngine.muteLocalAudio(false);
            this.mRtcEngine.muteRemoteAudio(this.mTutorUid, false);
            this.mRtcEngine.muteRemoteVideo(this.mTutorUid, false);
            if (!this.mIsExquisite) {
                RTCChannel rTCChannel = this.mRtcEngineChannel;
                if (!(rTCChannel == null || (rtcConfig = this.mRtcConfig) == null)) {
                    rTCChannel.muteRemoteAudio(ParseUtils.tryParseLong(rtcConfig.getTeacherAudioUid(), -1), true);
                }
            } else {
                RtcConfig rtcConfig2 = this.mRtcConfig;
                if (rtcConfig2 != null) {
                    this.mRtcEngine.muteRemoteAudio(ParseUtils.tryParseLong(rtcConfig2.getTeacherAudioUid(), -1), true);
                }
            }
            XesLog.dt("TutorVideoCall", "辅导连麦开始渲染");
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("TutorVideoCall", "辅导连麦:renderVideo");
            XesLog.ut("TutorVideoCall", jsonObject);
            SurfaceView surfaceView = this.mSurfaceViewMap.get(Long.valueOf(this.mTutorUid));
            if (surfaceView == null && (surfaceView = this.mRtcEngine.createRendererView()) != null) {
                surfaceView.setZOrderOnTop(true);
                this.mSurfaceViewMap.put(Long.valueOf(this.mTutorUid), surfaceView);
            }
            if (surfaceView != null) {
                this.mRtcEngine.setupRemoteVideo(surfaceView, this.mTutorUid);
                if (this.mPager != null) {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject.addProperty("TutorVideoCall", "辅导连麦:renderVideo时mPager!=null");
                    XesLog.ut("TutorVideoCall", jsonObject2);
                    this.mPager.removeRenderView();
                    this.mPager.addRenderView(surfaceView);
                    surfaceView.setZOrderMediaOverlay(true);
                }
            }
        }
    }

    public void videoCallOff() {
        if (this.isTutorVideoCallOn) {
            HWEventTracking.get().ostaIaVideoLink("", "guiding_teacher", "end");
            XesLog.i(this.TAG, "辅导老师关闭视频连麦");
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("收到连麦关闭", "关闭视频连麦");
            XesLog.ut("TutorVideoCall", jsonObject);
            stopRTC();
            TutorVideoCallPager tutorVideoCallPager = this.mPager;
            if (tutorVideoCallPager != null) {
                tutorVideoCallPager.onDestroy();
                closeVideoCall();
            }
            this.isTutorVideoCallOn = false;
            this.mSurfaceViewMap.clear();
            this.mInteractionId = -1;
        }
    }

    public void teacherQuit() {
        videoCallOff();
    }

    /* access modifiers changed from: private */
    public void startTutorRTC(IRTCEngineProvider iRTCEngineProvider) {
        if (this.mRtcEngine != null) {
            iRTCEngineProvider.addEtcEngineEventListener("TutorVideoCall", new RtcPlayerEngineEventListener() {
                public void didAudioMuted(long j, boolean z, String str) {
                }

                public void localUserJoindWithUid(long j, String str) {
                }

                public void onOnceLastMileQuality(int i, String str) {
                }

                public void remotefirstAudioRecvWithUid(long j, String str) {
                }

                public void reportAudioVolumeOfSpeaker(long j, int i) {
                    if (j == TutorVideoCallDriver.this.mTutorUid) {
                        TutorVideoCallDriver tutorVideoCallDriver = TutorVideoCallDriver.this;
                        tutorVideoCallDriver.trackInteractiveLog("TutorLinkMic", "AudioDisplay", 1, "mTutorUid" + j + "辅导的声音：" + i);
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("reportAudioVolumeOfSpeaker", "mTutorUid" + j + "辅导的声音：" + i);
                        XesLog.ut("TutorVideoCall", jsonObject);
                    }
                }

                public void remoteUserJoinWitnUid(long j, String str) {
                    if ("Engine".equals(str)) {
                        ThreadUtils.runOnUiThread(new TutorVideoCallDriver$2$$ExternalSyntheticLambda2(this, j));
                    }
                }

                public /* synthetic */ void lambda$remoteUserJoinWitnUid$0$TutorVideoCallDriver$2(long j) {
                    if (j == TutorVideoCallDriver.this.mTutorUid) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("remoteUserJoinWitnUid", "辅导老师" + j);
                        XesLog.ut("TutorVideoCall", jsonObject);
                        if (TutorVideoCallDriver.this.isTutorVideoCallOn) {
                            TutorVideoCallDriver.this.teacherQuit();
                        }
                    }
                }

                public void dispatchConnectionState(RTCConnectionStateType rTCConnectionStateType, String str, String str2) {
                    if ("Engine".equals(str2)) {
                        ThreadUtils.runOnUiThread(new TutorVideoCallDriver$2$$ExternalSyntheticLambda4(this, rTCConnectionStateType, str, str2));
                    }
                }

                public /* synthetic */ void lambda$dispatchConnectionState$1$TutorVideoCallDriver$2(RTCConnectionStateType rTCConnectionStateType, String str, String str2) {
                    if (RTCConnectionStateType.RTCConnectionStateTypeConnected != rTCConnectionStateType) {
                        XesLog.i(TutorVideoCallDriver.this.TAG, "辅导rtc  断开连接");
                        if (TutorVideoCallDriver.this.mPager != null) {
                            TutorVideoCallDriver tutorVideoCallDriver = TutorVideoCallDriver.this;
                            tutorVideoCallDriver.trackInteractiveLog("TutorLinkMic", "videoDisplay", 0, "state:" + rTCConnectionStateType + "reason:" + str + "type:" + str2);
                        }
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("dispatchConnectionState", "RTCConnectionStateTypeDisconnected：自己的rtc连接断开");
                        XesLog.ut("TutorVideoCall", jsonObject);
                    } else if (TutorVideoCallDriver.this.mPager != null) {
                        TutorVideoCallDriver.this.mPager.hideMask();
                        JsonObject jsonObject2 = new JsonObject();
                        jsonObject2.addProperty("dispatchConnectionState", "RTCConnectionStateTypeConnected：自己的rtc连接成功");
                        XesLog.ut("TutorVideoCall", jsonObject2);
                    }
                }

                public void remotefirstVideoRecvWithUid(long j, String str) {
                    if ("Engine".equals(str) && j == TutorVideoCallDriver.this.mTutorUid) {
                        ThreadUtils.runOnUiThread(new TutorVideoCallDriver$2$$ExternalSyntheticLambda3(this, j));
                    }
                }

                public /* synthetic */ void lambda$remotefirstVideoRecvWithUid$2$TutorVideoCallDriver$2(long j) {
                    if (TutorVideoCallDriver.this.mPager != null) {
                        TutorVideoCallDriver.this.mPager.hideMask();
                    }
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("remotefirstVideoRecvWithUid", "收到辅导首帧视频，mTutorUid：" + j);
                    XesLog.ut("TutorVideoCall", jsonObject);
                }

                public void didOfflineOfUid(long j, String str) {
                    if ("Engine".equals(str)) {
                        ThreadUtils.runOnUiThread(new TutorVideoCallDriver$2$$ExternalSyntheticLambda1(this, j));
                    }
                }

                public /* synthetic */ void lambda$didOfflineOfUid$3$TutorVideoCallDriver$2(long j) {
                    if (j == TutorVideoCallDriver.this.mTutorUid) {
                        TutorVideoCallDriver.this.teacherQuit();
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("didOfflineOfUid", "辅导退出房间" + j);
                        XesLog.ut("TutorVideoCall", jsonObject);
                    }
                }

                public void didVideoMuted(long j, boolean z, String str) {
                    if (!"Engine".equals(str)) {
                        return;
                    }
                    if (j == TutorVideoCallDriver.this.mSelfUid) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("didVideoMuted", "自己" + j + " mute状态 " + z);
                        XesLog.ut("TutorVideoCall", jsonObject);
                    } else if (j == TutorVideoCallDriver.this.mTutorUid) {
                        JsonObject jsonObject2 = new JsonObject();
                        jsonObject2.addProperty("didVideoMuted", "辅导老师" + j + " mute状态 " + z);
                        XesLog.ut("TutorVideoCall", jsonObject2);
                    }
                }

                public void onRemoteVideoStateChanged(long j, int i, String str) {
                    ThreadUtils.runOnUiThread(new TutorVideoCallDriver$2$$ExternalSyntheticLambda0(this, i, str, j));
                }

                public /* synthetic */ void lambda$onRemoteVideoStateChanged$4$TutorVideoCallDriver$2(int i, String str, long j) {
                    if (i == 0) {
                        if ("Engine".equals(str) && j == TutorVideoCallDriver.this.mTutorUid) {
                            TutorVideoCallPager unused = TutorVideoCallDriver.this.mPager;
                        }
                    } else if (i == 2 && "Engine".equals(str) && j == TutorVideoCallDriver.this.mTutorUid && TutorVideoCallDriver.this.mPager != null) {
                        TutorVideoCallDriver.this.mPager.hideMask();
                        TutorVideoCallDriver.this.trackInteractiveLog("TutorLinkMic", "videoDisplay", 1, "");
                    }
                }
            });
            this.mRtcEngine.setVideoEncoderConfiguration(320, 240, RTCEngine.RTCEngineVideoBitrate.VIDEO_BITRATE_100, RTCEngine.RTC_ORIENTATION_MODE.RTC_ORIENTATION_MODE_ADAPTIVE);
        }
    }

    private void stopRTC() {
        IRTCEngineProvider iRTCEngineProvider = this.mRtcEngineProvider;
        if (iRTCEngineProvider != null) {
            iRTCEngineProvider.removeRtcEngineEventListener("TutorVideoCall");
        }
        IRTCEngineProvider iRTCEngineProvider2 = this.mRtcEngineProvider;
        if (iRTCEngineProvider2 != null) {
            iRTCEngineProvider2.release();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("TutorVideoCall", "辅导老师结束上麦互动");
            XesLog.ut("TutorVideoCall", jsonObject);
        }
    }

    /* access modifiers changed from: private */
    public void trackInteractiveLog(String str, String str2, int i, String str3) {
        InteractReportKt.XesLogReport(str2, str, this.mInteractionId + "", Integer.valueOf(i), str3);
    }
}
