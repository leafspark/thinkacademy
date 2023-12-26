package com.tal.app.thinkacademy.live.business.videocall.entity;

public class VideoCallRequestParams {
    public static final VideoSize HORIZONTAL_SIZE = new VideoSize(640, 480);
    public static final VideoSize PORTRAIT_SIZE = new VideoSize(480, 640);
    private String StuIrcId;
    private int bizId;
    private int classId;
    private String className;
    private int courseId;
    private String interactionId;
    private int linkType;
    private int planId;
    private String psId;
    private long roomId;
    private VideoSize startConfig;
    private int streamMode;
    private int stuId;
    private String stuName;
    private int teamId;

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }

    public int getClassId() {
        return this.classId;
    }

    public void setClassId(int i) {
        this.classId = i;
    }

    public int getTeamId() {
        return this.teamId;
    }

    public void setTeamId(int i) {
        this.teamId = i;
    }

    public String getStuIrcId() {
        return this.StuIrcId;
    }

    public void setStuIrcId(String str) {
        this.StuIrcId = str;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int i) {
        this.courseId = i;
    }

    public int getBizId() {
        return this.bizId;
    }

    public void setBizId(int i) {
        this.bizId = i;
    }

    public String getInteractionId() {
        return this.interactionId;
    }

    public void setInteractionId(String str) {
        this.interactionId = str;
    }

    public String getPsId() {
        return this.psId;
    }

    public void setPsId(String str) {
        this.psId = str;
    }

    public int getLinkType() {
        return this.linkType;
    }

    public void setLinkType(int i) {
        this.linkType = i;
    }

    public int getStreamMode() {
        return this.streamMode;
    }

    public void setStreamMode(int i) {
        this.streamMode = i;
    }

    public int getStuId() {
        return this.stuId;
    }

    public void setStuId(int i) {
        this.stuId = i;
    }

    public String getStuName() {
        return this.stuName;
    }

    public void setStuName(String str) {
        this.stuName = str;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public VideoSize getStartConfig() {
        return this.startConfig;
    }

    public void setStartConfig(VideoSize videoSize) {
        this.startConfig = videoSize;
    }

    public static class VideoSize {
        public int height;
        public int width;

        public VideoSize(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }

    public String toString() {
        return "VideoCallRequestParams{, planId=" + this.planId + ", classId=" + this.classId + ", teamId=" + this.teamId + ", StuIrcId='" + this.StuIrcId + '\'' + ", courseId=" + this.courseId + ", bizId=" + this.bizId + ", interactionId='" + this.interactionId + '\'' + ", psId='" + this.psId + '\'' + ", linkType=" + this.linkType + ", streamMode=" + this.streamMode + ", stuId=" + this.stuId + ", stuName='" + this.stuName + '\'' + ", className='" + this.className + '\'' + ", roomId='" + this.roomId + '\'' + '}';
    }
}
