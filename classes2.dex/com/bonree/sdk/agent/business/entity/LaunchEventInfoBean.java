package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.List;

public class LaunchEventInfoBean extends BaseEventInfo {
    public static final Integer LAUNCH_TYPE_COLD = 1;
    public static final Integer LAUNCH_TYPE_FIRST = 3;
    public static final Integer LAUNCH_TYPE_HOT = 2;
    @SerializedName("is")
    public Boolean mIsSlow;
    @SerializedName("lt")
    public Long mLoadTime;
    @SerializedName("tmi")
    public List<ThreadMethodInfoBean> mThreadMethodInfo;
    @SerializedName("t")
    public Integer mType;

    public String toString() {
        return "LaunchEventBean{mType=" + this.mType + ", mLoadTime=" + this.mLoadTime + ", mIsSlow=" + this.mIsSlow + ", mThreadMethodInfo=" + this.mThreadMethodInfo + '}';
    }
}
