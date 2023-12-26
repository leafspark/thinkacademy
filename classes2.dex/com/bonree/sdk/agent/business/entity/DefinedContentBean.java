package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import com.bonree.sdk.common.json.JSONObject;
import com.bonree.sdk.f.d;

public class DefinedContentBean {
    public static final String[] KEYS = {"bnc"};
    @SerializedName("bnc")
    public String mBusniessContent;

    public String toString() {
        return "DefinedContentBean{" + "mBusniessContent='" + this.mBusniessContent + '\'' + '}';
    }

    public static Object[] getDefinedContentValues(JSONObject jSONObject) {
        try {
            return new Object[]{d.a(jSONObject, "bnc")};
        } catch (Throwable unused) {
            return null;
        }
    }
}
