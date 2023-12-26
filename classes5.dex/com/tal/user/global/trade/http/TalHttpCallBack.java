package com.tal.user.global.trade.http;

public abstract class TalHttpCallBack {
    protected String url;

    public void onError(Object obj, String str) {
    }

    public void onFail(Object obj, String str) {
    }

    public abstract void onSuccess(Object obj);

    public void setUrl(String str) {
        this.url = str;
    }
}
