package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.List;

public class H5EventInfoBean extends BaseEventInfo {
    @SerializedName("ic")
    public boolean isCustom;
    @SerializedName("cbbq")
    public String mCustomBusinessBody;
    @SerializedName("cbhq")
    public String mCustomBusinessHeader;
    @SerializedName("cbq")
    public String mCustomBusinessQuery;
    @SerializedName("pvid")
    public String mPvid;
    @SerializedName("url")
    public String mRequestUrl;
    @SerializedName("wpi")
    public WebviewPerformanceTiming mWebviewPerformanceTiming;
    @SerializedName("wri")
    public List<WebviewResourceBean> mWebviewResources;
    public transient long startTime;

    public String toString() {
        return "H5EventBean{startTime=" + this.startTime + ", mPvid='" + this.mPvid + '\'' + ", isCustom='" + this.isCustom + ", mRequestUrl='" + this.mRequestUrl + '\'' + ", mWebviewPerformanceTiming=" + this.mWebviewPerformanceTiming + ", mWebviewResources=" + this.mWebviewResources + '}';
    }
}
