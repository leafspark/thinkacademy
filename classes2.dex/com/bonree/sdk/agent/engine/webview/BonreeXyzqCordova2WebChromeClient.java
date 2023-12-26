package com.bonree.sdk.agent.engine.webview;

import android.webkit.WebView;
import com.bonree.sdk.agent.engine.external.WebViewInstrumentation;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;
import java.lang.reflect.Field;
import org.apache.cordova2.engine.MySystemWebChromeClient;
import org.apache.cordova2.engine.MySystemWebView;
import org.apache.cordova2.engine.MySystemWebViewEngine;

public class BonreeXyzqCordova2WebChromeClient extends MySystemWebChromeClient {
    private static f a = a.a();

    private BonreeXyzqCordova2WebChromeClient(MySystemWebViewEngine mySystemWebViewEngine) {
        super(mySystemWebViewEngine);
    }

    public void onProgressChanged(WebView webView, int i) {
        BonreeXyzqCordova2WebChromeClient.super.onProgressChanged(webView, i);
        WebViewInstrumentation.setProgressChanged(webView, i);
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [com.bonree.sdk.agent.engine.webview.BonreeXyzqCordova2WebChromeClient, android.webkit.WebChromeClient] */
    /* JADX WARNING: type inference failed for: r7v3, types: [com.bonree.sdk.agent.engine.webview.BonreeXyzqCordova2WebChromeClient, android.webkit.WebChromeClient] */
    public static void setXyzqWebChromeClient(WebView webView) {
        if (webView != null) {
            a.c("webview set xyzq cordova2 WebChromeClient start...", new Object[0]);
            if (!(webView instanceof MySystemWebView)) {
                a.e("this webview must be org.apache.cordova2.engine.MySystemWebView! current webview:%s", webView.getClass().getName());
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
                webView.setWebChromeClient(new BonreeXyzqCordova2WebChromeClient(mySystemWebViewEngine));
                a.c("webview set xyzq cordova2 WebChromeClient success", new Object[0]);
            } catch (Throwable th) {
                a.a("webview try to get xyzq  cordova2 MySystemWebViewEngine exception", th);
            }
        }
    }
}
