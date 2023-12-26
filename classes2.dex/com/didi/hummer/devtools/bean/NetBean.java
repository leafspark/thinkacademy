package com.didi.hummer.devtools.bean;

public class NetBean {
    private Object data;
    private Object error;
    private String url;

    public NetBean(String str, Object obj, Object obj2) {
        this.url = str;
        this.data = obj;
        this.error = obj2;
    }

    public String getUrl() {
        return this.url;
    }

    public Object getData() {
        return this.data;
    }

    public Object getError() {
        return this.error;
    }
}
