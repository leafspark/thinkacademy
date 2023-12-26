package com.bonree.sdk.agent.engine.webview;

import android.webkit.WebView;
import com.bonree.sdk.agent.engine.external.WebViewInstrumentation;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;
import com.xyzq.mobile.webviewEngine.MySystemWebChromeClient;
import com.xyzq.mobile.webviewEngine.MySystemWebView;
import com.xyzq.mobile.webviewEngine.MySystemWebViewEngine;
import java.lang.reflect.Field;

public class BonreeXyzqMobileWebChromeClient extends MySystemWebChromeClient {
    private static f a = a.a();

    private BonreeXyzqMobileWebChromeClient(MySystemWebViewEngine mySystemWebViewEngine) {
        super(mySystemWebViewEngine);
    }

    public void onProgressChanged(WebView webView, int i) {
        BonreeXyzqMobileWebChromeClient.super.onProgressChanged(webView, i);
        WebViewInstrumentation.setProgressChanged(webView, i);
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [com.bonree.sdk.agent.engine.webview.BonreeXyzqMobileWebChromeClient, android.webkit.WebChromeClient] */
    /* JADX WARNING: type inference failed for: r7v3, types: [com.bonree.sdk.agent.engine.webview.BonreeXyzqMobileWebChromeClient, android.webkit.WebChromeClient] */
    public static void setXyzqWebChromeClient(WebView webView) {
        if (webView != null) {
            a.c("webview set xyzq mobile WebChromeClient start...", new Object[0]);
            if (!(webView instanceof MySystemWebView)) {
                a.e("this webview must be com.xyzq.phonept.webviewEngine.MySystemWebView! current webview:%s", webView.getClass().getName());
                return;
            }
            MySystemWebView mySystemWebView = (MySystemWebView) webView;
            Class<MySystemWebView> cls = MySystemWebView.class;
            try {
                Field declaredField = cls.getDeclaredField("parentEngine");
                declaredField.setAccessible(true);
                MySystemWebViewEngine mySystemWebViewEngine = (MySystemWebViewEngine) declaredField.get(mySystemWebView);
                if (mySystemWebViewEngine == null) {
                    a.d("parentEngine is null!", new Object[0]);
                    return;
                }
                webView.setWebChromeClient(new BonreeXyzqMobileWebChromeClient(mySystemWebViewEngine));
                a.c("webview set xyzq mobile WebChromeClient success", new Object[0]);
            } catch (Throwable th) {
                a.a("webview try to get xyzq  mobile MySystemWebViewEngine exception", th);
            }
        }
    }
}
