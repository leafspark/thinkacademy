package com.wushuangtech.library;

import android.text.TextUtils;
import android.util.LongSparseArray;
import com.wushuangtech.api.ExternalVideoModule;
import com.wushuangtech.bean.LogEvent;
import com.wushuangtech.library.video.VideoStatistical;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.library.video.bean.VideoRemoteStatsBean;
import com.wushuangtech.utils.OmniLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalVideoConfig {
    private static final String TAG = "GlobalVideoConfig";
    public static final int VIDEO_DEFAULT_CAMERA = 1;
    public static final int VIDEO_DEFAULT_CAMERA_ORIENTATION = 90;
    public static final int VIDEO_DEFAULT_ENCODE_BITRATE = 160000;
    public static final int VIDEO_DEFAULT_ENCODE_FPS = 15;
    public static final int VIDEO_DEFAULT_ENCODE_HEIGHT = 320;
    public static final int VIDEO_DEFAULT_ENCODE_I_INTERVAL = 1;
    public static final int VIDEO_DEFAULT_ENCODE_WIDTH = 240;
    private static final int VIDEO_RAW_DATA_WATCH_NUM = 10;
    private int mLocalVideoTotalRecvBitrate;
    private int mLocalVideoTotalSendBitrate;
    private int mSetVideoDualEncodeBitrate;
    private int mSetVideoDualEncodeFps;
    private int mSetVideoDualEncodeHeight;
    private int mSetVideoDualEncodeWidth;
    private int mSetVideoEncodeBitrate = VIDEO_DEFAULT_ENCODE_BITRATE;
    private int mSetVideoEncodeFps = 15;
    private int mSetVideoEncodeHeight = VIDEO_DEFAULT_ENCODE_HEIGHT;
    private int mSetVideoEncodeWidth = VIDEO_DEFAULT_ENCODE_WIDTH;
    private ConcurrentHashMap<String, LongSparseArray<VideoRemoteStatsBean>> mVideoDecodeStatsMap;
    private final Object mVideoDecodedFpsMapLock = new Object();
    private int mVideoEncodedMainBr;
    private int mVideoEncodedMainFps;
    private int mVideoEncodedMinorBr;
    private int mVideoEncodedMinorFps;
    private int mVideoEncoderMainBitrate;
    private int mVideoEncoderMainFps;
    private int mVideoEncoderMainHeight;
    private int mVideoEncoderMainType = 2;
    private int mVideoEncoderMainWidth;
    private int mVideoEncoderMinorBitrate;
    private int mVideoEncoderMinorFps;
    private int mVideoEncoderMinorHeight;
    private int mVideoEncoderMinorType = 2;
    private int mVideoEncoderMinorWidth;
    private final int[] mVideoLocalRawReportFps = new int[10];
    private int mVideoLocalRawReportFpsIndex;
    private VideoStatistical mVideoStatistical;
    private int mVideoTargetBitrate;
    private int mVideoTargetFps;

    public void init() {
        synchronized (this.mVideoDecodedFpsMapLock) {
            if (this.mVideoStatistical == null) {
                this.mVideoStatistical = new VideoStatistical();
            }
            if (this.mVideoDecodeStatsMap == null) {
                this.mVideoDecodeStatsMap = new ConcurrentHashMap<>();
            }
        }
    }

    public void unInit() {
        executeClearResource(true);
    }

    public void clearResource() {
        executeClearResource(false);
    }

    public void clearResource(String str) {
        LongSparseArray remove;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.mVideoDecodedFpsMapLock) {
                ConcurrentHashMap<String, LongSparseArray<VideoRemoteStatsBean>> concurrentHashMap = this.mVideoDecodeStatsMap;
                if (!(concurrentHashMap == null || (remove = concurrentHashMap.remove(str)) == null)) {
                    for (int i = 0; i < remove.size(); i++) {
                        VideoRemoteStatsBean videoRemoteStatsBean = (VideoRemoteStatsBean) remove.get((long) i);
                        if (videoRemoteStatsBean != null) {
                            if (videoRemoteStatsBean.mDecodedFrameReportRate != null) {
                                videoRemoteStatsBean.mDecodedFrameReportRate.clear();
                                videoRemoteStatsBean.mDecodedFrameReportRate = null;
                            }
                        }
                    }
                    remove.clear();
                }
            }
        }
    }

    private void executeClearResource(boolean z) {
        synchronized (this.mVideoDecodedFpsMapLock) {
            ConcurrentHashMap<String, LongSparseArray<VideoRemoteStatsBean>> concurrentHashMap = this.mVideoDecodeStatsMap;
            if (concurrentHashMap != null) {
                for (Map.Entry<String, LongSparseArray<VideoRemoteStatsBean>> value : concurrentHashMap.entrySet()) {
                    LongSparseArray longSparseArray = (LongSparseArray) value.getValue();
                    for (int i = 0; i < longSparseArray.size(); i++) {
                        VideoRemoteStatsBean videoRemoteStatsBean = (VideoRemoteStatsBean) longSparseArray.get((long) i);
                        if (videoRemoteStatsBean != null) {
                            if (videoRemoteStatsBean.mDecodedFrameReportRate != null) {
                                videoRemoteStatsBean.mDecodedFrameReportRate.clear();
                                videoRemoteStatsBean.mDecodedFrameReportRate = null;
                            }
                        }
                    }
                    longSparseArray.clear();
                }
                this.mVideoDecodeStatsMap.clear();
            }
            this.mVideoStatistical.clearResource();
            if (z) {
                this.mVideoDecodeStatsMap = null;
                this.mVideoStatistical = null;
            }
        }
        VideoStatus.resetStats();
    }

    public VideoStatistical getVideoStatistical() {
        return this.mVideoStatistical;
    }

    public void setVideoLocalRawReportFps(int i) {
        int i2 = this.mVideoLocalRawReportFpsIndex;
        int[] iArr = this.mVideoLocalRawReportFps;
        if (i2 == iArr.length) {
            this.mVideoLocalRawReportFpsIndex = 0;
        }
        int i3 = this.mVideoLocalRawReportFpsIndex;
        iArr[i3] = i;
        this.mVideoLocalRawReportFpsIndex = i3 + 1;
    }

    public void setVideoEncoderType(int i) {
        this.mVideoEncoderMainType = i;
    }

    public void setVideoEncoderParams(int i, int i2, int i3, int i4) {
        this.mVideoEncoderMainWidth = i;
        this.mVideoEncoderMainHeight = i2;
        this.mVideoEncoderMainFps = i3;
        this.mVideoEncoderMainBitrate = i4;
        String str = TAG;
        OmniLog.i(str, "Set video encoder params : " + i + " | height : " + i2 + " | fps : " + i3 + " | bitrate : " + i4);
    }

    public void setVideoEncoderMinorParams(int i, int i2, int i3, int i4) {
        this.mVideoEncoderMinorWidth = i;
        this.mVideoEncoderMinorHeight = i2;
        this.mVideoEncoderMinorFps = i3;
        this.mVideoEncoderMinorBitrate = i4;
        String str = TAG;
        OmniLog.i(str, "Set video encoder minor params : " + i + " | height : " + i2 + " | fps : " + i3 + " | bitrate : " + i4);
    }

    public void setUserVideoEncoderParams(int i, int i2, int i3, int i4) {
        this.mSetVideoEncodeWidth = i;
        this.mSetVideoEncodeHeight = i2;
        this.mSetVideoEncodeFps = i3;
        this.mSetVideoEncodeBitrate = i4;
        String str = TAG;
        OmniLog.d(str, "Set user target, video encode params : " + i + " | height : " + i2 + " | fps : " + i3 + " | bitrate : " + i4);
        ExternalVideoModule.getInstance().updateMaxBitrateControlParam(this.mSetVideoEncodeBitrate + this.mSetVideoDualEncodeBitrate, this.mSetVideoEncodeFps);
        if (GlobalConfig.mIsInRoom.get()) {
            GlobalHolder.getInstance().handleRtcEventReport(GlobalConfig.mLocalRoomName, LogEvent.VIDEO_LOCAL_ENC_PARAMS, Integer.valueOf(i4));
        }
    }

    public void setUserVideoDualEncodeParams(int i, int i2, int i3, int i4) {
        this.mSetVideoDualEncodeWidth = i;
        this.mSetVideoDualEncodeHeight = i2;
        this.mSetVideoDualEncodeFps = i3;
        this.mSetVideoDualEncodeBitrate = i4;
        String str = TAG;
        OmniLog.d(str, "Set user target, video dual encode params : " + i + " | height : " + i2 + " | fps : " + i3 + " | bitrate : " + i4);
        ExternalVideoModule.getInstance().updateMaxBitrateControlParam(this.mSetVideoEncodeBitrate + this.mSetVideoDualEncodeBitrate, this.mSetVideoEncodeFps);
    }

    public void setVideoEncoderParams(int i, int i2) {
        this.mVideoTargetFps = i;
        this.mVideoTargetBitrate = i2;
    }

    public void setVideoDecodeInputFps(String str, long j, int i) {
        VideoRemoteStatsBean videoDecoderStatsBean;
        if (!TextUtils.isEmpty(str) && j > 0 && (videoDecoderStatsBean = getVideoDecoderStatsBean(str, j)) != null) {
            videoDecoderStatsBean.mInputFpsForDecode = i;
        }
    }

    public void setVideoDecodedFps(String str, long j, int i) {
        VideoRemoteStatsBean videoDecoderStatsBean;
        if (!TextUtils.isEmpty(str) && j > 0 && (videoDecoderStatsBean = getVideoDecoderStatsBean(str, j)) != null) {
            videoDecoderStatsBean.mDecodedFrameRate = i;
        }
    }

    public void setVideoDecodedRenderFps(String str, long j, int i) {
        VideoRemoteStatsBean videoDecoderStatsBean;
        if (!TextUtils.isEmpty(str) && j > 0 && (videoDecoderStatsBean = getVideoDecoderStatsBean(str, j)) != null) {
            videoDecoderStatsBean.mRenderFrameRate = i;
        }
    }

    public void setVideoDecodedElapsed(String str, long j, int i) {
        VideoRemoteStatsBean videoDecoderStatsBean;
        if (!TextUtils.isEmpty(str) && j > 0 && (videoDecoderStatsBean = getVideoDecoderStatsBean(str, j)) != null) {
            videoDecoderStatsBean.mDecodedElapsed = i;
        }
    }

    public void setVideoDecodedFrameReport(String str, long j, int i) {
        VideoRemoteStatsBean videoDecoderStatsBean;
        if (!TextUtils.isEmpty(str) && j > 0 && (videoDecoderStatsBean = getVideoDecoderStatsBean(str, j)) != null) {
            synchronized (this.mVideoDecodedFpsMapLock) {
                if (videoDecoderStatsBean.mDecodedFrameReportRate != null) {
                    if (videoDecoderStatsBean.mDecodedFrameReportRateCacheSize >= 10) {
                        videoDecoderStatsBean.mDecodedFrameReportRate.poll();
                        videoDecoderStatsBean.mDecodedFrameReportRateCacheSize--;
                    }
                    videoDecoderStatsBean.mDecodedFrameReportRate.add(Integer.valueOf(i));
                    videoDecoderStatsBean.mDecodedFrameReportRateCacheSize++;
                }
            }
        }
    }

    public void setVideoEncodedMainBr(int i) {
        this.mVideoEncodedMainBr = i;
    }

    public void setVideoEncodedMainFps(int i) {
        this.mVideoEncodedMainFps = i;
    }

    public void setVideoEncodedMinorBr(int i) {
        this.mVideoEncodedMinorBr = i;
    }

    public void setVideoEncodedMinorFps(int i) {
        this.mVideoEncodedMinorFps = i;
    }

    public void setLocalVideoTotalSendBitrate(int i) {
        this.mLocalVideoTotalSendBitrate = i;
    }

    public void setLocalVideoTotalRecvBitrate(int i) {
        this.mLocalVideoTotalRecvBitrate = i;
    }

    public void addVideoRemoteRenderCaton(String str, long j) {
        VideoRemoteStatsBean videoDecoderStatsBean;
        if (!TextUtils.isEmpty(str) && j > 0 && (videoDecoderStatsBean = getVideoDecoderStatsBean(str, j)) != null) {
            videoDecoderStatsBean.mCatonCount++;
        }
    }

    public int[] getVideoLocalRawReportFps() {
        return this.mVideoLocalRawReportFps;
    }

    public int getVideoEncoderType() {
        return this.mVideoEncoderMainType;
    }

    public int[] getVideoEncoderSize() {
        return new int[]{this.mVideoEncoderMainWidth, this.mVideoEncoderMainHeight};
    }

    public int[] getVideoEncoderTargetParams() {
        return new int[]{this.mVideoTargetFps, this.mVideoTargetBitrate};
    }

    public int getSetVideoDualEncodeFps() {
        return this.mSetVideoDualEncodeFps;
    }

    public int getSetVideoDualEncodeBitrate() {
        return this.mSetVideoDualEncodeBitrate;
    }

    public VideoRemoteStatsBean getVideoDecoderStatsBean(String str, long j) {
        ConcurrentHashMap<String, LongSparseArray<VideoRemoteStatsBean>> concurrentHashMap;
        LongSparseArray longSparseArray;
        if (TextUtils.isEmpty(str) || j <= 0 || (concurrentHashMap = this.mVideoDecodeStatsMap) == null || (longSparseArray = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return (VideoRemoteStatsBean) longSparseArray.get(j);
    }

    public int getSetVideoEncodeBitrate() {
        return this.mSetVideoEncodeBitrate;
    }

    public int getVideoEncodedMainBr() {
        return this.mVideoEncodedMainBr;
    }

    public int getVideoEncodedMainFps() {
        return this.mVideoEncodedMainFps;
    }

    public int getVideoEncodedMinorBr() {
        return this.mVideoEncodedMinorBr;
    }

    public int getVideoEncodedMinorFps() {
        return this.mVideoEncodedMinorFps;
    }

    public int getLocalVideoTotalSendBitrate() {
        return this.mLocalVideoTotalSendBitrate;
    }

    public int getLocalVideoTotalRecvBitrate() {
        return this.mLocalVideoTotalRecvBitrate;
    }

    public void updateUserStatus(String str, long j, boolean z) {
        if (j > 0) {
            synchronized (this.mVideoDecodedFpsMapLock) {
                ConcurrentHashMap<String, LongSparseArray<VideoRemoteStatsBean>> concurrentHashMap = this.mVideoDecodeStatsMap;
                if (concurrentHashMap != null) {
                    LongSparseArray longSparseArray = concurrentHashMap.get(str);
                    if (z) {
                        if (longSparseArray == null) {
                            LongSparseArray longSparseArray2 = new LongSparseArray();
                            longSparseArray2.put(j, new VideoRemoteStatsBean());
                            this.mVideoDecodeStatsMap.put(str, longSparseArray2);
                        } else if (((VideoRemoteStatsBean) longSparseArray.get(j)) == null) {
                            longSparseArray.put(j, new VideoRemoteStatsBean());
                        }
                    } else if (longSparseArray != null) {
                        longSparseArray.remove(j);
                    }
                }
            }
            this.mVideoStatistical.updateUserStatus(str, j, z);
        }
    }

    public ConcurrentHashMap<String, LongSparseArray<VideoRemoteStatsBean>> getUserDecodeStatsMap() {
        return this.mVideoDecodeStatsMap;
    }
}
