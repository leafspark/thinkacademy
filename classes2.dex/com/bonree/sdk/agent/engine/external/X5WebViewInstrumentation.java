package com.bonree.sdk.agent.engine.external;

import android.os.Build;
import com.bonree.sdk.agent.engine.webview.BonreeCustomInterfaceBridge;
import com.bonree.sdk.agent.engine.webview.BonreeJavaScriptBridge;
import com.bonree.sdk.agent.engine.webview.JS;
import com.bonree.sdk.agent.engine.webview.g;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.common.json.HTTP;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class X5WebViewInstrumentation {
    private static int injectMax;
    private static f mLog = a.a();

    public static void setsetWebViewClient(WebView webView, WebViewClient webViewClient) {
        if (webView != null && webViewClient != null) {
            webView.setWebViewClient(webViewClient);
            setWebChromeClient(webView, webViewClient);
            webViewPageStart(webView);
        }
    }

    private static void setWebChromeClient(WebView webView, WebViewClient webViewClient) {
        if (webView != null && g.a().b() && Build.VERSION.SDK_INT >= 19) {
            WebChromeClient webChromeClient = null;
            try {
                mLog.c("x5webview  setWebChromeClient start...", new Object[0]);
                Method method = webView.getClass().getMethod("getWebChromeClient", new Class[0]);
                if (method != null) {
                    method.setAccessible(true);
                    webChromeClient = (WebChromeClient) method.invoke(webView, new Object[0]);
                }
            } catch (Throwable th) {
                mLog.a("webview get real WebChromeClient exception", th);
            }
            if (webChromeClient == null) {
                mLog.d("webview get old WebChromeClient is null", new Object[0]);
                try {
                    setRealWebChromeClient(webView, webViewClient);
                } catch (Throwable th2) {
                    mLog.a("webview set real WebChromeClient exception", th2);
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:8|9|10|11|12|(1:14)|15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        com.bonree.sdk.be.a.a().a("WEBVIEW ERROR: addJavascriptInterface: ", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038 A[Catch:{ all -> 0x0053 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void webViewPageStart(com.tencent.smtt.sdk.WebView r3) {
        /*
            com.bonree.sdk.be.f r0 = mLog
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "x5webview onPageStart"
            r0.c(r2, r1)
            com.bonree.sdk.agent.engine.webview.g r0 = com.bonree.sdk.agent.engine.webview.g.a()
            boolean r0 = r0.b()
            if (r0 != 0) goto L_0x0015
            return
        L_0x0015:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            if (r0 >= r1) goto L_0x001c
            return
        L_0x001c:
            if (r3 != 0) goto L_0x001f
            return
        L_0x001f:
            java.lang.String r0 = "searchBoxJavaBridge_"
            r3.removeJavascriptInterface(r0)     // Catch:{ all -> 0x002e }
            java.lang.String r0 = "accessibility"
            r3.removeJavascriptInterface(r0)     // Catch:{ all -> 0x002e }
            java.lang.String r0 = "accessibilityTraversal"
            r3.removeJavascriptInterface(r0)     // Catch:{ all -> 0x002e }
        L_0x002e:
            com.tencent.smtt.sdk.WebSettings r0 = r3.getSettings()     // Catch:{ all -> 0x0053 }
            boolean r0 = r0.getJavaScriptEnabled()     // Catch:{ all -> 0x0053 }
            if (r0 != 0) goto L_0x0040
            com.tencent.smtt.sdk.WebSettings r0 = r3.getSettings()     // Catch:{ all -> 0x0053 }
            r1 = 1
            r0.setJavaScriptEnabled(r1)     // Catch:{ all -> 0x0053 }
        L_0x0040:
            com.bonree.sdk.agent.engine.webview.BonreeCustomInterfaceBridge r0 = com.bonree.sdk.agent.engine.webview.BonreeCustomInterfaceBridge.getInstance()     // Catch:{ all -> 0x0053 }
            java.lang.String r1 = "bonreeJsBridge"
            r3.addJavascriptInterface(r0, r1)     // Catch:{ all -> 0x0053 }
            com.bonree.sdk.agent.engine.webview.BonreeJavaScriptBridge r0 = com.bonree.sdk.agent.engine.webview.BonreeJavaScriptBridge.getInstance()     // Catch:{ all -> 0x0053 }
            java.lang.String r1 = "bonreePrivateInterface"
            r3.addJavascriptInterface(r0, r1)     // Catch:{ all -> 0x0053 }
            return
        L_0x0053:
            r3 = move-exception
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()
            java.lang.String r1 = "WEBVIEW ERROR: addJavascriptInterface: "
            r0.a((java.lang.String) r1, (java.lang.Throwable) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.engine.external.X5WebViewInstrumentation.webViewPageStart(com.tencent.smtt.sdk.WebView):void");
    }

    private static void setRealWebChromeClient(WebView webView, WebViewClient webViewClient) {
        if (webView != null && ad.a((Class<?>) WebView.class, webView.getClass()) != null) {
            webView.setWebChromeClient(new WebChromeClient() {
                public final void onProgressChanged(WebView webView, int i) {
                    X5WebViewInstrumentation.super.onProgressChanged(webView, i);
                    X5WebViewInstrumentation.setProgressChanged(webView, i);
                }
            });
            mLog.c("x5webview set default WebChromeClient Success", new Object[0]);
        }
    }

    public static void setProgressChanged(WebView webView, int i) {
        if (g.a().b() && webView != null) {
            mLog.c("x5webview onProgressChanged，newProgress:%s", Integer.valueOf(i));
            webViewPageStart(webView);
            try {
                if (!ad.b(webView.getOriginalUrl())) {
                    String simpleName = webView.getClass().getSimpleName();
                    if (Build.VERSION.SDK_INT >= 19 && webView.getSettings().getJavaScriptEnabled()) {
                        if (injectMax < 10) {
                            injectScriptFile(webView, simpleName);
                            injectMax++;
                        }
                        if (i >= 100) {
                            injectMax = 0;
                        }
                    }
                }
            } catch (Throwable th) {
                mLog.a("x5 webview geturl error: ", th);
            }
        }
    }

    private static void injectScriptFile(WebView webView, String str) {
        BonreeJavaScriptBridge.getInstance().setWebViewName(str);
        try {
            String url = webView.getUrl();
            webView.evaluateJavascript("javascript:" + JS.getJs(url, webView.hashCode()), (ValueCallback) null);
            mLog.c("x5webview inject js success", new Object[0]);
        } catch (Throwable th) {
            mLog.a("webview inject js failed", th);
        }
    }

    public static void webViewPageFinished(WebView webView, String str) {
        injectMax = 0;
        mLog.c("x5webview onPageFinished，url:%s", str);
    }

    public static void onReceivedError(WebView webView, int i, String str, String str2) {
        String str3;
        try {
            if (g.a().b() && Build.VERSION.SDK_INT < 23) {
                mLog.c("x5webview onReceivedError errorCode = %d, description = %s, failingUrl = %s", Integer.valueOf(i), str, str2);
                String url = webView.getUrl();
                if (url != null) {
                    f fVar = mLog;
                    fVar.c("webview onReceivedError errorCode loadurl:" + webView.getUrl(), new Object[0]);
                    str3 = url;
                } else {
                    str3 = str2;
                }
                g.a().a(str2, str, i, str3, "android_webview");
            }
        } catch (Throwable th) {
            mLog.a("webview onReceivedError below 23 error", th);
        }
    }

    public static void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        try {
            if (g.a().b()) {
                mLog.c("x5webview onReceivedError errorCode = %d, description = %s, url = %s , RequestHeader= %s", Integer.valueOf(webResourceError.getErrorCode()), webResourceError.getDescription(), webResourceRequest.getUrl(), webResourceRequest.getRequestHeaders());
                String url = webView.getUrl();
                if (webResourceRequest.isForMainFrame()) {
                    url = webResourceRequest.getUrl().toString();
                }
                g.a().a(webResourceRequest.getUrl().toString(), webResourceError.getErrorCode(), formatHttpRequest(webResourceError, webResourceRequest), webResourceError.getDescription().toString(), url, "android_webview");
            }
        } catch (Throwable th) {
            mLog.a("webview onReceivedError since 23 error", th);
        }
    }

    public static void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        try {
            if (g.a().b()) {
                mLog.c("x5webview onReceivedHttpError errorCode = %d , description = %s, url = %s , RequestHeader= %s , mimeType = %s , ResponseHeader= %s , InputStream = %s", Integer.valueOf(webResourceResponse.getStatusCode()), webResourceResponse.getReasonPhrase(), webResourceRequest.getUrl(), webResourceRequest.getRequestHeaders(), webResourceResponse.getMimeType(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
                String url = webView.getUrl();
                if (webResourceRequest.isForMainFrame()) {
                    url = webResourceRequest.getUrl().toString();
                }
                g.a().a(webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode(), formatHttpHeaders(webResourceRequest.getRequestHeaders()), formatHttpResponse(webResourceResponse), webResourceResponse.getMimeType(), webResourceResponse.getReasonPhrase(), url, "http");
            }
        } catch (Throwable th) {
            mLog.a("webview onReceivedHttpError error", th);
        }
    }

    public static String formatHttpRequest(WebResourceError webResourceError, WebResourceRequest webResourceRequest) {
        Integer num;
        CharSequence charSequence;
        if (webResourceError == null && webResourceRequest == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            if (webResourceError == null) {
                num = "";
            } else {
                num = Integer.valueOf(webResourceError.getErrorCode());
            }
            Objects.toString(num);
            if (webResourceError == null) {
                charSequence = "";
            } else {
                charSequence = webResourceError.getDescription();
            }
            sb.append(charSequence);
            if (webResourceRequest != null) {
                formatHttpHeaders(webResourceRequest.getRequestHeaders());
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String formatHttpResponse(WebResourceResponse webResourceResponse) {
        if (webResourceResponse == null) {
            return "";
        }
        try {
            AtomicReference atomicReference = new AtomicReference(new StringBuilder());
            StringBuilder sb = (StringBuilder) atomicReference.get();
            sb.append(webResourceResponse.getStatusCode());
            sb.append(" ");
            sb.append(webResourceResponse.getReasonPhrase());
            sb.append(HTTP.CRLF);
            sb.append(formatHttpHeaders(webResourceResponse.getResponseHeaders()));
            return atomicReference.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String formatHttpHeaders(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String next : map.keySet()) {
                sb.append(next);
                sb.append(":");
                sb.append(map.get(next));
                sb.append(HTTP.CRLF);
            }
            sb.append("\r\n\r\n");
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        try {
            if (g.a().b()) {
                mLog.c("x5webview onReceivedSslError errorCode = %d , url = %s", Integer.valueOf(sslError.getPrimaryError()));
            }
        } catch (Throwable th) {
            mLog.a("webview onReceivedSslError error", th);
        }
    }

    public static void loadUrlInOverride(Object obj, String str) {
        if (obj instanceof WebView) {
            WebView webView = (WebView) obj;
            webView.addJavascriptInterface(BonreeCustomInterfaceBridge.getInstance(), "bonreeJsBridge");
            webView.addJavascriptInterface(BonreeJavaScriptBridge.getInstance(), "bonreePrivateInterface");
        }
    }
}
