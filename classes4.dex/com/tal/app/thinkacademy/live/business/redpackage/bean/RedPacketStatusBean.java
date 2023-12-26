package com.tal.app.thinkacademy.live.business.redpackage.bean;

public class RedPacketStatusBean {
    private int attendTime;
    private boolean isAttend;
    private int userId;

    public boolean isIsAttend() {
        return this.isAttend;
    }

    public void setIsAttend(boolean z) {
        this.isAttend = z;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public int getAttendTime() {
        return this.attendTime;
    }

    public void setAttendTime(int i) {
        this.attendTime = i;
    }
}
