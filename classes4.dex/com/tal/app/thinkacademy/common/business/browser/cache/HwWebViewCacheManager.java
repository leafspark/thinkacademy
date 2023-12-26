package com.tal.app.thinkacademy.common.business.browser.cache;

import android.app.Application;
import android.content.MutableContextWrapper;
import android.os.Looper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.business.browser.handler.MyWebChromeClient;
import com.tal.app.thinkacademy.common.business.browser.helper.XesWebViewCookieUtils;
import com.tal.app.thinkacademy.common.business.browser.view.XesWebView;
import com.tal.app.thinkacademy.common.constants.UrlUtils;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.Utils;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/cache/HwWebViewCacheManager;", "", "()V", "mCachedWebViewStack", "Ljava/util/Stack;", "Lcom/tal/app/thinkacademy/common/business/browser/view/XesWebView;", "clearWebView", "", "getLinkUrl", "", "getWebView", "isOpenWebCache", "", "preLoadWeb", "preLoadWebReal", "Companion", "SingleHolder", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwWebViewCacheManager.kt */
public final class HwWebViewCacheManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "MyWebViewManager";
    private static final long WEB_VIEW_TIME_OUT = 3600000;
    public static final int WHAT_PRELOAD = 100;
    /* access modifiers changed from: private */
    public static final HwWebViewCacheManager instance = SingleHolder.INSTANCE.getHolder();
    private final Stack<XesWebView> mCachedWebViewStack = new Stack<>();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/cache/HwWebViewCacheManager$Companion;", "", "()V", "TAG", "", "WEB_VIEW_TIME_OUT", "", "WHAT_PRELOAD", "", "instance", "Lcom/tal/app/thinkacademy/common/business/browser/cache/HwWebViewCacheManager;", "getInstance", "()Lcom/tal/app/thinkacademy/common/business/browser/cache/HwWebViewCacheManager;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HwWebViewCacheManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HwWebViewCacheManager getInstance() {
            return HwWebViewCacheManager.instance;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/cache/HwWebViewCacheManager$SingleHolder;", "", "()V", "holder", "Lcom/tal/app/thinkacademy/common/business/browser/cache/HwWebViewCacheManager;", "getHolder", "()Lcom/tal/app/thinkacademy/common/business/browser/cache/HwWebViewCacheManager;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HwWebViewCacheManager.kt */
    private static final class SingleHolder {
        public static final SingleHolder INSTANCE = new SingleHolder();
        private static final HwWebViewCacheManager holder = new HwWebViewCacheManager();

        private SingleHolder() {
        }

        public final HwWebViewCacheManager getHolder() {
            return holder;
        }
    }

    private final boolean isOpenWebCache() {
        PadUtils.isPad(Utils.getApp());
        return false;
    }

    private final String getLinkUrl() {
        String str = UrlUtils.INSTANCE.getTouchHost() + "/app-v2/prefetch";
        Intrinsics.checkNotNullExpressionValue(str, "urlBuilder.toString()");
        XesLog.dt(TAG, "getLinkUrl", str);
        return str;
    }

    public final void preLoadWeb() {
        if (isOpenWebCache()) {
            try {
                Looper.myQueue().addIdleHandler(new HwWebViewCacheManager$$ExternalSyntheticLambda0(this));
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: preLoadWeb$lambda-0  reason: not valid java name */
    public static final boolean m8preLoadWeb$lambda0(HwWebViewCacheManager hwWebViewCacheManager) {
        Intrinsics.checkNotNullParameter(hwWebViewCacheManager, "this$0");
        XesLog.dt(TAG, "进入空闲了，开始预缓存");
        try {
            hwWebViewCacheManager.preLoadWebReal();
        } catch (Exception unused) {
        }
        return false;
    }

    private final void preLoadWebReal() {
        XesWebView xesWebView;
        Application app = Utils.getApp();
        Intrinsics.checkNotNullExpressionValue(app, "getApp()");
        String linkUrl = getLinkUrl();
        CharSequence charSequence = linkUrl;
        if (charSequence == null || charSequence.length() == 0) {
            XesLog.dt(TAG, "preLoadWeb url is null");
            return;
        }
        try {
            xesWebView = this.mCachedWebViewStack.peek();
        } catch (Exception unused) {
            xesWebView = null;
        }
        if (xesWebView != null && System.currentTimeMillis() - xesWebView.getCreateTimeMillis() >= 3600000) {
            XesLog.dt(TAG, "webview缓存已过期");
            this.mCachedWebViewStack.pop();
            xesWebView = null;
        }
        if (xesWebView != null) {
            XesLog.dt(TAG, "preLoadWeb 缓存存在，重新加载");
            xesWebView.setHwCourseIsCacheComplete(false);
            XesWebViewCookieUtils.syncCookie(linkUrl, (Map<String, String>) null, xesWebView);
            xesWebView.loadUrl(linkUrl);
            SensorsDataAutoTrackHelper.loadUrl2(xesWebView, linkUrl);
            return;
        }
        XesLog.dt(TAG, Intrinsics.stringPlus("preLoadWeb 创建新的缓存 start time = ", Long.valueOf(System.currentTimeMillis())));
        XesWebView xesWebView2 = new XesWebView(new MutableContextWrapper(app));
        xesWebView2.setCachedWeb(true);
        xesWebView2.initSettings((MyWebChromeClient.IProgressListener) null, new ArrayList());
        XesWebViewCookieUtils.syncCookie(linkUrl, (Map<String, String>) null, xesWebView2);
        xesWebView2.loadUrl(linkUrl);
        SensorsDataAutoTrackHelper.loadUrl2(xesWebView2, linkUrl);
        this.mCachedWebViewStack.push(xesWebView2);
        XesLog.dt(TAG, Intrinsics.stringPlus("preLoadWeb 创建新的缓存 end time = ", Long.valueOf(System.currentTimeMillis())));
    }

    public final XesWebView getWebView() {
        XesWebView xesWebView;
        try {
            xesWebView = this.mCachedWebViewStack.peek();
        } catch (Exception unused) {
            xesWebView = null;
        }
        if (xesWebView != null) {
            try {
                if (System.currentTimeMillis() - xesWebView.getCreateTimeMillis() >= 3600000) {
                    XesLog.dt(TAG, "webview缓存已过期");
                    this.mCachedWebViewStack.pop();
                    preLoadWeb();
                    return null;
                } else if (xesWebView.getHwCourseIsCacheComplete()) {
                    XesLog.dt(TAG, "webview缓存完成");
                    this.mCachedWebViewStack.pop();
                    preLoadWeb();
                    return xesWebView;
                } else {
                    preLoadWeb();
                    XesLog.dt(TAG, "webview缓存未完成");
                }
            } catch (Exception unused2) {
            }
        }
        return null;
    }

    public final void clearWebView() {
        try {
            XesLog.dt(TAG, "清理缓存");
            this.mCachedWebViewStack.clear();
        } catch (Exception unused) {
        }
    }
}
