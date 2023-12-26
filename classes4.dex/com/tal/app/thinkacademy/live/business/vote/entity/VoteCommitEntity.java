package com.tal.app.thinkacademy.live.business.vote.entity;

public class VoteCommitEntity {
    int bizId;
    int classId;
    String interactionId;
    private int isplayback;
    String option;
    int planId;
    String stuIRCId;

    public void setIsplayback(int i) {
        this.isplayback = i;
    }

    public int getIsplayback() {
        return this.isplayback;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }

    public int getBizId() {
        return this.bizId;
    }

    public void setBizId(int i) {
        this.bizId = i;
    }

    public String getInteractionId() {
        return this.interactionId;
    }

    public void setInteractionId(String str) {
        this.interactionId = str;
    }

    public String getOption() {
        return this.option;
    }

    public void setOption(String str) {
        this.option = str;
    }

    public String getStuIRCId() {
        return this.stuIRCId;
    }

    public void setStuIRCId(String str) {
        this.stuIRCId = str;
    }

    public int getClassId() {
        return this.classId;
    }

    public void setClassId(int i) {
        this.classId = i;
    }
}
