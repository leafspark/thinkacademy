package com.bonree.sdk.agent.business.entity.transfer;

import com.bonree.sdk.agent.business.entity.AppInfoBean;
import com.bonree.sdk.agent.business.entity.DataFusionInfo;
import com.bonree.sdk.agent.business.entity.DeviceInfoBean;
import com.bonree.sdk.agent.business.entity.NetWorkStateInfoBean;
import com.bonree.sdk.agent.business.entity.UserInfoBean;
import com.bonree.sdk.common.gson.annotations.SerializedName;

public class ConfigRequestBean {
    @SerializedName("ai")
    public AppInfoBean mAppInfo;
    @SerializedName("dfi")
    public DataFusionInfo mDataFusionInfo;
    @SerializedName("di")
    public DeviceInfoBean mDeviceInfo;
    @SerializedName("nsi")
    public NetWorkStateInfoBean mNetStateInfo;
    @SerializedName("ui")
    public UserInfoBean mUserInfo;
    @SerializedName("v")
    public String mVersion;

    public String toString() {
        return "ConfigRequestBean{mVersion='" + this.mVersion + '\'' + ", mDeviceInfo=" + this.mDeviceInfo + ", mDataFusionInfo=" + this.mDataFusionInfo + ", mAppInfo=" + this.mAppInfo + ", mUserInfo=" + this.mUserInfo + ", mNetStateInfo=" + this.mNetStateInfo + '}';
    }
}
