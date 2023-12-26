package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import com.bonree.sdk.common.json.JSONObject;
import com.bonree.sdk.f.d;

public class MethodInfoBeanOld {
    public static final String[] KEYS = {"st", "et", "n", "t", "ru", "rg", "rgu"};
    @SerializedName("et")
    public long mEndTimeUs;
    public transient int mMethodType;
    @SerializedName("n")
    public String mName;
    @SerializedName("rg")
    public String mRequestGuid;
    @SerializedName("ru")
    public String mRequestUrl;
    @SerializedName("rgu")
    public String mResponseGuid;
    @SerializedName("st")
    public long mStartTimeUs;
    @SerializedName("t")
    public long mThreadId;

    public String toString() {
        return "MethodInfoBeanOld{mMethodType=" + this.mMethodType + ", mStartTimeUs=" + this.mStartTimeUs + ", mEndTimeUs=" + this.mEndTimeUs + ", mName='" + this.mName + '\'' + ", mThreadId=" + this.mThreadId + ", mRequestUrl='" + this.mRequestUrl + '\'' + ", mRequestGuid='" + this.mRequestGuid + '\'' + ", mResponseGuid='" + this.mResponseGuid + '\'' + '}';
    }

    public static Object[] getMethodInfoValues(JSONObject jSONObject) {
        try {
            return new Object[]{Long.valueOf(d.b(jSONObject, "st")), Long.valueOf(d.b(jSONObject, "et")), d.a(jSONObject, "n"), Long.valueOf(d.b(jSONObject, "t")), d.a(jSONObject, "ru"), d.a(jSONObject, "rg"), d.a(jSONObject, "rgu")};
        } catch (Throwable unused) {
            return null;
        }
    }
}
