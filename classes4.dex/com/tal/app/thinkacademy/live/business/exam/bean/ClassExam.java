package com.tal.app.thinkacademy.live.business.exam.bean;

public class ClassExam {
    private long beginTime;
    private String examName;
    private String examUrl;
    private String from;
    private boolean pub;
    private int status;
    private int totaltime;

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getTotaltime() {
        return this.totaltime;
    }

    public void setTotaltime(int i) {
        this.totaltime = i;
    }

    public boolean isPub() {
        return this.pub;
    }

    public void setPub(boolean z) {
        this.pub = z;
    }

    public String getExamName() {
        return this.examName;
    }

    public void setExamName(String str) {
        this.examName = str;
    }

    public String getExamUrl() {
        return this.examUrl;
    }

    public void setExamUrl(String str) {
        this.examUrl = str;
    }

    public long getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(long j) {
        this.beginTime = j;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }
}
