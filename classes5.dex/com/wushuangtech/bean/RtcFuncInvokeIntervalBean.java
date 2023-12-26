package com.wushuangtech.bean;

public class RtcFuncInvokeIntervalBean {
    public int mAvgInterval;
    public int mCount;
    public long mLastTimeMillis;
    public int mMaxInterval;
    public int mMinInterval;
    public long mTotalInterval;

    public String toString() {
        return "RtcFuncInvokeIntervalBean{, mCount=" + this.mCount + ", mTotalInterval=" + this.mTotalInterval + ", mMaxInterval=" + this.mMaxInterval + ", mMinInterval=" + this.mMinInterval + ", mAvgInterval=" + this.mAvgInterval + ", mLastTimeMillis=" + this.mLastTimeMillis + '}';
    }
}
