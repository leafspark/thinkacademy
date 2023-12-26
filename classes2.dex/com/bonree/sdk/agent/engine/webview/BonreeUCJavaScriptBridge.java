package com.bonree.sdk.agent.engine.webview;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.bonree.sdk.ab.d;
import com.bonree.sdk.ab.j;
import com.bonree.sdk.agent.engine.webview.g;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.m.o;

public class BonreeUCJavaScriptBridge {
    private String a;
    private final f b;

    /* synthetic */ BonreeUCJavaScriptBridge(byte b2) {
        this();
    }

    static class a {
        /* access modifiers changed from: private */
        public static final BonreeUCJavaScriptBridge a = new BonreeUCJavaScriptBridge((byte) 0);

        private a() {
        }
    }

    private BonreeUCJavaScriptBridge() {
        this.b = com.bonree.sdk.be.a.a();
    }

    public static BonreeUCJavaScriptBridge getInstance() {
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
    @com.uc.webview.export.JavascriptInterface
    public void setUserID(String str) {
        BonreeCustomInterfaceUCBridge.getInstance().setUserID(str);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void setExtraInfo(String str) {
        BonreeCustomInterfaceUCBridge.getInstance().setExtraInfo(str);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void setCustomEvent(String str, String str2, String str3) {
        BonreeCustomInterfaceUCBridge.getInstance().setCustomEvent(str, str2, str3);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void setCustomEventWithLabel(String str, String str2, String str3) {
        BonreeCustomInterfaceUCBridge.getInstance().setCustomEventWithLabel(str, str2, str3);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void setCustomEventWithLabel(String str, String str2, String str3, String str4) {
        BonreeCustomInterfaceUCBridge.getInstance().setCustomEventWithLabel(str, str2, str3, str4);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void setCustomEvent(String str, String str2) {
        BonreeCustomInterfaceUCBridge.getInstance().setCustomEvent(str, str2);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void setCustomEventStart(String str, String str2, String str3, String str4) {
        BonreeCustomInterfaceUCBridge.getInstance().setCustomEventStart(str, str2, str3, str4);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void setCustomEventEnd(String str, String str2, String str3, String str4) {
        BonreeCustomInterfaceUCBridge.getInstance().setCustomEventEnd(str, str2, str3, str4);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void setCustomLog(String str, String str2) {
        BonreeCustomInterfaceUCBridge.getInstance().setCustomLog(str, str2);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void setCustomMetric(String str, String str2, String str3) {
        BonreeCustomInterfaceUCBridge.getInstance().setCustomMetric(str, str2, str3);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void setCustomMetric(String str, String str2) {
        setCustomMetric(str, str2, (String) null);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void setCustomPageStart(String str, String str2) {
        BonreeCustomInterfaceUCBridge.getInstance().setCustomPageStart(str, str2);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void setCustomPageEnd(String str, String str2) {
        BonreeCustomInterfaceUCBridge.getInstance().setCustomPageEnd(str, str2);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void setCustomException(String str, String str2, String str3) {
        BonreeCustomInterfaceUCBridge.getInstance().setCustomException(str, str2, str3);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void setCustomLog(String str) {
        BonreeCustomInterfaceUCBridge.getInstance().setCustomLog(str);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void setCustomH5performanceData(String str) {
        BonreeCustomInterfaceUCBridge.getInstance().setCustomH5performanceData(str);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void setCustomRouteChangeData(String str) {
        BonreeCustomInterfaceUCBridge.getInstance().setCustomRouteChangeData(str);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void log(String str) {
        this.b.a("[js log]%s", str);
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void webviewPerformanceTimingEvent(String str, int i) {
        com.bonree.sdk.d.a.k();
        if (com.bonree.sdk.d.a.s()) {
            this.b.c("UC js get webview performance data:\n%s", str);
            if (!ad.a(str)) {
                g.a.a.a(new com.bonree.sdk.w.a(str));
            }
        }
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void ajaxPerformanceTimingEvent(String str) {
        com.bonree.sdk.d.a.k();
        if (com.bonree.sdk.d.a.s()) {
            this.b.c("UC js get ajax performance data:\n%s", str);
            g.a.a.a(new o(str));
        }
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void webviewJSErrorEvent(String str, int i) {
        com.bonree.sdk.d.a.k();
        if (com.bonree.sdk.d.a.s()) {
            this.b.c("UC js get error data:\n%s", str);
            g a2 = g.a.a;
            d dVar = new d();
            dVar.a(str);
            a2.notifyService(dVar);
        }
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void webviewPageEvent(String str) {
        com.bonree.sdk.d.a.k();
        if (com.bonree.sdk.d.a.s()) {
            this.b.c("UC js get webviewPageEvent data:\n%s", str);
            g.a.a.c(str);
        }
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void webviewActionEvent(String str) {
        com.bonree.sdk.d.a.k();
        if (com.bonree.sdk.d.a.s()) {
            this.b.c("UC js get WebviewActionEvent data:\n%s", str);
            g.a.a.b(str);
        }
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public void routeChangeData(String str) {
        com.bonree.sdk.d.a.k();
        if (com.bonree.sdk.d.a.s()) {
            this.b.c("UC js get routeChange data:\n%s", str);
            g.a.a.a(new j(str, false));
        }
    }
}
