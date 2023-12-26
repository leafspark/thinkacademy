package com.tal.app.thinkacademy.live.business.canvastriplescreen.entity;

public class CoursewareLoadBean {
    private String coursewareId;
    private int isOnlineUrl;
    private int isPlayback;
    private int isSuccess;
    private long loadTime;
    private String url;

    public CoursewareLoadBean(String str, String str2, int i, long j, int i2, int i3) {
        this.coursewareId = str;
        this.url = str2;
        this.isOnlineUrl = i;
        this.loadTime = j;
        this.isSuccess = i2;
        this.isPlayback = i3;
    }

    public String getCoursewareId() {
        return this.coursewareId;
    }

    public void setCoursewareId(String str) {
        this.coursewareId = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public int getIsOnlineUrl() {
        return this.isOnlineUrl;
    }

    public void setIsOnlineUrl(int i) {
        this.isOnlineUrl = i;
    }

    public long getLoadTime() {
        return this.loadTime;
    }

    public void setLoadTime(long j) {
        this.loadTime = j;
    }

    public int getIsSuccess() {
        return this.isSuccess;
    }

    public void setIsSuccess(int i) {
        this.isSuccess = i;
    }

    public int getIsPlayback() {
        return this.isPlayback;
    }

    public void setIsPlayback(int i) {
        this.isPlayback = i;
    }
}
