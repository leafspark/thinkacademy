package com.tal.app.thinkacademy.common.business.browser.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.bonree.sdk.agent.engine.external.WebViewInstrumentation;
import com.tal.app.thinkacademy.common.business.browser.dispatch.JsInjection;
import com.tal.app.thinkacademy.common.business.browser.handler.DefaultWebSetting;
import com.tal.app.thinkacademy.common.business.browser.handler.IWebViewClient;
import com.tal.app.thinkacademy.common.business.browser.handler.MyWebChromeClient;
import com.tal.app.thinkacademy.common.business.browser.handler.MyWebViewClient;
import com.tal.app.thinkacademy.common.business.browser.handler.WebViewLifeHandler;
import java.util.ArrayList;
import java.util.List;

public class XesWebView extends WebView implements IWebViewClient {
    private String TAG = "XesWebView";
    private boolean isCachedWeb = false;
    private Context mContext;
    private long mCreateTimeMillis = System.currentTimeMillis();
    private JsInjection mJsInjection;
    private MyWebChromeClient mMyWebChromeClient;
    private MyWebViewClient mMyWebViewClient;
    private OnScrollListener mOnScrollListener;
    private List<WebViewLifeHandler> mWebHandlers = new ArrayList();

    public interface OnScrollListener {
        void scrollHeight(int i);
    }

    public void loadUrl(String str) {
        WebViewInstrumentation.loadUrlInOverride(this, str);
        super.loadUrl(str);
    }

    public XesWebView(Context context) {
        super(context);
        this.mContext = context;
    }

    public XesWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public XesWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    public void reInitSettings(Context context, MyWebChromeClient.IProgressListener iProgressListener, List<WebViewLifeHandler> list) {
        this.mWebHandlers = list;
        MyWebViewClient myWebViewClient = this.mMyWebViewClient;
        if (myWebViewClient != null) {
            myWebViewClient.setWebHandlers(list);
        }
        MyWebChromeClient myWebChromeClient = this.mMyWebChromeClient;
        if (myWebChromeClient != null) {
            myWebChromeClient.setWebHandlers(list);
            this.mMyWebChromeClient.setListener(iProgressListener);
        }
        JsInjection jsInjection = this.mJsInjection;
        if (jsInjection != null) {
            jsInjection.setFragmentActivity((FragmentActivity) context);
        }
    }

    public void initSettings(MyWebChromeClient.IProgressListener iProgressListener, List<WebViewLifeHandler> list) {
        this.mWebHandlers = list;
        DefaultWebSetting.set(this);
        MyWebViewClient myWebViewClient = new MyWebViewClient(list, this);
        this.mMyWebViewClient = myWebViewClient;
        setWebViewClient(myWebViewClient);
        MyWebChromeClient myWebChromeClient = new MyWebChromeClient(list, iProgressListener);
        this.mMyWebChromeClient = myWebChromeClient;
        setWebChromeClient(myWebChromeClient);
        if (this.isCachedWeb) {
            this.mJsInjection = new JsInjection((FragmentActivity) null, this);
        } else {
            this.mJsInjection = new JsInjection(this.mContext, this);
        }
        addJavascriptInterface(this.mJsInjection, "JsInjectionActivity");
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.scrollHeight(i2);
        }
    }

    public boolean onUrlLoading(String str) {
        for (WebViewLifeHandler onUrlLoading : this.mWebHandlers) {
            if (onUrlLoading.onUrlLoading(str)) {
                return true;
            }
        }
        return false;
    }

    public void jsCallBack(String str, String str2) {
        JsInjection jsInjection = this.mJsInjection;
        if (jsInjection != null) {
            jsInjection.jsCallBack(str, str2);
        }
    }

    public void setCachedWeb(boolean z) {
        this.isCachedWeb = z;
    }

    public boolean isCachedWeb() {
        return this.isCachedWeb;
    }

    public boolean getHwCourseIsCacheComplete() {
        JsInjection jsInjection = this.mJsInjection;
        if (jsInjection != null) {
            return jsInjection.getHwCourseIsCacheComplete();
        }
        return false;
    }

    public void setHwCourseIsCacheComplete(boolean z) {
        JsInjection jsInjection = this.mJsInjection;
        if (jsInjection != null) {
            jsInjection.setHwCourseIsCacheComplete(z);
        }
    }

    public long getCreateTimeMillis() {
        return this.mCreateTimeMillis;
    }

    public void destroy() {
        super.destroy();
        JsInjection jsInjection = this.mJsInjection;
        if (jsInjection != null) {
            jsInjection.setWebViewDestroyed(true);
        }
    }
}
