package com.bonree.sdk.bb;

import com.alipay.mobile.nebula.webview.APWebView;
import com.alipay.mobile.nebulacore.core.H5PageImpl;
import com.alipay.mobile.nebulacore.web.H5WebChromeClient;
import com.bonree.sdk.agent.engine.external.UCWebViewInstrumentation;

public final class d extends H5WebChromeClient {
    public d(H5PageImpl h5PageImpl) {
        super(h5PageImpl);
    }

    public final void onProgressChanged(APWebView aPWebView, int i) {
        d.super.onProgressChanged(aPWebView, i);
        UCWebViewInstrumentation.setProgressChanged(aPWebView, i);
    }
}
