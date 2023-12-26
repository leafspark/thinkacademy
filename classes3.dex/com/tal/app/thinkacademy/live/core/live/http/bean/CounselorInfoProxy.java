package com.tal.app.thinkacademy.live.core.live.http.bean;

public class CounselorInfoProxy {
    private CounselorInfo mCounselorInfo;

    public CounselorInfoProxy(CounselorInfo counselorInfo) {
        this.mCounselorInfo = counselorInfo;
    }

    public String getId() {
        return this.mCounselorInfo.getId();
    }

    public String getName() {
        return this.mCounselorInfo.getName();
    }

    public String getNickName() {
        return this.mCounselorInfo.getNickName();
    }

    public String getSex() {
        return this.mCounselorInfo.getSex();
    }

    public String getAvatar() {
        return this.mCounselorInfo.getAvatar();
    }
}
