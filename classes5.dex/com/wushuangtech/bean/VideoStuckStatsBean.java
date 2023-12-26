package com.wushuangtech.bean;

public class VideoStuckStatsBean {
    public String mChannelName;
    public int mStats;
    public long mStuckMs;
    public long mTimeStamp;
    public long mUid;

    public String toString() {
        return "VideoStuckStatsBean{mChannelId=" + this.mChannelName + ", mStats=" + this.mStats + ", mStats=" + this.mStats + ", mStuckMs=" + this.mStuckMs + ", mTimeStamp=" + this.mTimeStamp + '}';
    }
}
