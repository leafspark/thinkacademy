package com.tal.app.thinkacademy.live.core.live.http.bean;

public class UserInfoProxy {
    private UserInfo userInfo;

    public UserInfoProxy(UserInfo userInfo2) {
        this.userInfo = userInfo2;
    }

    public String getId() {
        return this.userInfo.getId();
    }

    public String getName() {
        return this.userInfo.getUserName();
    }

    public String getNickName() {
        return this.userInfo.getNickName();
    }

    public String getEnglishName() {
        return this.userInfo.getEnglishName();
    }

    public int getSex() {
        return this.userInfo.getSex();
    }

    public String getAvatar() {
        return this.userInfo.getAvatar();
    }

    public int getGoldNum() {
        return this.userInfo.getGoldNum();
    }

    public void setGoldNum(int i) {
        this.userInfo.setGoldNum(i);
    }

    public int getLevel() {
        return this.userInfo.getLevel();
    }

    public void setLevel(int i) {
        this.userInfo.setLevel(i);
    }

    public String getTitle() {
        return this.userInfo.getTitle();
    }

    public void setTitle(String str) {
        this.userInfo.setTitle(str);
    }
}
