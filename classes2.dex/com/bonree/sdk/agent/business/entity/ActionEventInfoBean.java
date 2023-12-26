package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ActionEventInfoBean extends BaseEventInfo {
    public static final transient int ACTION_END = 2;
    public static final transient int ACTION_START = 1;
    public static final transient int SOURCE_OF_JS = 1;
    public static final transient int SOURCE_OF_ORIGINAL = 0;
    public static final transient int SOURCE_OF_RN = 2;
    public static final transient int TYPE_CLICK = 1;
    public static final transient int TYPE_GESTURE = 2;
    public static final transient int TYPE_INPUT = 4;
    public static final transient int TYPE_KEYBOARD = 3;
    public static final transient int TYPE_OTHER = 0;
    private transient List<ActionMethodNode> asyncNodes = Collections.synchronizedList(new ArrayList());
    public transient int childrenCount;
    @SerializedName("ic")
    public boolean isCustom = false;
    @SerializedName("is")
    public Boolean isSlow;
    @SerializedName("id")
    public String mActionId;
    @SerializedName("ci")
    public ControlInfo mControlInfo;
    @SerializedName("crids")
    public List<String> mCrashIds;
    @SerializedName("i")
    public String mInfo;
    @SerializedName("ice")
    public Boolean mIsCustomEnd;
    @SerializedName("lt")
    public long mLoadTime;
    @SerializedName("me")
    public ActionMethodNode mMethod;
    @SerializedName("m")
    public Integer mMode;
    @SerializedName("n")
    public String mName;
    @SerializedName("p")
    public String mParam;
    @SerializedName("sa")
    public int mSourceAction;
    public transient long mStartTime;
    @SerializedName("tmi")
    public List<ThreadMethodInfoBean> mThreadMethodInfoBean;
    @SerializedName("t")
    public int mType;
    @SerializedName("vn")
    public String mViewName;
    protected transient AtomicInteger uncloseNodeCount;

    public List<ActionMethodNode> getAsyncNodes() {
        return this.asyncNodes;
    }

    public void addAsyncNodes(ActionMethodNode actionMethodNode) {
        this.asyncNodes.add(actionMethodNode);
    }

    public void removeAsyncNodes(ActionMethodNode actionMethodNode) {
        this.asyncNodes.remove(actionMethodNode);
    }

    public List<String> getCrashIds() {
        return this.mCrashIds;
    }

    public void addCrashId(String str) {
        if (this.mCrashIds == null) {
            this.mCrashIds = new ArrayList();
        }
        if (!this.mCrashIds.contains(str)) {
            this.mCrashIds.add(str);
        }
    }

    public AtomicInteger getUncloseNodeCount() {
        return this.uncloseNodeCount;
    }

    public void setUncloseNodeCount(AtomicInteger atomicInteger) {
        this.uncloseNodeCount = atomicInteger;
    }

    public static class ControlInfo {
        @SerializedName("t")
        public String text;
        @SerializedName("td")
        public String typeDescription;
        @SerializedName("id")
        public String viewId;

        public String toString() {
            return "ControlInfo{viewId='" + this.viewId + '\'' + ", typeDescription='" + this.typeDescription + '\'' + ", text='" + this.text + '\'' + '}';
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ActionEventInfoBean{mType=");
        sb.append(this.mType);
        sb.append(", mName='");
        sb.append(this.mName);
        sb.append('\'');
        sb.append(", mInfo='");
        sb.append(this.mInfo);
        sb.append('\'');
        sb.append(", mViewName='");
        sb.append(this.mViewName);
        sb.append('\'');
        sb.append(", isCustom=");
        sb.append(this.isCustom);
        sb.append(", mParam='");
        sb.append(this.mParam);
        sb.append('\'');
        sb.append(", mLoadTime=");
        sb.append(this.mLoadTime);
        sb.append(", isSlow=");
        sb.append(this.isSlow);
        sb.append(", mSourceAction=");
        sb.append(this.mSourceAction);
        sb.append(", mThreadMethodInfoBean=");
        sb.append(this.mThreadMethodInfoBean);
        sb.append(", mActionId=");
        sb.append(this.mActionId);
        sb.append(", mMode=");
        sb.append(this.mMode);
        sb.append(", mControlInfo=");
        sb.append(this.mControlInfo);
        sb.append(", mMethod=");
        sb.append(this.mMethod);
        sb.append(", uncloseNodeCount=");
        sb.append(this.uncloseNodeCount);
        sb.append(", mCrashIds=");
        List<String> list = this.mCrashIds;
        if (list != null) {
            list = Arrays.asList(list.toArray());
        }
        sb.append(list);
        sb.append('}');
        return sb.toString();
    }
}
