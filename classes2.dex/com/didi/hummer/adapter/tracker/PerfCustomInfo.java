package com.didi.hummer.adapter.tracker;

import java.io.Serializable;

public class PerfCustomInfo implements Serializable {
    public String category;
    public String name;
    public String unit;
    public Object value;

    public PerfCustomInfo(String str, String str2) {
        this.category = str;
        this.name = str2;
    }

    public PerfCustomInfo(String str, String str2, String str3) {
        this.category = str;
        this.name = str2;
        this.unit = str3;
    }

    public PerfCustomInfo(String str, String str2, String str3, Object obj) {
        this.category = str;
        this.name = str2;
        this.unit = str3;
        this.value = obj;
    }
}
