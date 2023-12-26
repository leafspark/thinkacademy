package com.bonree.sdk.agent.business.entity.transfer;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class HeartbeatResponseBean {
    private int code;
    @SerializedName("data")
    private HeartbeatResponseDataBean heartbeatResponseDataBean;
    private String msg;

    public HeartbeatResponseBean(int i, String str, HeartbeatResponseDataBean heartbeatResponseDataBean2) {
        this.code = i;
        this.msg = str;
        this.heartbeatResponseDataBean = heartbeatResponseDataBean2;
    }

    public String toString() {
        return "HeartbeatResponseBean{code=" + this.code + ", msg='" + this.msg + '\'' + ", heartbeatResponseDataBean=" + this.heartbeatResponseDataBean + '}';
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public HeartbeatResponseDataBean getHeartbeatResponseDataBean() {
        return this.heartbeatResponseDataBean;
    }

    public void setHeartbeatResponseDataBean(HeartbeatResponseDataBean heartbeatResponseDataBean2) {
        this.heartbeatResponseDataBean = heartbeatResponseDataBean2;
    }
}
