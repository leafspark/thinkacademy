package com.bonree.sdk.agent.engine.external;

import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bonree.sdk.agent.engine.webview.BonreeCustomInterfaceBridge;
import com.bonree.sdk.agent.engine.webview.BonreeJavaScriptBridge;
import com.bonree.sdk.agent.engine.webview.BonreeJsCallbackOhos;
import com.bonree.sdk.agent.engine.webview.JS;
import com.bonree.sdk.agent.engine.webview.g;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.q;
import com.bonree.sdk.bs.z;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import ohos.agp.components.webengine.AsyncCallback;
import ohos.agp.components.webengine.BrowserAgent;
import ohos.agp.components.webengine.ResourceError;
import ohos.agp.components.webengine.ResourceRequest;
import ohos.agp.components.webengine.WebAgent;

public class WebViewInstrumentation {
    private static final String JS_CALLBACK_NAME = "bonreePrivateInterface";
    private static final String JS_CUSTOM_CALLBACK_NAME = "bonreeJsBridge";
    private static final List<String> WEBVIEW_CLASS_NAME = Arrays.asList(new String[]{"android.webkit.WebView", "com.tencent.smtt.sdk.WebView"});
    private static int injectMax;
    private static final f mLog = a.a();

    public static void setsetWebViewClient(WebView webView, WebViewClient webViewClient) {
        if (webView != null) {
            webView.setWebViewClient(webViewClient);
            if (webViewClient != null) {
                setWebChromeClient(webView, webViewClient);
                webViewPageStart(webView);
            }
        }
    }

    private static void setWebChromeClient(WebView webView, WebViewClient webViewClient) {
        boolean z;
        if (webView != null && g.a().b() && Build.VERSION.SDK_INT >= 19) {
            f fVar = mLog;
            fVar.c("webview  setWebChromeClient start...", new Object[0]);
            WebChromeClient webChromeClient = null;
            if (Build.VERSION.SDK_INT >= 26) {
                webChromeClient = webView.getWebChromeClient();
                fVar.c("webview WebChromeClient get from  system declare api", new Object[0]);
            } else {
                try {
                    webChromeClient = getWebChromeClientLessThanO(webView);
                } catch (Throwable th) {
                    mLog.a("webview get old WebChromeClient Throwable", th);
                    z = true;
                }
            }
            z = false;
            if (!z && webChromeClient == null) {
                f fVar2 = mLog;
                fVar2.d("webview get old WebChromeClient is null", new Object[0]);
                fVar2.c("webview set real WebChromeClient start", new Object[0]);
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
        com.bonree.sdk.be.a.a().a("WEBVIEW ERROR: add bonreePrivateInterface: ", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038 A[Catch:{ all -> 0x0053 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void webViewPageStart(android.webkit.WebView r3) {
        /*
            com.bonree.sdk.agent.engine.webview.g r0 = com.bonree.sdk.agent.engine.webview.g.a()
            boolean r0 = r0.b()
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            if (r0 >= r1) goto L_0x0012
            return
        L_0x0012:
            if (r3 != 0) goto L_0x0015
            return
        L_0x0015:
            com.bonree.sdk.be.f r0 = mLog
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "webview onPageStart"
            r0.c(r2, r1)
            java.lang.String r0 = "searchBoxJavaBridge_"
            r3.removeJavascriptInterface(r0)     // Catch:{ all -> 0x002e }
            java.lang.String r0 = "accessibility"
            r3.removeJavascriptInterface(r0)     // Catch:{ all -> 0x002e }
            java.lang.String r0 = "accessibilityTraversal"
            r3.removeJavascriptInterface(r0)     // Catch:{ all -> 0x002e }
        L_0x002e:
            android.webkit.WebSettings r0 = r3.getSettings()     // Catch:{ all -> 0x0053 }
            boolean r0 = r0.getJavaScriptEnabled()     // Catch:{ all -> 0x0053 }
            if (r0 != 0) goto L_0x0040
            android.webkit.WebSettings r0 = r3.getSettings()     // Catch:{ all -> 0x0053 }
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
            java.lang.String r1 = "WEBVIEW ERROR: add bonreePrivateInterface: "
            r0.a((java.lang.String) r1, (java.lang.Throwable) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.engine.external.WebViewInstrumentation.webViewPageStart(android.webkit.WebView):void");
    }

    public static WebChromeClient getWebChromeClientLessThanO(WebView webView) throws RuntimeException {
        Object obj;
        Class<?> cls;
        Field field;
        Object obj2 = null;
        if (webView == null) {
            return null;
        }
        Class<WebView> cls2 = WebView.class;
        try {
            Method declaredMethod = cls2.getDeclaredMethod("checkThread", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(webView, new Object[0]);
        } catch (Throwable th) {
            mLog.a("invoke  webview.checkThread() exception", th);
        }
        try {
            Field declaredField = cls2.getDeclaredField("mProvider");
            declaredField.setAccessible(true);
            obj = declaredField.get(webView);
            mLog.c("webview WebChromeClient mProvider:" + obj, new Object[0]);
            cls = obj.getClass();
            Field declaredField2 = cls.getDeclaredField("mContentsClientAdapter");
            declaredField2.setAccessible(true);
            obj2 = declaredField2.get(obj);
        } catch (NoSuchFieldException e) {
            mLog.a("mProvider.getmContentsClientAdapter NoSuchFieldException", (Throwable) e);
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields != null && declaredFields.length != 0) {
                Class<?> i = ad.i("com.android.webview.chromium.WebViewContentsClientAdapter");
                if (i != null) {
                    int length = declaredFields.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        field = declaredFields[i2];
                        Class<?> type = field.getType();
                        if (i.equals(type)) {
                            break;
                        } else if (ad.b(i, type)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    field.setAccessible(true);
                    obj2 = field.get(obj);
                } else {
                    throw new ClassNotFoundException("class com.android.webview.chromium.WebViewContentsClientAdapter not found!");
                }
            }
        } catch (Throwable th2) {
            mLog.a("mProvider.getWebChromeClient() exception", th2);
            throw new RuntimeException(th2);
        }
        Field declaredField3 = obj2.getClass().getDeclaredField("mWebChromeClient");
        declaredField3.setAccessible(true);
        WebChromeClient webChromeClient = (WebChromeClient) declaredField3.get(obj2);
        mLog.c("WebChromeClient get from  system reflect", new Object[0]);
        return webChromeClient;
    }

    private static void setRealWebChromeClient(WebView webView, WebViewClient webViewClient) {
        Class<?> a;
        if (webView != null && (a = ad.a((Class<?>) WebView.class, webView.getClass())) != null) {
            Class<?> i = ad.i("org.apache.cordova.engine.SystemWebView");
            if (a.equals(i)) {
                setCordovaWebChromeClient(webView);
            } else if (i != null) {
                String name = a.getName();
                if (name.equals("com.xyzq.mobile.webviewEngine.MySystemWebView")) {
                    setXyzqWebChromeClient(webView, "com.bonree.sdk.agent.engine.webview.BonreeXyzqMobileWebChromeClient", "setXyzqWebChromeClient");
                } else if (name.equals("org.apache.cordova2.engine.MySystemWebView") || name.equals("org.apache.cordova2.engine.SystemWebView2")) {
                    setXyzqWebChromeClient(webView, "com.bonree.sdk.agent.engine.webview.BonreeXyzqCordova2WebChromeClient", "setXyzqWebChromeClient");
                } else {
                    mLog.d("not support webview:%s", webView.getClass().getName());
                }
            } else if (webView.getClass().getName().contains("io.flutter.plugins.webviewflutter.WebViewHostApiImpl$WebViewPlatformView")) {
                mLog.c("webview is io.flutter.plugins.webviewflutter.WebViewHostApiImpl$WebViewPlatformView", new Object[0]);
            } else {
                webView.setWebChromeClient(new WebChromeClient() {
                    public final void onProgressChanged(WebView webView, int i) {
                        super.onProgressChanged(webView, i);
                        WebViewInstrumentation.setProgressChanged(webView, i);
                    }
                });
                mLog.c("webview set default WebChromeClient Success", new Object[0]);
            }
        }
    }

    private static void setCordovaWebChromeClient(WebView webView) {
        Class<?> i;
        if (webView != null) {
            Class<?> cls = webView.getClass();
            try {
                Field declaredField = cls.getDeclaredField("parentEngine");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(webView);
                if (obj == null) {
                    mLog.d("not found parentEngine in SystemWebView!", new Object[0]);
                    return;
                }
                Class<?> i2 = ad.i("org.apache.cordova.engine.SystemWebChromeClient");
                if (i2 != null && (i = ad.i("org.apache.cordova.engine.SystemWebViewEngine")) != null) {
                    Constructor<?> constructor = i2.getConstructor(new Class[]{i});
                    constructor.setAccessible(true);
                    Object newInstance = constructor.newInstance(new Object[]{obj});
                    Method declaredMethod = cls.getDeclaredMethod("setWebChromeClient", new Class[]{WebChromeClient.class});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(webView, new Object[]{newInstance});
                    mLog.c("webview set cordova WebChromeClient success", new Object[0]);
                }
            } catch (Throwable th) {
                mLog.a("set CordovaWebChromeClient exception", th);
            }
        }
    }

    private static void setXyzqWebChromeClient(WebView webView, String str, String str2) {
        if (webView != null && str != null && str2 != null) {
            Class<?> i = ad.i(str);
            if (i == null) {
                f fVar = mLog;
                fVar.d("not found class %s!", str);
                fVar.c("try to load class %s!", str);
                try {
                    i = Thread.currentThread().getContextClassLoader().loadClass(str);
                } catch (ClassNotFoundException e) {
                    f fVar2 = mLog;
                    fVar2.a("load class " + str + " exception", (Throwable) e);
                    return;
                }
            }
            try {
                i.getDeclaredMethod(str2, new Class[]{WebView.class}).invoke((Object) null, new Object[]{webView});
            } catch (Throwable th) {
                f fVar3 = mLog;
                fVar3.a("invoke method " + str2 + " in " + str + " exception", th);
            }
        }
    }

    public static void setProgressChanged(WebView webView, int i) {
        if (g.a().b()) {
            mLog.c("webview onProgressChanged，newProgress:%s", Integer.valueOf(i));
            if (webView != null) {
                webViewPageStart(webView);
                try {
                    if (!TextUtils.isEmpty(webView.getOriginalUrl())) {
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
                    mLog.a("webview geturl error: ", th);
                }
            }
        }
    }

    private static void injectScriptFile(WebView webView, String str) {
        BonreeJavaScriptBridge.getInstance().setWebViewName(str);
        try {
            String url = webView.getUrl();
            String js = JS.getJs(url, webView.hashCode());
            webView.evaluateJavascript("javascript:" + js, (ValueCallback) null);
            f fVar = mLog;
            fVar.c("webview inject js success:" + url + "  originalUrl: " + webView.getOriginalUrl(), new Object[0]);
        } catch (Throwable th) {
            mLog.a("webview inject js failed", th);
        }
    }

    public static void webViewPageFinished(WebView webView, String str) {
        injectMax = 0;
        mLog.c("webview onPageFinished，url:%s", str);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0057 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005d A[Catch:{ all -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005f A[Catch:{ all -> 0x006d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void onReceivedError(android.webkit.WebView r8, int r9, java.lang.String r10, java.lang.String r11) {
        /*
            com.bonree.sdk.agent.engine.webview.g r0 = com.bonree.sdk.agent.engine.webview.g.a()     // Catch:{ all -> 0x006d }
            boolean r0 = r0.b()     // Catch:{ all -> 0x006d }
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x006d }
            r1 = 23
            if (r0 >= r1) goto L_0x006c
            com.bonree.sdk.be.f r0 = mLog     // Catch:{ all -> 0x006d }
            java.lang.String r1 = "webview onReceivedError errorCode = %d, description = %s, failingUrl = %s"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x006d }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x006d }
            r4 = 0
            r2[r4] = r3     // Catch:{ all -> 0x006d }
            r3 = 1
            r2[r3] = r10     // Catch:{ all -> 0x006d }
            r3 = 2
            r2[r3] = r11     // Catch:{ all -> 0x006d }
            r0.c(r1, r2)     // Catch:{ all -> 0x006d }
            r1 = 0
            java.lang.String r1 = r8.getUrl()     // Catch:{ all -> 0x0057 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = "webview onReceivedError errorCode loadurl:"
            r2.<init>(r3)     // Catch:{ all -> 0x0057 }
            r2.append(r1)     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0057 }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ all -> 0x0057 }
            r0.c(r2, r3)     // Catch:{ all -> 0x0057 }
            java.lang.String r1 = r8.getOriginalUrl()     // Catch:{ all -> 0x0057 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = "webview onReceivedError errorCode original loadurl:"
            r8.<init>(r2)     // Catch:{ all -> 0x0057 }
            r8.append(r1)     // Catch:{ all -> 0x0057 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0057 }
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x0057 }
            r0.c(r8, r2)     // Catch:{ all -> 0x0057 }
        L_0x0057:
            boolean r8 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x006d }
            if (r8 == 0) goto L_0x005f
            r6 = r11
            goto L_0x0060
        L_0x005f:
            r6 = r1
        L_0x0060:
            com.bonree.sdk.agent.engine.webview.g r2 = com.bonree.sdk.agent.engine.webview.g.a()     // Catch:{ all -> 0x006d }
            java.lang.String r7 = "android_webview"
            r3 = r11
            r4 = r10
            r5 = r9
            r2.a(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x006d }
        L_0x006c:
            return
        L_0x006d:
            r8 = move-exception
            com.bonree.sdk.be.f r9 = mLog
            java.lang.String r10 = "webview onReceivedError below 23 error"
            r9.a((java.lang.String) r10, (java.lang.Throwable) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.engine.external.WebViewInstrumentation.onReceivedError(android.webkit.WebView, int, java.lang.String, java.lang.String):void");
    }

    public static void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        try {
            if (g.a().b()) {
                String url = webView.getUrl();
                if (webResourceRequest.isForMainFrame()) {
                    url = webResourceRequest.getUrl().toString();
                }
                g.a().a(webResourceRequest.getUrl().toString(), webResourceError.getErrorCode(), ad.a(webResourceError, webResourceRequest), webResourceError.getDescription().toString(), url, "android_webview");
            }
        } catch (Throwable th) {
            mLog.a("webview onReceivedError since 23 error", th);
        }
    }

    public static void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        try {
            if (g.a().b()) {
                mLog.c("webview onReceivedHttpError errorCode = %d , description = %s, url = %s , RequestHeader= %s , mimeType = %s , ResponseHeader= %s , InputStream = %s", Integer.valueOf(webResourceResponse.getStatusCode()), webResourceResponse.getReasonPhrase(), webResourceRequest.getUrl(), webResourceRequest.getRequestHeaders(), webResourceResponse.getMimeType(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
                String url = webView.getUrl();
                if (webResourceRequest.isForMainFrame()) {
                    url = webResourceRequest.getUrl().toString();
                }
                g.a().a(webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode(), ad.a(webResourceRequest.getRequestHeaders()), ad.a(webResourceResponse), webResourceResponse.getMimeType(), webResourceResponse.getReasonPhrase(), url, "http");
            }
        } catch (Throwable th) {
            mLog.a("webview onReceivedHttpError error", th);
        }
    }

    public static void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        try {
            if (g.a().b()) {
                f fVar = mLog;
                fVar.c("webview onReceivedSslError errorCode = %d , url = %s", Integer.valueOf(sslError.getPrimaryError()), sslError.getUrl());
                String url = webView.getUrl();
                if (url != null) {
                    fVar.c("webview onReceivedSslError errorCode loadurl:" + webView.getUrl(), new Object[0]);
                } else {
                    url = sslError.getUrl();
                }
                g.a().b(sslError.getUrl(), "", sslError.getPrimaryError(), url, "android_webview_ssl");
            }
        } catch (Throwable th) {
            mLog.a("webview onReceivedSslError error", th);
        }
    }

    public static void postUrl(Object obj, String str, byte[] bArr) {
        try {
            obj.getClass().getMethod("postUrl", new Class[]{String.class, byte[].class}).invoke(obj, new Object[]{str, bArr});
            if (!TextUtils.isEmpty(str) && bArr != null && bArr.length > 0 && g.a().b()) {
                if (z.a(obj.getClass(), WEBVIEW_CLASS_NAME)) {
                    g.a().a(obj, str, bArr);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void loadUrl(Object obj, String str, Map<String, String> map) {
        try {
            obj.getClass().getMethod("loadUrl", new Class[]{String.class, Map.class}).invoke(obj, new Object[]{str, map});
            if (!TextUtils.isEmpty(str) && map != null && map.size() > 0 && g.a().b()) {
                if (z.a(obj.getClass(), WEBVIEW_CLASS_NAME)) {
                    g.a().a(obj, str, map);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void loadUrlInOverride(Object obj, String str) {
        if (obj instanceof WebView) {
            WebView webView = (WebView) obj;
            webView.addJavascriptInterface(BonreeCustomInterfaceBridge.getInstance(), JS_CUSTOM_CALLBACK_NAME);
            webView.addJavascriptInterface(BonreeJavaScriptBridge.getInstance(), JS_CALLBACK_NAME);
        }
    }

    public static void setWebAgent(ohos.agp.components.webengine.WebView webView, WebAgent webAgent) {
        if (webView != null) {
            webView.setWebAgent(webAgent);
            if (webAgent != null) {
                webViewPageStart(webView);
                setBrowserAgent(webView);
            }
        }
    }

    private static void setBrowserAgent(ohos.agp.components.webengine.WebView webView) {
        if (webView != null && g.a().b()) {
            if (!hasBrowerAgent(webView)) {
                webView.setBrowserAgent(new BrowserAgent(q.a()) {
                    public final void onProgressUpdated(ohos.agp.components.webengine.WebView webView, int i) {
                        WebViewInstrumentation.super.onProgressUpdated(webView, i);
                        WebViewInstrumentation.onProgressUpdated(webView, i);
                    }
                });
            }
            mLog.c("webview set default BrowserAgent Success", new Object[0]);
        }
    }

    private static boolean hasBrowerAgent(ohos.agp.components.webengine.WebView webView) {
        try {
            Field declaredField = webView.getClass().getDeclaredField("mWebViewBridge");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(webView);
            Field declaredField2 = obj.getClass().getDeclaredField("mBrowserAgentBridge");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 != null) {
                Field declaredField3 = obj2.getClass().getDeclaredField("mBrowserAgentInterface");
                declaredField3.setAccessible(true);
                Object obj3 = declaredField3.get(obj2);
                if (obj3 != null) {
                    Field declaredField4 = obj3.getClass().getDeclaredField("this$0");
                    declaredField4.setAccessible(true);
                    if (declaredField4.get(obj3) instanceof BrowserAgent) {
                        mLog.c("browserAgent is instanceof BrowserAgent", new Object[0]);
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static void webViewPageStart(ohos.agp.components.webengine.WebView webView) {
        if (webView != null && g.a().b()) {
            mLog.c("webview onPageStart", new Object[0]);
            try {
                if (!webView.getWebConfig().isJavaScriptPermitted()) {
                    webView.getWebConfig().setJavaScriptPermit(true);
                }
                webView.addJsCallback(JS_CUSTOM_CALLBACK_NAME, com.bonree.sdk.agent.engine.webview.a.a());
                webView.addJsCallback(JS_CALLBACK_NAME, BonreeJsCallbackOhos.getInstance());
            } catch (Throwable th) {
                a.a().a("WEBVIEW ERROR: add BonreeJsCallback: ", th);
            }
        }
    }

    public static void onProgressUpdated(ohos.agp.components.webengine.WebView webView, int i) {
        mLog.c("webview onProgressChanged，newProgress:%s", Integer.valueOf(i));
        if (webView != null && webView.getWebConfig().isJavaScriptPermitted() && !TextUtils.isEmpty(webView.getFirstRequestUrl())) {
            String simpleName = webView.getClass().getSimpleName();
            if (injectMax < 10) {
                injectScriptFile(webView, simpleName);
                injectMax++;
            }
            if (i >= 100) {
                injectMax = 0;
            }
        }
    }

    private static void injectScriptFile(ohos.agp.components.webengine.WebView webView, String str) {
        BonreeJavaScriptBridge.getInstance().setWebViewName(str);
        try {
            Method declaredMethod = ohos.agp.components.webengine.WebView.class.getDeclaredMethod("executeJs", new Class[]{String.class, AsyncCallback.class});
            declaredMethod.setAccessible(true);
            String firstRequestUrl = webView.getFirstRequestUrl();
            if (!TextUtils.isEmpty(firstRequestUrl)) {
                String js = JS.getJs(firstRequestUrl, 4, -1);
                declaredMethod.invoke(webView, new Object[]{"javascript:" + js, null});
                f fVar = mLog;
                fVar.c("webview inject js success:" + firstRequestUrl, new Object[0]);
            }
        } catch (Throwable th) {
            mLog.a("webview inject js failed", th);
        }
    }

    public static void onPageLoaded(ohos.agp.components.webengine.WebView webView, String str) {
        injectMax = 0;
        mLog.c("webview onPageFinished，url:%s", str);
    }

    public static void onError(ohos.agp.components.webengine.WebView webView, ResourceRequest resourceRequest, ResourceError resourceError) {
        try {
            if (g.a().b()) {
                String firstRequestUrl = webView.getFirstRequestUrl();
                if (resourceRequest.isMainFrame()) {
                    firstRequestUrl = resourceRequest.getRequestUrl().toString();
                }
                String str = firstRequestUrl;
                g.a().a(str, resourceError.getErrorCode(), ad.a(resourceError, resourceRequest), resourceError.getInfo().toString(), str, "android_webview");
            }
        } catch (Throwable th) {
            mLog.a("webview onReceivedError since 23 error", th);
        }
    }

    public static void onSslError(ohos.agp.components.webengine.WebView webView, ohos.net.http.SslError sslError) {
        try {
            if (g.a().b()) {
                f fVar = mLog;
                fVar.c("webview onReceivedSslError errorCode = %d , url = %s", Integer.valueOf(sslError.getCriticalError()), sslError.getUrl());
                String firstRequestUrl = webView.getFirstRequestUrl();
                if (firstRequestUrl != null) {
                    fVar.c("webview onReceivedSslError errorCode loadurl:" + webView.getFirstRequestUrl(), new Object[0]);
                } else {
                    firstRequestUrl = sslError.getUrl();
                }
                g.a().b(sslError.getUrl(), "", sslError.getCriticalError(), firstRequestUrl, "android_webview_ssl");
            }
        } catch (Throwable th) {
            mLog.a("webview onReceivedSslError error", th);
        }
    }
}
