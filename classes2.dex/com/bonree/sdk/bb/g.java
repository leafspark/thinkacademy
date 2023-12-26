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
import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.web.H5WebChromeClient;
import com.bonree.sdk.agent.engine.external.UCWebViewInstrumentation;

public final class g extends H5WebChromeClient {
    private H5WebChromeClient a;

    public g(H5PageImpl h5PageImpl, H5WebChromeClient h5WebChromeClient) {
        super(h5PageImpl);
        this.a = h5WebChromeClient;
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.a.onConsoleMessage(consoleMessage);
    }

    public final Bitmap getDefaultVideoPoster() {
        return this.a.getDefaultVideoPoster();
    }

    public final void onProgressChanged(APWebView aPWebView, int i) {
        this.a.onProgressChanged(aPWebView, i);
        UCWebViewInstrumentation.setProgressChanged(aPWebView, i);
    }

    public final void onReceivedTitle(APWebView aPWebView, String str) {
        this.a.onReceivedTitle(aPWebView, str);
    }

    public final void onReceivedIcon(APWebView aPWebView, Bitmap bitmap) {
        this.a.onReceivedIcon(aPWebView, bitmap);
    }

    public final void onReceivedTouchIconUrl(APWebView aPWebView, String str, boolean z) {
        this.a.onReceivedTouchIconUrl(aPWebView, str, z);
    }

    public final boolean onJsBeforeUnload(APWebView aPWebView, String str, String str2, APJsResult aPJsResult) {
        return this.a.onJsBeforeUnload(aPWebView, str, str2, aPJsResult);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        this.a.onGeolocationPermissionsShowPrompt(str, callback);
    }

    public final void onGeolocationPermissionsHidePrompt() {
        this.a.onGeolocationPermissionsHidePrompt();
    }

    public final View getVideoLoadingProgressView() {
        return this.a.getVideoLoadingProgressView();
    }

    public final void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        this.a.getVisitedHistory(valueCallback);
    }

    public final void openFileChooser(ValueCallback valueCallback, boolean z) {
        this.a.openFileChooser(valueCallback, z);
    }

    public final void onShowCustomView(View view, APWebChromeClient.CustomViewCallback customViewCallback) {
        this.a.onShowCustomView(view, customViewCallback);
    }

    public final void onHideCustomView() {
        this.a.onHideCustomView();
    }

    public final boolean onCreateWindow(APWebView aPWebView, boolean z, boolean z2, Message message) {
        return this.a.onCreateWindow(aPWebView, z, z2, message);
    }

    public final void onRequestFocus(APWebView aPWebView) {
        this.a.onRequestFocus(aPWebView);
    }

    public final void onCloseWindow(APWebView aPWebView) {
        this.a.onCloseWindow(aPWebView);
    }

    public final boolean onJsAlert(APWebView aPWebView, String str, String str2, APJsResult aPJsResult) {
        return this.a.onJsAlert(aPWebView, str, str2, aPJsResult);
    }

    public final boolean onJsConfirm(APWebView aPWebView, String str, String str2, APJsResult aPJsResult) {
        return this.a.onJsConfirm(aPWebView, str, str2, aPJsResult);
    }

    public final boolean onJsPrompt(APWebView aPWebView, String str, String str2, String str3, APJsPromptResult aPJsPromptResult) {
        return this.a.onJsPrompt(aPWebView, str, str2, str3, aPJsPromptResult);
    }

    public final void onRelease() {
        this.a.onRelease();
    }
}
