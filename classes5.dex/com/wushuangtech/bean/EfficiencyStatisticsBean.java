package com.wushuangtech.bean;

public class EfficiencyStatisticsBean {
    public int mAvgSpentTime;
    public int mMaxSpentTime;
    public int mMinSpentTime;
    public int mTotalSpentTime;
    public int mTotalStatisticsNums;

    public void calc(long j) {
        this.mTotalStatisticsNums++;
        int currentTimeMillis = (int) (System.currentTimeMillis() - j);
        int i = this.mTotalSpentTime + currentTimeMillis;
        this.mTotalSpentTime = i;
        this.mAvgSpentTime = i / this.mTotalStatisticsNums;
        if (this.mMaxSpentTime < currentTimeMillis) {
            this.mMaxSpentTime = currentTimeMillis;
        }
        if (currentTimeMillis > this.mMinSpentTime) {
            this.mMinSpentTime = currentTimeMillis;
        }
    }

    public String toString() {
        return "EfficiencyStatisticsBean{mTotalSpentTime=" + this.mTotalSpentTime + ", mTotalStatisticsNums=" + this.mTotalStatisticsNums + ", mAvgSpentTime=" + this.mAvgSpentTime + ", mMaxSpentTime=" + this.mMaxSpentTime + ", mMinSpentTime=" + this.mMinSpentTime + '}';
    }
}
