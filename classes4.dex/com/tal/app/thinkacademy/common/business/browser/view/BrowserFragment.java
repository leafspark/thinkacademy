package com.tal.app.thinkacademy.common.business.browser.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.common.base.XesBaseFragment;
import com.tal.app.thinkacademy.common.business.browser.agent.WebAgent;
import com.tal.app.thinkacademy.common.business.browser.handler.WebViewLifeHandler;
import com.tal.app.thinkacademy.common.business.browser.helper.BrowserDataHelper;
import com.tal.app.thinkacademy.common.business.browser.helper.FragmentListener;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/view/BrowserFragment;", "Lcom/tal/app/thinkacademy/common/base/XesBaseFragment;", "()V", "mBrowserData", "Lcom/tal/app/thinkacademy/common/business/browser/helper/BrowserDataHelper;", "mDataistener", "Lcom/tal/app/thinkacademy/common/business/browser/view/BrowserFragment$OnBrowserListener;", "mIsCanUserCache", "", "mUrl", "", "webAgent", "Lcom/tal/app/thinkacademy/common/business/browser/agent/WebAgent;", "getLayoutId", "", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "Companion", "OnBrowserListener", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BrowserFragment.kt */
public final class BrowserFragment extends XesBaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PARAMS_URL = "paramsUrl";
    private BrowserDataHelper mBrowserData;
    private OnBrowserListener mDataistener;
    private boolean mIsCanUserCache;
    private String mUrl;
    private WebAgent webAgent;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/view/BrowserFragment$OnBrowserListener;", "", "getData", "Lcom/tal/app/thinkacademy/common/business/browser/helper/BrowserDataHelper;", "getLifeHandler", "", "Lcom/tal/app/thinkacademy/common/business/browser/handler/WebViewLifeHandler;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BrowserFragment.kt */
    public interface OnBrowserListener {
        BrowserDataHelper getData();

        List<WebViewLifeHandler> getLifeHandler();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/view/BrowserFragment$Companion;", "", "()V", "PARAMS_URL", "", "getInstance", "Lcom/tal/app/thinkacademy/common/business/browser/view/BrowserFragment;", "url", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BrowserFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BrowserFragment getInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            BrowserFragment browserFragment = new BrowserFragment();
            Bundle bundle = new Bundle();
            bundle.putString(BrowserFragment.PARAMS_URL, str);
            browserFragment.setArguments(bundle);
            return browserFragment;
        }
    }

    public int getLayoutId() {
        return R.layout.fragment_browser;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BrowserDataHelper browserDataHelper = this.mBrowserData;
        String str = null;
        String url = browserDataHelper == null ? null : browserDataHelper.getUrl();
        if (!TextUtils.isEmpty(url)) {
            str = url;
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                str = arguments.getString(PARAMS_URL);
            }
        }
        this.mUrl = str;
        XesLog.dt("BrowserFragment", Intrinsics.stringPlus("mUrl = ", str));
        XesDataBus.with(DataBusKey.JS_GO_BACK).observe((LifecycleOwner) this, new BrowserFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m22onCreate$lambda0(BrowserFragment browserFragment, Object obj) {
        Intrinsics.checkNotNullParameter(browserFragment, "this$0");
        WebAgent webAgent2 = browserFragment.webAgent;
        if (webAgent2 != null) {
            webAgent2.goBack();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        WebAgent webAgent2;
        IWebDelegate webDelegate;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        BrowserDataHelper browserDataHelper = this.mBrowserData;
        this.mIsCanUserCache = browserDataHelper == null ? false : browserDataHelper.getMIsCanUseCache();
        WebAgent webAgent3 = new WebAgent(getmActivity());
        BrowserDataHelper browserDataHelper2 = this.mBrowserData;
        XesWebView xesWebView = null;
        WebAgent canUseCache = webAgent3.applyConfig(browserDataHelper2 == null ? null : browserDataHelper2.getConfig()).setCanUseCache(this.mIsCanUserCache);
        this.webAgent = canUseCache;
        if (canUseCache != null) {
            canUseCache.setHwWebJumCallback(new BrowserFragment$$ExternalSyntheticLambda1(this));
        }
        WebAgent webAgent4 = this.webAgent;
        if (webAgent4 != null) {
            OnBrowserListener onBrowserListener = this.mDataistener;
            WebAgent applyLifeHandler = webAgent4.applyLifeHandler(onBrowserListener == null ? null : onBrowserListener.getLifeHandler());
            if (applyLifeHandler != null) {
                ViewGroup viewGroup = (ViewGroup) this.layoutView;
                Intrinsics.checkNotNull(viewGroup);
                applyLifeHandler.setWebAgentParent(viewGroup, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        WebAgent webAgent5 = this.webAgent;
        if (!(webAgent5 == null || (webDelegate = webAgent5.getWebDelegate()) == null)) {
            xesWebView = webDelegate.getWebView();
        }
        if ((xesWebView == null || !xesWebView.isCachedWeb()) && (webAgent2 = this.webAgent) != null) {
            webAgent2.loadUrl(this.mUrl);
        }
        FragmentListener fragmentListener = this.mFragmentListener;
        if (fragmentListener != null) {
            WebAgent webAgent6 = this.webAgent;
            Intrinsics.checkNotNull(webAgent6);
            fragmentListener.process(webAgent6);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r0 = r0.getWebDelegate();
     */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m23onViewCreated$lambda1(com.tal.app.thinkacademy.common.business.browser.view.BrowserFragment r3) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.tal.app.thinkacademy.common.business.browser.agent.WebAgent r0 = r3.webAgent
            r1 = 0
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            r0 = r1
            goto L_0x0017
        L_0x000c:
            com.tal.app.thinkacademy.common.business.browser.view.IWebDelegate r0 = r0.getWebDelegate()
            if (r0 != 0) goto L_0x0013
            goto L_0x000a
        L_0x0013:
            com.tal.app.thinkacademy.common.business.browser.view.XesWebView r0 = r0.getWebView()
        L_0x0017:
            if (r0 == 0) goto L_0x004b
            boolean r0 = r0.isCachedWeb()
            if (r0 == 0) goto L_0x004b
            com.tal.app.thinkacademy.common.business.browser.cache.WebCacheJumParams r0 = new com.tal.app.thinkacademy.common.business.browser.cache.WebCacheJumParams
            com.tal.app.thinkacademy.common.business.browser.helper.BrowserDataHelper r2 = r3.mBrowserData
            if (r2 != 0) goto L_0x0026
            goto L_0x002a
        L_0x0026:
            java.lang.String r1 = r2.getMCacheJumpUrl()
        L_0x002a:
            r0.<init>(r1)
            java.lang.String r0 = com.tal.app.thinkacademy.lib.util.GsonUtils.toJson(r0)     // Catch:{ Exception -> 0x0041 }
            java.lang.String r1 = "toJson(webCacheJumParams)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x0041 }
            com.tal.app.thinkacademy.common.business.browser.agent.WebAgent r1 = r3.webAgent     // Catch:{ Exception -> 0x0041 }
            if (r1 != 0) goto L_0x003b
            goto L_0x004b
        L_0x003b:
            java.lang.String r2 = "window.GLOBAL_APP_HUB.pageJump"
            r1.jsCallBack(r2, r0)     // Catch:{ Exception -> 0x0041 }
            goto L_0x004b
        L_0x0041:
            com.tal.app.thinkacademy.common.business.browser.agent.WebAgent r0 = r3.webAgent
            if (r0 != 0) goto L_0x0046
            goto L_0x004b
        L_0x0046:
            java.lang.String r3 = r3.mUrl
            r0.loadUrl(r3)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.business.browser.view.BrowserFragment.m23onViewCreated$lambda1(com.tal.app.thinkacademy.common.business.browser.view.BrowserFragment):void");
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        BrowserDataHelper browserDataHelper = null;
        OnBrowserListener onBrowserListener = context instanceof OnBrowserListener ? (OnBrowserListener) context : null;
        this.mDataistener = onBrowserListener;
        if (onBrowserListener != null) {
            browserDataHelper = onBrowserListener.getData();
        }
        this.mBrowserData = browserDataHelper;
    }
}
