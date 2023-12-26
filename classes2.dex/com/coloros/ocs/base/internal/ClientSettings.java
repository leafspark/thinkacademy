package com.coloros.ocs.base.internal;

import com.coloros.ocs.base.common.Feature;
import java.util.List;

public class ClientSettings {
    private String a;
    private int b;
    private List<Feature> c;

    public ClientSettings(String str, int i, List<Feature> list) {
        this.a = str;
        this.b = i;
        this.c = list;
    }

    public String getPackageName() {
        return this.a;
    }

    public int getVersionCode() {
        return this.b;
    }

    public List<Feature> getList() {
        return this.c;
    }
}
