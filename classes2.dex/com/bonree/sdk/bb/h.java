package com.bonree.sdk.bb;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebResourceResponse;
import com.alipay.mobile.nebula.appcenter.api.H5ContentProvider;
import com.alipay.mobile.nebula.webview.APHttpAuthHandler;
import com.alipay.mobile.nebula.webview.APSslErrorHandler;
import com.alipay.mobile.nebula.webview.APWebResourceRequest;
import com.alipay.mobile.nebula.webview.APWebView;
import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.web.H5WebViewClient;
import com.bonree.sdk.agent.engine.external.UCWebViewInstrumentation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h extends H5WebViewClient {
    private H5WebViewClient a;

    public h(H5PageImpl h5PageImpl, H5WebViewClient h5WebViewClient) {
        super(h5PageImpl);
        this.a = h5WebViewClient;
    }

    public final String getPageUrl() {
        return this.a.getPageUrl();
    }

    public final String getShareUrl() {
        return this.a.getShareUrl();
    }

    public final String getRedirectUrl() {
        return this.a.getRedirectUrl();
    }

    public final void setCheckingUrl(String str) {
        this.a.setCheckingUrl(str);
    }

    public final void setWebProvider(H5ContentProvider h5ContentProvider) {
        this.a.setWebProvider(h5ContentProvider);
    }

    public final boolean shouldOverrideUrlLoading(APWebView aPWebView, String str) {
        return this.a.shouldOverrideUrlLoading(aPWebView, str);
    }

    public final void onReceivedError(APWebView aPWebView, int i, String str, String str2) {
        this.a.onReceivedError(aPWebView, i, str, str2);
        UCWebViewInstrumentation.onReceivedError(aPWebView, i, str, str2);
    }

    public final void onReceivedHttpError(APWebView aPWebView, int i, String str) {
        this.a.onReceivedHttpError(aPWebView, i, str);
        UCWebViewInstrumentation.onReceivedHttpError(aPWebView, i, str);
    }

    public final void onReceivedSslError(APWebView aPWebView, APSslErrorHandler aPSslErrorHandler, SslError sslError) {
        this.a.onReceivedSslError(aPWebView, aPSslErrorHandler, sslError);
        UCWebViewInstrumentation.onReceivedSslError(aPWebView, aPSslErrorHandler, sslError);
    }

    public final void onResourceResponse(APWebView aPWebView, HashMap<String, String> hashMap) {
        this.a.onResourceResponse(aPWebView, hashMap);
    }

    public final void onResourceFinishLoad(APWebView aPWebView, String str, long j) {
        this.a.onResourceFinishLoad(aPWebView, str, j);
    }

    public final void onReceivedResponseHeader(Map<String, List<String>> map) {
        this.a.onReceivedResponseHeader(map);
    }

    public final boolean shouldOverrideUrlLoadingForUC(APWebView aPWebView, String str, int i) {
        return this.a.shouldOverrideUrlLoadingForUC(aPWebView, str, i);
    }

    public final Map getRequestMap() {
        return this.a.getRequestMap();
    }

    public final boolean shouldInterceptResponse(APWebView aPWebView, HashMap<String, String> hashMap) {
        return this.a.shouldInterceptResponse(aPWebView, hashMap);
    }

    public final void onWebViewEvent(APWebView aPWebView, int i, Object obj) {
        this.a.onWebViewEvent(aPWebView, i, obj);
    }

    public final void onFirstVisuallyRender(APWebView aPWebView) {
        this.a.onFirstVisuallyRender(aPWebView);
    }

    public final void onFormResubmission(APWebView aPWebView, Message message, Message message2) {
        this.a.onFormResubmission(aPWebView, message, message2);
    }

    public final void onReceivedHttpAuthRequest(APWebView aPWebView, APHttpAuthHandler aPHttpAuthHandler, String str, String str2) {
        this.a.onReceivedHttpAuthRequest(aPWebView, aPHttpAuthHandler, str, str2);
    }

    public final boolean shouldOverrideKeyEvent(APWebView aPWebView, KeyEvent keyEvent) {
        return this.a.shouldOverrideKeyEvent(aPWebView, keyEvent);
    }

    public final void onUnhandledKeyEvent(APWebView aPWebView, KeyEvent keyEvent) {
        this.a.onUnhandledKeyEvent(aPWebView, keyEvent);
    }

    public final void onScaleChanged(APWebView aPWebView, float f, float f2) {
        this.a.onScaleChanged(aPWebView, f, f2);
    }

    public final void onReceivedLoginRequest(APWebView aPWebView, String str, String str2, String str3) {
        this.a.onReceivedLoginRequest(aPWebView, str, str2, str3);
    }

    public final String getJSBridge() {
        return this.a.getJSBridge();
    }

    public final WebResourceResponse shouldInterceptRequest(APWebView aPWebView, APWebResourceRequest aPWebResourceRequest) {
        return this.a.shouldInterceptRequest(aPWebView, aPWebResourceRequest);
    }

    public final WebResourceResponse shouldInterceptRequest(APWebView aPWebView, String str) {
        return this.a.shouldInterceptRequest(aPWebView, str);
    }

    public final void onTooManyRedirects(APWebView aPWebView, Message message, Message message2) {
        this.a.onTooManyRedirects(aPWebView, message, message2);
    }

    public final void onLoadResource(APWebView aPWebView, String str) {
        this.a.onLoadResource(aPWebView, str);
    }

    public final void onPageStarted(APWebView aPWebView, String str, Bitmap bitmap) {
        this.a.onPageStarted(aPWebView, str, bitmap);
    }

    public final void doUpdateVisitedHistory(APWebView aPWebView, String str, boolean z) {
        this.a.doUpdateVisitedHistory(aPWebView, str, z);
    }

    public final void onPageFinished(APWebView aPWebView, String str, long j) {
        this.a.onPageFinished(aPWebView, str, j);
        UCWebViewInstrumentation.webViewPageFinished(aPWebView, str, j);
    }

    public final void onRelease() {
        this.a.onRelease();
    }
}
