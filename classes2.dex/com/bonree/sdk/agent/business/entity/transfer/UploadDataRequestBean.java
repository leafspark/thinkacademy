package com.bonree.sdk.agent.business.entity.transfer;

import com.bonree.sdk.agent.business.entity.AppInfoBean;
import com.bonree.sdk.agent.business.entity.AppStateInfoBean;
import com.bonree.sdk.agent.business.entity.DataFusionInfo;
import com.bonree.sdk.agent.business.entity.DeviceInfoBean;
import com.bonree.sdk.agent.business.entity.DeviceStateInfoBean;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.NetWorkStateInfoBean;
import com.bonree.sdk.agent.business.entity.TrafficUsageBean;
import com.bonree.sdk.agent.business.entity.UserInfoBean;
import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

public class UploadDataRequestBean {
    @SerializedName("ai")
    public AppInfoBean mAppInfo;
    @SerializedName("as")
    public AppStateInfoBean mAppStateInfo;
    @SerializedName("cmt")
    public long mConfigMonitorTime;
    @SerializedName("dfi")
    public DataFusionInfo mDataFusionInfo;
    @SerializedName("di")
    public DeviceInfoBean mDeviceInfo;
    @SerializedName("ds")
    public Map<String, DeviceStateInfoBean> mDeviceStateInfo;
    @SerializedName("e")
    public List<EventBean> mEvents;
    @SerializedName("fui")
    public String mFirstUserInfo;
    @SerializedName("mt")
    public long mMonitorTime;
    @SerializedName("nsi")
    public Map<String, NetWorkStateInfoBean> mNetWorkStateInfo;
    @SerializedName("pid")
    public String mProcessIdentifier;
    @SerializedName("pn")
    public String mProcessName;
    @SerializedName("s")
    public String mSession;
    @SerializedName("tid")
    public String mTrackID;
    @SerializedName("ti")
    public List<TrafficUsageBean> mTrafficInfo;
    @SerializedName("usd")
    public long mUnitSessionDuration;
    @SerializedName("ui")
    public Map<String, UserInfoBean> mUserInfoBean;
    @SerializedName("v")
    public String mVersion;

    public String toString() {
        return "UploadDataRequestBean{mSession='" + this.mSession + '\'' + ", mProcessIdentifier='" + this.mProcessIdentifier + '\'' + ", mProcessName='" + this.mProcessName + '\'' + ", mVersion='" + this.mVersion + '\'' + ", mMonitorTime=" + this.mMonitorTime + ", mConfigMonitorTime=" + this.mConfigMonitorTime + ", mDeviceInfo=" + this.mDeviceInfo + ", mAppInfo=" + this.mAppInfo + ", mAppStateInfo=" + this.mAppStateInfo + ", mTrafficInfo=" + this.mTrafficInfo + ", mFirstUserInfo='" + this.mFirstUserInfo + '\'' + ", mUserInfoBean=" + this.mUserInfoBean + ", mDeviceStateInfo=" + this.mDeviceStateInfo + ", mNetWorkStateInfo=" + this.mNetWorkStateInfo + ", mUnitSessionDuration=" + this.mUnitSessionDuration + ", mTrackID='" + this.mTrackID + '\'' + ", mEvents=" + this.mEvents + ", mDataFusionInfo=" + this.mDataFusionInfo + '}';
    }

    public String getmSession() {
        return this.mSession;
    }

    public String getmVersion() {
        return this.mVersion;
    }

    public void setmVersion(String str) {
        this.mVersion = str;
    }

    public long getmMonitorTime() {
        return this.mMonitorTime;
    }

    public void setmMonitorTime(long j) {
        this.mMonitorTime = j;
    }

    public long getmConfigMonitorTime() {
        return this.mConfigMonitorTime;
    }

    public void setmConfigMonitorTime(long j) {
        this.mConfigMonitorTime = j;
    }

    public DeviceInfoBean getmDeviceInfo() {
        return this.mDeviceInfo;
    }

    public void setmDeviceInfo(DeviceInfoBean deviceInfoBean) {
        this.mDeviceInfo = deviceInfoBean;
    }

    public AppInfoBean getmAppInfo() {
        return this.mAppInfo;
    }

    public void setmAppInfo(AppInfoBean appInfoBean) {
        this.mAppInfo = appInfoBean;
    }

    public List<TrafficUsageBean> getmTrafficInfo() {
        return this.mTrafficInfo;
    }

    public void setmTrafficInfo(List<TrafficUsageBean> list) {
        this.mTrafficInfo = list;
    }

    public String getmFirstUserInfo() {
        return this.mFirstUserInfo;
    }

    public void setmFirstUserInfo(String str) {
        this.mFirstUserInfo = str;
    }

    public Map<String, UserInfoBean> getmUserInfoBean() {
        return this.mUserInfoBean;
    }

    public void setmUserInfoBean(Map<String, UserInfoBean> map) {
        this.mUserInfoBean = map;
    }

    public Map<String, DeviceStateInfoBean> getmDeviceStateInfo() {
        return this.mDeviceStateInfo;
    }

    public void setmDeviceStateInfo(Map<String, DeviceStateInfoBean> map) {
        this.mDeviceStateInfo = map;
    }

    public Map<String, NetWorkStateInfoBean> getmNetWorkStateInfo() {
        return this.mNetWorkStateInfo;
    }

    public void setmNetWorkStateInfo(Map<String, NetWorkStateInfoBean> map) {
        this.mNetWorkStateInfo = map;
    }

    public long getmUnitSessionDuration() {
        return this.mUnitSessionDuration;
    }

    public void setmUnitSessionDuration(long j) {
        this.mUnitSessionDuration = j;
    }

    public DataFusionInfo getDataFusionInfo() {
        return this.mDataFusionInfo;
    }

    public String getTrackID() {
        return this.mTrackID;
    }

    public void setTrackID(String str) {
        this.mTrackID = str;
    }

    public List<EventBean> getmEvents() {
        return this.mEvents;
    }

    public void setmEvents(List<EventBean> list) {
        this.mEvents = list;
    }

    public String getSession() {
        return this.mSession;
    }

    public String getAgentVersion() {
        return this.mVersion;
    }

    public long getMonitorTime() {
        return this.mMonitorTime;
    }

    public long getConfigMonitorTime() {
        return this.mConfigMonitorTime;
    }

    public DeviceInfoBean getDeviceInfo() {
        return this.mDeviceInfo;
    }

    public long getUnitSessionDuration() {
        return this.mUnitSessionDuration;
    }

    public AppInfoBean getAppInfo() {
        return this.mAppInfo;
    }

    public List<TrafficUsageBean> getTrafficInfo() {
        return this.mTrafficInfo;
    }

    public String getFirstUserInfo() {
        return this.mFirstUserInfo;
    }

    public Map<String, UserInfoBean> getUserInfoBean() {
        return this.mUserInfoBean;
    }

    public Map<String, DeviceStateInfoBean> getDeviceStateInfo() {
        return this.mDeviceStateInfo;
    }

    public Map<String, NetWorkStateInfoBean> getNetWorkStateInfo() {
        return this.mNetWorkStateInfo;
    }

    public List<EventBean> getEvents() {
        return this.mEvents;
    }
}
