package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class RouteChangeEventBean extends BaseEventInfo {
    @SerializedName("al")
    public String alias;
    @SerializedName("ctp")
    public int clientType;
    @SerializedName("d")
    public long duration;
    @SerializedName("fw")
    public String framework = "";
    @SerializedName("fu")
    public String fromUrl = "";
    @SerializedName("ic")
    public boolean isCustom;
    @SerializedName("pu")
    public String pageUrl = "";
    @SerializedName("pt")
    public String path = "";
    @SerializedName("rt")
    public String root = "";
    @SerializedName("sta")
    public int status;
    @SerializedName("tu")
    public String toUrl = "";

    public String toString() {
        return "RouteChangeEventBean{toUrl='" + this.toUrl + '\'' + ", fromUrl='" + this.fromUrl + '\'' + ", duration=" + this.duration + ", status=" + this.status + ", alias='" + this.alias + '\'' + ", path='" + this.path + '\'' + ", root='" + this.root + '\'' + ", pageUrl='" + this.pageUrl + '\'' + ", framework='" + this.framework + '\'' + ", isCustom=" + this.isCustom + ", clientType=" + this.clientType + '}';
    }
}
