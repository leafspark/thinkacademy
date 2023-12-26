package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.bs.ad;
import com.bonree.sdk.common.gson.annotations.SerializedName;
import com.bonree.sdk.common.json.JSONObject;
import com.bonree.sdk.f.d;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

public class WebViewErrorBean {
    public static final String[] KEYS = {"pvid", "url", "msg", "line", "col", "file", "en", "sta", "flag", AppMeasurementSdk.ConditionalUserProperty.NAME, "et", "t"};
    @SerializedName("col")
    public int col;
    @SerializedName("file")
    public String file;
    @SerializedName("flag")
    public int flag;
    @SerializedName("line")
    public int line;
    @SerializedName("msg")
    public String msg;
    @SerializedName("name")
    public String name;
    @SerializedName("num")
    public int num;
    @SerializedName("pvid")
    public String pvid;
    @SerializedName("stack")
    public String stack;
    @SerializedName("time")
    public double time;
    @SerializedName("title")
    public String title;
    @SerializedName("url")
    public String url;

    public String toString() {
        return "WebViewErrorBean{" + "pvid='" + this.pvid + '\'' + ", url='" + this.url + '\'' + ", msg='" + this.msg + '\'' + ", line=" + this.line + ", col=" + this.col + ", file='" + this.file + '\'' + ", num=" + this.num + ", stack='" + this.stack + '\'' + ", flag=" + this.flag + ", name='" + this.name + '\'' + ", time=" + this.time + ", title='" + this.title + "'" + '}';
    }

    public static Object[] getWebViewErrorValues(JSONObject jSONObject) {
        try {
            return new Object[]{d.a(jSONObject, "pvid"), d.a(jSONObject, "url"), d.a(jSONObject, "msg"), Integer.valueOf(d.d(jSONObject, "line")), Integer.valueOf(d.d(jSONObject, "col")), d.a(jSONObject, "file"), Integer.valueOf(d.d(jSONObject, "num")), d.a(jSONObject, "stack"), Integer.valueOf(d.d(jSONObject, "flag")), d.a(jSONObject, (String) AppMeasurementSdk.ConditionalUserProperty.NAME), Long.valueOf(ad.a(d.e(jSONObject, "time"), 1.0d)), d.a(jSONObject, "title")};
        } catch (Throwable unused) {
            return null;
        }
    }
}
