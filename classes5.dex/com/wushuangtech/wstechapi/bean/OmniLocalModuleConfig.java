package com.wushuangtech.wstechapi.bean;

public class OmniLocalModuleConfig {
    public int eventType;
    public Object[] objs;

    public OmniLocalModuleConfig(int i, Object[] objArr) {
        this.eventType = i;
        this.objs = objArr;
    }
}
