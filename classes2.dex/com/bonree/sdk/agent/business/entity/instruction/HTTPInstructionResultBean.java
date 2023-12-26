package com.bonree.sdk.agent.business.entity.instruction;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class HTTPInstructionResultBean extends InstructionResultBean {
    @SerializedName("ct")
    private long connectTime;
    @SerializedName("dt")
    private long dnsTime;
    @SerializedName("ds")
    private long downloadSize = 0;
    @SerializedName("dti")
    private long downloadTime;
    @SerializedName("ec")
    private long errorCode;
    @SerializedName("em")
    private String errorMsg;
    @SerializedName("eop")
    private Integer errorOccurrentProcess;
    @SerializedName("ep")
    private String errorPlatform;
    @SerializedName("m")
    private String method;
    @SerializedName("rb")
    private String requestBody;
    @SerializedName("rh")
    private String requestHeader;
    @SerializedName("rt")
    private long requestTime;
    @SerializedName("ru")
    private String requestUrl;
    @SerializedName("rsb")
    private String responseBody;
    @SerializedName("rhe")
    private String responseHeader;
    @SerializedName("rti")
    private long responseTime;
    @SerializedName("sslt")
    private long sslTime;

    public void setRequestUrl(String str) {
        this.requestUrl = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setDnsTime(long j) {
        this.dnsTime = j;
    }

    public void setConnectTime(long j) {
        this.connectTime = j;
    }

    public void setSslTime(long j) {
        this.sslTime = j;
    }

    public void setRequestTime(long j) {
        this.requestTime = j;
    }

    public void setResponseTime(long j) {
        this.responseTime = j;
    }

    public long getResponseTime() {
        return this.responseTime;
    }

    public void setDownloadTime(long j) {
        this.downloadTime = j;
    }

    public void setDownloadSize(long j) {
        this.downloadSize = j;
    }

    public void setRequestHeader(String str) {
        this.requestHeader = str;
    }

    public void setResponseHeader(String str) {
        this.responseHeader = str;
    }

    public void setErrorPlatform(String str) {
        this.errorPlatform = str;
    }

    public void setErrorCode(long j) {
        this.errorCode = j;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setRequestBody(String str) {
        this.requestBody = str;
    }

    public void setResponseBody(String str) {
        this.responseBody = str;
    }

    public int getErrorOccurrentProcess() {
        return this.errorOccurrentProcess.intValue();
    }

    public void setErrorOccurrentProcess(int i) {
        this.errorOccurrentProcess = Integer.valueOf(i);
    }

    public String toString() {
        return "HTTPInstructionResultBean{requestUrl='" + this.requestUrl + '\'' + ", method='" + this.method + '\'' + ", dnsTime=" + this.dnsTime + ", connectTime=" + this.connectTime + ", sslTime=" + this.sslTime + ", requestTime=" + this.requestTime + ", responseTime=" + this.responseTime + ", downloadTime=" + this.downloadTime + ", downloadSize=" + this.downloadSize + ", requestHeader='" + this.requestHeader + '\'' + ", responseHeader='" + this.responseHeader + '\'' + ", errorPlatform='" + this.errorPlatform + '\'' + ", errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + '\'' + ", requestBody='" + this.requestBody + '\'' + ", responseBody='" + this.responseBody + '\'' + ", errorOccurrentProcess=" + this.errorOccurrentProcess + '}';
    }
}
