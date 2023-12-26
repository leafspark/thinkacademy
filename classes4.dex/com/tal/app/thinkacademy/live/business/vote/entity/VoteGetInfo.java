package com.tal.app.thinkacademy.live.business.vote.entity;

public class VoteGetInfo {
    private int BizId;
    private int ClassId;
    private int Id;
    private String IrcNick;
    private String Url;
    private String interactionId;
    private String stuIRCId;

    public String getStuIRCId() {
        return this.stuIRCId;
    }

    public void setStuIRCId(String str) {
        this.stuIRCId = str;
    }

    public String getInteractionId() {
        return this.interactionId;
    }

    public void setInteractionId(String str) {
        this.interactionId = str;
    }

    public String getIrcNick() {
        return this.IrcNick;
    }

    public void setIrcNick(String str) {
        this.IrcNick = str;
    }

    public String getUrl() {
        return this.Url;
    }

    public void setUrl(String str) {
        this.Url = str;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int i) {
        this.Id = i;
    }

    public int getBizId() {
        return this.BizId;
    }

    public void setBizId(int i) {
        this.BizId = i;
    }

    public int getClassId() {
        return this.ClassId;
    }

    public void setClassId(int i) {
        this.ClassId = i;
    }
}
