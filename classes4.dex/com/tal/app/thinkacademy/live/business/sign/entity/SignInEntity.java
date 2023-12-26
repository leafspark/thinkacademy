package com.tal.app.thinkacademy.live.business.sign.entity;

public class SignInEntity {
    private int bizId;
    private int classId;
    private String englishName;
    private String id;
    private String nickname;
    private int planId;
    private String signExecuteURL;
    private int stuId;
    private String stuName;

    public String getEnglishName() {
        return this.englishName;
    }

    public void setEnglishName(String str) {
        this.englishName = str;
    }

    public int getClassId() {
        return this.classId;
    }

    public void setClassId(int i) {
        this.classId = i;
    }

    public String getSignExecuteURL() {
        return this.signExecuteURL;
    }

    public void setSignExecuteURL(String str) {
        this.signExecuteURL = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }

    public int getStuId() {
        return this.stuId;
    }

    public void setStuId(int i) {
        this.stuId = i;
    }

    public int getBizId() {
        return this.bizId;
    }

    public void setBizId(int i) {
        this.bizId = i;
    }

    public String getStuName() {
        return this.stuName;
    }

    public void setStuName(String str) {
        this.stuName = str;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }
}
