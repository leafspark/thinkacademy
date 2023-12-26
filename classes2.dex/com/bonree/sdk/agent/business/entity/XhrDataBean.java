package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class XhrDataBean {
    @SerializedName("cb")
    public double callbackTime;
    @SerializedName("ce")
    public double connectEnd;
    @SerializedName("cs")
    public double connectStart;
    @SerializedName("de")
    public double dnsEnd;
    @SerializedName("ds")
    public double dnsStart;
    @SerializedName("d")
    public double duration;
    @SerializedName("e")
    public double endTime;
    @SerializedName("fb")
    public double firstByteEndTime;
    @SerializedName("m")
    public String method;
    @SerializedName("pr")
    public String nextHopProtocol;
    @SerializedName("oe")
    public int onLoadEnd;
    @SerializedName("p")
    public String pageUrl;
    @SerializedName("i")
    public String pvid;
    @SerializedName("req")
    public int requestLength;
    @SerializedName("a")
    public String requestParams;
    @SerializedName("h")
    public String responseHeader;
    @SerializedName("res")
    public int responseLength;
    @SerializedName("ssl")
    public double ssl;
    @SerializedName("s")
    public double startTime;
    @SerializedName("st")
    public int statusCode;
    public long timingNavigationStart;
    @SerializedName("u")
    public String url;

    public String toString() {
        return "XhrDataBean{" + "pvid='" + this.pvid + '\'' + ", pageUrl='" + this.pageUrl + '\'' + ", url='" + this.url + '\'' + ", method='" + this.method + '\'' + ", statusCode=" + this.statusCode + ", timingNavigationStart=" + this.timingNavigationStart + ", startTime=" + this.startTime + ", requestLength=" + this.requestLength + ", responseLength=" + this.responseLength + ", endTime=" + this.endTime + ", firstByteEndTime=" + this.firstByteEndTime + ", duration=" + this.duration + ", callbackTime=" + this.callbackTime + ", responseHeader='" + this.responseHeader + '\'' + ", requestParams='" + this.requestParams + '\'' + ", onLoadEnd=" + this.onLoadEnd + ", dnsStart=" + this.dnsStart + ", dnsEnd=" + this.dnsEnd + ", connectStart=" + this.connectStart + ", connectEnd=" + this.connectEnd + ", ssl=" + this.ssl + ", nextHopProtocol='" + this.nextHopProtocol + '\'' + '}';
    }
}
