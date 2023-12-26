package com.tal.app.thinkacademy.live.business.studentvideo.driver;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.eaydu.omni.RTCChannel;
import com.eaydu.omni.RTCEngine;
import com.eaydu.omni.listener.RTCConnectionStateType;
import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.common.entity.ParentAuditCloudData;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.player.rtcplayer.IRTCEngineProvider;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineProvider;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineProviderUtils;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayerEngineEventListener;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.BarUtils;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModelKt;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.mediacontroller.EnableState;
import com.tal.app.thinkacademy.live.business.studentvideo.AbstractStudentVideoPluginView;
import com.tal.app.thinkacademy.live.business.studentvideo.AuditorPluginViewPad;
import com.tal.app.thinkacademy.live.business.studentvideo.AuditorPluginViewPhone;
import com.tal.app.thinkacademy.live.business.studentvideo.PermissCameraView;
import com.tal.app.thinkacademy.live.business.studentvideo.StudentVideoPluginViewPad;
import com.tal.app.thinkacademy.live.business.studentvideo.StudentVideoPluginViewPadSmallClassView;
import com.tal.app.thinkacademy.live.business.studentvideo.StudentVideoPluginViewPhone;
import com.tal.app.thinkacademy.live.business.studentvideo.api.StudentVideoApi;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.body.StudentListBody;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.body.StudentVideoUidBody;
import com.tal.app.thinkacademy.live.business.studentvideo.listen.PermissionListen;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
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

@PluginAnnotation(classType = 0, desc = "视频回显插件", launchType = "initmodule", moduleId = "110")
@ViewLevels({@ViewLevel(level = 100, name = "StudentViedeo")})
public class StudentVideoPluginDriver extends BaseLivePluginDriver implements PermissionListen {
    private static final int DELAY_TIME = 30000;
    /* access modifiers changed from: private */
    public static final XesLogTag TAG = Tag.BIG_CLASS_VIDEO_DRIVER;
    private PermissCameraView cameraView;
    private int classId;
    /* access modifiers changed from: private */
    public StudentVideoBean.ListBean currentStudent;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    private boolean isAuditor;
    /* access modifiers changed from: private */
    public boolean isDistory;
    /* access modifiers changed from: private */
    public boolean isMuteStudentVideo;
    private int isOpenMic = 1;
    private boolean isParentAuditor;
    /* access modifiers changed from: private */
    public boolean isSmallClass = false;
    private boolean isTakePhotoState = false;
    /* access modifiers changed from: private */
    public boolean isWhile;
    protected String mClassType = EnterRoomMuteData.STATUS_UN_MUTE;
    private Context mContext;
    private CourseInfoProxy mCourseInfo;
    public int mCurrentPage = 1;
    /* access modifiers changed from: private */
    public boolean mIsLookOther = true;
    /* access modifiers changed from: private */
    public volatile List<Long> mJoinStudentList = new ArrayList();
    public int mMaxPage = 1;
    /* access modifiers changed from: private */
    public boolean mNormalState = true;
    public Observer<PluginEventData> mObserverBigClassGroupVideoCamera = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (StudentVideoPluginDriver.class == pluginEventData.getmClass()) {
                XesLog.i(StudentVideoPluginDriver.TAG, "收到操作摄像头，本插件自己设置，直接忽略。");
            } else if ("1".equals(pluginEventData.getData())) {
                XesLog.i(StudentVideoPluginDriver.TAG, "收到大班消息，关闭小组视频，操作摄像头，开");
                if (PadUtils.isPad(Utils.getApp()) && StudentVideoPluginDriver.this.isSmallClass) {
                    ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.mSmallClassVideoList.get(0)).setDisableTheVideo(false);
                    StudentVideoPluginDriver.this.syncStudentView(0);
                } else if (StudentVideoPluginDriver.this.mPluginView != null) {
                    StudentVideoPluginDriver.this.mPluginView.studentOnline(0);
                }
                StudentVideoPluginDriver.this.setMuteStudentVideo(false);
                StudentVideoPluginDriver.this.enableLocalVideo(true);
            } else if (EnterRoomMuteData.STATUS_UN_MUTE.equals(pluginEventData.getData())) {
                XesLog.i(StudentVideoPluginDriver.TAG, "收到大班消息，关闭小组视频，操作摄像头，关");
                if (PadUtils.isPad(Utils.getApp()) && StudentVideoPluginDriver.this.isSmallClass) {
                    ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.mSmallClassVideoList.get(0)).setDisableTheVideo(true);
                    StudentVideoPluginDriver.this.syncStudentView(0);
                } else if (StudentVideoPluginDriver.this.mPluginView != null) {
                    StudentVideoPluginDriver.this.mPluginView.studentOffline(0);
                }
                StudentVideoPluginDriver.this.setMuteStudentVideo(true);
                StudentVideoPluginDriver.this.enableLocalVideo(false);
            }
        }
    };
    /* access modifiers changed from: private */
    public AbstractStudentVideoPluginView<StudentVideoPluginDriver> mPluginView;
    private IRTCEngineProvider mProvider;
    private IRTCEngineProvider.RTCEngineCallback mRTCEngineCallback = new IRTCEngineProvider.RTCEngineCallback() {
        public void onGetRTCEngine(RTCEngine rTCEngine, RTCChannel rTCChannel) {
            RTCEngine unused = StudentVideoPluginDriver.this.mRtcEngine = rTCEngine;
            if (StudentVideoPluginDriver.this.mRtcEngine != null) {
                XesLog.i(StudentVideoPluginDriver.TAG, "获取RTCEngine成功");
                if (PadUtils.isPad(Utils.getApp()) && StudentVideoPluginDriver.this.isSmallClass) {
                    StudentVideoPluginDriver.this.mRtcEngine.setDefaultMuteAllRemoteVideoStreams(true);
                    return;
                }
                return;
            }
            XesLog.e(StudentVideoPluginDriver.TAG, "获取RTCEngine失败");
        }

        public void onGetRTCEngineFail(int i, int i2) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("onGetRTCEngineFail", "RTC回调失败");
            XesLog.ut(StudentVideoPluginDriver.TAG.get(), jsonObject);
        }
    };
    /* access modifiers changed from: private */
    public RTCEngine mRtcEngine;
    private RtcViewModel mRtcViewModel;
    /* access modifiers changed from: private */
    public volatile Map<Long, StudentVideoBean.ListBean> mSmallClassMap = new HashMap();
    /* access modifiers changed from: private */
    public volatile List<StudentVideoBean.ListBean> mSmallClassVideoList = new ArrayList();
    private Map<Long, SurfaceView> mSurfaceViewMap = new HashMap();
    /* access modifiers changed from: private */
    public long mUid;
    private UserInfoProxy mUserInfoProxy;
    /* access modifiers changed from: private */
    public volatile List<StudentVideoBean.ListBean> myGroupList;
    /* access modifiers changed from: private */
    public StudentVideoBean.ListBean mySelf;
    public Observer<PluginEventData> observerCollective = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (PadUtils.isPad(Utils.getApp()) && StudentVideoPluginDriver.this.isSmallClass) {
                StudentVideoPluginDriver.this.mPluginView.setCollectiveSpeech("1".equals(pluginEventData.getData()));
                StudentVideoPluginDriver studentVideoPluginDriver = StudentVideoPluginDriver.this;
                studentVideoPluginDriver.updateStudentsViewList((studentVideoPluginDriver.mCurrentPage - 1) * 6);
            } else if (StudentVideoPluginDriver.this.myGroupList != null) {
                if ("1".equals(pluginEventData.getData())) {
                    StudentVideoPluginDriver.this.mPluginView.showVoiceLottieView(StudentVideoPluginDriver.this.myGroupList.size());
                } else {
                    StudentVideoPluginDriver.this.mPluginView.hideVoiceLottieView(StudentVideoPluginDriver.this.myGroupList.size());
                }
            }
        }
    };
    public Observer<PluginEventData> observerGrouoVideoCallEnd = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            int indexOf;
            long parseLong = Long.parseLong(pluginEventData.getData());
            if (StudentVideoPluginDriver.this.mUid == parseLong) {
                StudentVideoPluginDriver.this.mPluginView.setSwitchEnable(true, EnableState.TEACHER_LINK);
                StudentVideoPluginDriver.this.videoCallOff();
            } else if (StudentVideoPluginDriver.this.mRtcEngine != null) {
                StudentVideoPluginDriver studentVideoPluginDriver = StudentVideoPluginDriver.this;
                StudentVideoBean.ListBean unused = studentVideoPluginDriver.currentStudent = (StudentVideoBean.ListBean) studentVideoPluginDriver.mSmallClassMap.get(Long.valueOf(parseLong));
                if (StudentVideoPluginDriver.this.currentStudent == null) {
                    StudentVideoPluginDriver.this.mRtcEngine.muteRemoteVideo(parseLong, true);
                } else if (StudentVideoPluginDriver.this.mSmallClassVideoList.contains(StudentVideoPluginDriver.this.currentStudent) && (indexOf = StudentVideoPluginDriver.this.mSmallClassVideoList.indexOf(StudentVideoPluginDriver.this.currentStudent)) > -1) {
                    if (!StudentVideoPluginDriver.this.isCurrentPageStudent(indexOf)) {
                        StudentVideoPluginDriver.this.mRtcEngine.muteRemoteVideo(parseLong, true);
                    }
                    ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.mSmallClassVideoList.get(indexOf)).setDisableTheVideo(false);
                    if (PadUtils.isPad(Utils.getApp())) {
                        StudentVideoPluginDriver.this.syncStudentView(indexOf, true);
                    }
                }
            }
        }
    };
    public Observer<PluginEventData> observerGrouoVideoCallGetMic = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            PluginEventData pluginEventData2;
            if (StudentVideoPluginDriver.this.mySelf.isOpenMic()) {
                pluginEventData2 = new PluginEventData(StudentVideoPluginDriver.class, DataBusKey.GROUP_VIDEO_CALL_STUDENT_SEND_MIC, "1");
            } else {
                pluginEventData2 = new PluginEventData(StudentVideoPluginDriver.class, DataBusKey.GROUP_VIDEO_CALL_STUDENT_SEND_MIC, "2");
            }
            PluginEventBus.onEventMain(DataBusKey.GROUP_VIDEO_CALL_STUDENT_SEND_MIC, pluginEventData2);
        }
    };
    public Observer<PluginEventData> observerGrouoVideoCallStart = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            int indexOf;
            long parseLong = Long.parseLong(pluginEventData.getData());
            if (StudentVideoPluginDriver.this.mUid == parseLong) {
                StudentVideoPluginDriver.this.mPluginView.setSwitchEnable(false, EnableState.TEACHER_LINK);
                StudentVideoPluginDriver.this.videoCallOn();
            } else if (StudentVideoPluginDriver.this.mRtcEngine != null) {
                StudentVideoPluginDriver.this.mRtcEngine.muteRemoteVideo(parseLong, false);
                StudentVideoPluginDriver studentVideoPluginDriver = StudentVideoPluginDriver.this;
                StudentVideoBean.ListBean unused = studentVideoPluginDriver.currentStudent = (StudentVideoBean.ListBean) studentVideoPluginDriver.mSmallClassMap.get(Long.valueOf(parseLong));
                if (StudentVideoPluginDriver.this.currentStudent != null && StudentVideoPluginDriver.this.mSmallClassVideoList.contains(StudentVideoPluginDriver.this.currentStudent) && (indexOf = StudentVideoPluginDriver.this.mSmallClassVideoList.indexOf(StudentVideoPluginDriver.this.currentStudent)) > -1) {
                    ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.mSmallClassVideoList.get(indexOf)).setDisableTheVideo(true);
                    if (PadUtils.isPad(Utils.getApp())) {
                        StudentVideoPluginDriver.this.syncStudentView(indexOf, false);
                    }
                }
            }
        }
    };
    public Observer<PluginEventData> observerGroupVideoCallState = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if ("1".equals(pluginEventData.getData())) {
                PluginEventBus.onEvent(DataBusKey.GROUP_VIDEO_CALL_STATUS, new PluginEventData(StudentVideoPluginDriver.class, DataBusKey.GROUP_VIDEO_CALL_STATUS, "videoCallStart"));
            } else {
                PluginEventBus.onEvent(DataBusKey.GROUP_VIDEO_CALL_STATUS, new PluginEventData(StudentVideoPluginDriver.class, DataBusKey.GROUP_VIDEO_CALL_STATUS, "videoCallEnd"));
            }
        }
    };
    public Observer<PluginEventData> observerMuteStudentVideo = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (String.valueOf(0).equals(pluginEventData.getData())) {
                if (PadUtils.isPad(Utils.getApp()) && StudentVideoPluginDriver.this.isSmallClass) {
                    StudentVideoPluginDriver.this.mPluginView.rootViewIsShow(false);
                }
                StudentVideoPluginDriver.this.enableLocalVideo(false);
                if (PadUtils.isPad(Utils.getApp()) && StudentVideoPluginDriver.this.isSmallClass) {
                    StudentVideoPluginDriver.this.closeSmallClassStreams();
                } else if (StudentVideoPluginDriver.this.myGroupList != null) {
                    for (int i = 0; i < StudentVideoPluginDriver.this.myGroupList.size(); i++) {
                        StudentVideoPluginDriver.this.mRtcEngine.muteRemoteVideo(((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.myGroupList.get(i)).getUserId(), true);
                    }
                }
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("mute", "关闭互显");
                XesLog.ut(StudentVideoPluginDriver.TAG.get(), jsonObject);
                return;
            }
            if (PadUtils.isPad(Utils.getApp()) && StudentVideoPluginDriver.this.isSmallClass) {
                StudentVideoPluginDriver.this.mPluginView.rootViewIsShow(true);
            }
            if (!StudentVideoPluginDriver.this.isMuteStudentVideo) {
                StudentVideoPluginDriver.this.enableLocalVideo(true);
            } else {
                StudentVideoPluginDriver.this.enableLocalVideo(false);
            }
            if (PadUtils.isPad(Utils.getApp()) && StudentVideoPluginDriver.this.isSmallClass) {
                StudentVideoPluginDriver.this.pushStudentsStream();
            } else if (StudentVideoPluginDriver.this.myGroupList != null) {
                for (int i2 = 0; i2 < StudentVideoPluginDriver.this.myGroupList.size(); i2++) {
                    StudentVideoPluginDriver.this.mRtcEngine.muteRemoteVideo(((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.myGroupList.get(i2)).getUserId(), false);
                }
            }
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("mute", "打开互显");
            XesLog.ut(StudentVideoPluginDriver.TAG.get(), jsonObject2);
        }
    };
    public Observer<PluginEventData> observerOtherUserLevel = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            int indexOf;
            int indexOf2;
            if (StudentVideoPluginDriver.this.mPluginView != null) {
                try {
                    JSONObject jSONObject = new JSONObject(pluginEventData.getData());
                    String optString = jSONObject.optString("userId");
                    String optString2 = jSONObject.optString("level");
                    StudentVideoBean.ListBean listBean = new StudentVideoBean.ListBean();
                    listBean.setUserId(Long.parseLong(optString));
                    if (PadUtils.isPad(Utils.getApp()) && StudentVideoPluginDriver.this.isSmallClass) {
                        StudentVideoPluginDriver studentVideoPluginDriver = StudentVideoPluginDriver.this;
                        StudentVideoBean.ListBean unused = studentVideoPluginDriver.currentStudent = (StudentVideoBean.ListBean) studentVideoPluginDriver.mSmallClassMap.get(Long.valueOf(Long.parseLong(optString)));
                        if (StudentVideoPluginDriver.this.currentStudent != null && (indexOf2 = StudentVideoPluginDriver.this.mSmallClassVideoList.indexOf(StudentVideoPluginDriver.this.currentStudent)) > -1) {
                            ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.mSmallClassVideoList.get(indexOf2)).setLevel(Integer.parseInt(optString2));
                            StudentVideoPluginDriver.this.syncStudentView(indexOf2);
                        }
                    } else if (StudentVideoPluginDriver.this.myGroupList != null && (indexOf = StudentVideoPluginDriver.this.myGroupList.indexOf(listBean)) != -1) {
                        StudentVideoPluginDriver.this.mPluginView.showLevelIcon(indexOf + 1, optString2);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    public Observer<PluginEventData> observerUserCoins = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if (StudentVideoPluginDriver.this.mPluginView != null) {
                StudentVideoPluginDriver.this.mPluginView.setUserCoins(pluginEventData.getData());
            }
        }
    };
    public Observer<PluginEventData> observerUserLevel = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("当前最新等级", Integer.valueOf(Integer.parseInt(pluginEventData.getData())));
            XesLog.ut(StudentVideoPluginDriver.TAG.get(), jsonObject);
            if (!PadUtils.isPad(Utils.getApp()) || !StudentVideoPluginDriver.this.isSmallClass) {
                StudentVideoPluginDriver.this.mPluginView.showLevelIcon(0, pluginEventData.getData());
            } else if (StudentVideoPluginDriver.this.mSmallClassVideoList.size() > 0) {
                ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.mSmallClassVideoList.get(0)).setLevel(Integer.parseInt(pluginEventData.getData()));
                StudentVideoPluginDriver.this.syncStudentView(0);
            }
        }
    };
    public Observer<PluginEventData> observerVideoCall = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if ("videoCallStart".equals(pluginEventData.getData())) {
                StudentVideoPluginDriver.this.mPluginView.setSwitchEnable(false, EnableState.TEACHER_LINK);
            } else if ("videoCallOn".equals(pluginEventData.getData())) {
                StudentVideoPluginDriver.this.videoCallOn();
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("视频连麦", "上麦");
                jsonObject.addProperty("isMuteStudentVideo", Boolean.valueOf(StudentVideoPluginDriver.this.isMuteStudentVideo));
                XesLog.ut(StudentVideoPluginDriver.TAG.get(), jsonObject);
            } else if ("videoCallOff".equals(pluginEventData.getData())) {
                StudentVideoPluginDriver.this.videoCallOff();
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("视频连麦", "下麦");
                jsonObject2.addProperty("isMuteStudentVideo", Boolean.valueOf(StudentVideoPluginDriver.this.isMuteStudentVideo));
                XesLog.ut(StudentVideoPluginDriver.TAG.get(), jsonObject2);
            } else {
                StudentVideoPluginDriver.this.mPluginView.setSwitchEnable(true, EnableState.TEACHER_LINK);
                StudentVideoPluginDriver.this.videoCallOff();
                JsonObject jsonObject3 = new JsonObject();
                jsonObject3.addProperty("视频连麦", "下麦");
                jsonObject3.addProperty("isMuteStudentVideo", Boolean.valueOf(StudentVideoPluginDriver.this.isMuteStudentVideo));
                XesLog.ut(StudentVideoPluginDriver.TAG.get(), jsonObject3);
            }
        }
    };
    public Observer<PluginEventData> observerVideoFCall = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if ("videoCallTutorOn".equals(pluginEventData.getData())) {
                StudentVideoPluginDriver.this.mPluginView.setSwitchEnable(false, EnableState.TUTOR_LINK);
                StudentVideoPluginDriver.this.videoCallOn();
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("辅导视频连麦", "上麦");
                jsonObject.addProperty("isMuteStudentVideo", Boolean.valueOf(StudentVideoPluginDriver.this.isMuteStudentVideo));
                XesLog.ut(StudentVideoPluginDriver.TAG.get(), jsonObject);
                return;
            }
            StudentVideoPluginDriver.this.mPluginView.setSwitchEnable(true, EnableState.TUTOR_LINK);
            StudentVideoPluginDriver.this.videoCallOff();
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("辅导视频连麦", "下麦");
            jsonObject2.addProperty("isMuteStudentVideo", Boolean.valueOf(StudentVideoPluginDriver.this.isMuteStudentVideo));
            XesLog.ut(StudentVideoPluginDriver.TAG.get(), jsonObject2);
        }
    };
    public Observer<PluginEventData> observerVideoState = new Observer<PluginEventData>() {
        public void onChanged(PluginEventData pluginEventData) {
            if ("1".equals(pluginEventData.getData())) {
                StudentVideoPluginDriver.this.mPluginView.videoChatToggle(true);
            } else {
                StudentVideoPluginDriver.this.mPluginView.videoChatToggle(false);
            }
        }
    };
    private int planId;
    /* access modifiers changed from: private */
    public Runnable runnable = new Runnable() {
        public void run() {
            boolean unused = StudentVideoPluginDriver.this.isWhile = true;
            StudentVideoPluginDriver.this.handler.postDelayed(StudentVideoPluginDriver.this.runnable, 30000);
            StudentVideoPluginDriver.this.initData();
        }
    };
    private int tutorId;

    public void onMessage(String str, String str2) {
    }

    public StudentVideoPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        this.isSmallClass = iLiveRoomProvider.isSmallClass();
        this.mClassType = iLiveRoomProvider.getClassType();
        this.mUserInfoProxy = iLiveRoomProvider.getDataStorage().getUserInfo();
        CourseInfoProxy courseInfo = iLiveRoomProvider.getDataStorage().getCourseInfo();
        this.mCourseInfo = courseInfo;
        this.planId = courseInfo.getPlanId();
        this.classId = this.mCourseInfo.getClassId();
        this.tutorId = this.mCourseInfo.getTutorId();
        this.mUid = Long.parseLong(this.mUserInfoProxy.getId());
        this.isAuditor = this.mCourseInfo.getIsAudition() == CourseInfo.ROLE_AUDITION;
        this.isParentAuditor = this.mCourseInfo.getIsParentAuditLocal();
        this.mIsLookOther = getLookOthers();
        this.mRtcViewModel = RtcViewModelKt.getRtcViewModel(AbilityPack.get());
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "发送存在视频回显消息 通知聊天区域触发动画。是否可以看其他人=" + this.mIsLookOther + "，是否为旁听课=" + this.isAuditor + ",是否为家长旁听=" + this.isParentAuditor);
        eventHasStudentVideo();
        this.mySelf = addMySelf();
        if (PadUtils.isPad(Utils.getApp()) && this.isSmallClass) {
            this.mSmallClassVideoList.add(0, this.mySelf);
        }
        initView();
        initEngine();
        if (!PadUtils.isPad(Utils.getApp()) || !this.isSmallClass) {
            initData();
        } else {
            initSmallClassStudents();
        }
        if (!this.isAuditor) {
            showMyShelf();
        } else {
            this.mRtcEngine.enableLocalAudio(false);
            RtcViewModel rtcViewModel = this.mRtcViewModel;
            if (rtcViewModel != null) {
                rtcViewModel.setMLocalAudioEnable(false);
            }
            this.mRtcEngine.enableLocalVideo(false);
            RtcViewModel rtcViewModel2 = this.mRtcViewModel;
            if (rtcViewModel2 != null) {
                rtcViewModel2.setMLocalVideoEnable(false);
            }
            XesLog.i(xesLogTag, "旁听生关闭音视频回显");
        }
        PluginEventBus.register(this, DataBusKey.UPDATE_COINS, this.observerUserCoins);
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
        PluginEventBus.register(this, DataBusKey.GROUP_VIDEO_CALL_STATE, this.observerGroupVideoCallState);
        PluginEventBus.register(this, DataBusKey.GROUP_VIDEO_CALL_STUDENT_GET_MIC, this.observerGrouoVideoCallGetMic);
        PluginEventBus.register(this, DataBusKey.USER_MUTE_BIG_CLASS_GROUP_VIDEO_KEY, this.mObserverBigClassGroupVideoCamera);
        XesDataBus.with(DataBusKey.TAKE_PHOTO_STATE).observe(this, new StudentVideoPluginDriver$$ExternalSyntheticLambda2(this));
        XesDataBus.with(DataBusKey.CAMERA_PERMISSION).observe(this, new Observer<Object>() {
            public void onChanged(Object obj) {
                Boolean bool = (Boolean) obj;
                if (bool == null || !bool.booleanValue()) {
                    XesLog.i(StudentVideoPluginDriver.TAG, "收到视频权限通知=false");
                    return;
                }
                XesLog.i(StudentVideoPluginDriver.TAG, "收到视频权限通知,有权限，开始推流");
                StudentVideoPluginDriver.this.enableLocalVideo(true);
                StudentVideoPluginDriver.this.showMyShelf();
            }
        });
        XesDataBus.with(DataBusKey.LESSON_EXAM_STATE).observe(this, new Observer<Object>() {
            public void onChanged(Object obj) {
                if (obj != null) {
                    boolean unused = StudentVideoPluginDriver.this.mNormalState = TextUtils.equals("open", (String) obj);
                    StudentVideoPluginDriver studentVideoPluginDriver = StudentVideoPluginDriver.this;
                    studentVideoPluginDriver.showExamMask(studentVideoPluginDriver.mNormalState);
                }
            }
        });
    }

    public /* synthetic */ void lambda$new$0$StudentVideoPluginDriver(Object obj) {
        if (obj != null) {
            String str = (String) obj;
            if ("end".equals(str)) {
                this.isTakePhotoState = false;
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(GoldSource.PHOTOS_ON_THE_WALL_GOLD, str);
                jsonObject.addProperty("onlyShelf", 1);
                jsonObject.addProperty("isMuteStudentVideo", Boolean.valueOf(this.isMuteStudentVideo));
                XesLog.ut(TAG.get(), jsonObject);
                if (!PadUtils.isPad(Utils.getApp()) || !this.isSmallClass) {
                    AbstractStudentVideoPluginView<StudentVideoPluginDriver> abstractStudentVideoPluginView = this.mPluginView;
                    if (abstractStudentVideoPluginView != null) {
                        abstractStudentVideoPluginView.studentOnline(0);
                    }
                } else {
                    this.mSmallClassVideoList.get(0).setDisableTheVideo(false);
                    syncStudentView(0);
                }
                if (!this.isMuteStudentVideo) {
                    enableLocalVideo(true);
                } else {
                    enableLocalVideo(false);
                }
            } else {
                this.isTakePhotoState = true;
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty(GoldSource.PHOTOS_ON_THE_WALL_GOLD, str);
                jsonObject2.addProperty("onlyShelf", 1);
                jsonObject2.addProperty("isMuteStudentVideo", Boolean.valueOf(this.isMuteStudentVideo));
                XesLog.ut(TAG.get(), jsonObject2);
                if (this.mPluginView != null) {
                    if (!PadUtils.isPad(Utils.getApp()) || !this.isSmallClass) {
                        this.mPluginView.studentOffline(0);
                    } else {
                        this.mSmallClassVideoList.get(0).setDisableTheVideo(true);
                        syncStudentView(0);
                    }
                }
                enableLocalVideo(false);
            }
        }
    }

    public void eventHasStudentVideo() {
        PluginEventBus.onEvent(DataBusKey.STUDENTVIDEO_KEY, new PluginEventData(StudentVideoPluginDriver.class, DataBusKey.STUDENTVIDEO_KEY, "1"));
    }

    private void initEngine() {
        RTCEngineProvider rTCEngineProvider = RTCEngineProviderUtils.getInstance().get("Live");
        this.mProvider = rTCEngineProvider;
        rTCEngineProvider.provide((String) null, this.mRTCEngineCallback);
        this.mProvider.addEtcEngineEventListener("StudentVideo", new RtcPlayerEngineEventListener() {
            public void didAudioMuted(long j, boolean z, String str) {
            }

            public void dispatchConnectionState(RTCConnectionStateType rTCConnectionStateType, String str, String str2) {
            }

            public void onOnceLastMileQuality(int i, String str) {
            }

            public void remotefirstAudioRecvWithUid(long j, String str) {
            }

            public void reportAudioVolumeOfSpeaker(long j, int i) {
            }

            public void localUserJoindWithUid(long j, String str) {
                if ("Engine".equals(str)) {
                    long unused = StudentVideoPluginDriver.this.mUid = j;
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("本人加入房间", Long.valueOf(j));
                    XesLog.ut(StudentVideoPluginDriver.TAG.get(), jsonObject);
                }
            }

            public void remoteUserJoinWitnUid(long j, String str) {
                if (!"Engine".equals(str)) {
                    return;
                }
                if (PadUtils.isPad(Utils.getApp()) && StudentVideoPluginDriver.this.isSmallClass) {
                    if (!StudentVideoPluginDriver.this.mJoinStudentList.contains(Long.valueOf(j))) {
                        StudentVideoPluginDriver.this.mJoinStudentList.add(StudentVideoPluginDriver.this.mJoinStudentList.size(), Long.valueOf(j));
                    }
                    StudentVideoPluginDriver studentVideoPluginDriver = StudentVideoPluginDriver.this;
                    StudentVideoBean.ListBean unused = studentVideoPluginDriver.currentStudent = (StudentVideoBean.ListBean) studentVideoPluginDriver.mSmallClassMap.get(Long.valueOf(j));
                    if (StudentVideoPluginDriver.this.currentStudent != null && !StudentVideoPluginDriver.this.mSmallClassVideoList.contains(StudentVideoPluginDriver.this.currentStudent)) {
                        StudentVideoPluginDriver.this.mSmallClassVideoList.add(StudentVideoPluginDriver.this.mSmallClassVideoList.size(), StudentVideoPluginDriver.this.currentStudent);
                        if (StudentVideoPluginDriver.this.mPluginView != null) {
                            StudentVideoPluginDriver.this.mPluginView.updateSmallClassVideoList(StudentVideoPluginDriver.this.mSmallClassVideoList);
                        }
                        StudentVideoPluginDriver studentVideoPluginDriver2 = StudentVideoPluginDriver.this;
                        studentVideoPluginDriver2.syncStudentView(studentVideoPluginDriver2.mSmallClassVideoList.size() - 1);
                        StudentVideoPluginDriver.this.pushStudentsStream();
                    }
                } else if (StudentVideoPluginDriver.this.myGroupList != null) {
                    for (int i = 0; i < StudentVideoPluginDriver.this.myGroupList.size(); i++) {
                        if (j == ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.myGroupList.get(i)).getUserId()) {
                            StudentVideoPluginDriver.this.showStudentVideo(j, i + 1);
                        }
                    }
                }
            }

            public void remotefirstVideoRecvWithUid(long j, String str) {
                int indexOf;
                if (!"Engine".equals(str)) {
                    return;
                }
                if (PadUtils.isPad(Utils.getApp()) && StudentVideoPluginDriver.this.isSmallClass) {
                    StudentVideoPluginDriver studentVideoPluginDriver = StudentVideoPluginDriver.this;
                    StudentVideoBean.ListBean unused = studentVideoPluginDriver.currentStudent = (StudentVideoBean.ListBean) studentVideoPluginDriver.mSmallClassMap.get(Long.valueOf(j));
                    if (StudentVideoPluginDriver.this.currentStudent != null && j != StudentVideoPluginDriver.this.mUid && (indexOf = StudentVideoPluginDriver.this.mSmallClassVideoList.indexOf(StudentVideoPluginDriver.this.currentStudent)) > -1) {
                        ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.mSmallClassVideoList.get(indexOf)).setCameraPerm(1);
                        ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.mSmallClassVideoList.get(indexOf)).setStudentOnline(true);
                        StudentVideoPluginDriver.this.syncStudentView(indexOf);
                    }
                } else if (StudentVideoPluginDriver.this.myGroupList != null) {
                    for (int i = 0; i < StudentVideoPluginDriver.this.myGroupList.size(); i++) {
                        if (j == ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.myGroupList.get(i)).getUserId() && StudentVideoPluginDriver.this.mPluginView != null) {
                            StudentVideoPluginDriver.this.mPluginView.studentOnline(i + 1);
                        }
                    }
                }
            }

            public void didOfflineOfUid(long j, String str) {
                int indexOf;
                if ("Engine".equals(str)) {
                    if (j == StudentVideoPluginDriver.this.mUid) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("本人停止了推流下线了", Long.valueOf(j));
                        XesLog.ut(StudentVideoPluginDriver.TAG.get(), jsonObject);
                    }
                    if (PadUtils.isPad(Utils.getApp()) && StudentVideoPluginDriver.this.isSmallClass) {
                        StudentVideoPluginDriver.this.mJoinStudentList.remove(Long.valueOf(j));
                        StudentVideoPluginDriver studentVideoPluginDriver = StudentVideoPluginDriver.this;
                        StudentVideoBean.ListBean unused = studentVideoPluginDriver.currentStudent = (StudentVideoBean.ListBean) studentVideoPluginDriver.mSmallClassMap.get(Long.valueOf(j));
                        if (StudentVideoPluginDriver.this.currentStudent != null && (indexOf = StudentVideoPluginDriver.this.mSmallClassVideoList.indexOf(StudentVideoPluginDriver.this.currentStudent)) > -1) {
                            if (StudentVideoPluginDriver.this.mPluginView != null) {
                                StudentVideoPluginDriver.this.mRtcEngine.muteRemoteVideo(j, true);
                            }
                            ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.mSmallClassVideoList.get(indexOf)).setCameraPerm(0);
                            ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.mSmallClassVideoList.get(indexOf)).setStudentOnline(false);
                            StudentVideoPluginDriver.this.mSmallClassVideoList.remove(indexOf);
                            if (StudentVideoPluginDriver.this.mPluginView != null) {
                                StudentVideoPluginDriver.this.mPluginView.updateSmallClassVideoList(StudentVideoPluginDriver.this.mSmallClassVideoList);
                            }
                            StudentVideoPluginDriver.this.syncStudentLeaveView();
                            StudentVideoPluginDriver.this.pushStudentsStream();
                        }
                    } else if (StudentVideoPluginDriver.this.myGroupList != null) {
                        for (int i = 0; i < StudentVideoPluginDriver.this.myGroupList.size(); i++) {
                            if (j == ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.myGroupList.get(i)).getUserId() && StudentVideoPluginDriver.this.mPluginView != null) {
                                StudentVideoPluginDriver.this.mPluginView.studentOffline(i + 1);
                            }
                        }
                    }
                }
            }

            public void didVideoMuted(long j, boolean z, String str) {
                int indexOf;
                if ("Engine".equals(str)) {
                    if (j == StudentVideoPluginDriver.this.mUid) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("本人mute状态", j + " is " + z);
                        XesLog.ut(StudentVideoPluginDriver.TAG.get(), jsonObject);
                    }
                    if (PadUtils.isPad(Utils.getApp()) && StudentVideoPluginDriver.this.isSmallClass) {
                        StudentVideoPluginDriver studentVideoPluginDriver = StudentVideoPluginDriver.this;
                        StudentVideoBean.ListBean unused = studentVideoPluginDriver.currentStudent = (StudentVideoBean.ListBean) studentVideoPluginDriver.mSmallClassMap.get(Long.valueOf(j));
                        if (StudentVideoPluginDriver.this.currentStudent != null && StudentVideoPluginDriver.this.mSmallClassVideoList.contains(StudentVideoPluginDriver.this.currentStudent) && j != StudentVideoPluginDriver.this.mUid && (indexOf = StudentVideoPluginDriver.this.mSmallClassVideoList.indexOf(StudentVideoPluginDriver.this.currentStudent)) > -1) {
                            if (z) {
                                ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.mSmallClassVideoList.get(indexOf)).setCameraPerm(0);
                            } else {
                                ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.mSmallClassVideoList.get(indexOf)).setCameraPerm(1);
                            }
                            StudentVideoPluginDriver.this.syncStudentView(indexOf);
                        }
                    } else if (StudentVideoPluginDriver.this.myGroupList != null) {
                        for (int i = 0; i < StudentVideoPluginDriver.this.myGroupList.size(); i++) {
                            if (j == ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.myGroupList.get(i)).getUserId() && StudentVideoPluginDriver.this.mPluginView != null) {
                                StudentVideoPluginDriver.this.mPluginView.studentOffline(i + 1);
                            }
                        }
                    }
                }
            }

            public void onRemoteVideoStateChanged(long j, int i, String str) {
                if ("Engine".equalsIgnoreCase(str) && StudentVideoPluginDriver.this.myGroupList != null) {
                    if (i == 2) {
                        for (int i2 = 0; i2 < StudentVideoPluginDriver.this.myGroupList.size(); i2++) {
                            if (j == ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.myGroupList.get(i2)).getUserId() && StudentVideoPluginDriver.this.mPluginView != null) {
                                StudentVideoPluginDriver.this.mPluginView.studentOnline(i2 + 1);
                            }
                        }
                    }
                    if (i == 0) {
                        for (int i3 = 0; i3 < StudentVideoPluginDriver.this.myGroupList.size(); i3++) {
                            if (j == ((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.myGroupList.get(i3)).getUserId() && StudentVideoPluginDriver.this.mPluginView != null) {
                                StudentVideoPluginDriver.this.mPluginView.studentOffline(i3 + 1);
                            }
                        }
                    }
                }
            }
        });
    }

    private void initView() {
        FrameLayout.LayoutParams newLp = LiveAreaContext.get().getMsgLp().newLp();
        if (!PadUtils.isPad(Utils.getApp())) {
            if (!this.isAuditor) {
                this.mPluginView = new StudentVideoPluginViewPhone(this.mContext);
            } else {
                this.mPluginView = new AuditorPluginViewPhone(this.mContext);
            }
            newLp.height = (newLp.width * 3) / 4;
        } else if (this.isAuditor) {
            this.mPluginView = new AuditorPluginViewPad(this.mContext);
            newLp.height = SizeUtils.dp2px(192.0f);
        } else if (this.isSmallClass) {
            this.mPluginView = new StudentVideoPluginViewPadSmallClassView(this.mContext);
            newLp.height -= SizeUtils.dp2px(65.0f);
            newLp.topMargin += SizeUtils.dp2px(65.0f);
            newLp.bottomMargin = 0;
            if (BarUtils.isNavBarVisible((Activity) this.mContext)) {
                newLp.bottomMargin = BarUtils.getNavBarHeight();
            }
        } else {
            this.mPluginView = new StudentVideoPluginViewPad(this.mContext);
            newLp.height = SizeUtils.dp2px(192.0f);
        }
        this.mPluginView.driver = this;
        this.mPluginView.mUid = Long.valueOf(this.mUid);
        this.mPluginView.classType = this.mClassType;
        this.mPluginView.setUserCoins(String.valueOf(this.mUserInfoProxy.getGoldNum()));
        this.mLiveRoomProvider.addView(this, this.mPluginView, this.mPluginConfData.getViewLevel("StudentViedeo"), newLp);
        LiveAreaContext.get().layoutObserver.observe(this, new StudentVideoPluginDriver$$ExternalSyntheticLambda1(this));
    }

    public /* synthetic */ void lambda$initView$1$StudentVideoPluginDriver(LiveAreaContext liveAreaContext) {
        AbstractStudentVideoPluginView<StudentVideoPluginDriver> abstractStudentVideoPluginView = this.mPluginView;
        if (abstractStudentVideoPluginView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) abstractStudentVideoPluginView.getLayoutParams();
            LiveAreaLayoutParams msgLp = liveAreaContext.getMsgLp();
            if (PadUtils.isPad(Utils.getApp())) {
                msgLp.mergeLp(layoutParams);
                if (this.isSmallClass) {
                    layoutParams.height -= SizeUtils.dp2px(65.0f);
                    layoutParams.topMargin += SizeUtils.dp2px(65.0f);
                    layoutParams.bottomMargin = 0;
                    if (BarUtils.isNavBarVisible((Activity) this.mContext)) {
                        layoutParams.bottomMargin = BarUtils.getNavBarHeight();
                    }
                } else {
                    layoutParams.height = SizeUtils.dp2px(192.0f);
                }
            } else {
                msgLp.mergeLp(layoutParams);
                layoutParams.height = (layoutParams.width * 3) / 4;
            }
            this.mPluginView.setLayoutParams(layoutParams);
        }
    }

    private boolean getLookOthers() {
        if (!this.isParentAuditor) {
            return true;
        }
        ParentAuditCloudData parentAuditParam = HwCloudControlHelper.get().getParentAuditParam();
        if (parentAuditParam == null || parentAuditParam.getLookOther() == null || !parentAuditParam.getLookOther().equals("1")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void initData() {
        boolean z = this.isParentAuditor;
        Call<HiResponse<StudentVideoBean>> studentVideoUid = ((StudentVideoApi) Api.create(StudentVideoApi.class)).getStudentVideoUid(ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/classroom/student/groupMember", new StudentVideoUidBody(this.planId, this.classId, this.tutorId, isHasPermission() ? 1 : 2, z ? 1 : 0));
        AnonymousClass20 r1 = new OmyCallback<HiResponse<StudentVideoBean>>(new IError() {
            public void onFail(int i, String str) {
                if (!StudentVideoPluginDriver.this.isWhile) {
                    StudentVideoPluginDriver.this.handler.postDelayed(StudentVideoPluginDriver.this.runnable, 30000);
                }
            }

            public void onError(int i, String str) {
                if (!StudentVideoPluginDriver.this.isWhile) {
                    StudentVideoPluginDriver.this.handler.postDelayed(StudentVideoPluginDriver.this.runnable, 30000);
                }
            }
        }) {
            public void onSuccess(HiResponse<StudentVideoBean> hiResponse) {
                StudentVideoBean data;
                if (StudentVideoPluginDriver.this.mIsLookOther && hiResponse.successful() && !StudentVideoPluginDriver.this.isDistory && (data = hiResponse.getData()) != null) {
                    List unused = StudentVideoPluginDriver.this.myGroupList = data.getList();
                    if (StudentVideoPluginDriver.this.myGroupList != null) {
                        int size = StudentVideoPluginDriver.this.myGroupList.size();
                        int i = 0;
                        while (i < size) {
                            int i2 = i + 1;
                            StudentVideoPluginDriver.this.showStudentVideo(((StudentVideoBean.ListBean) StudentVideoPluginDriver.this.myGroupList.get(i)).getUserId(), i2);
                            StudentVideoPluginDriver studentVideoPluginDriver = StudentVideoPluginDriver.this;
                            studentVideoPluginDriver.showStudentInfo((StudentVideoBean.ListBean) studentVideoPluginDriver.myGroupList.get(i), i2);
                            StudentVideoPluginDriver studentVideoPluginDriver2 = StudentVideoPluginDriver.this;
                            studentVideoPluginDriver2.showExamMask(studentVideoPluginDriver2.mNormalState);
                            i = i2;
                        }
                    }
                    StudentVideoPluginDriver studentVideoPluginDriver3 = StudentVideoPluginDriver.this;
                    int i3 = 1;
                    if (studentVideoPluginDriver3.myGroupList != null) {
                        i3 = 1 + StudentVideoPluginDriver.this.myGroupList.size();
                    }
                    studentVideoPluginDriver3.track_show_groupvideo(i3);
                    if (data.isFull()) {
                        StudentVideoPluginDriver.this.handler.removeCallbacksAndMessages((Object) null);
                    } else if (!StudentVideoPluginDriver.this.isWhile) {
                        StudentVideoPluginDriver.this.handler.postDelayed(StudentVideoPluginDriver.this.runnable, 30000);
                    }
                }
            }
        };
        if (!(studentVideoUid instanceof Call)) {
            studentVideoUid.enqueue(r1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) studentVideoUid, r1);
        }
    }

    private void initSmallClassStudents() {
        boolean z = this.isParentAuditor;
        Call<HiResponse<List<StudentVideoBean.ListBean>>> smallClassStudentList = ((StudentVideoApi) Api.create(StudentVideoApi.class)).getSmallClassStudentList(ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/classroom/student/classStudentList", new StudentListBody(this.planId, this.classId, z ? 1 : 0));
        AnonymousClass22 r1 = new OmyCallback<HiResponse<List<StudentVideoBean.ListBean>>>(new IError() {
            public void onError(int i, String str) {
            }

            public void onFail(int i, String str) {
            }
        }) {
            public void onSuccess(HiResponse<List<StudentVideoBean.ListBean>> hiResponse) {
                if (StudentVideoPluginDriver.this.mIsLookOther && hiResponse.successful() && !StudentVideoPluginDriver.this.isDistory) {
                    List data = hiResponse.getData();
                    if (data != null && data.size() > 0) {
                        for (int i = 0; i < data.size(); i++) {
                            StudentVideoPluginDriver.this.mSmallClassMap.put(Long.valueOf(((StudentVideoBean.ListBean) data.get(i)).getUserId()), (StudentVideoBean.ListBean) data.get(i));
                        }
                    }
                    for (int i2 = 0; i2 < StudentVideoPluginDriver.this.mJoinStudentList.size(); i2++) {
                        StudentVideoPluginDriver studentVideoPluginDriver = StudentVideoPluginDriver.this;
                        StudentVideoBean.ListBean unused = studentVideoPluginDriver.currentStudent = (StudentVideoBean.ListBean) studentVideoPluginDriver.mSmallClassMap.get(StudentVideoPluginDriver.this.mJoinStudentList.get(i2));
                        if (StudentVideoPluginDriver.this.currentStudent != null && !StudentVideoPluginDriver.this.mSmallClassVideoList.contains(StudentVideoPluginDriver.this.currentStudent)) {
                            StudentVideoPluginDriver.this.mSmallClassVideoList.add(StudentVideoPluginDriver.this.mSmallClassVideoList.size(), StudentVideoPluginDriver.this.currentStudent);
                            if (StudentVideoPluginDriver.this.mPluginView != null) {
                                StudentVideoPluginDriver.this.mPluginView.updateSmallClassVideoList(StudentVideoPluginDriver.this.mSmallClassVideoList);
                            }
                            StudentVideoPluginDriver studentVideoPluginDriver2 = StudentVideoPluginDriver.this;
                            studentVideoPluginDriver2.syncStudentView(studentVideoPluginDriver2.mSmallClassVideoList.size() - 1);
                            StudentVideoPluginDriver.this.pushStudentsStream();
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
        if (!PadUtils.isPad(Utils.getApp()) || !this.isSmallClass) {
            if (isHasPermission()) {
                this.mySelf.setCameraPerm(1);
                showStudentVideo(this.mUid, 0);
                XesLogTag xesLogTag = TAG;
                XesLog.i(xesLogTag, "showMyShelf，有权限，直接显示");
                AbstractStudentVideoPluginView<StudentVideoPluginDriver> abstractStudentVideoPluginView = this.mPluginView;
                if (abstractStudentVideoPluginView != null) {
                    abstractStudentVideoPluginView.setTurnState1(true);
                    this.mPluginView.studentOnline(0);
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("有摄像头权限", "显示");
                    XesLog.ut(xesLogTag.get(), jsonObject);
                }
            } else {
                this.mySelf.setCameraPerm(0);
                XesLogTag xesLogTag2 = TAG;
                XesLog.i(xesLogTag2, "showMyShelf，无权限，不显示");
                AbstractStudentVideoPluginView<StudentVideoPluginDriver> abstractStudentVideoPluginView2 = this.mPluginView;
                if (abstractStudentVideoPluginView2 != null) {
                    abstractStudentVideoPluginView2.setTurnState1(false);
                    this.mPluginView.showNoPermissionView(0);
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("无摄像头权限", "隐藏");
                    XesLog.ut(xesLogTag2.get(), jsonObject2);
                }
            }
            showStudentInfo(this.mySelf, 0);
            return;
        }
        if (isHasPermission()) {
            XesLog.i(TAG, "showMyShelf Pad小班，有权限");
            this.mySelf.setCameraPerm(1);
        } else {
            XesLog.i(TAG, "showMyShelf Pad小班，无权限");
            this.mySelf.setCameraPerm(0);
        }
        syncStudentView(0);
        pushStudentsStream();
    }

    public StudentVideoBean.ListBean addMySelf() {
        StudentVideoBean.ListBean listBean = new StudentVideoBean.ListBean();
        listBean.setNickName(this.mUserInfoProxy.getNickName());
        listBean.setAvatar(this.mUserInfoProxy.getAvatar());
        listBean.setLevel(this.mUserInfoProxy.getLevel());
        listBean.setUserId(this.mUid);
        if (isHasPermission()) {
            listBean.setCameraPerm(1);
        } else {
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
    public void showStudentVideo(long j, int i) {
        if (this.mRtcEngine != null) {
            SurfaceView surfaceView = this.mSurfaceViewMap.get(Long.valueOf(j));
            if (surfaceView == null) {
                surfaceView = this.mRtcEngine.createRendererView();
                if (surfaceView != null) {
                    surfaceView.setZOrderOnTop(true);
                    surfaceView.setZOrderMediaOverlay(true);
                    this.mSurfaceViewMap.put(Long.valueOf(j), surfaceView);
                }
            } else if (j != this.mUid) {
                return;
            }
            setUpVideo(j);
            AbstractStudentVideoPluginView<StudentVideoPluginDriver> abstractStudentVideoPluginView = this.mPluginView;
            if (abstractStudentVideoPluginView != null) {
                abstractStudentVideoPluginView.addRenderView(surfaceView, i);
            }
        }
    }

    public void setUpVideo(long j) {
        if (j == -1) {
            j = this.mUid;
        }
        SurfaceView surfaceView = this.mSurfaceViewMap.get(Long.valueOf(j));
        if (j == this.mUid) {
            this.mRtcEngine.setupLocalVideo(surfaceView);
            return;
        }
        this.mRtcEngine.setupRemoteVideo(surfaceView, j);
        this.mRtcEngine.muteRemoteVideo(j, false);
    }

    /* access modifiers changed from: private */
    public void showStudentInfo(StudentVideoBean.ListBean listBean, int i) {
        AbstractStudentVideoPluginView<StudentVideoPluginDriver> abstractStudentVideoPluginView = this.mPluginView;
        if (abstractStudentVideoPluginView != null) {
            abstractStudentVideoPluginView.showStudentInfo(listBean, i);
        }
    }

    /* access modifiers changed from: private */
    public void showExamMask(boolean z) {
        if (!this.isAuditor && !this.isSmallClass && PadUtils.isPad(Utils.getApp()) && this.myGroupList != null) {
            int i = 0;
            while (i < this.myGroupList.size()) {
                i++;
                showExamMask(z, i);
            }
        }
    }

    private void showExamMask(boolean z, int i) {
        AbstractStudentVideoPluginView<StudentVideoPluginDriver> abstractStudentVideoPluginView = this.mPluginView;
        if (abstractStudentVideoPluginView != null) {
            abstractStudentVideoPluginView.showExamMask(z, i);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void updateStudentsViewList(int i) {
        int i2 = this.mCurrentPage;
        int i3 = (i2 - 1) * 6;
        int i4 = ((i2 - 1) * 6) + 5;
        int size = this.mSmallClassVideoList.size() - 1;
        if (size >= 0 && i >= i3 && i <= i4 && this.mPluginView != null) {
            while (i3 <= i4) {
                if (i3 <= size) {
                    StudentVideoBean.ListBean listBean = this.mSmallClassVideoList.get(i3);
                    SurfaceView studentSurfaceView = getStudentSurfaceView(listBean.getUserId(), false);
                    if (studentSurfaceView != null) {
                        this.mPluginView.addRenderView(studentSurfaceView, i3 % 6, listBean);
                    } else {
                        this.mPluginView.addRenderView((SurfaceView) null, i3 % 6, (StudentVideoBean.ListBean) null);
                    }
                } else {
                    this.mPluginView.addRenderView((SurfaceView) null, i3 % 6, (StudentVideoBean.ListBean) null);
                }
                i3++;
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void syncStudentView(int i) {
        syncStudentView(i, false);
    }

    /* access modifiers changed from: private */
    public synchronized void syncStudentView(int i, boolean z) {
        int i2 = this.mCurrentPage;
        int i3 = (i2 - 1) * 6;
        int i4 = ((i2 - 1) * 6) + 5;
        int size = this.mSmallClassVideoList.size() - 1;
        if (size >= 0 && i >= i3 && i <= i4 && this.mPluginView != null) {
            while (i3 <= i4) {
                if (i3 <= size && i == i3) {
                    StudentVideoBean.ListBean listBean = this.mSmallClassVideoList.get(i3);
                    SurfaceView studentSurfaceView = getStudentSurfaceView(listBean.getUserId(), z);
                    if (studentSurfaceView != null) {
                        this.mPluginView.addRenderView(studentSurfaceView, i3 % 6, listBean);
                    }
                }
                i3++;
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void syncStudentLeaveView() {
        updateStudentsViewList((this.mCurrentPage - 1) * 6);
    }

    /* access modifiers changed from: private */
    public synchronized void pushStudentsStream() {
        RTCEngine rTCEngine;
        int i = this.mCurrentPage;
        int i2 = ((i - 1) * 6) + 5;
        int size = this.mSmallClassVideoList.size() - 1;
        if (size > 0) {
            if (i2 > size) {
                i2 = size;
            }
            for (int i3 = (i - 1) * 6; i3 <= i2; i3++) {
                StudentVideoBean.ListBean listBean = this.mSmallClassVideoList.get(i3);
                if (!(listBean.getUserId() == this.mUid || (rTCEngine = this.mRtcEngine) == null)) {
                    rTCEngine.muteRemoteVideo(listBean.getUserId(), false);
                }
            }
        } else {
            RTCEngine rTCEngine2 = this.mRtcEngine;
            if (rTCEngine2 != null) {
                rTCEngine2.setDefaultMuteAllRemoteVideoStreams(true);
            }
        }
    }

    public void closeSmallClassStreams() {
        if (this.mSmallClassVideoList != null && this.mSmallClassVideoList.size() > 1) {
            for (int i = 1; i < this.mSmallClassVideoList.size(); i++) {
                RTCEngine rTCEngine = this.mRtcEngine;
                if (rTCEngine != null) {
                    rTCEngine.muteRemoteVideo(this.mSmallClassVideoList.get(i).getUserId(), true);
                }
            }
        }
    }

    public void setCurrentPage(int i, int i2) {
        this.mCurrentPage = i;
        this.mMaxPage = i2;
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngine.setDefaultMuteAllRemoteVideoStreams(true);
        }
        updateStudentsViewList((this.mCurrentPage - 1) * 6);
        pushStudentsStream();
    }

    public void updatesetCurrentPage(int i, int i2) {
        this.mCurrentPage = i;
        this.mMaxPage = i2;
    }

    public void updateSmallClassStudent(StudentVideoBean.ListBean listBean) {
        int indexOf;
        if (listBean != null && this.mSmallClassVideoList.contains(listBean) && (indexOf = this.mSmallClassVideoList.indexOf(listBean)) > -1) {
            syncStudentView(indexOf);
        }
    }

    /* access modifiers changed from: private */
    public synchronized boolean isCurrentPageStudent(int i) {
        int i2 = this.mCurrentPage;
        int i3 = (i2 - 1) * 6;
        int i4 = ((i2 - 1) * 6) + 5;
        int size = this.mSmallClassVideoList.size() - 1;
        if (size >= 0 && i >= i3 && i <= i4 && this.mPluginView != null) {
            while (i3 <= i4) {
                if (i3 <= size && i == i3) {
                    return true;
                }
                i3++;
            }
        }
        return false;
    }

    public void updateMySelfMic(StudentVideoBean.ListBean listBean) {
        if (listBean != null && this.mSmallClassVideoList.contains(listBean)) {
            int i = 1;
            if (listBean.isOpenMic()) {
                this.isOpenMic = 1;
            } else {
                this.isOpenMic = 2;
            }
            PluginEventData pluginEventData = new PluginEventData(StudentVideoPluginDriver.class, DataBusKey.USER_MUTE_MIC_KEY, this.isOpenMic + "");
            if (this.isMuteStudentVideo) {
                i = 2;
            }
            enableLocalAudio(listBean.isOpenMic());
            PluginEventBus.onEvent(DataBusKey.USER_MUTE_MIC_KEY, pluginEventData);
            InteractLogReport.uploadRtcStatusLog(this.classId, this.planId, this.isOpenMic, i);
        }
    }

    public void applyMicPermission() {
        new RxPermissions(this.mContext).request(new String[]{"android.permission.RECORD_AUDIO"}).subscribe(new Consumer<Boolean>() {
            public void accept(Boolean bool) {
                if (bool.booleanValue()) {
                    StudentVideoPluginDriver.this.syncStudentView(0);
                }
            }
        });
    }

    private SurfaceView getStudentSurfaceView(long j, boolean z) {
        if (this.mRtcEngine == null) {
            return null;
        }
        SurfaceView surfaceView = this.mSurfaceViewMap.get(Long.valueOf(j));
        if (surfaceView == null) {
            surfaceView = this.mRtcEngine.createRendererView();
            if (surfaceView != null) {
                surfaceView.setZOrderOnTop(true);
                surfaceView.setZOrderMediaOverlay(true);
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

    public boolean isHasPermission() {
        return PermissionUtils.isGranted("android.permission.CAMERA");
    }

    public boolean isHasMicPermission() {
        return PermissionUtils.isGranted("android.permission.RECORD_AUDIO");
    }

    public void addPermissonWindow() {
        PermissCameraView permissCameraView = new PermissCameraView(this.mContext);
        this.cameraView = permissCameraView;
        permissCameraView.setDriver(this);
        this.mLiveRoomProvider.addView(this, this.cameraView, this.mPluginConfData.getViewLevel("StudentViedeo"), LiveAreaContext.get().getPptLp().newLp());
        LiveAreaContext.get().layoutObserver.observe(this, new StudentVideoPluginDriver$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ void lambda$addPermissonWindow$2$StudentVideoPluginDriver(LiveAreaContext liveAreaContext) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cameraView.getLayoutParams();
        liveAreaContext.getPptLp().mergeLp(layoutParams);
        this.cameraView.setLayoutParams(layoutParams);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.tal.app.thinkacademy.live.business.studentvideo.PermissCameraView, android.view.View] */
    public void removePermissView() {
        if (this.cameraView != null) {
            this.mLiveRoomProvider.removeView(this.cameraView);
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.tal.app.thinkacademy.live.business.studentvideo.PermissCameraView, android.view.View] */
    public void settingView() {
        if (this.cameraView != null) {
            this.mLiveRoomProvider.removeView(this.cameraView);
            PermissionUtils.launchAppDetailsSettings();
        }
    }

    public void setMuteStudentVideo(boolean z) {
        PluginEventData pluginEventData;
        Class<StudentVideoPluginDriver> cls = StudentVideoPluginDriver.class;
        this.isMuteStudentVideo = z;
        if (z) {
            InteractLogReport.uploadRtcStatusLog(this.classId, this.planId, this.isOpenMic, 2);
            pluginEventData = new PluginEventData(cls, DataBusKey.USER_MUTE_VIDEO_KEY, "2");
        } else {
            InteractLogReport.uploadRtcStatusLog(this.classId, this.planId, this.isOpenMic, 1);
            pluginEventData = new PluginEventData(cls, DataBusKey.USER_MUTE_VIDEO_KEY, "1");
        }
        PluginEventBus.onEvent(DataBusKey.USER_MUTE_VIDEO_KEY, pluginEventData);
    }

    public void enableLocalVideo(boolean z) {
        if (this.mRtcEngine == null) {
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "enableLocalVideo 本人摄像头管理失败，引擎为null，是否关闭=" + z);
            return;
        }
        XesLogTag xesLogTag2 = TAG;
        XesLog.i(xesLogTag2, "enableLocalVideo 本人摄像头管理，是否关闭=" + z);
        if (!z) {
            RtcViewModel rtcViewModel = this.mRtcViewModel;
            if (rtcViewModel != null) {
                rtcViewModel.setMLocalVideoEnable(false);
            } else {
                XesLog.i(xesLogTag2, "enableLocalVideo false mRtcViewModel 为null");
            }
            this.mRtcEngine.enableLocalVideo(false);
            this.mRtcEngine.muteLocalVideo(true);
            HWEventTracking.get().ostaRtcVidioChange("mute");
        } else if (this.isAuditor) {
            XesLog.i(xesLogTag2, "旁听课，不允许打开视频推流");
        } else {
            RtcViewModel rtcViewModel2 = this.mRtcViewModel;
            if (rtcViewModel2 != null) {
                rtcViewModel2.setMLocalVideoEnable(true);
            } else {
                XesLog.i(xesLogTag2, "enableLocalVideo true mRtcViewModel 为null");
            }
            this.mRtcEngine.enableLocalVideo(true);
            this.mRtcEngine.muteLocalVideo(false);
            HWEventTracking.get().ostaRtcVidioChange("unmute");
        }
    }

    public void enableLocalAudio(boolean z) {
        if (this.mRtcEngine == null) {
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "enableLocalAudio 本人麦克风管理失败，引擎为null，是否关闭=" + z);
            return;
        }
        XesLogTag xesLogTag2 = TAG;
        XesLog.i(xesLogTag2, "enableLocalAudio 本人麦克风管理，是否关闭=" + z);
        if (z) {
            RtcViewModel rtcViewModel = this.mRtcViewModel;
            if (rtcViewModel != null) {
                rtcViewModel.setMLocalAudioEnable(false);
            }
            this.mRtcEngine.enableLocalAudio(true);
            this.mRtcEngine.muteLocalAudio(false);
            HWEventTracking.get().ostaRtcAudioChange("unmute");
            return;
        }
        RtcViewModel rtcViewModel2 = this.mRtcViewModel;
        if (rtcViewModel2 != null) {
            rtcViewModel2.setMLocalAudioEnable(false);
        }
        this.mRtcEngine.enableLocalAudio(false);
        this.mRtcEngine.muteLocalAudio(true);
        HWEventTracking.get().ostaRtcAudioChange("mute");
    }

    /* access modifiers changed from: private */
    public void videoCallOn() {
        if (this.mRtcEngine != null && this.mPluginView != null) {
            if (!PadUtils.isPad(Utils.getApp()) || !this.isSmallClass) {
                this.mPluginView.studentOffline(0);
                return;
            }
            this.mSmallClassVideoList.get(0).setDisableTheVideo(true);
            syncStudentView(0);
        }
    }

    /* access modifiers changed from: private */
    public void videoCallOff() {
        if (this.mRtcEngine != null && this.mPluginView != null) {
            if (this.isTakePhotoState) {
                enableLocalVideo(false);
                videoCallOn();
                return;
            }
            if (this.isMuteStudentVideo) {
                enableLocalVideo(false);
            } else {
                enableLocalVideo(true);
            }
            if (!PadUtils.isPad(Utils.getApp()) || !this.isSmallClass) {
                this.mPluginView.studentOnline(0);
                setUpVideo(this.mUid);
                return;
            }
            this.mSmallClassVideoList.get(0).setDisableTheVideo(false);
            RTCEngine rTCEngine = this.mRtcEngine;
            if (rTCEngine != null) {
                rTCEngine.setupLocalVideo(getStudentSurfaceView(this.mUid, false));
            }
            syncStudentView(0);
        }
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
        PluginEventBus.unregister(DataBusKey.UPDATE_COINS, this.observerUserCoins);
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
        PluginEventBus.unregister(DataBusKey.GROUP_VIDEO_CALL_STATE, this.observerGroupVideoCallState);
        PluginEventBus.unregister(DataBusKey.GROUP_VIDEO_CALL_STUDENT_GET_MIC, this.observerGrouoVideoCallGetMic);
        PluginEventBus.unregister(DataBusKey.USER_MUTE_BIG_CLASS_GROUP_VIDEO_KEY, this.mObserverBigClassGroupVideoCamera);
        this.handler.removeCallbacksAndMessages((Object) null);
        this.cameraView = null;
        AbstractStudentVideoPluginView<StudentVideoPluginDriver> abstractStudentVideoPluginView = this.mPluginView;
        if (abstractStudentVideoPluginView != null) {
            abstractStudentVideoPluginView.onDestroy();
            this.mPluginView = null;
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
}
