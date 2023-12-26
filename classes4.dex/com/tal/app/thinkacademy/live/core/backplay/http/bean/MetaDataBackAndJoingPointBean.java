package com.tal.app.thinkacademy.live.core.backplay.http.bean;

public class MetaDataBackAndJoingPointBean {
    private long interval;
    private long joinRoomTime;
    private long leaveRoomTime;

    public long getLeaveRoomTime() {
        return this.leaveRoomTime;
    }

    public void setLeaveRoomTime(long j) {
        this.leaveRoomTime = j;
    }

    public long getJoinRoomTime() {
        return this.joinRoomTime;
    }

    public void setJoinRoomTime(long j) {
        this.joinRoomTime = j;
    }

    public long getInterval() {
        return this.interval;
    }

    public void setInterval(long j) {
        this.interval = j;
    }

    public long subDuration(long j, long j2, long j3) {
        long j4 = this.leaveRoomTime;
        if (j < j4 && j2 > this.joinRoomTime) {
            return j3 - this.interval;
        }
        if (j < j4 && j2 < this.joinRoomTime) {
            return j3 - (j2 - j4);
        }
        if (j <= j4) {
            return j3;
        }
        long j5 = this.joinRoomTime;
        return j2 > j5 ? j3 - (j5 - j) : j3;
    }

    public boolean containInInterval(long j, long j2) {
        return j > this.leaveRoomTime && j2 < this.joinRoomTime;
    }

    public boolean shouldSubInterval(long j) {
        return j > this.leaveRoomTime;
    }
}
