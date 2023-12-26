package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.Arrays;

public class LagResultBean {
    @SerializedName("ar")
    public ActivityResultBean mActivityResult;
    @SerializedName("cb")
    public String mCausedBy;
    @SerializedName("cg")
    public String mCrashGuid;
    @SerializedName("ds")
    public DeviceStateInfoBean mDeviceStateInfo;
    @SerializedName("ed")
    public String mErrorDump;
    public transient int mFps;
    @SerializedName("is")
    public IosSymbolicBean mIosSymbolic;
    @SerializedName("ns")
    public String mNetworkStandard;
    @SerializedName("st")
    public long mStartTimeUs;
    @SerializedName("ut")
    public UserTrackBean[] mUserTrack;

    public String toString() {
        return "LagResultBean{mFps=" + this.mFps + '\'' + ", mStartTimeUs=" + this.mStartTimeUs + '\'' + ", mIosSymbolic=" + this.mIosSymbolic + '\'' + ", mCausedBy='" + this.mCausedBy + '\'' + ", mCrashGuid='" + this.mCrashGuid + '\'' + ", mErrorDump='" + this.mErrorDump + '\'' + ", mDeviceStateInfo=" + this.mDeviceStateInfo + ", mNetworkStandard='" + this.mNetworkStandard + '\'' + ", mUserTrack=" + Arrays.toString(this.mUserTrack) + ", mActivityResult=" + this.mActivityResult + '}';
    }
}
