package com.bonree.sdk.agent.business.entity;

import android.content.Intent;
import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class ActionMethodNode {
    private transient long asyncThreadId = -1;
    protected transient Intent[] intents;
    private transient String mActionEventId;
    @SerializedName("ms")
    private List<ActionMethodNode> mChildren;
    @SerializedName("et")
    private long mEndTime = 0;
    @SerializedName("ice")
    private boolean mIsCustomEnd = false;
    @SerializedName("im")
    private boolean mIsMain;
    @SerializedName("to")
    private boolean mIsTimeOut = false;
    private transient int mMethodLevel;
    @SerializedName("n")
    private String mName;
    @SerializedName("ne")
    private NetworkEventInfoBean mNetworkEventInfoBean;
    private transient ActionMethodNode mParent;
    private transient ActionEventInfoBean mRootNode;
    @SerializedName("st")
    private long mStartTime;
    @SerializedName("ti")
    private long mThreadId;
    @SerializedName("tn")
    private String mThreadName;
    @SerializedName("t")
    private int mType;
    protected transient String uuid;
    protected transient int what;

    public ActionEventInfoBean getRootNode() {
        return this.mRootNode;
    }

    public void setRootNode(ActionEventInfoBean actionEventInfoBean) {
        this.mRootNode = actionEventInfoBean;
    }

    public String getActionEventId() {
        return this.mActionEventId;
    }

    public void setActionEventId(String str) {
        this.mActionEventId = str;
    }

    public boolean isCustomEnd() {
        return this.mIsCustomEnd;
    }

    public void setCustomEnd(boolean z) {
        this.mIsCustomEnd = z;
    }

    public NetworkEventInfoBean getNetworkEventInfoBean() {
        return this.mNetworkEventInfoBean;
    }

    public void setNetworkEventInfoBean(NetworkEventInfoBean networkEventInfoBean) {
        this.mNetworkEventInfoBean = networkEventInfoBean;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public boolean isTimeOut() {
        return this.mIsTimeOut;
    }

    public void setTimeOut(boolean z) {
        this.mIsTimeOut = z;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public boolean isMain() {
        return this.mIsMain;
    }

    public void setMain(boolean z) {
        this.mIsMain = z;
    }

    public String getThreadName() {
        return this.mThreadName;
    }

    public void setThreadName(String str) {
        this.mThreadName = str;
    }

    public int getMethodLevel() {
        return this.mMethodLevel;
    }

    public void setMethodLevel(int i) {
        this.mMethodLevel = i;
    }

    public long getThreadId() {
        return this.mThreadId;
    }

    public void setThreadId(long j) {
        this.mThreadId = j;
    }

    public ActionMethodNode(String str) {
        this.mName = str;
        this.mMethodLevel = 0;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
    }

    public ActionMethodNode getParent() {
        return this.mParent;
    }

    public int getWhat() {
        return this.what;
    }

    public void setWhat(int i) {
        this.what = i;
    }

    public Intent[] getIntents() {
        return this.intents;
    }

    public void setIntents(Intent[] intentArr) {
        this.intents = intentArr;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.mName + "-->" + this.mMethodLevel + "\n");
        List<ActionMethodNode> list = this.mChildren;
        if (list != null && !list.isEmpty()) {
            getInfo(stringBuffer, this.mChildren);
        }
        return "ActionMethodNode{\n" + stringBuffer.toString() + '}';
    }

    private void getInfo(StringBuffer stringBuffer, List<ActionMethodNode> list) {
        for (int i = 0; i < list.size(); i++) {
            ActionMethodNode actionMethodNode = list.get(i);
            if (actionMethodNode != null) {
                stringBuffer.append(list.get(i).getMethodName() + "-->" + list.get(i).getMethodLevel() + "\n");
                NetworkEventInfoBean networkEventInfoBean = list.get(i).getNetworkEventInfoBean();
                if (networkEventInfoBean != null) {
                    stringBuffer.append(networkEventInfoBean.mRequestUrl + "\n");
                }
                if (actionMethodNode.getChildren() != null && !actionMethodNode.getChildren().isEmpty()) {
                    getInfo(stringBuffer, actionMethodNode.getChildren());
                }
            }
        }
    }

    public void setParent(ActionMethodNode actionMethodNode) {
        this.mParent = actionMethodNode;
    }

    public List<ActionMethodNode> getChildren() {
        return this.mChildren;
    }

    public void setChildren(List<ActionMethodNode> list) {
        if (this.mChildren == null) {
            this.mChildren = new ArrayList();
        }
        this.mChildren.addAll(list);
    }

    public void setChildrenNull() {
        this.mChildren = null;
    }

    public void addChildren(ActionMethodNode actionMethodNode) {
        if (this.mChildren == null) {
            this.mChildren = new ArrayList();
        }
        this.mChildren.add(actionMethodNode);
    }

    public String getMethodName() {
        return this.mName;
    }

    public void setMethodName(String str) {
        this.mName = str;
    }

    public long getAsyncThreadId() {
        return this.asyncThreadId;
    }

    public void setAsyncThreadId(long j) {
        this.asyncThreadId = j;
    }
}
