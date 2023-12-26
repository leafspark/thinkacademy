package com.bonree.sdk.agent.business.entity;

public class NetworkRequestExtraBean {
    private String info;
    private String key;
    private String value;

    public NetworkRequestExtraBean(String str, String str2, String str3) {
        this.key = str;
        this.value = str2;
        this.info = str3;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String str) {
        this.info = str;
    }
}
