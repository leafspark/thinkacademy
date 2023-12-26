package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.List;

public class ActivityResultBean {
    @SerializedName("ai")
    public String mActivityId;
    @SerializedName("an")
    public String mActivityName;
    @SerializedName("ct")
    public long mCreateTimeUs;
    @SerializedName("et")
    public long mEndTimeUs;
    @SerializedName("fr")
    public List<FragmentResultBean> mFragmentResults;
    @SerializedName("iq")
    public boolean mIsQuit;
    @SerializedName("lt")
    public long mLaunchTimeUs;
    @SerializedName("s")
    public SnapshotBean mSnapshotBean;
    @SerializedName("st")
    public long mStartTimeUs;
    @SerializedName("t")
    public int mType;

    public String toString() {
        return "ActivityResultBean{" + "mStartTimeUs=" + this.mStartTimeUs + ", mEndTimeUs=" + this.mEndTimeUs + ", mActivityName='" + this.mActivityName + '\'' + ", mLaunchTimeUs=" + this.mLaunchTimeUs + ", mCreateTimeUs=" + this.mCreateTimeUs + ", mFragmentResults=" + this.mFragmentResults + ", mActivityId='" + this.mActivityId + '\'' + ", mIsQuit=" + this.mIsQuit + ", mType=" + this.mType + ", mSnapshotBean=" + this.mSnapshotBean + '}';
    }

    public static class FragmentResultBean {
        public transient int hashCode;
        @SerializedName("ct")
        public long mCreateTimeUs;
        @SerializedName("et")
        public long mEndTimeUs;
        @SerializedName("fn")
        public String mFragmentName;
        public transient boolean mHasUserVisibleHint;
        @SerializedName("lt")
        public long mLoadTimeUs;
        @SerializedName("st")
        public long mStartTimeUs;
        public transient boolean mVisible;

        public String toString() {
            return "FragmentResultBean{hashCode=" + this.hashCode + ", mVisible=" + this.mVisible + ", mHasUserVisibleHint=" + this.mHasUserVisibleHint + ", mEndTimeUs=" + this.mEndTimeUs + ", mLoadTimeUs=" + this.mLoadTimeUs + ", mStartTimeUs=" + this.mStartTimeUs + ", mFragmentName='" + this.mFragmentName + '\'' + ", mCreateTimeUs=" + this.mCreateTimeUs + '}';
        }
    }
}
