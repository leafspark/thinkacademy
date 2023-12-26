package com.tal.app.thinkacademy.live.business.videocall.driver;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.irc.IrcKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.videocall.bll.IVideoCallAction;
import com.tal.app.thinkacademy.live.business.videocall.bll.VideoCallHelper;
import com.tal.app.thinkacademy.live.business.videocall.bll.YWVideoCallBll;
import com.tal.app.thinkacademy.live.business.videocall.config.VideoCallConfig;
import com.tal.app.thinkacademy.live.business.videocall.entity.StudentEntity;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.interfaces.IircControllerProvider;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.tal.app.thinkacademy.live.core.live.http.bean.CounselorInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import com.tal.app.thinkacademy.live.util.LiveMainHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(desc = "视频连麦", ircType = {"video_mic", "local_joinRoom", "mode"}, moduleId = "102", noActiveKey = {"mode"})
@ViewLevels({@ViewLevel(level = 120, name = "VideoCallView")})
public class VideoCallDriver extends BaseLivePluginDriver {
    private static final XesLogTag TAG = Tag.VIDEO_CALL;
    private int cpuMax;
    /* access modifiers changed from: private */
    public int isMuteVideo = 1;
    private volatile int lastHandNum = 0;
    private WeakReference<Context> mContext;
    private CourseInfoProxy mCourseInfoProxy;
    private CounselorInfoProxy mCourselorInfoProxy;
    private String mCurrentMode = "";
    private String mInteractionId = "";
    private IircControllerProvider mIrcControllerProvider;
    private RoomData mRoomData;
    private String mUId;
    private UserInfoProxy mUserInfoProxy;
    public Observer<PluginEventData> observerVideoMuteStatus = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if ("1".equals(pluginEventData.getData())) {
                int unused = VideoCallDriver.this.isMuteVideo = 1;
            } else {
                int unused2 = VideoCallDriver.this.isMuteVideo = 2;
            }
        }
    };
    private int rtcQuality = 3;
    private IVideoCallAction videoCallBll;
    private VideoCallHelper videoCallHelper;

    public VideoCallDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mUserInfoProxy = iLiveRoomProvider.getDataStorage().getUserInfo();
        this.mCourseInfoProxy = iLiveRoomProvider.getDataStorage().getCourseInfo();
        this.mCourselorInfoProxy = iLiveRoomProvider.getDataStorage().getCounselorInfo();
        this.mContext = iLiveRoomProvider.getWeakRefContext();
        this.mRoomData = iLiveRoomProvider.getDataStorage().getRoomData();
        this.videoCallHelper = new VideoCallHelper(iLiveRoomProvider, this);
        this.videoCallBll = new YWVideoCallBll(iLiveRoomProvider, this.videoCallHelper, this);
        this.mUId = this.mUserInfoProxy.getId();
        this.mCurrentMode = this.mRoomData.getMode();
        PluginEventBus.register(this, DataBusKey.USER_MUTE_VIDEO_KEY, this.observerVideoMuteStatus);
    }

    /* access modifiers changed from: protected */
    public void onLifecyclePause(LifecycleOwner lifecycleOwner) {
        VideoCallDriver.super.onLifecyclePause(lifecycleOwner);
        IVideoCallAction iVideoCallAction = this.videoCallBll;
        if (iVideoCallAction != null) {
            iVideoCallAction.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onLifecycleResume(LifecycleOwner lifecycleOwner) {
        VideoCallDriver.super.onLifecycleResume(lifecycleOwner);
        IVideoCallAction iVideoCallAction = this.videoCallBll;
        if (iVideoCallAction != null) {
            iVideoCallAction.onResume();
        }
    }

    public void onDestroy() {
        IVideoCallAction iVideoCallAction = this.videoCallBll;
        if (iVideoCallAction != null) {
            iVideoCallAction.destroy();
        }
        this.mInteractionId = "";
    }

    public boolean isInTraningMode() {
        return "in-training".equals(this.mCurrentMode);
    }

    public void requestMicro(int i, String str, String str2, String str3, String str4, String str5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", 125);
            jSONObject.put("status", 6);
            jSONObject.put("id", this.mUId);
            jSONObject.put("name", this.mUserInfoProxy.getNickName());
            jSONObject.put("image", this.mUserInfoProxy.getAvatar());
            jSONObject.put("classId", this.mCourseInfoProxy.getClassId());
            jSONObject.put("tutorName", this.mCourselorInfoProxy.getName());
            jSONObject.put("cameraAvailable", str4);
            jSONObject.put("mikeAvailable", str5);
            jSONObject.put("cameraIsOpen", this.isMuteVideo);
            XesLogTag xesLogTag = TAG;
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("举手：");
            sb.append(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            objArr[0] = sb.toString();
            XesLog.i(xesLogTag, objArr);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("linkMicRequest连麦举手：", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            XesLog.ut(VideoCallConfig.TAG, jsonObject);
            if (this.mIrcControllerProvider == null) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("linkMicRequest连麦举手：requestMicro：", "disconnected from server");
                XesLog.ut(VideoCallConfig.TAG, jsonObject2);
                ToastUtils.showShort((CharSequence) "disconnected from server");
                return;
            }
            JsonObject jsonObject3 = new JsonObject();
            jsonObject3.addProperty("linkMicRequest连麦举手：requestMicro：", "向老师发送举手消息成功");
            XesLog.ut(VideoCallConfig.TAG, jsonObject3);
            this.mIrcControllerProvider.sendPeerMessage(str, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), 0);
        } catch (Exception e) {
            e.printStackTrace();
            JsonObject jsonObject4 = new JsonObject();
            jsonObject4.addProperty("linkMicRequest连麦举手：requestMicro：", "举手错误" + e);
            XesLog.ut(VideoCallConfig.TAG, jsonObject4);
            XesLog.i(TAG, "举手错误", e);
        }
    }

    public void giveupMicro(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "125");
            jSONObject.put("status", 7);
            jSONObject.put("id", this.mUId);
            IircControllerProvider iircControllerProvider = this.mIrcControllerProvider;
            if (iircControllerProvider == null) {
                ToastUtils.showShort((CharSequence) "disconnected from server");
                trackInteractiveLog("NormalLinkMic", "giveupMicro", 0);
            } else {
                iircControllerProvider.sendPeerMessage(str, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), 0);
                trackInteractiveLog("NormalLinkMic", "giveupMicro", 1);
            }
            XesLog.i(TAG, "取消举手");
        } catch (Exception e) {
            e.printStackTrace();
            XesLog.i(TAG, "取消举手错误", e);
            trackInteractiveLog("NormalLinkMic", "giveupMicro", 0);
        }
    }

    public void track_click_video(String str, String str2) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("interactId", str2);
        trackMap.put(LeanplumUtil.time, System.currentTimeMillis() + "");
        LeanplumUtil.commonTrack(str, trackMap);
    }

    public void handleNotice(JSONObject jSONObject) {
        boolean z;
        JSONObject jSONObject2 = jSONObject;
        String optString = jSONObject2.optString("from");
        String optString2 = jSONObject2.optString("interactId");
        boolean optBoolean = jSONObject2.optBoolean("open");
        int optInt = jSONObject2.optInt("status");
        boolean optBoolean2 = jSONObject2.optBoolean("targeted");
        JSONArray optJSONArray = jSONObject2.optJSONArray("data");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            z = false;
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                StudentEntity studentEntity = new StudentEntity(optJSONObject.optString("id"), optJSONObject.optString("name"));
                studentEntity.setClassName(optJSONObject.optString("className", ""));
                studentEntity.cameraAvailable = optJSONObject.optString("cameraAvailable", "");
                studentEntity.cameraIsOpen = optJSONObject.optString("cameraIsOpen", "");
                arrayList.add(studentEntity);
                if (!TextUtils.isEmpty(this.mUId) && studentEntity.getId().equals(this.mUId)) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        if (this.videoCallBll != null) {
            if (optInt != 1) {
                if (optInt == 2) {
                    LiveMainHandler.post(new VideoCallDriver$$ExternalSyntheticLambda3(this, optBoolean2));
                } else if (optInt != 3) {
                    if (optInt != 4) {
                        if (optInt == 8) {
                            LiveMainHandler.post(new VideoCallDriver$$ExternalSyntheticLambda1(this));
                            XesLog.i(TAG, "教师端退出之后重新进入，视频连麦恢复初始未连麦状态");
                            return;
                        } else if (optInt != 21) {
                            if (optInt == 22) {
                                LiveMainHandler.post(new VideoCallDriver$$ExternalSyntheticLambda4(this, optBoolean2));
                                return;
                            }
                            return;
                        }
                    }
                    int optInt2 = jSONObject2.optInt("orderType", 0);
                    LiveMainHandler.post(new VideoCallDriver$$ExternalSyntheticLambda6(this, optBoolean, optBoolean2, optString2, optString, arrayList));
                    if (optJSONArray != null) {
                        LiveMainHandler.post(new VideoCallDriver$$ExternalSyntheticLambda2(this, optInt2, arrayList, z, optBoolean2));
                    }
                } else {
                    int optInt3 = jSONObject2.optInt("handNum", 0);
                    if (optInt3 != this.lastHandNum) {
                        this.lastHandNum = optInt3;
                        LiveMainHandler.post(new VideoCallDriver$$ExternalSyntheticLambda0(this));
                    }
                }
            } else if (!this.mInteractionId.equals(optString2)) {
                this.mInteractionId = optString2;
                track_click_video(LeanplumUtil.start_videomic, optString2);
                LiveMainHandler.post(new VideoCallDriver$$ExternalSyntheticLambda5(this, optBoolean2, optString2, optString, arrayList));
            }
        }
    }

    public /* synthetic */ void lambda$handleNotice$0$VideoCallDriver(boolean z, String str, String str2, List list) {
        if (z) {
            this.videoCallBll.videoCallOn(str, str2, "target", false, list);
            trackInteractiveLog("TargetLinkMic", "start", 1);
            return;
        }
        this.videoCallBll.videoCallOn(str, str2, VideoCallConfig.TEMP_VALUE_NOTICE, false, list);
        trackInteractiveLog("NormalLinkMic", "start", 1);
    }

    public /* synthetic */ void lambda$handleNotice$1$VideoCallDriver(boolean z) {
        this.videoCallBll.videoCallOff(VideoCallConfig.TEMP_VALUE_NOTICE);
        if (z) {
            trackInteractiveLog("TargetLinkMic", "end", 1);
        } else {
            trackInteractiveLog("NormalLinkMic", "end", 1);
        }
    }

    public /* synthetic */ void lambda$handleNotice$2$VideoCallDriver() {
        this.videoCallBll.videoCallHandNum(this.lastHandNum);
    }

    public /* synthetic */ void lambda$handleNotice$3$VideoCallDriver(boolean z, boolean z2, String str, String str2, List list) {
        IVideoCallAction iVideoCallAction = this.videoCallBll;
        if (iVideoCallAction == null || !z) {
            return;
        }
        if (z2) {
            iVideoCallAction.videoCallOn(str, str2, "target", true, list);
        } else {
            iVideoCallAction.videoCallOn(str, str2, VideoCallConfig.TEMP_VALUE_TOPIC, true, list);
        }
    }

    public /* synthetic */ void lambda$handleNotice$4$VideoCallDriver(int i, List list, boolean z, boolean z2) {
        this.videoCallBll.videoCallChoose(i, list, z, this.isMuteVideo, z2);
    }

    public /* synthetic */ void lambda$handleNotice$5$VideoCallDriver() {
        this.videoCallBll.teacherQuit();
    }

    public /* synthetic */ void lambda$handleNotice$6$VideoCallDriver(boolean z) {
        this.videoCallBll.videoCallOffRandom(VideoCallConfig.TEMP_VALUE_NOTICE);
        if (z) {
            trackInteractiveLog("TargetLinkMic", "end", 1);
        }
    }

    public void onMessage(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            XesLog.s(TAG, "收到上麦消息:ircTypeKey=" + str + ",message=" + str2);
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -644962439) {
                if (hashCode != 3357091) {
                    if (hashCode == 1333277827) {
                        if (str.equals("video_mic")) {
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
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("收到video_mic信令", str2);
                XesLog.ut(VideoCallConfig.TAG, jsonObject);
                handleNotice(jSONObject.optJSONObject(str));
            } else if (c == 1) {
                this.mIrcControllerProvider = this.mLiveRoomProvider.getIrcControllerProvider();
            } else if (c == 2) {
                String optString = jSONObject.optString("mode", "");
                IVideoCallAction iVideoCallAction = this.videoCallBll;
                if (iVideoCallAction != null) {
                    iVideoCallAction.onModeChange(this.mCurrentMode, optString, true);
                }
                this.mCurrentMode = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            XesLog.e(TAG, "收到上麦消息失败，error=" + e.toString());
        }
    }

    private void trackInteractiveLog(String str, String str2, int i) {
        InteractReportKt.XesLogReport(str2, str, this.mInteractionId, Integer.valueOf(i), "");
    }
}
