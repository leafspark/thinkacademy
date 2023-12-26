package com.tal.app.thinkacademy.live.abilitypack.rtc;

import android.content.Context;
import android.view.SurfaceView;
import android.view.TextureView;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.eaydu.omni.RTCEngine;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.common.entity.ParentAuditCloudData;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineProvider;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineProviderUtils;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayer;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayerUtil;
import com.tal.app.thinkacademy.lib.player.rtcplayer.entity.RtcUserState;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.rtc.listenbody.RtcPlayerListenerBody;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.studentvideo.api.StudentVideoApi;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.body.StudentListBody;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityViewModel;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.net.NetWork;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.RtcConfig;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002).\u0018\u0000 k2\u00020\u0001:\u0001kB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020#H\u0002J\b\u0010G\u001a\u0004\u0018\u00010HJ\u000e\u0010I\u001a\u00020E2\u0006\u0010J\u001a\u00020\nJ\u000e\u0010K\u001a\u00020E2\u0006\u0010J\u001a\u00020\nJ\u001e\u0010L\u001a\u00020E2\u0006\u0010M\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\nJ\b\u0010P\u001a\u00020\nH\u0002J\n\u0010Q\u001a\u0004\u0018\u00010'H\u0002J\n\u0010R\u001a\u0004\u0018\u000103H\u0002J\u001a\u0010S\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\"j\n\u0012\u0004\u0012\u00020#\u0018\u0001`$J\u0010\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010F\u001a\u00020#J\u0010\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010F\u001a\u00020#J\b\u0010X\u001a\u00020EH\u0002J\b\u0010Y\u001a\u00020EH\u0002J\b\u0010Z\u001a\u00020EH\u0014J\b\u0010[\u001a\u00020EH\u0002J\u000e\u0010\\\u001a\u00020E2\u0006\u0010]\u001a\u00020WJ\u000e\u0010\\\u001a\u00020E2\u0006\u0010^\u001a\u00020HJ\u0016\u0010_\u001a\u00020E2\u0006\u0010]\u001a\u00020W2\u0006\u0010F\u001a\u00020#J\u0016\u0010_\u001a\u00020E2\u0006\u0010^\u001a\u00020H2\u0006\u0010F\u001a\u00020#J\u000e\u0010`\u001a\u00020E2\u0006\u0010a\u001a\u00020\nJ\u000e\u0010b\u001a\u00020E2\u0006\u0010F\u001a\u00020#J\u000e\u0010c\u001a\u00020E2\u0006\u0010F\u001a\u00020#J\u000e\u0010d\u001a\u00020E2\u0006\u0010F\u001a\u00020#J\u000e\u0010e\u001a\u00020E2\u0006\u0010F\u001a\u00020#J\u0010\u0010f\u001a\u00020\u00062\u0006\u0010g\u001a\u00020\u0006H\u0002J \u0010h\u001a\u00020E2\u0016\u0010i\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0018\u00010jH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001f\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u000e¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u000e¢\u0006\u0004\n\u0002\u0010/R\u000e\u00100\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000205X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\"\u0010?\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\"j\n\u0012\u0004\u0012\u00020#\u0018\u0001`$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mClassId", "", "mContext", "Landroid/content/Context;", "mIsClassListCheckRequesting", "", "mIsLookOther", "mIsParentAudit", "mIsSmallClass", "mLocalAudioEnable", "getMLocalAudioEnable", "()Z", "setMLocalAudioEnable", "(Z)V", "mLocalVideoEnable", "getMLocalVideoEnable", "setMLocalVideoEnable", "mNetWork", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/net/NetWork;", "", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "getMNetWork", "()Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/net/NetWork;", "mNetworkQualityPicId", "getMNetworkQualityPicId", "()I", "setMNetworkQualityPicId", "(I)V", "mNewUidList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mPlanId", "mPlayer", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayer;", "mPlayerEventListener", "com/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel$mPlayerEventListener$1", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel$mPlayerEventListener$1;", "mProvider", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RTCEngineProvider;", "mRTCEngineCallback", "com/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel$mRTCEngineCallback$1", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel$mRTCEngineCallback$1;", "mRtcConfig", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/RtcConfig;", "mRtcEngine", "Lcom/eaydu/omni/RTCEngine;", "mRtcEngineEventObserver", "Lcom/eaydu/omni/RTCEngine$RtcEngineEventObserver;", "getMRtcEngineEventObserver", "()Lcom/eaydu/omni/RTCEngine$RtcEngineEventObserver;", "setMRtcEngineEventObserver", "(Lcom/eaydu/omni/RTCEngine$RtcEngineEventObserver;)V", "mRtcPlayerListener", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody;", "getMRtcPlayerListener", "()Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "mStudentList", "mTeacherAudioUid", "mTeacherPcUid", "mTeacherVideoUid", "mUid", "checkAndRequestData", "", "uid", "createTextureView", "Landroid/view/TextureView;", "enableLocalAudio", "turnOn", "enableLocalVideo", "getAllStudents", "planId", "classId", "isParentAudit", "getLookOthers", "getPlayer", "getRTCEngine", "getRemoteList", "getRemoteState", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/entity/RtcUserState;", "getSurfaceView", "Landroid/view/SurfaceView;", "initGlobalData", "initRtcEngine", "onVmDestroy", "requestCheckStudentUpdate", "setUpLocalVideo", "surfaceView", "textureView", "setUpRemoteVideo", "setVideoBitRate", "isHigh", "startRemoteAudio", "startRemoteVideo", "stopRemoteAudio", "stopRemoteVideo", "syncNetworkParse", "rxQuality", "updateStudentsData", "response", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcViewModel.kt */
public final class RtcViewModel extends AbilityViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.RTC_VIEW_MODEL;
    private static final String TAG_STR = "RtcViewModel";
    private int mClassId;
    private Context mContext;
    /* access modifiers changed from: private */
    public boolean mIsClassListCheckRequesting;
    private boolean mIsLookOther;
    private boolean mIsParentAudit;
    private boolean mIsSmallClass;
    private boolean mLocalAudioEnable;
    private boolean mLocalVideoEnable;
    private final NetWork<List<StudentVideoBean.ListBean>> mNetWork = new NetWork<>();
    private int mNetworkQualityPicId;
    private ArrayList<Long> mNewUidList;
    private int mPlanId;
    private RtcPlayer mPlayer;
    private RtcViewModel$mPlayerEventListener$1 mPlayerEventListener;
    private RTCEngineProvider mProvider;
    private RtcViewModel$mRTCEngineCallback$1 mRTCEngineCallback;
    private RtcConfig mRtcConfig;
    /* access modifiers changed from: private */
    public RTCEngine mRtcEngine;
    private RTCEngine.RtcEngineEventObserver mRtcEngineEventObserver;
    private final ListenerData<RtcPlayerListenerBody> mRtcPlayerListener = new ListenerData<>();
    private ArrayList<Long> mStudentList;
    private long mTeacherAudioUid;
    private long mTeacherPcUid;
    private long mTeacherVideoUid;
    private long mUid;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RtcViewModel(ILiveRoomProvider iLiveRoomProvider) {
        super(iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        RtcConfig rtcConfig = getMLiveRoomProvider().getDataStorage().getEnterConfig().getRtcConfig();
        Intrinsics.checkNotNullExpressionValue(rtcConfig, "mLiveRoomProvider.dataSt…age.enterConfig.rtcConfig");
        this.mRtcConfig = rtcConfig;
        this.mLocalVideoEnable = true;
        this.mLocalAudioEnable = true;
        this.mNetworkQualityPicId = R.drawable.icon_wifi_navigation_good;
        this.mIsLookOther = true;
        this.mTeacherAudioUid = -1;
        this.mTeacherVideoUid = -1;
        this.mTeacherPcUid = -1;
        this.mUid = -1;
        this.mNewUidList = new ArrayList<>();
        this.mRtcEngineEventObserver = new RtcViewModel$mRtcEngineEventObserver$1(this);
        this.mRTCEngineCallback = new RtcViewModel$mRTCEngineCallback$1(this);
        this.mPlayerEventListener = new RtcViewModel$mPlayerEventListener$1(this);
        initGlobalData();
        this.mIsLookOther = getLookOthers();
        this.mLocalAudioEnable = PermissionUtils.isGranted("android.permission.RECORD_AUDIO");
        this.mLocalVideoEnable = PermissionUtils.isGranted("android.permission.CAMERA");
        initRtcEngine();
        XesLog.s(TAG, "RtcViewModel初始化成功");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "TAG_STR", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RtcViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final ListenerData<RtcPlayerListenerBody> getMRtcPlayerListener() {
        return this.mRtcPlayerListener;
    }

    public final NetWork<List<StudentVideoBean.ListBean>> getMNetWork() {
        return this.mNetWork;
    }

    public final boolean getMLocalVideoEnable() {
        return this.mLocalVideoEnable;
    }

    public final void setMLocalVideoEnable(boolean z) {
        this.mLocalVideoEnable = z;
    }

    public final boolean getMLocalAudioEnable() {
        return this.mLocalAudioEnable;
    }

    public final void setMLocalAudioEnable(boolean z) {
        this.mLocalAudioEnable = z;
    }

    public final int getMNetworkQualityPicId() {
        return this.mNetworkQualityPicId;
    }

    public final void setMNetworkQualityPicId(int i) {
        this.mNetworkQualityPicId = i;
    }

    public final RTCEngine.RtcEngineEventObserver getMRtcEngineEventObserver() {
        return this.mRtcEngineEventObserver;
    }

    public final void setMRtcEngineEventObserver(RTCEngine.RtcEngineEventObserver rtcEngineEventObserver) {
        Intrinsics.checkNotNullParameter(rtcEngineEventObserver, "<set-?>");
        this.mRtcEngineEventObserver = rtcEngineEventObserver;
    }

    /* access modifiers changed from: private */
    public final int syncNetworkParse(int i) {
        int i2 = R.drawable.icon_wifi_navigation_good;
        switch (i) {
            case 1:
            case 2:
                return R.drawable.icon_wifi_navigation_good;
            case 3:
                return R.drawable.icon_wifi_navigation_normal;
            case 4:
            case 5:
            case 6:
                return R.drawable.icon_wifi_navigation_weak;
            default:
                return i2;
        }
    }

    private final void initGlobalData() {
        UserInfoProxy userInfo;
        String id;
        EnterConfigProxy enterConfig;
        RtcConfig rtcConfig;
        CourseInfoProxy courseInfo;
        CourseInfoProxy courseInfo2;
        EnterConfigProxy enterConfig2;
        List classStudentList;
        DataStorage dataStorage = getMLiveRoomProvider().getDataStorage();
        if (!(dataStorage == null || (enterConfig2 = dataStorage.getEnterConfig()) == null || (classStudentList = enterConfig2.getClassStudentList()) == null || !(classStudentList instanceof ArrayList))) {
            this.mStudentList = (ArrayList) classStudentList;
        }
        DataStorage dataStorage2 = getMLiveRoomProvider().getDataStorage();
        if (!(dataStorage2 == null || (courseInfo2 = dataStorage2.getCourseInfo()) == null)) {
            this.mIsParentAudit = courseInfo2.getIsParentAuditLocal();
        }
        if (Intrinsics.areEqual("2", getMLiveRoomProvider().getClassType())) {
            this.mIsSmallClass = true;
        }
        DataStorage dataStorage3 = getMLiveRoomProvider().getDataStorage();
        if (!(dataStorage3 == null || (courseInfo = dataStorage3.getCourseInfo()) == null)) {
            this.mPlanId = courseInfo.getPlanId();
            this.mClassId = courseInfo.getClassId();
        }
        DataStorage dataStorage4 = getMLiveRoomProvider().getDataStorage();
        if (!(dataStorage4 == null || (enterConfig = dataStorage4.getEnterConfig()) == null || (rtcConfig = enterConfig.getRtcConfig()) == null)) {
            String teacherAudioUid = rtcConfig.getTeacherAudioUid();
            Intrinsics.checkNotNullExpressionValue(teacherAudioUid, "it.teacherAudioUid");
            this.mTeacherAudioUid = Util.toLongOrDefault(teacherAudioUid, -1);
            String teacherVideoUid = rtcConfig.getTeacherVideoUid();
            Intrinsics.checkNotNullExpressionValue(teacherVideoUid, "it.teacherVideoUid");
            this.mTeacherVideoUid = Util.toLongOrDefault(teacherVideoUid, -1);
            String teacherUid = rtcConfig.getTeacherUid();
            Intrinsics.checkNotNullExpressionValue(teacherUid, "it.teacherUid");
            this.mTeacherPcUid = Util.toLongOrDefault(teacherUid, -1);
        }
        DataStorage dataStorage5 = getMLiveRoomProvider().getDataStorage();
        if (dataStorage5 != null && (userInfo = dataStorage5.getUserInfo()) != null && (id = userInfo.getId()) != null) {
            this.mUid = Util.toLongOrDefault(id, -1);
        }
    }

    private final boolean getLookOthers() {
        String lookOther;
        if (!this.mIsParentAudit) {
            return true;
        }
        ParentAuditCloudData parentAuditParam = HwCloudControlHelper.Companion.get().getParentAuditParam();
        if (parentAuditParam == null || (lookOther = parentAuditParam.getLookOther()) == null || !Intrinsics.areEqual(lookOther, "1")) {
            return false;
        }
        return true;
    }

    private final void initRtcEngine() {
        RtcPlayer rtcPlayer = RtcPlayerUtil.getInstance().get("Live");
        this.mPlayer = rtcPlayer;
        if (rtcPlayer == null) {
            XesLog.i(TAG, "RtcViewModel mPlayer == null");
        }
        RTCEngineProvider rTCEngineProvider = RTCEngineProviderUtils.getInstance().get("Live");
        this.mProvider = rTCEngineProvider;
        if (rTCEngineProvider == null) {
            XesLog.i(TAG, "RtcViewModel provider == null");
        }
        RTCEngineProvider rTCEngineProvider2 = this.mProvider;
        if (rTCEngineProvider2 != null) {
            rTCEngineProvider2.provide((String) null, this.mRTCEngineCallback);
        }
        RTCEngineProvider rTCEngineProvider3 = this.mProvider;
        if (rTCEngineProvider3 != null) {
            rTCEngineProvider3.addEtcEngineEventListener(TAG_STR, this.mPlayerEventListener);
        }
        RtcPlayer rtcPlayer2 = this.mPlayer;
        if (rtcPlayer2 != null) {
            rtcPlayer2.addRtcEngineEventObserver(TAG_STR, this.mRtcEngineEventObserver);
        }
    }

    public final void getAllStudents(int i, int i2, boolean z) {
        Call<HiResponse<List<StudentVideoBean.ListBean>>> smallClassStudentList = ((StudentVideoApi) Api.create(StudentVideoApi.class)).getSmallClassStudentList(Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/classroom/student/classStudentList"), new StudentListBody(i, i2, z ? 1 : 0));
        Callback rtcViewModel$getAllStudents$1 = new RtcViewModel$getAllStudents$1(this, new RtcViewModel$getAllStudents$2(this));
        if (!(smallClassStudentList instanceof Call)) {
            smallClassStudentList.enqueue(rtcViewModel$getAllStudents$1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) smallClassStudentList, rtcViewModel$getAllStudents$1);
        }
    }

    private final void requestCheckStudentUpdate() {
        boolean z = this.mIsParentAudit;
        this.mIsClassListCheckRequesting = true;
        Call<HiResponse<List<StudentVideoBean.ListBean>>> smallClassStudentList = ((StudentVideoApi) Api.create(StudentVideoApi.class)).getSmallClassStudentList(Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/classroom/student/classStudentList"), new StudentListBody(this.mPlanId, this.mClassId, z ? 1 : 0));
        Callback rtcViewModel$requestCheckStudentUpdate$1 = new RtcViewModel$requestCheckStudentUpdate$1(this, new RtcViewModel$requestCheckStudentUpdate$2(this));
        if (!(smallClassStudentList instanceof Call)) {
            smallClassStudentList.enqueue(rtcViewModel$requestCheckStudentUpdate$1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) smallClassStudentList, rtcViewModel$requestCheckStudentUpdate$1);
        }
    }

    /* access modifiers changed from: private */
    public final void checkAndRequestData(long j) {
        if (!this.mIsSmallClass || !this.mIsLookOther) {
            return;
        }
        if (!this.mIsParentAudit || j != this.mUid) {
            ArrayList<Long> arrayList = this.mStudentList;
            if ((arrayList == null || !arrayList.contains(Long.valueOf(j))) && j != this.mTeacherAudioUid && j != this.mTeacherVideoUid && j != this.mTeacherPcUid) {
                if (!this.mNewUidList.contains(Long.valueOf(j))) {
                    this.mNewUidList.add(Long.valueOf(j));
                }
                if (this.mIsClassListCheckRequesting) {
                    XesLog.i(TAG, "RtcViewModel 正在请求新的数据");
                    return;
                }
                XesLog.i(TAG, Intrinsics.stringPlus("RtcViewModel 开始请求新的数据 size = ", Integer.valueOf(this.mNewUidList.size())));
                requestCheckStudentUpdate();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateStudentsData(HiResponse<List<StudentVideoBean.ListBean>> hiResponse) {
        List data;
        if (hiResponse != null && (data = hiResponse.getData()) != null) {
            List arrayList = new ArrayList();
            int size = data.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                if (this.mNewUidList.contains(Long.valueOf(((StudentVideoBean.ListBean) data.get(i)).getUserId()))) {
                    arrayList.add(data.get(i));
                    ArrayList<Long> arrayList2 = this.mStudentList;
                    if (arrayList2 != null) {
                        arrayList2.add(Long.valueOf(((StudentVideoBean.ListBean) data.get(i)).getUserId()));
                    }
                }
                i = i2;
            }
            this.mNewUidList.clear();
            if (arrayList.size() > 0) {
                getMRtcPlayerListener().setStickyData(new RtcPlayerListenerBody.StudentListUpdate(arrayList));
                XesLog.i(TAG, Intrinsics.stringPlus("RtcViewModel 班级内的学生有增加 size=", Integer.valueOf(arrayList.size())));
            }
        }
    }

    /* access modifiers changed from: private */
    public final RtcPlayer getPlayer() {
        RtcPlayer rtcPlayer = this.mPlayer;
        if (!(rtcPlayer != null && rtcPlayer.isRtcInit())) {
            XesLog.i(TAG, "RtcViewModel rtcPlayer 未初始化");
            initRtcEngine();
        }
        RtcPlayer rtcPlayer2 = this.mPlayer;
        if ((rtcPlayer2 == null ? null : rtcPlayer2.getMRtcEngine()) == null) {
            XesLog.i(TAG, "RtcViewModel getPlayer mRtcEngine is null");
        }
        return this.mPlayer;
    }

    private final RTCEngine getRTCEngine() {
        RtcPlayer player = getPlayer();
        if (player == null) {
            return null;
        }
        return player.getMRtcEngine();
    }

    public final void startRemoteVideo(long j) {
        RTCEngine rTCEngine = getRTCEngine();
        if (rTCEngine != null) {
            rTCEngine.muteRemoteVideo(j, false);
        }
    }

    public final void stopRemoteVideo(long j) {
        RTCEngine rTCEngine = getRTCEngine();
        if (rTCEngine != null) {
            rTCEngine.muteRemoteVideo(j, true);
        }
    }

    public final void startRemoteAudio(long j) {
        RTCEngine rTCEngine = getRTCEngine();
        if (rTCEngine != null) {
            rTCEngine.muteRemoteAudio(j, false);
        }
    }

    public final void stopRemoteAudio(long j) {
        RTCEngine rTCEngine = getRTCEngine();
        if (rTCEngine != null) {
            rTCEngine.muteRemoteAudio(j, true);
        }
    }

    public final SurfaceView getSurfaceView(long j) {
        RtcPlayer player = getPlayer();
        if (player == null) {
            return null;
        }
        return player.getRemoteSurfaceView(j);
    }

    public final ArrayList<Long> getRemoteList() {
        RtcPlayer player = getPlayer();
        if (player == null) {
            return null;
        }
        return player.getRemoteUsers();
    }

    public final RtcUserState getRemoteState(long j) {
        RtcPlayer player = getPlayer();
        if (player == null) {
            return null;
        }
        return player.getRemoteState(j);
    }

    public final void setUpRemoteVideo(SurfaceView surfaceView, long j) {
        Intrinsics.checkNotNullParameter(surfaceView, "surfaceView");
        RTCEngine rTCEngine = getRTCEngine();
        if (rTCEngine != null) {
            rTCEngine.setupRemoteVideo(surfaceView, j);
        }
    }

    public final void setUpRemoteVideo(TextureView textureView, long j) {
        Intrinsics.checkNotNullParameter(textureView, "textureView");
        RTCEngine rTCEngine = getRTCEngine();
        if (rTCEngine != null) {
            rTCEngine.setupRemoteVideo(j, textureView);
        }
    }

    public final void setUpLocalVideo(SurfaceView surfaceView) {
        Intrinsics.checkNotNullParameter(surfaceView, "surfaceView");
        RTCEngine rTCEngine = getRTCEngine();
        if (rTCEngine != null) {
            rTCEngine.setupLocalVideo(surfaceView);
        }
    }

    public final void setUpLocalVideo(TextureView textureView) {
        Intrinsics.checkNotNullParameter(textureView, "textureView");
        RTCEngine rTCEngine = getRTCEngine();
        if (rTCEngine != null) {
            rTCEngine.setupLocalVideo(textureView);
        }
    }

    public final TextureView createTextureView() {
        RTCEngine rTCEngine = getRTCEngine();
        if (rTCEngine == null) {
            return null;
        }
        return rTCEngine.createTextureView();
    }

    public final void enableLocalVideo(boolean z) {
        int i;
        Tag tag = TAG;
        XesLog.i(tag, Intrinsics.stringPlus("RtcViewModel 是否打开视频推流： ", Boolean.valueOf(z)));
        RTCEngine rTCEngine = getRTCEngine();
        if (rTCEngine != null) {
            if (z) {
                rTCEngine.enableLocalVideo(true);
                i = rTCEngine.muteLocalVideo(false);
                HWEventTracking.Companion.get().ostaRtcVidioChange("unmute");
            } else {
                rTCEngine.enableLocalVideo(false);
                i = rTCEngine.muteLocalVideo(true);
                HWEventTracking.Companion.get().ostaRtcVidioChange("mute");
            }
            XesLog.i(tag, "RtcViewModel 是否打开视频推流=" + z + ",muteRet=" + i);
            setMLocalVideoEnable(z);
            ThreadUtils.runOnUiThread(new RtcViewModel$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: enableLocalVideo$lambda-10$lambda-9  reason: not valid java name */
    public static final void m142enableLocalVideo$lambda10$lambda9(RtcViewModel rtcViewModel) {
        Intrinsics.checkNotNullParameter(rtcViewModel, "this$0");
        rtcViewModel.mRtcPlayerListener.setStickyData(new RtcPlayerListenerBody.LocalVideoChanged(rtcViewModel.mLocalVideoEnable));
    }

    public final void enableLocalAudio(boolean z) {
        int i;
        Tag tag = TAG;
        XesLog.i(tag, Intrinsics.stringPlus("RtcViewModel 是否打开音频推流： ", Boolean.valueOf(z)));
        RTCEngine rTCEngine = getRTCEngine();
        if (rTCEngine != null) {
            if (z) {
                rTCEngine.enableLocalAudio(true);
                i = rTCEngine.muteLocalAudio(false);
                HWEventTracking.Companion.get().ostaRtcAudioChange("unmute");
            } else {
                rTCEngine.enableLocalAudio(false);
                i = rTCEngine.muteLocalAudio(true);
                HWEventTracking.Companion.get().ostaRtcAudioChange("mute");
            }
            XesLog.i(tag, "RtcViewModel 是否打开音频推流=" + z + ",muteRet=" + i);
            setMLocalAudioEnable(z);
            ThreadUtils.runOnUiThread(new RtcViewModel$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: enableLocalAudio$lambda-12$lambda-11  reason: not valid java name */
    public static final void m141enableLocalAudio$lambda12$lambda11(RtcViewModel rtcViewModel) {
        Intrinsics.checkNotNullParameter(rtcViewModel, "this$0");
        rtcViewModel.mRtcPlayerListener.setStickyData(new RtcPlayerListenerBody.LocalAudioChanged(rtcViewModel.mLocalAudioEnable));
    }

    public final void setVideoBitRate(boolean z) {
        XesLog.i(TAG, Intrinsics.stringPlus("设置视频码率: isHigh=", Boolean.valueOf(z)));
        RtcPlayer player = getPlayer();
        if (player != null) {
            player.setVideoBitrate(z);
        }
    }

    /* access modifiers changed from: protected */
    public void onVmDestroy() {
        XesLog.s(TAG, "RtcViewModel 销毁");
    }
}
