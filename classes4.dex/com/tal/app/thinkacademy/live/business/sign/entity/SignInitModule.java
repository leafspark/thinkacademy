package com.tal.app.thinkacademy.live.business.sign.entity;

public class SignInitModule {
    private String getSignStatusURL;
    private String signExecuteURL;

    public String getGetSignStatusURL() {
        return this.getSignStatusURL;
    }

    public void setGetSignStatusURL(String str) {
        this.getSignStatusURL = str;
    }

    public String getSignExecuteURL() {
        return this.signExecuteURL;
    }

    public void setSignExecuteURL(String str) {
        this.signExecuteURL = str;
    }
}
