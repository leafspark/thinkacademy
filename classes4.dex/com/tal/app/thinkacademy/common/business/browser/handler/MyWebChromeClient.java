package com.tal.app.thinkacademy.common.business.browser.handler;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bonree.sdk.agent.engine.external.WebViewInstrumentation;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import java.util.List;

public class MyWebChromeClient extends WebChromeClient {
    private IProgressListener mListener;
    private List<WebViewLifeHandler> mWebHandlers;

    public interface IProgressListener {
        void onProgressChanged(int i);
    }

    public MyWebChromeClient(List<WebViewLifeHandler> list, IProgressListener iProgressListener) {
        this.mWebHandlers = list;
        this.mListener = iProgressListener;
    }

    public void setWebHandlers(List<WebViewLifeHandler> list) {
        this.mWebHandlers = list;
    }

    public void setListener(IProgressListener iProgressListener) {
        this.mListener = iProgressListener;
    }

    public void onReceivedTitle(WebView webView, String str) {
        for (WebViewLifeHandler onReceiveTitle : this.mWebHandlers) {
            onReceiveTitle.onReceiveTitle(str);
        }
        super.onReceivedTitle(webView, str);
    }

    public void onProgressChanged(WebView webView, int i) {
        WebViewInstrumentation.setProgressChanged(webView, i);
        List<WebViewLifeHandler> list = this.mWebHandlers;
        if (list != null && list.size() > 0) {
            for (WebViewLifeHandler onProgress : this.mWebHandlers) {
                onProgress.onProgress(i);
            }
        }
        IProgressListener iProgressListener = this.mListener;
        if (iProgressListener != null) {
            iProgressListener.onProgressChanged(i);
        }
        super.onProgressChanged(webView, i);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        for (WebViewLifeHandler onConsoleMessage : this.mWebHandlers) {
            onConsoleMessage.onConsoleMessage(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public Bitmap getDefaultVideoPoster() {
        try {
            return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        } catch (Exception unused) {
            return super.getDefaultVideoPoster();
        }
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        XesDataBus.with(DataBusKey.SHOW_FILE_CHOOSER).postStickyData(valueCallback);
        return true;
    }
}
