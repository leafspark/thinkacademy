package com.tal.app.thinkacademy.live.business.liveplay;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.eaydu.omni.RTCEngine;
import com.eaydu.omni.listener.RTCConnectionStateType;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.player.rtcplayer.IRTCMediaVideoProcess;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayEventListener;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayPrePlayEventListener;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayerEngineEventListener;
import com.tal.app.thinkacademy.lib.player.rtcplayer.entity.RtcVideoData;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.ImageUtils;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.util.PathUtils;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.liveplay.bean.PcClassMsgBean;
import com.tal.app.thinkacademy.live.business.liveplay.bean.TeacherOnStageMsg;
import com.tal.app.thinkacademy.live.business.liveplay.bean.TeacherStatusInfo;
import com.tal.app.thinkacademy.live.business.liveplay.liveplayer.LivePlayController;
import com.tal.app.thinkacademy.live.business.liveplay.liveplayer.MuteView;
import com.tal.app.thinkacademy.live.business.liveplay.liveplayer.MuteViewSmallPad;
import com.tal.app.thinkacademy.live.business.liveplay.liveplayer.MuteViewSmallPhone;
import com.tal.app.thinkacademy.live.business.liveplay.loadingcontroller.LivePlayLoadingView;
import com.tal.app.thinkacademy.live.business.liveplay.loadingcontroller.LivePlayLoadingViewSmallPad;
import com.tal.app.thinkacademy.live.business.liveplay.loadingcontroller.TeacherOnlineListen;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteNoticeCode;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfo;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.RtcConfig;
import com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.core.utils.LiveTrack;
import com.tal.app.thinkacademy.live.util.InteractLogReport;
import com.tal.app.thinkacademy.live.util.VideoFrameToRgbaUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(desc = "直播播放插件", ircType = {"mode", "classmode"}, launchType = "enter", moduleId = "-101")
@ViewLevels({@ViewLevel(level = 100, name = "video"), @ViewLevel(level = 4, name = "loading"), @ViewLevel(level = 100, name = "mute")})
public class LivePlayPluginDriver extends BaseLivePluginDriver implements RtcPlayEventListener, RtcPlayPrePlayEventListener, RtcPlayerEngineEventListener, Observer<PluginEventData> {
    public static final int MODE_CLASS_ID = 1;
    public static final int MODE_TRAINING_AFTER_ID = 2;
    public static final int MODE_TRAINING_BEFORE_ID = 0;
    /* access modifiers changed from: private */
    public static final XesLogTag TAG = Tag.TEACHER_VIDEO;
    public static final int WHAT_MESSAGE_UPDATE_MIC = 100;
    boolean isFirstVideoFrame = true;
    /* access modifiers changed from: private */
    public Context mContext;
    private CourseInfoProxy mCourseInfoProxy;
    private String mCurrentMode;
    /* access modifiers changed from: private */
    public long mCurrentVideoUid;
    private SurfaceView mCurrentView;
    private boolean mFirst = false;
    Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            super.handleMessage(message);
            if (message.what == 100) {
                int intValue = ((Integer) message.obj).intValue();
                if (LivePlayPluginDriver.this.mMuteView != null) {
                    LivePlayPluginDriver.this.mMuteView.updateMic(intValue);
                }
            }
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    };
    /* access modifiers changed from: private */
    public TeacherStatusInfo mIpadTeacherStatusInfo = new TeacherStatusInfo();
    private boolean mIsAuditor = false;
    private boolean mIsExquisite = false;
    private boolean mIsMyselfTeacherPrivate = true;
    private boolean mIsNeedMuteTeacherAudio = false;
    /* access modifiers changed from: private */
    public boolean mIsPcTeacherModel = false;
    /* access modifiers changed from: private */
    public boolean mIsRealSmallClass = false;
    private boolean mIsTeacherOnState = false;
    /* access modifiers changed from: private */
    public LivePlayLoadingView mLoadingView;
    /* access modifiers changed from: private */
    public MuteView mMuteView;
    private boolean mMuted;
    /* access modifiers changed from: private */
    public LivePlayController mPLayerCtr;
    /* access modifiers changed from: private */
    public TeacherStatusInfo mPcTeacherStatusInfo = new TeacherStatusInfo();
    /* access modifiers changed from: private */
    public long mPcTeacherUid = -1;
    private PlanInfoProxy mPlanInfo;
    private RtcConfig mRtcConfig;
    private long mRtcStatCount = -1;
    private RtcViewModel mRtcViewModel = null;
    private long mTeacherAudioUid = -1;
    private TeacherInfo mTeacherInfo;
    private TeacherOnStageMsg mTeacherOnStageMsg = new TeacherOnStageMsg();

    private void addLayoutChangeListener() {
    }

    public void dispatchConnectionState(RTCConnectionStateType rTCConnectionStateType, String str, String str2) {
    }

    public void onOnceLastMileQuality(int i, String str) {
    }

    public LivePlayPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        long j = -1;
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        this.mRtcConfig = iLiveRoomProvider.getDataStorage().getEnterConfig().getRtcConfig();
        this.mCourseInfoProxy = iLiveRoomProvider.getDataStorage().getCourseInfo();
        this.mTeacherInfo = iLiveRoomProvider.getDataStorage().getTeacherInfo();
        this.mPlanInfo = iLiveRoomProvider.getDataStorage().getPlanInfo();
        this.mIsExquisite = "2".equals(iLiveRoomProvider.getClassType());
        LiveAreaCompat.CourseRate courseRate = iLiveRoomProvider.getDataStorage().getRoomData().getCourseRate();
        this.mIsRealSmallClass = this.mIsExquisite;
        initAudition();
        PluginEventBus.register(this, "video_shot", this);
        if (!this.mIsRealSmallClass || !PadUtils.isPad(Utils.getApp())) {
            this.mLoadingView = new LivePlayLoadingView(this.mContext);
        } else {
            this.mLoadingView = new LivePlayLoadingViewSmallPad(this.mContext, courseRate);
        }
        this.mLoadingView.setLayoutParams();
        LivePlayController livePlayController = new LivePlayController(this.mContext, this.mIsAuditor);
        this.mPLayerCtr = livePlayController;
        livePlayController.setSmallClass(this.mIsRealSmallClass);
        try {
            j = Long.parseLong(this.mRtcConfig.getTutorUid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.mPcTeacherUid = Long.parseLong(this.mRtcConfig.getTeacherUid());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mPLayerCtr.setPcTeacherUid(this.mPcTeacherUid);
        this.mPLayerCtr.setTutorUid(j);
        this.mPLayerCtr.setPlayEventListener(this);
        this.mPLayerCtr.setRtcPlayerEngineEventListener(this);
        this.mPLayerCtr.setPrePlayEventListener(this);
        addLayoutChangeListener();
        addPlayView();
        addLoadingView();
        addMuteView();
        this.mLoadingView.setTeacherOnlineListen(new TeacherOnlineListen() {
            public void teacherOnLine(boolean z) {
                LivePlayPluginDriver.this.mMuteView.setTeacherOnLine(z);
            }

            public void videoOnLine(boolean z) {
                if (LivePlayPluginDriver.this.mMuteView != null) {
                    LivePlayPluginDriver.this.mMuteView.showNoTeacher(!z);
                }
            }
        });
        start();
        PluginEventBus.register(this, DataBusKey.TEACHER_CAME_UP_STATE, this);
        PluginEventBus.register(this, DataBusKey.TEACHER_DRIVER_PRIVATE_CHAT, this);
        this.mRtcViewModel = AbilityPack.get().getViewModel(RtcViewModel.class);
    }

    private void initAudition() {
        if (this.mLiveRoomProvider != null && this.mLiveRoomProvider.getDataStorage() != null && this.mLiveRoomProvider.getDataStorage().getCourseInfo() != null && this.mLiveRoomProvider.getDataStorage().getCourseInfo().getIsAudition() == CourseInfo.ROLE_AUDITION) {
            this.mIsAuditor = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void start() {
        /*
            r10 = this;
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r0 = r10.mLiveRoomProvider
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r0 = r0.getDataStorage()
            com.tal.app.thinkacademy.live.core.live.http.bean.LiveStatus r0 = r0.getLiveStatus()
            int r0 = r0.getStreamMode()
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0033
            r2 = 1
            if (r0 == r2) goto L_0x001c
            r2 = 2
            if (r0 == r2) goto L_0x0033
            r5 = r1
            r6 = r5
            r7 = r6
            goto L_0x004c
        L_0x001c:
            com.tal.app.thinkacademy.live.core.live.http.bean.RtcConfig r0 = r10.mRtcConfig
            java.lang.String r1 = r0.getToken()
            com.tal.app.thinkacademy.live.core.live.http.bean.RtcConfig r0 = r10.mRtcConfig
            java.lang.String r0 = r0.getTeacherVideoUid()
            com.tal.app.thinkacademy.live.core.live.http.bean.RtcConfig r2 = r10.mRtcConfig
            java.lang.String r2 = r2.getTeacherAudioUid()
            java.lang.String r3 = "in-class"
            r10.mCurrentMode = r3
            goto L_0x0049
        L_0x0033:
            com.tal.app.thinkacademy.live.core.live.http.bean.RtcConfig r0 = r10.mRtcConfig
            java.lang.String r1 = r0.getTutorToken()
            com.tal.app.thinkacademy.live.core.live.http.bean.RtcConfig r0 = r10.mRtcConfig
            java.lang.String r0 = r0.getTutorUid()
            com.tal.app.thinkacademy.live.core.live.http.bean.RtcConfig r2 = r10.mRtcConfig
            java.lang.String r2 = r2.getTutorUid()
            java.lang.String r3 = "in-training"
            r10.mCurrentMode = r3
        L_0x0049:
            r6 = r0
            r5 = r1
            r7 = r2
        L_0x004c:
            boolean r0 = com.tal.app.thinkacademy.lib.util.StringUtils.isEmpty(r5)
            if (r0 != 0) goto L_0x006b
            r0 = -1
            long r2 = com.tal.app.thinkacademy.lib.util.ParseUtils.tryParseLong(r6, r0)
            r10.mCurrentVideoUid = r2
            long r0 = com.tal.app.thinkacademy.lib.util.ParseUtils.tryParseLong(r7, r0)
            r10.mTeacherAudioUid = r0
            com.tal.app.thinkacademy.live.business.liveplay.liveplayer.LivePlayController r4 = r10.mPLayerCtr
            com.tal.app.thinkacademy.live.core.live.http.bean.RtcConfig r0 = r10.mRtcConfig
            java.lang.String r8 = r0.classToken
            boolean r9 = r10.mIsExquisite
            r4.prePlay(r5, r6, r7, r8, r9)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.liveplay.LivePlayPluginDriver.start():void");
    }

    private void addLoadingView() {
        FrameLayout.LayoutParams layoutParams;
        if (!this.mIsRealSmallClass || !PadUtils.isPad(Utils.getApp())) {
            layoutParams = LiveAreaContext.get().getVisibleLp().newLp();
            if (PadUtils.isPad(Utils.getApp())) {
                layoutParams.height -= SizeUtils.dp2px(61.0f);
            }
        } else {
            layoutParams = LiveAreaContext.get().getPptLp().newLp();
        }
        this.mLiveRoomProvider.addView(this, this.mLoadingView, this.mPluginConfData.getViewLevel("loading"), layoutParams);
        LiveAreaContext.get().layoutObserver.observe(this, new LivePlayPluginDriver$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ void lambda$addLoadingView$0$LivePlayPluginDriver(LiveAreaContext liveAreaContext) {
        LivePlayLoadingView livePlayLoadingView = this.mLoadingView;
        if (livePlayLoadingView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) livePlayLoadingView.getLayoutParams();
            if (!this.mIsRealSmallClass || !PadUtils.isPad(Utils.getApp())) {
                liveAreaContext.getVisibleLp().mergeLp(layoutParams);
                if (PadUtils.isPad(Utils.getApp())) {
                    layoutParams.height -= SizeUtils.dp2px(61.0f);
                }
            } else {
                liveAreaContext.getPptLp().mergeLp(layoutParams);
            }
            this.mLoadingView.setLayoutParams(layoutParams);
        }
    }

    private void addPlayView() {
        LiveAreaLayoutParams headLp = LiveAreaContext.get().getHeadLp();
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "回显区域位置信息：" + headLp.toString());
        FrameLayout.LayoutParams newLp = headLp.newLp();
        if (this.mIsRealSmallClass) {
            if (PadUtils.isPad(Utils.getApp())) {
                newLp.width = ((newLp.height * 4) / 3) - (newLp.height / 76);
                newLp.height -= newLp.height / 76;
            } else {
                newLp.height /= 2;
            }
        }
        XesLog.i(xesLogTag, "老师回显区域位置信息：[" + newLp.leftMargin + ", " + newLp.topMargin + " - " + newLp.width + ", " + newLp.height + "]");
        this.mLiveRoomProvider.addView(this, this.mPLayerCtr.getPlayRootView(), this.mPluginConfData.getViewLevel("video"), newLp);
        LiveAreaContext.get().layoutObserver.observe(this, new Observer<LiveAreaContext>() {
            public void onChanged(LiveAreaContext liveAreaContext) {
                if (LivePlayPluginDriver.this.mPLayerCtr.getPlayRootView() != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) LivePlayPluginDriver.this.mPLayerCtr.getPlayRootView().getLayoutParams();
                    LiveAreaLayoutParams headLp = liveAreaContext.getHeadLp();
                    headLp.mergeLp(layoutParams);
                    XesLog.i(LivePlayPluginDriver.TAG, "重置回显区域位置信息：" + headLp.toString());
                    if (LivePlayPluginDriver.this.mIsRealSmallClass) {
                        if (PadUtils.isPad(Utils.getApp())) {
                            layoutParams.width = ((layoutParams.height * 4) / 3) - (layoutParams.height / 76);
                            layoutParams.height -= layoutParams.height / 76;
                        } else {
                            layoutParams.height /= 2;
                        }
                    }
                    XesLog.i(LivePlayPluginDriver.TAG, "布局变化，重置老师回显区域位置信息：[" + layoutParams.leftMargin + ", " + layoutParams.topMargin + " - " + layoutParams.width + ", " + layoutParams.height + "]");
                    LivePlayPluginDriver.this.mPLayerCtr.getPlayRootView().setLayoutParams(layoutParams);
                }
            }
        });
    }

    private void addMuteView() {
        TeacherInfo teacherInfo;
        FrameLayout.LayoutParams newLp = LiveAreaContext.get().getHeadLp().newLp();
        if (!this.mIsRealSmallClass) {
            this.mMuteView = new MuteView(this.mContext);
        } else if (PadUtils.isPad(Utils.getApp())) {
            this.mMuteView = new MuteViewSmallPad(this.mContext);
            newLp.width = ((newLp.height * 4) / 3) - (newLp.height / 76);
            newLp.height -= newLp.height / 76;
        } else {
            this.mMuteView = new MuteViewSmallPhone(this.mContext);
            newLp.height /= 2;
        }
        this.mLiveRoomProvider.addView(this, this.mMuteView, this.mPluginConfData.getViewLevel("mute"), newLp);
        LiveAreaContext.get().layoutObserver.observe(this, new LivePlayPluginDriver$$ExternalSyntheticLambda1(this));
        if (this.mMuteView != null && (teacherInfo = this.mTeacherInfo) != null) {
            this.mTeacherOnStageMsg.setTeacherName(teacherInfo.getNickName());
            this.mMuteView.showName(this.mTeacherInfo.getNickName());
            this.mMuteView.showTeacherAvatar(this.mTeacherInfo.getAvatar());
            if (this.mMuteView != null) {
                XesLog.i(TAG, "mMuteView not null");
            }
        }
    }

    public /* synthetic */ void lambda$addMuteView$1$LivePlayPluginDriver(LiveAreaContext liveAreaContext) {
        MuteView muteView = this.mMuteView;
        if (muteView != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) muteView.getLayoutParams();
            liveAreaContext.getHeadLp().mergeLp(layoutParams);
            if (this.mIsRealSmallClass) {
                if (PadUtils.isPad(Utils.getApp())) {
                    layoutParams.width = ((layoutParams.height * 4) / 3) - (layoutParams.height / 76);
                    layoutParams.height -= layoutParams.height / 76;
                } else {
                    layoutParams.height /= 2;
                }
            }
            this.mMuteView.setLayoutParams(layoutParams);
        }
    }

    public void onDestroy() {
        ViewGroup viewGroup;
        XesLog.i(TAG, "onDestory");
        try {
            SurfaceView surfaceView = this.mCurrentView;
            if (!(surfaceView == null || (viewGroup = (ViewGroup) surfaceView.getParent()) == null)) {
                viewGroup.removeView(this.mCurrentView);
            }
        } catch (Exception unused) {
            XesLog.i(TAG, "删除surfaceView 父视图失败，onDestory");
        }
        this.mPLayerCtr.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onLifecycleDestroy(LifecycleOwner lifecycleOwner) {
        LivePlayPluginDriver.super.onLifecycleDestroy(lifecycleOwner);
        XesLog.i(TAG, "onLifecycleDestroy");
        this.mTeacherOnStageMsg.setSurfaceView((SurfaceView) null);
        PluginEventBus.onEvent(DataBusKey.TEACHER_CAME_UP_GET_INFO, new PluginEventData(LivePlayPluginDriver.class, DataBusKey.TEACHER_CAME_UP_GET_INFO, "", this.mTeacherOnStageMsg));
        this.mPLayerCtr.onDestroy();
        PluginEventBus.unregister("video_shot", this);
        PluginEventBus.unregister(DataBusKey.TEACHER_CAME_UP_STATE, this);
        PluginEventBus.unregister(DataBusKey.TEACHER_DRIVER_PRIVATE_CHAT, this);
    }

    private void pc_teacher_class_message(String str) {
        try {
            PcClassMsgBean pcClassMsgBean = (PcClassMsgBean) GsonUtil.getInstance().fromJson(str, PcClassMsgBean.class);
            if (pcClassMsgBean == null) {
                return;
            }
            if (pcClassMsgBean.getClassmode() != null) {
                if ("onclass".equals(pcClassMsgBean.getClassmode().getAction())) {
                    "pc_teacher".equals(pcClassMsgBean.getClassmode().getClient());
                }
            }
        } catch (Exception e) {
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "pc_teacher_class_message error = " + e.toString());
        }
    }

    /* access modifiers changed from: private */
    public void pcTeacherEnter() {
        if (this.mIsRealSmallClass) {
            if (this.mIsPcTeacherModel) {
                syncPcStatusInfo();
                return;
            }
            this.mIsPcTeacherModel = true;
            long j = this.mPcTeacherUid;
            this.mTeacherAudioUid = j;
            this.mCurrentVideoUid = j;
            LivePlayController livePlayController = this.mPLayerCtr;
            if (livePlayController != null) {
                SurfaceView surfaceView = this.mCurrentView;
                if (surfaceView != null) {
                    livePlayController.removeView(surfaceView);
                }
                SurfaceView teacherSurfaceView = this.mPLayerCtr.getTeacherSurfaceView();
                this.mCurrentView = teacherSurfaceView;
                if (teacherSurfaceView != null) {
                    teacherSurfaceView.setZOrderMediaOverlay(true);
                    if (!this.mIsTeacherOnState) {
                        this.mPLayerCtr.addView(this.mCurrentView, new FrameLayout.LayoutParams(-1, -1));
                    }
                }
                this.mPLayerCtr.switchPcTeacherModel(this.mCurrentView);
                this.mPcTeacherStatusInfo.setOnLine(true);
                XesLog.s(TAG, "pc老师进入房间了");
                syncPcStatusInfo();
                checkIsNeedMuteTeacherAudio();
            }
        }
    }

    /* access modifiers changed from: private */
    public void switchToIpadTeacher() {
        LivePlayController livePlayController = this.mPLayerCtr;
        if (livePlayController != null) {
            livePlayController.switchIpadTeacherModel();
        }
        this.mIsPcTeacherModel = false;
        this.mCurrentVideoUid = ParseUtils.tryParseLong(this.mRtcConfig.getTeacherVideoUid(), -1);
        this.mTeacherAudioUid = ParseUtils.tryParseLong(this.mRtcConfig.getTeacherAudioUid(), -1);
    }

    public void onMessage(String str, String str2) {
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "ircTypeKey = " + str + " message = " + str2 + " currentMode : " + this.mCurrentMode);
        if ("mode".equals(str)) {
            try {
                String optString = new JSONObject(str2).optString("mode", "");
                if (!optString.equals(this.mCurrentMode)) {
                    if (VoteNoticeCode.MODE_CLASS.equals(optString)) {
                        this.mPLayerCtr.changeMode(this.mRtcConfig.getToken(), this.mRtcConfig.getTeacherVideoUid(), this.mRtcConfig.getTeacherAudioUid(), this.mRtcConfig.classToken, this.mIsExquisite);
                    } else {
                        this.mPLayerCtr.changeMode(this.mRtcConfig.getTutorToken(), this.mRtcConfig.getTutorUid(), this.mRtcConfig.getTutorUid(), this.mRtcConfig.classToken, this.mIsExquisite);
                    }
                    this.mCurrentMode = optString;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if ("classmode".equals(str)) {
            pc_teacher_class_message(str2);
        }
    }

    public void onRenderViewCreated(SurfaceView surfaceView) {
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "onRenderViewCreated");
        if (this.mIsPcTeacherModel) {
            XesLog.i(xesLogTag, "onRenderViewCreated is is PcTeacherModel");
            return;
        }
        SurfaceView surfaceView2 = this.mCurrentView;
        if (surfaceView2 != null) {
            this.mPLayerCtr.removeView(surfaceView2);
        }
        this.mCurrentView = surfaceView;
        surfaceView.setZOrderMediaOverlay(true);
        if (!this.mIsTeacherOnState) {
            this.mPLayerCtr.addView(this.mCurrentView, new FrameLayout.LayoutParams(-1, -1));
        }
        this.mPLayerCtr.startPlay();
    }

    public void onInitChannelError() {
        XesLog.i(TAG, "onInitChannelError");
        this.mLoadingView.showNoTeacher(true);
        this.mIpadTeacherStatusInfo.setOpenCamera(false);
        syncIpadTeacherStateInfo();
    }

    public void onVideoPlaySuceess() {
        XesLog.i(TAG, "onVideoPlaySuceess");
    }

    public void onPlayFaild() {
        XesLog.i(TAG, "onPlayFaild");
        LivePlayController livePlayController = this.mPLayerCtr;
        if (livePlayController != null) {
            livePlayController.pausePlayer();
        }
        this.mLoadingView.showNoTeacher(true);
        this.mIpadTeacherStatusInfo.setOpenCamera(false);
        syncIpadTeacherStateInfo();
    }

    public void onAudioTeacherJointRoom() {
        if (!this.mIsPcTeacherModel) {
            XesLogTag xesLogTag = TAG;
            XesLog.s(xesLogTag, "onAudioTeacherJointRoom,ipad老师进入房间");
            if (!this.mPLayerCtr.videoTeacherIsJoined()) {
                this.mLoadingView.showNoTeacher(true);
                this.mLoadingView.showCoursewareState(false, "");
                this.mLoadingView.hideLoading();
                this.mIpadTeacherStatusInfo.setOpenCamera(false);
            } else {
                XesLog.i(xesLogTag, "Video remove state");
                this.mLoadingView.showNoTeacher(false);
                this.mLoadingView.showCoursewareState(false, "");
                this.mLoadingView.setVisibility(8);
                this.mIpadTeacherStatusInfo.setOpenCamera(true);
            }
            this.mIpadTeacherStatusInfo.setOnLine(true);
            syncIpadTeacherStateInfo();
            checkIsNeedMuteTeacherAudio();
        }
    }

    public void onRemotefirstVideoRecvWithUid() {
        if (!this.mIsPcTeacherModel) {
            XesLogTag xesLogTag = TAG;
            XesLog.i(xesLogTag, "收到android推流端，视频第一帧");
            if (!this.mPLayerCtr.audioTeacherIsJoined()) {
                XesLog.i(xesLogTag, "收到android推流端，视频第一帧,ipad教师端未进入！！！");
                this.mLoadingView.showNoTeacher(true);
                this.mIpadTeacherStatusInfo.setOpenCamera(false);
            } else {
                XesLog.i(xesLogTag, "收到android推流端，视频第一帧，ipad教师端已经进入了。。");
                this.mLoadingView.showNoTeacher(false);
                this.mLoadingView.setVisibility(8);
                this.mIpadTeacherStatusInfo.setOpenCamera(true);
            }
            syncIpadTeacherStateInfo();
        }
    }

    public void onPadTeacherleaveRoom() {
        if (!this.mIsPcTeacherModel) {
            XesLog.i(TAG, "ipad教师端离开房间，显示：Your teacher will be here soon");
            this.mLoadingView.showNoTeacher(true);
            this.mLoadingView.showCoursewareState(true, this.mContext.getResources().getString(R.string.no_teacher));
            this.mIpadTeacherStatusInfo.setOnLine(false);
            this.mIpadTeacherStatusInfo.setOpenMic(false);
            this.mIpadTeacherStatusInfo.setOpenCamera(false);
            syncIpadTeacherStateInfo();
        }
    }

    public void onVideoTeacherLeaveRoom() {
        if (this.mIsPcTeacherModel) {
            XesLog.e(TAG, "Android推流端，视频老师离开，但此时是pc老师模式，忽略！！！");
            return;
        }
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "Android推流端，视频老师离开");
        this.mLoadingView.showNoTeacher(true);
        this.mLoadingView.hideLoading();
        if (!this.mPLayerCtr.audioTeacherIsJoined()) {
            XesLog.i(xesLogTag, "Android推流端，视频老师离开。此时ipad教师端也不在线，显示：your teacher will be here soon");
            this.mLoadingView.showCoursewareState(true, this.mContext.getResources().getString(R.string.no_teacher));
        } else {
            XesLog.i(xesLogTag, "Android推流端，视频老师离开。此时ipad教师端在线");
        }
        this.mIpadTeacherStatusInfo.setOpenCamera(false);
        syncIpadTeacherStateInfo();
    }

    public void onRtcConnected() {
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "onRtcConnected");
        if (!this.mIsPcTeacherModel) {
            this.mLoadingView.hideLoading();
            if (!this.mPLayerCtr.audioTeacherIsJoined()) {
                XesLog.i(xesLogTag, "audioTeacherIsJoined false");
                this.mLoadingView.showCoursewareState(true, this.mContext.getResources().getString(R.string.no_teacher));
                this.mLoadingView.showNoTeacher(true);
            } else if (!this.mPLayerCtr.videoTeacherIsJoined()) {
                this.mLoadingView.showNoTeacher(true);
            }
        }
    }

    public void onConnectionFaild() {
        XesLog.i(TAG, "onConnectionFaild");
    }

    public void onNeterror() {
        XesLog.i(TAG, "onNeterror");
        if (!this.mIsPcTeacherModel && this.mPLayerCtr.audioTeacherIsJoined()) {
            this.mLoadingView.showBufferLoading(true);
        }
    }

    public void onChanged(PluginEventData pluginEventData) {
        if (pluginEventData == null) {
            XesLog.i(TAG, "onChanged pluginEventData is null");
        } else if ("video_shot_operation".equals(pluginEventData.getOperation())) {
            this.isFirstVideoFrame = true;
            boolean z = !this.mIsPcTeacherModel ? this.mIpadTeacherStatusInfo.isOpenCamera() : this.mPcTeacherStatusInfo.isOpenCamera();
            Tag tag = Tag.SCREEN_SHOT;
            XesLog.i(tag, "收到老师头像截图，是否为pc=" + this.mIsPcTeacherModel + ",是否可以截图=" + z);
            LivePlayController livePlayController = this.mPLayerCtr;
            if (livePlayController == null || !z) {
                sendEvent((File) null);
            } else {
                livePlayController.addVideoFrameObserver(new IRTCMediaVideoProcess() {
                    public void didCapturedVideoData(RtcVideoData rtcVideoData) {
                    }

                    public void didRenderVideoData(long j, RtcVideoData rtcVideoData) {
                        boolean z = true;
                        if ((!LivePlayPluginDriver.this.mIsPcTeacherModel || j != LivePlayPluginDriver.this.mPcTeacherUid) && !LivePlayPluginDriver.this.mPLayerCtr.isTargeVideoUser(Long.valueOf(j))) {
                            z = false;
                        }
                        if (z && LivePlayPluginDriver.this.isFirstVideoFrame) {
                            LivePlayPluginDriver.this.isFirstVideoFrame = false;
                            LivePlayPluginDriver.this.mPLayerCtr.removeVideoFrameObserver(this);
                            LivePlayPluginDriver.this.getVideoBitmap(rtcVideoData);
                        }
                    }
                });
            }
        } else if (DataBusKey.TEACHER_CAME_UP_STATE.equals(pluginEventData.getOperation())) {
            if (pluginEventData.getObject() == null || !(pluginEventData.getObject() instanceof Boolean)) {
                this.mIsMyselfTeacherPrivate = true;
            } else {
                this.mIsMyselfTeacherPrivate = ((Boolean) pluginEventData.getObject()).booleanValue();
            }
            if (EnterRoomMuteData.STATUS_UN_MUTE.equals(pluginEventData.getData())) {
                this.mIsTeacherOnState = true;
                MuteView muteView = this.mMuteView;
                if (muteView != null) {
                    muteView.showOnStage(true, this.mIsMyselfTeacherPrivate);
                }
                SurfaceView surfaceView = this.mCurrentView;
                if (!(surfaceView == null || surfaceView.getParent() == null || this.mCurrentView.getParent() != this.mPLayerCtr.getPlayRootView())) {
                    ((ViewGroup) this.mCurrentView.getParent()).removeView(this.mCurrentView);
                }
                sendTeacherStatus();
                return;
            }
            SurfaceView surfaceView2 = this.mCurrentView;
            if (surfaceView2 != null) {
                if (surfaceView2.getParent() == null) {
                    this.mPLayerCtr.addView(this.mCurrentView, new FrameLayout.LayoutParams(-1, -1));
                } else if (this.mCurrentView.getParent() != this.mPLayerCtr.getPlayRootView()) {
                    ((ViewGroup) this.mCurrentView.getParent()).removeView(this.mCurrentView);
                    this.mPLayerCtr.addView(this.mCurrentView, new FrameLayout.LayoutParams(-1, -1));
                }
            }
            this.mIsTeacherOnState = false;
            MuteView muteView2 = this.mMuteView;
            if (muteView2 != null) {
                muteView2.showOnStage(false, this.mIsMyselfTeacherPrivate);
            }
        } else if (!DataBusKey.TEACHER_DRIVER_PRIVATE_CHAT.equals(pluginEventData.getOperation())) {
        } else {
            if (pluginEventData.getObject() != null && (pluginEventData.getObject() instanceof Boolean) && ((Boolean) pluginEventData.getObject()).booleanValue()) {
                XesLog.i(TAG, "收到关闭教师麦克风的消息，是本人，忽略 ");
            } else if ("1".equals(pluginEventData.getData())) {
                this.mIsNeedMuteTeacherAudio = true;
                MuteView muteView3 = this.mMuteView;
                if (muteView3 != null) {
                    muteView3.showHelpOther(true);
                }
                if (this.mRtcViewModel != null) {
                    XesLog.i(TAG, "收到关闭教师麦克风的消息");
                    this.mRtcViewModel.stopRemoteAudio(this.mTeacherAudioUid);
                    return;
                }
                XesLog.i(TAG, "收到关闭教师麦克风的消息,mRtcViewModel=null");
            } else {
                this.mIsNeedMuteTeacherAudio = false;
                MuteView muteView4 = this.mMuteView;
                if (muteView4 != null) {
                    muteView4.showHelpOther(false);
                }
                if (this.mRtcViewModel != null) {
                    XesLog.i(TAG, "收到打开教师麦克风的消息");
                    this.mRtcViewModel.startRemoteAudio(this.mTeacherAudioUid);
                    return;
                }
                XesLog.i(TAG, "收到打开教师麦克风的消息,mRtcViewModel=null");
            }
        }
    }

    private void checkIsNeedMuteTeacherAudio() {
        if (!this.mIsNeedMuteTeacherAudio) {
            return;
        }
        if (this.mRtcViewModel != null) {
            XesLog.i(TAG, "检测关闭老师麦克风：开始关闭");
            this.mRtcViewModel.stopRemoteAudio(this.mTeacherAudioUid);
            return;
        }
        XesLog.i(TAG, "检测关闭老师麦克风：mRtcViewModel=null");
    }

    /* access modifiers changed from: private */
    public void getVideoBitmap(RtcVideoData rtcVideoData) {
        Bitmap createBitmap = Bitmap.createBitmap(VideoFrameToRgbaUtils.yuvI420toARGB(rtcVideoData.getData(), rtcVideoData.getWidth(), rtcVideoData.getHeight()), rtcVideoData.getWidth(), rtcVideoData.getHeight(), Bitmap.Config.ARGB_8888);
        if (createBitmap == null) {
            sendEvent((File) null);
            return;
        }
        File file = new File(PathUtils.getCachePathExternalFirst(), "xueersi/screenshots");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "xueersi" + System.currentTimeMillis() + ".jpg");
        ImageUtils.save(createBitmap, file2, Bitmap.CompressFormat.JPEG);
        sendEvent(file2);
        createBitmap.recycle();
    }

    private void sendEvent(File file) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (file != null) {
                jSONObject.put("path", file.getAbsolutePath());
            } else {
                jSONObject.put("path", "");
            }
            jSONObject.put("left", LiveAreaContext.get().getHeadLp().left);
            jSONObject.put("top", LiveAreaContext.get().getHeadLp().top);
            jSONObject.put("right", ((LiveAreaContext.get().getHeadLp().height * 4) / 3) + LiveAreaContext.get().getHeadLp().left);
            jSONObject.put("bottom", LiveAreaContext.get().getHeadLp().top + LiveAreaContext.get().getHeadLp().height);
            PluginEventBus.onEvent("video_bitmap", new PluginEventData(LivePlayPluginDriver.class, "video_bitmap_operation", !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void localUserJoindWithUid(long j, String str) {
        if ("Engine".equals(str) && this.mCourseInfoProxy != null) {
            int i = PermissionUtils.isGranted("android.permission.RECORD_AUDIO") ? 1 : 2;
            if (PermissionUtils.isGranted("android.permission.CAMERA")) {
                InteractLogReport.uploadRtcStatusLog(this.mCourseInfoProxy.getClassId(), this.mCourseInfoProxy.getPlanId(), i, 1);
            } else {
                InteractLogReport.uploadRtcStatusLog(this.mCourseInfoProxy.getClassId(), this.mCourseInfoProxy.getPlanId(), i, 2);
            }
        }
    }

    public void remoteUserJoinWitnUid(long j, String str) {
        XesLogTag xesLogTag = TAG;
        XesLog.i(xesLogTag, "remoteUserJoinWitnUid uid = " + j + ",type = " + str);
        if (j == this.mPcTeacherUid) {
            ThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    LivePlayPluginDriver.this.pcTeacherEnter();
                    LivePlayPluginDriver.this.mPcTeacherStatusInfo.setOnLine(true);
                    LivePlayPluginDriver.this.syncPcStatusInfo();
                }
            });
        }
    }

    public void remotefirstVideoRecvWithUid(long j, String str) {
        if (j == this.mPcTeacherUid) {
            ThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (!LivePlayPluginDriver.this.mPcTeacherStatusInfo.isVideoMute()) {
                        LivePlayPluginDriver.this.mPcTeacherStatusInfo.setOpenCamera(true);
                    }
                    LivePlayPluginDriver.this.syncPcStatusInfo();
                }
            });
        }
    }

    public void remotefirstAudioRecvWithUid(long j, String str) {
        if (j == this.mPcTeacherUid) {
            ThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (!LivePlayPluginDriver.this.mPcTeacherStatusInfo.isAudioMute()) {
                        LivePlayPluginDriver.this.mPcTeacherStatusInfo.setOpenMic(true);
                    }
                    LivePlayPluginDriver.this.syncPcStatusInfo();
                }
            });
        }
        if (!this.mIsPcTeacherModel && j == this.mTeacherAudioUid) {
            this.mMuteView.removeMuteView();
            this.mIpadTeacherStatusInfo.setOpenMic(true);
            syncIpadTeacherStateInfo();
        }
    }

    public void didOfflineOfUid(long j, String str) {
        if (j == this.mPcTeacherUid) {
            ThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    LivePlayPluginDriver.this.mPcTeacherStatusInfo.setOnLine(false);
                    LivePlayPluginDriver.this.mPcTeacherStatusInfo.setOpenMic(false);
                    LivePlayPluginDriver.this.mPcTeacherStatusInfo.setOpenCamera(false);
                    LivePlayPluginDriver.this.mPcTeacherStatusInfo.setAudioMute(false);
                    LivePlayPluginDriver.this.mPcTeacherStatusInfo.setVideoMute(false);
                    LivePlayPluginDriver.this.syncPcStatusInfo();
                    if (LivePlayPluginDriver.this.mIsPcTeacherModel) {
                        LivePlayPluginDriver.this.switchToIpadTeacher();
                    }
                }
            });
        }
    }

    public void didAudioMuted(long j, final boolean z, String str) {
        if (j == this.mPcTeacherUid) {
            ThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    LivePlayPluginDriver.this.mPcTeacherStatusInfo.setOpenMic(!z);
                    LivePlayPluginDriver.this.mPcTeacherStatusInfo.setAudioMute(z);
                    LivePlayPluginDriver.this.syncPcStatusInfo();
                }
            });
        }
        if (!this.mIsPcTeacherModel) {
            String teacherAudioUid = this.mRtcConfig.getTeacherAudioUid();
            if (TextUtils.equals(teacherAudioUid, j + "")) {
                if (z) {
                    this.mIpadTeacherStatusInfo.setOpenMic(false);
                    this.mMuteView.addMuteView();
                } else {
                    this.mIpadTeacherStatusInfo.setOpenMic(true);
                    this.mMuteView.removeMuteView();
                }
                syncIpadTeacherStateInfo();
            }
        }
    }

    public void didVideoMuted(long j, final boolean z, String str) {
        if (j == this.mPcTeacherUid) {
            ThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    LivePlayPluginDriver.this.mPcTeacherStatusInfo.setOpenCamera(!z);
                    LivePlayPluginDriver.this.mPcTeacherStatusInfo.setVideoMute(z);
                    LivePlayPluginDriver.this.syncPcStatusInfo();
                }
            });
        }
        if (!this.mIsPcTeacherModel && j == this.mCurrentVideoUid) {
            ThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (z) {
                        if (LivePlayPluginDriver.this.mPLayerCtr.audioTeacherIsJoined()) {
                            LivePlayPluginDriver.this.mLoadingView.showNoTeacher(true);
                            LivePlayPluginDriver.this.mLoadingView.showCoursewareState(false, "");
                            LivePlayPluginDriver.this.mLoadingView.hideLoading();
                        } else {
                            LivePlayPluginDriver.this.mLoadingView.showNoTeacher(true);
                            LivePlayPluginDriver.this.mLoadingView.showCoursewareState(true, LivePlayPluginDriver.this.mContext.getResources().getString(R.string.no_teacher));
                        }
                        LivePlayPluginDriver.this.mIpadTeacherStatusInfo.setOpenCamera(false);
                    } else if (!LivePlayPluginDriver.this.mPLayerCtr.audioTeacherIsJoined()) {
                        XesLog.i(LivePlayPluginDriver.TAG, "audioTeacherIsJoined false");
                        LivePlayPluginDriver.this.mLoadingView.showNoTeacher(true);
                        LivePlayPluginDriver.this.mIpadTeacherStatusInfo.setOpenCamera(false);
                    } else {
                        XesLog.i(LivePlayPluginDriver.TAG, "Video remove state");
                        LivePlayPluginDriver.this.mLoadingView.showNoTeacher(false);
                        LivePlayPluginDriver.this.mLoadingView.setVisibility(8);
                        LivePlayPluginDriver.this.mIpadTeacherStatusInfo.setOpenCamera(true);
                    }
                    LivePlayPluginDriver.this.syncIpadTeacherStateInfo();
                }
            });
        }
    }

    private void sendTeacherStatus() {
        if (this.mIsPcTeacherModel) {
            sendTeacherStatus(this.mPcTeacherStatusInfo);
        } else {
            sendTeacherStatus(this.mIpadTeacherStatusInfo);
        }
    }

    private void sendTeacherStatus(TeacherStatusInfo teacherStatusInfo) {
        if (this.mIsTeacherOnState && teacherStatusInfo != null) {
            this.mTeacherOnStageMsg.setSurfaceView(this.mCurrentView);
            this.mTeacherOnStageMsg.setOnLine(teacherStatusInfo.isOnLine());
            this.mTeacherOnStageMsg.setOpenCamera(teacherStatusInfo.isOpenCamera());
            this.mTeacherOnStageMsg.setOpenMic(teacherStatusInfo.isOpenMic());
            if (this.mCurrentView == null) {
                this.mTeacherOnStageMsg.setOpenCamera(false);
            }
            this.mTeacherOnStageMsg.setTeacherAudioUid(this.mTeacherAudioUid);
            PluginEventBus.onEvent(DataBusKey.TEACHER_CAME_UP_GET_INFO, new PluginEventData(LivePlayPluginDriver.class, DataBusKey.TEACHER_CAME_UP_GET_INFO, "", this.mTeacherOnStageMsg));
            StringBuilder sb = new StringBuilder();
            sb.append(this.mIsPcTeacherModel ? "Pc" : "Ipad");
            sb.append(",isOnLine=");
            sb.append(teacherStatusInfo.isOnLine());
            sb.append(",isOpenMic=");
            sb.append(teacherStatusInfo.isOpenMic());
            sb.append(",isOpenCamera=");
            sb.append(teacherStatusInfo.isOpenCamera());
            sb.append(",TeacherAudioUid=");
            sb.append(this.mTeacherAudioUid);
            XesLog.dt("SendTeacherStatus", sb.toString());
        }
    }

    /* access modifiers changed from: private */
    public void syncIpadTeacherStateInfo() {
        sendTeacherStatus(this.mIpadTeacherStatusInfo);
    }

    /* access modifiers changed from: private */
    public void syncPcStatusInfo() {
        if (this.mIsPcTeacherModel) {
            if (this.mPcTeacherStatusInfo.isOnLine()) {
                if (this.mLoadingView != null) {
                    if (PadUtils.isPad(Utils.getApp())) {
                        this.mLoadingView.showNoTeacher(false);
                        this.mLoadingView.showCoursewareState(false, "");
                        this.mLoadingView.setVisibility(8);
                    } else {
                        if (this.mPcTeacherStatusInfo.isOpenCamera()) {
                            this.mLoadingView.showNoTeacher(false);
                        } else {
                            this.mLoadingView.showNoTeacher(true);
                        }
                        this.mLoadingView.showCoursewareState(false, "");
                        this.mLoadingView.hideLoading();
                    }
                }
                if (this.mPcTeacherStatusInfo.isOpenCamera()) {
                    this.mMuteView.showNoTeacher(false);
                } else {
                    this.mMuteView.showNoTeacher(true);
                }
                if (this.mPcTeacherStatusInfo.isOpenMic()) {
                    this.mMuteView.removeMuteView();
                } else {
                    this.mMuteView.addMuteView();
                }
            } else {
                XesLog.i(TAG, "syncPcStatusInfo pc 离开房间");
                this.mLoadingView.showNoTeacher(true);
                this.mLoadingView.showCoursewareState(true, this.mContext.getResources().getString(R.string.no_teacher));
            }
            sendTeacherStatus(this.mPcTeacherStatusInfo);
        }
    }

    public void onRemoteVideoStateChanged(final long j, final int i, String str) {
        if (j == this.mPcTeacherUid) {
            ThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    int i = i;
                    if (i == 2) {
                        LivePlayPluginDriver.this.mPcTeacherStatusInfo.setOpenCamera(true);
                        LivePlayPluginDriver.this.syncPcStatusInfo();
                    } else if (i == 0) {
                        LivePlayPluginDriver.this.mPcTeacherStatusInfo.setOpenCamera(false);
                        LivePlayPluginDriver.this.syncPcStatusInfo();
                    }
                }
            });
        }
        ThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (!LivePlayPluginDriver.this.mIsPcTeacherModel && LivePlayPluginDriver.this.mIsRealSmallClass && LivePlayPluginDriver.this.mCurrentVideoUid == j && i == 2) {
                    if (!LivePlayPluginDriver.this.mPLayerCtr.audioTeacherIsJoined()) {
                        XesLog.i(LivePlayPluginDriver.TAG, "audioTeacherIsJoined false");
                        LivePlayPluginDriver.this.mLoadingView.showNoTeacher(true);
                        return;
                    }
                    XesLog.i(LivePlayPluginDriver.TAG, "Video remove state");
                    LivePlayPluginDriver.this.mLoadingView.showNoTeacher(false);
                    LivePlayPluginDriver.this.mLoadingView.setVisibility(8);
                }
            }
        });
    }

    public void reportAudioVolumeOfSpeaker(long j, int i) {
        if (this.mIsRealSmallClass && this.mTeacherAudioUid == j) {
            Message obtain = Message.obtain();
            obtain.what = 100;
            obtain.obj = Integer.valueOf(i);
            Handler handler = this.mHandler;
            if (!(handler instanceof Handler)) {
                handler.sendMessage(obtain);
            } else {
                AsynchronousInstrumentation.sendMessage(handler, obtain);
            }
        }
    }

    public void onRtcStats(RTCEngine.ReportRtcStats reportRtcStats) {
        if (reportRtcStats != null && this.mPlanInfo != null) {
            long j = this.mRtcStatCount;
            if (j < 0) {
                XesLogTag xesLogTag = TAG;
                XesLog.i(xesLogTag, "onRtcStats cpuAppUsage = " + reportRtcStats.cpuAppUsage);
                LiveTrack.INSTANCE.reportCpu(reportRtcStats.cpuAppUsage, reportRtcStats.cpuTotalUsage, this.mPlanInfo.getId());
                this.mRtcStatCount = this.mRtcStatCount + 1;
                return;
            }
            long j2 = j + 1;
            this.mRtcStatCount = j2;
            if (j2 >= 30) {
                this.mRtcStatCount = -1;
            }
        }
    }
}
