package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class CustomerParamBean {
    @SerializedName("log")
    private LogReturnInfoBean mLogReturnInfoBean;
    @SerializedName("speed")
    private String mSpeedInfo;

    public LogReturnInfoBean getUploadLogBean() {
        return this.mLogReturnInfoBean;
    }

    public void setUploadLogBean(LogReturnInfoBean logReturnInfoBean) {
        this.mLogReturnInfoBean = logReturnInfoBean;
    }

    public String getSpeedInfo() {
        return this.mSpeedInfo;
    }

    public void setSpeedInfo(String str) {
        this.mSpeedInfo = str;
    }
}
