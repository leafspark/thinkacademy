package com.wushuangtech.library.video;

import android.text.TextUtils;
import com.wushuangtech.bean.LogEvent;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.GlobalVideoConfig;
import com.wushuangtech.library.video.bean.VideoStatsCalcBean;
import com.wushuangtech.utils.MyMathUtils;
import com.wushuangtech.utils.OmniLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoStatistical {
    private long mLastVideoLocalEncStartTimestamp;
    private long mVideoLocalEncEndTimestamp;
    private long mVideoLocalEncStartTimestamp;
    private final ConcurrentHashMap<Long, VideoStatsCalcBean> mVideoStatsCalcBeanMap = new ConcurrentHashMap<>();

    public void clearResource() {
        this.mVideoStatsCalcBeanMap.clear();
    }

    public void updateUserStatus(String str, long j, boolean z) {
        if (z) {
            this.mVideoStatsCalcBeanMap.put(Long.valueOf(j), new VideoStatsCalcBean(str, j));
            return;
        }
        this.mVideoStatsCalcBeanMap.remove(Long.valueOf(j));
    }

    public void updateVideoStats() {
        GlobalVideoConfig globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig();
        if (globalVideoConfig != null) {
            for (Map.Entry<Long, VideoStatsCalcBean> value : this.mVideoStatsCalcBeanMap.entrySet()) {
                VideoStatsCalcBean videoStatsCalcBean = (VideoStatsCalcBean) value.getValue();
                if (videoStatsCalcBean != null) {
                    if (videoStatsCalcBean.mUid == GlobalConfig.mLocalOwnerUid) {
                        globalVideoConfig.setVideoLocalRawReportFps(calcVideoLocalRawDataReportFps(videoStatsCalcBean));
                        calcVideoLocalEncKbps(videoStatsCalcBean);
                        calcVideoLocalEncFps(videoStatsCalcBean);
                    } else {
                        int calcVideoRemoteRecvDataFps = calcVideoRemoteRecvDataFps(videoStatsCalcBean);
                        int calcVideoRemoteDecodeFps = calcVideoRemoteDecodeFps(videoStatsCalcBean);
                        int calcVideoRemoteRenderFps = calcVideoRemoteRenderFps(videoStatsCalcBean);
                        int calcVideoRemoteRawReportFps = calcVideoRemoteRawReportFps(videoStatsCalcBean);
                        globalVideoConfig.setVideoDecodeInputFps(videoStatsCalcBean.mChannelName, videoStatsCalcBean.mUid, calcVideoRemoteRecvDataFps);
                        globalVideoConfig.setVideoDecodedFps(videoStatsCalcBean.mChannelName, videoStatsCalcBean.mUid, calcVideoRemoteDecodeFps);
                        globalVideoConfig.setVideoDecodedRenderFps(videoStatsCalcBean.mChannelName, videoStatsCalcBean.mUid, calcVideoRemoteRenderFps);
                        globalVideoConfig.setVideoDecodedFrameReport(videoStatsCalcBean.mChannelName, videoStatsCalcBean.mUid, calcVideoRemoteRawReportFps);
                    }
                }
            }
        }
    }

    public void updateVideoLocalRawDataReport() {
        VideoStatsCalcBean videoStatsCalcBean = this.mVideoStatsCalcBeanMap.get(Long.valueOf(GlobalConfig.mLocalOwnerUid));
        if (videoStatsCalcBean != null) {
            videoStatsCalcBean.mVideoLocalRawDataReportCount++;
        }
    }

    public void updateVideoLocalEncStats(boolean z, byte[] bArr) {
        VideoStatsCalcBean videoStatsCalcBean = this.mVideoStatsCalcBeanMap.get(Long.valueOf(GlobalConfig.mLocalOwnerUid));
        if (videoStatsCalcBean == null) {
            return;
        }
        if (z) {
            videoStatsCalcBean.mVideoLocalMinorEncDataLen += (long) bArr.length;
            videoStatsCalcBean.mVideoLocalMinorEncFrameCount++;
            return;
        }
        videoStatsCalcBean.mVideoLocalMainEncDataLen += (long) bArr.length;
        videoStatsCalcBean.mVideoLocalMainEncFrameCount++;
    }

    public void updateVideoLocalEncodeStart() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mVideoLocalEncStartTimestamp = currentTimeMillis;
        long j = this.mLastVideoLocalEncStartTimestamp;
        int i = (int) (currentTimeMillis - j);
        if ((j == 0 || i < 500) && this.mVideoLocalEncEndTimestamp != 0) {
            checkVideoLocalEncCaton();
        }
        this.mLastVideoLocalEncStartTimestamp = this.mVideoLocalEncStartTimestamp;
    }

    public void updateVideoLocalEncodeEnd() {
        if (this.mVideoLocalEncStartTimestamp != 0) {
            this.mVideoLocalEncEndTimestamp = System.currentTimeMillis();
            checkVideoLocalEncCaton();
        }
    }

    public void updateVideoRemoteRecvDataCount(long j) {
        VideoStatsCalcBean videoStatsCalcBean = this.mVideoStatsCalcBeanMap.get(Long.valueOf(j));
        if (videoStatsCalcBean != null) {
            videoStatsCalcBean.mVideoRemoteRecvDataCount++;
        }
    }

    public void updateVideoRemoteDecodeCount(long j) {
        VideoStatsCalcBean videoStatsCalcBean = this.mVideoStatsCalcBeanMap.get(Long.valueOf(j));
        if (videoStatsCalcBean != null) {
            videoStatsCalcBean.mVideoRemoteDecodeCount++;
        }
    }

    public void updateVideoRemoteRenderCount(long j) {
        VideoStatsCalcBean videoStatsCalcBean = this.mVideoStatsCalcBeanMap.get(Long.valueOf(j));
        if (videoStatsCalcBean != null) {
            videoStatsCalcBean.mVideoRemoteRenderCount++;
        }
    }

    public void updateVideoRemoteRawDataReport(long j) {
        VideoStatsCalcBean videoStatsCalcBean = this.mVideoStatsCalcBeanMap.get(Long.valueOf(j));
        if (videoStatsCalcBean != null) {
            videoStatsCalcBean.mVideoRemoteRawReportCount++;
        }
    }

    private int calcVideoLocalRawDataReportFps(VideoStatsCalcBean videoStatsCalcBean) {
        long j = videoStatsCalcBean.mLastVideoLocalRawDataReportCount;
        long j2 = videoStatsCalcBean.mVideoLocalRawDataReportCount;
        int i = (j <= 0 || j2 <= j) ? 0 : (int) (j2 - j);
        videoStatsCalcBean.mLastVideoLocalRawDataReportCount = j2;
        return i;
    }

    private void calcVideoLocalEncKbps(VideoStatsCalcBean videoStatsCalcBean) {
        VideoStatsCalcBean videoStatsCalcBean2 = videoStatsCalcBean;
        GlobalVideoConfig globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig();
        if (globalVideoConfig != null) {
            long j = videoStatsCalcBean2.mLastVideoLocalMainEncDataLen;
            long j2 = videoStatsCalcBean2.mVideoLocalMainEncDataLen;
            long j3 = videoStatsCalcBean2.mLastVideoLocalMinorEncDataLen;
            long j4 = videoStatsCalcBean2.mVideoLocalMinorEncDataLen;
            if (j == 0 || j2 < j) {
                globalVideoConfig.setVideoEncodedMainBr(0);
            } else {
                globalVideoConfig.setVideoEncodedMainBr((int) MyMathUtils.formatSpeedKbps(j2 - j, 1000));
            }
            videoStatsCalcBean2.mLastVideoLocalMainEncDataLen = j2;
            if (j3 == 0 || j4 < j3) {
                globalVideoConfig.setVideoEncodedMinorBr(0);
            } else {
                globalVideoConfig.setVideoEncodedMinorBr((int) MyMathUtils.formatSpeedKbps(j4 - j3, 1000));
            }
            videoStatsCalcBean2.mLastVideoLocalMinorEncDataLen = j4;
        }
    }

    private void calcVideoLocalEncFps(VideoStatsCalcBean videoStatsCalcBean) {
        GlobalVideoConfig globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig();
        if (globalVideoConfig != null) {
            long j = videoStatsCalcBean.mLastVideoLocalMainEncFrameCount;
            long j2 = videoStatsCalcBean.mVideoLocalMainEncFrameCount;
            long j3 = videoStatsCalcBean.mLastVideoLocalMinorEncFrameCount;
            long j4 = videoStatsCalcBean.mVideoLocalMinorEncFrameCount;
            if (j == 0 || j2 < j) {
                globalVideoConfig.setVideoEncodedMainFps(0);
            } else {
                globalVideoConfig.setVideoEncodedMainFps((int) (j2 - j));
            }
            videoStatsCalcBean.mLastVideoLocalMainEncFrameCount = j2;
            if (j3 == 0 || j4 < j3) {
                globalVideoConfig.setVideoEncodedMinorFps(0);
            } else {
                globalVideoConfig.setVideoEncodedMinorFps((int) (j4 - j3));
            }
            videoStatsCalcBean.mLastVideoLocalMinorEncFrameCount = j4;
        }
    }

    private int calcVideoRemoteRecvDataFps(VideoStatsCalcBean videoStatsCalcBean) {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        if (videoStatsCalcBean.mLastCalcVideoRemoteRecvDataFpsTimestamp == 0) {
            videoStatsCalcBean.mLastCalcVideoRemoteRecvDataFpsTimestamp = currentTimeMillis;
            videoStatsCalcBean.mLastVideoRemoteRecvDataCount = videoStatsCalcBean.mVideoRemoteRecvDataCount;
            return 0;
        }
        int i2 = (int) (currentTimeMillis - videoStatsCalcBean.mLastCalcVideoRemoteRecvDataFpsTimestamp);
        if (i2 < 1000 || (i = (int) (videoStatsCalcBean.mVideoRemoteRecvDataCount - videoStatsCalcBean.mLastVideoRemoteRecvDataCount)) == 0) {
            return 0;
        }
        if (((long) (i2 - 1000)) > 100) {
            i = (int) ((1000.0f / (((float) i2) / ((float) i))) + 0.5f);
        }
        videoStatsCalcBean.mLastVideoRemoteRecvDataCount = videoStatsCalcBean.mVideoRemoteRecvDataCount;
        videoStatsCalcBean.mLastCalcVideoRemoteRecvDataFpsTimestamp = currentTimeMillis;
        return i;
    }

    private int calcVideoRemoteDecodeFps(VideoStatsCalcBean videoStatsCalcBean) {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        if (videoStatsCalcBean.mLastVideoRemoteDecodeFpsTimestamp == 0) {
            videoStatsCalcBean.mLastVideoRemoteDecodeFpsTimestamp = currentTimeMillis;
            videoStatsCalcBean.mLastVideoRemoteDecodeCount = videoStatsCalcBean.mVideoRemoteDecodeCount;
            return 0;
        }
        int i2 = (int) (currentTimeMillis - videoStatsCalcBean.mLastVideoRemoteDecodeFpsTimestamp);
        if (i2 < 1000 || (i = (int) (videoStatsCalcBean.mVideoRemoteDecodeCount - videoStatsCalcBean.mLastVideoRemoteDecodeCount)) == 0) {
            return 0;
        }
        if (((long) (i2 - 1000)) > 100) {
            i = (int) ((1000.0f / (((float) i2) / ((float) i))) + 0.5f);
        }
        videoStatsCalcBean.mLastVideoRemoteDecodeCount = videoStatsCalcBean.mVideoRemoteDecodeCount;
        videoStatsCalcBean.mLastVideoRemoteDecodeFpsTimestamp = currentTimeMillis;
        return i;
    }

    private int calcVideoRemoteRenderFps(VideoStatsCalcBean videoStatsCalcBean) {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        if (videoStatsCalcBean.mLastVideoRemoteRenderFpsTimestamp == 0) {
            videoStatsCalcBean.mLastVideoRemoteRenderFpsTimestamp = currentTimeMillis;
            videoStatsCalcBean.mLastVideoRemoteRenderCount = videoStatsCalcBean.mVideoRemoteRenderCount;
            return 0;
        }
        int i2 = (int) (currentTimeMillis - videoStatsCalcBean.mLastVideoRemoteRenderFpsTimestamp);
        if (i2 < 1000 || (i = (int) (videoStatsCalcBean.mVideoRemoteRenderCount - videoStatsCalcBean.mLastVideoRemoteRenderCount)) == 0) {
            return 0;
        }
        if (((long) (i2 - 1000)) > 100) {
            i = (int) ((1000.0f / (((float) i2) / ((float) i))) + 0.5f);
        }
        videoStatsCalcBean.mLastVideoRemoteRenderCount = videoStatsCalcBean.mVideoRemoteRenderCount;
        videoStatsCalcBean.mLastVideoRemoteRenderFpsTimestamp = currentTimeMillis;
        return i;
    }

    private int calcVideoRemoteRawReportFps(VideoStatsCalcBean videoStatsCalcBean) {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        if (videoStatsCalcBean.mLastVideoRemoteRawReportFpsTimestamp == 0) {
            videoStatsCalcBean.mLastVideoRemoteRawReportFpsTimestamp = currentTimeMillis;
            videoStatsCalcBean.mLastVideoRemoteRawReportCount = videoStatsCalcBean.mVideoRemoteRawReportCount;
            return 0;
        }
        int i2 = (int) (currentTimeMillis - videoStatsCalcBean.mLastVideoRemoteRawReportFpsTimestamp);
        if (i2 < 1000 || (i = (int) (videoStatsCalcBean.mVideoRemoteRawReportCount - videoStatsCalcBean.mLastVideoRemoteRawReportCount)) == 0) {
            return 0;
        }
        if (((long) (i2 - 1000)) > 100) {
            i = (int) ((1000.0f / (((float) i2) / ((float) i))) + 0.5f);
        }
        videoStatsCalcBean.mLastVideoRemoteRawReportCount = videoStatsCalcBean.mVideoRemoteRawReportCount;
        videoStatsCalcBean.mLastVideoRemoteRawReportFpsTimestamp = currentTimeMillis;
        return i;
    }

    private void checkVideoLocalEncCaton() {
        int abs = (int) Math.abs(this.mVideoLocalEncEndTimestamp - this.mVideoLocalEncStartTimestamp);
        if (abs > 500) {
            String str = GlobalConfig.mAVUploadChannelName;
            long j = GlobalConfig.mLocalOwnerUid;
            if (TextUtils.isEmpty(str) || j == 0) {
                OmniLog.e("Check video local enc caton, report stuck event failed! channel name or uid is empty!");
                return;
            }
            GlobalHolder.getInstance().handleRtcEventReport(str, LogEvent.VIDEO_LOCAL_UPSTREAM_STUCK, String.valueOf(j), 2, Integer.valueOf(abs));
        }
    }
}
