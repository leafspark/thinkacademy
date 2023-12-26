package com.tal.app.thinkacademy.common.business.browser.view;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.business.browser.cache.HwWebViewCacheManager;
import com.tal.app.thinkacademy.common.business.browser.cache.IHwWebCache;
import com.tal.app.thinkacademy.common.business.browser.handler.DefaultHandler;
import com.tal.app.thinkacademy.common.business.browser.handler.FilterSchemeHandler;
import com.tal.app.thinkacademy.common.business.browser.handler.HtmlToSystemHandler;
import com.tal.app.thinkacademy.common.business.browser.handler.MyWebChromeClient;
import com.tal.app.thinkacademy.common.business.browser.handler.WebViewLifeHandler;
import com.tal.app.thinkacademy.common.business.browser.handler.WebViewTitleHandler;
import com.tal.app.thinkacademy.common.business.browser.helper.XesWebViewCookieUtils;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProgressWebView extends LinearLayout implements IWebDelegate, MyWebChromeClient.IProgressListener, IHwWebCache {
    private TextView mBrowserTitle;
    private Context mContext;
    private LoadStatusView mLoadStatusView;
    private ProgressBar mProgressBar;
    private View mRootView;
    private View mTitleBar;
    /* access modifiers changed from: private */
    public String mUrl;
    private XesWebView mWebView;
    private FrameLayout mWebViewContainer;

    public boolean isCanUseWebCache() {
        return false;
    }

    public ProgressWebView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ProgressWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        LayoutInflater from = LayoutInflater.from(context);
        int i2 = R.layout.layout_progress_webview;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i2, (ViewGroup) null, false) : XMLParseInstrumentation.inflate(from, i2, (ViewGroup) null, false);
        this.mRootView = inflate;
        this.mTitleBar = inflate.findViewById(R.id.rl_title_browswer);
        this.mWebViewContainer = (FrameLayout) this.mRootView.findViewById(R.id.fl_webview_container);
        if (isCanUseWebCache()) {
            XesWebView webView = HwWebViewCacheManager.Companion.getInstance().getWebView();
            this.mWebView = webView;
            if (webView == null) {
                this.mWebView = new XesWebView(getContext());
            } else {
                Context context2 = webView.getContext();
                if (context2 instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) context2).setBaseContext(getContext());
                }
            }
        } else {
            this.mWebView = new XesWebView(getContext());
        }
        this.mWebViewContainer.addView(this.mWebView, 0, new FrameLayout.LayoutParams(-1, -1));
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.probar_browser_loading);
        this.mBrowserTitle = (TextView) this.mRootView.findViewById(R.id.tv_browser_title);
        this.mLoadStatusView = this.mRootView.findViewById(R.id.load_status_view);
        registerEvent();
    }

    private void registerEvent() {
        XesDataBus.with(DataBusKey.USER_CENTER_LOGIN_BUS).observe(this.mContext, new Observer<Object>() {
            public void onChanged(Object obj) {
                if (TextUtils.equals((CharSequence) obj, "LoginIn")) {
                    String url = ProgressWebView.this.getWebView().getUrl();
                    ProgressWebView progressWebView = ProgressWebView.this;
                    if (TextUtils.isEmpty(url)) {
                        url = ProgressWebView.this.mUrl;
                    }
                    progressWebView.loadUrl(url);
                }
            }
        });
        XesDataBus.with(DataBusKey.USER_CENTER_LOGOUT_BUS).observe(this.mContext, new Observer<Object>() {
            public void onChanged(Object obj) {
                if (TextUtils.equals((CharSequence) obj, "LoginOut")) {
                    ProgressWebView progressWebView = ProgressWebView.this;
                    progressWebView.loadUrl(progressWebView.mUrl);
                }
            }
        });
    }

    public IWebDelegate create(AgentConfig agentConfig, List<WebViewLifeHandler> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mProgressBar.setVisibility(agentConfig.isShowProgressBar() ? 0 : 8);
        if (agentConfig.isShowTitle()) {
            list.add(new WebViewTitleHandler(this.mBrowserTitle));
            this.mTitleBar.setVisibility(0);
        } else {
            this.mTitleBar.setVisibility(8);
        }
        list.add(new DefaultHandler(this.mWebView, this.mLoadStatusView));
        list.add(new FilterSchemeHandler());
        list.add(new HtmlToSystemHandler());
        if (this.mWebView.isCachedWeb()) {
            this.mWebView.reInitSettings(getContext(), this, list);
        } else {
            this.mWebView.initSettings(this, list);
        }
        removeAllViews();
        addView(this.mRootView);
        return this;
    }

    public void loadUrl(String str) {
        XesLog.dt("app-pay-ProgressWebView", "url = " + str + " , mUrl = " + this.mUrl);
        this.mUrl = str;
        XesWebViewCookieUtils.syncCookie(str, (Map<String, String>) null, this.mWebView);
        XesWebView xesWebView = this.mWebView;
        if (xesWebView != null) {
            xesWebView.loadUrl(str);
            SensorsDataAutoTrackHelper.loadUrl2(xesWebView, str);
        }
    }

    public void onProgressChanged(int i) {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            if (i == 0) {
                progressBar.setVisibility(0);
            } else if (i >= 80) {
                progressBar.setVisibility(8);
            }
            this.mProgressBar.setProgress(i);
        }
    }

    public boolean canGoBack() {
        XesWebView xesWebView = this.mWebView;
        if (xesWebView != null) {
            return xesWebView.canGoBack();
        }
        return false;
    }

    public void goBack() {
        XesWebView xesWebView = this.mWebView;
        if (xesWebView != null) {
            xesWebView.goBack();
        }
    }

    public XesWebView getWebView() {
        return this.mWebView;
    }

    public void jsCallBack(String str, String str2) {
        XesWebView xesWebView = this.mWebView;
        if (xesWebView != null) {
            xesWebView.jsCallBack(str, str2);
        }
    }

    public void onDestroy() {
        XesWebView xesWebView = this.mWebView;
        if (xesWebView != null) {
            xesWebView.destroy();
        }
        this.mContext = null;
    }
}
