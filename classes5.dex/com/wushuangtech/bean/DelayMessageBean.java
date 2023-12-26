package com.wushuangtech.bean;

public class DelayMessageBean {
    public int messageType;
    public Object[] objs;

    public DelayMessageBean(int i, Object[] objArr) {
        this.messageType = i;
        this.objs = objArr;
    }
}
