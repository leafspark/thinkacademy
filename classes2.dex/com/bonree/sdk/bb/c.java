package com.bonree.sdk.bb;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import com.alipay.mobile.nebula.webview.APJsPromptResult;
import com.alipay.mobile.nebula.webview.APJsResult;
import com.alipay.mobile.nebula.webview.APWebChromeClient;
import com.alipay.mobile.nebula.webview.APWebView;
import com.bonree.sdk.agent.engine.external.UCWebViewInstrumentation;

public final class c implements APWebChromeClient {
    public final Bitmap getDefaultVideoPoster() {
        return null;
    }

    public final View getVideoLoadingProgressView() {
        return null;
    }

    public final void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    public final void onCloseWindow(APWebView aPWebView) {
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return false;
    }

    public final boolean onCreateWindow(APWebView aPWebView, boolean z, boolean z2, Message message) {
        return false;
    }

    public final void onGeolocationPermissionsHidePrompt() {
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
    }

    public final void onHideCustomView() {
    }

    public final boolean onJsAlert(APWebView aPWebView, String str, String str2, APJsResult aPJsResult) {
        return false;
    }

    public final boolean onJsBeforeUnload(APWebView aPWebView, String str, String str2, APJsResult aPJsResult) {
        return false;
    }

    public final boolean onJsConfirm(APWebView aPWebView, String str, String str2, APJsResult aPJsResult) {
        return false;
    }

    public final boolean onJsPrompt(APWebView aPWebView, String str, String str2, String str3, APJsPromptResult aPJsPromptResult) {
        return false;
    }

    public final void onReceivedIcon(APWebView aPWebView, Bitmap bitmap) {
    }

    public final void onReceivedTitle(APWebView aPWebView, String str) {
    }

    public final void onReceivedTouchIconUrl(APWebView aPWebView, String str, boolean z) {
    }

    public final void onRequestFocus(APWebView aPWebView) {
    }

    public final void onShowCustomView(View view, APWebChromeClient.CustomViewCallback customViewCallback) {
    }

    public final void openFileChooser(ValueCallback valueCallback, boolean z) {
    }

    public final void onProgressChanged(APWebView aPWebView, int i) {
        UCWebViewInstrumentation.setProgressChanged(aPWebView, i);
    }
}
