package com.tal.app.thinkacademy.live.business.vote.entity;

public class VoteBean {
    private int answerStat;
    private String contiRight;
    private int gold;
    private boolean isRepeat;
    private String option;
    public int userTotalGold;

    public int getGold() {
        return this.gold;
    }

    public void setGold(int i) {
        this.gold = i;
    }

    public String getOption() {
        return this.option;
    }

    public void setOption(String str) {
        this.option = str;
    }

    public boolean isIsRepeat() {
        return this.isRepeat;
    }

    public void setIsRepeat(boolean z) {
        this.isRepeat = z;
    }

    public int getAnswerStat() {
        return this.answerStat;
    }

    public void setAnswerStat(int i) {
        this.answerStat = i;
    }

    public String getContiRight() {
        return this.contiRight;
    }

    public void setContiRight(String str) {
        this.contiRight = str;
    }
}
