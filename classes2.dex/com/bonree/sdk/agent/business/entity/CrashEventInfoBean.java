package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.List;
import java.util.UUID;

public class CrashEventInfoBean extends BaseEventInfo {
    private final transient int BACKGROUND = 2;
    private final transient int FOREGROUND = 1;
    @SerializedName("alt")
    public long appLaunchTime;
    @SerializedName("as")
    public int appState = 1;
    @SerializedName("cab")
    public String causedBy;
    @SerializedName("cp")
    public Integer crashPlatform;
    @SerializedName("cti")
    public String crashThreadId;
    @SerializedName("id")
    public String identifier = UUID.randomUUID().toString();
    @SerializedName("ic")
    public boolean iscustom = false;
    @SerializedName("mti")
    public String mainThreadId;
    public String nativeCrashLogPath;
    @SerializedName("p")
    public String param;
    @SerializedName("sl")
    public String systemLog;
    @SerializedName("tdi")
    public List<ThreadDumpInfoBean> threadDumpInfo;
    @SerializedName("tri")
    public List<Object> traceInfos;
    @SerializedName("t")
    public String type;

    public void setAppStateBackground(boolean z) {
        this.appState = z ? 2 : 1;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("CrashEventInfoBean{");
        stringBuffer.append("causedBy='");
        stringBuffer.append(this.causedBy);
        stringBuffer.append('\'');
        stringBuffer.append(", type='");
        stringBuffer.append(this.type);
        stringBuffer.append('\'');
        stringBuffer.append(", crashThreadId='");
        stringBuffer.append(this.crashThreadId);
        stringBuffer.append('\'');
        stringBuffer.append(", mainThreadId='");
        stringBuffer.append(this.mainThreadId);
        stringBuffer.append('\'');
        stringBuffer.append(", systemLog='");
        stringBuffer.append(this.systemLog);
        stringBuffer.append('\'');
        stringBuffer.append(", iscustom=");
        stringBuffer.append(this.iscustom);
        stringBuffer.append(", param='");
        stringBuffer.append(this.param);
        stringBuffer.append('\'');
        stringBuffer.append(", threadDumpInfo=");
        stringBuffer.append(this.threadDumpInfo);
        stringBuffer.append(", crashPlatform=");
        stringBuffer.append(this.crashPlatform);
        stringBuffer.append(", appLaunchTime=");
        stringBuffer.append(this.appLaunchTime);
        stringBuffer.append(", appState=");
        stringBuffer.append(this.appState);
        stringBuffer.append(", traceInfos=");
        stringBuffer.append(this.traceInfos);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
