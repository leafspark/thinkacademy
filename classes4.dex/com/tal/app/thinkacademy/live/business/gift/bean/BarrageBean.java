package com.tal.app.thinkacademy.live.business.gift.bean;

public class BarrageBean {
    private String icon_mobile;
    private String interactId;
    private String message;
    private String nickName;
    private long userId;

    public BarrageBean(String str, String str2, long j, String str3) {
        this.message = str;
        this.nickName = str2;
        this.userId = j;
        this.icon_mobile = str3;
    }

    public String getInteractId() {
        return this.interactId;
    }

    public void setInteractId(String str) {
        this.interactId = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String getIcon_mobile() {
        return this.icon_mobile;
    }

    public void setIcon_mobile(String str) {
        this.icon_mobile = str;
    }
}
