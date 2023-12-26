package com.wushuangtech.videocore;

import android.text.TextUtils;
import android.util.LongSparseArray;
import com.wushuangtech.api.EnterConfApiImpl;
import com.wushuangtech.api.ExternalVideoModuleCallback;
import com.wushuangtech.api.RtcDeviceManager;
import com.wushuangtech.api.RtcUserManager;
import com.wushuangtech.api.VideoSender;
import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.bean.FastLogCacheBean;
import com.wushuangtech.bean.ServerConfigBean;
import com.wushuangtech.constants.RtcGlobalMessage;
import com.wushuangtech.jni.VideoJni;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.GlobalVideoConfig;
import com.wushuangtech.library.ServerConfigConstants;
import com.wushuangtech.library.User;
import com.wushuangtech.library.UserDeviceConfig;
import com.wushuangtech.library.video.VideoStatistical;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.library.video.bean.VideoFrame;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.videocore.MyVideoApi;
import com.wushuangtech.videocore.model.VideoDecoderHardwareModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class MyVideoApiImpl extends MyVideoApi {
    private static final String TAG = "MyVideoApi";
    private MyVideoApi.VideoConfig mConfig = new MyVideoApi.VideoConfig();
    private volatile boolean mIsCapturing;
    private final Object mLocalVideoStateLock = new Object();
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, VideoFrame>> mUserVideoFrameStats = new ConcurrentHashMap<>();
    private final VideoDecoderHardwareModel mVideoDecoderHardwareModel = new VideoDecoderHardwareModel();
    private boolean mVideoLocalEncodedFrameFirst;
    private final FastLogCacheBean mVideoRecvErrorBean = new FastLogCacheBean("RVW", TAG, 4);
    private final List<WeakReference<VideoSender>> mVideoSenders = new ArrayList();

    public void receiveH264Sei(byte[] bArr, long j, String str) {
    }

    public void receiveSeiDataDecoderPlugin(byte[] bArr, long j, String str) {
    }

    static {
        Class<MyVideoApi> cls = MyVideoApi.class;
    }

    MyVideoApiImpl() {
    }

    public VideoDecoderHardwareModel getVideoDecoderHardwareModel() {
        return this.mVideoDecoderHardwareModel;
    }

    public void setVideoConfig(MyVideoApi.VideoConfig videoConfig) {
        String str = TAG;
        OmniLog.i(str, "Set Video Config , width : " + videoConfig.videoWidth + " | height : " + videoConfig.videoHeight + " | videoBitRate : " + videoConfig.videoBitRate + " | videoFrameRate : " + videoConfig.videoFrameRate);
        this.mConfig = videoConfig;
        EnterConfApiImpl.getInstance().reportVideoSettingParams(this.mConfig.videoWidth, this.mConfig.videoHeight, this.mConfig.videoFrameRate, this.mConfig.videoBitRate);
    }

    public MyVideoApi.VideoConfig getVideoConfig() {
        return (MyVideoApi.VideoConfig) this.mConfig.clone();
    }

    public void updateLocalVideoState(int i, int i2) {
        synchronized (this.mLocalVideoStateLock) {
            if (i == 1) {
                this.mVideoLocalEncodedFrameFirst = false;
            }
        }
        GlobalHolder.getInstance().sendRtcEngineEvent(94, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void updateVideoDecoderSpentTime() {
        VideoDecoderManager.getInstance().updateVideoDecoderSpentTime();
    }

    public void initVideoGlobalConfig() {
        VideoDecoderManager.getInstance().initMananger();
    }

    public void initVideoConfig(String str) {
        VideoJni.getInstance().EnableVideoDev("", GlobalConfig.mVideoLocalEnabled ? 1 : 0);
        if (this.mUserVideoFrameStats.get(str) == null) {
            this.mUserVideoFrameStats.put(str, new ConcurrentHashMap());
        }
    }

    public boolean startCapture() {
        GlobalConfig.mVideoCapStartCount++;
        OmniLog.i(TAG, "LPW Start main capture invoked! count = " + GlobalConfig.mVideoCapStartCount);
        this.mIsCapturing = true;
        GlobalHolder.getInstance().sendSyncGlobalMessage(RtcGlobalMessage.VIDEO_LOCAL_ENC_START, false);
        return true;
    }

    public boolean stopCapture() {
        GlobalConfig.mVideoCapStartCount--;
        OmniLog.i(TAG, "LPW Stop main capture invoked! count = " + GlobalConfig.mVideoCapStartCount);
        if (GlobalConfig.mVideoCapStartCount <= 0) {
            this.mIsCapturing = false;
            GlobalHolder.getInstance().sendSyncGlobalMessage(RtcGlobalMessage.VIDEO_LOCAL_ENC_STOP, false);
        }
        return true;
    }

    public boolean startDualCapture() {
        OmniLog.i(TAG, "LPW Start dual capture invoked!");
        GlobalHolder.getInstance().sendSyncGlobalMessage(RtcGlobalMessage.VIDEO_LOCAL_ENC_START, true);
        return true;
    }

    public boolean stopDualCapture() {
        OmniLog.i(TAG, "LPW Stop dual capture invoked!");
        GlobalHolder.getInstance().sendSyncGlobalMessage(RtcGlobalMessage.VIDEO_LOCAL_ENC_STOP, true);
        return true;
    }

    public void requestIFrame() {
        GlobalHolder.getInstance().sendSyncGlobalMessage(RtcGlobalMessage.VIDEO_LOCAL_ENC_REQUEST_KEY_FRAME, false);
    }

    public void requestDualIFrame() {
        GlobalHolder.getInstance().sendSyncGlobalMessage(RtcGlobalMessage.VIDEO_LOCAL_ENC_REQUEST_KEY_FRAME, true);
    }

    public int maxFps() {
        int i = getVideoConfig().videoFrameRate;
        String str = TAG;
        OmniLog.i(str, "Get encoder max fps : " + i);
        return i;
    }

    public int dualMaxFps() {
        int i = getVideoConfig().videoFrameRate;
        GlobalVideoConfig globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig();
        if (globalVideoConfig == null) {
            return i;
        }
        int setVideoDualEncodeFps = globalVideoConfig.getSetVideoDualEncodeFps();
        if (setVideoDualEncodeFps != 0) {
            i = setVideoDualEncodeFps;
        }
        String str = TAG;
        OmniLog.i(str, "Get dual encoder max fps : " + i);
        return i;
    }

    public int maxBitrate() {
        int i = getVideoConfig().videoBitRate;
        String str = TAG;
        OmniLog.i(str, "Get encoder max bitrate : " + i);
        return i;
    }

    public int dualMaxBitrate() {
        int i = getVideoConfig().videoBitRate / 4;
        GlobalVideoConfig globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig();
        if (globalVideoConfig == null) {
            return i;
        }
        int setVideoDualEncodeBitrate = globalVideoConfig.getSetVideoDualEncodeBitrate();
        if (setVideoDualEncodeBitrate != 0) {
            i = setVideoDualEncodeBitrate;
        }
        String str = TAG;
        OmniLog.i(str, "Get dual encoder max bitrate : " + i);
        return i;
    }

    public void changeEncParam(int i, int i2) {
        GlobalHolder.getInstance().sendSyncGlobalMessage(RtcGlobalMessage.VIDEO_LOCAL_ENC_DYNAMIC_BITRATE, false, Integer.valueOf(i), Integer.valueOf(i2));
        GlobalVideoConfig globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig();
        if (globalVideoConfig != null) {
            globalVideoConfig.setVideoEncoderParams(i2, i);
        }
    }

    public void changeDualEncParam(int i, int i2) {
        GlobalHolder.getInstance().sendSyncGlobalMessage(RtcGlobalMessage.VIDEO_LOCAL_ENC_DYNAMIC_BITRATE, true, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void stopPlay(String str, String str2) {
        String str3 = TAG;
        OmniLog.i(str3, "Stop video play, channelName : " + str + " | deviceId : " + str2);
        VideoDecoderManager.getInstance().closeVideoDecoder(str2);
        GlobalHolder.getInstance().sendSyncGlobalMessage(1000, str2);
    }

    public void stopPlay(String str) {
        LongSparseArray<List<UserDeviceConfig>> videoDeviceForAll;
        String str2 = TAG;
        OmniLog.i(str2, "Stop all video of channel play! channelName: " + str);
        RtcDeviceManager deviceManager = GlobalHolder.getInstance().getDeviceManager(str);
        if (!(deviceManager == null || (videoDeviceForAll = deviceManager.getVideoDeviceForAll()) == null)) {
            closeVideoDeviceLinkInChannel(str, videoDeviceForAll);
            stopPlayInChannel(str, videoDeviceForAll);
        }
        this.mUserVideoFrameStats.remove(str);
    }

    public void stopAllPlay() {
        String str = TAG;
        OmniLog.i(str, "Stop all video play!");
        VideoDecoderManager.getInstance().closeVideoDecoder("all");
        OmniLog.i(str, "Video decoder resource clear over!");
        GlobalHolder.getInstance().sendSyncGlobalMessage(1002, new Object[0]);
        updateLocalVideoState(0, 0);
        this.mUserVideoFrameStats.clear();
        OmniLog.i(str, "Video resource clear over!");
    }

    public void receiveVideoData(String str, byte[] bArr, String str2, long j, int i, int i2, ExternalVideoModuleCallback.VideoFrameType videoFrameType) {
        if (i == 0 || i2 == 0) {
            VideoStatus.mVideoRecvErrorNum++;
            FastLogCacheBean fastLogCacheBean = this.mVideoRecvErrorBean;
            StringBuilder sb = new StringBuilder();
            sb.append("Recv video data error, width or height is zero! channel=");
            String str3 = str;
            sb.append(str);
            sb.append(", id=");
            String str4 = str2;
            sb.append(str2);
            sb.append(", num=");
            sb.append(VideoStatus.mVideoRecvErrorNum);
            fastLogCacheBean.mMessage = sb.toString();
            OmniLog.fd(this.mVideoRecvErrorBean);
            return;
        }
        decodingVideoData(str, str2, bArr, videoFrameType, i, i2, j);
    }

    public void addVideoSender(VideoSender videoSender) {
        OmniLog.i("addVideoSender sender" + videoSender);
        for (WeakReference<VideoSender> weakReference : this.mVideoSenders) {
            if (weakReference.get() == videoSender) {
                return;
            }
        }
        this.mVideoSenders.add(new WeakReference(videoSender));
    }

    public void removeVideoSender(VideoSender videoSender) {
        OmniLog.i("removeVideoSender sender:" + videoSender);
        for (WeakReference next : this.mVideoSenders) {
            if (next.get() == videoSender) {
                this.mVideoSenders.remove(next);
                return;
            }
        }
    }

    public boolean isCapturing() {
        return this.mIsCapturing;
    }

    public void setBitrateMode(int i) {
        this.mConfig.videoBitrateMode = i;
        GlobalHolder.getInstance().sendSyncGlobalMessage(RtcGlobalMessage.VIDEO_LOCAL_ENC_MODE, Integer.valueOf(i));
    }

    public void resetVideoDecoderStatus(CommonEventBean commonEventBean) {
        VideoDecoder videoDecoder;
        String str = (String) commonEventBean.mObjects[0];
        long longValue = ((Long) commonEventBean.mObjects[1]).longValue();
        boolean booleanValue = ((Boolean) commonEventBean.mObjects[2]).booleanValue();
        String str2 = TAG;
        OmniLog.i(str2, "Reset video decoder flag! channelName = " + str + " | resetAll = " + booleanValue);
        if (booleanValue) {
            VideoDecoderManager.getInstance().resetVideoDecoderFirstReportFlag(str);
            return;
        }
        RtcDeviceManager deviceManager = GlobalHolder.getInstance().getDeviceManager(str);
        if (deviceManager != null && (videoDecoder = VideoDecoderManager.getInstance().getVideoDecoder(deviceManager.getVideoDeviceForDefault(longValue))) != null) {
            videoDecoder.resetReportFirstDecoded(str);
        }
    }

    public void updateServerConfig(List<ServerConfigBean> list) {
        for (ServerConfigBean next : list) {
            String str = next.mConfigKey;
            str.hashCode();
            if (str.equals(ServerConfigConstants.KEY_VIDEO_DECODER_HARDWARE)) {
                handleServerConfigHWDecode(next);
            } else if (str.equals(ServerConfigConstants.KEY_CONFIG_VIDEO_ENCODER_INFO_TYPE)) {
                handleServerConfigEncodeInfo(next);
            }
        }
    }

    private void handleServerConfigEncodeInfo(ServerConfigBean serverConfigBean) {
        if (serverConfigBean.mConfigKey.equals(ServerConfigConstants.KEY_CONFIG_VIDEO_ENCODER_INFO_TYPE)) {
            boolean z = true;
            if (serverConfigBean.mConfigValue != 1) {
                z = false;
            }
            GlobalConfig.mForceVideoSoftEncoder = z;
        }
    }

    private void handleServerConfigHWDecode(ServerConfigBean serverConfigBean) {
        boolean z = true;
        if (serverConfigBean.mConfigValue != 1) {
            z = false;
        }
        VideoDecoder.mEnableDynamicSwitchVideoType = z;
    }

    public void receiveVideoDataDecoderPlugin(byte[] bArr, String str, long j, int i, int i2, ExternalVideoModuleCallback.VideoFrameType videoFrameType) {
        decodingVideoData(GlobalConfig.mLocalRoomName, str, bArr, videoFrameType, i, i2, j);
    }

    public void encodedVideoFrame(byte[] bArr, ExternalVideoModuleCallback.VideoFrameType videoFrameType, int i, int i2, boolean z, long j) {
        synchronized (this.mLocalVideoStateLock) {
            if (!this.mVideoLocalEncodedFrameFirst) {
                GlobalHolder.getInstance().sendRtcEngineEvent(94, 2, 0);
                this.mVideoLocalEncodedFrameFirst = true;
            }
        }
        for (WeakReference next : this.mVideoSenders) {
            if (next.get() != null) {
                if (z) {
                    ((VideoSender) next.get()).pushDualEncodedVideoData(bArr, videoFrameType, i, i2, j);
                } else {
                    ((VideoSender) next.get()).pushEncodedVideoData(bArr, videoFrameType, i, i2, j);
                }
            }
        }
    }

    private void decodingVideoData(String str, String str2, byte[] bArr, ExternalVideoModuleCallback.VideoFrameType videoFrameType, int i, int i2, long j) {
        String str3 = str;
        String str4 = str2;
        int i3 = i;
        int i4 = i2;
        User findUserByDeviceId = findUserByDeviceId(str, str2);
        if (findUserByDeviceId == null) {
            String str5 = TAG;
            OmniLog.i(str5, "Not found user... channelName : " + str + " | deviceId : " + str2);
            return;
        }
        String deviceIdWithOpened = findUserByDeviceId.getDeviceIdWithOpened();
        String str6 = (TextUtils.isEmpty(deviceIdWithOpened) || str2.equals(deviceIdWithOpened)) ? str4 : deviceIdWithOpened;
        long j2 = -1;
        try {
            String[] split = str6.split(":");
            if (split.length > 1) {
                try {
                    j2 = Long.parseLong(split[0]);
                } catch (Exception unused) {
                }
            } else {
                j2 = Long.parseLong(str6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long j3 = j2;
        VideoStatistical globalVideoStatistical = GlobalHolder.getInstance().getGlobalVideoStatistical();
        if (globalVideoStatistical != null) {
            globalVideoStatistical.updateVideoRemoteRecvDataCount(j3);
        }
        VideoDecoderManager instance = VideoDecoderManager.getInstance();
        if (!instance.checkVideoDecoderExist(str6)) {
            instance.createNewVideoDecoder(str, j3, str6, i, i2);
        }
        checkVideoSizeChanged(str, str6, i3, i4);
        VideoFrame videoFrame = new VideoFrame();
        videoFrame.data = bArr;
        videoFrame.frameType = videoFrameType;
        videoFrame.timeStamp = j;
        videoFrame.width = i3;
        videoFrame.height = i4;
        instance.addVideoData(str, str6, videoFrame);
    }

    private User findUserByDeviceId(String str, String str2) {
        RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(str);
        RtcDeviceManager deviceManager = GlobalHolder.getInstance().getDeviceManager(str);
        if (userManager == null || deviceManager == null) {
            return null;
        }
        long userByDeviceId = deviceManager.getUserByDeviceId(str2);
        if (userByDeviceId == -1) {
            return null;
        }
        return userManager.getUser(userByDeviceId);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkVideoSizeChanged(java.lang.String r5, java.lang.String r6, int r7, int r8) {
        /*
            r4 = this;
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.ConcurrentHashMap<java.lang.String, com.wushuangtech.library.video.bean.VideoFrame>> r0 = r4.mUserVideoFrameStats
            java.lang.Object r5 = r0.get(r5)
            java.util.concurrent.ConcurrentHashMap r5 = (java.util.concurrent.ConcurrentHashMap) r5
            if (r5 != 0) goto L_0x000b
            return
        L_0x000b:
            java.lang.Object r0 = r5.get(r6)
            com.wushuangtech.library.video.bean.VideoFrame r0 = (com.wushuangtech.library.video.bean.VideoFrame) r0
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0023
            com.wushuangtech.library.video.bean.VideoFrame r0 = new com.wushuangtech.library.video.bean.VideoFrame
            r0.<init>()
            r0.width = r7
            r0.height = r8
            r5.put(r6, r0)
        L_0x0021:
            r5 = r2
            goto L_0x0036
        L_0x0023:
            int r3 = r0.width
            if (r3 != r7) goto L_0x002e
            int r3 = r0.height
            if (r3 == r8) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r5 = r1
            goto L_0x0036
        L_0x002e:
            r0.width = r7
            r0.height = r8
            r5.put(r6, r0)
            goto L_0x0021
        L_0x0036:
            if (r5 == 0) goto L_0x0053
            com.wushuangtech.library.GlobalHolder r5 = com.wushuangtech.library.GlobalHolder.getInstance()
            r0 = 1004(0x3ec, float:1.407E-42)
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r1] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            r3[r2] = r6
            r6 = 2
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            r3[r6] = r7
            r5.sendSyncGlobalMessage(r0, r3)
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.videocore.MyVideoApiImpl.checkVideoSizeChanged(java.lang.String, java.lang.String, int, int):void");
    }

    private void closeVideoDeviceLinkInChannel(String str, LongSparseArray<List<UserDeviceConfig>> longSparseArray) {
        if (longSparseArray != null) {
            for (int i = 0; i < longSparseArray.size(); i++) {
                List valueAt = longSparseArray.valueAt(i);
                if (valueAt != null) {
                    for (int i2 = 0; i2 < valueAt.size(); i2++) {
                        UserDeviceConfig userDeviceConfig = (UserDeviceConfig) valueAt.get(i2);
                        long uid = userDeviceConfig.getUid();
                        String deviceId = userDeviceConfig.getDeviceId();
                        String dualDeviceId = userDeviceConfig.getDualDeviceId();
                        if (userDeviceConfig.isOpenBigVideo() && !TextUtils.isEmpty(deviceId)) {
                            VideoJni.getInstance().VideoCloseDevice(str, uid, deviceId);
                        }
                        if (userDeviceConfig.isOpenSmallVideo() && !TextUtils.isEmpty(dualDeviceId)) {
                            VideoJni.getInstance().VideoCloseDevice(str, uid, dualDeviceId);
                        }
                    }
                }
            }
        }
    }

    private void stopPlayInChannel(String str, LongSparseArray<List<UserDeviceConfig>> longSparseArray) {
        int size = longSparseArray.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                List valueAt = longSparseArray.valueAt(i);
                if (valueAt != null && valueAt.size() > 0) {
                    for (int i2 = 0; i2 < valueAt.size(); i2++) {
                        UserDeviceConfig userDeviceConfig = (UserDeviceConfig) valueAt.get(i2);
                        if (userDeviceConfig != null) {
                            String deviceId = userDeviceConfig.getDeviceId();
                            if (!TextUtils.isEmpty(deviceId)) {
                                stopPlay(str, deviceId);
                            }
                        }
                    }
                }
            }
        }
    }

    public byte[] CheckFrame(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3 = i + i2;
        if (i3 > bArr.length) {
            return null;
        }
        int i4 = i3 - 3;
        int i5 = i2 - 4;
        Vector vector = new Vector();
        for (int i6 = i; i6 < i4; i6++) {
            if (bArr[i6] == 0 && bArr[i6 + 1] == 0 && bArr[i6 + 2] == 1) {
                if (i6 > 0) {
                    int i7 = i6 - 1;
                    if (bArr[i7] == 0) {
                        vector.add(Integer.valueOf(i7));
                    }
                }
                vector.add(Integer.valueOf(i6));
                i5++;
            }
        }
        vector.add(Integer.valueOf(i3));
        if (bArr2 != null) {
            i5 += bArr2.length;
        }
        byte[] bArr3 = new byte[i5];
        int i8 = 0;
        int i9 = 0;
        while (i8 < vector.size() - 1) {
            int i10 = i8 + 1;
            int intValue = ((Integer) vector.get(i10)).intValue() - ((Integer) vector.get(i8)).intValue();
            if (i8 == 0) {
                intValue -= 4;
                System.arraycopy(bArr, ((Integer) vector.get(i8)).intValue() + i + 4, bArr3, i9, intValue);
            } else {
                if (i8 == 2 && bArr2 != null) {
                    System.arraycopy(bArr2, 0, bArr3, i9, bArr2.length);
                    i9 += bArr2.length;
                }
                if (bArr[((Integer) vector.get(i8)).intValue() + i + 2] == 1) {
                    int i11 = i9 + 1;
                    bArr3[i9] = 0;
                    System.arraycopy(bArr, ((Integer) vector.get(i8)).intValue() + i, bArr3, i11, intValue);
                    i9 = i11;
                } else {
                    System.arraycopy(bArr, ((Integer) vector.get(i8)).intValue() + i, bArr3, i9, intValue);
                }
            }
            i9 += intValue;
            i8 = i10;
        }
        return bArr3;
    }
}
