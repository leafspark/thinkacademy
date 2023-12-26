package com.wushuangtech.api;

import android.text.TextUtils;
import android.util.LongSparseArray;
import com.wushuangtech.bean.AVStreamConfigBean;
import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.bean.InterCorrectUserBean;
import com.wushuangtech.bean.InterCorrectionEnum;
import com.wushuangtech.bean.RtcChannelConfigBean;
import com.wushuangtech.bean.VideoRemoteStreamType;
import com.wushuangtech.broadcast.HeadSetReceiver;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.jni.VideoJni;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.RtcInvokeSafetyChecker;
import com.wushuangtech.library.User;
import com.wushuangtech.library.UserDeviceConfig;
import com.wushuangtech.library.video.VideoDualStreamManager;
import com.wushuangtech.log.RtcHeartbeatReporter;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class RtcChannelAVManager {
    private static final boolean CONFIG_AUDIO_LOCAL_MUTE = true;
    private static final boolean CONFIG_VIDEO_LOCAL_MUTE = true;
    private static final String TAG = "RtcChannelAVManager";
    private List<AVStreamConfigBean> mAVStreamConfigBeans = new ArrayList();
    private boolean mAudioAllRemoteMuted;
    private boolean mAudioMuted = true;
    private final String mChannelName;
    private boolean mDefaultAllRemoteAudioMuted;
    private boolean mDefaultAllRemoteVideoMuted;
    private HeadSetReceiver mHeadsetReceiver;
    private boolean mHeadsetReceiverInited;
    private boolean mLocalVideoUpload;
    private final Object mLock = new Object();
    private WeakReference<RtcChannelManager> mRtcChannelManagerRef;
    private final RtcInvokeSafetyChecker mRtcInvokeSafetyChecker = new RtcInvokeSafetyChecker();
    private boolean mVideoAllRemoteMuted;
    private boolean mVideoMuted = true;

    public void configureDefaultChannel(String str, long j, String str2) {
    }

    public RtcChannelAVManager(String str) {
        this.mChannelName = str;
    }

    public void setRtcChannelManager(RtcChannelManager rtcChannelManager) {
        this.mRtcChannelManagerRef = new WeakReference<>(rtcChannelManager);
    }

    public void configJoinChannel(RtcChannelConfigBean rtcChannelConfigBean) {
        this.mDefaultAllRemoteAudioMuted = !rtcChannelConfigBean.mAutoSubscribeAudio;
        this.mDefaultAllRemoteVideoMuted = !rtcChannelConfigBean.mAutoSubscribeVideo;
    }

    public void leaveChannel() {
        this.mLocalVideoUpload = false;
        synchronized (this.mLock) {
            this.mAudioMuted = true;
            this.mVideoMuted = true;
            this.mAudioAllRemoteMuted = false;
            this.mVideoAllRemoteMuted = false;
            this.mDefaultAllRemoteAudioMuted = false;
            this.mDefaultAllRemoteVideoMuted = false;
        }
    }

    public void destroy(boolean z) {
        leaveChannel();
        if (z) {
            ((ExternalAudioModuleImpl) ExternalAudioModule.getInstance()).StopCapture();
            List<AVStreamConfigBean> list = this.mAVStreamConfigBeans;
            if (list != null) {
                list.clear();
                this.mAVStreamConfigBeans = null;
            }
        }
        WeakReference<RtcChannelManager> weakReference = this.mRtcChannelManagerRef;
        if (weakReference != null) {
            weakReference.clear();
            this.mRtcChannelManagerRef = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void checkAVStreamStatus(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        initAudioStatus();
        initVideoStatus();
        checkLocalVideoUpload();
    }

    private void initVideoStatus() {
        updateVideoMuteStats();
        if (this.mVideoAllRemoteMuted) {
            RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.VIDEO_REMOTE_ALL_MUTED, this.mChannelName, true);
        }
    }

    private void initAudioStatus() {
        updateAudioMuteStats();
        if (this.mAudioAllRemoteMuted) {
            RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.AUDIO_REMOTE_ALL_MUTED, this.mChannelName, true);
        }
    }

    public void startAudioCapture() {
        ((ExternalAudioModuleImpl) ExternalAudioModule.getInstance()).StartSafetyCapture();
    }

    public void stopAudioCapture() {
        ((ExternalAudioModuleImpl) ExternalAudioModule.getInstance()).StopCapture();
    }

    public UserDeviceConfig createLocalUserVideoDevice(String str, long j, boolean z, boolean z2) {
        UserDeviceConfig userDeviceConfig = new UserDeviceConfig(j, String.valueOf(j), z && z2, true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(userDeviceConfig);
        RtcDeviceManager deviceManager = GlobalHolder.getInstance().getDeviceManager(str);
        if (deviceManager == null) {
            return null;
        }
        deviceManager.updateUserDevice(j, arrayList);
        return userDeviceConfig;
    }

    public void uploadLocalVideo(boolean z) {
        if (z != this.mLocalVideoUpload) {
            RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(this.mChannelName);
            if (userManager == null) {
                OmniLog.e("Upload local video failed, RtcUserManager is null... " + this.mChannelName);
                return;
            }
            RtcDeviceManager deviceManager = GlobalHolder.getInstance().getDeviceManager(this.mChannelName);
            if (deviceManager == null) {
                OmniLog.e("Upload local video failed, RtcDeviceManager is null... " + this.mChannelName);
                return;
            }
            long ownerId = userManager.getOwnerId();
            UserDeviceConfig videoDeviceForDefault = deviceManager.getVideoDeviceForDefault(ownerId);
            if (videoDeviceForDefault == null) {
                OmniLog.e("Upload local video failed, UserDeviceConfig is null... " + this.mChannelName + " | " + ownerId);
                return;
            }
            OmniLog.i(OmniLog.CHANNEL_PUSH, TAG, "Upload local video success... " + this.mChannelName + " | " + ownerId + " | " + z + " | " + ((RtcChannelManager) this.mRtcChannelManagerRef.get()).isJoinedChannel() + " | " + videoDeviceForDefault.getDeviceId());
            this.mLocalVideoUpload = z;
            RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.UPLOAD_VIDEO, this.mChannelName, videoDeviceForDefault.getDeviceId(), Boolean.valueOf(z));
        }
    }

    public void mixUserVideoStream(String str, long j, String str2, boolean z) {
        for (AVStreamConfigBean next : this.mAVStreamConfigBeans) {
            if (next.mTranscodingEnabled) {
                VideoJni.getInstance().RtmpAddVideo(str, j, str2, z ? 1 : -1, next.mStreamUrl);
            }
        }
    }

    public int muteRemoteAudioStream(long j, boolean z) {
        return muteRemoteAVStream(j, z, true);
    }

    public int muteAllRemoteVideoStreams(boolean z) {
        RtcChannelManager rtcChannelManager = getRtcChannelManager();
        if (rtcChannelManager == null) {
            return -1;
        }
        if (rtcChannelManager.isJoiningChannel()) {
            this.mVideoAllRemoteMuted = z;
            return 0;
        } else if (!rtcChannelManager.isJoinedChannel()) {
            return -3;
        } else {
            RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.VIDEO_REMOTE_ALL_MUTED, this.mChannelName, Boolean.valueOf(z));
            return 0;
        }
    }

    public int muteRemoteVideoStream(long j, boolean z) {
        return muteRemoteAVStream(j, z, false);
    }

    private int muteRemoteAVStream(long j, boolean z, boolean z2) {
        UserDeviceConfig videoDeviceForDefault;
        long j2 = j;
        boolean z3 = z;
        boolean z4 = z2;
        synchronized (this.mLock) {
            RtcChannelManager rtcChannelManager = getRtcChannelManager();
            int i = -1;
            if (rtcChannelManager == null) {
                return -1;
            }
            InterCorrectionManager interCorrectionManager = GlobalHolder.getInstance().getInterCorrectionManager();
            if (interCorrectionManager == null) {
                return -3;
            }
            RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(this.mChannelName);
            boolean isUserExist = userManager != null ? userManager.isUserExist(j2) : false;
            if (rtcChannelManager.isJoinedChannel() && isUserExist) {
                if (z4) {
                    RoomJni.getInstance().MuteRemoteAudio(this.mChannelName, j2, z3);
                } else {
                    String str = null;
                    RtcDeviceManager deviceManager = GlobalHolder.getInstance().getDeviceManager(this.mChannelName);
                    if (!(deviceManager == null || (videoDeviceForDefault = deviceManager.getVideoDeviceForDefault(j2)) == null)) {
                        str = videoDeviceForDefault.getDeviceId();
                    }
                    String str2 = str;
                    if (!TextUtils.isEmpty(str2)) {
                        if (EnterConfApi.getInstance().controlUserVideoDevice(this.mChannelName, j, str2, !z3)) {
                        }
                    }
                }
                i = 0;
            }
            InterCorrectUserBean interCorrectUserBean = new InterCorrectUserBean(this.mChannelName, j2);
            if (z4) {
                interCorrectUserBean.mAction = InterCorrectionEnum.INTER_MUTE_REMOTE_AUDIO;
            } else {
                interCorrectUserBean.mAction = InterCorrectionEnum.INTER_MUTE_REMOTE_VIDEO;
            }
            interCorrectUserBean.mInfo = Boolean.valueOf(z);
            interCorrectionManager.addInterCorrection(interCorrectUserBean);
            OmniLog.i(OmniLog.INTER_CORRECT_WATCH, TAG, "Mute remote audio/video stream over! uid = " + j2 + ", muted = " + z3 + ", isAudio = " + z4 + ", ret = " + i);
            return i;
        }
    }

    public int muteAllRemoteAudioStreams(boolean z) {
        RtcChannelManager rtcChannelManager = getRtcChannelManager();
        if (rtcChannelManager == null) {
            return -1;
        }
        if (rtcChannelManager.isJoiningChannel()) {
            this.mAudioAllRemoteMuted = z;
            return 0;
        } else if (!rtcChannelManager.isJoinedChannel()) {
            return -3;
        } else {
            RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.AUDIO_REMOTE_ALL_MUTED, this.mChannelName, Boolean.valueOf(z));
            return 0;
        }
    }

    public int setRemoteRenderMode(long j, int i, int i2) {
        RtcUserManager userManager;
        LongSparseArray<User> users;
        int size;
        GlobalHolder instance = GlobalHolder.getInstance();
        RtcDeviceManager deviceManager = instance.getDeviceManager(this.mChannelName);
        if (deviceManager == null) {
            OmniLog.e("REMOTE_MODE", TAG, "Set render mode failed! RtcDeviceManager is null! " + this.mChannelName);
            return -1;
        } else if (j != -200) {
            return executingSetRemoteRenderMode(deviceManager, j, i, i2);
        } else {
            RtcChannelManager rtcChannelManager = getRtcChannelManager();
            if (rtcChannelManager == null || (userManager = instance.getUserManager(this.mChannelName)) == null || (size = users.size()) <= 0) {
                return 0;
            }
            long channelUid = rtcChannelManager.getChannelUid();
            for (int i3 = 0; i3 < size; i3++) {
                User valueAt = (users = userManager.getUsers()).valueAt(i3);
                if (valueAt != null) {
                    long uid = valueAt.getUid();
                    if (uid != channelUid) {
                        executingSetRemoteRenderMode(deviceManager, uid, i, i2);
                    }
                }
            }
            return 0;
        }
    }

    private int executingSetRemoteRenderMode(RtcDeviceManager rtcDeviceManager, long j, int i, int i2) {
        UserDeviceConfig videoDeviceForDefault = rtcDeviceManager.getVideoDeviceForDefault(j);
        if (videoDeviceForDefault == null) {
            OmniLog.e("REMOTE_MODE", TAG, "Set render mode failed! UserDeviceConfig is null! " + j);
            return -3;
        }
        String deviceId = videoDeviceForDefault.getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            OmniLog.e("REMOTE_MODE", TAG, "Set render mode failed! Device id is null! " + videoDeviceForDefault.toString());
            return -3;
        }
        GlobalHolder.getInstance().sendSyncGlobalMessage(1003, deviceId, Integer.valueOf(i), Integer.valueOf(i2));
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void onEventJoinedChannelSuccess(int i, String str) {
        if (i == 2) {
            checkAVStreamStatus(str, GlobalConfig.mAudioLocalStreamEnabled, GlobalConfig.mVideoEnabled, GlobalConfig.mVideoLocalEnabled, false);
        }
    }

    private RtcChannelManager getRtcChannelManager() {
        WeakReference<RtcChannelManager> weakReference = this.mRtcChannelManagerRef;
        if (weakReference == null) {
            return null;
        }
        return (RtcChannelManager) weakReference.get();
    }

    private void checkLocalVideoUpload() {
        RtcChannelManager rtcChannelManager = (RtcChannelManager) this.mRtcChannelManagerRef.get();
        if (rtcChannelManager != null && rtcChannelManager.isJoinedChannel()) {
            uploadLocalVideo(GlobalHolder.getInstance().getAVStreamPublishHandler().isPublishStats(this.mChannelName));
        }
    }

    public int adjustPlaybackSignalVolume(int i) {
        double checkAudioPlaybackSignalVolume = this.mRtcInvokeSafetyChecker.checkAudioPlaybackSignalVolume(i);
        if (checkAudioPlaybackSignalVolume < 0.0d) {
            return (int) checkAudioPlaybackSignalVolume;
        }
        CommonEventBean commonEventBean = new CommonEventBean();
        commonEventBean.mEventType = 1;
        commonEventBean.mObjects = new Object[]{this.mChannelName, Double.valueOf(checkAudioPlaybackSignalVolume)};
        ExternalAudioModule.getInstance().sendAudioModuleEvent(commonEventBean);
        return 0;
    }

    public int adjustUserPlaybackSignalVolume(long j, int i) {
        double checkAudioPlaybackSignalVolume = this.mRtcInvokeSafetyChecker.checkAudioPlaybackSignalVolume(i);
        if (checkAudioPlaybackSignalVolume < 0.0d) {
            return (int) checkAudioPlaybackSignalVolume;
        }
        CommonEventBean commonEventBean = new CommonEventBean();
        commonEventBean.mEventType = 2;
        commonEventBean.mObjects = new Object[]{Long.valueOf(j), Double.valueOf(checkAudioPlaybackSignalVolume)};
        ExternalAudioModule.getInstance().sendAudioModuleEvent(commonEventBean);
        return 0;
    }

    public int setRemoteVideoStreamType(long j, int i) {
        VideoDualStreamManager videoDualStreamManager = GlobalHolder.getInstance().getVideoDualStreamManager(this.mChannelName);
        if (videoDualStreamManager == null) {
            OmniLog.w(OmniLog.DUAL_VIDEO, TAG, "Channel not found VideoDualStreamManager... cache : " + j + " | " + i + " | " + this.mChannelName);
            EnterConfApi.getInstance().cacheVideoRemoteStreamType(new VideoRemoteStreamType(j, i));
            return 0;
        }
        videoDualStreamManager.setRemoteVideoStreamType(j, i);
        return 0;
    }

    public int muteLocalAudioStream(boolean z) {
        if (!GlobalConfig.mAudioEnabled) {
            return -3;
        }
        if (this.mAudioMuted == z) {
            return 0;
        }
        RtcChannelManager rtcChannelManager = (RtcChannelManager) this.mRtcChannelManagerRef.get();
        if (rtcChannelManager == null) {
            return -1;
        }
        this.mAudioMuted = z;
        if (!rtcChannelManager.isJoinedChannel()) {
            return 0;
        }
        updateHeartbeatReporterAVStatus(Boolean.valueOf(!z), (Boolean) null);
        if (rtcChannelManager.getRole() == 2 && !z) {
            return 0;
        }
        RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.AUDIO_LOCAL_MUTED, this.mChannelName, Boolean.valueOf(z));
        return 0;
    }

    public int muteLocalVideoStream(boolean z) {
        if (this.mVideoMuted == z) {
            return 0;
        }
        RtcChannelManager rtcChannelManager = (RtcChannelManager) this.mRtcChannelManagerRef.get();
        if (rtcChannelManager == null) {
            return -1;
        }
        synchronized (this.mLock) {
            this.mVideoMuted = z;
        }
        if (!rtcChannelManager.isJoinedChannel()) {
            return 0;
        }
        updateHeartbeatReporterAVStatus((Boolean) null, Boolean.valueOf(!z));
        checkLocalVideoUpload();
        if (rtcChannelManager.getRole() == 2 && !z) {
            OmniLog.w(OmniLog.CHANNEL_PUSH, TAG, "Mute local video stream failed, role is audience, but mute stats is false!");
            return 0;
        } else if (!GlobalConfig.mVideoEnabled) {
            OmniLog.w(OmniLog.CHANNEL_PUSH, TAG, "Mute local video stream failed, video module isn't enabled!");
            return 0;
        } else {
            RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.VIDEO_LOCAL_MUTED, this.mChannelName, Boolean.valueOf(z));
            return 0;
        }
    }

    public void updateHeartbeatReporterAVStatus(Boolean bool, Boolean bool2) {
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

    public void updateAudioMuteStats() {
        updateHeartbeatReporterAVStatus(Boolean.valueOf(this.mAudioMuted), (Boolean) null);
        RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.AUDIO_LOCAL_MUTED, this.mChannelName, Boolean.valueOf(this.mAudioMuted));
    }

    public void updateVideoMuteStats() {
        boolean z = this.mVideoMuted;
        boolean z2 = GlobalConfig.mVideoEnabled;
        if (!z2 && !z) {
            z = true;
        }
        OmniLog.i(OmniLog.CHANNEL_PUSH, TAG, "Update local video stream status, muted = " + z + ", video module enabled = " + z2);
        updateHeartbeatReporterAVStatus((Boolean) null, Boolean.valueOf(z));
        RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.VIDEO_LOCAL_MUTED, this.mChannelName, Boolean.valueOf(z));
    }

    public int setDefaultMuteAllRemoteAudioStreams(boolean z) {
        synchronized (this.mLock) {
            if (this.mDefaultAllRemoteAudioMuted == z) {
                return 0;
            }
            this.mDefaultAllRemoteAudioMuted = z;
            return 0;
        }
    }

    public int setDefaultMuteAllRemoteVideoStreams(boolean z) {
        synchronized (this.mLock) {
            if (this.mDefaultAllRemoteVideoMuted == z) {
                return 0;
            }
            OmniLog.i(TAG, "Set default mute all remote video stream, muted=" + z);
            this.mDefaultAllRemoteVideoMuted = z;
            return 0;
        }
    }

    public void handleCallBackForUserJoined(String str, long j) {
        checkCacheAction(j);
        updateVideoDevStatus(str, j);
    }

    public void handleCallBackForUpdateVideoDev(String str, long j) {
        updateVideoDevStatus(str, j);
    }

    public void handleCallBackForRoleChanged(long j, int i) {
        synchronized (this.mLock) {
            if (!this.mVideoMuted) {
                uploadLocalVideo(true);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkCacheAction(long r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            com.wushuangtech.library.GlobalHolder r1 = com.wushuangtech.library.GlobalHolder.getInstance()     // Catch:{ all -> 0x0056 }
            com.wushuangtech.api.InterCorrectionManager r1 = r1.getInterCorrectionManager()     // Catch:{ all -> 0x0056 }
            if (r1 != 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            return
        L_0x000f:
            com.wushuangtech.bean.InterCorrectUserBean r2 = new com.wushuangtech.bean.InterCorrectUserBean     // Catch:{ all -> 0x0056 }
            java.lang.String r3 = r5.mChannelName     // Catch:{ all -> 0x0056 }
            r2.<init>(r3, r6)     // Catch:{ all -> 0x0056 }
            com.wushuangtech.bean.InterCorrectionEnum r3 = com.wushuangtech.bean.InterCorrectionEnum.INTER_MUTE_REMOTE_AUDIO     // Catch:{ all -> 0x0056 }
            r2.mAction = r3     // Catch:{ all -> 0x0056 }
            com.wushuangtech.bean.InterCorrectionBean r1 = r1.recoveryInterWithNoNotify(r2)     // Catch:{ all -> 0x0056 }
            r2 = 1
            if (r1 == 0) goto L_0x003e
            java.lang.Object r1 = r1.mInfo     // Catch:{ all -> 0x0056 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0056 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x0054
            java.lang.String r1 = "INTER_CORRECT_WATCH"
            java.lang.String r3 = "RtcChannelAVManager"
            java.lang.String r4 = "User has joined room, restore the user's audio streaming status, muted: true"
            com.wushuangtech.utils.OmniLog.i(r1, r3, r4)     // Catch:{ all -> 0x0056 }
            com.wushuangtech.jni.RoomJni r1 = com.wushuangtech.jni.RoomJni.getInstance()     // Catch:{ all -> 0x0056 }
            java.lang.String r3 = r5.mChannelName     // Catch:{ all -> 0x0056 }
            r1.MuteRemoteAudio(r3, r6, r2)     // Catch:{ all -> 0x0056 }
            goto L_0x0054
        L_0x003e:
            boolean r1 = r5.mDefaultAllRemoteAudioMuted     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x0054
            java.lang.String r1 = "INTER_CORRECT_WATCH"
            java.lang.String r3 = "RtcChannelAVManager"
            java.lang.String r4 = "User has joined room, but doesn't pull the audio stream by default."
            com.wushuangtech.utils.OmniLog.i(r1, r3, r4)     // Catch:{ all -> 0x0056 }
            com.wushuangtech.jni.RoomJni r1 = com.wushuangtech.jni.RoomJni.getInstance()     // Catch:{ all -> 0x0056 }
            java.lang.String r3 = r5.mChannelName     // Catch:{ all -> 0x0056 }
            r1.MuteRemoteAudio(r3, r6, r2)     // Catch:{ all -> 0x0056 }
        L_0x0054:
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            return
        L_0x0056:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.RtcChannelAVManager.checkCacheAction(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f3, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateVideoDevStatus(java.lang.String r8, long r9) {
        /*
            r7 = this;
            com.wushuangtech.library.GlobalHolder r0 = com.wushuangtech.library.GlobalHolder.getInstance()
            com.wushuangtech.api.RtcUserManager r0 = r0.getUserManager(r8)
            if (r0 != 0) goto L_0x0012
            java.lang.String r8 = "RtcChannelAVManager"
            java.lang.String r9 = "Open user's device failed... RtcUserManager is null!"
            com.wushuangtech.utils.OmniLog.e(r8, r9)
            return
        L_0x0012:
            com.wushuangtech.library.GlobalHolder r1 = com.wushuangtech.library.GlobalHolder.getInstance()
            com.wushuangtech.api.RtcDeviceManager r1 = r1.getDeviceManager(r8)
            if (r1 != 0) goto L_0x0024
            java.lang.String r8 = "RtcChannelAVManager"
            java.lang.String r9 = "Open user's device failed... RtcDeviceManager is null!"
            com.wushuangtech.utils.OmniLog.e(r8, r9)
            return
        L_0x0024:
            com.wushuangtech.library.User r0 = r0.getUser(r9)
            if (r0 != 0) goto L_0x0032
            java.lang.String r8 = "RtcChannelAVManager"
            java.lang.String r9 = "Open user's device failed... User is null!"
            com.wushuangtech.utils.OmniLog.e(r8, r9)
            return
        L_0x0032:
            int r0 = r0.getIdentity()
            r2 = 2
            if (r0 != r2) goto L_0x003a
            return
        L_0x003a:
            com.wushuangtech.library.UserDeviceConfig r0 = r1.getVideoDeviceForDefault(r9)
            if (r0 != 0) goto L_0x0041
            return
        L_0x0041:
            java.lang.String r5 = r0.getDeviceId()
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 == 0) goto L_0x004c
            return
        L_0x004c:
            java.lang.Object r1 = r7.mLock
            monitor-enter(r1)
            java.lang.String r2 = "RtcChannelAVManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r3.<init>()     // Catch:{ all -> 0x00f7 }
            java.lang.String r4 = "Check status, inuse="
            r3.append(r4)     // Catch:{ all -> 0x00f7 }
            boolean r4 = r0.isUse()     // Catch:{ all -> 0x00f7 }
            r3.append(r4)     // Catch:{ all -> 0x00f7 }
            java.lang.String r4 = ", videoEnabled="
            r3.append(r4)     // Catch:{ all -> 0x00f7 }
            boolean r4 = com.wushuangtech.library.GlobalConfig.mVideoEnabled     // Catch:{ all -> 0x00f7 }
            r3.append(r4)     // Catch:{ all -> 0x00f7 }
            java.lang.String r4 = ", defaultVideoMuted="
            r3.append(r4)     // Catch:{ all -> 0x00f7 }
            boolean r4 = r7.mDefaultAllRemoteVideoMuted     // Catch:{ all -> 0x00f7 }
            r3.append(r4)     // Catch:{ all -> 0x00f7 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00f7 }
            com.wushuangtech.utils.OmniLog.i(r2, r3)     // Catch:{ all -> 0x00f7 }
            boolean r0 = r0.isUse()     // Catch:{ all -> 0x00f7 }
            if (r0 == 0) goto L_0x0089
            boolean r0 = com.wushuangtech.library.GlobalConfig.mVideoEnabled     // Catch:{ all -> 0x00f7 }
            if (r0 == 0) goto L_0x0089
            r0 = 1
            goto L_0x008a
        L_0x0089:
            r0 = 0
        L_0x008a:
            monitor-exit(r1)     // Catch:{ all -> 0x00f7 }
            if (r0 != 0) goto L_0x008e
            return
        L_0x008e:
            java.lang.Object r0 = r7.mLock
            monitor-enter(r0)
            com.wushuangtech.library.GlobalHolder r1 = com.wushuangtech.library.GlobalHolder.getInstance()     // Catch:{ all -> 0x00f4 }
            com.wushuangtech.api.InterCorrectionManager r1 = r1.getInterCorrectionManager()     // Catch:{ all -> 0x00f4 }
            if (r1 != 0) goto L_0x009d
            monitor-exit(r0)     // Catch:{ all -> 0x00f4 }
            return
        L_0x009d:
            com.wushuangtech.bean.InterCorrectUserBean r2 = new com.wushuangtech.bean.InterCorrectUserBean     // Catch:{ all -> 0x00f4 }
            r2.<init>(r8, r9)     // Catch:{ all -> 0x00f4 }
            com.wushuangtech.bean.InterCorrectionEnum r3 = com.wushuangtech.bean.InterCorrectionEnum.INTER_MUTE_REMOTE_VIDEO     // Catch:{ all -> 0x00f4 }
            r2.mAction = r3     // Catch:{ all -> 0x00f4 }
            com.wushuangtech.bean.InterCorrectionBean r1 = r1.recoveryInterWithNoNotify(r2)     // Catch:{ all -> 0x00f4 }
            if (r1 == 0) goto L_0x00d9
            java.lang.Object r1 = r1.mInfo     // Catch:{ all -> 0x00f4 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x00f4 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00f4 }
            java.lang.String r2 = "INTER_CORRECT_WATCH"
            java.lang.String r3 = "RtcChannelAVManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f4 }
            r4.<init>()     // Catch:{ all -> 0x00f4 }
            java.lang.String r6 = "User has joined room, restore the user's video streaming status, muted: "
            r4.append(r6)     // Catch:{ all -> 0x00f4 }
            r4.append(r1)     // Catch:{ all -> 0x00f4 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00f4 }
            com.wushuangtech.utils.OmniLog.i(r2, r3, r4)     // Catch:{ all -> 0x00f4 }
            if (r1 != 0) goto L_0x00f2
            com.wushuangtech.api.EnterConfApi r1 = com.wushuangtech.api.EnterConfApi.getInstance()     // Catch:{ all -> 0x00f4 }
            r6 = 1
            r2 = r8
            r3 = r9
            r1.controlUserVideoDevice(r2, r3, r5, r6)     // Catch:{ all -> 0x00f4 }
            goto L_0x00f2
        L_0x00d9:
            boolean r1 = r7.mDefaultAllRemoteVideoMuted     // Catch:{ all -> 0x00f4 }
            if (r1 == 0) goto L_0x00e8
            java.lang.String r8 = "INTER_CORRECT_WATCH"
            java.lang.String r9 = "RtcChannelAVManager"
            java.lang.String r10 = "User has joined room, but doesn't pull the video stream by default."
            com.wushuangtech.utils.OmniLog.i(r8, r9, r10)     // Catch:{ all -> 0x00f4 }
            monitor-exit(r0)     // Catch:{ all -> 0x00f4 }
            return
        L_0x00e8:
            com.wushuangtech.api.EnterConfApi r1 = com.wushuangtech.api.EnterConfApi.getInstance()     // Catch:{ all -> 0x00f4 }
            r6 = 1
            r2 = r8
            r3 = r9
            r1.controlUserVideoDevice(r2, r3, r5, r6)     // Catch:{ all -> 0x00f4 }
        L_0x00f2:
            monitor-exit(r0)     // Catch:{ all -> 0x00f4 }
            return
        L_0x00f4:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00f4 }
            throw r8
        L_0x00f7:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00f7 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.RtcChannelAVManager.updateVideoDevStatus(java.lang.String, long):void");
    }
}
