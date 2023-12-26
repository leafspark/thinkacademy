package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.List;

public class ThreadMethodInfoBean {
    @SerializedName("im")
    public boolean isMain;
    @SerializedName("ti")
    public String mId;
    @SerializedName("mi")
    public List<MethodInfoBean> mMethodInfo;
    @SerializedName("n")
    public String mName;

    public String toString() {
        return "ThreadMethodInfoBean{mId=" + this.mId + ", isMain=" + this.isMain + ", mName='" + this.mName + '\'' + ", mMethodInfo=" + this.mMethodInfo + '}';
    }
}
