package com.wushuangtech.library;

import android.text.TextUtils;
import android.util.LongSparseArray;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.api.ExternalVideoModule;
import com.wushuangtech.bean.AudioEncodedConfig;
import com.wushuangtech.bean.ChannelInfoBean;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.expansion.bean.LocalAudioStats;
import com.wushuangtech.expansion.bean.LocalVideoStats;
import com.wushuangtech.expansion.bean.RemoteAudioStats;
import com.wushuangtech.expansion.bean.RemoteVideoStats;
import com.wushuangtech.expansion.bean.RtcStats;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.library.video.bean.VideoRemoteStatsBean;
import com.wushuangtech.utils.DeviceUtils;
import com.wushuangtech.utils.MyMathUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class RtcAVStatistics {
    public static final int AV_STATUS_REFRESH_INTERVAL = 1000;
    private final HashMap<Long, AudioRemoteStatisticalBean> mAudioRemoteStatisticalBeanArray = new HashMap<>();
    private boolean mEnableStatistical;
    private long mLastBuildTime;
    private int mLastLocalAudioEncodedFps;
    private long mLastLocalAudioRecvDataSize;
    private long mLastLocalAudioSendDataSize;
    private long mLastLocalVideoRecvDataSize;
    private long mLastLocalVideoSentFps;
    private long mLastLocalVideoTotalSendBytes;
    private int mLocalAudioRecvPS;
    private int mLocalAudioSendPS;
    private LocalAudioStats mLocalAudioStats;
    private int mLocalVideoRecvPS;
    private int mLocalVideoSendBitrate;
    private int mLocalVideoSendFps;
    private LocalVideoStats mLocalVideoStats;
    private final Object mLock = new Object();
    private LongSparseArray<RemoteAudioStats> mRemoteAudioStats;
    private HashMap<String, LongSparseArray<RemoteVideoStats>> mRemoteVideoStats;
    private final HashMap<String, RtcStats> mRtcStatsList = new HashMap<>();

    public void startCalcAVStatistical() {
        synchronized (this.mLock) {
            this.mEnableStatistical = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateAVStatistical() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            boolean r1 = r5.mEnableStatistical     // Catch:{ all -> 0x004e }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return
        L_0x0009:
            com.wushuangtech.expansion.bean.LocalAudioStats r1 = r5.calcAudioLocalStats()     // Catch:{ all -> 0x004e }
            com.wushuangtech.expansion.bean.LocalVideoStats r2 = r5.calcVideoLocalStats()     // Catch:{ all -> 0x004e }
            com.wushuangtech.api.ExternalVideoModule r3 = com.wushuangtech.api.ExternalVideoModule.getInstance()     // Catch:{ all -> 0x004e }
            android.util.LongSparseArray r3 = r3.getVideoStatistics()     // Catch:{ all -> 0x004e }
            android.util.LongSparseArray r4 = r5.calcRemoteAudioStats(r3)     // Catch:{ all -> 0x004e }
            java.util.HashMap r3 = r5.calcRemoteVideoStats(r3)     // Catch:{ all -> 0x004e }
            r5.calcVideoLocalSentBitrate()     // Catch:{ all -> 0x004e }
            r5.calcVideoLocalSentFps()     // Catch:{ all -> 0x004e }
            r5.calcRtcStats()     // Catch:{ all -> 0x004e }
            r5.mLocalAudioStats = r1     // Catch:{ all -> 0x004e }
            r5.mLocalVideoStats = r2     // Catch:{ all -> 0x004e }
            r5.mRemoteAudioStats = r4     // Catch:{ all -> 0x004e }
            r5.mRemoteVideoStats = r3     // Catch:{ all -> 0x004e }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x004e }
            r5.mLastBuildTime = r1     // Catch:{ all -> 0x004e }
            com.wushuangtech.library.GlobalHolder r1 = com.wushuangtech.library.GlobalHolder.getInstance()     // Catch:{ all -> 0x004e }
            com.wushuangtech.library.GlobalVideoConfig r1 = r1.getGlobalVideoConfig()     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x004c
            int r2 = r5.mLocalVideoSendBitrate     // Catch:{ all -> 0x004e }
            r1.setLocalVideoTotalSendBitrate(r2)     // Catch:{ all -> 0x004e }
            int r2 = r5.mLocalVideoRecvPS     // Catch:{ all -> 0x004e }
            r1.setLocalVideoTotalRecvBitrate(r2)     // Catch:{ all -> 0x004e }
        L_0x004c:
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            return
        L_0x004e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.RtcAVStatistics.updateAVStatistical():void");
    }

    public void resetChannelAVStatistical(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.mLock) {
                this.mRtcStatsList.remove(str);
            }
        }
    }

    public void resetAVStatistical() {
        synchronized (this.mLock) {
            this.mEnableStatistical = false;
            this.mLocalAudioSendPS = 0;
            this.mLocalAudioRecvPS = 0;
            this.mLocalVideoRecvPS = 0;
            this.mLastLocalAudioSendDataSize = 0;
            this.mLastLocalAudioRecvDataSize = 0;
            this.mLastLocalVideoRecvDataSize = 0;
            this.mLastLocalAudioEncodedFps = 0;
            LongSparseArray<RemoteAudioStats> longSparseArray = this.mRemoteAudioStats;
            if (longSparseArray != null) {
                longSparseArray.clear();
                this.mRemoteAudioStats = null;
            }
            HashMap<String, LongSparseArray<RemoteVideoStats>> hashMap = this.mRemoteVideoStats;
            if (hashMap != null) {
                hashMap.clear();
                this.mRemoteVideoStats = null;
            }
            this.mAudioRemoteStatisticalBeanArray.clear();
            this.mRtcStatsList.clear();
        }
    }

    private void calcRtcStats() {
        DeviceUtils deviceUtils;
        List<ChannelInfoBean> rtcChannelNames = GlobalHolder.getInstance().getRtcChannelNames();
        if (rtcChannelNames != null) {
            double cpuUsage = RoomJni.getInstance().getCpuUsage();
            double d = 0.0d;
            GlobalChannelConfig globalChannelConfig = GlobalHolder.getInstance().getGlobalChannelConfig();
            if (!(globalChannelConfig == null || (deviceUtils = globalChannelConfig.getDeviceUtils()) == null)) {
                d = (double) (deviceUtils.getAppUsedMemory() / deviceUtils.getTotalMemory());
            }
            Iterator<ChannelInfoBean> it = rtcChannelNames.iterator();
            while (it.hasNext()) {
                String str = it.next().mChannelName;
                RtcStats rtcStats = this.mRtcStatsList.get(str);
                if (rtcStats == null) {
                    rtcStats = new RtcStats();
                    rtcStats.setChannelName(str);
                    this.mRtcStatsList.put(str, rtcStats);
                }
                rtcStats.reset();
                long currentTimeMillis = System.currentTimeMillis() - GlobalConfig.mEnterRoomTime;
                if (currentTimeMillis < 1000) {
                    rtcStats.totalDuration = 0;
                } else {
                    rtcStats.totalDuration = (int) (currentTimeMillis / 1000);
                }
                ExternalAudioModule instance = ExternalAudioModule.getInstance();
                ExternalVideoModule instance2 = ExternalVideoModule.getInstance();
                ExternalAudioModule.LocalAudioStatistics localAudioStatistics = instance.getLocalAudioStatistics();
                ExternalVideoModule.LocalVideoStatistics localVideoStatistics = instance2.getLocalVideoStatistics();
                LongSparseArray<ExternalAudioModule.AudioStatistics> audioStatistics = instance.getAudioStatistics(str);
                long totalSendBytes = instance2.getTotalSendBytes();
                long totalSendBytes2 = instance.getTotalSendBytes();
                double d2 = cpuUsage;
                Iterator<ChannelInfoBean> it2 = it;
                long calcRemoteAudioRecvSizePerChannel = calcRemoteAudioRecvSizePerChannel(audioStatistics);
                LongSparseArray<ExternalAudioModule.AudioStatistics> longSparseArray = audioStatistics;
                LongSparseArray<ExternalVideoModule.VideoStatistics> videoStatistics = instance2.getVideoStatistics(str);
                ExternalVideoModule.LocalVideoStatistics localVideoStatistics2 = localVideoStatistics;
                long calcRemoteVideoRecvSizePerChannel = calcRemoteVideoRecvSizePerChannel(videoStatistics);
                Iterator<ChannelInfoBean> it3 = it2;
                double d3 = d;
                long j = calcRemoteAudioRecvSizePerChannel;
                if (str.equals(GlobalConfig.mAVUploadChannelName)) {
                    rtcStats.txBytes = (int) Math.max(0, totalSendBytes + totalSendBytes2);
                    rtcStats.txAudioBytes = (int) Math.max(0, totalSendBytes2);
                    rtcStats.txVideoBytes = (int) Math.max(0, totalSendBytes);
                    rtcStats.txKBitRate = Math.max(0, this.mLocalAudioSendPS + this.mLocalVideoSendBitrate);
                    rtcStats.txAudioKBitRate = Math.max(0, this.mLocalAudioSendPS);
                    rtcStats.txVideoKBitRate = Math.max(0, this.mLocalVideoSendBitrate);
                }
                rtcStats.rxBytes = (int) Math.max(0, calcRemoteVideoRecvSizePerChannel + j);
                rtcStats.rxAudioBytes = (int) Math.max(0, j);
                rtcStats.rxVideoBytes = (int) Math.max(0, calcRemoteVideoRecvSizePerChannel);
                rtcStats.rxKBitRate = Math.max(0, this.mLocalAudioRecvPS + this.mLocalVideoRecvPS);
                rtcStats.rxAudioKBitRate = Math.max(0, this.mLocalAudioRecvPS);
                rtcStats.rxVideoKBitRate = Math.max(0, this.mLocalVideoRecvPS);
                rtcStats.lastmileDelay = localAudioStatistics.rttMs;
                int i = GlobalConfig.mNetTestSigStrength;
                if (i == 0) {
                    i = -1;
                }
                rtcStats.gatewayRtt = i;
                d = d3;
                rtcStats.memoryAppUsageRatio = d;
                if (str.equals(GlobalConfig.mAVUploadChannelName)) {
                    rtcStats.txPacketLossRate = calcTxPacketLossRate(localAudioStatistics, localVideoStatistics2);
                }
                rtcStats.rxPacketLossRate = calcRxPacketLossRate(longSparseArray, videoStatistics);
                double d4 = d2;
                rtcStats.cpuAppUsage = d4;
                cpuUsage = d4;
                it = it3;
            }
        }
    }

    private long calcRemoteAudioRecvSizePerChannel(LongSparseArray<ExternalAudioModule.AudioStatistics> longSparseArray) {
        int size = longSparseArray.size();
        long j = 0;
        if (size <= 0) {
            return 0;
        }
        for (int i = 0; i < size; i++) {
            ExternalAudioModule.AudioStatistics valueAt = longSparseArray.valueAt(i);
            if (valueAt != null) {
                j += valueAt.recvLength;
            }
        }
        return j;
    }

    private long calcRemoteVideoRecvSizePerChannel(LongSparseArray<ExternalVideoModule.VideoStatistics> longSparseArray) {
        int size = longSparseArray.size();
        long j = 0;
        if (size <= 0) {
            return 0;
        }
        for (int i = 0; i < size; i++) {
            ExternalVideoModule.VideoStatistics valueAt = longSparseArray.valueAt(i);
            if (valueAt != null) {
                j += valueAt.recvSize;
            }
        }
        return j;
    }

    private int calcTxPacketLossRate(ExternalAudioModule.LocalAudioStatistics localAudioStatistics, ExternalVideoModule.LocalVideoStatistics localVideoStatistics) {
        return Math.max(Math.max(localAudioStatistics.fractionLost > 0 ? (int) (MyMathUtils.formatNumberDecimal(LocalSDKConstants.LEFT_DECIMAL_NUM, ((float) localAudioStatistics.fractionLost) / 255.0f) * 100.0f) : 0, localVideoStatistics.V_SENDFRACTIONLOST > 0 ? (int) (MyMathUtils.formatNumberDecimal(LocalSDKConstants.LEFT_DECIMAL_NUM, ((float) localVideoStatistics.V_SENDFRACTIONLOST) / 255.0f) * 100.0f) : 0), 0);
    }

    private int calcRxPacketLossRate(LongSparseArray<ExternalAudioModule.AudioStatistics> longSparseArray, LongSparseArray<ExternalVideoModule.VideoStatistics> longSparseArray2) {
        int i;
        int i2;
        int size = longSparseArray.size();
        if (size > 0) {
            i = 0;
            for (int i3 = 0; i3 < size; i3++) {
                ExternalAudioModule.AudioStatistics valueAt = longSparseArray.valueAt(i3);
                if (valueAt != null && i < valueAt.fractionLost) {
                    i = valueAt.fractionLost;
                }
            }
        } else {
            i = 0;
        }
        int size2 = longSparseArray2.size();
        if (size2 > 0) {
            i2 = 0;
            for (int i4 = 0; i4 < size2; i4++) {
                ExternalVideoModule.VideoStatistics valueAt2 = longSparseArray2.valueAt(i4);
                if (valueAt2 != null && i2 < valueAt2.fractionLost) {
                    i2 = valueAt2.fractionLost;
                }
            }
        } else {
            i2 = 0;
        }
        int max = Math.max(i, i2);
        if (max <= 0) {
            return 0;
        }
        return (int) (MyMathUtils.formatNumberDecimal(LocalSDKConstants.LEFT_DECIMAL_NUM, ((float) max) / 255.0f) * 100.0f);
    }

    public int getLocalVideoSendFps() {
        return this.mLocalVideoSendFps;
    }

    public RtcStats getRtcStats(String str) {
        synchronized (this.mLock) {
            RtcStats rtcStats = this.mRtcStatsList.get(str);
            if (rtcStats == null) {
                return null;
            }
            RtcStats clone = rtcStats.clone();
            return clone;
        }
    }

    public LocalAudioStats getLocalAudioStats() {
        LocalAudioStats clone;
        LocalAudioStats localAudioStats = this.mLocalAudioStats;
        if (localAudioStats == null) {
            return null;
        }
        synchronized (this.mLock) {
            clone = localAudioStats.clone();
        }
        return clone;
    }

    public LocalVideoStats getLocalVideoStats() {
        LocalVideoStats clone;
        LocalVideoStats localVideoStats = this.mLocalVideoStats;
        if (localVideoStats == null) {
            return null;
        }
        synchronized (this.mLock) {
            clone = localVideoStats.clone();
        }
        return clone;
    }

    public LongSparseArray<RemoteAudioStats> getRemoteAudioStats() {
        LongSparseArray<RemoteAudioStats> clone;
        LongSparseArray<RemoteAudioStats> longSparseArray = this.mRemoteAudioStats;
        if (longSparseArray == null) {
            return null;
        }
        synchronized (this.mLock) {
            clone = longSparseArray.clone();
        }
        return clone;
    }

    public HashMap<String, LongSparseArray<RemoteVideoStats>> getRemoteVideoStats() {
        HashMap<String, LongSparseArray<RemoteVideoStats>> hashMap;
        HashMap<String, LongSparseArray<RemoteVideoStats>> hashMap2 = this.mRemoteVideoStats;
        if (hashMap2 == null) {
            return null;
        }
        synchronized (this.mLock) {
            hashMap = (HashMap) hashMap2.clone();
        }
        return hashMap;
    }

    private LocalAudioStats calcAudioLocalStats() {
        int i;
        int i2;
        AudioEncodedConfig audioEncodedConfig;
        ExternalAudioModule instance = ExternalAudioModule.getInstance();
        calcAudioLocalBitrate(instance);
        int encodedFps = instance.getEncodedFps();
        if (encodedFps == 0) {
            encodedFps = this.mLastLocalAudioEncodedFps;
        } else {
            this.mLastLocalAudioEncodedFps = encodedFps;
        }
        ExternalAudioModule.LocalAudioStatistics localAudioStatistics = instance.getLocalAudioStatistics();
        int formatNumberDecimal = localAudioStatistics.fractionLost > 0 ? (int) MyMathUtils.formatNumberDecimal(LocalSDKConstants.LEFT_DECIMAL_NUM, (((float) localAudioStatistics.fractionLost) / 255.0f) * 100.0f) : 0;
        GlobalAudioConfig globalAudioConfig = GlobalHolder.getInstance().getGlobalAudioConfig();
        if (globalAudioConfig == null || (audioEncodedConfig = globalAudioConfig.getAudioEncodedConfig()) == null) {
            i2 = 0;
            i = 0;
        } else {
            i = audioEncodedConfig.mSampleRate;
            i2 = audioEncodedConfig.mChannelNum;
        }
        int transAudioLevelRange = MyMathUtils.transAudioLevelRange(instance.getAudioLevel("", 0, true));
        LocalAudioStats localAudioStats = new LocalAudioStats();
        localAudioStats.sentBitrate = Math.max(this.mLocalAudioSendPS, 0);
        localAudioStats.txPacketLossRate = Math.max(formatNumberDecimal, 0);
        localAudioStats.audioDelay = Math.max(localAudioStatistics.rttMs, 0);
        localAudioStats.audioEncodeFps = Math.max(encodedFps, 0);
        localAudioStats.sentSampleRate = Math.max(i, 0);
        localAudioStats.numChannels = Math.max(i2, 0);
        localAudioStats.volume = Math.max(transAudioLevelRange, 0);
        localAudioStats.rtt = Math.max(localAudioStatistics.rttMs, 0);
        return localAudioStats;
    }

    private LocalVideoStats calcVideoLocalStats() {
        int i;
        int i2;
        int i3;
        int i4;
        ExternalVideoModule instance = ExternalVideoModule.getInstance();
        calcVideoLocalRecvBitrate(instance);
        int[][] encoderParams = getEncoderParams();
        if (encoderParams != null) {
            int[] iArr = encoderParams[0];
            int[] iArr2 = encoderParams[1];
            i = iArr[0];
            i3 = iArr[1];
            i2 = iArr2[1];
            i4 = iArr2[0];
        } else {
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        ExternalVideoModule.LocalVideoStatistics localVideoStatistics = instance.getLocalVideoStatistics();
        int formatNumberDecimal = localVideoStatistics.V_SENDFRACTIONLOST > 0 ? (int) MyMathUtils.formatNumberDecimal(LocalSDKConstants.LEFT_DECIMAL_NUM, (((float) localVideoStatistics.V_SENDFRACTIONLOST) / 255.0f) * 100.0f) : 0;
        LocalVideoStats localVideoStats = new LocalVideoStats();
        localVideoStats.encodedFrameWidth = Math.max(i, 0);
        localVideoStats.encodedFrameHeight = Math.max(i3, 0);
        localVideoStats.sentBitrate = Math.max(localVideoStatistics.V_VBR / 1000, 0);
        localVideoStats.sentFrameRate = Math.max(localVideoStatistics.V_FPS, 0);
        localVideoStats.videoTargetBps = Math.max(i2 / 1000, 0);
        localVideoStats.videoTargetFps = Math.max(i4, 0);
        localVideoStats.txPacketLossRate = Math.max(formatNumberDecimal, 0);
        localVideoStats.videoBuffer = Math.max(instance.getBufferDuration(), 0);
        localVideoStats.delay = Math.max(localVideoStatistics.V_RTT, 0);
        localVideoStats.rtt = Math.max(localVideoStatistics.V_RTT, 0);
        return localVideoStats;
    }

    private int[][] getEncoderParams() {
        GlobalVideoConfig globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig();
        if (globalVideoConfig == null) {
            return null;
        }
        return new int[][]{globalVideoConfig.getVideoEncoderSize(), globalVideoConfig.getVideoEncoderTargetParams()};
    }

    private LongSparseArray<RemoteAudioStats> calcRemoteAudioStats(LongSparseArray<ExternalVideoModule.VideoStatistics> longSparseArray) {
        ExternalAudioModule.AudioStatistics valueAt;
        ExternalVideoModule.VideoStatistics videoStatistics;
        LongSparseArray<ExternalAudioModule.AudioStatistics> audioStatistics = ExternalAudioModule.getInstance().getAudioStatistics();
        if (audioStatistics == null || audioStatistics.size() <= 0) {
            return null;
        }
        LongSparseArray<RemoteAudioStats> longSparseArray2 = new LongSparseArray<>();
        int size = audioStatistics.size();
        for (int i = 0; i < size; i++) {
            long keyAt = audioStatistics.keyAt(i);
            if (keyAt > 0 && (valueAt = audioStatistics.valueAt(i)) != null) {
                int calcAudioRemoteBitrate = (int) calcAudioRemoteBitrate(keyAt, valueAt);
                int formatNumberDecimal = valueAt.fractionLost > 0 ? (int) MyMathUtils.formatNumberDecimal(LocalSDKConstants.LEFT_DECIMAL_NUM, (((float) valueAt.fractionLost) / 255.0f) * 100.0f) : 0;
                int audioLevel = ExternalAudioModule.getInstance().getAudioLevel("", keyAt, false);
                int i2 = (longSparseArray == null || (videoStatistics = longSparseArray.get(keyAt)) == null) ? 0 : videoStatistics.av_sync_diff;
                int transAudioLevelRange = MyMathUtils.transAudioLevelRange(audioLevel);
                RemoteAudioStats remoteAudioStats = new RemoteAudioStats(keyAt);
                remoteAudioStats.receivedBitrate = Math.max(calcAudioRemoteBitrate, 0);
                remoteAudioStats.audioLossRate = Math.max(formatNumberDecimal, 0);
                remoteAudioStats.jitterBufferDelay = Math.max(valueAt.delayMs, 0);
                remoteAudioStats.avDiff = i2;
                remoteAudioStats.audioVolume = Math.max(transAudioLevelRange, 0);
                remoteAudioStats.audioDecFps = Math.max(valueAt.decoderOutputFps, 0);
                remoteAudioStats.sampleRate = Math.max(valueAt.sampleRate, 0);
                remoteAudioStats.numChannels = Math.max(valueAt.channels, 0);
                remoteAudioStats.jitter = Math.max(valueAt.bufferDuration, 0);
                remoteAudioStats.decodeDur = Math.max(valueAt.decodeDur, 0);
                remoteAudioStats.rtt = Math.max(valueAt.rttMs, 0);
                longSparseArray2.put(keyAt, remoteAudioStats);
            }
        }
        return longSparseArray2;
    }

    private HashMap<String, LongSparseArray<RemoteVideoStats>> calcRemoteVideoStats(LongSparseArray<ExternalVideoModule.VideoStatistics> longSparseArray) {
        int size;
        long j;
        int i;
        int i2;
        int i3;
        VideoRemoteStatsBean videoDecoderStatsBean;
        LongSparseArray<ExternalVideoModule.VideoStatistics> longSparseArray2 = longSparseArray;
        if (longSparseArray2 == null || (size = longSparseArray.size()) <= 0) {
            return null;
        }
        HashMap<String, LongSparseArray<RemoteVideoStats>> hashMap = new HashMap<>();
        int i4 = 0;
        while (true) {
            j = 0;
            if (i4 >= size) {
                break;
            }
            long keyAt = longSparseArray2.keyAt(i4);
            ExternalVideoModule.VideoStatistics valueAt = longSparseArray2.valueAt(i4);
            if (keyAt > 0 && valueAt != null) {
                String str = valueAt.channelName;
                if (hashMap.get(str) == null) {
                    hashMap.put(str, new LongSparseArray());
                }
            }
            i4++;
        }
        GlobalVideoConfig globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig();
        int i5 = 0;
        while (i5 < size) {
            long keyAt2 = longSparseArray2.keyAt(i5);
            ExternalVideoModule.VideoStatistics valueAt2 = longSparseArray2.valueAt(i5);
            if (valueAt2 != null && keyAt2 > j) {
                String str2 = valueAt2.channelName;
                String str3 = valueAt2.devId;
                int formatNumberDecimal = valueAt2.fractionLost > 0 ? (int) (MyMathUtils.formatNumberDecimal(LocalSDKConstants.LEFT_DECIMAL_NUM, ((float) valueAt2.fractionLost) / 255.0f) * 100.0f) : 0;
                if (globalVideoConfig == null || (videoDecoderStatsBean = globalVideoConfig.getVideoDecoderStatsBean(String.valueOf(str2), keyAt2)) == null) {
                    i3 = 0;
                    i2 = 0;
                    i = 0;
                } else {
                    i = videoDecoderStatsBean.mDecodedFrameRate;
                    i2 = videoDecoderStatsBean.mDecodedElapsed;
                    i3 = i;
                }
                RemoteVideoStats remoteVideoStats = new RemoteVideoStats(keyAt2);
                remoteVideoStats.deviceId = str3;
                remoteVideoStats.width = Math.max(valueAt2.width, 0);
                remoteVideoStats.height = Math.max(valueAt2.height, 0);
                remoteVideoStats.receivedBitrate = Math.max(valueAt2.recvBitrate / 1000, 0);
                remoteVideoStats.decoderOutputFrameRate = Math.max(i, 0);
                remoteVideoStats.rendererOutputFrameRate = Math.max(i3, 0);
                remoteVideoStats.delay = Math.max(valueAt2.bufferDuration, 0);
                remoteVideoStats.latency = Math.max(valueAt2.delayMS, 0);
                remoteVideoStats.avDiff = valueAt2.av_sync_diff;
                remoteVideoStats.packetLossRate = Math.max(formatNumberDecimal, 0);
                remoteVideoStats.jitter = Math.max(valueAt2.jitter, 0);
                remoteVideoStats.decodeDur = Math.max(i2, 0);
                remoteVideoStats.rtt = Math.max(valueAt2.rtt, 0);
                LongSparseArray longSparseArray3 = hashMap.get(str2);
                if (longSparseArray3 != null) {
                    longSparseArray3.put(keyAt2, remoteVideoStats);
                }
            }
            i5++;
            j = 0;
        }
        return hashMap;
    }

    private void calcAudioLocalBitrate(ExternalAudioModule externalAudioModule) {
        if (this.mLastLocalAudioSendDataSize == 0) {
            this.mLastLocalAudioSendDataSize = externalAudioModule.getTotalSendBytes();
        } else {
            long totalSendBytes = externalAudioModule.getTotalSendBytes();
            this.mLocalAudioSendPS = (int) MyMathUtils.formatSpeedKbps(totalSendBytes - this.mLastLocalAudioSendDataSize, 1000);
            this.mLastLocalAudioSendDataSize = totalSendBytes;
        }
        if (this.mLastLocalAudioRecvDataSize == 0) {
            this.mLastLocalAudioRecvDataSize = externalAudioModule.getTotalRecvBytes();
            return;
        }
        long totalRecvBytes = externalAudioModule.getTotalRecvBytes();
        this.mLocalAudioRecvPS = (int) MyMathUtils.formatSpeedKbps(totalRecvBytes - this.mLastLocalAudioRecvDataSize, 1000);
        this.mLastLocalAudioRecvDataSize = totalRecvBytes;
    }

    private void calcVideoLocalSentBitrate() {
        long totalSendBytes = ExternalVideoModule.getInstance().getTotalSendBytes();
        long j = this.mLastLocalVideoTotalSendBytes;
        if (j == 0 || totalSendBytes < j) {
            this.mLastLocalVideoTotalSendBytes = totalSendBytes;
            return;
        }
        this.mLocalVideoSendBitrate = (int) MyMathUtils.formatSpeedKbps(totalSendBytes - j, System.currentTimeMillis() - this.mLastBuildTime);
        this.mLastLocalVideoTotalSendBytes = totalSendBytes;
    }

    private void calcVideoLocalSentFps() {
        long videoEncodedFrames = VideoStatus.getVideoEncodedFrames();
        long j = this.mLastLocalVideoSentFps;
        if (videoEncodedFrames <= j) {
            this.mLastLocalVideoSentFps = videoEncodedFrames;
            this.mLocalVideoSendFps = 0;
        } else if (j == 0) {
            this.mLastLocalVideoSentFps = videoEncodedFrames;
            this.mLocalVideoSendFps = 0;
        } else {
            int currentTimeMillis = (int) (((double) (((float) (videoEncodedFrames - this.mLastLocalVideoSentFps)) / (this.mLastBuildTime == 0 ? 1.0f : ((float) (System.currentTimeMillis() - this.mLastBuildTime)) / 1000.0f))) + 0.5d);
            this.mLocalVideoSendFps = currentTimeMillis;
            if (currentTimeMillis > 60) {
                this.mLocalVideoSendFps = 0;
            }
            this.mLastLocalVideoSentFps = videoEncodedFrames;
        }
    }

    private void calcVideoLocalRecvBitrate(ExternalVideoModule externalVideoModule) {
        if (this.mLastLocalVideoRecvDataSize == 0) {
            this.mLastLocalVideoRecvDataSize = externalVideoModule.getTotalRecvBytes();
        } else if (GlobalConfig.mVideoEnabled) {
            long totalRecvBytes = externalVideoModule.getTotalRecvBytes();
            this.mLocalVideoRecvPS = (int) MyMathUtils.formatSpeedKbps(totalRecvBytes - this.mLastLocalVideoRecvDataSize, 1000);
            this.mLastLocalVideoRecvDataSize = totalRecvBytes;
        } else {
            this.mLastLocalVideoRecvDataSize = 0;
        }
    }

    private float calcAudioRemoteBitrate(long j, ExternalAudioModule.AudioStatistics audioStatistics) {
        AudioRemoteStatisticalBean audioRemoteStatisticalBean = this.mAudioRemoteStatisticalBeanArray.get(Long.valueOf(j));
        if (audioRemoteStatisticalBean == null) {
            AudioRemoteStatisticalBean audioRemoteStatisticalBean2 = new AudioRemoteStatisticalBean();
            audioRemoteStatisticalBean2.mUid = j;
            audioRemoteStatisticalBean2.mRecvAudioDataSize = audioStatistics.recvLength;
            this.mAudioRemoteStatisticalBeanArray.put(Long.valueOf(j), audioRemoteStatisticalBean2);
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        float formatSpeedKbps = MyMathUtils.formatSpeedKbps(audioStatistics.recvLength - audioRemoteStatisticalBean.mRecvAudioDataSize, 1000);
        audioRemoteStatisticalBean.mRecvAudioDataSize = audioStatistics.recvLength;
        return formatSpeedKbps;
    }

    private static class AudioRemoteStatisticalBean {
        long mRecvAudioDataSize;
        long mUid;

        private AudioRemoteStatisticalBean() {
        }
    }
}
