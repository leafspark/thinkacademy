package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.Arrays;

public class DefinedCrashLogBean {
    @SerializedName("cb")
    public String mCausedBy;
    @SerializedName("cg")
    public String mCrashId;
    @SerializedName("cst")
    public long mCrashStartTimeUs;
    @SerializedName("st")
    public long mCrashTime;
    @SerializedName("ds")
    public DeviceStateInfoBean mDeviceStateInfo;
    @SerializedName("ed")
    public String mErrorDump;
    @SerializedName("en")
    public String mErrorName;
    @SerializedName("is")
    public IosSymbolicBean mIosSymbolicBean;
    @SerializedName("lav")
    public String mLastAppVersion;
    @SerializedName("sl")
    public String mLogcatInfo;
    @SerializedName("ut")
    public UserTrackBean[] mUserTrack;

    public String toString() {
        return "DefinedCrashLogBean{" + "mCrashTime=" + this.mCrashTime + ", mErrorDump='" + this.mErrorDump + '\'' + ", mErrorName='" + this.mErrorName + '\'' + ", mCausedBy='" + this.mCausedBy + '\'' + ", mDeviceStateInfo=" + this.mDeviceStateInfo + ", mCrashId='" + this.mCrashId + '\'' + ", mLogcatInfo='" + this.mLogcatInfo + '\'' + ", mLastAppVersion='" + this.mLastAppVersion + '\'' + ", mUserTrack=" + Arrays.toString(this.mUserTrack) + ", mIosSymbolicBean=" + this.mIosSymbolicBean + ", mCrashStartTimeUs=" + this.mCrashStartTimeUs + '}';
    }
}
