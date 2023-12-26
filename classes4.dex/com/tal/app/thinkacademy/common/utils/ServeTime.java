package com.tal.app.thinkacademy.common.utils;

import android.os.SystemClock;

public class ServeTime {
    private long baseTime;
    private long requestTimeOffset;
    private long startUpTime = SystemClock.elapsedRealtime();

    public ServeTime(long j) {
        this.baseTime = j;
    }

    public void setRequestTimeOffset(long j) {
        this.requestTimeOffset = j / 2;
    }

    public long getServeNowTime() {
        return this.baseTime + (((SystemClock.elapsedRealtime() - this.startUpTime) + this.requestTimeOffset) / 1000);
    }

    public long getServeNowMillsTime() {
        return (this.baseTime * 1000) + (SystemClock.elapsedRealtime() - this.startUpTime) + this.requestTimeOffset;
    }
}
