package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.List;

public class SnapshotBean {
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

    public String toString() {
        return "MethodSnapshotBean{mThreadInfo=" + this.mThreadInfo + ", mMethodInfo=" + this.mMethodInfo + ", mNetworkInfo=" + this.mNetworkInfo + ", mDeviceStateInfo=" + this.mDeviceStateInfo + ", mNetworkStandard='" + this.mNetworkStandard + '\'' + '}';
    }
}
