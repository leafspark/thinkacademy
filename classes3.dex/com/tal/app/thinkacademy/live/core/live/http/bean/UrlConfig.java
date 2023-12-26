package com.tal.app.thinkacademy.live.core.live.http.bean;

public class UrlConfig {
    private String getChatRecordUrl;
    private String getMetadataUrl;
    private String initModuleUrl;

    public String getInitModuleUrl() {
        return this.initModuleUrl;
    }

    public void setInitModuleUrl(String str) {
        this.initModuleUrl = str;
    }

    public String getGetChatRecordUrl() {
        return this.getChatRecordUrl;
    }

    public void setGetChatRecordUrl(String str) {
        this.getChatRecordUrl = str;
    }

    public String getGetMetadataUrl() {
        return this.getMetadataUrl;
    }

    public void setGetMetadataUrl(String str) {
        this.getMetadataUrl = str;
    }

    public String toString() {
        return "Urls{getChatRecordUrl='" + this.getChatRecordUrl + '\'' + ", getMetadataUrl='" + this.getMetadataUrl + '\'' + ", initModuleUrl='" + this.initModuleUrl + '\'' + '}';
    }
}
