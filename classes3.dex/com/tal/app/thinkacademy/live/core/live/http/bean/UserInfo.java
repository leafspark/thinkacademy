package com.tal.app.thinkacademy.live.core.live.http.bean;

public class UserInfo {
    private String avatar;
    private String englishName;
    private int goldNum;
    private String id;
    private int level;
    private String nickName;
    private int sex;
    private String title;
    private String userName;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public String getEnglishName() {
        return this.englishName;
    }

    public void setEnglishName(String str) {
        this.englishName = str;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public int getGoldNum() {
        return this.goldNum;
    }

    public void setGoldNum(int i) {
        this.goldNum = i;
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

    public String toString() {
        return "UserInfo{id='" + this.id + '\'' + ", name='" + this.userName + '\'' + ", nickName='" + this.nickName + '\'' + ", englishName='" + this.englishName + '\'' + ", sex=" + this.sex + ", avatar='" + this.avatar + '\'' + ", goldNum=" + this.goldNum + '}';
    }
}
