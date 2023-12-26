package com.wushuangtech.library.video.bean;

import java.util.concurrent.ConcurrentLinkedQueue;

public class VideoRemoteStatsBean {
    public int mCatonCount;
    public int mDecodeFailedFrameRate;
    public int mDecodedElapsed;
    public int mDecodedFrameRate;
    public ConcurrentLinkedQueue<Integer> mDecodedFrameReportRate = new ConcurrentLinkedQueue<>();
    public int mDecodedFrameReportRateCacheSize;
    public int mInputFpsForDecode;
    public int mRenderFrameRate;
}
