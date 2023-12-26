package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class DeviceInfoBean {
    @SerializedName("a")
    public String authority;
    @SerializedName("di")
    public String deviceId;
    @SerializedName("bn")
    public String mBrandName;
    @SerializedName("ch")
    public String mCpuHardware;
    @SerializedName("ci")
    public String mCpuInstructionSet;
    @SerializedName("cm")
    public String mCpuModel;
    @SerializedName("ds")
    public String mDisplaySize;
    @SerializedName("l")
    public String mLanguage;
    @SerializedName("m")
    public String mModel;
    @SerializedName("ram")
    public int mTotalRAM;
    @SerializedName("rom")
    public int mTotalROM;
    @SerializedName("ocv")
    public String osCustomVersion;
    @SerializedName("omv")
    public String osMajorVersion;
    @SerializedName("ot")
    public int osType;

    public String toString() {
        return "DeviceInfoBean{" + "mDeviceId='" + this.deviceId + '\'' + ", authority=" + this.authority + '\'' + ", mBrandName='" + this.mBrandName + '\'' + ", mModel='" + this.mModel + '\'' + ", mOsMajorVersion='" + this.osMajorVersion + '\'' + ", osCustomVersion='" + this.osCustomVersion + '\'' + ", osType='" + this.osType + '\'' + ", mTotalRAM=" + this.mTotalRAM + '\'' + ", mTotalROM=" + this.mTotalROM + '\'' + ", mLanguage='" + this.mLanguage + '\'' + ", mCpuHardware='" + this.mCpuHardware + '\'' + ", mCpuModel='" + this.mCpuModel + '\'' + ", mCpuInstructionSet='" + this.mCpuInstructionSet + '\'' + ", mDisplaySize='" + this.mDisplaySize + '\'' + '}';
    }
}
