package com.didi.hummer.adapter.tracker;

import java.io.Serializable;

public class SDKCustomInfo implements Serializable {
    public String category;
    public long duration;
    public String errorMsg;
    public String name;
    public boolean success;

    public SDKCustomInfo(String str, String str2) {
        this.category = str;
        this.name = str2;
    }
}
