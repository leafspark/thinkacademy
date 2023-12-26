package com.tal.app.thinkacademy.common.business.browser.dispatch;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import java.util.Map;

public class JsInjection {
    private DispatchFactory mFactory;
    private WebView mWebView;
    private volatile boolean mWebViewDestroyed;

    public JsInjection(FragmentActivity fragmentActivity, WebView webView) {
        this.mWebView = webView;
        this.mFactory = new DispatchFactory(fragmentActivity);
    }

    @JavascriptInterface
    public void jsCallClient(String str) {
        XesLog.dt("收到h5js调用=" + str, new Object[0]);
        JsModel jsModel = (JsModel) GsonUtils.fromJson(str, JsModel.class);
        if (!this.mWebViewDestroyed || jsModel.getParam() == null || !"redpackage_rain".equals(jsModel.getParam().get("type"))) {
            this.mFactory.getDispatcher(jsModel.getClassName()).dispatch(this, jsModel.getMethodName(), jsModel.getParam());
            return;
        }
        XesLog.i(Tag.RED_PACKAGE_RAIN, "WebView已销毁无需再分发js回调");
    }

    public void jsCallBack(String str, String str2) {
        if (this.mWebView != null && !TextUtils.isEmpty(str)) {
            this.mWebView.post(new JsInjection$$ExternalSyntheticLambda0(this, str2, str));
        }
    }

    public /* synthetic */ void lambda$jsCallBack$0$JsInjection(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            WebView webView = this.mWebView;
            String str3 = "javascript:" + str2 + "()";
            webView.loadUrl(str3);
            SensorsDataAutoTrackHelper.loadUrl2(webView, str3);
            return;
        }
        WebView webView2 = this.mWebView;
        String str4 = "javascript:" + str2 + "(" + str + ")";
        webView2.loadUrl(str4);
        SensorsDataAutoTrackHelper.loadUrl2(webView2, str4);
    }

    public void parseParams(Map<String, String> map) {
        if (!map.isEmpty() && map.containsKey("callback")) {
            jsCallBack(map.get("callback"), (String) null);
        }
    }

    public boolean getHwCourseIsCacheComplete() {
        return this.mFactory.getHwCourseIsCacheComplete();
    }

    public void setHwCourseIsCacheComplete(boolean z) {
        this.mFactory.setHwCourseIsCacheComplete(z);
    }

    public void setFragmentActivity(FragmentActivity fragmentActivity) {
        this.mFactory.setFragmentActivity(fragmentActivity);
    }

    public void setWebViewDestroyed(boolean z) {
        this.mWebViewDestroyed = z;
    }
}
