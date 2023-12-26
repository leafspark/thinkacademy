package com.tal.app.thinkacademy.live.core.irc.entity;

import java.util.List;

public class IrcInitEntity {
    private boolean alluser = false;
    private String businessId = "";
    private String classId = "";
    private String liveId;
    private String location = "China-aws";
    private String nickname;
    private List<String> roomIds;
    private String subBusinessId = "";

    public IrcInitEntity(String str, String str2, String str3, List<String> list) {
        this.nickname = str;
        this.liveId = str2;
        this.roomIds = list;
        this.businessId = str3;
    }

    public List<String> getRoomIds() {
        return this.roomIds;
    }

    public void setRoomIds(List<String> list) {
        this.roomIds = list;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public String getLiveId() {
        return this.liveId;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public String getBusinessId() {
        return this.businessId;
    }

    public void setBusinessId(String str) {
        this.businessId = str;
    }

    public String getSubBusinessId() {
        return this.subBusinessId;
    }

    public void setSubBusinessId(String str) {
        this.subBusinessId = str;
    }

    public String getClassId() {
        return this.classId;
    }

    public void setClassId(String str) {
        this.classId = str;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public boolean isAlluser() {
        return this.alluser;
    }

    public void setAlluser(boolean z) {
        this.alluser = z;
    }
}
