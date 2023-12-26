package com.wushuangtech.api;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.bean.EngineCacheBean;
import com.wushuangtech.bean.InterCorrectUserBean;
import com.wushuangtech.bean.InterCorrectionBean;
import com.wushuangtech.bean.InterCorrectionEnum;
import com.wushuangtech.bean.LogEvent;
import com.wushuangtech.bean.VideoRemoteStreamType;
import com.wushuangtech.bean.VideoStuckStatsBean;
import com.wushuangtech.broadcast.CommonReceiver;
import com.wushuangtech.broadcast.HeadSetReceiver;
import com.wushuangtech.broadcast.OrientationEventListenerImpl;
import com.wushuangtech.broadcast.PhoneListener;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.expansion.api.Constants;
import com.wushuangtech.expansion.bean.AudioVolumeInfo;
import com.wushuangtech.expansion.bean.ChannelMediaRelayConfiguration;
import com.wushuangtech.expansion.bean.LocalAudioStats;
import com.wushuangtech.expansion.bean.LocalVideoStats;
import com.wushuangtech.expansion.bean.RemoteAudioStats;
import com.wushuangtech.expansion.bean.RemoteVideoStats;
import com.wushuangtech.expansion.bean.RtcStats;
import com.wushuangtech.handler.AVStreamPublishHandler;
import com.wushuangtech.handler.ChannelMediaRelayHandler;
import com.wushuangtech.inter.RtcGlobalAVInterface;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.jni.VideoJni;
import com.wushuangtech.jni.response.ChannelJoinResponse;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.GlobalVideoConfig;
import com.wushuangtech.library.JNIResponse;
import com.wushuangtech.library.PviewConferenceRequest;
import com.wushuangtech.library.RtcRequestServerManager;
import com.wushuangtech.library.User;
import com.wushuangtech.library.UserDeviceConfig;
import com.wushuangtech.library.video.VideoStatistical;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.log.ReportLogger;
import com.wushuangtech.log.RtcHeartbeatReporter;
import com.wushuangtech.thread.EngineCallbackThread;
import com.wushuangtech.utils.OmniLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class EnterConfApiImpl extends EnterConfApi {
    private static final String TAG = "EnterConfApi";
    private static EnterConfApiImpl mEnterConfApiImpl = new EnterConfApiImpl();
    private static final String sDefayltChannelKey = "VGhpcyBpcyBhbiBpbnZhbGlkIHRva2Vu77yB";
    private boolean mAudioAllRemoteMuted;
    private HashMap<Long, VideoRemoteStreamType> mCacheRemoteVideoStreamType;
    private Timer mChannelKeyTimer = null;
    private ChannelMediaRelayHandler mChannelMediaRelayHandler;
    /* access modifiers changed from: private */
    public String mChannelName;
    private CommonReceiver mCommonReceiver;
    private String mConnectId = "";
    private final Object mDualStreamTypeLock = new Object();
    private final EngineCacheBean mEngineCacheBean = new EngineCacheBean();
    /* access modifiers changed from: private */
    public EngineCallbackThread mEngineCallbackThread;
    private final HeadSetReceiver mHeadSetReceiver = new HeadSetReceiver();
    private int mHeartbeatTmerTicks;
    private boolean mJoiningChannel;
    private final AtomicBoolean mKickOutRoom = new AtomicBoolean();
    private LocalAsyncTask mLocalAsyncTask;
    private boolean mLocalVideoUpload;
    private final Object mLock = new Object();
    private final Object mLockObject = new Object();
    private OrientationEventListenerImpl mOrientationEventListenerImpl;
    private PhoneListener mPhoneListener;
    /* access modifiers changed from: private */
    public boolean mRefreshToken;
    private boolean mRegistered;
    private RtcRequestServerManager mRequestServerManager;
    private int mRole;
    private String mRtmpUrl;
    private String mSessionId = "";
    private String mToken = "";
    /* access modifiers changed from: private */
    public boolean mTokenExpiredAndExiting;
    /* access modifiers changed from: private */
    public final Object mTokenLock = new Object();
    private long mUid;
    private boolean mVideoAllRemoteMuted;
    private boolean regit_headset_receiver;
    /* access modifiers changed from: private */
    public ReportLogger reportLogger;
    private final PviewConferenceRequest v2ConferenceRequest = new PviewConferenceRequest();

    public void OnRecvCmdMsg(String str, long j, String str2) {
    }

    static {
        Class<EnterConfApi> cls = EnterConfApi.class;
    }

    private EnterConfApiImpl() {
        tryLoadLibrary();
    }

    public static synchronized EnterConfApiImpl getInstance() {
        EnterConfApiImpl enterConfApiImpl;
        synchronized (EnterConfApiImpl.class) {
            enterConfApiImpl = mEnterConfApiImpl;
        }
        return enterConfApiImpl;
    }

    private void tryLoadLibrary() {
        if (!ExternalLoadHelper.isLoaded()) {
            try {
                loadLibrary();
            } catch (Exception unused) {
                loadLibrary();
            }
        }
    }

    private void loadLibrary() {
        System.loadLibrary("AudioDecoder");
        System.loadLibrary("clientcore");
        if (!GlobalConfig.mIsVoiceSDK) {
            System.loadLibrary("yuv_omni");
            System.loadLibrary("codec_omni");
        }
    }

    public void setEngineCallBackThread(EngineCallbackThread engineCallbackThread) {
        this.mEngineCallbackThread = engineCallbackThread;
    }

    public void registerSystemService(boolean z) {
        LocalAsyncTask localAsyncTask = this.mLocalAsyncTask;
        if (localAsyncTask != null) {
            localAsyncTask.cancel(false);
        }
        LocalAsyncTask localAsyncTask2 = new LocalAsyncTask();
        this.mLocalAsyncTask = localAsyncTask2;
        localAsyncTask2.execute(new Object[]{Boolean.valueOf(z)});
    }

    public int getConnectionState() {
        return GlobalConfig.mConnectState;
    }

    public void setServerAddress(String str, int i) {
        GlobalConfig.mServerIP = str;
        GlobalConfig.mServerPort = i;
        if (str != null && !str.isEmpty()) {
            RoomJni.getInstance().setServerAddress(str, i);
        }
    }

    public void setVideoMixerParams(int i, int i2, int i3, int i4, int i5, int i6) {
        RoomJni.getInstance().SetVideoMixerParams(i, i2, i3, i4, i5 == 160602 ? 1 : 0, i6);
    }

    public int setReconnectTimeoutSeconds(int i) {
        if (GlobalHolder.getInstance().isJoinedChannel()) {
            return -4;
        }
        GlobalConfig.mServerTimout = i;
        if (i < 20) {
            i = 20;
        }
        RoomJni.getInstance().SetSignalTimeout(i);
        return 0;
    }

    public int kickUser(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return -5;
        }
        RoomJni.getInstance().RoomKickUser(str, j);
        return 0;
    }

    public int setSei(String str, String str2, String str3, String str4) {
        String str5;
        if (TextUtils.isEmpty(str)) {
            OmniLog.w(OmniLog.RTC_PUBLISH_WATCH, TAG, "Set sei failed! Haven't joined the channel yet!");
            return -5;
        }
        if (TextUtils.isEmpty(str3) || !validateJson(str3)) {
            str5 = "{\"report\":false,\"extContent\":\"\"}";
        } else {
            str5 = "{\"report\":true,\"extContent\":" + str3 + "}";
        }
        OmniLog.i(OmniLog.RTC_PUBLISH_WATCH, TAG, "Set sei success, finally send sei content : " + str2 + " | seiExt : " + str3 + " | extContent : " + str5 + " | streamUrl : " + str4 + " | def streamUrl : " + this.mRtmpUrl);
        if (TextUtils.isEmpty(str4)) {
            str4 = this.mRtmpUrl;
        }
        VideoJni.getInstance().RtmpSetH264Sei(str, str2, str5, str4);
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x012c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean controlUserVideoDevice(java.lang.String r23, long r24, java.lang.String r26, boolean r27) {
        /*
            r22 = this;
            r0 = r23
            r7 = r24
            r1 = r27
            java.lang.String r2 = "Open"
            if (r1 != 0) goto L_0x000c
            java.lang.String r2 = "Close"
        L_0x000c:
            r9 = 0
            if (r0 == 0) goto L_0x027c
            r3 = 0
            int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x0017
            goto L_0x027c
        L_0x0017:
            boolean r3 = android.text.TextUtils.isEmpty(r26)
            if (r3 == 0) goto L_0x0034
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            java.lang.String r2 = "Video device open failed... device's id is zero"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.wushuangtech.utils.OmniLog.pdw(r0, r1)
            return r9
        L_0x0034:
            r10 = r22
            java.lang.Object r11 = r10.mLockObject
            monitor-enter(r11)
            boolean r3 = com.wushuangtech.library.GlobalConfig.mVideoEnabled     // Catch:{ all -> 0x0279 }
            if (r3 != 0) goto L_0x003f
            monitor-exit(r11)     // Catch:{ all -> 0x0279 }
            return r9
        L_0x003f:
            com.wushuangtech.library.GlobalHolder r3 = com.wushuangtech.library.GlobalHolder.getInstance()     // Catch:{ all -> 0x0279 }
            com.wushuangtech.api.RtcDeviceManager r12 = r3.getDeviceManager(r0)     // Catch:{ all -> 0x0279 }
            if (r12 != 0) goto L_0x004b
            monitor-exit(r11)     // Catch:{ all -> 0x0279 }
            return r9
        L_0x004b:
            r3 = r26
            com.wushuangtech.library.UserDeviceConfig r13 = r12.getVideoDeviceByDeviceId(r3)     // Catch:{ all -> 0x0279 }
            if (r13 != 0) goto L_0x006b
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0279 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0279 }
            r1.<init>()     // Catch:{ all -> 0x0279 }
            r1.append(r2)     // Catch:{ all -> 0x0279 }
            java.lang.String r2 = "Video device open failed... UserDeviceConfig is null!"
            r1.append(r2)     // Catch:{ all -> 0x0279 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0279 }
            com.wushuangtech.utils.OmniLog.pdw(r0, r1)     // Catch:{ all -> 0x0279 }
            monitor-exit(r11)     // Catch:{ all -> 0x0279 }
            return r9
        L_0x006b:
            com.wushuangtech.library.GlobalHolder r2 = com.wushuangtech.library.GlobalHolder.getInstance()     // Catch:{ all -> 0x0279 }
            com.wushuangtech.api.RtcUserManager r2 = r2.getUserManager(r0)     // Catch:{ all -> 0x0279 }
            if (r2 != 0) goto L_0x0077
            monitor-exit(r11)     // Catch:{ all -> 0x0279 }
            return r9
        L_0x0077:
            com.wushuangtech.library.User r3 = r2.getUser(r7)     // Catch:{ all -> 0x0279 }
            if (r3 != 0) goto L_0x007f
            monitor-exit(r11)     // Catch:{ all -> 0x0279 }
            return r9
        L_0x007f:
            long r4 = r2.getOwnerId()     // Catch:{ all -> 0x0279 }
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            r14 = 1
            if (r4 == 0) goto L_0x0092
            if (r1 == 0) goto L_0x0092
            boolean r2 = r2.getRemoteVideoMuteStats(r7)     // Catch:{ all -> 0x0279 }
            if (r2 == 0) goto L_0x0092
            monitor-exit(r11)     // Catch:{ all -> 0x0279 }
            return r14
        L_0x0092:
            boolean r2 = com.wushuangtech.library.GlobalConfig.mIsEnableVideoDualStream     // Catch:{ all -> 0x0279 }
            if (r2 == 0) goto L_0x009c
            boolean r2 = r3.isEnableDualVideo()     // Catch:{ all -> 0x0279 }
            if (r2 != 0) goto L_0x00a6
        L_0x009c:
            java.lang.String r2 = TAG     // Catch:{ all -> 0x0279 }
            java.lang.String r3 = "The small steam can't be used... Change to big steam"
            com.wushuangtech.utils.OmniLog.pdw(r2, r3)     // Catch:{ all -> 0x0279 }
            r13.setVideoSteamType(r9)     // Catch:{ all -> 0x0279 }
        L_0x00a6:
            java.lang.String r15 = r13.getDeviceId()     // Catch:{ all -> 0x0279 }
            java.lang.String r6 = r13.getDualDeviceId()     // Catch:{ all -> 0x0279 }
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0279 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0279 }
            r2.<init>()     // Catch:{ all -> 0x0279 }
            java.lang.String r3 = "Check args uid : "
            r2.append(r3)     // Catch:{ all -> 0x0279 }
            r2.append(r7)     // Catch:{ all -> 0x0279 }
            java.lang.String r3 = " | big device : "
            r2.append(r3)     // Catch:{ all -> 0x0279 }
            r2.append(r15)     // Catch:{ all -> 0x0279 }
            java.lang.String r3 = " | small device : "
            r2.append(r3)     // Catch:{ all -> 0x0279 }
            r2.append(r6)     // Catch:{ all -> 0x0279 }
            java.lang.String r3 = " | "
            r2.append(r3)     // Catch:{ all -> 0x0279 }
            int r3 = r13.getVideoSteamType()     // Catch:{ all -> 0x0279 }
            r2.append(r3)     // Catch:{ all -> 0x0279 }
            java.lang.String r3 = " | "
            r2.append(r3)     // Catch:{ all -> 0x0279 }
            r2.append(r1)     // Catch:{ all -> 0x0279 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0279 }
            com.wushuangtech.utils.OmniLog.pdw(r4, r2)     // Catch:{ all -> 0x0279 }
            if (r1 == 0) goto L_0x01ca
            int r1 = r13.getVideoSteamType()     // Catch:{ all -> 0x0279 }
            if (r1 != 0) goto L_0x015d
            boolean r1 = r13.isOpenBigVideo()     // Catch:{ all -> 0x0279 }
            if (r1 == 0) goto L_0x00fd
            java.lang.String r0 = "opt user video device failed! big video is already opend!"
            com.wushuangtech.utils.OmniLog.pdww(r4, r0)     // Catch:{ all -> 0x0279 }
            monitor-exit(r11)     // Catch:{ all -> 0x0279 }
            return r9
        L_0x00fd:
            boolean r1 = r13.isOpenSmallVideo()     // Catch:{ all -> 0x0279 }
            if (r1 == 0) goto L_0x0121
            r13.setIsOpenSmallVideo(r9)     // Catch:{ all -> 0x0279 }
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0279 }
            if (r1 != 0) goto L_0x0121
            java.lang.String r1 = "prepare open big video, close small video first!"
            com.wushuangtech.utils.OmniLog.pdw(r4, r1)     // Catch:{ all -> 0x0279 }
            r2 = 0
            r1 = r22
            r3 = r23
            r16 = r4
            r4 = r24
            r1.videoDeviceControl(r2, r3, r4, r6)     // Catch:{ all -> 0x0279 }
            com.wushuangtech.library.GlobalConfig.testUpdateVideoDeviceOptSize(r9)     // Catch:{ all -> 0x0279 }
            goto L_0x0123
        L_0x0121:
            r16 = r4
        L_0x0123:
            r13.setIsOpenBigVideo(r14)     // Catch:{ all -> 0x0279 }
            boolean r1 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0279 }
            if (r1 != 0) goto L_0x0265
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0279 }
            r13.setDeviceOpenTimestamp(r4)     // Catch:{ all -> 0x0279 }
            r2 = 1
            r1 = r22
            r3 = r23
            r17 = r4
            r4 = r24
            r6 = r15
            r1.videoDeviceControl(r2, r3, r4, r6)     // Catch:{ all -> 0x0279 }
            com.wushuangtech.library.GlobalConfig.testUpdateVideoDeviceOptSize(r14)     // Catch:{ all -> 0x0279 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0279 }
            r0.<init>()     // Catch:{ all -> 0x0279 }
            java.lang.String r1 = "opt user video device success! big video is open! "
            r0.append(r1)     // Catch:{ all -> 0x0279 }
            r1 = r17
            r0.append(r1)     // Catch:{ all -> 0x0279 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0279 }
            r4 = r16
            com.wushuangtech.utils.OmniLog.pdw(r4, r0)     // Catch:{ all -> 0x0279 }
            goto L_0x0265
        L_0x015d:
            boolean r1 = r13.isOpenSmallVideo()     // Catch:{ all -> 0x0279 }
            if (r1 == 0) goto L_0x016a
            java.lang.String r0 = "opt user video device failed! small video is already opend!"
            com.wushuangtech.utils.OmniLog.pdww(r4, r0)     // Catch:{ all -> 0x0279 }
            monitor-exit(r11)     // Catch:{ all -> 0x0279 }
            return r9
        L_0x016a:
            boolean r1 = r13.isOpenBigVideo()     // Catch:{ all -> 0x0279 }
            if (r1 == 0) goto L_0x018b
            r13.setIsOpenBigVideo(r9)     // Catch:{ all -> 0x0279 }
            java.lang.String r1 = "prepare open small video, close big video first!"
            com.wushuangtech.utils.OmniLog.pdw(r4, r1)     // Catch:{ all -> 0x0279 }
            r2 = 0
            r1 = r22
            r3 = r23
            r19 = r4
            r4 = r24
            r26 = r6
            r6 = r15
            r1.videoDeviceControl(r2, r3, r4, r6)     // Catch:{ all -> 0x0279 }
            com.wushuangtech.library.GlobalConfig.testUpdateVideoDeviceOptSize(r9)     // Catch:{ all -> 0x0279 }
            goto L_0x018f
        L_0x018b:
            r19 = r4
            r26 = r6
        L_0x018f:
            r13.setIsOpenSmallVideo(r14)     // Catch:{ all -> 0x0279 }
            boolean r1 = android.text.TextUtils.isEmpty(r26)     // Catch:{ all -> 0x0279 }
            if (r1 != 0) goto L_0x0265
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0279 }
            r13.setDeviceOpenTimestamp(r4)     // Catch:{ all -> 0x0279 }
            r2 = 1
            r1 = r22
            r3 = r23
            r20 = r4
            r4 = r24
            r6 = r26
            r1.videoDeviceControl(r2, r3, r4, r6)     // Catch:{ all -> 0x0279 }
            com.wushuangtech.library.GlobalConfig.testUpdateVideoDeviceOptSize(r14)     // Catch:{ all -> 0x0279 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0279 }
            r0.<init>()     // Catch:{ all -> 0x0279 }
            java.lang.String r1 = "opt user video device success! small video is open! "
            r0.append(r1)     // Catch:{ all -> 0x0279 }
            r1 = r20
            r0.append(r1)     // Catch:{ all -> 0x0279 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0279 }
            r1 = r19
            com.wushuangtech.utils.OmniLog.pdw(r1, r0)     // Catch:{ all -> 0x0279 }
            goto L_0x0265
        L_0x01ca:
            r1 = r4
            r26 = r6
            int r2 = r13.getVideoSteamType()     // Catch:{ all -> 0x0279 }
            if (r2 != 0) goto L_0x021b
            boolean r2 = r13.isOpenBigVideo()     // Catch:{ all -> 0x0279 }
            if (r2 != 0) goto L_0x01ef
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0279 }
            r0.<init>()     // Catch:{ all -> 0x0279 }
            java.lang.String r2 = "Close video device is failed! not opend! "
            r0.append(r2)     // Catch:{ all -> 0x0279 }
            r0.append(r15)     // Catch:{ all -> 0x0279 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0279 }
            com.wushuangtech.utils.OmniLog.pdww(r1, r0)     // Catch:{ all -> 0x0279 }
            monitor-exit(r11)     // Catch:{ all -> 0x0279 }
            return r9
        L_0x01ef:
            r13.setIsOpenBigVideo(r9)     // Catch:{ all -> 0x0279 }
            boolean r2 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0279 }
            if (r2 != 0) goto L_0x0265
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0279 }
            r2.<init>()     // Catch:{ all -> 0x0279 }
            java.lang.String r3 = "Close video device success! "
            r2.append(r3)     // Catch:{ all -> 0x0279 }
            r2.append(r15)     // Catch:{ all -> 0x0279 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0279 }
            com.wushuangtech.utils.OmniLog.pdw(r1, r2)     // Catch:{ all -> 0x0279 }
            r2 = 0
            r1 = r22
            r3 = r23
            r4 = r24
            r6 = r15
            r1.videoDeviceControl(r2, r3, r4, r6)     // Catch:{ all -> 0x0279 }
            com.wushuangtech.library.GlobalConfig.testUpdateVideoDeviceOptSize(r9)     // Catch:{ all -> 0x0279 }
            goto L_0x0265
        L_0x021b:
            boolean r2 = r13.isOpenSmallVideo()     // Catch:{ all -> 0x0279 }
            if (r2 != 0) goto L_0x0239
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0279 }
            r0.<init>()     // Catch:{ all -> 0x0279 }
            java.lang.String r2 = "Close dual video device is failed! not opend! "
            r0.append(r2)     // Catch:{ all -> 0x0279 }
            r6 = r26
            r0.append(r6)     // Catch:{ all -> 0x0279 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0279 }
            com.wushuangtech.utils.OmniLog.pdww(r1, r0)     // Catch:{ all -> 0x0279 }
            monitor-exit(r11)     // Catch:{ all -> 0x0279 }
            return r9
        L_0x0239:
            r6 = r26
            r13.setIsOpenSmallVideo(r9)     // Catch:{ all -> 0x0279 }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0279 }
            if (r2 != 0) goto L_0x0265
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0279 }
            r2.<init>()     // Catch:{ all -> 0x0279 }
            java.lang.String r3 = "Close dual video device is success! "
            r2.append(r3)     // Catch:{ all -> 0x0279 }
            r2.append(r6)     // Catch:{ all -> 0x0279 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0279 }
            com.wushuangtech.utils.OmniLog.pdww(r1, r2)     // Catch:{ all -> 0x0279 }
            r2 = 0
            r1 = r22
            r3 = r23
            r4 = r24
            r1.videoDeviceControl(r2, r3, r4, r6)     // Catch:{ all -> 0x0279 }
            com.wushuangtech.library.GlobalConfig.testUpdateVideoDeviceOptSize(r9)     // Catch:{ all -> 0x0279 }
        L_0x0265:
            boolean r3 = r13.isOpenBigVideo()     // Catch:{ all -> 0x0279 }
            boolean r4 = r13.isOpenSmallVideo()     // Catch:{ all -> 0x0279 }
            long r5 = r13.getDeviceOpenTimestamp()     // Catch:{ all -> 0x0279 }
            r0 = r12
            r1 = r24
            r0.updateDeviceOpenStatus(r1, r3, r4, r5)     // Catch:{ all -> 0x0279 }
            monitor-exit(r11)     // Catch:{ all -> 0x0279 }
            return r14
        L_0x0279:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0279 }
            throw r0
        L_0x027c:
            r10 = r22
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            java.lang.String r2 = "Video device open failed... channel id or user id is zero"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.wushuangtech.utils.OmniLog.pdw(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.EnterConfApiImpl.controlUserVideoDevice(java.lang.String, long, java.lang.String, boolean):boolean");
    }

    public void setAudioLevelReportInterval(int i) {
        if (i <= 0) {
            ExternalAudioModule.getInstance().enableAudioVadIndication(false, false);
        } else {
            ExternalAudioModule.getInstance().enableAudioVadIndication(true, true);
        }
        RoomJni.getInstance().SetAudioLevelReportInterval(i);
    }

    public void setSpeakerphoneOn(boolean z) {
        Context context = GlobalHolder.getInstance().getContext();
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        HeadSetReceiver.setSpeakerphoneOn(z);
        if (audioManager != null) {
            try {
                boolean isHeadsetOn = HeadSetReceiver.isHeadsetOn(context);
                boolean z2 = !isHeadsetOn && z;
                OmniLog.aw_d("EnterConfApiImpl setSpeakerphoneOn", "headsetOn : " + isHeadsetOn + " | speakerphoneOn : " + z);
                audioManager.setSpeakerphoneOn(z2);
                HeadSetReceiver.reportAudioRouteChange(z2);
            } catch (Exception e) {
                OmniLog.aw_e("EnterConfApiImpl setSpeakerphoneOn", "setSpeakerphoneOn failed! exception : " + e.getLocalizedMessage());
            }
        }
    }

    public int setRemoteSubscribeFallbackOption(int i) {
        if (i != 0 && i != 1 && i != 2) {
            return -5;
        }
        RoomJni.getInstance().SetRemoteSubscribeFallbackOption(i);
        return 0;
    }

    public void enableDualVideoStream(boolean z) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.reportVideoDualStream(z);
            }
        }
        GlobalConfig.mIsEnableVideoDualStream = z;
        RoomJni.getInstance().EnableDualVideoStream(z);
    }

    public int sendLyrics(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return -5;
        }
        RoomJni.getInstance().SendLyric(str, str2);
        return 0;
    }

    public int updateRtmpUrl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return -5;
        }
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportUpdateRtmpUrl(str2);
            }
        }
        RoomJni.getInstance().UpdateRtmpUrl(str, str2);
        return 0;
    }

    public void controlLastmileTest(boolean z) {
        if (z) {
            RoomJni.getInstance().StartCheckNet(GlobalConfig.mAppId, UUID.randomUUID().toString());
            return;
        }
        RoomJni.getInstance().StopCheckNet();
    }

    public int setBusinessUserRole(int i) {
        RoomJni.getInstance().SetBusinessUserRole(i);
        return 0;
    }

    public void enableLocalVideo(boolean z) {
        updateHeartbeatReporterVideoStatus((Boolean) null, Boolean.valueOf(z), (Boolean) null);
        VideoJni.getInstance().EnableVideoDev("", z ? 1 : 0);
    }

    public void muteAllRemoteAudio(boolean z) {
        RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.AUDIO_REMOTE_ALL_MUTED, "", Boolean.valueOf(z));
    }

    public void muteAllRemoteVideo(boolean z) {
        RoomJni.getInstance().MuteAllRoomRemoteVideo(z);
    }

    public int setRemoteRenderMode(int i) {
        GlobalHolder.getInstance().sendSyncGlobalMessage(1003, LocalSDKConstants.OPTION_FOR_ALL_STRING, Integer.valueOf(i));
        return 0;
    }

    public int setRemoteRenderMirror(int i) {
        GlobalConfig.mRemoteVideoHorMirrorEnabled = i == 160201;
        GlobalHolder.getInstance().sendSyncGlobalMessage(1014, LocalSDKConstants.OPTION_FOR_ALL_STRING, Integer.valueOf(i));
        return 0;
    }

    public int adjustPlaybackSignalVolume(String str, int i) {
        if (i < 0 || i > 400) {
            return -5;
        }
        CommonEventBean commonEventBean = new CommonEventBean();
        commonEventBean.mEventType = 1;
        commonEventBean.mObjects = new Object[]{str, Double.valueOf(((double) i) / 100.0d)};
        ExternalAudioModule.getInstance().sendAudioModuleEvent(commonEventBean);
        return 0;
    }

    public int adjustUserPlaybackSignalVolume(long j, int i) {
        if (i < 0 || i > 400) {
            return -5;
        }
        CommonEventBean commonEventBean = new CommonEventBean();
        commonEventBean.mEventType = 2;
        commonEventBean.mObjects = new Object[]{Long.valueOf(j), Double.valueOf(((double) i) / 100.0d)};
        ExternalAudioModule.getInstance().sendAudioModuleEvent(commonEventBean);
        return 0;
    }

    public void updateHeartbeatReporterAudioStatus(Boolean bool, Boolean bool2, Boolean bool3) {
        updateHeartbeatReporterAVStatus(bool, bool2, bool3, (Boolean) null, (Boolean) null, (Boolean) null);
    }

    public void updateHeartbeatReporterVideoStatus(Boolean bool, Boolean bool2, Boolean bool3) {
        updateHeartbeatReporterAVStatus((Boolean) null, (Boolean) null, (Boolean) null, bool, bool2, bool3);
    }

    public void handleAppBackgroundStatus(boolean z) {
        if (GlobalConfig.mAppInBackground != z) {
            GlobalConfig.mAppInBackground = z;
            String str = TAG;
            OmniLog.i(str, "App background stats changed: " + z);
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportInBackgroud(z);
            }
            RoomJni.getInstance().SetVideoStuckIgnore(z);
        }
    }

    public void cacheVideoRemoteStreamType(VideoRemoteStreamType videoRemoteStreamType) {
        synchronized (this.mDualStreamTypeLock) {
            if (this.mCacheRemoteVideoStreamType == null) {
                this.mCacheRemoteVideoStreamType = new HashMap<>();
            }
            long j = videoRemoteStreamType.mUid;
            VideoRemoteStreamType videoRemoteStreamType2 = this.mCacheRemoteVideoStreamType.get(Long.valueOf(j));
            if (videoRemoteStreamType2 != null) {
                videoRemoteStreamType2.mStreamType = videoRemoteStreamType.mStreamType;
            } else {
                this.mCacheRemoteVideoStreamType.put(Long.valueOf(j), videoRemoteStreamType);
            }
        }
    }

    public int setImageReportUrl(String str) {
        String str2 = TAG;
        OmniLog.i(str2, "Set image report url = " + str);
        if (TextUtils.isEmpty(str)) {
            return -5;
        }
        RoomJni.getInstance().SetImageReportUrl(str);
        return 0;
    }

    public int setAppExtensionInfo(String str) {
        return RoomJni.getInstance().SetAppExtensionInfo(str);
    }

    private void videoDeviceControl(boolean z, String str, long j, String str2) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.reportVideoOpened(z, str, j, str2);
            }
        }
        if (z) {
            VideoJni.getInstance().VideoOpenDevice(str, j, str2);
        } else {
            VideoJni.getInstance().VideoCloseDevice(str, j, str2);
        }
    }

    private void updateHeartbeatReporterAVStreamStatus(Boolean bool, Boolean bool2) {
        RtcHeartbeatReporter rtcHeartbeatReporter = GlobalHolder.getInstance().getRtcHeartbeatReporter(this.mChannelName);
        if (rtcHeartbeatReporter != null) {
            if (bool != null) {
                rtcHeartbeatReporter.setAudioLocalStreamEnabled(bool.booleanValue());
            }
            if (bool2 != null) {
                rtcHeartbeatReporter.setVideoLocalStreamEnabled(bool2.booleanValue());
            }
        }
    }

    private void updateHeartbeatReporterAVStatus(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6) {
        List<RtcHeartbeatReporter> rtcHeartbeatReporterForAll = GlobalHolder.getInstance().getRtcHeartbeatReporterForAll();
        if (rtcHeartbeatReporterForAll != null && rtcHeartbeatReporterForAll.size() > 0) {
            for (int i = 0; i < rtcHeartbeatReporterForAll.size(); i++) {
                RtcHeartbeatReporter rtcHeartbeatReporter = rtcHeartbeatReporterForAll.get(i);
                if (rtcHeartbeatReporter != null) {
                    if (bool != null) {
                        rtcHeartbeatReporter.setAudioEnabled(bool.booleanValue());
                    }
                    if (bool2 != null) {
                        rtcHeartbeatReporter.setAudioLocalEnabled(bool2.booleanValue());
                    }
                    if (bool != null) {
                        rtcHeartbeatReporter.setAudioEnabled(bool.booleanValue());
                    }
                    if (bool3 != null) {
                        rtcHeartbeatReporter.setAudioLocalStreamEnabled(bool3.booleanValue());
                    }
                    if (bool4 != null) {
                        rtcHeartbeatReporter.setVideoEnabled(bool4.booleanValue());
                    }
                    if (bool5 != null) {
                        rtcHeartbeatReporter.setVideoLocalEnabled(bool5.booleanValue());
                    }
                    if (bool6 != null) {
                        rtcHeartbeatReporter.setVideoLocalStreamEnabled(bool6.booleanValue());
                    }
                }
            }
        }
    }

    public int enterRoom(String str, long j, String str2, int i, String str3) {
        if (TextUtils.isEmpty(str)) {
            str = "VGhpcyBpcyBhbiBpbnZhbGlkIHRva2Vu77yB";
        }
        GlobalConfig.mLocalUserID = j;
        GlobalConfig.mLocalRoomName = str2;
        GlobalConfig.mEnterRoomTime = System.currentTimeMillis();
        synchronized (this.mLock) {
            this.mJoiningChannel = true;
            this.mUid = j;
            this.mRole = i;
            this.mRtmpUrl = str3;
            this.mChannelName = str2;
            this.mKickOutRoom.set(false);
            this.mToken = str;
        }
        configureLogReport();
        GlobalHolder.getInstance().getGlobalChannelConfig().configChannelBeforeJoinChannel();
        this.mEngineCallbackThread.clearDelayMessages();
        Object[] objArr = {GlobalConfig.mAppId, Long.valueOf(j), str2, Integer.valueOf(i), str3, str, false, ""};
        if (this.mRequestServerManager == null) {
            this.mRequestServerManager = new RtcRequestServerManager(str2);
        }
        this.mRequestServerManager.requestServer(501, objArr, new RequestEventCallBackImpl());
        return 0;
    }

    public void renewChannelKey(String str) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.reportRenewKey(str, this.mTokenExpiredAndExiting);
            }
        }
        synchronized (this.mTokenLock) {
            if (this.mTokenExpiredAndExiting) {
                OmniLog.rw_e(TAG, "authDoing -> renewToken invoked! but failed! room exiting!");
                return;
            }
            String str2 = TAG;
            OmniLog.rw_d(str2, "authDoing -> renewToken invoked! channelKey : " + str);
            RoomJni.getInstance().RenewToken(this.mChannelName, str);
        }
    }

    public void exitRoom(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.mChannelName;
        }
        if (!TextUtils.isEmpty(str)) {
            String str2 = TAG;
            OmniLog.i(str2, "exitRoom Exit channel invoked! " + str);
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (ReportLogger.class) {
                ReportLogger reportLogger2 = this.reportLogger;
                if (reportLogger2 != null) {
                    reportLogger2.ReportExit(str);
                    this.reportLogger = null;
                }
            }
            ChannelMediaRelayHandler channelMediaRelayHandler = this.mChannelMediaRelayHandler;
            if (channelMediaRelayHandler != null) {
                channelMediaRelayHandler.stopChannelMediaRelay();
                this.mChannelMediaRelayHandler = null;
            }
            RoomJni.getInstance().RoomExit(str);
            RtcRequestServerManager rtcRequestServerManager = this.mRequestServerManager;
            if (rtcRequestServerManager != null) {
                rtcRequestServerManager.clearResource();
                this.mRequestServerManager = null;
            }
            RtcGlobalAVInterface globalAVInterface = GlobalHolder.getInstance().getGlobalAVInterface();
            RtcStats rtcStats = globalAVInterface != null ? globalAVInterface.getRtcStats(str) : null;
            if (!GlobalConfig.mIsInRoom.get()) {
                resetMember();
                GlobalConfig.resetEngineStats();
                reportLeaveChannel(rtcStats);
                OmniLog.i(str2, "exitRoom reportLeaveChannel");
                return;
            }
            synchronized (this) {
                Timer timer = this.mChannelKeyTimer;
                if (timer != null) {
                    timer.cancel();
                    this.mChannelKeyTimer = null;
                }
            }
            GlobalHolder.getInstance().clearChannelDatas(str);
            OmniLog.i(str2, "Clear member var list...");
            resetMember();
            GlobalConfig.resetEngineStats();
            GlobalHolder.getInstance().getAVStreamPublishHandler().resetEngineAVStreamPublishBean();
            reportLeaveChannel(rtcStats);
            OmniLog.i(str2, "Exit channel execute over! time : " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void uploadLocalVideo(boolean z) {
        String invokedMethodNameWithFormat = OmniLog.getInvokedMethodNameWithFormat();
        if (TextUtils.isEmpty(this.mChannelName)) {
            String str = TAG;
            OmniLog.w(OmniLog.CHANNEL_PUSH, str, invokedMethodNameWithFormat + "Haven't joined the channel yet!");
        } else if (z == this.mLocalVideoUpload) {
            String str2 = TAG;
            OmniLog.i(OmniLog.CHANNEL_PUSH, str2, invokedMethodNameWithFormat + "Already upload!");
        } else {
            UserDeviceConfig userDefaultDevice = GlobalHolder.getInstance().getUserDefaultDevice(this.mUid);
            if (userDefaultDevice == null) {
                String str3 = TAG;
                OmniLog.e(OmniLog.CHANNEL_PUSH, str3, invokedMethodNameWithFormat + "UserDeviceConfig is null! " + this.mUid);
                return;
            }
            String str4 = TAG;
            OmniLog.i(OmniLog.CHANNEL_PUSH, str4, invokedMethodNameWithFormat + "Upload local video success! channel = " + this.mChannelName + ", uid = " + this.mUid);
            this.mLocalVideoUpload = z;
            RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.UPLOAD_VIDEO, this.mChannelName, userDefaultDevice.getDeviceId(), Boolean.valueOf(z));
        }
    }

    public boolean changeUserRole(int i) {
        AVStreamPublishHandler aVStreamPublishHandler = GlobalHolder.getInstance().getAVStreamPublishHandler();
        if (aVStreamPublishHandler.isPublishStats(GlobalConfig.ENGINE_NAME) && i == 2) {
            OmniLog.w(OmniLog.CHANNEL_PUSH, TAG, "Set role failed... Pushing stream! Engine");
            return false;
        } else if (GlobalHolder.getInstance().setRoleForBroadcaster(GlobalConfig.ENGINE_NAME, i) != 0) {
            OmniLog.w(OmniLog.CHANNEL_PUSH, TAG, "Set role failed... Only one can be set broadcaster at the same time!Engine");
            return false;
        } else {
            synchronized (ReportLogger.class) {
                ReportLogger reportLogger2 = this.reportLogger;
                if (reportLogger2 != null) {
                    reportLogger2.ReportChangeRole(i);
                }
            }
            this.mRole = i;
            aVStreamPublishHandler.updateRole(GlobalConfig.ENGINE_NAME, i);
            boolean isPublishStats = aVStreamPublishHandler.isPublishStats(GlobalConfig.ENGINE_NAME);
            if (TextUtils.isEmpty(this.mChannelName)) {
                return true;
            }
            uploadLocalVideo(isPublishStats);
            RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.ROLE_CHANGE, this.mChannelName, Integer.valueOf(i));
            RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.AUDIO_LOCAL_MUTED, this.mChannelName, Boolean.valueOf(!GlobalConfig.mAudioLocalStreamEnabled));
            RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.VIDEO_LOCAL_MUTED, this.mChannelName, Boolean.valueOf(!GlobalConfig.mVideoLocalStreamEnabled));
            return true;
        }
    }

    public String getEngineSessionId() {
        String str;
        synchronized (this.mLock) {
            str = this.mSessionId;
        }
        return str;
    }

    public int muteLocalAudio(boolean z) {
        if (!GlobalConfig.mAudioEnabled) {
            return -3;
        }
        boolean z2 = !z;
        if (GlobalConfig.mAudioLocalStreamEnabled == z2) {
            return 0;
        }
        AVStreamPublishHandler aVStreamPublishHandler = GlobalHolder.getInstance().getAVStreamPublishHandler();
        if (!aVStreamPublishHandler.updateAudioMuted(GlobalConfig.ENGINE_NAME, z)) {
            return -5;
        }
        GlobalConfig.mAudioLocalStreamEnabled = z2;
        if (TextUtils.isEmpty(this.mChannelName)) {
            return 0;
        }
        if (!z2) {
            aVStreamPublishHandler.updateAudioMuted(GlobalConfig.ENGINE_NAME, true);
        } else if (aVStreamPublishHandler.isPublishStats() && !aVStreamPublishHandler.isPublishStats(GlobalConfig.ENGINE_NAME)) {
            return -5;
        }
        return executeMuteLocalAudio(z);
    }

    public int muteLocalVideo(boolean z) {
        boolean z2 = !z;
        if (GlobalConfig.mVideoLocalStreamEnabled == z2) {
            return 0;
        }
        AVStreamPublishHandler aVStreamPublishHandler = GlobalHolder.getInstance().getAVStreamPublishHandler();
        if (!aVStreamPublishHandler.updateVideoMuted(GlobalConfig.ENGINE_NAME, z)) {
            return -5;
        }
        GlobalConfig.mVideoLocalStreamEnabled = z2;
        if (TextUtils.isEmpty(this.mChannelName)) {
            return 0;
        }
        if (!z2) {
            aVStreamPublishHandler.updateVideoMuted(GlobalConfig.ENGINE_NAME, true);
        } else if (aVStreamPublishHandler.isPublishStats() && !aVStreamPublishHandler.isPublishStats(GlobalConfig.ENGINE_NAME)) {
            return -5;
        }
        if (GlobalConfig.mVideoEnabled) {
            return executeMuteLocalVideo(z);
        }
        OmniLog.w(OmniLog.CHANNEL_PUSH, TAG, "Mute local video stream failed, video module isn't enabled!");
        return 0;
    }

    public int muteRemoteAudio(long j, boolean z) {
        RtcUserManager userManager;
        InterCorrectionManager interCorrectionManager = GlobalHolder.getInstance().getInterCorrectionManager();
        if (interCorrectionManager == null) {
            return -3;
        }
        InterCorrectUserBean interCorrectUserBean = new InterCorrectUserBean(LocalSDKConstants.ENGINE_CHANNEL_ID, j);
        interCorrectUserBean.mAction = InterCorrectionEnum.INTER_MUTE_REMOTE_AUDIO;
        interCorrectUserBean.mInfo = Boolean.valueOf(z);
        interCorrectionManager.addInterCorrection(interCorrectUserBean);
        User user = null;
        if (!TextUtils.isEmpty(this.mChannelName) && (userManager = GlobalHolder.getInstance().getUserManager(this.mChannelName)) != null) {
            user = userManager.getUser(j);
        }
        if (GlobalConfig.mIsInRoom.get() && user != null) {
            String str = TAG;
            OmniLog.i(OmniLog.INTER_CORRECT_WATCH, str, "Mute remote audio success. channelName: " + this.mChannelName + ", uid: " + j + ", muted: " + z);
            RoomJni.getInstance().MuteRemoteAudio(this.mChannelName, j, z);
        }
        return 0;
    }

    public int muteRemoteVideo(long j, boolean z) {
        RtcDeviceManager deviceManager;
        InterCorrectionManager interCorrectionManager = GlobalHolder.getInstance().getInterCorrectionManager();
        if (interCorrectionManager == null) {
            return -3;
        }
        InterCorrectUserBean interCorrectUserBean = new InterCorrectUserBean(LocalSDKConstants.ENGINE_CHANNEL_ID, j);
        interCorrectUserBean.mAction = InterCorrectionEnum.INTER_MUTE_REMOTE_VIDEO;
        interCorrectUserBean.mInfo = Boolean.valueOf(z);
        interCorrectionManager.addInterCorrection(interCorrectUserBean);
        UserDeviceConfig userDeviceConfig = null;
        if (!TextUtils.isEmpty(this.mChannelName) && (deviceManager = GlobalHolder.getInstance().getDeviceManager(this.mChannelName)) != null) {
            userDeviceConfig = deviceManager.getVideoDeviceForDefault(j);
        }
        if (!GlobalConfig.mIsInRoom.get() || userDeviceConfig == null) {
            return 0;
        }
        String str = TAG;
        OmniLog.i(OmniLog.INTER_CORRECT_WATCH, str, "Mute remote video success. channelName: " + this.mChannelName + ", uid: " + j + ", muted: " + z);
        if (controlUserVideoDevice(this.mChannelName, j, userDeviceConfig.getDeviceId(), !z)) {
            return 0;
        }
        return -6;
    }

    public int controlDeviceVideoByType(boolean z, long j, int i) {
        if (TextUtils.isEmpty(this.mChannelName)) {
            OmniLog.w(TAG, "Control device video failed! Haven't joined the channel yet!");
            return 0;
        }
        String str = this.mChannelName;
        RtcDeviceManager deviceManager = GlobalHolder.getInstance().getDeviceManager(str);
        if (deviceManager == null) {
            return 0;
        }
        if (deviceManager.getVideoDeviceByType(j, i) == null) {
            return -3;
        }
        synchronized (this.mLockObject) {
            if (z) {
                VideoJni.getInstance().VideoOpenDevice(str, j, i);
            } else {
                VideoJni.getInstance().VideoCloseDevice(str, j, i);
            }
        }
        return 0;
    }

    public void muteAllRemoteAudioForChannel(boolean z) {
        if (!TextUtils.isEmpty(this.mChannelName)) {
            this.mAudioAllRemoteMuted = z;
            if (GlobalConfig.mIsInRoom.get()) {
                RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.AUDIO_REMOTE_ALL_MUTED, this.mChannelName, Boolean.valueOf(z));
            }
        }
    }

    public void muteAllRemoteVideoForChannel(boolean z) {
        if (!TextUtils.isEmpty(this.mChannelName)) {
            this.mVideoAllRemoteMuted = z;
            if (GlobalConfig.mIsInRoom.get()) {
                RoomJni.getInstance().MuteAllRemoteVideo(this.mChannelName, z);
            }
        }
    }

    public int setRemoteRenderMode(long j, int i, int i2) {
        UserDeviceConfig userDefaultDevice = GlobalHolder.getInstance().getUserDefaultDevice(j);
        if (userDefaultDevice == null) {
            return -3;
        }
        String deviceId = userDefaultDevice.getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            return -3;
        }
        GlobalHolder.getInstance().sendSyncGlobalMessage(1003, deviceId, Integer.valueOf(i));
        GlobalHolder.getInstance().sendSyncGlobalMessage(1014, deviceId, Integer.valueOf(i2));
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r0 = com.wushuangtech.library.GlobalHolder.getInstance().getRtcPublishStreamManager(r2.mChannelName);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        if (r0 != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        return -3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        return r0.addPublishStreamUrl(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int addPublishStreamUrl(java.lang.String r3) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x0008
            r3 = -5
            return r3
        L_0x0008:
            java.lang.Object r0 = r2.mLock
            monitor-enter(r0)
            java.lang.String r1 = r2.mChannelName     // Catch:{ all -> 0x0031 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x001d
            com.wushuangtech.bean.EngineCacheBean r1 = r2.mEngineCacheBean     // Catch:{ all -> 0x0031 }
            java.util.List<java.lang.String> r1 = r1.mRtmpUrlList     // Catch:{ all -> 0x0031 }
            r1.add(r3)     // Catch:{ all -> 0x0031 }
            r3 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return r3
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            com.wushuangtech.library.GlobalHolder r0 = com.wushuangtech.library.GlobalHolder.getInstance()
            java.lang.String r1 = r2.mChannelName
            com.wushuangtech.api.RtcPublishStreamManager r0 = r0.getRtcPublishStreamManager(r1)
            if (r0 != 0) goto L_0x002c
            r3 = -3
            return r3
        L_0x002c:
            int r3 = r0.addPublishStreamUrl(r3)
            return r3
        L_0x0031:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.EnterConfApiImpl.addPublishStreamUrl(java.lang.String):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r0 = com.wushuangtech.library.GlobalHolder.getInstance().getRtcPublishStreamManager(r2.mChannelName);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        if (r0 != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        return -3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        return r0.removePublishStreamUrl(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int removePublishStreamUrl(java.lang.String r3) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x0008
            r3 = -5
            return r3
        L_0x0008:
            java.lang.Object r0 = r2.mLock
            monitor-enter(r0)
            java.lang.String r1 = r2.mChannelName     // Catch:{ all -> 0x0031 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x001d
            com.wushuangtech.bean.EngineCacheBean r1 = r2.mEngineCacheBean     // Catch:{ all -> 0x0031 }
            java.util.List<java.lang.String> r1 = r1.mRtmpUrlList     // Catch:{ all -> 0x0031 }
            r1.remove(r3)     // Catch:{ all -> 0x0031 }
            r3 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return r3
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            com.wushuangtech.library.GlobalHolder r0 = com.wushuangtech.library.GlobalHolder.getInstance()
            java.lang.String r1 = r2.mChannelName
            com.wushuangtech.api.RtcPublishStreamManager r0 = r0.getRtcPublishStreamManager(r1)
            if (r0 != 0) goto L_0x002c
            r3 = -3
            return r3
        L_0x002c:
            int r3 = r0.removePublishStreamUrl(r3)
            return r3
        L_0x0031:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.EnterConfApiImpl.removePublishStreamUrl(java.lang.String):int");
    }

    public void mixGuestAudio(long j, boolean z, String str) {
        if (TextUtils.isEmpty(this.mChannelName)) {
            OmniLog.w(TAG, "Haven't joined the channel yet!");
            return;
        }
        int i = 1;
        if (GlobalConfig.mCurrentChannelMode == 1) {
            if (TextUtils.isEmpty(str)) {
                str = this.mRtmpUrl;
            }
            String str2 = str;
            OmniLog.i(OmniLog.CROSS_WATCH, "mixGuestAudio -> uid : " + j + " | streamUrl : " + str2 + " | enable : " + z);
            VideoJni instance = VideoJni.getInstance();
            String str3 = this.mChannelName;
            if (!z) {
                i = -1;
            }
            instance.RtmpAddAudio(str3, j, i, str2);
        }
    }

    public boolean mixGuestVideo(long j, String str, boolean z, String str2) {
        boolean z2 = z;
        if (TextUtils.isEmpty(this.mChannelName)) {
            OmniLog.w(TAG, "Haven't joined the channel yet!");
            return false;
        } else if (GlobalConfig.mCurrentChannelMode != 1 || !GlobalConfig.mVideoEnabled) {
            return false;
        } else {
            String str3 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Rtmp add video, uid : ");
            long j2 = j;
            sb.append(j);
            sb.append(" | streamUrl : ");
            sb.append(str2);
            sb.append(" | enable : ");
            sb.append(z2);
            OmniLog.i(OmniLog.RTC_PUBLISH_WATCH, str3, sb.toString());
            VideoJni.getInstance().RtmpAddVideo(this.mChannelName, j, str, z2 ? 1 : -1, str2);
            return true;
        }
    }

    public int startChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        if (!GlobalConfig.mIsInRoom.get()) {
            return -3;
        }
        if (this.mChannelMediaRelayHandler == null) {
            this.mChannelMediaRelayHandler = new ChannelMediaRelayHandler(this.mChannelName, this.mUid);
        }
        return this.mChannelMediaRelayHandler.startChannelMediaRelay(channelMediaRelayConfiguration);
    }

    public void stopChannelMediaRelay() {
        ChannelMediaRelayHandler channelMediaRelayHandler = this.mChannelMediaRelayHandler;
        if (channelMediaRelayHandler != null) {
            channelMediaRelayHandler.stopChannelMediaRelay();
        }
    }

    public int updateChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        ChannelMediaRelayHandler channelMediaRelayHandler = this.mChannelMediaRelayHandler;
        if (channelMediaRelayHandler != null) {
            return channelMediaRelayHandler.updateChannelMediaRelay(channelMediaRelayConfiguration);
        }
        return 0;
    }

    public int createDataStream(boolean z, boolean z2) {
        if (TextUtils.isEmpty(this.mChannelName)) {
            OmniLog.w(TAG, "Create data stream failed! Haven't joined the channel yet!");
            return -3;
        }
        RtcDataStreamManager dataStreamManager = GlobalHolder.getInstance().getDataStreamManager(this.mChannelName);
        if (dataStreamManager == null) {
            return -1;
        }
        return dataStreamManager.createDataStream(z, z2);
    }

    public int sendStreamMessage(int i, byte[] bArr) {
        if (TextUtils.isEmpty(this.mChannelName)) {
            return -3;
        }
        if (i <= 0 || bArr == null) {
            return -5;
        }
        RtcDataStreamManager dataStreamManager = GlobalHolder.getInstance().getDataStreamManager(this.mChannelName);
        if (dataStreamManager == null) {
            return -1;
        }
        dataStreamManager.sendStreamMessage(i, bArr);
        return 0;
    }

    private void resetMember() {
        synchronized (this.mLock) {
            OmniLog.rw_i(TAG, "SESSION_WATCH Reset engine member var!");
            this.mChannelName = "";
            this.mUid = 0;
            this.mToken = "";
            this.reportLogger = null;
            this.mSessionId = "";
            this.mConnectId = "";
            this.mJoiningChannel = false;
        }
        this.mTokenExpiredAndExiting = false;
        this.mAudioAllRemoteMuted = false;
        this.mVideoAllRemoteMuted = false;
        this.mLocalVideoUpload = false;
        this.mEngineCacheBean.mRtmpUrlList.clear();
    }

    private int executeMuteLocalAudio(boolean z) {
        updateHeartbeatReporterAVStreamStatus(Boolean.valueOf(!z), (Boolean) null);
        if (this.mRole != 2 || z) {
            String str = TAG;
            OmniLog.i(OmniLog.CHANNEL_PUSH, str, "Mute local audio stream success, channel = " + this.mChannelName + ", muted = " + z);
            RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.AUDIO_LOCAL_MUTED, this.mChannelName, Boolean.valueOf(z));
            return 0;
        }
        OmniLog.w(OmniLog.CHANNEL_PUSH, TAG, "Mute local audio stream failed, role is audience, but mute stats is false!");
        return 0;
    }

    private int executeMuteLocalVideo(boolean z) {
        uploadLocalVideo(GlobalHolder.getInstance().getAVStreamPublishHandler().isPublishStats(GlobalConfig.ENGINE_NAME));
        updateHeartbeatReporterAVStreamStatus((Boolean) null, Boolean.valueOf(!z));
        if (this.mRole != 2 || z) {
            String str = TAG;
            OmniLog.i(OmniLog.CHANNEL_PUSH, str, "Mute local video stream success, channel = " + this.mChannelName + ", muted = " + z);
            RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.VIDEO_LOCAL_MUTED, this.mChannelName, Boolean.valueOf(z));
            return 0;
        }
        OmniLog.w(OmniLog.CHANNEL_PUSH, TAG, "Mute local video stream failed, role is audience, but mute stats is false!");
        return 0;
    }

    public void OnReportMediaAddr(String str, int i, String str2, String str3, int i2, String str4) {
        this.v2ConferenceRequest.OnReportMediaAddr(str, i, str2, str3, i2, str4);
    }

    public void onGlobalAudioVolumeIndication(AudioVolumeInfo[] audioVolumeInfoArr, int i) {
        if (audioVolumeInfoArr != null) {
            this.mEngineCallbackThread.sendMessage(17, new Object[]{audioVolumeInfoArr, Integer.valueOf(i)});
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r0 = r4.reportLogger;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        if (r0 == null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
        r0.ReportUserRoleChanged(r6, r8);
        r4.reportLogger.setRole(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
        com.wushuangtech.library.GlobalConfig.mLocalRole = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        if (com.wushuangtech.library.GlobalConfig.mVideoLocalStreamEnabled == false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        uploadLocalVideo(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        r4.mEngineCallbackThread.sendMessage(30, new java.lang.Object[]{java.lang.Long.valueOf(r6), java.lang.Integer.valueOf(r8)});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        r5 = com.wushuangtech.log.ReportLogger.class;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onGlobalUserRoleChanged(java.lang.String r5, long r6, int r8) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.mLock
            monitor-enter(r0)
            java.lang.String r1 = r4.mChannelName     // Catch:{ all -> 0x004c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x004a
            java.lang.String r1 = r4.mChannelName     // Catch:{ all -> 0x004c }
            boolean r5 = r1.equals(r5)     // Catch:{ all -> 0x004c }
            if (r5 != 0) goto L_0x0014
            goto L_0x004a
        L_0x0014:
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            java.lang.Class<com.wushuangtech.log.ReportLogger> r5 = com.wushuangtech.log.ReportLogger.class
            monitor-enter(r5)
            com.wushuangtech.log.ReportLogger r0 = r4.reportLogger     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0024
            r0.ReportUserRoleChanged(r6, r8)     // Catch:{ all -> 0x0047 }
            com.wushuangtech.log.ReportLogger r0 = r4.reportLogger     // Catch:{ all -> 0x0047 }
            r0.setRole(r8)     // Catch:{ all -> 0x0047 }
        L_0x0024:
            monitor-exit(r5)     // Catch:{ all -> 0x0047 }
            com.wushuangtech.library.GlobalConfig.mLocalRole = r8
            boolean r5 = com.wushuangtech.library.GlobalConfig.mVideoLocalStreamEnabled
            r0 = 1
            if (r5 == 0) goto L_0x002f
            r4.uploadLocalVideo(r0)
        L_0x002f:
            com.wushuangtech.thread.EngineCallbackThread r5 = r4.mEngineCallbackThread
            r1 = 30
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r2[r3] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            r2[r0] = r6
            r5.sendMessage(r1, r2)
            return
        L_0x0047:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0047 }
            throw r6
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            return
        L_0x004c:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.EnterConfApiImpl.onGlobalUserRoleChanged(java.lang.String, long, int):void");
    }

    public void OnUpdateReportLogConfig(boolean z, boolean z2, int i) {
        this.v2ConferenceRequest.setLogReportConfig(z, z2, i);
    }

    public void OnReportFireEvent(long j) {
        reportHeartbeat(j);
    }

    public void OnSetSei(long j, String str) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportSei(str, true, "");
            }
        }
        this.mEngineCallbackThread.sendMessage(20, new Object[]{str});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        if (r17 != 3) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        r1.mEngineCallbackThread.sendMessage(46, new java.lang.Object[]{java.lang.Long.valueOf(r13), java.lang.Boolean.valueOf(r0)});
        r1.mEngineCallbackThread.sendMessage(56, new java.lang.Object[]{java.lang.Long.valueOf(r13), java.lang.Boolean.valueOf(com.wushuangtech.utils.XMLParseUtils.parseDeviceDualStatus(r15))});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0066, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        checkUserAVMuteStats(r12, r13);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void OnRoomMemberEnter(java.lang.String r12, long r13, java.lang.String r15, int r16, int r17, boolean r18, boolean r19) {
        /*
            r11 = this;
            r1 = r11
            com.wushuangtech.library.PviewConferenceRequest r2 = r1.v2ConferenceRequest
            r3 = r12
            r4 = r13
            r6 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            r10 = r19
            r2.OnConfMemberEnter(r3, r4, r6, r7, r8, r9, r10)
            r11.checkCacheVideoRemoteStreamType(r12, r13)
            java.lang.Object r2 = r1.mLock
            monitor-enter(r2)
            java.lang.String r0 = r1.mChannelName     // Catch:{ all -> 0x0069 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0069 }
            if (r0 != 0) goto L_0x0067
            java.lang.String r0 = r1.mChannelName     // Catch:{ all -> 0x0069 }
            r3 = r12
            boolean r0 = r0.equals(r12)     // Catch:{ all -> 0x0069 }
            if (r0 != 0) goto L_0x0029
            goto L_0x0067
        L_0x0029:
            monitor-exit(r2)     // Catch:{ all -> 0x0069 }
            r11.checkUserAVMuteStats(r12, r13)
            r0 = 3
            r2 = 0
            r3 = 1
            r4 = r17
            if (r4 != r0) goto L_0x0036
            r0 = r2
            goto L_0x0037
        L_0x0036:
            r0 = r3
        L_0x0037:
            com.wushuangtech.thread.EngineCallbackThread r4 = r1.mEngineCallbackThread
            r5 = 46
            r6 = 2
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.Long r8 = java.lang.Long.valueOf(r13)
            r7[r2] = r8
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r7[r3] = r0
            r4.sendMessage(r5, r7)
            boolean r0 = com.wushuangtech.utils.XMLParseUtils.parseDeviceDualStatus(r15)
            com.wushuangtech.thread.EngineCallbackThread r4 = r1.mEngineCallbackThread
            r5 = 56
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Long r7 = java.lang.Long.valueOf(r13)
            r6[r2] = r7
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6[r3] = r0
            r4.sendMessage(r5, r6)
            return
        L_0x0067:
            monitor-exit(r2)     // Catch:{ all -> 0x0069 }
            return
        L_0x0069:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0069 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.EnterConfApiImpl.OnRoomMemberEnter(java.lang.String, long, java.lang.String, int, int, boolean, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0074, code lost:
        r6 = com.wushuangtech.library.GlobalHolder.getInstance().getVideoDualStreamManager(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007c, code lost:
        if (r6 != null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007e, code lost:
        com.wushuangtech.utils.OmniLog.e(com.wushuangtech.utils.OmniLog.DUAL_VIDEO, r2, "HandleUserJoined -> VideoDualStreamManager is null... ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0085, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0086, code lost:
        r6 = r6.setRemoteVideoStreamType(r7, r1.mStreamType);
        com.wushuangtech.utils.OmniLog.i(com.wushuangtech.utils.OmniLog.DUAL_VIDEO, r2, "HandleUserJoined -> set remote video stream type result : " + r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a2, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkCacheVideoRemoteStreamType(java.lang.String r6, long r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mDualStreamTypeLock
            monitor-enter(r0)
            java.lang.String r1 = "DUAL_WATCH"
            java.lang.String r2 = TAG     // Catch:{ all -> 0x00a3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a3 }
            r3.<init>()     // Catch:{ all -> 0x00a3 }
            java.lang.String r4 = "HandleUserJoined -> start check video remote stream type cache : "
            r3.append(r4)     // Catch:{ all -> 0x00a3 }
            r3.append(r6)     // Catch:{ all -> 0x00a3 }
            java.lang.String r4 = " | "
            r3.append(r4)     // Catch:{ all -> 0x00a3 }
            r3.append(r7)     // Catch:{ all -> 0x00a3 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00a3 }
            com.wushuangtech.utils.OmniLog.i(r1, r2, r3)     // Catch:{ all -> 0x00a3 }
            java.util.HashMap<java.lang.Long, com.wushuangtech.bean.VideoRemoteStreamType> r1 = r5.mCacheRemoteVideoStreamType     // Catch:{ all -> 0x00a3 }
            if (r1 != 0) goto L_0x0047
            java.lang.String r1 = "DUAL_WATCH"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a3 }
            r3.<init>()     // Catch:{ all -> 0x00a3 }
            java.lang.String r4 = "HandleUserJoined -> cache map is null..."
            r3.append(r4)     // Catch:{ all -> 0x00a3 }
            r3.append(r6)     // Catch:{ all -> 0x00a3 }
            java.lang.String r6 = " | "
            r3.append(r6)     // Catch:{ all -> 0x00a3 }
            r3.append(r7)     // Catch:{ all -> 0x00a3 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x00a3 }
            com.wushuangtech.utils.OmniLog.w((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r6)     // Catch:{ all -> 0x00a3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a3 }
            return
        L_0x0047:
            java.lang.Long r3 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x00a3 }
            java.lang.Object r1 = r1.remove(r3)     // Catch:{ all -> 0x00a3 }
            com.wushuangtech.bean.VideoRemoteStreamType r1 = (com.wushuangtech.bean.VideoRemoteStreamType) r1     // Catch:{ all -> 0x00a3 }
            if (r1 != 0) goto L_0x0073
            java.lang.String r1 = "DUAL_WATCH"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a3 }
            r3.<init>()     // Catch:{ all -> 0x00a3 }
            java.lang.String r4 = "HandleUserJoined -> not found cache : "
            r3.append(r4)     // Catch:{ all -> 0x00a3 }
            r3.append(r6)     // Catch:{ all -> 0x00a3 }
            java.lang.String r6 = " | "
            r3.append(r6)     // Catch:{ all -> 0x00a3 }
            r3.append(r7)     // Catch:{ all -> 0x00a3 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x00a3 }
            com.wushuangtech.utils.OmniLog.w((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r6)     // Catch:{ all -> 0x00a3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a3 }
            return
        L_0x0073:
            monitor-exit(r0)     // Catch:{ all -> 0x00a3 }
            com.wushuangtech.library.GlobalHolder r0 = com.wushuangtech.library.GlobalHolder.getInstance()
            com.wushuangtech.library.video.VideoDualStreamManager r6 = r0.getVideoDualStreamManager(r6)
            if (r6 != 0) goto L_0x0086
            java.lang.String r6 = "DUAL_WATCH"
            java.lang.String r7 = "HandleUserJoined -> VideoDualStreamManager is null... "
            com.wushuangtech.utils.OmniLog.e((java.lang.String) r6, (java.lang.String) r2, (java.lang.String) r7)
            return
        L_0x0086:
            int r0 = r1.mStreamType
            int r6 = r6.setRemoteVideoStreamType(r7, r0)
            java.lang.String r7 = "DUAL_WATCH"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "HandleUserJoined -> set remote video stream type result : "
            r8.append(r0)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            com.wushuangtech.utils.OmniLog.i(r7, r2, r6)
            return
        L_0x00a3:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a3 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.EnterConfApiImpl.checkCacheVideoRemoteStreamType(java.lang.String, long):void");
    }

    private void checkUserAVMuteStats(String str, long j) {
        InterCorrectionManager interCorrectionManager = GlobalHolder.getInstance().getInterCorrectionManager();
        if (interCorrectionManager != null) {
            InterCorrectUserBean interCorrectUserBean = new InterCorrectUserBean(LocalSDKConstants.ENGINE_CHANNEL_ID, j);
            interCorrectUserBean.mAction = InterCorrectionEnum.INTER_MUTE_REMOTE_AUDIO;
            InterCorrectionBean recoveryInterWithNoNotify = interCorrectionManager.recoveryInterWithNoNotify(interCorrectUserBean);
            if (recoveryInterWithNoNotify != null) {
                if (((Boolean) recoveryInterWithNoNotify.mInfo).booleanValue()) {
                    OmniLog.i(OmniLog.INTER_CORRECT_WATCH, TAG, "User has joined room, restore the user's audio streaming status, muted: true");
                    RoomJni.getInstance().MuteRemoteAudio(str, j, true);
                }
            } else if (GlobalConfig.mDefaultMuteAllRemoteAudioStreams) {
                OmniLog.i(OmniLog.INTER_CORRECT_WATCH, TAG, "User has joined room, but doesn't pull the audio stream by default.");
                RoomJni.getInstance().MuteRemoteAudio(str, j, true);
            }
        }
    }

    public void OnRoomMemberExit(String str, long j, int i) {
        this.v2ConferenceRequest.OnConfMemberExitCallback(str, j);
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    this.mEngineCallbackThread.sendMessage(8, new Object[]{Long.valueOf(j), Integer.valueOf(i + 200)});
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        if (r2.mConnectId.equals(r9) != false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        com.wushuangtech.utils.OmniLog.w("OnKickRoom 所收到的ID与当前房间ID不匹配... uuid : " + r9);
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        r9 = com.wushuangtech.log.ReportLogger.class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0 = r2.reportLogger;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r0 == null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        r0.ReportKicked(r4, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        if (r3 != false) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        r2.mEngineCallbackThread.sendMessage(55, new java.lang.Object[]{java.lang.Long.valueOf(r4), java.lang.Integer.valueOf(r8), java.lang.Integer.valueOf(r10)});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0064, code lost:
        if (r8 != 111) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        r2.mEngineCallbackThread.sendMessage(76, new java.lang.Object[]{5, 3});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007c, code lost:
        r2.mKickOutRoom.set(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0081, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        r8 = r8 + 100;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void OnRoomKicked(java.lang.String r3, long r4, long r6, int r8, java.lang.String r9, int r10) {
        /*
            r2 = this;
            java.lang.Object r6 = r2.mLock
            monitor-enter(r6)
            java.lang.String r7 = r2.mChannelName     // Catch:{ all -> 0x0087 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0087 }
            if (r7 != 0) goto L_0x0085
            java.lang.String r7 = r2.mChannelName     // Catch:{ all -> 0x0087 }
            boolean r3 = r7.equals(r3)     // Catch:{ all -> 0x0087 }
            if (r3 != 0) goto L_0x0014
            goto L_0x0085
        L_0x0014:
            monitor-exit(r6)     // Catch:{ all -> 0x0087 }
            int r8 = r8 + 100
            java.lang.String r3 = r2.mConnectId
            boolean r3 = r3.equals(r9)
            r6 = 0
            r7 = 1
            if (r3 != 0) goto L_0x0037
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "OnKickRoom 所收到的ID与当前房间ID不匹配... uuid : "
            r3.append(r0)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.wushuangtech.utils.OmniLog.w(r3)
            r3 = r7
            goto L_0x0038
        L_0x0037:
            r3 = r6
        L_0x0038:
            java.lang.Class<com.wushuangtech.log.ReportLogger> r9 = com.wushuangtech.log.ReportLogger.class
            monitor-enter(r9)
            com.wushuangtech.log.ReportLogger r0 = r2.reportLogger     // Catch:{ all -> 0x0082 }
            if (r0 == 0) goto L_0x0042
            r0.ReportKicked(r4, r8)     // Catch:{ all -> 0x0082 }
        L_0x0042:
            monitor-exit(r9)     // Catch:{ all -> 0x0082 }
            if (r3 != 0) goto L_0x007c
            com.wushuangtech.thread.EngineCallbackThread r3 = r2.mEngineCallbackThread
            r9 = 55
            r0 = 3
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1[r6] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r1[r7] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r5 = 2
            r1[r5] = r4
            r3.sendMessage(r9, r1)
            r3 = 111(0x6f, float:1.56E-43)
            if (r8 != r3) goto L_0x007c
            com.wushuangtech.thread.EngineCallbackThread r3 = r2.mEngineCallbackThread
            r4 = 76
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r8 = 5
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r5[r6] = r8
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            r5[r7] = r6
            r3.sendMessage(r4, r5)
        L_0x007c:
            java.util.concurrent.atomic.AtomicBoolean r3 = r2.mKickOutRoom
            r3.set(r7)
            return
        L_0x0082:
            r3 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0082 }
            throw r3
        L_0x0085:
            monitor-exit(r6)     // Catch:{ all -> 0x0087 }
            return
        L_0x0087:
            r3 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0087 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.EnterConfApiImpl.OnRoomKicked(java.lang.String, long, long, int, java.lang.String, int):void");
    }

    public void OnRoomPermissionGranted(long j, int i, int i2) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportSpeakPermission(j, i2);
            }
        }
        if (j == this.mUid) {
            GlobalConfig.mSpeakStatus = i2;
        }
        ExternalAudioModule instance = ExternalAudioModule.getInstance();
        if (i != 1) {
            return;
        }
        if (i2 != 3) {
            if (j == this.mUid) {
                instance.StopCapture();
            }
            this.mEngineCallbackThread.sendMessage(46, new Object[]{Long.valueOf(j), true});
            return;
        }
        if (j == this.mUid) {
            instance.StartSafetyCapture();
        }
        this.mEngineCallbackThread.sendMessage(46, new Object[]{Long.valueOf(j), false});
    }

    public void OnRoomDisconnected(String str) {
        if (!this.mConnectId.equals(str)) {
            OmniLog.e("OnDisconnected 所收到的ID与当前房间ID不匹配... uuid : " + str);
            return;
        }
        boolean z = !this.mKickOutRoom.get();
        OmniLog.d("Disconnect -> OnDisconnected 触发! disconnect_overtime : " + z);
        if (z) {
            this.mEngineCallbackThread.sendMessage(11, new Object[0]);
        }
    }

    public void OnUpdateRtmpStatus(String str, String str2, int i) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportRtmpSendState(str2, i);
            }
        }
        EngineCallbackThread engineCallbackThread = this.mEngineCallbackThread;
        Object[] objArr = new Object[2];
        boolean z = false;
        objArr[0] = str2;
        if (i == 0) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        engineCallbackThread.sendMessage(63, objArr);
    }

    public void OnMediaReconnect(int i, String str) {
        this.v2ConferenceRequest.setMediaReconnectInfo(i, str);
    }

    public void OnUpdateVideoDev(String str, long j, String str2) {
        this.v2ConferenceRequest.OnUpdateVideoDev(str, j, str2);
    }

    public void OnUpdateMediaChannelState(int i, int i2, String str, int i3, int i4) {
        this.v2ConferenceRequest.OnUpdateMediaChannelState(i, i2, str, i3, i4);
    }

    public void OnStartSendVideo(boolean z, boolean z2) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportStartSendVideo(z, z2);
            }
        }
    }

    public void OnStopSendVideo(int i) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportStopSendVideo(i);
            }
        }
    }

    public void OnUpdateAudioStatus(String str, long j, boolean z, boolean z2) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportUpdateAudioStatus(j, z, z2);
            }
        }
    }

    public void OnFirstAudioSent() {
        this.mEngineCallbackThread.sendMessage(72, new Object[0]);
    }

    public void OnFirstVideoSent() {
        this.mEngineCallbackThread.sendMessage(73, new Object[0]);
    }

    public void OnReportFirstIFrameSent() {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportFirstIFrameSent();
            }
        }
    }

    public void OnSetAudioCodecParams(int i, int i2) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportAudioCodecParams(i, i2);
            }
        }
        GlobalConfig.mServerAudioBitrate = i2;
    }

    public void OnReceiveLyric(String str, long j, String str2) {
        this.mEngineCallbackThread.sendMessage(68, new Object[]{Long.valueOf(j), str2});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        r11.mEngineCallbackThread.sendMessage(54, new java.lang.Object[]{r13, r14});
        r0 = null;
        r12 = com.wushuangtech.library.GlobalHolder.getInstance().getRtcPublishStreamManager(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        if (r12 == null) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        r0 = r12.getStreamUrlList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r12 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        if (r12 >= r0.size()) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        if (r0.get(r12).equals(r14) != false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        r1 = com.wushuangtech.library.GlobalHolder.getInstance().getUserDefaultDevice(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0057, code lost:
        if (r1 != null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        r4 = r1.getDeviceId();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0062, code lost:
        if (android.text.TextUtils.isEmpty(r4) == false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0064, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
        mixGuestVideo(r7, r4, true, r14);
        com.wushuangtech.utils.OmniLog.d("MULTI_STREAM", "OnVideoMixerCreate -> update stream url : " + r14);
        r11.mEngineCallbackThread.sendMessage(63, new java.lang.Object[]{r14, true});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        r12 = r12 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void OnVideoMixerCreate(java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            r11 = this;
            java.lang.Object r0 = r11.mLock
            monitor-enter(r0)
            java.lang.String r1 = r11.mChannelName     // Catch:{ all -> 0x0099 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0099 }
            if (r1 != 0) goto L_0x0097
            java.lang.String r1 = r11.mChannelName     // Catch:{ all -> 0x0099 }
            boolean r12 = r1.equals(r12)     // Catch:{ all -> 0x0099 }
            if (r12 != 0) goto L_0x0015
            goto L_0x0097
        L_0x0015:
            java.lang.String r12 = r11.mChannelName     // Catch:{ all -> 0x0099 }
            long r7 = r11.mUid     // Catch:{ all -> 0x0099 }
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            com.wushuangtech.thread.EngineCallbackThread r0 = r11.mEngineCallbackThread
            r1 = 54
            r9 = 2
            java.lang.Object[] r2 = new java.lang.Object[r9]
            r10 = 0
            r2[r10] = r13
            r13 = 1
            r2[r13] = r14
            r0.sendMessage(r1, r2)
            r0 = 0
            com.wushuangtech.library.GlobalHolder r1 = com.wushuangtech.library.GlobalHolder.getInstance()
            com.wushuangtech.api.RtcPublishStreamManager r12 = r1.getRtcPublishStreamManager(r12)
            if (r12 == 0) goto L_0x0039
            java.util.List r0 = r12.getStreamUrlList()
        L_0x0039:
            if (r0 == 0) goto L_0x0096
            r12 = r10
        L_0x003c:
            int r1 = r0.size()
            if (r12 >= r1) goto L_0x0096
            java.lang.Object r1 = r0.get(r12)
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r1.equals(r14)
            if (r1 != 0) goto L_0x004f
            goto L_0x0093
        L_0x004f:
            com.wushuangtech.library.GlobalHolder r1 = com.wushuangtech.library.GlobalHolder.getInstance()
            com.wushuangtech.library.UserDeviceConfig r1 = r1.getUserDefaultDevice(r7)
            if (r1 != 0) goto L_0x005a
            return
        L_0x005a:
            java.lang.String r4 = r1.getDeviceId()
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 == 0) goto L_0x0065
            return
        L_0x0065:
            r5 = 1
            r1 = r11
            r2 = r7
            r6 = r14
            r1.mixGuestVideo(r2, r4, r5, r6)
            java.lang.String r1 = "MULTI_STREAM"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "OnVideoMixerCreate -> update stream url : "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            com.wushuangtech.utils.OmniLog.d(r1, r2)
            com.wushuangtech.thread.EngineCallbackThread r1 = r11.mEngineCallbackThread
            r2 = 63
            java.lang.Object[] r3 = new java.lang.Object[r9]
            r3[r10] = r14
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r13)
            r3[r13] = r4
            r1.sendMessage(r2, r3)
        L_0x0093:
            int r12 = r12 + 1
            goto L_0x003c
        L_0x0096:
            return
        L_0x0097:
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            return
        L_0x0099:
            r12 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.EnterConfApiImpl.OnVideoMixerCreate(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void OnSendDataFail(String str, int i, int i2) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportSendDataFail(str, i, i2);
            }
        }
    }

    public void OnEnterAuthed() {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportOnEnterAuthed();
            }
        }
    }

    public void OnAudioMsgLog(int i, long j) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                if (i == 100) {
                    reportLogger2.ReportOnAudioConnectSuccess();
                } else if (i == 101) {
                    reportLogger2.ReportAudioFirstPackReceived();
                }
            }
        }
    }

    public void OnAudioTryReconnect() {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportAudioTryReconnect();
            }
        }
    }

    public void OnVideoTryReconnect() {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportVideoTryReconnect();
            }
        }
    }

    public void OnUpdateRtmpError(String str, String str2) {
        this.mEngineCallbackThread.sendMessage(71, new Object[0]);
    }

    public void OnRemoteVideoMuted(String str, long j, boolean z) {
        this.v2ConferenceRequest.onRemoteVideoMuted(str, j, z);
        if (!TextUtils.isEmpty(this.mChannelName) && this.mChannelName.equals(str)) {
            this.mEngineCallbackThread.sendMessage(74, new Object[]{Long.valueOf(j), Boolean.valueOf(z)});
        }
    }

    public void OnCheckNetQuality(int i, int i2, int i3) {
        this.mEngineCallbackThread.sendMessage(50, new Object[]{Integer.valueOf(i)});
    }

    public void onGlobalChannelOnError(int i) {
        this.mEngineCallbackThread.sendMessage(6, new Object[]{Integer.valueOf(i)});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        if (com.wushuangtech.library.GlobalConfig.mIsServerAuth != false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        r7 = r6.mTokenLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        if (r6.mTokenExpiredAndExiting == false) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0022, code lost:
        com.wushuangtech.utils.OmniLog.w("Room Watcher -> authDoing, OnConfRefreshToken invoked! but failed! room exiting!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
        if (r9 != 0) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002b, code lost:
        r6.mRefreshToken = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002e, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002f, code lost:
        com.wushuangtech.utils.OmniLog.d("Room Watcher -> server authDoing, result token : " + r8 + " | code : " + r9 + " | remain : " + r10 + " | mask : " + r11);
        "VGhpcyBpcyBhbiBpbnZhbGlkIHRva2Vu77yB".equals(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r9 != 0) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0068, code lost:
        if ("VGhpcyBpcyBhbiBpbnZhbGlkIHRva2Vu77yB".equals(r8) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006a, code lost:
        if (r10 <= 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006c, code lost:
        notifyJoinChannelAuth(r6.mToken, r8, "", false, "");
        checkAuthenticateTime((long) (r10 * 1000));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007f, code lost:
        com.wushuangtech.utils.OmniLog.d("Room Watcher -> server authDoing, failed code : " + r9);
        r1 = r6.mToken;
        notifyJoinChannelAuth(r1, r8, "", true, "AUTH_ERROR_" + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onGlobalChannelRefreshToken(java.lang.String r7, java.lang.String r8, int r9, int r10, int r11) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            java.lang.String r1 = r6.mChannelName     // Catch:{ all -> 0x00b4 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00b4 }
            if (r1 != 0) goto L_0x00b2
            java.lang.String r1 = r6.mChannelName     // Catch:{ all -> 0x00b4 }
            boolean r7 = r1.equals(r7)     // Catch:{ all -> 0x00b4 }
            if (r7 != 0) goto L_0x0015
            goto L_0x00b2
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x00b4 }
            boolean r7 = com.wushuangtech.library.GlobalConfig.mIsServerAuth
            if (r7 != 0) goto L_0x001b
            return
        L_0x001b:
            java.lang.Object r7 = r6.mTokenLock
            monitor-enter(r7)
            boolean r0 = r6.mTokenExpiredAndExiting     // Catch:{ all -> 0x00af }
            if (r0 == 0) goto L_0x0029
            java.lang.String r8 = "Room Watcher -> authDoing, OnConfRefreshToken invoked! but failed! room exiting!"
            com.wushuangtech.utils.OmniLog.w(r8)     // Catch:{ all -> 0x00af }
            monitor-exit(r7)     // Catch:{ all -> 0x00af }
            return
        L_0x0029:
            if (r9 != 0) goto L_0x002e
            r0 = 1
            r6.mRefreshToken = r0     // Catch:{ all -> 0x00af }
        L_0x002e:
            monitor-exit(r7)     // Catch:{ all -> 0x00af }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Room Watcher -> server authDoing, result token : "
            r7.append(r0)
            r7.append(r8)
            java.lang.String r0 = " | code : "
            r7.append(r0)
            r7.append(r9)
            java.lang.String r0 = " | remain : "
            r7.append(r0)
            r7.append(r10)
            java.lang.String r0 = " | mask : "
            r7.append(r0)
            r7.append(r11)
            java.lang.String r7 = r7.toString()
            com.wushuangtech.utils.OmniLog.d(r7)
            java.lang.String r7 = "VGhpcyBpcyBhbiBpbnZhbGlkIHRva2Vu77yB"
            r7.equals(r8)
            if (r9 != 0) goto L_0x007f
            java.lang.String r7 = "VGhpcyBpcyBhbiBpbnZhbGlkIHRva2Vu77yB"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x00ae
            if (r10 <= 0) goto L_0x00ae
            java.lang.String r1 = r6.mToken
            java.lang.String r3 = ""
            r4 = 0
            java.lang.String r5 = ""
            r0 = r6
            r2 = r8
            r0.notifyJoinChannelAuth(r1, r2, r3, r4, r5)
            int r10 = r10 * 1000
            long r7 = (long) r10
            r6.checkAuthenticateTime(r7)
            goto L_0x00ae
        L_0x007f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = "Room Watcher -> server authDoing, failed code : "
            r7.append(r10)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            com.wushuangtech.utils.OmniLog.d(r7)
            java.lang.String r1 = r6.mToken
            java.lang.String r3 = ""
            r4 = 1
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = "AUTH_ERROR_"
            r7.append(r10)
            r7.append(r9)
            java.lang.String r5 = r7.toString()
            r0 = r6
            r2 = r8
            r0.notifyJoinChannelAuth(r1, r2, r3, r4, r5)
        L_0x00ae:
            return
        L_0x00af:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00af }
            throw r8
        L_0x00b2:
            monitor-exit(r0)     // Catch:{ all -> 0x00b4 }
            return
        L_0x00b4:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b4 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.EnterConfApiImpl.onGlobalChannelRefreshToken(java.lang.String, java.lang.String, int, int, int):void");
    }

    public void onGlobalConnectionStateChanged(String str, int i, int i2) {
        if (5 == i) {
            this.mEngineCallbackThread.sendMessage(42, new Object[0]);
        } else if (3 == i) {
            this.mEngineCallbackThread.sendMessage(53, new Object[0]);
        }
        this.mEngineCallbackThread.sendMessage(76, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public void onGlobalRtcStats(RtcStats rtcStats) {
        if (rtcStats != null) {
            String channelName = rtcStats.getChannelName();
            if (!TextUtils.isEmpty(channelName)) {
                synchronized (this.mLock) {
                    if (!TextUtils.isEmpty(this.mChannelName)) {
                        if (this.mChannelName.equals(channelName)) {
                            this.mEngineCallbackThread.sendMessage(18, new Object[]{rtcStats});
                        }
                    }
                }
            }
        }
    }

    public void OnGlobalConnectIdReport(String str) {
        if (this.mJoiningChannel) {
            configureLogReport();
        }
    }

    public void onGlobalRejoin(String str, int i) {
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    this.mEngineCallbackThread.sendMessage(91, new Object[]{str, Long.valueOf(this.mUid), Integer.valueOf(i)});
                }
            }
        }
    }

    private void configureLogReport() {
        String connectId = GlobalHolder.getInstance().getGlobalChannelConfig().getConnectId();
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(connectId) && TextUtils.isEmpty(this.mConnectId)) {
                if (!TextUtils.isEmpty(this.mChannelName)) {
                    String str = TAG;
                    OmniLog.d(str, "Configure connectId... : " + connectId);
                    String str2 = this.mChannelName;
                    this.mConnectId = connectId;
                    GlobalHolder.getInstance().initUserActionReporter(LocalSDKConstants.USER_ACTION_PREFIX_ENGINE, GlobalConfig.mAppId, this.mToken, str2, this.mUid, this.mRole, connectId);
                    ReportLogger initChannelEventReporter = GlobalHolder.getInstance().initChannelEventReporter(str2, this.mUid, this.mRole, connectId);
                    this.reportLogger = initChannelEventReporter;
                    initChannelEventReporter.reportEnterBegin(this.mRtmpUrl);
                }
            }
        }
    }

    public void onGlobalFirstRemoteAudioFrame(String str, long j, int i) {
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    this.mEngineCallbackThread.sendMessage(77, new Object[]{Long.valueOf(j), Integer.valueOf(i)});
                }
            }
        }
    }

    public void onGlobalFirstRemoteAudioDecoded(String str, long j, int i) {
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    GlobalHolder.getInstance().handleRtcEventReport(str, LogEvent.AUDIO_REMOTE_FIRST_FRAME_DECODED, Long.valueOf(j), Integer.valueOf(i));
                    this.mEngineCallbackThread.sendMessage(57, new Object[]{Long.valueOf(j), Integer.valueOf(i)});
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        if (r12 != 5) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r7.mEngineCallbackThread.sendMessage(32, new java.lang.Object[]{java.lang.Long.valueOf(r9), java.lang.Boolean.valueOf(r8)});
        r7.mEngineCallbackThread.sendMessage(79, new java.lang.Object[]{java.lang.Long.valueOf(r9), java.lang.Integer.valueOf(r11), java.lang.Integer.valueOf(r12), java.lang.Integer.valueOf(r13)});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onGlobalRemoteAudioStateChanged(java.lang.String r8, long r9, int r11, int r12, int r13) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.mLock
            monitor-enter(r0)
            java.lang.String r1 = r7.mChannelName     // Catch:{ all -> 0x0059 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0059 }
            if (r1 != 0) goto L_0x0057
            java.lang.String r1 = r7.mChannelName     // Catch:{ all -> 0x0059 }
            boolean r8 = r1.equals(r8)     // Catch:{ all -> 0x0059 }
            if (r8 != 0) goto L_0x0014
            goto L_0x0057
        L_0x0014:
            monitor-exit(r0)     // Catch:{ all -> 0x0059 }
            r8 = 5
            r0 = 1
            r1 = 0
            if (r12 != r8) goto L_0x001c
            r8 = r0
            goto L_0x001d
        L_0x001c:
            r8 = r1
        L_0x001d:
            com.wushuangtech.thread.EngineCallbackThread r2 = r7.mEngineCallbackThread
            r3 = 32
            r4 = 2
            java.lang.Object[] r5 = new java.lang.Object[r4]
            java.lang.Long r6 = java.lang.Long.valueOf(r9)
            r5[r1] = r6
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            r5[r0] = r8
            r2.sendMessage(r3, r5)
            com.wushuangtech.thread.EngineCallbackThread r8 = r7.mEngineCallbackThread
            r2 = 79
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            r3[r1] = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r11)
            r3[r0] = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)
            r3[r4] = r9
            r9 = 3
            java.lang.Integer r10 = java.lang.Integer.valueOf(r13)
            r3[r9] = r10
            r8.sendMessage(r2, r3)
            return
        L_0x0057:
            monitor-exit(r0)     // Catch:{ all -> 0x0059 }
            return
        L_0x0059:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0059 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.EnterConfApiImpl.onGlobalRemoteAudioStateChanged(java.lang.String, long, int, int, int):void");
    }

    public void onGlobalAudioBufferingStateChanged(String str, long j, int i, long j2) {
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    this.mEngineCallbackThread.sendMessage(95, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)});
                }
            }
        }
    }

    public void onGlobalFirstRemoteVideoDecoded(String str, long j, String str2, int i, int i2, int i3) {
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    this.mEngineCallbackThread.sendMessage(23, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                    this.mEngineCallbackThread.sendMessage(60, new Object[]{Long.valueOf(j), str2, Integer.valueOf(i), Integer.valueOf(i2)});
                }
            }
        }
    }

    public void onGlobalFirstRemoteVideoFrame(String str, long j, String str2, int i, int i2, int i3) {
        String str3 = str;
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    GlobalHolder.getInstance().handleRtcEventReport(str, LogEvent.VIDEO_REMOTE_FIRST_FRAME_DRAN, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                    this.mEngineCallbackThread.sendMessage(9, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                    this.mEngineCallbackThread.sendMessage(61, new Object[]{Long.valueOf(j), str2, Integer.valueOf(i), Integer.valueOf(i2)});
                }
            }
        }
    }

    public void onGlobalRemoteVideoStateChanged(String str, long j, int i, int i2, int i3) {
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    this.mEngineCallbackThread.sendMessage(78, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                }
            }
        }
    }

    public void onGlobalVideoSubscribeStateChanged(String str, long j, int i, int i2, int i3) {
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    this.mEngineCallbackThread.sendMessage(104, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                }
            }
        }
    }

    public void onGlobalLocalAudioStats(LocalAudioStats localAudioStats) {
        if (localAudioStats != null) {
            this.mEngineCallbackThread.sendMessage(21, new Object[]{localAudioStats});
        }
    }

    public void onGlobalLocalVideoStats(LocalVideoStats localVideoStats) {
        if (localVideoStats != null) {
            this.mEngineCallbackThread.sendMessage(12, new Object[]{localVideoStats});
        }
    }

    public void onGlobalRemoteAudioStats(String str, long j, RemoteAudioStats remoteAudioStats) {
        if (remoteAudioStats != null) {
            synchronized (this.mLock) {
                if (!TextUtils.isEmpty(this.mChannelName)) {
                    if (this.mChannelName.equals(str)) {
                        this.mEngineCallbackThread.sendMessage(22, new Object[]{remoteAudioStats});
                    }
                }
            }
        }
    }

    public void onGlobalRemoteVideoStats(String str, long j, RemoteVideoStats remoteVideoStats) {
        if (remoteVideoStats != null) {
            synchronized (this.mLock) {
                if (!TextUtils.isEmpty(this.mChannelName)) {
                    if (this.mChannelName.equals(str)) {
                        this.mEngineCallbackThread.sendMessage(13, new Object[]{remoteVideoStats});
                    }
                }
            }
        }
    }

    public void onGlobalChannelMediaRelayStateChanged(String str, int i, int i2) {
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    this.mEngineCallbackThread.sendMessage(97, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                }
            }
        }
    }

    public void onGlobalChannelMediaRelayEvent(String str, int i) {
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    this.mEngineCallbackThread.sendMessage(97, new Object[]{Integer.valueOf(i)});
                }
            }
        }
    }

    public void onGlobalCaptureVideoSize(int i, int i2) {
        this.mEngineCallbackThread.sendMessage(99, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public void onGlobalRemoteStreamSubscribeAdvice(String str, long j, int i, int i2) {
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    this.mEngineCallbackThread.sendMessage(100, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)});
                }
            }
        }
    }

    public void onGlobalRemoteTakeSnapshot(String str, long j, Bitmap bitmap) {
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    this.mEngineCallbackThread.sendMessage(101, new Object[]{Long.valueOf(j), bitmap});
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void OnGlobalChannelSessionId(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.mLock
            monitor-enter(r0)
            java.lang.String r1 = r4.mChannelName     // Catch:{ all -> 0x003c }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x003c }
            if (r1 != 0) goto L_0x003a
            java.lang.String r1 = r4.mChannelName     // Catch:{ all -> 0x003c }
            boolean r5 = r1.equals(r5)     // Catch:{ all -> 0x003c }
            if (r5 != 0) goto L_0x0014
            goto L_0x003a
        L_0x0014:
            java.lang.String r5 = "SESSION_WATCH"
            java.lang.String r1 = TAG     // Catch:{ all -> 0x003c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003c }
            r2.<init>()     // Catch:{ all -> 0x003c }
            java.lang.String r3 = "Recv engine session id = "
            r2.append(r3)     // Catch:{ all -> 0x003c }
            r2.append(r6)     // Catch:{ all -> 0x003c }
            java.lang.String r3 = ", engine = "
            r2.append(r3)     // Catch:{ all -> 0x003c }
            java.lang.String r3 = r4.mChannelName     // Catch:{ all -> 0x003c }
            r2.append(r3)     // Catch:{ all -> 0x003c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x003c }
            com.wushuangtech.utils.OmniLog.i(r5, r1, r2)     // Catch:{ all -> 0x003c }
            r4.mSessionId = r6     // Catch:{ all -> 0x003c }
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x003a:
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x003c:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.EnterConfApiImpl.OnGlobalChannelSessionId(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (com.wushuangtech.library.GlobalHolder.getInstance().getDataStreamManager(r4) != null) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        com.wushuangtech.utils.OmniLog.e(TAG, "Recv data stream failed... RtcDataStreamManager is null!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        r3.mEngineCallbackThread.sendMessage(75, new java.lang.Object[]{java.lang.Long.valueOf(r5), java.lang.Integer.valueOf(r7), r8});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void OnGlobalRecvAudioMsg(java.lang.String r4, long r5, int r7, byte[] r8) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLock
            monitor-enter(r0)
            java.lang.String r1 = r3.mChannelName     // Catch:{ all -> 0x0045 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0045 }
            if (r1 != 0) goto L_0x0043
            java.lang.String r1 = r3.mChannelName     // Catch:{ all -> 0x0045 }
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0045 }
            if (r1 != 0) goto L_0x0014
            goto L_0x0043
        L_0x0014:
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            com.wushuangtech.library.GlobalHolder r0 = com.wushuangtech.library.GlobalHolder.getInstance()
            com.wushuangtech.api.RtcDataStreamManager r4 = r0.getDataStreamManager(r4)
            if (r4 != 0) goto L_0x0027
            java.lang.String r4 = TAG
            java.lang.String r5 = "Recv data stream failed... RtcDataStreamManager is null!"
            com.wushuangtech.utils.OmniLog.e(r4, r5)
            return
        L_0x0027:
            com.wushuangtech.thread.EngineCallbackThread r4 = r3.mEngineCallbackThread
            r0 = 75
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r1[r2] = r5
            r5 = 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            r1[r5] = r6
            r5 = 2
            r1[r5] = r8
            r4.sendMessage(r0, r1)
            return
        L_0x0043:
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return
        L_0x0045:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.EnterConfApiImpl.OnGlobalRecvAudioMsg(java.lang.String, long, int, byte[]):void");
    }

    public void onGlobalNetworkQualityEvent(String str, long j, int i, int i2) {
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    this.mEngineCallbackThread.sendMessage(106, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)});
                }
            }
        }
    }

    public void OnVideoBufferingStateChanged(String str, long j, boolean z, int i, long j2) {
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    this.mEngineCallbackThread.sendMessage(92, new Object[]{Long.valueOf(j), Integer.valueOf(z ^ true ? 1 : 0), Long.valueOf(j2)});
                }
            }
        }
    }

    public void OnVideoPublishStateChanged(String str, int i, int i2, int i3) {
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    this.mEngineCallbackThread.sendMessage(102, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                }
            }
        }
    }

    public void OnAudioPublishStateChanged(String str, int i, int i2, int i3) {
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    this.mEngineCallbackThread.sendMessage(103, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                }
            }
        }
    }

    public void OnAudioSubscribeStateChanged(String str, long j, int i, int i2, int i3) {
        synchronized (this.mLock) {
            if (!TextUtils.isEmpty(this.mChannelName)) {
                if (this.mChannelName.equals(str)) {
                    this.mEngineCallbackThread.sendMessage(105, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                }
            }
        }
    }

    public void reportAudioRecError(ExternalAudioModule.RecordErrInfo recordErrInfo) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportAudioRecErr(recordErrInfo);
            }
        }
    }

    public void reportAudioPlayError() {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportAudioPlayErr();
            }
        }
    }

    public void reportMuteLocalErr(int i) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportMuteLocalErr(i);
            }
        }
    }

    public void reportEncodeInfos(int i, int i2, int i3, int i4, int i5, String str, boolean z) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportEncodeInfos(i, i2, i3, i4, i5, str, z);
            }
        }
    }

    public void reportCameraPreview(int i, int i2, int i3, int i4) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportCameraPreview(i, i2, i3, i4);
            }
        }
    }

    public void reportCreateVideoDecoder(String str, String str2) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportVideoDecoderCreated(str, str2);
            }
        }
    }

    public void reportVideoSettingParams(int i, int i2, int i3, int i4) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.reportVideoSettingParams(i, i2, i3, i4);
            }
        }
    }

    private void notifyJoinChannelAuth(String str, String str2, String str3, boolean z, String str4) {
        synchronized (ReportLogger.class) {
            ReportLogger reportLogger2 = this.reportLogger;
            if (reportLogger2 != null) {
                reportLogger2.ReportAuth(str, str2, str3, z, str4);
            }
        }
        if (z) {
            ChannelJoinResponse channelJoinResponse = new ChannelJoinResponse(JNIResponse.Result.ERR_CONF_AUTHENTICATION, this.mChannelName, this.mUid, this.mRole);
            GlobalHolder.getInstance().sendSyncGlobalMessage(1, channelJoinResponse);
        }
    }

    private void checkAuthenticateTime(long j) {
        synchronized (this) {
            OmniLog.d("Room Watcher -> authDoing, checkAuthenticateTime mChannelKeyTimer release!");
            Timer timer = this.mChannelKeyTimer;
            if (timer != null) {
                timer.cancel();
                this.mChannelKeyTimer = null;
            }
        }
        this.mChannelKeyTimer = new Timer(VideoStatus.THREAD_TOKEN_CHECK);
        AnonymousClass1 r3 = new TimerTask() {
            boolean willKickUser = false;

            public void run() {
                if (!this.willKickUser) {
                    OmniLog.d("Room Watcher -> authDoing, TimerTask first invoked! token will expire!");
                    EnterConfApiImpl.this.mEngineCallbackThread.sendMessage(24, new Object[0]);
                    synchronized (EnterConfApiImpl.this.mTokenLock) {
                        boolean unused = EnterConfApiImpl.this.mRefreshToken = false;
                    }
                    this.willKickUser = true;
                    return;
                }
                synchronized (EnterConfApiImpl.this.mTokenLock) {
                    OmniLog.d("Room Watcher -> authDoing, TimerTask second invoked! token refresh? : " + EnterConfApiImpl.this.mRefreshToken);
                    if (!EnterConfApiImpl.this.mRefreshToken) {
                        OmniLog.d("Room Watcher -> authDoing, token expire!");
                        boolean unused2 = EnterConfApiImpl.this.mTokenExpiredAndExiting = true;
                        synchronized (ReportLogger.class) {
                            if (EnterConfApiImpl.this.reportLogger != null) {
                                EnterConfApiImpl.this.reportLogger.reportKeyExpired();
                            }
                        }
                        EnterConfApiImpl.this.mEngineCallbackThread.sendMessage(6, new Object[]{Integer.valueOf(Constants.ERR_TOKEN_EXPIRED)});
                        EnterConfApiImpl.this.mEngineCallbackThread.sendMessage(76, new Object[]{1, 9});
                        EnterConfApiImpl.this.mEngineCallbackThread.sendMessage(90, new Object[0]);
                        EnterConfApiImpl enterConfApiImpl = EnterConfApiImpl.this;
                        enterConfApiImpl.exitRoom(enterConfApiImpl.mChannelName);
                    }
                }
            }
        };
        OmniLog.i("Room Watcher -> authDoing, new TimerTask : " + r3.toString());
        int i = (int) (j / 1000);
        OmniLog.i("Room Watcher -> authDoing, time : " + j + " | tokenTime : " + i);
        int i2 = 2;
        if (i >= 6) {
            int i3 = i / 6;
            if (i3 > 60) {
                i3 = 60;
            }
            if (i3 >= 2) {
                i2 = i3;
            }
            long j2 = (long) (i - i2);
            OmniLog.i("Room Watcher -> authDoing, firstExecute : " + j2 + " | delayTime : " + i2);
            this.mChannelKeyTimer.schedule(r3, j2 * 1000, (long) (i2 * 1000));
        } else if (i < 2) {
            this.mChannelKeyTimer.schedule(r3, 1000, 1000);
        } else {
            this.mChannelKeyTimer.schedule(r3, (long) ((i - 2) * 1000), 2000);
        }
    }

    private boolean validateJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            StringBuilder sb = new StringBuilder();
            sb.append("SEI -> json format success! ");
            sb.append(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            OmniLog.d(sb.toString());
            return true;
        } catch (Exception e) {
            OmniLog.e("SEI -> json format failed! msg : " + e.getLocalizedMessage());
            return false;
        }
    }

    public void updateVideoDefaultDevice(long j, boolean z) {
        UserDeviceConfig userDefaultDevice = GlobalHolder.getInstance().getUserDefaultDevice(j);
        OmniLog.pdw("DUAL_WATCH|EnterConfApiImpl(updateVideoDefaultDevice)", "sync device, uid : " + j + " | isAdd : " + z);
        if (userDefaultDevice != null) {
            String deviceId = userDefaultDevice.getDeviceId();
            String dualDeviceId = userDefaultDevice.getDualDeviceId();
            OmniLog.pdw("DUAL_WATCH|EnterConfApiImpl(updateVideoDefaultDevice)", "sync device, def udc id : " + deviceId + " | " + dualDeviceId);
            if (!TextUtils.isEmpty(deviceId)) {
                VideoJni.getInstance().VideoUpdateDefaultDevice(deviceId, z);
            }
            if (!TextUtils.isEmpty(dualDeviceId)) {
                VideoJni.getInstance().VideoUpdateDefaultDevice(dualDeviceId, z);
            }
        }
    }

    public void handleJoinChannelResponse(ChannelJoinResponse channelJoinResponse) {
        int i;
        int i2;
        int i3;
        String str;
        GlobalConfig.mIsLogining.set(false);
        JNIResponse.Result result = channelJoinResponse.getResult();
        GlobalHolder instance = GlobalHolder.getInstance();
        int i4 = 4;
        if (result != JNIResponse.Result.SUCCESS) {
            OmniLog.rw_i(TAG, "executeJoinRoomRequest -> handle join channel failed msg! " + result);
            GlobalConfig.mIsNeedSetRole = false;
            instance.getGlobalChannelConfig().updateJoiningChannelCount(false);
            instance.clearChannelDatas(this.mChannelName);
            resetMember();
            if (result == JNIResponse.Result.ERR_CONF_INVALIDPARAM) {
                i4 = 6;
            } else if (result == JNIResponse.Result.ERR_CONF_AUTHENTICATION) {
                this.mEngineCallbackThread.sendMessage(6, new Object[]{110, 4});
                i4 = 8;
            } else if (result == JNIResponse.Result.ERR_CONNECTION_CHANGED_BANNED_BY_SERVER) {
                this.mEngineCallbackThread.sendMessage(55, new Object[]{Long.valueOf(this.mUid), 111, 7200});
                i4 = 3;
            }
            this.mEngineCallbackThread.sendMessage(76, new Object[]{5, Integer.valueOf(i4)});
            return;
        }
        String str2 = TAG;
        OmniLog.rw_i(str2, "executeJoinRoomRequest -> handle join channel success msg!");
        String channelName = channelJoinResponse.getChannelName();
        long uid = channelJoinResponse.getUid();
        int role = channelJoinResponse.getRole();
        boolean z = GlobalConfig.mAudioLocalStreamEnabled;
        boolean z2 = GlobalConfig.mVideoEnabled;
        boolean z3 = GlobalConfig.mVideoLocalEnabled;
        boolean z4 = GlobalConfig.mVideoLocalStreamEnabled;
        boolean z5 = GlobalConfig.mIsEnableVideoDualStream;
        boolean z6 = z2;
        boolean z7 = z;
        long j = uid;
        int i5 = role;
        instance.initChannel(channelName, uid, role, this.mConnectId);
        RtcUserManager userManager = instance.getUserManager(channelName);
        User user = new User(uid, role);
        user.setEnableDualVideo(z5);
        userManager.putOrUpdateUser(user);
        userManager.setOwnerId(uid);
        OmniLog.rw_i(str2, "Add Local User " + user.toString());
        boolean z8 = z6 && z3;
        String valueOf = String.valueOf(uid);
        UserDeviceConfig userDeviceConfig = new UserDeviceConfig(uid, valueOf, z8, true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(userDeviceConfig);
        instance.getDeviceManager(channelName).updateUserDevice(uid, arrayList);
        initAudioStatus(z7);
        initVideoStatus(z6, z4);
        GlobalConfig.mIsInRoom.set(true);
        instance.initGlobalChannelAfterJoinChannel(this.mChannelName);
        AVStreamPublishHandler aVStreamPublishHandler = instance.getAVStreamPublishHandler();
        aVStreamPublishHandler.updateRole(GlobalConfig.ENGINE_NAME, role);
        aVStreamPublishHandler.updateAudioMuted(GlobalConfig.ENGINE_NAME, !z7);
        aVStreamPublishHandler.updateVideoMuted(GlobalConfig.ENGINE_NAME, !z4);
        GlobalConfig.mLocalOwnerUid = this.mUid;
        VideoStatistical globalVideoStatistical = instance.getGlobalVideoStatistical();
        if (globalVideoStatistical != null) {
            globalVideoStatistical.updateUserStatus(this.mChannelName, this.mUid, true);
        }
        if (role == 2 || !aVStreamPublishHandler.isPublishStats(GlobalConfig.ENGINE_NAME)) {
            str = str2;
            i3 = 2;
            i2 = 3;
            i = 5;
        } else {
            uploadLocalVideo(true);
            str = str2;
            i3 = 2;
            i2 = 3;
            i = 5;
            mixGuestVideo(uid, valueOf, true, this.mRtmpUrl);
        }
        OmniLog.rw_i(str, "start send callback...");
        EngineCallbackThread engineCallbackThread = this.mEngineCallbackThread;
        Object[] objArr = new Object[i3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = 1;
        engineCallbackThread.sendMessage(76, objArr);
        EngineCallbackThread engineCallbackThread2 = this.mEngineCallbackThread;
        Object[] objArr2 = new Object[i3];
        objArr2[0] = this.mChannelName;
        objArr2[1] = Long.valueOf(uid);
        engineCallbackThread2.sendMessage(i, objArr2);
        EngineCallbackThread engineCallbackThread3 = this.mEngineCallbackThread;
        Object[] objArr3 = new Object[i3];
        objArr3[0] = Long.valueOf(uid);
        objArr3[1] = Boolean.valueOf(userDeviceConfig.isUse());
        engineCallbackThread3.sendMessage(15, objArr3);
        EngineCallbackThread engineCallbackThread4 = this.mEngineCallbackThread;
        Object[] objArr4 = new Object[i2];
        objArr4[0] = Long.valueOf(uid);
        objArr4[1] = valueOf;
        objArr4[i3] = Boolean.valueOf(userDeviceConfig.isUse());
        engineCallbackThread4.sendMessage(59, objArr4);
        EngineCallbackThread engineCallbackThread5 = this.mEngineCallbackThread;
        Object[] objArr5 = new Object[4];
        objArr5[0] = Long.valueOf(uid);
        objArr5[1] = valueOf;
        objArr5[i3] = 0;
        objArr5[i2] = Boolean.valueOf(userDeviceConfig.isUse());
        engineCallbackThread5.sendMessage(69, objArr5);
    }

    private void initAudioStatus(boolean z) {
        executeMuteLocalAudio(!z);
        if (this.mAudioAllRemoteMuted) {
            RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.AUDIO_REMOTE_ALL_MUTED, this.mChannelName, true);
        }
    }

    private void initVideoStatus(boolean z, boolean z2) {
        if (!z && z2) {
            z2 = false;
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Update local video stream status, muted = ");
        sb.append(!z2);
        sb.append(", video module enabled = ");
        sb.append(z);
        OmniLog.i(OmniLog.CHANNEL_PUSH, str, sb.toString());
        executeMuteLocalVideo(!z2);
        if (this.mVideoAllRemoteMuted) {
            RoomJni.getInstance().MuteAllRemoteVideo(this.mChannelName, true);
        }
        CommonEventBean commonEventBean = new CommonEventBean();
        commonEventBean.mObjects = new Object[]{this.mChannelName, Long.valueOf(this.mUid), true};
        ExternalVideoModule.getInstance().resetVideoDecoderStatus(commonEventBean);
        GlobalVideoConfig globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig();
        ReportLogger reportLogger2 = this.reportLogger;
        if (!(reportLogger2 == null || globalVideoConfig == null)) {
            reportLogger2.reportVideoEncParams(globalVideoConfig.getSetVideoEncodeBitrate());
        }
        for (String next : this.mEngineCacheBean.mRtmpUrlList) {
            RtcPublishStreamManager rtcPublishStreamManager = GlobalHolder.getInstance().getRtcPublishStreamManager(this.mChannelName);
            if (rtcPublishStreamManager != null) {
                rtcPublishStreamManager.addPublishStreamUrl(next);
            }
        }
        this.mEngineCacheBean.mRtmpUrlList.clear();
    }

    private void reportLeaveChannel(RtcStats rtcStats) {
        if (rtcStats == null) {
            new RtcStats().totalDuration = 1;
            OmniLog.rw_w(TAG, "Report leave channel, but RtcStats is null... create a new RtcStats");
            return;
        }
        this.mEngineCallbackThread.sendMessage(76, new Object[]{1, 5});
        this.mEngineCallbackThread.sendMessage(16, new Object[]{rtcStats});
    }

    private void reportHeartbeat(long j) {
        int i = GlobalConfig.mLogReportInterval;
        if (i != 0) {
            this.mHeartbeatTmerTicks++;
            List<RtcHeartbeatReporter> rtcHeartbeatReporterForAll = GlobalHolder.getInstance().getRtcHeartbeatReporterForAll();
            if (this.mHeartbeatTmerTicks % 2 == 0 && rtcHeartbeatReporterForAll != null) {
                for (RtcHeartbeatReporter next : rtcHeartbeatReporterForAll) {
                    if (next.isJoinedChannel()) {
                        next.collectClientJsonLog(2000, (int) j);
                    } else {
                        return;
                    }
                }
            }
            if (this.mHeartbeatTmerTicks % i == 0) {
                LinkedList<VideoStuckStatsBean> stuck = ExternalVideoModule.getInstance().getStuck();
                if (rtcHeartbeatReporterForAll != null) {
                    for (RtcHeartbeatReporter next2 : rtcHeartbeatReporterForAll) {
                        if (next2.isJoinedChannel()) {
                            next2.reportClientJsonLog(stuck);
                        } else {
                            return;
                        }
                    }
                }
            }
            if (this.mHeartbeatTmerTicks >= 100000) {
                this.mHeartbeatTmerTicks = 0;
            }
        }
    }

    private static class RequestEventCallBackImpl implements RtcRequestServerManager.OnRequestEventCallBack {
        private RequestEventCallBackImpl() {
        }

        public void onJoinChannelEvent(JNIResponse jNIResponse) {
            GlobalHolder.getInstance().sendSyncGlobalMessage(1, jNIResponse);
        }
    }

    private static class LocalAsyncTask extends AsyncTask<Object, Void, Boolean> {
        private LocalAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(Object... objArr) {
            return objArr[0];
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean bool) {
            ((EnterConfApiImpl) EnterConfApi.getInstance()).handleSystemService(bool.booleanValue());
        }
    }

    /* access modifiers changed from: private */
    public void handleSystemService(boolean z) {
        if (this.mRegistered != z) {
            String str = TAG;
            OmniLog.i(str, "Handle system service, register? " + z + " | " + this.mRegistered + " | thread : " + Thread.currentThread().getId());
            this.mRegistered = z;
            Context context = GlobalHolder.getInstance().getContext();
            if (z) {
                if (this.mPhoneListener == null) {
                    this.mPhoneListener = new PhoneListener();
                }
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        telephonyManager.listen(this.mPhoneListener, 0);
                        telephonyManager.listen(this.mPhoneListener, 32);
                    }
                } catch (Exception e) {
                    OmniLog.e("TelephonyManager listen exception: " + e.getLocalizedMessage());
                }
                if (!this.regit_headset_receiver) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                    intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
                    intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
                    context.registerReceiver(this.mHeadSetReceiver, intentFilter);
                    this.regit_headset_receiver = true;
                }
                if (this.mCommonReceiver == null) {
                    this.mCommonReceiver = new CommonReceiver();
                    IntentFilter intentFilter2 = new IntentFilter();
                    intentFilter2.addAction("android.intent.action.CONFIGURATION_CHANGED");
                    intentFilter2.addAction("android.net.wifi.RSSI_CHANGED");
                    context.registerReceiver(this.mCommonReceiver, intentFilter2);
                }
                if (this.mOrientationEventListenerImpl == null) {
                    OrientationEventListenerImpl orientationEventListenerImpl = new OrientationEventListenerImpl(context);
                    this.mOrientationEventListenerImpl = orientationEventListenerImpl;
                    orientationEventListenerImpl.enable();
                    return;
                }
                return;
            }
            TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager2 != null) {
                telephonyManager2.listen(this.mPhoneListener, 0);
            }
            try {
                CommonReceiver commonReceiver = this.mCommonReceiver;
                if (commonReceiver != null) {
                    context.unregisterReceiver(commonReceiver);
                    this.mCommonReceiver = null;
                }
            } catch (Exception e2) {
                OmniLog.w("unregisterReceiver exception : " + e2.getLocalizedMessage());
            }
            if (this.regit_headset_receiver) {
                try {
                    context.unregisterReceiver(this.mHeadSetReceiver);
                } catch (Exception e3) {
                    OmniLog.w("HeadSetReceiver unregisterReceiver exception : " + e3.getLocalizedMessage());
                }
                HeadSetReceiver.abandonAudioFocus();
                HeadSetReceiver.reset();
                this.regit_headset_receiver = false;
            }
            OrientationEventListenerImpl orientationEventListenerImpl2 = this.mOrientationEventListenerImpl;
            if (orientationEventListenerImpl2 != null) {
                orientationEventListenerImpl2.disable();
                this.mOrientationEventListenerImpl = null;
            }
        }
    }
}
