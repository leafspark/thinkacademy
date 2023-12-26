package com.tal.app.thinkacademy.common.business.browser.handler;

import android.webkit.ConsoleMessage;
import android.webkit.WebResourceError;

public abstract class WebViewLifeHandler {
    public void onConsoleMessage(ConsoleMessage consoleMessage) {
    }

    public void onPageFinish(String str) {
    }

    public void onPageStart(String str) {
    }

    public void onProgress(int i) {
    }

    public void onReceiveTitle(String str) {
    }

    public void onReceivedError(String str, WebResourceError webResourceError) {
    }

    public boolean onUrlLoading(String str) {
        return false;
    }
}
