package com.tal.app.thinkacademy.live.core.live.bean;

import com.tal.app.thinkacademy.common.entity.PlaybackUrlEntity;

public class LiveRoomData {
    private int bizId;
    private String courseId;
    private int followCoursewareRatio;
    private boolean isAuditor;
    private boolean isBindCourseware = true;
    private boolean isParentAudit = false;
    private String isTemp;
    private String lessonType;
    private String packageId;
    private String planId;
    private PlaybackUrlEntity playbackUrl;
    private String previousSource;
    private int rate;
    private String subPlatformType;
    private String updateUserInfo;

    public String getPlanId() {
        return this.planId;
    }

    public void setPlanId(String str) {
        this.planId = str;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String str) {
        this.courseId = str;
    }

    public int getBizId() {
        return this.bizId;
    }

    public void setBizId(int i) {
        this.bizId = i;
    }

    public String getUpdateUserInfo() {
        return this.updateUserInfo;
    }

    public void setUpdateUserInfo(String str) {
        this.updateUserInfo = str;
    }

    public String getSubPlatformType() {
        return this.subPlatformType;
    }

    public void setSubPlatformType(String str) {
        this.subPlatformType = str;
    }

    public void setIsTemp(String str) {
        this.isTemp = str;
    }

    public String getIsTemp() {
        return this.isTemp;
    }

    public boolean isBindCourseware() {
        return this.isBindCourseware;
    }

    public void setBindCourseware(boolean z) {
        this.isBindCourseware = z;
    }

    public boolean isParentAudit() {
        return this.isParentAudit;
    }

    public void setParentAudit(boolean z) {
        this.isParentAudit = z;
    }

    public boolean isAuditor() {
        return this.isAuditor;
    }

    public void setAuditor(boolean z) {
        this.isAuditor = z;
    }

    public String getLessonType() {
        return this.lessonType;
    }

    public void setLessonType(String str) {
        this.lessonType = str;
    }

    public String getPreviousSource() {
        return this.previousSource;
    }

    public void setPreviousSource(String str) {
        this.previousSource = str;
    }

    public String getPackageId() {
        return this.packageId;
    }

    public void setPackageId(String str) {
        this.packageId = str;
    }

    public PlaybackUrlEntity getPlaybackUrl() {
        return this.playbackUrl;
    }

    public void setPlaybackUrl(PlaybackUrlEntity playbackUrlEntity) {
        this.playbackUrl = playbackUrlEntity;
    }

    public int getRate() {
        return this.rate;
    }

    public void setRate(int i) {
        this.rate = i;
    }

    public int getFollowCoursewareRatio() {
        return this.followCoursewareRatio;
    }

    public void setFollowCoursewareRatio(int i) {
        this.followCoursewareRatio = i;
    }
}
