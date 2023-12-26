package com.wushuangtech.jni.callback;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.api.RtcPublishStreamManager;
import com.wushuangtech.api.RtcUserManager;
import com.wushuangtech.bean.LogEvent;
import com.wushuangtech.constants.RtcGlobalServerMessage;
import com.wushuangtech.expansion.bean.AudioVolumeInfo;
import com.wushuangtech.expansion.bean.LocalAudioStats;
import com.wushuangtech.expansion.bean.LocalVideoStats;
import com.wushuangtech.expansion.bean.RemoteAudioStats;
import com.wushuangtech.expansion.bean.RemoteVideoStats;
import com.wushuangtech.expansion.bean.RtcStats;
import com.wushuangtech.handler.AVRouterHandler;
import com.wushuangtech.handler.NetworkQualityHandler;
import com.wushuangtech.handler.RtcGlobalSignalPreHandler;
import com.wushuangtech.inter.OnRtcGlobalServerMessageCallBack;
import com.wushuangtech.inter.RtcGlobalAVInterface;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.JNIResponse;
import com.wushuangtech.library.ServerConfigManager;
import com.wushuangtech.library.User;
import com.wushuangtech.library.audio.RtcAudioVolumeHandler;
import com.wushuangtech.log.ReportLogger;
import com.wushuangtech.log.RtcHeartbeatReporter;
import com.wushuangtech.utils.OmniLog;

public class RtcGlobalSignalCallBackImpl extends BaseRtcChannelSignalCallBack implements RtcAudioVolumeHandler.OnAudioVolumeHandlerCallBack {
    private static final String TAG = "RtcGlobalSignalCallBackImpl";
    private final RtcChannelSignalDispatcher<OnRtcGlobalServerMessageCallBack> mChannelSignalDispatcher;
    private final Object mGlobalRtcEventLock = new Object();
    private final RtcAudioVolumeHandler mRtcAudioVolumeHandler = new RtcAudioVolumeHandler(this);
    private final RtcGlobalSignalPreHandler mRtcGlobalSignalPreHandler = new RtcGlobalSignalPreHandler();
    private final ServerConfigManager mServerConfigManager = new ServerConfigManager();

    public void OnAudioPublishStateChanged(String str, int i, int i2, int i3) {
    }

    public void OnAudioSubscribeStateChanged(String str, long j, int i, int i2, int i3) {
    }

    public void OnVideoPublishStateChanged(String str, int i, int i2, int i3) {
    }

    public RtcGlobalSignalCallBackImpl() {
        RtcChannelSignalDispatcher<OnRtcGlobalServerMessageCallBack> rtcChannelSignalDispatcher = new RtcChannelSignalDispatcher<>("RtcGlobalSignalCallBack");
        this.mChannelSignalDispatcher = rtcChannelSignalDispatcher;
        rtcChannelSignalDispatcher.setClassType(2);
    }

    public void addRtcGlobalServerMessageCallback(OnRtcGlobalServerMessageCallBack onRtcGlobalServerMessageCallBack) {
        synchronized (this.mGlobalRtcEventLock) {
            this.mChannelSignalDispatcher.addCallback(onRtcGlobalServerMessageCallBack);
        }
    }

    public void removeRtcGlobalServerMessageCallback(OnRtcGlobalServerMessageCallBack onRtcGlobalServerMessageCallBack) {
        synchronized (this.mGlobalRtcEventLock) {
            this.mChannelSignalDispatcher.removeCallback(onRtcGlobalServerMessageCallBack);
        }
    }

    public void clearResource() {
        this.mRtcAudioVolumeHandler.clearResource();
    }

    public void OnConnectServerResult(String str, int i, String str2) {
        ReportLogger rtcEventReporter = GlobalHolder.getInstance().getRtcEventReporter(str);
        if (rtcEventReporter != null && i != 0) {
            rtcEventReporter.ReportSimpleEnterFail(JNIResponse.Result.fromInt(i), i, str2);
        }
    }

    public void OnStartSendAudio() {
        GlobalConfig.mSpeakStatus = 3;
        if (!TextUtils.isEmpty(GlobalConfig.mAVUploadChannelName)) {
            GlobalHolder.getInstance().handleRtcEventReport(GlobalConfig.mAVUploadChannelName, LogEvent.AUDIO_LOCAL_START_SEND, new Object[0]);
        }
    }

    public void OnStopSendAudio() {
        GlobalConfig.mSpeakStatus = 1;
        if (!TextUtils.isEmpty(GlobalConfig.mAVUploadChannelName)) {
            GlobalHolder.getInstance().handleRtcEventReport(GlobalConfig.mAVUploadChannelName, LogEvent.AUDIO_LOCAL_STOP_SEND, new Object[0]);
        }
    }

    public void OnConfRefreshToken(String str, String str2, int i, int i2, int i3) {
        dispatchMessage("onGlobalChannelRefreshToken", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void OnGlobalSessionId(String str, String str2) {
        String str3 = TAG;
        OmniLog.i(OmniLog.SESSION_WATCH, str3, "Recv session id = " + str2 + ", channel = " + str);
        this.mRtcGlobalSignalPreHandler.handleSessionId(str, str2);
        dispatchMessage("OnGlobalChannelSessionId", str, str2);
    }

    public void OnRoomMemberExit(String str, long j, int i) {
        RtcPublishStreamManager rtcPublishStreamManager = GlobalHolder.getInstance().getRtcPublishStreamManager(str);
        if (rtcPublishStreamManager != null) {
            rtcPublishStreamManager.removeMixUserVideo(j);
        }
        dispatchMessage("onGlobalRemoteVideoStateChanged", str, Long.valueOf(j), 0, 7, 0);
    }

    public void OnUserRoleChanged(String str, long j, int i) {
        RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(str);
        if (userManager != null) {
            userManager.updateRole(j, i);
            OmniLog.d("Chanage role successfully! " + i);
            GlobalHolder instance = GlobalHolder.getInstance();
            ReportLogger rtcEventReporter = instance.getRtcEventReporter(str);
            if (rtcEventReporter != null) {
                rtcEventReporter.setRole(i);
            }
            RtcHeartbeatReporter rtcHeartbeatReporter = instance.getRtcHeartbeatReporter(str);
            if (rtcHeartbeatReporter != null) {
                rtcHeartbeatReporter.setRoleType(i);
            }
            dispatchMessage("onGlobalUserRoleChanged", str, Long.valueOf(j), Integer.valueOf(i));
        }
    }

    public void OnRoomDisconnected(String str) {
        dispatchMessage("onGlobalConnectionStateChanged", "", 4, 2);
    }

    public void OnReconnectTimeout() {
        dispatchMessage("onGlobalConnectionStateChanged", "", 5, 2);
    }

    public void OnRoomConnectSuccess() {
        this.mRtcGlobalSignalPreHandler.prefixHandleRoomConnectSuccess();
        dispatchMessage("onGlobalConnectionStateChanged", "", 3, 1);
    }

    public void OnRejoin(String str, int i) {
        dispatchMessage("onGlobalRejoin", str, Integer.valueOf(i));
    }

    public void OnAudioLevelReport(String str, long j, int i, int i2) {
        RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(str);
        if (userManager != null) {
            this.mRtcAudioVolumeHandler.handleAudioVolumeLevel(str, userManager.getOwnerId(), j, i, i2, ExternalAudioModule.getInstance().getAudioVadLevel(str, j));
        }
    }

    public void OnMixAudioLevelReport(String str, long j, int i, int i2) {
        this.mRtcAudioVolumeHandler.handleAudioMixVolumeLevel(str, j, i, i2);
    }

    public void OnRecvAudioMsg(String str, long j, int i, byte[] bArr) {
        NetworkQualityHandler netQualityHandler = GlobalHolder.getInstance().getNetQualityHandler();
        if (netQualityHandler == null || !netQualityHandler.parseUploadNetQuality(j, bArr)) {
            dispatchMessage("OnGlobalRecvAudioMsg", str, Long.valueOf(j), Integer.valueOf(i), bArr);
        }
    }

    public void OnAudioRemoteFirstFrame(String str, long j) {
        User user;
        RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(str);
        if (userManager != null && (user = userManager.getUser(j)) != null && !user.isAudioRemoteFirstPackRecv()) {
            userManager.updateAudioRemoteFirstPackRecv(j, true);
            dispatchMessage("onGlobalFirstRemoteAudioFrame", str, Long.valueOf(j), Integer.valueOf((int) (System.currentTimeMillis() - user.getJoinedTimestamp())));
        }
    }

    public void OnRemoteAudioMuted(String str, long j, boolean z) {
        User user;
        int i;
        int i2;
        RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(str);
        if (userManager != null && (user = userManager.getUser(j)) != null && user.isAudioMuted() != z) {
            userManager.updateAudioMuted(j, z);
            if (z) {
                i = 5;
                i2 = 0;
            } else {
                i = 6;
                i2 = 2;
            }
            dispatchMessage("onGlobalRemoteAudioStateChanged", str, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i), 0);
        }
    }

    public void OnRemoteVideoMuted(String str, long j, boolean z) {
        User user;
        int i;
        int i2;
        RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(str);
        if (userManager != null && (user = userManager.getUser(j)) != null && user.isVideoMuted() != z) {
            userManager.updateVideoMuted(j, z);
            if (z) {
                i = 5;
                i2 = 0;
            } else {
                i = 6;
                i2 = 2;
            }
            dispatchMessage("onGlobalRemoteVideoStateChanged", str, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i), 0);
        }
    }

    public void OnConnectIdReport(String str) {
        GlobalHolder.getInstance().getGlobalChannelConfig().setConnectId(str);
        dispatchMessage("OnGlobalConnectIdReport", str);
    }

    public void OnNetTestQuality(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        GlobalConfig.mNetTestSigStrength = i7;
        GlobalConfig.mNetTestSigLost = i4;
        GlobalConfig.mNetTestSigQuality = i;
    }

    public void OnUpdateDevParam(String str) {
        this.mServerConfigManager.updateServerConfig(str);
    }

    public void OnAudioUpstreamStatus(String str, long j, int i) {
        RtcGlobalAVInterface globalAVInterface;
        if (GlobalHolder.getInstance().isJoinedChannel() && (globalAVInterface = GlobalHolder.getInstance().getGlobalAVInterface()) != null) {
            AVRouterHandler aVRouterHandler = globalAVInterface.getAVRouterHandler();
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            aVRouterHandler.updateAVUpstreamStatus(z);
        }
    }

    public void OnRemoteStreamSubscribeAdvice(String str, long j, int i, int i2) {
        dispatchMessage("onGlobalRemoteStreamSubscribeAdvice", str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void OnVideoSubscribeStateChanged(String str, long j, int i, int i2, int i3) {
        dispatchMessage("onGlobalVideoSubscribeStateChanged", str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void OnMediaRelayModeUpdate(int i) {
        GlobalConfig.mRelayMode = i;
    }

    public void OnMediaRelayStateChanged(String str, String str2, int i, int i2) {
        GlobalHolder.getInstance().handleRtcEventReport(str2, LogEvent.CHANNEL_MEDIA_RELAY_STATE2, str, str2, Integer.valueOf(i), Integer.valueOf(i2));
        dispatchMessage("onGlobalChannelMediaRelayStateChanged", str2, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void OnMediaRelayEvent(String str, String str2, int i) {
        dispatchMessage("onGlobalChannelMediaRelayEvent", str2, Integer.valueOf(i));
    }

    public void OnVideoMixerCreate(String str, String str2, String str3) {
        GlobalHolder.getInstance().addMixDeviceId(str, str2);
    }

    public void reportAudioVolumeEvent(AudioVolumeInfo[] audioVolumeInfoArr, int i) {
        if (audioVolumeInfoArr != null) {
            dispatchMessage("onGlobalAudioVolumeIndication", audioVolumeInfoArr, Integer.valueOf(i));
        }
    }

    private void onError(int i) {
        if (i != 1005) {
            dispatchMessage("onGlobalChannelOnError", Integer.valueOf(i));
        }
    }

    public void onConnectionStateChanged(int i, int i2) {
        dispatchMessage("onGlobalConnectionStateChanged", "", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void onRtcStats(RtcStats rtcStats) {
        dispatchMessage("onGlobalRtcStats", rtcStats);
    }

    public void onFirstRemoteAudioDecodeded(String str, long j) {
        dispatchMessage("onGlobalFirstRemoteAudioDecodeded", str, Long.valueOf(j), 0);
    }

    public void onFirstRemoteVideoDecoded(String str, long j, String str2, int i, int i2, int i3) {
        User user;
        String str3 = str;
        long j2 = j;
        RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(str);
        if (!(userManager == null || (user = userManager.getUser(j2)) == null || user.isVideoFirstReportDecoded())) {
            GlobalHolder.getInstance().handleRtcEventReport(str, LogEvent.VIDEO_REMOTE_FIRST_FRAME_DECODED, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            userManager.updateVideoFirstDecodedReport(j2);
        }
        dispatchMessage("onGlobalFirstRemoteVideoDecoded", str3, Long.valueOf(j), str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void onFirstRemoteVideoFrame(String str, long j, String str2, int i, int i2, int i3) {
        dispatchMessage("onGlobalRemoteVideoStateChanged", str, Long.valueOf(j), 2, 0, Integer.valueOf(i3));
        dispatchMessage("onGlobalFirstRemoteVideoFrame", str, Long.valueOf(j), str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void onRemoteVideoStateChanged(String str, long j, int i, int i2, int i3) {
        dispatchMessage("onGlobalRemoteVideoStateChanged", str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void onLocalAudioStats(LocalAudioStats localAudioStats) {
        dispatchMessage("onGlobalLocalAudioStats", localAudioStats);
    }

    public void onLocalVideoStats(LocalVideoStats localVideoStats) {
        dispatchMessage("onGlobalLocalVideoStats", localVideoStats);
    }

    public void onRemoteAudioStats(String str, long j, RemoteAudioStats remoteAudioStats) {
        dispatchMessage("onGlobalRemoteAudioStats", str, Long.valueOf(j), remoteAudioStats);
    }

    public void onRemoteVideoStats(String str, long j, RemoteVideoStats remoteVideoStats) {
        dispatchMessage("onGlobalRemoteVideoStats", str, Long.valueOf(j), remoteVideoStats);
    }

    /* renamed from: com.wushuangtech.jni.callback.RtcGlobalSignalCallBackImpl$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$wushuangtech$constants$RtcGlobalServerMessage;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.wushuangtech.constants.RtcGlobalServerMessage[] r0 = com.wushuangtech.constants.RtcGlobalServerMessage.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$wushuangtech$constants$RtcGlobalServerMessage = r0
                com.wushuangtech.constants.RtcGlobalServerMessage r1 = com.wushuangtech.constants.RtcGlobalServerMessage.NETWORK_CONNECT_STATE_CHANGED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$wushuangtech$constants$RtcGlobalServerMessage     // Catch:{ NoSuchFieldError -> 0x001d }
                com.wushuangtech.constants.RtcGlobalServerMessage r1 = com.wushuangtech.constants.RtcGlobalServerMessage.NETWORK_QUALITY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$wushuangtech$constants$RtcGlobalServerMessage     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.wushuangtech.constants.RtcGlobalServerMessage r1 = com.wushuangtech.constants.RtcGlobalServerMessage.CHANNEL_ON_ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$wushuangtech$constants$RtcGlobalServerMessage     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.wushuangtech.constants.RtcGlobalServerMessage r1 = com.wushuangtech.constants.RtcGlobalServerMessage.AUDIO_BUFFER_STATE_CHANGED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$wushuangtech$constants$RtcGlobalServerMessage     // Catch:{ NoSuchFieldError -> 0x003e }
                com.wushuangtech.constants.RtcGlobalServerMessage r1 = com.wushuangtech.constants.RtcGlobalServerMessage.VIDEO_REMOTE_FIRST_FRAME_DECODED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$wushuangtech$constants$RtcGlobalServerMessage     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.wushuangtech.constants.RtcGlobalServerMessage r1 = com.wushuangtech.constants.RtcGlobalServerMessage.VIDEO_REMOTE_FIRST_FRAME_DRAN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$wushuangtech$constants$RtcGlobalServerMessage     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.wushuangtech.constants.RtcGlobalServerMessage r1 = com.wushuangtech.constants.RtcGlobalServerMessage.VIDEO_REMOTE_STATE_CHANGED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$wushuangtech$constants$RtcGlobalServerMessage     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.wushuangtech.constants.RtcGlobalServerMessage r1 = com.wushuangtech.constants.RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_STATE_CHANGED     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$wushuangtech$constants$RtcGlobalServerMessage     // Catch:{ NoSuchFieldError -> 0x006c }
                com.wushuangtech.constants.RtcGlobalServerMessage r1 = com.wushuangtech.constants.RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_EVENT     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$wushuangtech$constants$RtcGlobalServerMessage     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.wushuangtech.constants.RtcGlobalServerMessage r1 = com.wushuangtech.constants.RtcGlobalServerMessage.VIDEO_LOCAL_CAP_SIZE_CHANGED     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$wushuangtech$constants$RtcGlobalServerMessage     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.wushuangtech.constants.RtcGlobalServerMessage r1 = com.wushuangtech.constants.RtcGlobalServerMessage.VIDEO_REMOTE_TAKE_SNAPSHOT     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.jni.callback.RtcGlobalSignalCallBackImpl.AnonymousClass1.<clinit>():void");
        }
    }

    public void recvServerMessage(RtcGlobalServerMessage rtcGlobalServerMessage, Object... objArr) {
        switch (AnonymousClass1.$SwitchMap$com$wushuangtech$constants$RtcGlobalServerMessage[rtcGlobalServerMessage.ordinal()]) {
            case 1:
                onConnectionStateChanged(objArr[0].intValue(), objArr[1].intValue());
                return;
            case 2:
                onNetworkQuality(objArr[0], objArr[1].longValue(), objArr[2].intValue(), objArr[3].intValue());
                return;
            case 3:
                onError(objArr[0].intValue());
                return;
            case 4:
                onAudioBufferingStateChanged(objArr[0], objArr[1].longValue(), objArr[2].intValue(), objArr[3].longValue());
                return;
            case 5:
                onFirstRemoteVideoDecoded(objArr[0], objArr[1].longValue(), objArr[2], objArr[3].intValue(), objArr[4].intValue(), objArr[5].intValue());
                return;
            case 6:
                onFirstRemoteVideoFrame(objArr[0], objArr[1].longValue(), objArr[2], objArr[3].intValue(), objArr[4].intValue(), objArr[5].intValue());
                return;
            case 7:
                onRemoteVideoStateChanged(objArr[0], objArr[1].longValue(), objArr[2].intValue(), objArr[3].intValue(), objArr[4].intValue());
                return;
            case 8:
                onChannelMediaRelayStateChanged(objArr[0], objArr[1].intValue(), objArr[2].intValue());
                return;
            case 9:
                onChannelMediaRelayEvent(objArr[0], objArr[1].intValue());
                return;
            case 10:
                onLocalCapSizeChanged(objArr[0].intValue(), objArr[1].intValue());
                return;
            case 11:
                onTakeRemoteViewSnapshot(objArr[0], objArr[1].longValue(), objArr[2]);
                return;
            default:
                return;
        }
    }

    private void onNetworkQuality(String str, long j, int i, int i2) {
        dispatchMessage("onGlobalNetworkQualityEvent", str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
    }

    private void onTakeRemoteViewSnapshot(String str, long j, Bitmap bitmap) {
        dispatchMessage("onGlobalRemoteTakeSnapshot", str, Long.valueOf(j), bitmap);
    }

    private void onAudioBufferingStateChanged(String str, long j, int i, long j2) {
        dispatchMessage("onGlobalAudioBufferingStateChanged", str, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2));
    }

    private void onChannelMediaRelayStateChanged(String str, int i, int i2) {
        dispatchMessage("onGlobalChannelMediaRelayStateChanged", str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    private void onChannelMediaRelayEvent(String str, int i) {
        dispatchMessage("onGlobalChannelMediaRelayEvent", str, Integer.valueOf(i));
    }

    private void onLocalCapSizeChanged(int i, int i2) {
        dispatchMessage("onGlobalCaptureVideoSize", Integer.valueOf(i), Integer.valueOf(i2));
    }

    private void dispatchMessage(Object... objArr) {
        dispatchMessage((String) null, objArr);
    }

    private void dispatchMessage(String str, Object... objArr) {
        this.mChannelSignalDispatcher.receiveChannelSignalEventWidthName(str, objArr);
    }
}
