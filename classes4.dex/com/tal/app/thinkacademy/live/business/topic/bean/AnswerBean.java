package com.tal.app.thinkacademy.live.business.topic.bean;

public class AnswerBean {
    private boolean isSubmit;
    private boolean isTopLevel;
    private int level;
    private String nextTitle;
    private int rightCoin;
    private String title;
    private int userLatestCoin;

    public int getUserLatestCoin() {
        return this.userLatestCoin;
    }

    public void setUserLatestCoin(int i) {
        this.userLatestCoin = i;
    }

    public int getRightCoin() {
        return this.rightCoin;
    }

    public void setRightCoin(int i) {
        this.rightCoin = i;
    }

    public boolean isIsSubmit() {
        return this.isSubmit;
    }

    public void setIsSubmit(boolean z) {
        this.isSubmit = z;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getNextTitle() {
        return this.nextTitle;
    }

    public void setNextTitle(String str) {
        this.nextTitle = str;
    }

    public boolean isTopLevel() {
        return this.isTopLevel;
    }

    public void setTopLevel(boolean z) {
        this.isTopLevel = z;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }
}
