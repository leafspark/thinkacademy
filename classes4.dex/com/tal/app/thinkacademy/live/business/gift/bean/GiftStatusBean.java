package com.tal.app.thinkacademy.live.business.gift.bean;

public class GiftStatusBean {
    private int interactStatus;
    private int sendStatus;
    private int sendTimes;
    private int startTime;

    public int getSendTimes() {
        return this.sendTimes;
    }

    public void setSendTimes(int i) {
        this.sendTimes = i;
    }

    public int getSendStatus() {
        return this.sendStatus;
    }

    public void setSendStatus(int i) {
        this.sendStatus = i;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public void setStartTime(int i) {
        this.startTime = i;
    }

    public int getInteractStatus() {
        return this.interactStatus;
    }

    public void setInteractStatus(int i) {
        this.interactStatus = i;
    }

    public String toString() {
        return "GiftStatusBean{sendTimes=" + this.sendTimes + ", sendStatus=" + this.sendStatus + ", startTime=" + this.startTime + ", interactStatus=" + this.interactStatus + '}';
    }
}
