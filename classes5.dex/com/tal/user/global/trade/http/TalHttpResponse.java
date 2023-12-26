package com.tal.user.global.trade.http;

public class TalHttpResponse {
    private int code;
    private String result;

    public TalHttpResponse() {
    }

    public TalHttpResponse(int i, String str) {
        this.code = i;
        this.result = str;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }
}
