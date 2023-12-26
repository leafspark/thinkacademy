package com.wushuangtech.library.video.bean;

public class VideoStatsCalcBean {
    public String mChannelName;
    public long mLastCalcVideoRemoteRecvDataFpsTimestamp;
    public long mLastVideoLocalMainEncDataLen;
    public long mLastVideoLocalMainEncFrameCount;
    public long mLastVideoLocalMinorEncDataLen;
    public long mLastVideoLocalMinorEncFrameCount;
    public long mLastVideoLocalRawDataReportCount;
    public long mLastVideoRemoteDecodeCount;
    public long mLastVideoRemoteDecodeFpsTimestamp;
    public long mLastVideoRemoteRawReportCount;
    public long mLastVideoRemoteRawReportFpsTimestamp;
    public long mLastVideoRemoteRecvDataCount;
    public long mLastVideoRemoteRenderCount;
    public long mLastVideoRemoteRenderFpsTimestamp;
    public long mUid;
    public long mVideoLocalMainEncDataLen;
    public long mVideoLocalMainEncFrameCount;
    public long mVideoLocalMinorEncDataLen;
    public long mVideoLocalMinorEncFrameCount;
    public long mVideoLocalRawDataReportCount;
    public long mVideoRemoteDecodeCount;
    public long mVideoRemoteRawReportCount;
    public long mVideoRemoteRecvDataCount;
    public long mVideoRemoteRenderCount;

    public VideoStatsCalcBean(String str, long j) {
        this.mChannelName = str;
        this.mUid = j;
    }
}
