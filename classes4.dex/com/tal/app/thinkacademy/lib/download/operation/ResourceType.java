package com.tal.app.thinkacademy.lib.download.operation;

public enum ResourceType {
    RES_TYPE_H5(1),
    RES_TYPE_SLIM(2),
    RES_TYPE_ONLINE(3);
    
    public int value;

    private ResourceType(int i) {
        this.value = i;
    }
}
