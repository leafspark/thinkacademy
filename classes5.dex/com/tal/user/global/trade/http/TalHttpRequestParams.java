package com.tal.user.global.trade.http;

import java.util.HashMap;

public class TalHttpRequestParams {
    private String appId;
    private HashMap<String, String> bodyParam;
    private int connectTime;
    private String curTime;
    private HashMap<String, String> fileParam;
    private HashMap<String, String> headerParam;
    private int readTime;
    private String secret;

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getSecret() {
        return this.secret;
    }

    public void setSecret(String str) {
        this.secret = str;
    }

    public String getCurTime() {
        return this.curTime;
    }

    public void setCurTime(String str) {
        this.curTime = str;
    }

    public void addHeaderParam(String str, String str2) {
        if (this.headerParam == null) {
            this.headerParam = new HashMap<>();
        }
        this.headerParam.put(str, str2);
    }

    public void addBodyParam(String str, String str2) {
        if (this.bodyParam == null) {
            this.bodyParam = new HashMap<>();
        }
        this.bodyParam.put(str, str2);
    }

    public void addFileParam(String str, String str2) {
        if (this.fileParam == null) {
            this.fileParam = new HashMap<>();
        }
        this.fileParam.put(str, str2);
    }

    public int getConnectTime() {
        return this.connectTime;
    }

    public void setConnectTime(int i) {
        this.connectTime = i;
    }

    public int getReadTime() {
        return this.readTime;
    }

    public void setReadTime(int i) {
        this.readTime = i;
    }

    public HashMap<String, String> getHeaderParam() {
        return this.headerParam;
    }

    public void setHeaderParam(HashMap<String, String> hashMap) {
        this.headerParam = hashMap;
    }

    public HashMap<String, String> getFileParam() {
        return this.fileParam;
    }

    public void setFileParam(HashMap<String, String> hashMap) {
        this.fileParam = hashMap;
    }

    public HashMap<String, String> getBodyParam() {
        return this.bodyParam;
    }

    public void setBodyParam(HashMap<String, String> hashMap) {
        this.bodyParam = hashMap;
    }
}
