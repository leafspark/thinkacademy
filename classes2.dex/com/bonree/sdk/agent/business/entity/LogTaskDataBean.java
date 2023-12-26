package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class LogTaskDataBean {
    @SerializedName("fp")
    public String filePath;
    @SerializedName("fs")
    public int fileSize;
    @SerializedName("ns")
    public int netStandard;

    public String toString() {
        return "LogTaskDataBean{filePath='" + this.filePath + '\'' + ", fileSize=" + this.fileSize + ", netStandard=" + this.netStandard + '}';
    }
}
