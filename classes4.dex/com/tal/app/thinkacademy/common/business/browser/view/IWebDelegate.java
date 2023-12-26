package com.tal.app.thinkacademy.common.business.browser.view;

import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.business.browser.handler.WebViewLifeHandler;
import java.util.List;

public interface IWebDelegate {
    boolean canGoBack();

    IWebDelegate create(AgentConfig agentConfig, List<WebViewLifeHandler> list);

    XesWebView getWebView();

    void goBack();

    void jsCallBack(String str, String str2);

    void loadUrl(String str);

    void onDestroy();
}
