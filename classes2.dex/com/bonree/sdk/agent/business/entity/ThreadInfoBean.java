package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import com.bonree.sdk.common.json.JSONObject;
import com.bonree.sdk.f.d;

public class ThreadInfoBean {
    public static final String[] KEYS = {"et", "st", "ti", "t", "n"};
    @SerializedName("et")
    public long mEndTimeUs;
    @SerializedName("ti")
    public long mId;
    @SerializedName("n")
    public String mName;
    @SerializedName("st")
    public long mStartTimeUs;
    @SerializedName("t")
    public int mType;

    public String toString() {
        return "ThreadInfoBean{" + "mStartTimeUs=" + this.mStartTimeUs + ", mEndTimeUs=" + this.mEndTimeUs + ", mType=" + this.mType + ", mName='" + this.mName + '\'' + ", mId=" + this.mId + '}';
    }

    public static Object[] getThreadInfoValues(JSONObject jSONObject) {
        try {
            return new Object[]{Long.valueOf(d.b(jSONObject, "et")), Long.valueOf(d.b(jSONObject, "st")), Long.valueOf(d.b(jSONObject, "ti")), Integer.valueOf(d.d(jSONObject, "t")), d.a(jSONObject, "n")};
        } catch (Throwable unused) {
            return null;
        }
    }
}
