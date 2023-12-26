package com.bonree.sdk.agent.engine.webview.entity;

import java.util.Map;

public class WebviewInfo {
    private Map<String, String> additionalHttpHeaders;
    private byte[] postData;
    private int referenceCount = 0;
    private String url;

    public WebviewInfo(Map<String, String> map, String str) {
        this.additionalHttpHeaders = map;
        this.url = str;
    }

    public WebviewInfo(byte[] bArr, String str) {
        this.postData = bArr;
        this.url = str;
    }

    public void addReference() {
        this.referenceCount++;
    }

    public int reduceReference() {
        int i = this.referenceCount - 1;
        this.referenceCount = i;
        return i;
    }

    public Map<String, String> getAdditionalHttpHeaders() {
        return this.additionalHttpHeaders;
    }

    public byte[] getPostData() {
        return this.postData;
    }

    public String getUrl() {
        return this.url;
    }

    public int getReferenceCount() {
        return this.referenceCount;
    }
}
