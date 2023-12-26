package com.bonree.sdk.agent.engine.webview.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class AjaxPerformanceTimingEvent {
    @SerializedName("au")
    public String ajaxUrl;
    @SerializedName("bu")
    public String baseUrl;
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
    @SerializedName("em")
    public String errorMessage;
    @SerializedName("et")
    public String errorPlatform;
    @SerializedName("fb")
    public double firstByteEndTime;
    @SerializedName("m")
    public String method;
    @SerializedName("pr")
    public String nextHopProtocol;
    @SerializedName("oe")
    public int onLoadEnd;
    @SerializedName("pu")
    public String pageUrl;
    @SerializedName("pvid")
    public String pvid;
    @SerializedName("rb")
    public Object requestBody;
    @SerializedName("reqh")
    public String requestHeader;
    @SerializedName("req")
    public int requestLength;
    @SerializedName("resh")
    public String responseHeader;
    @SerializedName("res")
    public int responseLength;
    @SerializedName("ssl")
    public double ssl;
    @SerializedName("st")
    public double startTime;
    @SerializedName("sc")
    public int statusCode;
    public long timingNavigationStart;
    @SerializedName("tpar")
    public String traceParent;

    public String toString() {
        return "AjaxPerformanceTimingEvent{pvid='" + this.pvid + '\'' + ", pageUrl='" + this.pageUrl + '\'' + ", baseUrl='" + this.baseUrl + '\'' + ", ajaxUrl='" + this.ajaxUrl + '\'' + ", method='" + this.method + '\'' + ", nextHopProtocol='" + this.nextHopProtocol + '\'' + ", statusCode=" + this.statusCode + ", timingNavigationStart=" + this.timingNavigationStart + ", startTime=" + this.startTime + ", requestLength=" + this.requestLength + ", responseLength=" + this.responseLength + ", endTime=" + this.endTime + ", firstByteEndTime=" + this.firstByteEndTime + ", duration=" + this.duration + ", callbackTime=" + this.callbackTime + ", requestHeader='" + this.requestHeader + '\'' + ", responseHeader='" + this.responseHeader + '\'' + ", onLoadEnd=" + this.onLoadEnd + ", dnsStart=" + this.dnsStart + ", dnsEnd=" + this.dnsEnd + ", connectStart=" + this.connectStart + ", connectEnd=" + this.connectEnd + ", ssl=" + this.ssl + ", traceParent='" + this.traceParent + '\'' + ", requestBody=" + this.requestBody + ", errorPlatform='" + this.errorPlatform + '\'' + ", errorMessage='" + this.errorMessage + '\'' + '}';
    }
}
