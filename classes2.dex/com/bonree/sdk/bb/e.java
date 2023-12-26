package com.bonree.sdk.bb;

import android.net.http.SslError;
import com.alipay.mobile.nebula.webview.APSslErrorHandler;
import com.alipay.mobile.nebula.webview.APWebView;
import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.web.H5WebViewClient;
import com.bonree.sdk.agent.engine.external.UCWebViewInstrumentation;

public final class e extends H5WebViewClient {
    public e(H5PageImpl h5PageImpl) {
        super(h5PageImpl);
    }

    public final void onReceivedError(APWebView aPWebView, int i, String str, String str2) {
        e.super.onReceivedError(aPWebView, i, str, str2);
        UCWebViewInstrumentation.onReceivedError(aPWebView, i, str, str2);
    }

    public final void onReceivedHttpError(APWebView aPWebView, int i, String str) {
        e.super.onReceivedHttpError(aPWebView, i, str);
        UCWebViewInstrumentation.onReceivedHttpError(aPWebView, i, str);
    }

    public final void onReceivedSslError(APWebView aPWebView, APSslErrorHandler aPSslErrorHandler, SslError sslError) {
        e.super.onReceivedSslError(aPWebView, aPSslErrorHandler, sslError);
        UCWebViewInstrumentation.onReceivedSslError(aPWebView, aPSslErrorHandler, sslError);
    }

    public final void onPageFinished(APWebView aPWebView, String str, long j) {
        e.super.onPageFinished(aPWebView, str, j);
        UCWebViewInstrumentation.webViewPageFinished(aPWebView, str, j);
    }
}
