package com.tal.app.thinkacademy.common.business.browser.handler;

import android.webkit.WebResourceError;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.business.browser.view.XesWebView;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class DefaultHandler extends WebViewLifeHandler {
    /* access modifiers changed from: private */
    public boolean isSuccess = true;
    private int mCurrentProgress;
    private LoadStatusView mLoadStatusView;
    /* access modifiers changed from: private */
    public XesWebView mWebView;

    public DefaultHandler(XesWebView xesWebView, LoadStatusView loadStatusView) {
        this.mWebView = xesWebView;
        this.mLoadStatusView = loadStatusView;
    }

    public void onPageStart(String str) {
        super.onPageStart(str);
        this.mLoadStatusView.showFullLoadingView();
    }

    public void onPageFinish(String str) {
        super.onPageFinish(str);
        if (this.isSuccess && this.mCurrentProgress > 80) {
            this.mWebView.setVisibility(0);
            this.mLoadStatusView.setVisibility(8);
            this.mLoadStatusView.hideFullLoadingView();
        }
    }

    public void onProgress(int i) {
        super.onProgress(i);
        this.mCurrentProgress = i;
    }

    public void onReceivedError(final String str, WebResourceError webResourceError) {
        super.onReceivedError(str, webResourceError);
        if (!str.toLowerCase().contains("webkjdsfiles") || (!str.toLowerCase().contains("videos") && !str.toLowerCase().contains("audios"))) {
            XesLog.et("failingUrl", str);
            this.isSuccess = false;
            this.mWebView.setVisibility(8);
            this.mLoadStatusView.setVisibility(0);
            this.mLoadStatusView.showErrorView(new Function0<Unit>() {
                public Unit invoke() {
                    boolean unused = DefaultHandler.this.isSuccess = true;
                    XesWebView access$100 = DefaultHandler.this.mWebView;
                    String str = str;
                    access$100.loadUrl(str);
                    SensorsDataAutoTrackHelper.loadUrl2(access$100, str);
                    return null;
                }
            });
        }
    }
}
