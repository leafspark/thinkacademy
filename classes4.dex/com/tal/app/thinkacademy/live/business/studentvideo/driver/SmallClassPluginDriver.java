package com.tal.app.thinkacademy.live.business.studentvideo.driver;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.eaydu.omni.RTCChannel;
import com.eaydu.omni.RTCEngine;
import com.eaydu.omni.listener.RTCConnectionStateType;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.common.entity.ParentAuditCloudData;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.irc.IrcKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.player.rtcplayer.IRTCEngineProvider;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineProvider;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineProviderUtils;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayer;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayerEngineEventListener;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayerUtil;
import com.tal.app.thinkacademy.lib.player.rtcplayer.entity.RtcUserState;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.AllOnStageViewModel;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.listenbody.AllOnStageListenerBody;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.listenbody.OnStageChanged;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.listenbody.RtcPlayerListenerBody;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiLocalImageResourceBean;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiOnlineImageResourceBean;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiOnlineLottieResourceBean;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.mediacontroller.EnableState;
import com.tal.app.thinkacademy.live.business.studentvideo.AbstractStudentVideoPluginView;
import com.tal.app.thinkacademy.live.business.studentvideo.PermissCameraView;
import com.tal.app.thinkacademy.live.business.studentvideo.SmallClassVideoPluginView;
import com.tal.app.thinkacademy.live.business.studentvideo.SmallClassVideoPluginViewPhone;
import com.tal.app.thinkacademy.live.business.studentvideo.SpeechStudentView;
import com.tal.app.thinkacademy.live.business.studentvideo.api.StudentVideoApi;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.OtherMaxVolumeStudent;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.body.StudentListBody;
import com.tal.app.thinkacademy.live.business.studentvideo.listen.PermissionListen;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.irc.entity.MsgBean;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfo;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.util.InteractLogReport;
import com.tbruyelle.rxpermissions3.RxPermissions;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

@PluginAnnotation(classType = 1, desc = "视频回显插件", ircType = {"raise_hand", "send_emoji", "level_chat_msg", "animation_emoji"}, launchType = "initmodule", moduleId = "110")
@ViewLevels({@ViewLevel(level = 100, name = "StudentViedeo")})
public class SmallClassPluginDriver extends BaseLivePluginDriver implements PermissionListen {
    private static final long EMOJI_DELAY_TIME = 3000;
    private static final int EMOJI_HIDE = 4;
    private static final int EMOJI_SHOW = 3;
    private static final long RAISE_HAND_DELAY_TIME = 10000;
    private static final int RAISE_HAND_DOWN = 2;
    private static final int RAISE_HAND_UP = 1;
    /* access modifiers changed from: private */
    public static final XesLogTag TAG = Tag.SMALL_CLASS_VIDEO_DRIVER;
    private static final int WHAT_HIDE_FORBID_USER_VIEW = 101;
    private static final int WHAT_MIC_UPDATE = 100;
    private PermissCameraView cameraView;
    private int classId;
    /* access modifiers changed from: private */
    public StudentVideoBean.ListBean currentStudent;
    /* access modifiers changed from: private */
    public boolean isDistory;
    /* access modifiers changed from: private */
    public boolean isMuteStudentVideo;
    private int isOpenCamera;
    private int isOpenMic;
    /* access modifiers changed from: private */
    public boolean isSmallClass = false;
    private boolean isWhile;
    /* access modifiers changed from: private */
    public AllOnStageViewModel mAllOnStageViewModel;
    protected String mClassType = EnterRoomMuteData.STATUS_UN_MUTE;
    private Context mContext;
    private CourseInfoProxy mCourseInfo;
    public int mCurrentPage = 1;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            StudentVideoBean.ListBean listBean;
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                long longValue = ((Long) message.obj).longValue();
                SmallClassPluginDriver.this.showRaiseHand(longValue, true);
                SmallClassPluginDriver.this.mHandler.removeMessages(2, SmallClassPluginDriver.this.getHideObj(longValue));
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.obj = SmallClassPluginDriver.this.getHideObj(longValue);
                SmallClassPluginDriver.this.mHandler.sendMessageDelayed(obtain, 10000);
            } else if (i == 2) {
                SmallClassPluginDriver.this.showRaiseHand(((Long) message.obj).longValue(), false);
            } else if (i == 4) {
                long longValue2 = ((Long) message.obj).longValue();
                XesLogTag access$300 = SmallClassPluginDriver.TAG;
                XesLog.i(access$300, "EMOJI_HIDE uid = " + longValue2);
                SmallClassPluginDriver.this.showEmoji(longValue2, new EmojiBean(), false);
            } else if (i == 100) {
                MicDataBean micDataBean = (MicDataBean) message.obj;
                if (!(micDataBean == null || SmallClassPluginDriver.this.mPluginView == null)) {
                    SmallClassPluginDriver.this.mPluginView.updateSmallMic(micDataBean.uid, micDataBean.mic);
                }
                if (!(micDataBean == null || SmallClassPluginDriver.this.mSpeechStudentView == null || (listBean = (StudentVideoBean.ListBean) SmallClassPluginDriver.this.mStopVideoStudentMap.get(Long.valueOf(micDataBean.uid))) == null)) {
                    SmallClassPluginDriver.this.mSpeechStudentView.updateOtherMic(new OtherMaxVolumeStudent(micDataBean.uid, micDataBean.mic, listBean.getNickName(), System.currentTimeMillis()));
                }
            } else if (i == 101) {
                SmallClassPluginDriver.this.hideForbidUserView(((Long) message.obj).longValue());
            }
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    };
    private Observer<PluginEventData> mHearEachOtherObserver;
    private HashMap<Long, Long> mHideEmojiMap = new HashMap<>();
    /* access modifiers changed from: private */
    public boolean mIsAllStage = false;
    private boolean mIsDisableALLRemote = false;
    private boolean mIsDisableMySelfVideo = false;
    /* access modifiers changed from: private */
    public boolean mIsLookOther = false;
    private boolean mIsParentAudit = false;
    private volatile List<Long> mJoinStudentList = new ArrayList();
    public int mMaxPage = 1;
    public Observer<PluginEventData> mObserverCamera;
    public Observer<PluginEventData> mObserverEmoji;
    public Observer<PluginEventData> mObserverMic;
    private Observer<PluginEventData> mObserverRaiseHand;
    /* access modifiers changed from: private */
    public volatile Map<Long, StudentVideoBean.ListBean> mOnThePlatformStudentMap = new HashMap();
    /* access modifiers changed from: private */
    public RtcPlayer mPlayer;
    /* access modifiers changed from: private */
    public AbstractStudentVideoPluginView<SmallClassPluginDriver> mPluginView;
    private RTCEngineProvider mProvider;
    private IRTCEngineProvider.RTCEngineCallback mRTCEngineCallback;
    public Observer<PluginEventData> mRandomCallWithVideo;
    /* access modifiers changed from: private */
    public RTCEngine mRtcEngine;
    /* access modifiers changed from: private */
    public RtcViewModel mRtcViewModel;
    /* access modifiers changed from: private */
    public volatile Map<Long, StudentVideoBean.ListBean> mSmallClassMap = new HashMap();
    /* access modifiers changed from: private */
    public volatile List<StudentVideoBean.ListBean> mSmallClassVideoList = new ArrayList();
    /* access modifiers changed from: private */
    public SpeechStudentView mSpeechStudentView;
    /* access modifiers changed from: private */
    public volatile Map<Long, StudentVideoBean.ListBean> mStopVideoStudentMap = new HashMap();
    private Map<Long, SurfaceView> mSurfaceViewMap = new HashMap();
    private volatile ArrayList<Long> mTopStudentMap = new ArrayList<>();
    /* access modifiers changed from: private */
    public long mUid;
    private UserInfoProxy mUserInfoProxy;
    /* access modifiers changed from: private */
    public volatile List<StudentVideoBean.ListBean> myGroupList;
    /* access modifiers changed from: private */
    public StudentVideoBean.ListBean mySelf;
    public Observer<PluginEventData> observerCollective;
    public Observer<PluginEventData> observerGrouoVideoCallEnd;
    public Observer<PluginEventData> observerGrouoVideoCallStart;
    public Observer<PluginEventData> observerGrouoVideoCallState;
    public Observer<PluginEventData> observerMuteStudentVideo;
    public Observer<PluginEventData> observerOtherUserLevel;
    public Observer<PluginEventData> observerUserCourseCoins;
    public Observer<PluginEventData> observerUserLevel;
    public Observer<PluginEventData> observerVideoCall;
    public Observer<PluginEventData> observerVideoFCall;
    public Observer<PluginEventData> observerVideoState;
    private int planId;
    private int tutorId;

    public static class MicDataBean {
        public int mic;
        public long uid;
    }

    private void initData() {
    }

    public SmallClassPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        int i = 2;
        this.isOpenCamera = PermissionUtils.isGranted("android.permission.CAMERA") ? 1 : 2;
        this.isOpenMic = PermissionUtils.isGranted("android.permission.RECORD_AUDIO") ? 1 : i;
        this.observerUserCourseCoins = new Observer<PluginEventData>() {
            public void onChanged(PluginEventData pluginEventData) {
                if (SmallClassPluginDriver.this.mPluginView != null) {
                    SmallClassPluginDriver.this.mPluginView.setUserCoins(pluginEventData.getData());
                }
            }
        };
        this.observerUserLevel = new Observer<PluginEventData>() {
            public void onChanged(PluginEventData pluginEventData) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("当前最新等级", Integer.valueOf(Integer.parseInt(pluginEventData.getData())));
                XesLog.ut(SmallClassPluginDriver.TAG.get(), jsonObject);
                if (!PadUtils.isPad(Utils.getApp()) || !SmallClassPluginDriver.this.isSmallClass) {
                    SmallClassPluginDriver.this.mPluginView.showLevelIcon(0, pluginEventData.getData());
                    return;
                }
                SmallClassPluginDriver.this.mySelf.setLevel(Integer.parseInt(pluginEventData.getData()));
                SmallClassPluginDriver.this.syncStudentView(0);
            }
        };
        this.observerOtherUserLevel = new Observer<PluginEventData>() {
            public void onChanged(PluginEventData pluginEventData) {
                int indexOf;
                int indexOf2;
                if (SmallClassPluginDriver.this.mPluginView != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(pluginEventData.getData());
                        String optString = jSONObject.optString("userId");
                        String optString2 = jSONObject.optString("level");
                        StudentVideoBean.ListBean listBean = new StudentVideoBean.ListBean();
                        listBean.setUserId(Long.parseLong(optString));
                        XesLogTag access$300 = SmallClassPluginDriver.TAG;
                        int i = 0;
                        XesLog.i(access$300, "接收其他学生等级变化，userId=" + optString + ",level=" + optString2);
                        if (PadUtils.isPad(Utils.getApp()) && SmallClassPluginDriver.this.isSmallClass) {
                            SmallClassPluginDriver smallClassPluginDriver = SmallClassPluginDriver.this;
                            StudentVideoBean.ListBean unused = smallClassPluginDriver.currentStudent = (StudentVideoBean.ListBean) smallClassPluginDriver.mSmallClassMap.get(Long.valueOf(Long.parseLong(optString)));
                            if (SmallClassPluginDriver.this.currentStudent != null && (indexOf2 = SmallClassPluginDriver.this.mSmallClassVideoList.indexOf(SmallClassPluginDriver.this.currentStudent)) > -1 && SmallClassPluginDriver.this.mPluginView != null) {
                                try {
                                    i = Integer.parseInt(optString2);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf2)).setLevel(i);
                                SmallClassPluginDriver.this.mPluginView.changeSmallClassVideo(SmallClassPluginDriver.this.mSmallClassVideoList, indexOf2);
                            }
                        } else if (SmallClassPluginDriver.this.myGroupList != null && (indexOf = SmallClassPluginDriver.this.myGroupList.indexOf(listBean)) != -1) {
                            SmallClassPluginDriver.this.mPluginView.showLevelIcon(indexOf + 1, optString2);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        };
        this.observerVideoCall = new Observer<PluginEventData>() {
            public void onChanged(PluginEventData pluginEventData) {
                if ("videoCallStart".equals(pluginEventData.getData())) {
                    SmallClassPluginDriver.this.mPluginView.setSwitchEnable(false, EnableState.TEACHER_LINK);
                } else if ("videoCallOn".equals(pluginEventData.getData())) {
                    SmallClassPluginDriver.this.videoCallOn(false);
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("视频连麦", "上麦");
                    jsonObject.addProperty("isMuteStudentVideo", Boolean.valueOf(SmallClassPluginDriver.this.isMuteStudentVideo));
                    XesLog.ut(SmallClassPluginDriver.TAG.get(), jsonObject);
                } else if ("videoCallOff".equals(pluginEventData.getData())) {
                    SmallClassPluginDriver.this.videoCallOff(true);
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("视频连麦", "下麦");
                    jsonObject2.addProperty("isMuteStudentVideo", Boolean.valueOf(SmallClassPluginDriver.this.isMuteStudentVideo));
                    XesLog.ut(SmallClassPluginDriver.TAG.get(), jsonObject2);
                } else {
                    SmallClassPluginDriver.this.mPluginView.setSwitchEnable(true, EnableState.TEACHER_LINK);
                    SmallClassPluginDriver.this.videoCallOff(true);
                    JsonObject jsonObject3 = new JsonObject();
                    jsonObject3.addProperty("视频连麦", "下麦");
                    jsonObject3.addProperty("isMuteStudentVideo", Boolean.valueOf(SmallClassPluginDriver.this.isMuteStudentVideo));
                    XesLog.ut(SmallClassPluginDriver.TAG.get(), jsonObject3);
                }
            }
        };
        this.observerVideoFCall = new Observer<PluginEventData>() {
            public void onChanged(PluginEventData pluginEventData) {
                if ("videoCallTutorOn".equals(pluginEventData.getData())) {
                    SmallClassPluginDriver.this.mPluginView.setSwitchEnable(false, EnableState.TUTOR_LINK);
                    SmallClassPluginDriver.this.videoCallOn(false);
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("辅导视频连麦", "上麦");
                    jsonObject.addProperty("isMuteStudentVideo", Boolean.valueOf(SmallClassPluginDriver.this.isMuteStudentVideo));
                    XesLog.ut(SmallClassPluginDriver.TAG.get(), jsonObject);
                    return;
                }
                SmallClassPluginDriver.this.mPluginView.setSwitchEnable(true, EnableState.TUTOR_LINK);
                SmallClassPluginDriver.this.videoCallOff(true);
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("辅导视频连麦", "下麦");
                jsonObject2.addProperty("isMuteStudentVideo", Boolean.valueOf(SmallClassPluginDriver.this.isMuteStudentVideo));
                XesLog.ut(SmallClassPluginDriver.TAG.get(), jsonObject2);
            }
        };
        this.observerCollective = new Observer<PluginEventData>() {
            public void onChanged(PluginEventData pluginEventData) {
                if (!PadUtils.isPad(Utils.getApp()) || !SmallClassPluginDriver.this.isSmallClass) {
                    if (SmallClassPluginDriver.this.myGroupList != null) {
                        if ("1".equals(pluginEventData.getData())) {
                            SmallClassPluginDriver.this.mPluginView.showVoiceLottieView(SmallClassPluginDriver.this.myGroupList.size());
                        } else {
                            SmallClassPluginDriver.this.mPluginView.hideVoiceLottieView(SmallClassPluginDriver.this.myGroupList.size());
                        }
                    }
                } else if (SmallClassPluginDriver.this.mPluginView != null) {
                    SmallClassPluginDriver.this.mPluginView.setCollectiveSpeech("1".equals(pluginEventData.getData()));
                    SmallClassPluginDriver.this.mPluginView.updateSmallClassVideoList(SmallClassPluginDriver.this.mSmallClassVideoList);
                }
            }
        };
        this.observerMuteStudentVideo = new Observer<PluginEventData>() {
            public void onChanged(PluginEventData pluginEventData) {
                if (String.valueOf(0).equals(pluginEventData.getData())) {
                    if (PadUtils.isPad(Utils.getApp()) && SmallClassPluginDriver.this.isSmallClass) {
                        SmallClassPluginDriver.this.mPluginView.rootViewIsShow(false);
                    }
                    SmallClassPluginDriver.this.setMuteStudentVideo(true);
                    SmallClassPluginDriver.this.enableLocalVideo(false);
                    if (PadUtils.isPad(Utils.getApp()) && SmallClassPluginDriver.this.isSmallClass) {
                        SmallClassPluginDriver.this.closePullAllStreams();
                    }
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("mute", "关闭互显");
                    XesLog.ut(SmallClassPluginDriver.TAG.get(), jsonObject);
                    return;
                }
                if (PadUtils.isPad(Utils.getApp()) && SmallClassPluginDriver.this.isSmallClass) {
                    SmallClassPluginDriver.this.mPluginView.rootViewIsShow(true);
                }
                SmallClassPluginDriver.this.setMuteStudentVideo(false);
                if (!SmallClassPluginDriver.this.isMuteStudentVideo) {
                    SmallClassPluginDriver.this.enableLocalVideo(true);
                } else {
                    SmallClassPluginDriver.this.enableLocalVideo(false);
                }
                if (PadUtils.isPad(Utils.getApp()) && SmallClassPluginDriver.this.isSmallClass) {
                    SmallClassPluginDriver.this.startPullAllStream();
                }
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("mute", "打开互显");
                XesLog.ut(SmallClassPluginDriver.TAG.get(), jsonObject2);
            }
        };
        this.observerVideoState = new Observer<PluginEventData>() {
            public void onChanged(PluginEventData pluginEventData) {
                if ("1".equals(pluginEventData.getData())) {
                    SmallClassPluginDriver.this.mPluginView.videoChatToggle(true);
                } else {
                    SmallClassPluginDriver.this.mPluginView.videoChatToggle(false);
                }
            }
        };
        this.observerGrouoVideoCallStart = new Observer<PluginEventData>() {
            public void onChanged(PluginEventData pluginEventData) {
                long parseLong = Long.parseLong(pluginEventData.getData());
                if (SmallClassPluginDriver.this.mUid == parseLong) {
                    XesLog.i(SmallClassPluginDriver.TAG, "自己上台");
                    if (!(SmallClassPluginDriver.this.mRtcEngine == null || SmallClassPluginDriver.this.mPluginView == null)) {
                        SmallClassPluginDriver.this.mySelf.setOnStageAction(true);
                    }
                    SmallClassPluginDriver.this.videoCallOn(true);
                    return;
                }
                XesLogTag access$300 = SmallClassPluginDriver.TAG;
                XesLog.i(access$300, "其他人上台uid=" + parseLong);
                if (SmallClassPluginDriver.this.mRtcEngine != null) {
                    SmallClassPluginDriver.this.mRtcEngine.muteRemoteVideo(parseLong, false);
                    SmallClassPluginDriver smallClassPluginDriver = SmallClassPluginDriver.this;
                    StudentVideoBean.ListBean unused = smallClassPluginDriver.currentStudent = (StudentVideoBean.ListBean) smallClassPluginDriver.mSmallClassMap.get(Long.valueOf(parseLong));
                    SmallClassPluginDriver.this.mOnThePlatformStudentMap.put(Long.valueOf(parseLong), SmallClassPluginDriver.this.currentStudent);
                    SmallClassPluginDriver.this.updateStopVideoStudents();
                    if (SmallClassPluginDriver.this.currentStudent == null) {
                        return;
                    }
                    if (SmallClassPluginDriver.this.mSmallClassVideoList.contains(SmallClassPluginDriver.this.currentStudent)) {
                        int indexOf = SmallClassPluginDriver.this.mSmallClassVideoList.indexOf(SmallClassPluginDriver.this.currentStudent);
                        if (indexOf > -1) {
                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setOnStageAction(true);
                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setPullStreamState(4);
                            if (PadUtils.isPad(Utils.getApp()) && SmallClassPluginDriver.this.mPluginView != null) {
                                SmallClassPluginDriver.this.mPluginView.changeSmallClassVideo(SmallClassPluginDriver.this.mSmallClassVideoList, indexOf);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    SmallClassPluginDriver.this.currentStudent.setOnStageAction(true);
                    SmallClassPluginDriver.this.currentStudent.setPullStreamState(4);
                }
            }
        };
        this.observerGrouoVideoCallEnd = new Observer<PluginEventData>() {
            public void onChanged(PluginEventData pluginEventData) {
                long parseLong = Long.parseLong(pluginEventData.getData());
                if (SmallClassPluginDriver.this.mUid == parseLong) {
                    XesLog.i(SmallClassPluginDriver.TAG, "自己下台");
                    if (!(SmallClassPluginDriver.this.mRtcEngine == null || SmallClassPluginDriver.this.mPluginView == null)) {
                        SmallClassPluginDriver.this.mySelf.setOnStageAction(false);
                    }
                    SmallClassPluginDriver.this.videoCallOff(true);
                    return;
                }
                XesLogTag access$300 = SmallClassPluginDriver.TAG;
                XesLog.i(access$300, "其他人下台 uid = " + parseLong);
                if (SmallClassPluginDriver.this.mRtcEngine != null) {
                    SmallClassPluginDriver smallClassPluginDriver = SmallClassPluginDriver.this;
                    StudentVideoBean.ListBean unused = smallClassPluginDriver.currentStudent = (StudentVideoBean.ListBean) smallClassPluginDriver.mSmallClassMap.get(Long.valueOf(parseLong));
                    SmallClassPluginDriver.this.mOnThePlatformStudentMap.remove(Long.valueOf(parseLong));
                    SmallClassPluginDriver.this.updateStopVideoStudents();
                    if (SmallClassPluginDriver.this.currentStudent == null) {
                        SmallClassPluginDriver.this.mRtcEngine.muteRemoteVideo(parseLong, true);
                    } else if (SmallClassPluginDriver.this.mSmallClassVideoList.contains(SmallClassPluginDriver.this.currentStudent)) {
                        int indexOf = SmallClassPluginDriver.this.mSmallClassVideoList.indexOf(SmallClassPluginDriver.this.currentStudent);
                        if (indexOf > -1) {
                            SmallClassPluginDriver.this.mRtcEngine.muteRemoteVideo(parseLong, true);
                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setPullStreamStateForce(0);
                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setOnStageAction(false);
                            if (PadUtils.isPad(Utils.getApp()) && SmallClassPluginDriver.this.mPluginView != null) {
                                SmallClassPluginDriver.this.mPluginView.changeSmallClassVideo(SmallClassPluginDriver.this.mSmallClassVideoList, indexOf);
                            }
                        }
                    } else {
                        SmallClassPluginDriver.this.currentStudent.setPullStreamStateForce(0);
                        SmallClassPluginDriver.this.currentStudent.setOnStageAction(false);
                    }
                }
            }
        };
        this.observerGrouoVideoCallState = new Observer<PluginEventData>() {
            public void onChanged(PluginEventData pluginEventData) {
                if ("1".equals(pluginEventData.getData())) {
                    PluginEventBus.onEvent(DataBusKey.GROUP_VIDEO_CALL_STATUS, new PluginEventData(SmallClassPluginDriver.class, DataBusKey.GROUP_VIDEO_CALL_STATUS, "videoCallStart"));
                } else {
                    PluginEventBus.onEvent(DataBusKey.GROUP_VIDEO_CALL_STATUS, new PluginEventData(SmallClassPluginDriver.class, DataBusKey.GROUP_VIDEO_CALL_STATUS, "videoCallEnd"));
                }
            }
        };
        this.mObserverRaiseHand = new Observer<PluginEventData>() {
            public void onChanged(PluginEventData pluginEventData) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = Long.valueOf(SmallClassPluginDriver.this.mUid);
                Handler access$200 = SmallClassPluginDriver.this.mHandler;
                if (!(access$200 instanceof Handler)) {
                    access$200.sendMessage(obtain);
                } else {
                    AsynchronousInstrumentation.sendMessage(access$200, obtain);
                }
            }
        };
        this.mObserverEmoji = new Observer<PluginEventData>() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onChanged(com.tal.app.thinkacademy.live.core.plugin.PluginEventData r6) {
                /*
                    r5 = this;
                    java.lang.String r6 = r6.getData()     // Catch:{ Exception -> 0x005d }
                    com.tal.app.thinkacademy.lib.util.GsonUtil r0 = com.tal.app.thinkacademy.lib.util.GsonUtil.getInstance()     // Catch:{ Exception -> 0x005d }
                    java.lang.Class<com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean> r1 = com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean.class
                    java.lang.Object r0 = r0.fromJson((java.lang.String) r6, r1)     // Catch:{ Exception -> 0x005d }
                    com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean r0 = (com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean) r0     // Catch:{ Exception -> 0x005d }
                    if (r0 != 0) goto L_0x0013
                    return
                L_0x0013:
                    int r1 = r0.getType()     // Catch:{ Exception -> 0x005d }
                    r2 = 1
                    if (r1 == r2) goto L_0x0043
                    r3 = 2
                    if (r1 == r3) goto L_0x0032
                    r3 = 3
                    if (r1 == r3) goto L_0x0021
                    goto L_0x0053
                L_0x0021:
                    com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver$14$3 r0 = new com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver$14$3     // Catch:{ Exception -> 0x005d }
                    r0.<init>()     // Catch:{ Exception -> 0x005d }
                    java.lang.reflect.Type r0 = r0.getType()     // Catch:{ Exception -> 0x005d }
                    java.lang.Object r6 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson((java.lang.String) r6, (java.lang.reflect.Type) r0)     // Catch:{ Exception -> 0x005d }
                    r0 = r6
                    com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean r0 = (com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean) r0     // Catch:{ Exception -> 0x005d }
                    goto L_0x0053
                L_0x0032:
                    com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver$14$2 r0 = new com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver$14$2     // Catch:{ Exception -> 0x005d }
                    r0.<init>()     // Catch:{ Exception -> 0x005d }
                    java.lang.reflect.Type r0 = r0.getType()     // Catch:{ Exception -> 0x005d }
                    java.lang.Object r6 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson((java.lang.String) r6, (java.lang.reflect.Type) r0)     // Catch:{ Exception -> 0x005d }
                    r0 = r6
                    com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean r0 = (com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean) r0     // Catch:{ Exception -> 0x005d }
                    goto L_0x0053
                L_0x0043:
                    com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver$14$1 r0 = new com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver$14$1     // Catch:{ Exception -> 0x005d }
                    r0.<init>()     // Catch:{ Exception -> 0x005d }
                    java.lang.reflect.Type r0 = r0.getType()     // Catch:{ Exception -> 0x005d }
                    java.lang.Object r6 = com.tal.app.thinkacademy.lib.util.GsonUtils.fromJson((java.lang.String) r6, (java.lang.reflect.Type) r0)     // Catch:{ Exception -> 0x005d }
                    r0 = r6
                    com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean r0 = (com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean) r0     // Catch:{ Exception -> 0x005d }
                L_0x0053:
                    com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver r6 = com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver.this     // Catch:{ Exception -> 0x005d }
                    long r3 = r6.mUid     // Catch:{ Exception -> 0x005d }
                    r6.showEmoji(r3, r0, r2)     // Catch:{ Exception -> 0x005d }
                    goto L_0x0061
                L_0x005d:
                    r6 = move-exception
                    r6.printStackTrace()
                L_0x0061:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.studentvideo.driver.SmallClassPluginDriver.AnonymousClass14.onChanged(com.tal.app.thinkacademy.live.core.plugin.PluginEventData):void");
            }
        };
        this.mObserverMic = new Observer<PluginEventData>() {
            public void onChanged(PluginEventData pluginEventData) {
                if (pluginEventData == null) {
                    return;
                }
                if (PadUtils.isPad(Utils.getApp())) {
                    if ("1".equals(pluginEventData.getData())) {
                        SmallClassPluginDriver.this.setMuteStudentAudio(false);
                        SmallClassPluginDriver.this.mySelf.setOpenMic(true);
                        SmallClassPluginDriver.this.enableLocalAudio(true);
                        SmallClassPluginDriver.this.syncStudentView(0);
                    } else if (EnterRoomMuteData.STATUS_UN_MUTE.equals(pluginEventData.getData())) {
                        SmallClassPluginDriver.this.setMuteStudentAudio(true);
                        SmallClassPluginDriver.this.mySelf.setOpenMic(false);
                        SmallClassPluginDriver.this.enableLocalAudio(false);
                        SmallClassPluginDriver.this.syncStudentView(0);
                    }
                    XesLogTag access$300 = SmallClassPluginDriver.TAG;
                    XesLog.i(access$300, "pad接收到:打开麦克风=" + pluginEventData.getData());
                    return;
                }
                if ("1".equals(pluginEventData.getData())) {
                    SmallClassPluginDriver.this.setMuteStudentAudio(false);
                    SmallClassPluginDriver.this.mySelf.setOpenMic(true);
                    SmallClassPluginDriver.this.enableLocalAudio(true);
                } else if (EnterRoomMuteData.STATUS_UN_MUTE.equals(pluginEventData.getData())) {
                    SmallClassPluginDriver.this.setMuteStudentAudio(true);
                    SmallClassPluginDriver.this.mySelf.setOpenMic(false);
                    SmallClassPluginDriver.this.enableLocalAudio(false);
                }
                XesLogTag access$3002 = SmallClassPluginDriver.TAG;
                XesLog.i(access$3002, "手机接收到:打开麦克风=" + pluginEventData.getData());
            }
        };
        this.mObserverCamera = new Observer<PluginEventData>() {
            public void onChanged(PluginEventData pluginEventData) {
                if (pluginEventData == null) {
                    return;
                }
                if (PadUtils.isPad(Utils.getApp())) {
                    if ("1".equals(pluginEventData.getData())) {
                        SmallClassPluginDriver.this.setMuteStudentVideo(false);
                        SmallClassPluginDriver.this.mySelf.setCameraPerm(1);
                        SmallClassPluginDriver.this.mySelf.setOpenCamera(true);
                        SmallClassPluginDriver.this.enableLocalVideo(true);
                        SmallClassPluginDriver.this.syncStudentView(0);
                    } else if (EnterRoomMuteData.STATUS_UN_MUTE.equals(pluginEventData.getData())) {
                        SmallClassPluginDriver.this.setMuteStudentVideo(true);
                        SmallClassPluginDriver.this.mySelf.setCameraPerm(0);
                        SmallClassPluginDriver.this.mySelf.setOpenCamera(false);
                        SmallClassPluginDriver.this.enableLocalVideo(false);
                        SmallClassPluginDriver.this.syncStudentView(0);
                    }
                    XesLogTag access$300 = SmallClassPluginDriver.TAG;
                    XesLog.i(access$300, "pad接收到:打开摄像头=" + pluginEventData.getData());
                } else if ("fromFunction".equals(pluginEventData.getObject())) {
                    if ("1".equals(pluginEventData.getData())) {
                        if (SmallClassPluginDriver.this.mAllOnStageViewModel == null || !SmallClassPluginDriver.this.mAllOnStageViewModel.getMIsOnStage()) {
                            SmallClassPluginDriver.this.setMuteStudentVideo(false);
                            SmallClassPluginDriver.this.mySelf.setCameraPerm(1);
                            SmallClassPluginDriver.this.mySelf.setOpenCamera(true);
                            SmallClassPluginDriver.this.enableLocalVideo(true);
                            if (SmallClassPluginDriver.this.mPluginView != null) {
                                SmallClassPluginDriver.this.mPluginView.changeTurnState(true);
                            }
                            SmallClassPluginDriver.this.syncStudentView(0);
                        } else {
                            XesLog.i(SmallClassPluginDriver.TAG, "全员上台时，手机端不接受打开摄像头");
                            return;
                        }
                    } else if (EnterRoomMuteData.STATUS_UN_MUTE.equals(pluginEventData.getData())) {
                        SmallClassPluginDriver.this.setMuteStudentVideo(true);
                        SmallClassPluginDriver.this.mySelf.setCameraPerm(0);
                        SmallClassPluginDriver.this.mySelf.setOpenCamera(false);
                        SmallClassPluginDriver.this.enableLocalVideo(false);
                        if (SmallClassPluginDriver.this.mPluginView != null) {
                            SmallClassPluginDriver.this.mPluginView.changeTurnState(false);
                        }
                        SmallClassPluginDriver.this.syncStudentView(0);
                    }
                    XesLogTag access$3002 = SmallClassPluginDriver.TAG;
                    XesLog.i(access$3002, "手机接收到:打开摄像头=" + pluginEventData.getData());
                }
            }
        };
        this.mRandomCallWithVideo = new Observer<PluginEventData>() {
            public void onChanged(PluginEventData pluginEventData) {
                boolean equals = "1".equals(pluginEventData.getData());
                XesLogTag access$300 = SmallClassPluginDriver.TAG;
                XesLog.i(access$300, "收到随机点名互动 = " + pluginEventData.getData());
                SmallClassPluginDriver.this.disableAllStudentVideo(equals);
                SmallClassPluginDriver.this.disableMyselfVideo(equals);
            }
        };
        this.mHearEachOtherObserver = new Observer<PluginEventData>() {
            public void onChanged(PluginEventData pluginEventData) {
                boolean equals = "open".equals(pluginEventData.getData());
                XesLogTag access$300 = SmallClassPluginDriver.TAG;
                XesLog.i(access$300, "是否开启了互听=" + equals);
                if (SmallClassPluginDriver.this.mPluginView != null) {
                    SmallClassPluginDriver.this.mPluginView.setCollectiveSpeech(equals);
                    SmallClassPluginDriver.this.mPluginView.updateSmallClassVideoList(SmallClassPluginDriver.this.mSmallClassVideoList);
                }
                if (SmallClassPluginDriver.this.mSpeechStudentView != null) {
                    SmallClassPluginDriver.this.mSpeechStudentView.setCollectiveSpeech(equals);
                }
            }
        };
        this.mRTCEngineCallback = new IRTCEngineProvider.RTCEngineCallback() {
            public void onGetRTCEngine(RTCEngine rTCEngine, RTCChannel rTCChannel) {
                RTCEngine unused = SmallClassPluginDriver.this.mRtcEngine = rTCEngine;
                if (SmallClassPluginDriver.this.mRtcEngine != null && PadUtils.isPad(Utils.getApp()) && SmallClassPluginDriver.this.isSmallClass) {
                    SmallClassPluginDriver.this.mRtcEngine.setDefaultMuteAllRemoteVideoStreams(true);
                }
            }

            public void onGetRTCEngineFail(int i, int i2) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("onGetRTCEngineFail", "RTC回调失败");
                XesLog.ut(SmallClassPluginDriver.TAG.get(), jsonObject);
            }
        };
        XesLog.it("1111111111111", "SmallClassPluginDriver init");
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        this.isSmallClass = iLiveRoomProvider.isSmallClass();
        this.mClassType = iLiveRoomProvider.getClassType();
        eventHasStudentVideo();
        this.mUserInfoProxy = iLiveRoomProvider.getDataStorage().getUserInfo();
        CourseInfoProxy courseInfo = iLiveRoomProvider.getDataStorage().getCourseInfo();
        this.mCourseInfo = courseInfo;
        this.planId = courseInfo.getPlanId();
        this.classId = this.mCourseInfo.getClassId();
        this.tutorId = this.mCourseInfo.getTutorId();
        this.mIsParentAudit = this.mCourseInfo.getIsParentAuditLocal();
        this.mIsLookOther = getLookOthers();
        this.mUid = Long.parseLong(this.mUserInfoProxy.getId());
        this.mySelf = addMySelf();
        initViewModel(iLiveRoomProvider);
        initView();
        initEngine();
        if (!PadUtils.isPad(Utils.getApp()) || !this.isSmallClass) {
            initData();
        } else {
            initSmallClassStudents();
        }
        showMyShelf();
        PluginEventBus.registerSticky(this, DataBusKey.COURSE_USERCOINS_KEY, this.observerUserCourseCoins);
        PluginEventBus.register(this, DataBusKey.VIDEO_CALL_STATUS, this.observerVideoCall);
        PluginEventBus.register(this, DataBusKey.VIDEO_CALL_F_STATUS, this.observerVideoFCall);
        PluginEventBus.register(this, DataBusKey.LEVEL_KEY, this.observerUserLevel);
        if (PadUtils.isPad(Utils.getApp())) {
            PluginEventBus.register(this, DataBusKey.UPDATE_GROUP_AUDIO, this.observerCollective);
            PluginEventBus.register(this, DataBusKey.SHOW_OTHER_LEVEL_KEY, this.observerOtherUserLevel);
        }
        PluginEventBus.register(this, DataBusKey.STUDENTVIDEO_MUTE, this.observerMuteStudentVideo);
        if (PadUtils.isPad(Utils.getApp()) && this.isSmallClass) {
            PluginEventBus.register(this, DataBusKey.VIDEO_CHAT_TOGGLE, this.observerVideoState);
        }
        PluginEventBus.register(this, DataBusKey.GROUP_VIDEO_CALL_STUDENT_START, this.observerGrouoVideoCallStart);
        PluginEventBus.register(this, DataBusKey.GROUP_VIDEO_CALL_STUDENT_END, this.observerGrouoVideoCallEnd);
        PluginEventBus.register(this, DataBusKey.GROUP_VIDEO_CALL_STATE, this.observerGrouoVideoCallState);
        XesDataBus.with(DataBusKey.TAKE_PHOTO_STATE).observe(this, new SmallClassPluginDriver$$ExternalSyntheticLambda0(this));
        XesDataBus.with(DataBusKey.LESSON_EXAM_STATE).observe(this, new Observer<Object>() {
            public void onChanged(Object obj) {
                if (obj != null) {
                    String str = (String) obj;
                    XesLogTag access$300 = SmallClassPluginDriver.TAG;
                    XesLog.i(access$300, "课中考试消息，关闭回显，state=" + str);
                    SmallClassPluginDriver.this.disableAllStudentVideo("open".equals(str) ^ true);
                }
            }
        });
        PluginEventBus.register(this, DataBusKey.RANDOM_CALL_KEY, this.mRandomCallWithVideo);
        PluginEventBus.register(this, DataBusKey.RAISE_HAND, this.mObserverRaiseHand);
        PluginEventBus.registerSticky(this, DataBusKey.USER_MUTE_VIDEO_KEY, this.mObserverCamera);
        if (PadUtils.isPad(Utils.getApp())) {
            PluginEventBus.register(this, DataBusKey.SEND_EMOJI, this.mObserverEmoji);
        }
        PluginEventBus.registerStickyForever(this, DataBusKey.USER_MUTE_MIC_KEY, this.mObserverMic);
        PluginEventBus.register(this, DataBusKey.VOICE_DRIVER_IS_HEAR_EACH_OTHER, this.mHearEachOtherObserver);
    }

    public /* synthetic */ void lambda$new$0$SmallClassPluginDriver(Object obj) {
        if (obj != null) {
            String str = (String) obj;
            if ("end".equals(str)) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(GoldSource.PHOTOS_ON_THE_WALL_GOLD, str);
                jsonObject.addProperty("onlyShelf", 1);
                jsonObject.addProperty("isMuteStudentVideo", Boolean.valueOf(this.isMuteStudentVideo));
                XesLog.ut(TAG.get(), jsonObject);
                this.mySelf.setDisableTheVideo(false);
                this.mySelf.setShowOpenCameraButton(true);
                if (!this.isMuteStudentVideo) {
                    enableLocalVideo(true);
                } else {
                    enableLocalVideo(false);
                }
                if (!PadUtils.isPad(Utils.getApp()) || !this.isSmallClass) {
                    this.mPluginView.studentOnline(0, this.mySelf);
                    syncStudentView(0);
                    return;
                }
                syncStudentView(0);
                return;
            }
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty(GoldSource.PHOTOS_ON_THE_WALL_GOLD, str);
            jsonObject2.addProperty("onlyShelf", 1);
            jsonObject2.addProperty("isMuteStudentVideo", Boolean.valueOf(this.isMuteStudentVideo));
            XesLog.ut(TAG.get(), jsonObject2);
            enableLocalVideo(false);
            this.mySelf.setDisableTheVideo(true);
            this.mySelf.setShowOpenCameraButton(false);
            if (this.mPluginView == null) {
                return;
            }
            if (!PadUtils.isPad(Utils.getApp()) || !this.isSmallClass) {
                this.mPluginView.studentOffline(0, this.mySelf);
            } else {
                syncStudentView(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void disableAllStudentVideo(boolean z) {
        AbstractStudentVideoPluginView<SmallClassPluginDriver> abstractStudentVideoPluginView;
        XesLog.i(TAG, "disableAllStudentVideo disable = " + z);
        if (this.mIsDisableALLRemote != z) {
            this.mIsDisableALLRemote = z;
            if (this.mSmallClassVideoList != null && (abstractStudentVideoPluginView = this.mPluginView) != null) {
                abstractStudentVideoPluginView.setALLRemoteVideoDisable(this.mIsDisableALLRemote);
                if (z) {
                    for (int i = 0; i < this.mSmallClassVideoList.size(); i++) {
                        if (!this.mSmallClassVideoList.get(i).isOnStageAction()) {
                            RTCEngine rTCEngine = this.mRtcEngine;
                            if (rTCEngine != null) {
                                rTCEngine.muteRemoteVideo(this.mSmallClassVideoList.get(i).getUserId(), true);
                            }
                            this.mSmallClassVideoList.get(i).setPullStreamState(4);
                        }
                    }
                } else {
                    for (int i2 = 0; i2 < this.mSmallClassVideoList.size(); i2++) {
                        if (!this.mSmallClassVideoList.get(i2).isOnStageAction()) {
                            this.mSmallClassVideoList.get(i2).setPullStreamStateForce(0);
                        }
                    }
                }
                AbstractStudentVideoPluginView<SmallClassPluginDriver> abstractStudentVideoPluginView2 = this.mPluginView;
                if (abstractStudentVideoPluginView2 != null) {
                    abstractStudentVideoPluginView2.updateSmallClassVideoList(this.mSmallClassVideoList);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void disableMyselfVideo(boolean z) {
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "disableMyselfVideo disable = " + z);
        this.mIsDisableMySelfVideo = z;
        this.mySelf.setDisableTheVideo(z);
        if (this.mPluginView != null) {
            if (!PadUtils.isPad(Utils.getApp())) {
                if (this.mIsDisableMySelfVideo) {
                    this.mPluginView.studentOffline(0, this.mySelf);
                } else {
                    this.mPluginView.studentOnline(0, this.mySelf);
                    setUpVideo(this.mUid);
                }
            }
            syncStudentView(0);
        }
    }

    public void eventHasStudentVideo() {
        PluginEventBus.onEvent(DataBusKey.STUDENTVIDEO_KEY, new PluginEventData(StudentVideoPluginDriver.class, DataBusKey.STUDENTVIDEO_KEY, "1"));
    }

    /* access modifiers changed from: private */
    public int findUidIndex(long j) {
        for (int i = 0; i < this.mSmallClassVideoList.size(); i++) {
            if (j == this.mSmallClassVideoList.get(i).getUserId()) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public void updateStudentList(List<StudentVideoBean.ListBean> list) {
        RtcUserState remoteState;
        if (!PadUtils.isPad(Utils.getApp())) {
            XesLog.i(TAG, "手机不需要更新");
        } else if (!this.mIsLookOther) {
            XesLog.i(TAG, "不开互看不需要更新");
        } else if (list != null) {
            boolean z = false;
            for (int i = 0; i < list.size(); i++) {
                StudentVideoBean.ListBean listBean = list.get(i);
                if (this.mSmallClassMap.get(Long.valueOf(listBean.getUserId())) == null) {
                    this.mSmallClassMap.put(Long.valueOf(listBean.getUserId()), listBean);
                    RtcViewModel rtcViewModel = this.mRtcViewModel;
                    if (!(rtcViewModel == null || (remoteState = rtcViewModel.getRemoteState(listBean.getUserId())) == null || !remoteState.getMIsOnline())) {
                        listBean.setPullStreamState(0);
                        listBean.setOpenMic(remoteState.getMIsOpenMic());
                        this.mSmallClassVideoList.add(listBean);
                        z = true;
                    }
                }
            }
            if (z) {
                XesLog.i(TAG, "班级数据真正更新了");
                AbstractStudentVideoPluginView<SmallClassPluginDriver> abstractStudentVideoPluginView = this.mPluginView;
                if (abstractStudentVideoPluginView != null) {
                    abstractStudentVideoPluginView.updateSmallClassVideoList(this.mSmallClassVideoList);
                    return;
                }
                return;
            }
            XesLog.i(TAG, "班级数据不需要更新");
        }
    }

    private void initViewModel(ILiveRoomProvider iLiveRoomProvider) {
        try {
            this.mIsAllStage = iLiveRoomProvider.getDataStorage().getRoomData().isIsOnStage();
        } catch (Exception e) {
            this.mIsAllStage = false;
            e.printStackTrace();
        }
        RtcViewModel viewModel = AbilityPack.get().getViewModel(RtcViewModel.class);
        this.mRtcViewModel = viewModel;
        if (viewModel != null) {
            setLocalCameraInfo(viewModel.getMLocalVideoEnable());
            setLocalMicInfo(this.mRtcViewModel.getMLocalAudioEnable());
            this.mRtcViewModel.getMRtcPlayerListener().observerSticky(this, false, new Observer<RtcPlayerListenerBody>() {
                public void onChanged(RtcPlayerListenerBody rtcPlayerListenerBody) {
                    if (rtcPlayerListenerBody instanceof RtcPlayerListenerBody.LocalAudioChanged) {
                        SmallClassPluginDriver.this.setLocalMicInfo(((RtcPlayerListenerBody.LocalAudioChanged) rtcPlayerListenerBody).getEnable());
                    } else if (rtcPlayerListenerBody instanceof RtcPlayerListenerBody.LocalVideoChanged) {
                        SmallClassPluginDriver.this.setLocalCameraInfo(((RtcPlayerListenerBody.LocalVideoChanged) rtcPlayerListenerBody).getEnable());
                    } else if (rtcPlayerListenerBody instanceof RtcPlayerListenerBody.StudentListUpdate) {
                        XesLog.i(SmallClassPluginDriver.TAG, "班级数据有更新了");
                        SmallClassPluginDriver.this.updateStudentList(((RtcPlayerListenerBody.StudentListUpdate) rtcPlayerListenerBody).getList());
                    }
                }
            });
        } else {
            XesLog.i(TAG, "error: mRtcViewModel is null");
        }
        AllOnStageViewModel viewModel2 = AbilityPack.get().getViewModel(AllOnStageViewModel.class);
        this.mAllOnStageViewModel = viewModel2;
        if (viewModel2 != null) {
            if (viewModel2.getMOnstageInit()) {
                this.mIsAllStage = this.mAllOnStageViewModel.getMIsOnStage();
            }
            this.mAllOnStageViewModel.getMListenerBody().observerSticky(this, false, new Observer<AllOnStageListenerBody>() {
                public void onChanged(AllOnStageListenerBody allOnStageListenerBody) {
                    SurfaceView surfaceView;
                    if (!(allOnStageListenerBody instanceof OnStageChanged)) {
                        return;
                    }
                    if (((OnStageChanged) allOnStageListenerBody).isOnStage()) {
                        boolean unused = SmallClassPluginDriver.this.mIsAllStage = true;
                        if (!(SmallClassPluginDriver.this.mRtcViewModel == null || (surfaceView = SmallClassPluginDriver.this.mRtcViewModel.getSurfaceView(SmallClassPluginDriver.this.mUid)) == null || surfaceView.getParent() == null)) {
                            ((ViewGroup) surfaceView.getParent()).removeView(surfaceView);
                        }
                        if (SmallClassPluginDriver.this.mPluginView != null) {
                            SmallClassPluginDriver.this.mPluginView.setAllOnStage(SmallClassPluginDriver.this.mIsAllStage);
                        }
                        SmallClassPluginDriver.this.closePullAllStreams();
                        return;
                    }
                    boolean unused2 = SmallClassPluginDriver.this.mIsAllStage = false;
                    if (SmallClassPluginDriver.this.mPluginView != null) {
                        SmallClassPluginDriver.this.mPluginView.setAllOnStage(SmallClassPluginDriver.this.mIsAllStage);
                    }
                    SmallClassPluginDriver.this.syncStudentView(0);
                    SmallClassPluginDriver.this.startPullAllStream();
                }
            });
        }
    }

    private void initEngine() {
        RtcPlayer rtcPlayer = RtcPlayerUtil.getInstance().get("Live");
        this.mPlayer = rtcPlayer;
        if (rtcPlayer == null) {
            this.mPlayer = new RtcPlayer(this.mContext);
            RtcPlayerUtil.getInstance().put("Live", this.mPlayer);
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "SmallClassPluginDriver进入直播间创建mPlayer：", "mPlayer is" + this.mPlayer);
        }
        RTCEngineProvider rTCEngineProvider = RTCEngineProviderUtils.getInstance().get("Live");
        this.mProvider = rTCEngineProvider;
        if (rTCEngineProvider == null) {
            this.mProvider = new RTCEngineProvider(this.mPlayer);
            RTCEngineProviderUtils.getInstance().put("Live", this.mProvider);
            XesLogTag xesLogTag2 = TAG;
            XesLog.i(xesLogTag2, "SmallClassPluginDriver进入直播间创建provider：", "provider is" + this.mProvider);
        }
        this.mProvider.provide((String) null, this.mRTCEngineCallback);
        this.mProvider.addEtcEngineEventListener("StudentVideo", new RtcPlayerEngineEventListener() {
            public void dispatchConnectionState(RTCConnectionStateType rTCConnectionStateType, String str, String str2) {
            }

            public void onOnceLastMileQuality(int i, String str) {
            }

            public void reportAudioVolumeOfSpeaker(long j, int i) {
                Message obtain = Message.obtain();
                MicDataBean micDataBean = new MicDataBean();
                micDataBean.uid = j;
                micDataBean.mic = i;
                obtain.what = 100;
                obtain.obj = micDataBean;
                Handler access$200 = SmallClassPluginDriver.this.mHandler;
                if (!(access$200 instanceof Handler)) {
                    access$200.sendMessage(obtain);
                } else {
                    AsynchronousInstrumentation.sendMessage(access$200, obtain);
                }
            }

            public void localUserJoindWithUid(long j, String str) {
                if ("Engine".equals(str)) {
                    long unused = SmallClassPluginDriver.this.mUid = j;
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("本人加入房间", Long.valueOf(j));
                    XesLog.ut(SmallClassPluginDriver.TAG.get(), jsonObject);
                }
            }

            public void remoteUserJoinWitnUid(long j, String str) {
                if ("Engine".equals(str) && PadUtils.isPad(Utils.getApp()) && SmallClassPluginDriver.this.isSmallClass) {
                    SmallClassPluginDriver smallClassPluginDriver = SmallClassPluginDriver.this;
                    StudentVideoBean.ListBean unused = smallClassPluginDriver.currentStudent = (StudentVideoBean.ListBean) smallClassPluginDriver.mSmallClassMap.get(Long.valueOf(j));
                    if (SmallClassPluginDriver.this.currentStudent != null && !SmallClassPluginDriver.this.mSmallClassVideoList.contains(SmallClassPluginDriver.this.currentStudent)) {
                        SmallClassPluginDriver.this.currentStudent.setPullStreamState(0);
                        SmallClassPluginDriver.this.currentStudent.setOpenMic(SmallClassPluginDriver.this.mPlayer.getRemoteStateOpenMic(j));
                        SmallClassPluginDriver.this.mSmallClassVideoList.add(SmallClassPluginDriver.this.mSmallClassVideoList.size(), SmallClassPluginDriver.this.currentStudent);
                        if (SmallClassPluginDriver.this.mPluginView != null) {
                            SmallClassPluginDriver.this.mPluginView.addSmallClassVideo(SmallClassPluginDriver.this.mSmallClassVideoList);
                        }
                    }
                }
            }

            public void remotefirstVideoRecvWithUid(final long j, String str) {
                if ("Engine".equals(str)) {
                    ThreadUtils.runOnUiThread(new Runnable() {
                        public void run() {
                            int access$3100;
                            if (PadUtils.isPad(Utils.getApp()) && SmallClassPluginDriver.this.isSmallClass) {
                                StudentVideoBean.ListBean unused = SmallClassPluginDriver.this.currentStudent = (StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassMap.get(Long.valueOf(j));
                                if (SmallClassPluginDriver.this.currentStudent != null && j != SmallClassPluginDriver.this.mUid && (access$3100 = SmallClassPluginDriver.this.findUidIndex(j)) > -1 && !((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(access$3100)).isVideoMute()) {
                                    ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(access$3100)).setPullStreamState(2);
                                    ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(access$3100)).setCameraPerm(1);
                                    ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(access$3100)).setStudentOnline(true);
                                    if (SmallClassPluginDriver.this.mPluginView != null) {
                                        SmallClassPluginDriver.this.mPluginView.changeSmallClassVideo(SmallClassPluginDriver.this.mSmallClassVideoList, access$3100);
                                    }
                                }
                            }
                        }
                    });
                }
            }

            public void remotefirstAudioRecvWithUid(final long j, String str) {
                ThreadUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        int indexOf;
                        if (PadUtils.isPad(Utils.getApp())) {
                            StudentVideoBean.ListBean unused = SmallClassPluginDriver.this.currentStudent = (StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassMap.get(Long.valueOf(j));
                            if (SmallClassPluginDriver.this.currentStudent != null && SmallClassPluginDriver.this.mSmallClassVideoList.contains(SmallClassPluginDriver.this.currentStudent) && j != SmallClassPluginDriver.this.mUid && (indexOf = SmallClassPluginDriver.this.mSmallClassVideoList.indexOf(SmallClassPluginDriver.this.currentStudent)) > -1) {
                                ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setOpenMic(true);
                                if (SmallClassPluginDriver.this.mPluginView != null) {
                                    SmallClassPluginDriver.this.mPluginView.changeSmallClassVideo(SmallClassPluginDriver.this.mSmallClassVideoList, indexOf);
                                }
                            }
                        }
                    }
                });
            }

            public void didOfflineOfUid(long j, String str) {
                int indexOf;
                if ("Engine".equals(str)) {
                    if (j == SmallClassPluginDriver.this.mUid) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("本人停止了推流下线了", Long.valueOf(j));
                        XesLog.ut(SmallClassPluginDriver.TAG.get(), jsonObject);
                    }
                    if (PadUtils.isPad(Utils.getApp()) && SmallClassPluginDriver.this.isSmallClass) {
                        SmallClassPluginDriver smallClassPluginDriver = SmallClassPluginDriver.this;
                        StudentVideoBean.ListBean unused = smallClassPluginDriver.currentStudent = (StudentVideoBean.ListBean) smallClassPluginDriver.mSmallClassMap.get(Long.valueOf(j));
                        if (SmallClassPluginDriver.this.currentStudent != null && (indexOf = SmallClassPluginDriver.this.mSmallClassVideoList.indexOf(SmallClassPluginDriver.this.currentStudent)) > -1) {
                            if (!(SmallClassPluginDriver.this.mPluginView == null || SmallClassPluginDriver.this.mRtcEngine == null)) {
                                SmallClassPluginDriver.this.mRtcEngine.muteRemoteVideo(j, true);
                            }
                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setPullStreamStateForce(3);
                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setCameraPerm(0);
                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setStudentOnline(false);
                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setShowEmoji(false);
                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setRaiseHandUp(false);
                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setOnStageAction(false);
                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setOpenMic(false);
                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setVideoMute(false);
                            SmallClassPluginDriver.this.mSmallClassVideoList.remove(indexOf);
                            if (SmallClassPluginDriver.this.mPluginView != null) {
                                SmallClassPluginDriver.this.mPluginView.removeSmallClassVideo(SmallClassPluginDriver.this.mSmallClassVideoList, indexOf);
                            }
                        }
                    }
                }
            }

            public void didAudioMuted(final long j, final boolean z, String str) {
                if ("Engine".equals(str)) {
                    ThreadUtils.runOnUiThread(new Runnable() {
                        public void run() {
                            int indexOf;
                            if (PadUtils.isPad(Utils.getApp()) && SmallClassPluginDriver.this.isSmallClass) {
                                StudentVideoBean.ListBean unused = SmallClassPluginDriver.this.currentStudent = (StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassMap.get(Long.valueOf(j));
                                if (SmallClassPluginDriver.this.currentStudent != null && SmallClassPluginDriver.this.mSmallClassVideoList.contains(SmallClassPluginDriver.this.currentStudent) && j != SmallClassPluginDriver.this.mUid && (indexOf = SmallClassPluginDriver.this.mSmallClassVideoList.indexOf(SmallClassPluginDriver.this.currentStudent)) > -1) {
                                    XesLogTag access$300 = SmallClassPluginDriver.TAG;
                                    XesLog.i(access$300, "didAudioMuted mute = " + z + ",uid = " + j);
                                    if (z) {
                                        ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setOpenMic(false);
                                    } else {
                                        ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setOpenMic(true);
                                    }
                                    if (SmallClassPluginDriver.this.mPluginView != null) {
                                        SmallClassPluginDriver.this.mPluginView.changeSmallClassVideo(SmallClassPluginDriver.this.mSmallClassVideoList, indexOf);
                                    }
                                }
                            }
                        }
                    });
                }
            }

            public void didVideoMuted(final long j, final boolean z, String str) {
                if ("Engine".equals(str)) {
                    if (j == SmallClassPluginDriver.this.mUid) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("本人mute状态", j + " is " + z);
                        XesLog.ut(SmallClassPluginDriver.TAG.get(), jsonObject);
                    }
                    ThreadUtils.runOnUiThread(new Runnable() {
                        public void run() {
                            int indexOf;
                            if (PadUtils.isPad(Utils.getApp()) && SmallClassPluginDriver.this.isSmallClass) {
                                StudentVideoBean.ListBean unused = SmallClassPluginDriver.this.currentStudent = (StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassMap.get(Long.valueOf(j));
                                if (SmallClassPluginDriver.this.currentStudent != null) {
                                    SmallClassPluginDriver.this.currentStudent.setVideoMute(z);
                                    if (SmallClassPluginDriver.this.mSmallClassVideoList.contains(SmallClassPluginDriver.this.currentStudent) && j != SmallClassPluginDriver.this.mUid && (indexOf = SmallClassPluginDriver.this.mSmallClassVideoList.indexOf(SmallClassPluginDriver.this.currentStudent)) > -1) {
                                        XesLogTag access$300 = SmallClassPluginDriver.TAG;
                                        XesLog.i(access$300, "didVideoMuted mute = " + z);
                                        if (z) {
                                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setPullStreamState(3);
                                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setCameraPerm(0);
                                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setVideoMute(true);
                                        } else {
                                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setPullStreamState(0);
                                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setCameraPerm(1);
                                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(indexOf)).setVideoMute(false);
                                        }
                                        if (SmallClassPluginDriver.this.mPluginView != null) {
                                            SmallClassPluginDriver.this.mPluginView.changeSmallClassVideo(SmallClassPluginDriver.this.mSmallClassVideoList, indexOf);
                                        }
                                    }
                                }
                            }
                        }
                    });
                }
            }

            public void onRemoteVideoStateChanged(final long j, final int i, String str) {
                if ("Engine".equalsIgnoreCase(str)) {
                    Handler mainHandler = ThreadUtils.getMainHandler();
                    AnonymousClass5 r0 = new Runnable() {
                        public void run() {
                            int access$3100;
                            int i = i;
                            if ((i == 2 || i == 0) && PadUtils.isPad(Utils.getApp()) && SmallClassPluginDriver.this.isSmallClass) {
                                StudentVideoBean.ListBean unused = SmallClassPluginDriver.this.currentStudent = (StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassMap.get(Long.valueOf(j));
                                if (SmallClassPluginDriver.this.currentStudent != null && j != SmallClassPluginDriver.this.mUid && (access$3100 = SmallClassPluginDriver.this.findUidIndex(j)) > -1) {
                                    XesLogTag access$300 = SmallClassPluginDriver.TAG;
                                    XesLog.i(access$300, "onRemoteVideoStateChanged state = " + i);
                                    if (!((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(access$3100)).isVideoMute()) {
                                        if (i == 2) {
                                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(access$3100)).setPullStreamState(2);
                                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(access$3100)).setCameraPerm(1);
                                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(access$3100)).setStudentOnline(true);
                                        } else {
                                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(access$3100)).setCameraPerm(0);
                                            ((StudentVideoBean.ListBean) SmallClassPluginDriver.this.mSmallClassVideoList.get(access$3100)).setStudentOnline(false);
                                        }
                                        if (SmallClassPluginDriver.this.mPluginView != null) {
                                            SmallClassPluginDriver.this.mPluginView.changeSmallClassVideo(SmallClassPluginDriver.this.mSmallClassVideoList, access$3100);
                                        }
                                    }
                                }
                            }
                        }
                    };
                    if (!(mainHandler instanceof Handler)) {
                        mainHandler.post(r0);
                    } else {
                        AsynchronousInstrumentation.handlerPost(mainHandler, r0);
                    }
                }
            }
        });
    }

    private void initView() {
        FrameLayout.LayoutParams newLp = LiveAreaContext.get().getHeadLp().newLp();
        if (PadUtils.isPad(Utils.getApp())) {
            SmallClassVideoPluginView smallClassVideoPluginView = new SmallClassVideoPluginView(this.mContext, isAudition());
            smallClassVideoPluginView.setDriver(this);
            int i = (newLp.height * 4) / 3;
            newLp.setMarginStart(newLp.getMarginStart() + i);
            newLp.width -= i;
            newLp.height -= newLp.height / 76;
            this.mPluginView = smallClassVideoPluginView;
        } else {
            this.mPluginView = new SmallClassVideoPluginViewPhone(this.mContext);
            newLp.topMargin += newLp.height / 2;
            newLp.height /= 2;
        }
        this.mPluginView.setAllOnStage(this.mIsAllStage);
        this.mPluginView.driver = this;
        this.mPluginView.mUid = Long.valueOf(this.mUid);
        this.mPluginView.classType = this.mClassType;
        if (PadUtils.isPad(Utils.getApp()) || !isAudition()) {
            this.mLiveRoomProvider.addView(this, this.mPluginView, this.mPluginConfData.getViewLevel("StudentViedeo"), newLp);
            LiveAreaContext.get().layoutObserver.observe(this, new Observer<LiveAreaContext>() {
                public void onChanged(LiveAreaContext liveAreaContext) {
                    if (SmallClassPluginDriver.this.mPluginView != null) {
                        XesLog.i(SmallClassPluginDriver.TAG, "Small_S", "SmallClassPlugin onChanged ");
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SmallClassPluginDriver.this.mPluginView.getLayoutParams();
                        liveAreaContext.getHeadLp().mergeLp(layoutParams);
                        if (PadUtils.isPad(Utils.getApp())) {
                            int i = (layoutParams.height * 4) / 3;
                            layoutParams.setMarginStart(layoutParams.getMarginStart() + i);
                            layoutParams.width -= i;
                            layoutParams.height -= layoutParams.height / 76;
                        } else {
                            layoutParams.topMargin += layoutParams.height / 2;
                            layoutParams.height /= 2;
                        }
                        SmallClassPluginDriver.this.mPluginView.setLayoutParams(layoutParams);
                    }
                }
            });
            if (PadUtils.isPad(Utils.getApp())) {
                FrameLayout.LayoutParams newLp2 = LiveAreaContext.get().getHeadLp().newLp();
                this.mSpeechStudentView = new SpeechStudentView(this.mContext);
                this.mLiveRoomProvider.addView(this, this.mSpeechStudentView, this.mPluginConfData.getViewLevel("StudentViedeo"), newLp2);
                LiveAreaContext.get().layoutObserver.observe(this, new Observer<LiveAreaContext>() {
                    public void onChanged(LiveAreaContext liveAreaContext) {
                        if (SmallClassPluginDriver.this.mSpeechStudentView != null) {
                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SmallClassPluginDriver.this.mSpeechStudentView.getLayoutParams();
                            liveAreaContext.getHeadLp().mergeLp(layoutParams);
                            SmallClassPluginDriver.this.mSpeechStudentView.setLayoutParams(layoutParams);
                        }
                    }
                });
            }
        }
    }

    private boolean getLookOthers() {
        if (!this.mIsParentAudit) {
            return true;
        }
        ParentAuditCloudData parentAuditParam = HwCloudControlHelper.get().getParentAuditParam();
        if (parentAuditParam == null || parentAuditParam.getLookOther() == null || !parentAuditParam.getLookOther().equals("1")) {
            return false;
        }
        return true;
    }

    private void initSmallClassStudents() {
        boolean z = this.mIsParentAudit;
        Call<HiResponse<List<StudentVideoBean.ListBean>>> smallClassStudentList = ((StudentVideoApi) Api.create(StudentVideoApi.class)).getSmallClassStudentList(ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/classroom/student/classStudentList", new StudentListBody(this.planId, this.classId, z ? 1 : 0));
        AnonymousClass27 r1 = new OmyCallback<HiResponse<List<StudentVideoBean.ListBean>>>(new IError() {
            public void onFail(int i, String str) {
                XesLog.i(SmallClassPluginDriver.TAG, "student list onFailed");
            }

            public void onError(int i, String str) {
                XesLog.i(SmallClassPluginDriver.TAG, "student list onError");
            }
        }) {
            public void onSuccess(HiResponse<List<StudentVideoBean.ListBean>> hiResponse) {
                if (SmallClassPluginDriver.this.mIsLookOther && hiResponse.successful() && !SmallClassPluginDriver.this.isDistory) {
                    List data = hiResponse.getData();
                    if (data != null && data.size() > 0) {
                        for (int i = 0; i < data.size(); i++) {
                            StudentVideoBean.ListBean listBean = (StudentVideoBean.ListBean) data.get(i);
                            listBean.setOpenMic(SmallClassPluginDriver.this.mPlayer.getRemoteStateOpenMic(listBean.getUserId()));
                            SmallClassPluginDriver.this.mSmallClassMap.put(Long.valueOf(listBean.getUserId()), listBean);
                        }
                    }
                    SmallClassPluginDriver.this.mPluginView.putAllStudentInfo(SmallClassPluginDriver.this.mSmallClassMap);
                    ArrayList<Long> remoteUsers = SmallClassPluginDriver.this.mPlayer.getRemoteUsers();
                    if (remoteUsers != null) {
                        for (int i2 = 0; i2 < remoteUsers.size(); i2++) {
                            SmallClassPluginDriver smallClassPluginDriver = SmallClassPluginDriver.this;
                            StudentVideoBean.ListBean unused = smallClassPluginDriver.currentStudent = (StudentVideoBean.ListBean) smallClassPluginDriver.mSmallClassMap.get(remoteUsers.get(i2));
                            if (SmallClassPluginDriver.this.currentStudent != null && !SmallClassPluginDriver.this.mSmallClassVideoList.contains(SmallClassPluginDriver.this.currentStudent)) {
                                SmallClassPluginDriver.this.mSmallClassVideoList.add(SmallClassPluginDriver.this.mSmallClassVideoList.size(), SmallClassPluginDriver.this.currentStudent);
                            }
                        }
                        if (SmallClassPluginDriver.this.mPluginView != null) {
                            SmallClassPluginDriver.this.mPluginView.updateSmallClassVideoList(SmallClassPluginDriver.this.mSmallClassVideoList);
                        }
                    }
                }
            }
        };
        if (!(smallClassStudentList instanceof Call)) {
            smallClassStudentList.enqueue(r1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) smallClassStudentList, r1);
        }
    }

    public void showMyShelf() {
        if (isAudition()) {
            enableLocalAudio(false);
            enableLocalVideo(false);
        }
        if (PadUtils.isPad(Utils.getApp())) {
            syncStudentView(0);
            return;
        }
        if (isHasCameraPermission()) {
            this.mySelf.setCameraPerm(1);
            AbstractStudentVideoPluginView<SmallClassPluginDriver> abstractStudentVideoPluginView = this.mPluginView;
            if (abstractStudentVideoPluginView != null) {
                abstractStudentVideoPluginView.setTurnState1(true);
                this.mPluginView.studentOnline(0, this.mySelf);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("有摄像头权限", "显示");
                XesLog.ut(TAG.get(), jsonObject);
            }
            showStudentVideo(this.mUid, 0);
            syncStudentView(0);
        } else {
            this.mySelf.setCameraPerm(0);
            AbstractStudentVideoPluginView<SmallClassPluginDriver> abstractStudentVideoPluginView2 = this.mPluginView;
            if (abstractStudentVideoPluginView2 != null) {
                abstractStudentVideoPluginView2.setTurnState1(false);
                this.mPluginView.showNoPermissionView(0);
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("无摄像头权限", "隐藏");
                XesLog.ut(TAG.get(), jsonObject2);
            }
        }
        showStudentInfo(this.mySelf, 0);
    }

    public StudentVideoBean.ListBean addMySelf() {
        StudentVideoBean.ListBean listBean = new StudentVideoBean.ListBean();
        listBean.setNickName(this.mUserInfoProxy.getNickName());
        listBean.setAvatar(this.mUserInfoProxy.getAvatar());
        listBean.setLevel(this.mUserInfoProxy.getLevel());
        listBean.setUserId(this.mUid);
        if (isHasCameraPermission()) {
            listBean.setOpenCamera(true);
            listBean.setCameraPerm(1);
        } else {
            listBean.setOpenCamera(false);
            listBean.setCameraPerm(0);
        }
        if (isHasMicPermission()) {
            listBean.setOpenMic(true);
        } else {
            listBean.setOpenMic(false);
        }
        return listBean;
    }

    /* access modifiers changed from: private */
    public void setLocalMicInfo(boolean z) {
        if (z) {
            this.mySelf.setOpenMic(true);
        } else {
            this.mySelf.setOpenMic(false);
        }
    }

    /* access modifiers changed from: private */
    public void setLocalCameraInfo(boolean z) {
        if (z) {
            this.mySelf.setOpenCamera(true);
            this.mySelf.setCameraPerm(1);
            return;
        }
        this.mySelf.setOpenCamera(false);
        this.mySelf.setCameraPerm(0);
    }

    private void showStudentVideo(long j, int i) {
        if (this.mRtcViewModel != null) {
            SurfaceView surfaceView = this.mSurfaceViewMap.get(Long.valueOf(j));
            if (surfaceView == null) {
                surfaceView = this.mRtcViewModel.getSurfaceView(j);
                if (surfaceView != null) {
                    surfaceView.setZOrderMediaOverlay(false);
                }
                this.mSurfaceViewMap.put(Long.valueOf(j), surfaceView);
            } else if (j != this.mUid) {
                return;
            }
            setUpVideo(j);
            if (!this.mIsAllStage && this.mPluginView != null) {
                surfaceView.setZOrderMediaOverlay(true);
                this.mPluginView.addRenderView(surfaceView, i, this.mySelf);
            }
        }
    }

    public void setUpVideo(long j) {
        if (j == -1) {
            j = this.mUid;
        }
        SurfaceView surfaceView = this.mSurfaceViewMap.get(Long.valueOf(j));
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine == null) {
            return;
        }
        if (j == this.mUid) {
            rTCEngine.setupLocalVideo(surfaceView);
            return;
        }
        rTCEngine.setupRemoteVideo(surfaceView, j);
        this.mRtcEngine.muteRemoteVideo(j, false);
    }

    private void showStudentInfo(StudentVideoBean.ListBean listBean, int i) {
        AbstractStudentVideoPluginView<SmallClassPluginDriver> abstractStudentVideoPluginView = this.mPluginView;
        if (abstractStudentVideoPluginView != null) {
            abstractStudentVideoPluginView.showStudentInfo(listBean, i);
        }
    }

    public synchronized void syncStudentView(int i) {
        StudentVideoBean.ListBean listBean = this.mySelf;
        if (listBean == null || (!listBean.isOnStageAction() && !this.mIsDisableMySelfVideo)) {
            syncStudentView(i, true);
        } else {
            syncStudentView(i, false);
        }
    }

    private synchronized void syncStudentView(int i, boolean z) {
        if (i == 0) {
            StudentVideoBean.ListBean listBean = this.mySelf;
            SurfaceView studentSurfaceView = getStudentSurfaceView(listBean.getUserId(), z);
            if (!(studentSurfaceView == null || this.mIsAllStage || this.mPluginView == null)) {
                studentSurfaceView.setZOrderMediaOverlay(true);
                this.mPluginView.addRenderView(studentSurfaceView, 0, listBean);
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void startPullAllStream() {
        if (this.mSmallClassVideoList != null) {
            for (int i = 0; i < this.mSmallClassVideoList.size(); i++) {
                this.mSmallClassVideoList.get(i).setPullStreamStateForce(0);
            }
        }
        AbstractStudentVideoPluginView<SmallClassPluginDriver> abstractStudentVideoPluginView = this.mPluginView;
        if (abstractStudentVideoPluginView != null) {
            abstractStudentVideoPluginView.updateSmallClassVideoList(this.mSmallClassVideoList);
        }
    }

    public void closePullAllStreams() {
        if (this.mSmallClassVideoList != null) {
            for (int i = 0; i < this.mSmallClassVideoList.size(); i++) {
                RTCEngine rTCEngine = this.mRtcEngine;
                if (rTCEngine != null) {
                    rTCEngine.muteRemoteVideo(this.mSmallClassVideoList.get(i).getUserId(), true);
                }
                this.mSmallClassVideoList.get(i).setPullStreamState(4);
            }
        }
        AbstractStudentVideoPluginView<SmallClassPluginDriver> abstractStudentVideoPluginView = this.mPluginView;
        if (abstractStudentVideoPluginView != null) {
            abstractStudentVideoPluginView.updateSmallClassVideoList(this.mSmallClassVideoList);
        }
    }

    public void applyMicPermission() {
        new RxPermissions(this.mContext).request(new String[]{"android.permission.RECORD_AUDIO"}).subscribe(new Consumer<Boolean>() {
            public void accept(Boolean bool) {
                if (bool.booleanValue()) {
                    SmallClassPluginDriver.this.syncStudentView(0);
                }
            }
        });
    }

    public SurfaceView getStudentSurfaceView(long j, boolean z) {
        if (this.mRtcEngine == null || this.mRtcViewModel == null) {
            return null;
        }
        SurfaceView surfaceView = this.mSurfaceViewMap.get(Long.valueOf(j));
        if (surfaceView == null) {
            surfaceView = this.mRtcViewModel.getSurfaceView(j);
            if (surfaceView != null) {
                surfaceView.setZOrderMediaOverlay(false);
                this.mSurfaceViewMap.put(Long.valueOf(j), surfaceView);
                if (j == this.mUid) {
                    this.mRtcEngine.setupLocalVideo(surfaceView);
                } else {
                    this.mRtcEngine.setupRemoteVideo(surfaceView, j);
                }
            }
        } else if (z) {
            if (j == this.mUid) {
                this.mRtcEngine.setupLocalVideo(surfaceView);
            } else {
                this.mRtcEngine.setupRemoteVideo(surfaceView, j);
            }
        }
        return surfaceView;
    }

    public SurfaceView getSurfaceView(long j) {
        SurfaceView surfaceView = this.mSurfaceViewMap.get(Long.valueOf(j));
        if (surfaceView == null && (surfaceView = this.mRtcViewModel.getSurfaceView(j)) != null) {
            surfaceView.setZOrderMediaOverlay(false);
            this.mSurfaceViewMap.put(Long.valueOf(j), surfaceView);
        }
        return surfaceView;
    }

    public void setUpRemoteSurfaceView(SurfaceView surfaceView, long j) {
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngine.setupRemoteVideo(surfaceView, j);
        }
    }

    public boolean isHasMicPermission() {
        return PermissionUtils.isGranted("android.permission.RECORD_AUDIO");
    }

    public boolean isHasCameraPermission() {
        return PermissionUtils.isGranted("android.permission.CAMERA");
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [com.tal.app.thinkacademy.live.business.studentvideo.PermissCameraView, android.view.View] */
    public void addPermissonWindow() {
        if (this.cameraView != null) {
            this.mLiveRoomProvider.removeView(this.cameraView);
        }
        PermissCameraView permissCameraView = new PermissCameraView(this.mContext);
        this.cameraView = permissCameraView;
        permissCameraView.setDriver(this);
        this.mLiveRoomProvider.addView(this, this.cameraView, this.mPluginConfData.getViewLevel("StudentViedeo"), LiveAreaContext.get().getPptLp().newLp());
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.tal.app.thinkacademy.live.business.studentvideo.PermissCameraView, android.view.View] */
    public void removePermissView() {
        if (this.cameraView != null) {
            this.mLiveRoomProvider.removeView(this.cameraView);
            this.cameraView = null;
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.tal.app.thinkacademy.live.business.studentvideo.PermissCameraView, android.view.View] */
    public void settingView() {
        if (this.cameraView != null) {
            this.mLiveRoomProvider.removeView(this.cameraView);
            this.cameraView = null;
            PluginEventBus.onEvent(DataBusKey.SETTING_PERMISSION, PluginEventData.obtainData(StudentVideoPluginDriver.class, ""));
            PermissionUtils.launchAppDetailsSettings();
        }
    }

    public void setMuteStudentAudio(boolean z) {
        int i = z ? 2 : 1;
        this.isOpenMic = i;
        InteractLogReport.uploadRtcStatusLog(this.classId, this.planId, i, this.isOpenCamera);
    }

    public void setMuteStudentVideo(boolean z) {
        PluginEventData pluginEventData;
        this.isMuteStudentVideo = z;
        int i = z ? 2 : 1;
        this.isOpenCamera = i;
        InteractLogReport.uploadRtcStatusLog(this.classId, this.planId, this.isOpenMic, i);
        if (!PadUtils.isPad(Utils.getApp())) {
            if (this.isMuteStudentVideo) {
                pluginEventData = new PluginEventData(StudentVideoPluginDriver.class, DataBusKey.USER_MUTE_VIDEO_KEY, "2");
            } else {
                pluginEventData = new PluginEventData(StudentVideoPluginDriver.class, DataBusKey.USER_MUTE_VIDEO_KEY, "1");
            }
            PluginEventBus.onEvent(DataBusKey.USER_MUTE_VIDEO_KEY, pluginEventData);
        }
    }

    public void enableLocalVideo(boolean z) {
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "enableLocalVideo turnOn=" + z);
        RtcViewModel rtcViewModel = this.mRtcViewModel;
        if (rtcViewModel != null) {
            if (!z) {
                rtcViewModel.enableLocalVideo(false);
            } else if (!isAudition()) {
                XesLog.i(xesLogTag, "enableLocalVideo 非旁听生才会打开视频推流");
                this.mRtcViewModel.enableLocalVideo(true);
            }
        }
    }

    public void enableLocalAudio(boolean z) {
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "enableLocalAudio turnOn=" + z);
        RtcViewModel rtcViewModel = this.mRtcViewModel;
        if (rtcViewModel == null) {
            XesLog.i(xesLogTag, "enableLocalAudio mRtcViewModel is null");
        } else if (!z) {
            rtcViewModel.enableLocalAudio(false);
        } else if (!isAudition()) {
            XesLog.i(xesLogTag, "enableLocalAudio 非旁听生才会打开音频推流");
            this.mRtcViewModel.enableLocalAudio(true);
        }
    }

    private boolean isAudition() {
        return (this.mLiveRoomProvider == null || this.mLiveRoomProvider.getDataStorage() == null || this.mLiveRoomProvider.getDataStorage().getCourseInfo() == null || this.mLiveRoomProvider.getDataStorage().getCourseInfo().getIsAudition() != CourseInfo.ROLE_AUDITION) ? false : true;
    }

    /* access modifiers changed from: private */
    public void videoCallOn(boolean z) {
        if (this.mRtcEngine != null) {
            this.mySelf.setShowOpenCameraButton(z);
            if (this.mPluginView != null) {
                this.mySelf.setDisableTheVideo(true);
                if (PadUtils.isPad(Utils.getApp())) {
                    syncStudentView(0);
                } else {
                    this.mPluginView.studentOffline(0, this.mySelf);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void videoCallOff(boolean z) {
        if (this.mRtcEngine != null && this.mPluginView != null) {
            if (this.isMuteStudentVideo) {
                enableLocalVideo(false);
            } else {
                enableLocalVideo(true);
            }
            this.mySelf.setShowOpenCameraButton(z);
            if (!this.mIsDisableMySelfVideo) {
                this.mySelf.setDisableTheVideo(false);
            }
            if (PadUtils.isPad(Utils.getApp())) {
                RTCEngine rTCEngine = this.mRtcEngine;
                if (rTCEngine != null) {
                    rTCEngine.setupLocalVideo(getStudentSurfaceView(this.mUid, false));
                }
            } else {
                this.mPluginView.studentOnline(0, this.mySelf);
                setUpVideo(this.mUid);
            }
            syncStudentView(0);
        }
    }

    public void onMessage(String str, String str2) {
        long j = 0;
        MsgBean msgBean = null;
        if (DataBusKey.RAISE_HAND.equals(str)) {
            try {
                msgBean = (MsgBean) GsonUtil.getInstance().fromJson(str2, new TypeToken<MsgBean<Object>>() {
                }.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (msgBean != null && msgBean.getFrom() != null) {
                Message obtain = Message.obtain();
                try {
                    j = Long.parseLong(msgBean.getFrom().getUserId());
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
                obtain.what = 1;
                obtain.obj = Long.valueOf(j);
                Handler handler = this.mHandler;
                if (!(handler instanceof Handler)) {
                    handler.sendMessage(obtain);
                } else {
                    AsynchronousInstrumentation.sendMessage(handler, obtain);
                }
            }
        } else if (DataBusKey.SEND_EMOJI.equals(str) || "animation_emoji".equals(str)) {
            if (PadUtils.isPad(Utils.getApp())) {
                try {
                    msgBean = (MsgBean) GsonUtil.getInstance().fromJson(str2, new TypeToken<MsgBean<EmojiBean<Object>>>() {
                    }.getType());
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                if (msgBean != null && msgBean.getData() != null && msgBean.getFrom() != null) {
                    try {
                        j = Long.parseLong(msgBean.getFrom().getUserId());
                    } catch (NumberFormatException e4) {
                        e4.printStackTrace();
                    }
                    int type = ((EmojiBean) msgBean.getData()).getType();
                    if (type == 1) {
                        showEmoji(j, (EmojiBean) ((MsgBean) GsonUtils.fromJson(str2, new TypeToken<MsgBean<EmojiBean<EmojiLocalImageResourceBean>>>() {
                        }.getType())).getData(), true);
                    } else if (type == 2) {
                        showEmoji(j, (EmojiBean) ((MsgBean) GsonUtils.fromJson(str2, new TypeToken<MsgBean<EmojiBean<EmojiOnlineLottieResourceBean>>>() {
                        }.getType())).getData(), true);
                    } else if (type == 3) {
                        showEmoji(j, (EmojiBean) ((MsgBean) GsonUtils.fromJson(str2, new TypeToken<MsgBean<EmojiBean<EmojiOnlineImageResourceBean>>>() {
                        }.getType())).getData(), true);
                    }
                }
            }
        } else if (IrcKey.LEVEL_CHAT_MSG.equals(str)) {
            onReceiveLevelMsg(str, str2);
        }
    }

    private void onReceiveLevelMsg(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str2).optJSONObject(str).optString("content"));
            if (jSONObject.optInt("type") == 142) {
                updateOtherUserLevel(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void updateOtherUserLevel(String str) {
        PluginEventBus.onEvent(DataBusKey.SHOW_OTHER_LEVEL_KEY, new PluginEventData(SmallClassPluginDriver.class, DataBusKey.SHOW_OTHER_LEVEL_KEY, str));
    }

    public void onDestroy() {
        try {
            for (Map.Entry next : this.mSurfaceViewMap.entrySet()) {
                SurfaceView surfaceView = (SurfaceView) next.getValue();
                Long l = (Long) next.getKey();
                if (surfaceView != null) {
                    if (surfaceView.getParent() != null) {
                        ((ViewGroup) surfaceView.getParent()).removeView(surfaceView);
                        XesLogTag xesLogTag = TAG;
                        XesLog.i(xesLogTag, "开始移除，uid=" + l);
                    } else {
                        XesLogTag xesLogTag2 = TAG;
                        XesLog.i(xesLogTag2, "没有父视图，不需要移除，uid=" + l);
                    }
                    if (surfaceView.getParent() != null) {
                        XesLogTag xesLogTag3 = TAG;
                        XesLog.i(xesLogTag3, "检查：未移除掉！uid=" + l);
                    } else {
                        XesLogTag xesLogTag4 = TAG;
                        XesLog.i(xesLogTag4, "检查：已经移除！uid=" + l);
                    }
                } else {
                    XesLogTag xesLogTag5 = TAG;
                    XesLog.i(xesLogTag5, "surfaceView为空，不需要移除！uid=" + l);
                }
            }
        } catch (Exception e) {
            XesLogTag xesLogTag6 = TAG;
            XesLog.i(xesLogTag6, "遍历移除surfaceView引用失败=" + e);
        }
        this.isDistory = true;
        PluginEventBus.unregister(DataBusKey.COURSE_USERCOINS_KEY, this.observerUserCourseCoins);
        PluginEventBus.unregister(DataBusKey.VIDEO_CALL_STATUS, this.observerVideoCall);
        PluginEventBus.unregister(DataBusKey.VIDEO_CALL_F_STATUS, this.observerVideoFCall);
        if (PadUtils.isPad(Utils.getApp())) {
            PluginEventBus.unregister(DataBusKey.UPDATE_GROUP_AUDIO, this.observerCollective);
        }
        PluginEventBus.unregister(DataBusKey.STUDENTVIDEO_MUTE, this.observerMuteStudentVideo);
        PluginEventBus.unregister(DataBusKey.SHOW_OTHER_LEVEL_KEY, this.observerOtherUserLevel);
        PluginEventBus.unregister(DataBusKey.LEVEL_KEY, this.observerUserLevel);
        if (PadUtils.isPad(Utils.getApp()) && this.isSmallClass) {
            PluginEventBus.unregister(DataBusKey.VIDEO_CHAT_TOGGLE, this.observerVideoState);
        }
        PluginEventBus.unregister(DataBusKey.GROUP_VIDEO_CALL_STUDENT_START, this.observerGrouoVideoCallStart);
        PluginEventBus.unregister(DataBusKey.GROUP_VIDEO_CALL_STUDENT_END, this.observerGrouoVideoCallEnd);
        PluginEventBus.unregister(DataBusKey.GROUP_VIDEO_CALL_STATE, this.observerGrouoVideoCallState);
        PluginEventBus.unregister(DataBusKey.RAISE_HAND, this.mObserverRaiseHand);
        PluginEventBus.unregister(DataBusKey.RANDOM_CALL_KEY, this.mRandomCallWithVideo);
        PluginEventBus.unregister(DataBusKey.USER_MUTE_VIDEO_KEY, this.mObserverCamera);
        XesDataBus.remove(DataBusKey.USER_MUTE_VIDEO_KEY);
        if (PadUtils.isPad(Utils.getApp())) {
            PluginEventBus.unregister(DataBusKey.SEND_EMOJI, this.mObserverEmoji);
        }
        PluginEventBus.unregister(DataBusKey.USER_MUTE_MIC_KEY, this.mObserverMic);
        PluginEventBus.unregister(DataBusKey.VOICE_DRIVER_IS_HEAR_EACH_OTHER, this.mHearEachOtherObserver);
        this.cameraView = null;
        AbstractStudentVideoPluginView<SmallClassPluginDriver> abstractStudentVideoPluginView = this.mPluginView;
        if (abstractStudentVideoPluginView != null) {
            abstractStudentVideoPluginView.onDestroy();
            this.mPluginView = null;
        }
        SpeechStudentView speechStudentView = this.mSpeechStudentView;
        if (speechStudentView != null) {
            speechStudentView.onDestroy();
            this.mSpeechStudentView = null;
        }
    }

    public void track_click_group_own_video(String str) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("button_status", str);
        LeanplumUtil.commonTrack(LeanplumUtil.click_group_own_video, trackMap);
        String str2 = EnterRoomMuteData.STATUS_UN_MUTE.equals(str) ? "开启" : "关闭";
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("本人摄像头状态", str2);
        XesLog.ut(TAG.get(), jsonObject);
    }

    public void track_click_group_others_video(String str) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("button_status", str);
        LeanplumUtil.commonTrack(LeanplumUtil.click_group_others_video, trackMap);
    }

    public void track_show_groupvideo(int i) {
        HashMap<String, String> trackMap = LeanplumUtil.trackMap();
        trackMap.put("showvideo_num", i + "");
        LeanplumUtil.commonTrack(LeanplumUtil.show_groupvideo, trackMap);
    }

    public void stopPullStream(long j) {
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngine.muteRemoteVideo(j, true);
        }
    }

    public void startPullStream(long j) {
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngine.muteRemoteVideo(j, false);
        }
    }

    /* access modifiers changed from: private */
    public void showRaiseHand(long j, boolean z) {
        int indexOf;
        long j2 = this.mUid;
        if (j2 == j) {
            AbstractStudentVideoPluginView<SmallClassPluginDriver> abstractStudentVideoPluginView = this.mPluginView;
            if (abstractStudentVideoPluginView != null) {
                abstractStudentVideoPluginView.showRaiseHand(j2, z);
            }
        } else if (PadUtils.isPad(Utils.getApp())) {
            StudentVideoBean.ListBean listBean = this.mSmallClassMap.get(Long.valueOf(j));
            this.currentStudent = listBean;
            if (listBean != null && (indexOf = this.mSmallClassVideoList.indexOf(this.currentStudent)) > -1) {
                this.mSmallClassVideoList.get(indexOf).setRaiseHandUp(z);
                AbstractStudentVideoPluginView<SmallClassPluginDriver> abstractStudentVideoPluginView2 = this.mPluginView;
                if (abstractStudentVideoPluginView2 != null) {
                    abstractStudentVideoPluginView2.changeSmallClassVideo(this.mSmallClassVideoList, indexOf);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public Long getHideObj(long j) {
        Long l = this.mHideEmojiMap.get(Long.valueOf(j));
        if (l != null) {
            return l;
        }
        Long valueOf = Long.valueOf(j);
        this.mHideEmojiMap.put(Long.valueOf(j), valueOf);
        return valueOf;
    }

    public void showForbidUserView(long j, boolean z) {
        if (z) {
            this.mHandler.removeMessages(101, getHideObj(j));
            Message obtain = Message.obtain();
            obtain.what = 101;
            obtain.obj = getHideObj(j);
            this.mHandler.sendMessageDelayed(obtain, EMOJI_DELAY_TIME);
            return;
        }
        this.mHandler.removeMessages(101, getHideObj(j));
    }

    /* access modifiers changed from: private */
    public void hideForbidUserView(long j) {
        int indexOf;
        StudentVideoBean.ListBean listBean = this.mSmallClassMap.get(Long.valueOf(j));
        this.currentStudent = listBean;
        if (listBean != null && (indexOf = this.mSmallClassVideoList.indexOf(this.currentStudent)) > -1) {
            this.mSmallClassVideoList.get(indexOf).setShowForbidUserView(false);
            AbstractStudentVideoPluginView<SmallClassPluginDriver> abstractStudentVideoPluginView = this.mPluginView;
            if (abstractStudentVideoPluginView != null) {
                abstractStudentVideoPluginView.changeSmallClassVideo(this.mSmallClassVideoList, indexOf);
            }
        }
    }

    /* access modifiers changed from: private */
    public void showEmoji(long j, EmojiBean emojiBean, boolean z) {
        int indexOf;
        boolean z2 = false;
        if (z) {
            XesLog.i(TAG, "remove EMOJI_HIDE = " + j);
            this.mHandler.removeMessages(4, getHideObj(j));
        }
        if (emojiBean != null) {
            int type = emojiBean.getType();
            if (type == 2 || type == 4) {
                z2 = true;
            }
            if (this.mUid == j) {
                AbstractStudentVideoPluginView<SmallClassPluginDriver> abstractStudentVideoPluginView = this.mPluginView;
                if (abstractStudentVideoPluginView != null) {
                    abstractStudentVideoPluginView.showEmoji(j, emojiBean, z);
                }
                if (z && !z2) {
                    Message obtain = Message.obtain();
                    obtain.what = 4;
                    obtain.obj = getHideObj(j);
                    this.mHandler.sendMessageDelayed(obtain, EMOJI_DELAY_TIME);
                    return;
                }
                return;
            }
            StudentVideoBean.ListBean listBean = this.mSmallClassMap.get(Long.valueOf(j));
            this.currentStudent = listBean;
            if (listBean != null && (indexOf = this.mSmallClassVideoList.indexOf(this.currentStudent)) > -1) {
                this.mSmallClassVideoList.get(indexOf).setShowEmoji(z);
                this.mSmallClassVideoList.get(indexOf).setEmojiBean(emojiBean);
                AbstractStudentVideoPluginView<SmallClassPluginDriver> abstractStudentVideoPluginView2 = this.mPluginView;
                if (abstractStudentVideoPluginView2 != null) {
                    abstractStudentVideoPluginView2.changeSmallClassVideo(this.mSmallClassVideoList, indexOf);
                }
            }
            if (z && !z2) {
                Message obtain2 = Message.obtain();
                obtain2.what = 4;
                obtain2.obj = getHideObj(j);
                this.mHandler.sendMessageDelayed(obtain2, EMOJI_DELAY_TIME);
            }
        }
    }

    public void updateTopStudents(ArrayList<Long> arrayList) {
        this.mTopStudentMap = arrayList;
        updateStopVideoStudents();
    }

    public void updateStopVideoStudents() {
        if (PadUtils.isPad(Utils.getApp())) {
            this.mStopVideoStudentMap.clear();
            for (Long longValue : this.mSmallClassMap.keySet()) {
                long longValue2 = longValue.longValue();
                this.mStopVideoStudentMap.put(Long.valueOf(longValue2), this.mSmallClassMap.get(Long.valueOf(longValue2)));
            }
            this.mStopVideoStudentMap.remove(Long.valueOf(this.mUid));
        }
    }
}
