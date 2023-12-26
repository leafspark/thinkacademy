package com.tal.app.thinkacademy.live.business.praise.bean;

public class CoinEntity {
    private String avatar;
    private int level;
    private String messageContent;
    private String messageTitle;
    private int rewardCoin;
    private String title;
    private int userLatestCoin;

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getMessageTitle() {
        return this.messageTitle;
    }

    public void setMessageTitle(String str) {
        this.messageTitle = str;
    }

    public String getMessageContent() {
        return this.messageContent;
    }

    public void setMessageContent(String str) {
        this.messageContent = str;
    }

    public int getRewardCoin() {
        return this.rewardCoin;
    }

    public void setRewardCoin(int i) {
        this.rewardCoin = i;
    }

    public int getUserLatestCoin() {
        return this.userLatestCoin;
    }

    public void setUserLatestCoin(int i) {
        this.userLatestCoin = i;
    }
}
