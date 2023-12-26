package com.wushuangtech.bean;

public class InterCorrectionBean {
    public InterCorrectionEnum mAction;
    public Object mInfo;
    public long mTimestamp;

    public String toString() {
        return "InterCorrectionBean{mAction=" + this.mAction + ", mInfo=" + this.mInfo + ", mTimestamp=" + this.mTimestamp + '}';
    }
}
