package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import com.bonree.sdk.common.json.JSONObject;
import com.bonree.sdk.f.d;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

public class WebviewResourceBean {
    public static final String[] KEYS = {"st", "rt", AppMeasurementSdk.ConditionalUserProperty.NAME, "dura", "fs", "dls", "dle", "cs", "ce", "scs", "reqs", "rsps", "rspe", "ts", "ebs", "dbs"};
    @SerializedName("ce")
    public int connectEnd = 0;
    @SerializedName("cs")
    public int connectStart = 0;
    @SerializedName("dbs")
    public long decodedBodySize = 0;
    @SerializedName("dle")
    public int domainLookupEnd = 0;
    @SerializedName("dls")
    public int domainLookupStart = 0;
    @SerializedName("dura")
    public int duration = 0;
    @SerializedName("ebs")
    public long encodedBodySize = 0;
    @SerializedName("fs")
    public int fetchStart = 0;
    @SerializedName("name")
    public String name = " ";
    public transient String nextHopProtocol;
    public transient String pvid;
    @SerializedName("reqs")
    public int requestStart = 0;
    @SerializedName("rt")
    public String resourceType = " ";
    @SerializedName("rspe")
    public int responseEnd = 0;
    @SerializedName("rsps")
    public int responseStart = 0;
    @SerializedName("scs")
    public int secureConnectionStart = 0;
    @SerializedName("st")
    public long startTime = 0;
    @SerializedName("ts")
    public long transferSize = 0;

    public static Object[] getWebViewResourceValues(JSONObject jSONObject) {
        try {
            return new Object[]{Float.valueOf(d.f(jSONObject, "st")), d.a(jSONObject, "rt"), d.a(jSONObject, (String) AppMeasurementSdk.ConditionalUserProperty.NAME), Float.valueOf(d.f(jSONObject, "dura")), Float.valueOf(d.f(jSONObject, "fs")), Float.valueOf(d.f(jSONObject, "dls")), Float.valueOf(d.f(jSONObject, "dle")), Float.valueOf(d.f(jSONObject, "cs")), Float.valueOf(d.f(jSONObject, "ce")), Integer.valueOf(d.d(jSONObject, "scs")), Float.valueOf(d.f(jSONObject, "reqs")), Float.valueOf(d.f(jSONObject, "rsps")), Float.valueOf(d.f(jSONObject, "rspe")), Long.valueOf(d.b(jSONObject, "ts")), Long.valueOf(d.b(jSONObject, "ebs")), Long.valueOf(d.b(jSONObject, "dbs"))};
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        return "WebviewResourceBean{" + "startTime=" + this.startTime + ", resourceType='" + this.resourceType + '\'' + ", name='" + this.name + '\'' + ", duration=" + this.duration + ", fetchStart=" + this.fetchStart + ", domainLookupStart=" + this.domainLookupStart + ", domainLookupEnd=" + this.domainLookupEnd + ", connectStart=" + this.connectStart + ", connectEnd=" + this.connectEnd + ", secureConnectionStart=" + this.secureConnectionStart + ", requestStart=" + this.requestStart + ", responseStart=" + this.responseStart + ", responseEnd=" + this.responseEnd + ", transferSize=" + this.transferSize + ", encodedBodySize=" + this.encodedBodySize + ", decodedBodySize=" + this.decodedBodySize + ", nextHopProtocol='" + this.nextHopProtocol + '\'' + ", pvid='" + this.pvid + '\'' + '}';
    }
}
