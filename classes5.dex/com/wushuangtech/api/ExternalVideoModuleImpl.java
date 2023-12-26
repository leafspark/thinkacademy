package com.wushuangtech.api;

import android.util.LongSparseArray;
import com.wushuangtech.api.ExternalVideoModule;
import com.wushuangtech.api.ExternalVideoModuleCallback;
import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.bean.ServerConfigBean;
import com.wushuangtech.bean.VideoStuckStatsBean;
import com.wushuangtech.handler.RtcVideoStuckHandler;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.GlobalVideoConfig;
import com.wushuangtech.library.User;
import com.wushuangtech.library.video.VideoStatus;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExternalVideoModuleImpl extends ExternalVideoModule implements VideoSender {
    private static final String TAG = "ExternalVideoModule";
    private static byte[] startCode = {0, 0, 0, 1};
    private long encodedVideoSize = 0;
    private WeakReference<ExternalVideoModuleCallback> mCallback;
    private int mDrawFrameTimes;
    private ExternalVideoDecoderPluginCallback mExternalVideoDecoderPlugin;
    private int mLastDrawFrameTime;
    private int mLastDrawFrameTimeStamp;
    private int mLastDrawFrameTimes;
    private long mLastLocalVideoStatisticsTime;
    private long mLastVideoStatisticsTime;
    private final ExternalVideoModule.LocalVideoStatistics mLocalVideoStatistics = new ExternalVideoModule.LocalVideoStatistics();
    private final Object mLocalVideoStatisticsLock = new Object();
    private final RtcVideoStuckHandler mRtcVideoStuckHandler = new RtcVideoStuckHandler(this);
    private final ArrayList<VideoDynamicParam> mVideoDynamicParams = new ArrayList<>();
    private final LongSparseArray<ExternalVideoModule.VideoStatistics> mVideoStatistics = new LongSparseArray<>();
    private final Object mVideoStatisticsLock = new Object();
    private final long nativeMsDiff;
    private final Object videoDynamicMutex = new Object();

    public static class VideoDynamicParam {
        public int bitrate;
        public int fps;
        public long ts;
    }

    public static class VideoRecvLen {
        public int fecVecSize;
        public int recvLen;
        public int udpRecvLen;
    }

    private native int GetBufferDuration();

    private native int GetLastSliceQp();

    private native void GetLocalVideoStatistics();

    private native long GetNaitveTimeTick();

    private native int GetRecvDataErrorTimes();

    private native int GetSentFrameCount();

    private native long GetTotalRecvBytes();

    private native long GetTotalSendBytes();

    private native void GetVideoStatistics();

    private native boolean Initialize(ExternalVideoModuleImpl externalVideoModuleImpl);

    private native void InsertH264SeiContent(byte[] bArr, int i);

    private void OnVideoConnectFailed(String str, long j) {
    }

    private native void PushDualEncodedVideoData(byte[] bArr, int i, int i2, int i3, int i4, long j);

    private native void PushEncodedVideoData(byte[] bArr, int i, int i2, int i3, int i4, long j);

    private native void SendDualEncodedVideoFrame();

    private native void SendEncodedVideoFrame();

    private native void SetMaxBufferDuration(int i);

    private native void Uninitialize();

    private native void UpdateMaxBitrateControlParam(int i, int i2);

    public native void GetVdieoStuckStats();

    public int getRTT() {
        return 0;
    }

    ExternalVideoModuleImpl() {
        Initialize(this);
        this.nativeMsDiff = System.currentTimeMillis() - GetNaitveTimeTick();
    }

    public void setExternalVideoModuleCallback(ExternalVideoModuleCallback externalVideoModuleCallback) {
        this.mCallback = new WeakReference<>(externalVideoModuleCallback);
    }

    public void setExternalVideoDecoderPlugin(ExternalVideoDecoderPluginCallback externalVideoDecoderPluginCallback) {
        this.mExternalVideoDecoderPlugin = externalVideoDecoderPluginCallback;
    }

    public void initVideoGlobalConfig() {
        ExternalVideoModuleCallback callBack = getCallBack();
        if (callBack != null) {
            callBack.initVideoGlobalConfig();
        }
    }

    public void initVideoConfig(String str) {
        ExternalVideoModuleCallback callBack = getCallBack();
        if (callBack != null) {
            callBack.initVideoConfig(str);
        }
    }

    public void stopPlay(String str) {
        ExternalVideoModuleCallback externalVideoModuleCallback = (ExternalVideoModuleCallback) this.mCallback.get();
        if (externalVideoModuleCallback != null) {
            externalVideoModuleCallback.stopPlay(str);
        }
    }

    public void stopPlay(String str, String str2) {
        ExternalVideoModuleCallback externalVideoModuleCallback = (ExternalVideoModuleCallback) this.mCallback.get();
        if (externalVideoModuleCallback != null) {
            externalVideoModuleCallback.stopPlay(str, str2);
        }
    }

    public void stopAllPlay() {
        ExternalVideoModuleCallback externalVideoModuleCallback = (ExternalVideoModuleCallback) this.mCallback.get();
        if (externalVideoModuleCallback != null) {
            externalVideoModuleCallback.stopAllPlay();
        }
    }

    public void setBitrateMode(int i) {
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalVideoModuleCallback) this.mCallback.get()).setBitrateMode(i);
        }
    }

    public void setMaxBufferDuration(int i) {
        SetMaxBufferDuration(i);
    }

    public int getBufferDuration() {
        return GetBufferDuration();
    }

    public int getSentFrameCount() {
        return GetSentFrameCount();
    }

    public long getTotalSendBytes() {
        return GetTotalSendBytes();
    }

    public long getTotalRecvBytes() {
        return GetTotalRecvBytes();
    }

    public long getEncodeDataSize() {
        return this.encodedVideoSize;
    }

    public int getRecvDataErrorTimes() {
        return GetRecvDataErrorTimes();
    }

    public LongSparseArray<ExternalVideoModule.VideoStatistics> getVideoStatistics() {
        return executingGetVideoStatistics();
    }

    public LongSparseArray<ExternalVideoModule.VideoStatistics> getVideoStatistics(String str) {
        LongSparseArray<ExternalVideoModule.VideoStatistics> longSparseArray = new LongSparseArray<>();
        LongSparseArray<ExternalVideoModule.VideoStatistics> executingGetVideoStatistics = executingGetVideoStatistics();
        for (int i = 0; i < executingGetVideoStatistics.size(); i++) {
            long keyAt = executingGetVideoStatistics.keyAt(i);
            ExternalVideoModule.VideoStatistics valueAt = executingGetVideoStatistics.valueAt(i);
            if (valueAt != null && valueAt.channelName.equals(str)) {
                longSparseArray.append(keyAt, valueAt);
            }
        }
        return longSparseArray;
    }

    public ExternalVideoModule.LocalVideoStatistics getLocalVideoStatistics() {
        return executingGetLocalVideoStatistics();
    }

    public int getLastSliceQp() {
        return GetLastSliceQp();
    }

    public LinkedList<VideoStuckStatsBean> getStuck() {
        return this.mRtcVideoStuckHandler.getVideoStuckDatas();
    }

    public void getNativeVdieoStuckStats() {
        GetVdieoStuckStats();
    }

    public boolean isCapturing() {
        ExternalVideoModuleCallback callBack = getCallBack();
        if (callBack == null) {
            return false;
        }
        return callBack.isCapturing();
    }

    public int[] getEncodeSize() {
        GlobalVideoConfig globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig();
        if (globalVideoConfig == null) {
            return null;
        }
        return globalVideoConfig.getVideoEncoderSize();
    }

    public void insertH264SeiContent(byte[] bArr) {
        InsertH264SeiContent(bArr, bArr == null ? 0 : bArr.length);
    }

    public void updateMaxBitrateControlParam(int i, int i2) {
        UpdateMaxBitrateControlParam(i, i2);
    }

    public void updateServerConfig(List<ServerConfigBean> list) {
        ExternalVideoModuleCallback callBack = getCallBack();
        if (callBack != null) {
            callBack.updateServerConfig(list);
        }
    }

    public void updateVideoDecoderSpentTime() {
        ExternalVideoModuleCallback externalVideoModuleCallback = (ExternalVideoModuleCallback) this.mCallback.get();
        if (externalVideoModuleCallback != null) {
            externalVideoModuleCallback.updateVideoDecoderSpentTime();
        }
    }

    public void resetVideoDecoderStatus(CommonEventBean commonEventBean) {
        ExternalVideoModuleCallback externalVideoModuleCallback = (ExternalVideoModuleCallback) this.mCallback.get();
        if (externalVideoModuleCallback != null) {
            externalVideoModuleCallback.resetVideoDecoderStatus(commonEventBean);
        }
    }

    public ArrayList<VideoDynamicParam> getVideoDynamicParamHistory() {
        ArrayList<VideoDynamicParam> arrayList;
        synchronized (this.videoDynamicMutex) {
            arrayList = new ArrayList<>(this.mVideoDynamicParams);
        }
        return arrayList;
    }

    public void pushEncodedVideoData(ArrayList<byte[]> arrayList, ExternalVideoModuleCallback.VideoFrameType videoFrameType, int i, int i2, long j) {
        Iterator<byte[]> it = arrayList.iterator();
        while (it.hasNext()) {
            pushEncodedVideoData(it.next(), videoFrameType, i, i2, j);
        }
    }

    public void pushEncodedVideoData(byte[] bArr, ExternalVideoModuleCallback.VideoFrameType videoFrameType, int i, int i2, long j) {
        byte[] bArr2 = bArr;
        int i3 = videoFrameType == ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_I ? 1 : 0;
        this.encodedVideoSize += (long) bArr2.length;
        PushEncodedVideoData(bArr, bArr2.length, i3, i, i2, j - this.nativeMsDiff);
        SendEncodedVideoFrame();
        VideoStatus.addVideoSendFrames(false);
    }

    public void pushDualEncodedVideoData(ArrayList<byte[]> arrayList, ExternalVideoModuleCallback.VideoFrameType videoFrameType, int i, int i2, long j) {
        Iterator<byte[]> it = arrayList.iterator();
        while (it.hasNext()) {
            pushDualEncodedVideoData(it.next(), videoFrameType, i, i2, j);
        }
    }

    public void pushDualEncodedVideoData(byte[] bArr, ExternalVideoModuleCallback.VideoFrameType videoFrameType, int i, int i2, long j) {
        int i3;
        byte[] bArr2;
        if (videoFrameType == ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_I) {
            bArr2 = bArr;
            i3 = 1;
        } else {
            i3 = 0;
            bArr2 = bArr;
        }
        PushDualEncodedVideoData(bArr, bArr2.length, i3, i, i2, j - this.nativeMsDiff);
        SendDualEncodedVideoFrame();
        VideoStatus.addVideoSendFrames(true);
    }

    private ExternalVideoModule.LocalVideoStatistics executingGetLocalVideoStatistics() {
        ExternalVideoModule.LocalVideoStatistics localVideoStatistics;
        synchronized (this.mLocalVideoStatisticsLock) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.mLastLocalVideoStatisticsTime;
            boolean z = true;
            if (j == 0) {
                this.mLastLocalVideoStatisticsTime = currentTimeMillis;
            } else if (currentTimeMillis - j < 1000) {
                z = false;
            }
            if (z) {
                GetLocalVideoStatistics();
                this.mLastLocalVideoStatisticsTime = currentTimeMillis;
            }
            localVideoStatistics = new ExternalVideoModule.LocalVideoStatistics();
            localVideoStatistics.userId = this.mLocalVideoStatistics.userId;
            localVideoStatistics.V_SSRC = this.mLocalVideoStatistics.V_SSRC;
            localVideoStatistics.V_VBR = this.mLocalVideoStatistics.V_VBR;
            localVideoStatistics.V_RBR = this.mLocalVideoStatistics.V_RBR;
            localVideoStatistics.V_FBR = this.mLocalVideoStatistics.V_FBR;
            localVideoStatistics.V_FPS = this.mLocalVideoStatistics.V_FPS;
            localVideoStatistics.V_SENDBYTES = this.mLocalVideoStatistics.V_SENDBYTES;
            localVideoStatistics.V_SENDCOUNT = this.mLocalVideoStatistics.V_SENDCOUNT;
            localVideoStatistics.V_SENDFRACTIONLOST = this.mLocalVideoStatistics.V_SENDFRACTIONLOST;
            localVideoStatistics.V_RTT = this.mLocalVideoStatistics.V_RTT;
            localVideoStatistics.isValid = this.mLocalVideoStatistics.isValid;
            if (this.mLocalVideoStatistics.isValid) {
                localVideoStatistics.vmsInfo.msIp = this.mLocalVideoStatistics.vmsInfo.msIp;
                localVideoStatistics.vmsInfo.msId = this.mLocalVideoStatistics.vmsInfo.msId;
                localVideoStatistics.vmsInfo.msPort = this.mLocalVideoStatistics.vmsInfo.msPort;
                localVideoStatistics.vmsInfo.msIOType = this.mLocalVideoStatistics.vmsInfo.msIOType;
                localVideoStatistics.vmsInfo.msState = this.mLocalVideoStatistics.vmsInfo.msState;
            }
        }
        return localVideoStatistics;
    }

    private LongSparseArray<ExternalVideoModule.VideoStatistics> executingGetVideoStatistics() {
        synchronized (this.mVideoStatisticsLock) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.mLastVideoStatisticsTime;
            boolean z = true;
            if (j == 0) {
                this.mLastVideoStatisticsTime = currentTimeMillis;
            } else if (currentTimeMillis - j < 1000) {
                z = false;
            }
            if (z) {
                this.mVideoStatistics.clear();
                GetVideoStatistics();
                this.mLastVideoStatisticsTime = currentTimeMillis;
            }
        }
        return this.mVideoStatistics.clone();
    }

    private boolean StartCapture() {
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mCallback;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return ((ExternalVideoModuleCallback) this.mCallback.get()).startCapture();
    }

    private boolean StopCapture() {
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mCallback;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return ((ExternalVideoModuleCallback) this.mCallback.get()).stopCapture();
    }

    private boolean StartDualCapture() {
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mCallback;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return ((ExternalVideoModuleCallback) this.mCallback.get()).startDualCapture();
    }

    private boolean StopDualCapture() {
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mCallback;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return ((ExternalVideoModuleCallback) this.mCallback.get()).stopDualCapture();
    }

    private void ReceiveVideoData(byte[] bArr, String str, String str2, long j, int i, int i2, int i3) {
        ExternalVideoModuleCallback.VideoFrameType videoFrameType;
        int i4 = i3;
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            if (i4 == 1) {
                videoFrameType = ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_SPS_PPS;
            } else if (i4 == 2) {
                videoFrameType = ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_I;
            } else if (i4 == 3) {
                videoFrameType = ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_P;
            } else {
                videoFrameType = ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_INVALID;
            }
            ExternalVideoModuleCallback.VideoFrameType videoFrameType2 = videoFrameType;
            if (GlobalHolder.trunOnCallback) {
                ExternalVideoDecoderPluginCallback externalVideoDecoderPluginCallback = this.mExternalVideoDecoderPlugin;
                if (externalVideoDecoderPluginCallback != null) {
                    externalVideoDecoderPluginCallback.receiveVideoDataDecoderPlugin(bArr, str2, j, i, i2, videoFrameType2);
                    return;
                }
                WeakReference<ExternalVideoModuleCallback> weakReference2 = this.mCallback;
                if (weakReference2 != null && weakReference2.get() != null) {
                    ((ExternalVideoModuleCallback) this.mCallback.get()).receiveVideoData(str, bArr, str2, j, i, i2, videoFrameType2);
                }
            }
        }
    }

    private void ReceiveSeiData(byte[] bArr, long j, String str) {
        ExternalVideoDecoderPluginCallback externalVideoDecoderPluginCallback = this.mExternalVideoDecoderPlugin;
        if (externalVideoDecoderPluginCallback != null) {
            externalVideoDecoderPluginCallback.receiveSeiDataDecoderPlugin(bArr, j, str);
            return;
        }
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalVideoModuleCallback) this.mCallback.get()).receiveH264Sei(bArr, j, str);
        }
    }

    private void OnReportVideoStatistics(String str, long j, String str2, int i, long j2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, boolean z, String str3, int i23, int i24, String str4, int i25) {
        String str5 = str;
        long j3 = j;
        String str6 = str3;
        String str7 = str4;
        RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(str);
        if (userManager != null) {
            User user = userManager.getUser(j);
            int i26 = 0;
            boolean ismTimestampTrusted = user != null ? user.ismTimestampTrusted() : false;
            ExternalVideoModule.VideoStatistics videoStatistics = new ExternalVideoModule.VideoStatistics();
            videoStatistics.channelName = str5;
            videoStatistics.userId = j3;
            videoStatistics.devId = str2;
            videoStatistics.ssrc = i;
            videoStatistics.recvSize = j2;
            videoStatistics.recvFrames = i2;
            videoStatistics.lostFrames = i3;
            videoStatistics.recvBitrate = i4;
            videoStatistics.decodeBitrate = i5;
            videoStatistics.recvFramerate = i6;
            videoStatistics.bufferDuration = i7;
            if (ismTimestampTrusted) {
                i26 = i8;
            }
            videoStatistics.delayMS = i26;
            videoStatistics.recvPkts = i9;
            videoStatistics.fractionLost = i10;
            videoStatistics.rtt = i11;
            videoStatistics.lostRate = i12;
            videoStatistics.jitter = i13;
            videoStatistics.rDelay = i14;
            videoStatistics.lostDelay = i15;
            videoStatistics.rDelayFraction = i16;
            videoStatistics.lostDelayFraction = i17;
            videoStatistics.width = i18;
            videoStatistics.height = i19;
            videoStatistics.av_sync_diff = i20;
            videoStatistics.v_targetvbr = i21;
            videoStatistics.e2e_fraction_lost = i22;
            videoStatistics.isValid = z;
            if (str6 != null) {
                videoStatistics.vmsInfo.msIp = str6;
            }
            if (str7 != null) {
                videoStatistics.vmsInfo.msId = str7;
            }
            videoStatistics.vmsInfo.msPort = i23;
            videoStatistics.vmsInfo.msIOType = i24;
            videoStatistics.vmsInfo.msState = i25;
            this.mVideoStatistics.append(j, videoStatistics);
        }
    }

    private void OnReportLocalVideoStatistics(String str, long j, int i, int i2, int i3, int i4, int i5, int i6, long j2, int i7, int i8, int i9, boolean z, String str2, int i10, int i11, String str3, int i12) {
        boolean z2 = z;
        String str4 = str2;
        String str5 = str3;
        this.mLocalVideoStatistics.userId = j;
        this.mLocalVideoStatistics.V_SSRC = i;
        this.mLocalVideoStatistics.V_VBR = i2;
        this.mLocalVideoStatistics.V_RBR = i3;
        this.mLocalVideoStatistics.V_FBR = i4;
        this.mLocalVideoStatistics.V_FPS = i5;
        this.mLocalVideoStatistics.V_SFPS = i6;
        this.mLocalVideoStatistics.V_SENDBYTES = j2;
        this.mLocalVideoStatistics.V_SENDCOUNT = i7;
        this.mLocalVideoStatistics.V_SENDFRACTIONLOST = i8;
        this.mLocalVideoStatistics.V_RTT = i9;
        this.mLocalVideoStatistics.isValid = z2;
        if (z2) {
            if (str4 != null) {
                this.mLocalVideoStatistics.vmsInfo.msIp = str4;
            }
            if (str5 != null) {
                this.mLocalVideoStatistics.vmsInfo.msId = str5;
            }
            this.mLocalVideoStatistics.vmsInfo.msPort = i10;
            this.mLocalVideoStatistics.vmsInfo.msIOType = i11;
            this.mLocalVideoStatistics.vmsInfo.msState = i12;
        }
    }

    private void OnReportVideoStuckStat(String str, long j, int i, int i2, long j2) {
        this.mRtcVideoStuckHandler.receiveVideoStuckStats(str, j, i, i2, j2);
    }

    private void OnSignalDisconnect() {
        this.encodedVideoSize = 0;
    }

    private void RequestIFrame() {
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalVideoModuleCallback) this.mCallback.get()).requestIFrame();
        }
    }

    private void RequestDualIFrame() {
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalVideoModuleCallback) this.mCallback.get()).requestDualIFrame();
        }
    }

    private int MaxFps(boolean z) {
        ExternalVideoModuleCallback callBack = getCallBack();
        if (callBack == null) {
            return 0;
        }
        if (z) {
            return callBack.dualMaxFps();
        }
        return callBack.maxFps();
    }

    private int MaxBitrate(boolean z) {
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mCallback;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        if (z) {
            return ((ExternalVideoModuleCallback) this.mCallback.get()).dualMaxBitrate();
        }
        return ((ExternalVideoModuleCallback) this.mCallback.get()).maxBitrate();
    }

    private void ChangeEncParam(boolean z, int i, int i2) {
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            if (z) {
                ((ExternalVideoModuleCallback) this.mCallback.get()).changeDualEncParam(i, i2);
                return;
            }
            VideoDynamicParam videoDynamicParam = new VideoDynamicParam();
            videoDynamicParam.bitrate = i;
            videoDynamicParam.fps = i2;
            videoDynamicParam.ts = System.currentTimeMillis();
            synchronized (this.videoDynamicMutex) {
                this.mVideoDynamicParams.add(videoDynamicParam);
            }
            ((ExternalVideoModuleCallback) this.mCallback.get()).changeEncParam(i, i2);
        }
    }

    private void operaFileData(byte[] bArr, int i, int i2) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File("/mnt/sdcard/pushed.h264"), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr, i, i2);
            fileOutputStream.flush();
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            fileOutputStream.close();
        } catch (IOException e4) {
            e4.printStackTrace();
            fileOutputStream.close();
        } catch (Exception e5) {
            e5.printStackTrace();
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            throw th;
        }
    }

    private void operaFileData2(byte[] bArr, int i, int i2) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File("/storage/emulated/0/pulled.h264"), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr, i, i2);
            fileOutputStream.flush();
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            fileOutputStream.close();
        } catch (IOException e4) {
            e4.printStackTrace();
            fileOutputStream.close();
        } catch (Exception e5) {
            e5.printStackTrace();
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            throw th;
        }
    }

    private ExternalVideoModuleCallback getCallBack() {
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mCallback;
        if (weakReference == null) {
            return null;
        }
        return (ExternalVideoModuleCallback) weakReference.get();
    }
}
