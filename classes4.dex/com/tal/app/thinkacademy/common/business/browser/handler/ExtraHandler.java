package com.tal.app.thinkacademy.common.business.browser.handler;

import android.app.Activity;
import android.content.Context;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.business.browser.view.XesWebView;
import com.tal.app.thinkacademy.lib.logger.XesLog;

public class ExtraHandler extends WebViewLifeHandler {
    private Context mContext;
    private WebView mWebView;

    public ExtraHandler(Context context, XesWebView xesWebView) {
        this.mContext = context;
        this.mWebView = xesWebView;
    }

    public boolean onUrlLoading(String str) {
        if (str.contains("screenType=0")) {
            ((Activity) this.mContext).setRequestedOrientation(1);
        } else if (str.contains("screenType=1")) {
            ((Activity) this.mContext).setRequestedOrientation(0);
        } else if (str.contains("screenType=2")) {
            ((Activity) this.mContext).setRequestedOrientation(2);
        }
        return super.onUrlLoading(str);
    }

    public void onPageFinish(String str) {
        super.onPageFinish(str);
        performanceLog();
    }

    public void onConsoleMessage(ConsoleMessage consoleMessage) {
        super.onConsoleMessage(consoleMessage);
        XesLog.dt("onConsoleMessage ====> \n  message : " + consoleMessage.message() + "\n sourceId : " + consoleMessage.sourceId() + "\n lineNumber : " + consoleMessage.lineNumber() + "\n level : " + consoleMessage.messageLevel().name(), new Object[0]);
    }

    private void performanceLog() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.loadUrl("javascript:window.addEventListener('load', function() {setTimeout(function (){let t = performance.timing;\nconsole.log('xesWebPerformance__DNS查询耗时 ：' + (t.domainLookupEnd - t.domainLookupStart).toFixed(0));console.log('xesWebPerformance__TCP链接耗时 ：' + (t.connectEnd - t.connectStart).toFixed(0));\nconsole.log('xesWebPerformance__request请求耗时 ：' + (t.responseEnd - t.responseStart).toFixed(0));\nconsole.log('xesWebPerformance__解析dom树耗时 ：' + (t.domComplete - t.domInteractive).toFixed(0));\nconsole.log('xesWebPerformance__白屏时间 ：' + (t.responseStart - t.navigationStart).toFixed(0));\nconsole.log('xesWebPerformance__domready时间 ：' + (t.domContentLoadedEventEnd - t.navigationStart).toFixed(0));\nconsole.log('xesWebPerformance__onload时间 ：' + (t.loadEventEnd - t.navigationStart).toFixed(0));\n},2000)})");
            SensorsDataAutoTrackHelper.loadUrl2(webView, "javascript:window.addEventListener('load', function() {setTimeout(function (){let t = performance.timing;\nconsole.log('xesWebPerformance__DNS查询耗时 ：' + (t.domainLookupEnd - t.domainLookupStart).toFixed(0));console.log('xesWebPerformance__TCP链接耗时 ：' + (t.connectEnd - t.connectStart).toFixed(0));\nconsole.log('xesWebPerformance__request请求耗时 ：' + (t.responseEnd - t.responseStart).toFixed(0));\nconsole.log('xesWebPerformance__解析dom树耗时 ：' + (t.domComplete - t.domInteractive).toFixed(0));\nconsole.log('xesWebPerformance__白屏时间 ：' + (t.responseStart - t.navigationStart).toFixed(0));\nconsole.log('xesWebPerformance__domready时间 ：' + (t.domContentLoadedEventEnd - t.navigationStart).toFixed(0));\nconsole.log('xesWebPerformance__onload时间 ：' + (t.loadEventEnd - t.navigationStart).toFixed(0));\n},2000)})");
        }
    }
}
