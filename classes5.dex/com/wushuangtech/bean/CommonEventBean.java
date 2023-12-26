package com.wushuangtech.bean;

import java.util.Arrays;
import java.util.UUID;

public class CommonEventBean {
    public int mEventType;
    public boolean mNotified;
    public Object mObject;
    public Object[] mObjects;
    public int mResult;
    public String mUniqueUid;

    public CommonEventBean() {
        this(0, (Object) null, (Object[]) null);
    }

    public CommonEventBean(int i, Object... objArr) {
        this(i, (Object) null, objArr);
    }

    public CommonEventBean(int i, Object obj) {
        this(i, obj, (Object[]) null);
    }

    public CommonEventBean(int i, Object obj, Object... objArr) {
        this.mEventType = i;
        this.mObject = obj;
        this.mObjects = objArr;
        this.mUniqueUid = UUID.randomUUID().toString();
    }

    public String toString() {
        return "CommonEventBean{mUniqueUid='" + this.mUniqueUid + '\'' + ", mNotified=" + this.mNotified + ", mResult=" + this.mResult + ", mEventType=" + this.mEventType + ", mObject=" + this.mObject + ", mObjects=" + Arrays.toString(this.mObjects) + '}';
    }
}
