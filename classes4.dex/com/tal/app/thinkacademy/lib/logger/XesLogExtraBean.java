package com.tal.app.thinkacademy.lib.logger;

import com.tal.app.thinkacademy.lib.util.DeviceUtils;
import com.tal.app.thinkacademy.lib.util.PhoneUtils;
import com.tal.app.thinkacademy.lib.utils.TableUtils;

@Deprecated
public class XesLogExtraBean {
    private String appVersion;
    private String appVersionNumber;
    private String clientType;
    private String cpuArch;
    private String cpuFreq;
    private String cpuModel;
    private String deviceModel;
    private String identifierForClient;
    private String machineInfo;
    private int planId;
    private String schoolCode;
    private String systemName;
    private String systemVersion;
    private String totalMem;
    private String userAgent;
    private int userId;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static XesLogExtraBean instance = new XesLogExtraBean();

        private SingletonHolder() {
        }
    }

    private XesLogExtraBean() {
        this.clientType = "";
        this.appVersion = "2.19.1";
        this.systemVersion = DeviceUtils.getSDKVersionName();
        this.deviceModel = DeviceUtils.getModel();
        this.cpuFreq = PhoneUtils.getMaxCpuFreq();
        this.totalMem = PhoneUtils.getRomMaxMemory();
        if (TableUtils.isTable()) {
            setClientType("ANDROID_HD_STUDENT");
        } else {
            setClientType("ANDROID_PHONE_STUDENT");
        }
    }

    public static XesLogExtraBean getInstance() {
        return SingletonHolder.instance;
    }

    public String getClientType() {
        return this.clientType;
    }

    public void setClientType(String str) {
        this.clientType = str;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getSystemVersion() {
        return this.systemVersion;
    }

    public void setSystemVersion(String str) {
        this.systemVersion = str;
    }

    public String getSystemName() {
        return this.systemName;
    }

    public void setSystemName(String str) {
        this.systemName = str;
    }

    public String getAppVersionNumber() {
        return this.appVersionNumber;
    }

    public void setAppVersionNumber(String str) {
        this.appVersionNumber = str;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public String getMachineInfo() {
        return this.machineInfo;
    }

    public void setMachineInfo(String str) {
        this.machineInfo = str;
    }

    public String getIdentifierForClient() {
        return this.identifierForClient;
    }

    public void setIdentifierForClient(String str) {
        this.identifierForClient = str;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public String getCpuFreq() {
        return this.cpuFreq;
    }

    public void setCpuFreq(String str) {
        this.cpuFreq = str;
    }

    public String getCpuModel() {
        return this.cpuModel;
    }

    public void setCpuModel(String str) {
        this.cpuModel = str;
    }

    public String getCpuArch() {
        return this.cpuArch;
    }

    public void setCpuArch(String str) {
        this.cpuArch = str;
    }

    public String getTotalMem() {
        return this.totalMem;
    }

    public void setTotalMem(String str) {
        this.totalMem = str;
    }

    public int getPlanId() {
        return this.planId;
    }

    public void setPlanId(int i) {
        this.planId = i;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public String getSchoolCode() {
        return this.schoolCode;
    }

    public void setSchoolCode(String str) {
        this.schoolCode = str;
    }
}
