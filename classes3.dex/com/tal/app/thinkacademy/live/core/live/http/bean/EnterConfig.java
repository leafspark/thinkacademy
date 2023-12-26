package com.tal.app.thinkacademy.live.core.live.http.bean;

import com.tal.app.thinkacademy.common.imconfig.ConfigServerInfo;
import java.util.List;

public class EnterConfig {
    private String afterClassFileId;
    private String appId;
    private String appKey;
    private String beforeClassFileId;
    private String businessId;
    private List<Long> classStudentList;
    private String fileId;
    private String ircAk;
    private String ircApiHost;
    private String ircRoomId;
    private List<String> ircRooms;
    public ConfigServerInfo.Servers.IRcProperty ircServer;
    private String ircSk;
    private String liveTypeId;
    private int protocol;
    private boolean raiseHand = false;
    private RtcConfig rtcConfig;
    private String stuIrcId;
    private String tutorIrcId;
    private String tutorIsRtc;
    private boolean wallCanCorrect;

    public String getLiveTypeId() {
        return this.liveTypeId;
    }

    public void setLiveTypeId(String str) {
        this.liveTypeId = str;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public String getIrcAk() {
        return this.ircAk;
    }

    public void setIrcAk(String str) {
        this.ircAk = str;
    }

    public String getIrcSk() {
        return this.ircSk;
    }

    public void setIrcSk(String str) {
        this.ircSk = str;
    }

    public String getIrcApiHost() {
        return this.ircApiHost;
    }

    public void setIrcApiHost(String str) {
        this.ircApiHost = str;
    }

    public String getBusinessId() {
        return this.businessId;
    }

    public void setBusinessId(String str) {
        this.businessId = str;
    }

    public String getStuIrcId() {
        return this.stuIrcId;
    }

    public void setStuIrcId(String str) {
        this.stuIrcId = str;
    }

    public List<String> getIrcRooms() {
        return this.ircRooms;
    }

    public void setIrcRooms(List<String> list) {
        this.ircRooms = list;
    }

    public RtcConfig getRtcConfig() {
        return this.rtcConfig;
    }

    public void setRtcConfig(RtcConfig rtcConfig2) {
        this.rtcConfig = rtcConfig2;
    }

    public String getTutorIsRtc() {
        return this.tutorIsRtc;
    }

    public void setTutorIsRtc(String str) {
        this.tutorIsRtc = str;
    }

    public String getBeforeClassFileId() {
        return this.beforeClassFileId;
    }

    public void setBeforeClassFileId(String str) {
        this.beforeClassFileId = str;
    }

    public String getAfterClassFileId() {
        return this.afterClassFileId;
    }

    public void setAfterClassFileId(String str) {
        this.afterClassFileId = str;
    }

    public String getFileId() {
        return this.fileId;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public int getProtocol() {
        return this.protocol;
    }

    public void setProtocol(int i) {
        this.protocol = i;
    }

    public String getTutorIrcId() {
        return this.tutorIrcId;
    }

    public void setTutorIrcId(String str) {
        this.tutorIrcId = str;
    }

    public boolean isWallCanCorrect() {
        return this.wallCanCorrect;
    }

    public void setWallCanCorrect(boolean z) {
        this.wallCanCorrect = z;
    }

    public boolean isRaiseHand() {
        return this.raiseHand;
    }

    public void setRaiseHand(boolean z) {
        this.raiseHand = z;
    }

    public List<Long> getClassStudentList() {
        return this.classStudentList;
    }

    public void setClassStudentList(List<Long> list) {
        this.classStudentList = list;
    }

    public ConfigServerInfo.Servers.IRcProperty getIrcServer() {
        return this.ircServer;
    }

    public String getIrcRoomId() {
        return this.ircRoomId;
    }

    public void setIrcRoomId(String str) {
        this.ircRoomId = str;
    }
}
