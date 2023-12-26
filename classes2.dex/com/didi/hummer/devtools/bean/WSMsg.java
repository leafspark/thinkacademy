package com.didi.hummer.devtools.bean;

import java.io.Serializable;

public class WSMsg<T> implements Serializable {
    public static final String TYPE_LOG = "log";
    private T data;
    private String type;

    public WSMsg(String str, T t) {
        this.type = str;
        this.data = t;
    }

    public String getType() {
        return this.type;
    }

    public T getData() {
        return this.data;
    }
}
