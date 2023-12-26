package com.bonree.sdk.agent.engine.webview;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.bonree.sdk.ab.j;
import com.bonree.sdk.agent.engine.webview.g;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.m.o;

public class BonreeJavaScriptBridge {
    private String a;
    private f b;

    /* synthetic */ BonreeJavaScriptBridge(byte b2) {
        this();
    }

    static class a {
        /* access modifiers changed from: private */
        public static final BonreeJavaScriptBridge a = new BonreeJavaScriptBridge((byte) 0);

        private a() {
        }
    }

    private BonreeJavaScriptBridge() {
        this.b = com.bonree.sdk.be.a.a();
    }

    public static BonreeJavaScriptBridge getInstance() {
        return a.a;
    }

    public void setWebViewName(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.a;
            if (str2 == null || !str2.contains(str)) {
                this.a = "WebView@" + str;
            }
        }
    }

    @JavascriptInterface
    public void setUserID(String str) {
        BonreeCustomInterfaceBridge.getInstance().setUserID(str);
    }

    @JavascriptInterface
    public void setExtraInfo(String str) {
        BonreeCustomInterfaceBridge.getInstance().setExtraInfo(str);
    }

    @JavascriptInterface
    public void setCustomEvent(String str, String str2, String str3) {
        BonreeCustomInterfaceBridge.getInstance().setCustomEvent(str, str2, str3);
    }

    @JavascriptInterface
    public void setCustomEventWithLabel(String str, String str2, String str3, String str4) {
        BonreeCustomInterfaceBridge.getInstance().setCustomEventWithLabel(str, str2, str3, str4);
    }

    @JavascriptInterface
    public void setCustomEvent(String str, String str2) {
        BonreeCustomInterfaceBridge.getInstance().setCustomEvent(str, str2);
    }

    @JavascriptInterface
    public void setCustomEventStart(String str, String str2, String str3, String str4) {
        BonreeCustomInterfaceBridge.getInstance().setCustomEventStart(str, str2, str3, str4);
    }

    @JavascriptInterface
    public void setCustomEventEnd(String str, String str2, String str3, String str4) {
        BonreeCustomInterfaceBridge.getInstance().setCustomEventEnd(str, str2, str3, str4);
    }

    @JavascriptInterface
    public void setCustomLog(String str, String str2) {
        BonreeCustomInterfaceBridge.getInstance().setCustomLog(str, str2);
    }

    @JavascriptInterface
    public void setCustomMetric(String str, String str2, String str3) {
        BonreeCustomInterfaceBridge.getInstance().setCustomMetric(str, str2, str3);
    }

    @JavascriptInterface
    public void setCustomMetric(String str, String str2) {
        setCustomMetric(str, str2, (String) null);
    }

    @JavascriptInterface
    public void setCustomPageStart(String str, String str2) {
        BonreeCustomInterfaceBridge.getInstance().setCustomPageStart(str, str2);
    }

    @JavascriptInterface
    public void setCustomPageEnd(String str, String str2) {
        BonreeCustomInterfaceBridge.getInstance().setCustomPageEnd(str, str2);
    }

    @JavascriptInterface
    public void setCustomException(String str, String str2, String str3) {
        BonreeCustomInterfaceBridge.getInstance().setCustomException(str, str2, str3);
    }

    @JavascriptInterface
    public void setCustomLog(String str) {
        BonreeCustomInterfaceBridge.getInstance().setCustomLog(str);
    }

    @JavascriptInterface
    public void setCustomH5performanceData(String str) {
        BonreeCustomInterfaceBridge.getInstance().setCustomH5performanceData(str);
    }

    @JavascriptInterface
    public void setCustomRouteChangeData(String str) {
        BonreeCustomInterfaceBridge.getInstance().setCustomRouteChangeData(str);
    }

    @JavascriptInterface
    public void log(String str) {
        this.b.a("[js log]%s", str);
    }

    @JavascriptInterface
    public void webviewPerformanceTimingEvent(String str, int i) {
        com.bonree.sdk.d.a.k();
        if (com.bonree.sdk.d.a.s()) {
            this.b.c("js get webview performance data:\n%s", str);
            if (!ad.a(str)) {
                g.a.a.a(new com.bonree.sdk.w.a(str, i));
            }
        }
    }

    @JavascriptInterface
    public void ajaxPerformanceTimingEvent(String str) {
        com.bonree.sdk.d.a.k();
        if (com.bonree.sdk.d.a.s()) {
            this.b.c("js get ajax performance data:\n%s", str);
            g.a.a.a(new o(str));
        }
    }

    @JavascriptInterface
    public void webviewJSErrorEvent(String str, int i) {
        com.bonree.sdk.d.a.k();
        if (com.bonree.sdk.d.a.s()) {
            this.b.c("js get error data:\n%s", str);
            g.a.a.a(str, i);
        }
    }

    @JavascriptInterface
    public void webviewPageEvent(String str) {
        com.bonree.sdk.d.a.k();
        if (com.bonree.sdk.d.a.s()) {
            this.b.c("js get webviewPageEvent data:\n%s", str);
            g.a.a.c(str);
        }
    }

    @JavascriptInterface
    public void webviewActionEvent(String str) {
        com.bonree.sdk.d.a.k();
        if (com.bonree.sdk.d.a.s()) {
            this.b.c("js get WebviewActionEvent data:\n%s", str);
            g.a.a.b(str);
        }
    }

    @JavascriptInterface
    public void routeChangeData(String str) {
        com.bonree.sdk.d.a.k();
        if (com.bonree.sdk.d.a.s()) {
            this.b.c("js get routeChange data:\n%s", str);
            g.a.a.a(new j(str, false));
        }
    }
}
