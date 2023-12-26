package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class NetworkEventInfoBean extends BaseEventInfo {
    @SerializedName("ic")
    public boolean isCustom;
    @SerializedName("ai")
    public String mActionId;
    @SerializedName("art")
    public int mAppRequestType;
    @SerializedName("cna")
    public List<String> mCNameArray;
    @SerializedName("ct")
    public int mConnectTimeUs = 0;
    @SerializedName("cbbq")
    public String mCustomBusinessBody;
    @SerializedName("cbhq")
    public String mCustomBusinessHeader;
    @SerializedName("cbq")
    public String mCustomBusinessQuery;
    @SerializedName("dt")
    public int mDnsTimeUs = 0;
    @SerializedName("dti")
    public int mDownloadTimeUs = 0;
    @SerializedName("ec")
    public Integer mErrorCode;
    @SerializedName("em")
    public String mErrorMsg;
    @SerializedName("eop")
    public Integer mErrorOccurrentProcess;
    @SerializedName("ep")
    public String mErrorPlatform;
    @SerializedName("id")
    public String mIdentifier = UUID.randomUUID().toString();
    @SerializedName("m")
    public String mMethod;
    @SerializedName("pvid")
    public String mPageId;
    @SerializedName("pt")
    public int mProtocolType = 0;
    @SerializedName("rds")
    public long mRequestDataSize;
    @SerializedName("rei")
    public String mRequestExtraInfo;
    @SerializedName("rh")
    public String mRequestHeader;
    @SerializedName("rt")
    public int mRequestTimeUs = 0;
    @SerializedName("reqht")
    public Map<String, String> mRequestTraceInfo;
    @SerializedName("ru")
    public String mRequestUrl = "";
    @SerializedName("ret")
    public String mResourceType;
    @SerializedName("rhe")
    public String mResponseHeader;
    @SerializedName("rti")
    public int mResponseTimeUs = 0;
    @SerializedName("resht")
    public Map<String, String> mResponseTraceInfo;
    @SerializedName("sslt")
    public int mSslTimeUs = 0;
    @SerializedName("ti")
    public String mTargetIp;
    @SerializedName("tp")
    public int mTargetPort;
    @SerializedName("tid")
    public String mTraceId;
    @SerializedName("ds")
    public int mdownloadSizeByte;
    public transient long startTime;
    @SerializedName("trsp")
    public String traceResponse;
    @SerializedName("xbr")
    public String xBrResponse;

    public String toString() {
        return "NetworkEventInfoBean{" + "mRequestUrl=" + this.mRequestUrl + ", startTime='" + this.startTime + '\'' + "，mIdentifier=" + this.mIdentifier + ", mMethod='" + this.mMethod + '\'' + ", mTargetIp='" + this.mTargetIp + '\'' + ", mTargetPort=" + this.mTargetPort + ", mDnsTimeUs=" + this.mDnsTimeUs + ", mConnectTimeUs=" + this.mConnectTimeUs + ", mSslTimeUs=" + this.mSslTimeUs + ", mRequestTimeUs=" + this.mRequestTimeUs + ", mResponseTimeUs=" + this.mResponseTimeUs + ", mDownloadTimeUs=" + this.mDownloadTimeUs + ", mdownloadSizeByte=" + this.mdownloadSizeByte + ", mCNameArray=" + this.mCNameArray + ", mProtocolType=" + this.mProtocolType + ", mRequestHeader='" + this.mRequestHeader + '\'' + ", mResponseHeader='" + this.mResponseHeader + '\'' + ", mTraceId='" + this.mTraceId + '\'' + ", xBrResponse='" + this.xBrResponse + '\'' + ", traceResponse='" + this.traceResponse + '\'' + ", mErrorPlatform='" + this.mErrorPlatform + '\'' + ", mErrorOccurrentProcess=" + this.mErrorOccurrentProcess + ", mErrorCode=" + this.mErrorCode + ", mErrorMsg='" + this.mErrorMsg + '\'' + ", mResourceType='" + this.mResourceType + '\'' + ", isCustom=" + this.isCustom + ", mCustomBusinessHeader='" + this.mCustomBusinessHeader + '\'' + ", mCustomBusinessBody='" + this.mCustomBusinessBody + '\'' + ", mCustomBusinessQuery='" + this.mCustomBusinessQuery + '\'' + ", mAppRequestType=" + this.mAppRequestType + ", mPageId='" + this.mPageId + '\'' + ", mRequestDataSize=" + this.mRequestDataSize + ", mRequestExtraInfo='" + this.mRequestExtraInfo + '\'' + ", mResponseTraceInfo='" + this.mResponseTraceInfo + '\'' + ", mRequestTraceInfo='" + this.mRequestTraceInfo + '\'' + '}';
    }
}
