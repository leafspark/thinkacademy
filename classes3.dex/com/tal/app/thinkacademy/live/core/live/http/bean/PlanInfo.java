package com.tal.app.thinkacademy.live.core.live.http.bean;

public class PlanInfo {
    private long endStampTime;
    private String gradeIds;
    private String gradeName;
    private String id;
    private String liveTypeId;
    private String name;
    private long packageId;
    private int pattern;
    private long startStampTime;
    private String subjectIds;
    private String subjectName;

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

    public int getPattern() {
        return this.pattern;
    }

    public void setPattern(int i) {
        this.pattern = i;
    }

    public long getStartStampTime() {
        return this.startStampTime;
    }

    public void setStartStampTime(long j) {
        this.startStampTime = j;
    }

    public long getEndStampTime() {
        return this.endStampTime;
    }

    public void setEndStampTime(long j) {
        this.endStampTime = j;
    }

    public String getSubjectIds() {
        return this.subjectIds;
    }

    public void setSubjectIds(String str) {
        this.subjectIds = str;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public void setSubjectName(String str) {
        this.subjectName = str;
    }

    public String getGradeIds() {
        return this.gradeIds;
    }

    public void setGradeIds(String str) {
        this.gradeIds = str;
    }

    public String getGradeName() {
        return this.gradeName;
    }

    public void setGradeName(String str) {
        this.gradeName = str;
    }

    public String getLiveTypeId() {
        return this.liveTypeId;
    }

    public void setLiveTypeId(String str) {
        this.liveTypeId = str;
    }

    public long getPackageId() {
        return this.packageId;
    }

    public void setPackageId(long j) {
        this.packageId = j;
    }

    public String toString() {
        return "PlanInfo{id=" + this.id + ", name='" + this.name + '\'' + ", pattern=" + this.pattern + ", startStampTime=" + this.startStampTime + ", endStampTime=" + this.endStampTime + ", subjectIds='" + this.subjectIds + '\'' + ", subjectName='" + this.subjectName + '\'' + ", gradeIds='" + this.gradeIds + '\'' + ", gradeName='" + this.gradeName + '\'' + ", packageId='" + this.packageId + '\'' + '}';
    }
}
