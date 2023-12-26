package com.tal.app.thinkacademy.live.core.live.http.bean;

import com.tal.app.thinkacademy.common.imconfig.ConfigServerInfo;
import java.util.List;

public class EnterConfigProxy {
    private EnterConfig enterConfig;

    public EnterConfigProxy(EnterConfig enterConfig2) {
        if (enterConfig2 == null) {
            this.enterConfig = new EnterConfig();
        } else {
            this.enterConfig = enterConfig2;
        }
    }

    public String getLiveTypeId() {
        return this.enterConfig.getLiveTypeId();
    }

    public String getAppId() {
        return this.enterConfig.getAppId();
    }

    public String getAppKey() {
        return this.enterConfig.getAppKey();
    }

    public String getIrcAK() {
        return this.enterConfig.getIrcAk();
    }

    public String getIrcSK() {
        return this.enterConfig.getIrcSk();
    }

    public String getIrcApiHost() {
        return this.enterConfig.getIrcApiHost();
    }

    public String getBusinessId() {
        return this.enterConfig.getBusinessId();
    }

    public String getStuIrcId() {
        return this.enterConfig.getStuIrcId();
    }

    public List<String> getIrcRooms() {
        return this.enterConfig.getIrcRooms();
    }

    public RtcConfig getRtcConfig() {
        return this.enterConfig.getRtcConfig();
    }

    public String getTutorIsRtc() {
        return this.enterConfig.getTutorIsRtc();
    }

    public String getBeforeClassFileId() {
        return this.enterConfig.getBeforeClassFileId();
    }

    public String getAfterClassFileId() {
        return this.enterConfig.getAfterClassFileId();
    }

    public String getFileId() {
        return this.enterConfig.getFileId();
    }

    public int getProtocol() {
        return this.enterConfig.getProtocol();
    }

    public String getTutorIrcId() {
        return this.enterConfig.getTutorIrcId();
    }

    public boolean isWallCanCorrect() {
        return this.enterConfig.isWallCanCorrect();
    }

    public boolean isRaiseHand() {
        EnterConfig enterConfig2 = this.enterConfig;
        if (enterConfig2 == null) {
            return false;
        }
        return enterConfig2.isRaiseHand();
    }

    public List<Long> getClassStudentList() {
        return this.enterConfig.getClassStudentList();
    }

    public String getIrcRoomId() {
        return this.enterConfig.getIrcRoomId();
    }

    public ConfigServerInfo.Servers.IRcProperty getIrcServer() {
        return this.enterConfig.getIrcServer();
    }
}
