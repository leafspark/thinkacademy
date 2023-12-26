package com.tal.app.thinkacademy.live.core.backplay.http.bean;

public class TimePeriod {
    private long beginTime;
    private long endTime;

    public long getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(long j) {
        this.beginTime = j;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public String toString() {
        return "TimePeriod{beginTime=" + this.beginTime + ", endTime=" + this.endTime + '}';
    }
}
