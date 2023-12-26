package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.List;

public class ViewEventInfoBean extends BaseEventInfo {
    public static final transient int MODEL_ENTER = 1;
    public static final transient int MODEL_EXIT = 2;
    public static final transient int TYPE_ABILITY = 8;
    public static final transient int TYPE_ABILITY_SLICE = 9;
    public static final transient int TYPE_ACTIVITY = 2;
    public static final transient int TYPE_FLUTTER = 7;
    public static final transient int TYPE_FRAGMENT = 3;
    public static final transient int TYPE_H5 = 1;
    public static final transient int TYPE_RN = 6;
    @SerializedName("ic")
    public boolean isCustom;
    @SerializedName("ci")
    public String mCorrelationId;
    @SerializedName("is")
    public Boolean mIsSlow;
    @SerializedName("lt")
    public long mLoadTimeUs;
    @SerializedName("m")
    public int mModel;
    @SerializedName("n")
    public String mName;
    @SerializedName("p")
    public String mParam;
    @SerializedName("pv")
    public String mParentView;
    @SerializedName("st")
    public Long mStayTimeUs;
    @SerializedName("tmi")
    public List<ThreadMethodInfoBean> mThreadMethodInfo;
    @SerializedName("t")
    public int mType;

    public String toString() {
        return "ViewEventBean{mCorrelationId='" + this.mCorrelationId + '\'' + ", mLoadTimeUs=" + this.mLoadTimeUs + ", mStayTimeUs=" + this.mStayTimeUs + ", mModel=" + this.mModel + ", mType=" + this.mType + ", mParentView='" + this.mParentView + '\'' + ", mName='" + this.mName + '\'' + ", isCustom=" + this.isCustom + ", mParam='" + this.mParam + '\'' + ", mIsSlow=" + this.mIsSlow + ", mThreadMethodInfo=" + this.mThreadMethodInfo + '}';
    }
}
