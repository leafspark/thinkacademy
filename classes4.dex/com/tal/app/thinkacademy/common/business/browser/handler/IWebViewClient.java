package com.tal.app.thinkacademy.common.business.browser.handler;

public interface IWebViewClient {
    void jsCallBack(String str, String str2);

    boolean onUrlLoading(String str);
}
