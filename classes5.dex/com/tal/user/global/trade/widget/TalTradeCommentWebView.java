package com.tal.user.global.trade.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bonree.sdk.agent.engine.external.WebViewInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.user.global.trade.api.TalTradeSdk;
import java.util.HashMap;
import java.util.Map;

public class TalTradeCommentWebView extends WebView {
    /* access modifiers changed from: private */
    public Context context;
    private Map<String, String> map = new HashMap();
    /* access modifiers changed from: private */
    public PayStatus payStatus;

    public interface PayStatus<T> {
        void onLoadSuccess();

        void onProgress(int i);

        void onTitle(String str);
    }

    public void loadUrl(String str) {
        WebViewInstrumentation.loadUrlInOverride(this, str);
        super.loadUrl(str);
    }

    public TalTradeCommentWebView(Context context2) {
        super(context2);
        this.context = context2;
    }

    public TalTradeCommentWebView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
        init();
    }

    public TalTradeCommentWebView(Context context2, AttributeSet attributeSet, int i) {
        super(getFixedContext(context2), attributeSet, i);
        this.context = context2;
        init();
    }

    public static Context getFixedContext(Context context2) {
        return (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT >= 23) ? context2 : context2.createConfigurationContext(new Configuration());
    }

    private void init() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSupportMultipleWindows(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setAllowFileAccess(true);
        getSettings().setDefaultTextEncodingName("UTF-8");
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setUseWideViewPort(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setAppCacheEnabled(true);
        setDownloadListener(new MyWebViewDownLoadListener());
        getSettings().setPluginState(WebSettings.PluginState.ON);
        getSettings().setUseWideViewPort(true);
        getSettings().setAllowFileAccess(true);
        getSettings().setSupportZoom(true);
        getSettings().setLoadWithOverviewMode(true);
        String userAgentString = getSettings().getUserAgentString();
        WebSettings settings = getSettings();
        settings.setUserAgentString(userAgentString + " " + TalTradeSdk.TAG);
        if (Build.VERSION.SDK_INT >= 21) {
            getSettings().setMixedContentMode(0);
        }
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptThirdPartyCookies(this, true);
        instance.setAcceptCookie(true);
        setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView webView, int i) {
                WebViewInstrumentation.setProgressChanged(webView, i);
                super.onProgressChanged(webView, i);
                if (TalTradeCommentWebView.this.payStatus != null) {
                    TalTradeCommentWebView.this.payStatus.onProgress(i);
                }
            }

            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (TalTradeCommentWebView.this.payStatus != null) {
                    TalTradeCommentWebView.this.payStatus.onTitle(str);
                }
            }
        });
    }

    public void setUrl(String str) {
        setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                WebViewInstrumentation.onReceivedError(webView, i, str, str2);
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                WebViewInstrumentation.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                WebViewInstrumentation.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                WebViewInstrumentation.onReceivedSslError(webView, sslErrorHandler, sslError);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str.startsWith("http:") || str.startsWith("https:")) {
                    TalTradeCommentWebView talTradeCommentWebView = TalTradeCommentWebView.this;
                    Map<String, String> map = talTradeCommentWebView.getMap();
                    if (!(talTradeCommentWebView instanceof Object)) {
                        talTradeCommentWebView.loadUrl(str, map);
                    } else {
                        WebViewInstrumentation.loadUrl(talTradeCommentWebView, str, map);
                    }
                    SensorsDataAutoTrackHelper.loadUrl2(talTradeCommentWebView, str, map);
                    return true;
                }
                try {
                    TalTradeCommentWebView.this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            public void onPageFinished(WebView webView, String str) {
                WebViewInstrumentation.webViewPageFinished(webView, str);
                super.onPageFinished(webView, str);
                if (TalTradeCommentWebView.this.payStatus != null) {
                    TalTradeCommentWebView.this.payStatus.onLoadSuccess();
                }
            }
        });
        Map<String, String> map2 = getMap();
        loadUrl(str, map2);
        SensorsDataAutoTrackHelper.loadUrl2(this, str, map2);
    }

    public void setPayStatus(PayStatus payStatus2) {
        this.payStatus = payStatus2;
    }

    private class MyWebViewDownLoadListener implements DownloadListener {
        private MyWebViewDownLoadListener() {
        }

        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            TalTradeCommentWebView.this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
    }

    public Map<String, String> getMap() {
        if (this.map == null) {
            this.map = new HashMap();
        }
        return this.map;
    }

    public String getDomain(String str) {
        if (!TextUtils.isEmpty(str) && (str.startsWith("http") || str.startsWith("https"))) {
            try {
                return Uri.parse(str).getHost();
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public void clearWebViewCookie() {
        CookieManager instance = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT >= 21) {
            instance.removeSessionCookies((ValueCallback) null);
        } else {
            instance.removeSessionCookie();
        }
    }
}
