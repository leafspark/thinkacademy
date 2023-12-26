package com.igexin.sdk;

import java.io.Serializable;

public class Tag implements Serializable {
    private String a;

    public String getName() {
        return this.a;
    }

    public Tag setName(String str) {
        this.a = str;
        return this;
    }
}
