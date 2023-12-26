package com.bonree.sdk.agent.engine.webview.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class WebviewActionEvent {
    @SerializedName("ent")
    public long mEventTime;
    @SerializedName("i")
    public InfoBean mInfo;
    @SerializedName("lt")
    public int mLoadTime;
    @SerializedName("n")
    public String mName;
    @SerializedName("pvid")
    public String mPageId;
    @SerializedName("t")
    public int mType;
    @SerializedName("vn")
    public String mViewName;

    public String toString() {
        return "WebviewActionEvent{mEventTime=" + this.mEventTime + ", mPageId='" + this.mPageId + '\'' + ", mLoadTime=" + this.mLoadTime + ", mName='" + this.mName + '\'' + ", mType=" + this.mType + ", mInfo='" + this.mInfo + '\'' + ", mViewName='" + this.mViewName + '\'' + '}';
    }

    public static class InfoBean {
        @SerializedName("className")
        public String mClassName;
        @SerializedName("id")
        public String mId;
        @SerializedName("innerText")
        public String mInnerText;
        @SerializedName("name")
        public String mName;
        @SerializedName("outerHTML")
        public String mOuterHtml;
        @SerializedName("xpath")
        public String mXPath;

        public String toString() {
            return "InfoBean{mClassName='" + this.mClassName + '\'' + ", mId='" + this.mId + '\'' + ", mName='" + this.mName + '\'' + ", mInnerText='" + this.mInnerText + '\'' + ", mOuterHtml='" + this.mOuterHtml + '\'' + ", mXPath='" + this.mXPath + '\'' + '}';
        }
    }
}
