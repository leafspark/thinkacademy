package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import com.bonree.sdk.common.json.JSONObject;
import com.bonree.sdk.f.d;
import java.util.List;

public class UserTrackBean {
    public static final String[] KEYS = {"st", "an", "fn", "utst", "f", "mi"};
    @SerializedName("an")
    public String mActivityName;
    @SerializedName("fn")
    public String mFragmentName;
    @SerializedName("f")
    public List<FunctionBean> mFunctions;
    @SerializedName("mi")
    public String mMemberId;
    @SerializedName("utst")
    public long mStartTime;
    @SerializedName("st")
    public long mStayingTime;

    public static Object[] getUserTrackValues(JSONObject jSONObject) {
        try {
            String[] strArr = KEYS;
            Object[] objArr = new Object[strArr.length];
            objArr[0] = Long.valueOf(d.b(jSONObject, strArr[0]));
            objArr[1] = d.a(jSONObject, strArr[1]);
            objArr[2] = d.a(jSONObject, strArr[2]);
            objArr[3] = Long.valueOf(d.b(jSONObject, strArr[3]));
            objArr[4] = d.c(jSONObject, strArr[4]);
            objArr[5] = d.a(jSONObject, strArr[5]);
            return objArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        return "UserTrackBean{" + "mStayingTime=" + this.mStayingTime + ", mActivityName='" + this.mActivityName + '\'' + ", mFragmentName='" + this.mFragmentName + '\'' + ", mStartTime=" + this.mStartTime + ", mFunctions=" + this.mFunctions + ", mMemberId='" + this.mMemberId + '\'' + '}';
    }
}
