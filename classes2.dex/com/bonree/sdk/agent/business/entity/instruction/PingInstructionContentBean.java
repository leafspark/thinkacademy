package com.bonree.sdk.agent.business.entity.instruction;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class PingInstructionContentBean extends InstructionContentBean {
    @SerializedName("h")
    private String host;
    @SerializedName("t")
    private int time;

    public String getHost() {
        return this.host;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public String toString() {
        return "PingInstructionContentBean{host='" + this.host + '\'' + ", time=" + this.time + '}';
    }
}
