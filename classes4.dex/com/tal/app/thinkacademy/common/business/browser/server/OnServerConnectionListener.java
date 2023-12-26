package com.tal.app.thinkacademy.common.business.browser.server;

public interface OnServerConnectionListener {
    void onServerError(String str);

    void onServerRequestError(int i, String str);

    void onServerStart(String str);

    void onServerStop();
}
