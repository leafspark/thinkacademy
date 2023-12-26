package com.bonree.sdk.agent.engine.external;

import android.app.Activity;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.alipay.mobile.h5container.api.H5Bundle;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.webview.APSslErrorHandler;
import com.alipay.mobile.nebula.webview.APWebChromeClient;
import com.alipay.mobile.nebula.webview.APWebView;
import com.alipay.mobile.nebula.webview.APWebViewClient;
import com.alipay.mobile.nebulacore.android.AndroidWebView;
import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.web.H5WebChromeClient;
import com.alipay.mobile.nebulacore.web.H5WebView;
import com.alipay.mobile.nebulacore.web.H5WebViewClient;
import com.alipay.mobile.nebulauc.impl.UCWebView;
import com.bonree.sdk.agent.engine.webview.BonreeUCJavaScriptBridge;
import com.bonree.sdk.agent.engine.webview.JS;
import com.bonree.sdk.bb.b;
import com.bonree.sdk.bb.c;
import com.bonree.sdk.bb.d;
import com.bonree.sdk.bb.e;
import com.bonree.sdk.bb.g;
import com.bonree.sdk.bb.h;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.WebView;
import java.lang.reflect.Field;

public class UCWebViewInstrumentation {
    private static int injectMax;
    private static f mLog = a.a();

    public static void setsetWebViewClient(APWebView aPWebView, APWebViewClient aPWebViewClient) {
        if (aPWebView != null && aPWebViewClient != null) {
            boolean z = aPWebViewClient instanceof b;
            if (z || (aPWebViewClient instanceof e) || (aPWebViewClient instanceof h)) {
                aPWebView.setWebViewClient(aPWebViewClient);
                mLog.d("no need wrap APWebViewClient! webview is %s, client is %s", aPWebView, aPWebViewClient);
                if (z) {
                    mLog.c("setsetWebViewClient client is APWebViewClientWraper", new Object[0]);
                }
                if (aPWebViewClient instanceof e) {
                    mLog.c("setsetWebViewClient client is BonreeH5WebViewClient", new Object[0]);
                }
                if (aPWebViewClient instanceof h) {
                    mLog.c("setsetWebViewClient client is H5WebViewClientWrapper", new Object[0]);
                    return;
                }
                return;
            }
            mLog.c("setsetWebViewClient start. webview is %s, client is %s  ", aPWebView, aPWebViewClient);
            aPWebView.setWebViewClient(aPWebViewClient);
            hookWebChromeClient(aPWebView);
            mLog.c("setsetWebViewClient end", new Object[0]);
        }
    }

    public static void setsetWebChromeClient(APWebView aPWebView, APWebChromeClient aPWebChromeClient) {
        if (aPWebView != null && aPWebChromeClient != null) {
            boolean z = aPWebChromeClient instanceof com.bonree.sdk.bb.a;
            if (z || (aPWebChromeClient instanceof c) || (aPWebChromeClient instanceof d) || (aPWebChromeClient instanceof g)) {
                aPWebView.setWebChromeClient(aPWebChromeClient);
                mLog.d("no need wrap APWebChromeClient! webview is %s, client is %s", aPWebView, aPWebChromeClient);
                if (z) {
                    mLog.c("setsetWebChromeClient client is APWebChromeClientWraper", new Object[0]);
                }
                if (aPWebChromeClient instanceof c) {
                    mLog.c("setsetWebChromeClient client is BonreeAPWebChromeClient", new Object[0]);
                }
                if (aPWebChromeClient instanceof d) {
                    mLog.c("setsetWebChromeClient client is BonreeH5WebChromeClient", new Object[0]);
                }
                if (aPWebChromeClient instanceof g) {
                    mLog.c("setsetWebChromeClient client is H5WebChromeClientWrapper", new Object[0]);
                    return;
                }
                return;
            }
            mLog.c("setsetWebChromeClient start. webview is %s, client is %s", aPWebView, aPWebChromeClient);
            aPWebView.setWebChromeClient(aPWebChromeClient);
            mLog.c("setsetWebChromeClient end", new Object[0]);
        }
    }

    private static void hookWebChromeClient(APWebView aPWebView) {
        if (aPWebView != null && com.bonree.sdk.agent.engine.webview.g.a().b() && Build.VERSION.SDK_INT >= 19) {
            mLog.c("APWebView hookWebChromeClient start. webview is %s ", aPWebView);
            if (aPWebView instanceof AndroidWebView) {
                hookAndroidWebChromeClient(aPWebView);
            } else if (aPWebView instanceof H5WebView) {
                hookH5WebChromeClient(aPWebView);
            } else if (aPWebView instanceof UCWebView) {
                hookUCWebChromeClient(aPWebView);
            }
            mLog.c("APWebView hookWebChromeClient end", new Object[0]);
        }
    }

    private static void hookUCWebChromeClient(APWebView aPWebView) {
        WebChromeClient webChromeClient;
        boolean z;
        if (aPWebView != null) {
            mLog.c("hook UCWebChromeClient start...", new Object[0]);
            try {
                Field declaredField = UCWebView.class.getDeclaredField("webView");
                declaredField.setAccessible(true);
                webChromeClient = null;
                webChromeClient = getUCWebChromeClient((WebView) declaredField.get(aPWebView));
                z = false;
            } catch (Throwable th) {
                mLog.a("hook UCWebChromeClient error", th);
                return;
            }
            if (!z && webChromeClient == null) {
                mLog.c("hookUCWebChromeClient set real WebChromeClient start, oldUCWebChromeClient is null.", new Object[0]);
                aPWebView.setWebChromeClient(new c());
                mLog.c("hookUCWebChromeClient set real WebChromeClient success", new Object[0]);
            } else if (webChromeClient != null) {
                mLog.c("hookUCWebChromeClient get oldWebChromeClient is %s", webChromeClient);
                Class<?> i = ad.i("com.alipay.mobile.nebulauc.impl.UCWebChromeClient");
                if (i == null) {
                    mLog.d("hookUCWebChromeClient not found com.alipay.mobile.nebulauc.impl.UCWebChromeClient", new Object[0]);
                    return;
                }
                Field declaredField2 = i.getDeclaredField("mClient");
                declaredField2.setAccessible(true);
                APWebChromeClient aPWebChromeClient = (APWebChromeClient) declaredField2.get(webChromeClient);
                Object cVar = aPWebChromeClient == null ? new c() : new com.bonree.sdk.bb.a(aPWebChromeClient);
                declaredField2.set(webChromeClient, cVar);
                mLog.c("hookUCWebChromeClient success，apWebChromeClient is %s. repaceAPWebChromeClient is %s. ", aPWebChromeClient, cVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e9, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ea, code lost:
        mLog.a("mProvider.getWebChromeClient() Throwable", r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f6, code lost:
        throw new java.lang.RuntimeException(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0105, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0106, code lost:
        mLog.a("mProvider.getWebChromeClient() IllegalAccessException", (java.lang.Throwable) r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0112, code lost:
        throw new java.lang.RuntimeException(r10);
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e9 A[ExcHandler: all (r10v10 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:16:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0105 A[ExcHandler: IllegalAccessException (r10v8 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:16:0x003f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.uc.webview.export.WebChromeClient getUCWebChromeClient(com.uc.webview.export.WebView r10) throws java.lang.RuntimeException {
        /*
            java.lang.String r0 = "invoke  UCWebview.checkThread() exception"
            java.lang.String r1 = "getUCWebChromeClient DeclaredField  mWebView exception"
            r2 = 0
            if (r10 != 0) goto L_0x0008
            return r2
        L_0x0008:
            java.lang.Class<com.uc.webview.export.WebView> r3 = com.uc.webview.export.WebView.class
            java.lang.String r4 = "mWebView"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch:{ NoSuchFieldException -> 0x013c, IllegalAccessException -> 0x0130, all -> 0x0124 }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ NoSuchFieldException -> 0x013c, IllegalAccessException -> 0x0130, all -> 0x0124 }
            java.lang.Object r10 = r3.get(r10)     // Catch:{ NoSuchFieldException -> 0x013c, IllegalAccessException -> 0x0130, all -> 0x0124 }
            com.uc.webview.export.internal.interfaces.IWebView r10 = (com.uc.webview.export.internal.interfaces.IWebView) r10     // Catch:{ NoSuchFieldException -> 0x013c, IllegalAccessException -> 0x0130, all -> 0x0124 }
            r1 = 0
            if (r10 == 0) goto L_0x0113
            java.lang.Class<com.uc.webview.export.WebView> r3 = com.uc.webview.export.WebView.class
            java.lang.String r5 = "checkThread"
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x0037, all -> 0x0030 }
            java.lang.reflect.Method r5 = r3.getDeclaredMethod(r5, r6)     // Catch:{ NoSuchMethodException -> 0x0037, all -> 0x0030 }
            r5.setAccessible(r4)     // Catch:{ NoSuchMethodException -> 0x0037, all -> 0x0030 }
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ NoSuchMethodException -> 0x0037, all -> 0x0030 }
            r5.invoke(r10, r6)     // Catch:{ NoSuchMethodException -> 0x0037, all -> 0x0030 }
            goto L_0x003d
        L_0x0030:
            r5 = move-exception
            com.bonree.sdk.be.f r6 = mLog
            r6.a((java.lang.String) r0, (java.lang.Throwable) r5)
            goto L_0x003d
        L_0x0037:
            r5 = move-exception
            com.bonree.sdk.be.f r6 = mLog
            r6.a((java.lang.String) r0, (java.lang.Throwable) r5)
        L_0x003d:
            java.lang.String r0 = "mProvider"
            java.lang.reflect.Field r0 = r3.getDeclaredField(r0)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            r0.setAccessible(r4)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.Object r10 = r0.get(r10)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            com.bonree.sdk.be.f r0 = mLog     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.String r5 = "getUCWebChromeClient WebChromeClient mProvider:"
            r3.<init>(r5)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            r3.append(r10)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.String r3 = r3.toString()     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            r0.c(r3, r5)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.Class r0 = r10.getClass()     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.String r3 = "mContentsClientAdapter"
            java.lang.reflect.Field r3 = r0.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0071, IllegalAccessException -> 0x0105, all -> 0x00e9 }
            r3.setAccessible(r4)     // Catch:{ NoSuchFieldException -> 0x0071, IllegalAccessException -> 0x0105, all -> 0x00e9 }
            java.lang.Object r2 = r3.get(r10)     // Catch:{ NoSuchFieldException -> 0x0071, IllegalAccessException -> 0x0105, all -> 0x00e9 }
            goto L_0x00b4
        L_0x0071:
            r3 = move-exception
            com.bonree.sdk.be.f r5 = mLog     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.String r6 = "mProvider.getmContentsClientAdapter NoSuchFieldException"
            r5.a((java.lang.String) r6, (java.lang.Throwable) r3)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.reflect.Field[] r0 = r0.getDeclaredFields()     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            if (r0 == 0) goto L_0x00b4
            int r3 = r0.length     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            if (r3 == 0) goto L_0x00b4
            java.lang.String r3 = "com.android.webview.chromium.WebViewContentsClientAdapter"
            java.lang.Class r3 = com.bonree.sdk.bs.ad.i(r3)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            if (r3 == 0) goto L_0x00ac
            int r5 = r0.length     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            r6 = r1
        L_0x008c:
            if (r6 >= r5) goto L_0x00b4
            r7 = r0[r6]     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.Class r8 = r7.getType()     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            boolean r9 = r3.equals(r8)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            if (r9 != 0) goto L_0x00a4
            boolean r8 = com.bonree.sdk.bs.ad.b((java.lang.Class<?>) r3, (java.lang.Class<?>) r8)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            if (r8 == 0) goto L_0x00a1
            goto L_0x00a4
        L_0x00a1:
            int r6 = r6 + 1
            goto L_0x008c
        L_0x00a4:
            r7.setAccessible(r4)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.Object r2 = r7.get(r10)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            goto L_0x00b4
        L_0x00ac:
            java.lang.ClassNotFoundException r10 = new java.lang.ClassNotFoundException     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.String r0 = "class com.android.webview.chromium.WebViewContentsClientAdapter not found!"
            r10.<init>(r0)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            throw r10     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
        L_0x00b4:
            java.lang.Class r10 = r2.getClass()     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.String r0 = "mWebChromeClient"
            java.lang.reflect.Field r10 = r10.getDeclaredField(r0)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            r10.setAccessible(r4)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.Object r10 = r10.get(r2)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            com.bonree.sdk.be.f r0 = mLog     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.String r2 = "get com.uc.webview.export.internal.android.i success!"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            r0.c(r2, r3)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.Class<com.uc.webview.export.internal.android.WebChromeClientCompatibility> r0 = com.uc.webview.export.internal.android.WebChromeClientCompatibility.class
            java.lang.Class<com.uc.webview.export.WebChromeClient> r2 = com.uc.webview.export.WebChromeClient.class
            java.lang.reflect.Field r0 = com.bonree.sdk.bs.ad.c((java.lang.Class<?>) r0, (java.lang.Class<?>) r2)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            r0.setAccessible(r4)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.Object r10 = r0.get(r10)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            com.uc.webview.export.WebChromeClient r10 = (com.uc.webview.export.WebChromeClient) r10     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            com.bonree.sdk.be.f r0 = mLog     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            java.lang.String r2 = "uc WebChromeClient get from  system reflect"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            r0.c(r2, r1)     // Catch:{ IllegalAccessException -> 0x0105, NoSuchFieldException -> 0x00f7, all -> 0x00e9 }
            return r10
        L_0x00e9:
            r10 = move-exception
            com.bonree.sdk.be.f r0 = mLog
            java.lang.String r1 = "mProvider.getWebChromeClient() Throwable"
            r0.a((java.lang.String) r1, (java.lang.Throwable) r10)
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r10)
            throw r0
        L_0x00f7:
            r10 = move-exception
            com.bonree.sdk.be.f r0 = mLog
            java.lang.String r1 = "mProvider.getWebChromeClient() NoSuchFieldException"
            r0.a((java.lang.String) r1, (java.lang.Throwable) r10)
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r10)
            throw r0
        L_0x0105:
            r10 = move-exception
            com.bonree.sdk.be.f r0 = mLog
            java.lang.String r1 = "mProvider.getWebChromeClient() IllegalAccessException"
            r0.a((java.lang.String) r1, (java.lang.Throwable) r10)
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r10)
            throw r0
        L_0x0113:
            com.bonree.sdk.be.f r10 = mLog
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "getUCWebChromeClient try to get uc real webview fail!"
            r10.d(r1, r0)
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.String r0 = "try to get uc real webview fail!"
            r10.<init>(r0)
            throw r10
        L_0x0124:
            r10 = move-exception
            com.bonree.sdk.be.f r0 = mLog
            r0.a((java.lang.String) r1, (java.lang.Throwable) r10)
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r10)
            throw r0
        L_0x0130:
            r10 = move-exception
            com.bonree.sdk.be.f r0 = mLog
            r0.a((java.lang.String) r1, (java.lang.Throwable) r10)
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r10)
            throw r0
        L_0x013c:
            r10 = move-exception
            com.bonree.sdk.be.f r0 = mLog
            r0.a((java.lang.String) r1, (java.lang.Throwable) r10)
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.engine.external.UCWebViewInstrumentation.getUCWebChromeClient(com.uc.webview.export.WebView):com.uc.webview.export.WebChromeClient");
    }

    private static void setH5WebChromeClient(H5PageImpl h5PageImpl, H5WebChromeClient h5WebChromeClient) throws IllegalAccessException {
        if (h5PageImpl != null && h5WebChromeClient != null) {
            mLog.c("set real H5WebChromeClient start .H5PageImpl is %s, H5WebChromeClient is %s .", h5PageImpl, h5WebChromeClient);
            Field c = ad.c((Class<?>) H5PageImpl.class, (Class<?>) H5WebChromeClient.class);
            if (c == null) {
                mLog.d("setH5WebChromeClient not found H5WebChromeClient!", new Object[0]);
                return;
            }
            c.setAccessible(true);
            c.set(h5PageImpl, h5WebChromeClient);
            H5WebView webView = h5PageImpl.getWebView();
            if (webView == null) {
                mLog.d("setH5WebChromeClient H5PageImpl is null!", new Object[0]);
                return;
            }
            webView.setWebChromeClient(h5WebChromeClient);
            mLog.c("setH5WebChromeClient success", new Object[0]);
        }
    }

    private static void hookH5WebChromeClient(APWebView aPWebView) {
        if (aPWebView != null) {
            Field c = ad.c((Class<?>) H5WebView.class, (Class<?>) H5Page.class);
            mLog.c("check H5WebviewWebChromeClient start. h5PageField is %s.", c);
            if (c != null) {
                try {
                    c.setAccessible(true);
                    H5PageImpl h5PageImpl = (H5Page) c.get(aPWebView);
                    if (!(h5PageImpl instanceof H5PageImpl)) {
                        mLog.d("hookH5WebChromeClient must be H5PageImpl!", new Object[0]);
                        return;
                    }
                    H5PageImpl h5PageImpl2 = h5PageImpl;
                    H5WebChromeClient webChromeClient = h5PageImpl2.getWebChromeClient();
                    H5WebChromeClient dVar = webChromeClient == null ? new d(h5PageImpl2) : new g(h5PageImpl2, webChromeClient);
                    mLog.c("H5WebviewWebChromeClient h5WebChromeClient is %s. replaceH5WebChromeClient is %s.", webChromeClient, dVar);
                    setH5WebChromeClient(h5PageImpl2, dVar);
                } catch (Throwable th) {
                    mLog.a("check H5WebviewWebChromeClient error", th);
                }
            }
        }
    }

    private static void hookAndroidWebChromeClient(APWebView aPWebView) {
        android.webkit.WebChromeClient webChromeClient;
        boolean z;
        if (aPWebView != null) {
            Field c = ad.c((Class<?>) AndroidWebView.class, (Class<?>) android.webkit.WebView.class);
            mLog.c("check hookAndroidWebChromeClient start. androidWebviewField is %s ", c);
            if (c != null) {
                try {
                    c.setAccessible(true);
                    android.webkit.WebView webView = (android.webkit.WebView) c.get(aPWebView);
                    webChromeClient = null;
                    if (Build.VERSION.SDK_INT >= 26) {
                        webChromeClient = webView.getWebChromeClient();
                        mLog.c("hookAndroidWebChromeClient get from  system declare api", new Object[0]);
                    } else {
                        webChromeClient = WebViewInstrumentation.getWebChromeClientLessThanO(webView);
                    }
                    z = false;
                } catch (Throwable th) {
                    mLog.a("check hookAndroidWebChromeClient error", th);
                    return;
                }
                if (!z && webChromeClient == null) {
                    mLog.d("hookAndroidWebChromeClient get old WebChromeClient is null", new Object[0]);
                    mLog.c("hookAndroidWebChromeClient set real WebChromeClient start", new Object[0]);
                    aPWebView.setWebChromeClient(new c());
                } else if (webChromeClient != null) {
                    mLog.c("ghookAndroidWebChromeClient et old webviewChromeClient:%s", webChromeClient);
                    Class<?> i = ad.i("com.alipay.mobile.nebulacore.android.AndroidWebChromeClient");
                    if (i != null) {
                        Field c2 = ad.c(i, (Class<?>) APWebChromeClient.class);
                        if (c2 == null) {
                            mLog.d("hookAndroidWebChromeClient not found APWebChromeClientClass!", new Object[0]);
                            return;
                        }
                        c2.setAccessible(true);
                        APWebChromeClient aPWebChromeClient = (APWebChromeClient) c2.get(webChromeClient);
                        c2.set(webChromeClient, aPWebChromeClient == null ? new c() : new com.bonree.sdk.bb.a(aPWebChromeClient));
                        mLog.c("hookAndroidWebChromeClient success", new Object[0]);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0039 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void webViewPageStart(com.uc.webview.export.WebView r4) {
        /*
            com.bonree.sdk.be.f r0 = mLog
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "UCWebview onPageStart view is %s "
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r0.c(r1, r3)
            if (r4 == 0) goto L_0x0067
            com.bonree.sdk.agent.engine.webview.g r0 = com.bonree.sdk.agent.engine.webview.g.a()
            boolean r0 = r0.b()
            if (r0 != 0) goto L_0x0023
            goto L_0x0067
        L_0x0023:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            if (r0 >= r1) goto L_0x002a
            return
        L_0x002a:
            java.lang.String r0 = "searchBoxJavaBridge_"
            r4.removeJavascriptInterface(r0)     // Catch:{ all -> 0x0039 }
            java.lang.String r0 = "accessibility"
            r4.removeJavascriptInterface(r0)     // Catch:{ all -> 0x0039 }
            java.lang.String r0 = "accessibilityTraversal"
            r4.removeJavascriptInterface(r0)     // Catch:{ all -> 0x0039 }
        L_0x0039:
            com.uc.webview.export.WebSettings r0 = r4.getSettings()     // Catch:{ all -> 0x005f }
            r1 = 1
            r0.setJavaScriptEnabled(r1)     // Catch:{ all -> 0x005f }
            com.bonree.sdk.agent.engine.webview.BonreeCustomInterfaceUCBridge r0 = com.bonree.sdk.agent.engine.webview.BonreeCustomInterfaceUCBridge.getInstance()     // Catch:{ all -> 0x005f }
            java.lang.String r3 = "bonreeJsBridge"
            r4.addJavascriptInterface(r0, r3)     // Catch:{ all -> 0x005f }
            com.bonree.sdk.agent.engine.webview.BonreeUCJavaScriptBridge r0 = com.bonree.sdk.agent.engine.webview.BonreeUCJavaScriptBridge.getInstance()     // Catch:{ all -> 0x005f }
            java.lang.String r3 = "bonreePrivateInterface"
            r4.addJavascriptInterface(r0, r3)     // Catch:{ all -> 0x005f }
            com.bonree.sdk.be.f r0 = mLog     // Catch:{ all -> 0x005f }
            java.lang.String r3 = "%s onPageStart addJavascriptInterface is success"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x005f }
            r1[r2] = r4     // Catch:{ all -> 0x005f }
            r0.c(r3, r1)     // Catch:{ all -> 0x005f }
            return
        L_0x005f:
            r4 = move-exception
            com.bonree.sdk.be.f r0 = mLog
            java.lang.String r1 = "UCWebview add bonreePrivateInterface exception"
            r0.a((java.lang.String) r1, (java.lang.Throwable) r4)
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.engine.external.UCWebViewInstrumentation.webViewPageStart(com.uc.webview.export.WebView):void");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0030 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void webViewPageStart(com.alipay.mobile.nebula.webview.APWebView r5) {
        /*
            com.bonree.sdk.be.f r0 = mLog
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r5
            java.lang.String r4 = "APWebView onPageStart view is %s ."
            r0.c(r4, r2)
            if (r5 == 0) goto L_0x005d
            com.bonree.sdk.agent.engine.webview.g r0 = com.bonree.sdk.agent.engine.webview.g.a()
            boolean r0 = r0.b()
            if (r0 != 0) goto L_0x001a
            goto L_0x005d
        L_0x001a:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 19
            if (r0 >= r2) goto L_0x0021
            return
        L_0x0021:
            java.lang.String r0 = "searchBoxJavaBridge_"
            r5.removeJavascriptInterface(r0)     // Catch:{ all -> 0x0030 }
            java.lang.String r0 = "accessibility"
            r5.removeJavascriptInterface(r0)     // Catch:{ all -> 0x0030 }
            java.lang.String r0 = "accessibilityTraversal"
            r5.removeJavascriptInterface(r0)     // Catch:{ all -> 0x0030 }
        L_0x0030:
            com.alipay.mobile.nebula.webview.APWebSettings r0 = r5.getSettings()     // Catch:{ all -> 0x0055 }
            r0.setJavaScriptEnabled(r1)     // Catch:{ all -> 0x0055 }
            com.bonree.sdk.agent.engine.webview.BonreeCustomInterfaceUCBridge r0 = com.bonree.sdk.agent.engine.webview.BonreeCustomInterfaceUCBridge.getInstance()     // Catch:{ all -> 0x0055 }
            java.lang.String r2 = "bonreeJsBridge"
            r5.addJavascriptInterface(r0, r2)     // Catch:{ all -> 0x0055 }
            com.bonree.sdk.agent.engine.webview.BonreeUCJavaScriptBridge r0 = com.bonree.sdk.agent.engine.webview.BonreeUCJavaScriptBridge.getInstance()     // Catch:{ all -> 0x0055 }
            java.lang.String r2 = "bonreePrivateInterface"
            r5.addJavascriptInterface(r0, r2)     // Catch:{ all -> 0x0055 }
            com.bonree.sdk.be.f r0 = mLog     // Catch:{ all -> 0x0055 }
            java.lang.String r2 = "%s onPageStart addJavascriptInterface is success"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0055 }
            r1[r3] = r5     // Catch:{ all -> 0x0055 }
            r0.c(r2, r1)     // Catch:{ all -> 0x0055 }
            return
        L_0x0055:
            r5 = move-exception
            com.bonree.sdk.be.f r0 = mLog
            java.lang.String r1 = "APWebView add bonreePrivateInterface exception"
            r0.a((java.lang.String) r1, (java.lang.Throwable) r5)
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.engine.external.UCWebViewInstrumentation.webViewPageStart(com.alipay.mobile.nebula.webview.APWebView):void");
    }

    public static void setProgressChanged(WebView webView, int i) {
        f fVar = mLog;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = webView == null ? "null" : webView.getUrl();
        fVar.c("UCWebView onProgressChanged，newProgress: %s ,webview is %s ", objArr);
        if (webView != null && com.bonree.sdk.agent.engine.webview.g.a().b()) {
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
                mLog.a("uc webview geturl error: ", th);
            }
        }
    }

    public static void setProgressChanged(APWebView aPWebView, int i) {
        f fVar = mLog;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        String str = "null";
        objArr[1] = aPWebView == null ? str : aPWebView.getUrl();
        if (aPWebView != null) {
            str = aPWebView.getType();
        }
        objArr[2] = str;
        fVar.c("APWebView onProgressChanged，newProgress: %s ,webview is %s, webviewType is %s", objArr);
        if (aPWebView != null && com.bonree.sdk.agent.engine.webview.g.a().b()) {
            webViewPageStart(aPWebView);
            try {
                if (!TextUtils.isEmpty(aPWebView.getOriginalUrl())) {
                    String simpleName = aPWebView.getClass().getSimpleName();
                    if (Build.VERSION.SDK_INT >= 19 && aPWebView.getSettings().getJavaScriptEnabled()) {
                        if (injectMax < 10) {
                            injectScriptFile(aPWebView, simpleName);
                            injectMax++;
                        }
                        if (i >= 100) {
                            injectMax = 0;
                        }
                    }
                }
            } catch (Throwable th) {
                mLog.a("uc webview geturl error: ", th);
            }
        }
    }

    private static void injectScriptFile(WebView webView, String str) {
        try {
            BonreeUCJavaScriptBridge.getInstance().setWebViewName(str);
            String url = webView.getUrl();
            webView.evaluateJavascript("javascript:" + JS.getJs(url, webView.hashCode()), (ValueCallback) null);
            mLog.c("UCWebview inject js success，url is %s, className is %s ,original url is %s ", url, str, webView.getOriginalUrl());
        } catch (Throwable th) {
            mLog.a("UCWebview inject js failed", th);
        }
    }

    private static void injectScriptFile(APWebView aPWebView, String str) {
        try {
            BonreeUCJavaScriptBridge.getInstance().setWebViewName(str);
            String url = aPWebView.getUrl();
            aPWebView.evaluateJavascript("javascript:" + JS.getJs(url, aPWebView.hashCode()), (ValueCallback) null);
            mLog.c("APWebView inject js success，url is %s, className is %s ,original url is %s", url, str, aPWebView.getOriginalUrl());
        } catch (Throwable th) {
            mLog.a("APWebView inject js failed", th);
        }
    }

    public static void webViewPageFinished(WebView webView, String str) {
        mLog.c("UCWebview onPageFinished，url is %s, webview is %s.", str, webView);
        injectMax = 0;
    }

    public static void webViewPageFinished(APWebView aPWebView, String str, long j) {
        mLog.c("APWebView onPageFinished，url is %s, webview is %s.", str, aPWebView);
        injectMax = 0;
    }

    public static void onReceivedError(APWebView aPWebView, int i, String str, String str2) {
        try {
            if (com.bonree.sdk.agent.engine.webview.g.a().b()) {
                com.bonree.sdk.agent.engine.webview.g.a().a(str2, str, i, aPWebView.getUrl(), "android_webview");
                f fVar = mLog;
                fVar.c("APWebView onReceivedError errorCode = " + i + ", description = " + str + ", failingUrl = " + str2 + "  getUrl: " + aPWebView.getUrl() + "  getOrigin:" + aPWebView.getOriginalUrl(), new Object[0]);
            }
        } catch (Throwable th) {
            mLog.a("APWebView onReceivedError error", th);
        }
    }

    public static void onReceivedHttpError(APWebView aPWebView, int i, String str) {
        try {
            if (com.bonree.sdk.agent.engine.webview.g.a().b()) {
                com.bonree.sdk.agent.engine.webview.g.a().a(str, "", i, aPWebView.getUrl(), "http");
                f fVar = mLog;
                fVar.c("APWebView onReceivedHttpError errorCode = " + i + ", url = " + str + "  getUrl: " + aPWebView.getUrl() + "  getOrigin:" + aPWebView.getOriginalUrl(), new Object[0]);
            }
        } catch (Throwable th) {
            mLog.a("APWebView onReceivedHttpError error", th);
        }
    }

    public static void onReceivedSslError(APWebView aPWebView, APSslErrorHandler aPSslErrorHandler, SslError sslError) {
        try {
            if (com.bonree.sdk.agent.engine.webview.g.a().b()) {
                com.bonree.sdk.agent.engine.webview.g.a().b(sslError.getUrl(), "", sslError.getPrimaryError(), aPWebView.getUrl(), "android_webview_ssl");
                f fVar = mLog;
                fVar.c("APWebView onReceivedSslError errorCode = " + sslError.getPrimaryError() + ", url = " + sslError.getUrl() + "  getUrl: " + aPWebView.getUrl() + "  getOrigin:" + aPWebView.getOriginalUrl(), new Object[0]);
            }
        } catch (Throwable th) {
            mLog.a("APWebView onReceivedSslError error", th);
        }
    }

    public static H5Page setcreatePage(H5Service h5Service, Activity activity, H5Bundle h5Bundle) {
        if (h5Service == null || activity == null || h5Bundle == null) {
            return null;
        }
        H5PageImpl createPage = h5Service.createPage(activity, h5Bundle);
        mLog.c("hook H5Service createPage start...page is %s ", createPage);
        if (createPage == null) {
            return null;
        }
        try {
            APWebView webView = createPage.getWebView();
            mLog.c("hook H5Service createPage. webView is %s ", webView);
            if (webView == null) {
                return createPage;
            }
            if (!(createPage instanceof H5PageImpl)) {
                mLog.d("hook H5Service createPage. must be H5PageImpl!", new Object[0]);
                return createPage;
            }
            H5PageImpl h5PageImpl = createPage;
            Field c = ad.c((Class<?>) H5PageImpl.class, (Class<?>) H5WebViewClient.class);
            if (c == null) {
                mLog.d("hook H5Service createPage. not found the field  which field type is H5WebViewClient in H5PageImpl!", new Object[0]);
                return createPage;
            }
            c.setAccessible(true);
            H5WebViewClient webViewClient = h5PageImpl.getWebViewClient();
            APWebViewClient eVar = webViewClient == null ? new e(h5PageImpl) : new h(h5PageImpl, webViewClient);
            c.set(h5PageImpl, eVar);
            H5WebView webView2 = h5PageImpl.getWebView();
            if (webView2 == null) {
                mLog.d("hook H5Service createPage. H5WebView in H5PageImpl is null!", new Object[0]);
                return createPage;
            }
            mLog.c("hook H5Service createPage. webviewClient is %s, webview is %s.", webViewClient, webView);
            webView2.setWebViewClient(eVar);
            hookWebChromeClient(webView);
            return createPage;
        } catch (Throwable th) {
            mLog.a("hook H5Service createPage error", th);
        }
    }
}
