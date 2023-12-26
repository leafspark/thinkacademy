package com.tal.app.thinkacademy.live.business.heartbeat.entity.request;

import java.util.Map;

public class HeartBeatBody {
    private int bizId;
    private int cameraState;
    private String classId;
    private String dottingTime;
    private int duration;
    private int fromType;
    private Map<String, Integer> ircCodeCount;
    private int ircCurrentCode;
    private boolean isLive;
    private int isParentAudition;
    private boolean isSuspend;
    private int kejianStatus;
    private int micStatus;
    private String planId;
    private int planStatus;
    private double rtcDownlinkPacketLossRate;
    private int rtcRoundTripDelayed;
    private String stuCouId;

    public HeartBeatBody() {
    }

    public HeartBeatBody(String str, int i, String str2, int i2, boolean z, int i3, String str3, int i4, boolean z2, String str4, int i5, Map<String, Integer> map, int i6, int i7, int i8, int i9, double d) {
        this.classId = str;
        this.bizId = i;
        this.planId = str2;
        this.planStatus = i2;
        this.isLive = z;
        this.fromType = i3;
        this.dottingTime = str3;
        this.duration = i4;
        this.isSuspend = z2;
        this.stuCouId = str4;
        this.kejianStatus = i5;
        this.ircCodeCount = map;
        this.ircCurrentCode = i6;
        this.rtcRoundTripDelayed = i7;
        this.micStatus = i9;
        this.rtcDownlinkPacketLossRate = d;
    }

    public String getClassId() {
        return this.classId;
    }

    public void setClassId(String str) {
        this.classId = str;
    }

    public int getBizId() {
        return this.bizId;
    }

    public void setBizId(int i) {
        this.bizId = i;
    }

    public String getPlanId() {
        return this.planId;
    }

    public void setPlanId(String str) {
        this.planId = str;
    }

    public int getPlanStatus() {
        return this.planStatus;
    }

    public void setPlanStatus(int i) {
        this.planStatus = i;
    }

    public boolean isLive() {
        return this.isLive;
    }

    public void setLive(boolean z) {
        this.isLive = z;
    }

    public int getFromType() {
        return this.fromType;
    }

    public void setFromType(int i) {
        this.fromType = i;
    }

    public String getDottingTime() {
        return this.dottingTime;
    }

    public void setDottingTime(String str) {
        this.dottingTime = str;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public boolean isSuspend() {
        return this.isSuspend;
    }

    public void setSuspend(boolean z) {
        this.isSuspend = z;
    }

    public String getStuCouId() {
        return this.stuCouId;
    }

    public void setStuCouId(String str) {
        this.stuCouId = str;
    }

    public int getKejianStatus() {
        return this.kejianStatus;
    }

    public void setKejianStatus(int i) {
        this.kejianStatus = i;
    }

    public Map<String, Integer> getIrcCodeCount() {
        return this.ircCodeCount;
    }

    public void setIrcCodeCount(Map<String, Integer> map) {
        this.ircCodeCount = map;
    }

    public int getIrcCurrentCode() {
        return this.ircCurrentCode;
    }

    public void setIrcCurrentCode(int i) {
        this.ircCurrentCode = i;
    }

    public int getRtcRoundTripDelayed() {
        return this.rtcRoundTripDelayed;
    }

    public void setRtcRoundTripDelayed(int i) {
        this.rtcRoundTripDelayed = i;
    }

    public double getRtcDownlinkPacketLossRate() {
        return this.rtcDownlinkPacketLossRate;
    }

    public void setRtcDownlinkPacketLossRate(double d) {
        this.rtcDownlinkPacketLossRate = d;
    }

    public int getMicStatus() {
        return this.micStatus;
    }

    public void setMicStatus(int i) {
        this.micStatus = i;
    }

    public int getIsParentAudition() {
        return this.isParentAudition;
    }

    public void setIsParentAudition(int i) {
        this.isParentAudition = i;
    }

    public int getCameraState() {
        return this.cameraState;
    }

    public void setCameraState(int i) {
        this.cameraState = i;
    }
}
