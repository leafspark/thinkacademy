package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.bs.ad;
import com.bonree.sdk.common.gson.annotations.SerializedName;

public class LogReturnInfoBean {
    @SerializedName("get_logtask")
    private String mGetLogTask;
    @SerializedName("upload_logfile")
    private String mUploadLogFile;
    @SerializedName("upload_user_info")
    private String mUploadUserInfo;

    public String getUploadUserInfo() {
        return this.mUploadUserInfo;
    }

    public void setUploadUserInfo(String str) {
        this.mUploadUserInfo = str;
    }

    public String getUploadLogFile() {
        return this.mUploadLogFile;
    }

    public void setUploadLogFile(String str) {
        this.mUploadLogFile = str;
    }

    public String getGetLogTask() {
        return this.mGetLogTask;
    }

    public void setGetLogTask(String str) {
        this.mGetLogTask = str;
    }

    public boolean isLegal() {
        return ad.c(this.mUploadUserInfo) && ad.c(this.mUploadLogFile) && ad.c(this.mGetLogTask);
    }

    public String toString() {
        return "LogReturnInfoBean{mUploadUserInfo='" + this.mUploadUserInfo + '\'' + ", mUploadLogFile='" + this.mUploadLogFile + '\'' + ", mGetLogTask='" + this.mGetLogTask + '\'' + '}';
    }
}
