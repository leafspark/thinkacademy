package com.tal.app.thinkacademy.live.business.exam.bean;

public class ExamInfo {
    private int duration;
    private int questionCount;
    private String reportUrl;
    private int showReportEnter;
    private int status;
    private String studentReportUrl;
    private String submitUrl;
    private String title;
    private int totalScore;

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public int getQuestionCount() {
        return this.questionCount;
    }

    public void setQuestionCount(int i) {
        this.questionCount = i;
    }

    public String getSubmitUrl() {
        return this.submitUrl;
    }

    public void setSubmitUrl(String str) {
        this.submitUrl = str;
    }

    public String getReportUrl() {
        return this.reportUrl;
    }

    public void setReportUrl(String str) {
        this.reportUrl = str;
    }

    public String getStudentReportUrl() {
        return this.studentReportUrl;
    }

    public void setStudentReportUrl(String str) {
        this.studentReportUrl = str;
    }

    public int getShowReportEnter() {
        return this.showReportEnter;
    }

    public void setShowReportEnter(int i) {
        this.showReportEnter = i;
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    public void setTotalScore(int i) {
        this.totalScore = i;
    }
}
