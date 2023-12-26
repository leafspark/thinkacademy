package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class NetworkInfoBean {
    @SerializedName("et")
    public long endTimeUs;
    public transient boolean isResponse;
    public transient String loadUrl;
    @SerializedName("st")
    public long startTimeUs;
    @SerializedName("url")
    public String url;
    public transient String uuid;

    public String toString() {
        return "NetworkInfoBean{isResponse=" + this.isResponse + ", uuid='" + this.uuid + '\'' + ", loadUrl='" + this.loadUrl + '\'' + ", url='" + this.url + '\'' + ", startTimeUs=" + this.startTimeUs + ", endTimeUs=" + this.endTimeUs + '}';
    }
}
