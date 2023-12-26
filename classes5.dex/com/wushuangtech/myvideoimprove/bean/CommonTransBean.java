package com.wushuangtech.myvideoimprove.bean;

public class CommonTransBean {
    public int eventType;
    public boolean mUrgentMsg;
    public Object[] objs;

    public CommonTransBean(int i, Object... objArr) {
        this.eventType = i;
        this.objs = objArr;
    }
}
