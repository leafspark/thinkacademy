package com.wushuangtech.api;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.expansion.api.Constants;
import com.wushuangtech.expansion.bean.AudioVolumeInfo;
import com.wushuangtech.expansion.bean.LocalAudioStats;
import com.wushuangtech.expansion.bean.LocalVideoStats;
import com.wushuangtech.expansion.bean.RemoteAudioStats;
import com.wushuangtech.expansion.bean.RemoteVideoStats;
import com.wushuangtech.expansion.bean.RtcStats;
import com.wushuangtech.inter.OnRtcChannelHandlerEventCallBack;
import com.wushuangtech.inter.OnRtcGlobalServerMessageCallBack;
import com.wushuangtech.inter.RtcGlobalAVInterface;
import com.wushuangtech.jni.callback.BaseRtcChannelSignalCallBack;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.JNIResponse;
import com.wushuangtech.library.UserDeviceConfig;
import com.wushuangtech.library.video.VideoStatistical;
import com.wushuangtech.thread.EngineCallbackThread;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;

class RtcChannelEventManager implements OnRtcGlobalServerMessageCallBack {
    public static final int EVENT_ON_AUDIO_BUFFER_STATE_CHANGED = 203;
    public static final int EVENT_ON_AUDIO_PUBLISH_STATE_CHANGED = 204;
    public static final int EVENT_ON_AUDIO_REMOTE_FIRST_FRAME = 201;
    public static final int EVENT_ON_AUDIO_REMOTE_STATE_CHANGED = 202;
    public static final int EVENT_ON_AUDIO_REMOTE_STATUS = 200;
    public static final int EVENT_ON_AUDIO_SUBSCRIBE_STATE_CHANGED = 205;
    public static final int EVENT_ON_CHANNEL_MEDIA_RELAY_EVENT = 16;
    public static final int EVENT_ON_CHANNEL_MEDIA_RELAY_STATE_CHANGED = 15;
    public static final int EVENT_ON_CONNECT_LOST = 8;
    public static final int EVENT_ON_CONNECT_STATE_CHANGED = 9;
    public static final int EVENT_ON_JOIN_CHANNEL_END = 2;
    public static final int EVENT_ON_JOIN_CHANNEL_FAILED = 2;
    public static final int EVENT_ON_JOIN_CHANNEL_FIRST = 1;
    public static final int EVENT_ON_JOIN_CHANNEL_LEAVE = 3;
    public static final int EVENT_ON_JOIN_CHANNEL_SUCCESS = 1;
    public static final int EVENT_ON_NETWORK_QUALITY = 18;
    public static final int EVENT_ON_REJOIN_CHANNEL_SUCCESS = 14;
    public static final int EVENT_ON_REMOTE_STREAM_SUBSCRIBE_ADVICE_EVENT = 17;
    public static final int EVENT_ON_ROLE_CHANGED = 6;
    public static final int EVENT_ON_RTC_STATUS = 7;
    public static final int EVENT_ON_STREAM_MESSAGE_RECV = 12;
    public static final int EVENT_ON_TOKEN_REQUEST_REFRESH = 11;
    public static final int EVENT_ON_TOKEN_WILL_EXPIRE = 10;
    public static final int EVENT_ON_USER_JOINED = 4;
    public static final int EVENT_ON_USER_KICKED = 13;
    public static final int EVENT_ON_USER_OFFLINE = 5;
    public static final int EVENT_ON_VIDEO_BUFFERING_STATE_CHANGED = 303;
    public static final int EVENT_ON_VIDEO_CAPTURE_SIZE_CHANGED = 304;
    public static final int EVENT_ON_VIDEO_PUBLISH_STATE_CHANGED = 306;
    public static final int EVENT_ON_VIDEO_REMOTE_FIRST_FRAME = 302;
    public static final int EVENT_ON_VIDEO_REMOTE_STATUS = 300;
    public static final int EVENT_ON_VIDEO_REMOTE_STREAM_STATUS = 301;
    public static final int EVENT_ON_VIDEO_SUBSCRIBE_STATE_CHANGED = 307;
    public static final int EVENT_ON_VIDEO_TAKE_REMOTE_SNAPSHOT = 305;
    private final String TAG;
    private WeakReference<OnRtcChannelHandlerEventCallBack> mCallBack;
    /* access modifiers changed from: private */
    public final String mChannelName;
    private long mJoinChannelTimestamp;
    private boolean mJoinedChannel;
    private final LocalRtcChannelNativeCallBack mLocalRtcChannelNativeCallBack;
    private final WeakReference<RtcChannelAVManager> mRtcChannelAVManager;
    private final WeakReference<RtcChannelManager> mRtcChannelManager;

    public void onGlobalAudioVolumeIndication(AudioVolumeInfo[] audioVolumeInfoArr, int i) {
    }

    public void onGlobalCaptureVideoSize(int i, int i2) {
    }

    public void onGlobalFirstRemoteAudioFrame(String str, long j, int i) {
    }

    public void onGlobalFirstRemoteVideoDecoded(String str, long j, String str2, int i, int i2, int i3) {
    }

    public void onGlobalLocalAudioStats(LocalAudioStats localAudioStats) {
    }

    public void onGlobalLocalVideoStats(LocalVideoStats localVideoStats) {
    }

    public RtcChannelEventManager(String str, String str2, RtcChannelManager rtcChannelManager, RtcChannelAVManager rtcChannelAVManager) {
        String str3 = str + " - RtcChannelEventManager";
        this.TAG = str3;
        this.mChannelName = str2;
        this.mRtcChannelManager = new WeakReference<>(rtcChannelManager);
        this.mRtcChannelAVManager = new WeakReference<>(rtcChannelAVManager);
        LocalRtcChannelNativeCallBack localRtcChannelNativeCallBack = new LocalRtcChannelNativeCallBack(str3, this);
        this.mLocalRtcChannelNativeCallBack = localRtcChannelNativeCallBack;
        OmniLog.i(str3, "Created a new channel event manager : " + str2 + ", new callback : " + localRtcChannelNativeCallBack);
    }

    public LocalRtcChannelNativeCallBack getLocalRtcChannelNativeCallBack() {
        return this.mLocalRtcChannelNativeCallBack;
    }

    public void setJoinChannelTimestamp(long j) {
        this.mJoinChannelTimestamp = j;
    }

    public void setCallBack(OnRtcChannelHandlerEventCallBack onRtcChannelHandlerEventCallBack) {
        this.mCallBack = new WeakReference<>(onRtcChannelHandlerEventCallBack);
    }

    public void onChannelError(int i) {
        sendCallBack(2, Integer.valueOf(i));
    }

    public void onConnectionStateChanged(int i, int i2) {
        sendCallBack(9, Integer.valueOf(i), Integer.valueOf(i2));
    }

    private boolean checkChannelName(String str) {
        return !TextUtils.isEmpty(this.mChannelName) && this.mChannelName.equals(str);
    }

    public void onLeaveChannel(String str) {
        RtcGlobalAVInterface globalAVInterface;
        RtcStats rtcStats;
        this.mJoinedChannel = false;
        if (((RtcChannelManager) this.mRtcChannelManager.get()) != null && (globalAVInterface = GlobalHolder.getInstance().getGlobalAVInterface()) != null && (rtcStats = globalAVInterface.getRtcStats(str)) != null) {
            globalAVInterface.resetChannelAVStatistical(str);
            sendCallBack(9, 1, 5);
            sendCallBack(3, rtcStats);
        }
    }

    public void onTokenPrivilegeWillExpire(String str) {
        sendCallBack(10, str);
    }

    public void onRequestToken() {
        sendCallBack(11, new Object[0]);
        sendCallBack(2, Integer.valueOf(Constants.ERR_TOKEN_EXPIRED));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0094, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executingJoinChannelCallBack(com.wushuangtech.library.JNIResponse r8) {
        /*
            r7 = this;
            r0 = r8
            com.wushuangtech.jni.response.ChannelJoinResponse r0 = (com.wushuangtech.jni.response.ChannelJoinResponse) r0
            java.lang.String r1 = r0.getChannelName()
            int r2 = r0.getRole()
            java.lang.String r3 = r7.mChannelName
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x003e
            java.lang.String r3 = r7.mChannelName
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x003e
            java.lang.String r8 = "ROOM_WATCH"
            java.lang.String r0 = r7.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Recv join channel response, but channel name not same! local = "
            r2.append(r3)
            java.lang.String r3 = r7.mChannelName
            r2.append(r3)
            java.lang.String r3 = ", recv = "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.wushuangtech.utils.OmniLog.e((java.lang.String) r8, (java.lang.String) r0, (java.lang.String) r1)
            return
        L_0x003e:
            java.lang.ref.WeakReference<com.wushuangtech.api.RtcChannelManager> r3 = r7.mRtcChannelManager
            java.lang.Object r3 = r3.get()
            com.wushuangtech.api.RtcChannelManager r3 = (com.wushuangtech.api.RtcChannelManager) r3
            if (r3 != 0) goto L_0x0052
            java.lang.String r8 = "ROOM_WATCH"
            java.lang.String r0 = r7.TAG
            java.lang.String r1 = "Recv join channel response, but RtcChannelManager is null"
            com.wushuangtech.utils.OmniLog.e((java.lang.String) r8, (java.lang.String) r0, (java.lang.String) r1)
            return
        L_0x0052:
            java.lang.Object r4 = r3.getLock()
            com.wushuangtech.library.JNIResponse$Result r0 = r0.getResult()
            com.wushuangtech.library.JNIResponse$Result r5 = com.wushuangtech.library.JNIResponse.Result.SUCCESS
            r6 = 1
            if (r0 != r5) goto L_0x0061
            r0 = r6
            goto L_0x0062
        L_0x0061:
            r0 = 0
        L_0x0062:
            monitor-enter(r4)
            boolean r5 = r7.mJoinedChannel     // Catch:{ all -> 0x0095 }
            if (r5 == 0) goto L_0x0081
            java.lang.String r8 = "ROOM_WATCH"
            java.lang.String r0 = r7.TAG     // Catch:{ all -> 0x0095 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0095 }
            r2.<init>()     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = "Already join channel! "
            r2.append(r3)     // Catch:{ all -> 0x0095 }
            r2.append(r1)     // Catch:{ all -> 0x0095 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0095 }
            com.wushuangtech.utils.OmniLog.w((java.lang.String) r8, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0095 }
            monitor-exit(r4)     // Catch:{ all -> 0x0095 }
            return
        L_0x0081:
            r7.mJoinedChannel = r6     // Catch:{ all -> 0x0095 }
            r3.onEventJoinedChannelSuccess(r6, r0, r1)     // Catch:{ all -> 0x0095 }
            boolean r0 = r3.isMediaRelay()     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x0090
            r7.handleCallBackForJoinRelayChannel(r3, r8, r1)     // Catch:{ all -> 0x0095 }
            goto L_0x0093
        L_0x0090:
            r7.handleCallBackForJoinChannel(r3, r8, r1, r2)     // Catch:{ all -> 0x0095 }
        L_0x0093:
            monitor-exit(r4)     // Catch:{ all -> 0x0095 }
            return
        L_0x0095:
            r8 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0095 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.RtcChannelEventManager.executingJoinChannelCallBack(com.wushuangtech.library.JNIResponse):void");
    }

    public void onGlobalChannelOnError(int i) {
        RtcChannelManager rtcChannelManager = (RtcChannelManager) this.mRtcChannelManager.get();
        if (rtcChannelManager != null) {
            rtcChannelManager.onChannelError(i);
        }
    }

    public void onGlobalChannelRefreshToken(String str, String str2, int i, int i2, int i3) {
        RtcChannelManager rtcChannelManager;
        if ((TextUtils.isEmpty(this.mChannelName) || this.mChannelName.equals(str)) && (rtcChannelManager = (RtcChannelManager) this.mRtcChannelManager.get()) != null) {
            rtcChannelManager.onChannelRefreshToken(str2, i, i2, i3);
        }
    }

    public void onGlobalUserRoleChanged(String str, long j, int i) {
        RtcChannelManager rtcChannelManager;
        if ((TextUtils.isEmpty(this.mChannelName) || this.mChannelName.equals(str)) && (rtcChannelManager = (RtcChannelManager) this.mRtcChannelManager.get()) != null) {
            RtcChannelAVManager rtcChannelAVManager = (RtcChannelAVManager) this.mRtcChannelAVManager.get();
            if (rtcChannelAVManager != null) {
                rtcChannelAVManager.handleCallBackForRoleChanged(j, i);
            }
            sendCallBack(6, Integer.valueOf(rtcChannelManager.getOleRole()), Integer.valueOf(i));
        }
    }

    public void onGlobalConnectionStateChanged(String str, int i, int i2) {
        sendCallBack(9, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void onGlobalRtcStats(RtcStats rtcStats) {
        if (((RtcChannelManager) this.mRtcChannelManager.get()) != null && this.mJoinedChannel) {
            String channelName = rtcStats.getChannelName();
            if (TextUtils.isEmpty(this.mChannelName) || this.mChannelName.equals(channelName)) {
                sendCallBack(7, rtcStats);
            }
        }
    }

    public void OnGlobalConnectIdReport(String str) {
        RtcChannelManager rtcChannelManager = (RtcChannelManager) this.mRtcChannelManager.get();
        if (rtcChannelManager != null) {
            rtcChannelManager.onConnectIdReport(str);
        }
    }

    public void onGlobalRejoin(String str, int i) {
        RtcChannelManager rtcChannelManager;
        if (checkChannelName(str) && (rtcChannelManager = (RtcChannelManager) this.mRtcChannelManager.get()) != null) {
            sendCallBack(14, Long.valueOf(rtcChannelManager.getChannelUid()), Integer.valueOf(i));
        }
    }

    public void onGlobalFirstRemoteAudioDecoded(String str, long j, int i) {
        if ((TextUtils.isEmpty(this.mChannelName) || this.mChannelName.equals(str)) && ((RtcChannelManager) this.mRtcChannelManager.get()) != null) {
            sendCallBack(201, Long.valueOf(j), Integer.valueOf(calcElapsedTime()));
        }
    }

    public void onGlobalRemoteAudioStateChanged(String str, long j, int i, int i2, int i3) {
        if ((TextUtils.isEmpty(this.mChannelName) || this.mChannelName.equals(str)) && ((RtcChannelManager) this.mRtcChannelManager.get()) != null) {
            sendCallBack(202, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(calcElapsedTime()));
        }
    }

    public void onGlobalAudioBufferingStateChanged(String str, long j, int i, long j2) {
        if ((TextUtils.isEmpty(this.mChannelName) || this.mChannelName.equals(str)) && ((RtcChannelManager) this.mRtcChannelManager.get()) != null) {
            sendCallBack(203, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2));
        }
    }

    public void onGlobalFirstRemoteVideoFrame(String str, long j, String str2, int i, int i2, int i3) {
        if ((TextUtils.isEmpty(this.mChannelName) || this.mChannelName.equals(str)) && ((RtcChannelManager) this.mRtcChannelManager.get()) != null) {
            sendCallBack(302, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public void onGlobalRemoteVideoStateChanged(String str, long j, int i, int i2, int i3) {
        if ((TextUtils.isEmpty(this.mChannelName) || this.mChannelName.equals(str)) && ((RtcChannelManager) this.mRtcChannelManager.get()) != null) {
            sendCallBack(301, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(calcElapsedTime()));
        }
    }

    public void onGlobalVideoSubscribeStateChanged(String str, long j, int i, int i2, int i3) {
        if (checkChannelName(str)) {
            sendCallBack(307, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public void onGlobalRemoteAudioStats(String str, long j, RemoteAudioStats remoteAudioStats) {
        if ((TextUtils.isEmpty(this.mChannelName) || this.mChannelName.equals(str)) && ((RtcChannelManager) this.mRtcChannelManager.get()) != null && this.mJoinedChannel) {
            sendCallBack(200, remoteAudioStats);
        }
    }

    public void onGlobalRemoteVideoStats(String str, long j, RemoteVideoStats remoteVideoStats) {
        if (checkChannelName(str) && ((RtcChannelManager) this.mRtcChannelManager.get()) != null && this.mJoinedChannel) {
            sendCallBack(300, remoteVideoStats);
        }
    }

    public void onGlobalChannelMediaRelayStateChanged(String str, int i, int i2) {
        if (checkChannelName(str) && ((RtcChannelManager) this.mRtcChannelManager.get()) != null) {
            sendCallBack(15, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void onGlobalChannelMediaRelayEvent(String str, int i) {
        if (checkChannelName(str) && ((RtcChannelManager) this.mRtcChannelManager.get()) != null) {
            sendCallBack(16, Integer.valueOf(i));
        }
    }

    public void onGlobalRemoteStreamSubscribeAdvice(String str, long j, int i, int i2) {
        RtcChannelManager rtcChannelManager;
        if (checkChannelName(str) && (rtcChannelManager = (RtcChannelManager) this.mRtcChannelManager.get()) != null && rtcChannelManager.isJoinedChannel()) {
            sendCallBack(17, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public void onGlobalRemoteTakeSnapshot(String str, long j, Bitmap bitmap) {
        RtcChannelManager rtcChannelManager;
        if (checkChannelName(str) && (rtcChannelManager = (RtcChannelManager) this.mRtcChannelManager.get()) != null && rtcChannelManager.isJoinedChannel()) {
            sendCallBack(305, Long.valueOf(j), bitmap);
        }
    }

    public void OnGlobalChannelSessionId(String str, String str2) {
        RtcChannelManager rtcChannelManager;
        if (checkChannelName(str) && (rtcChannelManager = (RtcChannelManager) this.mRtcChannelManager.get()) != null) {
            rtcChannelManager.setSessionId(str2);
        }
    }

    public void OnGlobalRecvAudioMsg(String str, long j, int i, byte[] bArr) {
        RtcChannelManager rtcChannelManager;
        if (checkChannelName(str) && (rtcChannelManager = (RtcChannelManager) this.mRtcChannelManager.get()) != null && rtcChannelManager.isJoinedChannel()) {
            sendCallBack(12, Long.valueOf(j), Integer.valueOf(i), bArr);
        }
    }

    public void onGlobalNetworkQualityEvent(String str, long j, int i, int i2) {
        RtcChannelManager rtcChannelManager;
        if (checkChannelName(str) && (rtcChannelManager = (RtcChannelManager) this.mRtcChannelManager.get()) != null && rtcChannelManager.isJoinedChannel()) {
            sendCallBack(18, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    private void handleCallBackForJoinChannel(RtcChannelManager rtcChannelManager, JNIResponse jNIResponse, String str, int i) {
        long j;
        String str2 = str;
        JNIResponse.Result result = jNIResponse.getResult();
        GlobalHolder instance = GlobalHolder.getInstance();
        if (result != JNIResponse.Result.SUCCESS) {
            String str3 = this.TAG;
            OmniLog.rw_d(str3, "Handling join channel, join failed... " + result);
            instance.getGlobalChannelConfig().updateJoiningChannelCount(false);
            int convertResponseCode = convertResponseCode(result);
            if (convertResponseCode == 8) {
                sendCallBack(2, 110);
            }
            sendCallBack(9, 5, Integer.valueOf(convertResponseCode));
            return;
        }
        RtcChannelAVManager rtcChannelAVManager = (RtcChannelAVManager) this.mRtcChannelAVManager.get();
        if (rtcChannelAVManager == null) {
            OmniLog.rw_e(this.TAG, "Handling join channel failed, RtcChannelAVManager is null...");
            return;
        }
        boolean isDefaultChannel = rtcChannelManager.isDefaultChannel();
        if (!isDefaultChannel || !GlobalConfig.mIsInRoom.getAndSet(true)) {
            String str4 = this.TAG;
            OmniLog.rw_i(str4, "Handling join channel, join success... channelName:" + str2);
            long channelUid = rtcChannelManager.getChannelUid();
            String str5 = str;
            long j2 = channelUid;
            long j3 = channelUid;
            int i2 = i;
            instance.initChannel(str5, j2, i2, instance.getGlobalChannelConfig().getConnectId());
            boolean z = GlobalConfig.mVideoEnabled;
            boolean z2 = GlobalConfig.mVideoLocalEnabled;
            if (!rtcChannelManager.createLocalUserManager(str5, j3, i2, GlobalConfig.mIsEnableVideoDualStream)) {
                sendCallBack(2, 8);
            }
            instance.handleUserActionReport(LocalSDKConstants.USER_ACTION_PREFIX_CHANNEL, str2, 4, new Object[0]);
            UserDeviceConfig createLocalUserVideoDevice = rtcChannelAVManager.createLocalUserVideoDevice(str, j3, z, z2);
            boolean isUse = createLocalUserVideoDevice.isUse();
            String deviceId = createLocalUserVideoDevice.getDeviceId();
            rtcChannelManager.onEventJoinedChannelSuccess(2, true, str2);
            rtcChannelAVManager.onEventJoinedChannelSuccess(2, str2);
            instance.initGlobalChannelAfterJoinChannel(str2);
            int joinChannelSpentTime = rtcChannelManager.getJoinChannelSpentTime();
            VideoStatistical globalVideoStatistical = instance.getGlobalVideoStatistical();
            if (globalVideoStatistical != null) {
                j = j3;
                globalVideoStatistical.updateUserStatus(this.mChannelName, j, true);
            } else {
                j = j3;
            }
            GlobalConfig.mLocalOwnerUid = j;
            if (isDefaultChannel) {
                long j4 = j;
                configureDefaultChannel(rtcChannelAVManager, str, j, deviceId, i);
                EngineCallbackThread workerThread = instance.getWorkerThread();
                sendCallBack(1, Long.valueOf(j4), Integer.valueOf(joinChannelSpentTime));
                workerThread.sendMessage(15, new Object[]{Long.valueOf(j4), Boolean.valueOf(isUse)});
                workerThread.sendMessage(59, new Object[]{Long.valueOf(j4), deviceId, Boolean.valueOf(isUse)});
                workerThread.sendMessage(69, new Object[]{Long.valueOf(j4), deviceId, 0, Boolean.valueOf(isUse)});
                return;
            }
            sendCallBack(9, 3, 1);
            sendCallBack(1, Long.valueOf(j), Integer.valueOf(joinChannelSpentTime));
            return;
        }
        OmniLog.rw_e(this.TAG, "Handling join channel failed... already in channel...");
        sendCallBack(2, 8);
    }

    private void handleCallBackForJoinRelayChannel(RtcChannelManager rtcChannelManager, JNIResponse jNIResponse, String str) {
        JNIResponse.Result result = jNIResponse.getResult();
        if (result != JNIResponse.Result.SUCCESS) {
            String str2 = this.TAG;
            OmniLog.rw_d(str2, "Handling join channel, join failed... " + result);
            int convertResponseCode = convertResponseCode(result);
            if (convertResponseCode == 8) {
                sendCallBack(2, 110);
            }
            sendCallBack(9, 4, Integer.valueOf(convertResponseCode));
            return;
        }
        rtcChannelManager.onEventJoinedChannelSuccess(2, true, str);
        int joinChannelSpentTime = rtcChannelManager.getJoinChannelSpentTime();
        sendCallBack(1, Long.valueOf(rtcChannelManager.getChannelUid()), Integer.valueOf(joinChannelSpentTime));
    }

    /* access modifiers changed from: private */
    public void handleCallBackForUserJoined(String str, long j) {
        RtcChannelAVManager rtcChannelAVManagerRef;
        RtcChannelManager rtcChannelManager = (RtcChannelManager) this.mRtcChannelManager.get();
        if (rtcChannelManager != null && (rtcChannelAVManagerRef = rtcChannelManager.getRtcChannelAVManagerRef()) != null) {
            rtcChannelAVManagerRef.handleCallBackForUserJoined(str, j);
        }
    }

    /* access modifiers changed from: private */
    public void handleCallBackForUpdateVideoDev(String str, long j) {
        RtcChannelAVManager rtcChannelAVManagerRef;
        RtcChannelManager rtcChannelManager = (RtcChannelManager) this.mRtcChannelManager.get();
        if (rtcChannelManager != null && (rtcChannelAVManagerRef = rtcChannelManager.getRtcChannelAVManagerRef()) != null) {
            rtcChannelAVManagerRef.handleCallBackForUpdateVideoDev(str, j);
        }
    }

    private int convertResponseCode(JNIResponse.Result result) {
        if (result == JNIResponse.Result.ERR_CONF_INVALIDPARAM) {
            return 6;
        }
        if (result == JNIResponse.Result.ERR_CONF_AUTHENTICATION) {
            return 8;
        }
        return result == JNIResponse.Result.ERR_CONNECTION_CHANGED_BANNED_BY_SERVER ? 3 : 4;
    }

    private void configureDefaultChannel(RtcChannelAVManager rtcChannelAVManager, String str, long j, String str2, int i) {
        GlobalConfig.mLocalRoomName = str;
        if (i != 2) {
            rtcChannelAVManager.configureDefaultChannel(str, j, str2);
        }
    }

    /* access modifiers changed from: private */
    public int calcElapsedTime() {
        long j = this.mJoinChannelTimestamp;
        if (j == 0) {
            return 0;
        }
        return (int) (System.currentTimeMillis() - j);
    }

    /* access modifiers changed from: private */
    public void sendCallBack(int i, Object... objArr) {
        OnRtcChannelHandlerEventCallBack onRtcChannelHandlerEventCallBack = (OnRtcChannelHandlerEventCallBack) this.mCallBack.get();
        if (onRtcChannelHandlerEventCallBack != null) {
            if (i == 17) {
                onRtcChannelHandlerEventCallBack.onRemoteStreamSubscribeAdvice(objArr[0].longValue(), objArr[1].intValue(), objArr[2].intValue());
            } else if (i != 18) {
                switch (i) {
                    case 1:
                        onRtcChannelHandlerEventCallBack.onJoinChannelSuccess(objArr[0].longValue(), objArr[1].intValue());
                        return;
                    case 2:
                        onRtcChannelHandlerEventCallBack.onChannelError(objArr[0].intValue());
                        return;
                    case 3:
                        onRtcChannelHandlerEventCallBack.onLeaveChannel(objArr[0]);
                        return;
                    case 4:
                        onRtcChannelHandlerEventCallBack.onUserJoined(objArr[0].longValue(), objArr[1].intValue());
                        return;
                    case 5:
                        onRtcChannelHandlerEventCallBack.onUserOffline(objArr[0].longValue(), objArr[1].intValue());
                        return;
                    case 6:
                        onRtcChannelHandlerEventCallBack.onClientRoleChanged(objArr[0].intValue(), objArr[1].intValue());
                        return;
                    case 7:
                        onRtcChannelHandlerEventCallBack.onRtcStats(objArr[0]);
                        return;
                    case 8:
                        onRtcChannelHandlerEventCallBack.onConnectionLost();
                        return;
                    case 9:
                        onRtcChannelHandlerEventCallBack.onConnectionStateChanged(objArr[0].intValue(), objArr[1].intValue());
                        return;
                    case 10:
                        onRtcChannelHandlerEventCallBack.onTokenPrivilegeWillExpire(objArr[0]);
                        return;
                    case 11:
                        onRtcChannelHandlerEventCallBack.onRequestToken();
                        return;
                    case 12:
                        onRtcChannelHandlerEventCallBack.onStreamMessage(objArr[0].longValue(), objArr[1].intValue(), objArr[2]);
                        return;
                    case 13:
                        onRtcChannelHandlerEventCallBack.onUserKicked(objArr[0].longValue(), objArr[1].intValue(), objArr[2].intValue());
                        return;
                    case 14:
                        onRtcChannelHandlerEventCallBack.onRejoinChannelSuccess(objArr[0].longValue(), objArr[1].intValue());
                        return;
                    default:
                        switch (i) {
                            case 200:
                                onRtcChannelHandlerEventCallBack.onRemoteAudioStats(objArr[0]);
                                return;
                            case 201:
                                onRtcChannelHandlerEventCallBack.onFirstRemoteAudioDecoded(objArr[0].longValue(), objArr[1].intValue());
                                return;
                            case 202:
                                onRtcChannelHandlerEventCallBack.onRemoteAudioStateChanged(objArr[0].longValue(), objArr[1].intValue(), objArr[2].intValue(), objArr[3].intValue());
                                return;
                            case 203:
                                onRtcChannelHandlerEventCallBack.onAudioBufferingStateChanged(objArr[0].longValue(), objArr[1].intValue(), objArr[2].longValue());
                                return;
                            case 204:
                                onRtcChannelHandlerEventCallBack.onAudioPublishStateChanged(objArr[0].intValue(), objArr[1].intValue(), objArr[2].intValue());
                                return;
                            case 205:
                                onRtcChannelHandlerEventCallBack.onAudioSubscribeStateChanged(objArr[0].longValue(), objArr[1].intValue(), objArr[2].intValue(), objArr[3].intValue());
                                return;
                            default:
                                switch (i) {
                                    case 300:
                                        onRtcChannelHandlerEventCallBack.onRemoteVideoStats(objArr[0]);
                                        return;
                                    case 301:
                                        onRtcChannelHandlerEventCallBack.onRemoteVideoStateChanged(objArr[0].longValue(), objArr[1].intValue(), objArr[2].intValue(), objArr[3].intValue());
                                        return;
                                    case 302:
                                        onRtcChannelHandlerEventCallBack.onFirstRemoteVideoFrame(objArr[0].longValue(), objArr[1].intValue(), objArr[2].intValue(), objArr[3].intValue());
                                        return;
                                    case 303:
                                        onRtcChannelHandlerEventCallBack.OnVideoBufferingStateChanged(objArr[0].longValue(), objArr[1].intValue(), objArr[2].longValue());
                                        return;
                                    default:
                                        switch (i) {
                                            case 305:
                                                onRtcChannelHandlerEventCallBack.onTakeRemoteViewSnapshot(objArr[0].longValue(), objArr[1]);
                                                return;
                                            case 306:
                                                onRtcChannelHandlerEventCallBack.onVideoPublishStateChanged(objArr[0].intValue(), objArr[1].intValue(), objArr[2].intValue());
                                                return;
                                            case 307:
                                                onRtcChannelHandlerEventCallBack.onVideoSubscribeStateChanged(objArr[0].longValue(), objArr[1].intValue(), objArr[2].intValue(), objArr[3].intValue());
                                                return;
                                            default:
                                                return;
                                        }
                                }
                        }
                }
            } else {
                onRtcChannelHandlerEventCallBack.onNetworkQuality(objArr[0].longValue(), objArr[1].intValue(), objArr[2].intValue());
            }
        }
    }

    private static class LocalRtcChannelNativeCallBack extends BaseRtcChannelSignalCallBack {
        private final String TAG;
        private final String mChannelName;
        private final WeakReference<RtcChannelEventManager> mRtcChannelEventManager;

        public void OnVideoMixerCreate(String str, String str2, String str3) {
        }

        public LocalRtcChannelNativeCallBack(String str, RtcChannelEventManager rtcChannelEventManager) {
            String str2 = str + " - LocalRtcChannelNativeCallBack";
            this.TAG = str2;
            this.mRtcChannelEventManager = new WeakReference<>(rtcChannelEventManager);
            this.mChannelName = rtcChannelEventManager.mChannelName;
            OmniLog.i(str2, "Create a new channel callback receiver : " + this);
        }

        public void OnRoomMemberEnter(String str, long j, String str2, int i, int i2, boolean z, boolean z2) {
            RtcChannelEventManager rtcChannelEventManager = getRtcChannelEventManager(str);
            if (rtcChannelEventManager == null) {
                OmniLog.e(this.TAG, "RoomMemberEnter -> RtcChannelEventManager is null! ");
                return;
            }
            int access$100 = rtcChannelEventManager.calcElapsedTime();
            rtcChannelEventManager.handleCallBackForUserJoined(str, j);
            rtcChannelEventManager.sendCallBack(4, Long.valueOf(j), Integer.valueOf(access$100));
        }

        public void OnRoomMemberExit(String str, long j, int i) {
            RtcChannelEventManager rtcChannelEventManager = getRtcChannelEventManager(str);
            if (rtcChannelEventManager == null) {
                OmniLog.w(this.TAG, "RoomMemberExit -> RtcChannelEventManager is null! ");
                return;
            }
            rtcChannelEventManager.sendCallBack(5, Long.valueOf(j), Integer.valueOf(i + 200));
        }

        public void OnUpdateVideoDev(String str, long j, String str2) {
            RtcChannelEventManager rtcChannelEventManager = getRtcChannelEventManager(str);
            if (rtcChannelEventManager == null) {
                OmniLog.w(this.TAG, "RoomMemberEnter -> RtcChannelEventManager is null! ");
            } else {
                rtcChannelEventManager.handleCallBackForUpdateVideoDev(str, j);
            }
        }

        public void OnRoomDisconnected(String str) {
            RtcChannelEventManager rtcChannelEventManager = (RtcChannelEventManager) this.mRtcChannelEventManager.get();
            if (rtcChannelEventManager != null) {
                rtcChannelEventManager.sendCallBack(8, new Object[0]);
            }
        }

        public void OnRoomKicked(String str, long j, long j2, int i, String str2, int i2) {
            int i3 = i + 100;
            RtcChannelEventManager rtcChannelEventManager = getRtcChannelEventManager(str);
            if (rtcChannelEventManager != null) {
                rtcChannelEventManager.sendCallBack(13, Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(i2));
                if (i3 == 111) {
                    rtcChannelEventManager.sendCallBack(9, 5, 3);
                }
            }
        }

        public void OnVideoBufferingStateChanged(String str, long j, boolean z, int i, long j2) {
            RtcChannelEventManager rtcChannelEventManager = getRtcChannelEventManager(str);
            if (rtcChannelEventManager != null) {
                rtcChannelEventManager.sendCallBack(303, Long.valueOf(j), Integer.valueOf(z ^ true ? 1 : 0), Long.valueOf(j2));
            }
        }

        public void OnVideoPublishStateChanged(String str, int i, int i2, int i3) {
            RtcChannelEventManager rtcChannelEventManager;
            if (checkChannelName(str) && (rtcChannelEventManager = getRtcChannelEventManager(str)) != null) {
                rtcChannelEventManager.sendCallBack(306, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }
        }

        public void OnAudioPublishStateChanged(String str, int i, int i2, int i3) {
            RtcChannelEventManager rtcChannelEventManager;
            if (checkChannelName(str) && (rtcChannelEventManager = getRtcChannelEventManager(str)) != null) {
                rtcChannelEventManager.sendCallBack(204, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }
        }

        public void OnAudioSubscribeStateChanged(String str, long j, int i, int i2, int i3) {
            RtcChannelEventManager rtcChannelEventManager;
            if (checkChannelName(str) && (rtcChannelEventManager = getRtcChannelEventManager(str)) != null) {
                rtcChannelEventManager.sendCallBack(205, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }
        }

        private RtcChannelEventManager getRtcChannelEventManager(String str) {
            RtcChannelEventManager rtcChannelEventManager = (RtcChannelEventManager) this.mRtcChannelEventManager.get();
            if (rtcChannelEventManager == null) {
                OmniLog.e(this.TAG, "Get RtcChannelEventManager -> RtcChannelEventManager ref is null! ");
                return null;
            } else if (checkChannelName(str)) {
                return null;
            } else {
                return rtcChannelEventManager;
            }
        }

        private boolean checkChannelName(String str) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mChannelName)) {
                return true;
            }
            return true ^ str.equals(this.mChannelName);
        }
    }
}
