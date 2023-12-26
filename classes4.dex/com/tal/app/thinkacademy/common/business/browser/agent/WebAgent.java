package com.tal.app.thinkacademy.common.business.browser.agent;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.business.browser.cache.HwWebJumCallback;
import com.tal.app.thinkacademy.common.business.browser.handler.WebViewLifeHandler;
import com.tal.app.thinkacademy.common.business.browser.view.IWebDelegate;
import com.tal.app.thinkacademy.common.business.browser.view.ProgressWebView;
import com.tal.app.thinkacademy.common.business.browser.view.ProgressWebViewCache;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WebAgent {
    private AgentConfig config;
    private HwWebJumCallback mHwWebJumCallback;
    private boolean mIsCanUseCache = false;
    private List<WebViewLifeHandler> mWebHandlers;
    private WeakReference<FragmentActivity> weakReActivity;
    private IWebDelegate webDelegate;

    private WebAgent() {
    }

    public WebAgent(FragmentActivity fragmentActivity) {
        this.weakReActivity = new WeakReference<>(fragmentActivity);
    }

    public WebAgent setCanUseCache(boolean z) {
        this.mIsCanUseCache = z;
        return this;
    }

    public WebAgent setHwWebJumCallback(HwWebJumCallback hwWebJumCallback) {
        this.mHwWebJumCallback = hwWebJumCallback;
        return this;
    }

    public WebAgent setWebAgentParent(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        viewGroup.removeAllViews();
        viewGroup.addView((View) createWebView(), layoutParams);
        return this;
    }

    public WebAgent applyConfig(AgentConfig agentConfig) {
        this.config = agentConfig;
        return this;
    }

    public WebAgent applyLifeHandler(List<WebViewLifeHandler> list) {
        if (this.mWebHandlers == null) {
            this.mWebHandlers = new ArrayList();
        }
        if (list != null) {
            this.mWebHandlers.addAll(list);
        }
        return this;
    }

    public WebAgent loadUrl(String str) {
        IWebDelegate iWebDelegate = this.webDelegate;
        if (iWebDelegate != null) {
            iWebDelegate.loadUrl(str);
        }
        return this;
    }

    public WebAgent jsCallBack(String str, String str2) {
        IWebDelegate iWebDelegate = this.webDelegate;
        if (iWebDelegate != null) {
            iWebDelegate.jsCallBack(str, str2);
        }
        return this;
    }

    public boolean canGoBack() {
        IWebDelegate iWebDelegate = this.webDelegate;
        if (iWebDelegate != null) {
            return iWebDelegate.canGoBack();
        }
        return false;
    }

    public void goBack() {
        IWebDelegate iWebDelegate = this.webDelegate;
        if (iWebDelegate != null) {
            iWebDelegate.goBack();
        }
    }

    public IWebDelegate getWebDelegate() {
        return this.webDelegate;
    }

    private IWebDelegate createWebView() {
        if (this.webDelegate == null) {
            if (this.mIsCanUseCache) {
                this.webDelegate = new ProgressWebViewCache((Context) this.weakReActivity.get());
                HwWebJumCallback hwWebJumCallback = this.mHwWebJumCallback;
                if (hwWebJumCallback != null) {
                    hwWebJumCallback.webCachePrepared();
                }
            } else {
                this.webDelegate = new ProgressWebView((Context) this.weakReActivity.get());
            }
        }
        if (this.config == null) {
            this.config = new AgentConfig.Builder().setShowProgressBar(false).setShowTitle(false).build();
        }
        return this.webDelegate.create(this.config, this.mWebHandlers);
    }

    public void onDestroy() {
        IWebDelegate iWebDelegate = this.webDelegate;
        if (iWebDelegate != null) {
            iWebDelegate.onDestroy();
        }
        this.config = null;
        this.webDelegate = null;
        this.weakReActivity = null;
        List<WebViewLifeHandler> list = this.mWebHandlers;
        if (list != null) {
            list.clear();
        }
    }
}
