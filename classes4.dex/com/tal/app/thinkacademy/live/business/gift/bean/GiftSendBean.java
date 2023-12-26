package com.tal.app.thinkacademy.live.business.gift.bean;

public class GiftSendBean {
    private int sendStatus;
    private int sendTimes;
    private int userLatestCoin;

    public int getSendTimes() {
        return this.sendTimes;
    }

    public void setSendTimes(int i) {
        this.sendTimes = i;
    }

    public int getUserLatestCoin() {
        return this.userLatestCoin;
    }

    public void setUserLatestCoin(int i) {
        this.userLatestCoin = i;
    }

    public int getSendStatus() {
        return this.sendStatus;
    }

    public void setSendStatus(int i) {
        this.sendStatus = i;
    }
}
