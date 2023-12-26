package com.tal.app.thinkacademy.live.core.live.http.bean;

public class TeacherInfo {
    private String avatar;
    private String id;
    private String name;
    private String nickName;
    private String sex;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String str) {
        this.sex = str;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public String toString() {
        return "TeacherInfo{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", nickName='" + this.nickName + '\'' + ", sex='" + this.sex + '\'' + ", avatar='" + this.avatar + '\'' + '}';
    }
}
