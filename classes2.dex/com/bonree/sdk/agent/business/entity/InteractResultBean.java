package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.List;

public class InteractResultBean {
    @SerializedName("ar")
    public ActivityResultBean mActivityResult;
    @SerializedName("ds")
    public DeviceStateInfoBean mDeviceStateInfo;
    @SerializedName("mi")
    public List<MethodInfoBeanOld> mMethodInfo;
    @SerializedName("ni")
    public List<NetworkInfoBean> mNetworkInfo;
    @SerializedName("ns")
    public String mNetworkStandard;
    @SerializedName("ti")
    public List<ThreadInfoBean> mThreadInfo;
    @SerializedName("ut")
    public UserTrackBean[] mUserTrack;

    public String toString() {
        return "InteractResultBean{mThreadInfo=" + this.mThreadInfo + ", mMethodInfo=" + this.mMethodInfo + ", mDeviceStateInfo=" + this.mDeviceStateInfo + ", mUserTrack=" + Arrays.toString(this.mUserTrack) + ", mActivityResult=" + this.mActivityResult + ", mNetworkInfo=" + this.mNetworkInfo + ", mNetworkStandard='" + this.mNetworkStandard + '\'' + '}';
    }
}
