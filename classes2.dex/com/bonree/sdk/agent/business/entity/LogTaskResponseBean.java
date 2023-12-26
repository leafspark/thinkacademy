package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class LogTaskResponseBean {
    @SerializedName("code")
    public int code;
    @SerializedName("data")
    public LogTaskDataBean data;
    @SerializedName("message")
    public String message;

    public String toString() {
        return "LogTaskResponseBean{code=" + this.code + ", data=" + this.data + ", message='" + this.message + '\'' + '}';
    }

    public boolean isSuccess() {
        return this.code == 200;
    }
}
