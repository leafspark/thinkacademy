package com.didi.hummer.adapter.tracker;

import java.io.Serializable;

public class BundleInfo implements Serializable {
    public String moduleName;
    public String moduleVersion;
    public String url;

    public BundleInfo(String str, String str2, String str3) {
        this.url = str;
        this.moduleName = str2;
        this.moduleVersion = str3;
    }
}
