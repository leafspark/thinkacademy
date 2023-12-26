package com.tal.app.thinkacademy.common.business.browser.handler;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tal.app.thinkacademy.lib.util.AppUtils;

public class DefaultWebSetting {
    public static void set(WebView webView) {
        WebSettings settings = webView.getSettings();
        webView.setInitialScale(0);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setTextZoom(100);
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setCacheMode(2);
        settings.setDatabaseEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setSavePassword(true);
        settings.setDomStorageEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        settings.setLoadWithOverviewMode(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setUserAgentString(settings.getUserAgentString() + " Version/" + AppUtils.getAppVersionCode() + " ThinkAcademyApp");
        webView.requestFocus();
    }
}
