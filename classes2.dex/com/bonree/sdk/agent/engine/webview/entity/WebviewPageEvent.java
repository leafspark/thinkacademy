package com.bonree.sdk.agent.engine.webview.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class WebviewPageEvent {
    @SerializedName("imd")
    public int isMainDocument;
    @SerializedName("ent")
    public long mEventTimeMS;
    @SerializedName("lt")
    public int mLoadTimeMS;
    @SerializedName("m")
    public int mModel;
    @SerializedName("ci")
    public String mPageId;
    @SerializedName("p")
    public String mParam;
    public long mRealTimeMs;
    @SerializedName("vn")
    public String mViewName;

    public String toString() {
        return "WebviewPageEvent{mEventTimeMS=" + this.mEventTimeMS + ", mRealTimeMs=" + this.mRealTimeMs + ", mPageId='" + this.mPageId + '\'' + ", mLoadTimeMS=" + this.mLoadTimeMS + ", mViewName='" + this.mViewName + '\'' + ", mModel=" + this.mModel + ", isMainDocument=" + this.isMainDocument + ", mParam='" + this.mParam + '\'' + '}';
    }
}
