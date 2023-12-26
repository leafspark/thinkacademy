package com.tal.app.thinkacademy.live.business.redpackage.bean;

import com.google.gson.annotations.SerializedName;

public class RedPacketBean {
    @SerializedName("coin")
    int coin;
    @SerializedName("status")
    int status;

    public int getCoin() {
        return this.coin;
    }

    public int getStatus() {
        return this.status;
    }
}
